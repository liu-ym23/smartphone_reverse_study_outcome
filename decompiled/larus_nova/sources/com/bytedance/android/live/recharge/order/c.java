package com.bytedance.android.live.recharge.order;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f90082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.service.j f90083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.service.c f90084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.service.a f90085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.service.n f90086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.service.o f90087f;

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        a r100 = this.f90082a;
        Intrinsics.checkNotNullParameter(r100, "service");
        BusinessType r101 = BusinessType.Generic;
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "businessType");
        com.bytedance.android.live.recharge.platform.service.c r102 = this.f90084c;
        if (r102 == null) goto L5;
        r100.N(r102, r101);
    L5:
        com.bytedance.android.live.recharge.platform.service.a r103 = this.f90085d;
        if (r103 == null) goto L8;
        r100.N(r103, r101);
    L8:
        com.bytedance.android.live.recharge.platform.service.n r104 = this.f90086e;
        if (r104 == null) goto L11;
        r100.N(r104, r101);
    L11:
        com.bytedance.android.live.recharge.platform.service.j r105 = this.f90083b;
        if (r105 == null) goto L14;
        r100.N(r105, r101);
    L14:
        BusinessType r106 = BusinessType.ExchangeOnly;
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r106, "businessType");
        com.bytedance.android.live.recharge.platform.service.o r107 = this.f90087f;
        if (r107 == null) goto L18;
        r100.N(r107, r106);
        return;
    }

    public c(a r100, com.bytedance.android.live.recharge.platform.service.j r101, com.bytedance.android.live.recharge.platform.service.c r102, com.bytedance.android.live.recharge.platform.service.a r103, com.bytedance.android.live.recharge.platform.service.n r104, com.bytedance.android.live.recharge.platform.service.o r105) {
        Intrinsics.checkNotNullParameter(r100, "orderService");
        Intrinsics.checkNotNullParameter(r101, "defaultPayProcessor");
        Intrinsics.checkNotNullParameter(r102, "interceptProcessor");
        Intrinsics.checkNotNullParameter(r103, "bizExtraProcessor");
        this.f90082a = r100;
        this.f90083b = r101;
        this.f90084c = r102;
        this.f90085d = r103;
        this.f90086e = r104;
        this.f90087f = r105;
    }
}
