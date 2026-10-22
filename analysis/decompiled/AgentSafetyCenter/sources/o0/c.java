package o0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c extends kb.e {
    public abstract c b(int i, Object obj);

    public abstract c c(Object obj);

    @Override // jb.n, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // jb.n, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public c d(Collection collection) {
        f fVarE = e();
        fVarE.addAll(collection);
        return fVarE.c();
    }

    public abstract f e();

    public abstract c f(b bVar);

    public abstract c g(int i);

    public abstract c h(int i, Object obj);

    @Override // kb.e, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // kb.e, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // kb.e, java.util.List
    public final List subList(int i, int i3) {
        return new n0.a(this, i, i3);
    }
}
