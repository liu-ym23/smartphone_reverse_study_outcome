package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _MatchInfo_FollowBtnSkin_ProtoDecoder implements c<MatchInfo.FollowBtnSkin> {
    public _MatchInfo_FollowBtnSkin_ProtoDecoder() {
    }

    public static MatchInfo.FollowBtnSkin decodeStatic(g r100) throws Exception {
        MatchInfo.FollowBtnSkin r101 = new MatchInfo.FollowBtnSkin();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.leftColor = h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.rightColor = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.fontColor = h.c(r100);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MatchInfo.FollowBtnSkin decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MatchInfo.FollowBtnSkin decode(g r100) throws Exception {
        return decode(r100);
    }
}
