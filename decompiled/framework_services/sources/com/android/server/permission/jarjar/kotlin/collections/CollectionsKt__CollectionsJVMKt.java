package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__CollectionsJVMKt {
    public static final <T> List<T> listOf(T r2) {
        List<T> r0 = Collections.singletonList(r2);
        Intrinsics.checkNotNullExpressionValue(r0, "singletonList(...)");
        return r0;
    }
}
