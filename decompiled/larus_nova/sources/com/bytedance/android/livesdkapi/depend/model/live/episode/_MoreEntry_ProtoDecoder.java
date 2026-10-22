package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _MoreEntry_ProtoDecoder implements c<MoreEntry> {
    public _MoreEntry_ProtoDecoder() {
    }

    public static MoreEntry decodeStatic(g r100) throws Exception {
        MoreEntry r101 = new MoreEntry();
        r101.colors = new ArrayList();
        r101.episodeIdsStr = new ArrayList();
        r101.episodeIds = new ArrayList();
        r101.episodes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        switch(r103) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L6;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        r101.episodeIdsStr.add(h.c(r100));
        goto L3
    L8:
        r101.secondTitle = h.c(r100);
        goto L3
    L9:
        r101.batchSize = r100.j();
        goto L3
    L10:
        r101.episodeIds.add(Long.valueOf(r100.j()));
        goto L3
    L11:
        r101.displayType = r100.j();
        goto L3
    L12:
        r101.extensionType = r100.j();
        goto L3
    L13:
        r101.total = r100.j();
        goto L3
    L14:
        r101.colors.add(h.c(r100));
        goto L3
    L15:
        r101.episodes.add(_AlbumItem_ProtoDecoder.decodeStatic(r100));
        goto L3
    L16:
        r101.desc = h.c(r100);
        goto L3
    L17:
        r101.title = h.c(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L18:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MoreEntry decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MoreEntry decode(g r100) throws Exception {
        return decode(r100);
    }
}
