package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class y implements am3.c<a> {
    public y() {
    }

    @Override // am3.c
    public final a decode(am3.g r100) throws Exception {
        a r101 = new a();
        r101.itemList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.itemList.add(e0.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }
}
