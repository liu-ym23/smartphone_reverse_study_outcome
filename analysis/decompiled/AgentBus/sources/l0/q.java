package l0;

import android.os.Parcel;
import android.os.Parcelable;
import b0.u1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class q implements Parcelable, v, List, RandomAccess, r7.c {
    public static final Parcelable.Creator<q> CREATOR = new p();

    /* renamed from: f, reason: collision with root package name */
    public u f5785f;

    public q(f0.c cVar) {
        f fVarK = m.k();
        u uVar = new u(fVarK.g(), cVar);
        if (!(fVarK instanceof a)) {
            uVar.f5814b = new u(1, cVar);
        }
        this.f5785f = uVar;
    }

    @Override // l0.v
    public final x a() {
        return this.f5785f;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i2;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarH = cVar.h(obj);
            if (cVarH.equals(cVar)) {
                return false;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i2, cVarH, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public final boolean addAll(final int i2, final Collection collection) {
        return r.g(this, new p7.k() { // from class: l0.o
            @Override // p7.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(((List) obj).addAll(i2, collection));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        f fVarK;
        u uVar = this.f5785f;
        q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        synchronized (m.f5774c) {
            fVarK = m.k();
            u uVar2 = (u) m.w(uVar, this, fVarK);
            synchronized (r.f5786a) {
                uVar2.f5809c = f0.j.f3351g;
                uVar2.f5810d++;
                uVar2.f5811e++;
            }
        }
        m.n(fVarK, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return r.d(this).f5809c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return r.d(this).f5809c.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // l0.v
    public final void f(x xVar) {
        xVar.f5814b = this.f5785f;
        this.f5785f = (u) xVar;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return r.d(this).f5809c.get(i2);
    }

    public final void i(int i2, int i10) {
        int i11;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i11 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.g gVarJ = cVar.j();
            gVarJ.subList(i2, i10).clear();
            f0.c cVarH = gVarJ.h();
            if (q7.k.a(cVarH, cVar)) {
                return;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i11, cVarH, true);
            }
            m.n(fVarK, this);
        } while (!zB);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return r.d(this).f5809c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return r.d(this).f5809c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return r.d(this).f5809c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new e7.a(this, 0);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        int i10;
        f0.c cVar;
        f fVarK;
        boolean zB;
        Object obj = get(i2);
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i10 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarL = cVar.l(i2);
            if (cVarL.equals(cVar)) {
                break;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i10, cVarL, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return obj;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i2;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarK = cVar.k(new f0.b(0, collection));
            if (q7.k.a(cVarK, cVar)) {
                return false;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i2, cVarK, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return r.g(this, new f0.b(2, collection));
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        int i10;
        f0.c cVar;
        f fVarK;
        boolean zB;
        Object obj2 = get(i2);
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i10 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarM = cVar.m(i2, obj);
            if (cVarM.equals(cVar)) {
                break;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i10, cVarM, false);
            }
            m.n(fVarK, this);
        } while (!zB);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return r.d(this).f5809c.a();
    }

    @Override // java.util.List
    public final List subList(int i2, int i10) {
        if (!(i2 >= 0 && i2 <= i10 && i10 <= size())) {
            u1.a("fromIndex or toIndex are out of bounds");
        }
        return new y(this, i2, i10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return q7.j.a(this);
    }

    public final String toString() {
        u uVar = this.f5785f;
        q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((u) m.i(uVar)).f5809c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        f0.c cVar = r.d(this).f5809c;
        int iA = cVar.a();
        parcel.writeInt(iA);
        for (int i10 = 0; i10 < iA; i10++) {
            parcel.writeValue(cVar.get(i10));
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i2;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarI = cVar.i(collection);
            if (q7.k.a(cVarI, cVar)) {
                return false;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i2, cVarI, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        return new e7.a(this, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return q7.j.b(this, objArr);
    }

    public q() {
        this(f0.j.f3351g);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        int i10;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i10 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            f0.c cVarF = cVar.f(i2, obj);
            if (cVarF.equals(cVar)) {
                return;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i10, cVarF, true);
            }
            m.n(fVarK, this);
        } while (!zB);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i2;
        f0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f5786a) {
                u uVar = this.f5785f;
                q7.k.c(uVar, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                u uVar2 = (u) m.i(uVar);
                i2 = uVar2.f5810d;
                cVar = uVar2.f5809c;
            }
            q7.k.b(cVar);
            int iIndexOf = cVar.indexOf(obj);
            f0.c cVarL = iIndexOf != -1 ? cVar.l(iIndexOf) : cVar;
            if (cVarL.equals(cVar)) {
                return false;
            }
            u uVar3 = this.f5785f;
            q7.k.c(uVar3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            synchronized (m.f5774c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i2, cVarL, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }
}
