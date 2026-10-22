package androidx.datastore.preferences.protobuf;

import com.stepos.stepclaw.SecurePrefs;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends a2.e {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f478c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f479e;

    /* renamed from: f, reason: collision with root package name */
    public int f480f;

    /* renamed from: g, reason: collision with root package name */
    public final int f481g;

    /* renamed from: h, reason: collision with root package name */
    public int f482h;

    /* renamed from: i, reason: collision with root package name */
    public int f483i = Integer.MAX_VALUE;

    public h(byte[] bArr, int i8, int i9, boolean z) {
        this.f478c = bArr;
        this.d = i9 + i8;
        this.f480f = i8;
        this.f481g = i8;
    }

    @Override // a2.e
    public final String A() throws z {
        int iJ = J();
        if (iJ > 0) {
            int i8 = this.d;
            int i9 = this.f480f;
            if (iJ <= i8 - i9) {
                String str = new String(this.f478c, i9, iJ, x.f579a);
                this.f480f += iJ;
                return str;
            }
        }
        if (iJ == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (iJ < 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // a2.e
    public final String B() throws z {
        int iJ = J();
        if (iJ > 0) {
            int i8 = this.d;
            int i9 = this.f480f;
            if (iJ <= i8 - i9) {
                String strL = k1.f506a.l(i9, iJ, this.f478c);
                this.f480f += iJ;
                return strL;
            }
        }
        if (iJ == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (iJ <= 0) {
            throw z.d();
        }
        throw z.e();
    }

    @Override // a2.e
    public final int C() throws z {
        if (g()) {
            this.f482h = 0;
            return 0;
        }
        int iJ = J();
        this.f482h = iJ;
        if ((iJ >>> 3) != 0) {
            return iJ;
        }
        throw new z("Protocol message contained an invalid tag (zero).");
    }

    @Override // a2.e
    public final int D() {
        return J();
    }

    @Override // a2.e
    public final long E() {
        return K();
    }

    @Override // a2.e
    public final boolean F(int i8) throws z {
        int i9 = i8 & 7;
        int i10 = 0;
        if (i9 != 0) {
            if (i9 == 1) {
                N(8);
                return true;
            }
            if (i9 == 2) {
                N(J());
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
            N(4);
            return true;
        }
        int i11 = this.d - this.f480f;
        byte[] bArr = this.f478c;
        if (i11 >= 10) {
            while (i10 < 10) {
                int i12 = this.f480f;
                this.f480f = i12 + 1;
                if (bArr[i12] < 0) {
                    i10++;
                }
            }
            throw z.c();
        }
        while (i10 < 10) {
            int i13 = this.f480f;
            if (i13 == this.d) {
                throw z.e();
            }
            this.f480f = i13 + 1;
            if (bArr[i13] < 0) {
                i10++;
            }
        }
        throw z.c();
        return true;
    }

    public final int H() throws z {
        int i8 = this.f480f;
        if (this.d - i8 < 4) {
            throw z.e();
        }
        this.f480f = i8 + 4;
        byte[] bArr = this.f478c;
        return ((bArr[i8 + 3] & 255) << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public final long I() throws z {
        int i8 = this.f480f;
        if (this.d - i8 < 8) {
            throw z.e();
        }
        this.f480f = i8 + 8;
        byte[] bArr = this.f478c;
        return ((bArr[i8 + 1] & 255) << 8) | (bArr[i8] & 255) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24) | ((bArr[i8 + 4] & 255) << 32) | ((bArr[i8 + 5] & 255) << 40) | ((bArr[i8 + 6] & 255) << 48) | ((bArr[i8 + 7] & 255) << 56);
    }

    public final int J() {
        int i8;
        int i9 = this.f480f;
        int i10 = this.d;
        if (i10 != i9) {
            int i11 = i9 + 1;
            byte[] bArr = this.f478c;
            byte b9 = bArr[i9];
            if (b9 >= 0) {
                this.f480f = i11;
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
                this.f480f = i12;
                return i8;
            }
        }
        return (int) L();
    }

    public final long K() {
        long j4;
        long j8;
        long j9;
        long j10;
        int i8 = this.f480f;
        int i9 = this.d;
        if (i9 != i8) {
            int i10 = i8 + 1;
            byte[] bArr = this.f478c;
            byte b9 = bArr[i8];
            if (b9 >= 0) {
                this.f480f = i10;
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
                this.f480f = i11;
                return j4;
            }
        }
        return L();
    }

    public final long L() throws z {
        long j4 = 0;
        for (int i8 = 0; i8 < 64; i8 += 7) {
            int i9 = this.f480f;
            if (i9 == this.d) {
                throw z.e();
            }
            this.f480f = i9 + 1;
            j4 |= (r3 & AbstractJsonLexerKt.TC_INVALID) << i8;
            if ((this.f478c[i9] & 128) == 0) {
                return j4;
            }
        }
        throw z.c();
    }

    public final void M() {
        int i8 = this.d + this.f479e;
        this.d = i8;
        int i9 = i8 - this.f481g;
        int i10 = this.f483i;
        if (i9 <= i10) {
            this.f479e = 0;
            return;
        }
        int i11 = i9 - i10;
        this.f479e = i11;
        this.d = i8 - i11;
    }

    public final void N(int i8) throws z {
        if (i8 >= 0) {
            int i9 = this.d;
            int i10 = this.f480f;
            if (i8 <= i9 - i10) {
                this.f480f = i10 + i8;
                return;
            }
        }
        if (i8 >= 0) {
            throw z.e();
        }
        throw z.d();
    }

    @Override // a2.e
    public final void b(int i8) throws z {
        if (this.f482h != i8) {
            throw new z("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // a2.e
    public final int f() {
        return this.f480f - this.f481g;
    }

    @Override // a2.e
    public final boolean g() {
        return this.f480f == this.d;
    }

    @Override // a2.e
    public final void j(int i8) {
        this.f483i = i8;
        M();
    }

    @Override // a2.e
    public final int l(int i8) throws z {
        if (i8 < 0) {
            throw z.d();
        }
        int iF = f() + i8;
        if (iF < 0) {
            throw new z("Failed to parse the message.");
        }
        int i9 = this.f483i;
        if (iF > i9) {
            throw z.e();
        }
        this.f483i = iF;
        M();
        return i9;
    }

    @Override // a2.e
    public final boolean m() {
        return K() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // a2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.preferences.protobuf.g n() throws androidx.datastore.preferences.protobuf.z {
        /*
            r4 = this;
            int r0 = r4.J()
            byte[] r1 = r4.f478c
            if (r0 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f480f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            androidx.datastore.preferences.protobuf.g r1 = androidx.datastore.preferences.protobuf.g.h(r3, r0, r1)
            int r2 = r4.f480f
            int r2 = r2 + r0
            r4.f480f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            androidx.datastore.preferences.protobuf.g r4 = androidx.datastore.preferences.protobuf.g.f473c
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f480f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f480f = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r4 = androidx.datastore.preferences.protobuf.x.f580b
        L35:
            androidx.datastore.preferences.protobuf.g r0 = androidx.datastore.preferences.protobuf.g.f473c
            androidx.datastore.preferences.protobuf.g r0 = new androidx.datastore.preferences.protobuf.g
            r0.<init>(r4)
            return r0
        L3d:
            androidx.datastore.preferences.protobuf.z r4 = androidx.datastore.preferences.protobuf.z.d()
            throw r4
        L42:
            androidx.datastore.preferences.protobuf.z r4 = androidx.datastore.preferences.protobuf.z.e()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.n():androidx.datastore.preferences.protobuf.g");
    }

    @Override // a2.e
    public final double p() {
        return Double.longBitsToDouble(I());
    }

    @Override // a2.e
    public final int q() {
        return J();
    }

    @Override // a2.e
    public final int r() {
        return H();
    }

    @Override // a2.e
    public final long s() {
        return I();
    }

    @Override // a2.e
    public final float t() {
        return Float.intBitsToFloat(H());
    }

    @Override // a2.e
    public final int u() {
        return J();
    }

    @Override // a2.e
    public final long v() {
        return K();
    }

    @Override // a2.e
    public final int w() {
        return H();
    }

    @Override // a2.e
    public final long x() {
        return I();
    }

    @Override // a2.e
    public final int y() {
        int iJ = J();
        return (-(iJ & 1)) ^ (iJ >>> 1);
    }

    @Override // a2.e
    public final long z() {
        long jK = K();
        return (-(jK & 1)) ^ (jK >>> 1);
    }
}
