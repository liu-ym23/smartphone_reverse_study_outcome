package n;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: n.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0870b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    c<K, V> f18824a;

    /* renamed from: b, reason: collision with root package name */
    private c<K, V> f18825b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap<f<K, V>, Boolean> f18826c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private int f18827d = 0;

    /* renamed from: n.b$a */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // n.C0870b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f18831d;
        }

        @Override // n.C0870b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f18830c;
        }
    }

    /* renamed from: n.b$b, reason: collision with other inner class name */
    private static class C0226b<K, V> extends e<K, V> {
        C0226b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // n.C0870b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f18830c;
        }

        @Override // n.C0870b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f18831d;
        }
    }

    /* renamed from: n.b$c */
    static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        final K f18828a;

        /* renamed from: b, reason: collision with root package name */
        final V f18829b;

        /* renamed from: c, reason: collision with root package name */
        c<K, V> f18830c;

        /* renamed from: d, reason: collision with root package name */
        c<K, V> f18831d;

        c(K k5, V v5) {
            this.f18828a = k5;
            this.f18829b = v5;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f18828a.equals(cVar.f18828a) && this.f18829b.equals(cVar.f18829b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f18828a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f18829b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f18829b.hashCode() ^ this.f18828a.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v5) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f18828a + "=" + this.f18829b;
        }
    }

    /* renamed from: n.b$d */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private c<K, V> f18832a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f18833b = true;

        d() {
        }

        @Override // n.C0870b.f
        void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f18832a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f18831d;
                this.f18832a = cVar3;
                this.f18833b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f18833b) {
                this.f18833b = false;
                this.f18832a = C0870b.this.f18824a;
            } else {
                c<K, V> cVar = this.f18832a;
                this.f18832a = cVar != null ? cVar.f18830c : null;
            }
            return this.f18832a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f18833b) {
                return C0870b.this.f18824a != null;
            }
            c<K, V> cVar = this.f18832a;
            return (cVar == null || cVar.f18830c == null) ? false : true;
        }
    }

    /* renamed from: n.b$e */
    private static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        c<K, V> f18835a;

        /* renamed from: b, reason: collision with root package name */
        c<K, V> f18836b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f18835a = cVar2;
            this.f18836b = cVar;
        }

        private c<K, V> f() {
            c<K, V> cVar = this.f18836b;
            c<K, V> cVar2 = this.f18835a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // n.C0870b.f
        public void b(c<K, V> cVar) {
            if (this.f18835a == cVar && cVar == this.f18836b) {
                this.f18836b = null;
                this.f18835a = null;
            }
            c<K, V> cVar2 = this.f18835a;
            if (cVar2 == cVar) {
                this.f18835a = c(cVar2);
            }
            if (this.f18836b == cVar) {
                this.f18836b = f();
            }
        }

        abstract c<K, V> c(c<K, V> cVar);

        abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f18836b;
            this.f18836b = f();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18836b != null;
        }
    }

    /* renamed from: n.b$f */
    public static abstract class f<K, V> {
        abstract void b(c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f18824a;
    }

    protected c<K, V> c(K k5) {
        c<K, V> cVar = this.f18824a;
        while (cVar != null && !cVar.f18828a.equals(k5)) {
            cVar = cVar.f18830c;
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0226b c0226b = new C0226b(this.f18825b, this.f18824a);
        this.f18826c.put(c0226b, Boolean.FALSE);
        return c0226b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0870b)) {
            return false;
        }
        C0870b c0870b = (C0870b) obj;
        if (size() != c0870b.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c0870b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public C0870b<K, V>.d f() {
        C0870b<K, V>.d dVar = new d();
        this.f18826c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> h() {
        return this.f18825b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    c<K, V> i(K k5, V v5) {
        c<K, V> cVar = new c<>(k5, v5);
        this.f18827d++;
        c<K, V> cVar2 = this.f18825b;
        if (cVar2 == null) {
            this.f18824a = cVar;
            this.f18825b = cVar;
            return cVar;
        }
        cVar2.f18830c = cVar;
        cVar.f18831d = cVar2;
        this.f18825b = cVar;
        return cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f18824a, this.f18825b);
        this.f18826c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V m(K k5, V v5) {
        c<K, V> cVarC = c(k5);
        if (cVarC != null) {
            return cVarC.f18829b;
        }
        i(k5, v5);
        return null;
    }

    public V n(K k5) {
        c<K, V> cVarC = c(k5);
        if (cVarC == null) {
            return null;
        }
        this.f18827d--;
        if (!this.f18826c.isEmpty()) {
            Iterator<f<K, V>> it = this.f18826c.keySet().iterator();
            while (it.hasNext()) {
                it.next().b(cVarC);
            }
        }
        c<K, V> cVar = cVarC.f18831d;
        if (cVar != null) {
            cVar.f18830c = cVarC.f18830c;
        } else {
            this.f18824a = cVarC.f18830c;
        }
        c<K, V> cVar2 = cVarC.f18830c;
        if (cVar2 != null) {
            cVar2.f18831d = cVar;
        } else {
            this.f18825b = cVar;
        }
        cVarC.f18830c = null;
        cVarC.f18831d = null;
        return cVarC.f18829b;
    }

    public int size() {
        return this.f18827d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
