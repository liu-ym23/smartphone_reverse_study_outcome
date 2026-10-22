package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class r0 implements am3.c<r> {
    public r0() {
    }

    public static r a(am3.g r100) throws Exception {
        r r101 = new r();
        r101.pairs = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.pairs.add(s0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final r decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
