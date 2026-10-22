package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class t0 implements am3.c<v> {
    public t0() {
    }

    @Override // am3.c
    public final v decode(am3.g r100) throws Exception {
        v r101 = new v();
        r101.strategies = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.strategies.add(x0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }
}
