package t;

import androidx.datastore.preferences.protobuf.b1;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f<E> extends mb.f<E> implements Collection, ac.b {

    /* renamed from: a, reason: collision with root package name */
    public s.b<? extends E> f12880a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f12881b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f12882c;

    /* renamed from: d, reason: collision with root package name */
    public int f12883d;

    /* renamed from: e, reason: collision with root package name */
    public w.b f12884e = new w.b();
    public Object[] h;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f12885j;

    /* renamed from: k, reason: collision with root package name */
    public int f12886k;

    public f(c cVar, Object[] objArr, Object[] objArr2, int i10) {
        this.f12880a = cVar;
        this.f12881b = objArr;
        this.f12882c = objArr2;
        this.f12883d = i10;
        this.h = objArr;
        this.f12885j = objArr2;
        this.f12886k = cVar.a();
    }

    public static void e(Object[] objArr, int i10, Iterator it) {
        while (i10 < 32 && it.hasNext()) {
            objArr[i10] = it.next();
            i10++;
        }
    }

    public final int A(l<? super E, Boolean> lVar, int i10, ge.e eVar) {
        int iZ = z(lVar, this.f12885j, i10, eVar);
        if (iZ == i10) {
            return i10;
        }
        Object obj = eVar.f9167a;
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, iZ, i10, (Object) null);
        this.f12885j = objArr;
        this.f12886k -= i10 - iZ;
        return iZ;
    }

    public final boolean B(l<? super E, Boolean> lVar) {
        Object[] objArrT;
        int i10;
        l<? super E, Boolean> lVar2 = lVar;
        int I = I();
        Object[] objArrQ = null;
        ge.e eVar = new ge.e(null, 1);
        boolean z = false;
        if (this.h != null) {
            a aVarK = k(0);
            int iZ = 32;
            while (iZ == 32 && aVarK.hasNext()) {
                iZ = z(lVar2, (Object[]) aVarK.next(), 32, eVar);
            }
            if (iZ == 32) {
                int iA = A(lVar2, I, eVar);
                if (iA == 0) {
                    s(this.h, this.f12886k, this.f12883d);
                }
                if (iA != I) {
                }
            } else {
                int i11 = (aVarK.f12871a - 1) << 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int iY = iZ;
                while (aVarK.hasNext()) {
                    iY = y(lVar2, (Object[]) aVarK.next(), 32, iY, eVar, arrayList2, arrayList);
                    lVar2 = lVar;
                }
                int iY2 = y(lVar, this.f12885j, I, iY, eVar, arrayList2, arrayList);
                Object obj = eVar.f9167a;
                kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                Object[] objArr = (Object[]) obj;
                Arrays.fill(objArr, iY2, 32, (Object) null);
                if (arrayList.isEmpty()) {
                    objArrT = this.h;
                    kotlin.jvm.internal.g.c(objArrT);
                } else {
                    objArrT = t(this.h, i11, this.f12883d, arrayList.iterator());
                }
                int size = i11 + (arrayList.size() << 5);
                if ((size & 31) != 0) {
                    androidx.compose.runtime.f.a("invalid size");
                }
                if (size == 0) {
                    this.f12883d = 0;
                } else {
                    int i12 = size - 1;
                    while (true) {
                        i10 = this.f12883d;
                        if ((i12 >> i10) != 0) {
                            break;
                        }
                        this.f12883d = i10 - 5;
                        Object[] objArr2 = objArrT[0];
                        kotlin.jvm.internal.g.d(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                        objArrT = objArr2;
                    }
                    objArrQ = q(objArrT, i12, i10);
                }
                this.h = objArrQ;
                this.f12885j = objArr;
                this.f12886k = size + iY2;
            }
            z = true;
        } else if (A(lVar2, I, eVar) != I) {
            z = true;
        }
        if (z) {
            ((AbstractList) this).modCount++;
        }
        return z;
    }

    public final Object[] D(Object[] objArr, int i10, int i11, ge.e eVar) {
        int iV = jd.b.v(i11, i10);
        if (i10 == 0) {
            Object obj = objArr[iV];
            Object[] objArrL = l(objArr);
            b1.q(objArr, objArrL, iV, iV + 1, 32);
            objArrL[31] = eVar.f9167a;
            eVar.f9167a = obj;
            return objArrL;
        }
        int iV2 = objArr[31] == null ? jd.b.v(F() - 1, i10) : 31;
        Object[] objArrL2 = l(objArr);
        int i12 = i10 - 5;
        int i13 = iV + 1;
        if (i13 <= iV2) {
            while (true) {
                Object obj2 = objArrL2[iV2];
                kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrL2[iV2] = D((Object[]) obj2, i12, 0, eVar);
                if (iV2 == i13) {
                    break;
                }
                iV2--;
            }
        }
        Object obj3 = objArrL2[iV];
        kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrL2[iV] = D((Object[]) obj3, i12, i11, eVar);
        return objArrL2;
    }

    public final Object E(Object[] objArr, int i10, int i11, int i12) {
        int i13 = this.f12886k - i10;
        if (i13 == 1) {
            Object obj = this.f12885j[0];
            s(objArr, i10, i11);
            return obj;
        }
        Object[] objArr2 = this.f12885j;
        Object obj2 = objArr2[i12];
        Object[] objArrL = l(objArr2);
        b1.q(objArr2, objArrL, i12, i12 + 1, i13);
        objArrL[i13 - 1] = null;
        this.h = objArr;
        this.f12885j = objArrL;
        this.f12886k = (i10 + i13) - 1;
        this.f12883d = i11;
        return obj2;
    }

    public final int F() {
        int i10 = this.f12886k;
        if (i10 <= 32) {
            return 0;
        }
        return (i10 - 1) & (-32);
    }

    public final Object[] G(Object[] objArr, int i10, int i11, E e10, ge.e eVar) {
        int iV = jd.b.v(i11, i10);
        Object[] objArrL = l(objArr);
        if (i10 != 0) {
            Object obj = objArrL[iV];
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrL[iV] = G((Object[]) obj, i10 - 5, i11, e10, eVar);
            return objArrL;
        }
        if (objArrL != objArr) {
            ((AbstractList) this).modCount++;
        }
        eVar.f9167a = objArrL[iV];
        objArrL[iV] = e10;
        return objArrL;
    }

    public final void H(Collection<? extends E> collection, int i10, Object[] objArr, int i11, Object[][] objArr2, int i12, Object[] objArr3) {
        Object[] objArrN;
        if (i12 < 1) {
            androidx.compose.runtime.f.a("requires at least one nullBuffer");
        }
        Object[] objArrL = l(objArr);
        objArr2[0] = objArrL;
        int i13 = i10 & 31;
        int size = ((collection.size() + i10) - 1) & 31;
        int i14 = (i11 - i13) + size;
        if (i14 < 32) {
            b1.q(objArrL, objArr3, size + 1, i13, i11);
        } else {
            int i15 = i14 - 31;
            if (i12 == 1) {
                objArrN = objArrL;
            } else {
                objArrN = n();
                i12--;
                objArr2[i12] = objArrN;
            }
            int i16 = i11 - i15;
            b1.q(objArrL, objArr3, 0, i16, i11);
            b1.q(objArrL, objArrN, size + 1, i13, i16);
            objArr3 = objArrN;
        }
        Iterator<? extends E> it = collection.iterator();
        e(objArrL, i13, it);
        for (int i17 = 1; i17 < i12; i17++) {
            Object[] objArrN2 = n();
            e(objArrN2, 0, it);
            objArr2[i17] = objArrN2;
        }
        e(objArr3, 0, it);
    }

    public final int I() {
        int i10 = this.f12886k;
        return i10 <= 32 ? i10 : i10 - ((i10 - 1) & (-32));
    }

    @Override // mb.f
    public final int a() {
        return this.f12886k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e10) {
        jd.b.k(i10, a());
        if (i10 == a()) {
            add(e10);
            return;
        }
        ((AbstractList) this).modCount++;
        int iF = F();
        if (i10 >= iF) {
            i(this.h, i10 - iF, e10);
            return;
        }
        ge.e eVar = new ge.e(null, 1);
        Object[] objArr = this.h;
        kotlin.jvm.internal.g.c(objArr);
        i(h(objArr, this.f12883d, i10, e10, eVar), 0, eVar.f9167a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        Collection<? extends E> collection2;
        Object[] objArrN;
        jd.b.k(i10, this.f12886k);
        if (i10 == this.f12886k) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i11 = (i10 >> 5) << 5;
        int size = ((collection.size() + (this.f12886k - i11)) - 1) / 32;
        if (size == 0) {
            int i12 = i10 & 31;
            int size2 = ((collection.size() + i10) - 1) & 31;
            Object[] objArr = this.f12885j;
            Object[] objArrL = l(objArr);
            b1.q(objArr, objArrL, size2 + 1, i12, I());
            e(objArrL, i12, collection.iterator());
            this.f12885j = objArrL;
            this.f12886k = collection.size() + this.f12886k;
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int I = I();
        int size3 = collection.size() + this.f12886k;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (i10 >= F()) {
            objArrN = n();
            collection2 = collection;
            H(collection2, i10, this.f12885j, I, objArr2, size, objArrN);
            objArr2 = objArr2;
        } else {
            collection2 = collection;
            if (size3 > I) {
                int i13 = size3 - I;
                Object[] objArrM = m(this.f12885j, i13);
                g(collection2, i10, i13, objArr2, size, objArrM);
                objArr2 = objArr2;
                objArrN = objArrM;
            } else {
                Object[] objArr3 = this.f12885j;
                objArrN = n();
                int i14 = I - size3;
                b1.q(objArr3, objArrN, 0, i14, I);
                int i15 = 32 - i14;
                Object[] objArrM2 = m(this.f12885j, i15);
                int i16 = size - 1;
                objArr2[i16] = objArrM2;
                g(collection2, i10, i15, objArr2, i16, objArrM2);
                collection2 = collection2;
            }
        }
        this.h = u(this.h, i11, objArr2);
        this.f12885j = objArrN;
        this.f12886k = collection2.size() + this.f12886k;
        return true;
    }

    @Override // mb.f
    public final E b(int i10) {
        jd.b.j(i10, a());
        ((AbstractList) this).modCount++;
        int iF = F();
        if (i10 >= iF) {
            return (E) E(this.h, iF, this.f12883d, i10 - iF);
        }
        ge.e eVar = new ge.e(this.f12885j[0], 1);
        Object[] objArr = this.h;
        kotlin.jvm.internal.g.c(objArr);
        E(D(objArr, this.f12883d, i10, eVar), iF, this.f12883d, 0);
        return (E) eVar.f9167a;
    }

    public final s.b<E> c() {
        e eVar;
        Object[] objArr = this.h;
        if (objArr == this.f12881b && this.f12885j == this.f12882c) {
            eVar = this.f12880a;
        } else {
            this.f12884e = new w.b();
            this.f12881b = objArr;
            Object[] objArr2 = this.f12885j;
            this.f12882c = objArr2;
            if (objArr != null) {
                eVar = new e(objArr, objArr2, this.f12886k, this.f12883d);
            } else if (objArr2.length == 0) {
                eVar = j.f12893b;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(this.f12885j, this.f12886k);
                kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
                eVar = new j(objArrCopyOf);
            }
        }
        this.f12880a = eVar;
        return (s.b<E>) eVar;
    }

    public final int f() {
        return ((AbstractList) this).modCount;
    }

    public final void g(Collection<? extends E> collection, int i10, int i11, Object[][] objArr, int i12, Object[] objArr2) {
        if (this.h == null) {
            throw new IllegalStateException("root is null");
        }
        int i13 = i10 >> 5;
        a aVarK = k(F() >> 5);
        int i14 = i12;
        Object[] objArrM = objArr2;
        while (aVarK.f12871a - 1 != i13) {
            Object[] objArr3 = (Object[]) aVarK.previous();
            b1.q(objArr3, objArrM, 0, 32 - i11, 32);
            objArrM = m(objArr3, i11);
            i14--;
            objArr[i14] = objArrM;
        }
        Object[] objArr4 = (Object[]) aVarK.previous();
        int iF = i12 - (((F() >> 5) - 1) - i13);
        if (iF < i12) {
            objArr2 = objArr[iF];
            kotlin.jvm.internal.g.c(objArr2);
        }
        H(collection, i10, objArr4, 32, objArr, iF, objArr2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        Object[] objArr;
        jd.b.j(i10, a());
        if (F() <= i10) {
            objArr = this.f12885j;
        } else {
            Object[] objArr2 = this.h;
            kotlin.jvm.internal.g.c(objArr2);
            for (int i11 = this.f12883d; i11 > 0; i11 -= 5) {
                Object[] objArr3 = objArr2[jd.b.v(i10, i11)];
                kotlin.jvm.internal.g.d(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return (E) objArr[i10 & 31];
    }

    public final Object[] h(Object[] objArr, int i10, int i11, Object obj, ge.e eVar) {
        Object obj2;
        int iV = jd.b.v(i11, i10);
        if (i10 == 0) {
            eVar.f9167a = objArr[31];
            Object[] objArrL = l(objArr);
            b1.q(objArr, objArrL, iV + 1, iV, 31);
            objArrL[iV] = obj;
            return objArrL;
        }
        Object[] objArrL2 = l(objArr);
        int i12 = i10 - 5;
        Object obj3 = objArrL2[iV];
        kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrL2[iV] = h((Object[]) obj3, i12, i11, obj, eVar);
        while (true) {
            iV++;
            if (iV >= 32 || (obj2 = objArrL2[iV]) == null) {
                break;
            }
            objArrL2[iV] = h((Object[]) obj2, i12, 0, eVar.f9167a, eVar);
        }
        return objArrL2;
    }

    public final void i(Object[] objArr, int i10, E e10) {
        int I = I();
        Object[] objArrL = l(this.f12885j);
        if (I < 32) {
            b1.q(this.f12885j, objArrL, i10 + 1, i10, I);
            objArrL[i10] = e10;
            this.h = objArr;
            this.f12885j = objArrL;
            this.f12886k++;
            return;
        }
        Object[] objArr2 = this.f12885j;
        Object obj = objArr2[31];
        b1.q(objArr2, objArrL, i10 + 1, i10, 31);
        objArrL[i10] = e10;
        v(objArr, objArrL, p(obj));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    public final boolean j(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f12884e;
    }

    public final a k(int i10) {
        Object[] objArr = this.h;
        if (objArr == null) {
            throw new IllegalStateException("Invalid root");
        }
        int iF = F() >> 5;
        jd.b.k(i10, iF);
        int i11 = this.f12883d;
        return i11 == 0 ? new i(objArr, i10) : new k(objArr, i10, iF, i11 / 5);
    }

    public final Object[] l(Object[] objArr) {
        if (objArr == null) {
            return n();
        }
        if (j(objArr)) {
            return objArr;
        }
        Object[] objArrN = n();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        b1.t(objArr, objArrN, 0, length, 6);
        return objArrN;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int i10) {
        jd.b.k(i10, this.f12886k);
        return new h(this, i10);
    }

    public final Object[] m(Object[] objArr, int i10) {
        if (j(objArr)) {
            b1.q(objArr, objArr, i10, 0, 32 - i10);
            return objArr;
        }
        Object[] objArrN = n();
        b1.q(objArr, objArrN, i10, 0, 32 - i10);
        return objArrN;
    }

    public final Object[] n() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f12884e;
        return objArr;
    }

    public final Object[] p(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f12884e;
        return objArr;
    }

    public final Object[] q(Object[] objArr, int i10, int i11) {
        if (i11 < 0) {
            androidx.compose.runtime.f.a("shift should be positive");
        }
        if (i11 == 0) {
            return objArr;
        }
        int iV = jd.b.v(i10, i11);
        Object obj = objArr[iV];
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object objQ = q((Object[]) obj, i10, i11 - 5);
        if (iV < 31) {
            int i12 = iV + 1;
            if (objArr[i12] != null) {
                if (j(objArr)) {
                    Arrays.fill(objArr, i12, 32, (Object) null);
                }
                Object[] objArrN = n();
                b1.q(objArr, objArrN, 0, 0, i12);
                objArr = objArrN;
            }
        }
        if (objQ == objArr[iV]) {
            return objArr;
        }
        Object[] objArrL = l(objArr);
        objArrL[iV] = objQ;
        return objArrL;
    }

    public final Object[] r(Object[] objArr, int i10, int i11, ge.e eVar) {
        Object[] objArrR;
        int iV = jd.b.v(i11 - 1, i10);
        if (i10 == 5) {
            eVar.f9167a = objArr[iV];
            objArrR = null;
        } else {
            Object obj = objArr[iV];
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrR = r((Object[]) obj, i10 - 5, i11, eVar);
        }
        if (objArrR == null && iV == 0) {
            return null;
        }
        Object[] objArrL = l(objArr);
        objArrL[iV] = objArrR;
        return objArrL;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<?> collection) {
        return B(new b(1, collection));
    }

    public final void s(Object[] objArr, int i10, int i11) {
        if (i11 == 0) {
            this.h = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f12885j = objArr;
            this.f12886k = i10;
            this.f12883d = i11;
            return;
        }
        ge.e eVar = new ge.e(null, 1);
        kotlin.jvm.internal.g.c(objArr);
        Object[] objArrR = r(objArr, i11, i10, eVar);
        kotlin.jvm.internal.g.c(objArrR);
        Object obj = eVar.f9167a;
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.f12885j = (Object[]) obj;
        this.f12886k = i10;
        if (objArrR[1] == null) {
            this.h = (Object[]) objArrR[0];
            this.f12883d = i11 - 5;
        } else {
            this.h = objArrR;
            this.f12883d = i11;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e10) {
        jd.b.j(i10, a());
        if (F() > i10) {
            ge.e eVar = new ge.e(null, 1);
            Object[] objArr = this.h;
            kotlin.jvm.internal.g.c(objArr);
            this.h = G(objArr, this.f12883d, i10, e10, eVar);
            return (E) eVar.f9167a;
        }
        Object[] objArrL = l(this.f12885j);
        if (objArrL != this.f12885j) {
            ((AbstractList) this).modCount++;
        }
        int i11 = i10 & 31;
        E e11 = (E) objArrL[i11];
        objArrL[i11] = e10;
        this.f12885j = objArrL;
        return e11;
    }

    public final Object[] t(Object[] objArr, int i10, int i11, Iterator<Object[]> it) {
        if (!it.hasNext()) {
            androidx.compose.runtime.f.a("invalid buffersIterator");
        }
        if (!(i11 >= 0)) {
            androidx.compose.runtime.f.a("negative shift");
        }
        if (i11 == 0) {
            return it.next();
        }
        Object[] objArrL = l(objArr);
        int iV = jd.b.v(i10, i11);
        int i12 = i11 - 5;
        objArrL[iV] = t((Object[]) objArrL[iV], i10, i12, it);
        while (true) {
            iV++;
            if (iV >= 32 || !it.hasNext()) {
                break;
            }
            objArrL[iV] = t((Object[]) objArrL[iV], 0, i12, it);
        }
        return objArrL;
    }

    public final Object[] u(Object[] objArr, int i10, Object[][] objArr2) {
        kotlin.jvm.internal.a aVarO = b1.O(objArr2);
        int i11 = i10 >> 5;
        int i12 = this.f12883d;
        Object[] objArrT = i11 < (1 << i12) ? t(objArr, i10, i12, aVarO) : l(objArr);
        while (aVarO.hasNext()) {
            this.f12883d += 5;
            objArrT = p(objArrT);
            int i13 = this.f12883d;
            t(objArrT, 1 << i13, i13, aVarO);
        }
        return objArrT;
    }

    public final void v(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i10 = this.f12886k;
        int i11 = i10 >> 5;
        int i12 = this.f12883d;
        if (i11 > (1 << i12)) {
            this.h = x(this.f12883d + 5, p(objArr), objArr2);
            this.f12885j = objArr3;
            this.f12883d += 5;
            this.f12886k++;
            return;
        }
        if (objArr == null) {
            this.h = objArr2;
            this.f12885j = objArr3;
            this.f12886k = i10 + 1;
        } else {
            this.h = x(i12, objArr, objArr2);
            this.f12885j = objArr3;
            this.f12886k++;
        }
    }

    public final Object[] x(int i10, Object[] objArr, Object[] objArr2) {
        int iV = jd.b.v(a() - 1, i10);
        Object[] objArrL = l(objArr);
        if (i10 == 5) {
            objArrL[iV] = objArr2;
            return objArrL;
        }
        objArrL[iV] = x(i10 - 5, (Object[]) objArrL[iV], objArr2);
        return objArrL;
    }

    public final int y(l lVar, Object[] objArr, int i10, int i11, ge.e eVar, ArrayList arrayList, ArrayList arrayList2) {
        if (j(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = eVar.f9167a;
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) obj;
        Object[] objArrN = objArr2;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj2 = objArr[i12];
            if (!((Boolean) lVar.invoke(obj2)).booleanValue()) {
                if (i11 == 32) {
                    objArrN = !arrayList.isEmpty() ? (Object[]) arrayList.remove(arrayList.size() - 1) : n();
                    i11 = 0;
                }
                objArrN[i11] = obj2;
                i11++;
            }
        }
        eVar.f9167a = objArrN;
        if (objArr2 != objArrN) {
            arrayList2.add(objArr2);
        }
        return i11;
    }

    public final int z(l<? super E, Boolean> lVar, Object[] objArr, int i10, ge.e eVar) {
        Object[] objArrL = objArr;
        int i11 = i10;
        boolean z = false;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (lVar.invoke(obj).booleanValue()) {
                if (!z) {
                    objArrL = l(objArr);
                    z = true;
                    i11 = i12;
                }
            } else if (z) {
                objArrL[i11] = obj;
                i11++;
            }
        }
        eVar.f9167a = objArrL;
        return i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e10) {
        ((AbstractList) this).modCount++;
        int I = I();
        if (I < 32) {
            Object[] objArrL = l(this.f12885j);
            objArrL[I] = e10;
            this.f12885j = objArrL;
            this.f12886k = a() + 1;
        } else {
            v(this.h, this.f12885j, p(e10));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int I = I();
        Iterator<? extends E> it = collection.iterator();
        if (32 - I >= collection.size()) {
            Object[] objArrL = l(this.f12885j);
            e(objArrL, I, it);
            this.f12885j = objArrL;
            this.f12886k = collection.size() + this.f12886k;
            return true;
        }
        int size = ((collection.size() + I) - 1) / 32;
        Object[][] objArr = new Object[size][];
        Object[] objArrL2 = l(this.f12885j);
        e(objArrL2, I, it);
        objArr[0] = objArrL2;
        for (int i10 = 1; i10 < size; i10++) {
            Object[] objArrN = n();
            e(objArrN, 0, it);
            objArr[i10] = objArrN;
        }
        this.h = u(this.h, F(), objArr);
        Object[] objArrN2 = n();
        e(objArrN2, 0, it);
        this.f12885j = objArrN2;
        this.f12886k = collection.size() + this.f12886k;
        return true;
    }
}
