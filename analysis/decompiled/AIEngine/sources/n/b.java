package n;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public c<K, V> f10573a;

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f10574b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f10575c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public int f10576d = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<K, V> extends e<K, V> {
        @Override // n.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f10580d;
        }

        @Override // n.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f10579c;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: n.b$b, reason: collision with other inner class name */
    public static class C0111b<K, V> extends e<K, V> {
        @Override // n.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.f10579c;
        }

        @Override // n.b.e
        public final c<K, V> c(c<K, V> cVar) {
            return cVar.f10580d;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f10577a;

        /* renamed from: b, reason: collision with root package name */
        public final V f10578b;

        /* renamed from: c, reason: collision with root package name */
        public c<K, V> f10579c;

        /* renamed from: d, reason: collision with root package name */
        public c<K, V> f10580d;

        public c(K k9, V v3) {
            this.f10577a = k9;
            this.f10578b = v3;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f10577a.equals(cVar.f10577a) && this.f10578b.equals(cVar.f10578b);
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f10577a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f10578b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f10578b.hashCode() ^ this.f10577a.hashCode();
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f10577a + "=" + this.f10578b;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f10581a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10582b = true;

        public d() {
        }

        @Override // n.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f10581a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f10580d;
                this.f10581a = cVar3;
                this.f10582b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f10582b) {
                return b.this.f10573a != null;
            }
            c<K, V> cVar = this.f10581a;
            return (cVar == null || cVar.f10579c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f10582b) {
                this.f10582b = false;
                this.f10581a = b.this.f10573a;
            } else {
                c<K, V> cVar = this.f10581a;
                this.f10581a = cVar != null ? cVar.f10579c : null;
            }
            return this.f10581a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f10584a;

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f10585b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f10584a = cVar2;
            this.f10585b = cVar;
        }

        @Override // n.b.f
        public final void a(c<K, V> cVar) {
            c<K, V> cVarC = null;
            if (this.f10584a == cVar && cVar == this.f10585b) {
                this.f10585b = null;
                this.f10584a = null;
            }
            c<K, V> cVar2 = this.f10584a;
            if (cVar2 == cVar) {
                this.f10584a = b(cVar2);
            }
            c<K, V> cVar3 = this.f10585b;
            if (cVar3 == cVar) {
                c<K, V> cVar4 = this.f10584a;
                if (cVar3 != cVar4 && cVar4 != null) {
                    cVarC = c(cVar3);
                }
                this.f10585b = cVarC;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f10585b != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            c<K, V> cVar = this.f10585b;
            c<K, V> cVar2 = this.f10584a;
            this.f10585b = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public c<K, V> a(K k9) {
        c<K, V> cVar = this.f10573a;
        while (cVar != null && !cVar.f10577a.equals(k9)) {
            cVar = cVar.f10579c;
        }
        return cVar;
    }

    public V b(K k9) {
        c<K, V> cVarA = a(k9);
        if (cVarA == null) {
            return null;
        }
        this.f10576d--;
        WeakHashMap<f<K, V>, Boolean> weakHashMap = this.f10575c;
        if (!weakHashMap.isEmpty()) {
            Iterator<f<K, V>> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarA);
            }
        }
        c<K, V> cVar = cVarA.f10580d;
        if (cVar != null) {
            cVar.f10579c = cVarA.f10579c;
        } else {
            this.f10573a = cVarA.f10579c;
        }
        c<K, V> cVar2 = cVarA.f10579c;
        if (cVar2 != null) {
            cVar2.f10580d = cVar;
        } else {
            this.f10574b = cVar;
        }
        cVarA.f10579c = null;
        cVarA.f10580d = null;
        return cVarA.f10578b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r1.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((n.b.e) r6).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof n.b
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            n.b r6 = (n.b) r6
            int r1 = r5.f10576d
            int r3 = r6.f10576d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r5 = r5.iterator()
            java.util.Iterator r6 = r6.iterator()
        L1b:
            r1 = r5
            n.b$e r1 = (n.b.e) r1
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L44
            r3 = r6
            n.b$e r3 = (n.b.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            java.lang.Object r1 = r1.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r3.next()
            if (r1 != 0) goto L3b
            if (r3 != 0) goto L43
        L3b:
            if (r1 == 0) goto L1b
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r5 = r1.hasNext()
            if (r5 != 0) goto L53
            n.b$e r6 = (n.b.e) r6
            boolean r5 = r6.hasNext()
            if (r5 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: n.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) eVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f10573a, this.f10574b);
        this.f10575c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                sb2.append(", ");
            }
        }
    }
}
