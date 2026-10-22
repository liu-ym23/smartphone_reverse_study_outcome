package com.bytedance.android.btm.impl.thread;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42481a = null;

    public static Handler a() {
        return (Handler) f42481a.getValue();
    }

    static {
        f42481a = LazyKt.lazy(ThreadUtils$mainHandler$2.INSTANCE);
    }

    public static boolean b() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }
}
