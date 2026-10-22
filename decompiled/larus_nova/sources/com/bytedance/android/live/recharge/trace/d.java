package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.recharge.order.Order;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Order f90387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.recharge.trace.session.a f90388b;

    public d(Order r100, com.bytedance.android.live.recharge.trace.session.a r101) {
        this.f90387a = r100;
        this.f90388b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Order.State r101 = (Order.State) r100;
        Order.State r102 = (Order.State) this.f90387a.getState().f90981b;
        int r103 = c.f90386a[r102.ordinal()];
        if (r103 != 1) goto L5;
        this.f90388b.c(com.bytedance.android.live.recharge.trace.session.d.f90406e);
        return;
    L5:
        if (r103 != 2) goto L7;
        this.f90388b.c(com.bytedance.android.live.recharge.trace.session.d.f90407f);
        return;
    L7:
        if (r103 != 3) goto L15;
        this.f90388b.c(com.bytedance.android.live.recharge.trace.session.d.f90408g);
        return;
    }
}
