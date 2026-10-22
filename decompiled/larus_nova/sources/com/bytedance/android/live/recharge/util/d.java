package com.bytedance.android.live.recharge.util;

import android.content.Context;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.live.kmp.core.KmpEnv;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90424a = 0;

    public static boolean a() {
        a r100 = a.f90422i;
        r100.getClass();
        return ((Boolean) a.f90415b.getValue(r100, a.f90414a[0])).booleanValue();
    }

    static {
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        KmpEnv r101 = KmpEnv.f255139a;
        if (KmpEnv.b() == true) goto L6;
        return false;
    L6:
        if (com.bytedance.android.live.incentive.exchange.j.a() == true) goto L8;
        return false;
    L8:
        int r102 = ((IRechargeService) k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo().getGiftPanelType();
        if (PadConfigUtils.a() == false) goto L12;
        return false;
    L12:
        if (r100.getResources().getConfiguration().orientation != 2) goto L14;
        return false;
    L14:
        if (r102 == 1) goto L16;
        return false;
    L16:
        return com.bytedance.android.live.incentive.exchange.j.b();
    }

    public static void c(boolean r100) {
        a r101 = a.f90422i;
        r101.getClass();
        a.f90415b.setValue(r101, a.f90414a[0], Boolean.valueOf(r100));
    }

    public static boolean d(ExchangeInfo r100) {
        if (r100 != null) goto L10;
        IRechargeService r101 = (IRechargeService) k.f(IRechargeService.class);
        if (r101 == null) goto L8;
        zv0.f r102 = r101.rechargeCenter();
        if (r102 == null) goto L8;
        r100 = r102.getExchangeInfo();
    L8:
        r100 = null;
    L10:
        if (r100 == null) goto L14;
        boolean r103 = true;
        if (r100.isFirstExchange() != true) goto L14;
    L15:
        if (r103 == true) goto L18;
        return false;
    L18:
        return com.bytedance.android.live.incentive.exchange.j.b();
    L14:
        r103 = false;
        goto L15
    }
}
