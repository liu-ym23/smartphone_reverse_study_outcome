package com.bytedance.android.livesdkapi.depend.model.live.vs;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _BusinessConfigure_ProtoDecoder implements c<BusinessConfigure> {
    public _BusinessConfigure_ProtoDecoder() {
    }

    public static BusinessConfigure decodeStatic(g r100) throws Exception {
        BusinessConfigure r101 = new BusinessConfigure();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        r101.deliveryType = r100.j();
        goto L3
    L8:
        r101.resourceConfig = _BusinessResourceConfigure_ProtoDecoder.decodeStatic(r100);
        goto L3
    L9:
        r101.displaySecond = r100.i();
        goto L3
    L10:
        r101.preciseTime = r100.j();
        goto L3
    L11:
        r101.delaySecond = r100.i();
        goto L3
    L12:
        r101.businessType = r100.j();
        goto L3
    L13:
        r101.businessId = r100.j();
        goto L3
    L6:
        h.e(r100);
        goto L3
    L14:
        r100.d(r102);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final BusinessConfigure decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ BusinessConfigure decode(g r100) throws Exception {
        return decode(r100);
    }
}
