package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes28.dex */
@ControllerAdvice
@Order
public class FastJsonViewResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public FastJsonViewResponseBodyAdvice() {
    }

    private FastJsonContainer getOrCreateContainer(Object r100) {
        if ((r100 instanceof FastJsonContainer) == false) goto L6;
        return (FastJsonContainer) r100;
    L6:
        return new FastJsonContainer(r100);
    }

    public boolean supports(MethodParameter r100, Class<? extends HttpMessageConverter<?>> r101) {
        if (FastJsonHttpMessageConverter.class.isAssignableFrom(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasMethodAnnotation(FastJsonView.class) == false) goto L7;
        return true;
    }

    public void beforeBodyWriteInternal(FastJsonContainer r100, MediaType r101, MethodParameter r102, ServerHttpRequest r103, ServerHttpResponse r104) {
        FastJsonView r105 = (FastJsonView) r102.getMethodAnnotation(FastJsonView.class);
        FastJsonFilter[] r106 = r105.include();
        FastJsonFilter[] r107 = r105.exclude();
        PropertyPreFilters r108 = new PropertyPreFilters();
        int r109 = r106.length;
        int r110 = 0;
    L3:
        if (r110 >= r109) goto L5;
        FastJsonFilter r111 = r106[r110];
        r108.addFilter(r111.clazz(), r111.props());
        r110 = r110 + 1;
        goto L3
    L5:
        int r112 = r107.length;
        int r113 = 0;
    L6:
        if (r113 >= r112) goto L8;
        FastJsonFilter r114 = r107[r113];
        r108.addFilter(r114.clazz(), new String[0]).addExcludes(r114.props());
        r113 = r113 + 1;
        goto L6
    L8:
        r100.setFilters(r108);
    }

    public FastJsonContainer beforeBodyWrite(Object r100, MethodParameter r101, MediaType r102, Class<? extends HttpMessageConverter<?>> r110, ServerHttpRequest r111, ServerHttpResponse r112) {
        FastJsonContainer r103 = getOrCreateContainer(r100);
        beforeBodyWriteInternal(r103, r102, r101, r111, r112);
        return r103;
    }

    /* JADX INFO: renamed from: beforeBodyWrite, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8014beforeBodyWrite(Object r100, MethodParameter r101, MediaType r102, Class r103, ServerHttpRequest r104, ServerHttpResponse r105) {
        return beforeBodyWrite(r100, r101, r102, r103, r104, r105);
    }
}
