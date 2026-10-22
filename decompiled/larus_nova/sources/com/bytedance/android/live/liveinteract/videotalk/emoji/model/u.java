package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements am3.c<InteractEmojiAnim> {
    public u() {
    }

    @Override // am3.c
    public final InteractEmojiAnim decode(am3.g r100) throws Exception {
        InteractEmojiAnim r101 = new InteractEmojiAnim();
        r101.getDelegate().setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = r101.getDelegate().decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        r101.reshapeStart = Long.valueOf(r100.j());
        goto L3
    L9:
        r101.soundUrl = am3.h.c(r100);
        goto L3
    L10:
        r101.reshape = am3.h.a(r100);
        goto L3
    L11:
        r101.sizeScale = r100.j();
        goto L3
    L12:
        r101.offset = r100.j();
        goto L3
    L13:
        r101.extraDuration = r100.j();
        goto L3
    L14:
        r101.extraDynamicImage = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L15:
        r101.start = r100.j();
        goto L3
    L16:
        r101.duration = r100.j();
        goto L3
    L17:
        r101.dynamicImage = (py.k) vh7.f.a(r100, py.k.class);
        goto L3
    L7:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.getDelegate().setThreadSafe(true);
        return r101;
    }
}
