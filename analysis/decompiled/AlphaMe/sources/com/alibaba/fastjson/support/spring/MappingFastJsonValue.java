package com.alibaba.fastjson.support.spring;

@Deprecated
/* loaded from: classes.dex */
public class MappingFastJsonValue {
    private String jsonpFunction;
    private Object value;

    public MappingFastJsonValue(Object obj) {
        this.value = obj;
    }

    public String getJsonpFunction() {
        return this.jsonpFunction;
    }

    public Object getValue() {
        return this.value;
    }

    public void setJsonpFunction(String str) {
        this.jsonpFunction = str;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }
}
