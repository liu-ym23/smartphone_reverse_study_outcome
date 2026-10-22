package od;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 extends l {
    public final transient byte[][] i;

    /* renamed from: j, reason: collision with root package name */
    public final transient int[] f9447j;

    public f0(byte[][] bArr, int[] iArr) {
        this.f9460c = l.f9459h.f9460c;
        this.i = bArr;
        this.f9447j = iArr;
    }

    @Override // od.l
    public final l b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.i;
        int length = bArr.length;
        int i = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.f9447j;
            int i10 = iArr[length + i];
            int i11 = iArr[i];
            messageDigest.update(bArr[i], i10, i11 - i3);
            i++;
            i3 = i11;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        l lVar = new l();
        lVar.f9460c = bArrDigest;
        return lVar;
    }

    @Override // od.l
    public final int c() {
        return this.f9447j[this.i.length - 1];
    }

    @Override // od.l
    public final String d() {
        return s().d();
    }

    @Override // od.l
    public final int e(int i, byte[] bArr) {
        bArr.getClass();
        return s().e(i, bArr);
    }

    @Override // od.l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.c() == c() && k(0, lVar, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // od.l
    public final byte[] g() {
        return r();
    }

    @Override // od.l
    public final byte h(int i) {
        byte[][] bArr = this.i;
        int length = bArr.length - 1;
        int[] iArr = this.f9447j;
        a.a.m(iArr[length], i, 1L);
        int iG = pd.b.g(this, i);
        return bArr[iG][(i - (iG == 0 ? 0 : iArr[iG - 1])) + iArr[bArr.length + iG]];
    }

    @Override // od.l
    public final int hashCode() {
        int i = this.f9461f;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.i;
        int length = bArr.length;
        int i3 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i3 < length) {
            int[] iArr = this.f9447j;
            int i12 = iArr[length + i3];
            int i13 = iArr[i3];
            byte[] bArr2 = bArr[i3];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr2[i12];
                i12++;
            }
            i3++;
            i11 = i13;
        }
        this.f9461f = i10;
        return i10;
    }

    @Override // od.l
    public final int i(byte[] bArr) {
        bArr.getClass();
        return s().i(bArr);
    }

    @Override // od.l
    public final boolean k(int i, l lVar, int i3) {
        lVar.getClass();
        if (i >= 0 && i <= c() - i3) {
            int i10 = i3 + i;
            int iG = pd.b.g(this, i);
            int i11 = 0;
            while (i < i10) {
                int[] iArr = this.f9447j;
                int i12 = iG == 0 ? 0 : iArr[iG - 1];
                int i13 = iArr[iG] - i12;
                byte[][] bArr = this.i;
                int i14 = iArr[bArr.length + iG];
                int iMin = Math.min(i10, i13 + i12) - i;
                if (lVar.l(i11, bArr[iG], (i - i12) + i14, iMin)) {
                    i11 += iMin;
                    i += iMin;
                    iG++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // od.l
    public final boolean l(int i, byte[] bArr, int i3, int i10) {
        bArr.getClass();
        if (i < 0 || i > c() - i10 || i3 < 0 || i3 > bArr.length - i10) {
            return false;
        }
        int i11 = i10 + i;
        int iG = pd.b.g(this, i);
        while (i < i11) {
            int[] iArr = this.f9447j;
            int i12 = iG == 0 ? 0 : iArr[iG - 1];
            int i13 = iArr[iG] - i12;
            byte[][] bArr2 = this.i;
            int i14 = iArr[bArr2.length + iG];
            int iMin = Math.min(i11, i13 + i12) - i;
            if (!a.a.i(bArr2[iG], (i - i12) + i14, i3, bArr, iMin)) {
                return false;
            }
            i3 += iMin;
            i += iMin;
            iG++;
        }
        return true;
    }

    @Override // od.l
    public final l m(int i, int i3) {
        if (i3 == -1234567890) {
            i3 = c();
        }
        if (i < 0) {
            f.c(k0.a.k(i, "beginIndex=", " < 0"));
            return null;
        }
        if (i3 > c()) {
            StringBuilder sbT = k0.a.t(i3, "endIndex=", " > length(");
            sbT.append(c());
            sbT.append(')');
            throw new IllegalArgumentException(sbT.toString().toString());
        }
        int i10 = i3 - i;
        if (i10 < 0) {
            f.c(androidx.activity.b.i("endIndex=", i3, " < beginIndex=", i));
            return null;
        }
        if (i == 0 && i3 == c()) {
            return this;
        }
        if (i == i3) {
            return l.f9459h;
        }
        int iG = pd.b.g(this, i);
        int iG2 = pd.b.g(this, i3 - 1);
        byte[][] bArr = this.i;
        byte[][] bArr2 = (byte[][]) kb.k.l0(bArr, iG, iG2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f9447j;
        if (iG <= iG2) {
            int i11 = iG;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(iArr2[i11] - i, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr2.length] = iArr2[bArr.length + i11];
                if (i11 == iG2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = iG != 0 ? iArr2[iG - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i14) + iArr[length];
        return new f0(bArr2, iArr);
    }

    @Override // od.l
    public final l o() {
        return s().o();
    }

    @Override // od.l
    public final void q(i iVar, int i) {
        int iG = pd.b.g(this, 0);
        int i3 = 0;
        while (i3 < i) {
            int[] iArr = this.f9447j;
            int i10 = iG == 0 ? 0 : iArr[iG - 1];
            int i11 = iArr[iG] - i10;
            byte[][] bArr = this.i;
            int i12 = iArr[bArr.length + iG];
            int iMin = Math.min(i, i11 + i10) - i3;
            int i13 = (i3 - i10) + i12;
            d0 d0Var = new d0(bArr[iG], i13, i13 + iMin, true);
            d0 d0Var2 = iVar.f9453c;
            if (d0Var2 == null) {
                d0Var.f9443g = d0Var;
                d0Var.f9442f = d0Var;
                iVar.f9453c = d0Var;
            } else {
                d0 d0Var3 = d0Var2.f9443g;
                d0Var3.getClass();
                d0Var3.b(d0Var);
            }
            i3 += iMin;
            iG++;
        }
        iVar.f9454f += i;
    }

    public final byte[] r() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.i;
        int length = bArr2.length;
        int i = 0;
        int i3 = 0;
        int i10 = 0;
        while (i < length) {
            int[] iArr = this.f9447j;
            int i11 = iArr[length + i];
            int i12 = iArr[i];
            int i13 = i12 - i3;
            kb.k.g0(bArr2[i], i10, i11, bArr, i11 + i13);
            i10 += i13;
            i++;
            i3 = i12;
        }
        return bArr;
    }

    public final l s() {
        byte[] bArrR = r();
        l lVar = new l();
        lVar.f9460c = bArrR;
        return lVar;
    }

    @Override // od.l
    public final String toString() {
        return s().toString();
    }
}
