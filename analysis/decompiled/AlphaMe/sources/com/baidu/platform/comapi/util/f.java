package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int f9304a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f9305b;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f9304a = iAvailableProcessors;
        f9305b = Math.min((iAvailableProcessors * 2) + 1, 8);
    }

    public static ExecutorService a(String str) {
        int i4 = f9305b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 60L, timeUnit, new LinkedBlockingQueue(), new b(str));
        try {
            threadPoolExecutor.setKeepAliveTime(60L, timeUnit);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception unused) {
        }
        return threadPoolExecutor;
    }
}
