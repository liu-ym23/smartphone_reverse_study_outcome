package com.bytedance.android.live.base.model;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements am3.c<o> {
    public y() {
    }

    public static o a(am3.g r100) throws Exception {
        o r101 = new o();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        r101.bigCardUrl = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.containerType = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.width = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.height = r100.i();
        goto L3
    L14:
        if (r103 != 5) goto L15;
        r101.duration = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final o decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
