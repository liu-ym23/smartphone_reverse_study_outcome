package com.bytedance.android.livesdk.message.model;

/* JADX INFO: loaded from: classes11.dex */
public final class eo implements am3.c<LinkMicGuideMessage.CreateGroupChatGuideContent> {
    public eo() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.CreateGroupChatGuideContent decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.CreateGroupChatGuideContent r101 = new LinkMicGuideMessage.CreateGroupChatGuideContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.anchorID = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.headerText = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.bodyText = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
