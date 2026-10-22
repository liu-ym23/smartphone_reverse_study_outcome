package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _MoreSpectacular_ProtoDecoder implements c<MoreSpectacular> {
    public _MoreSpectacular_ProtoDecoder() {
    }

    public static MoreSpectacular decodeStatic(g r100) throws Exception {
        MoreSpectacular r101 = new MoreSpectacular();
        r101.colors = new ArrayList();
        r101.episodes = new ArrayList();
        r101.moreEntryList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        r101.moreEntryList.add(_MoreEntry_ProtoDecoder.decodeStatic(r100));
        goto L3
    L8:
        r101.extensionType = r100.j();
        goto L3
    L9:
        r101.total = r100.j();
        goto L3
    L10:
        r101.moreSeason = new MoreSeason(r100);
        goto L3
    L11:
        r101.colors.add(h.c(r100));
        goto L3
    L12:
        r101.episodes.add(_AlbumItem_ProtoDecoder.decodeStatic(r100));
        goto L3
    L13:
        r101.desc = h.c(r100);
        goto L3
    L14:
        r101.title = h.c(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MoreSpectacular decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MoreSpectacular decode(g r100) throws Exception {
        return decode(r100);
    }
}
