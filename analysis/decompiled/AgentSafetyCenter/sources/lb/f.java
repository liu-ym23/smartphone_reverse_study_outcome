package lb;

import b8.z;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Map, Serializable, zb.c {

    /* renamed from: r, reason: collision with root package name */
    public static final f f7837r;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f7838c;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f7839f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f7840g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f7841h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f7842j;

    /* renamed from: k, reason: collision with root package name */
    public int f7843k;

    /* renamed from: l, reason: collision with root package name */
    public int f7844l;

    /* renamed from: m, reason: collision with root package name */
    public int f7845m;

    /* renamed from: n, reason: collision with root package name */
    public g f7846n;

    /* renamed from: o, reason: collision with root package name */
    public h f7847o;

    /* renamed from: p, reason: collision with root package name */
    public g f7848p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7849q;

    static {
        f fVar = new f(0);
        fVar.f7849q = true;
        f7837r = fVar;
    }

    public f(int i) {
        if (i < 0) {
            g5.f.s("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f7838c = objArr;
        this.f7839f = null;
        this.f7840g = iArr;
        this.f7841h = new int[iHighestOneBit];
        this.i = 2;
        this.f7842j = 0;
        this.f7843k = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int i = i(obj);
            int i3 = this.i * 2;
            int length = this.f7841h.length / 2;
            if (i3 > length) {
                i3 = length;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f7841h;
                int i11 = iArr[i];
                if (i11 <= 0) {
                    int i12 = this.f7842j;
                    Object[] objArr = this.f7838c;
                    if (i12 < objArr.length) {
                        int i13 = i12 + 1;
                        this.f7842j = i13;
                        objArr[i12] = obj;
                        this.f7840g[i12] = i;
                        iArr[i] = i13;
                        this.f7845m++;
                        this.f7844l++;
                        if (i10 > this.i) {
                            this.i = i10;
                        }
                        return i12;
                    }
                    f(1);
                } else {
                    if (k.a(this.f7838c[i11 - 1], obj)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > i3) {
                        j(this.f7841h.length * 2);
                        break;
                    }
                    i = i == 0 ? this.f7841h.length - 1 : i - 1;
                }
            }
        }
    }

    public final f b() {
        c();
        this.f7849q = true;
        if (this.f7845m > 0) {
            return this;
        }
        f fVar = f7837r;
        fVar.getClass();
        return fVar;
    }

    public final void c() {
        if (this.f7849q) {
            z.c();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i = this.f7842j - 1;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f7840g;
                int i10 = iArr[i3];
                if (i10 >= 0) {
                    this.f7841h[i10] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        a.a.S(this.f7838c, 0, this.f7842j);
        Object[] objArr = this.f7839f;
        if (objArr != null) {
            a.a.S(objArr, 0, this.f7842j);
        }
        this.f7845m = 0;
        this.f7842j = 0;
        this.f7844l++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    public final void d(boolean z10) {
        int i;
        Object[] objArr = this.f7839f;
        int i3 = 0;
        int i10 = 0;
        while (true) {
            i = this.f7842j;
            if (i3 >= i) {
                break;
            }
            int[] iArr = this.f7840g;
            int i11 = iArr[i3];
            if (i11 >= 0) {
                Object[] objArr2 = this.f7838c;
                objArr2[i10] = objArr2[i3];
                if (objArr != null) {
                    objArr[i10] = objArr[i3];
                }
                if (z10) {
                    iArr[i10] = i11;
                    this.f7841h[i11] = i10 + 1;
                }
                i10++;
            }
            i3++;
        }
        a.a.S(this.f7838c, i10, i);
        if (objArr != null) {
            a.a.S(objArr, i10, this.f7842j);
        }
        this.f7842j = i10;
    }

    public final boolean e(Collection collection) {
        boolean zA;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int iG = g(entry.getKey());
                    if (iG < 0) {
                        zA = false;
                    } else {
                        Object[] objArr = this.f7839f;
                        objArr.getClass();
                        zA = k.a(objArr[iG], entry.getValue());
                    }
                    if (!zA) {
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
        g gVar = this.f7848p;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.f7848p = gVar2;
        return gVar2;
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
        return this.f7845m == map.size() && e(map.entrySet());
    }

    public final void f(int i) {
        Object[] objArr = this.f7838c;
        int length = objArr.length;
        int i3 = this.f7842j;
        int i10 = length - i3;
        int i11 = i3 - this.f7845m;
        if (i10 < i && i10 + i11 >= i && i11 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i12 = i3 + i;
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
                i13 = i12 > 2147483639 ? Reader.READ_DONE : 2147483639;
            }
            this.f7838c = Arrays.copyOf(objArr, i13);
            Object[] objArr2 = this.f7839f;
            this.f7839f = objArr2 != null ? Arrays.copyOf(objArr2, i13) : null;
            this.f7840g = Arrays.copyOf(this.f7840g, i13);
            int iHighestOneBit = Integer.highestOneBit((i13 >= 1 ? i13 : 1) * 3);
            if (iHighestOneBit > this.f7841h.length) {
                j(iHighestOneBit);
            }
        }
    }

    public final int g(Object obj) {
        int i = i(obj);
        int i3 = this.i;
        while (true) {
            int i10 = this.f7841h[i];
            if (i10 == 0) {
                return -1;
            }
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (k.a(this.f7838c[i11], obj)) {
                    return i11;
                }
            }
            i3--;
            if (i3 < 0) {
                return -1;
            }
            i = i == 0 ? this.f7841h.length - 1 : i - 1;
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f7839f;
        objArr.getClass();
        return objArr[iG];
    }

    public final int h(Object obj) {
        int i = this.f7842j;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f7840g[i] >= 0) {
                Object[] objArr = this.f7839f;
                objArr.getClass();
                if (k.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i = 0;
        while (dVar.hasNext()) {
            int i3 = dVar.f1897c;
            f fVar = (f) dVar.f1900h;
            if (i3 >= fVar.f7842j) {
                g5.f.k();
                return 0;
            }
            dVar.f1897c = i3 + 1;
            dVar.f1898f = i3;
            Object obj = fVar.f7838c[i3];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f7839f;
            objArr.getClass();
            Object obj2 = objArr[dVar.f1898f];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.e();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f7843k;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f7845m == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f7840g[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r6) {
        /*
            r5 = this;
            int r0 = r5.f7844l
            int r0 = r0 + 1
            r5.f7844l = r0
            int r0 = r5.f7842j
            int r1 = r5.f7845m
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f7841h = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f7843k = r6
        L1c:
            int r6 = r5.f7842j
            if (r2 >= r6) goto L4d
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f7838c
            r0 = r0[r2]
            int r0 = r5.i(r0)
            int r1 = r5.i
        L2c:
            int[] r3 = r5.f7841h
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f7840g
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
            java.lang.String r5 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            od.f.e(r5)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.f.j(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0022->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f7838c
            r0.getClass()
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f7839f
            if (r0 == 0) goto Le
            r0[r12] = r1
        Le:
            int[] r0 = r11.f7840g
            r0 = r0[r12]
            int r1 = r11.i
            int r1 = r1 * 2
            int[] r2 = r11.f7841h
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1e
            r1 = r2
        L1e:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L22:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2c
            int[] r0 = r11.f7841h
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2d
        L2c:
            r0 = r5
        L2d:
            int r4 = r4 + 1
            int r5 = r11.i
            int[] r6 = r11.f7841h
            r7 = -1
            if (r4 <= r5) goto L39
            r6[r1] = r2
            goto L68
        L39:
            r5 = r6[r0]
            if (r5 != 0) goto L40
            r6[r1] = r2
            goto L68
        L40:
            if (r5 >= 0) goto L47
            r6[r1] = r7
        L44:
            r1 = r0
            r4 = r2
            goto L61
        L47:
            java.lang.Object[] r6 = r11.f7838c
            int r8 = r5 + (-1)
            r6 = r6[r8]
            int r6 = r11.i(r6)
            int r6 = r6 - r0
            int[] r9 = r11.f7841h
            int r10 = r9.length
            int r10 = r10 + (-1)
            r6 = r6 & r10
            if (r6 < r4) goto L61
            r9[r1] = r5
            int[] r4 = r11.f7840g
            r4[r8] = r1
            goto L44
        L61:
            int r3 = r3 + r7
            if (r3 >= 0) goto L22
            int[] r0 = r11.f7841h
            r0[r1] = r7
        L68:
            int[] r0 = r11.f7840g
            r0[r12] = r7
            int r12 = r11.f7845m
            int r12 = r12 + r7
            r11.f7845m = r12
            int r12 = r11.f7844l
            int r12 = r12 + 1
            r11.f7844l = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lb.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f7846n;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f7846n = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.f7839f;
        if (objArr == null) {
            int length = this.f7838c.length;
            if (length < 0) {
                g5.f.s("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.f7839f = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        f(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.f7839f;
            if (objArr == null) {
                int length = this.f7838c.length;
                if (length < 0) {
                    g5.f.s("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.f7839f = objArr;
                }
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!k.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iG = g(obj);
        if (iG < 0) {
            return null;
        }
        Object[] objArr = this.f7839f;
        objArr.getClass();
        Object obj2 = objArr[iG];
        k(iG);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f7845m;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f7845m * 3) + 2);
        sb2.append("{");
        d dVar = new d(this, 0);
        int i = 0;
        while (dVar.hasNext()) {
            if (i > 0) {
                sb2.append(", ");
            }
            int i3 = dVar.f1897c;
            f fVar = (f) dVar.f1900h;
            if (i3 >= fVar.f7842j) {
                g5.f.k();
                return null;
            }
            dVar.f1897c = i3 + 1;
            dVar.f1898f = i3;
            Object obj = fVar.f7838c[i3];
            if (obj == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = fVar.f7839f;
            objArr.getClass();
            Object obj2 = objArr[dVar.f1898f];
            if (obj2 == fVar) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            dVar.e();
            i++;
        }
        sb2.append("}");
        return sb2.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f7847o;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this, 0);
        this.f7847o = hVar2;
        return hVar2;
    }

    public f() {
        this(8);
    }
}
