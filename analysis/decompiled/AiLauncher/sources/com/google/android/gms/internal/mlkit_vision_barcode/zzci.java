package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import z2.C6074S;
import z2.C6175k;
import z2.C6195m;
import z2.C6275u;
import z2.C6285v;

/* loaded from: classes2.dex */
final class zzci extends AbstractMap implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f19972j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public transient Object f19973a;

    /* renamed from: b, reason: collision with root package name */
    public transient int[] f19974b;

    /* renamed from: c, reason: collision with root package name */
    public transient Object[] f19975c;

    /* renamed from: d, reason: collision with root package name */
    public transient Object[] f19976d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f19977e;

    /* renamed from: f, reason: collision with root package name */
    public transient int f19978f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set f19979g;

    /* renamed from: h, reason: collision with root package name */
    public transient Set f19980h;

    /* renamed from: i, reason: collision with root package name */
    public transient Collection f19981i;

    public zzci(int i10) {
        y(12);
    }

    public static /* synthetic */ Object m(zzci zzciVar, int i10) {
        return zzciVar.c()[i10];
    }

    public static /* synthetic */ Object q(zzci zzciVar) {
        Object obj = zzciVar.f19973a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object s(zzci zzciVar, int i10) {
        return zzciVar.d()[i10];
    }

    public static /* synthetic */ void w(zzci zzciVar, int i10, Object obj) {
        zzciVar.d()[i10] = obj;
    }

    public final boolean A() {
        return this.f19973a == null;
    }

    public final int G() {
        return (1 << (this.f19977e & 31)) - 1;
    }

    public final int H(Object obj) {
        if (A()) {
            return -1;
        }
        int iA = C6285v.a(obj);
        int iG = G();
        Object obj2 = this.f19973a;
        Objects.requireNonNull(obj2);
        int iC = C6275u.c(obj2, iA & iG);
        if (iC != 0) {
            int i10 = ~iG;
            int i11 = iA & i10;
            do {
                int i12 = iC - 1;
                int i13 = b()[i12];
                if ((i13 & i10) == i11 && C6175k.a(obj, c()[i12])) {
                    return i12;
                }
                iC = i13 & iG;
            } while (iC != 0);
        }
        return -1;
    }

    public final int J(int i10, int i11, int i12, int i13) {
        int i14 = i11 - 1;
        Object objD = C6275u.d(i11);
        if (i13 != 0) {
            C6275u.e(objD, i12 & i14, i13 + 1);
        }
        Object obj = this.f19973a;
        Objects.requireNonNull(obj);
        int[] iArrB = b();
        for (int i15 = 0; i15 <= i10; i15++) {
            int iC = C6275u.c(obj, i15);
            while (iC != 0) {
                int i16 = iC - 1;
                int i17 = iArrB[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int iC2 = C6275u.c(objD, i19);
                C6275u.e(objD, i19, iC);
                iArrB[i16] = ((~i14) & i18) | (iC2 & i14);
                iC = i17 & i10;
            }
        }
        this.f19973a = objD;
        L(i14);
        return i14;
    }

    public final Object K(Object obj) {
        if (!A()) {
            int iG = G();
            Object obj2 = this.f19973a;
            Objects.requireNonNull(obj2);
            int iB = C6275u.b(obj, null, iG, obj2, b(), c(), null);
            if (iB != -1) {
                Object obj3 = d()[iB];
                z(iB, iG);
                this.f19978f--;
                x();
                return obj3;
            }
        }
        return f19972j;
    }

    public final void L(int i10) {
        this.f19977e = ((32 - Integer.numberOfLeadingZeros(i10)) & 31) | (this.f19977e & (-32));
    }

    public final int[] b() {
        int[] iArr = this.f19974b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] c() {
        Object[] objArr = this.f19975c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (A()) {
            return;
        }
        x();
        Map mapU = u();
        if (mapU != null) {
            this.f19977e = C6074S.a(size(), 3, 1073741823);
            mapU.clear();
            this.f19973a = null;
            this.f19978f = 0;
            return;
        }
        Arrays.fill(c(), 0, this.f19978f, (Object) null);
        Arrays.fill(d(), 0, this.f19978f, (Object) null);
        Object obj = this.f19973a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(b(), 0, this.f19978f, 0);
        this.f19978f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapU = u();
        return mapU != null ? mapU.containsKey(obj) : H(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapU = u();
        if (mapU != null) {
            return mapU.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f19978f; i10++) {
            if (C6175k.a(obj, d()[i10])) {
                return true;
            }
        }
        return false;
    }

    public final Object[] d() {
        Object[] objArr = this.f19976d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f19980h;
        if (set != null) {
            return set;
        }
        n nVar = new n(this);
        this.f19980h = nVar;
        return nVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapU = u();
        if (mapU != null) {
            return mapU.get(obj);
        }
        int iH = H(obj);
        if (iH == -1) {
            return null;
        }
        return d()[iH];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    public final int j() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f19979g;
        if (set != null) {
            return set;
        }
        p pVar = new p(this);
        this.f19979g = pVar;
        return pVar;
    }

    public final int l(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.f19978f) {
            return i11;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i10;
        if (A()) {
            C6195m.e(A(), "Arrays already allocated");
            int i11 = this.f19977e;
            int iMax = Math.max(i11 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.f19973a = C6275u.d(iMax2);
            L(iMax2 - 1);
            this.f19974b = new int[i11];
            this.f19975c = new Object[i11];
            this.f19976d = new Object[i11];
        }
        Map mapU = u();
        if (mapU != null) {
            return mapU.put(obj, obj2);
        }
        int[] iArrB = b();
        Object[] objArrC = c();
        Object[] objArrD = d();
        int i12 = this.f19978f;
        int i13 = i12 + 1;
        int iA = C6285v.a(obj);
        int iG = G();
        int i14 = iA & iG;
        Object obj3 = this.f19973a;
        Objects.requireNonNull(obj3);
        int iC = C6275u.c(obj3, i14);
        if (iC == 0) {
            if (i13 > iG) {
                iG = J(iG, C6275u.a(iG), iA, i12);
            } else {
                Object obj4 = this.f19973a;
                Objects.requireNonNull(obj4);
                C6275u.e(obj4, i14, i13);
            }
            i10 = 1;
        } else {
            int i15 = ~iG;
            int i16 = iA & i15;
            int i17 = 0;
            while (true) {
                int i18 = iC - 1;
                int i19 = iArrB[i18];
                i10 = 1;
                int i20 = i19 & i15;
                if (i20 == i16 && C6175k.a(obj, objArrC[i18])) {
                    Object obj5 = objArrD[i18];
                    objArrD[i18] = obj2;
                    return obj5;
                }
                int i21 = i19 & iG;
                i17++;
                if (i21 != 0) {
                    iC = i21;
                } else {
                    if (i17 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(G() + 1, 1.0f);
                        int iJ = j();
                        while (iJ >= 0) {
                            linkedHashMap.put(c()[iJ], d()[iJ]);
                            iJ = l(iJ);
                        }
                        this.f19973a = linkedHashMap;
                        this.f19974b = null;
                        this.f19975c = null;
                        this.f19976d = null;
                        x();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i13 > iG) {
                        iG = J(iG, C6275u.a(iG), iA, i12);
                    } else {
                        iArrB[i18] = (i13 & iG) | i20;
                    }
                }
            }
        }
        int length = b().length;
        if (i13 > length) {
            int i22 = i10;
            int iMin = Math.min(1073741823, (Math.max(i22, length >>> 1) + length) | i22);
            if (iMin != length) {
                this.f19974b = Arrays.copyOf(b(), iMin);
                this.f19975c = Arrays.copyOf(c(), iMin);
                this.f19976d = Arrays.copyOf(d(), iMin);
            }
        }
        b()[i12] = (~iG) & iA;
        c()[i12] = obj;
        d()[i12] = obj2;
        this.f19978f = i13;
        x();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapU = u();
        if (mapU != null) {
            return mapU.remove(obj);
        }
        Object objK = K(obj);
        if (objK == f19972j) {
            return null;
        }
        return objK;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapU = u();
        return mapU != null ? mapU.size() : this.f19978f;
    }

    public final Map u() {
        Object obj = this.f19973a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f19981i;
        if (collection != null) {
            return collection;
        }
        r rVar = new r(this);
        this.f19981i = rVar;
        return rVar;
    }

    public final void x() {
        this.f19977e += 32;
    }

    public final void y(int i10) {
        this.f19977e = C6074S.a(i10, 1, 1073741823);
    }

    public final void z(int i10, int i11) {
        Object obj = this.f19973a;
        Objects.requireNonNull(obj);
        int[] iArrB = b();
        Object[] objArrC = c();
        Object[] objArrD = d();
        int size = size();
        int i12 = size - 1;
        if (i10 >= i12) {
            objArrC[i10] = null;
            objArrD[i10] = null;
            iArrB[i10] = 0;
            return;
        }
        int i13 = i10 + 1;
        Object obj2 = objArrC[i12];
        objArrC[i10] = obj2;
        objArrD[i10] = objArrD[i12];
        objArrC[i12] = null;
        objArrD[i12] = null;
        iArrB[i10] = iArrB[i12];
        iArrB[i12] = 0;
        int iA = C6285v.a(obj2) & i11;
        int iC = C6275u.c(obj, iA);
        if (iC == size) {
            C6275u.e(obj, iA, i13);
            return;
        }
        while (true) {
            int i14 = iC - 1;
            int i15 = iArrB[i14];
            int i16 = i15 & i11;
            if (i16 == size) {
                iArrB[i14] = ((~i11) & i15) | (i13 & i11);
                return;
            }
            iC = i16;
        }
    }
}
