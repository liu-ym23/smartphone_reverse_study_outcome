package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _EpisodeOnlyTaSegments_ProtoDecoder implements c<EpisodeOnlyTaSegments> {
    public _EpisodeOnlyTaSegments_ProtoDecoder() {
    }

    public static EpisodeOnlyTaSegments decodeStatic(g r100) throws Exception {
        EpisodeOnlyTaSegments r101 = new EpisodeOnlyTaSegments();
        r101.scopes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.taId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.taNickname = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.avatar = (k) f.a(r100, k.class);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.scopes.add(_EpisodeOnlyTaSegmentScope_ProtoDecoder.decodeStatic(r100));
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
    public final EpisodeOnlyTaSegments decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ EpisodeOnlyTaSegments decode(g r100) throws Exception {
        return decode(r100);
    }
}
