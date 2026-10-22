package p;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f9516a;

    /* renamed from: b, reason: collision with root package name */
    public int f9517b;

    public a0(int i) {
        this.f9516a = i == 0 ? k0.f9587a : new Object[i];
    }

    public final void a(Object obj) {
        int i = this.f9517b + 1;
        Object[] objArr = this.f9516a;
        if (objArr.length < i) {
            l(objArr, i);
        }
        Object[] objArr2 = this.f9516a;
        int i3 = this.f9517b;
        objArr2[i3] = obj;
        this.f9517b = i3 + 1;
    }

    public final void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        int i = this.f9517b;
        int size = list.size() + i;
        Object[] objArr = this.f9516a;
        if (objArr.length < size) {
            l(objArr, size);
        }
        Object[] objArr2 = this.f9516a;
        int size2 = list.size();
        for (int i3 = 0; i3 < size2; i3++) {
            objArr2[i3 + i] = list.get(i3);
        }
        this.f9517b = list.size() + this.f9517b;
    }

    public final void c() {
        kb.k.m0(null, 0, this.f9516a, this.f9517b);
        this.f9517b = 0;
    }

    public final Object d() {
        if (!g()) {
            return this.f9516a[0];
        }
        g5.f.m("ObjectList is empty.");
        return null;
    }

    public final Object e(int i) {
        if (i >= 0 && i < this.f9517b) {
            return this.f9516a[i];
        }
        m(i);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            int i = a0Var.f9517b;
            int i3 = this.f9517b;
            if (i == i3) {
                Object[] objArr = this.f9516a;
                Object[] objArr2 = a0Var.f9516a;
                ec.g gVarO = p5.f.O(0, i3);
                int i10 = gVarO.f3758c;
                int i11 = gVarO.f3759f;
                if (i10 > i11) {
                    return true;
                }
                while (yb.k.a(objArr[i10], objArr2[i10])) {
                    if (i10 == i11) {
                        return true;
                    }
                    i10++;
                }
                return false;
            }
        }
        return false;
    }

    public final int f(Object obj) {
        Object[] objArr = this.f9516a;
        int i = 0;
        if (obj == null) {
            int i3 = this.f9517b;
            while (i < i3) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i10 = this.f9517b;
        while (i < i10) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final boolean g() {
        return this.f9517b == 0;
    }

    public final boolean h() {
        return this.f9517b != 0;
    }

    public final int hashCode() {
        Object[] objArr = this.f9516a;
        int i = this.f9517b;
        int iHashCode = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final boolean i(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        j(iF);
        return true;
    }

    public final Object j(int i) {
        int i3;
        if (i < 0 || i >= (i3 = this.f9517b)) {
            m(i);
            throw null;
        }
        Object[] objArr = this.f9516a;
        Object obj = objArr[i];
        if (i != i3 - 1) {
            kb.k.i0(objArr, objArr, i, i + 1, i3);
        }
        int i10 = this.f9517b - 1;
        this.f9517b = i10;
        objArr[i10] = null;
        return obj;
    }

    public final void k(int i, int i3) {
        int i10;
        if (i < 0 || i > (i10 = this.f9517b) || i3 < 0 || i3 > i10) {
            b8.z.i(this.f9517b, k0.a.u("Start (", i, ") and end (", ") must be in 0..", i3));
            return;
        }
        if (i3 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i3 + ')');
        }
        if (i3 != i) {
            if (i3 < i10) {
                Object[] objArr = this.f9516a;
                kb.k.i0(objArr, objArr, i, i3, i10);
            }
            int i11 = this.f9517b;
            int i12 = i11 - (i3 - i);
            kb.k.m0(null, i12, this.f9516a, i11);
            this.f9517b = i12;
        }
    }

    public final void l(Object[] objArr, int i) {
        objArr.getClass();
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, (length * 3) / 2)];
        kb.k.i0(objArr, objArr2, 0, 0, length);
        this.f9516a = objArr2;
    }

    public final void m(int i) {
        StringBuilder sbT = k0.a.t(i, "Index ", " must be in 0..");
        sbT.append(this.f9517b - 1);
        throw new IndexOutOfBoundsException(sbT.toString());
    }

    public final String toString() {
        a2.m mVar = new a2.m(this, 6);
        StringBuilder sb2 = new StringBuilder("[");
        Object[] objArr = this.f9516a;
        int i = this.f9517b;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                sb2.append((CharSequence) "]");
                break;
            }
            Object obj = objArr[i3];
            if (i3 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append((CharSequence) mVar.invoke(obj));
            i3++;
        }
        return sb2.toString();
    }

    public /* synthetic */ a0() {
        this(16);
    }
}
