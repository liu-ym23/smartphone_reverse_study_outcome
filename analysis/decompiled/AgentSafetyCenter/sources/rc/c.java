package rc;

import java.io.Closeable;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kc.w;
import pc.p;
import pc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10542l = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10543m = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10544n = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: o, reason: collision with root package name */
    public static final t f10545o = new t("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: c, reason: collision with root package name */
    public final int f10546c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: f, reason: collision with root package name */
    public final int f10547f;

    /* renamed from: g, reason: collision with root package name */
    public final long f10548g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10549h;
    public final f i;

    /* renamed from: j, reason: collision with root package name */
    public final f f10550j;

    /* renamed from: k, reason: collision with root package name */
    public final p f10551k;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i, int i3, long j10, String str) {
        this.f10546c = i;
        this.f10547f = i3;
        this.f10548g = j10;
        this.f10549h = str;
        if (i < 1) {
            od.f.c(k0.a.k(i, "Core pool size ", " should be at least 1"));
            throw null;
        }
        if (i3 < i) {
            od.f.c(androidx.activity.b.i("Max pool size ", i3, " should be greater than or equals to core pool size ", i));
            throw null;
        }
        if (i3 > 2097150) {
            od.f.c(k0.a.k(i3, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.i = new f();
        this.f10550j = new f();
        this.f10551k = new p((i + 1) * 2);
        this.controlState$volatile = i << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void g(c cVar, Runnable runnable, int i) {
        cVar.e(runnable, false, (i & 4) == 0);
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
        throw new UnsupportedOperationException("Method not decompiled: rc.c.close():void");
    }

    public final int d() {
        synchronized (this.f10551k) {
            try {
                if (f10544n.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f10543m;
                long j10 = atomicLongFieldUpdater.get(this);
                int i = (int) (j10 & 2097151);
                int i3 = i - ((int) ((j10 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f10546c) {
                    return 0;
                }
                if (i >= this.f10547f) {
                    return 0;
                }
                int i10 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i10 <= 0 || this.f10551k.b(i10) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i10);
                this.f10551k.c(i10, aVar);
                if (i10 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i11 = i3 + 1;
                aVar.start();
                return i11;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(Runnable runnable, boolean z10, boolean z11) {
        h hVarA;
        b bVar;
        j.f10565f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            hVarA = (h) runnable;
            hVarA.f10557c = jNanoTime;
            hVarA.f10558f = z10;
        } else {
            i iVar = new i(jNanoTime, z10);
            iVar.f10559g = runnable;
            VarHandle.storeStoreFence();
            hVarA = iVar;
        }
        boolean z12 = hVarA.f10558f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10543m;
        long jAddAndGet = z12 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !aVar.f10536l.equals(this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f10532g) != b.i && (hVarA.f10558f || bVar != b.f10538f)) {
            aVar.f10535k = true;
            l lVar = aVar.f10530c;
            if (z11) {
                hVarA = lVar.a(hVarA);
            } else {
                lVar.getClass();
                h hVar = (h) l.f10567b.getAndSet(lVar, hVarA);
                hVarA = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (hVarA != null) {
            if (!(hVarA.f10558f ? this.f10550j.a(hVarA) : this.i.a(hVarA))) {
                throw new RejectedExecutionException(androidx.activity.b.n(new StringBuilder(), this.f10549h, " was terminated"));
            }
        }
        boolean z13 = z11 && aVar != null;
        if (z12) {
            if (z13 || o() || n(jAddAndGet)) {
                return;
            }
            o();
            return;
        }
        if (z13 || o() || n(atomicLongFieldUpdater.get(this))) {
            return;
        }
        o();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        g(this, runnable, 6);
    }

    public final void i(a aVar, int i, int i3) {
        while (true) {
            long j10 = f10542l.get(this);
            int i10 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i10 == i) {
                if (i3 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f10545o) {
                            i10 = -1;
                            break;
                        }
                        if (objC == null) {
                            i10 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i10 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i10 = i3;
                }
            }
            if (i10 >= 0) {
                c cVar = this;
                if (f10542l.compareAndSet(cVar, j10, i10 | j11)) {
                    return;
                } else {
                    this = cVar;
                }
            }
        }
    }

    public final boolean n(long j10) {
        int i = ((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i3 = this.f10546c;
        if (i < i3) {
            int iD = d();
            if (iD == 1 && i3 > 1) {
                d();
            }
            if (iD > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean o() {
        c cVar;
        t tVar;
        int iB;
        while (true) {
            long j10 = f10542l.get(this);
            a aVar = (a) this.f10551k.b((int) (2097151 & j10));
            if (aVar == null) {
                aVar = null;
                cVar = this;
            } else {
                long j11 = (2097152 + j10) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    tVar = f10545o;
                    if (objC == tVar) {
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
                    j10 = j10;
                }
                if (iB >= 0) {
                    c cVar2 = this;
                    boolean zCompareAndSet = f10542l.compareAndSet(cVar2, j10, iB | j11);
                    cVar = cVar2;
                    if (zCompareAndSet) {
                        aVar.g(tVar);
                    }
                    this = cVar;
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f10529m.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
            this = cVar;
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        p pVar = this.f10551k;
        int iA = pVar.a();
        int i = 0;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < iA; i13++) {
            a aVar = (a) pVar.b(i13);
            if (aVar != null) {
                l lVar = aVar.f10530c;
                lVar.getClass();
                int i14 = l.f10567b.get(lVar) != null ? (l.f10568c.get(lVar) - l.f10569d.get(lVar)) + 1 : l.f10568c.get(lVar) - l.f10569d.get(lVar);
                int iOrdinal = aVar.f10532g.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i14);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 1) {
                    i3++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i14);
                    sb3.append('b');
                    arrayList.add(sb3.toString());
                } else if (iOrdinal == 2) {
                    i10++;
                } else if (iOrdinal == 3) {
                    i11++;
                    if (i14 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i14);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        g5.f.a();
                        return null;
                    }
                    i12++;
                }
            }
        }
        long j10 = f10543m.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f10549h);
        sb5.append('@');
        sb5.append(w.m(this));
        sb5.append("[Pool Size {core = ");
        int i15 = this.f10546c;
        sb5.append(i15);
        sb5.append(", max = ");
        sb5.append(this.f10547f);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i);
        sb5.append(", blocking = ");
        sb5.append(i3);
        sb5.append(", parked = ");
        sb5.append(i10);
        sb5.append(", dormant = ");
        sb5.append(i11);
        sb5.append(", terminated = ");
        sb5.append(i12);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.i.b());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f10550j.b());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j10));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j10) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i15 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }
}
