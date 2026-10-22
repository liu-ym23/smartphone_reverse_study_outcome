package com.bytedance.android.ec.opt.asynctask;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class TaskExecutor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f48029e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f48030f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f48031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f48032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f48033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, ThreadPoolExecutor> f48034d;

    public static final class a {
        public a() {
        }

        public static TaskExecutor a() {
            return (TaskExecutor) TaskExecutor.f48029e.getValue();
        }
    }

    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f48035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48036b;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f48035a);
            r101.setDaemon(false);
            ThreadMethodProxy.setPriority(r101, this.f48036b);
            return r101;
        }

        public b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f48035a = r100;
            this.f48036b = r101;
        }
    }

    public static final class c implements RejectedExecutionHandler {
        public c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            Intrinsics.checkNotNullParameter(r100, "r");
            Intrinsics.checkNotNullParameter(r101, "executor");
            System.out.println("Django: AsyncTaskManager: rejected: " + r100);
            new Handler(Looper.getMainLooper()).post(r100);
        }
    }

    static {
        f48030f = new a();
        f48029e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TaskExecutor$Companion$INSTANCE$2.INSTANCE);
    }

    public TaskExecutor() {
        this.f48031a = new m(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new b("django_bg", 1));
        TimeUnit r100 = TimeUnit.SECONDS;
        this.f48032b = new m(2, 2, 60, r100, new LinkedBlockingQueue(), new b("django_common", 5));
        this.f48033c = new m(0, Integer.MAX_VALUE, r100, new SynchronousQueue(), new b("django_urgent_heavy", 10), new c());
        this.f48034d = new LinkedHashMap();
    }

    public final void a(String r100, w r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r110, "task");
        if (this.f48034d.containsKey(r100) == true) goto L5;
        m r101 = new m(1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b("django_high_freq", 10), new c());
        this.f48034d.put(r100, r101);
    L5:
        ThreadPoolExecutor r102 = (ThreadPoolExecutor) ((LinkedHashMap) this.f48034d).get(r100);
        if (r102 == null) goto L9;
        r102.execute(r110);
        return;
    }

    public final void b(String r100, w r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "task");
        ThreadPoolExecutor r102 = (ThreadPoolExecutor) ((LinkedHashMap) this.f48034d).get(r100);
        if (r102 == null) goto L5;
        boolean r103 = r102.remove(r101);
    L6:
        System.out.println("Django: AsyncTaskManager: remove: " + r103);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
