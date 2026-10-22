package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _VsTopicInfo_ProtoDecoder implements c<VsTopicInfo> {
    public _VsTopicInfo_ProtoDecoder() {
    }

    public static VsTopicInfo decodeStatic(g r100) throws Exception {
        VsTopicInfo r101 = new VsTopicInfo();
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
        r101.timePoint = _VsTopicInfo_TimePoint_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        r101.cover = (k) f.a(r100, k.class);
        goto L3
    L9:
        r101.playCount = r100.j();
        goto L3
    L10:
        r101.isCommerce = h.a(r100);
        goto L3
    L11:
        r101.title = h.c(r100);
        goto L3
    L12:
        r101.challengeId = r100.j();
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
    public final VsTopicInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ VsTopicInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
