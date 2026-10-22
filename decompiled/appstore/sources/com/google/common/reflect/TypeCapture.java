package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
abstract class TypeCapture<T> {
    public TypeCapture() {
    }

    public final Type capture() {
        Type r10 = getClass().getGenericSuperclass();
        Preconditions.checkArgument(r10 instanceof ParameterizedType, "%s isn't parameterized", r10);
        return ((ParameterizedType) r10).getActualTypeArguments()[0];
    }
}
