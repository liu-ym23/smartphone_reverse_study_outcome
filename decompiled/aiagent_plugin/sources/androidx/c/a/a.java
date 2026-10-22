package androidx.c.a;

import com.google.common.util.concurrent.ListenableFuture;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.Objects;
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

/* JADX INFO: compiled from: AbstractResolvableFuture.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f564a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final AbstractC0010a f565b = null;
    private static final Logger f = null;
    private static final Object g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile Object f566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile d f567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile h f568e;

    /* JADX INFO: renamed from: androidx.c.a.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: androidx.c.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static abstract class AbstractC0010a {
        abstract void a(h r1, h r2);

        abstract void a(h r1, Thread r2);

        abstract boolean a(a<?> r1, d r2, d r3);

        abstract boolean a(a<?> r1, h r2, h r3);

        abstract boolean a(a<?> r1, Object r2, Object r3);

        private AbstractC0010a() {
        }

        /* synthetic */ AbstractC0010a(AnonymousClass1 r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f569a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f570b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Throwable f572d;

        static {
            if (a.f564a == false) goto L5;
            f570b = null;
            f569a = null;
            return;
        L5:
            f570b = new b(false, null);
            f569a = new b(true, null);
        }

        b(boolean r1, Throwable r2) {
            this.f571c = r1;
            this.f572d = r2;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f573a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f574b;

        static {
            final String r2 = "Failure occurred while trying to finish a future.";
            f573a = new c(new AnonymousClass1(r2));
        }

        c(Throwable r3) {
            this.f574b = (Throwable) ZeusTransformUtils.preCheckCast(a.b(r3), Throwable.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f575a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Executor f577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d f578d;

        static {
            f575a = new d(null, null);
        }

        d(Runnable r3, Executor r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            this.f576b = r5;
            this.f577c = r6;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class e extends AbstractC0010a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, Thread> f579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<h, h> f580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, h> f581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, d> f582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f583e;

        e(AtomicReferenceFieldUpdater<h, Thread> r2, AtomicReferenceFieldUpdater<h, h> r3, AtomicReferenceFieldUpdater<a, h> r4, AtomicReferenceFieldUpdater<a, d> r5, AtomicReferenceFieldUpdater<a, Object> r6) {
            super(null);
            this.f579a = r2;
            this.f580b = r3;
            this.f581c = r4;
            this.f582d = r5;
            this.f583e = r6;
        }

        @Override // androidx.c.a.a.AbstractC0010a
        void a(h r1, Thread r2) {
            this.f579a.lazySet(r1, r2);
        }

        @Override // androidx.c.a.a.AbstractC0010a
        void a(h r1, h r2) {
            this.f580b.lazySet(r1, r2);
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, h r2, h r3) {
            return this.f581c.compareAndSet(r1, r2, r3);
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, d r2, d r3) {
            return this.f582d.compareAndSet(r1, r2, r3);
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, Object r2, Object r3) {
            return this.f583e.compareAndSet(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class f<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a<V> f584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ListenableFuture<? extends V> f585b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f584a.f566c == this) goto L5;
            return;
        L5:
            Object r0 = a.a(this.f585b);
            if (a.f565b.a(this.f584a, this, r0) == false) goto L9;
            a.a(this.f584a);
            return;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class g extends AbstractC0010a {
        g() {
            super(null);
        }

        @Override // androidx.c.a.a.AbstractC0010a
        void a(h r1, Thread r2) {
            r1.f587b = r2;
        }

        @Override // androidx.c.a.a.AbstractC0010a
        void a(h r1, h r2) {
            r1.f588c = r2;
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, h r2, h r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.f568e != r2) goto L9;
            r1.f568e = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, d r2, d r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.f567d != r2) goto L9;
            r1.f567d = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // androidx.c.a.a.AbstractC0010a
        boolean a(a<?> r1, Object r2, Object r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.f566c != r2) goto L9;
            r1.f566c = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }
    }

    /* JADX INFO: compiled from: AbstractResolvableFuture.java */
    private static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f586a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Thread f587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile h f588c;

        static {
            f586a = new h(false);
        }

        h(boolean r1) {
        }

        h() {
            a.f565b.a(this, Thread.currentThread());
        }

        void a(h r2) {
            a.f565b.a(this, r2);
        }

        void a() {
            Thread r0 = this.f587b;
            if (r0 == null) goto L6;
            this.f587b = null;
            LockSupport.unpark(r0);
            return;
        }
    }

    public void a() {
    }

    public void b() {
    }

    static {
        f564a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        f = Logger.getLogger(a.class.getName());
        AbstractC0010a r2 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "e"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "d"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "c"));     // Catch: Throwable -> L5
        th = null;
    L7:
        f565b = r2;
        if (th == null) goto L10;
        f.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        g = new Object();
        return;
    L5:
        th = th;
        r2 = new g();
        goto L7
    }

    private void a(h r5) {
        r5.f587b = null;
    L3:
        h r6 = this.f568e;
        if (r6 == h.f586a) goto L5;
        h r1 = null;
    L7:
        if (r6 == null) goto L19;
        h r2 = r6.f588c;
        if (r6.f587b == null) goto L11;
        r1 = r6;
    L18:
        r6 = r2;
        goto L7
    L11:
        if (r1 == null) goto L16;
        r1.f588c = r2;
        if (r1.f587b != null) goto L18;
    L16:
        if (f565b.a(this, r6, r2) == true) goto L18;
    L19:
        return;
    }

    public a() {
    }

    @Override // java.util.concurrent.Future
    public final V get(long r20, TimeUnit r22) {
        long r4 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r6 = this.f566c;
        if (r6 == null) goto L7;
        boolean r9 = true;
    L9:
        if ((r9 & (!ZeusTransformUtils.instanceOf(r6, f.class))) == false) goto L13;
        return c(r6);
    L13:
        if (r4 <= 0) goto L15;
        long r11 = System.nanoTime() + r4;
    L17:
        if (r4 < 1000) goto L43;
        h r7 = this.f568e;
        if (r7 == h.f586a) goto L41;
        h r15 = new h();
    L21:
        r15.a(r7);
        if (f565b.a(this, r7, r15) == true) goto L23;
        r7 = this.f568e;
        if (r7 != h.f586a) goto L21;
    L23:
        LockSupport.parkNanos(this, r4);
        if (Thread.interrupted() == true) goto L36;
        Object r5 = this.f566c;
        if (r5 == null) goto L28;
        boolean r8 = true;
    L30:
        if ((r8 & (!ZeusTransformUtils.instanceOf(r5, f.class))) == true) goto L32;
        r4 = r11 - System.nanoTime();
        if (r4 >= 1000) goto L23;
        a(r15);
        goto L43
    L32:
        return c(r5);
    L28:
        r8 = false;
        goto L30
    L36:
        a(r15);
        throw new InterruptedException();
    L41:
        return c(this.f566c);
    L43:
        if (r4 <= 0) goto L57;
        Object r10 = this.f566c;
        if (r10 == null) goto L47;
        boolean r12 = true;
    L49:
        if ((r12 & (!ZeusTransformUtils.instanceOf(r10, f.class))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r4 = r11 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return c(r10);
    L47:
        r12 = false;
        goto L49
    L57:
        String r13 = toString();
        String r14 = r22.toString().toLowerCase(Locale.ROOT);
        String r1 = "Waited " + r20 + " " + r22.toString().toLowerCase(Locale.ROOT);
        if ((r4 + 1000) >= 0) goto L75;
        String r2 = r1 + " (plus ";
        long r16 = -r4;
        long r17 = r22.convert(r16, TimeUnit.NANOSECONDS);
        long r18 = r16 - r22.toNanos(r17);
        if (r17 != 0) goto L62;
    L65:
        boolean r19 = true;
    L66:
        if (r17 <= 0) goto L71;
        String r3 = r2 + r17 + " " + r14;
        if (r19 == false) goto L70;
        r3 = r3 + ",";
    L70:
        r2 = r3 + " ";
    L71:
        if (r19 == false) goto L73;
        r2 = r2 + r18 + " nanoseconds ";
    L73:
        r1 = r2 + "delay)";
        goto L75
    L62:
        if (r18 > 1000) goto L65;
        r19 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r1 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r1 + " for " + r13);
    L15:
        r11 = 0;
        goto L17
    L7:
        r9 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        if (Thread.interrupted() == true) goto L34;
        Object r0 = this.f566c;
        if (r0 == null) goto L7;
        boolean r3 = true;
    L9:
        if ((r3 & (!ZeusTransformUtils.instanceOf(r0, f.class))) == true) goto L11;
        h r1 = this.f568e;
        if (r1 == h.f586a) goto L32;
        h r4 = new h();
    L15:
        r4.a(r1);
        if (f565b.a(this, r1, r4) == true) goto L17;
        r1 = this.f568e;
        if (r1 != h.f586a) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r2 = this.f566c;
        if (r2 == null) goto L22;
        boolean r5 = true;
    L24:
        if ((r5 & (!ZeusTransformUtils.instanceOf(r2, f.class))) == false) goto L17;
        return c(r2);
    L22:
        r5 = false;
        goto L24
    L27:
        a(r4);
        throw new InterruptedException();
    L32:
        return c(this.f566c);
    L11:
        return c(r0);
    L7:
        r3 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V c(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L12;
        if (r3 != g) goto L10;
        return null;
    L10:
        return r3;
    L12:
        throw new ExecutionException(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin")).f574b);
    L14:
        throw a("Task was cancelled.", ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).f572d);
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r3 = this.f566c;
        if (r3 == null) goto L5;
        boolean r1 = true;
    L7:
        return (!ZeusTransformUtils.instanceOf(r3, f.class)) & r1;
    L5:
        r1 = false;
        goto L7
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return ZeusTransformUtils.instanceOf(this.f566c, b.class);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r8) {
        Object r1 = this.f566c;
        if (r1 != null) goto L5;
        boolean r4 = true;
    L7:
        if ((r4 | ZeusTransformUtils.instanceOf(r1, f.class)) == false) goto L35;
        if (f564a == false) goto L11;
        b r5 = new b(r8, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r6 = false;
    L16:
        if (f565b.a(this, r1, r5) == true) goto L17;
        r1 = this.f566c;
        if (ZeusTransformUtils.instanceOf(r1, f.class) == true) goto L16;
        return r6;
    L17:
        if (r8 == false) goto L19;
        this.a();
    L19:
        a(this);
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L47;
        ListenableFuture<? extends V> r7 = ((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin")).f585b;
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L30;
        a<V> this = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        r1 = this.f566c;
        if (r1 != null) goto L26;
        boolean r9 = true;
    L28:
        if ((r9 | ZeusTransformUtils.instanceOf(r1, f.class)) == false) goto L48;
        r6 = true;
        goto L16
    L48:
        return true;
    L26:
        r9 = false;
        goto L28
    L30:
        r7.cancel(r8);
        return true;
    L47:
        return true;
    L11:
        if (r8 == false) goto L13;
        r5 = b.f569a;
        goto L14
    L13:
        r5 = b.f570b;
        goto L14
    L35:
        return false;
    L5:
        r4 = false;
        goto L7
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable r4, Executor r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        b(r6);
        b(r7);
        d r0 = this.f567d;
        if (r0 == d.f575a) goto L10;
        d r1 = new d(r6, r7);
    L5:
        r1.f578d = r0;
        if (f565b.a(this, r0, r1) == true) goto L7;
        r0 = this.f567d;
        if (r0 != d.f575a) goto L5;
    L7:
        return;
    L10:
        a(r6, r7);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean a(V r3) {
        if (r3 != null) goto L5;
        r3 = (V) g;
    L5:
        if (f565b.a(this, null, r3) == false) goto L8;
        a(this);
        return true;
    L8:
        return false;
    }

    static Object a(ListenableFuture<?> r5) {
        ListenableFuture r6 = (ListenableFuture) ZeusTransformUtils.wrapperContextForParams(r5, ListenableFuture.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, a.class) == false) goto L13;
        Object r7 = ((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.aiagent.plugin")).f566c;
        if (ZeusTransformUtils.instanceOf(r7, b.class) == false) goto L35;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.aiagent.plugin");
        if (r0.f571c == true) goto L9;
        return r7;
    L9:
        if (r0.f572d == null) goto L12;
        return new b(false, r0.f572d);
    L12:
        return b.f570b;
    L35:
        return r7;
    L13:
        boolean r1 = r6.isCancelled();
        if (((!f564a) & r1) == true) goto L16;
        Object r2 = a(r6);     // Catch: Throwable -> L21 CancellationException -> L24 ExecutionException -> L30
        if (r2 != null) goto L38;
        return g;
    L38:
        return r2;
    L24:
        e = move-exception;
        if (r1 == true) goto L29;
        return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r6, e));
    L29:
        return new b(false, e);
    L30:
        e = move-exception;
        return new c(e.getCause());
    L21:
        th = move-exception;
        return new c(th);
    L16:
        return b.f570b;
    }

    static <V> V a(Future<V> r2) {
        Future r3 = (Future) ZeusTransformUtils.wrapperContextForParams(r2, Future.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
    L12:
        V r4 = (V) r3.get();
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r4;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    static void a(a<?> r4) {
        d r0 = null;
        a r5 = r4;
    L3:
        r5.d();
        r5.b();
        d r6 = r5.a(r0);
    L4:
        if (r6 == null) goto L14;
        r0 = r6.f578d;
        Runnable r1 = r6.f576b;
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L12;
        f r7 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin");
        a<V> r2 = r7.f584a;
        if (r2.f566c != r7) goto L13;
        Object r3 = a(r7.f585b);
        if (f565b.a(r2, r7, r3) == false) goto L13;
        r5 = r2;
    L13:
        r6 = r0;
        goto L4
    L12:
        a(r1, r6.f577c);
        goto L13
    }

    private void d() {
    L2:
        h r0 = this.f568e;
        if (f565b.a(this, r0, h.f586a) == false) goto L2;
    L4:
        if (r0 == null) goto L6;
        r0.a();
        r0 = r0.f588c;
        goto L4
    }

    private d a(d r4) {
    L2:
        d r0 = this.f567d;
        if (f565b.a(this, r0, d.f575a) == false) goto L2;
    L4:
        d r3 = r4;
        r4 = r0;
        if (r4 == null) goto L7;
        r0 = r4.f578d;
        r4.f578d = r3;
        goto L4
    L7:
        return r3;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString()).append("[status=");
        if (isCancelled() == false) goto L6;
        r0.append("CANCELLED");
    L21:
        return r0.append("]").toString();
    L6:
        if (isDone() == false) goto L22;
        a(r0);
        goto L21
    L22:
        String r1 = c();     // Catch: RuntimeException -> L10
    L12:
        if (r1 == null) goto L17;
        if (r1.isEmpty() == true) goto L17;
        r0.append("PENDING, info=[").append(r1).append("]");
    L17:
        if (isDone() == false) goto L19;
        a(r0);
        goto L21
    L19:
        r0.append("PENDING");
    L10:
        e = move-exception;
        r1 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    public String c() {
        Object r0 = this.f566c;
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L7;
        return "setFuture=[" + d(((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.aiagent.plugin")).f585b) + "]";
    L7:
        if (ZeusTransformUtils.instanceOf(this, ScheduledFuture.class) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) ZeusTransformUtils.preCheckCast(this, ScheduledFuture.class, "com.obric.aiagent.plugin")).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    private void a(StringBuilder r4) {
        Object r1 = a(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("SUCCESS, result=[").append(d(r1)).append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
    L15:
        return;
    L7:
        r4.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r4.append("UNKNOWN, cause=[").append(e.getClass()).append(" thrown from get()]");
        return;
    L8:
        e = move-exception;
        r4.append("FAILURE, cause=[").append(e.getCause()).append("]");
    }

    private String d(Object r1) {
        if (r1 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r1);
    }

    private static void a(Runnable r5, Executor r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.aiagent.plugin");
        r8.execute(r7);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        f.log(Level.SEVERE, "RuntimeException while executing runnable " + r7 + " with executor " + r8, e);
    }

    private static CancellationException a(String r1, Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }

    static <T> T b(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }
}
