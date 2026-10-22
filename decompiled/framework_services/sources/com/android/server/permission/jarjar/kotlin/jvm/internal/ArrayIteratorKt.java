package com.android.server.permission.jarjar.kotlin.jvm.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArrayIteratorKt {
    public static final <T> Iterator<T> iterator(T[] r1) {
        Intrinsics.checkNotNullParameter(r1, "array");
        return new ArrayIterator(r1);
    }
}
