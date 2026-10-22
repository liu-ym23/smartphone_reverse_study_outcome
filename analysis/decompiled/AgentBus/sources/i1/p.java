package i1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/* loaded from: classes.dex */
public final class p implements List, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final k.z f4559f = new k.z(16);

    /* renamed from: g, reason: collision with root package name */
    public final k.v f4560g = new k.v(16);

    /* renamed from: h, reason: collision with root package name */
    public int f4561h = -1;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        l.a.d("Index must be between 0 and size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        throw null;
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
            long r0 = i1.l.a(r0, r1, r1)
            int r2 = r7.f4561h
            int r2 = r2 + 1
            int r3 = d7.s.t0(r7)
            if (r2 > r3) goto L44
        L11:
            k.v r4 = r7.f4560g
            if (r2 < 0) goto L3a
            int r5 = r4.f5538b
            if (r2 >= r5) goto L3d
            long[] r4 = r4.f5537a
            r4 = r4[r2]
            int r6 = i1.l.g(r4, r0)
            if (r6 >= 0) goto L24
            r0 = r4
        L24:
            float r4 = i1.l.k(r0)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L34
            boolean r4 = i1.l.p(r0)
            if (r4 == 0) goto L34
            goto L39
        L34:
            if (r2 == r3) goto L39
            int r2 = r2 + 1
            goto L11
        L39:
            return r0
        L3a:
            r4.getClass()
        L3d:
            java.lang.String r7 = "Index must be between 0 and size"
            l.a.d(r7)
            r7 = 0
            throw r7
        L44:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.p.a():long");
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
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
        this.f4561h = -1;
        this.f4559f.c();
        this.f4560g.f5538b = 0;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return (obj instanceof n0.l) && indexOf((n0.l) obj) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((n0.l) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i2, int i10) {
        if (i2 >= i10) {
            return;
        }
        this.f4559f.k(i2, i10);
        k.v vVar = this.f4560g;
        if (i2 >= 0) {
            int i11 = vVar.f5538b;
            if (i2 <= i11 && i10 >= 0 && i10 <= i11) {
                if (i10 < i2) {
                    l.a.c("The end index must be < start index");
                    throw null;
                }
                if (i10 != i2) {
                    if (i10 < i11) {
                        long[] jArr = vVar.f5537a;
                        d7.n.X(jArr, jArr, i2, i10, i11);
                    }
                    vVar.f5538b -= i10 - i2;
                    return;
                }
                return;
            }
        } else {
            vVar.getClass();
        }
        l.a.d("Index must be between 0 and size");
        throw null;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        Object objE = this.f4559f.e(i2);
        q7.k.c(objE, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (n0.l) objE;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof n0.l)) {
            return -1;
        }
        n0.l lVar = (n0.l) obj;
        int iT0 = d7.s.t0(this);
        if (iT0 >= 0) {
            int i2 = 0;
            while (!q7.k.a(this.f4559f.e(i2), lVar)) {
                if (i2 != iT0) {
                    i2++;
                }
            }
            return i2;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f4559f.g();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new e7.a(this, 0, 7);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof n0.l)) {
            return -1;
        }
        n0.l lVar = (n0.l) obj;
        for (int iT0 = d7.s.t0(this); -1 < iT0; iT0--) {
            if (q7.k.a(this.f4559f.e(iT0), lVar)) {
                return iT0;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new e7.a(this, 0, 7);
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
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
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f4559f.f5557b;
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public final List subList(int i2, int i10) {
        return new o(this, i2, i10);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return q7.j.a(this);
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
    public final ListIterator listIterator(int i2) {
        return new e7.a(this, i2, 6);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return q7.j.b(this, objArr);
    }
}
