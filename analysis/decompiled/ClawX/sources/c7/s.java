package c7;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends i {

    /* renamed from: e, reason: collision with root package name */
    public final transient byte[][] f1196e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int[] f1197f;

    public s(byte[][] bArr, int[] iArr) {
        super(i.d.f1165a);
        this.f1196e = bArr;
        this.f1197f = iArr;
    }

    @Override // c7.i
    public final String a() {
        throw null;
    }

    @Override // c7.i
    public final i b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f1196e;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int[] iArr = this.f1197f;
            int i10 = iArr[length + i8];
            int i11 = iArr[i8];
            messageDigest.update(bArr[i8], i10, i11 - i9);
            i8++;
            i9 = i11;
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.p.b(bArrDigest);
        return new i(bArrDigest);
    }

    @Override // c7.i
    public final int c() {
        return this.f1197f[this.f1196e.length - 1];
    }

    @Override // c7.i
    public final String d() {
        return new i(n()).d();
    }

    @Override // c7.i
    public final byte[] e() {
        return n();
    }

    @Override // c7.i
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.c() == c() && g(c(), iVar);
    }

    @Override // c7.i
    public final byte f(int i8) {
        byte[][] bArr = this.f1196e;
        int length = bArr.length - 1;
        int[] iArr = this.f1197f;
        b.d(iArr[length], i8, 1L);
        int iB = d7.b.b(this, i8);
        return bArr[iB][(i8 - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // c7.i
    public final boolean g(int i8, i other) {
        kotlin.jvm.internal.p.e(other, "other");
        if (c() - i8 >= 0) {
            int iB = d7.b.b(this, 0);
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8) {
                int[] iArr = this.f1197f;
                int i11 = iB == 0 ? 0 : iArr[iB - 1];
                int i12 = iArr[iB] - i11;
                byte[][] bArr = this.f1196e;
                int i13 = iArr[bArr.length + iB];
                int iMin = Math.min(i8, i12 + i11) - i9;
                if (other.h(i10, bArr[iB], (i9 - i11) + i13, iMin)) {
                    i10 += iMin;
                    i9 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // c7.i
    public final boolean h(int i8, byte[] other, int i9, int i10) {
        kotlin.jvm.internal.p.e(other, "other");
        if (i8 < 0 || i8 > c() - i10 || i9 < 0 || i9 > other.length - i10) {
            return false;
        }
        int i11 = i10 + i8;
        int iB = d7.b.b(this, i8);
        while (i8 < i11) {
            int[] iArr = this.f1197f;
            int i12 = iB == 0 ? 0 : iArr[iB - 1];
            int i13 = iArr[iB] - i12;
            byte[][] bArr = this.f1196e;
            int i14 = iArr[bArr.length + iB];
            int iMin = Math.min(i11, i13 + i12) - i8;
            if (!b.a((i8 - i12) + i14, bArr[iB], i9, other, iMin)) {
                return false;
            }
            i9 += iMin;
            i8 += iMin;
            iB++;
        }
        return true;
    }

    @Override // c7.i
    public final int hashCode() {
        int i8 = this.f1166b;
        if (i8 != 0) {
            return i8;
        }
        byte[][] bArr = this.f1196e;
        int length = bArr.length;
        int i9 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i9 < length) {
            int[] iArr = this.f1197f;
            int i12 = iArr[length + i9];
            int i13 = iArr[i9];
            byte[] bArr2 = bArr[i9];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr2[i12];
                i12++;
            }
            i9++;
            i11 = i13;
        }
        this.f1166b = i10;
        return i10;
    }

    @Override // c7.i
    public final String i(Charset charset) {
        kotlin.jvm.internal.p.e(charset, "charset");
        return new i(n()).i(charset);
    }

    @Override // c7.i
    public final i j(int i8, int i9) {
        if (i9 == -1234567890) {
            i9 = c();
        }
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "beginIndex=", " < 0").toString());
        }
        if (i9 > c()) {
            StringBuilder sbS = a8.b.s(i9, "endIndex=", " > length(");
            sbS.append(c());
            sbS.append(')');
            throw new IllegalArgumentException(sbS.toString().toString());
        }
        int i10 = i9 - i8;
        if (i10 < 0) {
            throw new IllegalArgumentException(a8.b.i(i9, i8, "endIndex=", " < beginIndex=").toString());
        }
        if (i8 == 0 && i9 == c()) {
            return this;
        }
        if (i8 == i9) {
            return i.d;
        }
        int iB = d7.b.b(this, i8);
        int iB2 = d7.b.b(this, i9 - 1);
        byte[][] bArr = this.f1196e;
        byte[][] bArr2 = (byte[][]) c5.l.a0(bArr, iB, iB2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f1197f;
        if (iB <= iB2) {
            int i11 = iB;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(iArr2[i11] - i8, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr2.length] = iArr2[bArr.length + i11];
                if (i11 == iB2) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = iB != 0 ? iArr2[iB - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i8 - i14) + iArr[length];
        return new s(bArr2, iArr);
    }

    @Override // c7.i
    public final i k() {
        return new i(n()).k();
    }

    @Override // c7.i
    public final void m(f fVar, int i8) {
        int iB = d7.b.b(this, 0);
        int i9 = 0;
        while (i9 < i8) {
            int[] iArr = this.f1197f;
            int i10 = iB == 0 ? 0 : iArr[iB - 1];
            int i11 = iArr[iB] - i10;
            byte[][] bArr = this.f1196e;
            int i12 = iArr[bArr.length + iB];
            int iMin = Math.min(i8, i11 + i10) - i9;
            int i13 = (i9 - i10) + i12;
            q qVar = new q(bArr[iB], i13, i13 + iMin, true, false);
            q qVar2 = fVar.f1163a;
            if (qVar2 == null) {
                qVar.f1192g = qVar;
                qVar.f1191f = qVar;
                fVar.f1163a = qVar;
            } else {
                q qVar3 = qVar2.f1192g;
                kotlin.jvm.internal.p.b(qVar3);
                qVar3.b(qVar);
            }
            i9 += iMin;
            iB++;
        }
        fVar.f1164b += i8;
    }

    public final byte[] n() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f1196e;
        int length = bArr2.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            int[] iArr = this.f1197f;
            int i11 = iArr[length + i8];
            int i12 = iArr[i8];
            int i13 = i12 - i9;
            c5.l.U(i10, bArr2[i8], i11, bArr, i11 + i13);
            i10 += i13;
            i8++;
            i9 = i12;
        }
        return bArr;
    }

    @Override // c7.i
    public final String toString() {
        return new i(n()).toString();
    }
}
