package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 implements am3.c<a0> {
    public x0() {
    }

    public static a0 a(am3.g r100) throws Exception {
        a0 r101 = new a0();
        r101.features = new ArrayList();
        r101.rules = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        r101.strategyStatus = r100.i();
        goto L3
    L8:
        r101.version = (int) r100.j();
        goto L3
    L9:
        r101.ruleType = r100.i();
        goto L3
    L10:
        r101.rules.add(u0.a(r100));
        goto L3
    L11:
        r101.defaultResult = k0.a(r100);
        goto L3
    L12:
        r101.features.add(n0.a(r100));
        goto L3
    L13:
        r101.strategyName = am3.h.c(r100);
        goto L3
    L14:
        r101.strategyId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final a0 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
