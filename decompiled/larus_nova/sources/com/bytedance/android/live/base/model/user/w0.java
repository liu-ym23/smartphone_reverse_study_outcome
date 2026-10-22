package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: classes45.dex */
public final class w0 implements am3.c<UserExtra> {
    public w0() {
    }

    @Override // am3.c
    public final UserExtra decode(am3.g r100) throws Exception {
        UserExtra r101 = new UserExtra();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.anonymousIsSilence = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.mysteryDetailJumpSchema = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }
}
