package com.bytedance.android.shopping.orderlist.common.monitor.firstscreen;

import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonFirstScreenMonitorKt {
    public static final void a(final String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "task");
        final long r102 = System.currentTimeMillis();
        r101.invoke();
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderCommonFirstScreenMonitor", new OrderCommonFirstScreenMonitorKt$logDuration$1(r100, r102));
    }
}
