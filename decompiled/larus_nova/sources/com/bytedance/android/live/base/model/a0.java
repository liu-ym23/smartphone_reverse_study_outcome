package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 implements am3.c<q> {
    public a0() {
    }

    public static q a(am3.g r100) throws Exception {
        q r101 = new q();
        r101.businessList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        switch(r103) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        r101.accessibleName = am3.h.c(r100);
        goto L3
    L8:
        r101.animationShowTimes = r100.i();
        goto L3
    L9:
        r101.imgLayers = c0.a(r100);
        goto L3
    L10:
        r101.businessList.add(am3.h.c(r100));
        goto L3
    L11:
        r101.animationType = r100.i();
        goto L3
    L12:
        r101.showAnimation = r100.i();
        goto L3
    L13:
        r101.jumpSchema = am3.h.c(r100);
        goto L3
    L14:
        r101.imageUrl = am3.h.c(r100);
        goto L3
    L15:
        r101.height = r100.i();
        goto L3
    L16:
        r101.width = r100.i();
        goto L3
    L17:
        r101.containerType = r100.i();
        goto L3
    L18:
        r101.fallbackUrl = am3.h.c(r100);
        goto L3
    L19:
        r101.loadUrl = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final q decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
