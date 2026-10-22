package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;

/* renamed from: com.google.protobuf.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0968n extends AbstractC0972o {
    public final ByteBuffer c;
    public final long d;
    public long e;
    public long f;
    public final long g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f2931j = Integer.MAX_VALUE;

    public C0968n(ByteBuffer byteBuffer, boolean z10) {
        this.c = byteBuffer;
        long j5 = W2.c.j(byteBuffer, W2.g);
        this.d = j5;
        this.e = byteBuffer.limit() + j5;
        long jPosition = j5 + byteBuffer.position();
        this.f = jPosition;
        this.g = jPosition;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long A() {
        return AbstractC0972o.d(J());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final String B() throws InvalidProtocolBufferException {
        int iW = w();
        if (iW > 0) {
            long j5 = this.e;
            long j6 = this.f;
            if (iW <= ((int) (j5 - j6))) {
                byte[] bArr = new byte[iW];
                long j10 = iW;
                W2.c.c(j6, bArr, j10);
                String str = new String(bArr, AbstractC0989s1.f2940a);
                this.f += j10;
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
            long j5 = this.e;
            long j6 = this.f;
            if (iW <= ((int) (j5 - j6))) {
                int i = (int) (j6 - this.d);
                AbstractC1002v2 abstractC1002v2 = Y2.f2904a;
                abstractC1002v2.getClass();
                ByteBuffer byteBuffer = this.c;
                String strM = byteBuffer.hasArray() ? abstractC1002v2.m(byteBuffer.array(), byteBuffer.arrayOffset() + i, iW) : byteBuffer.isDirect() ? abstractC1002v2.o(byteBuffer, i, iW) : AbstractC1002v2.n(byteBuffer, i, iW);
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
            this.i = 0;
            return 0;
        }
        int iW = w();
        this.i = iW;
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
            if (((int) (this.e - this.f)) >= 10) {
                while (i10 < 10) {
                    long j5 = this.f;
                    this.f = j5 + 1;
                    if (W2.c.e(j5) < 0) {
                        i10++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i10 < 10) {
                long j6 = this.f;
                if (j6 == this.e) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f = j6 + 1;
                if (W2.c.e(j6) < 0) {
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
        long j5 = this.f;
        if (this.e - j5 < 4) {
            throw InvalidProtocolBufferException.g();
        }
        this.f = 4 + j5;
        V2 v22 = W2.c;
        return ((v22.e(j5 + 3) & 255) << 24) | (v22.e(j5) & 255) | ((v22.e(1 + j5) & 255) << 8) | ((v22.e(2 + j5) & 255) << 16);
    }

    public final long I() throws InvalidProtocolBufferException {
        long j5 = this.f;
        if (this.e - j5 < 8) {
            throw InvalidProtocolBufferException.g();
        }
        this.f = 8 + j5;
        V2 v22 = W2.c;
        return ((v22.e(j5 + 7) & 255) << 56) | (v22.e(j5) & 255) | ((v22.e(1 + j5) & 255) << 8) | ((v22.e(2 + j5) & 255) << 16) | ((v22.e(3 + j5) & 255) << 24) | ((v22.e(4 + j5) & 255) << 32) | ((v22.e(5 + j5) & 255) << 40) | ((v22.e(6 + j5) & 255) << 48);
    }

    public final long J() {
        long j5;
        long j6;
        long j10;
        int i;
        long j11 = this.f;
        if (this.e != j11) {
            long j12 = 1 + j11;
            V2 v22 = W2.c;
            byte bE = v22.e(j11);
            if (bE >= 0) {
                this.f = j12;
                return bE;
            }
            if (this.e - j12 >= 9) {
                long j13 = 2 + j11;
                int iE = (v22.e(j12) << 7) ^ bE;
                if (iE >= 0) {
                    long j14 = 3 + j11;
                    int iE2 = iE ^ (v22.e(j13) << 14);
                    if (iE2 >= 0) {
                        j5 = iE2 ^ 16256;
                    } else {
                        j13 = j11 + 4;
                        int iE3 = iE2 ^ (v22.e(j14) << 21);
                        if (iE3 < 0) {
                            i = (-2080896) ^ iE3;
                        } else {
                            j14 = 5 + j11;
                            long jE = iE3 ^ (v22.e(j13) << 28);
                            if (jE < 0) {
                                long j15 = 6 + j11;
                                long jE2 = jE ^ (v22.e(j14) << 35);
                                if (jE2 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    j14 = 7 + j11;
                                    jE = jE2 ^ (v22.e(j15) << 42);
                                    if (jE >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        j15 = 8 + j11;
                                        jE2 = jE ^ (v22.e(j14) << 49);
                                        if (jE2 >= 0) {
                                            long j16 = j11 + 9;
                                            long jE3 = (jE2 ^ (v22.e(j15) << 56)) ^ 71499008037633920L;
                                            if (jE3 < 0) {
                                                long j17 = j11 + 10;
                                                if (v22.e(j16) >= 0) {
                                                    j13 = j17;
                                                    j5 = jE3;
                                                }
                                            } else {
                                                j5 = jE3;
                                                j13 = j16;
                                            }
                                            this.f = j13;
                                            return j5;
                                        }
                                        j6 = -558586000294016L;
                                    }
                                }
                                j5 = j6 ^ jE2;
                                j13 = j15;
                                this.f = j13;
                                return j5;
                            }
                            j10 = 266354560;
                            j5 = j10 ^ jE;
                        }
                    }
                    j13 = j14;
                    this.f = j13;
                    return j5;
                }
                i = iE ^ (-128);
                j5 = i;
                this.f = j13;
                return j5;
            }
        }
        return K();
    }

    public final long K() throws InvalidProtocolBufferException {
        long j5 = 0;
        for (int i = 0; i < 64; i += 7) {
            long j6 = this.f;
            if (j6 == this.e) {
                throw InvalidProtocolBufferException.g();
            }
            this.f = 1 + j6;
            j5 |= (r3 & 127) << i;
            if ((W2.c.e(j6) & 128) == 0) {
                return j5;
            }
        }
        throw InvalidProtocolBufferException.d();
    }

    public final void L() {
        long j5 = this.e + this.h;
        this.e = j5;
        int i = (int) (j5 - this.g);
        int i6 = this.f2931j;
        if (i <= i6) {
            this.h = 0;
            return;
        }
        int i10 = i - i6;
        this.h = i10;
        this.e = j5 - i10;
    }

    public final void M(int i) throws InvalidProtocolBufferException {
        if (i >= 0) {
            long j5 = this.e;
            long j6 = this.f;
            if (i <= ((int) (j5 - j6))) {
                this.f = j6 + i;
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
        if (this.i != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int e() {
        int i = this.f2931j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - f();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int f() {
        return (int) (this.f - this.g);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean g() {
        return this.f == this.e;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void i(int i) {
        this.f2931j = i;
        L();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int j(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        int iF = f() + i;
        int i6 = this.f2931j;
        if (iF > i6) {
            throw InvalidProtocolBufferException.g();
        }
        this.f2931j = iF;
        L();
        return i6;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean k() {
        return J() != 0;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final ByteString l() throws InvalidProtocolBufferException {
        int iW = w();
        if (iW > 0) {
            long j5 = this.e;
            long j6 = this.f;
            if (iW <= ((int) (j5 - j6))) {
                byte[] bArr = new byte[iW];
                long j10 = iW;
                W2.c.c(j6, bArr, j10);
                this.f += j10;
                ByteString byteString = ByteString.b;
                return new ByteString.LiteralByteString(bArr);
            }
        }
        if (iW == 0) {
            return ByteString.b;
        }
        if (iW < 0) {
            throw InvalidProtocolBufferException.e();
        }
        throw InvalidProtocolBufferException.g();
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        if (r4.e(r8) < 0) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[PHI: r6
      0x0099: PHI (r6v7 long) = (r6v6 long), (r6v8 long), (r6v10 long) binds: [B:25:0x006d, B:29:0x0080, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.protobuf.AbstractC0972o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int w() {
        /*
            r12 = this;
            long r0 = r12.f
            long r2 = r12.e
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L93
        La:
            r2 = 1
            long r2 = r2 + r0
            com.google.protobuf.V2 r4 = com.google.protobuf.W2.c
            byte r5 = r4.e(r0)
            if (r5 < 0) goto L18
            r12.f = r2
            return r5
        L18:
            long r6 = r12.e
            long r6 = r6 - r2
            r8 = 9
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L23
            goto L93
        L23:
            r6 = 2
            long r6 = r6 + r0
            byte r2 = r4.e(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r5
            if (r2 >= 0) goto L33
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto La0
        L33:
            r10 = 3
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r3 = r3 << 14
            r2 = r2 ^ r3
            if (r2 < 0) goto L43
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L41:
            r6 = r10
            goto La0
        L43:
            r5 = 4
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L55
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto La0
        L55:
            r10 = 5
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            int r5 = r3 << 28
            r2 = r2 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r5
            if (r3 >= 0) goto L9e
            r5 = 6
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            r10 = 7
            long r10 = r10 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9e
            r5 = 8
            long r6 = r0 + r5
            byte r3 = r4.e(r10)
            if (r3 >= 0) goto L99
            long r8 = r8 + r0
            byte r3 = r4.e(r6)
            if (r3 >= 0) goto L9b
            r5 = 10
            long r6 = r0 + r5
            byte r0 = r4.e(r8)
            if (r0 >= 0) goto L99
        L93:
            long r0 = r12.K()
            int r12 = (int) r0
            return r12
        L99:
            r0 = r2
            goto La0
        L9b:
            r0 = r2
            r6 = r8
            goto La0
        L9e:
            r0 = r2
            goto L41
        La0:
            r12.f = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0968n.w():int");
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
