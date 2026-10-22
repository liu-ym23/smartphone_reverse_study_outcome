package com.bytedance.android.livesdkapi.message;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.user.IBaseUser;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _TextPieceUser_ProtoDecoder implements c<TextPieceUser> {
    public _TextPieceUser_ProtoDecoder() {
    }

    public static TextPieceUser decodeStatic(g r100) throws Exception {
        TextPieceUser r101 = new TextPieceUser();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.user = (IBaseUser) f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.withColon = h.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.selfShowRealName = h.a(r100);
        goto L3
    L12:
        if (r103 != 5) goto L14;
        r101.leftAdditionalContent = h.c(r100);
        goto L3
    L14:
        if (r103 != 6) goto L15;
        r101.rightAdditionalContent = h.c(r100);
        goto L3
    L15:
        h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final TextPieceUser decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ TextPieceUser decode(g r100) throws Exception {
        return decode(r100);
    }
}
