package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180716b;

    public q() {
        Intrinsics.checkNotNullParameter("updateGoodsDetail", "lynxEventName");
        Intrinsics.checkNotNullParameter("Refresh", "sliceEventName");
        this.f180715a = "Refresh";
        this.f180716b = "updateGoodsDetail";
    }
}
