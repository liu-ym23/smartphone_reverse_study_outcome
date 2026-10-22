package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.MiniGameMeta")
public final class f extends e {
    public f(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.schema = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.version = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
