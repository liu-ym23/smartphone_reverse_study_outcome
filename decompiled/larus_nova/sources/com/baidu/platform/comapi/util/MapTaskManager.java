package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
public class MapTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f33388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f33389b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f33390c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ExecutorService f33391d = null;

    static {
        f33388a = PThreadExecutorsUtils.newSingleThreadExecutor(new b("Single"));
        f33389b = PThreadExecutorsUtils.newFixedThreadPool(4, new b("FixedPool"));
        f33390c = new Handler(Looper.getMainLooper());
        f33391d = f.a("DefaultPool");
    }

    public MapTaskManager() {
    }

    public static ExecutorService getDefaultThreadPool() {
        return f33391d;
    }

    public static ExecutorService getFixedThreadPool() {
        return f33389b;
    }

    public static ExecutorService getSingleThreadPool() {
        return f33388a;
    }

    public static void postToMainThread(Runnable r100, long r101) {
        f33390c.postDelayed(r100, r101);
    }
}
