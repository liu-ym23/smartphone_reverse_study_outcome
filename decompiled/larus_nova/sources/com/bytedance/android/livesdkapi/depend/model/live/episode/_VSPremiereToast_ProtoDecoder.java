package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VSPremiereToast_ProtoDecoder implements c<VSPremiereToast> {
    public _VSPremiereToast_ProtoDecoder() {
    }

    public static VSPremiereToast decodeStatic(g r100) throws Exception {
        VSPremiereToast r101 = new VSPremiereToast();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.leftTopText = h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.playerToastText = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.playerTopText = h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.icon = (k) f.a(r100, k.class);
        goto L3
    L13:
        h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VSPremiereToast decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VSPremiereToast decode(g r100) throws Exception {
        return decode(r100);
    }
}
