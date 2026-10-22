package x4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import x4.AbstractC1304d;

/* renamed from: x4.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1304d<N extends AbstractC1304d<N>> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23851a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1304d.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23852b = AtomicReferenceFieldUpdater.newUpdater(AbstractC1304d.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public AbstractC1304d(N n5) {
        this._prev$volatile = n5;
    }

    private final N d() {
        N n5 = (N) h();
        while (n5 != null && n5.k()) {
            n5 = (N) f23852b.get(n5);
        }
        return n5;
    }

    private final N e() {
        AbstractC1304d abstractC1304dF;
        N n5 = (N) f();
        j4.k.d(n5);
        while (n5.k() && (abstractC1304dF = n5.f()) != null) {
            n5 = (N) abstractC1304dF;
        }
        return n5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g() {
        return f23851a.get(this);
    }

    public final void c() {
        f23852b.set(this, null);
    }

    public final N f() {
        Object objG = g();
        if (objG == C1303c.f23850a) {
            return null;
        }
        return (N) objG;
    }

    public final N h() {
        return (N) f23852b.get(this);
    }

    public abstract boolean k();

    public final boolean l() {
        return f() == null;
    }

    public final boolean m() {
        return f23851a.compareAndSet(this, null, C1303c.f23850a);
    }

    public final void n() {
        Object obj;
        if (l()) {
            return;
        }
        while (true) {
            AbstractC1304d abstractC1304dD = d();
            AbstractC1304d abstractC1304dE = e();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23852b;
            do {
                obj = atomicReferenceFieldUpdater.get(abstractC1304dE);
            } while (!atomicReferenceFieldUpdater.compareAndSet(abstractC1304dE, obj, ((AbstractC1304d) obj) == null ? null : abstractC1304dD));
            if (abstractC1304dD != null) {
                f23851a.set(abstractC1304dD, abstractC1304dE);
            }
            if (!abstractC1304dE.k() || abstractC1304dE.l()) {
                if (abstractC1304dD == null || !abstractC1304dD.k()) {
                    return;
                }
            }
        }
    }

    public final boolean o(N n5) {
        return f23851a.compareAndSet(this, null, n5);
    }
}
