package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextPiecePatternRef_ProtoDecoder implements c<TextPiecePatternRef> {
    public _TextPiecePatternRef_ProtoDecoder() {
    }

    public static TextPiecePatternRef decodeStatic(g r100) throws Exception {
        TextPiecePatternRef r101 = new TextPiecePatternRef();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.key = h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.defaultPattern = h.c(r100);
        goto L3
    L9:
        h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TextPiecePatternRef decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextPiecePatternRef decode(g r100) throws Exception {
        return decode(r100);
    }
}
