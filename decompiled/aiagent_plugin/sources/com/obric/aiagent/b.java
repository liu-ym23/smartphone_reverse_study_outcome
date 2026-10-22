package com.obric.aiagent;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: LaunchBoostExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadFactory f16390b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f16391c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f16392d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f16393e = 0;
    private static final ThreadPoolExecutor f = null;

    /* JADX INFO: compiled from: LaunchBoostExecutor.kt */
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f16394a;

        a() {
            this.f16394a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r7) {
            Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
            o.e(r2, DownloadFileUtils.MODE_READ);
            return new Thread(new ThreadGroup("aiagent_a"), r2, "aiagent_a_launch" + this.f16394a.getAndIncrement(), 0);
        }
    }

    private b() {
    }

    static {
        f16389a = new b();
        ThreadFactory r10 = (ThreadFactory) ZeusTransformUtils.preCheckCast(new a(), ThreadFactory.class, "com.obric.aiagent.plugin");
        f16390b = r10;
        int r0 = Runtime.getRuntime().availableProcessors();
        f16391c = r0;
        int r4 = r0 + 1;
        f16392d = r4;
        int r5 = (r0 * 2) + 1;
        f16393e = r5;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(r4, r5, 5, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), r10);
        r1.allowCoreThreadTimeOut(true);
        f = r1;
    }

    public final ThreadPoolExecutor a() {
        return f;
    }
}
