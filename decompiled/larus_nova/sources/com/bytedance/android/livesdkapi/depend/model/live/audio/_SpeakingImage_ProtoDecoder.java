package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _SpeakingImage_ProtoDecoder implements c<SpeakingImage> {
    public _SpeakingImage_ProtoDecoder() {
    }

    public static SpeakingImage decodeStatic(g r100) throws Exception {
        SpeakingImage r101 = new SpeakingImage();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.low = (k) f.a(r100, k.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.medium = (k) f.a(r100, k.class);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.high = (k) f.a(r100, k.class);
        goto L3
    L11:
        h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final SpeakingImage decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ SpeakingImage decode(g r100) throws Exception {
        return decode(r100);
    }
}
