package com.bytedance.android.ec.adapter.api.message.model;

import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements am3.c<UpdatedCartInfo.RoomCartStateVertical> {
    public c() {
    }

    public static UpdatedCartInfo.RoomCartStateVertical a(g r100) throws Exception {
        UpdatedCartInfo.RoomCartStateVertical r101 = new UpdatedCartInfo.RoomCartStateVertical();
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
    public final UpdatedCartInfo.RoomCartStateVertical decode(g r100) throws Exception {
        return a(r100);
    }
}
