package com.bytedance.android.ec.common.impl.sku.utils;

import com.bytedance.android.ec.core.utils.l1;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ActivityCountDownTimer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f43347c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l1 f43349b;

    public static final class a {
        public static ActivityCountDownTimer a() {
            return (ActivityCountDownTimer) ActivityCountDownTimer.f43347c.getValue();
        }
    }

    public ActivityCountDownTimer() {
    }

    public final void b() {
        this.f43348a = 0;
        l1 r100 = this.f43349b;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f43349b = null;
    }

    static {
        f43347c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ActivityCountDownTimer$Companion$instance$2.INSTANCE);
    }

    public final void a(long r100, long r110, l1.a r111) {
        Intrinsics.checkNotNullParameter(r111, "listener");
        if (this.f43348a != 0) goto L5;
        b();
        this.f43348a++;
        TimeUnit r101 = TimeUnit.SECONDS;
        l1 r102 = new l1(r101.toMillis(r110 - r100), r101.toMillis(1), r111);
        this.f43349b = r102;
        r102.d();
        return;
    L5:
        l1 r103 = this.f43349b;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r111 != r103.f45639i) goto L10;
        return;
    L10:
        if (((ArrayList) r103.f45640j).contains(r111) == true) goto L16;
        this.f43348a++;
        ((ArrayList) r103.f45640j).add(r111);
        return;
    }
}
