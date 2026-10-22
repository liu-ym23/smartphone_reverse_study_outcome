package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements am3.c<ECV2InteractionData.ElementAvatar> {
    public j() {
    }

    public static ECV2InteractionData.ElementAvatar a(am3.g r100) throws Exception {
        ECV2InteractionData.ElementAvatar r101 = new ECV2InteractionData.ElementAvatar();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.image = z.a(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2InteractionData.ElementAvatar decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
