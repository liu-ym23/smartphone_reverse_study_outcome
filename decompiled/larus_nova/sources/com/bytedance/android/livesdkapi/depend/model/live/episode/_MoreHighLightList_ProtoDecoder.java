package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _MoreHighLightList_ProtoDecoder implements c<MoreHighLightList> {
    public _MoreHighLightList_ProtoDecoder() {
    }

    public static MoreHighLightList decodeStatic(g r100) throws Exception {
        MoreHighLightList r101 = new MoreHighLightList();
        r101.backgrounds = new ArrayList();
        r101.episodes = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r101.extensionType = r100.j();
        goto L3
    L8:
        r101.introductionUrl = h.c(r100);
        goto L3
    L9:
        r101.backgrounds.add(h.c(r100));
        goto L3
    L10:
        r101.episodes.add(Long.valueOf(r100.j()));
        goto L3
    L11:
        r101.desc = h.c(r100);
        goto L3
    L12:
        r101.title = h.c(r100);
        goto L3
    L6:
        h.e(r100);
        goto L3
    L13:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final MoreHighLightList decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ MoreHighLightList decode(g r100) throws Exception {
        return decode(r100);
    }
}
