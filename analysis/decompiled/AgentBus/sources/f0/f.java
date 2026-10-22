package f0;

import b0.u1;
import d7.n;
import java.util.Arrays;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f3333f;

    /* renamed from: g, reason: collision with root package name */
    public final Object[] f3334g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3335h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3336i;

    public f(Object[] objArr, Object[] objArr2, int i2, int i10) {
        this.f3333f = objArr;
        this.f3334g = objArr2;
        this.f3335h = i2;
        this.f3336i = i10;
        if (!(a() > 32)) {
            u1.a("Trie-based persistent vector should have at least 33 elements, got " + a());
        }
        int length = objArr2.length;
    }

    public static Object[] n(Object[] objArr, int i2, int i10, Object obj, e eVar) {
        Object[] objArrCopyOf;
        int iR = a.a.R(i10, i2);
        if (i2 == 0) {
            if (iR == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                q7.k.d(objArrCopyOf, "copyOf(...)");
            }
            n.Y(objArr, objArrCopyOf, iR + 1, iR, 31);
            eVar.f3332a = objArr[31];
            objArrCopyOf[iR] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        q7.k.d(objArrCopyOf2, "copyOf(...)");
        int i11 = i2 - 5;
        Object obj2 = objArr[iR];
        q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iR] = n((Object[]) obj2, i11, i10, obj, eVar);
        while (true) {
            iR++;
            if (iR >= 32 || objArrCopyOf2[iR] == null) {
                break;
            }
            Object obj3 = objArr[iR];
            q7.k.c(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf2[iR] = n((Object[]) obj3, i11, 0, eVar.f3332a, eVar);
        }
        return objArrCopyOf2;
    }

    public static Object[] p(Object[] objArr, int i2, int i10, e eVar) {
        Object[] objArrP;
        int iR = a.a.R(i10, i2);
        if (i2 == 5) {
            eVar.f3332a = objArr[iR];
            objArrP = null;
        } else {
            Object obj = objArr[iR];
            q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrP = p((Object[]) obj, i2 - 5, i10, eVar);
        }
        if (objArrP == null && iR == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iR] = objArrP;
        return objArrCopyOf;
    }

    public static Object[] v(Object[] objArr, int i2, int i10, Object obj) {
        int iR = a.a.R(i10, i2);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        if (i2 == 0) {
            objArrCopyOf[iR] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iR];
        q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf[iR] = v((Object[]) obj2, i2 - 5, i10, obj);
        return objArrCopyOf;
    }

    @Override // d7.a
    public final int a() {
        return this.f3335h;
    }

    @Override // f0.c
    public final c f(int i2, Object obj) {
        int i10 = this.f3335h;
        a.a.h(i2, i10);
        if (i2 == i10) {
            return h(obj);
        }
        int iU = u();
        Object[] objArr = this.f3333f;
        if (i2 >= iU) {
            return o(objArr, i2 - iU, obj);
        }
        e eVar = new e(null);
        return o(n(objArr, this.f3336i, i2, obj, eVar), 0, eVar.f3332a);
    }

    @Override // java.util.List
    public final Object get(int i2) {
        Object[] objArr;
        a.a.g(i2, a());
        if (u() <= i2) {
            objArr = this.f3334g;
        } else {
            Object[] objArr2 = this.f3333f;
            for (int i10 = this.f3336i; i10 > 0; i10 -= 5) {
                Object[] objArr3 = objArr2[a.a.R(i2, i10)];
                q7.k.c(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i2 & 31];
    }

    @Override // f0.c
    public final c h(Object obj) {
        int iU = u();
        int i2 = this.f3335h;
        int i10 = i2 - iU;
        Object[] objArr = this.f3333f;
        Object[] objArr2 = this.f3334g;
        if (i10 >= 32) {
            Object[] objArr3 = new Object[32];
            objArr3[0] = obj;
            return q(objArr, objArr2, objArr3);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i10] = obj;
        return new f(objArr, objArrCopyOf, i2 + 1, this.f3336i);
    }

    @Override // f0.c
    public final g j() {
        return new g(this, this.f3333f, this.f3334g, this.f3336i);
    }

    @Override // f0.c
    public final c k(b bVar) {
        g gVar = new g(this, this.f3333f, this.f3334g, this.f3336i);
        gVar.D(bVar);
        return gVar.h();
    }

    @Override // f0.c
    public final c l(int i2) {
        a.a.g(i2, this.f3335h);
        int iU = u();
        Object[] objArr = this.f3333f;
        int i10 = this.f3336i;
        return i2 >= iU ? t(objArr, iU, i10, i2 - iU) : t(s(objArr, i10, i2, new e(this.f3334g[0])), iU, i10, 0);
    }

    @Override // d7.f, java.util.List
    public final ListIterator listIterator(int i2) {
        a.a.h(i2, this.f3335h);
        return new h(this.f3333f, this.f3334g, i2, this.f3335h, (this.f3336i / 5) + 1);
    }

    @Override // f0.c
    public final c m(int i2, Object obj) {
        int i10 = this.f3335h;
        a.a.g(i2, i10);
        int iU = u();
        Object[] objArr = this.f3333f;
        Object[] objArr2 = this.f3334g;
        int i11 = this.f3336i;
        if (iU > i2) {
            return new f(v(objArr, i11, i2, obj), objArr2, i10, i11);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i2 & 31] = obj;
        return new f(objArr, objArrCopyOf, i10, i11);
    }

    public final f o(Object[] objArr, int i2, Object obj) {
        int iU = u();
        int i10 = this.f3335h;
        int i11 = i10 - iU;
        Object[] objArr2 = this.f3334g;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        q7.k.d(objArrCopyOf, "copyOf(...)");
        if (i11 < 32) {
            n.Y(objArr2, objArrCopyOf, i2 + 1, i2, i11);
            objArrCopyOf[i2] = obj;
            return new f(objArr, objArrCopyOf, i10 + 1, this.f3336i);
        }
        Object obj2 = objArr2[31];
        n.Y(objArr2, objArrCopyOf, i2 + 1, i2, i11 - 1);
        objArrCopyOf[i2] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return q(objArr, objArrCopyOf, objArr3);
    }

    public final f q(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i2 = this.f3335h;
        int i10 = i2 >> 5;
        int i11 = this.f3336i;
        if (i10 <= (1 << i11)) {
            return new f(r(i11, objArr, objArr2), objArr3, i2 + 1, i11);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i12 = i11 + 5;
        return new f(r(i12, objArr4, objArr2), objArr3, i2 + 1, i12);
    }

    public final Object[] r(int i2, Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf;
        int iR = a.a.R(a() - 1, i2);
        if (objArr != null) {
            objArrCopyOf = Arrays.copyOf(objArr, 32);
            q7.k.d(objArrCopyOf, "copyOf(...)");
        } else {
            objArrCopyOf = new Object[32];
        }
        if (i2 == 5) {
            objArrCopyOf[iR] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iR] = r(i2 - 5, (Object[]) objArrCopyOf[iR], objArr2);
        return objArrCopyOf;
    }

    public final Object[] s(Object[] objArr, int i2, int i10, e eVar) {
        Object[] objArrCopyOf;
        int iR = a.a.R(i10, i2);
        if (i2 == 0) {
            if (iR == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                q7.k.d(objArrCopyOf, "copyOf(...)");
            }
            n.Y(objArr, objArrCopyOf, iR, iR + 1, 32);
            objArrCopyOf[31] = eVar.f3332a;
            eVar.f3332a = objArr[iR];
            return objArrCopyOf;
        }
        int iR2 = objArr[31] == null ? a.a.R(u() - 1, i2) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        q7.k.d(objArrCopyOf2, "copyOf(...)");
        int i11 = i2 - 5;
        int i12 = iR + 1;
        if (i12 <= iR2) {
            while (true) {
                Object obj = objArrCopyOf2[iR2];
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iR2] = s((Object[]) obj, i11, 0, eVar);
                if (iR2 == i12) {
                    break;
                }
                iR2--;
            }
        }
        Object obj2 = objArrCopyOf2[iR];
        q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iR] = s((Object[]) obj2, i11, i10, eVar);
        return objArrCopyOf2;
    }

    public final c t(Object[] objArr, int i2, int i10, int i11) {
        int i12 = this.f3335h - i2;
        if (i12 != 1) {
            Object[] objArr2 = this.f3334g;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            int i13 = i12 - 1;
            if (i11 < i13) {
                n.Y(objArr2, objArrCopyOf, i11, i11 + 1, i12);
            }
            objArrCopyOf[i13] = null;
            return new f(objArr, objArrCopyOf, (i2 + i12) - 1, i10);
        }
        if (i10 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                q7.k.d(objArr, "copyOf(...)");
            }
            return new j(objArr);
        }
        e eVar = new e(null);
        Object[] objArrP = p(objArr, i10, i2 - 1, eVar);
        q7.k.b(objArrP);
        Object obj = eVar.f3332a;
        q7.k.c(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr3 = (Object[]) obj;
        if (objArrP[1] != null) {
            return new f(objArrP, objArr3, i2, i10);
        }
        Object obj2 = objArrP[0];
        q7.k.c(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new f((Object[]) obj2, objArr3, i2, i10 - 5);
    }

    public final int u() {
        return (this.f3335h - 1) & (-32);
    }
}
