package l;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: l.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4854b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public c<K, V> f36855a;

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f36856b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f36857c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public int f36858d = 0;

    /* renamed from: l.b$a */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.C4854b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f36862d;
        }

        @Override // l.C4854b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f36861c;
        }
    }

    /* renamed from: l.b$b, reason: collision with other inner class name */
    public static class C0466b<K, V> extends e<K, V> {
        public C0466b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.C4854b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f36861c;
        }

        @Override // l.C4854b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f36862d;
        }
    }

    /* renamed from: l.b$c */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f36859a;

        /* renamed from: b, reason: collision with root package name */
        public final V f36860b;

        /* renamed from: c, reason: collision with root package name */
        public c<K, V> f36861c;

        /* renamed from: d, reason: collision with root package name */
        public c<K, V> f36862d;

        public c(K k10, V v10) {
            this.f36859a = k10;
            this.f36860b = v10;
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
            return this.f36859a.equals(cVar.f36859a) && this.f36860b.equals(cVar.f36860b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f36859a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f36860b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f36860b.hashCode() ^ this.f36859a.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f36859a + "=" + this.f36860b;
        }
    }

    /* renamed from: l.b$d */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f36863a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f36864b = true;

        public d() {
        }

        @Override // l.C4854b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f36863a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f36862d;
                this.f36863a = cVar3;
                this.f36864b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f36864b) {
                this.f36864b = false;
                this.f36863a = C4854b.this.f36855a;
            } else {
                c<K, V> cVar = this.f36863a;
                this.f36863a = cVar != null ? cVar.f36861c : null;
            }
            return this.f36863a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f36864b) {
                return C4854b.this.f36855a != null;
            }
            c<K, V> cVar = this.f36863a;
            return (cVar == null || cVar.f36861c == null) ? false : true;
        }
    }

    /* renamed from: l.b$e */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f36866a;

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f36867b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f36866a = cVar2;
            this.f36867b = cVar;
        }

        @Override // l.C4854b.f
        public void a(c<K, V> cVar) {
            if (this.f36866a == cVar && cVar == this.f36867b) {
                this.f36867b = null;
                this.f36866a = null;
            }
            c<K, V> cVar2 = this.f36866a;
            if (cVar2 == cVar) {
                this.f36866a = b(cVar2);
            }
            if (this.f36867b == cVar) {
                this.f36867b = e();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f36867b;
            this.f36867b = e();
            return cVar;
        }

        public final c<K, V> e() {
            c<K, V> cVar = this.f36867b;
            c<K, V> cVar2 = this.f36866a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f36867b != null;
        }
    }

    /* renamed from: l.b$f */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> b() {
        return this.f36855a;
    }

    public c<K, V> c(K k10) {
        c<K, V> cVar = this.f36855a;
        while (cVar != null && !cVar.f36859a.equals(k10)) {
            cVar = cVar.f36861c;
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0466b c0466b = new C0466b(this.f36856b, this.f36855a);
        this.f36857c.put(c0466b, Boolean.FALSE);
        return c0466b;
    }

    public C4854b<K, V>.d e() {
        C4854b<K, V>.d dVar = new d();
        this.f36857c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4854b)) {
            return false;
        }
        C4854b c4854b = (C4854b) obj;
        if (size() != c4854b.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c4854b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry<K, V> f() {
        return this.f36856b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public c<K, V> i(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f36858d++;
        c<K, V> cVar2 = this.f36856b;
        if (cVar2 == null) {
            this.f36855a = cVar;
            this.f36856b = cVar;
            return cVar;
        }
        cVar2.f36861c = cVar;
        cVar.f36862d = cVar2;
        this.f36856b = cVar;
        return cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f36855a, this.f36856b);
        this.f36857c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(K k10, V v10) {
        c<K, V> cVarC = c(k10);
        if (cVarC != null) {
            return cVarC.f36860b;
        }
        i(k10, v10);
        return null;
    }

    public V k(K k10) {
        c<K, V> cVarC = c(k10);
        if (cVarC == null) {
            return null;
        }
        this.f36858d--;
        if (!this.f36857c.isEmpty()) {
            Iterator<f<K, V>> it = this.f36857c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarC);
            }
        }
        c<K, V> cVar = cVarC.f36862d;
        if (cVar != null) {
            cVar.f36861c = cVarC.f36861c;
        } else {
            this.f36855a = cVarC.f36861c;
        }
        c<K, V> cVar2 = cVarC.f36861c;
        if (cVar2 != null) {
            cVar2.f36862d = cVar;
        } else {
            this.f36856b = cVar;
        }
        cVarC.f36861c = null;
        cVarC.f36862d = null;
        return cVarC.f36860b;
    }

    public int size() {
        return this.f36858d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
