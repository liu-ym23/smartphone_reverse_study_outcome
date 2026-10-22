package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ArrayMap extends SimpleArrayMap implements Map {

    @Nullable
    MapCollections mCollections;

    public class a extends MapCollections {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayMap f1179d;

        public a(ArrayMap r10) {
            this.f1179d = r10;
        }

        @Override // androidx.collection.MapCollections
        public void a() {
            this.f1179d.clear();
        }

        @Override // androidx.collection.MapCollections
        public Object b(int r10, int r11) {
            return this.f1179d.mArray[(r10 << 1) + r11];
        }

        @Override // androidx.collection.MapCollections
        public Map c() {
            return this.f1179d;
        }

        @Override // androidx.collection.MapCollections
        public int d() {
            return this.f1179d.mSize;
        }

        @Override // androidx.collection.MapCollections
        public int e(Object r10) {
            return this.f1179d.indexOfKey(r10);
        }

        @Override // androidx.collection.MapCollections
        public int f(Object r10) {
            return this.f1179d.indexOfValue(r10);
        }

        @Override // androidx.collection.MapCollections
        public void g(Object r10, Object r11) {
            this.f1179d.put(r10, r11);
        }

        @Override // androidx.collection.MapCollections
        public void h(int r10) {
            this.f1179d.removeAt(r10);
        }

        @Override // androidx.collection.MapCollections
        public Object i(int r10, Object r11) {
            return this.f1179d.setValueAt(r10, r11);
        }
    }

    public ArrayMap() {
    }

    public boolean containsAll(@NonNull Collection<?> r10) {
        return MapCollections.j(this, r10);
    }

    public final MapCollections d() {
        if (this.mCollections != null) goto L6;
        this.mCollections = new a(this);
    L6:
        return this.mCollections;
    }

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return d().l();
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return d().m();
    }

    @Override // java.util.Map
    public void putAll(Map<Object, Object> r10) {
        ensureCapacity(this.mSize + r10.size());
        Iterator<Map.Entry<Object, Object>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Object, Object> r12 = r11.next();
        put(r12.getKey(), r12.getValue());
        goto L4
    }

    public boolean removeAll(@NonNull Collection<?> r10) {
        return MapCollections.o(this, r10);
    }

    public boolean retainAll(@NonNull Collection<?> r10) {
        return MapCollections.p(this, r10);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return d().n();
    }

    public ArrayMap(int r10) {
        super(r10);
    }

    public ArrayMap(SimpleArrayMap r10) {
        super(r10);
    }
}
