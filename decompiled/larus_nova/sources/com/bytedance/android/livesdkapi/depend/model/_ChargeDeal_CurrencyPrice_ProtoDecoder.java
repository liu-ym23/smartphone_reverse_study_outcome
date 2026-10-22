package com.bytedance.android.livesdkapi.depend.model;

import am3.c;
import am3.g;
import am3.h;

/* JADX INFO: loaded from: classes12.dex */
public final class _ChargeDeal_CurrencyPrice_ProtoDecoder implements c<ChargeDeal.CurrencyPrice> {
    public _ChargeDeal_CurrencyPrice_ProtoDecoder() {
    }

    public static ChargeDeal.CurrencyPrice decodeStatic(g r100) throws Exception {
        ChargeDeal.CurrencyPrice r101 = new ChargeDeal.CurrencyPrice();
        r101.setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        g.a r104 = r101.decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        r101.currency = h.c(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.priceShowForm = h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.price = String.valueOf(r100.i());
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
    public final ChargeDeal.CurrencyPrice decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ ChargeDeal.CurrencyPrice decode(g r100) throws Exception {
        return decode(r100);
    }
}
