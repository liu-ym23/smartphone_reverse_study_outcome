package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.SearchBar")
public final class n0 extends h implements vh7.h {
    public n0(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.backgroundImage = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.content = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
