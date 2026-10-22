package com.bytedance.android.annie.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f40052a = null;

    static {
        f40052a = LazyKt.lazy(ThreadUtils$mainThreadHandler$2.INSTANCE);
    }

    public static final Handler a() {
        return (Handler) f40052a.getValue();
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    @JvmStatic
    public static final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L5;
        a().post(r100);
        return;
    L5:
        r100.run();
    }
}
