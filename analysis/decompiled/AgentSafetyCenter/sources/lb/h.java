package lb;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import p0.k;
import p0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends AbstractCollection implements Collection, zb.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7852c;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7853f;

    public /* synthetic */ h(Object obj, int i) {
        this.f7852c = i;
        this.f7853f = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f7852c) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        switch (this.f7852c) {
            case 0:
                collection.getClass();
                throw new UnsupportedOperationException();
            default:
                return super.addAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f7852c) {
            case 0:
                ((f) this.f7853f).clear();
                break;
            default:
                ((s0.f) this.f7853f).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f7852c) {
            case 0:
                return ((f) this.f7853f).containsValue(obj);
            default:
                return ((s0.f) this.f7853f).containsValue(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f7852c) {
            case 0:
                return ((f) this.f7853f).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f7852c) {
            case 0:
                f fVar = (f) this.f7853f;
                fVar.getClass();
                return new d(fVar, 2);
            default:
                s0.f fVar2 = (s0.f) this.f7853f;
                k[] kVarArr = new k[8];
                for (int i = 0; i < 8; i++) {
                    kVarArr[i] = new l(2);
                }
                return new p0.f(fVar2, kVarArr);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        switch (this.f7852c) {
            case 0:
                f fVar = (f) this.f7853f;
                fVar.c();
                int iH = fVar.h(obj);
                if (iH < 0) {
                    return false;
                }
                fVar.k(iH);
                return true;
            default:
                return super.remove(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        switch (this.f7852c) {
            case 0:
                collection.getClass();
                ((f) this.f7853f).c();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        switch (this.f7852c) {
            case 0:
                collection.getClass();
                ((f) this.f7853f).c();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        switch (this.f7852c) {
            case 0:
                return ((f) this.f7853f).f7845m;
            default:
                return ((s0.f) this.f7853f).i;
        }
    }
}
