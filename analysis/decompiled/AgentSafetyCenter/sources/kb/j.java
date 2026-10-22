package kb;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: h, reason: collision with root package name */
    public static final Object[] f7399h = new Object[0];

    /* renamed from: c, reason: collision with root package name */
    public int f7400c;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f7401f = f7399h;

    /* renamed from: g, reason: collision with root package name */
    public int f7402g;

    @Override // kb.f
    public final int a() {
        return this.f7402g;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i3 = this.f7402g;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return;
        }
        if (i == i3) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.f7402g + 1);
        int iH = h(this.f7400c + i);
        int i10 = this.f7402g;
        if (i < ((i10 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr = this.f7401f;
                objArr.getClass();
                length = objArr.length - 1;
            } else {
                length = iH - 1;
            }
            int length2 = this.f7400c;
            if (length2 == 0) {
                Object[] objArr2 = this.f7401f;
                objArr2.getClass();
                length2 = objArr2.length;
            }
            int i11 = length2 - 1;
            int i12 = this.f7400c;
            Object[] objArr3 = this.f7401f;
            if (length >= i12) {
                objArr3[i11] = objArr3[i12];
                k.i0(objArr3, objArr3, i12, i12 + 1, length + 1);
            } else {
                k.i0(objArr3, objArr3, i12 - 1, i12, objArr3.length);
                Object[] objArr4 = this.f7401f;
                objArr4[objArr4.length - 1] = objArr4[0];
                k.i0(objArr4, objArr4, 0, 1, length + 1);
            }
            this.f7401f[length] = obj;
            this.f7400c = i11;
        } else {
            int iH2 = h(i10 + this.f7400c);
            Object[] objArr5 = this.f7401f;
            if (iH < iH2) {
                k.i0(objArr5, objArr5, iH + 1, iH, iH2);
            } else {
                k.i0(objArr5, objArr5, 1, 0, iH2);
                Object[] objArr6 = this.f7401f;
                objArr6[0] = objArr6[objArr6.length - 1];
                k.i0(objArr6, objArr6, iH + 1, iH, objArr6.length - 1);
            }
            this.f7401f[iH] = obj;
        }
        this.f7402g++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        int i3 = this.f7402g;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return false;
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f7402g) {
            return addAll(collection);
        }
        i();
        d(collection.size() + this.f7402g);
        int iH = h(this.f7402g + this.f7400c);
        int iH2 = h(this.f7400c + i);
        int size = collection.size();
        if (i >= ((this.f7402g + 1) >> 1)) {
            int i10 = iH2 + size;
            Object[] objArr = this.f7401f;
            if (iH2 < iH) {
                int i11 = size + iH;
                if (i11 <= objArr.length) {
                    k.i0(objArr, objArr, i10, iH2, iH);
                } else if (i10 >= objArr.length) {
                    k.i0(objArr, objArr, i10 - objArr.length, iH2, iH);
                } else {
                    int length = iH - (i11 - objArr.length);
                    k.i0(objArr, objArr, 0, length, iH);
                    Object[] objArr2 = this.f7401f;
                    k.i0(objArr2, objArr2, i10, iH2, length);
                }
            } else {
                k.i0(objArr, objArr, size, 0, iH);
                Object[] objArr3 = this.f7401f;
                if (i10 >= objArr3.length) {
                    k.i0(objArr3, objArr3, i10 - objArr3.length, iH2, objArr3.length);
                } else {
                    k.i0(objArr3, objArr3, 0, objArr3.length - size, objArr3.length);
                    Object[] objArr4 = this.f7401f;
                    k.i0(objArr4, objArr4, i10, iH2, objArr4.length - size);
                }
            }
            c(iH2, collection);
            return true;
        }
        int i12 = this.f7400c;
        int length2 = i12 - size;
        Object[] objArr5 = this.f7401f;
        if (iH2 < i12) {
            k.i0(objArr5, objArr5, length2, i12, objArr5.length);
            Object[] objArr6 = this.f7401f;
            if (size >= iH2) {
                k.i0(objArr6, objArr6, objArr6.length - size, 0, iH2);
            } else {
                k.i0(objArr6, objArr6, objArr6.length - size, 0, size);
                Object[] objArr7 = this.f7401f;
                k.i0(objArr7, objArr7, 0, size, iH2);
            }
        } else if (length2 >= 0) {
            k.i0(objArr5, objArr5, length2, i12, iH2);
        } else {
            length2 += objArr5.length;
            int i13 = iH2 - i12;
            int length3 = objArr5.length - length2;
            if (length3 >= i13) {
                k.i0(objArr5, objArr5, length2, i12, iH2);
            } else {
                k.i0(objArr5, objArr5, length2, i12, i12 + length3);
                Object[] objArr8 = this.f7401f;
                k.i0(objArr8, objArr8, 0, this.f7400c + length3, iH2);
            }
        }
        this.f7400c = length2;
        c(f(iH2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        i();
        d(this.f7402g + 1);
        int length = this.f7400c;
        if (length == 0) {
            Object[] objArr = this.f7401f;
            objArr.getClass();
            length = objArr.length;
        }
        int i = length - 1;
        this.f7400c = i;
        this.f7401f[i] = obj;
        this.f7402g++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.f7401f[h(a() + this.f7400c)] = obj;
        this.f7402g = a() + 1;
    }

    @Override // kb.f
    public final Object b(int i) {
        int i3 = this.f7402g;
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        if (i == a() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        i();
        int iH = h(this.f7400c + i);
        Object[] objArr = this.f7401f;
        Object obj = objArr[iH];
        int i10 = this.f7402g >> 1;
        int i11 = this.f7400c;
        if (i < i10) {
            if (iH >= i11) {
                k.i0(objArr, objArr, i11 + 1, i11, iH);
            } else {
                k.i0(objArr, objArr, 1, 0, iH);
                Object[] objArr2 = this.f7401f;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f7400c;
                k.i0(objArr2, objArr2, i12 + 1, i12, objArr2.length - 1);
            }
            Object[] objArr3 = this.f7401f;
            int i13 = this.f7400c;
            objArr3[i13] = null;
            this.f7400c = e(i13);
        } else {
            int iH2 = h((a() - 1) + i11);
            Object[] objArr4 = this.f7401f;
            if (iH <= iH2) {
                k.i0(objArr4, objArr4, iH, iH + 1, iH2 + 1);
            } else {
                k.i0(objArr4, objArr4, iH, iH + 1, objArr4.length);
                Object[] objArr5 = this.f7401f;
                objArr5[objArr5.length - 1] = objArr5[0];
                k.i0(objArr5, objArr5, 0, 1, iH2 + 1);
            }
            this.f7401f[iH2] = null;
        }
        this.f7402g--;
        return obj;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f7401f.length;
        while (i < length && it.hasNext()) {
            this.f7401f[i] = it.next();
            i++;
        }
        int i3 = this.f7400c;
        for (int i10 = 0; i10 < i3 && it.hasNext(); i10++) {
            this.f7401f[i10] = it.next();
        }
        this.f7402g = collection.size() + this.f7402g;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.f7400c, h(a() + this.f7400c));
        }
        this.f7400c = 0;
        this.f7402g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            od.f.e("Deque is too big.");
            return;
        }
        Object[] objArr = this.f7401f;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f7399h) {
            if (i < 10) {
                i = 10;
            }
            this.f7401f = new Object[i];
            return;
        }
        int length = objArr.length;
        int i3 = length + (length >> 1);
        if (i3 - i < 0) {
            i3 = i;
        }
        if (i3 - 2147483639 > 0) {
            i3 = i > 2147483639 ? Reader.READ_DONE : 2147483639;
        }
        Object[] objArr2 = new Object[i3];
        k.i0(objArr, objArr2, 0, this.f7400c, objArr.length);
        Object[] objArr3 = this.f7401f;
        int length2 = objArr3.length;
        int i10 = this.f7400c;
        k.i0(objArr3, objArr2, length2 - i10, 0, i10);
        this.f7400c = 0;
        this.f7401f = objArr2;
    }

    public final int e(int i) {
        this.f7401f.getClass();
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int f(int i) {
        return i < 0 ? i + this.f7401f.length : i;
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.f7401f[this.f7400c];
        }
        g5.f.m("ArrayDeque is empty.");
        return null;
    }

    public final void g(int i, int i3) {
        Object[] objArr = this.f7401f;
        if (i < i3) {
            k.m0(null, i, objArr, i3);
        } else {
            k.m0(null, i, objArr, objArr.length);
            k.m0(null, 0, this.f7401f, i3);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int iA = a();
        if (i >= 0 && i < iA) {
            return this.f7401f[h(this.f7400c + i)];
        }
        g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", iA));
        return null;
    }

    public final int h(int i) {
        Object[] objArr = this.f7401f;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iH = h(a() + this.f7400c);
        int length = this.f7400c;
        if (length < iH) {
            while (length < iH) {
                if (yb.k.a(obj, this.f7401f[length])) {
                    i = this.f7400c;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.f7401f.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iH; i3++) {
                    if (yb.k.a(obj, this.f7401f[i3])) {
                        length = i3 + this.f7401f.length;
                        i = this.f7400c;
                    }
                }
                return -1;
            }
            if (yb.k.a(obj, this.f7401f[length])) {
                i = this.f7400c;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    public final Object last() {
        if (isEmpty()) {
            g5.f.m("ArrayDeque is empty.");
            return null;
        }
        return this.f7401f[h((size() - 1) + this.f7400c)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iH = h(this.f7402g + this.f7400c);
        int i3 = this.f7400c;
        if (i3 < iH) {
            length = iH - 1;
            if (i3 <= length) {
                while (!yb.k.a(obj, this.f7401f[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i = this.f7400c;
                return length - i;
            }
            return -1;
        }
        if (i3 > iH) {
            while (true) {
                iH--;
                Object[] objArr = this.f7401f;
                if (-1 >= iH) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i10 = this.f7400c;
                    if (i10 <= length) {
                        while (!yb.k.a(obj, this.f7401f[length])) {
                            if (length != i10) {
                                length--;
                            }
                        }
                        i = this.f7400c;
                    }
                } else if (yb.k.a(obj, objArr[iH])) {
                    length = iH + this.f7401f.length;
                    i = this.f7400c;
                    break;
                }
            }
            return length - i;
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
    public final boolean removeAll(Collection collection) {
        int iH;
        Object[] objArr;
        collection.getClass();
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f7401f.length != 0) {
            int iH2 = h(a() + this.f7400c);
            int i = this.f7400c;
            if (i < iH2) {
                iH = i;
                while (true) {
                    objArr = this.f7401f;
                    if (i >= iH2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z10 = true;
                    } else {
                        this.f7401f[iH] = obj;
                        iH++;
                    }
                    i++;
                }
                k.m0(null, iH, objArr, iH2);
            } else {
                int length = this.f7401f.length;
                boolean z11 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr2 = this.f7401f;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z11 = true;
                    } else {
                        this.f7401f[i3] = obj2;
                        i3++;
                    }
                    i++;
                }
                iH = h(i3);
                for (int i10 = 0; i10 < iH2; i10++) {
                    Object[] objArr3 = this.f7401f;
                    Object obj3 = objArr3[i10];
                    objArr3[i10] = null;
                    if (collection.contains(obj3)) {
                        z11 = true;
                    } else {
                        this.f7401f[iH] = obj3;
                        iH = e(iH);
                    }
                }
                z10 = z11;
            }
            if (z10) {
                i();
                this.f7402g = f(iH - this.f7400c);
            }
        }
        return z10;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            g5.f.m("ArrayDeque is empty.");
            return null;
        }
        i();
        Object[] objArr = this.f7401f;
        int i = this.f7400c;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f7400c = e(i);
        this.f7402g = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            g5.f.m("ArrayDeque is empty.");
            return null;
        }
        i();
        int iH = h((size() - 1) + this.f7400c);
        Object[] objArr = this.f7401f;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.f7402g = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i3) {
        td.h.i(i, i3, this.f7402g);
        int i10 = i3 - i;
        if (i10 == 0) {
            return;
        }
        if (i10 == this.f7402g) {
            clear();
            return;
        }
        if (i10 == 1) {
            b(i);
            return;
        }
        i();
        int i11 = this.f7402g - i3;
        int i12 = this.f7400c;
        if (i < i11) {
            int iH = h((i - 1) + i12);
            int iH2 = h(this.f7400c + (i3 - 1));
            while (i > 0) {
                int i13 = iH + 1;
                int iMin = Math.min(i, Math.min(i13, iH2 + 1));
                Object[] objArr = this.f7401f;
                int i14 = iH2 - iMin;
                int i15 = iH - iMin;
                k.i0(objArr, objArr, i14 + 1, i15 + 1, i13);
                iH = f(i15);
                iH2 = f(i14);
                i -= iMin;
            }
            int iH3 = h(this.f7400c + i10);
            g(this.f7400c, iH3);
            this.f7400c = iH3;
        } else {
            int iH4 = h(i12 + i3);
            int iH5 = h(this.f7400c + i);
            int i16 = this.f7402g;
            while (true) {
                i16 -= i3;
                if (i16 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f7401f;
                i3 = Math.min(i16, Math.min(objArr2.length - iH4, objArr2.length - iH5));
                Object[] objArr3 = this.f7401f;
                int i17 = iH4 + i3;
                k.i0(objArr3, objArr3, iH5, iH4, i17);
                iH4 = h(i17);
                iH5 = h(iH5 + i3);
            }
            int iH6 = h(this.f7402g + this.f7400c);
            g(f(iH6 - i10), iH6);
        }
        this.f7402g -= i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iH;
        Object[] objArr;
        collection.getClass();
        boolean z10 = false;
        z10 = false;
        z10 = false;
        if (!isEmpty() && this.f7401f.length != 0) {
            int iH2 = h(a() + this.f7400c);
            int i = this.f7400c;
            if (i < iH2) {
                iH = i;
                while (true) {
                    objArr = this.f7401f;
                    if (i >= iH2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.f7401f[iH] = obj;
                        iH++;
                    } else {
                        z10 = true;
                    }
                    i++;
                }
                k.m0(null, iH, objArr, iH2);
            } else {
                int length = this.f7401f.length;
                boolean z11 = false;
                int i3 = i;
                while (i < length) {
                    Object[] objArr2 = this.f7401f;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.f7401f[i3] = obj2;
                        i3++;
                    } else {
                        z11 = true;
                    }
                    i++;
                }
                iH = h(i3);
                for (int i10 = 0; i10 < iH2; i10++) {
                    Object[] objArr3 = this.f7401f;
                    Object obj3 = objArr3[i10];
                    objArr3[i10] = null;
                    if (collection.contains(obj3)) {
                        this.f7401f[iH] = obj3;
                        iH = e(iH);
                    } else {
                        z11 = true;
                    }
                }
                z10 = z11;
            }
            if (z10) {
                i();
                this.f7402g = f(iH - this.f7400c);
            }
        }
        return z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int iA = a();
        if (i < 0 || i >= iA) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", iA));
            return null;
        }
        int iH = h(this.f7400c + i);
        Object[] objArr = this.f7401f;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        objArr.getClass();
        int length = objArr.length;
        int i = this.f7402g;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        int iH = h(this.f7402g + this.f7400c);
        int i3 = this.f7400c;
        if (i3 < iH) {
            k.k0(this.f7401f, objArr, i3, iH, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f7401f;
            k.i0(objArr2, objArr, 0, this.f7400c, objArr2.length);
            Object[] objArr3 = this.f7401f;
            k.i0(objArr3, objArr, objArr3.length - this.f7400c, 0, iH);
        }
        int i10 = this.f7402g;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        i();
        d(collection.size() + a());
        c(h(a() + this.f7400c), collection);
        return true;
    }
}
