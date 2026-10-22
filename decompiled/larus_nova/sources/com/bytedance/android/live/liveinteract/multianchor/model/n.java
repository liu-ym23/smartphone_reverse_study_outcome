package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class n implements am3.c<MicDress.LinkmicBadge> {
    public n() {
    }

    @Override // am3.c
    public final MicDress.LinkmicBadge decode(am3.g r100) throws Exception {
        MicDress.LinkmicBadge r101 = new MicDress.LinkmicBadge();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.dressId = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.showType = r100.i();
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
