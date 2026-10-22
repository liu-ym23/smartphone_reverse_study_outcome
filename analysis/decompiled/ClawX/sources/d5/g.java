package d5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements Map, Serializable, q5.e {

    /* renamed from: o, reason: collision with root package name */
    public static final g f1833o;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f1834a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1835b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f1836c;
    public int[] d;

    /* renamed from: e, reason: collision with root package name */
    public int f1837e;

    /* renamed from: f, reason: collision with root package name */
    public int f1838f;

    /* renamed from: g, reason: collision with root package name */
    public int f1839g;

    /* renamed from: h, reason: collision with root package name */
    public int f1840h;

    /* renamed from: j, reason: collision with root package name */
    public int f1841j;

    /* renamed from: k, reason: collision with root package name */
    public h f1842k;

    /* renamed from: l, reason: collision with root package name */
    public i f1843l;

    /* renamed from: m, reason: collision with root package name */
    public h f1844m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1845n;

    static {
        g gVar = new g(0);
        gVar.f1845n = true;
        f1833o = gVar;
    }

    public g() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int iJ = j(obj);
            int i8 = this.f1837e * 2;
            int length = this.d.length / 2;
            if (i8 > length) {
                i8 = length;
            }
            int i9 = 0;
            while (true) {
                int[] iArr = this.d;
                int i10 = iArr[iJ];
                if (i10 <= 0) {
                    int i11 = this.f1838f;
                    Object[] objArr = this.f1834a;
                    if (i11 < objArr.length) {
                        int i12 = i11 + 1;
                        this.f1838f = i12;
                        objArr[i11] = obj;
                        this.f1836c[i11] = iJ;
                        iArr[iJ] = i12;
                        this.f1841j++;
                        this.f1840h++;
                        if (i9 > this.f1837e) {
                            this.f1837e = i9;
                        }
                        return i11;
                    }
                    g(1);
                } else {
                    if (p.a(this.f1834a[i10 - 1], obj)) {
                        return -i10;
                    }
                    i9++;
                    if (i9 > i8) {
                        k(this.d.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.d.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final g b() {
        c();
        this.f1845n = true;
        if (this.f1841j > 0) {
            return this;
        }
        g gVar = f1833o;
        p.c(gVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return gVar;
    }

    public final void c() {
        if (this.f1845n) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i8 = this.f1838f - 1;
        if (i8 >= 0) {
            int i9 = 0;
            while (true) {
                int[] iArr = this.f1836c;
                int i10 = iArr[i9];
                if (i10 >= 0) {
                    this.d[i10] = 0;
                    iArr[i9] = -1;
                }
                if (i9 == i8) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        b8.h.K(this.f1834a, 0, this.f1838f);
        Object[] objArr = this.f1835b;
        if (objArr != null) {
            b8.h.K(objArr, 0, this.f1838f);
        }
        this.f1841j = 0;
        this.f1838f = 0;
        this.f1840h++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z) {
        int i8;
        Object[] objArr = this.f1835b;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i8 = this.f1838f;
            if (i9 >= i8) {
                break;
            }
            int[] iArr = this.f1836c;
            int i11 = iArr[i9];
            if (i11 >= 0) {
                Object[] objArr2 = this.f1834a;
                objArr2[i10] = objArr2[i9];
                if (objArr != null) {
                    objArr[i10] = objArr[i9];
                }
                if (z) {
                    iArr[i10] = i11;
                    this.d[i11] = i10 + 1;
                }
                i10++;
            }
            i9++;
        }
        b8.h.K(this.f1834a, i10, i8);
        if (objArr != null) {
            b8.h.K(objArr, i10, this.f1838f);
        }
        this.f1838f = i10;
    }

    public final boolean e(Collection m3) {
        p.e(m3, "m");
        for (Object obj : m3) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        h hVar = this.f1844m;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this, 0);
        this.f1844m = hVar2;
        return hVar2;
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
        return this.f1841j == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        p.e(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.f1835b;
        p.b(objArr);
        return p.a(objArr[iH], entry.getValue());
    }

    public final void g(int i8) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f1834a;
        int length = objArr.length;
        int i9 = this.f1838f;
        int i10 = length - i9;
        int i11 = i9 - this.f1841j;
        if (i10 < i8 && i10 + i11 >= i8 && i11 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i12 = i9 + i8;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        if (i12 > objArr.length) {
            int length2 = objArr.length;
            int i13 = length2 + (length2 >> 1);
            if (i13 - i12 < 0) {
                i13 = i12;
            }
            if (i13 - 2147483639 > 0) {
                i13 = i12 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i13);
            p.d(objArrCopyOf2, "copyOf(...)");
            this.f1834a = objArrCopyOf2;
            Object[] objArr2 = this.f1835b;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i13);
                p.d(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f1835b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f1836c, i13);
            p.d(iArrCopyOf, "copyOf(...)");
            this.f1836c = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i13 >= 1 ? i13 : 1) * 3);
            if (iHighestOneBit > this.d.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f1835b;
        p.b(objArr);
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i8 = this.f1837e;
        while (true) {
            int i9 = this.d[iJ];
            if (i9 == 0) {
                return -1;
            }
            if (i9 > 0) {
                int i10 = i9 - 1;
                if (p.a(this.f1834a[i10], obj)) {
                    return i10;
                }
            }
            i8--;
            if (i8 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.d.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i8 = 0;
        while (dVar.hasNext()) {
            int i9 = dVar.f1830a;
            g gVar = (g) dVar.d;
            if (i9 >= gVar.f1838f) {
                throw new NoSuchElementException();
            }
            dVar.f1830a = i9 + 1;
            dVar.f1831b = i9;
            Object obj = gVar.f1834a[i9];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = gVar.f1835b;
            p.b(objArr);
            Object obj2 = objArr[dVar.f1831b];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.c();
            i8 += iHashCode ^ iHashCode2;
        }
        return i8;
    }

    public final int i(Object obj) {
        int i8 = this.f1838f;
        while (true) {
            i8--;
            if (i8 < 0) {
                return -1;
            }
            if (this.f1836c[i8] >= 0) {
                Object[] objArr = this.f1835b;
                p.b(objArr);
                if (p.a(objArr[i8], obj)) {
                    return i8;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f1841j == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f1839g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f1836c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.f1840h
            int r0 = r0 + 1
            r5.f1840h = r0
            int r0 = r5.f1838f
            int r1 = r5.f1841j
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.d = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f1839g = r6
        L1c:
            int r6 = r5.f1838f
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f1834a
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.f1837e
        L2c:
            int[] r3 = r5.d
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f1836c
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
        throw new UnsupportedOperationException("Method not decompiled: d5.g.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        h hVar = this.f1842k;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this, 1);
        this.f1842k = hVar2;
        return hVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f1834a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.p.e(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f1835b
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f1836c
            r0 = r0[r12]
            int r1 = r11.f1837e
            int r1 = r1 * 2
            int[] r2 = r11.d
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
            int[] r0 = r11.d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f1837e
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.d
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.d
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
            java.lang.Object[] r5 = r11.f1834a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f1836c
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.d
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f1836c
            r0[r12] = r6
            int r12 = r11.f1841j
            int r12 = r12 + r6
            r11.f1841j = r12
            int r12 = r11.f1840h
            int r12 = r12 + 1
            r11.f1840h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.g.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f1835b;
        if (objArr == null) {
            int length = this.f1834a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f1835b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i8 = (-iA) - 1;
        Object obj3 = objArr[i8];
        objArr[i8] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        p.e(from, "from");
        c();
        Set<Map.Entry> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f1835b;
            if (objArr == null) {
                int length = this.f1834a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f1835b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i8 = (-iA) - 1;
                if (!p.a(entry.getValue(), objArr[i8])) {
                    objArr[i8] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.f1835b;
        p.b(objArr);
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f1841j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f1841j * 3) + 2);
        sb.append("{");
        d dVar = new d(this, 0);
        int i8 = 0;
        while (dVar.hasNext()) {
            if (i8 > 0) {
                sb.append(", ");
            }
            int i9 = dVar.f1830a;
            g gVar = (g) dVar.d;
            if (i9 >= gVar.f1838f) {
                throw new NoSuchElementException();
            }
            dVar.f1830a = i9 + 1;
            dVar.f1831b = i9;
            Object obj = gVar.f1834a[i9];
            if (obj == gVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = gVar.f1835b;
            p.b(objArr);
            Object obj2 = objArr[dVar.f1831b];
            if (obj2 == gVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.c();
            i8++;
        }
        sb.append("}");
        String string = sb.toString();
        p.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        i iVar = this.f1843l;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f1843l = iVar2;
        return iVar2;
    }

    public g(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i8];
        int[] iArr = new int[i8];
        int iHighestOneBit = Integer.highestOneBit((i8 < 1 ? 1 : i8) * 3);
        this.f1834a = objArr;
        this.f1835b = null;
        this.f1836c = iArr;
        this.d = new int[iHighestOneBit];
        this.f1837e = 2;
        this.f1838f = 0;
        this.f1839g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
