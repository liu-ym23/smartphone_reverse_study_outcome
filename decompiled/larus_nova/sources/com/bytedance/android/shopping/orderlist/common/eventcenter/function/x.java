package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class x extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179849a;

    public x(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f179849a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        OrderCommonErrorMonitorKt.c(this.f179849a.E0(), "OrderCommonUpdateRawDataFunction-doExecuteSync", new OrderCommonUpdateRawParamsFunction$onExecuteSync$1(this, r100));
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
