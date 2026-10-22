package com.bytedance.android.livesdk.message.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class co implements am3.c<LinkMicGuideMessage.AnchorGuideInfo> {
    public co() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.AnchorGuideInfo decode(am3.g r100) throws Exception {
        LinkMicGuideMessage.AnchorGuideInfo r101 = new LinkMicGuideMessage.AnchorGuideInfo();
        r101.setThreadSafe(false);
        r101.infoItems = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.infoItems.add((LinkMicGuideMessage.AnchorGuideInfoItem) vh7.f.a(r100, LinkMicGuideMessage.AnchorGuideInfoItem.class));
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
