package e7;

import g0.l;
import g0.m;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import q7.k;

/* loaded from: classes.dex */
public final class i extends AbstractCollection implements Collection, r7.b {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3114f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3115g;

    public /* synthetic */ i(int i2, Object obj) {
        this.f3114f = i2;
        this.f3115g = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f3114f) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.f3114f) {
            case 0:
                k.e(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f3114f) {
            case 0:
                ((g) this.f3115g).clear();
                break;
            default:
                ((j0.g) this.f3115g).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f3114f) {
            case 0:
                return ((g) this.f3115g).containsValue(obj);
            default:
                return ((j0.g) this.f3115g).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f3114f) {
            case 0:
                return ((g) this.f3115g).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f3114f) {
            case 0:
                g gVar = (g) this.f3115g;
                gVar.getClass();
                return new d(gVar, 2);
            default:
                j0.g gVar2 = (j0.g) this.f3115g;
                l[] lVarArr = new l[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    lVarArr[i2] = new m(2);
                }
                return new g0.g(gVar2, lVarArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f3114f) {
            case 0:
                g gVar = (g) this.f3115g;
                gVar.d();
                int iK = gVar.k(obj);
                if (iK < 0) {
                    return false;
                }
                gVar.n(iK);
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f3114f) {
            case 0:
                k.e(collection, "elements");
                ((g) this.f3115g).d();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f3114f) {
            case 0:
                k.e(collection, "elements");
                ((g) this.f3115g).d();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f3114f) {
            case 0:
                return ((g) this.f3115g).f3107n;
            default:
                return ((j0.g) this.f3115g).size();
        }
    }
}
