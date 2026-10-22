package com.amap.api.mapcore.util;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.map.api.monitor.MapMonitorConst;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public abstract class x8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f28339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f28340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<a9, Future<?>> f28341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a9.a f28342d;

    public class a implements a9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x8 f28343a;

        public a(x8 r100) {
            this.f28343a = r100;
        }

        public final void a(a9 r100) {
            if ((r100 instanceof b) == false) goto L6;
            b r101 = (b) r100;
            r101.b();
            n0.a("AMapThreadPool", "[" + this.f28343a.f28340b + "] Task started executing | task=" + r101.f(), false);
            return;
        L6:
            n0.a("AMapThreadPool", "[" + this.f28343a.f28340b + "] Task started executing | task=" + r100.getClass().getSimpleName(), false);
        }

        public final void b(a9 r110) {
        L10:
            th = move-exception;
            this.f28343a.a(x8.a(r110), false);
            throw th;
        L5:
            if ((r110 instanceof b) == false) goto L7;
            long r100 = ((b) r110).c();     // Catch: Throwable -> L10
            String r101 = ((b) r110).f();     // Catch: Throwable -> L10
            n0.a("AMapThreadPool", "[" + this.f28343a.f28340b + "] Task finished | task=" + r101 + " | waitTime=" + (((b) r110).e() - ((b) r110).d()) + "ms | executeTime=" + r100 + "ms", false);     // Catch: Throwable -> L10
        L8:
            this.f28343a.a(x8.a(r110), false);
            x8.a(this.f28343a, "Task completed (" + r101 + ")");
            return;
        L7:
            r101 = r110.getClass().getSimpleName();     // Catch: Throwable -> L10
            n0.a("AMapThreadPool", "[" + this.f28343a.f28340b + "] Task finished | task=" + r101, false);     // Catch: Throwable -> L10
            goto L8
        }

        public final void c(a9 r100) {
        L11:
            th = move-exception;
            this.f28343a.a(x8.a(r100), true);
            throw th;
        L4:
            if ((r100 instanceof b) == false) goto L6;
            String r101 = ((b) r100).f();     // Catch: Throwable -> L11
        L8:
            n0.a("AMapThreadPool", "[" + this.f28343a.f28340b + "] Task cancelled | task=" + r101, false);     // Catch: Throwable -> L11
            this.f28343a.a(x8.a(r100), true);
            x8.a(this.f28343a, "Task cancelled (" + r101 + ")");
            return;
        L6:
            r101 = r100.getClass().getSimpleName();     // Catch: Throwable -> L11
            goto L8
        }
    }

    public static class b extends a9 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a9 f28344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f28345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f28346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f28347e;

        public final String f() {
            return this.f28344b.getClass().getSimpleName();
        }

        public final int hashCode() {
            return this.f28344b.hashCode();
        }

        @Override // com.amap.api.mapcore.util.a9
        public final void onTaskCancelled() {
            this.f28344b.h();
        }

        @Override // com.amap.api.mapcore.util.a9
        public final void runTask() {
            this.f28344b.runTask();
        }

        public final String toString() {
            return this.f28344b.toString();
        }

        public final void a() {
            this.f28345c = System.currentTimeMillis();
        }

        public final void b() {
            this.f28346d = System.currentTimeMillis();
        }

        public final long c() {
            long r100 = System.currentTimeMillis();
            this.f28347e = r100;
            return r100 - this.f28346d;
        }

        public final long d() {
            return this.f28345c;
        }

        public final long e() {
            return this.f28346d;
        }

        public final a9 g() {
            return this.f28344b;
        }

        public b(a9 r100) {
            this.f28344b = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == false) goto L7;
            return this.f28344b.equals(((b) r100).f28344b);
        L7:
            return this.f28344b.equals(r100);
        }

        @Override // com.amap.api.mapcore.util.a9
        public final void onTaskException(Throwable r100) {
            this.f28344b.a(r100);
        }
    }

    public void a() {
        Iterator<Map.Entry<a9, Future<?>>> r100 = this.f28341c.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r100.hasNext() == false) goto L12;
        a9 r101 = r100.next().getKey();     // Catch: Throwable -> L14
        Future<?> r102 = this.f28341c.get(r101);     // Catch: Throwable -> L14
        r101.cancelTask();     // Catch: Exception -> L10 Throwable -> L14
        if (r102 == null) goto L4;
        a(r102);     // Catch: Exception -> L10 Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        goto L4
    L12:
        this.f28341c.clear();     // Catch: Throwable -> L14
    L16:
        ThreadPoolExecutor r103 = this.f28339a;
        if (r103 == null) goto L19;
        r103.shutdown();
    L19:
        a("Pool destroyed");
        return;
    L14:
        th = move-exception;
        t6.a(th, "TPool", MapMonitorConst.EVENT_DESTROY);
        th.printStackTrace();
        goto L16
    }

    public int b() {
        ThreadPoolExecutor r100 = this.f28339a;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getCorePoolSize();
    }

    public int d() {
        ThreadPoolExecutor r100 = this.f28339a;
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getMaximumPoolSize();
    }

    public x8() {
        this.f28340b = "";
        this.f28341c = new ConcurrentHashMap();
        this.f28342d = new a(this);
    }

    public Executor c() {
        return this.f28339a;
    }

    private void a(String r100) {
        if (this.f28339a == null) goto L6;
        n0.a("AMapThreadPool", "[" + this.f28340b + "] " + r100 + " | pool=" + this.f28339a.getPoolSize() + HTTP.URL_DEFAULT + this.f28339a.getCorePoolSize() + HTTP.URL_DEFAULT + this.f28339a.getMaximumPoolSize() + " | active=" + this.f28339a.getActiveCount() + " | queue=" + this.f28339a.getQueue().size() + " | pending=" + this.f28341c.size() + " | completed=" + this.f28339a.getCompletedTaskCount(), false);
        return;
    }

    public boolean b(a9 r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        monitor-enter(this);
        Future<?> r101 = this.f28341c.remove(r100);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        return false;
    L10:
        r100.cancelTask();
        a(r101);
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized boolean c(a9 r100) {
        monitor-enter(this);
        boolean r101 = this.f28341c.containsKey(r100);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return r101;
    L5:
        th = move-exception;
        t6.a(th, "TPool", LynxVideoManagerLite.CONTAIN);     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean d(a9 r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof b) == false) goto L8;
        a9 r101 = r100;
    L10:
        if ((r101 instanceof b) == false) goto L12;
        String r102 = ((b) r101).f();
    L14:
        if (c(r100) == false) goto L17;
        n0.a("AMapThreadPool", "[" + this.f28340b + "] Task already in queue, skip | task=" + r102, false);
        return false;
    L17:
        ThreadPoolExecutor r103 = this.f28339a;
        if (r103 != null) goto L20;
    L50:
        n0.b("AMapThreadPool", "[" + this.f28340b + "] ThreadPool is null or shutdown, skip | task=" + r102, false);
        return false;
    L20:
        if (r103.isShutdown() == true) goto L50;
        a9.a r104 = this.f28342d;
        r101.f26888g = r104;
        if (r100 == r101) goto L54;
        r100.f26888g = r104;
    L54:
    L47:
        e = move-exception;
        n0.b("AMapThreadPool", "[" + this.f28340b + "] Task rejected | task=" + r102 + " | reason=" + e.getMessage(), false);
        StringBuilder r105 = new StringBuilder("Task rejected (");
        r105.append(r102);
        r105.append(")");
        a(r105.toString());
        t6.a(e, "TPool", "addTask");
        return false;
    L26:
        if ((r101 instanceof b) == false) goto L28;
        ((b) r101).a();     // Catch: RejectedExecutionException -> L47
    L28:
        Future<?> r106 = this.f28339a.submit(r101);     // Catch: RejectedExecutionException -> L47
        n0.a("AMapThreadPool", "[" + this.f28340b + "] Task submitted | task=" + r102 + " | queue=" + this.f28339a.getQueue().size() + " | pending=" + this.f28341c.size(), false);     // Catch: RejectedExecutionException -> L47
        if (r106 != null) goto L33;
        return false;
    L33:
        monitor-enter(this);
        this.f28341c.put(r100, r106);     // Catch: Throwable -> L36
    L38:
        monitor-exit(this);
        if (r106.isDone() == false) goto L42;
        a(r100, false);
    L42:
        a("After task submission (" + r102 + ")");
        return true;
    L36:
        th = move-exception;
        t6.a(th, "TPool", "addQueue");     // Catch: Throwable -> L44
        th.printStackTrace();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    L12:
        r102 = r101.getClass().getSimpleName();
        goto L14
    L8:
        r101 = new b(r100);
        goto L10
    }

    private void a(Future<?> r100) {
        r100.cancel(true);
        ThreadPoolExecutor r101 = this.f28339a;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Runnable) == false) goto L9;
        r101.remove((Runnable) r100);
        return;
    }

    public static /* synthetic */ a9 a(a9 r100) {
        if ((r100 instanceof b) == true) goto L5;
        return r100;
    L5:
        return ((b) r100).g();
    }

    public synchronized void a(a9 r100, boolean r101) {
        monitor-enter(this);
        Future<?> r102 = this.f28341c.remove(r100);     // Catch: Throwable -> L9
        if (r101 == false) goto L7;
        if (r102 == null) goto L7;
        a(r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        t6.a(th, "TPool", "removeQueue");     // Catch: Throwable -> L13
        th.printStackTrace();     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void a(long r100, TimeUnit r101) {
        ThreadPoolExecutor r102 = this.f28339a;     // Catch: InterruptedException -> L6
        if (r102 == null) goto L9;
        r102.awaitTermination(r100, r101);     // Catch: InterruptedException -> L6
        return;
    L9:
        return;
    }

    public static /* synthetic */ void a(x8 r100, String r101) {
        r100.a(r101);
    }
}
