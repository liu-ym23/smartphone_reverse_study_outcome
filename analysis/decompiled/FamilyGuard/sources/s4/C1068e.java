package s4;

import java.util.concurrent.locks.LockSupport;

/* renamed from: s4.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1068e<T> extends AbstractC1060a<T> {

    /* renamed from: d, reason: collision with root package name */
    private final Thread f20342d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC1061a0 f20343e;

    public C1068e(Z3.i iVar, Thread thread, AbstractC1061a0 abstractC1061a0) {
        super(iVar, true, true);
        this.f20342d = thread;
        this.f20343e = abstractC1061a0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T N0() throws Throwable {
        C1064c.a();
        try {
            AbstractC1061a0 abstractC1061a0 = this.f20343e;
            if (abstractC1061a0 != null) {
                AbstractC1061a0.o0(abstractC1061a0, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    AbstractC1061a0 abstractC1061a02 = this.f20343e;
                    long jU0 = abstractC1061a02 != null ? abstractC1061a02.u0() : Long.MAX_VALUE;
                    if (i0()) {
                        AbstractC1061a0 abstractC1061a03 = this.f20343e;
                        if (abstractC1061a03 != null) {
                            AbstractC1061a0.j0(abstractC1061a03, false, 1, null);
                        }
                        C1064c.a();
                        T t5 = (T) v0.h(b0());
                        C1096y c1096y = t5 instanceof C1096y ? (C1096y) t5 : null;
                        if (c1096y == null) {
                            return t5;
                        }
                        throw c1096y.f20398a;
                    }
                    C1064c.a();
                    LockSupport.parkNanos(this, jU0);
                } catch (Throwable th) {
                    AbstractC1061a0 abstractC1061a04 = this.f20343e;
                    if (abstractC1061a04 != null) {
                        AbstractC1061a0.j0(abstractC1061a04, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            q(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            C1064c.a();
            throw th2;
        }
    }

    @Override // s4.u0
    protected boolean j0() {
        return true;
    }

    @Override // s4.u0
    protected void l(Object obj) {
        if (j4.k.b(Thread.currentThread(), this.f20342d)) {
            return;
        }
        Thread thread = this.f20342d;
        C1064c.a();
        LockSupport.unpark(thread);
    }
}
