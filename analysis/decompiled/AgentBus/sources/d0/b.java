package d0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import q7.j;
import q7.k;

/* loaded from: classes.dex */
public final class b implements List, r7.c {

    /* renamed from: f, reason: collision with root package name */
    public final e f2743f;

    public b(e eVar) {
        this.f2743f = eVar;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        this.f2743f.b(obj);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        e eVar = this.f2743f;
        return eVar.e(eVar.f2751h, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f2743f.g();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f2743f.h(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        e eVar = this.f2743f;
        eVar.getClass();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!eVar.h(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        f.a(i2, this);
        return this.f2743f.f2749f[i2];
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        e eVar = this.f2743f;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            if (k.a(obj, objArr[i10])) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f2743f.f2751h == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new d(0, this);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        e eVar = this.f2743f;
        Object[] objArr = eVar.f2749f;
        for (int i2 = eVar.f2751h - 1; i2 >= 0; i2--) {
            if (k.a(obj, objArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new d(0, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        return this.f2743f.i(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f2743f;
        eVar.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        int i2 = eVar.f2751h;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            eVar.i(it.next());
        }
        return i2 != eVar.f2751h;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f2743f;
        int i2 = eVar.f2751h;
        for (int i10 = i2 - 1; -1 < i10; i10--) {
            if (!collection.contains(eVar.f2749f[i10])) {
                eVar.j(i10);
            }
        }
        return i2 != eVar.f2751h;
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        f.a(i2, this);
        Object[] objArr = this.f2743f.f2749f;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f2743f.f2751h;
    }

    @Override // java.util.List
    public final List subList(int i2, int i10) {
        f.b(this, i2, i10);
        return new c(this, i2, i10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return j.a(this);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        this.f2743f.a(i2, obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        return new d(i2, this);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        f.a(i2, this);
        return this.f2743f.j(i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return j.b(this, objArr);
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        return this.f2743f.e(i2, collection);
    }
}
