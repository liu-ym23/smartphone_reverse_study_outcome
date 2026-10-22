package com.bytedance.android.livesdk.message.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class jo implements am3.c<LinkMicGuideMessage.c> {
    public jo() {
    }

    public static LinkMicGuideMessage.c a(am3.g r100) throws Exception {
        LinkMicGuideMessage.c r101 = new LinkMicGuideMessage.c();
        r101.followInfos = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.roomId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.fromUserId = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.followInfos.add(io.a(r100));
        goto L3
    L12:
        if (r103 != 5000) goto L13;
        r101.fromOpenId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final LinkMicGuideMessage.c decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
