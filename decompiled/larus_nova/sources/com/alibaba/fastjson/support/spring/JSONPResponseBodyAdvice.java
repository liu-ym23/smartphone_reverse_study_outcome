package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.alibaba.fastjson.util.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes28.dex */
@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class JSONPResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public final Log logger;

    public void beforeBodyWriteInternal(JSONPObject r100, MediaType r101, MethodParameter r102, ServerHttpRequest r103, ServerHttpResponse r104) {
    }

    public JSONPResponseBodyAdvice() {
        this.logger = LogFactory.getLog(getClass());
    }

    public boolean supports(MethodParameter r100, Class<? extends HttpMessageConverter<?>> r101) {
        if (FastJsonHttpMessageConverter.class.isAssignableFrom(r101) == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.getContainingClass().isAnnotationPresent(ResponseJSONP.class) == false) goto L7;
    L8:
        return true;
    L7:
        if (r100.hasMethodAnnotation(ResponseJSONP.class) == false) goto L9;
        goto L8
    }

    public MediaType getContentType(MediaType r100, ServerHttpRequest r101, ServerHttpResponse r102) {
        return FastJsonHttpMessageConverter.APPLICATION_JAVASCRIPT;
    }

    public Object beforeBodyWrite(Object r100, MethodParameter r101, MediaType r110, Class<? extends HttpMessageConverter<?>> r111, ServerHttpRequest r112, ServerHttpResponse r113) {
        ResponseJSONP r114 = (ResponseJSONP) r101.getMethodAnnotation(ResponseJSONP.class);
        if (r114 != null) goto L5;
        r114 = (ResponseJSONP) r101.getContainingClass().getAnnotation(ResponseJSONP.class);
    L5:
        String r115 = ((ServletServerHttpRequest) r112).getServletRequest().getParameter(r114.callback());
        if (IOUtils.isValidJsonpQueryParam(r115) == false) goto L8;
    L11:
        JSONPObject r102 = new JSONPObject(r115);
        r102.addParameter(r100);
        beforeBodyWriteInternal(r102, r110, r101, r112, r113);
        return r102;
    L8:
        if (this.logger.isDebugEnabled() == false) goto L10;
        this.logger.debug("Invalid jsonp parameter value:" + r115);
    L10:
        r115 = null;
        goto L11
    }
}
