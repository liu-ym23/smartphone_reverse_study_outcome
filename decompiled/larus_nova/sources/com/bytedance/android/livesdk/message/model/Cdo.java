package com.bytedance.android.livesdk.message.model;

/* JADX INFO: renamed from: com.bytedance.android.livesdk.message.model.do, reason: invalid class name */
/* JADX INFO: loaded from: classes11.dex */
public final class Cdo implements am3.c<LinkMicGuideMessage.a> {
    public Cdo() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.a decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.a r101 = new LinkMicGuideMessage.a();
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
