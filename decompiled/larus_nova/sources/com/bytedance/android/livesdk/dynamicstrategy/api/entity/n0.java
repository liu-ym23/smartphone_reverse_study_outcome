package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

/* JADX INFO: loaded from: classes8.dex */
public final class n0 implements am3.c<m> {
    public n0() {
    }

    public static m a(am3.g r100) throws Exception {
        m r101 = new m();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r101.nfaInfo = new s(r100);
        goto L3
    L8:
        r101.featureType = r100.i();
        goto L3
    L9:
        r101.featureValue = m0.a(r100);
        goto L3
    L10:
        r101.refreshInterval = r100.i();
        goto L3
    L11:
        r101.timeliness = r100.i();
        goto L3
    L12:
        r101.source = r100.i();
        goto L3
    L13:
        r101.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final m decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
