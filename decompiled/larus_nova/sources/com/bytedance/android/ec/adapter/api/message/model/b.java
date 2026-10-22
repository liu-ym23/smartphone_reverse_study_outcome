package com.bytedance.android.ec.adapter.api.message.model;

import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements am3.c<UpdatedCartInfo.RoomCartStateHorizontal> {
    public b() {
    }

    public static UpdatedCartInfo.RoomCartStateHorizontal a(g r100) throws Exception {
        UpdatedCartInfo.RoomCartStateHorizontal r101 = new UpdatedCartInfo.RoomCartStateHorizontal();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.allowShowCart = h.a(r100);
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final UpdatedCartInfo.RoomCartStateHorizontal decode(g r100) throws Exception {
        return a(r100);
    }
}
