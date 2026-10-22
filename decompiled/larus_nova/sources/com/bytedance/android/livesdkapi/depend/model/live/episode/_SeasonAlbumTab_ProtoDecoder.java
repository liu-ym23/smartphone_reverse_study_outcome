package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _SeasonAlbumTab_ProtoDecoder implements c<SeasonAlbumTab> {
    public _SeasonAlbumTab_ProtoDecoder() {
    }

    public static SeasonAlbumTab decodeStatic(g r100) throws Exception {
        SeasonAlbumTab r101 = new SeasonAlbumTab();
        r101.specialEpisodes = new ArrayList();
        r101.episodes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.episodes.add(_AlbumItem_ProtoDecoder.decodeStatic(r100));
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.specialEpisodes.add(_AlbumItem_ProtoDecoder.decodeStatic(r100));
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
    public final SeasonAlbumTab decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ SeasonAlbumTab decode(g r100) throws Exception {
        return decode(r100);
    }
}
