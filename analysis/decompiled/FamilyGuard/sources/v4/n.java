package v4;

import V3.n;
import V3.v;
import a4.C0428b;
import java.util.concurrent.atomic.AtomicReference;
import s4.C1082l;
import x4.C1305e;

/* loaded from: classes.dex */
final class n extends w4.d<l<?>> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<Object> f23380a = new AtomicReference<>(null);

    @Override // w4.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(l<?> lVar) {
        if (C1305e.a(this.f23380a) != null) {
            return false;
        }
        C1305e.b(this.f23380a, m.f23378a);
        return true;
    }

    public final Object e(Z3.e<? super v> eVar) {
        C1082l c1082l = new C1082l(C0428b.c(eVar), 1);
        c1082l.D();
        if (!this.f23380a.compareAndSet(m.f23378a, c1082l)) {
            n.a aVar = V3.n.f5531a;
            c1082l.resumeWith(V3.n.a(v.f5542a));
        }
        Object objX = c1082l.x();
        if (objX == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objX == C0428b.e() ? objX : v.f5542a;
    }

    @Override // w4.d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Z3.e<v>[] b(l<?> lVar) {
        C1305e.b(this.f23380a, null);
        return w4.c.f23716a;
    }

    public final void g() {
        AtomicReference<Object> atomicReference = this.f23380a;
        while (true) {
            Object objA = C1305e.a(atomicReference);
            if (objA == null || objA == m.f23379b) {
                return;
            }
            if (objA == m.f23378a) {
                if (this.f23380a.compareAndSet(objA, m.f23379b)) {
                    return;
                }
            } else if (this.f23380a.compareAndSet(objA, m.f23378a)) {
                n.a aVar = V3.n.f5531a;
                ((C1082l) objA).resumeWith(V3.n.a(v.f5542a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = this.f23380a.getAndSet(m.f23378a);
        j4.k.d(andSet);
        return andSet == m.f23379b;
    }
}
