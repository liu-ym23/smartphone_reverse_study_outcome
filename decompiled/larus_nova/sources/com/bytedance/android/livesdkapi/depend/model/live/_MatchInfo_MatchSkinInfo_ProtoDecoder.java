package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _MatchInfo_MatchSkinInfo_ProtoDecoder implements c<MatchInfo.MatchSkinInfo> {
    public _MatchInfo_MatchSkinInfo_ProtoDecoder() {
    }

    public static MatchInfo.MatchSkinInfo decodeStatic(g r100) throws Exception {
        MatchInfo.MatchSkinInfo r101 = new MatchInfo.MatchSkinInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        switch(r103) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        r101.shareIcon = (k) f.a(r100, k.class);
        goto L3
    L8:
        r101.commentBackgroundColor = h.c(r100);
        goto L3
    L9:
        r101.toolBarImage = (k) f.a(r100, k.class);
        goto L3
    L10:
        r101.userBannerImage = (k) f.a(r100, k.class);
        goto L3
    L11:
        r101.anchorInfoColor = h.c(r100);
        goto L3
    L12:
        r101.anchorNameColor = h.c(r100);
        goto L3
    L13:
        r101.commentPlaceHolderColor = h.c(r100);
        goto L3
    L14:
        r101.tabUnselectedColor = h.c(r100);
        goto L3
    L15:
        r101.tabSelectedColor = h.c(r100);
        goto L3
    L16:
        r101.followedSkin = _MatchInfo_FollowBtnSkin_ProtoDecoder.decodeStatic(r100);
        goto L3
    L17:
        r101.unfollowSkin = _MatchInfo_FollowBtnSkin_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MatchInfo.MatchSkinInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MatchInfo.MatchSkinInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
