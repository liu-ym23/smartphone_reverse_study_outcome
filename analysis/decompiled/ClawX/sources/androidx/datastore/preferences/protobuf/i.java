package androidx.datastore.preferences.protobuf;

import com.stepos.stepclaw.SecurePrefs;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends a2.e {

    /* renamed from: c, reason: collision with root package name */
    public final FileInputStream f492c;
    public final byte[] d;

    /* renamed from: e, reason: collision with root package name */
    public int f493e;

    /* renamed from: f, reason: collision with root package name */
    public int f494f;

    /* renamed from: g, reason: collision with root package name */
    public int f495g;

    /* renamed from: h, reason: collision with root package name */
    public int f496h;

    /* renamed from: i, reason: collision with root package name */
    public int f497i;

    /* renamed from: j, reason: collision with root package name */
    public int f498j = Integer.MAX_VALUE;

    public i(FileInputStream fileInputStream) {
        Charset charset = x.f579a;
        this.f492c = fileInputStream;
        this.d = new byte[4096];
        this.f493e = 0;
        this.f495g = 0;
        this.f497i = 0;
    }

    @Override // a2.e
    public final String A() throws z {
        int iM = M();
        byte[] bArr = this.d;
        if (iM > 0) {
            int i8 = this.f493e;
            int i9 = this.f495g;
            if (iM <= i8 - i9) {
                String str = new String(bArr, i9, iM, x.f579a);
                this.f495g += iM;
                return str;
            }
        }
        if (iM == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (iM < 0) {
            throw z.d();
        }
        if (iM > this.f493e) {
            return new String(H(iM), x.f579a);
        }
        Q(iM);
        String str2 = new String(bArr, this.f495g, iM, x.f579a);
        this.f495g += iM;
        return str2;
    }

    @Override // a2.e
    public final String B() throws IOException {
        int iM = M();
        int i8 = this.f495g;
        int i9 = this.f493e;
        int i10 = i9 - i8;
        byte[] bArrH = this.d;
        if (iM <= i10 && iM > 0) {
            this.f495g = i8 + iM;
        } else {
            if (iM == 0) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (iM < 0) {
                throw z.d();
            }
            i8 = 0;
            if (iM <= i9) {
                Q(iM);
                this.f495g = iM;
            } else {
                bArrH = H(iM);
            }
        }
        return k1.f506a.l(i8, iM, bArrH);
    }

    @Override // a2.e
    public final int C() throws z {
        if (g()) {
            this.f496h = 0;
            return 0;
        }
        int iM = M();
        this.f496h = iM;
        if ((iM >>> 3) != 0) {
            return iM;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // a2.e
    public final int D() {
        return M();
    }

    @Override // a2.e
    public final long E() {
        return N();
    }

    @Override // a2.e
    public final boolean F(int i8) throws z {
        int i9 = i8 & 7;
        int i10 = 0;
        if (i9 != 0) {
            if (i9 == 1) {
                R(8);
                return true;
            }
            if (i9 == 2) {
                R(M());
                return true;
            }
            if (i9 == 3) {
                G();
                b(((i8 >>> 3) << 3) | 4);
                return true;
            }
            if (i9 == 4) {
                return false;
            }
            if (i9 != 5) {
                throw z.b();
            }
            R(4);
            return true;
        }
        int i11 = this.f493e - this.f495g;
        byte[] bArr = this.d;
        if (i11 >= 10) {
            while (i10 < 10) {
                int i12 = this.f495g;
                this.f495g = i12 + 1;
                if (bArr[i12] < 0) {
                    i10++;
                }
            }
            throw z.c();
        }
        while (i10 < 10) {
            if (this.f495g == this.f493e) {
                Q(1);
            }
            int i13 = this.f495g;
            this.f495g = i13 + 1;
            if (bArr[i13] < 0) {
                i10++;
            }
        }
        throw z.c();
        return true;
    }

    public final byte[] H(int i8) throws IOException {
        byte[] bArrI = I(i8);
        if (bArrI != null) {
            return bArrI;
        }
        int i9 = this.f495g;
        int i10 = this.f493e;
        int length = i10 - i9;
        this.f497i += i10;
        this.f495g = 0;
        this.f493e = 0;
        ArrayList arrayListJ = J(i8 - length);
        byte[] bArr = new byte[i8];
        System.arraycopy(this.d, i9, bArr, 0, length);
        int size = arrayListJ.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayListJ.get(i11);
            i11++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] I(int i8) throws IOException {
        if (i8 == 0) {
            return x.f580b;
        }
        if (i8 < 0) {
            throw z.d();
        }
        int i9 = this.f497i;
        int i10 = this.f495g;
        int i11 = i9 + i10 + i8;
        if (i11 - Integer.MAX_VALUE > 0) {
            throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i12 = this.f498j;
        if (i11 > i12) {
            R((i12 - i9) - i10);
            throw z.e();
        }
        int i13 = this.f493e - i10;
        int i14 = i8 - i13;
        FileInputStream fileInputStream = this.f492c;
        if (i14 >= 4096) {
            try {
                if (i14 > fileInputStream.available()) {
                    return null;
                }
            } catch (z e9) {
                e9.f587a = true;
                throw e9;
            }
        }
        byte[] bArr = new byte[i8];
        System.arraycopy(this.d, this.f495g, bArr, 0, i13);
        this.f497i += this.f493e;
        this.f495g = 0;
        this.f493e = 0;
        while (i13 < i8) {
            try {
                int i15 = fileInputStream.read(bArr, i13, i8 - i13);
                if (i15 == -1) {
                    throw z.e();
                }
                this.f497i += i15;
                i13 += i15;
            } catch (z e10) {
                e10.f587a = true;
                throw e10;
            }
        }
        return bArr;
    }

    public final ArrayList J(int i8) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i8 > 0) {
            int iMin = Math.min(i8, 4096);
            byte[] bArr = new byte[iMin];
            int i9 = 0;
            while (i9 < iMin) {
                int i10 = this.f492c.read(bArr, i9, iMin - i9);
                if (i10 == -1) {
                    throw z.e();
                }
                this.f497i += i10;
                i9 += i10;
            }
            i8 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int K() throws z {
        int i8 = this.f495g;
        if (this.f493e - i8 < 4) {
            Q(4);
            i8 = this.f495g;
        }
        this.f495g = i8 + 4;
        byte[] bArr = this.d;
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public final long L() throws z {
        int i8 = this.f495g;
        if (this.f493e - i8 < 8) {
            Q(8);
            i8 = this.f495g;
        }
        this.f495g = i8 + 8;
        byte[] bArr = this.d;
        return ((bArr[i8 + 1] & 255) << 8) | (bArr[i8] & 255) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48) | ((bArr[i8 + 7] & 255) << 56);
    }

    public final int M() {
        int i8;
        int i9 = this.f495g;
        int i10 = this.f493e;
        if (i10 != i9) {
            int i11 = i9 + 1;
            byte[] bArr = this.d;
            byte b9 = bArr[i9];
            if (b9 >= 0) {
                this.f495g = i11;
                return b9;
            }
            if (i10 - i11 >= 9) {
                int i12 = i9 + 2;
                int i13 = (bArr[i11] << 7) ^ b9;
                if (i13 < 0) {
                    i8 = i13 ^ (-128);
                } else {
                    int i14 = i9 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        i8 = i15 ^ 16256;
                    } else {
                        int i16 = i9 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            i8 = (-2080896) ^ i17;
                        } else {
                            i14 = i9 + 5;
                            byte b10 = bArr[i16];
                            int i18 = (i17 ^ (b10 << 28)) ^ 266354560;
                            if (b10 < 0) {
                                i16 = i9 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i9 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i9 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i9 + 9;
                                            if (bArr[i16] < 0) {
                                                int i19 = i9 + 10;
                                                if (bArr[i14] >= 0) {
                                                    i12 = i19;
                                                    i8 = i18;
                                                }
                                            }
                                        }
                                    }
                                }
                                i8 = i18;
                            }
                            i8 = i18;
                        }
                        i12 = i16;
                    }
                    i12 = i14;
                }
                this.f495g = i12;
                return i8;
            }
        }
        return (int) O();
    }

    public final long N() {
        long j4;
        long j8;
        long j9;
        long j10;
        int i8 = this.f495g;
        int i9 = this.f493e;
        if (i9 != i8) {
            int i10 = i8 + 1;
            byte[] bArr = this.d;
            byte b9 = bArr[i8];
            if (b9 >= 0) {
                this.f495g = i10;
                return b9;
            }
            if (i9 - i10 >= 9) {
                int i11 = i8 + 2;
                int i12 = (bArr[i10] << 7) ^ b9;
                if (i12 < 0) {
                    j4 = i12 ^ (-128);
                } else {
                    int i13 = i8 + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        j4 = i14 ^ 16256;
                        i11 = i13;
                    } else {
                        int i15 = i8 + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            j10 = (-2080896) ^ i16;
                        } else {
                            long j11 = i16;
                            i11 = i8 + 5;
                            long j12 = j11 ^ (bArr[i15] << 28);
                            if (j12 >= 0) {
                                j9 = 266354560;
                            } else {
                                i15 = i8 + 6;
                                long j13 = j12 ^ (bArr[i11] << 35);
                                if (j13 < 0) {
                                    j8 = -34093383808L;
                                } else {
                                    i11 = i8 + 7;
                                    j12 = j13 ^ (bArr[i15] << 42);
                                    if (j12 >= 0) {
                                        j9 = 4363953127296L;
                                    } else {
                                        i15 = i8 + 8;
                                        j13 = j12 ^ (bArr[i11] << 49);
                                        if (j13 < 0) {
                                            j8 = -558586000294016L;
                                        } else {
                                            i11 = i8 + 9;
                                            long j14 = (j13 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                            if (j14 < 0) {
                                                int i17 = i8 + 10;
                                                if (bArr[i11] >= 0) {
                                                    i11 = i17;
                                                }
                                            }
                                            j4 = j14;
                                        }
                                    }
                                }
                                j10 = j8 ^ j13;
                            }
                            j4 = j9 ^ j12;
                        }
                        i11 = i15;
                        j4 = j10;
                    }
                }
                this.f495g = i11;
                return j4;
            }
        }
        return O();
    }

    public final long O() throws z {
        long j4 = 0;
        for (int i8 = 0; i8 < 64; i8 += 7) {
            if (this.f495g == this.f493e) {
                Q(1);
            }
            int i9 = this.f495g;
            this.f495g = i9 + 1;
            j4 |= (r3 & AbstractJsonLexerKt.TC_INVALID) << i8;
            if ((this.d[i9] & 128) == 0) {
                return j4;
            }
        }
        throw z.c();
    }

    public final void P() {
        int i8 = this.f493e + this.f494f;
        this.f493e = i8;
        int i9 = this.f497i + i8;
        int i10 = this.f498j;
        if (i9 <= i10) {
            this.f494f = 0;
            return;
        }
        int i11 = i9 - i10;
        this.f494f = i11;
        this.f493e = i8 - i11;
    }

    public final void Q(int i8) throws z {
        if (S(i8)) {
            return;
        }
        if (i8 <= (Integer.MAX_VALUE - this.f497i) - this.f495g) {
            throw z.e();
        }
        throw new z("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void R(int i8) throws z {
        int i9 = this.f493e;
        int i10 = this.f495g;
        int i11 = i9 - i10;
        if (i8 <= i11 && i8 >= 0) {
            this.f495g = i10 + i8;
            return;
        }
        FileInputStream fileInputStream = this.f492c;
        if (i8 < 0) {
            throw z.d();
        }
        int i12 = this.f497i;
        int i13 = i12 + i10;
        int i14 = i13 + i8;
        int i15 = this.f498j;
        if (i14 > i15) {
            R((i15 - i12) - i10);
            throw z.e();
        }
        this.f497i = i13;
        this.f493e = 0;
        this.f495g = 0;
        while (i11 < i8) {
            long j4 = i8 - i11;
            try {
                try {
                    long jSkip = fileInputStream.skip(j4);
                    if (jSkip < 0 || jSkip > j4) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i11 += (int) jSkip;
                    }
                } catch (z e9) {
                    e9.f587a = true;
                    throw e9;
                }
            } catch (Throwable th) {
                this.f497i += i11;
                P();
                throw th;
            }
        }
        this.f497i += i11;
        P();
        if (i11 >= i8) {
            return;
        }
        int i16 = this.f493e;
        int i17 = i16 - this.f495g;
        this.f495g = i16;
        Q(1);
        while (true) {
            int i18 = i8 - i17;
            int i19 = this.f493e;
            if (i18 <= i19) {
                this.f495g = i18;
                return;
            } else {
                i17 += i19;
                this.f495g = i19;
                Q(1);
            }
        }
    }

    public final boolean S(int i8) throws IOException {
        FileInputStream fileInputStream = this.f492c;
        int i9 = this.f495g;
        int i10 = i9 + i8;
        int i11 = this.f493e;
        if (i10 <= i11) {
            throw new IllegalStateException(a8.b.k(i8, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i12 = this.f497i;
        if (i8 <= (Integer.MAX_VALUE - i12) - i9 && i12 + i9 + i8 <= this.f498j) {
            byte[] bArr = this.d;
            if (i9 > 0) {
                if (i11 > i9) {
                    System.arraycopy(bArr, i9, bArr, 0, i11 - i9);
                }
                this.f497i += i9;
                this.f493e -= i9;
                this.f495g = 0;
            }
            int i13 = this.f493e;
            try {
                int i14 = fileInputStream.read(bArr, i13, Math.min(bArr.length - i13, (Integer.MAX_VALUE - this.f497i) - i13));
                if (i14 == 0 || i14 < -1 || i14 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i14 + "\nThe InputStream implementation is buggy.");
                }
                if (i14 > 0) {
                    this.f493e += i14;
                    P();
                    if (this.f493e >= i8) {
                        return true;
                    }
                    return S(i8);
                }
            } catch (z e9) {
                e9.f587a = true;
                throw e9;
            }
        }
        return false;
    }

    @Override // a2.e
    public final void b(int i8) throws z {
        if (this.f496h != i8) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // a2.e
    public final int f() {
        return this.f497i + this.f495g;
    }

    @Override // a2.e
    public final boolean g() {
        return this.f495g == this.f493e && !S(1);
    }

    @Override // a2.e
    public final void j(int i8) {
        this.f498j = i8;
        P();
    }

    @Override // a2.e
    public final int l(int i8) throws z {
        if (i8 < 0) {
            throw z.d();
        }
        int i9 = this.f497i + this.f495g + i8;
        if (i9 < 0) {
            throw new z("Failed to parse the message.");
        }
        int i10 = this.f498j;
        if (i9 > i10) {
            throw z.e();
        }
        this.f498j = i9;
        P();
        return i10;
    }

    @Override // a2.e
    public final boolean m() {
        return N() != 0;
    }

    @Override // a2.e
    public final g n() throws IOException {
        int iM = M();
        int i8 = this.f493e;
        int i9 = this.f495g;
        int i10 = i8 - i9;
        byte[] bArr = this.d;
        if (iM <= i10 && iM > 0) {
            g gVarH = g.h(i9, iM, bArr);
            this.f495g += iM;
            return gVarH;
        }
        if (iM == 0) {
            return g.f473c;
        }
        if (iM < 0) {
            throw z.d();
        }
        byte[] bArrI = I(iM);
        if (bArrI != null) {
            return g.h(0, bArrI.length, bArrI);
        }
        int i11 = this.f495g;
        int i12 = this.f493e;
        int length = i12 - i11;
        this.f497i += i12;
        this.f495g = 0;
        this.f493e = 0;
        ArrayList arrayListJ = J(iM - length);
        byte[] bArr2 = new byte[iM];
        System.arraycopy(bArr, i11, bArr2, 0, length);
        int size = arrayListJ.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayListJ.get(i13);
            i13++;
            byte[] bArr3 = (byte[]) obj;
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        g gVar = g.f473c;
        return new g(bArr2);
    }

    @Override // a2.e
    public final double p() {
        return Double.longBitsToDouble(L());
    }

    @Override // a2.e
    public final int q() {
        return M();
    }

    @Override // a2.e
    public final int r() {
        return K();
    }

    @Override // a2.e
    public final long s() {
        return L();
    }

    @Override // a2.e
    public final float t() {
        return Float.intBitsToFloat(K());
    }

    @Override // a2.e
    public final int u() {
        return M();
    }

    @Override // a2.e
    public final long v() {
        return N();
    }

    @Override // a2.e
    public final int w() {
        return K();
    }

    @Override // a2.e
    public final long x() {
        return L();
    }

    @Override // a2.e
    public final int y() {
        int iM = M();
        return (-(iM & 1)) ^ (iM >>> 1);
    }

    @Override // a2.e
    public final long z() {
        long jN = N();
        return (-(jN & 1)) ^ (jN >>> 1);
    }
}
