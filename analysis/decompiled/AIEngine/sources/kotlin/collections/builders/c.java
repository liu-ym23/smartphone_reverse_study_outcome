package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.g;
import mb.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<V> extends e<V> {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder<?, V> f10053a;

    public c(MapBuilder<?, V> mapBuilder) {
        this.f10053a = mapBuilder;
    }

    @Override // mb.e
    public final int a() {
        return this.f10053a.f10034l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends V> elements) {
        g.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f10053a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f10053a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f10053a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        MapBuilder<?, V> mapBuilder = this.f10053a;
        mapBuilder.getClass();
        return new MapBuilder.f(mapBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        MapBuilder<?, V> mapBuilder = this.f10053a;
        mapBuilder.c();
        int iJ = mapBuilder.j(obj);
        if (iJ < 0) {
            return false;
        }
        mapBuilder.m(iJ);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        this.f10053a.c();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        this.f10053a.c();
        return super.retainAll(elements);
    }
}
