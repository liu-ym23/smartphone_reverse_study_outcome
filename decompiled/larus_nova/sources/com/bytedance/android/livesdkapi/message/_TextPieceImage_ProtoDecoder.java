package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextPieceImage_ProtoDecoder implements c<TextPieceImage> {
    public _TextPieceImage_ProtoDecoder() {
    }

    public static TextPieceImage decodeStatic(g r100) throws Exception {
        TextPieceImage r101 = new TextPieceImage();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.imageModel = (k) f.a(r100, k.class);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.scalingRate = Float.intBitsToFloat(r100.g());
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
    public final TextPieceImage decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextPieceImage decode(g r100) throws Exception {
        return decode(r100);
    }
}
