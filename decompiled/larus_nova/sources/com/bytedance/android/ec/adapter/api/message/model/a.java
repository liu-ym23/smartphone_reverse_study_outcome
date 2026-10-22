package com.bytedance.android.ec.adapter.api.message.model;

import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements am3.c<UpdatedCartInfo> {
    public a() {
    }

    public static UpdatedCartInfo a(g r100) throws Exception {
        UpdatedCartInfo r101 = new UpdatedCartInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.vertical = c.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.horizontal = b.a(r100);
        goto L3
    L9:
        h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final UpdatedCartInfo decode(g r100) throws Exception {
        return a(r100);
    }
}
