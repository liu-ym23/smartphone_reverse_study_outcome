package na;

import ia.f0;
import ia.j0;
import ia.p0;
import ia.v1;
import ia.x;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class h extends x implements j0 {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6904m = AtomicIntegerFieldUpdater.newUpdater(h.class, "runningWorkers$volatile");

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ j0 f6905h;

    /* renamed from: i, reason: collision with root package name */
    public final x f6906i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6907j;

    /* renamed from: k, reason: collision with root package name */
    public final l f6908k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f6909l;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public h(x xVar, int i2) {
        j0 j0Var = xVar instanceof j0 ? (j0) xVar : null;
        this.f6905h = j0Var == null ? f0.f4956a : j0Var;
        this.f6906i = xVar;
        this.f6907j = i2;
        this.f6908k = new l();
        this.f6909l = new Object();
    }

    @Override // ia.j0
    public final p0 C(long j2, Runnable runnable, g7.l lVar) {
        return this.f6905h.C(j2, runnable, lVar);
    }

    @Override // ia.x
    public final void R(g7.l lVar, Runnable runnable) {
        boolean z4;
        Runnable runnableU;
        this.f6908k.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6904m;
        if (atomicIntegerFieldUpdater.get(this) < this.f6907j) {
            synchronized (this.f6909l) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f6904m;
                if (atomicIntegerFieldUpdater2.get(this) >= this.f6907j) {
                    z4 = false;
                } else {
                    atomicIntegerFieldUpdater2.incrementAndGet(this);
                    z4 = true;
                }
            }
            if (!z4 || (runnableU = U()) == null) {
                return;
            }
            try {
                b.i(this.f6906i, this, new v1(this, runnableU));
            } catch (Throwable th) {
                atomicIntegerFieldUpdater.decrementAndGet(this);
                throw th;
            }
        }
    }

    public final Runnable U() {
        while (true) {
            Runnable runnable = (Runnable) this.f6908k.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f6909l) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f6904m;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f6908k.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // ia.j0
    public final void k(long j2, ia.m mVar) {
        this.f6905h.k(j2, mVar);
    }

    @Override // ia.x
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f6906i);
        sb2.append(".limitedParallelism(");
        return m.x.m(sb2, this.f6907j, ')');
    }
}
