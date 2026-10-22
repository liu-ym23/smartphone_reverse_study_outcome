package com.autonavi.aps.protocol.aps.common.b;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f18492a;

    /* renamed from: b, reason: collision with root package name */
    public int f18493b;

    /* renamed from: d, reason: collision with root package name */
    private int f18495d;

    /* renamed from: e, reason: collision with root package name */
    private int f18496e;

    /* renamed from: f, reason: collision with root package name */
    private int f18497f;

    /* renamed from: g, reason: collision with root package name */
    private int f18498g;

    /* renamed from: h, reason: collision with root package name */
    private int f18499h;

    /* renamed from: i, reason: collision with root package name */
    private int f18500i = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f18494c = 100;

    public a(byte[] bArr, int i10, int i11, boolean z10) {
        this.f18492a = bArr;
        this.f18495d = i11 + i10;
        this.f18497f = i10;
        this.f18498g = i10;
    }

    public static int a(int i10) {
        return i10 & 7;
    }

    public static int e(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static int f(int i10) {
        return i10 >>> 3;
    }

    private void p() {
        int i10 = this.f18495d + this.f18496e;
        this.f18495d = i10;
        int i11 = i10 - this.f18498g;
        int i12 = this.f18500i;
        if (i11 <= i12) {
            this.f18496e = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f18496e = i13;
        this.f18495d = i10 - i13;
    }

    public int b(int i10) throws IOException {
        if (i10 < 0) {
            throw new IOException();
        }
        int iA = i10 + a();
        int i11 = this.f18500i;
        if (iA > i11) {
            throw new IOException();
        }
        this.f18500i = iA;
        p();
        return i11;
    }

    public void c(int i10) {
        this.f18500i = i10;
        p();
    }

    public void d(int i10) {
        if (this.f18499h != i10) {
            throw new RuntimeException("not expected tag");
        }
    }

    public byte[] g() {
        int iC = c();
        if (iC > 0) {
            int i10 = this.f18495d;
            int i11 = this.f18497f;
            if (iC <= i10 - i11) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(this.f18492a, i11, i11 + iC);
                this.f18497f += iC;
                return bArrCopyOfRange;
            }
        }
        return new byte[0];
    }

    public String h() {
        int iC = c();
        if (iC > 0) {
            int i10 = this.f18495d;
            int i11 = this.f18497f;
            if (iC <= i10 - i11) {
                this.f18497f = i11 + iC;
                return new String(this.f18492a, i11, iC, StandardCharsets.UTF_8);
            }
        }
        if (iC == 0) {
            return "";
        }
        if (iC <= 0) {
            throw new RuntimeException("negative size");
        }
        throw new RuntimeException("trunk size");
    }

    public boolean i() {
        return m() != 0;
    }

    public int j() {
        return c();
    }

    public long k() {
        return m();
    }

    public int l() {
        return e(c());
    }

    public long m() {
        long j10;
        long j11;
        long j12;
        int i10 = this.f18497f;
        int i11 = this.f18495d;
        if (i11 != i10) {
            byte[] bArr = this.f18492a;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f18497f = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b10;
                if (i14 < 0) {
                    j10 = i14 ^ (-128);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    if (i16 >= 0) {
                        j10 = i16 ^ 16256;
                        i13 = i15;
                    } else {
                        int i17 = i10 + 4;
                        int i18 = i16 ^ (bArr[i15] << 21);
                        if (i18 < 0) {
                            long j13 = (-2080896) ^ i18;
                            i13 = i17;
                            j10 = j13;
                        } else {
                            long j14 = i18;
                            i13 = i10 + 5;
                            long j15 = j14 ^ (bArr[i17] << 28);
                            if (j15 >= 0) {
                                j12 = 266354560;
                            } else {
                                int i19 = i10 + 6;
                                long j16 = j15 ^ (bArr[i13] << 35);
                                if (j16 < 0) {
                                    j11 = -34093383808L;
                                } else {
                                    i13 = i10 + 7;
                                    j15 = j16 ^ (bArr[i19] << 42);
                                    if (j15 >= 0) {
                                        j12 = 4363953127296L;
                                    } else {
                                        i19 = i10 + 8;
                                        j16 = j15 ^ (bArr[i13] << 49);
                                        if (j16 < 0) {
                                            j11 = -558586000294016L;
                                        } else {
                                            i13 = i10 + 9;
                                            long j17 = (j16 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                            if (j17 < 0) {
                                                int i20 = i10 + 10;
                                                if (bArr[i13] >= 0) {
                                                    i13 = i20;
                                                }
                                            }
                                            j10 = j17;
                                        }
                                    }
                                }
                                j10 = j16 ^ j11;
                                i13 = i19;
                            }
                            j10 = j15 ^ j12;
                        }
                    }
                }
                this.f18497f = i13;
                return j10;
            }
        }
        return d();
    }

    public double n() {
        return Double.longBitsToDouble(m());
    }

    public void o() {
        int iB;
        do {
            iB = b();
            if (iB == 0) {
                return;
            }
        } while (g(iB));
    }

    public static a a(byte[] bArr, int i10, int i11) {
        a aVar = new a(bArr, i10, i11, false);
        try {
            aVar.b(i11);
            return aVar;
        } catch (IOException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public byte e() {
        int i10 = this.f18497f;
        if (i10 == this.f18495d) {
            throw new RuntimeException("length error");
        }
        byte[] bArr = this.f18492a;
        this.f18497f = i10 + 1;
        return bArr[i10];
    }

    public boolean f() {
        return this.f18497f == this.f18495d;
    }

    public int c() {
        int i10;
        int i11 = this.f18497f;
        int i12 = this.f18495d;
        if (i12 != i11) {
            byte[] bArr = this.f18492a;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f18497f = i13;
                return b10;
            }
            if (i12 - i13 >= 9) {
                int i14 = i11 + 2;
                int i15 = (bArr[i13] << 7) ^ b10;
                if (i15 < 0) {
                    i10 = i15 ^ (-128);
                } else {
                    int i16 = i11 + 3;
                    int i17 = (bArr[i14] << 14) ^ i15;
                    if (i17 >= 0) {
                        i10 = i17 ^ 16256;
                    } else {
                        int i18 = i11 + 4;
                        int i19 = i17 ^ (bArr[i16] << 21);
                        if (i19 < 0) {
                            i10 = (-2080896) ^ i19;
                        } else {
                            i16 = i11 + 5;
                            byte b11 = bArr[i18];
                            int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                            if (b11 < 0) {
                                i18 = i11 + 6;
                                if (bArr[i16] < 0) {
                                    i16 = i11 + 7;
                                    if (bArr[i18] < 0) {
                                        i18 = i11 + 8;
                                        if (bArr[i16] < 0) {
                                            i16 = i11 + 9;
                                            if (bArr[i18] < 0) {
                                                int i21 = i11 + 10;
                                                if (bArr[i16] >= 0) {
                                                    i14 = i21;
                                                    i10 = i20;
                                                }
                                            }
                                        }
                                    }
                                }
                                i10 = i20;
                            }
                            i10 = i20;
                        }
                        i14 = i18;
                    }
                    i14 = i16;
                }
                this.f18497f = i14;
                return i10;
            }
        }
        return (int) d();
    }

    public long d() {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            j10 |= (r3 & 127) << i10;
            if ((e() & 128) == 0) {
                return j10;
            }
        }
        throw new RuntimeException("malformed varint");
    }

    public int a() {
        return this.f18497f - this.f18498g;
    }

    public boolean g(int i10) {
        int iA = a(i10);
        int i11 = 0;
        if (iA == 0) {
            if (0 - this.f18497f >= 10) {
                while (i11 < 10) {
                    byte[] bArr = this.f18492a;
                    int i12 = this.f18497f;
                    this.f18497f = i12 + 1;
                    if (bArr[i12] < 0) {
                        i11++;
                    }
                }
                throw new RuntimeException("malformed varint");
            }
            while (i11 < 10) {
                if (e() < 0) {
                    i11++;
                }
            }
            throw new RuntimeException("malformed varint");
            return true;
        }
        if (iA == 1) {
            h(8);
            return true;
        }
        if (iA == 2) {
            h(c());
            return true;
        }
        if (iA == 3) {
            o();
            d((f(i10) << 3) | 4);
            return true;
        }
        if (iA == 4) {
            return false;
        }
        if (iA == 5) {
            h(4);
            return true;
        }
        throw new RuntimeException("invalidWireType");
    }

    public int b() {
        if (f()) {
            this.f18499h = 0;
            return 0;
        }
        int iC = c();
        this.f18499h = iC;
        if (f(iC) != 0) {
            return this.f18499h;
        }
        throw new RuntimeException("zero tag");
    }

    public void h(int i10) {
        this.f18497f += i10;
    }
}
