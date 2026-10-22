package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.live.kmp.core.KmpEnv;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90456a = 0;

    public static boolean d() {
        ExchangeInfo r100 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo();
        if (com.bytedance.android.live.recharge.util.e.a() != 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.getHideCombineExchange() == true) goto L7;
        return true;
    }

    public static boolean c() {
        if (ay0.c.a() == 0) goto L5;
        return true;
    L5:
        if (ay0.c.b() == 0) goto L7;
        return true;
    L7:
        if (ay0.c.c() == 0) goto L10;
        return true;
    L10:
        if (j.b() != 1) goto L12;
        return true;
    L12:
        if (j.b() == 2) goto L20;
        return false;
    L20:
        return true;
    }

    static {
    }

    public static IExchangeService.ExchangeApiType b(com.bytedance.android.live.recharge.deal.f r100) {
        Intrinsics.checkNotNullParameter(r100, "deal");
        KmpEnv r101 = KmpEnv.f255139a;
        if (KmpEnv.c() == false) goto L7;
        return IExchangeService.ExchangeApiType.HUOSHAN_FLAME;
    L7:
        if (((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getHideCombineExchange() == false) goto L9;
    L15:
        boolean r102 = false;
    L16:
        if (r102 == false) goto L19;
        return IExchangeService.ExchangeApiType.GOLD_BALANCE;
    L19:
        return IExchangeService.ExchangeApiType.CASH;
    L9:
        if (com.bytedance.android.live.recharge.util.e.a() == 0) goto L15;
        if (com.bytedance.android.live.recharge.deal.g.a(r100) == 0) goto L13;
    L14:
        r102 = true;
        goto L16
    L13:
        if (com.bytedance.android.live.recharge.deal.g.b(r100) == 0) goto L15;
        goto L14
    }

    public static JSONObject a(int r100, int r101) {
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L6;
        JSONObject r102 = new JSONObject();
        r102.put("income", r100);
        r102.put("gold", r101);
        return r102;
    L6:
        if (r100 > 0) goto L13;
        if (r101 <= 0) goto L11;
        return new JSONObject().put("gold", r101);
    L11:
        return new JSONObject();
    L13:
        return new JSONObject().put("income", r100);
    }
}
