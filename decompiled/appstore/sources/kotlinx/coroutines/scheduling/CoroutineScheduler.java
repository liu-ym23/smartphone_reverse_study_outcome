package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import bg.h;
import dg.g;
import dg.i;
import dg.j;
import dg.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.q;
import kotlin.random.Random;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.w;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f21675h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21676i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21677j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f21678k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f21679l = null;

    @Volatile
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21682c;

    @Volatile
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21683d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dg.c f21684e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dg.c f21685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f21686g;

    @Volatile
    private volatile long parkedWorkersStack;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum WorkerState extends Enum<WorkerState> {
        private static final /* synthetic */ WorkerState[] $VALUES = null;
        public static final WorkerState BLOCKING = null;
        public static final WorkerState CPU_ACQUIRED = null;
        public static final WorkerState DORMANT = null;
        public static final WorkerState PARKING = null;
        public static final WorkerState TERMINATED = null;

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        static {
            CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
            BLOCKING = new WorkerState("BLOCKING", 1);
            PARKING = new WorkerState("PARKING", 2);
            DORMANT = new WorkerState("DORMANT", 3);
            TERMINATED = new WorkerState("TERMINATED", 4);
            $VALUES = $values();
        }

        private WorkerState(String r10, int r11) {
            super(r10, r11);
        }

        public static WorkerState valueOf(String r10) {
            return (WorkerState) Enum.valueOf(WorkerState.class, r10);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21687a = null;

        static {
            int[] r10 = new int[WorkerState.values().length];
            r10[WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r10[WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r10[WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r10[WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f21687a = r10;
        }
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f21688i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f21689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Ref$ObjectRef f21690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WorkerState f21691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f21692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f21693e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f21694f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f21695g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ CoroutineScheduler f21696h;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @Volatile
        private volatile int workerCtl;

        static {
            f21688i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        }

        public c(CoroutineScheduler r10) {
            this.f21696h = r10;
            setDaemon(true);
            this.f21689a = new l();
            this.f21690b = new Ref$ObjectRef();
            this.f21691c = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f21679l;
            this.f21694f = Random.Default.nextInt();
        }

        public static final /* synthetic */ CoroutineScheduler a(c r10) {
            return r10.f21696h;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f21688i;
        }

        public final void b(int r10) {
            if (r10 != 0) goto L4;
            return;
        L4:
            CoroutineScheduler r11 = this.f21696h;
            CoroutineScheduler.a().addAndGet(r11, -2097152);
            if (this.f21691c == WorkerState.TERMINATED) goto L8;
            this.f21691c = WorkerState.DORMANT;
            return;
        }

        public final void c(int r10) {
            if (r10 != 0) goto L5;
            return;
        L5:
            if (u(WorkerState.BLOCKING) == false) goto L8;
            this.f21696h.o();
            return;
        }

        public final void d(g r10) {
            int r11 = r10.f19208b.getTaskMode();
            k(r11);
            c(r11);
            this.f21696h.l(r10);
            b(r11);
        }

        public final g e(boolean r10) {
            if (r10 == true) goto L4;
            g r11 = o();
            if (r11 == null) goto L22;
            return r11;
        L22:
            return v(3);
        L4:
            if (m(this.f21696h.f21680a * 2) != 0) goto L6;
            boolean r12 = true;
        L7:
            if (r12 == false) goto L11;
            g r13 = o();
            if (r13 == null) goto L11;
            return r13;
        L11:
            g r14 = this.f21689a.g();
            if (r14 == null) goto L14;
            return r14;
        L14:
            if (r12 == true) goto L22;
            g r15 = o();
            if (r15 == null) goto L22;
            return r15;
        L6:
            r12 = false;
            goto L7
        }

        public final g f() {
            g r10 = this.f21689a.h();
            if (r10 != null) goto L8;
            g r11 = (g) this.f21696h.f21685f.d();
            if (r11 == null) goto L7;
            return r11;
        L7:
            return v(1);
        L8:
            return r10;
        }

        public final g g(boolean r10) {
            if (s() == false) goto L7;
            return e(r10);
        L7:
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int r10) {
            this.f21692d = 0;
            if (this.f21691c != WorkerState.PARKING) goto L6;
            this.f21691c = WorkerState.BLOCKING;
            return;
        }

        public final boolean l() {
            if (this.nextParkedWorker == CoroutineScheduler.f21679l) goto L5;
            return true;
        L5:
            return false;
        }

        public final int m(int r10) {
            int r11 = this.f21694f;
            int r12 = r11 ^ (r11 << 13);
            int r13 = r12 ^ (r12 >> 17);
            int r14 = r13 ^ (r13 << 5);
            this.f21694f = r14;
            int r15 = r10 - 1;
            if ((r15 & r10) != 0) goto L7;
            return r15 & r14;
        L7:
            return (Integer.MAX_VALUE & r14) % r10;
        }

        public final void n() {
            if (this.f21692d != 0) goto L5;
            this.f21692d = System.nanoTime() + this.f21696h.f21682c;
        L5:
            LockSupport.parkNanos(this.f21696h.f21682c);
            if ((System.nanoTime() - this.f21692d) < 0) goto L9;
            this.f21692d = 0;
            w();
            return;
        }

        public final g o() {
            if (m(2) != 0) goto L9;
            g r10 = (g) this.f21696h.f21684e.d();
            if (r10 == null) goto L8;
            return r10;
        L8:
            return (g) this.f21696h.f21685f.d();
        L9:
            g r11 = (g) this.f21696h.f21685f.d();
            if (r11 == null) goto L13;
            return r11;
        L13:
            return (g) this.f21696h.f21684e.d();
        }

        public final void p() {
        L3:
            boolean r10 = false;
        L5:
            if (this.f21696h.isTerminated() == true) goto L17;
            if (this.f21691c == WorkerState.TERMINATED) goto L17;
            g r11 = g(this.f21695g);
            if (r11 != null) goto L10;
            this.f21695g = false;
            if (this.f21693e != 0) goto L13;
            t();
            goto L5
        L13:
            if (r10 == true) goto L15;
            r10 = true;
            goto L5
        L15:
            u(WorkerState.PARKING);
            Thread.interrupted();
            LockSupport.parkNanos(this.f21693e);
            this.f21693e = 0;
            goto L3
        L10:
            this.f21693e = 0;
            d(r11);
        L17:
            u(WorkerState.TERMINATED);
        }

        public final void q(int r10) {
            StringBuilder r11 = new StringBuilder();
            r11.append(this.f21696h.f21683d);
            r11.append("-worker-");
            if (r10 != 0) goto L5;
            String r12 = "TERMINATED";
        L6:
            r11.append(r12);
            setName(r11.toString());
            this.indexInArray = r10;
            return;
        L5:
            r12 = String.valueOf(r10);
            goto L6
        }

        public final void r(Object r10) {
            this.nextParkedWorker = r10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean s() {
            if (this.f21691c == WorkerState.CPU_ACQUIRED) goto L17;
            CoroutineScheduler r10 = this.f21696h;
            AtomicLongFieldUpdater r11 = CoroutineScheduler.a();
        L6:
            long r12 = r11.get(r10);
            if (((int) ((9223367638808264704L & r12) >> 42)) == 0) goto L8;
            AtomicLongFieldUpdater r13 = CoroutineScheduler.a();
            if (r13.compareAndSet(r10, r12, r12 - 4398046511104L) == false) goto L6;
            this.f21691c = WorkerState.CPU_ACQUIRED;
            return true;
        L8:
            return false;
        L17:
            return true;
        }

        public final void t() {
            if (l() == true) goto L6;
            this.f21696h.j(this);
            return;
        L6:
            f21688i.set(this, -1);
        L8:
            if (l() == false) goto L17;
            if (f21688i.get(this) != (-1)) goto L22;
            if (this.f21696h.isTerminated() == true) goto L23;
            if (this.f21691c == WorkerState.TERMINATED) goto L24;
            u(WorkerState.PARKING);
            Thread.interrupted();
            n();
            goto L8
        L24:
            return;
        L23:
            return;
        L22:
            return;
        }

        public final boolean u(WorkerState r10) {
            WorkerState r11 = this.f21691c;
            if (r11 != WorkerState.CPU_ACQUIRED) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L8;
            CoroutineScheduler r13 = this.f21696h;
            CoroutineScheduler.a().addAndGet(r13, 4398046511104L);
        L8:
            if (r11 == r10) goto L10;
            this.f21691c = r10;
        L10:
            return r12;
        L5:
            r12 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final g v(int r18) {
            int r10 = (int) (CoroutineScheduler.a().get(this.f21696h) & 2097151);
            if (r10 >= 2) goto L5;
            return null;
        L5:
            int r11 = m(r10);
            CoroutineScheduler r12 = this.f21696h;
            int r13 = 0;
            long r14 = Long.MAX_VALUE;
        L7:
            if (r13 >= r10) goto L24;
            r11 = r11 + 1;
            if (r11 <= r10) goto L11;
            r11 = 1;
        L11:
            c r15 = (c) r12.f21686g.b(r11);
            if (r15 == null) goto L22;
            if (r15 == this) goto L22;
            long r16 = r15.f21689a.n(r18, this.f21690b);
            if (r16 == (-1)) goto L16;
            if (r16 <= 0) goto L22;
            r14 = Math.min(r14, r16);
            goto L22
        L16:
            Ref$ObjectRef r17 = this.f21690b;
            g r19 = (g) r17.element;
            r17.element = null;
            return r19;
        L22:
            r13 = r13 + 1;
            goto L7
        L24:
            if (r14 != Long.MAX_VALUE) goto L27;
            r14 = 0;
        L27:
            this.f21693e = r14;
            return null;
        }

        public final void w() {
            CoroutineScheduler r10 = this.f21696h;
            w r11 = r10.f21686g;
            monitor-enter(r11);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (r10.isTerminated() == false) goto L9;
            monitor-exit(r11);
            return;
        L9:
            if (((int) (CoroutineScheduler.a().get(r10) & 2097151)) > r10.f21680a) goto L13;
            monitor-exit(r11);
            return;
        L13:
            if (f21688i.compareAndSet(this, -1, 1) == true) goto L16;
            monitor-exit(r11);
            return;
        L16:
            int r12 = this.indexInArray;     // Catch: Throwable -> L19
            q(0);     // Catch: Throwable -> L19
            r10.k(this, r12, 0);     // Catch: Throwable -> L19
            int r13 = (int) (CoroutineScheduler.a().getAndDecrement(r10) & 2097151);     // Catch: Throwable -> L19
            if (r13 == r12) goto L21;
            Object r14 = r10.f21686g.b(r13);     // Catch: Throwable -> L19
            q.d(r14);     // Catch: Throwable -> L19
            c r15 = (c) r14;     // Catch: Throwable -> L19
            r10.f21686g.c(r12, r15);     // Catch: Throwable -> L19
            r15.q(r12);     // Catch: Throwable -> L19
            r10.k(r15, r13, r12);     // Catch: Throwable -> L19
        L21:
            r10.f21686g.c(r13, null);     // Catch: Throwable -> L19
            Unit r16 = Unit.f21064a;     // Catch: Throwable -> L19
            monitor-exit(r11);
            this.f21691c = WorkerState.TERMINATED;
        }

        public c(CoroutineScheduler r10, int r11) {
            this(r10);
            q(r11);
        }
    }

    static {
        f21675h = new a(null);
        f21676i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
        f21677j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
        f21678k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
        f21679l = new b0("NOT_IN_STACK");
    }

    public CoroutineScheduler(int r10, int r11, long r12, String r13) {
        this.f21680a = r10;
        this.f21681b = r11;
        this.f21682c = r12;
        this.f21683d = r13;
        if (r10 < 1) goto L19;
        if (r11 < r10) goto L17;
        if (r11 > 2097150) goto L15;
        if (r12 <= 0) goto L13;
        this.f21684e = new dg.c();
        this.f21685f = new dg.c();
        this.f21686g = new w((r10 + 1) * 2);
        this.controlState = ((long) r10) << 42;
        this._isTerminated = 0;
        return;
    L13:
        throw new IllegalArgumentException(("Idle worker keep alive time " + r12 + " must be positive").toString());
    L15:
        throw new IllegalArgumentException(("Max pool size " + r11 + " should not exceed maximal supported number of threads 2097150").toString());
    L17:
        throw new IllegalArgumentException(("Max pool size " + r11 + " should be greater than or equals to core pool size " + r10).toString());
    L19:
        throw new IllegalArgumentException(("Core pool size " + r10 + " should be at least 1").toString());
    }

    public static final /* synthetic */ AtomicLongFieldUpdater a() {
        return f21677j;
    }

    public static /* synthetic */ void g(CoroutineScheduler r10, Runnable r11, TaskContext r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = j.f19217g;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = false;
    L8:
        r10.f(r11, r12, r13);
    }

    public static /* synthetic */ boolean r(CoroutineScheduler r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = f21677j.get(r10);
    L6:
        return r10.q(r11);
    }

    public final boolean b(g r10) {
        if (r10.f19208b.getTaskMode() != 1) goto L6;
        return this.f21685f.a(r10);
    L6:
        return this.f21684e.a(r10);
    }

    public final int c() {
        w r10 = this.f21686g;
        monitor-enter(r10);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (isTerminated() == false) goto L9;
        monitor-exit(r10);
        return -1;
    L9:
        AtomicLongFieldUpdater r11 = f21677j;     // Catch: Throwable -> L30
        long r12 = r11.get(this);     // Catch: Throwable -> L30
        int r13 = (int) (r12 & 2097151);     // Catch: Throwable -> L30
        int r14 = h.d(r13 - ((int) ((r12 & 4398044413952L) >> 21)), 0);     // Catch: Throwable -> L30
        if (r14 < this.f21680a) goto L14;
        monitor-exit(r10);
        return 0;
    L14:
        if (r13 < this.f21681b) goto L17;
        monitor-exit(r10);
        return 0;
    L17:
        int r15 = ((int) (a().get(this) & 2097151)) + 1;     // Catch: Throwable -> L30
        if (r15 <= 0) goto L33;
        if (this.f21686g.b(r15) != null) goto L33;
        c r16 = new c(this, r15);     // Catch: Throwable -> L30
        this.f21686g.c(r15, r16);     // Catch: Throwable -> L30
        if (r15 != ((int) (2097151 & r11.incrementAndGet(this)))) goto L29;
        int r17 = r14 + 1;
        monitor-exit(r10);
        r16.start();
        return r17;
    L29:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L30
    L33:
        throw new IllegalArgumentException("Failed requirement.");     // Catch: Throwable -> L30
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m(10000);
    }

    public final g d(Runnable r10, TaskContext r11) {
        long r12 = j.f19216f.a();
        if ((r10 instanceof g) == false) goto L7;
        g r13 = (g) r10;
        r13.f19207a = r12;
        r13.f19208b = r11;
        return r13;
    L7:
        return new i(r10, r12, r11);
    }

    public final c e() {
        Thread r10 = Thread.currentThread();
        if ((r10 instanceof c) == false) goto L5;
        c r11 = (c) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        if (q.b(c.a(r11), this) == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        g(this, r10, null, false, 6, null);
    }

    public final void f(Runnable r10, TaskContext r11, boolean r12) {
        kotlinx.coroutines.c.a();
        g r13 = d(r10, r11);
        boolean r14 = false;
        if (r13.f19208b.getTaskMode() != 1) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        long r16 = f21677j.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    L9:
        c r17 = e();
        g r18 = p(r17, r13, r12);
        if (r18 != null) goto L12;
    L16:
        if (r12 == false) goto L19;
        if (r17 == null) goto L19;
        r14 = true;
    L19:
        if (r15 == false) goto L21;
        n(r16, r14);
        return;
    L21:
        if (r14 == false) goto L23;
        return;
    L23:
        o();
        return;
    L12:
        if (b(r18) == true) goto L16;
        throw new RejectedExecutionException(this.f21683d + " was terminated");
    L8:
        r16 = 0;
        goto L9
    L5:
        r15 = false;
        goto L6
    }

    public final int h(c r10) {
        Object r11 = r10.i();
    L4:
        if (r11 == f21679l) goto L5;
        if (r11 == null) goto L8;
        c r12 = (c) r11;
        int r13 = r12.h();
        if (r13 != 0) goto L12;
        r11 = r12.i();
        goto L4
    L12:
        return r13;
    L8:
        return 0;
    L5:
        return -1;
    }

    public final c i() {
        AtomicLongFieldUpdater r10 = f21676i;
    L3:
        long r11 = r10.get(this);
        w r12 = this.f21686g;
        c r13 = (c) r12.b((int) (2097151 & r11));
        if (r13 == null) goto L5;
        long r14 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r11) & (-2097152);
        int r15 = h(r13);
        if (r15 < 0) goto L3;
        if (f21676i.compareAndSet(this, r11, ((long) r15) | r14) == false) goto L3;
        r13.r(f21679l);
        return r13;
    L5:
        return null;
    }

    public final boolean isTerminated() {
        if (f21678k.get(this) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean j(c r10) {
        if (r10.i() == f21679l) goto L6;
        return false;
    L6:
        AtomicLongFieldUpdater r11 = f21676i;
    L7:
        long r12 = r11.get(this);
        long r13 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r12) & (-2097152);
        int r14 = r10.h();
        w r15 = this.f21686g;
        r10.r(r15.b((int) (2097151 & r12)));
        if (f21676i.compareAndSet(this, r12, r13 | ((long) r14)) == false) goto L7;
        return true;
    }

    public final void k(c r10, int r11, int r12) {
        AtomicLongFieldUpdater r13 = f21676i;
    L3:
        long r14 = r13.get(this);
        int r15 = (int) (2097151 & r14);
        long r16 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + r14) & (-2097152);
        if (r15 != r11) goto L8;
        if (r12 != 0) goto L7;
        r15 = h(r10);
        goto L8
    L7:
        r15 = r12;
    L8:
        if (r15 < 0) goto L3;
        if (f21676i.compareAndSet(this, r14, r16 | ((long) r15)) == false) goto L3;
    }

    public final void l(g r10) {
        r10.run();     // Catch: Throwable -> L4
    L3:
        kotlinx.coroutines.c.a();
        return;
    L4:
        th = move-exception;
        Thread r11 = Thread.currentThread();     // Catch: Throwable -> L8
        r11.getUncaughtExceptionHandler().uncaughtException(r11, th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        kotlinx.coroutines.c.a();
        throw th;
    }

    public final void m(long r10) {
        if (f21678k.compareAndSet(this, 0, 1) == true) goto L5;
        return;
    L5:
        c r11 = e();
        w r12 = this.f21686g;
        monitor-enter(r12);
        int r13 = (int) (a().get(this) & 2097151);
        monitor-exit(r12);
        if (1 > r13) goto L20;
        int r14 = 1;
    L12:
        Object r15 = this.f21686g.b(r14);
        q.d(r15);
        c r16 = (c) r15;
        if (r16 != r11) goto L15;
    L18:
        if (r14 == r13) goto L20;
        r14 = r14 + 1;
    L15:
        if (r16.isAlive() == false) goto L17;
        LockSupport.unpark(r16);
        r16.join(r10);
        goto L15
    L17:
        r16.f21689a.f(this.f21685f);
    L20:
        this.f21685f.b();
        this.f21684e.b();
    L21:
        if (r11 == null) goto L24;
        g r17 = r11.g(true);
        if (r17 == null) goto L24;
    L32:
        l(r17);
    L24:
        r17 = (g) this.f21684e.d();
        if (r17 != null) goto L32;
        r17 = (g) this.f21685f.d();
        if (r17 != null) goto L32;
        if (r11 == null) goto L30;
        r11.u(WorkerState.TERMINATED);
    L30:
        f21676i.set(this, 0);
        f21677j.set(this, 0);
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public final void n(long r10, boolean r11) {
        if (r11 == false) goto L5;
        return;
    L5:
        if (s() == false) goto L8;
        return;
    L8:
        if (q(r10) == false) goto L10;
        return;
    L10:
        s();
    }

    public final void o() {
        if (s() == false) goto L6;
        return;
    L6:
        if (r(this, 0, 1, null) == false) goto L8;
        return;
    L8:
        s();
    }

    public final g p(c r10, g r11, boolean r12) {
        if (r10 != null) goto L5;
        return r11;
    L5:
        if (r10.f21691c != WorkerState.TERMINATED) goto L8;
        return r11;
    L8:
        if (r11.f19208b.getTaskMode() == 0) goto L10;
    L12:
        r10.f21695g = true;
        return r10.f21689a.a(r11, r12);
    L10:
        if (r10.f21691c != WorkerState.BLOCKING) goto L12;
        return r11;
    }

    public final boolean q(long r10) {
        if (h.d(((int) (2097151 & r10)) - ((int) ((r10 & 4398044413952L) >> 21)), 0) >= this.f21680a) goto L11;
        int r11 = c();
        if (r11 == 1) goto L7;
    L9:
        if (r11 <= 0) goto L11;
        return true;
    L7:
        if (this.f21680a <= 1) goto L9;
        c();
    L11:
        return false;
    }

    public final boolean s() {
    L2:
        c r10 = i();
        if (r10 == null) goto L4;
        if (c.j().compareAndSet(r10, -1, 0) == false) goto L2;
        LockSupport.unpark(r10);
        return true;
    L4:
        return false;
    }

    public String toString() {
        ArrayList r10 = new ArrayList();
        int r11 = this.f21686g.a();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        int r17 = 1;
    L3:
        if (r17 >= r11) goto L26;
        c r18 = (c) this.f21686g.b(r17);
        if (r18 == null) goto L25;
        int r19 = r18.f21689a.e();
        int r20 = b.f21687a[r18.f21691c.ordinal()];
        if (r20 != 1) goto L10;
        r14 = r14 + 1;
        goto L25
    L10:
        if (r20 != 2) goto L12;
        r13 = r13 + 1;
        StringBuilder r21 = new StringBuilder();
        r21.append(r19);
        r21.append('b');
        r10.add(r21.toString());
        goto L25
    L12:
        if (r20 != 3) goto L14;
        r12 = r12 + 1;
        StringBuilder r22 = new StringBuilder();
        r22.append(r19);
        r22.append('c');
        r10.add(r22.toString());
        goto L25
    L14:
        if (r20 != 4) goto L16;
        r15 = r15 + 1;
        if (r19 <= 0) goto L25;
        StringBuilder r23 = new StringBuilder();
        r23.append(r19);
        r23.append('d');
        r10.add(r23.toString());
        goto L25
    L16:
        if (r20 != 5) goto L25;
        r16 = r16 + 1;
    L25:
        r17 = r17 + 1;
        goto L3
    L26:
        long r24 = f21677j.get(this);
        return this.f21683d + '@' + e0.b(this) + "[Pool Size {core = " + this.f21680a + ", max = " + this.f21681b + "}, Worker States {CPU = " + r12 + ", blocking = " + r13 + ", parked = " + r14 + ", dormant = " + r15 + ", terminated = " + r16 + "}, running workers queues = " + r10 + ", global CPU queue size = " + this.f21684e.c() + ", global blocking queue size = " + this.f21685f.c() + ", Control State {created workers= " + ((int) (2097151 & r24)) + ", blocking tasks = " + ((int) ((4398044413952L & r24) >> 21)) + ", CPUs acquired = " + (this.f21680a - ((int) ((9223367638808264704L & r24) >> 42))) + "}]";
    }
}
