package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements Collection, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f21093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21094b;

    public h(Object[] r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "values");
        this.f21093a = r10;
        this.f21094b = r11;
    }

    public int a() {
        return this.f21093a.length;
    }

    @Override // java.util.Collection
    public boolean add(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object r10) {
        return n.o(this.f21093a, r10);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection r10) {
        kotlin.jvm.internal.q.g(r10, "elements");
        Collection r11 = r10;
        if (r11.isEmpty() == true) goto L15;
        Iterator r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L16;
        if (contains(r12.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        if (this.f21093a.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return kotlin.jvm.internal.h.a(this.f21093a);
    }

    @Override // java.util.Collection
    public boolean remove(Object r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] r10) {
        kotlin.jvm.internal.q.g(r10, "array");
        return kotlin.jvm.internal.m.b(this, r10);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return s.b(this.f21093a, this.f21094b);
    }
}
