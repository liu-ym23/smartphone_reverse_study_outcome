package com.bytedance.android.live.incentive.exchange.strategy;

import android.content.Context;
import com.bytedance.android.live.incentive.exchange.SaasOldExchangeDialogHelper;
import com.bytedance.android.live.incentive.exchange.l;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.core.f;
import com.bytedance.android.live.recharge.exchange.IAutoExchangeService;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.platform.service.z;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import zv0.e;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f69368a = null;

    public d() {
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void b(c.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    static {
        f69368a = new d();
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean a() {
        IAutoExchangeService r100 = f.a(RechargeServices.b());
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.w0() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean f() {
        IAutoExchangeService r100 = f.a(RechargeServices.b());
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d1() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final boolean d(long r100) {
        IAutoExchangeService r101 = f.a(RechargeServices.b());
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.z1(r100) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.incentive.exchange.strategy.c
    public final void g(l r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        Context r100 = r110.getContext();
        ExchangeType r101 = r110.getType();
        long r102 = r110.f69362c;
        e r103 = r110.f69363d;
        k r104 = r110.f69364e;
        Map<String, String> r111 = r110.f69365f;
        if (r111 != null) goto L5;
        r111 = new LinkedHashMap();
    L5:
        Map<String, String> r105 = r111;
        if (SaasOldExchangeDialogHelper.f69342c == false) goto L8;
        SaasOldExchangeDialogHelper.a(r100, r101, r102, r103, r104);
        return;
    L8:
        RechargeFacadeUtilsKt.a().getClass();
        ww0.a r106 = z.a();
        if (r106 == null) goto L13;
        r106.fo(r100, r101, r104, r102, r105, r103);
        return;
    }
}
