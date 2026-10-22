package e7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import q7.k;

/* loaded from: classes.dex */
public final class g implements Map, Serializable, r7.d {

    /* renamed from: s, reason: collision with root package name */
    public static final g f3098s;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f3099f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f3100g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f3101h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3102i;

    /* renamed from: j, reason: collision with root package name */
    public int f3103j;

    /* renamed from: k, reason: collision with root package name */
    public int f3104k;

    /* renamed from: l, reason: collision with root package name */
    public int f3105l;

    /* renamed from: m, reason: collision with root package name */
    public int f3106m;

    /* renamed from: n, reason: collision with root package name */
    public int f3107n;

    /* renamed from: o, reason: collision with root package name */
    public h f3108o;

    /* renamed from: p, reason: collision with root package name */
    public i f3109p;

    /* renamed from: q, reason: collision with root package name */
    public h f3110q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3111r;

    static {
        g gVar = new g(0);
        gVar.f3111r = true;
        f3098s = gVar;
    }

    public g() {
        this(8);
    }

    public final int a(Object obj) {
        d();
        while (true) {
            int iL = l(obj);
            int i2 = this.f3103j * 2;
            int length = this.f3102i.length / 2;
            if (i2 > length) {
                i2 = length;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f3102i;
                int i11 = iArr[iL];
                if (i11 <= 0) {
                    int i12 = this.f3104k;
                    Object[] objArr = this.f3099f;
                    if (i12 < objArr.length) {
                        int i13 = i12 + 1;
                        this.f3104k = i13;
                        objArr[i12] = obj;
                        this.f3101h[i12] = iL;
                        iArr[iL] = i13;
                        this.f3107n++;
                        this.f3106m++;
                        if (i10 > this.f3103j) {
                            this.f3103j = i10;
                        }
                        return i12;
                    }
                    i(1);
                } else {
                    if (k.a(this.f3099f[i11 - 1], obj)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > i2) {
                        m(this.f3102i.length * 2);
                        break;
                    }
                    iL = iL == 0 ? this.f3102i.length - 1 : iL - 1;
                }
            }
        }
    }

    public final g c() {
        d();
        this.f3111r = true;
        if (this.f3107n > 0) {
            return this;
        }
        g gVar = f3098s;
        k.c(gVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return gVar;
    }

    @Override // java.util.Map
    public final void clear() {
        d();
        int i2 = this.f3104k - 1;
        if (i2 >= 0) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f3101h;
                int i11 = iArr[i10];
                if (i11 >= 0) {
                    this.f3102i[i11] = 0;
                    iArr[i10] = -1;
                }
                if (i10 == i2) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        ib.k.N(this.f3099f, 0, this.f3104k);
        Object[] objArr = this.f3100g;
        if (objArr != null) {
            ib.k.N(objArr, 0, this.f3104k);
        }
        this.f3107n = 0;
        this.f3104k = 0;
        this.f3106m++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return j(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return k(obj) >= 0;
    }

    public final void d() {
        if (this.f3111r) {
            throw new UnsupportedOperationException();
        }
    }

    public final void e(boolean z4) {
        int i2;
        Object[] objArr = this.f3100g;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i2 = this.f3104k;
            if (i10 >= i2) {
                break;
            }
            int[] iArr = this.f3101h;
            int i12 = iArr[i10];
            if (i12 >= 0) {
                Object[] objArr2 = this.f3099f;
                objArr2[i11] = objArr2[i10];
                if (objArr != null) {
                    objArr[i11] = objArr[i10];
                }
                if (z4) {
                    iArr[i11] = i12;
                    this.f3102i[i12] = i11 + 1;
                }
                i11++;
            }
            i10++;
        }
        ib.k.N(this.f3099f, i11, i2);
        if (objArr != null) {
            ib.k.N(objArr, i11, this.f3104k);
        }
        this.f3104k = i11;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        h hVar = this.f3110q;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this, 0);
        this.f3110q = hVar2;
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
        return this.f3107n == map.size() && f(map.entrySet());
    }

    public final boolean f(Collection collection) {
        k.e(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!h((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iJ = j(obj);
        if (iJ < 0) {
            return null;
        }
        Object[] objArr = this.f3100g;
        k.b(objArr);
        return objArr[iJ];
    }

    public final boolean h(Map.Entry entry) {
        k.e(entry, "entry");
        int iJ = j(entry.getKey());
        if (iJ < 0) {
            return false;
        }
        Object[] objArr = this.f3100g;
        k.b(objArr);
        return k.a(objArr[iJ], entry.getValue());
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i2 = 0;
        while (dVar.hasNext()) {
            int i10 = dVar.f3094f;
            g gVar = (g) dVar.f3097i;
            if (i10 >= gVar.f3104k) {
                throw new NoSuchElementException();
            }
            dVar.f3094f = i10 + 1;
            dVar.f3095g = i10;
            Object obj = gVar.f3099f[i10];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = gVar.f3100g;
            k.b(objArr);
            Object obj2 = objArr[dVar.f3095g];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.d();
            i2 += iHashCode ^ iHashCode2;
        }
        return i2;
    }

    public final void i(int i2) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f3099f;
        int length = objArr.length;
        int i10 = this.f3104k;
        int i11 = length - i10;
        int i12 = i10 - this.f3107n;
        if (i11 < i2 && i11 + i12 >= i2 && i12 >= objArr.length / 4) {
            e(true);
            return;
        }
        int i13 = i10 + i2;
        if (i13 < 0) {
            throw new OutOfMemoryError();
        }
        if (i13 > objArr.length) {
            int length2 = objArr.length;
            int i14 = length2 + (length2 >> 1);
            if (i14 - i13 < 0) {
                i14 = i13;
            }
            if (i14 - 2147483639 > 0) {
                i14 = i13 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i14);
            k.d(objArrCopyOf2, "copyOf(...)");
            this.f3099f = objArrCopyOf2;
            Object[] objArr2 = this.f3100g;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i14);
                k.d(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.f3100g = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.f3101h, i14);
            k.d(iArrCopyOf, "copyOf(...)");
            this.f3101h = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i14 >= 1 ? i14 : 1) * 3);
            if (iHighestOneBit > this.f3102i.length) {
                m(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f3107n == 0;
    }

    public final int j(Object obj) {
        int iL = l(obj);
        int i2 = this.f3103j;
        while (true) {
            int i10 = this.f3102i[iL];
            if (i10 == 0) {
                return -1;
            }
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (k.a(this.f3099f[i11], obj)) {
                    return i11;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iL = iL == 0 ? this.f3102i.length - 1 : iL - 1;
        }
    }

    public final int k(Object obj) {
        int i2 = this.f3104k;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f3101h[i2] >= 0) {
                Object[] objArr = this.f3100g;
                k.b(objArr);
                if (k.a(objArr[i2], obj)) {
                    return i2;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Set keySet() {
        h hVar = this.f3108o;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this, 1);
        this.f3108o = hVar2;
        return hVar2;
    }

    public final int l(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f3105l;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f3101h[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(int r6) {
        /*
            r5 = this;
            int r0 = r5.f3106m
            int r0 = r0 + 1
            r5.f3106m = r0
            int r0 = r5.f3104k
            int r1 = r5.f3107n
            r2 = 0
            if (r0 <= r1) goto L10
            r5.e(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f3102i = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f3105l = r6
        L1c:
            int r6 = r5.f3104k
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f3099f
            r0 = r0[r2]
            int r0 = r5.l(r0)
            int r1 = r5.f3103j
        L2c:
            int[] r3 = r5.f3102i
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f3101h
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
        throw new UnsupportedOperationException("Method not decompiled: e7.g.m(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f3099f
            java.lang.String r1 = "<this>"
            q7.k.e(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f3100g
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.f3101h
            r0 = r0[r12]
            int r1 = r11.f3103j
            int r1 = r1 * 2
            int[] r2 = r11.f3102i
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
            int[] r0 = r11.f3102i
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.f3103j
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.f3102i
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.f3102i
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
            java.lang.Object[] r5 = r11.f3099f
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.l(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f3102i
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.f3101h
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.f3102i
            r0[r1] = r6
        L6c:
            int[] r0 = r11.f3101h
            r0[r12] = r6
            int r12 = r11.f3107n
            int r12 = r12 + r6
            r11.f3107n = r12
            int r12 = r11.f3106m
            int r12 = r12 + 1
            r11.f3106m = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.g.n(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        d();
        int iA = a(obj);
        Object[] objArr = this.f3100g;
        if (objArr == null) {
            int length = this.f3099f.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.f3100g = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i2 = (-iA) - 1;
        Object obj3 = objArr[i2];
        objArr[i2] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        k.e(map, "from");
        d();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        i(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f3100g;
            if (objArr == null) {
                int length = this.f3099f.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.f3100g = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i2 = (-iA) - 1;
                if (!k.a(entry.getValue(), objArr[i2])) {
                    objArr[i2] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        d();
        int iJ = j(obj);
        if (iJ < 0) {
            return null;
        }
        Object[] objArr = this.f3100g;
        k.b(objArr);
        Object obj2 = objArr[iJ];
        n(iJ);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f3107n;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f3107n * 3) + 2);
        sb2.append("{");
        d dVar = new d(this, 0);
        int i2 = 0;
        while (dVar.hasNext()) {
            if (i2 > 0) {
                sb2.append(", ");
            }
            int i10 = dVar.f3094f;
            g gVar = (g) dVar.f3097i;
            if (i10 >= gVar.f3104k) {
                throw new NoSuchElementException();
            }
            dVar.f3094f = i10 + 1;
            dVar.f3095g = i10;
            Object obj = gVar.f3099f[i10];
            if (obj == gVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = gVar.f3100g;
            k.b(objArr);
            Object obj2 = objArr[dVar.f3095g];
            if (obj2 == gVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            dVar.d();
            i2++;
        }
        sb2.append("}");
        String string = sb2.toString();
        k.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        i iVar = this.f3109p;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(0, this);
        this.f3109p = iVar2;
        return iVar2;
    }

    public g(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i2];
        int[] iArr = new int[i2];
        int iHighestOneBit = Integer.highestOneBit((i2 < 1 ? 1 : i2) * 3);
        this.f3099f = objArr;
        this.f3100g = null;
        this.f3101h = iArr;
        this.f3102i = new int[iHighestOneBit];
        this.f3103j = 2;
        this.f3104k = 0;
        this.f3105l = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
