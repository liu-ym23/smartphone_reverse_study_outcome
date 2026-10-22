package E7;

import D7.AbstractC0217i;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class e extends AbstractC0217i {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder f493a;

    public e(MapBuilder mapBuilder) {
        this.f493a = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection elements) {
        k.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f493a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f493a.containsValue(obj);
    }

    @Override // D7.AbstractC0217i
    public final int getSize() {
        return this.f493a.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f493a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        MapBuilder mapBuilder = this.f493a;
        mapBuilder.getClass();
        return new b(mapBuilder, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        MapBuilder mapBuilder = this.f493a;
        mapBuilder.d();
        int iJ = mapBuilder.j(obj);
        if (iJ < 0) {
            return false;
        }
        mapBuilder.o(iJ);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection elements) {
        k.f(elements, "elements");
        this.f493a.d();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection elements) {
        k.f(elements, "elements");
        this.f493a.d();
        return super.retainAll(elements);
    }
}
