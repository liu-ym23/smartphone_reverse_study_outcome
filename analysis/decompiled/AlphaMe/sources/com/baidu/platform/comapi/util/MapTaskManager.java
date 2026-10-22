package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class MapTaskManager {

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f9268a = Executors.newSingleThreadExecutor(new b("Single"));

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f9269b = Executors.newFixedThreadPool(4, new b("FixedPool"));

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f9270c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    private static final ExecutorService f9271d = f.a("DefaultPool");

    public static ExecutorService getDefaultThreadPool() {
        return f9271d;
    }

    public static ExecutorService getFixedThreadPool() {
        return f9269b;
    }

    public static ExecutorService getSingleThreadPool() {
        return f9268a;
    }

    public static void postToMainThread(Runnable runnable, long j4) {
        f9270c.postDelayed(runnable, j4);
    }
}
