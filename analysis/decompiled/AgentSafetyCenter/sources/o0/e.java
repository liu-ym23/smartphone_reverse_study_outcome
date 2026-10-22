package o0;

import h5.t;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.ListIterator;
import k0.q1;
import kb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: f, reason: collision with root package name */
    public final Object[] f8980f;

    /* renamed from: g, reason: collision with root package name */
    public final Object[] f8981g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8982h;
    public final int i;

    public e(Object[] objArr, Object[] objArr2, int i, int i3) {
        this.f8980f = objArr;
        this.f8981g = objArr2;
        this.f8982h = i;
        this.i = i3;
        if (!(a() > 32)) {
            q1.a("Trie-based persistent vector should have at least 33 elements, got " + a());
        }
        int length = objArr2.length;
    }

    public static Object[] i(Object[] objArr, int i, int i3, Object obj, h7.b bVar) {
        int iD = t.D(i3, i);
        if (i == 0) {
            Object[] objArrCopyOf = iD == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            k.i0(objArr, objArrCopyOf, iD + 1, iD, 31);
            bVar.f5399a = objArr[31];
            objArrCopyOf[iD] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i10 = i - 5;
        Object obj2 = objArr[iD];
        obj2.getClass();
        objArrCopyOf2[iD] = i((Object[]) obj2, i10, i3, obj, bVar);
        while (true) {
            iD++;
            if (iD >= 32 || objArrCopyOf2[iD] == null) {
                break;
            }
            Object obj3 = objArr[iD];
            obj3.getClass();
            objArrCopyOf2[iD] = i((Object[]) obj3, i10, 0, bVar.f5399a, bVar);
        }
        return objArrCopyOf2;
    }

    public static Object[] k(Object[] objArr, int i, int i3, h7.b bVar) {
        Object[] objArrK;
        int iD = t.D(i3, i);
        if (i == 5) {
            bVar.f5399a = objArr[iD];
            objArrK = null;
        } else {
            Object obj = objArr[iD];
            obj.getClass();
            objArrK = k((Object[]) obj, i - 5, i3, bVar);
        }
        if (objArrK == null && iD == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        objArrCopyOf[iD] = objArrK;
        return objArrCopyOf;
    }

    public static Object[] q(Object obj, int i, Object[] objArr, int i3) {
        int iD = t.D(i3, i);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        if (i == 0) {
            objArrCopyOf[iD] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iD];
        obj2.getClass();
        objArrCopyOf[iD] = q(obj, i - 5, (Object[]) obj2, i3);
        return objArrCopyOf;
    }

    @Override // jb.n
    public final int a() {
        return this.f8982h;
    }

    @Override // o0.c
    public final c b(int i, Object obj) {
        int i3 = this.f8982h;
        p5.f.l(i, i3);
        if (i == i3) {
            return c(obj);
        }
        int iP = p();
        Object[] objArr = this.f8980f;
        if (i >= iP) {
            return j(objArr, i - iP, obj);
        }
        h7.b bVar = new h7.b(null);
        return j(i(objArr, this.i, i, obj, bVar), 0, bVar.f5399a);
    }

    @Override // o0.c
    public final c c(Object obj) {
        int iP = p();
        int i = this.f8982h;
        int i3 = i - iP;
        Object[] objArr = this.f8980f;
        Object[] objArr2 = this.f8981g;
        if (i3 < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            objArrCopyOf[i3] = obj;
            return new e(objArr, objArrCopyOf, i + 1, this.i);
        }
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj;
        return l(objArr, objArr2, objArr3);
    }

    @Override // o0.c
    public final f e() {
        return new f(this, this.f8980f, this.f8981g, this.i);
    }

    @Override // o0.c
    public final c f(b bVar) {
        f fVar = new f(this, this.f8980f, this.f8981g, this.i);
        fVar.y(bVar);
        return fVar.c();
    }

    @Override // o0.c
    public final c g(int i) {
        p5.f.j(i, a());
        int iP = p();
        int i3 = this.i;
        Object[] objArr = this.f8980f;
        return i >= iP ? o(objArr, iP, i3, i - iP) : o(n(objArr, i3, i, new h7.b(this.f8981g[0])), iP, i3, 0);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr;
        p5.f.j(i, a());
        if (p() <= i) {
            objArr = this.f8981g;
        } else {
            Object[] objArr2 = this.f8980f;
            for (int i3 = this.i; i3 > 0; i3 -= 5) {
                Object[] objArr3 = objArr2[t.D(i, i3)];
                objArr3.getClass();
                objArr2 = objArr3;
            }
            objArr = objArr2;
        }
        return objArr[i & 31];
    }

    @Override // o0.c
    public final c h(int i, Object obj) {
        int i3 = this.f8982h;
        p5.f.j(i, i3);
        int iP = p();
        Object[] objArr = this.f8980f;
        Object[] objArr2 = this.f8981g;
        int i10 = this.i;
        if (iP > i) {
            return new e(q(obj, i10, objArr, i), objArr2, i3, i10);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        objArrCopyOf[i & 31] = obj;
        return new e(objArr, objArrCopyOf, i3, i10);
    }

    public final e j(Object[] objArr, int i, Object obj) {
        int iP = p();
        int i3 = this.f8982h;
        int i10 = i3 - iP;
        Object[] objArr2 = this.f8981g;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        if (i10 < 32) {
            k.i0(objArr2, objArrCopyOf, i + 1, i, i10);
            objArrCopyOf[i] = obj;
            return new e(objArr, objArrCopyOf, i3 + 1, this.i);
        }
        Object obj2 = objArr2[31];
        k.i0(objArr2, objArrCopyOf, i + 1, i, i10 - 1);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return l(objArr, objArrCopyOf, objArr3);
    }

    public final e l(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.f8982h;
        int i3 = i >> 5;
        int i10 = this.i;
        if (i3 <= (1 << i10)) {
            return new e(m(objArr, objArr2, i10), objArr3, i + 1, i10);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i11 = i10 + 5;
        return new e(m(objArr4, objArr2, i11), objArr3, i + 1, i11);
    }

    @Override // kb.e, java.util.List
    public final ListIterator listIterator(int i) {
        int i3 = this.f8982h;
        p5.f.l(i, i3);
        int i10 = (this.i / 5) + 1;
        g gVar = new g(i, i3);
        gVar.f8990g = this.f8981g;
        int i11 = (i3 - 1) & (-32);
        if (i > i11) {
            i = i11;
        }
        gVar.f8991h = new j(this.f8980f, i, i11, i10);
        VarHandle.storeStoreFence();
        return gVar;
    }

    public final Object[] m(Object[] objArr, Object[] objArr2, int i) {
        int iD = t.D(a() - 1, i);
        Object[] objArrCopyOf = objArr != null ? Arrays.copyOf(objArr, 32) : new Object[32];
        if (i == 5) {
            objArrCopyOf[iD] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iD] = m((Object[]) objArrCopyOf[iD], objArr2, i - 5);
        return objArrCopyOf;
    }

    public final Object[] n(Object[] objArr, int i, int i3, h7.b bVar) {
        int iD = t.D(i3, i);
        if (i == 0) {
            Object[] objArrCopyOf = iD == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            k.i0(objArr, objArrCopyOf, iD, iD + 1, 32);
            objArrCopyOf[31] = bVar.f5399a;
            bVar.f5399a = objArr[iD];
            return objArrCopyOf;
        }
        int iD2 = objArr[31] == null ? t.D(p() - 1, i) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i10 = i - 5;
        int i11 = iD + 1;
        if (i11 <= iD2) {
            while (true) {
                Object obj = objArrCopyOf2[iD2];
                obj.getClass();
                objArrCopyOf2[iD2] = n((Object[]) obj, i10, 0, bVar);
                if (iD2 == i11) {
                    break;
                }
                iD2--;
            }
        }
        Object obj2 = objArrCopyOf2[iD];
        obj2.getClass();
        objArrCopyOf2[iD] = n((Object[]) obj2, i10, i3, bVar);
        return objArrCopyOf2;
    }

    public final c o(Object[] objArr, int i, int i3, int i10) {
        int i11 = this.f8982h - i;
        if (i11 != 1) {
            Object[] objArr2 = this.f8981g;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            int i12 = i11 - 1;
            if (i10 < i12) {
                k.i0(objArr2, objArrCopyOf, i10, i10 + 1, i11);
            }
            objArrCopyOf[i12] = null;
            return new e(objArr, objArrCopyOf, (i + i11) - 1, i3);
        }
        if (i3 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
            }
            return new i(objArr);
        }
        h7.b bVar = new h7.b(null);
        Object[] objArrK = k(objArr, i3, i - 1, bVar);
        objArrK.getClass();
        Object obj = bVar.f5399a;
        obj.getClass();
        Object[] objArr3 = (Object[]) obj;
        if (objArrK[1] != null) {
            return new e(objArrK, objArr3, i, i3);
        }
        Object obj2 = objArrK[0];
        obj2.getClass();
        return new e((Object[]) obj2, objArr3, i, i3 - 5);
    }

    public final int p() {
        return (this.f8982h - 1) & (-32);
    }
}
