package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextPiece_ProtoDecoder implements c<TextPiece> {
    public _TextPiece_ProtoDecoder() {
    }

    public static TextPiece decodeStatic(g r100) throws Exception {
        TextPiece r101 = new TextPiece();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L27;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.type = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.format = (TextFormat) f.a(r100, TextFormat.class);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.refKey = h.c(r100);
        goto L3
    L12:
        if (r103 != 11) goto L14;
        r101.stringValue = h.c(r100);
        goto L3
    L14:
        if (r103 != 100) goto L15;
        r101.schemaKey = h.c(r100);
        goto L3
    L15:
        switch(r103) {
            case 21: goto L21;
            case 22: goto L20;
            case 23: goto L19;
            case 24: goto L18;
            case 25: goto L17;
            default: goto L16;
        };
    L17:
        r101.imageValue = (TextPieceImage) f.a(r100, TextPieceImage.class);
        goto L3
    L18:
        r101.patternRefValue = (TextPiecePatternRef) f.a(r100, TextPiecePatternRef.class);
        goto L3
    L19:
        r101.heartValue = (TextPieceHeart) f.a(r100, TextPieceHeart.class);
        goto L3
    L20:
        r101.giftValue = (TextPieceGift) f.a(r100, TextPieceGift.class);
        goto L3
    L21:
        r101.userValue = (TextPieceUser) f.a(r100, TextPieceUser.class);
        goto L3
    L16:
        h.d(r104, r100);
        goto L3
    L27:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TextPiece decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextPiece decode(g r100) throws Exception {
        return decode(r100);
    }
}
