package z4;

import b4.C0567b;
import b4.InterfaceC0566a;
import j4.v;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import s4.C1064c;
import s4.M;
import x4.C1289A;
import x4.C1294F;

/* renamed from: z4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ExecutorC1349a implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final C0261a f24077h = new C0261a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f24078i = AtomicLongFieldUpdater.newUpdater(ExecutorC1349a.class, "parkedWorkersStack$volatile");

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f24079j = AtomicLongFieldUpdater.newUpdater(ExecutorC1349a.class, "controlState$volatile");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f24080k = AtomicIntegerFieldUpdater.newUpdater(ExecutorC1349a.class, "_isTerminated$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final C1294F f24081l = new C1294F("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f24082a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24083b;

    /* renamed from: c, reason: collision with root package name */
    public final long f24084c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final String f24085d;

    /* renamed from: e, reason: collision with root package name */
    public final C1352d f24086e;

    /* renamed from: f, reason: collision with root package name */
    public final C1352d f24087f;

    /* renamed from: g, reason: collision with root package name */
    public final C1289A<c> f24088g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* renamed from: z4.a$a, reason: collision with other inner class name */
    public static final class C0261a {
        public /* synthetic */ C0261a(j4.g gVar) {
            this();
        }

        private C0261a() {
        }
    }

    /* renamed from: z4.a$b */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24089a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.f24101c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.f24100b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.f24099a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.f24102d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.f24103e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f24089a = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: z4.a$d */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public static final d f24099a = new d("CPU_ACQUIRED", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final d f24100b = new d("BLOCKING", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final d f24101c = new d("PARKING", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final d f24102d = new d("DORMANT", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final d f24103e = new d("TERMINATED", 4);

        /* renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ d[] f24104f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ InterfaceC0566a f24105g;

        static {
            d[] dVarArrB = b();
            f24104f = dVarArrB;
            f24105g = C0567b.a(dVarArrB);
        }

        private d(String str, int i5) {
        }

        private static final /* synthetic */ d[] b() {
            return new d[]{f24099a, f24100b, f24101c, f24102d, f24103e};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f24104f.clone();
        }
    }

    public ExecutorC1349a(int i5, int i6, long j5, String str) {
        this.f24082a = i5;
        this.f24083b = i6;
        this.f24084c = j5;
        this.f24085d = str;
        if (i5 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i5 + " should be at least 1").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should be greater than or equals to core pool size " + i5).toString());
        }
        if (i6 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i6 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j5 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.f24086e = new C1352d();
        this.f24087f = new C1352d();
        this.f24088g = new C1289A<>((i5 + 1) * 2);
        this.controlState$volatile = i5 << 42;
        this._isTerminated$volatile = 0;
    }

    private final int C(c cVar) {
        Object objI = cVar.i();
        while (objI != f24081l) {
            if (objI == null) {
                return 0;
            }
            c cVar2 = (c) objI;
            int iH = cVar2.h();
            if (iH != 0) {
                return iH;
            }
            objI = cVar2.i();
        }
        return -1;
    }

    private final c D() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f24078i;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            c cVarB = this.f24088g.b((int) (2097151 & j5));
            if (cVarB == null) {
                return null;
            }
            long j6 = (2097152 + j5) & (-2097152);
            int iC = this.C(cVarB);
            if (iC >= 0) {
                ExecutorC1349a executorC1349a = this;
                if (f24078i.compareAndSet(executorC1349a, j5, iC | j6)) {
                    cVarB.r(f24081l);
                    return cVarB;
                }
                this = executorC1349a;
            }
        }
    }

    private final void O(long j5, boolean z5) {
        if (z5 || W() || U(j5)) {
            return;
        }
        W();
    }

    private final h T(c cVar, h hVar, boolean z5) {
        if (cVar == null || cVar.f24093c == d.f24103e) {
            return hVar;
        }
        if (hVar.f24116b.b() == 0 && cVar.f24093c == d.f24100b) {
            return hVar;
        }
        cVar.f24097g = true;
        return cVar.f24091a.a(hVar, z5);
    }

    private final boolean U(long j5) {
        if (kotlin.ranges.l.b(((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21)), 0) < this.f24082a) {
            int iM = m();
            if (iM == 1 && this.f24082a > 1) {
                m();
            }
            if (iM > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean V(ExecutorC1349a executorC1349a, long j5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            j5 = f24079j.get(executorC1349a);
        }
        return executorC1349a.U(j5);
    }

    private final boolean W() {
        c cVarD;
        do {
            cVarD = D();
            if (cVarD == null) {
                return false;
            }
        } while (!c.f24090i.compareAndSet(cVarD, -1, 0));
        LockSupport.unpark(cVarD);
        return true;
    }

    private final boolean c(h hVar) {
        return hVar.f24116b.b() == 1 ? this.f24087f.a(hVar) : this.f24086e.a(hVar);
    }

    private final int m() {
        synchronized (this.f24088g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j5 = f24079j.get(this);
                int i5 = (int) (j5 & 2097151);
                int iB = kotlin.ranges.l.b(i5 - ((int) ((j5 & 4398044413952L) >> 21)), 0);
                if (iB >= this.f24082a) {
                    return 0;
                }
                if (i5 >= this.f24083b) {
                    return 0;
                }
                int i6 = ((int) (w().get(this) & 2097151)) + 1;
                if (i6 <= 0 || this.f24088g.b(i6) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i6);
                this.f24088g.c(i6, cVar);
                if (i6 != ((int) (2097151 & f24079j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i7 = iB + 1;
                cVar.start();
                return i7;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final c r() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !j4.k.b(ExecutorC1349a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void v(ExecutorC1349a executorC1349a, Runnable runnable, i iVar, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            iVar = l.f24125g;
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        executorC1349a.u(runnable, iVar, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater w() {
        return f24079j;
    }

    public final boolean E(c cVar) {
        if (cVar.i() != f24081l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f24078i;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int iH = cVar.h();
            cVar.r(this.f24088g.b((int) (2097151 & j5)));
            long j6 = ((2097152 + j5) & (-2097152)) | iH;
            ExecutorC1349a executorC1349a = this;
            if (f24078i.compareAndSet(executorC1349a, j5, j6)) {
                return true;
            }
            this = executorC1349a;
        }
    }

    public final void I(c cVar, int i5, int i6) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f24078i;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            int iC = (int) (2097151 & j5);
            long j6 = (2097152 + j5) & (-2097152);
            if (iC == i5) {
                iC = i6 == 0 ? this.C(cVar) : i6;
            }
            if (iC >= 0) {
                ExecutorC1349a executorC1349a = this;
                if (f24078i.compareAndSet(executorC1349a, j5, j6 | iC)) {
                    return;
                } else {
                    this = executorC1349a;
                }
            }
        }
    }

    public final void L(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                C1064c.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = A()
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Ld
            return
        Ld:
            z4.a$c r0 = r7.r()
            x4.A<z4.a$c> r1 = r7.f24088g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L8f
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L8f
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L4d
            r1 = r2
        L25:
            x4.A<z4.a$c> r4 = r7.f24088g
            java.lang.Object r4 = r4.b(r1)
            j4.k.d(r4)
            z4.a$c r4 = (z4.ExecutorC1349a.c) r4
            if (r4 == r0) goto L48
        L32:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L41
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L32
        L41:
            z4.n r4 = r4.f24091a
            z4.d r5 = r7.f24087f
            r4.j(r5)
        L48:
            if (r1 == r3) goto L4d
            int r1 = r1 + 1
            goto L25
        L4d:
            z4.d r8 = r7.f24087f
            r8.b()
            z4.d r8 = r7.f24086e
            r8.b()
        L57:
            if (r0 == 0) goto L5f
            z4.h r8 = r0.g(r2)
            if (r8 != 0) goto L8b
        L5f:
            z4.d r8 = r7.f24086e
            java.lang.Object r8 = r8.e()
            z4.h r8 = (z4.h) r8
            if (r8 != 0) goto L8b
            z4.d r8 = r7.f24087f
            java.lang.Object r8 = r8.e()
            z4.h r8 = (z4.h) r8
            if (r8 != 0) goto L8b
            if (r0 == 0) goto L7a
            z4.a$d r8 = z4.ExecutorC1349a.d.f24103e
            r0.u(r8)
        L7a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = x()
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = w()
            r8.set(r7, r0)
            return
        L8b:
            r7.L(r8)
            goto L57
        L8f:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.ExecutorC1349a.N(long):void");
    }

    public final void S() {
        if (W() || V(this, 0L, 1, null)) {
            return;
        }
        W();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        N(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        v(this, runnable, null, false, 6, null);
    }

    public final boolean isTerminated() {
        return f24080k.get(this) != 0;
    }

    public final h o(Runnable runnable, i iVar) {
        long jA = l.f24124f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.f24115a = jA;
        hVar.f24116b = iVar;
        return hVar;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f24088g.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < iA; i10++) {
            c cVarB = this.f24088g.b(i10);
            if (cVarB != null) {
                int i11 = cVarB.f24091a.i();
                int i12 = b.f24089a[cVarB.f24093c.ordinal()];
                if (i12 == 1) {
                    i7++;
                } else if (i12 == 2) {
                    i6++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i12 == 3) {
                    i5++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i12 == 4) {
                    i8++;
                    if (i11 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i11);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i12 == 5) {
                    i9++;
                }
            }
        }
        long j5 = f24079j.get(this);
        return this.f24085d + '@' + M.b(this) + "[Pool Size {core = " + this.f24082a + ", max = " + this.f24083b + "}, Worker States {CPU = " + i5 + ", blocking = " + i6 + ", parked = " + i7 + ", dormant = " + i8 + ", terminated = " + i9 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f24086e.c() + ", global blocking queue size = " + this.f24087f.c() + ", Control State {created workers= " + ((int) (2097151 & j5)) + ", blocking tasks = " + ((int) ((4398044413952L & j5) >> 21)) + ", CPUs acquired = " + (this.f24082a - ((int) ((9223367638808264704L & j5) >> 42))) + "}]";
    }

    public final void u(Runnable runnable, i iVar, boolean z5) {
        C1064c.a();
        h hVarO = o(runnable, iVar);
        boolean z6 = false;
        boolean z7 = hVarO.f24116b.b() == 1;
        long jAddAndGet = z7 ? f24079j.addAndGet(this, 2097152L) : 0L;
        c cVarR = r();
        h hVarT = T(cVarR, hVarO, z5);
        if (hVarT != null && !c(hVarT)) {
            throw new RejectedExecutionException(this.f24085d + " was terminated");
        }
        if (z5 && cVarR != null) {
            z6 = true;
        }
        if (z7) {
            O(jAddAndGet, z6);
        } else {
            if (z6) {
                return;
            }
            S();
        }
    }

    /* renamed from: z4.a$c */
    public final class c extends Thread {

        /* renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f24090i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");

        /* renamed from: a, reason: collision with root package name */
        public final n f24091a;

        /* renamed from: b, reason: collision with root package name */
        private final v<h> f24092b;

        /* renamed from: c, reason: collision with root package name */
        public d f24093c;

        /* renamed from: d, reason: collision with root package name */
        private long f24094d;

        /* renamed from: e, reason: collision with root package name */
        private long f24095e;

        /* renamed from: f, reason: collision with root package name */
        private int f24096f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f24097g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        private c() {
            setDaemon(true);
            setContextClassLoader(ExecutorC1349a.this.getClass().getClassLoader());
            this.f24091a = new n();
            this.f24092b = new v<>();
            this.f24093c = d.f24102d;
            this.nextParkedWorker = ExecutorC1349a.f24081l;
            int iNanoTime = (int) System.nanoTime();
            this.f24096f = iNanoTime == 0 ? 42 : iNanoTime;
        }

        private final void b(int i5) {
            if (i5 == 0) {
                return;
            }
            ExecutorC1349a.w().addAndGet(ExecutorC1349a.this, -2097152L);
            if (this.f24093c != d.f24103e) {
                this.f24093c = d.f24102d;
            }
        }

        private final void c(int i5) {
            if (i5 != 0 && u(d.f24100b)) {
                ExecutorC1349a.this.S();
            }
        }

        private final void d(h hVar) {
            int iB = hVar.f24116b.b();
            k(iB);
            c(iB);
            ExecutorC1349a.this.L(hVar);
            b(iB);
        }

        private final h e(boolean z5) {
            h hVarO;
            h hVarO2;
            if (z5) {
                boolean z6 = m(ExecutorC1349a.this.f24082a * 2) == 0;
                if (z6 && (hVarO2 = o()) != null) {
                    return hVarO2;
                }
                h hVarK = this.f24091a.k();
                if (hVarK != null) {
                    return hVarK;
                }
                if (!z6 && (hVarO = o()) != null) {
                    return hVarO;
                }
            } else {
                h hVarO3 = o();
                if (hVarO3 != null) {
                    return hVarO3;
                }
            }
            return v(3);
        }

        private final h f() {
            h hVarL = this.f24091a.l();
            return (hVarL == null && (hVarL = ExecutorC1349a.this.f24087f.e()) == null) ? v(1) : hVarL;
        }

        private final void k(int i5) {
            this.f24094d = 0L;
            if (this.f24093c == d.f24101c) {
                this.f24093c = d.f24100b;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != ExecutorC1349a.f24081l;
        }

        private final void n() {
            if (this.f24094d == 0) {
                this.f24094d = System.nanoTime() + ExecutorC1349a.this.f24084c;
            }
            LockSupport.parkNanos(ExecutorC1349a.this.f24084c);
            if (System.nanoTime() - this.f24094d >= 0) {
                this.f24094d = 0L;
                w();
            }
        }

        private final h o() {
            if (m(2) == 0) {
                h hVarE = ExecutorC1349a.this.f24086e.e();
                return hVarE != null ? hVarE : ExecutorC1349a.this.f24087f.e();
            }
            h hVarE2 = ExecutorC1349a.this.f24087f.e();
            return hVarE2 != null ? hVarE2 : ExecutorC1349a.this.f24086e.e();
        }

        private final void p() {
            loop0: while (true) {
                boolean z5 = false;
                while (!ExecutorC1349a.this.isTerminated() && this.f24093c != d.f24103e) {
                    h hVarG = g(this.f24097g);
                    if (hVarG != null) {
                        this.f24095e = 0L;
                        d(hVarG);
                    } else {
                        this.f24097g = false;
                        if (this.f24095e == 0) {
                            t();
                        } else if (z5) {
                            u(d.f24101c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f24095e);
                            this.f24095e = 0L;
                        } else {
                            z5 = true;
                        }
                    }
                }
                break loop0;
            }
            u(d.f24103e);
        }

        private final boolean s() {
            long j5;
            if (this.f24093c == d.f24099a) {
                return true;
            }
            ExecutorC1349a executorC1349a = ExecutorC1349a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterW = ExecutorC1349a.w();
            do {
                j5 = atomicLongFieldUpdaterW.get(executorC1349a);
                if (((int) ((9223367638808264704L & j5) >> 42)) == 0) {
                    return false;
                }
            } while (!ExecutorC1349a.w().compareAndSet(executorC1349a, j5, j5 - 4398046511104L));
            this.f24093c = d.f24099a;
            return true;
        }

        private final void t() {
            if (!l()) {
                ExecutorC1349a.this.E(this);
                return;
            }
            f24090i.set(this, -1);
            while (l() && f24090i.get(this) == -1 && !ExecutorC1349a.this.isTerminated() && this.f24093c != d.f24103e) {
                u(d.f24101c);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i5) {
            int i6 = (int) (ExecutorC1349a.w().get(ExecutorC1349a.this) & 2097151);
            if (i6 < 2) {
                return null;
            }
            int iM = m(i6);
            ExecutorC1349a executorC1349a = ExecutorC1349a.this;
            long jMin = Long.MAX_VALUE;
            for (int i7 = 0; i7 < i6; i7++) {
                iM++;
                if (iM > i6) {
                    iM = 1;
                }
                c cVarB = executorC1349a.f24088g.b(iM);
                if (cVarB != null && cVarB != this) {
                    long jR = cVarB.f24091a.r(i5, this.f24092b);
                    if (jR == -1) {
                        v<h> vVar = this.f24092b;
                        h hVar = vVar.f17836a;
                        vVar.f17836a = null;
                        return hVar;
                    }
                    if (jR > 0) {
                        jMin = Math.min(jMin, jR);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f24095e = jMin;
            return null;
        }

        private final void w() {
            ExecutorC1349a executorC1349a = ExecutorC1349a.this;
            synchronized (executorC1349a.f24088g) {
                try {
                    if (executorC1349a.isTerminated()) {
                        return;
                    }
                    if (((int) (ExecutorC1349a.w().get(executorC1349a) & 2097151)) <= executorC1349a.f24082a) {
                        return;
                    }
                    if (f24090i.compareAndSet(this, -1, 1)) {
                        int i5 = this.indexInArray;
                        q(0);
                        executorC1349a.I(this, i5, 0);
                        int andDecrement = (int) (ExecutorC1349a.w().getAndDecrement(executorC1349a) & 2097151);
                        if (andDecrement != i5) {
                            c cVarB = executorC1349a.f24088g.b(andDecrement);
                            j4.k.d(cVarB);
                            c cVar = cVarB;
                            executorC1349a.f24088g.c(i5, cVar);
                            cVar.q(i5);
                            executorC1349a.I(cVar, andDecrement, i5);
                        }
                        executorC1349a.f24088g.c(andDecrement, null);
                        V3.v vVar = V3.v.f5542a;
                        this.f24093c = d.f24103e;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final h g(boolean z5) {
            return s() ? e(z5) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i5) {
            int i6 = this.f24096f;
            int i7 = i6 ^ (i6 << 13);
            int i8 = i7 ^ (i7 >> 17);
            int i9 = i8 ^ (i8 << 5);
            this.f24096f = i9;
            int i10 = i5 - 1;
            return (i10 & i5) == 0 ? i10 & i9 : (Integer.MAX_VALUE & i9) % i5;
        }

        public final void q(int i5) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC1349a.this.f24085d);
            sb.append("-worker-");
            sb.append(i5 == 0 ? "TERMINATED" : String.valueOf(i5));
            setName(sb.toString());
            this.indexInArray = i5;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            d dVar2 = this.f24093c;
            boolean z5 = dVar2 == d.f24099a;
            if (z5) {
                ExecutorC1349a.w().addAndGet(ExecutorC1349a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f24093c = dVar;
            }
            return z5;
        }

        public c(ExecutorC1349a executorC1349a, int i5) {
            this();
            q(i5);
        }
    }
}
