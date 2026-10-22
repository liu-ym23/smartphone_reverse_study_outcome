package com.baidu.platform.comapi.util;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f33424a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f33425b = 0;

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f33424a = r100;
        f33425b = Math.min((r100 * 2) + 1, 8);
    }

    public static ExecutorService a(String r110) {
        int r100 = f33425b;
        TimeUnit r101 = TimeUnit.MILLISECONDS;
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(r100, r100, 60, r101, new LinkedBlockingQueue(), new b(r110));
        r102.setKeepAliveTime(60, r101);     // Catch: Exception -> L5
        r102.allowCoreThreadTimeOut(true);     // Catch: Exception -> L5
    L4:
        return r102;
    }
}
