package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class SetsKt__SetsJVMKt {
    public static <T> Set<T> setOf(T r2) {
        Set<T> r0 = Collections.singleton(r2);
        Intrinsics.checkNotNullExpressionValue(r0, "singleton(...)");
        return r0;
    }
}
