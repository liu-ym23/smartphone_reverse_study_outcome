package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _MatchInfo_ProtoDecoder implements c<MatchInfo> {
    public _MatchInfo_ProtoDecoder() {
    }

    public static MatchInfo decodeStatic(g r100) throws Exception {
        MatchInfo r101 = new MatchInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.skin = _MatchInfo_MatchSkinInfo_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MatchInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MatchInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
