package com.yiguan.handler;

import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.extension.api.R;
import com.yiguan.bean.entity.DataResult;
import com.yiguan.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: lw
 * @CreateTime: 2022-10-15  22:07
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        ResponseUtil.out(response,DataResult.createByError(HttpStatus.HTTP_UNAUTHORIZED,exception.getMessage()));
        log.error("Authentication异常: [{}], [{}], [{}]", request.getRequestURI(), exception.getMessage(), exception);
    }
}
