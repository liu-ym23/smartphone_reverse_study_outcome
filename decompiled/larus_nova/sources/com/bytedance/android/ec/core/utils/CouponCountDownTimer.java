package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class CouponCountDownTimer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45511c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f45513b;

    public static final class a {
        public static CouponCountDownTimer a() {
            return (CouponCountDownTimer) CouponCountDownTimer.f45511c.getValue();
        }
    }

    public CouponCountDownTimer() {
    }

    public final void b() {
        this.f45512a = 0;
        l1 r100 = this.f45513b;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f45513b = null;
        dm.a.a("CouponCountDownTimer").a("stopCountDown");
    }

    static {
        f45511c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CouponCountDownTimer$Companion$instance$2.INSTANCE);
    }

    public final void a(long r100, long r110, l1.a r111, long r112) {
        Intrinsics.checkNotNullParameter(r111, "listener");
        if (this.f45512a != 0) goto L5;
        b();
        this.f45512a++;
        l1 r101 = new l1(TimeUnit.SECONDS.toMillis(r110 - r100), r112, r111);
        this.f45513b = r101;
        r101.d();
    L12:
        dm.a.a("CouponCountDownTimer").a("startCountDown");
        return;
    L5:
        l1 r102 = this.f45513b;
        if (r102 == null) goto L12;
        if (r111 == r102.f45639i) goto L12;
        if (((ArrayList) r102.f45640j).contains(r111) == true) goto L12;
        this.f45512a++;
        ((ArrayList) r102.f45640j).add(r111);
        goto L12
    }
}
