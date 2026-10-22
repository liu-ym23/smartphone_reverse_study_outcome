package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;

/* JADX INFO: loaded from: classes11.dex */
public final class wn implements am3.c<g0> {
    public wn() {
    }

    public static g0 a(am3.g r100) throws Exception {
        g0 r101 = new g0();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.userInfo = (IBaseUser) vh7.f.a(r100, IBaseUser.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.displayText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.displayUserRole = am3.h.a(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final g0 decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
