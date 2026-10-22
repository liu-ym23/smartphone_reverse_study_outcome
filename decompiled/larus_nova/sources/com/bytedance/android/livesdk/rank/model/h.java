package com.bytedance.android.livesdk.rank.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements am3.c<e> {
    public h() {
    }

    @Override // am3.c
    public final e decode(am3.g r100) throws Exception {
        e r101 = new e();
        r101.options = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.status = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.prompt = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.localStatus = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.options.add(Long.valueOf(r100.j()));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }
}
