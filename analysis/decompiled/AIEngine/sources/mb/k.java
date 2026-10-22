package mb;

import androidx.datastore.preferences.protobuf.b1;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import mb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k<E> extends f<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f10555d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f10556a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f10557b;

    /* renamed from: c, reason: collision with root package name */
    public int f10558c;

    public k(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f10555d;
        } else {
            if (i10 <= 0) {
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Illegal Capacity: "));
            }
            objArr = new Object[i10];
        }
        this.f10557b = objArr;
    }

    @Override // mb.f
    public final int a() {
        return this.f10558c;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        int length;
        int i11 = this.f10558c;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        if (i10 == i11) {
            addLast(e10);
            return;
        }
        if (i10 == 0) {
            addFirst(e10);
            return;
        }
        j();
        e(this.f10558c + 1);
        int i12 = i(this.f10556a + i10);
        int i13 = this.f10558c;
        if (i10 < ((i13 + 1) >> 1)) {
            if (i12 == 0) {
                Object[] objArr = this.f10557b;
                kotlin.jvm.internal.g.f(objArr, "<this>");
                i12 = objArr.length;
            }
            int i14 = i12 - 1;
            int i15 = this.f10556a;
            if (i15 == 0) {
                Object[] objArr2 = this.f10557b;
                kotlin.jvm.internal.g.f(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i15 - 1;
            }
            int i16 = this.f10556a;
            if (i14 >= i16) {
                Object[] objArr3 = this.f10557b;
                objArr3[length] = objArr3[i16];
                b1.q(objArr3, objArr3, i16, i16 + 1, i14 + 1);
            } else {
                Object[] objArr4 = this.f10557b;
                b1.q(objArr4, objArr4, i16 - 1, i16, objArr4.length);
                Object[] objArr5 = this.f10557b;
                objArr5[objArr5.length - 1] = objArr5[0];
                b1.q(objArr5, objArr5, 0, 1, i14 + 1);
            }
            this.f10557b[i14] = e10;
            this.f10556a = length;
        } else {
            int i17 = i(i13 + this.f10556a);
            if (i12 < i17) {
                Object[] objArr6 = this.f10557b;
                b1.q(objArr6, objArr6, i12 + 1, i12, i17);
            } else {
                Object[] objArr7 = this.f10557b;
                b1.q(objArr7, objArr7, 1, 0, i17);
                Object[] objArr8 = this.f10557b;
                objArr8[0] = objArr8[objArr8.length - 1];
                b1.q(objArr8, objArr8, i12 + 1, i12, objArr8.length - 1);
            }
            this.f10557b[i12] = e10;
        }
        this.f10558c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends E> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        int i11 = this.f10558c;
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        if (elements.isEmpty()) {
            return false;
        }
        if (i10 == this.f10558c) {
            return addAll(elements);
        }
        j();
        e(elements.size() + this.f10558c);
        int i12 = i(this.f10558c + this.f10556a);
        int i13 = i(this.f10556a + i10);
        int size = elements.size();
        if (i10 >= ((this.f10558c + 1) >> 1)) {
            int i14 = i13 + size;
            if (i13 < i12) {
                int i15 = size + i12;
                Object[] objArr = this.f10557b;
                if (i15 <= objArr.length) {
                    b1.q(objArr, objArr, i14, i13, i12);
                } else if (i14 >= objArr.length) {
                    b1.q(objArr, objArr, i14 - objArr.length, i13, i12);
                } else {
                    int length = i12 - (i15 - objArr.length);
                    b1.q(objArr, objArr, 0, length, i12);
                    Object[] objArr2 = this.f10557b;
                    b1.q(objArr2, objArr2, i14, i13, length);
                }
            } else {
                Object[] objArr3 = this.f10557b;
                b1.q(objArr3, objArr3, size, 0, i12);
                Object[] objArr4 = this.f10557b;
                if (i14 >= objArr4.length) {
                    b1.q(objArr4, objArr4, i14 - objArr4.length, i13, objArr4.length);
                } else {
                    b1.q(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.f10557b;
                    b1.q(objArr5, objArr5, i14, i13, objArr5.length - size);
                }
            }
            c(i13, elements);
            return true;
        }
        int i16 = this.f10556a;
        int length2 = i16 - size;
        if (i13 < i16) {
            Object[] objArr6 = this.f10557b;
            b1.q(objArr6, objArr6, length2, i16, objArr6.length);
            if (size >= i13) {
                Object[] objArr7 = this.f10557b;
                b1.q(objArr7, objArr7, objArr7.length - size, 0, i13);
            } else {
                Object[] objArr8 = this.f10557b;
                b1.q(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.f10557b;
                b1.q(objArr9, objArr9, 0, size, i13);
            }
        } else if (length2 >= 0) {
            Object[] objArr10 = this.f10557b;
            b1.q(objArr10, objArr10, length2, i16, i13);
        } else {
            Object[] objArr11 = this.f10557b;
            length2 += objArr11.length;
            int i17 = i13 - i16;
            int length3 = objArr11.length - length2;
            if (length3 >= i17) {
                b1.q(objArr11, objArr11, length2, i16, i13);
            } else {
                b1.q(objArr11, objArr11, length2, i16, i16 + length3);
                Object[] objArr12 = this.f10557b;
                b1.q(objArr12, objArr12, 0, this.f10556a + length3, i13);
            }
        }
        this.f10556a = length2;
        c(g(i13 - size), elements);
        return true;
    }

    public final void addFirst(E e10) {
        j();
        e(this.f10558c + 1);
        int length = this.f10556a;
        if (length == 0) {
            Object[] objArr = this.f10557b;
            kotlin.jvm.internal.g.f(objArr, "<this>");
            length = objArr.length;
        }
        int i10 = length - 1;
        this.f10556a = i10;
        this.f10557b[i10] = e10;
        this.f10558c++;
    }

    public final void addLast(E e10) {
        j();
        e(a() + 1);
        this.f10557b[i(a() + this.f10556a)] = e10;
        this.f10558c = a() + 1;
    }

    @Override // mb.f
    public final E b(int i10) {
        int i11 = this.f10558c;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, i11, ", size: "));
        }
        if (i10 == m.a0(this)) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        j();
        int i12 = i(this.f10556a + i10);
        Object[] objArr = this.f10557b;
        E e10 = (E) objArr[i12];
        if (i10 < (this.f10558c >> 1)) {
            int i13 = this.f10556a;
            if (i12 >= i13) {
                b1.q(objArr, objArr, i13 + 1, i13, i12);
            } else {
                b1.q(objArr, objArr, 1, 0, i12);
                Object[] objArr2 = this.f10557b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i14 = this.f10556a;
                b1.q(objArr2, objArr2, i14 + 1, i14, objArr2.length - 1);
            }
            Object[] objArr3 = this.f10557b;
            int i15 = this.f10556a;
            objArr3[i15] = null;
            this.f10556a = f(i15);
        } else {
            int i16 = i(m.a0(this) + this.f10556a);
            if (i12 <= i16) {
                Object[] objArr4 = this.f10557b;
                b1.q(objArr4, objArr4, i12, i12 + 1, i16 + 1);
            } else {
                Object[] objArr5 = this.f10557b;
                b1.q(objArr5, objArr5, i12, i12 + 1, objArr5.length);
                Object[] objArr6 = this.f10557b;
                objArr6[objArr6.length - 1] = objArr6[0];
                b1.q(objArr6, objArr6, 0, 1, i16 + 1);
            }
            this.f10557b[i16] = null;
        }
        this.f10558c--;
        return e10;
    }

    public final void c(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f10557b.length;
        while (i10 < length && it.hasNext()) {
            this.f10557b[i10] = it.next();
            i10++;
        }
        int i11 = this.f10556a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f10557b[i12] = it.next();
        }
        this.f10558c = collection.size() + this.f10558c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            j();
            h(this.f10556a, i(a() + this.f10556a));
        }
        this.f10556a = 0;
        this.f10558c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void e(int i10) {
        if (i10 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f10557b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f10555d) {
            if (i10 < 10) {
                i10 = 10;
            }
            this.f10557b = new Object[i10];
            return;
        }
        int length = objArr.length;
        int i11 = length + (length >> 1);
        if (i11 - i10 < 0) {
            i11 = i10;
        }
        if (i11 - 2147483639 > 0) {
            i11 = i10 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i11];
        b1.q(objArr, objArr2, 0, this.f10556a, objArr.length);
        Object[] objArr3 = this.f10557b;
        int length2 = objArr3.length;
        int i12 = this.f10556a;
        b1.q(objArr3, objArr2, length2 - i12, 0, i12);
        this.f10556a = 0;
        this.f10557b = objArr2;
    }

    public final int f(int i10) {
        kotlin.jvm.internal.g.f(this.f10557b, "<this>");
        if (i10 == r1.length - 1) {
            return 0;
        }
        return i10 + 1;
    }

    public final int g(int i10) {
        return i10 < 0 ? i10 + this.f10557b.length : i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        int iA = a();
        if (i10 < 0 || i10 >= iA) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, iA, ", size: "));
        }
        return (E) this.f10557b[i(this.f10556a + i10)];
    }

    public final void h(int i10, int i11) {
        if (i10 < i11) {
            b1.G(null, this.f10557b, i10, i11);
            return;
        }
        Object[] objArr = this.f10557b;
        b1.G(null, objArr, i10, objArr.length);
        b1.G(null, this.f10557b, 0, i11);
    }

    public final int i(int i10) {
        Object[] objArr = this.f10557b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i10;
        int i11 = i(a() + this.f10556a);
        int length = this.f10556a;
        if (length < i11) {
            while (length < i11) {
                if (kotlin.jvm.internal.g.b(obj, this.f10557b[length])) {
                    i10 = this.f10556a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < i11) {
            return -1;
        }
        int length2 = this.f10557b.length;
        while (true) {
            if (length >= length2) {
                for (int i12 = 0; i12 < i11; i12++) {
                    if (kotlin.jvm.internal.g.b(obj, this.f10557b[i12])) {
                        length = i12 + this.f10557b.length;
                        i10 = this.f10556a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.g.b(obj, this.f10557b[length])) {
                i10 = this.f10556a;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final void j() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i10;
        int i11 = i(this.f10558c + this.f10556a);
        int i12 = this.f10556a;
        if (i12 < i11) {
            length = i11 - 1;
            if (i12 <= length) {
                while (!kotlin.jvm.internal.g.b(obj, this.f10557b[length])) {
                    if (length != i12) {
                        length--;
                    }
                }
                i10 = this.f10556a;
                return length - i10;
            }
            return -1;
        }
        if (i12 > i11) {
            int i13 = i11 - 1;
            while (true) {
                if (-1 >= i13) {
                    Object[] objArr = this.f10557b;
                    kotlin.jvm.internal.g.f(objArr, "<this>");
                    length = objArr.length - 1;
                    int i14 = this.f10556a;
                    if (i14 <= length) {
                        while (!kotlin.jvm.internal.g.b(obj, this.f10557b[length])) {
                            if (length != i14) {
                                length--;
                            }
                        }
                        i10 = this.f10556a;
                    }
                } else {
                    if (kotlin.jvm.internal.g.b(obj, this.f10557b[i13])) {
                        length = i13 + this.f10557b.length;
                        i10 = this.f10556a;
                        break;
                    }
                    i13--;
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
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.g.f(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f10557b.length != 0) {
            int i11 = i(a() + this.f10556a);
            int i12 = this.f10556a;
            if (i12 < i11) {
                i10 = i12;
                while (i12 < i11) {
                    Object obj = this.f10557b[i12];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.f10557b[i10] = obj;
                        i10++;
                    }
                    i12++;
                }
                b1.G(null, this.f10557b, i10, i11);
            } else {
                int length = this.f10557b.length;
                boolean z3 = false;
                int i13 = i12;
                while (i12 < length) {
                    Object[] objArr = this.f10557b;
                    Object obj2 = objArr[i12];
                    objArr[i12] = null;
                    if (elements.contains(obj2)) {
                        z3 = true;
                    } else {
                        this.f10557b[i13] = obj2;
                        i13++;
                    }
                    i12++;
                }
                i10 = i(i13);
                for (int i14 = 0; i14 < i11; i14++) {
                    Object[] objArr2 = this.f10557b;
                    Object obj3 = objArr2[i14];
                    objArr2[i14] = null;
                    if (elements.contains(obj3)) {
                        z3 = true;
                    } else {
                        this.f10557b[i10] = obj3;
                        i10 = f(i10);
                    }
                }
                z = z3;
            }
            if (z) {
                j();
                this.f10558c = g(i10 - this.f10556a);
            }
        }
        return z;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        Object[] objArr = this.f10557b;
        int i10 = this.f10556a;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f10556a = f(i10);
        this.f10558c = a() - 1;
        return e10;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        j();
        int i10 = i(m.a0(this) + this.f10556a);
        Object[] objArr = this.f10557b;
        E e10 = (E) objArr[i10];
        objArr[i10] = null;
        this.f10558c = a() - 1;
        return e10;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        c.a.b(i10, i11, this.f10558c);
        int i12 = i11 - i10;
        if (i12 == 0) {
            return;
        }
        if (i12 == this.f10558c) {
            clear();
            return;
        }
        if (i12 == 1) {
            b(i10);
            return;
        }
        j();
        if (i10 < this.f10558c - i11) {
            int i13 = i((i10 - 1) + this.f10556a);
            int i14 = i((i11 - 1) + this.f10556a);
            while (i10 > 0) {
                int i15 = i13 + 1;
                int iMin = Math.min(i10, Math.min(i15, i14 + 1));
                Object[] objArr = this.f10557b;
                int i16 = i14 - iMin;
                int i17 = i13 - iMin;
                b1.q(objArr, objArr, i16 + 1, i17 + 1, i15);
                i13 = g(i17);
                i14 = g(i16);
                i10 -= iMin;
            }
            int i18 = i(this.f10556a + i12);
            h(this.f10556a, i18);
            this.f10556a = i18;
        } else {
            int i19 = i(this.f10556a + i11);
            int i20 = i(this.f10556a + i10);
            int i21 = this.f10558c;
            while (true) {
                i21 -= i11;
                if (i21 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f10557b;
                i11 = Math.min(i21, Math.min(objArr2.length - i19, objArr2.length - i20));
                Object[] objArr3 = this.f10557b;
                int i22 = i19 + i11;
                b1.q(objArr3, objArr3, i20, i19, i22);
                i19 = i(i22);
                i20 = i(i20 + i11);
            }
            int i23 = i(this.f10558c + this.f10556a);
            h(g(i23 - i12), i23);
        }
        this.f10558c -= i12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        int i10;
        kotlin.jvm.internal.g.f(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f10557b.length != 0) {
            int i11 = i(a() + this.f10556a);
            int i12 = this.f10556a;
            if (i12 < i11) {
                i10 = i12;
                while (i12 < i11) {
                    Object obj = this.f10557b[i12];
                    if (elements.contains(obj)) {
                        this.f10557b[i10] = obj;
                        i10++;
                    } else {
                        z = true;
                    }
                    i12++;
                }
                b1.G(null, this.f10557b, i10, i11);
            } else {
                int length = this.f10557b.length;
                boolean z3 = false;
                int i13 = i12;
                while (i12 < length) {
                    Object[] objArr = this.f10557b;
                    Object obj2 = objArr[i12];
                    objArr[i12] = null;
                    if (elements.contains(obj2)) {
                        this.f10557b[i13] = obj2;
                        i13++;
                    } else {
                        z3 = true;
                    }
                    i12++;
                }
                i10 = i(i13);
                for (int i14 = 0; i14 < i11; i14++) {
                    Object[] objArr2 = this.f10557b;
                    Object obj3 = objArr2[i14];
                    objArr2[i14] = null;
                    if (elements.contains(obj3)) {
                        this.f10557b[i10] = obj3;
                        i10 = f(i10);
                    } else {
                        z3 = true;
                    }
                }
                z = z3;
            }
            if (z) {
                j();
                this.f10558c = g(i10 - this.f10556a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        int iA = a();
        if (i10 < 0 || i10 >= iA) {
            throw new IndexOutOfBoundsException(a0.a.f("index: ", i10, iA, ", size: "));
        }
        int i11 = i(this.f10556a + i10);
        Object[] objArr = this.f10557b;
        E e11 = (E) objArr[i11];
        objArr[i11] = e10;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] array) throws NegativeArraySizeException {
        kotlin.jvm.internal.g.f(array, "array");
        int length = array.length;
        int i10 = this.f10558c;
        if (length < i10) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i10);
            kotlin.jvm.internal.g.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (T[]) ((Object[]) objNewInstance);
        }
        int i11 = i(this.f10558c + this.f10556a);
        int i12 = this.f10556a;
        if (i12 < i11) {
            b1.t(this.f10557b, array, i12, i11, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f10557b;
            b1.q(objArr, array, 0, this.f10556a, objArr.length);
            Object[] objArr2 = this.f10557b;
            b1.q(objArr2, array, objArr2.length - this.f10556a, 0, i11);
        }
        int i13 = this.f10558c;
        if (i13 < array.length) {
            array[i13] = null;
        }
        return array;
    }

    public k() {
        this.f10557b = f10555d;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        addLast(e10);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        j();
        e(elements.size() + a());
        c(i(a() + this.f10556a), elements);
        return true;
    }
}
