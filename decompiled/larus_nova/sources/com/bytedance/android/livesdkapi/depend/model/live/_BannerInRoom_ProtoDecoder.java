package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _BannerInRoom_ProtoDecoder implements c<BannerInRoom> {
    public _BannerInRoom_ProtoDecoder() {
    }

    public static BannerInRoom decodeStatic(g r100) throws Exception {
        BannerInRoom r101 = new BannerInRoom();
        r101.setThreadSafe(false);
        r101.trackingTypes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L7;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L7;
            case 14: goto L9;
            case 15: goto L7;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L8;
            default: goto L7;
        };
    L8:
        r101.trackingTypes.add(h.c(r100));
        goto L3
    L9:
        r101.uid = r100.j();
        goto L3
    L10:
        r101.extra = h.c(r100);
        goto L3
    L11:
        r101.frameType = (int) r100.j();
        goto L3
    L12:
        r101.text = h.c(r100);
        goto L3
    L13:
        r101.priority = (int) r100.j();
        goto L3
    L14:
        r101.actionType = (int) r100.j();
        goto L3
    L15:
        r101.schemaUrl = h.c(r100);
        goto L3
    L16:
        r101.width = (int) r100.j();
        goto L3
    L17:
        r101.height = (int) r100.j();
        goto L3
    L18:
        r101.image = (k) f.a(r100, k.class);
        goto L3
    L19:
        r101.title = h.c(r100);
        goto L3
    L20:
        r101.f162578id = r100.j();
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final BannerInRoom decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BannerInRoom decode(g r100) throws Exception {
        return decode(r100);
    }
}
