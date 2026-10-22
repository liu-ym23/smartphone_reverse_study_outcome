package com.bytedance.android.live.base.model.message;

/* JADX INFO: loaded from: classes45.dex */
public final class q6 implements am3.c<b> {
    public q6() {
    }

    public static b a(am3.g r100) throws Exception {
        b r101 = new b();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.contourEnable = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.frequency = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.userCount = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final b decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
