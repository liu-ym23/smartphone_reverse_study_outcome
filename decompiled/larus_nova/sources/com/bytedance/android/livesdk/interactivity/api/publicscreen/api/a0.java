package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class a0 implements am3.c<FusionEmojiBanList> {
    public a0() {
    }

    public static FusionEmojiBanList a(am3.g r100) throws Exception {
        FusionEmojiBanList r101 = new FusionEmojiBanList();
        r101.banList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.banList.add(Long.valueOf(r100.j()));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final FusionEmojiBanList decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
