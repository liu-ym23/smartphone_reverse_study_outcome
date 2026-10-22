package com.bytedance.android.gamecp.host_api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.CloudGameMeta")
public final class b extends a {
    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.schema = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }
}
