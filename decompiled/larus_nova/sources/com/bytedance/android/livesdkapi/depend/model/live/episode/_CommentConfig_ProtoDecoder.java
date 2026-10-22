package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _CommentConfig_ProtoDecoder implements c<CommentConfig> {
    public _CommentConfig_ProtoDecoder() {
    }

    public static CommentConfig decodeStatic(g r100) throws Exception {
        CommentConfig r101 = new CommentConfig();
        r101.mCommentColors = new ArrayList();
        r101.mCommentMedals = new ArrayList();
        r101.mCommentRoles = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r101.mMedalTitle = h.c(r100);
        goto L3
    L8:
        r101.mCommentMedals.add(_CommentMedal_ProtoDecoder.decodeStatic(r100));
        goto L3
    L9:
        r101.mUnlockRoleTip = h.c(r100);
        goto L3
    L10:
        r101.mRoleTitle = h.c(r100);
        goto L3
    L11:
        r101.mRoleSuffix = h.c(r100);
        goto L3
    L12:
        r101.mCommentRoles.add(_CommentRole_ProtoDecoder.decodeStatic(r100));
        goto L3
    L13:
        r101.mCommentColors.add(_CommentColor_ProtoDecoder.decodeStatic(r100));
        goto L3
    L6:
        h.e(r100);
        goto L3
    L14:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final CommentConfig decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ CommentConfig decode(g r100) throws Exception {
        return decode(r100);
    }
}
