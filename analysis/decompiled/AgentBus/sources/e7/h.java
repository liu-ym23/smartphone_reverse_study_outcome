package e7;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class h extends d7.j {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3112f;

    /* renamed from: g, reason: collision with root package name */
    public final g f3113g;

    public /* synthetic */ h(g gVar, int i2) {
        this.f3112f = i2;
        this.f3113g = gVar;
    }

    @Override // d7.j
    public final int a() {
        switch (this.f3112f) {
        }
        return this.f3113g.f3107n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f3112f) {
            case 0:
                k.e((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f3112f) {
            case 0:
                k.e(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                k.e(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f3112f) {
            case 0:
                this.f3113g.clear();
                break;
            default:
                this.f3113g.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f3112f) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.f3113g.h((Map.Entry) obj);
            default:
                return this.f3113g.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f3112f) {
            case 0:
                k.e(collection, "elements");
                return this.f3113g.f(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f3112f) {
        }
        return this.f3113g.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3112f) {
            case 0:
                g gVar = this.f3113g;
                gVar.getClass();
                return new d(gVar, 0);
            default:
                g gVar2 = this.f3113g;
                gVar2.getClass();
                return new d(gVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f3112f) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    g gVar = this.f3113g;
                    gVar.getClass();
                    gVar.d();
                    int iJ = gVar.j(entry.getKey());
                    if (iJ >= 0) {
                        Object[] objArr = gVar.f3100g;
                        k.b(objArr);
                        if (k.a(objArr[iJ], entry.getValue())) {
                            gVar.n(iJ);
                            break;
                        }
                    }
                }
                break;
            default:
                g gVar2 = this.f3113g;
                gVar2.d();
                int iJ2 = gVar2.j(obj);
                if (iJ2 >= 0) {
                    gVar2.n(iJ2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.f3112f) {
            case 0:
                k.e(collection, "elements");
                this.f3113g.d();
                break;
            default:
                k.e(collection, "elements");
                this.f3113g.d();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.f3112f) {
            case 0:
                k.e(collection, "elements");
                this.f3113g.d();
                break;
            default:
                k.e(collection, "elements");
                this.f3113g.d();
                break;
        }
        return super.retainAll(collection);
    }
}
