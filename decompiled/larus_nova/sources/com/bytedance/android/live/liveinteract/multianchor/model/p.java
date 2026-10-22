package com.bytedance.android.live.liveinteract.multianchor.model;

/* JADX INFO: loaded from: classes46.dex */
public final class p implements am3.c<MicDress> {
    public p() {
    }

    @Override // am3.c
    public final MicDress decode(am3.g r100) throws Exception {
        MicDress r101 = new MicDress();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        am3.g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 2) goto L8;
        r101.voiceWave = (MicDress.VoiceWave) vh7.f.a(r100, MicDress.VoiceWave.class);
        goto L3
    L8:
        if (r103 != 3) goto L10;
        r101.badge = (MicDress.LinkmicBadge) vh7.f.a(r100, MicDress.LinkmicBadge.class);
        goto L3
    L10:
        if (r103 != 4) goto L11;
        r101.linkmicCustomizedRandomEmoji = o.a(r100);
        goto L3
    L11:
        am3.h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }
}
