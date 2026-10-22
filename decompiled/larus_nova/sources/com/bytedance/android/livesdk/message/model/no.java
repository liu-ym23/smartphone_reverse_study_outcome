package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import java.util.HashMap;

/* JADX INFO: loaded from: classes11.dex */
public final class no implements am3.c<LinkMicGuideMessage.PlayModeGuideBubbleContent> {
    public no() {
    }

    @Override // am3.c
    public final LinkMicGuideMessage.PlayModeGuideBubbleContent decode(am3.g r110) throws Exception {
        LinkMicGuideMessage.PlayModeGuideBubbleContent r100 = new LinkMicGuideMessage.PlayModeGuideBubbleContent();
        r100.setThreadSafe(false);
        r100.extra = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L31;
        am3.g.a r103 = r100.decodeExtensionFields(r102, r110);
        switch(r102) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        r100.anchorShowPosition = r110.i();
        goto L3
    L9:
        long r104 = r110.c();
        String r105 = null;
        String r106 = null;
    L10:
        int r107 = r110.f();
        if (r107 == (-1)) goto L18;
        if (r107 != 1) goto L14;
        r105 = am3.h.c(r110);
        goto L10
    L14:
        if (r107 != 2) goto L10;
        r106 = am3.h.c(r110);
        goto L10
    L18:
        r110.d(r104);
        if (r105 == null) goto L25;
        if (r106 == null) goto L23;
        r100.extra.put(r105, r106);
        goto L3
    L23:
        throw new IllegalStateException("Map value must not be null!");
    L25:
        throw new IllegalStateException("Map key must not be null!");
    L26:
        r100.schema = am3.h.c(r110);
        goto L3
    L27:
        r100.richText = _Text_ProtoDecoder.decodeStatic(r110);
        goto L3
    L28:
        r100.enhanceType = r110.i();
        goto L3
    L29:
        r100.toast = am3.h.c(r110);
        goto L3
    L30:
        r100.playMode = r110.i();
        goto L3
    L7:
        am3.h.d(r103, r110);
        goto L3
    L31:
        r110.d(r101);
        r100.setThreadSafe(true);
        return r100;
    }
}
