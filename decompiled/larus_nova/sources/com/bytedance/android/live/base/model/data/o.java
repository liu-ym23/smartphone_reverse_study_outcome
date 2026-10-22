package com.bytedance.android.live.base.model.data;

/* JADX INFO: loaded from: classes45.dex */
public final class o implements am3.c<a> {
    public o() {
    }

    @Override // am3.c
    public final a decode(am3.g r100) throws Exception {
        a r101 = new a();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.likeStatus = (int) r100.j();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }
}
