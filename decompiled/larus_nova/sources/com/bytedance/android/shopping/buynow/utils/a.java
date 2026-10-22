package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.model.order.IOrderSchema;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(String r100, final IOrderSchema r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        com.bytedance.android.ec.core.monitor.param.a r102 = ECParamTrackerCenter.c(r100);
        if (r102 == null) goto L6;
        r102.b(new APTReportHelper$onBuyNowEnterPage$1(r101));
        return;
    }
}
