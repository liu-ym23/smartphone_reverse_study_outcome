package com.bytedance.android.ec.core.buynow;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f43910a = null;

    static {
        f43910a = new a();
    }

    public a() {
    }

    public static void a() {
        if (BuyNowPerformanceOpt.f43905a != null) goto L6;
        BuyNowPerformanceOpt.f43905a = Boolean.TRUE;
    L6:
        if (BuyNowPerformanceOpt.q() == false) goto L9;
        qh.a.a();
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_buy_now_template_preload");
        BuyNowPerformanceOpt.r(BuyNowBizCode.BUY);
        BuyNowPerformanceOpt.r(BuyNowBizCode.YATA_SKUBUY);
    L9:
        if (BuyNowPerformanceOpt.q() == false) goto L11;
        int r100 = com.bytedance.android.ec.core.opt.a.f45200a;
    L11:
        Map r101 = BuyNowPerformanceOpt.g();
        if (r101 == null) goto L14;
        Object r102 = r101.get("buy_now_preconnect_url");
    L16:
        if (Intrinsics.areEqual(r102, 1) == true) goto L18;
        return;
    L18:
        if (BuyNowPerformanceOpt.k() == false) goto L20;
        String r103 = "https://ec5-core.ecombdapi.com/";
    L29:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        TTNetInit.preconnectUrl(r103);     // Catch: Throwable -> L23
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L32;
        ECExceptionMonitor.e(r106);
        return;
    L32:
        return;
    L23:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L20:
        r103 = OrderCommonApi.API_HOST;
        goto L29
    L14:
        r102 = null;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
