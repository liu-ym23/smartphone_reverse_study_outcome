package com.bytedance.android.livesdkapi.depend.model;

import am3.c;
import am3.g;
import am3.h;
import java.util.ArrayList;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public final class _ChargeDeal_ProtoDecoder implements c<ChargeDeal> {
    public _ChargeDeal_ProtoDecoder() {
    }

    public static ChargeDeal decodeStatic(g r100) throws Exception {
        ChargeDeal r101 = new ChargeDeal();
        r101.getDelegate().setThreadSafe(false);
        r101.mCurrencyPrice = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        g.a r104 = r101.getDelegate().decodeExtensionFields(r103, r100);
        switch(r103) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L7;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L7;
            case 14: goto L9;
            case 15: goto L8;
            default: goto L7;
        };
    L8:
        r101.mDescribeType = r100.i();
        goto L3
    L9:
        r101.mDiamondSignInfo = h.c(r100);
        goto L3
    L10:
        r101.mIsCustomizedDiamond = h.a(r100);
        goto L3
    L11:
        r101.mHideGivingCount = h.a(r100);
        goto L3
    L12:
        r101.mDiscountPrice = r100.i();
        goto L3
    L13:
        r101.mCurrencyPrice.add((ChargeDeal.CurrencyPrice) f.a(r100, ChargeDeal.CurrencyPrice.class));
        goto L3
    L14:
        r101.mDescribe = h.c(r100);
        goto L3
    L15:
        r101.mRewardDiamondCount = r100.i();
        goto L3
    L16:
        r101.mDiamondCount = r100.i();
        goto L3
    L17:
        r101.mExchangePrice = r100.i();
        goto L3
    L18:
        r101.mPrice = r100.i();
        goto L3
    L19:
        r101.mIapProductId = h.c(r100);
        goto L3
    L20:
        r101.mId = r100.j();
        goto L3
    L7:
        h.d(r104, r100);
        goto L3
    L21:
        r100.d(r102);
        r101.getDelegate().setThreadSafe(true);
        return r101;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // am3.c
    public final ChargeDeal decode(g r100) throws Exception {
        return decodeStatic(r100);
    }

    @Override // am3.c
    public /* bridge */ /* synthetic */ ChargeDeal decode(g r100) throws Exception {
        return decode(r100);
    }
}
