package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.order.Order;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PayService f90312a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public j(PayService r100) {
        Intrinsics.checkNotNullParameter(r100, "payService");
        this.f90312a = r100;
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r100) {
        Intrinsics.checkNotNullParameter(r100, "order");
        r100.b(this);
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "handle");
        this.f90312a.a(r100.o(), r100.a(), new com.bytedance.android.live.recharge.utils.h(r101), 0);
    }
}
