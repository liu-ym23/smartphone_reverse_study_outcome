package s4;

import a4.C0428b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import x4.C1290B;
import x4.C1311k;

/* loaded from: classes.dex */
public final class T<T> extends C1290B<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f20321e = AtomicIntegerFieldUpdater.newUpdater(T.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    public T(Z3.i iVar, Z3.e<? super T> eVar) {
        super(iVar, eVar);
    }

    private final boolean P0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20321e;
        do {
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f20321e.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean Q0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20321e;
        do {
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 != 0) {
                if (i5 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f20321e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // x4.C1290B, s4.AbstractC1060a
    protected void J0(Object obj) {
        if (P0()) {
            return;
        }
        C1311k.c(C0428b.c(this.f23827d), C1053B.a(obj, this.f23827d), null, 2, null);
    }

    public final Object N0() {
        if (Q0()) {
            return C0428b.e();
        }
        Object objH = v0.h(b0());
        if (objH instanceof C1096y) {
            throw ((C1096y) objH).f20398a;
        }
        return objH;
    }

    @Override // x4.C1290B, s4.u0
    protected void l(Object obj) {
        J0(obj);
    }
}
