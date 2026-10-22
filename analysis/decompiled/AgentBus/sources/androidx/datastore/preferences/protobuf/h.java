package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public final class h extends j {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f861c;

    /* renamed from: d, reason: collision with root package name */
    public int f862d;

    /* renamed from: e, reason: collision with root package name */
    public int f863e;

    /* renamed from: f, reason: collision with root package name */
    public int f864f;

    /* renamed from: g, reason: collision with root package name */
    public final int f865g;

    /* renamed from: h, reason: collision with root package name */
    public int f866h;

    /* renamed from: i, reason: collision with root package name */
    public int f867i = Integer.MAX_VALUE;

    public h(byte[] bArr, int i2, int i10, boolean z4) {
        this.f861c = bArr;
        this.f862d = i10 + i2;
        this.f864f = i2;
        this.f865g = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String A() throws a0 {
        int I = I();
        if (I > 0) {
            int i2 = this.f862d;
            int i10 = this.f864f;
            if (I <= i2 - i10) {
                String str = new String(this.f861c, i10, I, y.f968a);
                this.f864f += I;
                return str;
            }
        }
        if (I == 0) {
            return "";
        }
        if (I < 0) {
            throw a0.d();
        }
        throw a0.e();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String B() throws a0 {
        int I = I();
        if (I > 0) {
            int i2 = this.f862d;
            int i10 = this.f864f;
            if (I <= i2 - i10) {
                String strA = v1.f961a.a(this.f861c, i10, I);
                this.f864f += I;
                return strA;
            }
        }
        if (I == 0) {
            return "";
        }
        if (I <= 0) {
            throw a0.d();
        }
        throw a0.e();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int C() throws a0 {
        if (g()) {
            this.f866h = 0;
            return 0;
        }
        int I = I();
        this.f866h = I;
        if ((I >>> 3) != 0) {
            return I;
        }
        throw new a0("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int D() {
        return I();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long E() {
        return J();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean F(int i2) throws a0 {
        int iC;
        int i10 = i2 & 7;
        int i11 = 0;
        if (i10 == 0) {
            int i12 = this.f862d - this.f864f;
            byte[] bArr = this.f861c;
            if (i12 >= 10) {
                while (i11 < 10) {
                    int i13 = this.f864f;
                    this.f864f = i13 + 1;
                    if (bArr[i13] < 0) {
                        i11++;
                    }
                }
                throw a0.c();
            }
            while (i11 < 10) {
                int i14 = this.f864f;
                if (i14 == this.f862d) {
                    throw a0.e();
                }
                this.f864f = i14 + 1;
                if (bArr[i14] < 0) {
                    i11++;
                }
            }
            throw a0.c();
            return true;
        }
        if (i10 == 1) {
            M(8);
            return true;
        }
        if (i10 == 2) {
            M(I());
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw a0.b();
            }
            M(4);
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

    public final int G() throws a0 {
        int i2 = this.f864f;
        if (this.f862d - i2 < 4) {
            throw a0.e();
        }
        this.f864f = i2 + 4;
        byte[] bArr = this.f861c;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long H() throws a0 {
        int i2 = this.f864f;
        if (this.f862d - i2 < 8) {
            throw a0.e();
        }
        this.f864f = i2 + 8;
        byte[] bArr = this.f861c;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int I() {
        int i2;
        int i10 = this.f864f;
        int i11 = this.f862d;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f861c;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f864f = i12;
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
                this.f864f = i13;
                return i2;
            }
        }
        return (int) K();
    }

    public final long J() {
        long j2;
        long j4;
        long j10;
        long j11;
        int i2 = this.f864f;
        int i10 = this.f862d;
        if (i10 != i2) {
            int i11 = i2 + 1;
            byte[] bArr = this.f861c;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                this.f864f = i11;
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
                this.f864f = i12;
                return j2;
            }
        }
        return K();
    }

    public final long K() throws a0 {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i10 = this.f864f;
            if (i10 == this.f862d) {
                throw a0.e();
            }
            this.f864f = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f861c[i10] & 128) == 0) {
                return j2;
            }
        }
        throw a0.c();
    }

    public final void L() {
        int i2 = this.f862d + this.f863e;
        this.f862d = i2;
        int i10 = i2 - this.f865g;
        int i11 = this.f867i;
        if (i10 <= i11) {
            this.f863e = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f863e = i12;
        this.f862d = i2 - i12;
    }

    public final void M(int i2) throws a0 {
        if (i2 >= 0) {
            int i10 = this.f862d;
            int i11 = this.f864f;
            if (i2 <= i10 - i11) {
                this.f864f = i11 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw a0.e();
        }
        throw a0.d();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void b(int i2) throws a0 {
        if (this.f866h != i2) {
            throw new a0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int f() {
        return this.f864f - this.f865g;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean g() {
        return this.f864f == this.f862d;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void j(int i2) {
        this.f867i = i2;
        L();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int l(int i2) throws a0 {
        if (i2 < 0) {
            throw a0.d();
        }
        int iF = f() + i2;
        if (iF < 0) {
            throw new a0("Failed to parse the message.");
        }
        int i10 = this.f867i;
        if (iF > i10) {
            throw a0.e();
        }
        this.f867i = iF;
        L();
        return i10;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean m() {
        return J() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // androidx.datastore.preferences.protobuf.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.preferences.protobuf.g n() throws androidx.datastore.preferences.protobuf.a0 {
        /*
            r4 = this;
            int r0 = r4.I()
            byte[] r1 = r4.f861c
            if (r0 <= 0) goto L19
            int r2 = r4.f862d
            int r3 = r4.f864f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            androidx.datastore.preferences.protobuf.g r1 = androidx.datastore.preferences.protobuf.g.h(r1, r3, r0)
            int r2 = r4.f864f
            int r2 = r2 + r0
            r4.f864f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            androidx.datastore.preferences.protobuf.g r4 = androidx.datastore.preferences.protobuf.g.f850h
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.f862d
            int r3 = r4.f864f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f864f = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r4 = androidx.datastore.preferences.protobuf.y.f969b
        L35:
            androidx.datastore.preferences.protobuf.g r0 = androidx.datastore.preferences.protobuf.g.f850h
            androidx.datastore.preferences.protobuf.g r0 = new androidx.datastore.preferences.protobuf.g
            r0.<init>(r4)
            return r0
        L3d:
            androidx.datastore.preferences.protobuf.a0 r4 = androidx.datastore.preferences.protobuf.a0.d()
            throw r4
        L42:
            androidx.datastore.preferences.protobuf.a0 r4 = androidx.datastore.preferences.protobuf.a0.e()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.n():androidx.datastore.preferences.protobuf.g");
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final double p() {
        return Double.longBitsToDouble(H());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int q() {
        return I();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int r() {
        return G();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long s() {
        return H();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final float t() {
        return Float.intBitsToFloat(G());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int u() {
        return I();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long v() {
        return J();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int w() {
        return G();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long x() {
        return H();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int y() {
        int I = I();
        return (-(I & 1)) ^ (I >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long z() {
        long J = J();
        return (-(J & 1)) ^ (J >>> 1);
    }
}
