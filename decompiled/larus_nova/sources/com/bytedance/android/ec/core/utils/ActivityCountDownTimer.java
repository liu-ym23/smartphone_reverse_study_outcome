package com.bytedance.android.ec.core.utils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ActivityCountDownTimer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45499c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f45501b;

    public static final class a {
        public static ActivityCountDownTimer a() {
            return (ActivityCountDownTimer) ActivityCountDownTimer.f45499c.getValue();
        }
    }

    public ActivityCountDownTimer() {
    }

    public final void c() {
        this.f45500a = 0;
        l1 r100 = this.f45501b;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f45501b = null;
    }

    static {
        f45499c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ActivityCountDownTimer$Companion$instance$2.INSTANCE);
    }

    public static /* synthetic */ void b(ActivityCountDownTimer r100, long r101, long r110, l1.a r111) {
        r100.a(r101, r110, r111, null);
    }

    public final void a(long r100, long r110, l1.a r111, Long r112) {
        Intrinsics.checkNotNullParameter(r111, "listener");
        if (this.f45500a != 0) goto L9;
        c();
        this.f45500a++;
        TimeUnit r101 = TimeUnit.SECONDS;
        long r102 = r101.toMillis(r110 - r100);
        if (r112 == null) goto L7;
        long r103 = r112.longValue();
    L8:
        l1 r104 = new l1(r102, r103, r111);
        this.f45501b = r104;
        r104.d();
        return;
    L7:
        r103 = r101.toMillis(1);
        goto L8
    L9:
        l1 r105 = this.f45501b;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r111 != r105.f45639i) goto L14;
        return;
    L14:
        if (((ArrayList) r105.f45640j).contains(r111) == true) goto L20;
        this.f45500a++;
        ((ArrayList) r105.f45640j).add(r111);
        return;
    }
}
