package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0500u;
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
class k0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f10065a;

    /* renamed from: b, reason: collision with root package name */
    private List<k0<K, V>.e> f10066b;

    /* renamed from: c, reason: collision with root package name */
    private Map<K, V> f10067c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10068d;

    /* renamed from: e, reason: collision with root package name */
    private volatile k0<K, V>.g f10069e;

    /* renamed from: f, reason: collision with root package name */
    private Map<K, V> f10070f;

    /* renamed from: g, reason: collision with root package name */
    private volatile k0<K, V>.c f10071g;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    static class a<FieldDescriptorType> extends k0<FieldDescriptorType, Object> {
        a(int i5) {
            super(i5, null);
        }

        @Override // androidx.datastore.preferences.protobuf.k0
        public void p() {
            if (!o()) {
                for (int i5 = 0; i5 < k(); i5++) {
                    Map.Entry<FieldDescriptorType, Object> entryJ = j(i5);
                    if (((C0500u.b) entryJ.getKey()).c()) {
                        entryJ.setValue(Collections.unmodifiableList((List) entryJ.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : m()) {
                    if (((C0500u.b) entry.getKey()).c()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.p();
        }

        @Override // androidx.datastore.preferences.protobuf.k0, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((C0500u.b) obj, obj2);
        }
    }

    private class c extends k0<K, V>.g {
        private c() {
            super(k0.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.k0.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(k0.this, null);
        }

        /* synthetic */ c(k0 k0Var, a aVar) {
            this();
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f10076a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f10077b = new b();

        static class a implements Iterator<Object> {
            a() {
            }

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

        static class b implements Iterable<Object> {
            b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f10076a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f10077b;
        }
    }

    private class e implements Map.Entry<K, V>, Comparable<k0<K, V>.e> {

        /* renamed from: a, reason: collision with root package name */
        private final K f10078a;

        /* renamed from: b, reason: collision with root package name */
        private V f10079b;

        e(k0 k0Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean d(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compareTo(k0<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        @Override // java.util.Map.Entry
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f10078a;
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
            return d(this.f10078a, entry.getKey()) && d(this.f10079b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f10079b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k5 = this.f10078a;
            int iHashCode = k5 == null ? 0 : k5.hashCode();
            V v5 = this.f10079b;
            return iHashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            k0.this.g();
            V v6 = this.f10079b;
            this.f10079b = v5;
            return v6;
        }

        public String toString() {
            return this.f10078a + "=" + this.f10079b;
        }

        e(K k5, V v5) {
            this.f10078a = k5;
            this.f10079b = v5;
        }
    }

    private class g extends AbstractSet<Map.Entry<K, V>> {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            k0.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            k0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = k0.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(k0.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            k0.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k0.this.size();
        }

        /* synthetic */ g(k0 k0Var, a aVar) {
            this();
        }
    }

    /* synthetic */ k0(int i5, a aVar) {
        this(i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int f(K r5) {
        /*
            r4 = this;
            java.util.List<androidx.datastore.preferences.protobuf.k0<K, V>$e> r0 = r4.f10066b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List<androidx.datastore.preferences.protobuf.k0<K, V>$e> r2 = r4.f10066b
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.k0$e r2 = (androidx.datastore.preferences.protobuf.k0.e) r2
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
            java.util.List<androidx.datastore.preferences.protobuf.k0<K, V>$e> r3 = r4.f10066b
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.k0$e r3 = (androidx.datastore.preferences.protobuf.k0.e) r3
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.k0.f(java.lang.Comparable):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f10068d) {
            throw new UnsupportedOperationException();
        }
    }

    private void i() {
        g();
        if (!this.f10066b.isEmpty() || (this.f10066b instanceof ArrayList)) {
            return;
        }
        this.f10066b = new ArrayList(this.f10065a);
    }

    private SortedMap<K, V> n() {
        g();
        if (this.f10067c.isEmpty() && !(this.f10067c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f10067c = treeMap;
            this.f10070f = treeMap.descendingMap();
        }
        return (SortedMap) this.f10067c;
    }

    static <FieldDescriptorType extends C0500u.b<FieldDescriptorType>> k0<FieldDescriptorType, Object> q(int i5) {
        return new a(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V s(int i5) {
        g();
        V value = this.f10066b.remove(i5).getValue();
        if (!this.f10067c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = n().entrySet().iterator();
            this.f10066b.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f10066b.isEmpty()) {
            this.f10066b.clear();
        }
        if (this.f10067c.isEmpty()) {
            return;
        }
        this.f10067c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f10067c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f10069e == null) {
            this.f10069e = new g(this, null);
        }
        return this.f10069e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return super.equals(obj);
        }
        k0 k0Var = (k0) obj;
        int size = size();
        if (size != k0Var.size()) {
            return false;
        }
        int iK = k();
        if (iK != k0Var.k()) {
            return entrySet().equals(k0Var.entrySet());
        }
        for (int i5 = 0; i5 < iK; i5++) {
            if (!j(i5).equals(k0Var.j(i5))) {
                return false;
            }
        }
        if (iK != size) {
            return this.f10067c.equals(k0Var.f10067c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? this.f10066b.get(iF).getValue() : this.f10067c.get(comparable);
    }

    Set<Map.Entry<K, V>> h() {
        if (this.f10071g == null) {
            this.f10071g = new c(this, null);
        }
        return this.f10071g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i5 = 0; i5 < iK; i5++) {
            iHashCode += this.f10066b.get(i5).hashCode();
        }
        return l() > 0 ? iHashCode + this.f10067c.hashCode() : iHashCode;
    }

    public Map.Entry<K, V> j(int i5) {
        return this.f10066b.get(i5);
    }

    public int k() {
        return this.f10066b.size();
    }

    public int l() {
        return this.f10067c.size();
    }

    public Iterable<Map.Entry<K, V>> m() {
        return this.f10067c.isEmpty() ? d.b() : this.f10067c.entrySet();
    }

    public boolean o() {
        return this.f10068d;
    }

    public void p() {
        if (this.f10068d) {
            return;
        }
        this.f10067c = this.f10067c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f10067c);
        this.f10070f = this.f10070f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f10070f);
        this.f10068d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public V put(K k5, V v5) {
        g();
        int iF = f(k5);
        if (iF >= 0) {
            return this.f10066b.get(iF).setValue(v5);
        }
        i();
        int i5 = -(iF + 1);
        if (i5 >= this.f10065a) {
            return n().put(k5, v5);
        }
        int size = this.f10066b.size();
        int i6 = this.f10065a;
        if (size == i6) {
            k0<K, V>.e eVarRemove = this.f10066b.remove(i6 - 1);
            n().put(eVarRemove.getKey(), eVarRemove.getValue());
        }
        this.f10066b.add(i5, new e(k5, v5));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return s(iF);
        }
        if (this.f10067c.isEmpty()) {
            return null;
        }
        return this.f10067c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f10066b.size() + this.f10067c.size();
    }

    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private int f10072a;

        /* renamed from: b, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f10073b;

        private b() {
            this.f10072a = k0.this.f10066b.size();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f10073b == null) {
                this.f10073b = k0.this.f10070f.entrySet().iterator();
            }
            return this.f10073b;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (b().hasNext()) {
                return b().next();
            }
            List list = k0.this.f10066b;
            int i5 = this.f10072a - 1;
            this.f10072a = i5;
            return (Map.Entry) list.get(i5);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i5 = this.f10072a;
            return (i5 > 0 && i5 <= k0.this.f10066b.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(k0 k0Var, a aVar) {
            this();
        }
    }

    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private int f10081a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f10082b;

        /* renamed from: c, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f10083c;

        private f() {
            this.f10081a = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f10083c == null) {
                this.f10083c = k0.this.f10067c.entrySet().iterator();
            }
            return this.f10083c;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f10082b = true;
            int i5 = this.f10081a + 1;
            this.f10081a = i5;
            return i5 < k0.this.f10066b.size() ? (Map.Entry) k0.this.f10066b.get(this.f10081a) : b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10081a + 1 < k0.this.f10066b.size() || (!k0.this.f10067c.isEmpty() && b().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f10082b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f10082b = false;
            k0.this.g();
            if (this.f10081a >= k0.this.f10066b.size()) {
                b().remove();
                return;
            }
            k0 k0Var = k0.this;
            int i5 = this.f10081a;
            this.f10081a = i5 - 1;
            k0Var.s(i5);
        }

        /* synthetic */ f(k0 k0Var, a aVar) {
            this();
        }
    }

    private k0(int i5) {
        this.f10065a = i5;
        this.f10066b = Collections.EMPTY_LIST;
        Map<K, V> map = Collections.EMPTY_MAP;
        this.f10067c = map;
        this.f10070f = map;
    }
}
