package com.bytedance.frameworks.baselib.network.http.i;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AsyncIOTaskManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f8360d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f8361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<b, ScheduledFuture> f8362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<b, Runnable> f8363c;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.i.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: AsyncIOTaskManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncIOTaskManager.java */
    private class RunnableC0190a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f8365b;

        /* synthetic */ RunnableC0190a(a r1, b r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private RunnableC0190a(a r1, b r2) {
            this.f8364a = r1;
            this.f8365b = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L8
            this.f8365b.run();     // Catch: Throwable -> L8
            if (Logger.debug() == false) goto L6;
            Logger.d(a.b(), "Task execute time: " + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L8
        L6:
            if (this.f8365b.b() == true) goto L13;
        L7:
            a.a(this.f8364a).remove(this.f8365b);
            a.b(this.f8364a).remove(this.f8365b);
            return;
        L13:
            return;
        L8:
            th = move-exception;
            Logger.e(a.b(), "thread " + Thread.currentThread().getName() + " exception", th);     // Catch: Throwable -> L14
            if (this.f8365b.b() == false) goto L7;
            return;
        L14:
            th = move-exception;
            if (this.f8365b.b() == true) goto L18;
            a.a(this.f8364a).remove(this.f8365b);
            a.b(this.f8364a).remove(this.f8365b);
        L18:
            throw th;
        }
    }

    static {
    }

    static /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.f8362b;
    }

    static /* synthetic */ String b() {
        return TAG;
    }

    static /* synthetic */ ConcurrentHashMap b(a r0) {
        return r0.f8363c;
    }

    private a() {
        this.f8362b = new ConcurrentHashMap();
        this.f8363c = new ConcurrentHashMap();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new i("ttnet-io"));
        this.f8361a = r0;
        r0.setRemoveOnCancelPolicy(true);
    }

    public static a a() {
        if (f8360d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8360d != null) goto L9;
        f8360d = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f8360d;
    }

    public void a(b r9) {
        if (r9 != null) goto L13;
        return;
    L13:
        RunnableC0190a r7 = new RunnableC0190a(this, r9, null);     // Catch: Throwable -> L10
        if (r9.b() == false) goto L7;
        ScheduledFuture<?> r0 = this.f8361a.scheduleWithFixedDelay(r7, r9.a(), r9.c(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L8:
        this.f8363c.put(r9, r7);     // Catch: Throwable -> L10
        this.f8362b.put(r9, r0);     // Catch: Throwable -> L10
        return;
    L7:
        r0 = this.f8361a.schedule(r7, r9.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.e(TAG, "sendTask failed.", th);
    }

    public void a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L25;
        return;
    L25:
        Iterator<Map.Entry<b, Runnable>> r0 = this.f8363c.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r0.hasNext() == false) goto L12;
        b r1 = (b) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5.equals(r1.d()) == false) goto L8;
        r0.remove();     // Catch: Throwable -> L22
        this.f8361a.remove(r1);     // Catch: Throwable -> L22
        goto L8
    L12:
        Iterator<Map.Entry<b, ScheduledFuture>> r4 = this.f8362b.entrySet().iterator();     // Catch: Throwable -> L22
    L13:
        if (r4.hasNext() == false) goto L37;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5.equals(((b) ZeusTransformUtils.preCheckCast(r2.getKey(), b.class, "com.obric.aiagent.plugin")).d()) == false) goto L13;
        ScheduledFuture r3 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r2.getValue(), ScheduledFuture.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L20;
        r3.cancel(true);     // Catch: Throwable -> L22
    L20:
        r4.remove();     // Catch: Throwable -> L22
        goto L13
    L37:
        return;
    L22:
        th = move-exception;
        Logger.e(TAG, "removeTask failed", th);
    }
}
