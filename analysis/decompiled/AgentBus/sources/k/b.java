package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class b implements Set {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f5452f;

    public b(e eVar) {
        this.f5452f = eVar;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        this.f5452f.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5452f.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f5452f.b(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        e eVar = this.f5452f;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        try {
            if (eVar.f5479h == set.size()) {
                return eVar.b(set);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        e eVar = this.f5452f;
        int iHashCode = 0;
        for (int i2 = eVar.f5479h - 1; i2 >= 0; i2--) {
            Object objG = eVar.g(i2);
            iHashCode += objG == null ? 0 : objG.hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        return this.f5452f.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f5452f, 0);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f5452f;
        int iE = eVar.e(obj);
        if (iE < 0) {
            return false;
        }
        eVar.i(iE);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f5452f;
        int i2 = eVar.f5479h;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            eVar.remove(it.next());
        }
        return i2 != eVar.f5479h;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f5452f;
        int i2 = eVar.f5479h;
        for (int i10 = i2 - 1; i10 >= 0; i10--) {
            if (!collection.contains(eVar.g(i10))) {
                eVar.i(i10);
            }
        }
        return i2 != eVar.f5479h;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f5452f.f5479h;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f5452f;
        int i2 = eVar.f5479h;
        Object[] objArr = new Object[i2];
        for (int i10 = 0; i10 < i2; i10++) {
            objArr[i10] = eVar.g(i10);
        }
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f5452f;
        int i2 = eVar.f5479h;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i10 = 0; i10 < i2; i10++) {
            objArr[i10] = eVar.g(i10);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
