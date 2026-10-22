package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _LinkerUpdateLinkTypeApplyContent_ProtoDecoder implements c<LinkerUpdateLinkTypeApplyContent> {
    public _LinkerUpdateLinkTypeApplyContent_ProtoDecoder() {
    }

    public static LinkerUpdateLinkTypeApplyContent decodeStatic(g r100) throws Exception {
        LinkerUpdateLinkTypeApplyContent r101 = new LinkerUpdateLinkTypeApplyContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 5000) goto L8;
        r101.fromOpenId = h.c(r100);
        goto L3
    L8:
        if (r103 != 5001) goto L9;
        r101.toOpenId = h.c(r100);
        goto L3
    L9:
        switch(r103) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        r101.clientNoToast = Boolean.valueOf(h.a(r100));
        goto L3
    L12:
        r101.showType = r100.i();
        goto L3
    L13:
        r101.toast = h.c(r100);
        goto L3
    L14:
        r101.ackMessage = h.c(r100);
        goto L3
    L15:
        r101.source = r100.i();
        goto L3
    L16:
        r101.linkType = r100.i();
        goto L3
    L17:
        r101.toUserId = r100.j();
        goto L3
    L18:
        r101.fromUserId = r100.j();
        goto L3
    L10:
        h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final LinkerUpdateLinkTypeApplyContent decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ LinkerUpdateLinkTypeApplyContent decode(g r100) throws Exception {
        return decode(r100);
    }
}
