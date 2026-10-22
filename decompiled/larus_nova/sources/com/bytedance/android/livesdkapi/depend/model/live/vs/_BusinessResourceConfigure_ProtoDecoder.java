package com.bytedance.android.livesdkapi.depend.model.live.vs;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _BusinessResourceConfigure_ProtoDecoder implements c<BusinessResourceConfigure> {
    public _BusinessResourceConfigure_ProtoDecoder() {
    }

    public static BusinessResourceConfigure decodeStatic(g r100) throws Exception {
        BusinessResourceConfigure r101 = new BusinessResourceConfigure();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.resourceId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.barrageConfig = new BusinessBarrageConfigure(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.screenBarConfigure = new BusinessScreenBarConfigure(r100);
        goto L3
    L11:
        h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final BusinessResourceConfigure decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BusinessResourceConfigure decode(g r100) throws Exception {
        return decode(r100);
    }
}
