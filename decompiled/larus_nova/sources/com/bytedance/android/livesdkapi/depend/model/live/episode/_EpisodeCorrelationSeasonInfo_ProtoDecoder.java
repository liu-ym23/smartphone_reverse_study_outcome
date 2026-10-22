package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _EpisodeCorrelationSeasonInfo_ProtoDecoder implements c<EpisodeCorrelationSeasonInfo> {
    public _EpisodeCorrelationSeasonInfo_ProtoDecoder() {
    }

    public static EpisodeCorrelationSeasonInfo decodeStatic(g r100) throws Exception {
        EpisodeCorrelationSeasonInfo r101 = new EpisodeCorrelationSeasonInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.seasonBriefInfo = new SeasonBriefInfo(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.showInfo = _ShowCenterShowInfo_ProtoDecoder.decodeStatic(r100);
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
    public final EpisodeCorrelationSeasonInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ EpisodeCorrelationSeasonInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
