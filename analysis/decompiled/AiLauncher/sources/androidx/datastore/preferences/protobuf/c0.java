package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1355s;
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

/* loaded from: classes.dex */
public class c0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f13509a;

    /* renamed from: b, reason: collision with root package name */
    public List<c0<K, V>.e> f13510b;

    /* renamed from: c, reason: collision with root package name */
    public Map<K, V> f13511c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13512d;

    /* renamed from: e, reason: collision with root package name */
    public volatile c0<K, V>.g f13513e;

    /* renamed from: f, reason: collision with root package name */
    public Map<K, V> f13514f;

    /* renamed from: g, reason: collision with root package name */
    public volatile c0<K, V>.c f13515g;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    public static class a<FieldDescriptorType> extends c0<FieldDescriptorType, Object> {
        public a(int i10) {
            super(i10, null);
        }

        @Override // androidx.datastore.preferences.protobuf.c0, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((C1355s.b) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.c0
        public void s() {
            if (!r()) {
                for (int i10 = 0; i10 < n(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> entryM = m(i10);
                    if (((C1355s.b) entryM.getKey()).isRepeated()) {
                        entryM.setValue(Collections.unmodifiableList((List) entryM.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : p()) {
                    if (((C1355s.b) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.s();
        }
    }

    public class c extends c0<K, V>.g {
        public c() {
            super(c0.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.c0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(c0.this, null);
        }

        public /* synthetic */ c(c0 c0Var, a aVar) {
            this();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public static final Iterator<Object> f13520a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Iterable<Object> f13521b = new b();

        public static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f13520a;
            }
        }

        public static <T> Iterable<T> b() {
            return (Iterable<T>) f13521b;
        }
    }

    public class e implements Map.Entry<K, V>, Comparable<c0<K, V>.e> {

        /* renamed from: a, reason: collision with root package name */
        public final K f13522a;

        /* renamed from: b, reason: collision with root package name */
        public V f13523b;

        public e(c0 c0Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(c0<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f13522a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f13522a, entry.getKey()) && b(this.f13523b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f13523b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f13522a;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f13523b;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            c0.this.i();
            V v11 = this.f13523b;
            this.f13523b = v10;
            return v11;
        }

        public String toString() {
            return this.f13522a + "=" + this.f13523b;
        }

        public e(K k10, V v10) {
            this.f13522a = k10;
            this.f13523b = v10;
        }
    }

    public class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            c0.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = c0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(c0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            c0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c0.this.size();
        }

        public /* synthetic */ g(c0 c0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ c0(int i10, a aVar) {
        this(i10);
    }

    public static <FieldDescriptorType extends C1355s.b<FieldDescriptorType>> c0<FieldDescriptorType, Object> t(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.f13510b.isEmpty()) {
            this.f13510b.clear();
        }
        if (this.f13511c.isEmpty()) {
            return;
        }
        this.f13511c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return h(comparable) >= 0 || this.f13511c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f13513e == null) {
            this.f13513e = new g(this, null);
        }
        return this.f13513e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return super.equals(obj);
        }
        c0 c0Var = (c0) obj;
        int size = size();
        if (size != c0Var.size()) {
            return false;
        }
        int iN = n();
        if (iN != c0Var.n()) {
            return entrySet().equals(c0Var.entrySet());
        }
        for (int i10 = 0; i10 < iN; i10++) {
            if (!m(i10).equals(c0Var.m(i10))) {
                return false;
            }
        }
        if (iN != size) {
            return this.f13511c.equals(c0Var.f13511c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iH = h(comparable);
        return iH >= 0 ? this.f13510b.get(iH).getValue() : this.f13511c.get(comparable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(K r5) {
        /*
            r4 = this;
            java.util.List<androidx.datastore.preferences.protobuf.c0<K, V>$e> r0 = r4.f13510b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List<androidx.datastore.preferences.protobuf.c0<K, V>$e> r2 = r4.f13510b
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.c0$e r2 = (androidx.datastore.preferences.protobuf.c0.e) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r4 = -r0
            return r4
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List<androidx.datastore.preferences.protobuf.c0<K, V>$e> r3 = r4.f13510b
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.c0$e r3 = (androidx.datastore.preferences.protobuf.c0.e) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.c0.h(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iN = n();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iN; i10++) {
            iHashCode += this.f13510b.get(i10).hashCode();
        }
        return o() > 0 ? iHashCode + this.f13511c.hashCode() : iHashCode;
    }

    public final void i() {
        if (this.f13512d) {
            throw new UnsupportedOperationException();
        }
    }

    public Set<Map.Entry<K, V>> j() {
        if (this.f13515g == null) {
            this.f13515g = new c(this, null);
        }
        return this.f13515g;
    }

    public final void l() {
        i();
        if (!this.f13510b.isEmpty() || (this.f13510b instanceof ArrayList)) {
            return;
        }
        this.f13510b = new ArrayList(this.f13509a);
    }

    public Map.Entry<K, V> m(int i10) {
        return this.f13510b.get(i10);
    }

    public int n() {
        return this.f13510b.size();
    }

    public int o() {
        return this.f13511c.size();
    }

    public Iterable<Map.Entry<K, V>> p() {
        return this.f13511c.isEmpty() ? d.b() : this.f13511c.entrySet();
    }

    public final SortedMap<K, V> q() {
        i();
        if (this.f13511c.isEmpty() && !(this.f13511c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f13511c = treeMap;
            this.f13514f = treeMap.descendingMap();
        }
        return (SortedMap) this.f13511c;
    }

    public boolean r() {
        return this.f13512d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int iH = h(comparable);
        if (iH >= 0) {
            return v(iH);
        }
        if (this.f13511c.isEmpty()) {
            return null;
        }
        return this.f13511c.remove(comparable);
    }

    public void s() {
        if (this.f13512d) {
            return;
        }
        this.f13511c = this.f13511c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f13511c);
        this.f13514f = this.f13514f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f13514f);
        this.f13512d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13510b.size() + this.f13511c.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public V put(K k10, V v10) {
        i();
        int iH = h(k10);
        if (iH >= 0) {
            return this.f13510b.get(iH).setValue(v10);
        }
        l();
        int i10 = -(iH + 1);
        if (i10 >= this.f13509a) {
            return q().put(k10, v10);
        }
        int size = this.f13510b.size();
        int i11 = this.f13509a;
        if (size == i11) {
            c0<K, V>.e eVarRemove = this.f13510b.remove(i11 - 1);
            q().put(eVarRemove.getKey(), eVarRemove.getValue());
        }
        this.f13510b.add(i10, new e(k10, v10));
        return null;
    }

    public final V v(int i10) {
        i();
        V value = this.f13510b.remove(i10).getValue();
        if (!this.f13511c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = q().entrySet().iterator();
            this.f13510b.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    public class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f13516a;

        /* renamed from: b, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f13517b;

        public b() {
            this.f13516a = c0.this.f13510b.size();
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f13517b == null) {
                this.f13517b = c0.this.f13514f.entrySet().iterator();
            }
            return this.f13517b;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return a().next();
            }
            List list = c0.this.f13510b;
            int i10 = this.f13516a - 1;
            this.f13516a = i10;
            return (Map.Entry) list.get(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f13516a;
            return (i10 > 0 && i10 <= c0.this.f13510b.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(c0 c0Var, a aVar) {
            this();
        }
    }

    public class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f13525a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13526b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f13527c;

        public f() {
            this.f13525a = -1;
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f13527c == null) {
                this.f13527c = c0.this.f13511c.entrySet().iterator();
            }
            return this.f13527c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f13526b = true;
            int i10 = this.f13525a + 1;
            this.f13525a = i10;
            return i10 < c0.this.f13510b.size() ? (Map.Entry) c0.this.f13510b.get(this.f13525a) : a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13525a + 1 < c0.this.f13510b.size() || (!c0.this.f13511c.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f13526b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f13526b = false;
            c0.this.i();
            if (this.f13525a >= c0.this.f13510b.size()) {
                a().remove();
                return;
            }
            c0 c0Var = c0.this;
            int i10 = this.f13525a;
            this.f13525a = i10 - 1;
            c0Var.v(i10);
        }

        public /* synthetic */ f(c0 c0Var, a aVar) {
            this();
        }
    }

    public c0(int i10) {
        this.f13509a = i10;
        this.f13510b = Collections.EMPTY_LIST;
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f13511c = map;
        this.f13514f = map;
    }
}
