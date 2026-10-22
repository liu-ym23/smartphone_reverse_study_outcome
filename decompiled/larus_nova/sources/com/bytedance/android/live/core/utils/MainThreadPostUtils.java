package com.bytedance.android.live.core.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class MainThreadPostUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f66070a = null;

    static {
        f66070a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MainThreadPostUtils$sHandler$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final void b(Runnable r100) {
        if (r100 == null) goto L5;
        ((Handler) f66070a.getValue()).post(r100);
        return;
    }

    @JvmStatic
    public static final void d(Runnable r100) {
        if (r100 == null) goto L5;
        ((Handler) f66070a.getValue()).removeCallbacks(r100);
        return;
    }

    @JvmStatic
    public static final void e(Runnable r100) {
        if (a() == false) goto L5;
        r100.run();
        return;
    L5:
        b(r100);
    }

    @JvmStatic
    public static final void c(Runnable r100, long r101) {
        if (r100 == null) goto L5;
        ((Handler) f66070a.getValue()).postDelayed(r100, r101);
        return;
    }
}
