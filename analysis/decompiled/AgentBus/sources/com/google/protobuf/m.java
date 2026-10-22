package com.google.protobuf;

/* loaded from: classes.dex */
public final class m extends o {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2433c;

    /* renamed from: d, reason: collision with root package name */
    public int f2434d;

    /* renamed from: e, reason: collision with root package name */
    public int f2435e;

    /* renamed from: f, reason: collision with root package name */
    public int f2436f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2437g;

    /* renamed from: h, reason: collision with root package name */
    public int f2438h;

    /* renamed from: i, reason: collision with root package name */
    public int f2439i = Integer.MAX_VALUE;

    public m(byte[] bArr, int i2, int i10, boolean z4) {
        this.f2433c = bArr;
        this.f2434d = i10 + i2;
        this.f2436f = i2;
        this.f2437g = i2;
    }

    @Override // com.google.protobuf.o
    public final boolean A(int i2) throws r2 {
        int i10 = i2 & 7;
        int i11 = 0;
        if (i10 != 0) {
            if (i10 == 1) {
                I(8);
                return true;
            }
            if (i10 == 2) {
                I(E());
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
            I(4);
            return true;
        }
        int i12 = this.f2434d - this.f2436f;
        byte[] bArr = this.f2433c;
        if (i12 >= 10) {
            while (i11 < 10) {
                int i13 = this.f2436f;
                this.f2436f = i13 + 1;
                if (bArr[i13] < 0) {
                    i11++;
                }
            }
            throw r2.d();
        }
        while (i11 < 10) {
            int i14 = this.f2436f;
            if (i14 == this.f2434d) {
                throw r2.g();
            }
            this.f2436f = i14 + 1;
            if (bArr[i14] < 0) {
                i11++;
            }
        }
        throw r2.d();
        return true;
    }

    public final int C() throws r2 {
        int i2 = this.f2436f;
        if (this.f2434d - i2 < 4) {
            throw r2.g();
        }
        this.f2436f = i2 + 4;
        byte[] bArr = this.f2433c;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long D() throws r2 {
        int i2 = this.f2436f;
        if (this.f2434d - i2 < 8) {
            throw r2.g();
        }
        this.f2436f = i2 + 8;
        byte[] bArr = this.f2433c;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int E() {
        int i2;
        int i10 = this.f2436f;
        int i11 = this.f2434d;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f2433c;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f2436f = i12;
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
                this.f2436f = i13;
                return i2;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j2;
        long j4;
        long j10;
        long j11;
        int i2 = this.f2436f;
        int i10 = this.f2434d;
        if (i10 != i2) {
            int i11 = i2 + 1;
            byte[] bArr = this.f2433c;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                this.f2436f = i11;
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
                this.f2436f = i12;
                return j2;
            }
        }
        return G();
    }

    public final long G() throws r2 {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i10 = this.f2436f;
            if (i10 == this.f2434d) {
                throw r2.g();
            }
            this.f2436f = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f2433c[i10] & 128) == 0) {
                return j2;
            }
        }
        throw r2.d();
    }

    public final void H() {
        int i2 = this.f2434d + this.f2435e;
        this.f2434d = i2;
        int i10 = i2 - this.f2437g;
        int i11 = this.f2439i;
        if (i10 <= i11) {
            this.f2435e = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f2435e = i12;
        this.f2434d = i2 - i12;
    }

    public final void I(int i2) throws r2 {
        if (i2 >= 0) {
            int i10 = this.f2434d;
            int i11 = this.f2436f;
            if (i2 <= i10 - i11) {
                this.f2436f = i11 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw r2.g();
        }
        throw r2.e();
    }

    @Override // com.google.protobuf.o
    public final void a(int i2) throws r2 {
        if (this.f2438h != i2) {
            throw new r2("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.protobuf.o
    public final int d() {
        return this.f2436f - this.f2437g;
    }

    @Override // com.google.protobuf.o
    public final boolean e() {
        return this.f2436f == this.f2434d;
    }

    @Override // com.google.protobuf.o
    public final void g(int i2) {
        this.f2439i = i2;
        H();
    }

    @Override // com.google.protobuf.o
    public final int h(int i2) throws r2 {
        if (i2 < 0) {
            throw r2.e();
        }
        int iD = d() + i2;
        if (iD < 0) {
            throw r2.f();
        }
        int i10 = this.f2439i;
        if (iD > i10) {
            throw r2.g();
        }
        this.f2439i = iD;
        H();
        return i10;
    }

    @Override // com.google.protobuf.o
    public final boolean i() {
        return F() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // com.google.protobuf.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.protobuf.k j() throws com.google.protobuf.r2 {
        /*
            r4 = this;
            int r0 = r4.E()
            byte[] r1 = r4.f2433c
            if (r0 <= 0) goto L19
            int r2 = r4.f2434d
            int r3 = r4.f2436f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.google.protobuf.k r1 = com.google.protobuf.l.h(r1, r3, r0)
            int r2 = r4.f2436f
            int r2 = r2 + r0
            r4.f2436f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.protobuf.k r4 = com.google.protobuf.l.f2424g
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.f2434d
            int r3 = r4.f2436f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f2436f = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r4 = com.google.protobuf.p2.f2496b
        L35:
            com.google.protobuf.k r0 = com.google.protobuf.l.f2424g
            com.google.protobuf.k r0 = new com.google.protobuf.k
            r0.<init>(r4)
            return r0
        L3d:
            com.google.protobuf.r2 r4 = com.google.protobuf.r2.e()
            throw r4
        L42:
            com.google.protobuf.r2 r4 = com.google.protobuf.r2.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.m.j():com.google.protobuf.k");
    }

    @Override // com.google.protobuf.o
    public final double k() {
        return Double.longBitsToDouble(D());
    }

    @Override // com.google.protobuf.o
    public final int l() {
        return E();
    }

    @Override // com.google.protobuf.o
    public final int m() {
        return C();
    }

    @Override // com.google.protobuf.o
    public final long n() {
        return D();
    }

    @Override // com.google.protobuf.o
    public final float o() {
        return Float.intBitsToFloat(C());
    }

    @Override // com.google.protobuf.o
    public final int p() {
        return E();
    }

    @Override // com.google.protobuf.o
    public final long q() {
        return F();
    }

    @Override // com.google.protobuf.o
    public final int r() {
        return C();
    }

    @Override // com.google.protobuf.o
    public final long s() {
        return D();
    }

    @Override // com.google.protobuf.o
    public final int t() {
        return o.b(E());
    }

    @Override // com.google.protobuf.o
    public final long u() {
        return o.c(F());
    }

    @Override // com.google.protobuf.o
    public final String v() throws r2 {
        int iE = E();
        if (iE > 0) {
            int i2 = this.f2434d;
            int i10 = this.f2436f;
            if (iE <= i2 - i10) {
                String str = new String(this.f2433c, i10, iE, p2.f2495a);
                this.f2436f += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw r2.e();
        }
        throw r2.g();
    }

    @Override // com.google.protobuf.o
    public final String w() throws r2 {
        int iE = E();
        if (iE > 0) {
            int i2 = this.f2434d;
            int i10 = this.f2436f;
            if (iE <= i2 - i10) {
                String strQ = l4.f2432a.q(this.f2433c, i10, iE);
                this.f2436f += iE;
                return strQ;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE <= 0) {
            throw r2.e();
        }
        throw r2.g();
    }

    @Override // com.google.protobuf.o
    public final int x() throws r2 {
        if (e()) {
            this.f2438h = 0;
            return 0;
        }
        int iE = E();
        this.f2438h = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw r2.a();
    }

    @Override // com.google.protobuf.o
    public final int y() {
        return E();
    }

    @Override // com.google.protobuf.o
    public final long z() {
        return F();
    }
}
