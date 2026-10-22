package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AndroidYaTaInstance f179851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c f179852c;

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        OrderCommonErrorMonitorKt.c(this.f179850a.E0(), "OrderCommonUseBridgeFunction-doExecuteASync", new OrderCommonUseBridgeFunction$onExecuteAsync$1(this, r100, r101));
    }

    public y(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r100, AndroidYaTaInstance r101, com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c r102) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r102, "bridgeLynxComponent");
        this.f179850a = r100;
        this.f179851b = r101;
        this.f179852c = r102;
    }
}
