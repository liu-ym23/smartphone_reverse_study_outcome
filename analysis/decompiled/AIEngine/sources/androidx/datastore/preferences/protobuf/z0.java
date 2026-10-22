package androidx.datastore.preferences.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class z0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f1906j = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f1907a;

    /* renamed from: b, reason: collision with root package name */
    public List<z0<K, V>.b> f1908b = Collections.EMPTY_LIST;

    /* renamed from: c, reason: collision with root package name */
    public Map<K, V> f1909c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1910d;

    /* renamed from: e, reason: collision with root package name */
    public volatile z0<K, V>.d f1911e;
    public Map<K, V> h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0013a f1912a = new C0013a();

        /* renamed from: b, reason: collision with root package name */
        public static final b f1913b = new b();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.datastore.preferences.protobuf.z0$a$a, reason: collision with other inner class name */
        public static class C0013a implements Iterator<Object> {
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                return a.f1912a;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Map.Entry<K, V>, Comparable<z0<K, V>.b> {

        /* renamed from: a, reason: collision with root package name */
        public final K f1914a;

        /* renamed from: b, reason: collision with root package name */
        public V f1915b;

        public b() {
            throw null;
        }

        public b(K k9, V v3) {
            this.f1914a = k9;
            this.f1915b = v3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f1914a.compareTo(((b) obj).f1914a);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    K k9 = this.f1914a;
                    if (k9 == null ? key == null : k9.equals(key)) {
                        V v3 = this.f1915b;
                        Object value = entry.getValue();
                        if (v3 == null ? value == null : v3.equals(value)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f1914a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f1915b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k9 = this.f1914a;
            int iHashCode = k9 == null ? 0 : k9.hashCode();
            V v3 = this.f1915b;
            return iHashCode ^ (v3 != null ? v3.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            int i10 = z0.f1906j;
            z0.this.b();
            V v7 = this.f1915b;
            this.f1915b = v3;
            return v7;
        }

        public final String toString() {
            return this.f1914a + "=" + this.f1915b;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f1917a = -1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1918b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f1919c;

        public c() {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f1919c == null) {
                this.f1919c = z0.this.f1909c.entrySet().iterator();
            }
            return this.f1919c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i10 = this.f1917a + 1;
            z0 z0Var = z0.this;
            return i10 < z0Var.f1908b.size() || (!z0Var.f1909c.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f1918b = true;
            int i10 = this.f1917a + 1;
            this.f1917a = i10;
            z0 z0Var = z0.this;
            return i10 < z0Var.f1908b.size() ? z0Var.f1908b.get(this.f1917a) : a().next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f1918b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f1918b = false;
            int i10 = z0.f1906j;
            z0 z0Var = z0.this;
            z0Var.b();
            if (this.f1917a >= z0Var.f1908b.size()) {
                a().remove();
                return;
            }
            int i11 = this.f1917a;
            this.f1917a = i11 - 1;
            z0Var.i(i11);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            z0.this.h((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            z0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = z0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            z0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return z0.this.size();
        }
    }

    public z0(int i10) {
        this.f1907a = i10;
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f1909c = map;
        this.h = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(K r5) {
        /*
            r4 = this;
            java.util.List<androidx.datastore.preferences.protobuf.z0<K, V>$b> r0 = r4.f1908b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List<androidx.datastore.preferences.protobuf.z0<K, V>$b> r2 = r4.f1908b
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.z0$b r2 = (androidx.datastore.preferences.protobuf.z0.b) r2
            K extends java.lang.Comparable<K> r2 = r2.f1914a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r4 = -r0
            return r4
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List<androidx.datastore.preferences.protobuf.z0<K, V>$b> r3 = r4.f1908b
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.z0$b r3 = (androidx.datastore.preferences.protobuf.z0.b) r3
            K extends java.lang.Comparable<K> r3 = r3.f1914a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.z0.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f1910d) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry<K, V> c(int i10) {
        return this.f1908b.get(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f1908b.isEmpty()) {
            this.f1908b.clear();
        }
        if (this.f1909c.isEmpty()) {
            return;
        }
        this.f1909c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f1909c.containsKey(comparable);
    }

    public final Iterable<Map.Entry<K, V>> e() {
        return this.f1909c.isEmpty() ? a.f1913b : this.f1909c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.f1911e == null) {
            this.f1911e = new d();
        }
        return this.f1911e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return super.equals(obj);
        }
        z0 z0Var = (z0) obj;
        int size = size();
        if (size == z0Var.size()) {
            int size2 = this.f1908b.size();
            if (size2 != z0Var.f1908b.size()) {
                return ((AbstractSet) entrySet()).equals(z0Var.entrySet());
            }
            for (int i10 = 0; i10 < size2; i10++) {
                if (c(i10).equals(z0Var.c(i10))) {
                }
            }
            if (size2 != size) {
                return this.f1909c.equals(z0Var.f1909c);
            }
            return true;
        }
        return false;
    }

    public final SortedMap<K, V> f() {
        b();
        if (this.f1909c.isEmpty() && !(this.f1909c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1909c = treeMap;
            this.h = treeMap.descendingMap();
        }
        return (SortedMap) this.f1909c;
    }

    public void g() {
        if (this.f1910d) {
            return;
        }
        this.f1909c = this.f1909c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f1909c);
        this.h = this.h.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.h);
        this.f1910d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.f1908b.get(iA).f1915b : this.f1909c.get(comparable);
    }

    public final V h(K k9, V v3) {
        b();
        int iA = a(k9);
        if (iA >= 0) {
            return this.f1908b.get(iA).setValue(v3);
        }
        b();
        boolean zIsEmpty = this.f1908b.isEmpty();
        int i10 = this.f1907a;
        if (zIsEmpty && !(this.f1908b instanceof ArrayList)) {
            this.f1908b = new ArrayList(i10);
        }
        int i11 = -(iA + 1);
        if (i11 >= i10) {
            return f().put(k9, v3);
        }
        if (this.f1908b.size() == i10) {
            z0<K, V>.b bVarRemove = this.f1908b.remove(i10 - 1);
            f().put(bVarRemove.f1914a, bVarRemove.f1915b);
        }
        this.f1908b.add(i11, new b(k9, v3));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f1908b.size();
        int iHashCode = 0;
        for (int i10 = 0; i10 < size; i10++) {
            iHashCode += this.f1908b.get(i10).hashCode();
        }
        return this.f1909c.size() > 0 ? this.f1909c.hashCode() + iHashCode : iHashCode;
    }

    public final V i(int i10) {
        b();
        V v3 = this.f1908b.remove(i10).f1915b;
        if (!this.f1909c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = f().entrySet().iterator();
            List<z0<K, V>.b> list = this.f1908b;
            Map.Entry<K, V> next = it.next();
            list.add(new b(next.getKey(), next.getValue()));
            it.remove();
        }
        return v3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return i(iA);
        }
        if (this.f1909c.isEmpty()) {
            return null;
        }
        return this.f1909c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f1909c.size() + this.f1908b.size();
    }
}
