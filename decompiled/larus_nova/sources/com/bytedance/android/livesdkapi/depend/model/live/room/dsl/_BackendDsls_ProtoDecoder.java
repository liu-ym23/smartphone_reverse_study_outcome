package com.bytedance.android.livesdkapi.depend.model.live.room.dsl;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class _BackendDsls_ProtoDecoder implements c<BackendDsls> {
    public _BackendDsls_ProtoDecoder() {
    }

    public static BackendDsls decodeStatic(g r100) throws Exception {
        BackendDsls r101 = new BackendDsls();
        r101.cardList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.cardList.add(_BackendDslInfo_ProtoDecoder.decodeStatic(r100));
        goto L3
    L7:
        h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final BackendDsls decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BackendDsls decode(g r100) throws Exception {
        return decode(r100);
    }
}
