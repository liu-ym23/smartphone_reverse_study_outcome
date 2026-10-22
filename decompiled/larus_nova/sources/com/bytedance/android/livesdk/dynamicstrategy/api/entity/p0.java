package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class p0 implements am3.c<p> {
    public p0() {
    }

    public static p a(am3.g r100) throws Exception {
        p r101 = new p();
        r101.deleteStrategies = new ArrayList();
        r101.incrementStrategies = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.incrementStrategies.add(x0.a(r100));
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.deleteStrategies.add(x0.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final p decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
