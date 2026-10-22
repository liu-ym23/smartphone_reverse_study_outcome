package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class r0 extends s0 implements Delay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21663f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21664g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21665h = null;

    @Volatile
    @Nullable
    private volatile Object _delayed;

    @Volatile
    private volatile int _isCompleted;

    @Volatile
    @Nullable
    private volatile Object _queue;

    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CancellableContinuation f21666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r0 f21667d;

        public a(r0 r10, long r11, CancellableContinuation r12) {
            this.f21667d = r10;
            super(r11);
            this.f21666c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21666c.resumeUndispatched(this.f21667d, Unit.f21064a);
        }

        @Override // kotlinx.coroutines.r0.c
        public String toString() {
            return super.toString() + this.f21666c;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f21668c;

        public b(long r10, Runnable r11) {
            super(r10);
            this.f21668c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21668c.run();
        }

        @Override // kotlinx.coroutines.r0.c
        public String toString() {
            return super.toString() + this.f21668c;
        }
    }

    public static abstract class c implements Runnable, Comparable, DisposableHandle, ThreadSafeHeapNode {

        @Nullable
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f21669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21670b;

        public c(long r10) {
            this.f21669a = r10;
            this.f21670b = -1;
        }

        public int a(c r10) {
            long r11 = this.f21669a - r10.f21669a;
            if (r11 <= 0) goto L5;
            return 1;
        L5:
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final int b(long r10, d r11, r0 r12) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != u0.b()) goto L8;
            monitor-exit(this);
            return 2;
        L8:
            monitor-enter(r11);     // Catch: Throwable -> L15
            c r13 = (c) r11.b();     // Catch: Throwable -> L20
            if (r0.t(r12) == false) goto L18;
            monitor-exit(r11);     // Catch: Throwable -> L15
            monitor-exit(this);
            return 1;
        L18:
            if (r13 != null) goto L22;
            r11.f21671c = r10;     // Catch: Throwable -> L20
        L29:
            long r14 = this.f21669a;     // Catch: Throwable -> L20
            long r15 = r11.f21671c;     // Catch: Throwable -> L20
            if ((r14 - r15) >= 0) goto L32;
            this.f21669a = r15;     // Catch: Throwable -> L20
        L32:
            r11.a(this);     // Catch: Throwable -> L20
            monitor-exit(r11);     // Catch: Throwable -> L15
            monitor-exit(this);
            return 0;
        L22:
            long r16 = r13.f21669a;     // Catch: Throwable -> L20
            if ((r16 - r10) >= 0) goto L27;
            r10 = r16;
        L27:
            if ((r10 - r11.f21671c) <= 0) goto L29;
            r11.f21671c = r10;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        }

        public final boolean c(long r10) {
            if ((r10 - this.f21669a) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return a((c) r10);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            monitor-enter(this);
            Object r10 = this._heap;     // Catch: Throwable -> L10
            if (r10 != u0.b()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r10 instanceof d) == false) goto L12;
            d r11 = (d) r10;     // Catch: Throwable -> L10
        L13:
            if (r11 == null) goto L15;
            r11.g(this);     // Catch: Throwable -> L10
        L15:
            this._heap = u0.b();     // Catch: Throwable -> L10
            Unit r12 = Unit.f21064a;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L12:
            r11 = null;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public kotlinx.coroutines.internal.i0 getHeap() {
            Object r10 = this._heap;
            if ((r10 instanceof kotlinx.coroutines.internal.i0) == true) goto L7;
            return null;
        L7:
            return (kotlinx.coroutines.internal.i0) r10;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.f21670b;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(kotlinx.coroutines.internal.i0 r10) {
            if (this._heap == u0.b()) goto L7;
            this._heap = r10;
            return;
        L7:
            throw new IllegalArgumentException("Failed requirement.");
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int r10) {
            this.f21670b = r10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f21669a + ']';
        }
    }

    public static final class d extends kotlinx.coroutines.internal.i0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21671c;

        public d(long r10) {
            this.f21671c = r10;
        }
    }

    static {
        f21663f = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_queue");
        f21664g = AtomicReferenceFieldUpdater.newUpdater(r0.class, Object.class, "_delayed");
        f21665h = AtomicIntegerFieldUpdater.newUpdater(r0.class, "_isCompleted");
    }

    public r0() {
        this._isCompleted = 0;
    }

    private final boolean isCompleted() {
        if (f21665h.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final /* synthetic */ boolean t(r0 r10) {
        return r10.isCompleted();
    }

    public final void A() {
        f21663f.set(this, null);
        f21664g.set(this, null);
    }

    public final void B(long r10, c r11) {
        int r12 = C(r10, r11);
        if (r12 == 0) goto L13;
        if (r12 != 1) goto L7;
        r(r10, r11);
        return;
    L7:
        if (r12 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result");
    L13:
        if (F(r11) == false) goto L17;
        s();
        return;
    }

    public final int C(long r10, c r11) {
        if (isCompleted() == false) goto L6;
        return 1;
    L6:
        AtomicReferenceFieldUpdater r12 = f21664g;
        d r13 = (d) r12.get(this);
        if (r13 != null) goto L10;
        androidx.concurrent.futures.a.a(r12, this, null, new d(r10));
        Object r14 = r12.get(this);
        kotlin.jvm.internal.q.d(r14);
        r13 = (d) r14;
    L10:
        return r11.b(r10, r13, this);
    }

    public final DisposableHandle D(long r10, Runnable r11) {
        long r12 = u0.d(r10);
        if (r12 >= 4611686018427387903L) goto L6;
        kotlinx.coroutines.c.a();
        long r13 = System.nanoTime();
        b r14 = new b(r12 + r13, r11);
        B(r13, r14);
        return r14;
    L6:
        return r1.f21672a;
    }

    public final void E(boolean r10) {
        f21665h.set(this, r10 ? 1 : 0);
    }

    public final boolean F(c r10) {
        d r11 = (d) f21664g.get(this);
        if (r11 == null) goto L5;
        c r12 = (c) r11.e();
    L6:
        if (r12 != r10) goto L8;
        return true;
    L8:
        return false;
    L5:
        r12 = null;
        goto L6
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void a(CoroutineContext r10, Runnable r11) {
        w(r11);
    }

    @Override // kotlinx.coroutines.Delay
    public Object delay(long r10, Continuation r11) {
        return Delay.a.a(this, r10, r11);
    }

    @Override // kotlinx.coroutines.q0
    public long i() {
        if (super.i() != 0) goto L5;
        return 0;
    L5:
        Object r10 = f21663f.get(this);
        if (r10 != null) goto L8;
    L16:
        d r11 = (d) f21664g.get(this);
        if (r11 == null) goto L23;
        c r12 = (c) r11.e();
        if (r12 == null) goto L23;
        long r13 = r12.f21669a;
        kotlinx.coroutines.c.a();
        return bg.h.e(r13 - System.nanoTime(), 0);
    L23:
        return Long.MAX_VALUE;
    L8:
        if ((r10 instanceof kotlinx.coroutines.internal.q) == false) goto L13;
        if (((kotlinx.coroutines.internal.q) r10).g() == true) goto L16;
        return 0;
    L13:
        if (r10 != u0.a()) goto L15;
        return Long.MAX_VALUE;
    L15:
        return 0;
    }

    public DisposableHandle invokeOnTimeout(long r10, Runnable r11, CoroutineContext r12) {
        return Delay.a.b(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.q0
    public long n() {
        if (o() == false) goto L5;
        return 0;
    L5:
        d r10 = (d) f21664g.get(this);
        if (r10 != null) goto L8;
    L30:
        Runnable r11 = v();
        if (r11 == null) goto L35;
        r11.run();
        return 0;
    L35:
        return i();
    L8:
        if (r10.d() == true) goto L30;
        kotlinx.coroutines.c.a();
        long r12 = System.nanoTime();
    L10:
        monitor-enter(r10);
        ThreadSafeHeapNode r13 = r10.b();     // Catch: Throwable -> L19
        ThreadSafeHeapNode r14 = null;
        if (r13 != null) goto L16;
        monitor-exit(r10);
    L26:
        if (((c) r14) != null) goto L10;
    L16:
        c r15 = (c) r13;     // Catch: Throwable -> L19
        if (r15.c(r12) == false) goto L21;
        boolean r16 = x(r15);     // Catch: Throwable -> L19
    L22:
        if (r16 == false) goto L24;
        r14 = r10.h(0);     // Catch: Throwable -> L19
    L24:
        monitor-exit(r10);
        goto L26
    L21:
        r16 = false;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long r10, CancellableContinuation r11) {
        long r12 = u0.d(r10);
        if (r12 >= 4611686018427387903L) goto L6;
        kotlinx.coroutines.c.a();
        long r13 = System.nanoTime();
        a r14 = new a(this, r12 + r13, r11);
        B(r13, r14);
        p.a(r11, r14);
        return;
    }

    @Override // kotlinx.coroutines.q0
    public void shutdown() {
        z1.f21774a.c();
        E(true);
        u();
    L4:
        if (n() <= 0) goto L4;
        z();
    }

    public final void u() {
        AtomicReferenceFieldUpdater r10 = f21663f;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L6;
        if ((r11 instanceof kotlinx.coroutines.internal.q) == true) goto L10;
        if (r11 == u0.a()) goto L14;
        kotlinx.coroutines.internal.q r12 = new kotlinx.coroutines.internal.q(8, true);
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r12.a((Runnable) r11);
        if (androidx.concurrent.futures.a.a(f21663f, this, r11, r12) == false) goto L3;
        return;
    L14:
        return;
    L10:
        ((kotlinx.coroutines.internal.q) r11).d();
        return;
    L6:
        if (androidx.concurrent.futures.a.a(f21663f, this, null, u0.a()) == false) goto L3;
    }

    public final Runnable v() {
        AtomicReferenceFieldUpdater r10 = f21663f;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if ((r11 instanceof kotlinx.coroutines.internal.q) == true) goto L8;
        if (r11 == u0.a()) goto L15;
        if (androidx.concurrent.futures.a.a(f21663f, this, r11, null) == false) goto L3;
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable) r11;
    L15:
        return null;
    L8:
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r12 = (kotlinx.coroutines.internal.q) r11;
        Object r13 = r12.j();
        if (r13 != kotlinx.coroutines.internal.q.f21619h) goto L11;
        androidx.concurrent.futures.a.a(f21663f, this, r11, r12.i());
        goto L3
    L11:
        return (Runnable) r13;
    L5:
        return null;
    }

    public void w(Runnable r10) {
        if (x(r10) == false) goto L5;
        s();
        return;
    L5:
        f0.f21422i.w(r10);
    }

    public final boolean x(Runnable r10) {
        AtomicReferenceFieldUpdater r11 = f21663f;
    L3:
        Object r12 = r11.get(this);
        if (isCompleted() == true) goto L5;
        if (r12 == null) goto L9;
        if ((r12 instanceof kotlinx.coroutines.internal.q) == true) goto L13;
        if (r12 == u0.a()) goto L24;
        kotlinx.coroutines.internal.q r13 = new kotlinx.coroutines.internal.q(8, true);
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r13.a((Runnable) r12);
        r13.a(r10);
        if (androidx.concurrent.futures.a.a(f21663f, this, r12, r13) == false) goto L3;
        return true;
    L24:
        return false;
    L13:
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        kotlinx.coroutines.internal.q r14 = (kotlinx.coroutines.internal.q) r12;
        int r15 = r14.a(r10);
        if (r15 == 0) goto L21;
        if (r15 != 1) goto L17;
        androidx.concurrent.futures.a.a(f21663f, this, r12, r14.i());
        goto L3
    L17:
        if (r15 != 2) goto L3;
        return false;
    L21:
        return true;
    L9:
        if (androidx.concurrent.futures.a.a(f21663f, this, null, r10) == false) goto L3;
        return true;
    L5:
        return false;
    }

    public boolean y() {
        if (m() == true) goto L5;
        return false;
    L5:
        d r10 = (d) f21664g.get(this);
        if (r10 != null) goto L8;
    L10:
        Object r11 = f21663f.get(this);
        if (r11 != null) goto L14;
    L19:
        return true;
    L14:
        if ((r11 instanceof kotlinx.coroutines.internal.q) == false) goto L17;
        return ((kotlinx.coroutines.internal.q) r11).g();
    L17:
        if (r11 == u0.a()) goto L19;
        return false;
    L8:
        if (r10.d() == true) goto L10;
        return false;
    }

    public final void z() {
        kotlinx.coroutines.c.a();
        long r10 = System.nanoTime();
    L3:
        d r11 = (d) f21664g.get(this);
        if (r11 == null) goto L9;
        c r12 = (c) r11.i();
        if (r12 == null) goto L12;
        r(r10, r12);
        goto L3
    L12:
        return;
    }
}
