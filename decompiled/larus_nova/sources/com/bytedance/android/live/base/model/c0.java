package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 implements am3.c<q.a> {
    public c0() {
    }

    public static q.a a(am3.g r100) throws Exception {
        q.a r101 = new q.a();
        r101.layers = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.layers.add(b0.a(r100));
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.baseWidth = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.baseHeight = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final q.a decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
