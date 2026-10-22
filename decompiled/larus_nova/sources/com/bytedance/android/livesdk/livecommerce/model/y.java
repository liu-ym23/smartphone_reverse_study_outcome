package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class y implements am3.c<ECV2InteractionData> {
    public y() {
    }

    public static ECV2InteractionData a(am3.g r100) throws Exception {
        ECV2InteractionData r101 = new ECV2InteractionData();
        r101.contents = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.full = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.contents.add(r.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
