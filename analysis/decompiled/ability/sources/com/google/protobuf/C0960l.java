package com.google.protobuf;

/* renamed from: com.google.protobuf.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0960l extends AbstractC0972o {
    public final byte[] c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public int i = Integer.MAX_VALUE;

    public C0960l(byte[] bArr, int i, int i6, boolean z10) {
        this.c = bArr;
        this.d = i6 + i;
        this.f = i;
        this.g = i;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long A() {
        return AbstractC0972o.d(J());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final String B() throws InvalidProtocolBufferException {
        int iW = w();
        if (iW > 0) {
            int i = this.d;
            int i6 = this.f;
            if (iW <= i - i6) {
                String str = new String(this.c, i6, iW, AbstractC0989s1.f2940a);
                this.f += iW;
                return str;
            }
        }
        if (iW == 0) {
            return "";
        }
        if (iW < 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.g();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final String C() throws InvalidProtocolBufferException {
        int iW = w();
        if (iW > 0) {
            int i = this.d;
            int i6 = this.f;
            if (iW <= i - i6) {
                String strM = Y2.f2904a.m(this.c, i6, iW);
                this.f += iW;
                return strM;
            }
        }
        if (iW == 0) {
            return "";
        }
        if (iW <= 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.g();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int D() throws InvalidProtocolBufferException {
        if (g()) {
            this.h = 0;
            return 0;
        }
        int iW = w();
        this.h = iW;
        if ((iW >>> 3) != 0) {
            return iW;
        }
        throw InvalidProtocolBufferException.a();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int E() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long F() {
        return J();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean G(int i) throws InvalidProtocolBufferException {
        int iD;
        int i6 = i & 7;
        int i10 = 0;
        if (i6 == 0) {
            int i11 = this.d - this.f;
            byte[] bArr = this.c;
            if (i11 >= 10) {
                while (i10 < 10) {
                    int i12 = this.f;
                    this.f = i12 + 1;
                    if (bArr[i12] < 0) {
                        i10++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i10 < 10) {
                int i13 = this.f;
                if (i13 == this.d) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f = i13 + 1;
                if (bArr[i13] < 0) {
                    i10++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
        if (i6 == 1) {
            M(8);
            return true;
        }
        if (i6 == 2) {
            M(w());
            return true;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                return false;
            }
            if (i6 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            M(4);
            return true;
        }
        do {
            iD = D();
            if (iD == 0) {
                break;
            }
        } while (G(iD));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int H() throws InvalidProtocolBufferException {
        int i = this.f;
        if (this.d - i < 4) {
            throw InvalidProtocolBufferException.g();
        }
        this.f = i + 4;
        byte[] bArr = this.c;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long I() throws InvalidProtocolBufferException {
        int i = this.f;
        if (this.d - i < 8) {
            throw InvalidProtocolBufferException.g();
        }
        this.f = i + 8;
        byte[] bArr = this.c;
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public final long J() {
        long j5;
        long j6;
        long j10;
        long j11;
        int i = this.f;
        int i6 = this.d;
        if (i6 != i) {
            int i10 = i + 1;
            byte[] bArr = this.c;
            byte b = bArr[i];
            if (b >= 0) {
                this.f = i10;
                return b;
            }
            if (i6 - i10 >= 9) {
                int i11 = i + 2;
                int i12 = (bArr[i10] << 7) ^ b;
                if (i12 < 0) {
                    j5 = i12 ^ (-128);
                } else {
                    int i13 = i + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        j5 = i14 ^ 16256;
                        i11 = i13;
                    } else {
                        int i15 = i + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            j11 = (-2080896) ^ i16;
                        } else {
                            long j12 = i16;
                            i11 = i + 5;
                            long j13 = j12 ^ (bArr[i15] << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i15 = i + 6;
                                long j14 = j13 ^ (bArr[i11] << 35);
                                if (j14 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i11 = i + 7;
                                    j13 = j14 ^ (bArr[i15] << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i15 = i + 8;
                                        j14 = j13 ^ (bArr[i11] << 49);
                                        if (j14 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i11 = i + 9;
                                            long j15 = (j14 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i17 = i + 10;
                                                if (bArr[i11] >= 0) {
                                                    i11 = i17;
                                                }
                                            }
                                            j5 = j15;
                                        }
                                    }
                                }
                                j11 = j6 ^ j14;
                            }
                            j5 = j10 ^ j13;
                        }
                        i11 = i15;
                        j5 = j11;
                    }
                }
                this.f = i11;
                return j5;
            }
        }
        return K();
    }

    public final long K() throws InvalidProtocolBufferException {
        long j5 = 0;
        for (int i = 0; i < 64; i += 7) {
            int i6 = this.f;
            if (i6 == this.d) {
                throw InvalidProtocolBufferException.g();
            }
            this.f = i6 + 1;
            j5 |= (r3 & 127) << i;
            if ((this.c[i6] & 128) == 0) {
                return j5;
            }
        }
        throw InvalidProtocolBufferException.d();
    }

    public final void L() {
        int i = this.d + this.e;
        this.d = i;
        int i6 = i - this.g;
        int i10 = this.i;
        if (i6 <= i10) {
            this.e = 0;
            return;
        }
        int i11 = i6 - i10;
        this.e = i11;
        this.d = i - i11;
    }

    public final void M(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            int i6 = this.d;
            int i10 = this.f;
            if (i <= i6 - i10) {
                this.f = i10 + i;
                return;
            }
        }
        if (i >= 0) {
            throw InvalidProtocolBufferException.g();
        }
        throw InvalidProtocolBufferException.e();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.h != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int e() {
        int i = this.i;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - f();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int f() {
        return this.f - this.g;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean g() {
        return this.f == this.d;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void i(int i) {
        this.i = i;
        L();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int j(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        int iF = f() + i;
        if (iF < 0) {
            throw InvalidProtocolBufferException.f();
        }
        int i6 = this.i;
        if (iF > i6) {
            throw InvalidProtocolBufferException.g();
        }
        this.i = iF;
        L();
        return i6;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean k() {
        return J() != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    @Override // com.google.protobuf.AbstractC0972o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.protobuf.ByteString l() throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            r4 = this;
            int r0 = r4.w()
            byte[] r1 = r4.c
            if (r0 <= 0) goto L19
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L19
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.e(r1, r3, r0)
            int r2 = r4.f
            int r2 = r2 + r0
            r4.f = r2
            return r1
        L19:
            if (r0 != 0) goto L1e
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.b
            return r4
        L1e:
            if (r0 <= 0) goto L2f
            int r2 = r4.d
            int r3 = r4.f
            int r2 = r2 - r3
            if (r0 > r2) goto L2f
            int r0 = r0 + r3
            r4.f = r0
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
            goto L35
        L2f:
            if (r0 > 0) goto L42
            if (r0 != 0) goto L3d
            byte[] r4 = com.google.protobuf.AbstractC0989s1.c
        L35:
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.b
            com.google.protobuf.ByteString$LiteralByteString r0 = new com.google.protobuf.ByteString$LiteralByteString
            r0.<init>(r4)
            return r0
        L3d:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.e()
            throw r4
        L42:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0960l.l():com.google.protobuf.ByteString");
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final double m() {
        return Double.longBitsToDouble(I());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int n() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int o() {
        return H();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long p() {
        return I();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final float q() {
        return Float.intBitsToFloat(H());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void r(int i, W1 w12, R0 r02) throws InvalidProtocolBufferException {
        b();
        this.f2933a++;
        w12.mergeFrom(this, r02);
        a((i << 3) | 4);
        this.f2933a--;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int s() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long t() {
        return J();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final X1 u(InterfaceC0955j2 interfaceC0955j2, R0 r02) throws InvalidProtocolBufferException {
        int iW = w();
        b();
        int iJ = j(iW);
        this.f2933a++;
        X1 x12 = (X1) interfaceC0955j2.a(this, r02);
        a(0);
        this.f2933a--;
        if (e() != 0) {
            throw InvalidProtocolBufferException.g();
        }
        i(iJ);
        return x12;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void v(W1 w12, R0 r02) throws InvalidProtocolBufferException {
        int iW = w();
        b();
        int iJ = j(iW);
        this.f2933a++;
        w12.mergeFrom(this, r02);
        a(0);
        this.f2933a--;
        if (e() != 0) {
            throw InvalidProtocolBufferException.g();
        }
        i(iJ);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int w() {
        int i;
        int i6 = this.f;
        int i10 = this.d;
        if (i10 != i6) {
            int i11 = i6 + 1;
            byte[] bArr = this.c;
            byte b = bArr[i6];
            if (b >= 0) {
                this.f = i11;
                return b;
            }
            if (i10 - i11 >= 9) {
                int i12 = i6 + 2;
                int i13 = (bArr[i11] << 7) ^ b;
                if (i13 < 0) {
                    i = i13 ^ (-128);
                } else {
                    int i14 = i6 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        i = i15 ^ 16256;
                    } else {
                        int i16 = i6 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            i = (-2080896) ^ i17;
                        } else {
                            i14 = i6 + 5;
                            byte b5 = bArr[i16];
                            int i18 = (i17 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i16 = i6 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i6 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i6 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i6 + 9;
                                            if (bArr[i16] < 0) {
                                                int i19 = i6 + 10;
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
                this.f = i12;
                return i;
            }
        }
        return (int) K();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int x() {
        return H();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long y() {
        return I();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int z() {
        return AbstractC0972o.c(w());
    }
}
