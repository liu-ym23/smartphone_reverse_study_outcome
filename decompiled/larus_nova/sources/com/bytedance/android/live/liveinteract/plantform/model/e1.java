package com.bytedance.android.live.liveinteract.plantform.model;

/* JADX INFO: loaded from: classes46.dex */
public final class e1 implements am3.c<a> {
    public e1() {
    }

    @Override // am3.c
    public final a decode(am3.g r100) throws Exception {
        a r101 = new a();
        long r102 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r102);
        return r101;
    }
}
