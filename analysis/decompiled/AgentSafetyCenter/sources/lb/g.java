package lb;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends kb.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7850c;

    /* renamed from: f, reason: collision with root package name */
    public final f f7851f;

    public /* synthetic */ g(f fVar, int i) {
        this.f7850c = i;
        this.f7851f = fVar;
    }

    @Override // kb.g
    public final int a() {
        switch (this.f7850c) {
        }
        return this.f7851f.f7845m;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f7850c) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i = this.f7850c;
        collection.getClass();
        switch (i) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f7850c) {
            case 0:
                this.f7851f.clear();
                break;
            default:
                this.f7851f.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f7850c) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                f fVar = this.f7851f;
                fVar.getClass();
                int iG = fVar.g(entry.getKey());
                if (iG < 0) {
                    return false;
                }
                Object[] objArr = fVar.f7839f;
                objArr.getClass();
                return k.a(objArr[iG], entry.getValue());
            default:
                return this.f7851f.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f7850c) {
            case 0:
                collection.getClass();
                return this.f7851f.e(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f7850c) {
        }
        return this.f7851f.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f7850c) {
            case 0:
                f fVar = this.f7851f;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f7851f;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f7850c) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f7851f;
                    fVar.getClass();
                    fVar.c();
                    int iG = fVar.g(entry.getKey());
                    if (iG >= 0) {
                        Object[] objArr = fVar.f7839f;
                        objArr.getClass();
                        if (k.a(objArr[iG], entry.getValue())) {
                            fVar.k(iG);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f7851f;
                fVar2.c();
                int iG2 = fVar2.g(obj);
                if (iG2 >= 0) {
                    fVar2.k(iG2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i = this.f7850c;
        collection.getClass();
        switch (i) {
            case 0:
                this.f7851f.c();
                break;
            default:
                this.f7851f.c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i = this.f7850c;
        collection.getClass();
        switch (i) {
            case 0:
                this.f7851f.c();
                break;
            default:
                this.f7851f.c();
                break;
        }
        return super.retainAll(collection);
    }
}
