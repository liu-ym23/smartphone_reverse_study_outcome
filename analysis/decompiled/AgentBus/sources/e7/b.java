package e7;

import d7.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class b extends d7.h implements RandomAccess, Serializable {

    /* renamed from: f, reason: collision with root package name */
    public Object[] f3081f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3082g;

    /* renamed from: h, reason: collision with root package name */
    public int f3083h;

    /* renamed from: i, reason: collision with root package name */
    public final b f3084i;

    /* renamed from: j, reason: collision with root package name */
    public final c f3085j;

    public b(Object[] objArr, int i2, int i10, b bVar, c cVar) {
        k.e(objArr, "backing");
        k.e(cVar, "root");
        this.f3081f = objArr;
        this.f3082g = i2;
        this.f3083h = i10;
        this.f3084i = bVar;
        this.f3085j = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // d7.h
    public final int a() {
        k();
        return this.f3083h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        l();
        k();
        j(this.f3082g + this.f3083h, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        k.e(collection, "elements");
        l();
        k();
        int size = collection.size();
        i(this.f3082g + this.f3083h, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        l();
        k();
        n(this.f3082g, this.f3083h);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        k();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f3081f;
            int i2 = this.f3083h;
            if (i2 == list.size()) {
                for (int i10 = 0; i10 < i2; i10++) {
                    if (k.a(objArr[this.f3082g + i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // d7.h
    public final Object f(int i2) {
        l();
        k();
        int i10 = this.f3083h;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return m(this.f3082g + i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        k();
        int i10 = this.f3083h;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return this.f3081f[this.f3082g + i2];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        k();
        Object[] objArr = this.f3081f;
        int i2 = this.f3083h;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i2; i10++) {
            Object obj = objArr[this.f3082g + i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        c cVar = this.f3085j;
        b bVar = this.f3084i;
        if (bVar != null) {
            bVar.i(i2, collection, i10);
        } else {
            c cVar2 = c.f3086i;
            cVar.i(i2, collection, i10);
        }
        this.f3081f = cVar.f3087f;
        this.f3083h += i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        k();
        for (int i2 = 0; i2 < this.f3083h; i2++) {
            if (k.a(this.f3081f[this.f3082g + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        k();
        return this.f3083h == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f3085j;
        b bVar = this.f3084i;
        if (bVar != null) {
            bVar.j(i2, obj);
        } else {
            c cVar2 = c.f3086i;
            cVar.j(i2, obj);
        }
        this.f3081f = cVar.f3087f;
        this.f3083h++;
    }

    public final void k() {
        if (((AbstractList) this.f3085j).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void l() {
        if (this.f3085j.f3089h) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        k();
        for (int i2 = this.f3083h - 1; i2 >= 0; i2--) {
            if (k.a(this.f3081f[this.f3082g + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final Object m(int i2) {
        Object objM;
        ((AbstractList) this).modCount++;
        b bVar = this.f3084i;
        if (bVar != null) {
            objM = bVar.m(i2);
        } else {
            c cVar = c.f3086i;
            objM = this.f3085j.m(i2);
        }
        this.f3083h--;
        return objM;
    }

    public final void n(int i2, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f3084i;
        if (bVar != null) {
            bVar.n(i2, i10);
        } else {
            c cVar = c.f3086i;
            this.f3085j.n(i2, i10);
        }
        this.f3083h -= i10;
    }

    public final int o(int i2, int i10, Collection collection, boolean z4) {
        int iO;
        b bVar = this.f3084i;
        if (bVar != null) {
            iO = bVar.o(i2, i10, collection, z4);
        } else {
            c cVar = c.f3086i;
            iO = this.f3085j.o(i2, i10, collection, z4);
        }
        if (iO > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f3083h -= iO;
        return iO;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        k();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            f(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        l();
        k();
        return o(this.f3082g, this.f3083h, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        l();
        k();
        return o(this.f3082g, this.f3083h, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        l();
        k();
        int i10 = this.f3083h;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        Object[] objArr = this.f3081f;
        int i11 = this.f3082g;
        Object obj2 = objArr[i11 + i2];
        objArr[i11 + i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i10) {
        s7.a.h(i2, i10, this.f3083h);
        return new b(this.f3081f, this.f3082g + i2, i10 - i2, this, this.f3085j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        k.e(objArr, "array");
        k();
        int length = objArr.length;
        int i2 = this.f3083h;
        int i10 = this.f3082g;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f3081f, i10, i2 + i10, objArr.getClass());
            k.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        n.Y(this.f3081f, objArr, 0, i10, i2 + i10);
        int i11 = this.f3083h;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        k();
        return ib.k.c(this.f3081f, this.f3082g, this.f3083h, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        k();
        int i10 = this.f3083h;
        if (i2 < 0 || i2 > i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        l();
        k();
        int i10 = this.f3083h;
        if (i2 >= 0 && i2 <= i10) {
            j(this.f3082g + i2, obj);
            return;
        }
        throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        k.e(collection, "elements");
        l();
        k();
        int i10 = this.f3083h;
        if (i2 >= 0 && i2 <= i10) {
            int size = collection.size();
            i(this.f3082g + i2, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        k();
        Object[] objArr = this.f3081f;
        int i2 = this.f3083h;
        int i10 = this.f3082g;
        return n.c0(objArr, i10, i2 + i10);
    }
}
