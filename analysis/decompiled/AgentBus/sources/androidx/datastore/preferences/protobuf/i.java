package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    public final InputStream f871c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f872d;

    /* renamed from: e, reason: collision with root package name */
    public int f873e;

    /* renamed from: f, reason: collision with root package name */
    public int f874f;

    /* renamed from: g, reason: collision with root package name */
    public int f875g;

    /* renamed from: h, reason: collision with root package name */
    public int f876h;

    /* renamed from: i, reason: collision with root package name */
    public int f877i;

    /* renamed from: j, reason: collision with root package name */
    public int f878j = Integer.MAX_VALUE;

    public i(InputStream inputStream) {
        Charset charset = y.f968a;
        this.f871c = inputStream;
        this.f872d = new byte[4096];
        this.f873e = 0;
        this.f875g = 0;
        this.f877i = 0;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String A() throws a0 {
        int iL = L();
        byte[] bArr = this.f872d;
        if (iL > 0) {
            int i2 = this.f873e;
            int i10 = this.f875g;
            if (iL <= i2 - i10) {
                String str = new String(bArr, i10, iL, y.f968a);
                this.f875g += iL;
                return str;
            }
        }
        if (iL == 0) {
            return "";
        }
        if (iL > this.f873e) {
            return new String(G(iL), y.f968a);
        }
        P(iL);
        String str2 = new String(bArr, this.f875g, iL, y.f968a);
        this.f875g += iL;
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String B() throws IOException {
        int iL = L();
        int i2 = this.f875g;
        int i10 = this.f873e;
        int i11 = i10 - i2;
        byte[] bArrG = this.f872d;
        if (iL <= i11 && iL > 0) {
            this.f875g = i2 + iL;
        } else {
            if (iL == 0) {
                return "";
            }
            i2 = 0;
            if (iL <= i10) {
                P(iL);
                this.f875g = iL;
            } else {
                bArrG = G(iL);
            }
        }
        return v1.f961a.a(bArrG, i2, iL);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int C() throws a0 {
        if (g()) {
            this.f876h = 0;
            return 0;
        }
        int iL = L();
        this.f876h = iL;
        if ((iL >>> 3) != 0) {
            return iL;
        }
        throw new a0("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int D() {
        return L();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long E() {
        return M();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean F(int i2) throws a0 {
        int iC;
        int i10 = i2 & 7;
        int i11 = 0;
        if (i10 == 0) {
            int i12 = this.f873e - this.f875g;
            byte[] bArr = this.f872d;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f875g;
                    this.f875g = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw a0.c();
            }
            while (i11 < 10) {
                if (this.f875g == this.f873e) {
                    P(1);
                }
                int i14 = this.f875g;
                this.f875g = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw a0.c();
            return true;
        }
        if (i10 == 1) {
            Q(8);
            return true;
        }
        if (i10 == 2) {
            Q(L());
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw a0.b();
            }
            Q(4);
            return true;
        }
        do {
            iC = C();
            if (iC == 0) {
                break;
            }
        } while (F(iC));
        b(((i2 >>> 3) << 3) | 4);
        return true;
    }

    public final byte[] G(int i2) throws IOException {
        byte[] bArrH = H(i2);
        if (bArrH != null) {
            return bArrH;
        }
        int i10 = this.f875g;
        int i11 = this.f873e;
        int length = i11 - i10;
        this.f877i += i11;
        this.f875g = 0;
        this.f873e = 0;
        ArrayList arrayListI = I(i2 - length);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f872d, i10, bArr, 0, length);
        Iterator it = arrayListI.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] H(int i2) throws IOException {
        if (i2 == 0) {
            return y.f969b;
        }
        if (i2 < 0) {
            throw a0.d();
        }
        int i10 = this.f877i;
        int i11 = this.f875g;
        int i12 = i10 + i11 + i2;
        if (i12 - Integer.MAX_VALUE > 0) {
            throw new a0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i13 = this.f878j;
        if (i12 > i13) {
            Q((i13 - i10) - i11);
            throw a0.e();
        }
        int i14 = this.f873e - i11;
        int i15 = i2 - i14;
        InputStream inputStream = this.f871c;
        if (i15 >= 4096) {
            try {
                if (i15 > inputStream.available()) {
                    return null;
                }
            } catch (a0 e10) {
                e10.f794f = true;
                throw e10;
            }
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f872d, this.f875g, bArr, 0, i14);
        this.f877i += this.f873e;
        this.f875g = 0;
        this.f873e = 0;
        while (i14 < i2) {
            try {
                int i16 = inputStream.read(bArr, i14, i2 - i14);
                if (i16 == -1) {
                    throw a0.e();
                }
                this.f877i += i16;
                i14 += i16;
            } catch (a0 e11) {
                e11.f794f = true;
                throw e11;
            }
        }
        return bArr;
    }

    public final ArrayList I(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int iMin = Math.min(i2, 4096);
            byte[] bArr = new byte[iMin];
            int i10 = 0;
            while (i10 < iMin) {
                int i11 = this.f871c.read(bArr, i10, iMin - i10);
                if (i11 == -1) {
                    throw a0.e();
                }
                this.f877i += i11;
                i10 += i11;
            }
            i2 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int J() throws a0 {
        int i2 = this.f875g;
        if (this.f873e - i2 < 4) {
            P(4);
            i2 = this.f875g;
        }
        this.f875g = i2 + 4;
        byte[] bArr = this.f872d;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long K() throws a0 {
        int i2 = this.f875g;
        if (this.f873e - i2 < 8) {
            P(8);
            i2 = this.f875g;
        }
        this.f875g = i2 + 8;
        byte[] bArr = this.f872d;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int L() {
        int i2;
        int i10 = this.f875g;
        int i11 = this.f873e;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f872d;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f875g = i12;
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
                this.f875g = i13;
                return i2;
            }
        }
        return (int) N();
    }

    public final long M() {
        long j2;
        long j4;
        long j10;
        long j11;
        int i2 = this.f875g;
        int i10 = this.f873e;
        if (i10 != i2) {
            int i11 = i2 + 1;
            byte[] bArr = this.f872d;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                this.f875g = i11;
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
                this.f875g = i12;
                return j2;
            }
        }
        return N();
    }

    public final long N() throws a0 {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            if (this.f875g == this.f873e) {
                P(1);
            }
            int i10 = this.f875g;
            this.f875g = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f872d[i10] & 128) == 0) {
                return j2;
            }
        }
        throw a0.c();
    }

    public final void O() {
        int i2 = this.f873e + this.f874f;
        this.f873e = i2;
        int i10 = this.f877i + i2;
        int i11 = this.f878j;
        if (i10 <= i11) {
            this.f874f = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f874f = i12;
        this.f873e = i2 - i12;
    }

    public final void P(int i2) throws a0 {
        if (R(i2)) {
            return;
        }
        if (i2 <= (Integer.MAX_VALUE - this.f877i) - this.f875g) {
            throw a0.e();
        }
        throw new a0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void Q(int i2) throws a0 {
        int i10 = this.f873e;
        int i11 = this.f875g;
        if (i2 <= i10 - i11 && i2 >= 0) {
            this.f875g = i11 + i2;
            return;
        }
        InputStream inputStream = this.f871c;
        if (i2 < 0) {
            throw a0.d();
        }
        int i12 = this.f877i;
        int i13 = i12 + i11;
        int i14 = i13 + i2;
        int i15 = this.f878j;
        if (i14 > i15) {
            Q((i15 - i12) - i11);
            throw a0.e();
        }
        this.f877i = i13;
        int i16 = i10 - i11;
        this.f873e = 0;
        this.f875g = 0;
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
                } catch (a0 e10) {
                    e10.f794f = true;
                    throw e10;
                }
            } catch (Throwable th) {
                this.f877i += i16;
                O();
                throw th;
            }
        }
        this.f877i += i16;
        O();
        if (i16 >= i2) {
            return;
        }
        int i17 = this.f873e;
        int i18 = i17 - this.f875g;
        this.f875g = i17;
        P(1);
        while (true) {
            int i19 = i2 - i18;
            int i20 = this.f873e;
            if (i19 <= i20) {
                this.f875g = i19;
                return;
            } else {
                i18 += i20;
                this.f875g = i20;
                P(1);
            }
        }
    }

    public final boolean R(int i2) throws IOException {
        InputStream inputStream = this.f871c;
        int i10 = this.f875g;
        int i11 = i10 + i2;
        int i12 = this.f873e;
        if (i11 <= i12) {
            throw new IllegalStateException(a1.a.f(i2, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i13 = this.f877i;
        if (i2 <= (Integer.MAX_VALUE - i13) - i10 && i13 + i10 + i2 <= this.f878j) {
            byte[] bArr = this.f872d;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.f877i += i10;
                this.f873e -= i10;
                this.f875g = 0;
            }
            int i14 = this.f873e;
            try {
                int i15 = inputStream.read(bArr, i14, Math.min(bArr.length - i14, (Integer.MAX_VALUE - this.f877i) - i14));
                if (i15 == 0 || i15 < -1 || i15 > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i15 + "\nThe InputStream implementation is buggy.");
                }
                if (i15 > 0) {
                    this.f873e += i15;
                    O();
                    if (this.f873e >= i2) {
                        return true;
                    }
                    return R(i2);
                }
            } catch (a0 e10) {
                e10.f794f = true;
                throw e10;
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void b(int i2) throws a0 {
        if (this.f876h != i2) {
            throw new a0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int f() {
        return this.f877i + this.f875g;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean g() {
        return this.f875g == this.f873e && !R(1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void j(int i2) {
        this.f878j = i2;
        O();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int l(int i2) throws a0 {
        if (i2 < 0) {
            throw a0.d();
        }
        int i10 = this.f877i + this.f875g + i2;
        int i11 = this.f878j;
        if (i10 > i11) {
            throw a0.e();
        }
        this.f878j = i10;
        O();
        return i11;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean m() {
        return M() != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final g n() throws IOException {
        int iL = L();
        int i2 = this.f873e;
        int i10 = this.f875g;
        int i11 = i2 - i10;
        byte[] bArr = this.f872d;
        if (iL <= i11 && iL > 0) {
            g gVarH = g.h(bArr, i10, iL);
            this.f875g += iL;
            return gVarH;
        }
        if (iL == 0) {
            return g.f850h;
        }
        byte[] bArrH = H(iL);
        if (bArrH != null) {
            return g.h(bArrH, 0, bArrH.length);
        }
        int i12 = this.f875g;
        int i13 = this.f873e;
        int length = i13 - i12;
        this.f877i += i13;
        this.f875g = 0;
        this.f873e = 0;
        ArrayList arrayListI = I(iL - length);
        byte[] bArr2 = new byte[iL];
        System.arraycopy(bArr, i12, bArr2, 0, length);
        Iterator it = arrayListI.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        g gVar = g.f850h;
        return new g(bArr2);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final double p() {
        return Double.longBitsToDouble(K());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int q() {
        return L();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int r() {
        return J();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long s() {
        return K();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final float t() {
        return Float.intBitsToFloat(J());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int u() {
        return L();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long v() {
        return M();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int w() {
        return J();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long x() {
        return K();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int y() {
        int iL = L();
        return (-(iL & 1)) ^ (iL >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long z() {
        long jM = M();
        return (-(jM & 1)) ^ (jM >>> 1);
    }
}
