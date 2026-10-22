package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextPieceHeart_ProtoDecoder implements c<TextPieceHeart> {
    public _TextPieceHeart_ProtoDecoder() {
    }

    public static TextPieceHeart decodeStatic(g r100) throws Exception {
        TextPieceHeart r101 = new TextPieceHeart();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L7;
        r101.color = h.c(r100);
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L9:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TextPieceHeart decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextPieceHeart decode(g r100) throws Exception {
        return decode(r100);
    }
}
