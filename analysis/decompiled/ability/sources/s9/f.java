package s9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import m9.AbstractC1685C;
import m9.AbstractC1729v;
import m9.C1718k;
import m9.InterfaceC1688F;
import m9.InterfaceC1693K;

/* loaded from: classes4.dex */
public final class f extends AbstractC1729v implements InterfaceC1688F {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(f.class, "runningWorkers$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1688F f5999a;
    public final AbstractC1729v b;
    public final int c;
    public final String d;
    public final h e;
    public final Object f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public f(AbstractC1729v abstractC1729v, int i, String str) {
        InterfaceC1688F interfaceC1688F = abstractC1729v instanceof InterfaceC1688F ? (InterfaceC1688F) abstractC1729v : null;
        this.f5999a = interfaceC1688F == null ? AbstractC1685C.f5313a : interfaceC1688F;
        this.b = abstractC1729v;
        this.c = i;
        this.d = str;
        this.e = new h();
        this.f = new Object();
    }

    public final Runnable E() {
        while (true) {
            Runnable runnable = (Runnable) this.e.c();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.e.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean F() {
        synchronized (this.f) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            if (atomicIntegerFieldUpdater.get(this) >= this.c) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        Runnable runnableE;
        this.e.a(runnable);
        if (g.get(this) >= this.c || !F() || (runnableE = E()) == null) {
            return;
        }
        this.b.dispatch(this, new A.a(18, this, runnableE));
    }

    @Override // m9.AbstractC1729v
    public final void dispatchYield(H7.h hVar, Runnable runnable) {
        Runnable runnableE;
        this.e.a(runnable);
        if (g.get(this) >= this.c || !F() || (runnableE = E()) == null) {
            return;
        }
        this.b.dispatchYield(this, new A.a(18, this, runnableE));
    }

    @Override // m9.InterfaceC1688F
    public final InterfaceC1693K l(long j5, Runnable runnable, H7.h hVar) {
        return this.f5999a.l(j5, runnable, hVar);
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return i >= this.c ? str != null ? new l(this, str) : this : super.limitedParallelism(i, str);
    }

    @Override // m9.InterfaceC1688F
    public final void s(long j5, C1718k c1718k) {
        this.f5999a.s(j5, c1718k);
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append(".limitedParallelism(");
        return B7.a.o(sb, this.c, ')');
    }
}
