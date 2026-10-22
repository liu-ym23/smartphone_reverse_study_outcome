package androidx.datastore.preferences.protobuf;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: c, reason: collision with root package name */
    public FileInputStream f1121c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f1122d;

    /* renamed from: e, reason: collision with root package name */
    public int f1123e;

    /* renamed from: f, reason: collision with root package name */
    public int f1124f;

    /* renamed from: g, reason: collision with root package name */
    public int f1125g;

    /* renamed from: h, reason: collision with root package name */
    public int f1126h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1127j;

    public final byte[] A(int i) throws IOException {
        FileInputStream fileInputStream = this.f1121c;
        if (i == 0) {
            return x.f1219b;
        }
        if (i < 0) {
            throw z.d();
        }
        int i3 = this.i;
        int i10 = this.f1125g;
        int i11 = i3 + i10 + i;
        if (i11 - Reader.READ_DONE > 0) {
            throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i12 = this.f1127j;
        if (i11 > i12) {
            J((i12 - i3) - i10);
            throw z.e();
        }
        int i13 = this.f1123e - i10;
        int i14 = i - i13;
        if (i14 >= 4096) {
            try {
                if (i14 > fileInputStream.available()) {
                    return null;
                }
            } catch (z e10) {
                e10.f1228c = true;
                throw e10;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f1122d, this.f1125g, bArr, 0, i13);
        this.i += this.f1123e;
        this.f1125g = 0;
        this.f1123e = 0;
        while (i13 < i) {
            try {
                int i15 = fileInputStream.read(bArr, i13, i - i13);
                if (i15 == -1) {
                    throw z.e();
                }
                this.i += i15;
                i13 += i15;
            } catch (z e11) {
                e11.f1228c = true;
                throw e11;
            }
        }
        return bArr;
    }

    public final ArrayList B(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i3 = 0;
            while (i3 < iMin) {
                int i10 = this.f1121c.read(bArr, i3, iMin - i3);
                if (i10 == -1) {
                    throw z.e();
                }
                this.i += i10;
                i3 += i10;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int C() throws z {
        int i = this.f1125g;
        if (this.f1123e - i < 4) {
            I(4);
            i = this.f1125g;
        }
        byte[] bArr = this.f1122d;
        this.f1125g = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    public final long D() throws z {
        int i = this.f1125g;
        if (this.f1123e - i < 8) {
            I(8);
            i = this.f1125g;
        }
        byte[] bArr = this.f1122d;
        this.f1125g = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int E() {
        int i;
        int i3 = this.f1125g;
        int i10 = this.f1123e;
        if (i10 != i3) {
            byte[] bArr = this.f1122d;
            int i11 = i3 + 1;
            byte b10 = bArr[i3];
            if (b10 >= 0) {
                this.f1125g = i11;
                return b10;
            }
            if (i10 - i11 >= 9) {
                int i12 = i3 + 2;
                int i13 = (bArr[i11] << 7) ^ b10;
                if (i13 < 0) {
                    i = i13 ^ (-128);
                } else {
                    int i14 = i3 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        i = i15 ^ 16256;
                    } else {
                        int i16 = i3 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            i = (-2080896) ^ i17;
                        } else {
                            i14 = i3 + 5;
                            byte b11 = bArr[i16];
                            int i18 = (i17 ^ (b11 << 28)) ^ 266354560;
                            if (b11 < 0) {
                                i16 = i3 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i3 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i3 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i3 + 9;
                                            if (bArr[i16] < 0) {
                                                int i19 = i3 + 10;
                                                if (bArr[i14] >= 0) {
                                                    i12 = i19;
                                                    i = i18;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i18;
                            }
                            i = i18;
                        }
                        i12 = i16;
                    }
                    i12 = i14;
                }
                this.f1125g = i12;
                return i;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j10;
        long j11;
        long j12;
        int i = this.f1125g;
        int i3 = this.f1123e;
        if (i3 != i) {
            byte[] bArr = this.f1122d;
            int i10 = i + 1;
            byte b10 = bArr[i];
            if (b10 >= 0) {
                this.f1125g = i10;
                return b10;
            }
            if (i3 - i10 >= 9) {
                int i11 = i + 2;
                int i12 = (bArr[i10] << 7) ^ b10;
                if (i12 < 0) {
                    j10 = i12 ^ (-128);
                } else {
                    int i13 = i + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        j10 = i14 ^ 16256;
                        i11 = i13;
                    } else {
                        int i15 = i + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            long j13 = (-2080896) ^ i16;
                            i11 = i15;
                            j10 = j13;
                        } else {
                            long j14 = i16;
                            i11 = i + 5;
                            long j15 = j14 ^ (bArr[i15] << 28);
                            if (j15 >= 0) {
                                j12 = 266354560;
                            } else {
                                int i17 = i + 6;
                                long j16 = j15 ^ (bArr[i11] << 35);
                                if (j16 < 0) {
                                    j11 = -34093383808L;
                                } else {
                                    i11 = i + 7;
                                    j15 = j16 ^ (bArr[i17] << 42);
                                    if (j15 >= 0) {
                                        j12 = 4363953127296L;
                                    } else {
                                        i17 = i + 8;
                                        j16 = j15 ^ (bArr[i11] << 49);
                                        if (j16 < 0) {
                                            j11 = -558586000294016L;
                                        } else {
                                            i11 = i + 9;
                                            long j17 = (j16 ^ (bArr[i17] << 56)) ^ 71499008037633920L;
                                            if (j17 < 0) {
                                                int i18 = i + 10;
                                                if (bArr[i11] >= 0) {
                                                    i11 = i18;
                                                }
                                            }
                                            j10 = j17;
                                        }
                                    }
                                }
                                j10 = j16 ^ j11;
                                i11 = i17;
                            }
                            j10 = j15 ^ j12;
                        }
                    }
                }
                this.f1125g = i11;
                return j10;
            }
        }
        return G();
    }

    public final long G() throws z {
        long j10 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f1125g == this.f1123e) {
                I(1);
            }
            byte[] bArr = this.f1122d;
            int i3 = this.f1125g;
            this.f1125g = i3 + 1;
            j10 |= (r3 & 127) << i;
            if ((bArr[i3] & 128) == 0) {
                return j10;
            }
        }
        throw z.c();
    }

    public final void H() {
        int i = this.f1123e + this.f1124f;
        this.f1123e = i;
        int i3 = this.i + i;
        int i10 = this.f1127j;
        if (i3 <= i10) {
            this.f1124f = 0;
            return;
        }
        int i11 = i3 - i10;
        this.f1124f = i11;
        this.f1123e = i - i11;
    }

    public final void I(int i) throws z {
        if (K(i)) {
            return;
        }
        if (i <= (Reader.READ_DONE - this.i) - this.f1125g) {
            throw z.e();
        }
        throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void J(int i) throws z {
        int i3 = this.f1123e;
        int i10 = this.f1125g;
        int i11 = i3 - i10;
        if (i <= i11 && i >= 0) {
            this.f1125g = i10 + i;
            return;
        }
        FileInputStream fileInputStream = this.f1121c;
        if (i < 0) {
            throw z.d();
        }
        int i12 = this.i;
        int i13 = i12 + i10;
        int i14 = i13 + i;
        int i15 = this.f1127j;
        if (i14 > i15) {
            J((i15 - i12) - i10);
            throw z.e();
        }
        this.i = i13;
        this.f1123e = 0;
        this.f1125g = 0;
        while (i11 < i) {
            long j10 = i - i11;
            try {
                try {
                    long jSkip = fileInputStream.skip(j10);
                    if (jSkip < 0 || jSkip > j10) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i11 += (int) jSkip;
                    }
                } catch (z e10) {
                    e10.f1228c = true;
                    throw e10;
                }
            } catch (Throwable th) {
                this.i += i11;
                H();
                throw th;
            }
        }
        this.i += i11;
        H();
        if (i11 >= i) {
            return;
        }
        int i16 = this.f1123e;
        int i17 = i16 - this.f1125g;
        this.f1125g = i16;
        I(1);
        while (true) {
            int i18 = i - i17;
            int i19 = this.f1123e;
            if (i18 <= i19) {
                this.f1125g = i18;
                return;
            } else {
                i17 += i19;
                this.f1125g = i19;
                I(1);
            }
        }
    }

    public final boolean K(int i) throws IOException {
        FileInputStream fileInputStream = this.f1121c;
        byte[] bArr = this.f1122d;
        int i3 = this.f1125g;
        int i10 = i3 + i;
        int i11 = this.f1123e;
        if (i10 <= i11) {
            od.f.e(k0.a.k(i, "refillBuffer() called when ", " bytes were already available in buffer"));
            return false;
        }
        int i12 = this.i;
        if (i <= (Reader.READ_DONE - i12) - i3 && i12 + i3 + i <= this.f1127j) {
            if (i3 > 0) {
                if (i11 > i3) {
                    System.arraycopy(bArr, i3, bArr, 0, i11 - i3);
                }
                this.i += i3;
                this.f1123e -= i3;
                this.f1125g = 0;
            }
            int i13 = this.f1123e;
            try {
                int i14 = fileInputStream.read(bArr, i13, Math.min(bArr.length - i13, (Reader.READ_DONE - this.i) - i13));
                if (i14 == 0 || i14 < -1 || i14 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i14 + "\nThe InputStream implementation is buggy.");
                }
                if (i14 > 0) {
                    this.f1123e += i14;
                    H();
                    if (this.f1123e >= i) {
                        return true;
                    }
                    return K(i);
                }
            } catch (z e10) {
                e10.f1228c = true;
                throw e10;
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final void a(int i) throws z {
        if (this.f1126h != i) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int b() {
        return this.i + this.f1125g;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean c() {
        return this.f1125g == this.f1123e && !K(1);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final void d(int i) {
        this.f1127j = i;
        H();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int e(int i) throws z {
        if (i < 0) {
            throw z.d();
        }
        int i3 = this.i + this.f1125g + i;
        if (i3 < 0) {
            throw new z("Failed to parse the message.");
        }
        int i10 = this.f1127j;
        if (i3 > i10) {
            throw z.e();
        }
        this.f1127j = i3;
        H();
        return i10;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean f() {
        return F() != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final f g() throws IOException {
        byte[] bArr = this.f1122d;
        int iE = E();
        int i = this.f1123e;
        int i3 = this.f1125g;
        if (iE <= i - i3 && iE > 0) {
            f fVarC = f.c(i3, iE, bArr);
            this.f1125g += iE;
            return fVarC;
        }
        if (iE == 0) {
            return f.f1105g;
        }
        if (iE < 0) {
            throw z.d();
        }
        byte[] bArrA = A(iE);
        if (bArrA != null) {
            return f.c(0, bArrA.length, bArrA);
        }
        int i10 = this.f1125g;
        int i11 = this.f1123e;
        int length = i11 - i10;
        this.i += i11;
        this.f1125g = 0;
        this.f1123e = 0;
        ArrayList arrayListB = B(iE - length);
        byte[] bArr2 = new byte[iE];
        System.arraycopy(bArr, i10, bArr2, 0, length);
        int size = arrayListB.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayListB.get(i12);
            i12++;
            byte[] bArr3 = (byte[]) obj;
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        f fVar = f.f1105g;
        return new f(bArr2);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final double h() {
        return Double.longBitsToDouble(D());
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int i() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int j() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long k() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final float l() {
        return Float.intBitsToFloat(C());
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int m() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long n() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int o() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long p() {
        return D();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int q() {
        int iE = E();
        return (-(iE & 1)) ^ (iE >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long r() {
        long jF = F();
        return (-(jF & 1)) ^ (jF >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final String s() throws z {
        byte[] bArr = this.f1122d;
        int iE = E();
        if (iE > 0) {
            int i = this.f1123e;
            int i3 = this.f1125g;
            if (iE <= i - i3) {
                String str = new String(bArr, i3, iE, x.f1218a);
                this.f1125g += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw z.d();
        }
        if (iE > this.f1123e) {
            return new String(z(iE), x.f1218a);
        }
        I(iE);
        String str2 = new String(bArr, this.f1125g, iE, x.f1218a);
        this.f1125g += iE;
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final String t() throws IOException {
        byte[] bArrZ = this.f1122d;
        int iE = E();
        int i = this.f1125g;
        int i3 = this.f1123e;
        if (iE <= i3 - i && iE > 0) {
            this.f1125g = i + iE;
        } else {
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw z.d();
            }
            i = 0;
            if (iE <= i3) {
                I(iE);
                this.f1125g = iE;
            } else {
                bArrZ = z(iE);
            }
        }
        return m1.f1157a.o(bArrZ, i, iE);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int u() throws z {
        if (c()) {
            this.f1126h = 0;
            return 0;
        }
        int iE = E();
        this.f1126h = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int v() {
        return E();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long w() {
        return F();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean x(int i) throws z {
        byte[] bArr = this.f1122d;
        int i3 = i & 7;
        int i10 = 0;
        if (i3 != 0) {
            if (i3 == 1) {
                J(8);
                return true;
            }
            if (i3 == 2) {
                J(E());
                return true;
            }
            if (i3 == 3) {
                y();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw z.b();
            }
            J(4);
            return true;
        }
        if (this.f1123e - this.f1125g >= 10) {
            while (i10 < 10) {
                int i11 = this.f1125g;
                this.f1125g = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                }
            }
            throw z.c();
        }
        while (i10 < 10) {
            if (this.f1125g == this.f1123e) {
                I(1);
            }
            int i12 = this.f1125g;
            this.f1125g = i12 + 1;
            if (bArr[i12] < 0) {
                i10++;
            }
        }
        throw z.c();
        return true;
    }

    public final byte[] z(int i) throws IOException {
        byte[] bArrA = A(i);
        if (bArrA != null) {
            return bArrA;
        }
        int i3 = this.f1125g;
        int i10 = this.f1123e;
        int length = i10 - i3;
        this.i += i10;
        this.f1125g = 0;
        this.f1123e = 0;
        ArrayList arrayListB = B(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f1122d, i3, bArr, 0, length);
        int size = arrayListB.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayListB.get(i11);
            i11++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
