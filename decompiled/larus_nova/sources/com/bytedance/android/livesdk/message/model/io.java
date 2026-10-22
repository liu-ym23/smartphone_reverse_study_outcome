package com.bytedance.android.livesdk.message.model;

/* JADX INFO: loaded from: classes11.dex */
public final class io implements am3.c<LinkMicGuideMessage.c.a> {
    public io() {
    }

    public static LinkMicGuideMessage.c.a a(am3.g r100) throws Exception {
        LinkMicGuideMessage.c.a r101 = new LinkMicGuideMessage.c.a();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.targetUserId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.followStatus = r100.j();
        goto L3
    L10:
        if (r103 != 5000) goto L11;
        r101.targetOpenId = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final LinkMicGuideMessage.c.a decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
