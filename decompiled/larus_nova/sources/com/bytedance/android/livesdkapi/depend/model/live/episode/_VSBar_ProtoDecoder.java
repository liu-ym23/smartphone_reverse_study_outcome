package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _VSBar_ProtoDecoder implements c<VSBar> {
    public _VSBar_ProtoDecoder() {
    }

    public static VSBar decodeStatic(g r100) throws Exception {
        VSBar r101 = new VSBar();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.itemComment = new VSItemBar(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.itemBar = new VSItemBar(r100);
        goto L3
    L9:
        h.e(r100);
        goto L3
    L12:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final VSBar decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VSBar decode(g r100) throws Exception {
        return decode(r100);
    }
}
