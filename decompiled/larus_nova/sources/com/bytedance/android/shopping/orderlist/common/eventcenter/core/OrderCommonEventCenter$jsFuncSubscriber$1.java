package com.bytedance.android.shopping.orderlist.common.eventcenter.core;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonEventCenter$jsFuncSubscriber$1 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderCommonEventCenter f179770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f179771b;

    @Override // ti.j
    public final void a(final JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        OrderCommonErrorMonitorKt.c(this.f179770a.f179769g.E0(), "OrderCommonEventCenter-" + this.f179771b + "-onReceiveJsEvent", new OrderCommonEventCenter$jsFuncSubscriber$1$onReceiveJsEvent$1(this, r100));
    }

    public OrderCommonEventCenter$jsFuncSubscriber$1(OrderCommonEventCenter r100, String r101) {
        this.f179770a = r100;
        this.f179771b = r101;
    }
}
