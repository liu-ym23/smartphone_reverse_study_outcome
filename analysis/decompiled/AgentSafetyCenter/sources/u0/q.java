package u0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import k0.q1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements Parcelable, v, List, RandomAccess, zb.b {
    public static final Parcelable.Creator<q> CREATOR = new p(0);

    /* renamed from: c, reason: collision with root package name */
    public u f13687c;

    public q(o0.c cVar) {
        f fVarK = m.k();
        u uVar = new u(fVarK.g(), cVar);
        if (!(fVarK instanceof a)) {
            uVar.f13714b = new u(1, cVar);
        }
        this.f13687c = uVar;
    }

    @Override // u0.v
    public final x a() {
        return this.f13687c;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.c cVarC = cVar.c(obj);
            if (cVarC.equals(cVar)) {
                return false;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i, cVarC, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.c cVarD = cVar.d(collection);
            if (yb.k.a(cVarD, cVar)) {
                return false;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i, cVarD, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    public final void b(int i, int i3) {
        int i10;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i10 = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.f fVarE = cVar.e();
            fVarE.subList(i, i3).clear();
            o0.c cVarC = fVarE.c();
            if (yb.k.a(cVarC, cVar)) {
                return;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i10, cVarC, true);
            }
            m.n(fVarK, this);
        } while (!zB);
    }

    @Override // u0.v
    public final void c(x xVar) {
        xVar.f13714b = this.f13687c;
        this.f13687c = (u) xVar;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        f fVarK;
        u uVar = this.f13687c;
        uVar.getClass();
        synchronized (m.f13676c) {
            fVarK = m.k();
            u uVar2 = (u) m.w(uVar, this, fVarK);
            synchronized (r.f13688a) {
                uVar2.f13709c = o0.i.f8995g;
                uVar2.f13710d++;
                uVar2.f13711e++;
            }
        }
        m.n(fVarK, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return r.e(this).f13709c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return r.e(this).f13709c.containsAll(collection);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return r.e(this).f13709c.get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return r.e(this).f13709c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return r.e(this).f13709c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return r.e(this).f13709c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new lb.a(this, 0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            int iIndexOf = cVar.indexOf(obj);
            o0.c cVarG = iIndexOf != -1 ? cVar.g(iIndexOf) : cVar;
            if (cVarG.equals(cVar)) {
                return false;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i, cVarG, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.b bVar = new o0.b(0);
            bVar.f8977f = collection;
            VarHandle.storeStoreFence();
            o0.c cVarF = cVar.f(bVar);
            if (yb.k.a(cVarF, cVar)) {
                return false;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i, cVarF, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        o0.b bVar = new o0.b(2);
        bVar.f8977f = collection;
        VarHandle.storeStoreFence();
        return r.h(this, bVar);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        int i3;
        o0.c cVar;
        f fVarK;
        boolean zB;
        Object obj2 = get(i);
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i3 = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.c cVarH = cVar.h(i, obj);
            if (cVarH.equals(cVar)) {
                break;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i3, cVarH, false);
            }
            m.n(fVarK, this);
        } while (!zB);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return r.e(this).f13709c.a();
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        if (!(i >= 0 && i <= i3 && i3 <= size())) {
            q1.a("fromIndex or toIndex are out of bounds");
        }
        return new y(this, i, i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return yb.j.a(this);
    }

    public final String toString() {
        u uVar = this.f13687c;
        uVar.getClass();
        return "SnapshotStateList(value=" + ((u) m.i(uVar)).f13709c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        o0.c cVar = r.e(this).f13709c;
        int iA = cVar.a();
        parcel.writeInt(iA);
        for (int i3 = 0; i3 < iA; i3++) {
            parcel.writeValue(cVar.get(i3));
        }
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return yb.j.b(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new lb.a(this, i);
    }

    public q() {
        this(o0.i.f8995g);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        int i3;
        o0.c cVar;
        f fVarK;
        boolean zB;
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i3 = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.c cVarB = cVar.b(i, obj);
            if (cVarB.equals(cVar)) {
                return;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i3, cVarB, true);
            }
            m.n(fVarK, this);
        } while (!zB);
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        o oVar = new o();
        oVar.f13684c = i;
        oVar.f13685f = collection;
        VarHandle.storeStoreFence();
        return r.h(this, oVar);
    }

    @Override // java.util.List
    public final Object remove(int i) {
        int i3;
        o0.c cVar;
        f fVarK;
        boolean zB;
        Object obj = get(i);
        do {
            synchronized (r.f13688a) {
                u uVar = this.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i3 = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.c cVarG = cVar.g(i);
            if (cVarG.equals(cVar)) {
                break;
            }
            u uVar3 = this.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, this, fVarK), i3, cVarG, true);
            }
            m.n(fVarK, this);
        } while (!zB);
        return obj;
    }
}
