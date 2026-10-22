package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends i {

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1111c;

    /* renamed from: d, reason: collision with root package name */
    public int f1112d;

    /* renamed from: e, reason: collision with root package name */
    public int f1113e;

    /* renamed from: f, reason: collision with root package name */
    public int f1114f;

    /* renamed from: g, reason: collision with root package name */
    public int f1115g;

    /* renamed from: h, reason: collision with root package name */
    public int f1116h;
    public int i;

    public final long A() throws z {
        int i = this.f1114f;
        if (this.f1112d - i < 8) {
            throw z.e();
        }
        byte[] bArr = this.f1111c;
        this.f1114f = i + 8;
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final int B() {
        int i;
        int i3 = this.f1114f;
        int i10 = this.f1112d;
        if (i10 != i3) {
            byte[] bArr = this.f1111c;
            int i11 = i3 + 1;
            byte b10 = bArr[i3];
            if (b10 >= 0) {
                this.f1114f = i11;
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
                this.f1114f = i12;
                return i;
            }
        }
        return (int) D();
    }

    public final long C() {
        long j10;
        long j11;
        long j12;
        int i = this.f1114f;
        int i3 = this.f1112d;
        if (i3 != i) {
            byte[] bArr = this.f1111c;
            int i10 = i + 1;
            byte b10 = bArr[i];
            if (b10 >= 0) {
                this.f1114f = i10;
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
                this.f1114f = i11;
                return j10;
            }
        }
        return D();
    }

    public final long D() throws z {
        long j10 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i3 = this.f1114f;
            if (i3 == this.f1112d) {
                throw z.e();
            }
            byte[] bArr = this.f1111c;
            this.f1114f = i3 + 1;
            j10 |= (r3 & 127) << i;
            if ((bArr[i3] & 128) == 0) {
                return j10;
            }
        }
        throw z.c();
    }

    public final void E() {
        int i = this.f1112d + this.f1113e;
        this.f1112d = i;
        int i3 = i - this.f1115g;
        int i10 = this.i;
        if (i3 <= i10) {
            this.f1113e = 0;
            return;
        }
        int i11 = i3 - i10;
        this.f1113e = i11;
        this.f1112d = i - i11;
    }

    public final void F(int i) throws z {
        if (i >= 0) {
            int i3 = this.f1112d;
            int i10 = this.f1114f;
            if (i <= i3 - i10) {
                this.f1114f = i10 + i;
                return;
            }
        }
        if (i >= 0) {
            throw z.e();
        }
        throw z.d();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final void a(int i) throws z {
        if (this.f1116h != i) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int b() {
        return this.f1114f - this.f1115g;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean c() {
        return this.f1114f == this.f1112d;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final void d(int i) {
        this.i = i;
        E();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int e(int i) {
        if (i < 0) {
            throw z.d();
        }
        int iB = b() + i;
        if (iB < 0) {
            throw new z("Failed to parse the message.");
        }
        int i3 = this.i;
        if (iB > i3) {
            throw z.e();
        }
        this.i = iB;
        E();
        return i3;
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean f() {
        return C() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // androidx.datastore.preferences.protobuf.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.preferences.protobuf.f g() throws androidx.datastore.preferences.protobuf.z {
        /*
            r4 = this;
            byte[] r0 = r4.f1111c
            int r1 = r4.B()
            if (r1 <= 0) goto L19
            int r2 = r4.f1112d
            int r3 = r4.f1114f
            int r2 = r2 - r3
            if (r1 > r2) goto L19
            androidx.datastore.preferences.protobuf.f r0 = androidx.datastore.preferences.protobuf.f.c(r3, r1, r0)
            int r2 = r4.f1114f
            int r2 = r2 + r1
            r4.f1114f = r2
            return r0
        L19:
            if (r1 != 0) goto L1e
            androidx.datastore.preferences.protobuf.f r4 = androidx.datastore.preferences.protobuf.f.f1105g
            return r4
        L1e:
            if (r1 <= 0) goto L2f
            int r2 = r4.f1112d
            int r3 = r4.f1114f
            int r2 = r2 - r3
            if (r1 > r2) goto L2f
            int r1 = r1 + r3
            r4.f1114f = r1
            byte[] r4 = java.util.Arrays.copyOfRange(r0, r3, r1)
            goto L35
        L2f:
            if (r1 > 0) goto L42
            if (r1 != 0) goto L3d
            byte[] r4 = androidx.datastore.preferences.protobuf.x.f1219b
        L35:
            androidx.datastore.preferences.protobuf.f r0 = androidx.datastore.preferences.protobuf.f.f1105g
            androidx.datastore.preferences.protobuf.f r0 = new androidx.datastore.preferences.protobuf.f
            r0.<init>(r4)
            return r0
        L3d:
            androidx.datastore.preferences.protobuf.z r4 = androidx.datastore.preferences.protobuf.z.d()
            throw r4
        L42:
            androidx.datastore.preferences.protobuf.z r4 = androidx.datastore.preferences.protobuf.z.e()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.g.g():androidx.datastore.preferences.protobuf.f");
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final double h() {
        return Double.longBitsToDouble(A());
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int i() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int j() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long k() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final float l() {
        return Float.intBitsToFloat(z());
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int m() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long n() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int o() {
        return z();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long p() {
        return A();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int q() {
        int iB = B();
        return (-(iB & 1)) ^ (iB >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long r() {
        long jC = C();
        return (-(jC & 1)) ^ (jC >>> 1);
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final String s() throws z {
        int iB = B();
        if (iB > 0) {
            int i = this.f1112d;
            int i3 = this.f1114f;
            if (iB <= i - i3) {
                String str = new String(this.f1111c, i3, iB, x.f1218a);
                this.f1114f += iB;
                return str;
            }
        }
        if (iB == 0) {
            return "";
        }
        if (iB < 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final String t() throws z {
        int iB = B();
        if (iB > 0) {
            int i = this.f1112d;
            int i3 = this.f1114f;
            if (iB <= i - i3) {
                String strO = m1.f1157a.o(this.f1111c, i3, iB);
                this.f1114f += iB;
                return strO;
            }
        }
        if (iB == 0) {
            return "";
        }
        if (iB <= 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int u() throws z {
        if (c()) {
            this.f1116h = 0;
            return 0;
        }
        int iB = B();
        this.f1116h = iB;
        if ((iB >>> 3) != 0) {
            return iB;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final int v() {
        return B();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final long w() {
        return C();
    }

    @Override // androidx.datastore.preferences.protobuf.i
    public final boolean x(int i) throws z {
        byte[] bArr = this.f1111c;
        int i3 = i & 7;
        int i10 = 0;
        if (i3 != 0) {
            if (i3 == 1) {
                F(8);
                return true;
            }
            if (i3 == 2) {
                F(B());
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
            F(4);
            return true;
        }
        if (this.f1112d - this.f1114f >= 10) {
            while (i10 < 10) {
                int i11 = this.f1114f;
                this.f1114f = i11 + 1;
                if (bArr[i11] < 0) {
                    i10++;
                }
            }
            throw z.c();
        }
        while (i10 < 10) {
            int i12 = this.f1114f;
            if (i12 == this.f1112d) {
                throw z.e();
            }
            this.f1114f = i12 + 1;
            if (bArr[i12] < 0) {
                i10++;
            }
        }
        throw z.c();
        return true;
    }

    public final int z() throws z {
        int i = this.f1114f;
        if (this.f1112d - i < 4) {
            throw z.e();
        }
        byte[] bArr = this.f1111c;
        this.f1114f = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }
}
