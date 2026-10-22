package E7;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c implements Map.Entry, T7.d {

    /* renamed from: a, reason: collision with root package name */
    public final MapBuilder f491a;
    public final int b;
    public final int c;

    public c(MapBuilder map, int i) {
        k.f(map, "map");
        this.f491a = map;
        this.b = i;
        this.c = map.h;
    }

    public final void a() {
        if (this.f491a.h != this.c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return k.b(entry.getKey(), getKey()) && k.b(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f491a.f4900a[this.b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f491a.b;
        k.c(objArr);
        return objArr[this.b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        MapBuilder mapBuilder = this.f491a;
        mapBuilder.d();
        Object[] objArr = mapBuilder.b;
        if (objArr == null) {
            int length = mapBuilder.f4900a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            mapBuilder.b = objArr;
        }
        int i = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
