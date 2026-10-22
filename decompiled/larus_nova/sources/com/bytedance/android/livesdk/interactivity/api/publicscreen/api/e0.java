package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class e0 implements am3.c<u> {
    public e0() {
    }

    public static u a(am3.g r100) throws Exception {
        u r101 = new u();
        r101.insideName = new ArrayList();
        r101.outsideName = new ArrayList();
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
        r101.showOutside = am3.h.a(r100);
        goto L3
    L8:
        r101.canShow = am3.h.a(r100);
        goto L3
    L9:
        r101.insideName.add(am3.h.c(r100));
        goto L3
    L10:
        r101.outsideName.add(am3.h.c(r100));
        goto L3
    L11:
        r101.priority = r100.j();
        goto L3
    L12:
        r101.itemId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final u decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
