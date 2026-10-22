package com.bytedance.android.livesdkapi.depend.model.live;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _ReplayInfo_ProtoDecoder implements c<ReplayInfo> {
    public _ReplayInfo_ProtoDecoder() {
    }

    public static ReplayInfo decodeStatic(g r100) throws Exception {
        ReplayInfo r101 = new ReplayInfo();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.replayDuration = (int) r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.replayUrl = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.contentUniqId = h.c(r100);
        goto L3
    L11:
        h.d(r104, r100);
        goto L3
    L15:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final ReplayInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ ReplayInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
