package f0;

import b0.u1;
import d7.n;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class g extends d7.h implements Collection, r7.b {

    /* renamed from: f, reason: collision with root package name */
    public c f3337f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f3338g;

    /* renamed from: h, reason: collision with root package name */
    public Object[] f3339h;

    /* renamed from: i, reason: collision with root package name */
    public int f3340i;

    /* renamed from: j, reason: collision with root package name */
    public i0.b f3341j = new i0.b();

    /* renamed from: k, reason: collision with root package name */
    public Object[] f3342k;

    /* renamed from: l, reason: collision with root package name */
    public Object[] f3343l;

    /* renamed from: m, reason: collision with root package name */
    public int f3344m;

    public g(c cVar, Object[] objArr, Object[] objArr2, int i2) {
        this.f3337f = cVar;
        this.f3338g = objArr;
        this.f3339h = objArr2;
        this.f3340i = i2;
        this.f3342k = objArr;
        this.f3343l = objArr2;
        this.f3344m = cVar.a();
    }

    public static void i(Object[] objArr, int i2, Iterator it) {
        while (i2 < 32 && it.hasNext()) {
            objArr[i2] = it.next();
            i2++;
        }
    }

    public final int A(p7.k kVar, Object[] objArr, int i2, int i10, e eVar, ArrayList arrayList, ArrayList arrayList2) {
        if (n(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = eVar.f3332a;
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) obj;
        Object[] objArrR = objArr2;
        for (int i11 = 0; i11 < i2; i11++) {
            Object obj2 = objArr[i11];
            if (!((Boolean) kVar.invoke(obj2)).booleanValue()) {
                if (i10 == 32) {
                    objArrR = !arrayList.isEmpty() ? (Object[]) arrayList.remove(arrayList.size() - 1) : r();
                    i10 = 0;
                }
                objArrR[i10] = obj2;
                i10++;
            }
        }
        eVar.f3332a = objArrR;
        if (objArr2 != objArrR) {
            arrayList2.add(objArr2);
        }
        return i10;
    }

    public final int B(p7.k kVar, Object[] objArr, int i2, e eVar) {
        Object[] objArrP = objArr;
        int i10 = i2;
        boolean z4 = false;
        for (int i11 = 0; i11 < i2; i11++) {
            Object obj = objArr[i11];
            if (((Boolean) kVar.invoke(obj)).booleanValue()) {
                if (!z4) {
                    objArrP = p(objArr);
                    z4 = true;
                    i10 = i11;
                }
            } else if (z4) {
                objArrP[i10] = obj;
                i10++;
            }
        }
        eVar.f3332a = objArrP;
        return i10;
    }

    public final int C(p7.k kVar, int i2, e eVar) {
        int iB = B(kVar, this.f3343l, i2, eVar);
        if (iB == i2) {
            return i2;
        }
        Object obj = eVar.f3332a;
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, iB, i2, (Object) null);
        this.f3343l = objArr;
        this.f3344m -= i2 - iB;
        return iB;
    }

    public final boolean D(p7.k kVar) {
        Object[] objArrW;
        int i2;
        p7.k kVar2 = kVar;
        int iJ = J();
        Object[] objArrT = null;
        e eVar = new e(null);
        boolean z4 = false;
        if (this.f3342k != null) {
            a aVarO = o(0);
            int iB = 32;
            while (iB == 32 && aVarO.hasNext()) {
                iB = B(kVar2, (Object[]) aVarO.next(), 32, eVar);
            }
            if (iB == 32) {
                int iC = C(kVar2, iJ, eVar);
                if (iC == 0) {
                    v(this.f3342k, this.f3344m, this.f3340i);
                }
                if (iC != iJ) {
                }
            } else {
                int i10 = (aVarO.f3326f - 1) << 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int iA = iB;
                while (aVarO.hasNext()) {
                    iA = A(kVar2, (Object[]) aVarO.next(), 32, iA, eVar, arrayList2, arrayList);
                    kVar2 = kVar;
                }
                int iA2 = A(kVar, this.f3343l, iJ, iA, eVar, arrayList2, arrayList);
                Object obj = eVar.f3332a;
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                Object[] objArr = (Object[]) obj;
                Arrays.fill(objArr, iA2, 32, (Object) null);
                if (arrayList.isEmpty()) {
                    objArrW = this.f3342k;
                    q7.k.b(objArrW);
                } else {
                    objArrW = w(this.f3342k, i10, this.f3340i, arrayList.iterator());
                }
                int size = i10 + (arrayList.size() << 5);
                if ((size & 31) != 0) {
                    u1.a("invalid size");
                }
                if (size == 0) {
                    this.f3340i = 0;
                } else {
                    int i11 = size - 1;
                    while (true) {
                        i2 = this.f3340i;
                        if ((i11 >> i2) != 0) {
                            break;
                        }
                        this.f3340i = i2 - 5;
                        Object[] objArr2 = objArrW[0];
                        q7.k.c(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        objArrW = objArr2;
                    }
                    objArrT = t(objArrW, i11, i2);
                }
                this.f3342k = objArrT;
                this.f3343l = objArr;
                this.f3344m = size + iA2;
            }
            z4 = true;
        } else if (C(kVar2, iJ, eVar) != iJ) {
            z4 = true;
        }
        if (z4) {
            ((AbstractList) this).modCount++;
        }
        return z4;
    }

    public final Object[] E(Object[] objArr, int i2, int i10, e eVar) {
        int iR = a.a.R(i10, i2);
        if (i2 == 0) {
            Object obj = objArr[iR];
            Object[] objArrP = p(objArr);
            n.Y(objArr, objArrP, iR, iR + 1, 32);
            objArrP[31] = eVar.f3332a;
            eVar.f3332a = obj;
            return objArrP;
        }
        int iR2 = objArr[31] == null ? a.a.R(G() - 1, i2) : 31;
        Object[] objArrP2 = p(objArr);
        int i11 = i2 - 5;
        int i12 = iR + 1;
        if (i12 <= iR2) {
            while (true) {
                Object obj2 = objArrP2[iR2];
                q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrP2[iR2] = E((Object[]) obj2, i11, 0, eVar);
                if (iR2 == i12) {
                    break;
                }
                iR2--;
            }
        }
        Object obj3 = objArrP2[iR];
        q7.k.c(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrP2[iR] = E((Object[]) obj3, i11, i10, eVar);
        return objArrP2;
    }

    public final Object F(Object[] objArr, int i2, int i10, int i11) {
        int i12 = this.f3344m - i2;
        if (i12 == 1) {
            Object obj = this.f3343l[0];
            v(objArr, i2, i10);
            return obj;
        }
        Object[] objArr2 = this.f3343l;
        Object obj2 = objArr2[i11];
        Object[] objArrP = p(objArr2);
        n.Y(objArr2, objArrP, i11, i11 + 1, i12);
        objArrP[i12 - 1] = null;
        this.f3342k = objArr;
        this.f3343l = objArrP;
        this.f3344m = (i2 + i12) - 1;
        this.f3340i = i10;
        return obj2;
    }

    public final int G() {
        int i2 = this.f3344m;
        if (i2 <= 32) {
            return 0;
        }
        return (i2 - 1) & (-32);
    }

    public final Object[] H(Object[] objArr, int i2, int i10, Object obj, e eVar) {
        int iR = a.a.R(i10, i2);
        Object[] objArrP = p(objArr);
        if (i2 != 0) {
            Object obj2 = objArrP[iR];
            q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrP[iR] = H((Object[]) obj2, i2 - 5, i10, obj, eVar);
            return objArrP;
        }
        if (objArrP != objArr) {
            ((AbstractList) this).modCount++;
        }
        eVar.f3332a = objArrP[iR];
        objArrP[iR] = obj;
        return objArrP;
    }

    public final void I(Collection collection, int i2, Object[] objArr, int i10, Object[][] objArr2, int i11, Object[] objArr3) {
        Object[] objArrR;
        if (i11 < 1) {
            u1.a("requires at least one nullBuffer");
        }
        Object[] objArrP = p(objArr);
        objArr2[0] = objArrP;
        int i12 = i2 & 31;
        int size = ((collection.size() + i2) - 1) & 31;
        int i13 = (i10 - i12) + size;
        if (i13 < 32) {
            n.Y(objArrP, objArr3, size + 1, i12, i10);
        } else {
            int i14 = i13 - 31;
            if (i11 == 1) {
                objArrR = objArrP;
            } else {
                objArrR = r();
                i11--;
                objArr2[i11] = objArrR;
            }
            int i15 = i10 - i14;
            n.Y(objArrP, objArr3, 0, i15, i10);
            n.Y(objArrP, objArrR, size + 1, i12, i15);
            objArr3 = objArrR;
        }
        Iterator it = collection.iterator();
        i(objArrP, i12, it);
        for (int i16 = 1; i16 < i11; i16++) {
            Object[] objArrR2 = r();
            i(objArrR2, 0, it);
            objArr2[i16] = objArrR2;
        }
        i(objArr3, 0, it);
    }

    public final int J() {
        int i2 = this.f3344m;
        return i2 <= 32 ? i2 : i2 - ((i2 - 1) & (-32));
    }

    @Override // d7.h
    public final int a() {
        return this.f3344m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        a.a.h(i2, a());
        if (i2 == a()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iG = G();
        if (i2 >= iG) {
            m(this.f3342k, i2 - iG, obj);
            return;
        }
        e eVar = new e(null);
        Object[] objArr = this.f3342k;
        q7.k.b(objArr);
        m(l(objArr, this.f3340i, i2, obj, eVar), 0, eVar.f3332a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        Collection collection2;
        Object[] objArrR;
        a.a.h(i2, this.f3344m);
        if (i2 == this.f3344m) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i10 = (i2 >> 5) << 5;
        int size = ((collection.size() + (this.f3344m - i10)) - 1) / 32;
        if (size == 0) {
            int i11 = i2 & 31;
            int size2 = ((collection.size() + i2) - 1) & 31;
            Object[] objArr = this.f3343l;
            Object[] objArrP = p(objArr);
            n.Y(objArr, objArrP, size2 + 1, i11, J());
            i(objArrP, i11, collection.iterator());
            this.f3343l = objArrP;
            this.f3344m = collection.size() + this.f3344m;
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iJ = J();
        int size3 = collection.size() + this.f3344m;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (i2 >= G()) {
            objArrR = r();
            collection2 = collection;
            I(collection2, i2, this.f3343l, iJ, objArr2, size, objArrR);
            objArr2 = objArr2;
        } else {
            collection2 = collection;
            if (size3 > iJ) {
                int i12 = size3 - iJ;
                Object[] objArrQ = q(i12, this.f3343l);
                k(collection2, i2, i12, objArr2, size, objArrQ);
                objArr2 = objArr2;
                objArrR = objArrQ;
            } else {
                Object[] objArr3 = this.f3343l;
                objArrR = r();
                int i13 = iJ - size3;
                n.Y(objArr3, objArrR, 0, i13, iJ);
                int i14 = 32 - i13;
                Object[] objArrQ2 = q(i14, this.f3343l);
                int i15 = size - 1;
                objArr2[i15] = objArrQ2;
                k(collection2, i2, i14, objArr2, i15, objArrQ2);
                collection2 = collection2;
            }
        }
        this.f3342k = x(this.f3342k, i10, objArr2);
        this.f3343l = objArrR;
        this.f3344m = collection2.size() + this.f3344m;
        return true;
    }

    @Override // d7.h
    public final Object f(int i2) {
        a.a.g(i2, a());
        ((AbstractList) this).modCount++;
        int iG = G();
        if (i2 >= iG) {
            return F(this.f3342k, iG, this.f3340i, i2 - iG);
        }
        e eVar = new e(this.f3343l[0]);
        Object[] objArr = this.f3342k;
        q7.k.b(objArr);
        F(E(objArr, this.f3340i, i2, eVar), iG, this.f3340i, 0);
        return eVar.f3332a;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        Object[] objArr;
        a.a.g(i2, a());
        if (G() <= i2) {
            objArr = this.f3343l;
        } else {
            Object[] objArr2 = this.f3342k;
            q7.k.b(objArr2);
            for (int i10 = this.f3340i; i10 > 0; i10 -= 5) {
                Object[] objArr3 = objArr2[a.a.R(i2, i10)];
                q7.k.c(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i2 & 31];
    }

    public final c h() {
        c fVar;
        Object[] objArr = this.f3342k;
        if (objArr == this.f3338g && this.f3343l == this.f3339h) {
            fVar = this.f3337f;
        } else {
            this.f3341j = new i0.b();
            this.f3338g = objArr;
            Object[] objArr2 = this.f3343l;
            this.f3339h = objArr2;
            if (objArr != null) {
                fVar = new f(objArr, objArr2, this.f3344m, this.f3340i);
            } else if (objArr2.length == 0) {
                fVar = j.f3351g;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr2, this.f3344m);
                q7.k.d(objArrCopyOf, "copyOf(...)");
                fVar = new j(objArrCopyOf);
            }
        }
        this.f3337f = fVar;
        return fVar;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j() {
        return ((AbstractList) this).modCount;
    }

    public final void k(Collection collection, int i2, int i10, Object[][] objArr, int i11, Object[] objArr2) {
        if (this.f3342k == null) {
            throw new IllegalStateException("root is null");
        }
        int i12 = i2 >> 5;
        a aVarO = o(G() >> 5);
        int i13 = i11;
        Object[] objArrQ = objArr2;
        while (aVarO.f3326f - 1 != i12) {
            Object[] objArr3 = (Object[]) aVarO.previous();
            n.Y(objArr3, objArrQ, 0, 32 - i10, 32);
            objArrQ = q(i10, objArr3);
            i13--;
            objArr[i13] = objArrQ;
        }
        Object[] objArr4 = (Object[]) aVarO.previous();
        int iG = i11 - (((G() >> 5) - 1) - i12);
        if (iG < i11) {
            objArr2 = objArr[iG];
            q7.k.b(objArr2);
        }
        I(collection, i2, objArr4, 32, objArr, iG, objArr2);
    }

    public final Object[] l(Object[] objArr, int i2, int i10, Object obj, e eVar) {
        Object obj2;
        int iR = a.a.R(i10, i2);
        if (i2 == 0) {
            eVar.f3332a = objArr[31];
            Object[] objArrP = p(objArr);
            n.Y(objArr, objArrP, iR + 1, iR, 31);
            objArrP[iR] = obj;
            return objArrP;
        }
        Object[] objArrP2 = p(objArr);
        int i11 = i2 - 5;
        Object obj3 = objArrP2[iR];
        q7.k.c(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrP2[iR] = l((Object[]) obj3, i11, i10, obj, eVar);
        while (true) {
            iR++;
            if (iR >= 32 || (obj2 = objArrP2[iR]) == null) {
                break;
            }
            objArrP2[iR] = l((Object[]) obj2, i11, 0, eVar.f3332a, eVar);
        }
        return objArrP2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        a.a.h(i2, this.f3344m);
        return new i(this, i2);
    }

    public final void m(Object[] objArr, int i2, Object obj) {
        int iJ = J();
        Object[] objArrP = p(this.f3343l);
        if (iJ < 32) {
            n.Y(this.f3343l, objArrP, i2 + 1, i2, iJ);
            objArrP[i2] = obj;
            this.f3342k = objArr;
            this.f3343l = objArrP;
            this.f3344m++;
            return;
        }
        Object[] objArr2 = this.f3343l;
        Object obj2 = objArr2[31];
        n.Y(objArr2, objArrP, i2 + 1, i2, 31);
        objArrP[i2] = obj;
        y(objArr, objArrP, s(obj2));
    }

    public final boolean n(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f3341j;
    }

    public final a o(int i2) {
        Object[] objArr = this.f3342k;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root");
        }
        int iG = G() >> 5;
        a.a.h(i2, iG);
        int i10 = this.f3340i;
        return i10 == 0 ? new d(i2, objArr) : new k(objArr, i2, iG, i10 / 5);
    }

    public final Object[] p(Object[] objArr) {
        if (objArr == null) {
            return r();
        }
        if (n(objArr)) {
            return objArr;
        }
        Object[] objArrR = r();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        n.a0(objArr, objArrR, 0, length, 6);
        return objArrR;
    }

    public final Object[] q(int i2, Object[] objArr) {
        if (n(objArr)) {
            n.Y(objArr, objArr, i2, 0, 32 - i2);
            return objArr;
        }
        Object[] objArrR = r();
        n.Y(objArr, objArrR, i2, 0, 32 - i2);
        return objArrR;
    }

    public final Object[] r() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f3341j;
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        return D(new b(1, collection));
    }

    public final Object[] s(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f3341j;
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a.a.g(i2, a());
        if (G() > i2) {
            e eVar = new e(null);
            Object[] objArr = this.f3342k;
            q7.k.b(objArr);
            this.f3342k = H(objArr, this.f3340i, i2, obj, eVar);
            return eVar.f3332a;
        }
        Object[] objArrP = p(this.f3343l);
        if (objArrP != this.f3343l) {
            ((AbstractList) this).modCount++;
        }
        int i10 = i2 & 31;
        Object obj2 = objArrP[i10];
        objArrP[i10] = obj;
        this.f3343l = objArrP;
        return obj2;
    }

    public final Object[] t(Object[] objArr, int i2, int i10) {
        if (i10 < 0) {
            u1.a("shift should be positive");
        }
        if (i10 == 0) {
            return objArr;
        }
        int iR = a.a.R(i2, i10);
        Object obj = objArr[iR];
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object objT = t((Object[]) obj, i2, i10 - 5);
        if (iR < 31) {
            int i11 = iR + 1;
            if (objArr[i11] != null) {
                if (n(objArr)) {
                    Arrays.fill(objArr, i11, 32, (Object) null);
                }
                Object[] objArrR = r();
                n.Y(objArr, objArrR, 0, 0, i11);
                objArr = objArrR;
            }
        }
        if (objT == objArr[iR]) {
            return objArr;
        }
        Object[] objArrP = p(objArr);
        objArrP[iR] = objT;
        return objArrP;
    }

    public final Object[] u(Object[] objArr, int i2, int i10, e eVar) {
        Object[] objArrU;
        int iR = a.a.R(i10 - 1, i2);
        if (i2 == 5) {
            eVar.f3332a = objArr[iR];
            objArrU = null;
        } else {
            Object obj = objArr[iR];
            q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrU = u((Object[]) obj, i2 - 5, i10, eVar);
        }
        if (objArrU == null && iR == 0) {
            return null;
        }
        Object[] objArrP = p(objArr);
        objArrP[iR] = objArrU;
        return objArrP;
    }

    public final void v(Object[] objArr, int i2, int i10) {
        if (i10 == 0) {
            this.f3342k = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f3343l = objArr;
            this.f3344m = i2;
            this.f3340i = i10;
            return;
        }
        e eVar = new e(null);
        q7.k.b(objArr);
        Object[] objArrU = u(objArr, i10, i2, eVar);
        q7.k.b(objArrU);
        Object obj = eVar.f3332a;
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.f3343l = (Object[]) obj;
        this.f3344m = i2;
        if (objArrU[1] == null) {
            this.f3342k = (Object[]) objArrU[0];
            this.f3340i = i10 - 5;
        } else {
            this.f3342k = objArrU;
            this.f3340i = i10;
        }
    }

    public final Object[] w(Object[] objArr, int i2, int i10, Iterator it) {
        if (!it.hasNext()) {
            u1.a("invalid buffersIterator");
        }
        if (!(i10 >= 0)) {
            u1.a("negative shift");
        }
        if (i10 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrP = p(objArr);
        int iR = a.a.R(i2, i10);
        int i11 = i10 - 5;
        objArrP[iR] = w((Object[]) objArrP[iR], i2, i11, it);
        while (true) {
            iR++;
            if (iR >= 32 || !it.hasNext()) {
                break;
            }
            objArrP[iR] = w((Object[]) objArrP[iR], 0, i11, it);
        }
        return objArrP;
    }

    public final Object[] x(Object[] objArr, int i2, Object[][] objArr2) {
        d7.c cVarH = q7.k.h(objArr2);
        int i10 = i2 >> 5;
        int i11 = this.f3340i;
        Object[] objArrW = i10 < (1 << i11) ? w(objArr, i2, i11, cVarH) : p(objArr);
        while (cVarH.hasNext()) {
            this.f3340i += 5;
            objArrW = s(objArrW);
            int i12 = this.f3340i;
            w(objArrW, 1 << i12, i12, cVarH);
        }
        return objArrW;
    }

    public final void y(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i2 = this.f3344m;
        int i10 = i2 >> 5;
        int i11 = this.f3340i;
        if (i10 > (1 << i11)) {
            this.f3342k = z(this.f3340i + 5, s(objArr), objArr2);
            this.f3343l = objArr3;
            this.f3340i += 5;
            this.f3344m++;
            return;
        }
        if (objArr == null) {
            this.f3342k = objArr2;
            this.f3343l = objArr3;
            this.f3344m = i2 + 1;
        } else {
            this.f3342k = z(i11, objArr, objArr2);
            this.f3343l = objArr3;
            this.f3344m++;
        }
    }

    public final Object[] z(int i2, Object[] objArr, Object[] objArr2) {
        int iR = a.a.R(a() - 1, i2);
        Object[] objArrP = p(objArr);
        if (i2 == 5) {
            objArrP[iR] = objArr2;
            return objArrP;
        }
        objArrP[iR] = z(i2 - 5, (Object[]) objArrP[iR], objArr2);
        return objArrP;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iJ = J();
        if (iJ < 32) {
            Object[] objArrP = p(this.f3343l);
            objArrP[iJ] = obj;
            this.f3343l = objArrP;
            this.f3344m = a() + 1;
        } else {
            y(this.f3342k, this.f3343l, s(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iJ = J();
        Iterator it = collection.iterator();
        if (32 - iJ >= collection.size()) {
            Object[] objArrP = p(this.f3343l);
            i(objArrP, iJ, it);
            this.f3343l = objArrP;
            this.f3344m = collection.size() + this.f3344m;
            return true;
        }
        int size = ((collection.size() + iJ) - 1) / 32;
        Object[][] objArr = new Object[size][];
        Object[] objArrP2 = p(this.f3343l);
        i(objArrP2, iJ, it);
        objArr[0] = objArrP2;
        for (int i2 = 1; i2 < size; i2++) {
            Object[] objArrR = r();
            i(objArrR, 0, it);
            objArr[i2] = objArrR;
        }
        this.f3342k = x(this.f3342k, G(), objArr);
        Object[] objArrR2 = r();
        i(objArrR2, 0, it);
        this.f3343l = objArrR2;
        this.f3344m = collection.size() + this.f3344m;
        return true;
    }
}
