package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n extends o {

    /* renamed from: c, reason: collision with root package name */
    public final InputStream f2450c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2451d;

    /* renamed from: e, reason: collision with root package name */
    public int f2452e;

    /* renamed from: f, reason: collision with root package name */
    public int f2453f;

    /* renamed from: g, reason: collision with root package name */
    public int f2454g;

    /* renamed from: h, reason: collision with root package name */
    public int f2455h;

    /* renamed from: i, reason: collision with root package name */
    public int f2456i;

    /* renamed from: j, reason: collision with root package name */
    public int f2457j = Integer.MAX_VALUE;

    public n(InputStream inputStream) {
        p2.a(inputStream, "input");
        this.f2450c = inputStream;
        this.f2451d = new byte[4096];
        this.f2452e = 0;
        this.f2454g = 0;
        this.f2456i = 0;
    }

    @Override // com.google.protobuf.o
    public final boolean A(int i2) throws r2 {
        int i10 = i2 & 7;
        int i11 = 0;
        if (i10 != 0) {
            if (i10 == 1) {
                M(8);
                return true;
            }
            if (i10 == 2) {
                M(H());
                return true;
            }
            if (i10 == 3) {
                B();
                a(((i2 >>> 3) << 3) | 4);
                return true;
            }
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw r2.c();
            }
            M(4);
            return true;
        }
        int i12 = this.f2452e - this.f2454g;
        byte[] bArr = this.f2451d;
        if (i12 >= 10) {
            while (i11 < 10) {
                int i13 = this.f2454g;
                this.f2454g = i13 + 1;
                if (bArr[i13] < 0) {
                    i11++;
                }
            }
            throw r2.d();
        }
        while (i11 < 10) {
            if (this.f2454g == this.f2452e) {
                L(1);
            }
            int i14 = this.f2454g;
            this.f2454g = i14 + 1;
            if (bArr[i14] < 0) {
                i11++;
            }
        }
        throw r2.d();
        return true;
    }

    public final byte[] C(int i2) throws IOException {
        byte[] bArrD = D(i2);
        if (bArrD != null) {
            return bArrD;
        }
        int i10 = this.f2454g;
        int i11 = this.f2452e;
        int length = i11 - i10;
        this.f2456i += i11;
        this.f2454g = 0;
        this.f2452e = 0;
        ArrayList arrayListE = E(i2 - length);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f2451d, i10, bArr, 0, length);
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] D(int i2) throws IOException {
        if (i2 == 0) {
            return p2.f2496b;
        }
        if (i2 < 0) {
            throw r2.e();
        }
        int i10 = this.f2456i;
        int i11 = this.f2454g;
        int i12 = i10 + i11 + i2;
        if (i12 - Integer.MAX_VALUE > 0) {
            throw new r2("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i13 = this.f2457j;
        if (i12 > i13) {
            M((i13 - i10) - i11);
            throw r2.g();
        }
        int i14 = this.f2452e - i11;
        int i15 = i2 - i14;
        InputStream inputStream = this.f2450c;
        if (i15 >= 4096) {
            try {
                if (i15 > inputStream.available()) {
                    return null;
                }
            } catch (r2 e10) {
                e10.f2512f = true;
                throw e10;
            }
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f2451d, this.f2454g, bArr, 0, i14);
        this.f2456i += this.f2452e;
        this.f2454g = 0;
        this.f2452e = 0;
        while (i14 < i2) {
            try {
                int i16 = inputStream.read(bArr, i14, i2 - i14);
                if (i16 == -1) {
                    throw r2.g();
                }
                this.f2456i += i16;
                i14 += i16;
            } catch (r2 e11) {
                e11.f2512f = true;
                throw e11;
            }
        }
        return bArr;
    }

    public final ArrayList E(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int iMin = Math.min(i2, 4096);
            byte[] bArr = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = this.f2450c.read(bArr, i10, iMin - i10);
                if (i11 == -1) {
                    throw r2.g();
                }
                this.f2456i += i11;
                i10 += i11;
            }
            i2 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int F() throws r2 {
        int i2 = this.f2454g;
        if (this.f2452e - i2 < 4) {
            L(4);
            i2 = this.f2454g;
        }
        this.f2454g = i2 + 4;
        byte[] bArr = this.f2451d;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long G() throws r2 {
        int i2 = this.f2454g;
        if (this.f2452e - i2 < 8) {
            L(8);
            i2 = this.f2454g;
        }
        this.f2454g = i2 + 8;
        byte[] bArr = this.f2451d;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int H() {
        int i2;
        int i10 = this.f2454g;
        int i11 = this.f2452e;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f2451d;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f2454g = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b10;
                if (i14 < 0) {
                    i2 = i14 ^ (-128);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    if (i16 >= 0) {
                        i2 = i16 ^ 16256;
                    } else {
                        int i17 = i10 + 4;
                        int i18 = i16 ^ (bArr[i15] << 21);
                        if (i18 < 0) {
                            i2 = (-2080896) ^ i18;
                        } else {
                            i15 = i10 + 5;
                            byte b11 = bArr[i17];
                            int i19 = (i18 ^ (b11 << 28)) ^ 266354560;
                            if (b11 < 0) {
                                i17 = i10 + 6;
                                if (bArr[i15] < 0) {
                                    i15 = i10 + 7;
                                    if (bArr[i17] < 0) {
                                        i17 = i10 + 8;
                                        if (bArr[i15] < 0) {
                                            i15 = i10 + 9;
                                            if (bArr[i17] < 0) {
                                                int i20 = i10 + 10;
                                                if (bArr[i15] >= 0) {
                                                    i13 = i20;
                                                    i2 = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i19;
                            }
                            i2 = i19;
                        }
                        i13 = i17;
                    }
                    i13 = i15;
                }
                this.f2454g = i13;
                return i2;
            }
        }
        return (int) J();
    }

    public final long I() {
        long j2;
        long j4;
        long j10;
        long j11;
        int i2 = this.f2454g;
        int i10 = this.f2452e;
        if (i10 != i2) {
            int i11 = i2 + 1;
            byte[] bArr = this.f2451d;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                this.f2454g = i11;
                return b10;
            }
            if (i10 - i11 >= 9) {
                int i12 = i2 + 2;
                int i13 = (bArr[i11] << 7) ^ b10;
                if (i13 < 0) {
                    j2 = i13 ^ (-128);
                } else {
                    int i14 = i2 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        j2 = i15 ^ 16256;
                        i12 = i14;
                    } else {
                        int i16 = i2 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            j11 = (-2080896) ^ i17;
                        } else {
                            long j12 = i17;
                            i12 = i2 + 5;
                            long j13 = j12 ^ (bArr[i16] << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i16 = i2 + 6;
                                long j14 = j13 ^ (bArr[i12] << 35);
                                if (j14 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    i12 = i2 + 7;
                                    j13 = j14 ^ (bArr[i16] << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i16 = i2 + 8;
                                        j14 = j13 ^ (bArr[i12] << 49);
                                        if (j14 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            i12 = i2 + 9;
                                            long j15 = (j14 ^ (bArr[i16] << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i18 = i2 + 10;
                                                if (bArr[i12] >= 0) {
                                                    i12 = i18;
                                                }
                                            }
                                            j2 = j15;
                                        }
                                    }
                                }
                                j11 = j4 ^ j14;
                            }
                            j2 = j10 ^ j13;
                        }
                        i12 = i16;
                        j2 = j11;
                    }
                }
                this.f2454g = i12;
                return j2;
            }
        }
        return J();
    }

    public final long J() throws r2 {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            if (this.f2454g == this.f2452e) {
                L(1);
            }
            int i10 = this.f2454g;
            this.f2454g = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f2451d[i10] & 128) == 0) {
                return j2;
            }
        }
        throw r2.d();
    }

    public final void K() {
        int i2 = this.f2452e + this.f2453f;
        this.f2452e = i2;
        int i10 = this.f2456i + i2;
        int i11 = this.f2457j;
        if (i10 <= i11) {
            this.f2453f = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f2453f = i12;
        this.f2452e = i2 - i12;
    }

    public final void L(int i2) throws r2 {
        if (N(i2)) {
            return;
        }
        if (i2 <= (Integer.MAX_VALUE - this.f2456i) - this.f2454g) {
            throw r2.g();
        }
        throw new r2("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void M(int i2) throws r2 {
        int i10 = this.f2452e;
        int i11 = this.f2454g;
        if (i2 <= i10 - i11 && i2 >= 0) {
            this.f2454g = i11 + i2;
            return;
        }
        InputStream inputStream = this.f2450c;
        if (i2 < 0) {
            throw r2.e();
        }
        int i12 = this.f2456i;
        int i13 = i12 + i11;
        int i14 = i13 + i2;
        int i15 = this.f2457j;
        if (i14 > i15) {
            M((i15 - i12) - i11);
            throw r2.g();
        }
        this.f2456i = i13;
        int i16 = i10 - i11;
        this.f2452e = 0;
        this.f2454g = 0;
        while (i16 < i2) {
            long j2 = i2 - i16;
            try {
                try {
                    long jSkip = inputStream.skip(j2);
                    if (jSkip < 0 || jSkip > j2) {
                        throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i16 += (int) jSkip;
                    }
                } catch (r2 e10) {
                    e10.f2512f = true;
                    throw e10;
                }
            } catch (Throwable th) {
                this.f2456i += i16;
                K();
                throw th;
            }
        }
        this.f2456i += i16;
        K();
        if (i16 >= i2) {
            return;
        }
        int i17 = this.f2452e;
        int i18 = i17 - this.f2454g;
        this.f2454g = i17;
        L(1);
        while (true) {
            int i19 = i2 - i18;
            int i20 = this.f2452e;
            if (i19 <= i20) {
                this.f2454g = i19;
                return;
            } else {
                i18 += i20;
                this.f2454g = i20;
                L(1);
            }
        }
    }

    public final boolean N(int i2) throws IOException {
        InputStream inputStream = this.f2450c;
        int i10 = this.f2454g;
        int i11 = i10 + i2;
        int i12 = this.f2452e;
        if (i11 <= i12) {
            throw new IllegalStateException(a1.a.f(i2, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i13 = this.f2456i;
        if (i2 <= (Integer.MAX_VALUE - i13) - i10 && i13 + i10 + i2 <= this.f2457j) {
            byte[] bArr = this.f2451d;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.f2456i += i10;
                this.f2452e -= i10;
                this.f2454g = 0;
            }
            int i14 = this.f2452e;
            try {
                int i15 = inputStream.read(bArr, i14, Math.min(bArr.length - i14, (Integer.MAX_VALUE - this.f2456i) - i14));
                if (i15 == 0 || i15 < -1 || i15 > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i15 + "\nThe InputStream implementation is buggy.");
                }
                if (i15 > 0) {
                    this.f2452e += i15;
                    K();
                    if (this.f2452e >= i2) {
                        return true;
                    }
                    return N(i2);
                }
            } catch (r2 e10) {
                e10.f2512f = true;
                throw e10;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.o
    public final void a(int i2) throws r2 {
        if (this.f2455h != i2) {
            throw new r2("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.protobuf.o
    public final int d() {
        return this.f2456i + this.f2454g;
    }

    @Override // com.google.protobuf.o
    public final boolean e() {
        return this.f2454g == this.f2452e && !N(1);
    }

    @Override // com.google.protobuf.o
    public final void g(int i2) {
        this.f2457j = i2;
        K();
    }

    @Override // com.google.protobuf.o
    public final int h(int i2) throws r2 {
        if (i2 < 0) {
            throw r2.e();
        }
        int i10 = this.f2456i + this.f2454g + i2;
        if (i10 < 0) {
            throw r2.f();
        }
        int i11 = this.f2457j;
        if (i10 > i11) {
            throw r2.g();
        }
        this.f2457j = i10;
        K();
        return i11;
    }

    @Override // com.google.protobuf.o
    public final boolean i() {
        return I() != 0;
    }

    @Override // com.google.protobuf.o
    public final k j() throws IOException {
        int iH = H();
        int i2 = this.f2452e;
        int i10 = this.f2454g;
        int i11 = i2 - i10;
        byte[] bArr = this.f2451d;
        if (iH <= i11 && iH > 0) {
            k kVarH = l.h(bArr, i10, iH);
            this.f2454g += iH;
            return kVarH;
        }
        if (iH == 0) {
            return l.f2424g;
        }
        if (iH < 0) {
            throw r2.e();
        }
        byte[] bArrD = D(iH);
        if (bArrD != null) {
            return l.h(bArrD, 0, bArrD.length);
        }
        int i12 = this.f2454g;
        int i13 = this.f2452e;
        int length = i13 - i12;
        this.f2456i += i13;
        this.f2454g = 0;
        this.f2452e = 0;
        ArrayList arrayListE = E(iH - length);
        byte[] bArr2 = new byte[iH];
        System.arraycopy(bArr, i12, bArr2, 0, length);
        Iterator it = arrayListE.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        k kVar = l.f2424g;
        return new k(bArr2);
    }

    @Override // com.google.protobuf.o
    public final double k() {
        return Double.longBitsToDouble(G());
    }

    @Override // com.google.protobuf.o
    public final int l() {
        return H();
    }

    @Override // com.google.protobuf.o
    public final int m() {
        return F();
    }

    @Override // com.google.protobuf.o
    public final long n() {
        return G();
    }

    @Override // com.google.protobuf.o
    public final float o() {
        return Float.intBitsToFloat(F());
    }

    @Override // com.google.protobuf.o
    public final int p() {
        return H();
    }

    @Override // com.google.protobuf.o
    public final long q() {
        return I();
    }

    @Override // com.google.protobuf.o
    public final int r() {
        return F();
    }

    @Override // com.google.protobuf.o
    public final long s() {
        return G();
    }

    @Override // com.google.protobuf.o
    public final int t() {
        return o.b(H());
    }

    @Override // com.google.protobuf.o
    public final long u() {
        return o.c(I());
    }

    @Override // com.google.protobuf.o
    public final String v() throws r2 {
        int iH = H();
        byte[] bArr = this.f2451d;
        if (iH > 0) {
            int i2 = this.f2452e;
            int i10 = this.f2454g;
            if (iH <= i2 - i10) {
                String str = new String(bArr, i10, iH, p2.f2495a);
                this.f2454g += iH;
                return str;
            }
        }
        if (iH == 0) {
            return "";
        }
        if (iH < 0) {
            throw r2.e();
        }
        if (iH > this.f2452e) {
            return new String(C(iH), p2.f2495a);
        }
        L(iH);
        String str2 = new String(bArr, this.f2454g, iH, p2.f2495a);
        this.f2454g += iH;
        return str2;
    }

    @Override // com.google.protobuf.o
    public final String w() throws IOException {
        int iH = H();
        int i2 = this.f2454g;
        int i10 = this.f2452e;
        int i11 = i10 - i2;
        byte[] bArrC = this.f2451d;
        if (iH <= i11 && iH > 0) {
            this.f2454g = i2 + iH;
        } else {
            if (iH == 0) {
                return "";
            }
            if (iH < 0) {
                throw r2.e();
            }
            i2 = 0;
            if (iH <= i10) {
                L(iH);
                this.f2454g = iH;
            } else {
                bArrC = C(iH);
            }
        }
        return l4.f2432a.q(bArrC, i2, iH);
    }

    @Override // com.google.protobuf.o
    public final int x() throws r2 {
        if (e()) {
            this.f2455h = 0;
            return 0;
        }
        int iH = H();
        this.f2455h = iH;
        if ((iH >>> 3) != 0) {
            return iH;
        }
        throw r2.a();
    }

    @Override // com.google.protobuf.o
    public final int y() {
        return H();
    }

    @Override // com.google.protobuf.o
    public final long z() {
        return I();
    }
}
