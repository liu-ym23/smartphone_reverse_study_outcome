package p;

import java.lang.invoke.VarHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 implements Collection, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9621c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9622f;

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((c0) this.f9622f).a(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((c0) this.f9622f).b();
                return;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f9621c) {
            case 0:
                return ((f0) this.f9622f).d(obj);
            default:
                return ((c0) this.f9622f).c(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f9621c) {
            case 0:
                collection.getClass();
                Collection collection2 = collection;
                if (!collection2.isEmpty()) {
                    Iterator it = collection2.iterator();
                    while (it.hasNext()) {
                        if (!((f0) this.f9622f).d(it.next())) {
                            break;
                        }
                    }
                    break;
                }
                break;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!((c0) this.f9622f).c(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.f9621c) {
            case 0:
                return ((f0) this.f9622f).i();
            default:
                return ((c0) this.f9622f).f9535g == 0;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f9621c) {
            case 0:
                return td.h.A(new m0.g(this, null, 3));
            default:
                c0 c0Var = (c0) this.f9622f;
                e0 e0Var = new e0();
                e0Var.f9547c = c0Var;
                e0Var.f9548f = c0Var;
                VarHandle.storeStoreFence();
                return e0Var.iterator();
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((c0) this.f9622f).g(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((c0) this.f9622f).g(collection);
        }
    }

    @Override // java.util.Collection
    public final boolean removeIf(Predicate predicate) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f9621c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                return ((c0) this.f9622f).i(collection);
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.f9621c) {
            case 0:
                return ((f0) this.f9622f).f9556e;
            default:
                return ((c0) this.f9622f).f9535g;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f9621c) {
            case 0:
                objArr.getClass();
                break;
        }
        return yb.j.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.f9621c) {
        }
        return yb.j.a(this);
    }
}
