package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
abstract class TypeCapture<T> {
    TypeCapture() {
    }

    final Type capture() {
        Type r4 = getClass().getGenericSuperclass();
        Preconditions.checkArgument(r4 instanceof ParameterizedType, "%s isn't parameterized", new Object[]{r4});
        return ((ParameterizedType) r4).getActualTypeArguments()[0];
    }
}
