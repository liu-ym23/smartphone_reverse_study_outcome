package C1;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: h, reason: collision with root package name */
    private static final Comparator<Comparable> f567h = new a();

    /* renamed from: a, reason: collision with root package name */
    Comparator<? super K> f568a;

    /* renamed from: b, reason: collision with root package name */
    e<K, V> f569b;

    /* renamed from: c, reason: collision with root package name */
    int f570c;

    /* renamed from: d, reason: collision with root package name */
    int f571d;

    /* renamed from: e, reason: collision with root package name */
    final e<K, V> f572e;

    /* renamed from: f, reason: collision with root package name */
    private h<K, V>.b f573f;

    /* renamed from: g, reason: collision with root package name */
    private h<K, V>.c f574g;

    static class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends h<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = h.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f570c;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends h<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f588f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f570c;
        }
    }

    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f579a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f580b = null;

        /* renamed from: c, reason: collision with root package name */
        int f581c;

        d() {
            this.f579a = h.this.f572e.f586d;
            this.f581c = h.this.f571d;
        }

        final e<K, V> b() {
            e<K, V> eVar = this.f579a;
            h hVar = h.this;
            if (eVar == hVar.f572e) {
                throw new NoSuchElementException();
            }
            if (hVar.f571d != this.f581c) {
                throw new ConcurrentModificationException();
            }
            this.f579a = eVar.f586d;
            this.f580b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f579a != h.this.f572e;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f580b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            h.this.f(eVar, true);
            this.f580b = null;
            this.f581c = h.this.f571d;
        }
    }

    public h() {
        this(f567h);
    }

    private boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private void e(e<K, V> eVar, boolean z5) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f584b;
            e<K, V> eVar3 = eVar.f585c;
            int i5 = eVar2 != null ? eVar2.f590h : 0;
            int i6 = eVar3 != null ? eVar3.f590h : 0;
            int i7 = i5 - i6;
            if (i7 == -2) {
                e<K, V> eVar4 = eVar3.f584b;
                e<K, V> eVar5 = eVar3.f585c;
                int i8 = (eVar4 != null ? eVar4.f590h : 0) - (eVar5 != null ? eVar5.f590h : 0);
                if (i8 == -1 || (i8 == 0 && !z5)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z5) {
                    return;
                }
            } else if (i7 == 2) {
                e<K, V> eVar6 = eVar2.f584b;
                e<K, V> eVar7 = eVar2.f585c;
                int i9 = (eVar6 != null ? eVar6.f590h : 0) - (eVar7 != null ? eVar7.f590h : 0);
                if (i9 == 1 || (i9 == 0 && !z5)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z5) {
                    return;
                }
            } else if (i7 == 0) {
                eVar.f590h = i5 + 1;
                if (z5) {
                    return;
                }
            } else {
                eVar.f590h = Math.max(i5, i6) + 1;
                if (!z5) {
                    return;
                }
            }
            eVar = eVar.f583a;
        }
    }

    private void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f583a;
        eVar.f583a = null;
        if (eVar2 != null) {
            eVar2.f583a = eVar3;
        }
        if (eVar3 == null) {
            this.f569b = eVar2;
        } else if (eVar3.f584b == eVar) {
            eVar3.f584b = eVar2;
        } else {
            eVar3.f585c = eVar2;
        }
    }

    private void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f584b;
        e<K, V> eVar3 = eVar.f585c;
        e<K, V> eVar4 = eVar3.f584b;
        e<K, V> eVar5 = eVar3.f585c;
        eVar.f585c = eVar4;
        if (eVar4 != null) {
            eVar4.f583a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f584b = eVar;
        eVar.f583a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f590h : 0, eVar4 != null ? eVar4.f590h : 0) + 1;
        eVar.f590h = iMax;
        eVar3.f590h = Math.max(iMax, eVar5 != null ? eVar5.f590h : 0) + 1;
    }

    private void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f584b;
        e<K, V> eVar3 = eVar.f585c;
        e<K, V> eVar4 = eVar2.f584b;
        e<K, V> eVar5 = eVar2.f585c;
        eVar.f584b = eVar5;
        if (eVar5 != null) {
            eVar5.f583a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f585c = eVar;
        eVar.f583a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f590h : 0, eVar5 != null ? eVar5.f590h : 0) + 1;
        eVar.f590h = iMax;
        eVar2.f590h = Math.max(iMax, eVar4 != null ? eVar4.f590h : 0) + 1;
    }

    e<K, V> b(K k5, boolean z5) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f568a;
        e<K, V> eVar2 = this.f569b;
        if (eVar2 != null) {
            Comparable comparable = comparator == f567h ? (Comparable) k5 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f588f) : comparator.compare(k5, eVar2.f588f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f584b : eVar2.f585c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z5) {
            return null;
        }
        e<K, V> eVar4 = this.f572e;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k5, eVar4, eVar4.f587e);
            if (iCompareTo < 0) {
                eVar2.f584b = eVar;
            } else {
                eVar2.f585c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f567h && !(k5 instanceof Comparable)) {
                throw new ClassCastException(k5.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k5, eVar4, eVar4.f587e);
            this.f569b = eVar;
        }
        this.f570c++;
        this.f571d++;
        return eVar;
    }

    e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD == null || !a(eVarD.f589g, entry.getValue())) {
            return null;
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f569b = null;
        this.f570c = 0;
        this.f571d++;
        e<K, V> eVar = this.f572e;
        eVar.f587e = eVar;
        eVar.f586d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> d(Object obj) {
        if (obj != 0) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.b bVar = this.f573f;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.f573f = bVar2;
        return bVar2;
    }

    void f(e<K, V> eVar, boolean z5) {
        int i5;
        if (z5) {
            e<K, V> eVar2 = eVar.f587e;
            eVar2.f586d = eVar.f586d;
            eVar.f586d.f587e = eVar2;
        }
        e<K, V> eVar3 = eVar.f584b;
        e<K, V> eVar4 = eVar.f585c;
        e<K, V> eVar5 = eVar.f583a;
        int i6 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f584b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f585c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f570c--;
            this.f571d++;
            return;
        }
        e<K, V> eVarB = eVar3.f590h > eVar4.f590h ? eVar3.b() : eVar4.a();
        f(eVarB, false);
        e<K, V> eVar6 = eVar.f584b;
        if (eVar6 != null) {
            i5 = eVar6.f590h;
            eVarB.f584b = eVar6;
            eVar6.f583a = eVarB;
            eVar.f584b = null;
        } else {
            i5 = 0;
        }
        e<K, V> eVar7 = eVar.f585c;
        if (eVar7 != null) {
            i6 = eVar7.f590h;
            eVarB.f585c = eVar7;
            eVar7.f583a = eVarB;
            eVar.f585c = null;
        }
        eVarB.f590h = Math.max(i5, i6) + 1;
        h(eVar, eVarB);
    }

    e<K, V> g(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f589g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.c cVar = this.f574g;
        if (cVar != null) {
            return cVar;
        }
        h<K, V>.c cVar2 = new c();
        this.f574g = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k5, V v5) {
        if (k5 == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> eVarB = b(k5, true);
        V v6 = eVarB.f589g;
        eVarB.f589g = v5;
        return v6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f589g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f570c;
    }

    public h(Comparator<? super K> comparator) {
        this.f570c = 0;
        this.f571d = 0;
        this.f572e = new e<>();
        this.f568a = comparator == null ? f567h : comparator;
    }

    static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        e<K, V> f583a;

        /* renamed from: b, reason: collision with root package name */
        e<K, V> f584b;

        /* renamed from: c, reason: collision with root package name */
        e<K, V> f585c;

        /* renamed from: d, reason: collision with root package name */
        e<K, V> f586d;

        /* renamed from: e, reason: collision with root package name */
        e<K, V> f587e;

        /* renamed from: f, reason: collision with root package name */
        final K f588f;

        /* renamed from: g, reason: collision with root package name */
        V f589g;

        /* renamed from: h, reason: collision with root package name */
        int f590h;

        e() {
            this.f588f = null;
            this.f587e = this;
            this.f586d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this.f584b;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f584b;
            }
        }

        public e<K, V> b() {
            e<K, V> eVar = this.f585c;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f585c;
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k5 = this.f588f;
                if (k5 != null ? k5.equals(entry.getKey()) : entry.getKey() == null) {
                    V v5 = this.f589g;
                    if (v5 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v5.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f588f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f589g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k5 = this.f588f;
            int iHashCode = k5 == null ? 0 : k5.hashCode();
            V v5 = this.f589g;
            return iHashCode ^ (v5 != null ? v5.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            V v6 = this.f589g;
            this.f589g = v5;
            return v6;
        }

        public String toString() {
            return this.f588f + "=" + this.f589g;
        }

        e(e<K, V> eVar, K k5, e<K, V> eVar2, e<K, V> eVar3) {
            this.f583a = eVar;
            this.f588f = k5;
            this.f590h = 1;
            this.f586d = eVar2;
            this.f587e = eVar3;
            eVar3.f586d = this;
            eVar2.f587e = this;
        }
    }
}
