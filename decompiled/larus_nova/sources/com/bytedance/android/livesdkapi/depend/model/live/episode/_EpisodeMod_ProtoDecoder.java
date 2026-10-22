package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _EpisodeMod_ProtoDecoder implements c<EpisodeMod> {
    public _EpisodeMod_ProtoDecoder() {
    }

    public static EpisodeMod decodeStatic(g r100) throws Exception {
        EpisodeMod r101 = new EpisodeMod();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.episodeStage = r100.i();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.episodeType = r100.i();
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.episodeSubType = r100.i();
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.episodeRecordType = r100.i();
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
    public final EpisodeMod decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ EpisodeMod decode(g r100) throws Exception {
        return decode(r100);
    }
}
