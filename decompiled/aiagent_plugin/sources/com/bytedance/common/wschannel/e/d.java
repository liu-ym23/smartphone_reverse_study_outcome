package com.bytedance.common.wschannel.e;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: WsAsyncIOTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String TAG = "d";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static d f6944d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f6945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<e, ScheduledFuture> f6946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<e, Runnable> f6947c;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.e.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: WsAsyncIOTaskManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: WsAsyncIOTaskManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f6949b;

        /* synthetic */ a(d r1, e r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private a(d r1, e r2) {
            this.f6948a = r1;
            this.f6949b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f6949b.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(d.b(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f6949b.b() == true) goto L13;
        L7:
            d.a(this.f6948a).remove(this.f6949b);
            d.b(this.f6948a).remove(this.f6949b);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(d.b(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f6949b.b() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f6949b.b() == true) goto L18;
            d.a(this.f6948a).remove(this.f6949b);
            d.b(this.f6948a).remove(this.f6949b);
        L18:
            throw th;
        }
    }

    static {
    }

    static /* synthetic */ ConcurrentHashMap a(d r0) {
        return r0.f6946b;
    }

    static /* synthetic */ String b() {
        return TAG;
    }

    static /* synthetic */ ConcurrentHashMap b(d r0) {
        return r0.f6947c;
    }

    private d() {
        this.f6946b = new ConcurrentHashMap();
        this.f6947c = new ConcurrentHashMap();
        this.f6945a = new ScheduledThreadPoolExecutor(1, new f("frontier"));
    }

    public static d a() {
        if (f6944d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6944d != null) goto L9;
        f6944d = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f6944d;
    }

    public void a(e r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        a r7 = new a(this, r9, null);     // Catch: Throwable -> L10
        if (r9.b() == false) goto L7;
        ScheduledFuture<?> r0 = this.f6945a.scheduleWithFixedDelay(r7, r9.a(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f6947c.put(r9, r7);     // Catch: Throwable -> L10
        this.f6946b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f6945a.schedule(r7, r9.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(TAG, "sendTask failed.", th);
    }
}
