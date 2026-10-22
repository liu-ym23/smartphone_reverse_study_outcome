package com.alibaba.fastjson.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* JADX INFO: loaded from: classes28.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private final Type[] actualTypeArguments;
    private final Type ownerType;
    private final Type rawType;

    public int hashCode() {
        Type[] r100 = this.actualTypeArguments;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = Arrays.hashCode(r100);
    L6:
        int r103 = r102 * 31;
        Type r104 = this.ownerType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Type r107 = this.rawType;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.actualTypeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L28:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L28;
        ParameterizedTypeImpl r101 = (ParameterizedTypeImpl) r100;
        if (Arrays.equals(this.actualTypeArguments, r101.actualTypeArguments) == true) goto L13;
        return false;
    L13:
        Type r102 = this.ownerType;
        if (r102 == null) goto L19;
        if (r102.equals(r101.ownerType) == false) goto L20;
    L21:
        Type r103 = this.rawType;
        Type r104 = r101.rawType;
        if (r103 != null) goto L29;
        if (r104 == null) goto L30;
        return false;
    L30:
        return true;
    L29:
        return r103.equals(r104);
    L20:
        return false;
    L19:
        if (r101.ownerType == null) goto L21;
        goto L20
    }

    public ParameterizedTypeImpl(Type[] r100, Type r101, Type r102) {
        this.actualTypeArguments = r100;
        this.ownerType = r101;
        this.rawType = r102;
    }
}
