package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.ugm.api.webcast_anchor_manager.GenLiveRoomTopicResponse.ResponseData")
public final class h0 implements vh7.h {
    public h0() {
    }

    public h0(am3.g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }
}
