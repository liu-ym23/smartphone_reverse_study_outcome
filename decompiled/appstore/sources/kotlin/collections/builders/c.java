package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MapBuilder f21086a;

    public c(MapBuilder r10) {
        q.g(r10, "backing");
        this.f21086a = r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object r10) {
        return d((Map.Entry) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection r10) {
        q.g(r10, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.builders.a
    public boolean b(Map.Entry r10) {
        q.g(r10, "element");
        return this.f21086a.containsEntry$kotlin_stdlib(r10);
    }

    @Override // kotlin.collections.builders.a
    public boolean c(Map.Entry r10) {
        q.g(r10, "element");
        return this.f21086a.removeEntry$kotlin_stdlib(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f21086a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection r10) {
        q.g(r10, "elements");
        return this.f21086a.containsAllEntries$kotlin_stdlib(r10);
    }

    public boolean d(Map.Entry r10) {
        q.g(r10, "element");
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.collections.g
    public int getSize() {
        return this.f21086a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f21086a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f21086a.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection r10) {
        q.g(r10, "elements");
        this.f21086a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection r10) {
        q.g(r10, "elements");
        this.f21086a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(r10);
    }
}
