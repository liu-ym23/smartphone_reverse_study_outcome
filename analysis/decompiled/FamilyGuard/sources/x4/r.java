package x4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class r<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23877a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public r(boolean z5) {
        this._cur$volatile = new s(8, z5);
    }

    public final boolean a(E e6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23877a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            int iA = sVar.a(e6);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                f23877a.compareAndSet(this, sVar, sVar.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23877a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar.d()) {
                return;
            } else {
                f23877a.compareAndSet(this, sVar, sVar.l());
            }
        }
    }

    public final int c() {
        return ((s) f23877a.get(this)).g();
    }

    public final E e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23877a;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            E e6 = (E) sVar.m();
            if (e6 != s.f23881h) {
                return e6;
            }
            f23877a.compareAndSet(this, sVar, sVar.l());
        }
    }
}
