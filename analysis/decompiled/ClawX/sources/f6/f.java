package f6;

import a6.b0;
import a6.b2;
import a6.k0;
import a6.n0;
import a6.s0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends b0 implements n0 {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f2641h = AtomicIntegerFieldUpdater.newUpdater(f.class, "runningWorkers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n0 f2642c;
    public final b0 d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2643e;

    /* renamed from: f, reason: collision with root package name */
    public final j f2644f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2645g;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public f(b0 b0Var, int i8) {
        n0 n0Var = b0Var instanceof n0 ? (n0) b0Var : null;
        this.f2642c = n0Var == null ? k0.f185a : n0Var;
        this.d = b0Var;
        this.f2643e = i8;
        this.f2644f = new j();
        this.f2645g = new Object();
    }

    @Override // a6.b0
    public final void C(f5.h hVar, Runnable runnable) {
        Runnable runnableH;
        this.f2644f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2641h;
        if (atomicIntegerFieldUpdater.get(this) >= this.f2643e || !I() || (runnableH = H()) == null) {
            return;
        }
        try {
            a.i(this.d, this, new b0.a(this, runnableH, 2, false));
        } catch (Throwable th) {
            atomicIntegerFieldUpdater.decrementAndGet(this);
            throw th;
        }
    }

    @Override // a6.b0
    public final void E(f5.h hVar, Runnable runnable) {
        Runnable runnableH;
        this.f2644f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2641h;
        if (atomicIntegerFieldUpdater.get(this) >= this.f2643e || !I() || (runnableH = H()) == null) {
            return;
        }
        try {
            this.d.E(this, new b0.a(this, runnableH, 2, false));
        } catch (Throwable th) {
            atomicIntegerFieldUpdater.decrementAndGet(this);
            throw th;
        }
    }

    public final Runnable H() {
        while (true) {
            Runnable runnable = (Runnable) this.f2644f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f2645g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2641h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f2644f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean I() {
        synchronized (this.f2645g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2641h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f2643e) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // a6.n0
    public final s0 b(long j4, b2 b2Var, f5.h hVar) {
        return this.f2642c.b(j4, b2Var, hVar);
    }

    @Override // a6.b0
    public final String toString() {
        return this.d + ".limitedParallelism(" + this.f2643e + ')';
    }

    @Override // a6.n0
    public final void u(long j4, a6.m mVar) {
        this.f2642c.u(j4, mVar);
    }
}
