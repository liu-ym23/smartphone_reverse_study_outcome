package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.HashMap;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _CommentMedal_ProtoDecoder implements c<CommentMedal> {
    public _CommentMedal_ProtoDecoder() {
    }

    public static CommentMedal decodeStatic(g r110) throws Exception {
        CommentMedal r100 = new CommentMedal();
        r100.mJumpSchema = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L33;
        if (r102 != 1) goto L8;
        r100.mMedalName = h.c(r110);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.mImage = (k) f.a(r110, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L16:
        int r111 = r110.f();
        if (r111 == (-1)) goto L23;
        if (r111 != 1) goto L19;
        r104 = h.c(r110);
        goto L16
    L19:
        if (r111 != 2) goto L16;
        r105 = h.c(r110);
        goto L16
    L23:
        r110.d(r103);
        if (r104 == null) goto L30;
        if (r105 == null) goto L28;
        r100.mJumpSchema.put(r104, r105);
        goto L3
    L28:
        throw new IllegalStateException("Map value must not be null!");
    L30:
        throw new IllegalStateException("Map key must not be null!");
    L12:
        if (r102 != 4) goto L13;
        r100.mKeyBoardImage = (k) f.a(r110, k.class);
        goto L3
    L13:
        h.e(r110);
        goto L3
    L33:
        r110.d(r101);
        return r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final CommentMedal decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ CommentMedal decode(g r100) throws Exception {
        return decode(r100);
    }
}
