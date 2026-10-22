package com.alibaba.fastjson.support.spring;

/* JADX INFO: loaded from: classes28.dex */
public class FastJsonContainer {
    private PropertyPreFilters filters;
    private Object value;

    public PropertyPreFilters getFilters() {
        return this.filters;
    }

    public Object getValue() {
        return this.value;
    }

    public FastJsonContainer(Object r100) {
        this.value = r100;
    }

    public void setFilters(PropertyPreFilters r100) {
        this.filters = r100;
    }

    public void setValue(Object r100) {
        this.value = r100;
    }
}
