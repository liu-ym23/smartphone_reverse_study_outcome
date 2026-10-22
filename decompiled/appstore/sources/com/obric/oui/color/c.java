package com.obric.oui.color;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final a a(b r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new a(r10.i(), r10.h());
    }

    public static final a[] b(b[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(a(r10[r13]));
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new a[0]);
        if (r14 == null) goto L10;
        return (a[]) r14;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final b[] c(a[] r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10[r13].d());
        r13 = r13 + 1;
        goto L3
    L5:
        Object[] r14 = r11.toArray(new b[0]);
        if (r14 == null) goto L10;
        return (b[]) r14;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
