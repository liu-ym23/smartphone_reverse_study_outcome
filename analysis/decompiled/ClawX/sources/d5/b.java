package d5;

import c5.l;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends c5.g implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1819a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1820b;

    /* renamed from: c, reason: collision with root package name */
    public int f1821c;
    public final b d;

    /* renamed from: e, reason: collision with root package name */
    public final c f1822e;

    public b(Object[] backing, int i8, int i9, b bVar, c root) {
        p.e(backing, "backing");
        p.e(root, "root");
        this.f1819a = backing;
        this.f1820b = i8;
        this.f1821c = i9;
        this.d = bVar;
        this.f1822e = root;
        ((AbstractList) this).modCount = ((AbstractList) root).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        l();
        k();
        j(this.f1820b + this.f1821c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        p.e(elements, "elements");
        l();
        k();
        int size = elements.size();
        i(this.f1820b + this.f1821c, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        l();
        k();
        n(this.f1820b, this.f1821c);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        k();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f1819a;
            int i8 = this.f1821c;
            if (i8 == list.size()) {
                for (int i9 = 0; i9 < i8; i9++) {
                    if (p.a(objArr[this.f1820b + i9], list.get(i9))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // c5.g
    public final int f() {
        k();
        return this.f1821c;
    }

    @Override // c5.g
    public final Object g(int i8) {
        l();
        k();
        int i9 = this.f1821c;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return m(this.f1820b + i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        k();
        int i9 = this.f1821c;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return this.f1819a[this.f1820b + i8];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        k();
        Object[] objArr = this.f1819a;
        int i8 = this.f1821c;
        int iHashCode = 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = objArr[this.f1820b + i9];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i8, Collection collection, int i9) {
        ((AbstractList) this).modCount++;
        c cVar = this.f1822e;
        b bVar = this.d;
        if (bVar != null) {
            bVar.i(i8, collection, i9);
        } else {
            c cVar2 = c.d;
            cVar.i(i8, collection, i9);
        }
        this.f1819a = cVar.f1823a;
        this.f1821c += i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        k();
        for (int i8 = 0; i8 < this.f1821c; i8++) {
            if (p.a(this.f1819a[this.f1820b + i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        k();
        return this.f1821c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i8, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f1822e;
        b bVar = this.d;
        if (bVar != null) {
            bVar.j(i8, obj);
        } else {
            c cVar2 = c.d;
            cVar.j(i8, obj);
        }
        this.f1819a = cVar.f1823a;
        this.f1821c++;
    }

    public final void k() {
        if (((AbstractList) this.f1822e).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void l() {
        if (this.f1822e.f1825c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        k();
        for (int i8 = this.f1821c - 1; i8 >= 0; i8--) {
            if (p.a(this.f1819a[this.f1820b + i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    public final Object m(int i8) {
        Object objM;
        ((AbstractList) this).modCount++;
        b bVar = this.d;
        if (bVar != null) {
            objM = bVar.m(i8);
        } else {
            c cVar = c.d;
            objM = this.f1822e.m(i8);
        }
        this.f1821c--;
        return objM;
    }

    public final void n(int i8, int i9) {
        if (i9 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.n(i8, i9);
        } else {
            c cVar = c.d;
            this.f1822e.n(i8, i9);
        }
        this.f1821c -= i9;
    }

    public final int o(int i8, int i9, Collection collection, boolean z) {
        int iO;
        b bVar = this.d;
        if (bVar != null) {
            iO = bVar.o(i8, i9, collection, z);
        } else {
            c cVar = c.d;
            iO = this.f1822e.o(i8, i9, collection, z);
        }
        if (iO > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f1821c -= iO;
        return iO;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        k();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            g(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        p.e(elements, "elements");
        l();
        k();
        return o(this.f1820b, this.f1821c, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        p.e(elements, "elements");
        l();
        k();
        return o(this.f1820b, this.f1821c, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        l();
        k();
        int i9 = this.f1821c;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        Object[] objArr = this.f1819a;
        int i10 = this.f1820b;
        Object obj2 = objArr[i10 + i8];
        objArr[i10 + i8] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i8, int i9) {
        a.a.k(i8, i9, this.f1821c);
        return new b(this.f1819a, this.f1820b + i8, i9 - i8, this, this.f1822e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        p.e(array, "array");
        k();
        int length = array.length;
        int i8 = this.f1821c;
        int i9 = this.f1820b;
        if (length < i8) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f1819a, i9, i8 + i9, array.getClass());
            p.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        l.W(this.f1819a, array, 0, i9, i8 + i9);
        int i10 = this.f1821c;
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        k();
        return b8.h.b(this.f1819a, this.f1820b, this.f1821c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i8) {
        k();
        int i9 = this.f1821c;
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return new a(this, i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        l();
        k();
        int i9 = this.f1821c;
        if (i8 >= 0 && i8 <= i9) {
            j(this.f1820b + i8, obj);
            return;
        }
        throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i8, Collection elements) {
        p.e(elements, "elements");
        l();
        k();
        int i9 = this.f1821c;
        if (i8 >= 0 && i8 <= i9) {
            int size = elements.size();
            i(this.f1820b + i8, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        k();
        Object[] objArr = this.f1819a;
        int i8 = this.f1821c;
        int i9 = this.f1820b;
        return l.a0(objArr, i9, i8 + i9);
    }
}
