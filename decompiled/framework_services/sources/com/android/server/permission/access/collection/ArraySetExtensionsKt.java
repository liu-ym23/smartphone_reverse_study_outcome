package com.android.server.permission.access.collection;

import android.util.ArraySet;
import com.android.server.permission.jarjar.kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: ArraySetExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArraySetExtensionsKt {
    public static final <T> ArraySet<T> arraySetOf(T... r2) {
        return new ArraySet(ArraysKt.asList(r2));
    }
}
