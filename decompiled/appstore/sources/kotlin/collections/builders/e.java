package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends kotlin.collections.d implements Collection, KMutableCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapBuilder f21088a;

    public e(MapBuilder r10) {
        q.g(r10, "backing");
        this.f21088a = r10;
    }

    @Override // kotlin.collections.d
    public int a() {
        return this.f21088a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection r10) {
        q.g(r10, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f21088a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object r10) {
        return this.f21088a.containsValue(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f21088a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f21088a.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object r10) {
        return this.f21088a.removeValue$kotlin_stdlib(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection r10) {
        q.g(r10, "elements");
        this.f21088a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection r10) {
        q.g(r10, "elements");
        this.f21088a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(r10);
    }
}
