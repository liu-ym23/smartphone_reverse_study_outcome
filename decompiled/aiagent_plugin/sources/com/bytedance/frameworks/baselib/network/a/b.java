package com.bytedance.frameworks.baselib.network.a;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: NetworkAsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final String TAG = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<c, b> f7957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<com.bytedance.frameworks.baselib.network.a.a, ScheduledFuture> f7958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<com.bytedance.frameworks.baselib.network.a.a, Runnable> f7959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f7960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f7961e;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.a.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: NetworkAsyncTaskManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: NetworkAsyncTaskManager.java */
    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.frameworks.baselib.network.a.a f7962a;

        /* synthetic */ a(com.bytedance.frameworks.baselib.network.a.a r1, AnonymousClass1 r2) {
            this(r1);
        }

        private a(com.bytedance.frameworks.baselib.network.a.a r1) {
            this.f7962a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f7962a.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(b.c(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f7962a.isLoop() == true) goto L13;
        L7:
            b.a(this.f7962a.getTaskType()).a().remove(this.f7962a);
            b.a(this.f7962a.getTaskType()).b().remove(this.f7962a);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(b.c(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f7962a.isLoop() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f7962a.isLoop() == true) goto L18;
            b.a(this.f7962a.getTaskType()).a().remove(this.f7962a);
            b.a(this.f7962a.getTaskType()).b().remove(this.f7962a);
        L18:
            throw th;
        }
    }

    static /* synthetic */ String c() {
        return TAG;
    }

    static {
        f7957a = new ConcurrentHashMap();
    }

    public static b a(c r3) {
        if (r3 == null) goto L18;
        ConcurrentHashMap<c, b> r1 = f7957a;
        if (r1.get(r3) != null) goto L16;
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r1.get(r3) != null) goto L10;
        r1.put(r3, new b(r3));     // Catch: Throwable -> L12
    L10:
        monitor-exit(b.class);     // Catch: Throwable -> L12
    L16:
        return (b) ZeusTransformUtils.preCheckCast(r1.get(r3), b.class, "com.obric.aiagent.plugin");
    L18:
        throw new IllegalArgumentException("unsupported async task type");
    }

    private b(c r3) {
        this.f7958b = new ConcurrentHashMap();
        this.f7959c = new ConcurrentHashMap();
        this.f7960d = r3;
        this.f7961e = new ScheduledThreadPoolExecutor(1, new d(r3.name()));
    }

    public ConcurrentHashMap<?, ?> a() {
        return this.f7959c;
    }

    public ConcurrentHashMap<?, ?> b() {
        return this.f7958b;
    }

    public void a(com.bytedance.frameworks.baselib.network.a.a r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setTaskType(this.f7960d);
        a r0 = new a(r9, null);     // Catch: Throwable -> L11
        if (r9.isLoop() == false) goto L8;
        ScheduledFuture<?> r1 = this.f7961e.scheduleWithFixedDelay(r0, r9.getInitialDelay(), r9.getLoopInterval(), r9.getTimeUnit());     // Catch: Throwable -> L11
    L9:
        this.f7959c.put(r9, r0);     // Catch: Throwable -> L11
        this.f7958b.put(r9, r1);     // Catch: Throwable -> L11
        return;
    L8:
        r1 = this.f7961e.schedule(r0, r9.getInitialDelay(), r9.getTimeUnit());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    public void b(com.bytedance.frameworks.baselib.network.a.a r4) {
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.f7959c.remove(r4), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 == null) goto L6;
        this.f7961e.remove(r1);     // Catch: Throwable -> L10
    L6:
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.f7958b.remove(r4), ScheduledFuture.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L15;
        r3.cancel(true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
