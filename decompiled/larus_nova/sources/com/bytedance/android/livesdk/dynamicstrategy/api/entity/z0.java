package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class z0 implements am3.c<c0> {
    public z0() {
    }

    public static c0 a(am3.g r100) throws Exception {
        c0 r101 = new c0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.operator = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.node = d0.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final c0 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
