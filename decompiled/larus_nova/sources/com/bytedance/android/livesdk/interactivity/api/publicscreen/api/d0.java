package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class d0 implements am3.c<MsgOptPanel> {
    public d0() {
    }

    public static MsgOptPanel a(am3.g r100) throws Exception {
        MsgOptPanel r101 = new MsgOptPanel();
        r101.itemList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.itemList.add(f0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final MsgOptPanel decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
