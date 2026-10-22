package com.bytedance.android.livesdk.message.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class go implements am3.c<LinkMicGuideMessage.JoinGroupChatGuideContent> {
    public go() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.JoinGroupChatGuideContent decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.JoinGroupChatGuideContent r101 = new LinkMicGuideMessage.JoinGroupChatGuideContent();
        r101.setThreadSafe(false);
        r101.iconsList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r101.guide_source = r100.i();
        goto L3
    L9:
        r101.group_type = r100.i();
        goto L3
    L10:
        r101.iconsList.add(com.bytedance.android.live.base.model.x.a(r100));
        goto L3
    L11:
        r101.bodyText = am3.h.c(r100);
        goto L3
    L12:
        r101.headerText = am3.h.c(r100);
        goto L3
    L13:
        r101.conversationID = am3.h.c(r100);
        goto L3
    L14:
        r101.conversationShortID = Long.valueOf(r100.j());
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
