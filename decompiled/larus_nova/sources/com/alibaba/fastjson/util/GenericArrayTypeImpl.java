package com.alibaba.fastjson.util;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes28.dex */
public class GenericArrayTypeImpl implements GenericArrayType {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Type genericComponentType;

    public int hashCode() {
        return this.genericComponentType.hashCode();
    }

    public String toString() {
        Type r100 = getGenericComponentType();
        StringBuilder r101 = new StringBuilder();
        if ((r100 instanceof Class) == false) goto L5;
        r101.append(((Class) r100).getName());
    L6:
        r101.append("[]");
        return r101.toString();
    L5:
        r101.append(r100.toString());
        goto L6
    }

    static {
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.genericComponentType;
    }

    public GenericArrayTypeImpl(Type r100) {
        this.genericComponentType = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GenericArrayType) == true) goto L5;
        return false;
    L5:
        return this.genericComponentType.equals(((GenericArrayType) r100).getGenericComponentType());
    }
}
