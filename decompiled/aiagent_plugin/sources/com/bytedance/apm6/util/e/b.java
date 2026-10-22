package com.bytedance.apm6.util.e;

import com.bytedance.apm6.util.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AsyncTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<c, b> f5466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f5467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<com.bytedance.apm6.util.e.a, ScheduledFuture> f5468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<com.bytedance.apm6.util.e.a, Runnable> f5469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<com.bytedance.apm6.util.e.a, Runnable> f5470e;

    /* JADX INFO: renamed from: com.bytedance.apm6.util.e.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncTaskManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: AsyncTaskManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.bytedance.apm6.util.e.a f5472b;

        /* synthetic */ a(b r1, com.bytedance.apm6.util.e.a r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private a(b r1, com.bytedance.apm6.util.e.a r2) {
            this.f5471a = r1;
            this.f5472b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.a("APM-Task");
            this.f5472b.run();     // Catch: Throwable -> L5
        L7:
            j.a();
            return;
        L5:
            th = move-exception;
            com.bytedance.apm6.util.c.b.b("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
            goto L7
        }
    }

    static {
        f5466a = new HashMap();
    }

    private b(String r3) {
        this.f5468c = new ConcurrentHashMap();
        this.f5469d = new ConcurrentHashMap();
        this.f5470e = new ConcurrentHashMap();
        this.f5467b = new ScheduledThreadPoolExecutor(1, new d(r3));
    }

    public static synchronized b a(c r3) {
        monitor-enter(b.class);
        if (r3 == null) goto L13;
        b r1 = (b) ZeusTransformUtils.preCheckCast(f5466a.get(r3), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        r1 = new b(r3.name());     // Catch: Throwable -> L10
        f5466a.put(r3, r1);     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);
        return r1;
    L13:
        throw new IllegalArgumentException("AsyncTaskManagerType must be not null!");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void a(com.bytedance.apm6.util.e.a r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        a r7 = new a(this, r9, null);     // Catch: Throwable -> L10
        if (r9.b() == false) goto L7;
        ScheduledFuture<?> r0 = this.f5467b.scheduleWithFixedDelay(r7, r9.a(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f5469d.put(r9, r7);     // Catch: Throwable -> L10
        this.f5468c.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f5467b.schedule(r7, r9.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-AsyncTask", "sendTask failed.", th);
    }

    public void b(com.bytedance.apm6.util.e.a r4) {
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(this.f5469d.remove(r4), Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r1 == null) goto L6;
        this.f5467b.remove(r1);     // Catch: Throwable -> L10
    L6:
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(this.f5468c.remove(r4), ScheduledFuture.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        if (r3 == null) goto L15;
        r3.cancel(true);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-AsyncTask", "removeTask failed", th);
    }
}
