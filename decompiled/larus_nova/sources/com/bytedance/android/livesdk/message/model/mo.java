package com.bytedance.android.livesdk.message.model;

/* JADX INFO: loaded from: classes11.dex */
public final class mo implements am3.c<LinkMicGuideMessage.d> {
    public mo() {
    }

    public static LinkMicGuideMessage.d a(am3.g r100) throws Exception {
        LinkMicGuideMessage.d r101 = new LinkMicGuideMessage.d();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.toast = am3.h.c(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final LinkMicGuideMessage.d decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
