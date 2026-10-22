package Q0;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class p implements i {

    /* renamed from: a, reason: collision with root package name */
    private final Set<U0.e<?>> f4902a = Collections.newSetFromMap(new WeakHashMap());

    @Override // Q0.i
    public void a() {
        Iterator it = X0.k.j(this.f4902a).iterator();
        while (it.hasNext()) {
            ((U0.e) it.next()).a();
        }
    }

    @Override // Q0.i
    public void d() {
        Iterator it = X0.k.j(this.f4902a).iterator();
        while (it.hasNext()) {
            ((U0.e) it.next()).d();
        }
    }

    @Override // Q0.i
    public void g() {
        Iterator it = X0.k.j(this.f4902a).iterator();
        while (it.hasNext()) {
            ((U0.e) it.next()).g();
        }
    }

    public void h() {
        this.f4902a.clear();
    }

    public List<U0.e<?>> i() {
        return X0.k.j(this.f4902a);
    }

    public void n(U0.e<?> eVar) {
        this.f4902a.add(eVar);
    }

    public void o(U0.e<?> eVar) {
        this.f4902a.remove(eVar);
    }
}
