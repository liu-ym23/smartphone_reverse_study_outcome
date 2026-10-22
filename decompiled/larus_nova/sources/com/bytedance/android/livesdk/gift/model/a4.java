package com.bytedance.android.livesdk.gift.model;

/* JADX INFO: loaded from: classes9.dex */
public final class a4 implements am3.c<n0> {
    public a4() {
    }

    public static n0 a(am3.g r100) throws Exception {
        n0 r101 = new n0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.minLevel = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.insertPos = r100.i();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final n0 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
