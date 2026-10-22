package com.google.gson.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final a f5449l = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Comparator<? super K> f5450a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5451b;

    /* renamed from: c, reason: collision with root package name */
    public e<K, V> f5452c;

    /* renamed from: d, reason: collision with root package name */
    public int f5453d;

    /* renamed from: e, reason: collision with root package name */
    public int f5454e;
    public final e<K, V> h;

    /* renamed from: j, reason: collision with root package name */
    public LinkedTreeMap<K, V>.b f5455j;

    /* renamed from: k, reason: collision with root package name */
    public LinkedTreeMap<K, V>.c f5456k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[RETURN] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean contains(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L29
                com.google.gson.internal.LinkedTreeMap r3 = com.google.gson.internal.LinkedTreeMap.this
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                r2 = 0
                if (r0 == 0) goto L15
                com.google.gson.internal.LinkedTreeMap$e r3 = r3.a(r0, r1)     // Catch: java.lang.ClassCastException -> L15
                goto L16
            L15:
                r3 = r2
            L16:
                if (r3 == 0) goto L25
                V r0 = r3.f5469k
                java.lang.Object r4 = r4.getValue()
                boolean r4 = java.util.Objects.equals(r0, r4)
                if (r4 == 0) goto L25
                r2 = r3
            L25:
                if (r2 == 0) goto L29
                r3 = 1
                return r3
            L29:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.b.contains(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean remove(java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L6
                goto L28
            L6:
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r0 = r5.getKey()
                com.google.gson.internal.LinkedTreeMap r4 = com.google.gson.internal.LinkedTreeMap.this
                r2 = 0
                if (r0 == 0) goto L16
                com.google.gson.internal.LinkedTreeMap$e r0 = r4.a(r0, r1)     // Catch: java.lang.ClassCastException -> L16
                goto L17
            L16:
                r0 = r2
            L17:
                if (r0 == 0) goto L26
                V r3 = r0.f5469k
                java.lang.Object r5 = r5.getValue()
                boolean r5 = java.util.Objects.equals(r3, r5)
                if (r5 == 0) goto L26
                r2 = r0
            L26:
                if (r2 != 0) goto L29
            L28:
                return r1
            L29:
                r5 = 1
                r4.c(r2, r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.b.remove(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.f5453d;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class c extends AbstractSet<K> {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends LinkedTreeMap<K, V>.d<K> {
            @Override // com.google.gson.internal.LinkedTreeMap.d, java.util.Iterator
            public final K next() {
                return a().h;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            e<K, V> eVarA = null;
            if (obj != null) {
                try {
                    eVarA = linkedTreeMap.a(obj, false);
                } catch (ClassCastException unused) {
                }
            }
            if (eVarA != null) {
                linkedTreeMap.c(eVarA, true);
            }
            return eVarA != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.f5453d;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public abstract class d<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public e<K, V> f5459a;

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f5460b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f5461c;

        public d() {
            this.f5459a = LinkedTreeMap.this.h.f5466d;
            this.f5461c = LinkedTreeMap.this.f5454e;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f5459a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.h) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.f5454e != this.f5461c) {
                throw new ConcurrentModificationException();
            }
            this.f5459a = eVar.f5466d;
            this.f5460b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f5459a != LinkedTreeMap.this.h;
        }

        @Override // java.util.Iterator
        public Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f5460b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            linkedTreeMap.c(eVar, true);
            this.f5460b = null;
            this.f5461c = linkedTreeMap.f5454e;
        }
    }

    public LinkedTreeMap() {
        this(true);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }

    public final e<K, V> a(K k9, boolean z) {
        int iCompareTo;
        e<K, V> eVar;
        e<K, V> eVar2 = this.f5452c;
        a aVar = f5449l;
        Comparator<? super K> comparator = this.f5450a;
        if (eVar2 != null) {
            Comparable comparable = comparator == aVar ? (Comparable) k9 : null;
            while (true) {
                K k10 = eVar2.h;
                iCompareTo = comparable != null ? comparable.compareTo(k10) : comparator.compare(k9, k10);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f5464b : eVar2.f5465c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        e<K, V> eVar4 = eVar2;
        if (!z) {
            return null;
        }
        e<K, V> eVar5 = this.h;
        if (eVar4 != null) {
            eVar = new e<>(this.f5451b, eVar4, k9, eVar5, eVar5.f5467e);
            if (iCompareTo < 0) {
                eVar4.f5464b = eVar;
            } else {
                eVar4.f5465c = eVar;
            }
            b(eVar4, true);
        } else {
            if (comparator == aVar && !(k9 instanceof Comparable)) {
                throw new ClassCastException(k9.getClass().getName().concat(" is not Comparable"));
            }
            eVar = new e<>(this.f5451b, eVar4, k9, eVar5, eVar5.f5467e);
            this.f5452c = eVar;
        }
        this.f5453d++;
        this.f5454e++;
        return eVar;
    }

    public final void b(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f5464b;
            e<K, V> eVar3 = eVar.f5465c;
            int i10 = eVar2 != null ? eVar2.f5470l : 0;
            int i11 = eVar3 != null ? eVar3.f5470l : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f5464b;
                e<K, V> eVar5 = eVar3.f5465c;
                int i13 = (eVar4 != null ? eVar4.f5470l : 0) - (eVar5 != null ? eVar5.f5470l : 0);
                if (i13 == -1 || (i13 == 0 && !z)) {
                    f(eVar);
                } else {
                    g(eVar3);
                    f(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f5464b;
                e<K, V> eVar7 = eVar2.f5465c;
                int i14 = (eVar6 != null ? eVar6.f5470l : 0) - (eVar7 != null ? eVar7.f5470l : 0);
                if (i14 == 1 || (i14 == 0 && !z)) {
                    g(eVar);
                } else {
                    f(eVar2);
                    g(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f5470l = i10 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f5470l = Math.max(i10, i11) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f5463a;
        }
    }

    public final void c(e<K, V> eVar, boolean z) {
        e<K, V> eVar2;
        e<K, V> eVar3;
        int i10;
        if (z) {
            e<K, V> eVar4 = eVar.f5467e;
            eVar4.f5466d = eVar.f5466d;
            eVar.f5466d.f5467e = eVar4;
        }
        e<K, V> eVar5 = eVar.f5464b;
        e<K, V> eVar6 = eVar.f5465c;
        e<K, V> eVar7 = eVar.f5463a;
        int i11 = 0;
        if (eVar5 == null || eVar6 == null) {
            if (eVar5 != null) {
                e(eVar, eVar5);
                eVar.f5464b = null;
            } else if (eVar6 != null) {
                e(eVar, eVar6);
                eVar.f5465c = null;
            } else {
                e(eVar, null);
            }
            b(eVar7, false);
            this.f5453d--;
            this.f5454e++;
            return;
        }
        if (eVar5.f5470l > eVar6.f5470l) {
            e<K, V> eVar8 = eVar5.f5465c;
            while (true) {
                e<K, V> eVar9 = eVar8;
                eVar3 = eVar5;
                eVar5 = eVar9;
                if (eVar5 == null) {
                    break;
                } else {
                    eVar8 = eVar5.f5465c;
                }
            }
        } else {
            e<K, V> eVar10 = eVar6.f5464b;
            while (true) {
                eVar2 = eVar6;
                eVar6 = eVar10;
                if (eVar6 == null) {
                    break;
                } else {
                    eVar10 = eVar6.f5464b;
                }
            }
            eVar3 = eVar2;
        }
        c(eVar3, false);
        e<K, V> eVar11 = eVar.f5464b;
        if (eVar11 != null) {
            i10 = eVar11.f5470l;
            eVar3.f5464b = eVar11;
            eVar11.f5463a = eVar3;
            eVar.f5464b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar12 = eVar.f5465c;
        if (eVar12 != null) {
            i11 = eVar12.f5470l;
            eVar3.f5465c = eVar12;
            eVar12.f5463a = eVar3;
            eVar.f5465c = null;
        }
        eVar3.f5470l = Math.max(i10, i11) + 1;
        e(eVar, eVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f5452c = null;
        this.f5453d = 0;
        this.f5454e++;
        e<K, V> eVar = this.h;
        eVar.f5467e = eVar;
        eVar.f5466d = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        e<K, V> eVarA = null;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return eVarA != null;
    }

    public final void e(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f5463a;
        eVar.f5463a = null;
        if (eVar2 != null) {
            eVar2.f5463a = eVar3;
        }
        if (eVar3 == null) {
            this.f5452c = eVar2;
        } else if (eVar3.f5464b == eVar) {
            eVar3.f5464b = eVar2;
        } else {
            eVar3.f5465c = eVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.f5455j;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.f5455j = bVar2;
        return bVar2;
    }

    public final void f(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5464b;
        e<K, V> eVar3 = eVar.f5465c;
        e<K, V> eVar4 = eVar3.f5464b;
        e<K, V> eVar5 = eVar3.f5465c;
        eVar.f5465c = eVar4;
        if (eVar4 != null) {
            eVar4.f5463a = eVar;
        }
        e(eVar, eVar3);
        eVar3.f5464b = eVar;
        eVar.f5463a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f5470l : 0, eVar4 != null ? eVar4.f5470l : 0) + 1;
        eVar.f5470l = iMax;
        eVar3.f5470l = Math.max(iMax, eVar5 != null ? eVar5.f5470l : 0) + 1;
    }

    public final void g(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f5464b;
        e<K, V> eVar3 = eVar.f5465c;
        e<K, V> eVar4 = eVar2.f5464b;
        e<K, V> eVar5 = eVar2.f5465c;
        eVar.f5464b = eVar5;
        if (eVar5 != null) {
            eVar5.f5463a = eVar;
        }
        e(eVar, eVar2);
        eVar2.f5465c = eVar;
        eVar.f5463a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f5470l : 0, eVar5 != null ? eVar5.f5470l : 0) + 1;
        eVar.f5470l = iMax;
        eVar2.f5470l = Math.max(iMax, eVar4 != null ? eVar4.f5470l : 0) + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        e<K, V> eVarA;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        if (eVarA != null) {
            return eVarA.f5469k;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.f5456k;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.f5456k = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k9, V v3) {
        if (k9 == null) {
            throw new NullPointerException("key == null");
        }
        if (v3 == null && !this.f5451b) {
            throw new NullPointerException("value == null");
        }
        e<K, V> eVarA = a(k9, true);
        V v7 = eVarA.f5469k;
        eVarA.f5469k = v3;
        return v7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        e<K, V> eVarA;
        if (obj != 0) {
            try {
                eVarA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            eVarA = null;
        }
        if (eVarA != null) {
            c(eVarA, true);
        }
        if (eVarA != null) {
            return eVarA.f5469k;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5453d;
    }

    public LinkedTreeMap(boolean z) {
        this.f5453d = 0;
        this.f5454e = 0;
        this.f5450a = f5449l;
        this.f5451b = z;
        this.h = new e<>(z);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public e<K, V> f5463a;

        /* renamed from: b, reason: collision with root package name */
        public e<K, V> f5464b;

        /* renamed from: c, reason: collision with root package name */
        public e<K, V> f5465c;

        /* renamed from: d, reason: collision with root package name */
        public e<K, V> f5466d;

        /* renamed from: e, reason: collision with root package name */
        public e<K, V> f5467e;
        public final K h;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f5468j;

        /* renamed from: k, reason: collision with root package name */
        public V f5469k;

        /* renamed from: l, reason: collision with root package name */
        public int f5470l;

        public e(boolean z) {
            this.h = null;
            this.f5468j = z;
            this.f5467e = this;
            this.f5466d = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                K k9 = this.h;
                if (k9 != null ? k9.equals(entry.getKey()) : entry.getKey() == null) {
                    V v3 = this.f5469k;
                    if (v3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (v3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f5469k;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k9 = this.h;
            int iHashCode = k9 == null ? 0 : k9.hashCode();
            V v3 = this.f5469k;
            return iHashCode ^ (v3 != null ? v3.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            if (v3 == null && !this.f5468j) {
                throw new NullPointerException("value == null");
            }
            V v7 = this.f5469k;
            this.f5469k = v3;
            return v7;
        }

        public final String toString() {
            return this.h + "=" + this.f5469k;
        }

        public e(boolean z, e<K, V> eVar, K k9, e<K, V> eVar2, e<K, V> eVar3) {
            this.f5463a = eVar;
            this.h = k9;
            this.f5468j = z;
            this.f5470l = 1;
            this.f5466d = eVar2;
            this.f5467e = eVar3;
            eVar3.f5466d = this;
            eVar2.f5467e = this;
        }
    }
}
