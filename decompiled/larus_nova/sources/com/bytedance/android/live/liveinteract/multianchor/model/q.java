package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements am3.c<MicDress.VoiceWave> {
    public q() {
    }

    @Override // am3.c
    public final MicDress.VoiceWave decode(am3.g r100) throws Exception {
        MicDress.VoiceWave r101 = new MicDress.VoiceWave();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.dressId = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.lowImg = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.mediumImg = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.highImg = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
