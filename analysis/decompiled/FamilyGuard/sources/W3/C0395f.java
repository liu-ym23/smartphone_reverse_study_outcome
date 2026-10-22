package W3;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: W3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0395f<E> extends AbstractC0393d<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5756d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final Object[] f5757e = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    private int f5758a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f5759b = f5757e;

    /* renamed from: c, reason: collision with root package name */
    private int f5760c;

    /* renamed from: W3.f$a */
    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    private final void f(int i5, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.f5759b.length;
        while (i5 < length && it.hasNext()) {
            this.f5759b[i5] = it.next();
            i5++;
        }
        int i6 = this.f5758a;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f5759b[i7] = it.next();
        }
        this.f5760c = size() + collection.size();
    }

    private final void h(int i5) {
        Object[] objArr = new Object[i5];
        Object[] objArr2 = this.f5759b;
        C0399j.f(objArr2, objArr, 0, this.f5758a, objArr2.length);
        Object[] objArr3 = this.f5759b;
        int length = objArr3.length;
        int i6 = this.f5758a;
        C0399j.f(objArr3, objArr, length - i6, 0, i6);
        this.f5758a = 0;
        this.f5759b = objArr;
    }

    private final int i(int i5) {
        return i5 == 0 ? C0400k.o(this.f5759b) : i5 - 1;
    }

    private final void m(int i5) {
        if (i5 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f5759b;
        if (i5 <= objArr.length) {
            return;
        }
        if (objArr == f5757e) {
            this.f5759b = new Object[kotlin.ranges.l.b(i5, 10)];
        } else {
            h(AbstractC0392c.f5747a.d(objArr.length, i5));
        }
    }

    private final int n(int i5) {
        if (i5 == C0400k.o(this.f5759b)) {
            return 0;
        }
        return i5 + 1;
    }

    private final int o(int i5) {
        return i5 < 0 ? i5 + this.f5759b.length : i5;
    }

    private final void p(int i5, int i6) {
        if (i5 < i6) {
            C0399j.j(this.f5759b, null, i5, i6);
            return;
        }
        Object[] objArr = this.f5759b;
        C0399j.j(objArr, null, i5, objArr.length);
        C0399j.j(this.f5759b, null, 0, i6);
    }

    private final int q(int i5) {
        Object[] objArr = this.f5759b;
        return i5 >= objArr.length ? i5 - objArr.length : i5;
    }

    private final void r() {
        ((AbstractList) this).modCount++;
    }

    private final void t(int i5, int i6) {
        int iQ = q(this.f5758a + (i5 - 1));
        int iQ2 = q(this.f5758a + (i6 - 1));
        while (i5 > 0) {
            int i7 = iQ + 1;
            int iMin = Math.min(i5, Math.min(i7, iQ2 + 1));
            Object[] objArr = this.f5759b;
            int i8 = iQ2 - iMin;
            int i9 = iQ - iMin;
            C0399j.f(objArr, objArr, i8 + 1, i9 + 1, i7);
            iQ = o(i9);
            iQ2 = o(i8);
            i5 -= iMin;
        }
    }

    private final void u(int i5, int i6) {
        int iQ = q(this.f5758a + i6);
        int iQ2 = q(this.f5758a + i5);
        int size = size();
        while (true) {
            size -= i6;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.f5759b;
            i6 = Math.min(size, Math.min(objArr.length - iQ, objArr.length - iQ2));
            Object[] objArr2 = this.f5759b;
            int i7 = iQ + i6;
            C0399j.f(objArr2, objArr2, iQ2, iQ, i7);
            iQ = q(i7);
            iQ2 = q(iQ2 + i6);
        }
    }

    @Override // W3.AbstractC0393d
    public int a() {
        return this.f5760c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e6) {
        addLast(e6);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        j4.k.g(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        r();
        m(size() + collection.size());
        f(q(this.f5758a + size()), collection);
        return true;
    }

    public final void addFirst(E e6) {
        r();
        m(size() + 1);
        int i5 = i(this.f5758a);
        this.f5758a = i5;
        this.f5759b[i5] = e6;
        this.f5760c = size() + 1;
    }

    public final void addLast(E e6) {
        r();
        m(size() + 1);
        this.f5759b[q(this.f5758a + size())] = e6;
        this.f5760c = size() + 1;
    }

    @Override // W3.AbstractC0393d
    public E c(int i5) {
        AbstractC0392c.f5747a.a(i5, size());
        if (i5 == p.j(this)) {
            return removeLast();
        }
        if (i5 == 0) {
            return removeFirst();
        }
        r();
        int iQ = q(this.f5758a + i5);
        E e6 = (E) this.f5759b[iQ];
        if (i5 < (size() >> 1)) {
            int i6 = this.f5758a;
            if (iQ >= i6) {
                Object[] objArr = this.f5759b;
                C0399j.f(objArr, objArr, i6 + 1, i6, iQ);
            } else {
                Object[] objArr2 = this.f5759b;
                C0399j.f(objArr2, objArr2, 1, 0, iQ);
                Object[] objArr3 = this.f5759b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i7 = this.f5758a;
                C0399j.f(objArr3, objArr3, i7 + 1, i7, objArr3.length - 1);
            }
            Object[] objArr4 = this.f5759b;
            int i8 = this.f5758a;
            objArr4[i8] = null;
            this.f5758a = n(i8);
        } else {
            int iQ2 = q(this.f5758a + p.j(this));
            if (iQ <= iQ2) {
                Object[] objArr5 = this.f5759b;
                C0399j.f(objArr5, objArr5, iQ, iQ + 1, iQ2 + 1);
            } else {
                Object[] objArr6 = this.f5759b;
                C0399j.f(objArr6, objArr6, iQ, iQ + 1, objArr6.length);
                Object[] objArr7 = this.f5759b;
                objArr7[objArr7.length - 1] = objArr7[0];
                C0399j.f(objArr7, objArr7, 0, 1, iQ2 + 1);
            }
            this.f5759b[iQ2] = null;
        }
        this.f5760c = size() - 1;
        return e6;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            r();
            p(this.f5758a, q(this.f5758a + size()));
        }
        this.f5758a = 0;
        this.f5760c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i5) {
        AbstractC0392c.f5747a.a(i5, size());
        return (E) this.f5759b[q(this.f5758a + i5)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i5;
        int iQ = q(this.f5758a + size());
        int length = this.f5758a;
        if (length < iQ) {
            while (length < iQ) {
                if (j4.k.b(obj, this.f5759b[length])) {
                    i5 = this.f5758a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iQ) {
            return -1;
        }
        int length2 = this.f5759b.length;
        while (true) {
            if (length >= length2) {
                for (int i6 = 0; i6 < iQ; i6++) {
                    if (j4.k.b(obj, this.f5759b[i6])) {
                        length = i6 + this.f5759b.length;
                        i5 = this.f5758a;
                    }
                }
                return -1;
            }
            if (j4.k.b(obj, this.f5759b[length])) {
                i5 = this.f5758a;
                break;
            }
            length++;
        }
        return length - i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int iO;
        int i5;
        int iQ = q(this.f5758a + size());
        int i6 = this.f5758a;
        if (i6 < iQ) {
            iO = iQ - 1;
            if (i6 <= iO) {
                while (!j4.k.b(obj, this.f5759b[iO])) {
                    if (iO != i6) {
                        iO--;
                    }
                }
                i5 = this.f5758a;
                return iO - i5;
            }
            return -1;
        }
        if (i6 > iQ) {
            int i7 = iQ - 1;
            while (true) {
                if (-1 >= i7) {
                    iO = C0400k.o(this.f5759b);
                    int i8 = this.f5758a;
                    if (i8 <= iO) {
                        while (!j4.k.b(obj, this.f5759b[iO])) {
                            if (iO != i8) {
                                iO--;
                            }
                        }
                        i5 = this.f5758a;
                    }
                } else {
                    if (j4.k.b(obj, this.f5759b[i7])) {
                        iO = i7 + this.f5759b.length;
                        i5 = this.f5758a;
                        break;
                    }
                    i7--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        c(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        int iQ;
        j4.k.g(collection, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.f5759b.length != 0) {
            int iQ2 = q(this.f5758a + size());
            int i5 = this.f5758a;
            if (i5 < iQ2) {
                iQ = i5;
                while (i5 < iQ2) {
                    Object obj = this.f5759b[i5];
                    if (collection.contains(obj)) {
                        z5 = true;
                    } else {
                        this.f5759b[iQ] = obj;
                        iQ++;
                    }
                    i5++;
                }
                C0399j.j(this.f5759b, null, iQ, iQ2);
            } else {
                int length = this.f5759b.length;
                boolean z6 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f5759b;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (collection.contains(obj2)) {
                        z6 = true;
                    } else {
                        this.f5759b[i6] = obj2;
                        i6++;
                    }
                    i5++;
                }
                iQ = q(i6);
                for (int i7 = 0; i7 < iQ2; i7++) {
                    Object[] objArr2 = this.f5759b;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (collection.contains(obj3)) {
                        z6 = true;
                    } else {
                        this.f5759b[iQ] = obj3;
                        iQ = n(iQ);
                    }
                }
                z5 = z6;
            }
            if (z5) {
                r();
                this.f5760c = o(iQ - this.f5758a);
            }
        }
        return z5;
    }

    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        r();
        Object[] objArr = this.f5759b;
        int i5 = this.f5758a;
        E e6 = (E) objArr[i5];
        objArr[i5] = null;
        this.f5758a = n(i5);
        this.f5760c = size() - 1;
        return e6;
    }

    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        r();
        int iQ = q(this.f5758a + p.j(this));
        Object[] objArr = this.f5759b;
        E e6 = (E) objArr[iQ];
        objArr[iQ] = null;
        this.f5760c = size() - 1;
        return e6;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i5, int i6) {
        AbstractC0392c.f5747a.c(i5, i6, size());
        int i7 = i6 - i5;
        if (i7 == 0) {
            return;
        }
        if (i7 == size()) {
            clear();
            return;
        }
        if (i7 == 1) {
            c(i5);
            return;
        }
        r();
        if (i5 < size() - i6) {
            t(i5, i6);
            int iQ = q(this.f5758a + i7);
            p(this.f5758a, iQ);
            this.f5758a = iQ;
        } else {
            u(i5, i6);
            int iQ2 = q(this.f5758a + size());
            p(o(iQ2 - i7), iQ2);
        }
        this.f5760c = size() - i7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        int iQ;
        j4.k.g(collection, "elements");
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (!isEmpty() && this.f5759b.length != 0) {
            int iQ2 = q(this.f5758a + size());
            int i5 = this.f5758a;
            if (i5 < iQ2) {
                iQ = i5;
                while (i5 < iQ2) {
                    Object obj = this.f5759b[i5];
                    if (collection.contains(obj)) {
                        this.f5759b[iQ] = obj;
                        iQ++;
                    } else {
                        z5 = true;
                    }
                    i5++;
                }
                C0399j.j(this.f5759b, null, iQ, iQ2);
            } else {
                int length = this.f5759b.length;
                boolean z6 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f5759b;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (collection.contains(obj2)) {
                        this.f5759b[i6] = obj2;
                        i6++;
                    } else {
                        z6 = true;
                    }
                    i5++;
                }
                iQ = q(i6);
                for (int i7 = 0; i7 < iQ2; i7++) {
                    Object[] objArr2 = this.f5759b;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (collection.contains(obj3)) {
                        this.f5759b[iQ] = obj3;
                        iQ = n(iQ);
                    } else {
                        z6 = true;
                    }
                }
                z5 = z6;
            }
            if (z5) {
                r();
                this.f5760c = o(iQ - this.f5758a);
            }
        }
        return z5;
    }

    public final E s() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i5, E e6) {
        AbstractC0392c.f5747a.a(i5, size());
        int iQ = q(this.f5758a + i5);
        Object[] objArr = this.f5759b;
        E e7 = (E) objArr[iQ];
        objArr[iQ] = e6;
        return e7;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        j4.k.g(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) C0397h.a(tArr, size());
        }
        T[] tArr2 = tArr;
        int iQ = q(this.f5758a + size());
        int i5 = this.f5758a;
        if (i5 < iQ) {
            C0399j.h(this.f5759b, tArr2, 0, i5, iQ, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f5759b;
            C0399j.f(objArr, tArr2, 0, this.f5758a, objArr.length);
            Object[] objArr2 = this.f5759b;
            C0399j.f(objArr2, tArr2, objArr2.length - this.f5758a, 0, iQ);
        }
        return (T[]) o.c(size(), tArr2);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i5, E e6) {
        AbstractC0392c.f5747a.b(i5, size());
        if (i5 == size()) {
            addLast(e6);
            return;
        }
        if (i5 == 0) {
            addFirst(e6);
            return;
        }
        r();
        m(size() + 1);
        int iQ = q(this.f5758a + i5);
        if (i5 < ((size() + 1) >> 1)) {
            int i6 = i(iQ);
            int i7 = i(this.f5758a);
            int i8 = this.f5758a;
            if (i6 >= i8) {
                Object[] objArr = this.f5759b;
                objArr[i7] = objArr[i8];
                C0399j.f(objArr, objArr, i8, i8 + 1, i6 + 1);
            } else {
                Object[] objArr2 = this.f5759b;
                C0399j.f(objArr2, objArr2, i8 - 1, i8, objArr2.length);
                Object[] objArr3 = this.f5759b;
                objArr3[objArr3.length - 1] = objArr3[0];
                C0399j.f(objArr3, objArr3, 0, 1, i6 + 1);
            }
            this.f5759b[i6] = e6;
            this.f5758a = i7;
        } else {
            int iQ2 = q(this.f5758a + size());
            if (iQ < iQ2) {
                Object[] objArr4 = this.f5759b;
                C0399j.f(objArr4, objArr4, iQ + 1, iQ, iQ2);
            } else {
                Object[] objArr5 = this.f5759b;
                C0399j.f(objArr5, objArr5, 1, 0, iQ2);
                Object[] objArr6 = this.f5759b;
                objArr6[0] = objArr6[objArr6.length - 1];
                C0399j.f(objArr6, objArr6, iQ + 1, iQ, objArr6.length - 1);
            }
            this.f5759b[iQ] = e6;
        }
        this.f5760c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i5, Collection<? extends E> collection) {
        j4.k.g(collection, "elements");
        AbstractC0392c.f5747a.b(i5, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i5 == size()) {
            return addAll(collection);
        }
        r();
        m(size() + collection.size());
        int iQ = q(this.f5758a + size());
        int iQ2 = q(this.f5758a + i5);
        int size = collection.size();
        if (i5 < ((size() + 1) >> 1)) {
            int i6 = this.f5758a;
            int length = i6 - size;
            if (iQ2 < i6) {
                Object[] objArr = this.f5759b;
                C0399j.f(objArr, objArr, length, i6, objArr.length);
                if (size >= iQ2) {
                    Object[] objArr2 = this.f5759b;
                    C0399j.f(objArr2, objArr2, objArr2.length - size, 0, iQ2);
                } else {
                    Object[] objArr3 = this.f5759b;
                    C0399j.f(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f5759b;
                    C0399j.f(objArr4, objArr4, 0, size, iQ2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f5759b;
                C0399j.f(objArr5, objArr5, length, i6, iQ2);
            } else {
                Object[] objArr6 = this.f5759b;
                length += objArr6.length;
                int i7 = iQ2 - i6;
                int length2 = objArr6.length - length;
                if (length2 >= i7) {
                    C0399j.f(objArr6, objArr6, length, i6, iQ2);
                } else {
                    C0399j.f(objArr6, objArr6, length, i6, i6 + length2);
                    Object[] objArr7 = this.f5759b;
                    C0399j.f(objArr7, objArr7, 0, this.f5758a + length2, iQ2);
                }
            }
            this.f5758a = length;
            f(o(iQ2 - size), collection);
        } else {
            int i8 = iQ2 + size;
            if (iQ2 < iQ) {
                int i9 = size + iQ;
                Object[] objArr8 = this.f5759b;
                if (i9 <= objArr8.length) {
                    C0399j.f(objArr8, objArr8, i8, iQ2, iQ);
                } else if (i8 >= objArr8.length) {
                    C0399j.f(objArr8, objArr8, i8 - objArr8.length, iQ2, iQ);
                } else {
                    int length3 = iQ - (i9 - objArr8.length);
                    C0399j.f(objArr8, objArr8, 0, length3, iQ);
                    Object[] objArr9 = this.f5759b;
                    C0399j.f(objArr9, objArr9, i8, iQ2, length3);
                }
            } else {
                Object[] objArr10 = this.f5759b;
                C0399j.f(objArr10, objArr10, size, 0, iQ);
                Object[] objArr11 = this.f5759b;
                if (i8 >= objArr11.length) {
                    C0399j.f(objArr11, objArr11, i8 - objArr11.length, iQ2, objArr11.length);
                } else {
                    C0399j.f(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f5759b;
                    C0399j.f(objArr12, objArr12, i8, iQ2, objArr12.length - size);
                }
            }
            f(iQ2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
