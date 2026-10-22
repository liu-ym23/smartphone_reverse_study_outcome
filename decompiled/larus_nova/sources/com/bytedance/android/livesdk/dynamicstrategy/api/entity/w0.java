package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public final class w0 implements am3.c<z> {
    public w0() {
    }

    @Override // am3.c
    public final z decode(am3.g r100) throws Exception {
        z r101 = new z();
        r101.fullStrategies = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.incrementStrategies = p0.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.fullStrategies.add(x0.a(r100));
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.responseType = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
