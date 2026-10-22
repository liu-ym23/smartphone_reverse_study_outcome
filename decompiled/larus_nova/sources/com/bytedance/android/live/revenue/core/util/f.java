package com.bytedance.android.live.revenue.core.util;

import com.bytedance.android.scope.m;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final <T extends dy0.c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceCls");
        h.c();
        m r101 = m.f163449e;
        cy0.e.f465759a.getClass();
        cy0.j r102 = cy0.e.a.f465760a;
        T r103 = (T) r101.d(r102, r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        b.a(r100, r102);
        throw null;
    }

    @JvmStatic
    public static final <T extends f80.b> T b(com.bytedance.android.live.revenue.core.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        h.c();
        com.bytedance.android.live.revenue.core.a r102 = (com.bytedance.android.live.revenue.core.a) r100;
        Intrinsics.checkNotNullParameter(r102, "instance");
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        h.c();
        T r103 = (T) m.f163449e.d(r102.getScope(), r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        b.a(r101, r102.getScope());
        throw null;
    }

    @JvmStatic
    public static final <T extends f80.b> T c(com.bytedance.android.live.revenue.core.a r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        h.c();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (T) m.f163449e.d(r100.getScope(), r101);
    }

    @JvmStatic
    public static final <T extends f80.b> T d(com.bytedance.android.live.revenue.core.b r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "serviceCls");
        h.c();
        if ((r100 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.live.revenue.core.a r102 = (com.bytedance.android.live.revenue.core.a) r100;
        if (r102 != null) goto L8;
        return null;
    L8:
        return (T) c(r102, r101);
    }
}
