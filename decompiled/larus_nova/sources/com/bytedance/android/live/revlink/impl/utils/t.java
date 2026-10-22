package com.bytedance.android.live.revlink.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class t {
    public static final long a(long r100) {
        i97.a r101 = i97.a.f488802a;
        return System.currentTimeMillis() - r100;
    }

    public static final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r100, "tag");
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r103 = com.bytedance.android.scope.m.b(r102).a(Reflection.getOrCreateKotlinClass(jy0.c.class));
        Intrinsics.checkNotNull(r103);
        jy0.c r104 = (jy0.c) ((f80.a) r103);
        if (r101 == null) goto L5;
        StackTraceElement[] r105 = r101.getStackTrace();
    L6:
        r104.stacktrace(6, r100, r105);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
