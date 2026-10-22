package d5;

import c5.l;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends c5.g implements RandomAccess, Serializable {
    public static final c d;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1823a;

    /* renamed from: b, reason: collision with root package name */
    public int f1824b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1825c;

    static {
        c cVar = new c(0);
        cVar.f1825c = true;
        d = cVar;
    }

    public c(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f1823a = new Object[i8];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        k();
        int i8 = this.f1824b;
        ((AbstractList) this).modCount++;
        l(i8, 1);
        this.f1823a[i8] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        p.e(elements, "elements");
        k();
        int size = elements.size();
        i(this.f1824b, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        k();
        n(0, this.f1824b);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f1823a;
            int i8 = this.f1824b;
            if (i8 == list.size()) {
                for (int i9 = 0; i9 < i8; i9++) {
                    if (p.a(objArr[i9], list.get(i9))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // c5.g
    public final int f() {
        return this.f1824b;
    }

    @Override // c5.g
    public final Object g(int i8) {
        k();
        int i9 = this.f1824b;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return m(i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        int i9 = this.f1824b;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return this.f1823a[i8];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f1823a;
        int i8 = this.f1824b;
        int iHashCode = 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = objArr[i9];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i8, Collection collection, int i9) {
        ((AbstractList) this).modCount++;
        l(i8, i9);
        Iterator it = collection.iterator();
        for (int i10 = 0; i10 < i9; i10++) {
            this.f1823a[i8 + i10] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i8 = 0; i8 < this.f1824b; i8++) {
            if (p.a(this.f1823a[i8], obj)) {
                return i8;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f1824b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void j(int i8, Object obj) {
        ((AbstractList) this).modCount++;
        l(i8, 1);
        this.f1823a[i8] = obj;
    }

    public final void k() {
        if (this.f1825c) {
            throw new UnsupportedOperationException();
        }
    }

    public final void l(int i8, int i9) {
        int i10 = this.f1824b + i9;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f1823a;
        if (i10 > objArr.length) {
            int length = objArr.length;
            int i11 = length + (length >> 1);
            if (i11 - i10 < 0) {
                i11 = i10;
            }
            if (i11 - 2147483639 > 0) {
                i11 = i10 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i11);
            p.d(objArrCopyOf, "copyOf(...)");
            this.f1823a = objArrCopyOf;
        }
        Object[] objArr2 = this.f1823a;
        l.W(objArr2, objArr2, i8 + i9, i8, this.f1824b);
        this.f1824b += i9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i8 = this.f1824b - 1; i8 >= 0; i8--) {
            if (p.a(this.f1823a[i8], obj)) {
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
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f1823a;
        Object obj = objArr[i8];
        l.W(objArr, objArr, i8, i8 + 1, this.f1824b);
        Object[] objArr2 = this.f1823a;
        int i9 = this.f1824b - 1;
        p.e(objArr2, "<this>");
        objArr2[i9] = null;
        this.f1824b--;
        return obj;
    }

    public final void n(int i8, int i9) {
        if (i9 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f1823a;
        l.W(objArr, objArr, i8, i8 + i9, this.f1824b);
        Object[] objArr2 = this.f1823a;
        int i10 = this.f1824b;
        b8.h.K(objArr2, i10 - i9, i10);
        this.f1824b -= i9;
    }

    public final int o(int i8, int i9, Collection collection, boolean z) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = i8 + i10;
            if (collection.contains(this.f1823a[i12]) == z) {
                Object[] objArr = this.f1823a;
                i10++;
                objArr[i11 + i8] = objArr[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = i9 - i11;
        Object[] objArr2 = this.f1823a;
        l.W(objArr2, objArr2, i8 + i11, i9 + i8, this.f1824b);
        Object[] objArr3 = this.f1823a;
        int i14 = this.f1824b;
        b8.h.K(objArr3, i14 - i13, i14);
        if (i13 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f1824b -= i13;
        return i13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
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
        k();
        return o(0, this.f1824b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        p.e(elements, "elements");
        k();
        return o(0, this.f1824b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        k();
        int i9 = this.f1824b;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        Object[] objArr = this.f1823a;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i8, int i9) {
        a.a.k(i8, i9, this.f1824b);
        return new b(this.f1823a, i8, i9 - i8, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        p.e(array, "array");
        int length = array.length;
        int i8 = this.f1824b;
        if (length < i8) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f1823a, 0, i8, array.getClass());
            p.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        l.W(this.f1823a, array, 0, 0, i8);
        int i9 = this.f1824b;
        if (i9 < array.length) {
            array[i9] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return b8.h.b(this.f1823a, 0, this.f1824b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i8) {
        int i9 = this.f1824b;
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        return new a(this, i8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i8, Collection elements) {
        p.e(elements, "elements");
        k();
        int i9 = this.f1824b;
        if (i8 >= 0 && i8 <= i9) {
            int size = elements.size();
            i(i8, elements, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        k();
        int i9 = this.f1824b;
        if (i8 >= 0 && i8 <= i9) {
            ((AbstractList) this).modCount++;
            l(i8, 1);
            this.f1823a[i8] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return l.a0(this.f1823a, 0, this.f1824b);
    }
}
