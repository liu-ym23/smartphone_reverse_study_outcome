package com.bytedance.android.chunkstreamprediction.network;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ChunkStreamDefaultThreadExecutor extends PThreadPoolExecutor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<ChunkStreamDefaultThreadExecutor> f42515d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42516e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f42517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f42518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f42519c;

    public static final class a {
    }

    static {
        f42515d = LazyKt.lazy(ChunkStreamDefaultThreadExecutor$Companion$instance$2.INSTANCE);
        f42516e = Runtime.getRuntime().availableProcessors() + 1;
    }

    public ChunkStreamDefaultThreadExecutor() {
        int r100 = f42516e;
        super(r100, r100, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ChunkStreamDefaultThreadExecutor"));
        SecurityManager r101 = System.getSecurityManager();
        if (r101 == null) goto L5;
        ThreadGroup r102 = r101.getThreadGroup();
    L6:
        this.f42517a = r102;
        this.f42518b = new AtomicInteger(1);
        this.f42519c = "chunkstream-pool-thread-";
        setThreadFactory(new f(this));
        return;
    L5:
        r102 = ThreadMethodProxy.currentThread().getThreadGroup();
        goto L6
    }
}
