package u9;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState;
import m9.AbstractC1683A;
import s9.n;

/* loaded from: classes4.dex */
public final class b implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(b.class, "controlState$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6741j = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated$volatile");
    public static final a5.d k = new a5.d("NOT_IN_STACK", 6);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f6742a;
    public final int b;
    public final long c;
    private volatile /* synthetic */ long controlState$volatile;
    public final String d;
    public final e e;
    public final e f;
    public final n g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public b(long j5, String str, int i6, int i10) {
        this.f6742a = i6;
        this.b = i10;
        this.c = j5;
        this.d = str;
        if (i6 < 1) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i6, "Core pool size ", " should be at least 1").toString());
        }
        if (i10 < i6) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(i10, i6, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i10 > 2097150) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i10, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j5 <= 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.q(j5, "Idle worker keep alive time ", " must be positive").toString());
        }
        this.e = new e();
        this.f = new e();
        this.g = new n((i6 + 1) * 2);
        this.controlState$volatile = i6 << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void f(b bVar, Runnable runnable, int i6) {
        bVar.c(false, (i6 & 4) == 0, runnable);
    }

    public final int b() {
        synchronized (this.g) {
            try {
                if (f6741j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = i;
                long j5 = atomicLongFieldUpdater.get(this);
                int i6 = (int) (j5 & 2097151);
                int i10 = i6 - ((int) ((j5 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f6742a) {
                    return 0;
                }
                if (i6 >= this.b) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.g.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                C2051a c2051a = new C2051a(this, i11);
                this.g.c(i11, c2051a);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                c2051a.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(boolean z10, boolean z11, Runnable runnable) {
        h iVar;
        CoroutineScheduler$WorkerState coroutineScheduler$WorkerState;
        j.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            iVar = (h) runnable;
            iVar.f6746a = jNanoTime;
            iVar.b = z10;
        } else {
            iVar = new i(runnable, jNanoTime, z10);
        }
        boolean z12 = iVar.b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        long jAddAndGet = z12 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        C2051a c2051a = threadCurrentThread instanceof C2051a ? (C2051a) threadCurrentThread : null;
        if (c2051a == null || !kotlin.jvm.internal.k.b(c2051a.h, this)) {
            c2051a = null;
        }
        if (c2051a != null && (coroutineScheduler$WorkerState = c2051a.c) != CoroutineScheduler$WorkerState.e && (iVar.b || coroutineScheduler$WorkerState != CoroutineScheduler$WorkerState.b)) {
            c2051a.g = true;
            l lVar = c2051a.f6740a;
            if (z11) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                h hVar = (h) l.b.getAndSet(lVar, iVar);
                iVar = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.b ? this.f.a(iVar) : this.e.a(iVar))) {
                throw new RejectedExecutionException(B7.a.q(new StringBuilder(), this.d, " was terminated"));
            }
        }
        boolean z13 = z11 && c2051a != null;
        if (z12) {
            if (z13 || k() || i(jAddAndGet)) {
                return;
            }
            k();
            return;
        }
        if (z13 || k() || i(atomicLongFieldUpdater.get(this))) {
            return;
        }
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.b.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f(this, runnable, 6);
    }

    public final void g(C2051a c2051a, int i6, int i10) {
        while (true) {
            long j5 = h.get(this);
            int i11 = (int) (2097151 & j5);
            long j6 = (2097152 + j5) & (-2097152);
            if (i11 == i6) {
                if (i10 == 0) {
                    Object objD = c2051a.d();
                    while (true) {
                        if (objD == k) {
                            i11 = -1;
                            break;
                        }
                        if (objD == null) {
                            i11 = 0;
                            break;
                        }
                        C2051a c2051a2 = (C2051a) objD;
                        int iC = c2051a2.c();
                        if (iC != 0) {
                            i11 = iC;
                            break;
                        }
                        objD = c2051a2.d();
                    }
                } else {
                    i11 = i10;
                }
            }
            if (i11 >= 0) {
                b bVar = this;
                if (h.compareAndSet(bVar, j5, i11 | j6)) {
                    return;
                } else {
                    this = bVar;
                }
            }
        }
    }

    public final boolean i(long j5) {
        int i6 = ((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21));
        if (i6 < 0) {
            i6 = 0;
        }
        int i10 = this.f6742a;
        if (i6 < i10) {
            int iB = b();
            if (iB == 1 && i10 > 1) {
                b();
            }
            if (iB > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() {
        b bVar;
        a5.d dVar;
        int iC;
        while (true) {
            long j5 = h.get(this);
            C2051a c2051a = (C2051a) this.g.b((int) (2097151 & j5));
            if (c2051a == null) {
                c2051a = null;
                bVar = this;
            } else {
                long j6 = (2097152 + j5) & (-2097152);
                Object objD = c2051a.d();
                while (true) {
                    dVar = k;
                    if (objD == dVar) {
                        iC = -1;
                        break;
                    }
                    if (objD == null) {
                        iC = 0;
                        break;
                    }
                    C2051a c2051a2 = (C2051a) objD;
                    iC = c2051a2.c();
                    if (iC != 0) {
                        break;
                    }
                    objD = c2051a2.d();
                    j5 = j5;
                }
                if (iC >= 0) {
                    b bVar2 = this;
                    boolean zCompareAndSet = h.compareAndSet(bVar2, j5, iC | j6);
                    bVar = bVar2;
                    if (zCompareAndSet) {
                        c2051a.h(dVar);
                    }
                    this = bVar;
                } else {
                    continue;
                }
            }
            if (c2051a == null) {
                return false;
            }
            if (C2051a.i.compareAndSet(c2051a, -1, 0)) {
                LockSupport.unpark(c2051a);
                return true;
            }
            this = bVar;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        n nVar = this.g;
        int iA = nVar.a();
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < iA; i14++) {
            C2051a c2051a = (C2051a) nVar.b(i14);
            if (c2051a != null) {
                l lVar = c2051a.f6740a;
                lVar.getClass();
                int i15 = l.b.get(lVar) != null ? (l.c.get(lVar) - l.d.get(lVar)) + 1 : l.c.get(lVar) - l.d.get(lVar);
                int iOrdinal = c2051a.c.ordinal();
                if (iOrdinal == 0) {
                    i6++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i11++;
                } else if (iOrdinal == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i15);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i13++;
                }
            }
        }
        long j5 = i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.d);
        sb4.append('@');
        sb4.append(AbstractC1683A.i(this));
        sb4.append("[Pool Size {core = ");
        int i16 = this.f6742a;
        sb4.append(i16);
        sb4.append(", max = ");
        androidx.constraintlayout.core.dsl.a.y(sb4, this.b, "}, Worker States {CPU = ", i6, ", blocking = ");
        androidx.constraintlayout.core.dsl.a.y(sb4, i10, ", parked = ", i11, ", dormant = ");
        androidx.constraintlayout.core.dsl.a.y(sb4, i12, ", terminated = ", i13, "}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.e.b());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f.b());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j5));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j5) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i16 - ((int) ((j5 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
