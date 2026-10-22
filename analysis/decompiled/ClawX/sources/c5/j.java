package c5;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends g {
    public static final Object[] d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f1086a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1087b = d;

    /* renamed from: c, reason: collision with root package name */
    public int f1088c;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        int length;
        int i9 = this.f1088c;
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        if (i8 == i9) {
            addLast(obj);
            return;
        }
        if (i8 == 0) {
            addFirst(obj);
            return;
        }
        n();
        i(this.f1088c + 1);
        int iM = m(this.f1086a + i8);
        int i10 = this.f1088c;
        if (i8 < ((i10 + 1) >> 1)) {
            if (iM == 0) {
                Object[] objArr = this.f1087b;
                kotlin.jvm.internal.p.e(objArr, "<this>");
                iM = objArr.length;
            }
            int i11 = iM - 1;
            int i12 = this.f1086a;
            if (i12 == 0) {
                Object[] objArr2 = this.f1087b;
                kotlin.jvm.internal.p.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i12 - 1;
            }
            int i13 = this.f1086a;
            if (i11 >= i13) {
                Object[] objArr3 = this.f1087b;
                objArr3[length] = objArr3[i13];
                l.W(objArr3, objArr3, i13, i13 + 1, i11 + 1);
            } else {
                Object[] objArr4 = this.f1087b;
                l.W(objArr4, objArr4, i13 - 1, i13, objArr4.length);
                Object[] objArr5 = this.f1087b;
                objArr5[objArr5.length - 1] = objArr5[0];
                l.W(objArr5, objArr5, 0, 1, i11 + 1);
            }
            this.f1087b[i11] = obj;
            this.f1086a = length;
        } else {
            int iM2 = m(i10 + this.f1086a);
            if (iM < iM2) {
                Object[] objArr6 = this.f1087b;
                l.W(objArr6, objArr6, iM + 1, iM, iM2);
            } else {
                Object[] objArr7 = this.f1087b;
                l.W(objArr7, objArr7, 1, 0, iM2);
                Object[] objArr8 = this.f1087b;
                objArr8[0] = objArr8[objArr8.length - 1];
                l.W(objArr8, objArr8, iM + 1, iM, objArr8.length - 1);
            }
            this.f1087b[iM] = obj;
        }
        this.f1088c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i8, Collection elements) {
        kotlin.jvm.internal.p.e(elements, "elements");
        int i9 = this.f1088c;
        if (i8 < 0 || i8 > i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        if (elements.isEmpty()) {
            return false;
        }
        if (i8 == this.f1088c) {
            return addAll(elements);
        }
        n();
        i(elements.size() + this.f1088c);
        int iM = m(this.f1088c + this.f1086a);
        int iM2 = m(this.f1086a + i8);
        int size = elements.size();
        if (i8 >= ((this.f1088c + 1) >> 1)) {
            int i10 = iM2 + size;
            if (iM2 < iM) {
                int i11 = size + iM;
                Object[] objArr = this.f1087b;
                if (i11 <= objArr.length) {
                    l.W(objArr, objArr, i10, iM2, iM);
                } else if (i10 >= objArr.length) {
                    l.W(objArr, objArr, i10 - objArr.length, iM2, iM);
                } else {
                    int length = iM - (i11 - objArr.length);
                    l.W(objArr, objArr, 0, length, iM);
                    Object[] objArr2 = this.f1087b;
                    l.W(objArr2, objArr2, i10, iM2, length);
                }
            } else {
                Object[] objArr3 = this.f1087b;
                l.W(objArr3, objArr3, size, 0, iM);
                Object[] objArr4 = this.f1087b;
                if (i10 >= objArr4.length) {
                    l.W(objArr4, objArr4, i10 - objArr4.length, iM2, objArr4.length);
                } else {
                    l.W(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.f1087b;
                    l.W(objArr5, objArr5, i10, iM2, objArr5.length - size);
                }
            }
            h(iM2, elements);
            return true;
        }
        int i12 = this.f1086a;
        int length2 = i12 - size;
        if (iM2 < i12) {
            Object[] objArr6 = this.f1087b;
            l.W(objArr6, objArr6, length2, i12, objArr6.length);
            if (size >= iM2) {
                Object[] objArr7 = this.f1087b;
                l.W(objArr7, objArr7, objArr7.length - size, 0, iM2);
            } else {
                Object[] objArr8 = this.f1087b;
                l.W(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.f1087b;
                l.W(objArr9, objArr9, 0, size, iM2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f1087b;
            l.W(objArr10, objArr10, length2, i12, iM2);
        } else {
            Object[] objArr11 = this.f1087b;
            length2 += objArr11.length;
            int i13 = iM2 - i12;
            int length3 = objArr11.length - length2;
            if (length3 >= i13) {
                l.W(objArr11, objArr11, length2, i12, iM2);
            } else {
                l.W(objArr11, objArr11, length2, i12, i12 + length3);
                Object[] objArr12 = this.f1087b;
                l.W(objArr12, objArr12, 0, this.f1086a + length3, iM2);
            }
        }
        this.f1086a = length2;
        h(k(iM2 - size), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        i(this.f1088c + 1);
        int length = this.f1086a;
        if (length == 0) {
            Object[] objArr = this.f1087b;
            kotlin.jvm.internal.p.e(objArr, "<this>");
            length = objArr.length;
        }
        int i8 = length - 1;
        this.f1086a = i8;
        this.f1087b[i8] = obj;
        this.f1088c++;
    }

    public final void addLast(Object obj) {
        n();
        i(f() + 1);
        this.f1087b[m(f() + this.f1086a)] = obj;
        this.f1088c = f() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.f1086a, m(f() + this.f1086a));
        }
        this.f1086a = 0;
        this.f1088c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // c5.g
    public final int f() {
        return this.f1088c;
    }

    @Override // c5.g
    public final Object g(int i8) {
        int i9 = this.f1088c;
        if (i8 < 0 || i8 >= i9) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, i9, "index: ", ", size: "));
        }
        if (i8 == n.j0(this)) {
            return removeLast();
        }
        if (i8 == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.f1086a + i8);
        Object[] objArr = this.f1087b;
        Object obj = objArr[iM];
        if (i8 < (this.f1088c >> 1)) {
            int i10 = this.f1086a;
            if (iM >= i10) {
                l.W(objArr, objArr, i10 + 1, i10, iM);
            } else {
                l.W(objArr, objArr, 1, 0, iM);
                Object[] objArr2 = this.f1087b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i11 = this.f1086a;
                l.W(objArr2, objArr2, i11 + 1, i11, objArr2.length - 1);
            }
            Object[] objArr3 = this.f1087b;
            int i12 = this.f1086a;
            objArr3[i12] = null;
            this.f1086a = j(i12);
        } else {
            int iM2 = m(n.j0(this) + this.f1086a);
            if (iM <= iM2) {
                Object[] objArr4 = this.f1087b;
                l.W(objArr4, objArr4, iM, iM + 1, iM2 + 1);
            } else {
                Object[] objArr5 = this.f1087b;
                l.W(objArr5, objArr5, iM, iM + 1, objArr5.length);
                Object[] objArr6 = this.f1087b;
                objArr6[objArr6.length - 1] = objArr6[0];
                l.W(objArr6, objArr6, 0, 1, iM2 + 1);
            }
            this.f1087b[iM2] = null;
        }
        this.f1088c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        int iF = f();
        if (i8 < 0 || i8 >= iF) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, iF, "index: ", ", size: "));
        }
        return this.f1087b[m(this.f1086a + i8)];
    }

    public final void h(int i8, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f1087b.length;
        while (i8 < length && it.hasNext()) {
            this.f1087b[i8] = it.next();
            i8++;
        }
        int i9 = this.f1086a;
        for (int i10 = 0; i10 < i9 && it.hasNext(); i10++) {
            this.f1087b[i10] = it.next();
        }
        this.f1088c = collection.size() + this.f1088c;
    }

    public final void i(int i8) {
        if (i8 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f1087b;
        if (i8 <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i8 < 10) {
                i8 = 10;
            }
            this.f1087b = new Object[i8];
            return;
        }
        int length = objArr.length;
        int i9 = length + (length >> 1);
        if (i9 - i8 < 0) {
            i9 = i8;
        }
        if (i9 - 2147483639 > 0) {
            i9 = i8 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i9];
        l.W(objArr, objArr2, 0, this.f1086a, objArr.length);
        Object[] objArr3 = this.f1087b;
        int length2 = objArr3.length;
        int i10 = this.f1086a;
        l.W(objArr3, objArr2, length2 - i10, 0, i10);
        this.f1086a = 0;
        this.f1087b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i8;
        int iM = m(f() + this.f1086a);
        int length = this.f1086a;
        if (length < iM) {
            while (length < iM) {
                if (kotlin.jvm.internal.p.a(obj, this.f1087b[length])) {
                    i8 = this.f1086a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (isEmpty() || (length = this.f1086a) < iM) {
            return -1;
        }
        int length2 = this.f1087b.length;
        while (true) {
            if (length >= length2) {
                for (int i9 = 0; i9 < iM; i9++) {
                    if (kotlin.jvm.internal.p.a(obj, this.f1087b[i9])) {
                        length = i9 + this.f1087b.length;
                        i8 = this.f1086a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.p.a(obj, this.f1087b[length])) {
                i8 = this.f1086a;
                break;
            }
            length++;
        }
        return length - i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return f() == 0;
    }

    public final int j(int i8) {
        kotlin.jvm.internal.p.e(this.f1087b, "<this>");
        if (i8 == r1.length - 1) {
            return 0;
        }
        return i8 + 1;
    }

    public final int k(int i8) {
        return i8 < 0 ? i8 + this.f1087b.length : i8;
    }

    public final void l(int i8, int i9) {
        if (i8 < i9) {
            l.c0(this.f1087b, i8, i9);
            return;
        }
        Object[] objArr = this.f1087b;
        l.c0(objArr, i8, objArr.length);
        l.c0(this.f1087b, 0, i9);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i8;
        int iM = m(this.f1088c + this.f1086a);
        int i9 = this.f1086a;
        if (i9 < iM) {
            length = iM - 1;
            if (i9 <= length) {
                while (!kotlin.jvm.internal.p.a(obj, this.f1087b[length])) {
                    if (length != i9) {
                        length--;
                    }
                }
                i8 = this.f1086a;
                return length - i8;
            }
            return -1;
        }
        if (!isEmpty() && this.f1086a >= iM) {
            int i10 = iM - 1;
            while (true) {
                if (-1 >= i10) {
                    Object[] objArr = this.f1087b;
                    kotlin.jvm.internal.p.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i11 = this.f1086a;
                    if (i11 <= length) {
                        while (!kotlin.jvm.internal.p.a(obj, this.f1087b[length])) {
                            if (length != i11) {
                                length--;
                            }
                        }
                        i8 = this.f1086a;
                    }
                } else {
                    if (kotlin.jvm.internal.p.a(obj, this.f1087b[i10])) {
                        length = i10 + this.f1087b.length;
                        i8 = this.f1086a;
                        break;
                    }
                    i10--;
                }
            }
            return length - i8;
        }
        return -1;
    }

    public final int m(int i8) {
        Object[] objArr = this.f1087b;
        return i8 >= objArr.length ? i8 - objArr.length : i8;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iM;
        kotlin.jvm.internal.p.e(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f1087b.length != 0) {
            int iM2 = m(this.f1088c + this.f1086a);
            int i8 = this.f1086a;
            if (i8 < iM2) {
                iM = i8;
                while (i8 < iM2) {
                    Object obj = this.f1087b[i8];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.f1087b[iM] = obj;
                        iM++;
                    }
                    i8++;
                }
                l.c0(this.f1087b, iM, iM2);
            } else {
                int length = this.f1087b.length;
                boolean z2 = false;
                int i9 = i8;
                while (i8 < length) {
                    Object[] objArr = this.f1087b;
                    Object obj2 = objArr[i8];
                    objArr[i8] = null;
                    if (elements.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.f1087b[i9] = obj2;
                        i9++;
                    }
                    i8++;
                }
                iM = m(i9);
                for (int i10 = 0; i10 < iM2; i10++) {
                    Object[] objArr2 = this.f1087b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (elements.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.f1087b[iM] = obj3;
                        iM = j(iM);
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f1088c = k(iM - this.f1086a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.f1087b;
        int i8 = this.f1086a;
        Object obj = objArr[i8];
        objArr[i8] = null;
        this.f1086a = j(i8);
        this.f1088c = f() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iM = m(n.j0(this) + this.f1086a);
        Object[] objArr = this.f1087b;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.f1088c = f() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i8, int i9) {
        a.a.k(i8, i9, this.f1088c);
        int i10 = i9 - i8;
        if (i10 == 0) {
            return;
        }
        if (i10 == this.f1088c) {
            clear();
            return;
        }
        if (i10 == 1) {
            g(i8);
            return;
        }
        n();
        if (i8 < this.f1088c - i9) {
            int iM = m(this.f1086a + (i8 - 1));
            int iM2 = m(this.f1086a + (i9 - 1));
            while (i8 > 0) {
                int i11 = iM + 1;
                int iMin = Math.min(i8, Math.min(i11, iM2 + 1));
                Object[] objArr = this.f1087b;
                int i12 = iM2 - iMin;
                int i13 = iM - iMin;
                l.W(objArr, objArr, i12 + 1, i13 + 1, i11);
                iM = k(i13);
                iM2 = k(i12);
                i8 -= iMin;
            }
            int iM3 = m(this.f1086a + i10);
            l(this.f1086a, iM3);
            this.f1086a = iM3;
        } else {
            int iM4 = m(this.f1086a + i9);
            int iM5 = m(this.f1086a + i8);
            int i14 = this.f1088c;
            while (true) {
                i14 -= i9;
                if (i14 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f1087b;
                i9 = Math.min(i14, Math.min(objArr2.length - iM4, objArr2.length - iM5));
                Object[] objArr3 = this.f1087b;
                int i15 = iM4 + i9;
                l.W(objArr3, objArr3, iM5, iM4, i15);
                iM4 = m(i15);
                iM5 = m(iM5 + i9);
            }
            int iM6 = m(this.f1088c + this.f1086a);
            l(k(iM6 - i10), iM6);
        }
        this.f1088c -= i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iM;
        kotlin.jvm.internal.p.e(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f1087b.length != 0) {
            int iM2 = m(this.f1088c + this.f1086a);
            int i8 = this.f1086a;
            if (i8 < iM2) {
                iM = i8;
                while (i8 < iM2) {
                    Object obj = this.f1087b[i8];
                    if (elements.contains(obj)) {
                        this.f1087b[iM] = obj;
                        iM++;
                    } else {
                        z = true;
                    }
                    i8++;
                }
                l.c0(this.f1087b, iM, iM2);
            } else {
                int length = this.f1087b.length;
                boolean z2 = false;
                int i9 = i8;
                while (i8 < length) {
                    Object[] objArr = this.f1087b;
                    Object obj2 = objArr[i8];
                    objArr[i8] = null;
                    if (elements.contains(obj2)) {
                        this.f1087b[i9] = obj2;
                        i9++;
                    } else {
                        z2 = true;
                    }
                    i8++;
                }
                iM = m(i9);
                for (int i10 = 0; i10 < iM2; i10++) {
                    Object[] objArr2 = this.f1087b;
                    Object obj3 = objArr2[i10];
                    objArr2[i10] = null;
                    if (elements.contains(obj3)) {
                        this.f1087b[iM] = obj3;
                        iM = j(iM);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                n();
                this.f1088c = k(iM - this.f1086a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        int iF = f();
        if (i8 < 0 || i8 >= iF) {
            throw new IndexOutOfBoundsException(a8.b.i(i8, iF, "index: ", ", size: "));
        }
        int iM = m(this.f1086a + i8);
        Object[] objArr = this.f1087b;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[f()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) throws NegativeArraySizeException {
        kotlin.jvm.internal.p.e(array, "array");
        int length = array.length;
        int i8 = this.f1088c;
        if (length < i8) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i8);
            kotlin.jvm.internal.p.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        int iM = m(this.f1088c + this.f1086a);
        int i9 = this.f1086a;
        if (i9 < iM) {
            l.Y(this.f1087b, array, i9, iM, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f1087b;
            l.W(objArr, array, 0, this.f1086a, objArr.length);
            Object[] objArr2 = this.f1087b;
            l.W(objArr2, array, objArr2.length - this.f1086a, 0, iM);
        }
        int i10 = this.f1088c;
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.p.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        n();
        i(elements.size() + f());
        h(m(f() + this.f1086a), elements);
        return true;
    }
}
