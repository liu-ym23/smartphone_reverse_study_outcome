package com.bytedance.android.shopping.orderlist.common.repo;

import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.n;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.orderlist.common.monitor.error.a f179945a;

    public a(com.bytedance.android.shopping.orderlist.common.monitor.error.a r100) {
        this.f179945a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        OrderCommonErrorMonitorKt.b(this.f179945a, "API_NET_ERROR", "OrderCommonRepository-firstQuery: " + ((Throwable) r100).getMessage());
        n.a("网络异常", false, false);
    }
}
