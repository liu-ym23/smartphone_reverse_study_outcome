package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.List;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static <T> List<T> asList(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        List<T> r0 = ArraysUtilJVM.asList(r2);
        Intrinsics.checkNotNullExpressionValue(r0, "asList(...)");
        return r0;
    }
}
