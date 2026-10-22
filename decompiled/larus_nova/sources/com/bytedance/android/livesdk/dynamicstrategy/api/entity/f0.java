package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class f0 implements am3.c<d> {
    public f0() {
    }

    public static d a(am3.g r100) throws Exception {
        d r101 = new d();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.rule = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.root = d0.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.ruleKeyName = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final d decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
