package com.bytedance.android.livesdk.message.model;

/* JADX INFO: loaded from: classes11.dex */
public final class ho implements am3.c<LinkMicGuideMessage.b> {
    public ho() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.b decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.b r101 = new LinkMicGuideMessage.b();
        long r102 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r102);
        return r101;
    }
}
