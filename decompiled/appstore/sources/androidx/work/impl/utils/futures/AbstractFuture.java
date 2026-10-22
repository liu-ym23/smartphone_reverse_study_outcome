package androidx.work.impl.utils.futures;

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
public abstract class AbstractFuture implements ListenableFuture {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f5805d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f5806e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f5807f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f5808g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f5809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f5810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f5811c;

    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f5812b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f5813a;

        static {
            final String r10 = "Failure occurred while trying to finish a future.";
            f5812b = new Failure(new AnonymousClass1(r10));
        }

        public Failure(Throwable r10) {
            this.f5813a = (Throwable) AbstractFuture.e(r10);
        }
    }

    public static /* synthetic */ class a {
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture r10, d r11, d r12);

        public abstract boolean b(AbstractFuture r10, Object r11, Object r12);

        public abstract boolean c(AbstractFuture r10, h r11, h r12);

        public abstract void d(h r10, h r11);

        public abstract void e(h r10, Thread r11);

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f5814c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f5815d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f5816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f5817b;

        static {
            if (AbstractFuture.f5805d == false) goto L5;
            f5815d = null;
            f5814c = null;
            return;
        L5:
            f5815d = new c(false, null);
            f5814c = new c(true, null);
        }

        public c(boolean r10, Throwable r11) {
            this.f5816a = r10;
            this.f5817b = r11;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f5818d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f5819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f5820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f5821c;

        static {
            f5818d = new d(null, null);
        }

        public d(Runnable r10, Executor r11) {
            this.f5819a = r10;
            this.f5820b = r11;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f5822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f5823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f5824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f5825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f5826e;

        public e(AtomicReferenceFieldUpdater r10, AtomicReferenceFieldUpdater r11, AtomicReferenceFieldUpdater r12, AtomicReferenceFieldUpdater r13, AtomicReferenceFieldUpdater r14) {
            super(null);
            this.f5822a = r10;
            this.f5823b = r11;
            this.f5824c = r12;
            this.f5825d = r13;
            this.f5826e = r14;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture r10, d r11, d r12) {
            return androidx.concurrent.futures.a.a(this.f5825d, r10, r11, r12);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture r10, Object r11, Object r12) {
            return androidx.concurrent.futures.a.a(this.f5826e, r10, r11, r12);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture r10, h r11, h r12) {
            return androidx.concurrent.futures.a.a(this.f5824c, r10, r11, r12);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(h r10, h r11) {
            this.f5823b.lazySet(r10, r11);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(h r10, Thread r11) {
            this.f5822a.lazySet(r10, r11);
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractFuture f5827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListenableFuture f5828b;

        public f(AbstractFuture r10, ListenableFuture r11) {
            this.f5827a = r10;
            this.f5828b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5827a.f5809a == this) goto L5;
            return;
        L5:
            Object r10 = AbstractFuture.j(this.f5828b);
            if (AbstractFuture.f5807f.b(this.f5827a, this, r10) == false) goto L9;
            AbstractFuture.g(this.f5827a);
            return;
        }
    }

    public static final class g extends b {
        public g() {
            super(null);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture r10, d r11, d r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f5810b != r11) goto L11;
            r10.f5810b = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture r10, Object r11, Object r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f5809a != r11) goto L11;
            r10.f5809a = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture r10, h r11, h r12) {
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r10.f5811c != r11) goto L11;
            r10.f5811c = r12;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(h r10, h r11) {
            r10.f5831b = r11;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(h r10, Thread r11) {
            r10.f5830a = r11;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f5829c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f5830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f5831b;

        static {
            f5829c = new h(false);
        }

        public h(boolean r10) {
        }

        public void a(h r10) {
            AbstractFuture.f5807f.d(this, r10);
        }

        public void b() {
            Thread r10 = this.f5830a;
            if (r10 == null) goto L6;
            this.f5830a = null;
            LockSupport.unpark(r10);
            return;
        }

        public h() {
            AbstractFuture.f5807f.e(this, Thread.currentThread());
        }
    }

    static {
        f5805d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        f5806e = Logger.getLogger(AbstractFuture.class.getName());
        b r10 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));     // Catch: Throwable -> L5
        th = null;
    L7:
        f5807f = r10;
        if (th == null) goto L10;
        f5806e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        f5808g = new Object();
        return;
    L5:
        th = th;
        r10 = new g();
        goto L7
    }

    public AbstractFuture() {
    }

    private void b(StringBuilder r10) {
        Object r11 = k(this);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r10.append(s(r11));     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
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

    private static CancellationException d(String r10, Throwable r11) {
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

    public static void g(AbstractFuture r10) {
        d r11 = null;
    L3:
        r10.n();
        r10.c();
        d r12 = r10.f(r11);
    L4:
        if (r12 == null) goto L14;
        r11 = r12.f5821c;
        Runnable r13 = r12.f5819a;
        if ((r13 instanceof f) == false) goto L12;
        f r14 = (f) r13;
        r10 = r14.f5827a;
        if (r10.f5809a != r14) goto L13;
        Object r15 = j(r14.f5828b);
        if (f5807f.b(r10, r14, r15) == true) goto L3;
    L13:
        r12 = r11;
        goto L4
    L12:
        h(r13, r12.f5820b);
        goto L13
    }

    private static void h(Runnable r10, Executor r11) {
        r11.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        f5806e.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r11, e);
    }

    private Object i(Object r10) {
        if ((r10 instanceof c) == true) goto L14;
        if ((r10 instanceof Failure) == true) goto L12;
        if (r10 != f5808g) goto L10;
        return null;
    L10:
        return r10;
    L12:
        throw new ExecutionException(((Failure) r10).f5813a);
    L14:
        throw d("Task was cancelled.", ((c) r10).f5817b);
    }

    public static Object j(ListenableFuture r10) {
        if ((r10 instanceof AbstractFuture) == false) goto L13;
        Object r11 = ((AbstractFuture) r10).f5809a;
        if ((r11 instanceof c) == false) goto L39;
        c r12 = (c) r11;
        if (r12.f5816a == true) goto L9;
        return r11;
    L9:
        if (r12.f5817b == null) goto L12;
        return new c(false, r12.f5817b);
    L12:
        return c.f5815d;
    L39:
        return r11;
    L13:
        boolean r13 = r10.isCancelled();
        if (((!f5805d) & r13) == true) goto L16;
        Object r14 = k(r10);     // Catch: Throwable -> L21 CancellationException -> L23 ExecutionException -> L25
        if (r14 != null) goto L27;
    L42:
        return f5808g;
    L27:
        return r14;
    L23:
        e = move-exception;
        if (r13 == true) goto L34;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r10, e));
    L34:
        return new c(false, e);
    L25:
        e = move-exception;
        return new Failure(e.getCause());
    L21:
        th = move-exception;
        return new Failure(th);
    L16:
        return c.f5815d;
    }

    private static Object k(Future r10) {
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

    private void n() {
    L2:
        h r10 = this.f5811c;
        if (f5807f.c(this, r10, h.f5829c) == false) goto L2;
    L4:
        if (r10 == null) goto L6;
        r10.b();
        r10 = r10.f5831b;
        goto L4
    }

    private String s(Object r10) {
        if (r10 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r10);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable r10, Executor r11) {
        e(r10);
        e(r11);
        d r12 = this.f5810b;
        if (r12 == d.f5818d) goto L10;
        d r13 = new d(r10, r11);
    L5:
        r13.f5821c = r12;
        if (f5807f.a(this, r12, r13) == true) goto L7;
        r12 = this.f5810b;
        if (r12 != d.f5818d) goto L5;
    L7:
        return;
    L10:
        h(r10, r11);
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r10) {
        Object r11 = this.f5809a;
        if (r11 != null) goto L5;
        boolean r12 = true;
    L7:
        if ((r12 | (r11 instanceof f)) == false) goto L35;
        if (f5805d == false) goto L11;
        c r13 = new c(r10, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r14 = false;
    L16:
        if (f5807f.b(this, r11, r13) == true) goto L17;
        r11 = this.f5809a;
        if ((r11 instanceof f) == true) goto L16;
        return r14;
    L17:
        if (r10 == false) goto L19;
        this.l();
    L19:
        g(this);
        if ((r11 instanceof f) == false) goto L47;
        ListenableFuture r15 = ((f) r11).f5828b;
        if ((r15 instanceof AbstractFuture) == false) goto L30;
        AbstractFuture this = (AbstractFuture) r15;
        r11 = this.f5809a;
        if (r11 != null) goto L26;
        boolean r16 = true;
    L28:
        if ((r16 | (r11 instanceof f)) == false) goto L48;
        r14 = true;
        goto L16
    L48:
        return true;
    L26:
        r16 = false;
        goto L28
    L30:
        r15.cancel(r10);
        return true;
    L47:
        return true;
    L11:
        if (r10 == false) goto L13;
        r13 = c.f5814c;
        goto L14
    L13:
        r13 = c.f5815d;
        goto L14
    L35:
        return false;
    L5:
        r12 = false;
        goto L7
    }

    public final d f(d r10) {
    L2:
        d r11 = this.f5810b;
        if (f5807f.a(this, r11, d.f5818d) == false) goto L2;
    L4:
        d r12 = r10;
        r10 = r11;
        if (r10 == null) goto L7;
        r11 = r10.f5821c;
        r10.f5821c = r12;
        goto L4
    L7:
        return r12;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long r20, TimeUnit r22) {
        long r10 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r11 = this.f5809a;
        if (r11 == null) goto L7;
        boolean r12 = true;
    L9:
        if ((r12 & (!(r11 instanceof f))) == false) goto L13;
        return i(r11);
    L13:
        if (r10 <= 0) goto L15;
        long r13 = System.nanoTime() + r10;
    L17:
        if (r10 < 1000) goto L43;
        h r14 = this.f5811c;
        if (r14 == h.f5829c) goto L41;
        h r15 = new h();
    L21:
        r15.a(r14);
        if (f5807f.c(this, r14, r15) == true) goto L23;
        r14 = this.f5811c;
        if (r14 != h.f5829c) goto L21;
    L23:
        LockSupport.parkNanos(this, r10);
        if (Thread.interrupted() == true) goto L36;
        Object r16 = this.f5809a;
        if (r16 == null) goto L28;
        boolean r17 = true;
    L30:
        if ((r17 & (!(r16 instanceof f))) == true) goto L32;
        r10 = r13 - System.nanoTime();
        if (r10 >= 1000) goto L23;
        o(r15);
        goto L43
    L32:
        return i(r16);
    L28:
        r17 = false;
        goto L30
    L36:
        o(r15);
        throw new InterruptedException();
    L41:
        return i(this.f5809a);
    L43:
        if (r10 <= 0) goto L57;
        Object r18 = this.f5809a;
        if (r18 == null) goto L47;
        boolean r19 = true;
    L49:
        if ((r19 & (!(r18 instanceof f))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r10 = r13 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return i(r18);
    L47:
        r19 = false;
        goto L49
    L57:
        String r21 = toString();
        String r23 = r22.toString();
        Locale r110 = Locale.ROOT;
        String r24 = r23.toLowerCase(r110);
        String r25 = "Waited " + r20 + " " + r22.toString().toLowerCase(r110);
        if ((r10 + 1000) >= 0) goto L75;
        String r26 = r25 + " (plus ";
        long r27 = -r10;
        long r111 = r22.convert(r27, TimeUnit.NANOSECONDS);
        long r28 = r27 - r22.toNanos(r111);
        if (r111 != 0) goto L62;
    L65:
        boolean r112 = true;
    L66:
        if (r111 <= 0) goto L71;
        String r29 = r26 + r111 + " " + r24;
        if (r112 == false) goto L70;
        r29 = r29 + ",";
    L70:
        r26 = r29 + " ";
    L71:
        if (r112 == false) goto L73;
        r26 = r26 + r28 + " nanoseconds ";
    L73:
        r25 = r26 + "delay)";
        goto L75
    L62:
        if (r28 > 1000) goto L65;
        r112 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r25 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r25 + " for " + r21);
    L15:
        r13 = 0;
        goto L17
    L7:
        r12 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f5809a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r10 = this.f5809a;
        if (r10 == null) goto L5;
        boolean r11 = true;
    L7:
        return (!(r10 instanceof f)) & r11;
    L5:
        r11 = false;
        goto L7
    }

    public void l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String m() {
        Object r10 = this.f5809a;
        if ((r10 instanceof f) == false) goto L7;
        return "setFuture=[" + s(((f) r10).f5828b) + "]";
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void o(h r10) {
        r10.f5830a = null;
    L3:
        h r11 = this.f5811c;
        if (r11 == h.f5829c) goto L5;
        h r12 = null;
    L7:
        if (r11 == null) goto L19;
        h r13 = r11.f5831b;
        if (r11.f5830a == null) goto L11;
        r12 = r11;
    L18:
        r11 = r13;
        goto L7
    L11:
        if (r12 == null) goto L16;
        r12.f5831b = r13;
        if (r12.f5830a != null) goto L18;
    L16:
        if (f5807f.c(this, r11, r13) == true) goto L18;
    L19:
        return;
    }

    public boolean p(Object r10) {
        if (r10 != null) goto L5;
        r10 = f5808g;
    L5:
        if (f5807f.b(this, null, r10) == false) goto L8;
        g(this);
        return true;
    L8:
        return false;
    }

    public boolean q(Throwable r10) {
        Failure r11 = new Failure((Throwable) e(r10));
        if (f5807f.b(this, null, r11) == false) goto L6;
        g(this);
        return true;
    L6:
        return false;
    }

    public boolean r(ListenableFuture r10) {
        e(r10);
        Object r11 = this.f5809a;
        if (r11 != null) goto L23;
        if (r10.isDone() == false) goto L11;
        Object r12 = j(r10);
        if (f5807f.b(this, null, r12) == false) goto L10;
        g(this);
        return true;
    L10:
        return false;
    L11:
        f r13 = new f(this, r10);
        if (f5807f.b(this, null, r13) == true) goto L26;
        r11 = this.f5809a;
        goto L23
    L26:
        r10.addListener(r13, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r14 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        f5807f.b(this, r13, r14);
    L18:
        r14 = Failure.f5812b;
    L23:
        if ((r11 instanceof c) == false) goto L25;
        r10.cancel(((c) r11).f5816a);
    L25:
        return false;
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
        String r11 = m();     // Catch: RuntimeException -> L10
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
        if (Thread.interrupted() == true) goto L34;
        Object r10 = this.f5809a;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if ((r11 & (!(r10 instanceof f))) == true) goto L11;
        h r12 = this.f5811c;
        if (r12 == h.f5829c) goto L32;
        h r13 = new h();
    L15:
        r13.a(r12);
        if (f5807f.c(this, r12, r13) == true) goto L17;
        r12 = this.f5811c;
        if (r12 != h.f5829c) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r14 = this.f5809a;
        if (r14 == null) goto L22;
        boolean r15 = true;
    L24:
        if ((r15 & (!(r14 instanceof f))) == false) goto L17;
        return i(r14);
    L22:
        r15 = false;
        goto L24
    L27:
        o(r13);
        throw new InterruptedException();
    L32:
        return i(this.f5809a);
    L11:
        return i(r10);
    L7:
        r11 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }
}
