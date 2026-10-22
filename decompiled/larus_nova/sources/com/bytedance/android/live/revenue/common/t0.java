package com.bytedance.android.live.revenue.common;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: classes47.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u0 f90994a;

    static {
        u0 r100 = u0.f90999f;
        f90994a = u0.f90999f;
        new u0(500);
    }

    public static final u0 b() {
        Intrinsics.checkNotNullParameter(u0.f91005l, "$this$now");
        i97.a r100 = i97.a.f488802a;
        return new u0(System.currentTimeMillis());
    }

    public static final boolean a(KMutableProperty0<u0> r100, u0 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "minInterval");
        u0 r102 = u0.f90999f;
        u0 r103 = b();
        u0 r104 = r103.b(r100.get());
        r100.set(r103);
        if (r104.a(r101) <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
