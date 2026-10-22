package k;

import java.util.List;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f5556a;

    /* renamed from: b, reason: collision with root package name */
    public int f5557b;

    public z(int i2) {
        this.f5556a = i2 == 0 ? f0.f5487a : new Object[i2];
    }

    public final void a(Object obj) {
        int i2 = this.f5557b + 1;
        Object[] objArr = this.f5556a;
        if (objArr.length < i2) {
            l(i2, objArr);
        }
        Object[] objArr2 = this.f5556a;
        int i10 = this.f5557b;
        objArr2[i10] = obj;
        this.f5557b = i10 + 1;
    }

    public final void b(List list) {
        if (list.isEmpty()) {
            return;
        }
        int i2 = this.f5557b;
        int size = list.size() + i2;
        Object[] objArr = this.f5556a;
        if (objArr.length < size) {
            l(size, objArr);
        }
        Object[] objArr2 = this.f5556a;
        int size2 = list.size();
        for (int i10 = 0; i10 < size2; i10++) {
            objArr2[i10 + i2] = list.get(i10);
        }
        this.f5557b = list.size() + this.f5557b;
    }

    public final void c() {
        d7.n.d0(this.f5556a, 0, this.f5557b);
        this.f5557b = 0;
    }

    public final Object d() {
        if (!g()) {
            return this.f5556a[0];
        }
        l.a.e("ObjectList is empty.");
        throw null;
    }

    public final Object e(int i2) {
        if (i2 >= 0 && i2 < this.f5557b) {
            return this.f5556a[i2];
        }
        m(i2);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            z zVar = (z) obj;
            int i2 = zVar.f5557b;
            int i10 = this.f5557b;
            if (i2 == i10) {
                Object[] objArr = this.f5556a;
                Object[] objArr2 = zVar.f5556a;
                v7.d dVarN = nb.i.N(0, i10);
                int i11 = dVarN.f10523f;
                int i12 = dVarN.f10524g;
                if (i11 > i12) {
                    return true;
                }
                while (q7.k.a(objArr[i11], objArr2[i11])) {
                    if (i11 == i12) {
                        return true;
                    }
                    i11++;
                }
                return false;
            }
        }
        return false;
    }

    public final int f(Object obj) {
        int i2 = 0;
        if (obj == null) {
            Object[] objArr = this.f5556a;
            int i10 = this.f5557b;
            while (i2 < i10) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        Object[] objArr2 = this.f5556a;
        int i11 = this.f5557b;
        while (i2 < i11) {
            if (obj.equals(objArr2[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final boolean g() {
        return this.f5557b == 0;
    }

    public final boolean h() {
        return this.f5557b != 0;
    }

    public final int hashCode() {
        Object[] objArr = this.f5556a;
        int i2 = this.f5557b;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            Object obj = objArr[i10];
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

    public final Object j(int i2) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f5557b)) {
            m(i2);
            throw null;
        }
        Object[] objArr = this.f5556a;
        Object obj = objArr[i2];
        if (i2 != i10 - 1) {
            d7.n.Y(objArr, objArr, i2, i2 + 1, i10);
        }
        int i11 = this.f5557b - 1;
        this.f5557b = i11;
        objArr[i11] = null;
        return obj;
    }

    public final void k(int i2, int i10) {
        int i11;
        if (i2 < 0 || i2 > (i11 = this.f5557b) || i10 < 0 || i10 > i11) {
            l.a.d("Start (" + i2 + ") and end (" + i10 + ") must be in 0.." + this.f5557b);
            throw null;
        }
        if (i10 < i2) {
            l.a.c("Start (" + i2 + ") is more than end (" + i10 + ')');
            throw null;
        }
        if (i10 != i2) {
            if (i10 < i11) {
                Object[] objArr = this.f5556a;
                d7.n.Y(objArr, objArr, i2, i10, i11);
            }
            int i12 = this.f5557b;
            int i13 = i12 - (i10 - i2);
            d7.n.d0(this.f5556a, i13, i12);
            this.f5557b = i13;
        }
    }

    public final void l(int i2, Object[] objArr) {
        q7.k.e(objArr, "oldContent");
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i2, (length * 3) / 2)];
        d7.n.Y(objArr, objArr2, 0, 0, length);
        this.f5556a = objArr2;
    }

    public final void m(int i2) {
        StringBuilder sbN = a1.a.n(i2, "Index ", " must be in 0..");
        sbN.append(this.f5557b - 1);
        l.a.d(sbN.toString());
        throw null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        Object[] objArr = this.f5556a;
        int i2 = this.f5557b;
        int i10 = 0;
        while (true) {
            if (i10 >= i2) {
                sb2.append((CharSequence) "]");
                break;
            }
            Object obj = objArr[i10];
            if (i10 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i10 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append((CharSequence) (obj == this ? "(this)" : String.valueOf(obj)));
            i10++;
        }
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public /* synthetic */ z() {
        this(16);
    }
}
