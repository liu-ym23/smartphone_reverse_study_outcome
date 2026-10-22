package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class e0 implements am3.c<c> {
    public e0() {
    }

    public static c a(am3.g r100) throws Exception {
        c r101 = new c();
        r101.nodes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.nodes.add(d0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final c decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
