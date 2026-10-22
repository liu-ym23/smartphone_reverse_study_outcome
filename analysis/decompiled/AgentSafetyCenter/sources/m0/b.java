package m0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import yb.j;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements List, zb.b {

    /* renamed from: c, reason: collision with root package name */
    public e f8152c;

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        this.f8152c.b(obj);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        e eVar = this.f8152c;
        return eVar.e(eVar.f8160g, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f8152c.g();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f8152c.h(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        e eVar = this.f8152c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!eVar.h(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        f.a(i, this);
        return this.f8152c.f8158c[i];
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f8152c.i(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f8152c.f8160g == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d(0, this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        e eVar = this.f8152c;
        Object[] objArr = eVar.f8158c;
        for (int i = eVar.f8160g - 1; i >= 0; i--) {
            if (k.a(obj, objArr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new d(0, this);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        f.a(i, this);
        return this.f8152c.k(i);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f8152c;
        if (collection.isEmpty()) {
            return false;
        }
        int i = eVar.f8160g;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            eVar.j(it.next());
        }
        return i != eVar.f8160g;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f8152c;
        int i = eVar.f8160g;
        for (int i3 = i - 1; -1 < i3; i3--) {
            if (!collection.contains(eVar.f8158c[i3])) {
                eVar.k(i3);
            }
        }
        return i != eVar.f8160g;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        f.a(i, this);
        Object[] objArr = this.f8152c.f8158c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f8152c.f8160g;
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        f.b(this, i, i3);
        return new c(this, i, i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return j.b(this, objArr);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        this.f8152c.a(i, obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new d(i, this);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        return this.f8152c.e(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f8152c.j(obj);
    }
}
