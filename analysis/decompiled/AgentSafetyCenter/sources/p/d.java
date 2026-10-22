package p;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Collection {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e f9537c;

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
        this.f9537c.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9537c.a(obj) >= 0;
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
        return this.f9537c.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new a(this.f9537c, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        e eVar = this.f9537c;
        int iA = eVar.a(obj);
        if (iA < 0) {
            return false;
        }
        eVar.f(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        e eVar = this.f9537c;
        int i = eVar.f9610g;
        int i3 = 0;
        boolean z10 = false;
        while (i3 < i) {
            if (collection.contains(eVar.h(i3))) {
                eVar.f(i3);
                i3--;
                i--;
                z10 = true;
            }
            i3++;
        }
        return z10;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        e eVar = this.f9537c;
        int i = eVar.f9610g;
        int i3 = 0;
        boolean z10 = false;
        while (i3 < i) {
            if (!collection.contains(eVar.h(i3))) {
                eVar.f(i3);
                i3--;
                i--;
                z10 = true;
            }
            i3++;
        }
        return z10;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f9537c.f9610g;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        e eVar = this.f9537c;
        int i = eVar.f9610g;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = eVar.h(i3);
        }
        if (objArr.length > i) {
            objArr[i] = null;
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        e eVar = this.f9537c;
        int i = eVar.f9610g;
        Object[] objArr = new Object[i];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = eVar.h(i3);
        }
        return objArr;
    }
}
