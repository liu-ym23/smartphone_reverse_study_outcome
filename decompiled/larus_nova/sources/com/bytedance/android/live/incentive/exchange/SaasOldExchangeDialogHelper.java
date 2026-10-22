package com.bytedance.android.live.incentive.exchange;

import android.content.Context;
import com.bytedance.android.live.recharge.exchange.saas.CashExchangeDialog;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class SaasOldExchangeDialogHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wh6.a f69340a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<CashExchangeDialog> f69341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f69342c = false;

    static {
        wh6.a r100 = (wh6.a) vh6.c.b(wh6.a.class);
        f69340a = r100;
        f69342c = !r100.Wb();
    }

    public static void a(final Context r100, final ExchangeType r101, final long r110, final zv0.e r111, final py.k r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r111, "listener");
        Function0<Unit> r102 = new SaasOldExchangeDialogHelper$showExchangeDialog$1(r110, r111, r100, r101, r112);
        Intrinsics.checkNotNullParameter(r102, "action");
        com.bytedance.live.kmp.util.f.a(r102);
    }
}
