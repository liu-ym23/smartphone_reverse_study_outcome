package com.bytedance.android.live.base.model.data;

/* JADX INFO: loaded from: classes45.dex */
public final class p implements am3.c<e> {
    public p() {
    }

    public static e a(am3.g r100) throws Exception {
        e r101 = new e();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.showText = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.showIcons = am3.h.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final e decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
