package pa;

import a4.u;
import f8.x;
import ia.d0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import na.q;

/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8545m = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f8546n = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f8547o = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: p, reason: collision with root package name */
    public static final x f8548p = new x("NOT_IN_STACK", 3);
    private volatile /* synthetic */ int _isTerminated$volatile;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final int f8549f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8550g;

    /* renamed from: h, reason: collision with root package name */
    public final long f8551h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8552i;

    /* renamed from: j, reason: collision with root package name */
    public final f f8553j;

    /* renamed from: k, reason: collision with root package name */
    public final f f8554k;

    /* renamed from: l, reason: collision with root package name */
    public final q f8555l;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i2, int i10, long j2, String str) {
        this.f8549f = i2;
        this.f8550g = i10;
        this.f8551h = j2;
        this.f8552i = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(a1.a.f(i2, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i2) {
            throw new IllegalArgumentException(m.x.k("Max pool size ", i10, i2, " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(a1.a.f(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f8553j = new f();
        this.f8554k = new f();
        this.f8555l = new q((i2 + 1) * 2);
        this.controlState$volatile = i2 << 42;
    }

    public static /* synthetic */ void d(c cVar, Runnable runnable, int i2) {
        cVar.b(runnable, false, (i2 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f8555l) {
            try {
                if (f8547o.get(this) == 1) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f8546n;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i10 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f8549f) {
                    return 0;
                }
                if (i2 >= this.f8550g) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f8555l.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i11);
                this.f8555l.c(i11, aVar);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                aVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z4, boolean z10) {
        i jVar;
        b bVar;
        k.f8569f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f8561f = jNanoTime;
            jVar.f8562g = z4;
        } else {
            jVar = new j(runnable, jNanoTime, z4);
        }
        boolean z11 = jVar.f8562g;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8546n;
        long jAddAndGet = z11 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !q7.k.a(aVar.f8538m, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f8533h) != b.f8543j && (jVar.f8562g || bVar != b.f8540g)) {
            aVar.f8537l = true;
            m mVar = aVar.f8531f;
            if (z10) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                i iVar = (i) m.f8571b.getAndSet(mVar, jVar);
                jVar = iVar == null ? null : mVar.a(iVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f8562g ? this.f8554k.a(jVar) : this.f8553j.a(jVar))) {
                throw new RejectedExecutionException(a1.a.m(new StringBuilder(), this.f8552i, " was terminated"));
            }
        }
        if (z11) {
            if (i() || g(jAddAndGet)) {
                return;
            }
            i();
            return;
        }
        if (i() || g(atomicLongFieldUpdater.get(this))) {
            return;
        }
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = pa.c.f8547o
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof pa.a
            r3 = 0
            if (r1 == 0) goto L17
            pa.a r0 = (pa.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            pa.c r1 = r0.f8538m
            boolean r1 = q7.k.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            na.q r1 = r8.f8555l
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = pa.c.f8546n     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            na.q r5 = r8.f8555l
            java.lang.Object r5 = r5.b(r1)
            q7.k.b(r5)
            pa.a r5 = (pa.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            pa.m r5 = r5.f8531f
            pa.f r6 = r8.f8554k
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = pa.m.f8571b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            pa.i r7 = (pa.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            pa.i r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            pa.f r1 = r8.f8554k
            r1.b()
            pa.f r1 = r8.f8553j
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            pa.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            pa.f r1 = r8.f8553j
            java.lang.Object r1 = r1.d()
            pa.i r1 = (pa.i) r1
            if (r1 != 0) goto Lb2
            pa.f r1 = r8.f8554k
            java.lang.Object r1 = r1.d()
            pa.i r1 = (pa.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            pa.b r1 = pa.b.f8543j
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pa.c.f8545m
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pa.c.f8546n
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pa.c.close():void");
    }

    public final void e(a aVar, int i2, int i10) {
        while (true) {
            long j2 = f8545m.get(this);
            int i11 = (int) (2097151 & j2);
            long j4 = (2097152 + j2) & (-2097152);
            if (i11 == i2) {
                if (i10 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f8548p) {
                            i11 = -1;
                            break;
                        }
                        if (objC == null) {
                            i11 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i11 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i11 = i10;
                }
            }
            if (i11 >= 0) {
                c cVar = this;
                if (f8545m.compareAndSet(cVar, j2, i11 | j4)) {
                    return;
                } else {
                    this = cVar;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(this, runnable, 6);
    }

    public final boolean g(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i10 = this.f8549f;
        if (i2 < i10) {
            int iA = a();
            if (iA == 1 && i10 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        c cVar;
        x xVar;
        int iB;
        while (true) {
            long j2 = f8545m.get(this);
            a aVar = (a) this.f8555l.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
                cVar = this;
            } else {
                long j4 = (2097152 + j2) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    xVar = f8548p;
                    if (objC == xVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                    j2 = j2;
                }
                if (iB >= 0) {
                    c cVar2 = this;
                    boolean zCompareAndSet = f8545m.compareAndSet(cVar2, j2, iB | j4);
                    cVar = cVar2;
                    if (zCompareAndSet) {
                        aVar.g(xVar);
                    }
                    this = cVar;
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f8530n.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
            this = cVar;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        q qVar = this.f8555l;
        int iA = qVar.a();
        int i2 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iA; i14++) {
            a aVar = (a) qVar.b(i14);
            if (aVar != null) {
                m mVar = aVar.f8531f;
                mVar.getClass();
                int i15 = m.f8571b.get(mVar) != null ? (m.f8572c.get(mVar) - m.f8573d.get(mVar)) + 1 : m.f8572c.get(mVar) - m.f8573d.get(mVar);
                int iOrdinal = aVar.f8533h.ordinal();
                if (iOrdinal == 0) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 1) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i15);
                    sb3.append('b');
                    arrayList.add(sb3.toString());
                } else if (iOrdinal == 2) {
                    i11++;
                } else if (iOrdinal == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i15);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new u();
                    }
                    i13++;
                }
            }
        }
        long j2 = f8546n.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f8552i);
        sb5.append('@');
        sb5.append(d0.k(this));
        sb5.append("[Pool Size {core = ");
        int i16 = this.f8549f;
        sb5.append(i16);
        sb5.append(", max = ");
        sb5.append(this.f8550g);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i2);
        sb5.append(", blocking = ");
        sb5.append(i10);
        sb5.append(", parked = ");
        sb5.append(i11);
        sb5.append(", dormant = ");
        sb5.append(i12);
        sb5.append(", terminated = ");
        sb5.append(i13);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.f8553j.c());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f8554k.c());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j2));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j2) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i16 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }
}
