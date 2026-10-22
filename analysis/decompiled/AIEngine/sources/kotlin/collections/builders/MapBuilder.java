package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.g;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, ac.d {

    /* renamed from: q, reason: collision with root package name */
    public static final MapBuilder f10026q;

    /* renamed from: a, reason: collision with root package name */
    public K[] f10027a;

    /* renamed from: b, reason: collision with root package name */
    public V[] f10028b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f10029c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f10030d;

    /* renamed from: e, reason: collision with root package name */
    public int f10031e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f10032j;

    /* renamed from: k, reason: collision with root package name */
    public int f10033k;

    /* renamed from: l, reason: collision with root package name */
    public int f10034l;

    /* renamed from: m, reason: collision with root package name */
    public kotlin.collections.builders.b<K> f10035m;

    /* renamed from: n, reason: collision with root package name */
    public kotlin.collections.builders.c<V> f10036n;

    /* renamed from: o, reason: collision with root package name */
    public kotlin.collections.builders.a<K, V> f10037o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10038p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, ac.a {
        @Override // java.util.Iterator
        public final Object next() {
            a();
            int i10 = this.f10043b;
            MapBuilder<K, V> mapBuilder = this.f10042a;
            if (i10 >= mapBuilder.h) {
                throw new NoSuchElementException();
            }
            this.f10043b = i10 + 1;
            this.f10044c = i10;
            c cVar = new c(mapBuilder, i10);
            b();
            return cVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<K, V> implements Map.Entry<K, V>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final MapBuilder<K, V> f10039a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10040b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10041c;

        public c(MapBuilder<K, V> map, int i10) {
            g.f(map, "map");
            this.f10039a = map;
            this.f10040b = i10;
            this.f10041c = map.f10033k;
        }

        public final void a() {
            if (this.f10039a.f10033k != this.f10041c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return g.b(entry.getKey(), getKey()) && g.b(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            a();
            return this.f10039a.f10027a[this.f10040b];
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            a();
            V[] vArr = this.f10039a.f10028b;
            g.c(vArr);
            return vArr[this.f10040b];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            a();
            MapBuilder<K, V> mapBuilder = this.f10039a;
            mapBuilder.c();
            V[] vArr = mapBuilder.f10028b;
            if (vArr == null) {
                int length = mapBuilder.f10027a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                vArr = (V[]) new Object[length];
                mapBuilder.f10028b = vArr;
            }
            int i10 = this.f10040b;
            V v7 = vArr[i10];
            vArr[i10] = v3;
            return v7;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final MapBuilder<K, V> f10042a;

        /* renamed from: b, reason: collision with root package name */
        public int f10043b;

        /* renamed from: c, reason: collision with root package name */
        public int f10044c;

        /* renamed from: d, reason: collision with root package name */
        public int f10045d;

        public d(MapBuilder<K, V> map) {
            g.f(map, "map");
            this.f10042a = map;
            this.f10044c = -1;
            this.f10045d = map.f10033k;
            b();
        }

        public final void a() {
            if (this.f10042a.f10033k != this.f10045d) {
                throw new ConcurrentModificationException();
            }
        }

        public final void b() {
            while (true) {
                int i10 = this.f10043b;
                MapBuilder<K, V> mapBuilder = this.f10042a;
                if (i10 >= mapBuilder.h || mapBuilder.f10029c[i10] >= 0) {
                    return;
                } else {
                    this.f10043b = i10 + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.f10043b < this.f10042a.h;
        }

        public final void remove() {
            a();
            if (this.f10044c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            MapBuilder<K, V> mapBuilder = this.f10042a;
            mapBuilder.c();
            mapBuilder.m(this.f10044c);
            this.f10044c = -1;
            this.f10045d = mapBuilder.f10033k;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, ac.a {
        @Override // java.util.Iterator
        public final K next() {
            a();
            int i10 = this.f10043b;
            MapBuilder<K, V> mapBuilder = this.f10042a;
            if (i10 >= mapBuilder.h) {
                throw new NoSuchElementException();
            }
            this.f10043b = i10 + 1;
            this.f10044c = i10;
            K k9 = mapBuilder.f10027a[i10];
            b();
            return k9;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, ac.a {
        @Override // java.util.Iterator
        public final V next() {
            a();
            int i10 = this.f10043b;
            MapBuilder<K, V> mapBuilder = this.f10042a;
            if (i10 >= mapBuilder.h) {
                throw new NoSuchElementException();
            }
            this.f10043b = i10 + 1;
            this.f10044c = i10;
            V[] vArr = mapBuilder.f10028b;
            g.c(vArr);
            V v3 = vArr[this.f10044c];
            b();
            return v3;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.f10038p = true;
        f10026q = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (!this.f10038p) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        SerializedMap serializedMap = new SerializedMap();
        serializedMap.f10048a = this;
        return serializedMap;
    }

    public final int a(K k9) {
        c();
        while (true) {
            int iK = k(k9);
            int i10 = this.f10031e * 2;
            int length = this.f10030d.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int[] iArr = this.f10030d;
                int i12 = iArr[iK];
                if (i12 <= 0) {
                    int i13 = this.h;
                    K[] kArr = this.f10027a;
                    if (i13 < kArr.length) {
                        int i14 = i13 + 1;
                        this.h = i14;
                        kArr[i13] = k9;
                        this.f10029c[i13] = iK;
                        iArr[iK] = i14;
                        this.f10034l++;
                        this.f10033k++;
                        if (i11 > this.f10031e) {
                            this.f10031e = i11;
                        }
                        return i13;
                    }
                    h(1);
                } else {
                    if (g.b(this.f10027a[i12 - 1], k9)) {
                        return -i12;
                    }
                    i11++;
                    if (i11 > i10) {
                        l(this.f10030d.length * 2);
                        break;
                    }
                    iK = iK == 0 ? this.f10030d.length - 1 : iK - 1;
                }
            }
        }
    }

    public final MapBuilder b() {
        c();
        this.f10038p = true;
        if (this.f10034l > 0) {
            return this;
        }
        MapBuilder mapBuilder = f10026q;
        g.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    public final void c() {
        if (this.f10038p) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i10 = this.h - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.f10029c;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.f10030d[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        y.J(this.f10027a, 0, this.h);
        V[] vArr = this.f10028b;
        if (vArr != null) {
            y.J(vArr, 0, this.h);
        }
        this.f10034l = 0;
        this.h = 0;
        this.f10033k++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return i(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return j(obj) >= 0;
    }

    public final void e(boolean z) {
        int i10;
        V[] vArr = this.f10028b;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.h;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.f10029c;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                K[] kArr = this.f10027a;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                if (z) {
                    iArr[i12] = i13;
                    this.f10030d[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        y.J(this.f10027a, i12, i10);
        if (vArr != null) {
            y.J(vArr, i12, this.h);
        }
        this.h = i12;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        kotlin.collections.builders.a<K, V> aVar = this.f10037o;
        if (aVar != null) {
            return aVar;
        }
        kotlin.collections.builders.a<K, V> aVar2 = new kotlin.collections.builders.a<>(this);
        this.f10037o = aVar2;
        return aVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f10034l == map.size() && f(map.entrySet());
    }

    public final boolean f(Collection<?> m6) {
        g.f(m6, "m");
        for (Object obj : m6) {
            if (obj != null) {
                try {
                    if (!g((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean g(Map.Entry<? extends K, ? extends V> entry) {
        g.f(entry, "entry");
        int i10 = i(entry.getKey());
        if (i10 < 0) {
            return false;
        }
        V[] vArr = this.f10028b;
        g.c(vArr);
        return g.b(vArr[i10], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V get(Object obj) {
        int i10 = i(obj);
        if (i10 < 0) {
            return null;
        }
        V[] vArr = this.f10028b;
        g.c(vArr);
        return vArr[i10];
    }

    public final void h(int i10) {
        V[] vArr;
        K[] kArr = this.f10027a;
        int length = kArr.length;
        int i11 = this.h;
        int i12 = length - i11;
        int i13 = i11 - this.f10034l;
        if (i12 < i10 && i12 + i13 >= i10 && i13 >= kArr.length / 4) {
            e(true);
            return;
        }
        int i14 = i11 + i10;
        if (i14 < 0) {
            throw new OutOfMemoryError();
        }
        if (i14 > kArr.length) {
            int length2 = kArr.length;
            int i15 = length2 + (length2 >> 1);
            if (i15 - i14 < 0) {
                i15 = i14;
            }
            if (i15 - 2147483639 > 0) {
                i15 = i14 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            K[] kArr2 = (K[]) Arrays.copyOf(kArr, i15);
            g.e(kArr2, "copyOf(...)");
            this.f10027a = kArr2;
            V[] vArr2 = this.f10028b;
            if (vArr2 != null) {
                vArr = (V[]) Arrays.copyOf(vArr2, i15);
                g.e(vArr, "copyOf(...)");
            } else {
                vArr = null;
            }
            this.f10028b = vArr;
            int[] iArrCopyOf = Arrays.copyOf(this.f10029c, i15);
            g.e(iArrCopyOf, "copyOf(...)");
            this.f10029c = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i15 >= 1 ? i15 : 1) * 3);
            if (iHighestOneBit > this.f10030d.length) {
                l(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        b bVar = new b(this);
        int i10 = 0;
        while (bVar.hasNext()) {
            int i11 = bVar.f10043b;
            MapBuilder<K, V> mapBuilder = bVar.f10042a;
            if (i11 >= mapBuilder.h) {
                throw new NoSuchElementException();
            }
            bVar.f10043b = i11 + 1;
            bVar.f10044c = i11;
            K k9 = mapBuilder.f10027a[i11];
            int iHashCode = k9 != null ? k9.hashCode() : 0;
            V[] vArr = mapBuilder.f10028b;
            g.c(vArr);
            V v3 = vArr[bVar.f10044c];
            int iHashCode2 = v3 != null ? v3.hashCode() : 0;
            bVar.b();
            i10 += iHashCode ^ iHashCode2;
        }
        return i10;
    }

    public final int i(K k9) {
        int iK = k(k9);
        int i10 = this.f10031e;
        while (true) {
            int i11 = this.f10030d[iK];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (g.b(this.f10027a[i12], k9)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iK = iK == 0 ? this.f10030d.length - 1 : iK - 1;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f10034l == 0;
    }

    public final int j(V v3) {
        int i10 = this.h;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f10029c[i10] >= 0) {
                V[] vArr = this.f10028b;
                g.c(vArr);
                if (g.b(vArr[i10], v3)) {
                    return i10;
                }
            }
        }
    }

    public final int k(K k9) {
        return ((k9 != null ? k9.hashCode() : 0) * (-1640531527)) >>> this.f10032j;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        kotlin.collections.builders.b<K> bVar = this.f10035m;
        if (bVar != null) {
            return bVar;
        }
        kotlin.collections.builders.b<K> bVar2 = new kotlin.collections.builders.b<>(this);
        this.f10035m = bVar2;
        return bVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f10029c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
            int r0 = r5.f10033k
            int r0 = r0 + 1
            r5.f10033k = r0
            int r0 = r5.h
            int r1 = r5.f10034l
            r2 = 0
            if (r0 <= r1) goto L10
            r5.e(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f10030d = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f10032j = r6
        L1c:
            int r6 = r5.h
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            K[] r0 = r5.f10027a
            r0 = r0[r2]
            int r0 = r5.k(r0)
            int r1 = r5.f10031e
        L2c:
            int[] r3 = r5.f10030d
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f10029c
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r5.<init>(r6)
            throw r5
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.l(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(int r12) {
        /*
            r11 = this;
            K[] r0 = r11.f10027a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.g.f(r0, r1)
            r1 = 0
            r0[r12] = r1
            V[] r0 = r11.f10028b
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f10029c
            r0 = r0[r12]
            int r1 = r11.f10031e
            int r1 = r1 * 2
            int[] r2 = r11.f10030d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.f10030d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f10031e
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f10030d
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f10030d
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = r2
            goto L65
        L4b:
            K[] r5 = r11.f10027a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.k(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f10030d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f10029c
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f10030d
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f10029c
            r0[r12] = r6
            int r12 = r11.f10034l
            int r12 = r12 + r6
            r11.f10034l = r12
            int r12 = r11.f10033k
            int r12 = r12 + 1
            r11.f10033k = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.m(int):void");
    }

    @Override // java.util.Map
    public final V put(K k9, V v3) {
        c();
        int iA = a(k9);
        V[] vArr = this.f10028b;
        if (vArr == null) {
            int length = this.f10027a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            vArr = (V[]) new Object[length];
            this.f10028b = vArr;
        }
        if (iA >= 0) {
            vArr[iA] = v3;
            return null;
        }
        int i10 = (-iA) - 1;
        V v7 = vArr[i10];
        vArr[i10] = v3;
        return v7;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> from) {
        g.f(from, "from");
        c();
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        h(setEntrySet.size());
        for (Map.Entry<? extends K, ? extends V> entry : setEntrySet) {
            int iA = a(entry.getKey());
            V[] vArr = this.f10028b;
            if (vArr == null) {
                int length = this.f10027a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                vArr = (V[]) new Object[length];
                this.f10028b = vArr;
            }
            if (iA >= 0) {
                vArr[iA] = entry.getValue();
            } else {
                int i10 = (-iA) - 1;
                if (!g.b(entry.getValue(), vArr[i10])) {
                    vArr[i10] = entry.getValue();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final V remove(Object obj) {
        c();
        int i10 = i(obj);
        if (i10 < 0) {
            return null;
        }
        V[] vArr = this.f10028b;
        g.c(vArr);
        V v3 = vArr[i10];
        m(i10);
        return v3;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f10034l;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f10034l * 3) + 2);
        sb2.append("{");
        b bVar = new b(this);
        int i10 = 0;
        while (bVar.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            int i11 = bVar.f10043b;
            MapBuilder<K, V> mapBuilder = bVar.f10042a;
            if (i11 >= mapBuilder.h) {
                throw new NoSuchElementException();
            }
            bVar.f10043b = i11 + 1;
            bVar.f10044c = i11;
            K k9 = mapBuilder.f10027a[i11];
            if (k9 == mapBuilder) {
                sb2.append("(this Map)");
            } else {
                sb2.append(k9);
            }
            sb2.append('=');
            V[] vArr = mapBuilder.f10028b;
            g.c(vArr);
            V v3 = vArr[bVar.f10044c];
            if (v3 == mapBuilder) {
                sb2.append("(this Map)");
            } else {
                sb2.append(v3);
            }
            bVar.b();
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        g.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        kotlin.collections.builders.c<V> cVar = this.f10036n;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.f10036n = cVar2;
        return cVar2;
    }

    public MapBuilder(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        K[] kArr = (K[]) new Object[i10];
        int[] iArr = new int[i10];
        int iHighestOneBit = Integer.highestOneBit((i10 < 1 ? 1 : i10) * 3);
        this.f10027a = kArr;
        this.f10028b = null;
        this.f10029c = iArr;
        this.f10030d = new int[iHighestOneBit];
        this.f10031e = 2;
        this.h = 0;
        this.f10032j = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
