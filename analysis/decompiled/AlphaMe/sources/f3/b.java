package f3;

import X.r;
import Z2.I;
import d3.t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class b implements Executor, Closeable {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12554h = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f12555i = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f12556j = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* renamed from: k, reason: collision with root package name */
    public static final r f12557k = new r("NOT_IN_STACK", 4);

    @Volatile
    private volatile int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f12558a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12559b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12560c;

    @Volatile
    private volatile long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final String f12561d;

    /* renamed from: e, reason: collision with root package name */
    public final e f12562e;

    /* renamed from: f, reason: collision with root package name */
    public final e f12563f;

    /* renamed from: g, reason: collision with root package name */
    public final t f12564g;

    @Volatile
    private volatile long parkedWorkersStack;

    public b(long j4, int i4, int i5, String str) {
        this.f12558a = i4;
        this.f12559b = i5;
        this.f12560c = j4;
        this.f12561d = str;
        if (i4 < 1) {
            throw new IllegalArgumentException(B0.g.j("Core pool size ", i4, " should be at least 1").toString());
        }
        if (i5 < i4) {
            throw new IllegalArgumentException(B0.g.k("Max pool size ", i5, " should be greater than or equals to core pool size ", i4).toString());
        }
        if (i5 > 2097150) {
            throw new IllegalArgumentException(B0.g.j("Max pool size ", i5, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
        this.f12562e = new e();
        this.f12563f = new e();
        this.f12564g = new t((i4 + 1) * 2);
        this.controlState = i4 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void e(b bVar, Runnable runnable, boolean z4, int i4) {
        E3.b bVar2 = j.f12579g;
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        bVar.b(runnable, bVar2, z4);
    }

    public final int a() {
        synchronized (this.f12564g) {
            try {
                if (f12556j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f12555i;
                long j4 = atomicLongFieldUpdater.get(this);
                int i4 = (int) (j4 & 2097151);
                int iCoerceAtLeast = RangesKt.coerceAtLeast(i4 - ((int) ((j4 & 4398044413952L) >> 21)), 0);
                if (iCoerceAtLeast >= this.f12558a) {
                    return 0;
                }
                if (i4 >= this.f12559b) {
                    return 0;
                }
                int i5 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i5 <= 0 || this.f12564g.b(i5) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                C0559a c0559a = new C0559a(this, i5);
                this.f12564g.c(i5, c0559a);
                if (i5 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i6 = iCoerceAtLeast + 1;
                c0559a.start();
                return i6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, E3.b bVar, boolean z4) {
        h iVar;
        int i4;
        j.f12578f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            iVar = (h) runnable;
            iVar.f12570a = jNanoTime;
            iVar.f12571b = bVar;
        } else {
            iVar = new i(runnable, jNanoTime, bVar);
        }
        boolean z5 = false;
        boolean z6 = iVar.f12571b.f411a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12555i;
        long jAddAndGet = z6 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        C0559a c0559a = threadCurrentThread instanceof C0559a ? (C0559a) threadCurrentThread : null;
        if (c0559a == null || !Intrinsics.areEqual(c0559a.f12553h, this)) {
            c0559a = null;
        }
        if (c0559a != null && (i4 = c0559a.f12548c) != 5 && (iVar.f12571b.f411a != 0 || i4 != 2)) {
            c0559a.f12552g = true;
            l lVar = c0559a.f12546a;
            if (z4) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                h hVar = (h) l.f12582b.getAndSet(lVar, iVar);
                iVar = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.f12571b.f411a == 1 ? this.f12563f.a(iVar) : this.f12562e.a(iVar))) {
                throw new RejectedExecutionException(B0.g.r(new StringBuilder(), this.f12561d, " was terminated"));
            }
        }
        if (z4 && c0559a != null) {
            z5 = true;
        }
        if (z6) {
            if (z5 || u() || m(jAddAndGet)) {
                return;
            }
            u();
            return;
        }
        if (z5 || u() || m(atomicLongFieldUpdater.get(this))) {
            return;
        }
        u();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        e(this, runnable, false, 6);
    }

    public final void l(C0559a c0559a, int i4, int i5) {
        while (true) {
            long j4 = f12554h.get(this);
            int i6 = (int) (2097151 & j4);
            long j5 = (2097152 + j4) & (-2097152);
            if (i6 == i4) {
                if (i5 == 0) {
                    Object objC = c0559a.c();
                    while (true) {
                        if (objC == f12557k) {
                            i6 = -1;
                            break;
                        }
                        if (objC == null) {
                            i6 = 0;
                            break;
                        }
                        C0559a c0559a2 = (C0559a) objC;
                        int iB = c0559a2.b();
                        if (iB != 0) {
                            i6 = iB;
                            break;
                        }
                        objC = c0559a2.c();
                    }
                } else {
                    i6 = i5;
                }
            }
            if (i6 >= 0) {
                if (f12554h.compareAndSet(this, j4, i6 | j5)) {
                    return;
                }
            }
        }
    }

    public final boolean m(long j4) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21)), 0);
        int i4 = this.f12558a;
        if (iCoerceAtLeast < i4) {
            int iA = a();
            if (iA == 1 && i4 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        t tVar = this.f12564g;
        int iA = tVar.a();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 1; i9 < iA; i9++) {
            C0559a c0559a = (C0559a) tVar.b(i9);
            if (c0559a != null) {
                l lVar = c0559a.f12546a;
                lVar.getClass();
                int i10 = l.f12582b.get(lVar) != null ? (l.f12583c.get(lVar) - l.f12584d.get(lVar)) + 1 : l.f12583c.get(lVar) - l.f12584d.get(lVar);
                int iA2 = t.h.a(c0559a.f12548c);
                if (iA2 == 0) {
                    i4++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i10);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iA2 == 1) {
                    i5++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i10);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iA2 == 2) {
                    i6++;
                } else if (iA2 == 3) {
                    i7++;
                    if (i10 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i10);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iA2 == 4) {
                    i8++;
                }
            }
        }
        long j4 = f12555i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f12561d);
        sb4.append('@');
        sb4.append(I.p(this));
        sb4.append("[Pool Size {core = ");
        int i11 = this.f12558a;
        sb4.append(i11);
        sb4.append(", max = ");
        sb4.append(this.f12559b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i4);
        sb4.append(", blocking = ");
        sb4.append(i5);
        sb4.append(", parked = ");
        sb4.append(i6);
        sb4.append(", dormant = ");
        sb4.append(i7);
        sb4.append(", terminated = ");
        sb4.append(i8);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f12562e.b());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f12563f.b());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j4));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j4) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i11 - ((int) ((j4 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final boolean u() {
        r rVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f12554h;
            long j4 = atomicLongFieldUpdater.get(this);
            C0559a c0559a = (C0559a) this.f12564g.b((int) (2097151 & j4));
            if (c0559a == null) {
                c0559a = null;
            } else {
                long j5 = (2097152 + j4) & (-2097152);
                Object objC = c0559a.c();
                while (true) {
                    rVar = f12557k;
                    if (objC == rVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    C0559a c0559a2 = (C0559a) objC;
                    iB = c0559a2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = c0559a2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j4, j5 | iB)) {
                    c0559a.g(rVar);
                }
            }
            if (c0559a == null) {
                return false;
            }
            if (C0559a.f12545i.compareAndSet(c0559a, -1, 0)) {
                LockSupport.unpark(c0559a);
                return true;
            }
        }
    }
}
