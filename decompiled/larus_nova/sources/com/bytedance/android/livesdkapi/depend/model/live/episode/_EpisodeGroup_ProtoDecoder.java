package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _EpisodeGroup_ProtoDecoder implements c<EpisodeGroup> {
    public _EpisodeGroup_ProtoDecoder() {
    }

    public static EpisodeGroup decodeStatic(g r100) throws Exception {
        EpisodeGroup r101 = new EpisodeGroup();
        r101.episodes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.groupName = h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.episodes.add((Episode) f.a(r100, Episode.class));
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.extra = new ReplayListExtra(r100);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final EpisodeGroup decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ EpisodeGroup decode(g r100) throws Exception {
        return decode(r100);
    }
}
