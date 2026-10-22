package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.g;
import mb.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b<E> extends h<E> {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder<E, ?> f10052a;

    public b(MapBuilder<E, ?> mapBuilder) {
        this.f10052a = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> elements) {
        g.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f10052a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f10052a.containsKey(obj);
    }

    @Override // mb.h
    public final int getSize() {
        return this.f10052a.f10034l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f10052a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        MapBuilder<E, ?> mapBuilder = this.f10052a;
        mapBuilder.getClass();
        return new MapBuilder.e(mapBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        MapBuilder<E, ?> mapBuilder = this.f10052a;
        mapBuilder.c();
        int i10 = mapBuilder.i(obj);
        if (i10 < 0) {
            return false;
        }
        mapBuilder.m(i10);
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        this.f10052a.c();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        this.f10052a.c();
        return super.retainAll(elements);
    }
}
