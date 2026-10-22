package u1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q implements List, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final p.a0 f13903c = new p.a0(16);

    /* renamed from: f, reason: collision with root package name */
    public final p.w f13904f = new p.w(16);

    /* renamed from: g, reason: collision with root package name */
    public int f13905g = -1;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        g5.f.q("Index must be between 0 and size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long a() {
        /*
            r7 = this;
            r0 = 2139095040(0x7f800000, float:Infinity)
            r1 = 0
            long r0 = u1.f.a(r0, r1, r1)
            int r2 = r7.f13905g
            int r2 = r2 + 1
            p.a0 r3 = r7.f13903c
            int r3 = r3.f9517b
            int r3 = r3 + (-1)
            if (r2 > r3) goto L46
        L13:
            p.w r4 = r7.f13904f
            if (r2 < 0) goto L3c
            int r5 = r4.f9638b
            if (r2 >= r5) goto L3f
            long[] r4 = r4.f9637a
            r4 = r4[r2]
            int r6 = u1.f.g(r4, r0)
            if (r6 >= 0) goto L26
            r0 = r4
        L26:
            float r4 = u1.f.k(r0)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L36
            boolean r4 = u1.f.p(r0)
            if (r4 == 0) goto L36
            goto L3b
        L36:
            if (r2 == r3) goto L3b
            int r2 = r2 + 1
            goto L13
        L3b:
            return r0
        L3c:
            r4.getClass()
        L3f:
            java.lang.String r7 = "Index must be between 0 and size"
            g5.f.q(r7)
            r0 = 0
        L46:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.q.a():long");
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

    public final void b(int i, int i3) {
        if (i >= i3) {
            return;
        }
        this.f13903c.k(i, i3);
        p.w wVar = this.f13904f;
        if (i >= 0) {
            int i10 = wVar.f9638b;
            if (i <= i10 && i3 >= 0 && i3 <= i10) {
                if (i3 < i) {
                    g5.f.s("The end index must be < start index");
                    return;
                } else {
                    if (i3 != i) {
                        if (i3 < i10) {
                            long[] jArr = wVar.f9637a;
                            kb.k.h0(jArr, jArr, i, i3, i10);
                        }
                        wVar.f9638b -= i3 - i;
                        return;
                    }
                    return;
                }
            }
        } else {
            wVar.getClass();
        }
        g5.f.q("Index must be between 0 and size");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f13905g = -1;
        this.f13903c.c();
        this.f13904f.f9638b = 0;
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
        Object objE = this.f13903c.e(i);
        objE.getClass();
        return (w0.l) objE;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof w0.l)) {
            return -1;
        }
        w0.l lVar = (w0.l) obj;
        int size = size() - 1;
        if (size >= 0) {
            int i = 0;
            while (!yb.k.a(this.f13903c.e(i), lVar)) {
                if (i != size) {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f13903c.g();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new lb.a(this, 0, 7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof w0.l)) {
            return -1;
        }
        w0.l lVar = (w0.l) obj;
        for (int size = size() - 1; -1 < size; size--) {
            if (yb.k.a(this.f13903c.e(size), lVar)) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new lb.a(this, 0, 7);
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
        return this.f13903c.f9517b;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i, int i3) {
        return new p(this, i, i3);
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

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new lb.a(this, i, 6);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
