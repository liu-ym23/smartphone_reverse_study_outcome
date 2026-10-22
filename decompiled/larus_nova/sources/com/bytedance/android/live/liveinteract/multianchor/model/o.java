package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class o implements am3.c<MicDress.a> {
    public o() {
    }

    public static MicDress.a a(am3.g r100) throws Exception {
        MicDress.a r101 = new MicDress.a();
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
        r101.triggerReason = am3.h.c(r100);
        goto L3
    L8:
        r101.type = (int) r100.j();
        goto L3
    L9:
        r101.randomNum = r100.j();
        goto L3
    L10:
        r101.dynamicImage = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L11:
        r101.statusImage = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        r101.f75468ts = r100.j();
        goto L3
    L13:
        r101.status = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final MicDress.a decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
