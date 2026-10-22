package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class l0 implements am3.c<j> {
    public l0() {
    }

    public static j a(am3.g r100) throws Exception {
        j r101 = new j();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.value = Double.longBitsToDouble(r100.h());
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final j decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
