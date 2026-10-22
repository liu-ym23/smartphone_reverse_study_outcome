package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179811a;

    public static final class a {
    }

    static {
    }

    public h(com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f179811a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        OrderCommonErrorMonitorKt.c(this.f179811a.E0(), "OrderCommonOpenMaskLayerFunction-doexecuteSync", new OrderCommonOpenMaskLayerFunction$onExecuteSync$1(this));
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
