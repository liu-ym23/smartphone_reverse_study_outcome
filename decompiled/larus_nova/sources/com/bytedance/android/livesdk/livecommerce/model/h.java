package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: classes10.dex */
public final class h implements am3.c<ECV2FilterSwitchChangeData.UpIcon> {
    public h() {
    }

    public static ECV2FilterSwitchChangeData.UpIcon a(am3.g r100) throws Exception {
        ECV2FilterSwitchChangeData.UpIcon r101 = new ECV2FilterSwitchChangeData.UpIcon();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.name = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.upIconUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.upDesc = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.publicScreenNotice = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2FilterSwitchChangeData.UpIcon decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
