package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class y0 implements am3.c<b0> {
    public y0() {
    }

    public static b0 a(am3.g r100) throws Exception {
        b0 r101 = new b0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.value = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final b0 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
