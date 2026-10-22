package okhttp3.internal.c;

import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: TaskRunner.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f39849b = null;
    private static final Logger j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f39850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39852e;
    private long f;
    private final List<okhttp3.internal.c.c> g;
    private final List<okhttp3.internal.c.c> h;
    private final Runnable i;

    /* JADX INFO: compiled from: TaskRunner.kt */
    public interface a {
        long a();

        void a(Runnable r1);

        void a(d r1);

        void a(d r1, long r2);
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final Logger a() {
            return d.e();
        }
    }

    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f39853a;

        public c(ThreadFactory r11) {
            ThreadFactory r9 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r11, ThreadFactory.class, "com.obric.aiagent.plugin");
            o.e(r9, "threadFactory");
            this.f39853a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new SynchronousQueue(), BlockingQueue.class, "com.obric.aiagent.plugin"), r9);
        }

        @Override // okhttp3.internal.c.d.a
        public long a() {
            return System.nanoTime();
        }

        @Override // okhttp3.internal.c.d.a
        public void a(d r7, long r8) {
            o.e(r7, "taskRunner");
            long r2 = r8 / 1000000;
            long r0 = r8 - (1000000 * r2);
            if (r2 <= 0) goto L5;
        L6:
            ZeusTransformUtils.preCheckCast(r7, Object.class, "com.obric.aiagent.plugin").wait(r2, (int) r0);
            return;
        L5:
            if (r8 > 0) goto L6;
        }

        @Override // okhttp3.internal.c.d.a
        public void a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            o.e(r4, "runnable");
            this.f39853a.execute(r4);
        }

        @Override // okhttp3.internal.c.d.a
        public void a(d r2) {
            o.e(r2, "taskRunner");
            ZeusTransformUtils.preCheckCast(r2, Object.class, "com.obric.aiagent.plugin").notify();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.c.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskRunner.kt */
    public static final class RunnableC1075d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39854a;

        RunnableC1075d(d r1) {
            this.f39854a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            d r0 = this.f39854a;
            monitor-enter(r0);
            okhttp3.internal.c.a r1 = r0.b();     // Catch: Throwable -> L23
            monitor-exit(r0);
            if (r1 == null) goto L7;
            okhttp3.internal.c.c r2 = r1.d();
            o.a(r2);
            d r3 = this.f39854a;
            long r4 = -1;
            boolean r5 = d.f39848a.a().isLoggable(Level.FINE);
            if (r5 == false) goto L30;
            r4 = r2.a().a().a();
            okhttp3.internal.c.b.a(r1, r2, "starting");
        L30:
            d.a(r3, r1);     // Catch: Throwable -> L17
            x r6 = x.f38692a;     // Catch: Throwable -> L15
            if (r5 == false) goto L2;
            okhttp3.internal.c.b.a(r1, r2, "finished run in " + okhttp3.internal.c.b.a(r2.a().a().a() - r4));
            goto L2
        L17:
            th = move-exception;
            r3.a().a((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (r5 == false) goto L22;
            okhttp3.internal.c.b.a(r1, r2, "failed a run in " + okhttp3.internal.c.b.a(r2.a().a().a() - r4));
        L22:
            throw th;
        L7:
            return;
        L23:
            th = move-exception;
            throw th;
        }
    }

    public d(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "backend");
        this.f39850c = r4;
        this.f39851d = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        this.g = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.h = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.i = (Runnable) ZeusTransformUtils.preCheckCast(new RunnableC1075d(this), Runnable.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(d r0, okhttp3.internal.c.a r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ Logger e() {
        return j;
    }

    public final a a() {
        return this.f39850c;
    }

    public final okhttp3.internal.c.c c() {
        monitor-enter(this);
        int r0 = this.f39851d;     // Catch: Throwable -> L7
        this.f39851d = r0 + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return new okhttp3.internal.c.c(this, new StringBuilder().append('Q').append(r0).toString());
    L7:
        th = move-exception;
        throw th;
    }

    public final void d() {
        int r0 = this.g.size();
    L3:
        r0 = r0 - 1;
        if ((-1) >= r0) goto L6;
        ((okhttp3.internal.c.c) ZeusTransformUtils.preCheckCast(this.g.get(r0), okhttp3.internal.c.c.class, "com.obric.aiagent.plugin")).i();
        goto L3
    L6:
        int r1 = this.h.size() - 1;
    L7:
        if ((-1) >= r1) goto L12;
        okhttp3.internal.c.c r3 = (okhttp3.internal.c.c) ZeusTransformUtils.preCheckCast(this.h.get(r1), okhttp3.internal.c.c.class, "com.obric.aiagent.plugin");
        r3.i();
        if (r3.e().isEmpty() == false) goto L11;
        this.h.remove(r1);
    L11:
        r1 = r1 - 1;
        goto L7
    }

    static {
        f39848a = new b(null);
        f39849b = new d((a) ZeusTransformUtils.preCheckCast(new c(okhttp3.internal.c.a(okhttp3.internal.c.g + " TaskRunner", true)), a.class, "com.obric.aiagent.plugin"));
        Logger r0 = Logger.getLogger(d.class.getName());
        o.c(r0, "getLogger(TaskRunner::class.java.name)");
        j = r0;
    }

    public final void a(okhttp3.internal.c.c r4) {
        o.e(r4, "taskQueue");
        if (okhttp3.internal.c.f == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (r4.d() != null) goto L16;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4.e(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L14;
        okhttp3.internal.c.a(this.h, r4);
        goto L16
    L14:
        this.h.remove(r4);
    L16:
        if (this.f39852e == false) goto L18;
        this.f39850c.a(this);
        return;
    L18:
        this.f39850c.a(this.i);
    }

    private final void a(okhttp3.internal.c.a r3) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        r3.a(-1);
        okhttp3.internal.c.c r0 = r3.d();
        o.a(r0);
        r0.e().remove(r3);
        this.h.remove(r0);
        r0.a(r3);
        this.g.add(r0);
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void b(okhttp3.internal.c.a r6) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        Thread r0 = Thread.currentThread();
        String r1 = r0.getName();
        r0.setName(r6.b());
        long r2 = r6.a();     // Catch: Throwable -> L19
        monitor-enter(this);
        a(r6, r2);     // Catch: Throwable -> L16
        x r7 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        r0.setName(r1);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        monitor-enter(this);
        a(r6, -1);     // Catch: Throwable -> L25
        x r8 = x.f38692a;     // Catch: Throwable -> L25
        r0.setName(r1);
        throw th;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void a(okhttp3.internal.c.a r7, long r8) {
        if (okhttp3.internal.c.f == true) goto L5;
    L9:
        okhttp3.internal.c.c r0 = r7.d();
        o.a(r0);
        if (r0.d() != r7) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L25;
        boolean r2 = r0.f();
        r0.a(false);
        r0.a(null);
        this.g.remove(r0);
        if (r8 == (-1)) goto L21;
        if (r2 == true) goto L21;
        if (r0.c() == true) goto L21;
        r0.a(r7, r8, true);
    L21:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0.e(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L26;
        this.h.add(r0);
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r1 = false;
        goto L13
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final okhttp3.internal.c.a b() {
        if (okhttp3.internal.c.f == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.h.isEmpty() == true) goto L11;
        long r2 = this.f39850c.a();
        long r4 = Long.MAX_VALUE;
        Iterator<okhttp3.internal.c.c> r0 = this.h.iterator();
        okhttp3.internal.c.a r6 = null;
    L14:
        if (r0.hasNext() == false) goto L21;
        okhttp3.internal.c.a r7 = (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(((okhttp3.internal.c.c) ZeusTransformUtils.preCheckCast(r0.next(), okhttp3.internal.c.c.class, "com.obric.aiagent.plugin")).e().get(0), okhttp3.internal.c.a.class, "com.obric.aiagent.plugin");
        long r11 = Math.max(0, r7.e() - r2);
        if (r11 > 0) goto L17;
        if (r6 != null) goto L19;
        r6 = r7;
        goto L14
    L19:
        boolean r1 = true;
    L22:
        if (r6 != null) goto L23;
        if (this.f39852e == true) goto L34;
        this.f39852e = true;
        this.f = r2 + r4;
        this.f39850c.a(this, r4);     // Catch: Throwable -> L40 InterruptedException -> L42
    L39:
        this.f39852e = false;
    L40:
        th = move-exception;
        this.f39852e = false;
        throw th;
    L42:
        d();     // Catch: Throwable -> L40
        goto L39
    L34:
        if (r4 >= (this.f - r2)) goto L36;
        this.f39850c.a(this);
    L36:
        return null;
    L23:
        a(r6);
        if (r1 == false) goto L26;
    L29:
        this.f39850c.a(this.i);
    L30:
        return r6;
    L26:
        if (this.f39852e == true) goto L30;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L30;
    L17:
        r4 = Math.min(r11, r4);
        goto L14
    L21:
        r1 = false;
        goto L22
    L11:
        return null;
    }
}
