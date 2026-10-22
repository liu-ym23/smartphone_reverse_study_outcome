package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.controller.OrderBottomBarHandler;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OrderBottomBarHandler f179784b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        OrderCommonErrorMonitorKt.c(this.f179783a.E0(), "OrderSelfCloseBottomBarFunction-doExecuteSync", new OrderSelfCloseBottomBarFunction$onExecuteSync$1(this));
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }

    public b0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r100, OrderBottomBarHandler r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f179783a = r100;
        this.f179784b = r101;
    }
}
