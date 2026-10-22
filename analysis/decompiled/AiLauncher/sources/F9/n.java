package F9;

import Z8.F;
import Z8.r;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes5.dex */
public final class n implements g {

    /* renamed from: a, reason: collision with root package name */
    public final List<g> f2621a;

    /* JADX WARN: Multi-variable type inference failed */
    public n(List<? extends g> delegates) {
        p.i(delegates, "delegates");
        this.f2621a = delegates;
    }

    public static final c e(ga.c cVar, g it) {
        p.i(it, "it");
        return it.d(cVar);
    }

    public static final Ka.j f(g it) {
        p.i(it, "it");
        return F.d0(it);
    }

    @Override // F9.g
    public boolean E(ga.c fqName) {
        p.i(fqName, "fqName");
        Iterator it = F.d0(this.f2621a).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).E(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // F9.g
    public c d(ga.c fqName) {
        p.i(fqName, "fqName");
        return (c) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(F.d0(this.f2621a), new l(fqName)));
    }

    @Override // F9.g
    public boolean isEmpty() {
        List<g> list = this.f2621a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return SequencesKt___SequencesKt.L(F.d0(this.f2621a), m.f2620a).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(g... delegates) {
        this((List<? extends g>) r.T0(delegates));
        p.i(delegates, "delegates");
    }
}
