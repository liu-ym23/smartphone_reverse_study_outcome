package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _AsyncAuthData_ProtoDecoder implements c<AsyncAuthData> {
    public _AsyncAuthData_ProtoDecoder() {
    }

    public static AsyncAuthData decodeStatic(g r100) throws Exception {
        AsyncAuthData r101 = new AsyncAuthData();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        if (r103 != 2) goto L8;
        r101.needRefreshStream = r100.j();
        goto L3
    L8:
        if (r103 != 3) goto L10;
        r101.asyncAuthAB = r100.j();
        goto L3
    L10:
        if (r103 != 4) goto L12;
        r101.keepAliveTime = r100.j();
        goto L3
    L12:
        if (r103 != 5) goto L13;
        r101.tempWatchBuffer = r100.j();
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
    public final AsyncAuthData decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ AsyncAuthData decode(g r100) throws Exception {
        return decode(r100);
    }
}
