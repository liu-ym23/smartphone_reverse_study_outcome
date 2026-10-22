package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements am3.c<h> {
    public j0() {
    }

    public static h a(am3.g r100) throws Exception {
        h r101 = new h();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.condition = d0.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.then = d0.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.otherwise = d0.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final h decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
