package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;

/* JADX INFO: loaded from: classes11.dex */
public final class fo implements am3.c<LinkMicGuideMessage.GuestBattleBubbleGuideContent> {
    public fo() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.GuestBattleBubbleGuideContent decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.GuestBattleBubbleGuideContent r101 = new LinkMicGuideMessage.GuestBattleBubbleGuideContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.text = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
