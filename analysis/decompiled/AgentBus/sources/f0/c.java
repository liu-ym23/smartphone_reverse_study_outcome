package f0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public abstract class c extends d7.f implements List, Collection, r7.a {
    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // d7.a, java.util.Collection
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

    public abstract c f(int i2, Object obj);

    public abstract c h(Object obj);

    public c i(Collection collection) {
        g gVarJ = j();
        gVarJ.addAll(collection);
        return gVarJ.h();
    }

    @Override // d7.f, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public abstract g j();

    public abstract c k(b bVar);

    public abstract c l(int i2);

    @Override // d7.f, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public abstract c m(int i2, Object obj);

    @Override // d7.f, java.util.List
    public final List subList(int i2, int i10) {
        return new e0.a(this, i2, i10);
    }
}
