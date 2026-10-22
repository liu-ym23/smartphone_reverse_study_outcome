package com.bytedance.android.shopping.orderlist.common.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonErrorMonitorKt {
    public static final void f(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        r100.invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (ECAppInfoService.f48114e.isLocalTest() == true) goto L10;
        ECExceptionMonitor.e(e);
        return;
    L10:
        throw e;
    }

    public static final <T> T e(T r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return r101.invoke();
    L5:
        e = move-exception;
        if (ECAppInfoService.f48114e.isLocalTest() == true) goto L10;
        ECExceptionMonitor.e(e);
        return r100;
    L10:
        throw e;
    }

    public static /* synthetic */ void b(a r100, String r101, String r102) {
        a(r100, r101, r102, MapsKt.emptyMap());
    }

    public static final void c(a r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "errorTag");
        Intrinsics.checkNotNullParameter(r102, "task");
        int r103 = OrderCommonErrorUtils.f179893a;
        OrderCommonErrorUtils.b(r100, r101, r102, OrderCommonErrorMonitorKt$orderRunCatch$1.INSTANCE);
    }

    public static final void a(a r100, String r101, String r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r103, "params");
        OrderCommonErrorUtils.a(r100, r101, r102, r103);
    }

    public static final void d(a r100, String r101, Function0<Unit> r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "errorTag");
        Intrinsics.checkNotNullParameter(r102, "task");
        Intrinsics.checkNotNullParameter(r103, "errorCatchTask");
        OrderCommonErrorUtils.b(r100, r101, r102, r103);
    }
}
