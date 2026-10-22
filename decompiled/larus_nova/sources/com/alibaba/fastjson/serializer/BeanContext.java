package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public final class BeanContext {
    private final Class<?> beanClass;
    private final FieldInfo fieldInfo;
    private final String format;

    public int getFeatures() {
        return this.fieldInfo.serialzeFeatures;
    }

    public Field getField() {
        return this.fieldInfo.field;
    }

    public Class<?> getFieldClass() {
        return this.fieldInfo.fieldClass;
    }

    public Type getFieldType() {
        return this.fieldInfo.fieldType;
    }

    public String getLabel() {
        return this.fieldInfo.label;
    }

    public Method getMethod() {
        return this.fieldInfo.method;
    }

    public String getName() {
        return this.fieldInfo.name;
    }

    public boolean isJsonDirect() {
        return this.fieldInfo.jsonDirect;
    }

    public Class<?> getBeanClass() {
        return this.beanClass;
    }

    public String getFormat() {
        return this.format;
    }

    public <T extends Annotation> T getAnnation(Class<T> r100) {
        return (T) this.fieldInfo.getAnnation(r100);
    }

    public BeanContext(Class<?> r100, FieldInfo r101) {
        this.beanClass = r100;
        this.fieldInfo = r101;
        this.format = r101.getFormat();
    }
}
