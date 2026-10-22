package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
public final class i extends androidx.datastore.preferences.protobuf.j {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2215c;

    /* renamed from: d, reason: collision with root package name */
    public int f2216d;

    /* renamed from: e, reason: collision with root package name */
    public int f2217e;

    /* renamed from: f, reason: collision with root package name */
    public int f2218f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2219g;

    /* renamed from: h, reason: collision with root package name */
    public int f2220h;

    /* renamed from: i, reason: collision with root package name */
    public int f2221i = Integer.MAX_VALUE;

    public i(byte[] bArr, int i2, int i10, boolean z4) {
        this.f2215c = bArr;
        this.f2216d = i10 + i2;
        this.f2218f = i2;
        this.f2219g = i2;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String A() throws b0 {
        int I = I();
        if (I > 0) {
            int i2 = this.f2216d;
            int i10 = this.f2218f;
            if (I <= i2 - i10) {
                String str = new String(this.f2215c, i10, I, z.f2296a);
                this.f2218f += I;
                return str;
            }
        }
        if (I == 0) {
            return "";
        }
        if (I < 0) {
            throw b0.e();
        }
        throw b0.g();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final String B() throws b0 {
        int I = I();
        if (I > 0) {
            int i2 = this.f2216d;
            int i10 = this.f2218f;
            if (I <= i2 - i10) {
                String strQ = p1.f2258a.q(this.f2215c, i10, I);
                this.f2218f += I;
                return strQ;
            }
        }
        if (I == 0) {
            return "";
        }
        if (I <= 0) {
            throw b0.e();
        }
        throw b0.g();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int C() throws b0 {
        if (g()) {
            this.f2220h = 0;
            return 0;
        }
        int I = I();
        this.f2220h = I;
        if ((I >>> 3) != 0) {
            return I;
        }
        throw b0.a();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int D() {
        return I();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long E() {
        return J();
    }

    public final int G() throws b0 {
        int i2 = this.f2218f;
        if (this.f2216d - i2 < 4) {
            throw b0.g();
        }
        this.f2218f = i2 + 4;
        byte[] bArr = this.f2215c;
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public final long H() throws b0 {
        int i2 = this.f2218f;
        if (this.f2216d - i2 < 8) {
            throw b0.g();
        }
        this.f2218f = i2 + 8;
        byte[] bArr = this.f2215c;
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48) | ((bArr[i2 + 7] & 255) << 56);
    }

    public final int I() {
        int i2;
        int i10 = this.f2218f;
        int i11 = this.f2216d;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f2215c;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f2218f = i12;
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
                this.f2218f = i13;
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
        int i2 = this.f2218f;
        int i10 = this.f2216d;
        if (i10 != i2) {
            int i11 = i2 + 1;
            byte[] bArr = this.f2215c;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                this.f2218f = i11;
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
                this.f2218f = i12;
                return j2;
            }
        }
        return K();
    }

    public final long K() throws b0 {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i10 = this.f2218f;
            if (i10 == this.f2216d) {
                throw b0.g();
            }
            this.f2218f = i10 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f2215c[i10] & 128) == 0) {
                return j2;
            }
        }
        throw b0.d();
    }

    public final void L() {
        int i2 = this.f2216d + this.f2217e;
        this.f2216d = i2;
        int i10 = i2 - this.f2219g;
        int i11 = this.f2221i;
        if (i10 <= i11) {
            this.f2217e = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f2217e = i12;
        this.f2216d = i2 - i12;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void b(int i2) throws b0 {
        if (this.f2220h != i2) {
            throw new b0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int f() {
        return this.f2218f - this.f2219g;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final boolean g() {
        return this.f2218f == this.f2216d;
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final void j(int i2) {
        this.f2221i = i2;
        L();
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final int l(int i2) {
        if (i2 < 0) {
            throw b0.e();
        }
        int iF = f() + i2;
        if (iF < 0) {
            throw b0.f();
        }
        int i10 = this.f2221i;
        if (iF > i10) {
            throw b0.g();
        }
        this.f2221i = iF;
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
    public final com.google.crypto.tink.shaded.protobuf.g o() throws com.google.crypto.tink.shaded.protobuf.b0 {
        /*
            r4 = this;
            int r0 = r4.I()
            byte[] r1 = r4.f2215c
            if (r0 <= 0) goto L19
            int r2 = r4.f2216d
            int r3 = r4.f2218f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.google.crypto.tink.shaded.protobuf.g r1 = com.google.crypto.tink.shaded.protobuf.h.h(r1, r3, r0)
            int r2 = r4.f2218f
            int r2 = r2 + r0
            r4.f2218f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.crypto.tink.shaded.protobuf.g r4 = com.google.crypto.tink.shaded.protobuf.h.f2209g
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.f2216d
            int r3 = r4.f2218f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f2218f = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r4 = com.google.crypto.tink.shaded.protobuf.z.f2297b
        L35:
            com.google.crypto.tink.shaded.protobuf.g r0 = com.google.crypto.tink.shaded.protobuf.h.f2209g
            com.google.crypto.tink.shaded.protobuf.g r0 = new com.google.crypto.tink.shaded.protobuf.g
            r0.<init>(r4)
            return r0
        L3d:
            com.google.crypto.tink.shaded.protobuf.b0 r4 = com.google.crypto.tink.shaded.protobuf.b0.e()
            throw r4
        L42:
            com.google.crypto.tink.shaded.protobuf.b0 r4 = com.google.crypto.tink.shaded.protobuf.b0.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.i.o():com.google.crypto.tink.shaded.protobuf.g");
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
        return androidx.datastore.preferences.protobuf.j.d(I());
    }

    @Override // androidx.datastore.preferences.protobuf.j
    public final long z() {
        return androidx.datastore.preferences.protobuf.j.e(J());
    }
}
