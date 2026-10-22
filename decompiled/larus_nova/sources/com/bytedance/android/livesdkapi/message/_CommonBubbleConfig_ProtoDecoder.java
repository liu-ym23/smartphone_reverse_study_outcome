package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.message.a5;
import py.i;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _CommonBubbleConfig_ProtoDecoder implements c<CommonBubbleConfig> {
    public _CommonBubbleConfig_ProtoDecoder() {
    }

    public static CommonBubbleConfig decodeStatic(g r100) throws Exception {
        CommonBubbleConfig r101 = new CommonBubbleConfig();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        r101.arrowPosition = r100.i();
        goto L3
    L8:
        r101.messageType = r100.i();
        goto L3
    L9:
        r101.arrowImage = (k) f.a(r100, k.class);
        goto L3
    L10:
        r101.backgroundImage = (i) f.a(r100, i.class);
        goto L3
    L11:
        r101.schemeUrl = h.c(r100);
        goto L3
    L12:
        r101.richText = (a5) f.a(r100, a5.class);
        goto L3
    L13:
        r101.duration = (int) r100.j();
        goto L3
    L14:
        r101.content = h.c(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final CommonBubbleConfig decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ CommonBubbleConfig decode(g r100) throws Exception {
        return decode(r100);
    }
}
