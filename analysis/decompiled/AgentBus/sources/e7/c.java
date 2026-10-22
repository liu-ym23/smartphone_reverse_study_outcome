package e7;

import d7.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class c extends d7.h implements RandomAccess, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final c f3086i;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f3087f;

    /* renamed from: g, reason: collision with root package name */
    public int f3088g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3089h;

    static {
        c cVar = new c(0);
        cVar.f3089h = true;
        f3086i = cVar;
    }

    public c(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f3087f = new Object[i2];
    }

    @Override // d7.h
    public final int a() {
        return this.f3088g;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        k();
        int i2 = this.f3088g;
        ((AbstractList) this).modCount++;
        l(i2, 1);
        this.f3087f[i2] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        k.e(collection, "elements");
        k();
        int size = collection.size();
        i(this.f3088g, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        k();
        n(0, this.f3088g);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f3087f;
            int i2 = this.f3088g;
            if (i2 == list.size()) {
                for (int i10 = 0; i10 < i2; i10++) {
                    if (k.a(objArr[i10], list.get(i10))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // d7.h
    public final Object f(int i2) {
        k();
        int i10 = this.f3088g;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return m(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int i10 = this.f3088g;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return this.f3087f[i2];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f3087f;
        int i2 = this.f3088g;
        int iHashCode = 1;
        for (int i10 = 0; i10 < i2; i10++) {
            Object obj = objArr[i10];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, Collection collection, int i10) {
        ((AbstractList) this).modCount++;
        l(i2, i10);
        Iterator it = collection.iterator();
        for (int i11 = 0; i11 < i10; i11++) {
            this.f3087f[i2 + i11] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f3088g; i2++) {
            if (k.a(this.f3087f[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f3088g == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        l(i2, 1);
        this.f3087f[i2] = obj;
    }

    public final void k() {
        if (this.f3089h) {
            throw new UnsupportedOperationException();
        }
    }

    public final void l(int i2, int i10) {
        int i11 = this.f3088g + i10;
        if (i11 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f3087f;
        if (i11 > objArr.length) {
            int length = objArr.length;
            int i12 = length + (length >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - 2147483639 > 0) {
                i12 = i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i12);
            k.d(objArrCopyOf, "copyOf(...)");
            this.f3087f = objArrCopyOf;
        }
        Object[] objArr2 = this.f3087f;
        n.Y(objArr2, objArr2, i2 + i10, i2, this.f3088g);
        this.f3088g += i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f3088g - 1; i2 >= 0; i2--) {
            if (k.a(this.f3087f[i2], obj)) {
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
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f3087f;
        Object obj = objArr[i2];
        n.Y(objArr, objArr, i2, i2 + 1, this.f3088g);
        Object[] objArr2 = this.f3087f;
        int i10 = this.f3088g - 1;
        k.e(objArr2, "<this>");
        objArr2[i10] = null;
        this.f3088g--;
        return obj;
    }

    public final void n(int i2, int i10) {
        if (i10 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f3087f;
        n.Y(objArr, objArr, i2, i2 + i10, this.f3088g);
        Object[] objArr2 = this.f3087f;
        int i11 = this.f3088g;
        ib.k.N(objArr2, i11 - i10, i11);
        this.f3088g -= i10;
    }

    public final int o(int i2, int i10, Collection collection, boolean z4) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i2 + i11;
            if (collection.contains(this.f3087f[i13]) == z4) {
                Object[] objArr = this.f3087f;
                i11++;
                objArr[i12 + i2] = objArr[i13];
                i12++;
            } else {
                i11++;
            }
        }
        int i14 = i10 - i12;
        Object[] objArr2 = this.f3087f;
        n.Y(objArr2, objArr2, i2 + i12, i10 + i2, this.f3088g);
        Object[] objArr3 = this.f3087f;
        int i15 = this.f3088g;
        ib.k.N(objArr3, i15 - i14, i15);
        if (i14 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f3088g -= i14;
        return i14;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
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
        k();
        return o(0, this.f3088g, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        k();
        return o(0, this.f3088g, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        k();
        int i10 = this.f3088g;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        Object[] objArr = this.f3087f;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i10) {
        s7.a.h(i2, i10, this.f3088g);
        return new b(this.f3087f, i2, i10 - i2, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        k.e(objArr, "array");
        int length = objArr.length;
        int i2 = this.f3088g;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f3087f, 0, i2, objArr.getClass());
            k.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        n.Y(this.f3087f, objArr, 0, 0, i2);
        int i10 = this.f3088g;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return ib.k.c(this.f3087f, 0, this.f3088g, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        int i10 = this.f3088g;
        if (i2 < 0 || i2 > i10) {
            throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
        }
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        k.e(collection, "elements");
        k();
        int i10 = this.f3088g;
        if (i2 >= 0 && i2 <= i10) {
            int size = collection.size();
            i(i2, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        k();
        int i10 = this.f3088g;
        if (i2 >= 0 && i2 <= i10) {
            ((AbstractList) this).modCount++;
            l(i2, 1);
            this.f3087f[i2] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(x.k("index: ", i2, i10, ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return n.c0(this.f3087f, 0, this.f3088g);
    }
}
