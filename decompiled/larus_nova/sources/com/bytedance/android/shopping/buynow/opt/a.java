package com.bytedance.android.shopping.buynow.opt;

import android.content.Context;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f171027a = 0;

    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (BuyNowPerformanceOpt.q() == false) goto L6;
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).a().c(R.layout.buynow_layout_counter, 1, "步进器").c(R.layout.buynow_layout_marquee_content, 2, "跑马灯").c(R.layout.buynow_layout_countdown, 1, "倒计时").commit();
        return;
    }
}
