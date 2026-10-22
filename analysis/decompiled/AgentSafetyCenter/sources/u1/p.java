package u1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements List, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13886c;

    /* renamed from: f, reason: collision with root package name */
    public final int f13887f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ q f13888g;

    public p(q qVar, int i, int i3) {
        this.f13888g = qVar;
        this.f13886c = i;
        this.f13887f = i3;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return (obj instanceof w0.l) && indexOf((w0.l) obj) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((w0.l) it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object objE = this.f13888g.f13903c.e(i + this.f13886c);
        objE.getClass();
        return (w0.l) objE;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof w0.l)) {
            return -1;
        }
        w0.l lVar = (w0.l) obj;
        int i = this.f13886c;
        int i3 = this.f13887f;
        if (i > i3) {
            return -1;
        }
        int i10 = i;
        while (!yb.k.a(this.f13888g.f13903c.e(i10), lVar)) {
            if (i10 == i3) {
                return -1;
            }
            i10++;
        }
        return i10 - i;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        int i = this.f13886c;
        return new lb.a(this.f13888g, i, i, this.f13887f);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof w0.l)) {
            return -1;
        }
        w0.l lVar = (w0.l) obj;
        int i = this.f13887f;
        int i3 = this.f13886c;
        if (i3 > i) {
            return -1;
        }
        while (!yb.k.a(this.f13888g.f13903c.e(i), lVar)) {
            if (i == i3) {
                return -1;
            }
            i--;
        }
        return i - i3;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        int i3 = this.f13886c;
        int i10 = this.f13887f;
        return new lb.a(this.f13888g, i + i3, i3, i10);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final /* bridge */ /* synthetic */ Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f13887f - this.f13886c;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        int i10 = this.f13886c;
        return new p(this.f13888g, i + i10, i10 + i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return yb.j.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return yb.j.b(this, objArr);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        int i = this.f13886c;
        return new lb.a(this.f13888g, i, i, this.f13887f);
    }
}
