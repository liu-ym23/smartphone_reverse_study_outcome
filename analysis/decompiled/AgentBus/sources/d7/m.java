package d7;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class m extends h {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f2968i = new Object[0];

    /* renamed from: f, reason: collision with root package name */
    public int f2969f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f2970g = f2968i;

    /* renamed from: h, reason: collision with root package name */
    public int f2971h;

    @Override // d7.h
    public final int a() {
        return this.f2971h;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int length;
        int i10 = this.f2971h;
        if (i2 < 0 || i2 > i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
        if (i2 == i10) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        n();
        i(this.f2971h + 1);
        int iM = m(this.f2969f + i2);
        int i11 = this.f2971h;
        if (i2 < ((i11 + 1) >> 1)) {
            if (iM == 0) {
                Object[] objArr = this.f2970g;
                q7.k.e(objArr, "<this>");
                iM = objArr.length;
            }
            int i12 = iM - 1;
            int i13 = this.f2969f;
            if (i13 == 0) {
                Object[] objArr2 = this.f2970g;
                q7.k.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i13 - 1;
            }
            int i14 = this.f2969f;
            if (i12 >= i14) {
                Object[] objArr3 = this.f2970g;
                objArr3[length] = objArr3[i14];
                n.Y(objArr3, objArr3, i14, i14 + 1, i12 + 1);
            } else {
                Object[] objArr4 = this.f2970g;
                n.Y(objArr4, objArr4, i14 - 1, i14, objArr4.length);
                Object[] objArr5 = this.f2970g;
                objArr5[objArr5.length - 1] = objArr5[0];
                n.Y(objArr5, objArr5, 0, 1, i12 + 1);
            }
            this.f2970g[i12] = obj;
            this.f2969f = length;
        } else {
            int iM2 = m(i11 + this.f2969f);
            if (iM < iM2) {
                Object[] objArr6 = this.f2970g;
                n.Y(objArr6, objArr6, iM + 1, iM, iM2);
            } else {
                Object[] objArr7 = this.f2970g;
                n.Y(objArr7, objArr7, 1, 0, iM2);
                Object[] objArr8 = this.f2970g;
                objArr8[0] = objArr8[objArr8.length - 1];
                n.Y(objArr8, objArr8, iM + 1, iM, objArr8.length - 1);
            }
            this.f2970g[iM] = obj;
        }
        this.f2971h++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        q7.k.e(collection, "elements");
        int i10 = this.f2971h;
        if (i2 < 0 || i2 > i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == this.f2971h) {
            return addAll(collection);
        }
        n();
        i(collection.size() + this.f2971h);
        int iM = m(this.f2971h + this.f2969f);
        int iM2 = m(this.f2969f + i2);
        int size = collection.size();
        if (i2 >= ((this.f2971h + 1) >> 1)) {
            int i11 = iM2 + size;
            if (iM2 < iM) {
                int i12 = size + iM;
                Object[] objArr = this.f2970g;
                if (i12 <= objArr.length) {
                    n.Y(objArr, objArr, i11, iM2, iM);
                } else if (i11 >= objArr.length) {
                    n.Y(objArr, objArr, i11 - objArr.length, iM2, iM);
                } else {
                    int length = iM - (i12 - objArr.length);
                    n.Y(objArr, objArr, 0, length, iM);
                    Object[] objArr2 = this.f2970g;
                    n.Y(objArr2, objArr2, i11, iM2, length);
                }
            } else {
                Object[] objArr3 = this.f2970g;
                n.Y(objArr3, objArr3, size, 0, iM);
                Object[] objArr4 = this.f2970g;
                if (i11 >= objArr4.length) {
                    n.Y(objArr4, objArr4, i11 - objArr4.length, iM2, objArr4.length);
                } else {
                    n.Y(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.f2970g;
                    n.Y(objArr5, objArr5, i11, iM2, objArr5.length - size);
                }
            }
            h(iM2, collection);
            return true;
        }
        int i13 = this.f2969f;
        int length2 = i13 - size;
        if (iM2 < i13) {
            Object[] objArr6 = this.f2970g;
            n.Y(objArr6, objArr6, length2, i13, objArr6.length);
            if (size >= iM2) {
                Object[] objArr7 = this.f2970g;
                n.Y(objArr7, objArr7, objArr7.length - size, 0, iM2);
            } else {
                Object[] objArr8 = this.f2970g;
                n.Y(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.f2970g;
                n.Y(objArr9, objArr9, 0, size, iM2);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f2970g;
            n.Y(objArr10, objArr10, length2, i13, iM2);
        } else {
            Object[] objArr11 = this.f2970g;
            length2 += objArr11.length;
            int i14 = iM2 - i13;
            int length3 = objArr11.length - length2;
            if (length3 >= i14) {
                n.Y(objArr11, objArr11, length2, i13, iM2);
            } else {
                n.Y(objArr11, objArr11, length2, i13, i13 + length3);
                Object[] objArr12 = this.f2970g;
                n.Y(objArr12, objArr12, 0, this.f2969f + length3, iM2);
            }
        }
        this.f2969f = length2;
        h(k(iM2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        i(this.f2971h + 1);
        int length = this.f2969f;
        if (length == 0) {
            Object[] objArr = this.f2970g;
            q7.k.e(objArr, "<this>");
            length = objArr.length;
        }
        int i2 = length - 1;
        this.f2969f = i2;
        this.f2970g[i2] = obj;
        this.f2971h++;
    }

    public final void addLast(Object obj) {
        n();
        i(a() + 1);
        this.f2970g[m(a() + this.f2969f)] = obj;
        this.f2971h = a() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.f2969f, m(a() + this.f2969f));
        }
        this.f2969f = 0;
        this.f2971h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // d7.h
    public final Object f(int i2) {
        int i10 = this.f2971h;
        if (i2 < 0 || i2 >= i10) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, i10, ", size: "));
        }
        if (i2 == s.t0(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.f2969f + i2);
        Object[] objArr = this.f2970g;
        Object obj = objArr[iM];
        if (i2 < (this.f2971h >> 1)) {
            int i11 = this.f2969f;
            if (iM >= i11) {
                n.Y(objArr, objArr, i11 + 1, i11, iM);
            } else {
                n.Y(objArr, objArr, 1, 0, iM);
                Object[] objArr2 = this.f2970g;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f2969f;
                n.Y(objArr2, objArr2, i12 + 1, i12, objArr2.length - 1);
            }
            Object[] objArr3 = this.f2970g;
            int i13 = this.f2969f;
            objArr3[i13] = null;
            this.f2969f = j(i13);
        } else {
            int iM2 = m(s.t0(this) + this.f2969f);
            if (iM <= iM2) {
                Object[] objArr4 = this.f2970g;
                n.Y(objArr4, objArr4, iM, iM + 1, iM2 + 1);
            } else {
                Object[] objArr5 = this.f2970g;
                n.Y(objArr5, objArr5, iM, iM + 1, objArr5.length);
                Object[] objArr6 = this.f2970g;
                objArr6[objArr6.length - 1] = objArr6[0];
                n.Y(objArr6, objArr6, 0, 1, iM2 + 1);
            }
            this.f2970g[iM2] = null;
        }
        this.f2971h--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        int iA = a();
        if (i2 < 0 || i2 >= iA) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, iA, ", size: "));
        }
        return this.f2970g[m(this.f2969f + i2)];
    }

    public final void h(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f2970g.length;
        while (i2 < length && it.hasNext()) {
            this.f2970g[i2] = it.next();
            i2++;
        }
        int i10 = this.f2969f;
        for (int i11 = 0; i11 < i10 && it.hasNext(); i11++) {
            this.f2970g[i11] = it.next();
        }
        this.f2971h = collection.size() + this.f2971h;
    }

    public final void i(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f2970g;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == f2968i) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f2970g = new Object[i2];
            return;
        }
        int length = objArr.length;
        int i10 = length + (length >> 1);
        if (i10 - i2 < 0) {
            i10 = i2;
        }
        if (i10 - 2147483639 > 0) {
            i10 = i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i10];
        n.Y(objArr, objArr2, 0, this.f2969f, objArr.length);
        Object[] objArr3 = this.f2970g;
        int length2 = objArr3.length;
        int i11 = this.f2969f;
        n.Y(objArr3, objArr2, length2 - i11, 0, i11);
        this.f2969f = 0;
        this.f2970g = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int iM = m(a() + this.f2969f);
        int length = this.f2969f;
        if (length < iM) {
            while (length < iM) {
                if (q7.k.a(obj, this.f2970g[length])) {
                    i2 = this.f2969f;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM) {
            return -1;
        }
        int length2 = this.f2970g.length;
        while (true) {
            if (length >= length2) {
                for (int i10 = 0; i10 < iM; i10++) {
                    if (q7.k.a(obj, this.f2970g[i10])) {
                        length = i10 + this.f2970g.length;
                        i2 = this.f2969f;
                    }
                }
                return -1;
            }
            if (q7.k.a(obj, this.f2970g[length])) {
                i2 = this.f2969f;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final int j(int i2) {
        q7.k.e(this.f2970g, "<this>");
        if (i2 == r1.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    public final int k(int i2) {
        return i2 < 0 ? i2 + this.f2970g.length : i2;
    }

    public final void l(int i2, int i10) {
        if (i2 < i10) {
            n.d0(this.f2970g, i2, i10);
            return;
        }
        Object[] objArr = this.f2970g;
        n.d0(objArr, i2, objArr.length);
        n.d0(this.f2970g, 0, i10);
    }

    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return this.f2970g[m(s.t0(this) + this.f2969f)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i2;
        int iM = m(this.f2971h + this.f2969f);
        int i10 = this.f2969f;
        if (i10 < iM) {
            length = iM - 1;
            if (i10 <= length) {
                while (!q7.k.a(obj, this.f2970g[length])) {
                    if (length != i10) {
                        length--;
                    }
                }
                i2 = this.f2969f;
                return length - i2;
            }
            return -1;
        }
        if (i10 > iM) {
            int i11 = iM - 1;
            while (true) {
                if (-1 >= i11) {
                    Object[] objArr = this.f2970g;
                    q7.k.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i12 = this.f2969f;
                    if (i12 <= length) {
                        while (!q7.k.a(obj, this.f2970g[length])) {
                            if (length != i12) {
                                length--;
                            }
                        }
                        i2 = this.f2969f;
                    }
                } else {
                    if (q7.k.a(obj, this.f2970g[i11])) {
                        length = i11 + this.f2970g.length;
                        i2 = this.f2969f;
                        break;
                    }
                    i11--;
                }
            }
        }
        return -1;
    }

    public final int m(int i2) {
        Object[] objArr = this.f2970g;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
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
        f(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iM;
        q7.k.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f2970g.length != 0) {
            int iM2 = m(this.f2971h + this.f2969f);
            int i2 = this.f2969f;
            if (i2 < iM2) {
                iM = i2;
                while (i2 < iM2) {
                    Object obj = this.f2970g[i2];
                    if (collection.contains(obj)) {
                        z4 = true;
                    } else {
                        this.f2970g[iM] = obj;
                        iM++;
                    }
                    i2++;
                }
                n.d0(this.f2970g, iM, iM2);
            } else {
                int length = this.f2970g.length;
                boolean z10 = false;
                int i10 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f2970g;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        z10 = true;
                    } else {
                        this.f2970g[i10] = obj2;
                        i10++;
                    }
                    i2++;
                }
                iM = m(i10);
                for (int i11 = 0; i11 < iM2; i11++) {
                    Object[] objArr2 = this.f2970g;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        z10 = true;
                    } else {
                        this.f2970g[iM] = obj3;
                        iM = j(iM);
                    }
                }
                z4 = z10;
            }
            if (z4) {
                n();
                this.f2971h = k(iM - this.f2969f);
            }
        }
        return z4;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        Object[] objArr = this.f2970g;
        int i2 = this.f2969f;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f2969f = j(i2);
        this.f2971h = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        n();
        int iM = m(s.t0(this) + this.f2969f);
        Object[] objArr = this.f2970g;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.f2971h = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i10) {
        s7.a.h(i2, i10, this.f2971h);
        int i11 = i10 - i2;
        if (i11 == 0) {
            return;
        }
        if (i11 == this.f2971h) {
            clear();
            return;
        }
        if (i11 == 1) {
            f(i2);
            return;
        }
        n();
        if (i2 < this.f2971h - i10) {
            int iM = m((i2 - 1) + this.f2969f);
            int iM2 = m((i10 - 1) + this.f2969f);
            while (i2 > 0) {
                int i12 = iM + 1;
                int iMin = Math.min(i2, Math.min(i12, iM2 + 1));
                Object[] objArr = this.f2970g;
                int i13 = iM2 - iMin;
                int i14 = iM - iMin;
                n.Y(objArr, objArr, i13 + 1, i14 + 1, i12);
                iM = k(i14);
                iM2 = k(i13);
                i2 -= iMin;
            }
            int iM3 = m(this.f2969f + i11);
            l(this.f2969f, iM3);
            this.f2969f = iM3;
        } else {
            int iM4 = m(this.f2969f + i10);
            int iM5 = m(this.f2969f + i2);
            int i15 = this.f2971h;
            while (true) {
                i15 -= i10;
                if (i15 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f2970g;
                i10 = Math.min(i15, Math.min(objArr2.length - iM4, objArr2.length - iM5));
                Object[] objArr3 = this.f2970g;
                int i16 = iM4 + i10;
                n.Y(objArr3, objArr3, iM5, iM4, i16);
                iM4 = m(i16);
                iM5 = m(iM5 + i10);
            }
            int iM6 = m(this.f2971h + this.f2969f);
            l(k(iM6 - i11), iM6);
        }
        this.f2971h -= i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iM;
        q7.k.e(collection, "elements");
        boolean z4 = false;
        z4 = false;
        z4 = false;
        if (!isEmpty() && this.f2970g.length != 0) {
            int iM2 = m(this.f2971h + this.f2969f);
            int i2 = this.f2969f;
            if (i2 < iM2) {
                iM = i2;
                while (i2 < iM2) {
                    Object obj = this.f2970g[i2];
                    if (collection.contains(obj)) {
                        this.f2970g[iM] = obj;
                        iM++;
                    } else {
                        z4 = true;
                    }
                    i2++;
                }
                n.d0(this.f2970g, iM, iM2);
            } else {
                int length = this.f2970g.length;
                boolean z10 = false;
                int i10 = i2;
                while (i2 < length) {
                    Object[] objArr = this.f2970g;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (collection.contains(obj2)) {
                        this.f2970g[i10] = obj2;
                        i10++;
                    } else {
                        z10 = true;
                    }
                    i2++;
                }
                iM = m(i10);
                for (int i11 = 0; i11 < iM2; i11++) {
                    Object[] objArr2 = this.f2970g;
                    Object obj3 = objArr2[i11];
                    objArr2[i11] = null;
                    if (collection.contains(obj3)) {
                        this.f2970g[iM] = obj3;
                        iM = j(iM);
                    } else {
                        z10 = true;
                    }
                }
                z4 = z10;
            }
            if (z4) {
                n();
                this.f2971h = k(iM - this.f2969f);
            }
        }
        return z4;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        int iA = a();
        if (i2 < 0 || i2 >= iA) {
            throw new IndexOutOfBoundsException(m.x.k("index: ", i2, iA, ", size: "));
        }
        int iM = m(this.f2969f + i2);
        Object[] objArr = this.f2970g;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        q7.k.e(objArr, "array");
        int length = objArr.length;
        int i2 = this.f2971h;
        if (length < i2) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i2);
            q7.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        int iM = m(this.f2971h + this.f2969f);
        int i10 = this.f2969f;
        if (i10 < iM) {
            n.a0(this.f2970g, objArr, i10, iM, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f2970g;
            n.Y(objArr2, objArr, 0, this.f2969f, objArr2.length);
            Object[] objArr3 = this.f2970g;
            n.Y(objArr3, objArr, objArr3.length - this.f2969f, 0, iM);
        }
        int i11 = this.f2971h;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        q7.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        n();
        i(collection.size() + a());
        h(m(a() + this.f2969f), collection);
        return true;
    }
}
