package kotlin.reflect.jvm.internal.impl.protobuf;

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
import kotlin.reflect.jvm.internal.impl.protobuf.e;

/* loaded from: classes5.dex */
public class i<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final int f35886a;

    /* renamed from: b, reason: collision with root package name */
    public List<i<K, V>.c> f35887b;

    /* renamed from: c, reason: collision with root package name */
    public Map<K, V> f35888c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f35889d;

    /* renamed from: e, reason: collision with root package name */
    public volatile i<K, V>.e f35890e;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    public static class a<FieldDescriptorType> extends i<FieldDescriptorType, Object> {
        public a(int i10) {
            super(i10, null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i
        public void p() {
            if (!o()) {
                for (int i10 = 0; i10 < l(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> entryJ = j(i10);
                    if (((e.b) entryJ.getKey()).isRepeated()) {
                        entryJ.setValue(Collections.unmodifiableList((List) entryJ.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : m()) {
                    if (((e.b) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.p();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.r((e.b) obj, obj2);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Iterator<Object> f35891a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final Iterable<Object> f35892b = new C0451b();

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

        /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.i$b$b, reason: collision with other inner class name */
        public static class C0451b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f35891a;
            }
        }

        public static <T> Iterable<T> b() {
            return (Iterable<T>) f35892b;
        }
    }

    public class c implements Comparable<i<K, V>.c>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f35893a;

        /* renamed from: b, reason: collision with root package name */
        public V f35894b;

        public c(i iVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(i<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f35893a;
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
            return b(this.f35893a, entry.getKey()) && b(this.f35894b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f35894b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f35893a;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f35894b;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            i.this.h();
            V v11 = this.f35894b;
            this.f35894b = v10;
            return v11;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f35893a);
            String strValueOf2 = String.valueOf(this.f35894b);
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 1 + strValueOf2.length());
            sb2.append(strValueOf);
            sb2.append("=");
            sb2.append(strValueOf2);
            return sb2.toString();
        }

        public c(K k10, V v10) {
            this.f35893a = k10;
            this.f35894b = v10;
        }
    }

    public class e extends AbstractSet<Map.Entry<K, V>> {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            i.this.r(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = i.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d(i.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            i.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }

        public /* synthetic */ e(i iVar, a aVar) {
            this();
        }
    }

    public /* synthetic */ i(int i10, a aVar) {
        this(i10);
    }

    public static <FieldDescriptorType extends e.b<FieldDescriptorType>> i<FieldDescriptorType, Object> q(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f35887b.isEmpty()) {
            this.f35887b.clear();
        }
        if (this.f35888c.isEmpty()) {
            return;
        }
        this.f35888c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return g(comparable) >= 0 || this.f35888c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f35890e == null) {
            this.f35890e = new e(this, null);
        }
        return this.f35890e;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(K r5) {
        /*
            r4 = this;
            java.util.List<kotlin.reflect.jvm.internal.impl.protobuf.i<K, V>$c> r0 = r4.f35887b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List<kotlin.reflect.jvm.internal.impl.protobuf.i<K, V>$c> r2 = r4.f35887b
            java.lang.Object r2 = r2.get(r1)
            kotlin.reflect.jvm.internal.impl.protobuf.i$c r2 = (kotlin.reflect.jvm.internal.impl.protobuf.i.c) r2
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
            java.util.List<kotlin.reflect.jvm.internal.impl.protobuf.i<K, V>$c> r3 = r4.f35887b
            java.lang.Object r3 = r3.get(r2)
            kotlin.reflect.jvm.internal.impl.protobuf.i$c r3 = (kotlin.reflect.jvm.internal.impl.protobuf.i.c) r3
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
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.i.g(java.lang.Comparable):int");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        return iG >= 0 ? this.f35887b.get(iG).getValue() : this.f35888c.get(comparable);
    }

    public final void h() {
        if (this.f35889d) {
            throw new UnsupportedOperationException();
        }
    }

    public final void i() {
        h();
        if (!this.f35887b.isEmpty() || (this.f35887b instanceof ArrayList)) {
            return;
        }
        this.f35887b = new ArrayList(this.f35886a);
    }

    public Map.Entry<K, V> j(int i10) {
        return this.f35887b.get(i10);
    }

    public int l() {
        return this.f35887b.size();
    }

    public Iterable<Map.Entry<K, V>> m() {
        return this.f35888c.isEmpty() ? b.b() : this.f35888c.entrySet();
    }

    public final SortedMap<K, V> n() {
        h();
        if (this.f35888c.isEmpty() && !(this.f35888c instanceof TreeMap)) {
            this.f35888c = new TreeMap();
        }
        return (SortedMap) this.f35888c;
    }

    public boolean o() {
        return this.f35889d;
    }

    public void p() {
        if (this.f35889d) {
            return;
        }
        this.f35888c = this.f35888c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f35888c);
        this.f35889d = true;
    }

    public V r(K k10, V v10) {
        h();
        int iG = g(k10);
        if (iG >= 0) {
            return this.f35887b.get(iG).setValue(v10);
        }
        i();
        int i10 = -(iG + 1);
        if (i10 >= this.f35886a) {
            return n().put(k10, v10);
        }
        int size = this.f35887b.size();
        int i11 = this.f35886a;
        if (size == i11) {
            i<K, V>.c cVarRemove = this.f35887b.remove(i11 - 1);
            n().put(cVarRemove.getKey(), cVarRemove.getValue());
        }
        this.f35887b.add(i10, new c(k10, v10));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iG = g(comparable);
        if (iG >= 0) {
            return s(iG);
        }
        if (this.f35888c.isEmpty()) {
            return null;
        }
        return this.f35888c.remove(comparable);
    }

    public final V s(int i10) {
        h();
        V value = this.f35887b.remove(i10).getValue();
        if (!this.f35888c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = n().entrySet().iterator();
            this.f35887b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f35887b.size() + this.f35888c.size();
    }

    public class d implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f35896a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f35897b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f35898c;

        public d() {
            this.f35896a = -1;
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f35898c == null) {
                this.f35898c = i.this.f35888c.entrySet().iterator();
            }
            return this.f35898c;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f35897b = true;
            int i10 = this.f35896a + 1;
            this.f35896a = i10;
            return i10 < i.this.f35887b.size() ? (Map.Entry) i.this.f35887b.get(this.f35896a) : a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35896a + 1 < i.this.f35887b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f35897b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f35897b = false;
            i.this.h();
            if (this.f35896a >= i.this.f35887b.size()) {
                a().remove();
                return;
            }
            i iVar = i.this;
            int i10 = this.f35896a;
            this.f35896a = i10 - 1;
            iVar.s(i10);
        }

        public /* synthetic */ d(i iVar, a aVar) {
            this();
        }
    }

    public i(int i10) {
        this.f35886a = i10;
        this.f35887b = Collections.EMPTY_LIST;
        this.f35888c = Collections.EMPTY_MAP;
    }
}
