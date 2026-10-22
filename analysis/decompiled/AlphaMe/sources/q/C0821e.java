package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: q.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0821e implements Collection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f13947a;

    public C0821e(f fVar) {
        this.f13947a = fVar;
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
        this.f13947a.clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f13947a.a(obj) >= 0;
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
        return this.f13947a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0818b(this.f13947a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        f fVar = this.f13947a;
        int iA = fVar.a(obj);
        if (iA < 0) {
            return false;
        }
        fVar.g(iA);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        f fVar = this.f13947a;
        int i4 = fVar.f13970c;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < i4) {
            if (collection.contains(fVar.i(i5))) {
                fVar.g(i5);
                i5--;
                i4--;
                z4 = true;
            }
            i5++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        f fVar = this.f13947a;
        int i4 = fVar.f13970c;
        int i5 = 0;
        boolean z4 = false;
        while (i5 < i4) {
            if (!collection.contains(fVar.i(i5))) {
                fVar.g(i5);
                i5--;
                i4--;
                z4 = true;
            }
            i5++;
        }
        return z4;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f13947a.f13970c;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        f fVar = this.f13947a;
        int i4 = fVar.f13970c;
        Object[] objArr = new Object[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = fVar.i(i5);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        f fVar = this.f13947a;
        int i4 = fVar.f13970c;
        if (objArr.length < i4) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            objArr[i5] = fVar.i(i5);
        }
        if (objArr.length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }
}
