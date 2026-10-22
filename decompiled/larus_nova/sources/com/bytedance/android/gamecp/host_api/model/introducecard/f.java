package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.FeaturedContent")
public final class f extends e {
    public f(am3.g r100) {
        this.contentList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.rotationTime = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.contentList.add(new d(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
