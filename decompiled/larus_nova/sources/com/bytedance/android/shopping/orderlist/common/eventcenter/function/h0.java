package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h0 extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179812a;

    public static final class a {
    }

    static {
    }

    public h0(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f179812a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        OrderCommonErrorMonitorKt.c(this.f179812a.E0(), "OrderSelfUnregisterBridgeFunction-onExecuteAsync", new OrderSelfUnregisterBridgeFunction$onExecuteAsync$1(this, r100, r101));
    }
}
