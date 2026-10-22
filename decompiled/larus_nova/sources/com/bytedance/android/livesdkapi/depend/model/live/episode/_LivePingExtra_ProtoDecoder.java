package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _LivePingExtra_ProtoDecoder implements c<LivePingExtra> {
    public _LivePingExtra_ProtoDecoder() {
    }

    public static LivePingExtra decodeStatic(g r100) throws Exception {
        LivePingExtra r101 = new LivePingExtra();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.duration = r100.i();
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final LivePingExtra decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ LivePingExtra decode(g r100) throws Exception {
        return decode(r100);
    }
}
