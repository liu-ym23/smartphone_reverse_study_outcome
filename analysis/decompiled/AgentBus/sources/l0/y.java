package l0;

import b0.u1;
import d7.f0;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class y implements List, r7.c {

    /* renamed from: f, reason: collision with root package name */
    public final q f5815f;

    /* renamed from: g, reason: collision with root package name */
    public final int f5816g;

    /* renamed from: h, reason: collision with root package name */
    public int f5817h;

    /* renamed from: i, reason: collision with root package name */
    public int f5818i;

    public y(q qVar, int i2, int i10) {
        this.f5815f = qVar;
        this.f5816g = i2;
        this.f5817h = r.e(qVar);
        this.f5818i = i10 - i2;
    }

    public final void a() {
        if (r.e(this.f5815f) != this.f5817h) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        a();
        int i2 = this.f5816g + this.f5818i;
        q qVar = this.f5815f;
        qVar.add(i2, obj);
        this.f5818i++;
        this.f5817h = r.e(qVar);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(this.f5818i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.f5818i > 0) {
            a();
            int i2 = this.f5818i;
            int i10 = this.f5816g;
            q qVar = this.f5815f;
            qVar.i(i10, i2 + i10);
            this.f5818i = 0;
            this.f5817h = r.e(qVar);
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        a();
        r.a(i2, this.f5818i);
        return this.f5815f.get(this.f5816g + i2);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        a();
        int i2 = this.f5818i;
        int i10 = this.f5816g;
        Iterator it = nb.i.N(i10, i2 + i10).iterator();
        while (it.hasNext()) {
            int iNextInt = ((v7.c) it).nextInt();
            if (q7.k.a(obj, this.f5815f.get(iNextInt))) {
                return iNextInt - i10;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f5818i == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        a();
        int i2 = this.f5818i;
        int i10 = this.f5816g;
        for (int i11 = (i2 + i10) - 1; i11 >= i10; i11--) {
            if (q7.k.a(obj, this.f5815f.get(i11))) {
                return i11 - i10;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z4 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z4) {
                    z4 = true;
                }
            }
            return z4;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i2;
        f0.c cVar;
        f fVarK;
        boolean zB;
        a();
        q qVar = this.f5815f;
        int i10 = this.f5816g;
        int i11 = this.f5818i + i10;
        int size = qVar.size();
        do {
            synchronized (r.f5786a) {
                u uVar = qVar.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.g gVarJ = cVar.j();
            gVarJ.subList(i10, i11).retainAll(collection);
            f0.c cVarH = gVarJ.h();
            if (q7.k.a(cVarH, cVar)) {
                break;
            }
            u uVar3 = qVar.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, qVar, fVarK), i2, cVarH, true);
            }
            m.n(fVarK, qVar);
        } while (!zB);
        int size2 = size - qVar.size();
        if (size2 > 0) {
            this.f5817h = r.e(this.f5815f);
            this.f5818i -= size2;
        }
        return size2 > 0;
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        r.a(i2, this.f5818i);
        a();
        int i10 = i2 + this.f5816g;
        q qVar = this.f5815f;
        Object obj2 = qVar.set(i10, obj);
        this.f5817h = r.e(qVar);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f5818i;
    }

    @Override // java.util.List
    public final List subList(int i2, int i10) {
        if (!(i2 >= 0 && i2 <= i10 && i10 <= this.f5818i)) {
            u1.a("fromIndex or toIndex are out of bounds");
        }
        a();
        int i11 = this.f5816g;
        return new y(this.f5815f, i2 + i11, i10 + i11);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return q7.j.a(this);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        a();
        q7.t tVar = new q7.t();
        tVar.f8818f = i2 - 1;
        return new f0(tVar, this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return q7.j.b(this, objArr);
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        a();
        int i10 = i2 + this.f5816g;
        q qVar = this.f5815f;
        boolean zAddAll = qVar.addAll(i10, collection);
        if (zAddAll) {
            this.f5818i = collection.size() + this.f5818i;
            this.f5817h = r.e(qVar);
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        a();
        int i10 = this.f5816g + i2;
        q qVar = this.f5815f;
        Object objRemove = qVar.remove(i10);
        this.f5818i--;
        this.f5817h = r.e(qVar);
        return objRemove;
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        a();
        int i10 = this.f5816g + i2;
        q qVar = this.f5815f;
        qVar.add(i10, obj);
        this.f5818i++;
        this.f5817h = r.e(qVar);
    }
}
