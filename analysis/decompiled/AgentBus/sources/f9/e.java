package f9;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public int f3541c;

    /* renamed from: e, reason: collision with root package name */
    public final InputStream f3543e;

    /* renamed from: f, reason: collision with root package name */
    public int f3544f;

    /* renamed from: i, reason: collision with root package name */
    public int f3547i;

    /* renamed from: h, reason: collision with root package name */
    public int f3546h = Integer.MAX_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3539a = new byte[4096];

    /* renamed from: b, reason: collision with root package name */
    public int f3540b = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f3542d = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f3545g = 0;

    public e(InputStream inputStream) {
        this.f3543e = inputStream;
    }

    public final void a(int i2) throws r {
        if (this.f3544f != i2) {
            throw new r("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int b() {
        int i2 = this.f3546h;
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2 - (this.f3545g + this.f3542d);
    }

    public final void c(int i2) {
        this.f3546h = i2;
        o();
    }

    public final int d(int i2) throws r {
        if (i2 < 0) {
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i10 = this.f3545g + this.f3542d + i2;
        int i11 = this.f3546h;
        if (i10 > i11) {
            throw r.a();
        }
        this.f3546h = i10;
        o();
        return i11;
    }

    public final u e() {
        int iK = k();
        int i2 = this.f3540b;
        int i10 = this.f3542d;
        if (iK > i2 - i10 || iK <= 0) {
            return iK == 0 ? d.f3536f : new u(h(iK));
        }
        byte[] bArr = new byte[iK];
        System.arraycopy(this.f3539a, i10, bArr, 0, iK);
        u uVar = new u(bArr);
        this.f3542d += iK;
        return uVar;
    }

    public final int f() {
        return k();
    }

    public final a g(w wVar, h hVar) throws r {
        int iK = k();
        if (this.f3547i >= 64) {
            throw new r("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iD = d(iK);
        this.f3547i++;
        a aVar = (a) wVar.a(this, hVar);
        a(0);
        this.f3547i--;
        c(iD);
        return aVar;
    }

    public final byte[] h(int i2) throws IOException {
        if (i2 <= 0) {
            if (i2 == 0) {
                return q.f3596a;
            }
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i10 = this.f3545g;
        int i11 = this.f3542d;
        int i12 = i10 + i11 + i2;
        int i13 = this.f3546h;
        if (i12 > i13) {
            r((i13 - i10) - i11);
            throw r.a();
        }
        byte[] bArr = this.f3539a;
        if (i2 < 4096) {
            byte[] bArr2 = new byte[i2];
            int i14 = this.f3540b - i11;
            System.arraycopy(bArr, i11, bArr2, 0, i14);
            this.f3542d = this.f3540b;
            int i15 = i2 - i14;
            if (i15 > 0) {
                p(i15);
            }
            System.arraycopy(bArr, 0, bArr2, i14, i15);
            this.f3542d = i15;
            return bArr2;
        }
        int i16 = this.f3540b;
        this.f3545g = i10 + i16;
        this.f3542d = 0;
        this.f3540b = 0;
        int length = i16 - i11;
        int i17 = i2 - length;
        ArrayList arrayList = new ArrayList();
        while (i17 > 0) {
            int iMin = Math.min(i17, 4096);
            byte[] bArr3 = new byte[iMin];
            int i18 = 0;
            while (i18 < iMin) {
                int i19 = this.f3543e.read(bArr3, i18, iMin - i18);
                if (i19 == -1) {
                    throw r.a();
                }
                this.f3545g += i19;
                i18 += i19;
            }
            i17 -= iMin;
            arrayList.add(bArr3);
        }
        byte[] bArr4 = new byte[i2];
        System.arraycopy(bArr, i11, bArr4, 0, length);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byte[] bArr5 = (byte[]) it.next();
            System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
            length += bArr5.length;
        }
        return bArr4;
    }

    public final int i() throws r {
        int i2 = this.f3542d;
        if (this.f3540b - i2 < 4) {
            p(4);
            i2 = this.f3542d;
        }
        this.f3542d = i2 + 4;
        byte[] bArr = this.f3539a;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long j() throws r {
        int i2 = this.f3542d;
        if (this.f3540b - i2 < 8) {
            p(8);
            i2 = this.f3542d;
        }
        this.f3542d = i2 + 8;
        byte[] bArr = this.f3539a;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int k() {
        int i2;
        int i10 = this.f3542d;
        int i11 = this.f3540b;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f3539a;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f3542d = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b10;
                long j2 = i14;
                if (j2 < 0) {
                    i2 = (int) ((-128) ^ j2);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    long j4 = i16;
                    if (j4 >= 0) {
                        i2 = (int) (16256 ^ j4);
                    } else {
                        int i17 = i10 + 4;
                        long j10 = i16 ^ (bArr[i15] << 21);
                        if (j10 < 0) {
                            i2 = (int) ((-2080896) ^ j10);
                        } else {
                            i15 = i10 + 5;
                            int i18 = (int) ((r1 ^ (r2 << 28)) ^ 266354560);
                            if (bArr[i17] < 0) {
                                i17 = i10 + 6;
                                if (bArr[i15] < 0) {
                                    i15 = i10 + 7;
                                    if (bArr[i17] < 0) {
                                        i17 = i10 + 8;
                                        if (bArr[i15] < 0) {
                                            i15 = i10 + 9;
                                            if (bArr[i17] < 0) {
                                                int i19 = i10 + 10;
                                                if (bArr[i15] >= 0) {
                                                    i13 = i19;
                                                    i2 = i18;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i18;
                            }
                            i2 = i18;
                        }
                        i13 = i17;
                    }
                    i13 = i15;
                }
                this.f3542d = i13;
                return i2;
            }
        }
        return (int) m();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r3[r2] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.e.l():long");
    }

    public final long m() throws r {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            if (this.f3542d == this.f3540b) {
                p(1);
            }
            int i10 = this.f3542d;
            this.f3542d = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f3539a[i10] & 128) == 0) {
                return j2;
            }
        }
        throw new r("CodedInputStream encountered a malformed varint.");
    }

    public final int n() throws r {
        if (this.f3542d == this.f3540b && !s(1)) {
            this.f3544f = 0;
            return 0;
        }
        int iK = k();
        this.f3544f = iK;
        if ((iK >>> 3) != 0) {
            return iK;
        }
        throw new r("Protocol message contained an invalid tag (zero).");
    }

    public final void o() {
        int i2 = this.f3540b + this.f3541c;
        this.f3540b = i2;
        int i10 = this.f3545g + i2;
        int i11 = this.f3546h;
        if (i10 <= i11) {
            this.f3541c = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f3541c = i12;
        this.f3540b = i2 - i12;
    }

    public final void p(int i2) throws r {
        if (!s(i2)) {
            throw r.a();
        }
    }

    public final boolean q(int i2, f fVar) throws IOException {
        int iN;
        int i10 = i2 & 7;
        if (i10 == 0) {
            long jL = l();
            fVar.v(i2);
            fVar.w(jL);
            return true;
        }
        if (i10 == 1) {
            long j2 = j();
            fVar.v(i2);
            fVar.u(j2);
            return true;
        }
        if (i10 == 2) {
            u uVarE = e();
            fVar.v(i2);
            fVar.v(uVarE.size());
            fVar.r(uVarE);
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw new r("Protocol message tag had invalid wire type.");
            }
            int i11 = i();
            fVar.v(i2);
            fVar.t(i11);
            return true;
        }
        fVar.v(i2);
        do {
            iN = n();
            if (iN == 0) {
                break;
            }
        } while (q(iN, fVar));
        int i12 = ((i2 >>> 3) << 3) | 4;
        a(i12);
        fVar.v(i12);
        return true;
    }

    public final void r(int i2) throws r {
        int i10 = this.f3540b;
        int i11 = this.f3542d;
        int i12 = i10 - i11;
        if (i2 <= i12 && i2 >= 0) {
            this.f3542d = i11 + i2;
            return;
        }
        if (i2 < 0) {
            throw new r("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i13 = this.f3545g;
        int i14 = i13 + i11 + i2;
        int i15 = this.f3546h;
        if (i14 > i15) {
            r((i15 - i13) - i11);
            throw r.a();
        }
        this.f3542d = i10;
        p(1);
        while (true) {
            int i16 = i2 - i12;
            int i17 = this.f3540b;
            if (i16 <= i17) {
                this.f3542d = i16;
                return;
            } else {
                i12 += i17;
                this.f3542d = i17;
                p(1);
            }
        }
    }

    public final boolean s(int i2) throws IOException {
        InputStream inputStream;
        int i10 = this.f3542d;
        int i11 = i10 + i2;
        int i12 = this.f3540b;
        if (i11 <= i12) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i2);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f3545g + i10 + i2 <= this.f3546h && (inputStream = this.f3543e) != null) {
            byte[] bArr = this.f3539a;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.f3545g += i10;
                this.f3540b -= i10;
                this.f3542d = 0;
            }
            int i13 = this.f3540b;
            int i14 = inputStream.read(bArr, i13, bArr.length - i13);
            if (i14 == 0 || i14 < -1 || i14 > bArr.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(i14);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (i14 > 0) {
                this.f3540b += i14;
                if ((this.f3545g + i2) - 67108864 > 0) {
                    throw new r("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                o();
                if (this.f3540b >= i2) {
                    return true;
                }
                return s(i2);
            }
        }
        return false;
    }
}
