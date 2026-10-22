package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.live.recharge.platform.service.PayService;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements PayService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Order.a> f90459a;

    public h(com.bytedance.android.live.recharge.order.f.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        this.f90459a = new WeakReference(r100);
        r100.b(PayService.PayProgress.START);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.PayService.a
    public final void a(PayService.b r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Order.a r101 = this.f90459a.get();
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = r100.f90281a;
        if (r102 != 1) goto L8;
        r101.a(r100);
        return;
    L8:
        if (r102 != 2) goto L10;
        r101.cancel(r100);
        return;
    L10:
        if (r102 == 6) goto L12;
        r101.d(r100);
        return;
    L12:
        r101.c(r100);
    }

    @Override // com.bytedance.android.live.recharge.platform.service.PayService.a
    public final void b(PayService.PayProgress r100) {
        Intrinsics.checkNotNullParameter(r100, "progress");
        Order.a r101 = this.f90459a.get();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.b(r100);
    }
}
