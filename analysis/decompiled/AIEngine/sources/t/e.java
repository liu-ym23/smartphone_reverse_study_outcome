package t;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;
import java.util.ListIterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e<E> extends c<E> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f12876a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f12877b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12878c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12879d;

    public e(Object[] objArr, Object[] objArr2, int i10, int i11) {
        this.f12876a = objArr;
        this.f12877b = objArr2;
        this.f12878c = i10;
        this.f12879d = i11;
        if (!(a() > 32)) {
            androidx.compose.runtime.f.a("Trie-based persistent vector should have at least 33 elements, got " + a());
        }
        int length = objArr2.length;
    }

    public static Object[] b(Object[] objArr, int i10, int i11, Object obj, ge.e eVar) {
        Object[] objArrCopyOf;
        int iV = jd.b.v(i11, i10);
        if (i10 == 0) {
            if (iV == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            }
            b1.q(objArr, objArrCopyOf, iV + 1, iV, 31);
            eVar.f9167a = objArr[31];
            objArrCopyOf[iV] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf2, "copyOf(...)");
        int i12 = i10 - 5;
        Object obj2 = objArr[iV];
        kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iV] = b((Object[]) obj2, i12, i11, obj, eVar);
        while (true) {
            iV++;
            if (iV >= 32 || objArrCopyOf2[iV] == null) {
                break;
            }
            Object obj3 = objArr[iV];
            kotlin.jvm.internal.g.d(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf2[iV] = b((Object[]) obj3, i12, 0, eVar.f9167a, eVar);
        }
        return objArrCopyOf2;
    }

    public static Object[] e(Object[] objArr, int i10, int i11, ge.e eVar) {
        Object[] objArrE;
        int iV = jd.b.v(i11, i10);
        if (i10 == 5) {
            eVar.f9167a = objArr[iV];
            objArrE = null;
        } else {
            Object obj = objArr[iV];
            kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrE = e((Object[]) obj, i10 - 5, i11, eVar);
        }
        if (objArrE == null && iV == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iV] = objArrE;
        return objArrCopyOf;
    }

    public static Object[] k(Object obj, Object[] objArr, int i10, int i11) {
        int iV = jd.b.v(i11, i10);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        if (i10 == 0) {
            objArrCopyOf[iV] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iV];
        kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf[iV] = k(obj, (Object[]) obj2, i10 - 5, i11);
        return objArrCopyOf;
    }

    @Override // s.b
    public final s.b P(b bVar) {
        f fVar = new f(this, this.f12876a, this.f12877b, this.f12879d);
        fVar.B(bVar);
        return fVar.c();
    }

    @Override // mb.a
    public final int a() {
        return this.f12878c;
    }

    @Override // java.util.Collection, java.util.List, s.b
    public final s.b<E> add(E e10) {
        int iJ = j();
        int i10 = this.f12878c;
        int i11 = i10 - iJ;
        Object[] objArr = this.f12876a;
        Object[] objArr2 = this.f12877b;
        if (i11 >= 32) {
            Object[] objArr3 = new Object[32];
            objArr3[0] = e10;
            return f(objArr, objArr2, objArr3);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i11] = e10;
        return new e(objArr, objArrCopyOf, i10 + 1, this.f12879d);
    }

    @Override // s.b
    public final f builder() {
        return new f(this, this.f12876a, this.f12877b, this.f12879d);
    }

    public final e<E> c(Object[] objArr, int i10, Object obj) {
        int iJ = j();
        int i11 = this.f12878c;
        int i12 = i11 - iJ;
        Object[] objArr2 = this.f12877b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        if (i12 < 32) {
            b1.q(objArr2, objArrCopyOf, i10 + 1, i10, i12);
            objArrCopyOf[i10] = obj;
            return new e<>(objArr, objArrCopyOf, i11 + 1, this.f12879d);
        }
        Object obj2 = objArr2[31];
        b1.q(objArr2, objArrCopyOf, i10 + 1, i10, i12 - 1);
        objArrCopyOf[i10] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return f(objArr, objArrCopyOf, objArr3);
    }

    public final e<E> f(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i10 = this.f12878c;
        int i11 = i10 >> 5;
        int i12 = this.f12879d;
        if (i11 <= (1 << i12)) {
            return new e<>(g(i12, objArr, objArr2), objArr3, i10 + 1, i12);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i13 = i12 + 5;
        return new e<>(g(i13, objArr4, objArr2), objArr3, i10 + 1, i13);
    }

    public final Object[] g(int i10, Object[] objArr, Object[] objArr2) {
        Object[] objArrCopyOf;
        int iV = jd.b.v(a() - 1, i10);
        if (objArr != null) {
            objArrCopyOf = Arrays.copyOf(objArr, 32);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        } else {
            objArrCopyOf = new Object[32];
        }
        if (i10 == 5) {
            objArrCopyOf[iV] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iV] = g(i10 - 5, (Object[]) objArrCopyOf[iV], objArr2);
        return objArrCopyOf;
    }

    @Override // java.util.List
    public final E get(int i10) {
        Object[] objArr;
        jd.b.j(i10, a());
        if (j() <= i10) {
            objArr = this.f12877b;
        } else {
            Object[] objArr2 = this.f12876a;
            for (int i11 = this.f12879d; i11 > 0; i11 -= 5) {
                Object[] objArr3 = objArr2[jd.b.v(i10, i11)];
                kotlin.jvm.internal.g.d(objArr3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return (E) objArr[i10 & 31];
    }

    public final Object[] h(Object[] objArr, int i10, int i11, ge.e eVar) {
        Object[] objArrCopyOf;
        int iV = jd.b.v(i11, i10);
        if (i10 == 0) {
            if (iV == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            }
            b1.q(objArr, objArrCopyOf, iV, iV + 1, 32);
            objArrCopyOf[31] = eVar.f9167a;
            eVar.f9167a = objArr[iV];
            return objArrCopyOf;
        }
        int iV2 = objArr[31] == null ? jd.b.v(j() - 1, i10) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf2, "copyOf(...)");
        int i12 = i10 - 5;
        int i13 = iV + 1;
        if (i13 <= iV2) {
            while (true) {
                Object obj = objArrCopyOf2[iV2];
                kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iV2] = h((Object[]) obj, i12, 0, eVar);
                if (iV2 == i13) {
                    break;
                }
                iV2--;
            }
        }
        Object obj2 = objArrCopyOf2[iV];
        kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iV] = h((Object[]) obj2, i12, i11, eVar);
        return objArrCopyOf2;
    }

    public final c i(Object[] objArr, int i10, int i11, int i12) {
        int i13 = this.f12878c - i10;
        if (i13 != 1) {
            Object[] objArr2 = this.f12877b;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            int i14 = i13 - 1;
            if (i12 < i14) {
                b1.q(objArr2, objArrCopyOf, i12, i12 + 1, i13);
            }
            objArrCopyOf[i14] = null;
            return new e(objArr, objArrCopyOf, (i10 + i13) - 1, i11);
        }
        if (i11 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                kotlin.jvm.internal.g.e(objArr, "copyOf(...)");
            }
            return new j(objArr);
        }
        ge.e eVar = new ge.e(null, 1);
        Object[] objArrE = e(objArr, i11, i10 - 1, eVar);
        kotlin.jvm.internal.g.c(objArrE);
        Object obj = eVar.f9167a;
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr3 = (Object[]) obj;
        if (objArrE[1] != null) {
            return new e(objArrE, objArr3, i10, i11);
        }
        Object obj2 = objArrE[0];
        kotlin.jvm.internal.g.d(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new e((Object[]) obj2, objArr3, i10, i11 - 5);
    }

    public final int j() {
        return (this.f12878c - 1) & (-32);
    }

    @Override // mb.c, java.util.List
    public final ListIterator<E> listIterator(int i10) {
        jd.b.k(i10, this.f12878c);
        return new g(this.f12876a, this.f12877b, i10, this.f12878c, (this.f12879d / 5) + 1);
    }

    @Override // mb.c, java.util.List
    public final s.b<E> set(int i10, E e10) {
        int i11 = this.f12878c;
        jd.b.j(i10, i11);
        int iJ = j();
        Object[] objArr = this.f12876a;
        Object[] objArr2 = this.f12877b;
        int i12 = this.f12879d;
        if (iJ > i10) {
            return new e(k(e10, objArr, i12, i10), objArr2, i11, i12);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i10 & 31] = e10;
        return new e(objArr, objArrCopyOf, i11, i12);
    }

    @Override // s.b
    public final s.b<E> w(int i10) {
        jd.b.j(i10, this.f12878c);
        int iJ = j();
        Object[] objArr = this.f12876a;
        int i11 = this.f12879d;
        return i10 >= iJ ? i(objArr, iJ, i11, i10 - iJ) : i(h(objArr, i11, i10, new ge.e(this.f12877b[0], 1)), iJ, i11, 0);
    }

    @Override // java.util.List, s.b
    public final s.b<E> add(int i10, E e10) {
        int i11 = this.f12878c;
        jd.b.k(i10, i11);
        if (i10 == i11) {
            return add((e<E>) e10);
        }
        int iJ = j();
        Object[] objArr = this.f12876a;
        if (i10 >= iJ) {
            return c(objArr, i10 - iJ, e10);
        }
        ge.e eVar = new ge.e(null, 1);
        return c(b(objArr, this.f12879d, i10, e10, eVar), 0, eVar.f9167a);
    }
}
