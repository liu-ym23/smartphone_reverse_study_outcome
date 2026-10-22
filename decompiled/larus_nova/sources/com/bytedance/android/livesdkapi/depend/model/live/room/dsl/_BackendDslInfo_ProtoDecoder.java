package com.bytedance.android.livesdkapi.depend.model.live.room.dsl;

import am3.c;
import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;

/* JADX INFO: loaded from: classes12.dex */
public final class _BackendDslInfo_ProtoDecoder implements c<BackendDslInfo> {
    public _BackendDslInfo_ProtoDecoder() {
    }

    public static BackendDslInfo decodeStatic(g r100) throws Exception {
        BackendDslInfo r101 = new BackendDslInfo();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        if (r103 != 1) goto L8;
        r101.detail = new LiveDSLModel(r100);
        goto L3
    L8:
        if (r103 != 2) goto L9;
        r101.position = h.c(r100);
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
    public final BackendDslInfo decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BackendDslInfo decode(g r100) throws Exception {
        return decode(r100);
    }
}
