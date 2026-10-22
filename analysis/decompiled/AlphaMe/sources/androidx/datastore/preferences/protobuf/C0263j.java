package androidx.datastore.preferences.protobuf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0263j extends AbstractC0264k {

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f3484e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f3485f;

    /* renamed from: g, reason: collision with root package name */
    public int f3486g;

    /* renamed from: h, reason: collision with root package name */
    public int f3487h;

    /* renamed from: i, reason: collision with root package name */
    public int f3488i;

    /* renamed from: j, reason: collision with root package name */
    public int f3489j;

    /* renamed from: k, reason: collision with root package name */
    public int f3490k;

    /* renamed from: l, reason: collision with root package name */
    public int f3491l = Integer.MAX_VALUE;

    public C0263j(FileInputStream fileInputStream) {
        Charset charset = D.f3396a;
        this.f3484e = fileInputStream;
        this.f3485f = new byte[4096];
        this.f3486g = 0;
        this.f3488i = 0;
        this.f3490k = 0;
    }

    public final ArrayList A(int i4) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i4 > 0) {
            int iMin = Math.min(i4, 4096);
            byte[] bArr = new byte[iMin];
            int i5 = 0;
            while (i5 < iMin) {
                int i6 = this.f3484e.read(bArr, i5, iMin - i5);
                if (i6 == -1) {
                    throw F.f();
                }
                this.f3490k += i6;
                i5 += i6;
            }
            i4 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int B() throws F {
        int i4 = this.f3488i;
        if (this.f3486g - i4 < 4) {
            H(4);
            i4 = this.f3488i;
        }
        this.f3488i = i4 + 4;
        byte[] bArr = this.f3485f;
        return ((bArr[i4 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i4] & UByte.MAX_VALUE) | ((bArr[i4 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i4 + 2] & UByte.MAX_VALUE) << 16);
    }

    public final long C() throws F {
        int i4 = this.f3488i;
        if (this.f3486g - i4 < 8) {
            H(8);
            i4 = this.f3488i;
        }
        this.f3488i = i4 + 8;
        byte[] bArr = this.f3485f;
        return ((bArr[i4 + 1] & 255) << 8) | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48) | ((bArr[i4 + 7] & 255) << 56);
    }

    public final int D() {
        int i4;
        int i5 = this.f3488i;
        int i6 = this.f3486g;
        if (i6 != i5) {
            int i7 = i5 + 1;
            byte[] bArr = this.f3485f;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                this.f3488i = i7;
                return b4;
            }
            if (i6 - i7 >= 9) {
                int i8 = i5 + 2;
                int i9 = (bArr[i7] << 7) ^ b4;
                if (i9 < 0) {
                    i4 = i9 ^ (-128);
                } else {
                    int i10 = i5 + 3;
                    int i11 = (bArr[i8] << 14) ^ i9;
                    if (i11 >= 0) {
                        i4 = i11 ^ 16256;
                    } else {
                        int i12 = i5 + 4;
                        int i13 = i11 ^ (bArr[i10] << 21);
                        if (i13 < 0) {
                            i4 = (-2080896) ^ i13;
                        } else {
                            i10 = i5 + 5;
                            byte b5 = bArr[i12];
                            int i14 = (i13 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i12 = i5 + 6;
                                if (bArr[i10] < 0) {
                                    i10 = i5 + 7;
                                    if (bArr[i12] < 0) {
                                        i12 = i5 + 8;
                                        if (bArr[i10] < 0) {
                                            i10 = i5 + 9;
                                            if (bArr[i12] < 0) {
                                                int i15 = i5 + 10;
                                                if (bArr[i10] >= 0) {
                                                    i8 = i15;
                                                    i4 = i14;
                                                }
                                            }
                                        }
                                    }
                                }
                                i4 = i14;
                            }
                            i4 = i14;
                        }
                        i8 = i12;
                    }
                    i8 = i10;
                }
                this.f3488i = i8;
                return i4;
            }
        }
        return (int) F();
    }

    public final long E() {
        long j4;
        long j5;
        long j6;
        long j7;
        int i4 = this.f3488i;
        int i5 = this.f3486g;
        if (i5 != i4) {
            int i6 = i4 + 1;
            byte[] bArr = this.f3485f;
            byte b4 = bArr[i4];
            if (b4 >= 0) {
                this.f3488i = i6;
                return b4;
            }
            if (i5 - i6 >= 9) {
                int i7 = i4 + 2;
                int i8 = (bArr[i6] << 7) ^ b4;
                if (i8 < 0) {
                    j4 = i8 ^ (-128);
                } else {
                    int i9 = i4 + 3;
                    int i10 = (bArr[i7] << 14) ^ i8;
                    if (i10 >= 0) {
                        j4 = i10 ^ 16256;
                        i7 = i9;
                    } else {
                        int i11 = i4 + 4;
                        int i12 = i10 ^ (bArr[i9] << 21);
                        if (i12 < 0) {
                            j7 = (-2080896) ^ i12;
                        } else {
                            long j8 = i12;
                            i7 = i4 + 5;
                            long j9 = j8 ^ (bArr[i11] << 28);
                            if (j9 >= 0) {
                                j6 = 266354560;
                            } else {
                                i11 = i4 + 6;
                                long j10 = j9 ^ (bArr[i7] << 35);
                                if (j10 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i7 = i4 + 7;
                                    j9 = j10 ^ (bArr[i11] << 42);
                                    if (j9 >= 0) {
                                        j6 = 4363953127296L;
                                    } else {
                                        i11 = i4 + 8;
                                        j10 = j9 ^ (bArr[i7] << 49);
                                        if (j10 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i7 = i4 + 9;
                                            long j11 = (j10 ^ (bArr[i11] << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                int i13 = i4 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i7 = i13;
                                                }
                                            }
                                            j4 = j11;
                                        }
                                    }
                                }
                                j7 = j5 ^ j10;
                            }
                            j4 = j6 ^ j9;
                        }
                        i7 = i11;
                        j4 = j7;
                    }
                }
                this.f3488i = i7;
                return j4;
            }
        }
        return F();
    }

    public final long F() throws F {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            if (this.f3488i == this.f3486g) {
                H(1);
            }
            int i5 = this.f3488i;
            this.f3488i = i5 + 1;
            j4 |= (r3 & ByteCompanionObject.MAX_VALUE) << i4;
            if ((this.f3485f[i5] & ByteCompanionObject.MIN_VALUE) == 0) {
                return j4;
            }
        }
        throw F.c();
    }

    public final void G() {
        int i4 = this.f3486g + this.f3487h;
        this.f3486g = i4;
        int i5 = this.f3490k + i4;
        int i6 = this.f3491l;
        if (i5 <= i6) {
            this.f3487h = 0;
            return;
        }
        int i7 = i5 - i6;
        this.f3487h = i7;
        this.f3486g = i4 - i7;
    }

    public final void H(int i4) throws F {
        if (J(i4)) {
            return;
        }
        if (i4 <= (this.f3498c - this.f3490k) - this.f3488i) {
            throw F.f();
        }
        throw new F("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void I(int i4) throws F {
        int i5 = this.f3486g;
        int i6 = this.f3488i;
        if (i4 <= i5 - i6 && i4 >= 0) {
            this.f3488i = i6 + i4;
            return;
        }
        InputStream inputStream = this.f3484e;
        if (i4 < 0) {
            throw F.d();
        }
        int i7 = this.f3490k;
        int i8 = i7 + i6;
        int i9 = i8 + i4;
        int i10 = this.f3491l;
        if (i9 > i10) {
            I((i10 - i7) - i6);
            throw F.f();
        }
        this.f3490k = i8;
        int i11 = i5 - i6;
        this.f3486g = 0;
        this.f3488i = 0;
        while (i11 < i4) {
            long j4 = i4 - i11;
            try {
                long jSkip = inputStream.skip(j4);
                if (jSkip < 0 || jSkip > j4) {
                    throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                }
                if (jSkip == 0) {
                    break;
                } else {
                    i11 += (int) jSkip;
                }
            } finally {
                this.f3490k += i11;
                G();
            }
        }
        if (i11 >= i4) {
            return;
        }
        int i12 = this.f3486g;
        int i13 = i12 - this.f3488i;
        this.f3488i = i12;
        H(1);
        while (true) {
            int i14 = i4 - i13;
            int i15 = this.f3486g;
            if (i14 <= i15) {
                this.f3488i = i14;
                return;
            } else {
                i13 += i15;
                this.f3488i = i15;
                H(1);
            }
        }
    }

    public final boolean J(int i4) throws IOException {
        int i5 = this.f3488i;
        int i6 = i5 + i4;
        int i7 = this.f3486g;
        if (i6 <= i7) {
            throw new IllegalStateException(B0.g.j("refillBuffer() called when ", i4, " bytes were already available in buffer"));
        }
        int i8 = this.f3490k;
        int i9 = this.f3498c;
        if (i4 > (i9 - i8) - i5 || i8 + i5 + i4 > this.f3491l) {
            return false;
        }
        byte[] bArr = this.f3485f;
        if (i5 > 0) {
            if (i7 > i5) {
                System.arraycopy(bArr, i5, bArr, 0, i7 - i5);
            }
            this.f3490k += i5;
            this.f3486g -= i5;
            this.f3488i = 0;
        }
        int i10 = this.f3486g;
        int iMin = Math.min(bArr.length - i10, (i9 - this.f3490k) - i10);
        InputStream inputStream = this.f3484e;
        int i11 = inputStream.read(bArr, i10, iMin);
        if (i11 == 0 || i11 < -1 || i11 > bArr.length) {
            throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i11 + "\nThe InputStream implementation is buggy.");
        }
        if (i11 <= 0) {
            return false;
        }
        this.f3486g += i11;
        G();
        if (this.f3486g >= i4) {
            return true;
        }
        return J(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final void a(int i4) throws F {
        if (this.f3489j != i4) {
            throw new F("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int b() {
        return this.f3490k + this.f3488i;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final boolean c() {
        return this.f3488i == this.f3486g && !J(1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final void d(int i4) {
        this.f3491l = i4;
        G();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int e(int i4) throws F {
        if (i4 < 0) {
            throw F.d();
        }
        int i5 = this.f3490k + this.f3488i + i4;
        int i6 = this.f3491l;
        if (i5 > i6) {
            throw F.f();
        }
        this.f3491l = i5;
        G();
        return i6;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final boolean f() {
        return E() != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final C0261i g() throws IOException {
        int iD = D();
        int i4 = this.f3486g;
        int i5 = this.f3488i;
        int i6 = i4 - i5;
        byte[] bArr = this.f3485f;
        if (iD <= i6 && iD > 0) {
            C0261i c0261iD = AbstractC0259h.d(i5, iD, bArr);
            this.f3488i += iD;
            return c0261iD;
        }
        if (iD == 0) {
            return AbstractC0259h.f3480b;
        }
        byte[] bArrZ = z(iD);
        if (bArrZ != null) {
            return AbstractC0259h.d(0, bArrZ.length, bArrZ);
        }
        int i7 = this.f3488i;
        int i8 = this.f3486g;
        int length = i8 - i7;
        this.f3490k += i8;
        this.f3488i = 0;
        this.f3486g = 0;
        ArrayList arrayListA = A(iD - length);
        byte[] bArr2 = new byte[iD];
        System.arraycopy(bArr, i7, bArr2, 0, length);
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        C0261i c0261i = AbstractC0259h.f3480b;
        return new C0261i(bArr2);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final double h() {
        return Double.longBitsToDouble(C());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int i() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int j() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final long k() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final float l() {
        return Float.intBitsToFloat(B());
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int m() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final long n() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int o() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final long p() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int q() {
        int iD = D();
        return (-(iD & 1)) ^ (iD >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final long r() {
        long jE = E();
        return (-(jE & 1)) ^ (jE >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final String s() throws F {
        int iD = D();
        byte[] bArr = this.f3485f;
        if (iD > 0) {
            int i4 = this.f3486g;
            int i5 = this.f3488i;
            if (iD <= i4 - i5) {
                String str = new String(bArr, i5, iD, D.f3396a);
                this.f3488i += iD;
                return str;
            }
        }
        if (iD == 0) {
            return "";
        }
        if (iD > this.f3486g) {
            return new String(y(iD), D.f3396a);
        }
        H(iD);
        String str2 = new String(bArr, this.f3488i, iD, D.f3396a);
        this.f3488i += iD;
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final String t() throws IOException {
        int iD = D();
        int i4 = this.f3488i;
        int i5 = this.f3486g;
        int i6 = i5 - i4;
        byte[] bArrY = this.f3485f;
        if (iD <= i6 && iD > 0) {
            this.f3488i = i4 + iD;
        } else {
            if (iD == 0) {
                return "";
            }
            i4 = 0;
            if (iD <= i5) {
                H(iD);
                this.f3488i = iD;
            } else {
                bArrY = y(iD);
            }
        }
        return C0.f3395a.k(i4, iD, bArrY);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int u() throws F {
        if (c()) {
            this.f3489j = 0;
            return 0;
        }
        int iD = D();
        this.f3489j = iD;
        if ((iD >>> 3) != 0) {
            return iD;
        }
        throw new F("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final int v() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final long w() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0264k
    public final boolean x(int i4) throws F {
        int iU;
        int i5 = i4 & 7;
        int i6 = 0;
        if (i5 == 0) {
            int i7 = this.f3486g - this.f3488i;
            byte[] bArr = this.f3485f;
            if (i7 >= 10) {
                while (i6 < 10) {
                    int i8 = this.f3488i;
                    this.f3488i = i8 + 1;
                    if (bArr[i8] < 0) {
                        i6++;
                    }
                }
                throw F.c();
            }
            while (i6 < 10) {
                if (this.f3488i == this.f3486g) {
                    H(1);
                }
                int i9 = this.f3488i;
                this.f3488i = i9 + 1;
                if (bArr[i9] < 0) {
                    i6++;
                }
            }
            throw F.c();
            return true;
        }
        if (i5 == 1) {
            I(8);
            return true;
        }
        if (i5 == 2) {
            I(D());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                return false;
            }
            if (i5 != 5) {
                throw F.b();
            }
            I(4);
            return true;
        }
        do {
            iU = u();
            if (iU == 0) {
                break;
            }
        } while (x(iU));
        a(((i4 >>> 3) << 3) | 4);
        return true;
    }

    public final byte[] y(int i4) throws IOException {
        byte[] bArrZ = z(i4);
        if (bArrZ != null) {
            return bArrZ;
        }
        int i5 = this.f3488i;
        int i6 = this.f3486g;
        int length = i6 - i5;
        this.f3490k += i6;
        this.f3488i = 0;
        this.f3486g = 0;
        ArrayList arrayListA = A(i4 - length);
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f3485f, i5, bArr, 0, length);
        Iterator it = arrayListA.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] z(int i4) throws IOException {
        if (i4 == 0) {
            return D.f3397b;
        }
        if (i4 < 0) {
            throw F.d();
        }
        int i5 = this.f3490k;
        int i6 = this.f3488i;
        int i7 = i5 + i6 + i4;
        if (i7 - this.f3498c > 0) {
            throw new F("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i8 = this.f3491l;
        if (i7 > i8) {
            I((i8 - i5) - i6);
            throw F.f();
        }
        int i9 = this.f3486g - i6;
        int i10 = i4 - i9;
        InputStream inputStream = this.f3484e;
        if (i10 >= 4096 && i10 > inputStream.available()) {
            return null;
        }
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f3485f, this.f3488i, bArr, 0, i9);
        this.f3490k += this.f3486g;
        this.f3488i = 0;
        this.f3486g = 0;
        while (i9 < i4) {
            int i11 = inputStream.read(bArr, i9, i4 - i9);
            if (i11 == -1) {
                throw F.f();
            }
            this.f3490k += i11;
            i9 += i11;
        }
        return bArr;
    }
}
