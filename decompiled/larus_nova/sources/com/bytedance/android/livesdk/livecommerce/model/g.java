package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements am3.c<ECV2FilterSwitchChangeData> {
    public g() {
    }

    public static ECV2FilterSwitchChangeData a(am3.g r100) throws Exception {
        ECV2FilterSwitchChangeData r101 = new ECV2FilterSwitchChangeData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.enable = am3.h.a(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.upIcon = h.a(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2FilterSwitchChangeData decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
