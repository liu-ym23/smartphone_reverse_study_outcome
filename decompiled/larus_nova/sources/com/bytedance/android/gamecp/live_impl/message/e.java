package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.UserGiftStatus")
public final class e extends com.bytedance.android.gamecp.host_api.model.introducecard.n {
    public e() {
    }

    public e(am3.g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }
}
