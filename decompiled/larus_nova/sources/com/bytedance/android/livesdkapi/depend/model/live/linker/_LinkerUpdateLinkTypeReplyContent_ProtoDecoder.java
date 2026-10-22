package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _LinkerUpdateLinkTypeReplyContent_ProtoDecoder implements c<LinkerUpdateLinkTypeReplyContent> {
    public _LinkerUpdateLinkTypeReplyContent_ProtoDecoder() {
    }

    public static LinkerUpdateLinkTypeReplyContent decodeStatic(g r100) throws Exception {
        LinkerUpdateLinkTypeReplyContent r101 = new LinkerUpdateLinkTypeReplyContent();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101._fromUserId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101._toUserId = r100.j();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.replyType = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L14;
        r101.prompts = h.c(r100);
        goto L3
    L14:
        if (r103 != 5000) goto L16;
        r101._fromOpenId = h.c(r100);
        goto L3
    L16:
        if (r103 != 5001) goto L17;
        r101._toOpenId = h.c(r100);
        goto L3
    L17:
        h.d(r104, r100);
        goto L3
    L24:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final LinkerUpdateLinkTypeReplyContent decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ LinkerUpdateLinkTypeReplyContent decode(g r100) throws Exception {
        return decode(r100);
    }
}
