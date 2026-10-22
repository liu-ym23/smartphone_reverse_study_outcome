package lb;

import b8.z;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends kb.f implements RandomAccess, Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final c f7830h;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f7831c;

    /* renamed from: f, reason: collision with root package name */
    public int f7832f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7833g;

    static {
        c cVar = new c(0);
        cVar.f7833g = true;
        f7830h = cVar;
    }

    public c(int i) {
        if (i >= 0) {
            this.f7831c = new Object[i];
        } else {
            g5.f.s("capacity must be non-negative.");
            throw null;
        }
    }

    @Override // kb.f
    public final int a() {
        return this.f7832f;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        f();
        int i3 = this.f7832f;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return;
        }
        ((AbstractList) this).modCount++;
        g(i, 1);
        this.f7831c[i] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        f();
        int i3 = this.f7832f;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return false;
        }
        int size = collection.size();
        d(i, collection, size);
        return size > 0;
    }

    @Override // kb.f
    public final Object b(int i) {
        f();
        int i3 = this.f7832f;
        if (i >= 0 && i < i3) {
            return h(i);
        }
        g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f7832f);
    }

    public final void d(int i, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        g(i, i3);
        Iterator it = collection.iterator();
        for (int i10 = 0; i10 < i3; i10++) {
            this.f7831c[i + i10] = it.next();
        }
    }

    public final void e(int i, Object obj) {
        ((AbstractList) this).modCount++;
        g(i, 1);
        this.f7831c[i] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f7831c;
            int i = this.f7832f;
            if (i == list.size()) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (k.a(objArr[i3], list.get(i3))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.f7833g) {
            z.c();
        }
    }

    public final void g(int i, int i3) {
        int i10 = this.f7832f + i3;
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f7831c;
        if (i10 > objArr.length) {
            int length = objArr.length;
            int i11 = length + (length >> 1);
            if (i11 - i10 < 0) {
                i11 = i10;
            }
            if (i11 - 2147483639 > 0) {
                i11 = i10 > 2147483639 ? Reader.READ_DONE : 2147483639;
            }
            this.f7831c = Arrays.copyOf(objArr, i11);
        }
        Object[] objArr2 = this.f7831c;
        kb.k.i0(objArr2, objArr2, i + i3, i, this.f7832f);
        this.f7832f += i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i3 = this.f7832f;
        if (i >= 0 && i < i3) {
            return this.f7831c[i];
        }
        g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        return null;
    }

    public final Object h(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f7831c;
        Object obj = objArr[i];
        kb.k.i0(objArr, objArr, i, i + 1, this.f7832f);
        Object[] objArr2 = this.f7831c;
        int i3 = this.f7832f - 1;
        objArr2.getClass();
        objArr2[i3] = null;
        this.f7832f--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f7831c;
        int i = this.f7832f;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f7831c;
        kb.k.i0(objArr, objArr, i, i + i3, this.f7832f);
        Object[] objArr2 = this.f7831c;
        int i10 = this.f7832f;
        a.a.S(objArr2, i10 - i3, i10);
        this.f7832f -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.f7832f; i++) {
            if (k.a(this.f7831c[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f7832f == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i, int i3, Collection collection, boolean z10) {
        Object[] objArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            objArr = this.f7831c;
            if (i10 >= i3) {
                break;
            }
            int i12 = i + i10;
            if (collection.contains(objArr[i12]) == z10) {
                Object[] objArr2 = this.f7831c;
                i10++;
                objArr2[i11 + i] = objArr2[i12];
                i11++;
            } else {
                i10++;
            }
        }
        int i13 = i3 - i11;
        kb.k.i0(objArr, objArr, i + i11, i3 + i, this.f7832f);
        Object[] objArr3 = this.f7831c;
        int i14 = this.f7832f;
        a.a.S(objArr3, i14 - i13, i14);
        if (i13 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f7832f -= i13;
        return i13;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.f7832f - 1; i >= 0; i--) {
            if (k.a(this.f7831c[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i3 = this.f7832f;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        a aVar = new a(1);
        aVar.i = this;
        aVar.f7823f = i;
        aVar.f7824g = -1;
        aVar.f7825h = ((AbstractList) this).modCount;
        VarHandle.storeStoreFence();
        return aVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        f();
        return j(0, this.f7832f, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        f();
        return j(0, this.f7832f, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        f();
        int i3 = this.f7832f;
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        Object[] objArr = this.f7831c;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        td.h.i(i, i3, this.f7832f);
        return new b(this.f7831c, i, i3 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.f7832f;
        Object[] objArr2 = this.f7831c;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, 0, i, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        kb.k.i0(objArr2, objArr, 0, 0, i);
        int i3 = this.f7832f;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return a.a.h(this.f7831c, 0, this.f7832f, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i = this.f7832f;
        ((AbstractList) this).modCount++;
        g(i, 1);
        this.f7831c[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return kb.k.l0(this.f7831c, 0, this.f7832f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        f();
        int size = collection.size();
        d(this.f7832f, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }
}
