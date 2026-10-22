package ob;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class h0 extends k {

    /* renamed from: j, reason: collision with root package name */
    public final transient byte[][] f7994j;

    /* renamed from: k, reason: collision with root package name */
    public final transient int[] f7995k;

    public h0(byte[][] bArr, int[] iArr) {
        super(k.f7997i.f7998f);
        this.f7994j = bArr;
        this.f7995k = iArr;
    }

    @Override // ob.k
    public final String a() {
        throw null;
    }

    @Override // ob.k
    public final k c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f7994j;
        int length = bArr.length;
        int i2 = 0;
        int i10 = 0;
        while (i2 < length) {
            int[] iArr = this.f7995k;
            int i11 = iArr[length + i2];
            int i12 = iArr[i2];
            messageDigest.update(bArr[i2], i11, i12 - i10);
            i2++;
            i10 = i12;
        }
        byte[] bArrDigest = messageDigest.digest();
        q7.k.b(bArrDigest);
        return new k(bArrDigest);
    }

    @Override // ob.k
    public final int d() {
        return this.f7995k[this.f7994j.length - 1];
    }

    @Override // ob.k
    public final String e() {
        return t().e();
    }

    @Override // ob.k
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (kVar.d() == d() && m(0, kVar, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // ob.k
    public final int f(int i2, byte[] bArr) {
        q7.k.e(bArr, "other");
        return t().f(i2, bArr);
    }

    @Override // ob.k
    public final byte[] h() {
        return q();
    }

    @Override // ob.k
    public final int hashCode() {
        int i2 = this.f7999g;
        if (i2 != 0) {
            return i2;
        }
        byte[][] bArr = this.f7994j;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.f7995k;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            byte[] bArr2 = bArr[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr2[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        this.f7999g = i11;
        return i11;
    }

    @Override // ob.k
    public final byte i(int i2) {
        byte[][] bArr = this.f7994j;
        int length = bArr.length - 1;
        int[] iArr = this.f7995k;
        b.e(iArr[length], i2, 1L);
        int iG = pb.b.g(this, i2);
        return bArr[iG][(i2 - (iG == 0 ? 0 : iArr[iG - 1])) + iArr[bArr.length + iG]];
    }

    @Override // ob.k
    public final int j(byte[] bArr) {
        q7.k.e(bArr, "other");
        return t().j(bArr);
    }

    @Override // ob.k
    public final boolean l(int i2, int i10, int i11, byte[] bArr) {
        q7.k.e(bArr, "other");
        if (i2 < 0 || i2 > d() - i11 || i10 < 0 || i10 > bArr.length - i11) {
            return false;
        }
        int i12 = i11 + i2;
        int iG = pb.b.g(this, i2);
        while (i2 < i12) {
            int[] iArr = this.f7995k;
            int i13 = iG == 0 ? 0 : iArr[iG - 1];
            int i14 = iArr[iG] - i13;
            byte[][] bArr2 = this.f7994j;
            int i15 = iArr[bArr2.length + iG];
            int iMin = Math.min(i12, i14 + i13) - i2;
            if (!b.a((i2 - i13) + i15, i10, iMin, bArr2[iG], bArr)) {
                return false;
            }
            i10 += iMin;
            i2 += iMin;
            iG++;
        }
        return true;
    }

    @Override // ob.k
    public final boolean m(int i2, k kVar, int i10) {
        q7.k.e(kVar, "other");
        if (i2 >= 0 && i2 <= d() - i10) {
            int i11 = i10 + i2;
            int iG = pb.b.g(this, i2);
            int i12 = 0;
            while (i2 < i11) {
                int[] iArr = this.f7995k;
                int i13 = iG == 0 ? 0 : iArr[iG - 1];
                int i14 = iArr[iG] - i13;
                byte[][] bArr = this.f7994j;
                int i15 = iArr[bArr.length + iG];
                int iMin = Math.min(i11, i14 + i13) - i2;
                if (kVar.l(i12, (i2 - i13) + i15, iMin, bArr[iG])) {
                    i12 += iMin;
                    i2 += iMin;
                    iG++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // ob.k
    public final k n(int i2, int i10) {
        if (i10 == -1234567890) {
            i10 = d();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "beginIndex=", " < 0").toString());
        }
        if (i10 > d()) {
            StringBuilder sbN = a1.a.n(i10, "endIndex=", " > length(");
            sbN.append(d());
            sbN.append(')');
            throw new IllegalArgumentException(sbN.toString().toString());
        }
        int i11 = i10 - i2;
        if (i11 < 0) {
            throw new IllegalArgumentException(m.x.k("endIndex=", i10, i2, " < beginIndex=").toString());
        }
        if (i2 == 0 && i10 == d()) {
            return this;
        }
        if (i2 == i10) {
            return k.f7997i;
        }
        int iG = pb.b.g(this, i2);
        int iG2 = pb.b.g(this, i10 - 1);
        byte[][] bArr = this.f7994j;
        byte[][] bArr2 = (byte[][]) d7.n.c0(bArr, iG, iG2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f7995k;
        if (iG <= iG2) {
            int i12 = iG;
            int i13 = 0;
            while (true) {
                iArr[i13] = Math.min(iArr2[i12] - i2, i11);
                int i14 = i13 + 1;
                iArr[i13 + bArr2.length] = iArr2[bArr.length + i12];
                if (i12 == iG2) {
                    break;
                }
                i12++;
                i13 = i14;
            }
        }
        int i15 = iG != 0 ? iArr2[iG - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i2 - i15) + iArr[length];
        return new h0(bArr2, iArr);
    }

    @Override // ob.k
    public final k p() {
        return t().p();
    }

    @Override // ob.k
    public final byte[] q() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.f7994j;
        int length = bArr2.length;
        int i2 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i2 < length) {
            int[] iArr = this.f7995k;
            int i12 = iArr[length + i2];
            int i13 = iArr[i2];
            int i14 = i13 - i10;
            d7.n.V(i11, i12, i12 + i14, bArr2[i2], bArr);
            i11 += i14;
            i2++;
            i10 = i13;
        }
        return bArr;
    }

    @Override // ob.k
    public final void s(h hVar, int i2) {
        int iG = pb.b.g(this, 0);
        int i10 = 0;
        while (i10 < i2) {
            int[] iArr = this.f7995k;
            int i11 = iG == 0 ? 0 : iArr[iG - 1];
            int i12 = iArr[iG] - i11;
            byte[][] bArr = this.f7994j;
            int i13 = iArr[bArr.length + iG];
            int iMin = Math.min(i2, i12 + i11) - i10;
            int i14 = (i10 - i11) + i13;
            f0 f0Var = new f0(bArr[iG], i14, i14 + iMin, true, false);
            f0 f0Var2 = hVar.f7992f;
            if (f0Var2 == null) {
                f0Var.f7981g = f0Var;
                f0Var.f7980f = f0Var;
                hVar.f7992f = f0Var;
            } else {
                f0 f0Var3 = f0Var2.f7981g;
                q7.k.b(f0Var3);
                f0Var3.b(f0Var);
            }
            i10 += iMin;
            iG++;
        }
        hVar.f7993g += i2;
    }

    public final k t() {
        return new k(q());
    }

    @Override // ob.k
    public final String toString() {
        return t().toString();
    }
}
