package E7;

import D7.AbstractC0220l;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class d extends AbstractC0220l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f492a;
    public final MapBuilder b;

    public /* synthetic */ d(MapBuilder mapBuilder, int i) {
        this.f492a = i;
        this.b = mapBuilder;
    }

    @Override // D7.AbstractC0220l, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f492a) {
            case 0:
                Map.Entry element = (Map.Entry) obj;
                k.f(element, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        switch (this.f492a) {
            case 0:
                k.f(elements, "elements");
                throw new UnsupportedOperationException();
            default:
                k.f(elements, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f492a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f492a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry element = (Map.Entry) obj;
                k.f(element, "element");
                return this.b.g(element);
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        switch (this.f492a) {
            case 0:
                k.f(elements, "elements");
                return this.b.f(elements);
            default:
                return super.containsAll(elements);
        }
    }

    @Override // D7.AbstractC0220l
    public final int getSize() {
        switch (this.f492a) {
        }
        return this.b.i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f492a) {
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f492a) {
            case 0:
                MapBuilder mapBuilder = this.b;
                mapBuilder.getClass();
                return new b(mapBuilder, 0);
            default:
                MapBuilder mapBuilder2 = this.b;
                mapBuilder2.getClass();
                return new b(mapBuilder2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f492a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry element = (Map.Entry) obj;
                    k.f(element, "element");
                    MapBuilder mapBuilder = this.b;
                    mapBuilder.getClass();
                    mapBuilder.d();
                    int i = mapBuilder.i(element.getKey());
                    if (i >= 0) {
                        Object[] objArr = mapBuilder.b;
                        k.c(objArr);
                        if (k.b(objArr[i], element.getValue())) {
                            mapBuilder.o(i);
                            break;
                        }
                    }
                }
                break;
            default:
                MapBuilder mapBuilder2 = this.b;
                mapBuilder2.d();
                int i6 = mapBuilder2.i(obj);
                if (i6 >= 0) {
                    mapBuilder2.o(i6);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        switch (this.f492a) {
            case 0:
                k.f(elements, "elements");
                this.b.d();
                break;
            default:
                k.f(elements, "elements");
                this.b.d();
                break;
        }
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        switch (this.f492a) {
            case 0:
                k.f(elements, "elements");
                this.b.d();
                break;
            default:
                k.f(elements, "elements");
                this.b.d();
                break;
        }
        return super.retainAll(elements);
    }
}
