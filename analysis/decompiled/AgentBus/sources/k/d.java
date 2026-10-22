package k;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d implements Collection {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f5474f;

    public d(e eVar) {
        this.f5474f = eVar;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f5474f.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5474f.a(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f5474f.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f5474f, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f5474f;
        int iA = eVar.a(obj);
        if (iA < 0) {
            return false;
        }
        eVar.i(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f5474f;
        int i2 = eVar.f5479h;
        int i10 = 0;
        boolean z4 = false;
        while (i10 < i2) {
            if (collection.contains(eVar.k(i10))) {
                eVar.i(i10);
                i10--;
                i2--;
                z4 = true;
            }
            i10++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f5474f;
        int i2 = eVar.f5479h;
        int i10 = 0;
        boolean z4 = false;
        while (i10 < i2) {
            if (!collection.contains(eVar.k(i10))) {
                eVar.i(i10);
                i10--;
                i2--;
                z4 = true;
            }
            i10++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f5474f.f5479h;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f5474f;
        int i2 = eVar.f5479h;
        Object[] objArr = new Object[i2];
        for (int i10 = 0; i10 < i2; i10++) {
            objArr[i10] = eVar.k(i10);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f5474f;
        int i2 = eVar.f5479h;
        if (objArr.length < i2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
        }
        for (int i10 = 0; i10 < i2; i10++) {
            objArr[i10] = eVar.k(i10);
        }
        if (objArr.length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
