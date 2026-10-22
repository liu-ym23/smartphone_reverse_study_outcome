package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.g;
import mb.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SetBuilder<E> extends h<E> implements Set<E>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final SetBuilder f10049b;

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder<E, ?> f10050a;

    static {
        MapBuilder mapBuilder = MapBuilder.f10026q;
        f10049b = new SetBuilder(MapBuilder.f10026q);
    }

    public SetBuilder(MapBuilder<E, ?> backing) {
        g.f(backing, "backing");
        this.f10050a = backing;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f10050a.f10038p) {
            return new SerializedCollection(1, this);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e10) {
        return this.f10050a.a(e10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> elements) {
        g.f(elements, "elements");
        this.f10050a.c();
        return super.addAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f10050a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f10050a.containsKey(obj);
    }

    @Override // mb.h
    public final int getSize() {
        return this.f10050a.f10034l;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f10050a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        MapBuilder<E, ?> mapBuilder = this.f10050a;
        mapBuilder.getClass();
        return new MapBuilder.e(mapBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        MapBuilder<E, ?> mapBuilder = this.f10050a;
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
        this.f10050a.c();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<? extends Object> elements) {
        g.f(elements, "elements");
        this.f10050a.c();
        return super.retainAll(elements);
    }

    public SetBuilder() {
        this(new MapBuilder());
    }
}
