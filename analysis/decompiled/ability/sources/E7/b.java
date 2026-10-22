package E7;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder f490a;
    public int b;
    public int c;
    public int d;
    public final /* synthetic */ int e;

    public b(MapBuilder map, int i) {
        this.e = i;
        k.f(map, "map");
        this.f490a = map;
        this.c = -1;
        this.d = map.h;
        b();
    }

    public final void a() {
        if (this.f490a.h != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public final void b() {
        while (true) {
            int i = this.b;
            MapBuilder mapBuilder = this.f490a;
            if (i >= mapBuilder.f || mapBuilder.c[i] >= 0) {
                return;
            } else {
                this.b = i + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f490a.f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.e) {
            case 0:
                a();
                int i = this.b;
                MapBuilder mapBuilder = this.f490a;
                if (i >= mapBuilder.f) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                this.c = i;
                c cVar = new c(mapBuilder, i);
                b();
                return cVar;
            case 1:
                a();
                int i6 = this.b;
                MapBuilder mapBuilder2 = this.f490a;
                if (i6 >= mapBuilder2.f) {
                    throw new NoSuchElementException();
                }
                this.b = i6 + 1;
                this.c = i6;
                Object obj = mapBuilder2.f4900a[i6];
                b();
                return obj;
            default:
                a();
                int i10 = this.b;
                MapBuilder mapBuilder3 = this.f490a;
                if (i10 >= mapBuilder3.f) {
                    throw new NoSuchElementException();
                }
                this.b = i10 + 1;
                this.c = i10;
                Object[] objArr = mapBuilder3.b;
                k.c(objArr);
                Object obj2 = objArr[this.c];
                b();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        a();
        if (this.c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        MapBuilder mapBuilder = this.f490a;
        mapBuilder.d();
        mapBuilder.o(this.c);
        this.c = -1;
        this.d = mapBuilder.h;
    }
}
