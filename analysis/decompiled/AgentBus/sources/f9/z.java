package f9;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class z extends d {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3607m;

    /* renamed from: g, reason: collision with root package name */
    public final int f3608g;

    /* renamed from: h, reason: collision with root package name */
    public final d f3609h;

    /* renamed from: i, reason: collision with root package name */
    public final d f3610i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3611j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3612k;

    /* renamed from: l, reason: collision with root package name */
    public int f3613l = 0;

    static {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i10 = 1;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            int i11 = i10 + i2;
            i10 = i2;
            i2 = i11;
        }
        arrayList.add(Integer.MAX_VALUE);
        f3607m = new int[arrayList.size()];
        int i12 = 0;
        while (true) {
            int[] iArr = f3607m;
            if (i12 >= iArr.length) {
                return;
            }
            iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
            i12++;
        }
    }

    public z(d dVar, d dVar2) {
        this.f3609h = dVar;
        this.f3610i = dVar2;
        int size = dVar.size();
        this.f3611j = size;
        this.f3608g = dVar2.size() + size;
        this.f3612k = Math.max(dVar.j(), dVar2.j()) + 1;
    }

    public final boolean equals(Object obj) {
        int iP;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            int size = dVar.size();
            int i2 = this.f3608g;
            if (i2 == size) {
                if (i2 == 0) {
                    return true;
                }
                if (this.f3613l == 0 || (iP = dVar.p()) == 0 || this.f3613l == iP) {
                    x xVar = new x(this);
                    u uVarA = xVar.next();
                    x xVar2 = new x(dVar);
                    u uVarA2 = xVar2.next();
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (true) {
                        int length = uVarA.f3600g.length - i10;
                        int length2 = uVarA2.f3600g.length - i11;
                        int iMin = Math.min(length, length2);
                        if (!(i10 == 0 ? uVarA.t(uVarA2, i11, iMin) : uVarA2.t(uVarA, i10, iMin))) {
                            break;
                        }
                        i12 += iMin;
                        if (i12 >= i2) {
                            if (i12 == i2) {
                                return true;
                            }
                            throw new IllegalStateException();
                        }
                        if (iMin == length) {
                            uVarA = xVar.next();
                            i10 = 0;
                        } else {
                            i10 += iMin;
                        }
                        if (iMin == length2) {
                            uVarA2 = xVar2.next();
                            i11 = 0;
                        } else {
                            i11 += iMin;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN = this.f3613l;
        if (iN == 0) {
            int i2 = this.f3608g;
            iN = n(i2, 0, i2);
            if (iN == 0) {
                iN = 1;
            }
            this.f3613l = iN;
        }
        return iN;
    }

    @Override // f9.d
    public final void i(int i2, int i10, int i11, byte[] bArr) {
        int i12 = i2 + i11;
        d dVar = this.f3609h;
        int i13 = this.f3611j;
        if (i12 <= i13) {
            dVar.i(i2, i10, i11, bArr);
            return;
        }
        d dVar2 = this.f3610i;
        if (i2 >= i13) {
            dVar2.i(i2 - i13, i10, i11, bArr);
            return;
        }
        int i14 = i13 - i2;
        dVar.i(i2, i10, i14, bArr);
        dVar2.i(0, i10 + i14, i11 - i14, bArr);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new y(this);
    }

    @Override // f9.d
    public final int j() {
        return this.f3612k;
    }

    @Override // f9.d
    public final boolean k() {
        return this.f3608g >= f3607m[this.f3612k];
    }

    @Override // f9.d
    public final boolean l() {
        int iO = this.f3609h.o(0, 0, this.f3611j);
        d dVar = this.f3610i;
        return dVar.o(iO, 0, dVar.size()) == 0;
    }

    @Override // f9.d
    public final int n(int i2, int i10, int i11) {
        int i12 = i10 + i11;
        d dVar = this.f3609h;
        int i13 = this.f3611j;
        if (i12 <= i13) {
            return dVar.n(i2, i10, i11);
        }
        d dVar2 = this.f3610i;
        if (i10 >= i13) {
            return dVar2.n(i2, i10 - i13, i11);
        }
        int i14 = i13 - i10;
        return dVar2.n(dVar.n(i2, i10, i14), 0, i11 - i14);
    }

    @Override // f9.d
    public final int o(int i2, int i10, int i11) {
        int i12 = i10 + i11;
        d dVar = this.f3609h;
        int i13 = this.f3611j;
        if (i12 <= i13) {
            return dVar.o(i2, i10, i11);
        }
        d dVar2 = this.f3610i;
        if (i10 >= i13) {
            return dVar2.o(i2, i10 - i13, i11);
        }
        int i14 = i13 - i10;
        return dVar2.o(dVar.o(i2, i10, i14), 0, i11 - i14);
    }

    @Override // f9.d
    public final int p() {
        return this.f3613l;
    }

    @Override // f9.d
    public final String q() {
        byte[] bArr;
        int i2 = this.f3608g;
        if (i2 == 0) {
            bArr = q.f3596a;
        } else {
            byte[] bArr2 = new byte[i2];
            i(0, 0, i2, bArr2);
            bArr = bArr2;
        }
        return new String(bArr, "UTF-8");
    }

    @Override // f9.d
    public final void s(OutputStream outputStream, int i2, int i10) {
        int i11 = i2 + i10;
        d dVar = this.f3609h;
        int i12 = this.f3611j;
        if (i11 <= i12) {
            dVar.s(outputStream, i2, i10);
            return;
        }
        d dVar2 = this.f3610i;
        if (i2 >= i12) {
            dVar2.s(outputStream, i2 - i12, i10);
            return;
        }
        int i13 = i12 - i2;
        dVar.s(outputStream, i2, i13);
        dVar2.s(outputStream, 0, i10 - i13);
    }

    @Override // f9.d
    public final int size() {
        return this.f3608g;
    }
}
