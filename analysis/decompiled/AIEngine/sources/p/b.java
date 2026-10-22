package p;

import androidx.datastore.preferences.protobuf.b1;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E>, ac.b {

    /* renamed from: a, reason: collision with root package name */
    public int[] f11352a = q.a.f11482a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f11353b = q.a.f11484c;

    /* renamed from: c, reason: collision with root package name */
    public int f11354c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a extends c<E> {
        public a() {
            super(b.this.f11354c);
        }

        @Override // p.c
        public final E a(int i10) {
            return (E) b.this.f11353b[i10];
        }

        @Override // p.c
        public final void b(int i10) {
            b.this.a(i10);
        }
    }

    public b(Object obj) {
    }

    public final E a(int i10) {
        int i11 = this.f11354c;
        Object[] objArr = this.f11353b;
        E e10 = (E) objArr[i10];
        if (i11 <= 1) {
            clear();
            return e10;
        }
        int i12 = i11 - 1;
        int[] iArr = this.f11352a;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i12) {
                int i13 = i10 + 1;
                b1.o(i10, i13, iArr, iArr, i11);
                Object[] objArr2 = this.f11353b;
                b1.q(objArr2, objArr2, i10, i13, i11);
            }
            this.f11353b[i12] = null;
        } else {
            int i14 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] iArr2 = new int[i14];
            this.f11352a = iArr2;
            this.f11353b = new Object[i14];
            if (i10 > 0) {
                b1.r(0, i10, iArr, iArr2, 6);
                b1.t(objArr, this.f11353b, 0, i10, 6);
            }
            if (i10 < i12) {
                int i15 = i10 + 1;
                b1.o(i10, i15, iArr, this.f11352a, i11);
                b1.q(objArr, this.f11353b, i10, i15, i11);
            }
        }
        if (i11 != this.f11354c) {
            throw new ConcurrentModificationException();
        }
        this.f11354c = i12;
        return e10;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e10) {
        int i10;
        int iB;
        int i11 = this.f11354c;
        if (e10 == null) {
            iB = y.B(this, null, 0);
            i10 = 0;
        } else {
            int iHashCode = e10.hashCode();
            i10 = iHashCode;
            iB = y.B(this, e10, iHashCode);
        }
        if (iB >= 0) {
            return false;
        }
        int i12 = ~iB;
        int[] iArr = this.f11352a;
        if (i11 >= iArr.length) {
            int i13 = 8;
            if (i11 >= 8) {
                i13 = (i11 >> 1) + i11;
            } else if (i11 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f11353b;
            int[] iArr2 = new int[i13];
            this.f11352a = iArr2;
            this.f11353b = new Object[i13];
            if (i11 != this.f11354c) {
                throw new ConcurrentModificationException();
            }
            if (iArr2.length != 0) {
                b1.r(0, iArr.length, iArr, iArr2, 6);
                b1.t(objArr, this.f11353b, 0, objArr.length, 6);
            }
        }
        if (i12 < i11) {
            int[] iArr3 = this.f11352a;
            int i14 = i12 + 1;
            b1.o(i14, i12, iArr3, iArr3, i11);
            Object[] objArr2 = this.f11353b;
            b1.q(objArr2, objArr2, i14, i12, i11);
        }
        int i15 = this.f11354c;
        if (i11 == i15) {
            int[] iArr4 = this.f11352a;
            if (i12 < iArr4.length) {
                iArr4[i12] = i10;
                this.f11353b[i12] = e10;
                this.f11354c = i15 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        int size = elements.size() + this.f11354c;
        int i10 = this.f11354c;
        int[] iArr = this.f11352a;
        boolean zAdd = false;
        if (iArr.length < size) {
            Object[] objArr = this.f11353b;
            int[] iArr2 = new int[size];
            this.f11352a = iArr2;
            this.f11353b = new Object[size];
            if (i10 > 0) {
                b1.r(0, i10, iArr, iArr2, 6);
                b1.t(objArr, this.f11353b, 0, this.f11354c, 6);
            }
        }
        if (this.f11354c != i10) {
            throw new ConcurrentModificationException();
        }
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f11354c != 0) {
            this.f11352a = q.a.f11482a;
            this.f11353b = q.a.f11484c;
            this.f11354c = 0;
        }
        if (this.f11354c != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? y.B(this, null, 0) : y.B(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f11354c != ((Set) obj).size()) {
            return false;
        }
        try {
            int i10 = this.f11354c;
            for (int i11 = 0; i11 < i10; i11++) {
                if (!((Set) obj).contains(this.f11353b[i11])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f11352a;
        int i10 = this.f11354c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f11354c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iB = obj == null ? y.B(this, null, 0) : y.B(this, obj, obj.hashCode());
        if (iB < 0) {
            return false;
        }
        a(iB);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> elements) {
        kotlin.jvm.internal.g.f(elements, "elements");
        boolean z = false;
        for (int i10 = this.f11354c - 1; -1 < i10; i10--) {
            if (!kotlin.collections.a.n0(elements, this.f11353b[i10])) {
                a(i10);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f11354c;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return b1.v(this.f11353b, 0, this.f11354c);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11354c * 14);
        sb2.append('{');
        int i10 = this.f11354c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f11353b[i11];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.g.f(array, "array");
        int i10 = this.f11354c;
        if (array.length < i10) {
            array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), i10));
        } else if (array.length > i10) {
            array[i10] = null;
        }
        b1.q(this.f11353b, array, 0, 0, this.f11354c);
        return array;
    }
}
