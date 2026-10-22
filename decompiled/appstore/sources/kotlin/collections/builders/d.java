package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.g;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends g implements Set, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapBuilder f21087a;

    public d(MapBuilder r10) {
        q.g(r10, "backing");
        this.f21087a = r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection r10) {
        q.g(r10, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f21087a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        return this.f21087a.containsKey(r10);
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.f21087a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f21087a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f21087a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object r10) {
        if (this.f21087a.removeKey$kotlin_stdlib(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection r10) {
        q.g(r10, "elements");
        this.f21087a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r10) {
        q.g(r10, "elements");
        this.f21087a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(r10);
    }
}
