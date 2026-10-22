package com.android.server.permission.jarjar.kotlin.collections;

import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import java.util.List;

/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes2.dex */
class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public static <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        switch(r1.size()) {
            case 0: goto L7;
            case 1: goto L9;
            default: goto L8;
        };
    L8:
        return r1;
    L9:
        return CollectionsKt__CollectionsJVMKt.listOf(r1.get(0));
    L7:
        return CollectionsKt.emptyList();
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
