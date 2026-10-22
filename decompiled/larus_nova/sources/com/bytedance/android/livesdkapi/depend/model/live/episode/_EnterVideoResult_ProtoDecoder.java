package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.c;
import am3.g;
import am3.h;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _EnterVideoResult_ProtoDecoder implements c<EnterVideoResult> {
    public _EnterVideoResult_ProtoDecoder() {
    }

    public static EnterVideoResult decodeStatic(g r100) throws Exception {
        EnterVideoResult r101 = new EnterVideoResult();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 1) goto L8;
        r101.episode = (Episode) f.a(r100, Episode.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.more = _MoreSpectacular_ProtoDecoder.decodeStatic(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.isVidValid = h.a(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        r101.notReportPV = h.a(r100);
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
    public final EnterVideoResult decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ EnterVideoResult decode(g r100) throws Exception {
        return decode(r100);
    }
}
