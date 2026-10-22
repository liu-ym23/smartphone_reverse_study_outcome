package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

/* JADX INFO: loaded from: classes9.dex */
public final class z implements am3.c<g> {
    public z() {
    }

    public static g a(am3.g r100) throws Exception {
        g r101 = new g();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.title = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.text = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final g decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
