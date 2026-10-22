package pc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kc.a0;
import kc.g0;
import kc.o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends kc.p implements a0 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9959k = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ a0 f9960f;

    /* renamed from: g, reason: collision with root package name */
    public kc.p f9961g;

    /* renamed from: h, reason: collision with root package name */
    public int f9962h;
    public k i;

    /* renamed from: j, reason: collision with root package name */
    public Object f9963j;
    private volatile /* synthetic */ int runningWorkers$volatile;

    @Override // kc.a0
    public final void F(long j10, kc.g gVar) {
        this.f9960f.F(j10, gVar);
    }

    @Override // kc.p
    public final void M(nb.g gVar, Runnable runnable) {
        Runnable runnableQ;
        this.i.a(runnable);
        if (f9959k.get(this) >= this.f9962h || !R() || (runnableQ = Q()) == null) {
            return;
        }
        this.f9961g.M(this, new com.stepos.statsrpk.service.d(this, runnableQ));
    }

    @Override // kc.p
    public final void N(nb.g gVar, Runnable runnable) {
        Runnable runnableQ;
        this.i.a(runnable);
        if (f9959k.get(this) >= this.f9962h || !R() || (runnableQ = Q()) == null) {
            return;
        }
        this.f9961g.N(this, new com.stepos.statsrpk.service.d(this, runnableQ));
    }

    public final Runnable Q() {
        while (true) {
            Runnable runnable = (Runnable) this.i.c();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f9963j) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9959k;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.i.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean R() {
        synchronized (this.f9963j) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9959k;
            if (atomicIntegerFieldUpdater.get(this) >= this.f9962h) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // kc.a0
    public final g0 n(long j10, o1 o1Var, nb.g gVar) {
        return this.f9960f.n(j10, o1Var, gVar);
    }

    @Override // kc.p
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f9961g);
        sb2.append(".limitedParallelism(");
        return androidx.activity.b.l(sb2, this.f9962h, ')');
    }
}
