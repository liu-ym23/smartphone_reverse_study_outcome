package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: classes45.dex */
public final class d0 implements am3.c<r> {
    public d0() {
    }

    public static r a(am3.g r100) throws Exception {
        r r101 = new r();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.text = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.textColor = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.textSize = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.bgColor = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final r decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
