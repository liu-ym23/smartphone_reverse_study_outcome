package D7;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class p extends AbstractC0218j {
    public static final Object[] d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f403a;
    public Object[] b;
    public int c;

    public p() {
        this.b = d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        l();
        e(elements.size() + size());
        b(j(size() + this.f403a), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        l();
        e(size() + 1);
        int i = this.f403a;
        int iQ0 = i == 0 ? q.q0(this.b) : i - 1;
        this.f403a = iQ0;
        this.b[iQ0] = obj;
        this.c = size() + 1;
    }

    public final void addLast(Object obj) {
        l();
        e(size() + 1);
        this.b[j(size() + this.f403a)] = obj;
        this.c = size() + 1;
    }

    public final void b(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i6 = this.f403a;
        for (int i10 = 0; i10 < i6 && it.hasNext(); i10++) {
            this.b[i10] = it.next();
        }
        this.c = collection.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            l();
            i(this.f403a, j(size() + this.f403a));
        }
        this.f403a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i < 10) {
                i = 10;
            }
            this.b = new Object[i];
            return;
        }
        C0211c c0211c = AbstractC0214f.Companion;
        int length = objArr.length;
        c0211c.getClass();
        Object[] objArr2 = new Object[C0211c.e(length, i)];
        Object[] objArr3 = this.b;
        q.X(objArr3, objArr2, 0, this.f403a, objArr3.length);
        Object[] objArr4 = this.b;
        int length2 = objArr4.length;
        int i6 = this.f403a;
        q.X(objArr4, objArr2, length2 - i6, 0, i6);
        this.f403a = 0;
        this.b = objArr2;
    }

    public final Object f() {
        if (isEmpty()) {
            return null;
        }
        return this.b[this.f403a];
    }

    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[this.f403a];
    }

    public final int g(int i) {
        if (i == q.q0(this.b)) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.b(i, size);
        return this.b[j(this.f403a + i)];
    }

    @Override // D7.AbstractC0218j
    public final int getSize() {
        return this.c;
    }

    public final int h(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    public final void i(int i, int i6) {
        if (i < i6) {
            q.f0(null, i, this.b, i6);
            return;
        }
        Object[] objArr = this.b;
        q.f0(null, i, objArr, objArr.length);
        q.f0(null, 0, this.b, i6);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iJ = j(size() + this.f403a);
        int length = this.f403a;
        if (length < iJ) {
            while (length < iJ) {
                if (kotlin.jvm.internal.k.b(obj, this.b[length])) {
                    i = this.f403a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iJ) {
            return -1;
        }
        int length2 = this.b.length;
        while (true) {
            if (length >= length2) {
                for (int i6 = 0; i6 < iJ; i6++) {
                    if (kotlin.jvm.internal.k.b(obj, this.b[i6])) {
                        length = i6 + this.b.length;
                        i = this.f403a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.k.b(obj, this.b[length])) {
                i = this.f403a;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final int j(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void l() {
        ((AbstractList) this).modCount++;
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.b[j(H4.o.H(this) + this.f403a)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int iQ0;
        int i;
        int iJ = j(size() + this.f403a);
        int i6 = this.f403a;
        if (i6 < iJ) {
            iQ0 = iJ - 1;
            if (i6 <= iQ0) {
                while (!kotlin.jvm.internal.k.b(obj, this.b[iQ0])) {
                    if (iQ0 != i6) {
                        iQ0--;
                    }
                }
                i = this.f403a;
                return iQ0 - i;
            }
            return -1;
        }
        if (i6 > iJ) {
            int i10 = iJ - 1;
            while (true) {
                if (-1 >= i10) {
                    iQ0 = q.q0(this.b);
                    int i11 = this.f403a;
                    if (i11 <= iQ0) {
                        while (!kotlin.jvm.internal.k.b(obj, this.b[iQ0])) {
                            if (iQ0 != i11) {
                                iQ0--;
                            }
                        }
                        i = this.f403a;
                    }
                } else {
                    if (kotlin.jvm.internal.k.b(obj, this.b[i10])) {
                        iQ0 = i10 + this.b.length;
                        i = this.f403a;
                        break;
                    }
                    i10--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iJ;
        kotlin.jvm.internal.k.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.b.length != 0) {
            int iJ2 = j(size() + this.f403a);
            int i = this.f403a;
            if (i < iJ2) {
                iJ = i;
                while (i < iJ2) {
                    Object obj = this.b[i];
                    if (elements.contains(obj)) {
                        z10 = true;
                    } else {
                        this.b[iJ] = obj;
                        iJ++;
                    }
                    i++;
                }
                q.f0(null, iJ, this.b, iJ2);
            } else {
                int length = this.b.length;
                boolean z11 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.b[i6] = obj2;
                        i6++;
                    }
                    i++;
                }
                iJ = j(i6);
                for (int i10 = 0; i10 < iJ2; i10++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (elements.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.b[iJ] = obj3;
                        iJ = g(iJ);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                l();
                this.c = h(iJ - this.f403a);
            }
        }
        return z10;
    }

    @Override // D7.AbstractC0218j
    public final Object removeAt(int i) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.b(i, size);
        if (i == H4.o.H(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        l();
        int iJ = j(this.f403a + i);
        Object obj = this.b[iJ];
        if (i < (size() >> 1)) {
            int i6 = this.f403a;
            if (iJ >= i6) {
                Object[] objArr = this.b;
                q.X(objArr, objArr, i6 + 1, i6, iJ);
            } else {
                Object[] objArr2 = this.b;
                q.X(objArr2, objArr2, 1, 0, iJ);
                Object[] objArr3 = this.b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i10 = this.f403a;
                q.X(objArr3, objArr3, i10 + 1, i10, objArr3.length - 1);
            }
            Object[] objArr4 = this.b;
            int i11 = this.f403a;
            objArr4[i11] = null;
            this.f403a = g(i11);
        } else {
            int iJ2 = j(H4.o.H(this) + this.f403a);
            if (iJ <= iJ2) {
                Object[] objArr5 = this.b;
                q.X(objArr5, objArr5, iJ, iJ + 1, iJ2 + 1);
            } else {
                Object[] objArr6 = this.b;
                q.X(objArr6, objArr6, iJ, iJ + 1, objArr6.length);
                Object[] objArr7 = this.b;
                objArr7[objArr7.length - 1] = objArr7[0];
                q.X(objArr7, objArr7, 0, 1, iJ2 + 1);
            }
            this.b[iJ2] = null;
        }
        this.c = size() - 1;
        return obj;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        l();
        Object[] objArr = this.b;
        int i = this.f403a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f403a = g(i);
        this.c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        l();
        int iJ = j(H4.o.H(this) + this.f403a);
        Object[] objArr = this.b;
        Object obj = objArr[iJ];
        objArr[iJ] = null;
        this.c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.d(i, i6, size);
        int i10 = i6 - i;
        if (i10 == 0) {
            return;
        }
        if (i10 == size()) {
            clear();
            return;
        }
        if (i10 == 1) {
            removeAt(i);
            return;
        }
        l();
        if (i < size() - i6) {
            int iJ = j(this.f403a + (i - 1));
            int iJ2 = j(this.f403a + (i6 - 1));
            while (i > 0) {
                int i11 = iJ + 1;
                int iMin = Math.min(i, Math.min(i11, iJ2 + 1));
                Object[] objArr = this.b;
                int i12 = iJ2 - iMin;
                int i13 = iJ - iMin;
                q.X(objArr, objArr, i12 + 1, i13 + 1, i11);
                iJ = h(i13);
                iJ2 = h(i12);
                i -= iMin;
            }
            int iJ3 = j(this.f403a + i10);
            i(this.f403a, iJ3);
            this.f403a = iJ3;
        } else {
            int iJ4 = j(this.f403a + i6);
            int iJ5 = j(this.f403a + i);
            int size2 = size();
            while (true) {
                size2 -= i6;
                if (size2 <= 0) {
                    break;
                }
                Object[] objArr2 = this.b;
                i6 = Math.min(size2, Math.min(objArr2.length - iJ4, objArr2.length - iJ5));
                Object[] objArr3 = this.b;
                int i14 = iJ4 + i6;
                q.X(objArr3, objArr3, iJ5, iJ4, i14);
                iJ4 = j(i14);
                iJ5 = j(iJ5 + i6);
            }
            int iJ6 = j(size() + this.f403a);
            i(h(iJ6 - i10), iJ6);
        }
        this.c = size() - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iJ;
        kotlin.jvm.internal.k.f(elements, "elements");
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.b.length != 0) {
            int iJ2 = j(size() + this.f403a);
            int i = this.f403a;
            if (i < iJ2) {
                iJ = i;
                while (i < iJ2) {
                    Object obj = this.b[i];
                    if (elements.contains(obj)) {
                        this.b[iJ] = obj;
                        iJ++;
                    } else {
                        z10 = true;
                    }
                    i++;
                }
                q.f0(null, iJ, this.b, iJ2);
            } else {
                int length = this.b.length;
                boolean z11 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.b[i6] = obj2;
                        i6++;
                    } else {
                        z11 = true;
                    }
                    i++;
                }
                iJ = j(i6);
                for (int i10 = 0; i10 < iJ2; i10++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (elements.contains(obj3)) {
                        this.b[iJ] = obj3;
                        iJ = g(iJ);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                l();
                this.c = h(iJ - this.f403a);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.b(i, size);
        int iJ = j(this.f403a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iJ];
        objArr[iJ] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) throws NegativeArraySizeException {
        kotlin.jvm.internal.k.f(array, "array");
        if (array.length < size()) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), size());
            kotlin.jvm.internal.k.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        Object[] objArr = array;
        int iJ = j(size() + this.f403a);
        int i = this.f403a;
        if (i < iJ) {
            q.b0(this.b, objArr, 0, i, iJ, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            q.X(objArr2, objArr, 0, this.f403a, objArr2.length);
            Object[] objArr3 = this.b;
            q.X(objArr3, objArr, objArr3.length - this.f403a, 0, iJ);
        }
        int size = size();
        if (size < objArr.length) {
            objArr[size] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.c(i, size);
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        l();
        e(size() + 1);
        int iJ = j(this.f403a + i);
        if (i < ((size() + 1) >> 1)) {
            int iQ0 = iJ == 0 ? q.q0(this.b) : iJ - 1;
            int i6 = this.f403a;
            int iQ02 = i6 == 0 ? q.q0(this.b) : i6 - 1;
            int i10 = this.f403a;
            if (iQ0 >= i10) {
                Object[] objArr = this.b;
                objArr[iQ02] = objArr[i10];
                q.X(objArr, objArr, i10, i10 + 1, iQ0 + 1);
            } else {
                Object[] objArr2 = this.b;
                q.X(objArr2, objArr2, i10 - 1, i10, objArr2.length);
                Object[] objArr3 = this.b;
                objArr3[objArr3.length - 1] = objArr3[0];
                q.X(objArr3, objArr3, 0, 1, iQ0 + 1);
            }
            this.b[iQ0] = obj;
            this.f403a = iQ02;
        } else {
            int iJ2 = j(size() + this.f403a);
            if (iJ < iJ2) {
                Object[] objArr4 = this.b;
                q.X(objArr4, objArr4, iJ + 1, iJ, iJ2);
            } else {
                Object[] objArr5 = this.b;
                q.X(objArr5, objArr5, 1, 0, iJ2);
                Object[] objArr6 = this.b;
                objArr6[0] = objArr6[objArr6.length - 1];
                q.X(objArr6, objArr6, iJ + 1, iJ, objArr6.length - 1);
            }
            this.b[iJ] = obj;
        }
        this.c = size() + 1;
    }

    public p(int i) {
        this.b = new Object[16];
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        C0211c c0211c = AbstractC0214f.Companion;
        int size = size();
        c0211c.getClass();
        C0211c.c(i, size);
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        l();
        e(elements.size() + size());
        int iJ = j(size() + this.f403a);
        int iJ2 = j(this.f403a + i);
        int size2 = elements.size();
        if (i < ((size() + 1) >> 1)) {
            int i6 = this.f403a;
            int length = i6 - size2;
            if (iJ2 < i6) {
                Object[] objArr = this.b;
                q.X(objArr, objArr, length, i6, objArr.length);
                if (size2 >= iJ2) {
                    Object[] objArr2 = this.b;
                    q.X(objArr2, objArr2, objArr2.length - size2, 0, iJ2);
                } else {
                    Object[] objArr3 = this.b;
                    q.X(objArr3, objArr3, objArr3.length - size2, 0, size2);
                    Object[] objArr4 = this.b;
                    q.X(objArr4, objArr4, 0, size2, iJ2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.b;
                q.X(objArr5, objArr5, length, i6, iJ2);
            } else {
                Object[] objArr6 = this.b;
                length += objArr6.length;
                int i10 = iJ2 - i6;
                int length2 = objArr6.length - length;
                if (length2 >= i10) {
                    q.X(objArr6, objArr6, length, i6, iJ2);
                } else {
                    q.X(objArr6, objArr6, length, i6, i6 + length2);
                    Object[] objArr7 = this.b;
                    q.X(objArr7, objArr7, 0, this.f403a + length2, iJ2);
                }
            }
            this.f403a = length;
            b(h(iJ2 - size2), elements);
            return true;
        }
        int i11 = iJ2 + size2;
        if (iJ2 < iJ) {
            int i12 = size2 + iJ;
            Object[] objArr8 = this.b;
            if (i12 <= objArr8.length) {
                q.X(objArr8, objArr8, i11, iJ2, iJ);
            } else if (i11 >= objArr8.length) {
                q.X(objArr8, objArr8, i11 - objArr8.length, iJ2, iJ);
            } else {
                int length3 = iJ - (i12 - objArr8.length);
                q.X(objArr8, objArr8, 0, length3, iJ);
                Object[] objArr9 = this.b;
                q.X(objArr9, objArr9, i11, iJ2, length3);
            }
        } else {
            Object[] objArr10 = this.b;
            q.X(objArr10, objArr10, size2, 0, iJ);
            Object[] objArr11 = this.b;
            if (i11 >= objArr11.length) {
                q.X(objArr11, objArr11, i11 - objArr11.length, iJ2, objArr11.length);
            } else {
                q.X(objArr11, objArr11, 0, objArr11.length - size2, objArr11.length);
                Object[] objArr12 = this.b;
                q.X(objArr12, objArr12, i11, iJ2, objArr12.length - size2);
            }
        }
        b(iJ2, elements);
        return true;
    }

    public p(ArrayList arrayList) {
        Object[] array = arrayList.toArray(new Object[0]);
        this.b = array;
        this.c = array.length;
        if (array.length == 0) {
            this.b = d;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
