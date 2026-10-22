package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class w implements am3.c<ECV2InteractionData.MessageProduct> {
    public w() {
    }

    public static ECV2InteractionData.MessageProduct a(am3.g r100) throws Exception {
        ECV2InteractionData.MessageProduct r101 = new ECV2InteractionData.MessageProduct();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.cover = x.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.showIndex = am3.h.a(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.index = r100.i();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.MessageProduct decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
