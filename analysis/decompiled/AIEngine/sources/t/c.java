package t;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import s.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c<E> extends mb.c<E> implements s.b<E> {
    @Override // java.util.Collection, java.util.List, s.b
    public s.b<E> addAll(Collection<? extends E> collection) {
        f fVarBuilder = builder();
        fVarBuilder.addAll(collection);
        return fVarBuilder.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mb.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // mb.a, java.util.Collection
    public final boolean containsAll(Collection<?> collection) {
        Collection<?> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // mb.c, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // mb.c, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.Collection, java.util.List, s.b
    public final s.b<E> remove(E e10) {
        int iIndexOf = indexOf(e10);
        return iIndexOf != -1 ? w(iIndexOf) : this;
    }

    @Override // java.util.Collection, java.util.List, s.b
    public final s.b<E> removeAll(Collection<? extends E> collection) {
        return P(new b(0, collection));
    }

    @Override // mb.c, java.util.List
    public final List subList(int i10, int i11) {
        return new a.C0138a(this, i10, i11);
    }
}
