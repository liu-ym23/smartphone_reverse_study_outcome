package com.bytedance.android.livesdk.coupon.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class UgCouponNewDialogFrequencyController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f121919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f121920b;

    public UgCouponNewDialogFrequencyController(final int r100, final int r101) {
        this.f121919a = LazyKt.lazy(new UgCouponNewDialogFrequencyController$sp$2(r100, r101));
        this.f121920b = LazyKt.lazy(new UgCouponNewDialogFrequencyController$frequencyController$2(this, r100, r101));
    }
}
