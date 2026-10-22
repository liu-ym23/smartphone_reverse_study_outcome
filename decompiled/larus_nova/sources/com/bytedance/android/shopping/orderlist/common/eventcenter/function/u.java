package com.bytedance.android.shopping.orderlist.common.eventcenter.function;

import android.app.Activity;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f179844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.eventcenter.core.a f179845b;

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(final com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        OrderCommonErrorMonitorKt.c(this.f179845b.E0(), "OrderCommonSetStatusBarFunction-doExecuteSync", new OrderCommonSetStatusBarFunction$onExecuteSync$1(this, r100));
        int r101 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }

    public u(Activity r100, com.bytedance.android.shopping.orderlist.common.eventcenter.core.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.f179844a = r100;
        this.f179845b = r101;
    }
}
