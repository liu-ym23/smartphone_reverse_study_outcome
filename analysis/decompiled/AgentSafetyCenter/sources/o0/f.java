package o0;

import h5.t;
import java.lang.invoke.VarHandle;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import k0.q1;
import kb.k;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends kb.f implements Collection, zb.b {

    /* renamed from: c, reason: collision with root package name */
    public c f8983c;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f8984f;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f8985g;

    /* renamed from: h, reason: collision with root package name */
    public int f8986h;
    public r0.b i = new r0.b();

    /* renamed from: j, reason: collision with root package name */
    public Object[] f8987j;

    /* renamed from: k, reason: collision with root package name */
    public Object[] f8988k;

    /* renamed from: l, reason: collision with root package name */
    public int f8989l;

    public f(c cVar, Object[] objArr, Object[] objArr2, int i) {
        this.f8983c = cVar;
        this.f8984f = objArr;
        this.f8985g = objArr2;
        this.f8986h = i;
        this.f8987j = objArr;
        this.f8988k = objArr2;
        this.f8989l = cVar.a();
    }

    public static void d(Object[] objArr, int i, Iterator it) {
        while (i < 32 && it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    public final Object A(Object[] objArr, int i, int i3, int i10) {
        int i11 = this.f8989l - i;
        Object[] objArr2 = this.f8988k;
        if (i11 == 1) {
            Object obj = objArr2[0];
            q(objArr, i, i3);
            return obj;
        }
        Object obj2 = objArr2[i10];
        Object[] objArrK = k(objArr2);
        k.i0(objArr2, objArrK, i10, i10 + 1, i11);
        objArrK[i11 - 1] = null;
        this.f8987j = objArr;
        this.f8988k = objArrK;
        this.f8989l = (i + i11) - 1;
        this.f8986h = i3;
        return obj2;
    }

    public final int B() {
        int i = this.f8989l;
        if (i <= 32) {
            return 0;
        }
        return (i - 1) & (-32);
    }

    public final Object[] C(Object[] objArr, int i, int i3, Object obj, h7.b bVar) {
        int iD = t.D(i3, i);
        Object[] objArrK = k(objArr);
        if (i != 0) {
            Object obj2 = objArrK[iD];
            obj2.getClass();
            objArrK[iD] = C((Object[]) obj2, i - 5, i3, obj, bVar);
            return objArrK;
        }
        if (objArrK != objArr) {
            ((AbstractList) this).modCount++;
        }
        bVar.f5399a = objArrK[iD];
        objArrK[iD] = obj;
        return objArrK;
    }

    public final void D(Collection collection, int i, Object[] objArr, int i3, Object[][] objArr2, int i10, Object[] objArr3) {
        Object[] objArrM;
        if (i10 < 1) {
            q1.a("requires at least one nullBuffer");
        }
        Object[] objArrK = k(objArr);
        objArr2[0] = objArrK;
        int i11 = i & 31;
        int size = ((collection.size() + i) - 1) & 31;
        int i12 = (i3 - i11) + size;
        if (i12 < 32) {
            k.i0(objArrK, objArr3, size + 1, i11, i3);
        } else {
            int i13 = i12 - 31;
            if (i10 == 1) {
                objArrM = objArrK;
            } else {
                objArrM = m();
                i10--;
                objArr2[i10] = objArrM;
            }
            int i14 = i3 - i13;
            k.i0(objArrK, objArr3, 0, i14, i3);
            k.i0(objArrK, objArrM, size + 1, i11, i14);
            objArr3 = objArrM;
        }
        Iterator it = collection.iterator();
        d(objArrK, i11, it);
        for (int i15 = 1; i15 < i10; i15++) {
            Object[] objArrM2 = m();
            d(objArrM2, 0, it);
            objArr2[i15] = objArrM2;
        }
        d(objArr3, 0, it);
    }

    public final int E() {
        int i = this.f8989l;
        return i <= 32 ? i : i - ((i - 1) & (-32));
    }

    @Override // kb.f
    public final int a() {
        return this.f8989l;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        p5.f.l(i, a());
        if (i == a()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iB = B();
        if (i >= iB) {
            h(this.f8987j, i - iB, obj);
            return;
        }
        h7.b bVar = new h7.b(null);
        Object[] objArr = this.f8987j;
        objArr.getClass();
        h(g(objArr, this.f8986h, i, obj, bVar), 0, bVar.f5399a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        Collection collection2;
        Object[] objArrM;
        p5.f.l(i, this.f8989l);
        if (i == this.f8989l) {
            return addAll(collection);
        }
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i3 = (i >> 5) << 5;
        int size = ((collection.size() + (this.f8989l - i3)) - 1) / 32;
        if (size == 0) {
            int i10 = i & 31;
            int size2 = ((collection.size() + i) - 1) & 31;
            Object[] objArr = this.f8988k;
            Object[] objArrK = k(objArr);
            k.i0(objArr, objArrK, size2 + 1, i10, E());
            d(objArrK, i10, collection.iterator());
            this.f8988k = objArrK;
            this.f8989l = collection.size() + this.f8989l;
            return true;
        }
        Object[][] objArr2 = new Object[size][];
        int iE = E();
        int size3 = collection.size() + this.f8989l;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (i >= B()) {
            objArrM = m();
            collection2 = collection;
            D(collection2, i, this.f8988k, iE, objArr2, size, objArrM);
            objArr2 = objArr2;
        } else {
            collection2 = collection;
            Object[] objArr3 = this.f8988k;
            if (size3 > iE) {
                int i11 = size3 - iE;
                Object[] objArrL = l(objArr3, i11);
                f(collection2, i, i11, objArr2, size, objArrL);
                objArr2 = objArr2;
                objArrM = objArrL;
            } else {
                objArrM = m();
                int i12 = iE - size3;
                k.i0(objArr3, objArrM, 0, i12, iE);
                int i13 = 32 - i12;
                Object[] objArrL2 = l(this.f8988k, i13);
                int i14 = size - 1;
                objArr2[i14] = objArrL2;
                f(collection2, i, i13, objArr2, i14, objArrL2);
                collection2 = collection2;
            }
        }
        this.f8987j = s(this.f8987j, i3, objArr2);
        this.f8988k = objArrM;
        this.f8989l = collection2.size() + this.f8989l;
        return true;
    }

    @Override // kb.f
    public final Object b(int i) {
        p5.f.j(i, a());
        ((AbstractList) this).modCount++;
        int iB = B();
        if (i >= iB) {
            return A(this.f8987j, iB, this.f8986h, i - iB);
        }
        h7.b bVar = new h7.b(this.f8988k[0]);
        Object[] objArr = this.f8987j;
        objArr.getClass();
        A(z(objArr, this.f8986h, i, bVar), iB, this.f8986h, 0);
        return bVar.f5399a;
    }

    public final c c() {
        c iVar;
        Object[] objArr = this.f8987j;
        if (objArr == this.f8984f && this.f8988k == this.f8985g) {
            iVar = this.f8983c;
        } else {
            this.i = new r0.b();
            this.f8984f = objArr;
            Object[] objArr2 = this.f8988k;
            this.f8985g = objArr2;
            iVar = objArr == null ? objArr2.length == 0 ? i.f8995g : new i(Arrays.copyOf(objArr2, this.f8989l)) : new e(objArr, objArr2, this.f8989l, this.f8986h);
        }
        this.f8983c = iVar;
        return iVar;
    }

    public final int e() {
        return ((AbstractList) this).modCount;
    }

    public final void f(Collection collection, int i, int i3, Object[][] objArr, int i10, Object[] objArr2) {
        if (this.f8987j == null) {
            od.f.e("root is null");
            return;
        }
        int i11 = i >> 5;
        a aVarJ = j(B() >> 5);
        int i12 = i10;
        Object[] objArrL = objArr2;
        while (aVarJ.f8974c - 1 != i11) {
            Object[] objArr3 = (Object[]) aVarJ.previous();
            k.i0(objArr3, objArrL, 0, 32 - i3, 32);
            objArrL = l(objArr3, i3);
            i12--;
            objArr[i12] = objArrL;
        }
        Object[] objArr4 = (Object[]) aVarJ.previous();
        int iB = i10 - (((B() >> 5) - 1) - i11);
        if (iB < i10) {
            objArr2 = objArr[iB];
            objArr2.getClass();
        }
        D(collection, i, objArr4, 32, objArr, iB, objArr2);
    }

    public final Object[] g(Object[] objArr, int i, int i3, Object obj, h7.b bVar) {
        Object obj2;
        int iD = t.D(i3, i);
        if (i == 0) {
            bVar.f5399a = objArr[31];
            Object[] objArrK = k(objArr);
            k.i0(objArr, objArrK, iD + 1, iD, 31);
            objArrK[iD] = obj;
            return objArrK;
        }
        Object[] objArrK2 = k(objArr);
        int i10 = i - 5;
        Object obj3 = objArrK2[iD];
        obj3.getClass();
        objArrK2[iD] = g((Object[]) obj3, i10, i3, obj, bVar);
        while (true) {
            iD++;
            if (iD >= 32 || (obj2 = objArrK2[iD]) == null) {
                break;
            }
            objArrK2[iD] = g((Object[]) obj2, i10, 0, bVar.f5399a, bVar);
        }
        return objArrK2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        Object[] objArr;
        p5.f.j(i, a());
        if (B() <= i) {
            objArr = this.f8988k;
        } else {
            Object[] objArr2 = this.f8987j;
            objArr2.getClass();
            for (int i3 = this.f8986h; i3 > 0; i3 -= 5) {
                Object[] objArr3 = objArr2[t.D(i, i3)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    public final void h(Object[] objArr, int i, Object obj) {
        int iE = E();
        Object[] objArrK = k(this.f8988k);
        Object[] objArr2 = this.f8988k;
        if (iE >= 32) {
            Object obj2 = objArr2[31];
            k.i0(objArr2, objArrK, i + 1, i, 31);
            objArrK[i] = obj;
            t(objArr, objArrK, n(obj2));
            return;
        }
        k.i0(objArr2, objArrK, i + 1, i, iE);
        objArrK[i] = obj;
        this.f8987j = objArr;
        this.f8988k = objArrK;
        this.f8989l++;
    }

    public final boolean i(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final a j(int i) {
        Object[] objArr = this.f8987j;
        if (objArr == null) {
            od.f.e("Invalid root");
            return null;
        }
        int iB = B() >> 5;
        p5.f.l(i, iB);
        int i3 = this.f8986h;
        if (i3 != 0) {
            return new j(objArr, i, iB, i3 / 5);
        }
        d dVar = new d(i, 1, 1);
        dVar.f8979h = objArr;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public final Object[] k(Object[] objArr) {
        if (objArr == null) {
            return m();
        }
        if (i(objArr)) {
            return objArr;
        }
        Object[] objArrM = m();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        k.k0(objArr, objArrM, 0, length, 6);
        return objArrM;
    }

    public final Object[] l(Object[] objArr, int i) {
        if (i(objArr)) {
            k.i0(objArr, objArr, i, 0, 32 - i);
            return objArr;
        }
        Object[] objArrM = m();
        k.i0(objArr, objArrM, i, 0, 32 - i);
        return objArrM;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        p5.f.l(i, this.f8989l);
        h hVar = new h(i, this.f8989l);
        hVar.f8992g = this;
        hVar.f8993h = ((AbstractList) this).modCount;
        hVar.f8994j = -1;
        hVar.b();
        VarHandle.storeStoreFence();
        return hVar;
    }

    public final Object[] m() {
        Object[] objArr = new Object[33];
        objArr[32] = this.i;
        return objArr;
    }

    public final Object[] n(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.i;
        return objArr;
    }

    public final Object[] o(Object[] objArr, int i, int i3) {
        if (i3 < 0) {
            q1.a("shift should be positive");
        }
        if (i3 == 0) {
            return objArr;
        }
        int iD = t.D(i, i3);
        Object obj = objArr[iD];
        obj.getClass();
        Object objO = o((Object[]) obj, i, i3 - 5);
        if (iD < 31) {
            int i10 = iD + 1;
            if (objArr[i10] != null) {
                if (i(objArr)) {
                    Arrays.fill(objArr, i10, 32, (Object) null);
                }
                Object[] objArrM = m();
                k.i0(objArr, objArrM, 0, 0, i10);
                objArr = objArrM;
            }
        }
        if (objO == objArr[iD]) {
            return objArr;
        }
        Object[] objArrK = k(objArr);
        objArrK[iD] = objO;
        return objArrK;
    }

    public final Object[] p(Object[] objArr, int i, int i3, h7.b bVar) {
        Object[] objArrP;
        int iD = t.D(i3 - 1, i);
        if (i == 5) {
            bVar.f5399a = objArr[iD];
            objArrP = null;
        } else {
            Object obj = objArr[iD];
            obj.getClass();
            objArrP = p((Object[]) obj, i - 5, i3, bVar);
        }
        if (objArrP == null && iD == 0) {
            return null;
        }
        Object[] objArrK = k(objArr);
        objArrK[iD] = objArrP;
        return objArrK;
    }

    public final void q(Object[] objArr, int i, int i3) {
        if (i3 == 0) {
            this.f8987j = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f8988k = objArr;
            this.f8989l = i;
            this.f8986h = i3;
            return;
        }
        h7.b bVar = new h7.b(null);
        objArr.getClass();
        Object[] objArrP = p(objArr, i3, i, bVar);
        objArrP.getClass();
        Object obj = bVar.f5399a;
        obj.getClass();
        this.f8988k = (Object[]) obj;
        this.f8989l = i;
        if (objArrP[1] == null) {
            this.f8987j = (Object[]) objArrP[0];
            this.f8986h = i3 - 5;
        } else {
            this.f8987j = objArrP;
            this.f8986h = i3;
        }
    }

    public final Object[] r(Object[] objArr, int i, int i3, Iterator it) {
        if (!it.hasNext()) {
            q1.a("invalid buffersIterator");
        }
        if (!(i3 >= 0)) {
            q1.a("negative shift");
        }
        if (i3 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrK = k(objArr);
        int iD = t.D(i, i3);
        int i10 = i3 - 5;
        objArrK[iD] = r((Object[]) objArrK[iD], i, i10, it);
        while (true) {
            iD++;
            if (iD >= 32 || !it.hasNext()) {
                break;
            }
            objArrK[iD] = r((Object[]) objArrK[iD], 0, i10, it);
        }
        return objArrK;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        b bVar = new b(1);
        bVar.f8977f = collection;
        VarHandle.storeStoreFence();
        return y(bVar);
    }

    public final Object[] s(Object[] objArr, int i, Object[][] objArr2) {
        kb.b bVarD = yb.k.d(objArr2);
        int i3 = i >> 5;
        int i10 = this.f8986h;
        Object[] objArrR = i3 < (1 << i10) ? r(objArr, i, i10, bVarD) : k(objArr);
        while (bVarD.hasNext()) {
            this.f8986h += 5;
            objArrR = n(objArrR);
            int i11 = this.f8986h;
            r(objArrR, 1 << i11, i11, bVarD);
        }
        return objArrR;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        p5.f.j(i, a());
        if (B() > i) {
            h7.b bVar = new h7.b(null);
            Object[] objArr = this.f8987j;
            objArr.getClass();
            this.f8987j = C(objArr, this.f8986h, i, obj, bVar);
            return bVar.f5399a;
        }
        Object[] objArrK = k(this.f8988k);
        if (objArrK != this.f8988k) {
            ((AbstractList) this).modCount++;
        }
        int i3 = i & 31;
        Object obj2 = objArrK[i3];
        objArrK[i3] = obj;
        this.f8988k = objArrK;
        return obj2;
    }

    public final void t(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.f8989l;
        int i3 = i >> 5;
        int i10 = this.f8986h;
        if (i3 > (1 << i10)) {
            this.f8987j = u(n(objArr), objArr2, this.f8986h + 5);
            this.f8988k = objArr3;
            this.f8986h += 5;
            this.f8989l++;
            return;
        }
        if (objArr == null) {
            this.f8987j = objArr2;
            this.f8988k = objArr3;
            this.f8989l = i + 1;
        } else {
            this.f8987j = u(objArr, objArr2, i10);
            this.f8988k = objArr3;
            this.f8989l++;
        }
    }

    public final Object[] u(Object[] objArr, Object[] objArr2, int i) {
        int iD = t.D(a() - 1, i);
        Object[] objArrK = k(objArr);
        if (i == 5) {
            objArrK[iD] = objArr2;
            return objArrK;
        }
        objArrK[iD] = u((Object[]) objArrK[iD], objArr2, i - 5);
        return objArrK;
    }

    public final int v(l lVar, Object[] objArr, int i, int i3, h7.b bVar, ArrayList arrayList, ArrayList arrayList2) {
        if (i(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = bVar.f5399a;
        obj.getClass();
        Object[] objArr2 = (Object[]) obj;
        Object[] objArrM = objArr2;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj2 = objArr[i10];
            if (!((Boolean) lVar.invoke(obj2)).booleanValue()) {
                if (i3 == 32) {
                    objArrM = !arrayList.isEmpty() ? (Object[]) arrayList.remove(arrayList.size() - 1) : m();
                    i3 = 0;
                }
                objArrM[i3] = obj2;
                i3++;
            }
        }
        bVar.f5399a = objArrM;
        if (objArr2 != objArrM) {
            arrayList2.add(objArr2);
        }
        return i3;
    }

    public final int w(l lVar, Object[] objArr, int i, h7.b bVar) {
        Object[] objArrK = objArr;
        int i3 = i;
        boolean z10 = false;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            if (((Boolean) lVar.invoke(obj)).booleanValue()) {
                if (!z10) {
                    objArrK = k(objArr);
                    z10 = true;
                    i3 = i10;
                }
            } else if (z10) {
                objArrK[i3] = obj;
                i3++;
            }
        }
        bVar.f5399a = objArrK;
        return i3;
    }

    public final int x(l lVar, int i, h7.b bVar) {
        int iW = w(lVar, this.f8988k, i, bVar);
        Object obj = bVar.f5399a;
        if (iW == i) {
            return i;
        }
        obj.getClass();
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, iW, i, (Object) null);
        this.f8988k = objArr;
        this.f8989l -= i - iW;
        return iW;
    }

    public final boolean y(l lVar) {
        int i;
        l lVar2 = lVar;
        int iE = E();
        Object[] objArrO = null;
        h7.b bVar = new h7.b(null);
        boolean z10 = false;
        if (this.f8987j != null) {
            a aVarJ = j(0);
            int iW = 32;
            while (iW == 32 && aVarJ.hasNext()) {
                iW = w(lVar2, (Object[]) aVarJ.next(), 32, bVar);
            }
            if (iW == 32) {
                int iX = x(lVar2, iE, bVar);
                if (iX == 0) {
                    q(this.f8987j, this.f8989l, this.f8986h);
                }
                if (iX != iE) {
                }
            } else {
                int i3 = (aVarJ.f8974c - 1) << 5;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int iV = iW;
                while (aVarJ.hasNext()) {
                    iV = v(lVar2, (Object[]) aVarJ.next(), 32, iV, bVar, arrayList2, arrayList);
                    lVar2 = lVar;
                }
                int iV2 = v(lVar, this.f8988k, iE, iV, bVar, arrayList2, arrayList);
                Object obj = bVar.f5399a;
                obj.getClass();
                Object[] objArr = (Object[]) obj;
                Arrays.fill(objArr, iV2, 32, (Object) null);
                boolean zIsEmpty = arrayList.isEmpty();
                Object[] objArrR = this.f8987j;
                if (zIsEmpty) {
                    objArrR.getClass();
                } else {
                    objArrR = r(objArrR, i3, this.f8986h, arrayList.iterator());
                }
                int size = i3 + (arrayList.size() << 5);
                if ((size & 31) != 0) {
                    q1.a("invalid size");
                }
                if (size == 0) {
                    this.f8986h = 0;
                } else {
                    int i10 = size - 1;
                    while (true) {
                        i = this.f8986h;
                        if ((i10 >> i) != 0) {
                            break;
                        }
                        this.f8986h = i - 5;
                        Object[] objArr2 = objArrR[0];
                        objArr2.getClass();
                        objArrR = objArr2;
                    }
                    objArrO = o(objArrR, i10, i);
                }
                this.f8987j = objArrO;
                this.f8988k = objArr;
                this.f8989l = size + iV2;
            }
            z10 = true;
        } else if (x(lVar2, iE, bVar) != iE) {
            z10 = true;
        }
        if (z10) {
            ((AbstractList) this).modCount++;
        }
        return z10;
    }

    public final Object[] z(Object[] objArr, int i, int i3, h7.b bVar) {
        int iD = t.D(i3, i);
        if (i == 0) {
            Object obj = objArr[iD];
            Object[] objArrK = k(objArr);
            k.i0(objArr, objArrK, iD, iD + 1, 32);
            objArrK[31] = bVar.f5399a;
            bVar.f5399a = obj;
            return objArrK;
        }
        int iD2 = objArr[31] == null ? t.D(B() - 1, i) : 31;
        Object[] objArrK2 = k(objArr);
        int i10 = i - 5;
        int i11 = iD + 1;
        if (i11 <= iD2) {
            while (true) {
                Object obj2 = objArrK2[iD2];
                obj2.getClass();
                objArrK2[iD2] = z((Object[]) obj2, i10, 0, bVar);
                if (iD2 == i11) {
                    break;
                }
                iD2--;
            }
        }
        Object obj3 = objArrK2[iD];
        obj3.getClass();
        objArrK2[iD] = z((Object[]) obj3, i10, i3, bVar);
        return objArrK2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iE = E();
        if (iE < 32) {
            Object[] objArrK = k(this.f8988k);
            objArrK[iE] = obj;
            this.f8988k = objArrK;
            this.f8989l = a() + 1;
        } else {
            t(this.f8987j, this.f8988k, n(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iE = E();
        Iterator it = collection.iterator();
        if (32 - iE >= collection.size()) {
            Object[] objArrK = k(this.f8988k);
            d(objArrK, iE, it);
            this.f8988k = objArrK;
            this.f8989l = collection.size() + this.f8989l;
            return true;
        }
        int size = ((collection.size() + iE) - 1) / 32;
        Object[][] objArr = new Object[size][];
        Object[] objArrK2 = k(this.f8988k);
        d(objArrK2, iE, it);
        objArr[0] = objArrK2;
        for (int i = 1; i < size; i++) {
            Object[] objArrM = m();
            d(objArrM, 0, it);
            objArr[i] = objArrM;
        }
        this.f8987j = s(this.f8987j, B(), objArr);
        Object[] objArrM2 = m();
        d(objArrM2, 0, it);
        this.f8988k = objArrM2;
        this.f8989l = collection.size() + this.f8989l;
        return true;
    }
}
