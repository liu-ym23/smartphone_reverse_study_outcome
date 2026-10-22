package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 {
    public static final pc0.e a(m0 r100) {
        Intrinsics.checkNotNullParameter(pc0.e.f528471f, "$this$from");
        Intrinsics.checkNotNullParameter(r100, "rtcData");
        fr2.e r101 = r100.f90845a;
        fr2.p r102 = r100.f90848d;
        if (r101 == null) goto L5;
        vc0.a r103 = vc0.b.a(r101);
    L6:
        boolean r104 = r100.f90846b;
        vc0.c r105 = new vc0.c(r100.f90847c);
        if (r102 == null) goto L9;
        vc0.a r106 = vc0.b.a(r102);
    L11:
        return new pc0.e(r103, r104, r105, r106, r100.f90849e);
    L9:
        r106 = null;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
