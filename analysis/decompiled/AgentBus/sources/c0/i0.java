package c0;

import b0.s2;
import fi.iki.elonen.NanoHTTPD;
import i1.a1;

/* loaded from: classes.dex */
public final class i0 extends ib.c {

    /* renamed from: b, reason: collision with root package name */
    public int f1742b;

    /* renamed from: d, reason: collision with root package name */
    public int f1744d;

    /* renamed from: f, reason: collision with root package name */
    public int f1746f;

    /* renamed from: a, reason: collision with root package name */
    public b9.d[] f1741a = new b9.d[16];

    /* renamed from: c, reason: collision with root package name */
    public int[] f1743c = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public Object[] f1745e = new Object[16];

    public final void Q() {
        this.f1742b = 0;
        this.f1744d = 0;
        d7.n.d0(this.f1745e, 0, this.f1746f);
        this.f1746f = 0;
    }

    public final void R(b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        if (T()) {
            androidx.datastore.preferences.protobuf.k kVar = new androidx.datastore.preferences.protobuf.k(this);
            i0 i0Var = (i0) kVar.f896e;
            while (true) {
                b9.d dVar = i0Var.f1741a[kVar.f893b];
                b0.a aVarD = dVar.d(kVar);
                b0.c cVar2 = cVar;
                s2 s2Var2 = s2Var;
                a1 a1Var2 = a1Var;
                h0 h0Var2 = h0Var;
                try {
                    dVar.c(kVar, cVar2, s2Var2, a1Var2, h0Var2);
                    int i2 = kVar.f893b;
                    int i10 = i0Var.f1742b;
                    if (i2 < i10) {
                        b9.d dVar2 = i0Var.f1741a[i2];
                        kVar.f894c += dVar2.f1556b;
                        kVar.f895d += dVar2.f1557c;
                        int i11 = i2 + 1;
                        kVar.f893b = i11;
                        if (i11 >= i10) {
                            break;
                        }
                        cVar = cVar2;
                        s2Var = s2Var2;
                        a1Var = a1Var2;
                        h0Var = h0Var2;
                    } else {
                        break;
                    }
                } finally {
                }
            }
        }
        Q();
    }

    public final boolean S() {
        return this.f1742b == 0;
    }

    public final boolean T() {
        return this.f1742b != 0;
    }

    public final void U(b9.d dVar) {
        int i2 = this.f1742b;
        b9.d[] dVarArr = this.f1741a;
        int length = dVarArr.length;
        int i10 = NanoHTTPD.HTTPSession.MAX_HEADER_SIZE;
        if (i2 == length) {
            b9.d[] dVarArr2 = new b9.d[(i2 > 1024 ? 1024 : i2) + i2];
            System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
            this.f1741a = dVarArr2;
        }
        int i11 = this.f1744d;
        int i12 = dVar.f1556b;
        int i13 = dVar.f1557c;
        int i14 = i11 + i12;
        int[] iArr = this.f1743c;
        int length2 = iArr.length;
        if (i14 > length2) {
            int i15 = (length2 > 1024 ? 1024 : length2) + length2;
            if (i15 >= i14) {
                i14 = i15;
            }
            int[] iArr2 = new int[i14];
            d7.n.W(iArr, iArr2, 0, 0, length2);
            this.f1743c = iArr2;
        }
        int i16 = this.f1746f + i13;
        Object[] objArr = this.f1745e;
        int length3 = objArr.length;
        if (i16 > length3) {
            if (length3 <= 1024) {
                i10 = length3;
            }
            int i17 = i10 + length3;
            if (i17 >= i16) {
                i16 = i17;
            }
            Object[] objArr2 = new Object[i16];
            System.arraycopy(objArr, 0, objArr2, 0, length3);
            this.f1745e = objArr2;
        }
        b9.d[] dVarArr3 = this.f1741a;
        int i18 = this.f1742b;
        this.f1742b = i18 + 1;
        dVarArr3[i18] = dVar;
        this.f1744d += dVar.f1556b;
        this.f1746f += i13;
    }
}
