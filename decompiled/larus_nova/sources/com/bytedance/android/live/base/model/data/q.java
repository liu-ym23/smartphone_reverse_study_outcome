package com.bytedance.android.live.base.model.data;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements am3.c<m> {
    public q() {
    }

    public static m a(am3.g r100) throws Exception {
        m r101 = new m();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r101.schema = am3.h.c(r100);
        goto L3
    L8:
        r101.nameColor = am3.h.c(r100);
        goto L3
    L9:
        r101.name = am3.h.c(r100);
        goto L3
    L10:
        r101.icon = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        r101.itemId = am3.h.c(r100);
        goto L3
    L12:
        r101.itemType = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final m decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
