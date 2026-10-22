package com.alibaba.fastjson.support.spring;

import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* JADX INFO: loaded from: classes28.dex */
public class FastJsonHttpMessageConverter4 extends FastJsonHttpMessageConverter {
    public FastJsonHttpMessageConverter4() {
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean supports(Class<?> r100) {
        return super.supports(r100);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public Object readInternal(Class<?> r100, HttpInputMessage r101) throws IOException, HttpMessageNotReadableException {
        return super.readInternal(r100, r101);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public void writeInternal(Object r100, HttpOutputMessage r101) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(r100, r101);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean canRead(Type r100, Class<?> r101, MediaType r102) {
        return super.canRead(r100, r101, r102);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public boolean canWrite(Type r100, Class<?> r101, MediaType r102) {
        return super.canWrite(r100, r101, r102);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public Object read(Type r100, Class<?> r101, HttpInputMessage r102) throws IOException, HttpMessageNotReadableException {
        return super.read(r100, r101, r102);
    }

    @Override // com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
    public void write(Object r100, Type r101, MediaType r102, HttpOutputMessage r103) throws IOException, HttpMessageNotWritableException {
        super.write(r100, r101, r102, r103);
    }
}
