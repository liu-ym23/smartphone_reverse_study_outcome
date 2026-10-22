package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class i0 implements am3.c<g> {
    public i0() {
    }

    public static g a(am3.g r100) throws Exception {
        g r101 = new g();
        r101.arguments = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.caller = o0.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.arguments.add(d0.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final g decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
