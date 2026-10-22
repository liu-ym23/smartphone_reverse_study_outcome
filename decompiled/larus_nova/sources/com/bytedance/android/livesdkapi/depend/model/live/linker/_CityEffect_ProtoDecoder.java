package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _CityEffect_ProtoDecoder implements c<CityEffect> {
    public _CityEffect_ProtoDecoder() {
    }

    public static CityEffect decodeStatic(g r100) throws Exception {
        CityEffect r101 = new CityEffect();
        r101.setThreadSafe(false);
        r101.showEffectUserIdList = new ArrayList();
        r101.showEffectOpenIdList = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.cityEffect = (k) f.a(r100, k.class);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.city = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        r101.showEffectUserIdList.add(Long.valueOf(r100.j()));
        goto L3
    L12:
        if (r103 != 5000) goto L13;
        r101.showEffectOpenIdList.add(h.c(r100));
        goto L3
    L13:
        h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        r101.setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final CityEffect decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ CityEffect decode(g r100) throws Exception {
        return decode(r100);
    }
}
