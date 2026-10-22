package com.amap.api.col.s;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public class an {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile an f26045c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BlockingQueue<Runnable> f26046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExecutorService f26047b;

    public static an a() {
        if (f26045c != null) goto L15;
        monitor-enter(an.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26045c != null) goto L9;
        f26045c = new an();     // Catch: Throwable -> L11
    L9:
        monitor-exit(an.class);     // Catch: Throwable -> L11
    L15:
        return f26045c;
    }

    public static void b() {
        if (f26045c != null) goto L5;
        return;
    L5:
        monitor-enter(an.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f26045c == null) goto L9;
        f26045c.f26047b.shutdownNow();     // Catch: Throwable -> L11
        f26045c.f26047b = null;     // Catch: Throwable -> L11
        f26045c = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(an.class);     // Catch: Throwable -> L11
    }

    private an() {
        this.f26046a = new LinkedBlockingQueue();
        this.f26047b = null;
        int r100 = Runtime.getRuntime().availableProcessors();
        int r101 = r100 * 2;
        this.f26047b = new PThreadPoolExecutor(r100, r101, 1, TimeUnit.SECONDS, this.f26046a, new DefaultThreadFactory("/api/col/s/an"), new ThreadPoolExecutor.AbortPolicy());
    }

    public final void a(Runnable r100) {
        ExecutorService r101 = this.f26047b;
        if (r101 == null) goto L6;
        r101.execute(r100);
        return;
    }
}
