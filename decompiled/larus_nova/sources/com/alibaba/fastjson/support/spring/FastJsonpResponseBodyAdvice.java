package com.alibaba.fastjson.support.spring;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes28.dex */
@ControllerAdvice
@Order(Integer.MIN_VALUE)
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private static final Pattern CALLBACK_PARAM_PATTERN = null;
    public static final String[] DEFAULT_JSONP_QUERY_PARAM_NAMES = null;
    private final String[] jsonpQueryParamNames;

    static {
        CALLBACK_PARAM_PATTERN = PatternProtector.compile("[0-9A-Za-z_\\.]*");
        DEFAULT_JSONP_QUERY_PARAM_NAMES = new String[]{"callback", "jsonp"};
    }

    public FastJsonpResponseBodyAdvice() {
        this.jsonpQueryParamNames = DEFAULT_JSONP_QUERY_PARAM_NAMES;
    }

    public FastJsonpResponseBodyAdvice(String... r100) {
        Assert.isTrue(!ObjectUtils.isEmpty(r100), "At least one query param name is required");
        this.jsonpQueryParamNames = r100;
    }

    public MappingFastJsonValue getOrCreateContainer(Object r100) {
        if ((r100 instanceof MappingFastJsonValue) == false) goto L6;
        return (MappingFastJsonValue) r100;
    L6:
        return new MappingFastJsonValue(r100);
    }

    public boolean isValidJsonpQueryParam(String r100) {
        return CALLBACK_PARAM_PATTERN.matcher(r100).matches();
    }

    public boolean supports(MethodParameter r100, Class<? extends HttpMessageConverter<?>> r101) {
        return FastJsonHttpMessageConverter.class.isAssignableFrom(r101);
    }

    public MediaType getContentType(MediaType r100, ServerHttpRequest r101, ServerHttpResponse r102) {
        return new MediaType("application", "javascript");
    }

    public void beforeBodyWriteInternal(MappingFastJsonValue r100, MediaType r101, MethodParameter r102, ServerHttpRequest r103, ServerHttpResponse r104) {
        HttpServletRequest r105 = ((ServletServerHttpRequest) r103).getServletRequest();
        String[] r106 = this.jsonpQueryParamNames;
        int r107 = r106.length;
        int r108 = 0;
    L3:
        if (r108 >= r107) goto L16;
        String r109 = r105.getParameter(r106[r108]);
        if (r109 == null) goto L10;
        if (isValidJsonpQueryParam(r109) == false) goto L10;
        r100.setJsonpFunction(r109);
        return;
    L10:
        r108 = r108 + 1;
        goto L3
    }

    public Object beforeBodyWrite(Object r100, MethodParameter r101, MediaType r102, Class<? extends HttpMessageConverter<?>> r110, ServerHttpRequest r111, ServerHttpResponse r112) {
        MappingFastJsonValue r103 = getOrCreateContainer(r100);
        beforeBodyWriteInternal(r103, r102, r101, r111, r112);
        return r103;
    }
}
