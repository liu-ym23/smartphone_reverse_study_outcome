package u0;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import k0.q1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements List, zb.b {

    /* renamed from: c, reason: collision with root package name */
    public final q f13715c;

    /* renamed from: f, reason: collision with root package name */
    public final int f13716f;

    /* renamed from: g, reason: collision with root package name */
    public int f13717g;

    /* renamed from: h, reason: collision with root package name */
    public int f13718h;

    public y(q qVar, int i, int i3) {
        this.f13715c = qVar;
        this.f13716f = i;
        this.f13717g = r.f(qVar);
        this.f13718h = i3 - i;
    }

    public final void a() {
        if (r.f(this.f13715c) != this.f13717g) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        a();
        int i = this.f13716f + this.f13718h;
        q qVar = this.f13715c;
        qVar.add(i, obj);
        this.f13718h++;
        this.f13717g = r.f(qVar);
        return true;
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        a();
        int i3 = i + this.f13716f;
        q qVar = this.f13715c;
        boolean zAddAll = qVar.addAll(i3, collection);
        if (zAddAll) {
            this.f13718h = collection.size() + this.f13718h;
            this.f13717g = r.f(qVar);
        }
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        if (this.f13718h > 0) {
            a();
            int i = this.f13718h;
            int i3 = this.f13716f;
            q qVar = this.f13715c;
            qVar.b(i3, i + i3);
            this.f13718h = 0;
            this.f13717g = r.f(qVar);
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
    public final Object get(int i) {
        a();
        r.a(i, this.f13718h);
        return this.f13715c.get(this.f13716f + i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        a();
        int i = this.f13718h;
        int i3 = this.f13716f;
        ec.a it = p5.f.O(i3, i + i3).iterator();
        while (it.f3752h) {
            int iNextInt = it.nextInt();
            if (yb.k.a(obj, this.f13715c.get(iNextInt))) {
                return iNextInt - i3;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f13718h == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        a();
        int i = this.f13718h;
        int i3 = this.f13716f;
        for (int i10 = (i + i3) - 1; i10 >= i3; i10--) {
            if (yb.k.a(obj, this.f13715c.get(i10))) {
                return i10 - i3;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        a();
        yb.s sVar = new yb.s();
        sVar.f16096c = i - 1;
        kb.y yVar = new kb.y(1);
        yVar.f7410f = sVar;
        yVar.f7411g = this;
        VarHandle.storeStoreFence();
        return yVar;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        a();
        int i3 = this.f13716f + i;
        q qVar = this.f13715c;
        Object objRemove = qVar.remove(i3);
        this.f13718h--;
        this.f13717g = r.f(qVar);
        return objRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i;
        o0.c cVar;
        f fVarK;
        boolean zB;
        a();
        q qVar = this.f13715c;
        int i3 = this.f13716f;
        int i10 = this.f13718h + i3;
        int size = qVar.size();
        do {
            synchronized (r.f13688a) {
                u uVar = qVar.f13687c;
                uVar.getClass();
                u uVar2 = (u) m.i(uVar);
                i = uVar2.f13710d;
                cVar = uVar2.f13709c;
            }
            cVar.getClass();
            o0.f fVarE = cVar.e();
            fVarE.subList(i3, i10).retainAll(collection);
            o0.c cVarC = fVarE.c();
            if (yb.k.a(cVarC, cVar)) {
                break;
            }
            u uVar3 = qVar.f13687c;
            uVar3.getClass();
            synchronized (m.f13676c) {
                fVarK = m.k();
                zB = r.b((u) m.w(uVar3, qVar, fVarK), i, cVarC, true);
            }
            m.n(fVarK, qVar);
        } while (!zB);
        int size2 = size - qVar.size();
        if (size2 > 0) {
            this.f13717g = r.f(this.f13715c);
            this.f13718h -= size2;
        }
        return size2 > 0;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        r.a(i, this.f13718h);
        a();
        int i3 = i + this.f13716f;
        q qVar = this.f13715c;
        Object obj2 = qVar.set(i3, obj);
        this.f13717g = r.f(qVar);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f13718h;
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        if (i < 0 || i > i3 || i3 > this.f13718h) {
            q1.a("fromIndex or toIndex are out of bounds");
        }
        a();
        int i10 = this.f13716f;
        return new y(this.f13715c, i + i10, i3 + i10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return yb.j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return yb.j.b(this, objArr);
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

    @Override // java.util.List
    public final void add(int i, Object obj) {
        a();
        int i3 = this.f13716f + i;
        q qVar = this.f13715c;
        qVar.add(i3, obj);
        this.f13718h++;
        this.f13717g = r.f(qVar);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        return addAll(this.f13718h, collection);
    }
}
