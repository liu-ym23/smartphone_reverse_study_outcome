package com.bytedance.android.live.recharge.platform.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class z implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.core.a f90337a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static ww0.a a() {
        return (ww0.a) ((dy0.d) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ww0.a.class));
    }

    public final com.bytedance.android.live.recharge.core.b f() {
        com.bytedance.android.live.recharge.core.g r100 = this.f90337a.f89682a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_rechargeScope");
    L5:
        return r100;
    }

    public final com.bytedance.android.live.wallet.pay.iap.a g() {
        com.bytedance.android.live.recharge.core.b r100 = f();
        Object r101 = com.bytedance.android.scope.m.f163449e.d(r100, com.bytedance.android.live.wallet.pay.iap.a.class);
        Intrinsics.checkNotNull(r101);
        return (com.bytedance.android.live.wallet.pay.iap.a) ((com.bytedance.android.live.recharge.core.c) r101);
    }

    public z(com.bytedance.android.live.recharge.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "rechargeLoaderService");
        this.f90337a = r100;
    }
}
