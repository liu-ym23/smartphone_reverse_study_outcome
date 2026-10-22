package com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown;

import android.os.SystemClock;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f182058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityCountDownTimer f182059b;

    public static final class a {
    }

    static {
    }

    public b(ActivityCountDownTimer r100) {
        Intrinsics.checkNotNullParameter(r100, "activityTimer");
        this.f182059b = r100;
    }

    public final void a(long r100, com.bytedance.android.shopping.prepurchase.business.pdp.services.countdown.a r110, long r111) {
        this.f182059b.a((SystemClock.elapsedRealtime() / 1000) + this.f182058a, r100, r110, Long.valueOf(r111));
    }
}
