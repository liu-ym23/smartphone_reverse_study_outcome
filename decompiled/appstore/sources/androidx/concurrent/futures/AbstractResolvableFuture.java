package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResolvableFuture implements ListenableFuture {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f1229d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f1230e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f1231f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f1232g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f1233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f1234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g f1235c;

    public static final class Failure {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f1236a;

        /* JADX INFO: renamed from: androidx.concurrent.futures.AbstractResolvableFuture$Failure$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            public AnonymousClass1(String r10) {
                super(r10);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                monitor-enter(this);
                monitor-exit(this);
                return this;
            }
        }
    }

    public static /* synthetic */ class a {
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture r10, d r11, d r12);

        public abstract boolean b(AbstractResolvableFuture r10, Object r11, Object r12);

        public abstract boolean c(AbstractResolvableFuture r10, g r11, g r12);

        public abstract void d(g r10, g r11);

        public abstract void e(g r10, Thread r11);

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f1237c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f1238d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f1240b;

        static {
            if (AbstractResolvableFuture.f1229d == false) goto L5;
            f1238d = null;
            f1237c = null;
            return;
        L5:
            f1238d = new c(false, null);
            f1237c = new c(true, null);
        }

        public c(boolean r10, Throwable r11) {
            this.f1239a = r10;
            this.f1240b = r11;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f1241d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f1242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f1243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f1244c;

        static {
            f1241d = new d(null, null);
        }

        public d(Runnable r10, Executor r11) {
            this.f1242a = r10;
            this.f1243b = r11;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1249e;

        public e(AtomicReferenceFieldUpdater r10, AtomicReferenceFieldUpdater r11, AtomicReferenceFieldUpdater r12, AtomicReferenceFieldUpdater r13, AtomicReferenceFieldUpdater r14) {
            super(null);
            this.f1245a = r10;
            this.f1246b = r11;
            this.f1247c = r12;
            this.f1248d = r13;
            this.f1249e = r14;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture r10, d r11, d r12) {
            return androidx.concurrent.futures.a.a(this.f1248d, r10, r11, r12);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture r10, Object r11, Object r12) {
            return androidx.concurrent.futures.a.a(this.f1249e, r10, r11, r12);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture r10, g r11, g r12) {
            return androidx.concurrent.futures.a.a(this.f1247c, r10, r11, r12);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g r10, g r11) {
            this.f1246b.lazySet(r10, r11);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g r10, Thread r11) {
            this.f1245a.lazySet(r10, r11);
        }
    }

    public static final class f extends b {
        public f() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture r10, d r11, d r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f1234b != r11) goto L11;
            r10.f1234b = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture r10, Object r11, Object r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f1233a != r11) goto L11;
            r10.f1233a = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture r10, g r11, g r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f1235c != r11) goto L11;
            r10.f1235c = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(g r10, g r11) {
            r10.f1252b = r11;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(g r10, Thread r11) {
            r10.f1251a = r11;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f1250c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f1251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile g f1252b;

        static {
            f1250c = new g(false);
        }

        public g(boolean r10) {
        }

        public void a(g r10) {
            AbstractResolvableFuture.f1231f.d(this, r10);
        }

        public void b() {
            Thread r10 = this.f1251a;
            if (r10 == null) goto L6;
            this.f1251a = null;
            LockSupport.unpark(r10);
            return;
        }

        public g() {
            AbstractResolvableFuture.f1231f.e(this, Thread.currentThread());
        }
    }

    static {
        f1229d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        f1230e = Logger.getLogger(AbstractResolvableFuture.class.getName());
        b r10 = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));     // Catch: Throwable -> L5
        th = null;
    L7:
        f1231f = r10;
        if (th == null) goto L10;
        f1230e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        f1232g = new Object();
        return;
    L5:
        th = th;
        r10 = new f();
        goto L7
    }

    public AbstractResolvableFuture() {
    }

    public static CancellationException d(String r10, Throwable r11) {
        CancellationException r12 = new CancellationException(r10);
        r12.initCause(r11);
        return r12;
    }

    public static Object e(Object r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }

    public static void g(AbstractResolvableFuture r10) {
        r10.m();
        r10.c();
        d r11 = r10.f(null);
    L3:
        if (r11 == null) goto L5;
        d r12 = r11.f1244c;
        h(r11.f1242a, r11.f1243b);
        r11 = r12;
        goto L3
    }

    public static void h(Runnable r10, Executor r11) {
        r11.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        f1230e.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r11, e);
    }

    public static Object j(Future r10) {
        boolean r11 = false;
    L12:
        Object r12 = r10.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r11 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r12;
    L11:
        r11 = true;
    L7:
        th = move-exception;
        if (r11 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable r10, Executor r11) {
        e(r10);
        e(r11);
        d r12 = this.f1234b;
        if (r12 == d.f1241d) goto L10;
        d r13 = new d(r10, r11);
    L5:
        r13.f1244c = r12;
        if (f1231f.a(this, r12, r13) == true) goto L7;
        r12 = this.f1234b;
        if (r12 != d.f1241d) goto L5;
    L7:
        return;
    L10:
        h(r10, r11);
    }

    public final void b(StringBuilder r10) {
        Object r11 = j(this);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append(p(r11));     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append("]");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
    L17:
        return;
    L10:
        r10.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r10.append("UNKNOWN, cause=[");
        r10.append(e.getClass());
        r10.append(" thrown from get()]");
        return;
    L7:
        e = move-exception;
        r10.append("FAILURE, cause=[");
        r10.append(e.getCause());
        r10.append("]");
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r10) {
        Object r11 = this.f1233a;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L19;
        if (f1229d == false) goto L10;
        c r13 = new c(r10, new CancellationException("Future.cancel() was called."));
    L14:
        if (f1231f.b(this, r11, r13) == false) goto L19;
        if (r10 == false) goto L17;
        k();
    L17:
        g(this);
        return true;
    L10:
        if (r10 == false) goto L12;
        r13 = c.f1237c;
        goto L14
    L12:
        r13 = c.f1238d;
    L19:
        return false;
    L5:
        r12 = false;
        goto L6
    }

    public final d f(d r10) {
    L2:
        d r11 = this.f1234b;
        if (f1231f.a(this, r11, d.f1241d) == false) goto L2;
    L4:
        d r12 = r10;
        r10 = r11;
        if (r10 == null) goto L7;
        r11 = r10.f1244c;
        r10.f1244c = r12;
        goto L4
    L7:
        return r12;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r20, TimeUnit r22) {
        long r10 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L78;
        Object r11 = this.f1233a;
        if (r11 == null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L12;
        return i(r11);
    L12:
        if (r10 <= 0) goto L14;
        long r13 = System.nanoTime() + r10;
    L16:
        if (r10 < 1000) goto L41;
        g r14 = this.f1235c;
        if (r14 == g.f1250c) goto L39;
        g r15 = new g();
    L20:
        r15.a(r14);
        if (f1231f.c(this, r14, r15) == true) goto L22;
        r14 = this.f1235c;
        if (r14 != g.f1250c) goto L20;
    L22:
        LockSupport.parkNanos(this, r10);
        if (Thread.interrupted() == true) goto L34;
        Object r16 = this.f1233a;
        if (r16 == null) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == true) goto L30;
        r10 = r13 - System.nanoTime();
        if (r10 >= 1000) goto L22;
        n(r15);
        goto L41
    L30:
        return i(r16);
    L27:
        r17 = false;
        goto L28
    L34:
        n(r15);
        throw new InterruptedException();
    L39:
        return i(this.f1233a);
    L41:
        if (r10 <= 0) goto L54;
        Object r18 = this.f1233a;
        if (r18 == null) goto L45;
        boolean r19 = true;
    L46:
        if (r19 == true) goto L48;
        if (Thread.interrupted() == true) goto L53;
        r10 = r13 - System.nanoTime();
        goto L41
    L53:
        throw new InterruptedException();
    L48:
        return i(r18);
    L45:
        r19 = false;
        goto L46
    L54:
        String r21 = toString();
        String r23 = r22.toString();
        Locale r110 = Locale.ROOT;
        String r24 = r23.toLowerCase(r110);
        String r25 = "Waited " + r20 + " " + r22.toString().toLowerCase(r110);
        if ((r10 + 1000) >= 0) goto L72;
        String r26 = r25 + " (plus ";
        long r27 = -r10;
        long r111 = r22.convert(r27, TimeUnit.NANOSECONDS);
        long r28 = r27 - r22.toNanos(r111);
        if (r111 != 0) goto L59;
    L62:
        boolean r112 = true;
    L63:
        if (r111 <= 0) goto L68;
        String r29 = r26 + r111 + " " + r24;
        if (r112 == false) goto L67;
        r29 = r29 + ",";
    L67:
        r26 = r29 + " ";
    L68:
        if (r112 == false) goto L70;
        r26 = r26 + r28 + " nanoseconds ";
    L70:
        r25 = r26 + "delay)";
        goto L72
    L59:
        if (r28 > 1000) goto L62;
        r112 = false;
    L72:
        if (isDone() == false) goto L76;
        throw new TimeoutException(r25 + " but future completed as timeout expired");
    L76:
        throw new TimeoutException(r25 + " for " + r21);
    L14:
        r13 = 0;
        goto L16
    L7:
        r12 = false;
        goto L8
    L78:
        throw new InterruptedException();
    }

    public final Object i(Object r10) {
        if ((r10 instanceof c) == true) goto L14;
        if ((r10 instanceof Failure) == true) goto L12;
        if (r10 != f1232g) goto L10;
        return null;
    L10:
        return r10;
    L12:
        throw new ExecutionException(((Failure) r10).f1236a);
    L14:
        throw d("Task was cancelled.", ((c) r10).f1240b);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1233a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        if (this.f1233a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String l() {
        if ((this instanceof ScheduledFuture) == true) goto L5;
        return null;
    L5:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void m() {
    L2:
        g r10 = this.f1235c;
        if (f1231f.c(this, r10, g.f1250c) == false) goto L2;
    L4:
        if (r10 == null) goto L6;
        r10.b();
        r10 = r10.f1252b;
        goto L4
    }

    public final void n(g r10) {
        r10.f1251a = null;
    L3:
        g r11 = this.f1235c;
        if (r11 == g.f1250c) goto L5;
        g r12 = null;
    L7:
        if (r11 == null) goto L19;
        g r13 = r11.f1252b;
        if (r11.f1251a == null) goto L11;
        r12 = r11;
    L18:
        r11 = r13;
        goto L7
    L11:
        if (r12 == null) goto L16;
        r12.f1252b = r13;
        if (r12.f1251a != null) goto L18;
    L16:
        if (f1231f.c(this, r11, r13) == true) goto L18;
    L19:
        return;
    }

    public boolean o(Object r10) {
        if (r10 != null) goto L5;
        r10 = f1232g;
    L5:
        if (f1231f.b(this, null, r10) == false) goto L8;
        g(this);
        return true;
    L8:
        return false;
    }

    public final String p(Object r10) {
        if (r10 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r10);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        r10.append("[status=");
        if (isCancelled() == false) goto L6;
        r10.append("CANCELLED");
    L20:
        r10.append("]");
        return r10.toString();
    L6:
        if (isDone() == false) goto L22;
        b(r10);
        goto L20
    L22:
        String r11 = l();     // Catch: RuntimeException -> L10
    L12:
        if (r11 == null) goto L17;
        if (r11.isEmpty() == true) goto L17;
        r10.append("PENDING, info=[");
        r10.append(r11);
        r10.append("]");
    L17:
        if (isDone() == false) goto L19;
        b(r10);
        goto L20
    L19:
        r10.append("PENDING");
    L10:
        e = move-exception;
        r11 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        if (Thread.interrupted() == true) goto L32;
        Object r10 = this.f1233a;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L10;
        g r12 = this.f1235c;
        if (r12 == g.f1250c) goto L30;
        g r13 = new g();
    L14:
        r13.a(r12);
        if (f1231f.c(this, r12, r13) == true) goto L16;
        r12 = this.f1235c;
        if (r12 != g.f1250c) goto L14;
    L16:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L25;
        Object r14 = this.f1233a;
        if (r14 == null) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == false) goto L16;
        return i(r14);
    L21:
        r15 = false;
        goto L22
    L25:
        n(r13);
        throw new InterruptedException();
    L30:
        return i(this.f1233a);
    L10:
        return i(r10);
    L7:
        r11 = false;
        goto L8
    L32:
        throw new InterruptedException();
    }
}
