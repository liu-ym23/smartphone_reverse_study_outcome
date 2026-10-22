package j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Collection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3287a;

    public d(e eVar) {
        this.f3287a = eVar;
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
        this.f3287a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f3287a.a(obj) >= 0;
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
        return this.f3287a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f3287a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f3287a;
        int iA = eVar.a(obj);
        if (iA < 0) {
            return false;
        }
        eVar.g(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f3287a;
        int i8 = eVar.f3306c;
        int i9 = 0;
        boolean z = false;
        while (i9 < i8) {
            if (collection.contains(eVar.i(i9))) {
                eVar.g(i9);
                i9--;
                i8--;
                z = true;
            }
            i9++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f3287a;
        int i8 = eVar.f3306c;
        int i9 = 0;
        boolean z = false;
        while (i9 < i8) {
            if (!collection.contains(eVar.i(i9))) {
                eVar.g(i9);
                i9--;
                i8--;
                z = true;
            }
            i9++;
        }
        return z;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f3287a.f3306c;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f3287a;
        int i8 = eVar.f3306c;
        Object[] objArr = new Object[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = eVar.i(i9);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f3287a;
        int i8 = eVar.f3306c;
        if (objArr.length < i8) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i8);
        }
        for (int i9 = 0; i9 < i8; i9++) {
            objArr[i9] = eVar.i(i9);
        }
        if (objArr.length > i8) {
            objArr[i8] = null;
        }
        return objArr;
    }
}
