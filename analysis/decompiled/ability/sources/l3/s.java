package l3;

import java.util.AbstractCollection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class s extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.common.cache.e f5281a;

    public s(com.google.common.cache.e eVar) {
        this.f5281a = eVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f5281a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f5281a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f5281a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new k(this.f5281a, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f5281a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return com.google.common.cache.e.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return com.google.common.cache.e.a(this).toArray(objArr);
    }
}
