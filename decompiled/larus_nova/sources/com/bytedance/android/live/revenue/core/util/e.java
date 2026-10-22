package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    static {
        h.c();
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        m r101 = m.f163449e;
        cy0.e.f465759a.getClass();
        T r102 = (T) r101.d(cy0.e.a.f465760a, r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        c.a(r100);
        throw null;
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.d> T b(com.bytedance.android.live.revenue.core.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        T r102 = (T) m.f163449e.d(r100.e(), r101);
        if (r102 == null) goto L5;
        return r102;
    L5:
        c.a(r101);
        throw null;
    }

    @JvmStatic
    public static final <T extends com.bytedance.live.kmp.core.d> T c(com.bytedance.android.live.revenue.core.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        if (r100 != null) goto L7;
        return null;
    L7:
        return (T) m.f163449e.d(r100.e(), r101);
    }
}
