package lb;

import b8.z;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends kb.f implements RandomAccess, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public Object[] f7826c;

    /* renamed from: f, reason: collision with root package name */
    public final int f7827f;

    /* renamed from: g, reason: collision with root package name */
    public int f7828g;

    /* renamed from: h, reason: collision with root package name */
    public final b f7829h;
    public final c i;

    public b(Object[] objArr, int i, int i3, b bVar, c cVar) {
        objArr.getClass();
        cVar.getClass();
        this.f7826c = objArr;
        this.f7827f = i;
        this.f7828g = i3;
        this.f7829h = bVar;
        this.i = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // kb.f
    public final int a() {
        f();
        return this.f7828g;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        g();
        f();
        int i3 = this.f7828g;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        } else {
            e(this.f7827f + i, obj);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        g();
        f();
        int i3 = this.f7828g;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return false;
        }
        int size = collection.size();
        d(this.f7827f + i, collection, size);
        return size > 0;
    }

    @Override // kb.f
    public final Object b(int i) {
        g();
        f();
        int i3 = this.f7828g;
        if (i >= 0 && i < i3) {
            return h(this.f7827f + i);
        }
        g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        return null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f7827f, this.f7828g);
    }

    public final void d(int i, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        c cVar = this.i;
        b bVar = this.f7829h;
        if (bVar != null) {
            bVar.d(i, collection, i3);
        } else {
            c cVar2 = c.f7830h;
            cVar.d(i, collection, i3);
        }
        this.f7826c = cVar.f7831c;
        this.f7828g += i3;
    }

    public final void e(int i, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.i;
        b bVar = this.f7829h;
        if (bVar != null) {
            bVar.e(i, obj);
        } else {
            c cVar2 = c.f7830h;
            cVar.e(i, obj);
        }
        this.f7826c = cVar.f7831c;
        this.f7828g++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f7826c;
            int i = this.f7828g;
            if (i == list.size()) {
                for (int i3 = 0; i3 < i; i3++) {
                    if (k.a(objArr[this.f7827f + i3], list.get(i3))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.i).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.i.f7833g) {
            z.c();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        f();
        int i3 = this.f7828g;
        if (i >= 0 && i < i3) {
            return this.f7826c[this.f7827f + i];
        }
        g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
        return null;
    }

    public final Object h(int i) {
        Object objH;
        ((AbstractList) this).modCount++;
        b bVar = this.f7829h;
        if (bVar != null) {
            objH = bVar.h(i);
        } else {
            c cVar = c.f7830h;
            objH = this.i.h(i);
        }
        this.f7828g--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.f7826c;
        int i = this.f7828g;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[this.f7827f + i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f7829h;
        if (bVar != null) {
            bVar.i(i, i3);
        } else {
            c cVar = c.f7830h;
            this.i.i(i, i3);
        }
        this.f7828g -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i = 0; i < this.f7828g; i++) {
            if (k.a(this.f7826c[this.f7827f + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.f7828g == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i, int i3, Collection collection, boolean z10) {
        int iJ;
        b bVar = this.f7829h;
        if (bVar != null) {
            iJ = bVar.j(i, i3, collection, z10);
        } else {
            c cVar = c.f7830h;
            iJ = this.i.j(i, i3, collection, z10);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f7828g -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i = this.f7828g - 1; i >= 0; i--) {
            if (k.a(this.f7826c[this.f7827f + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        f();
        int i3 = this.f7828g;
        if (i < 0 || i > i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        a aVar = new a(0);
        aVar.i = this;
        aVar.f7823f = i;
        aVar.f7824g = -1;
        aVar.f7825h = ((AbstractList) this).modCount;
        VarHandle.storeStoreFence();
        return aVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
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
        g();
        f();
        return j(this.f7827f, this.f7828g, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        g();
        f();
        return j(this.f7827f, this.f7828g, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        g();
        f();
        int i3 = this.f7828g;
        if (i < 0 || i >= i3) {
            g5.f.q(androidx.activity.b.i("index: ", i, ", size: ", i3));
            return null;
        }
        Object[] objArr = this.f7826c;
        int i10 = this.f7827f;
        Object obj2 = objArr[i10 + i];
        objArr[i10 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i3) {
        td.h.i(i, i3, this.f7828g);
        return new b(this.f7826c, this.f7827f + i, i3 - i, this, this.i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        f();
        int length = objArr.length;
        int i = this.f7828g;
        Object[] objArr2 = this.f7826c;
        int i3 = this.f7827f;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i3, i + i3, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        kb.k.i0(objArr2, objArr, 0, i3, i + i3);
        int i10 = this.f7828g;
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return a.a.h(this.f7826c, this.f7827f, this.f7828g, this);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f7827f + this.f7828g, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f7826c;
        int i = this.f7828g;
        int i3 = this.f7827f;
        return kb.k.l0(objArr, i3, i + i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        g();
        f();
        int size = collection.size();
        d(this.f7827f + this.f7828g, collection, size);
        return size > 0;
    }
}
