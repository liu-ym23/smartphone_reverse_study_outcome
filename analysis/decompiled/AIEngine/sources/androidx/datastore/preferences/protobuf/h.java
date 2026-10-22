package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public int f1823a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1824b = 100;

    /* renamed from: c, reason: collision with root package name */
    public final int f1825c = Integer.MAX_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public i f1826d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends h {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f1827e;

        /* renamed from: f, reason: collision with root package name */
        public int f1828f;

        /* renamed from: g, reason: collision with root package name */
        public int f1829g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public final int f1830i;

        /* renamed from: j, reason: collision with root package name */
        public int f1831j;

        /* renamed from: k, reason: collision with root package name */
        public int f1832k = Integer.MAX_VALUE;

        public a(int i10, boolean z, int i11, byte[] bArr) {
            this.f1827e = bArr;
            this.f1828f = i11 + i10;
            this.h = i10;
            this.f1830i = i10;
        }

        public final long A() throws InvalidProtocolBufferException {
            int i10 = this.h;
            if (this.f1828f - i10 < 8) {
                throw InvalidProtocolBufferException.f();
            }
            this.h = i10 + 8;
            byte[] bArr = this.f1827e;
            return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
        }

        public final int B() {
            int i10;
            int i11 = this.h;
            int i12 = this.f1828f;
            if (i12 != i11) {
                int i13 = i11 + 1;
                byte[] bArr = this.f1827e;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.h = i13;
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
                    this.h = i14;
                    return i10;
                }
            }
            return (int) D();
        }

        public final long C() {
            long j10;
            long j11;
            long j12;
            long j13;
            int i10 = this.h;
            int i11 = this.f1828f;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f1827e;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.h = i12;
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
                                j13 = (-2080896) ^ i18;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (bArr[i17] << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    i17 = i10 + 6;
                                    long j16 = j15 ^ (bArr[i13] << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (bArr[i17] << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i17 = i10 + 8;
                                            j16 = j15 ^ (bArr[i13] << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (bArr[i17] << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i19 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i19;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j13 = j11 ^ j16;
                                }
                                j10 = j12 ^ j15;
                            }
                            i13 = i17;
                            j10 = j13;
                        }
                    }
                    this.h = i13;
                    return j10;
                }
            }
            return D();
        }

        public final long D() throws InvalidProtocolBufferException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                int i11 = this.h;
                if (i11 == this.f1828f) {
                    throw InvalidProtocolBufferException.f();
                }
                this.h = i11 + 1;
                j10 |= (r3 & 127) << i10;
                if ((this.f1827e[i11] & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        public final void E() {
            int i10 = this.f1828f + this.f1829g;
            this.f1828f = i10;
            int i11 = i10 - this.f1830i;
            int i12 = this.f1832k;
            if (i11 <= i12) {
                this.f1829g = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f1829g = i13;
            this.f1828f = i10 - i13;
        }

        public final void F(int i10) throws InvalidProtocolBufferException {
            if (i10 >= 0) {
                int i11 = this.f1828f;
                int i12 = this.h;
                if (i10 <= i11 - i12) {
                    this.h = i12 + i10;
                    return;
                }
            }
            if (i10 >= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.d();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final void a(int i10) throws InvalidProtocolBufferException {
            if (this.f1831j != i10) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int c() {
            return this.h - this.f1830i;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean d() {
            return this.h == this.f1828f;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final void e(int i10) {
            this.f1832k = i10;
            E();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int f(int i10) {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = c() + i10;
            int i11 = this.f1832k;
            if (iC > i11) {
                throw InvalidProtocolBufferException.f();
            }
            this.f1832k = iC;
            E();
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean g() {
            return C() != 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        @Override // androidx.datastore.preferences.protobuf.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.datastore.preferences.protobuf.ByteString h() throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
            /*
                r4 = this;
                int r0 = r4.B()
                byte[] r1 = r4.f1827e
                if (r0 <= 0) goto L19
                int r2 = r4.f1828f
                int r3 = r4.h
                int r2 = r2 - r3
                if (r0 > r2) goto L19
                androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.b(r1, r3, r0)
                int r2 = r4.h
                int r2 = r2 + r0
                r4.h = r2
                return r1
            L19:
                if (r0 != 0) goto L1e
                androidx.datastore.preferences.protobuf.ByteString r4 = androidx.datastore.preferences.protobuf.ByteString.f1717b
                return r4
            L1e:
                if (r0 <= 0) goto L2f
                int r2 = r4.f1828f
                int r3 = r4.h
                int r2 = r2 - r3
                if (r0 > r2) goto L2f
                int r0 = r0 + r3
                r4.h = r0
                byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r0)
                goto L35
            L2f:
                if (r0 > 0) goto L42
                if (r0 != 0) goto L3d
                byte[] r4 = androidx.datastore.preferences.protobuf.u.f1889b
            L35:
                androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.f1717b
                androidx.datastore.preferences.protobuf.ByteString$LiteralByteString r0 = new androidx.datastore.preferences.protobuf.ByteString$LiteralByteString
                r0.<init>(r4)
                return r0
            L3d:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.d()
                throw r4
            L42:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.f()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.h.a.h():androidx.datastore.preferences.protobuf.ByteString");
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final double i() {
            return Double.longBitsToDouble(A());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int j() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int k() {
            return z();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long l() {
            return A();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final float m() {
            return Float.intBitsToFloat(z());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int n() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long o() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int p() {
            return z();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long q() {
            return A();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int r() {
            int iB = B();
            return (-(iB & 1)) ^ (iB >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long s() {
            return h.b(C());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final String t() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0) {
                int i10 = this.f1828f;
                int i11 = this.h;
                if (iB <= i10 - i11) {
                    String str = new String(this.f1827e, i11, iB, u.f1888a);
                    this.h += iB;
                    return str;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB < 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final String u() throws InvalidProtocolBufferException {
            int iB = B();
            if (iB > 0) {
                int i10 = this.f1828f;
                int i11 = this.h;
                if (iB <= i10 - i11) {
                    String strA = Utf8.f1765a.a(this.f1827e, i11, iB);
                    this.h += iB;
                    return strA;
                }
            }
            if (iB == 0) {
                return "";
            }
            if (iB <= 0) {
                throw InvalidProtocolBufferException.d();
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int v() throws InvalidProtocolBufferException {
            if (d()) {
                this.f1831j = 0;
                return 0;
            }
            int iB = B();
            this.f1831j = iB;
            if ((iB >>> 3) != 0) {
                return iB;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int w() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long x() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean y(int i10) throws InvalidProtocolBufferException {
            int iV;
            int i11 = i10 & 7;
            int i12 = 0;
            if (i11 == 0) {
                int i13 = this.f1828f - this.h;
                byte[] bArr = this.f1827e;
                if (i13 >= 10) {
                    while (i12 < 10) {
                        int i14 = this.h;
                        this.h = i14 + 1;
                        if (bArr[i14] < 0) {
                            i12++;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                while (i12 < 10) {
                    int i15 = this.h;
                    if (i15 == this.f1828f) {
                        throw InvalidProtocolBufferException.f();
                    }
                    this.h = i15 + 1;
                    if (bArr[i15] < 0) {
                        i12++;
                    }
                }
                throw InvalidProtocolBufferException.c();
                return true;
            }
            if (i11 == 1) {
                F(8);
                return true;
            }
            if (i11 == 2) {
                F(B());
                return true;
            }
            if (i11 != 3) {
                if (i11 == 4) {
                    return false;
                }
                if (i11 != 5) {
                    throw InvalidProtocolBufferException.b();
                }
                F(4);
                return true;
            }
            do {
                iV = v();
                if (iV == 0) {
                    break;
                }
            } while (y(iV));
            a(((i10 >>> 3) << 3) | 4);
            return true;
        }

        public final int z() throws InvalidProtocolBufferException {
            int i10 = this.h;
            if (this.f1828f - i10 < 4) {
                throw InvalidProtocolBufferException.f();
            }
            this.h = i10 + 4;
            byte[] bArr = this.f1827e;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b extends h {

        /* renamed from: e, reason: collision with root package name */
        public final FileInputStream f1833e;

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f1834f;

        /* renamed from: g, reason: collision with root package name */
        public int f1835g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public int f1836i;

        /* renamed from: j, reason: collision with root package name */
        public int f1837j;

        /* renamed from: k, reason: collision with root package name */
        public int f1838k;

        /* renamed from: l, reason: collision with root package name */
        public int f1839l = Integer.MAX_VALUE;

        public b(FileInputStream fileInputStream) {
            Charset charset = u.f1888a;
            this.f1833e = fileInputStream;
            this.f1834f = new byte[4096];
            this.f1835g = 0;
            this.f1836i = 0;
            this.f1838k = 0;
        }

        public final byte[] A(int i10) throws IOException {
            if (i10 == 0) {
                return u.f1889b;
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f1838k;
            int i12 = this.f1836i;
            int i13 = i11 + i12 + i10;
            if (i13 - this.f1825c > 0) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            int i14 = this.f1839l;
            if (i13 > i14) {
                J((i14 - i11) - i12);
                throw InvalidProtocolBufferException.f();
            }
            int i15 = this.f1835g - i12;
            int i16 = i10 - i15;
            FileInputStream fileInputStream = this.f1833e;
            if (i16 >= 4096 && i16 > fileInputStream.available()) {
                return null;
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f1834f, this.f1836i, bArr, 0, i15);
            this.f1838k += this.f1835g;
            this.f1836i = 0;
            this.f1835g = 0;
            while (i15 < i10) {
                int i17 = fileInputStream.read(bArr, i15, i10 - i15);
                if (i17 == -1) {
                    throw InvalidProtocolBufferException.f();
                }
                this.f1838k += i17;
                i15 += i17;
            }
            return bArr;
        }

        public final ArrayList B(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int iMin = Math.min(i10, 4096);
                byte[] bArr = new byte[iMin];
                int i11 = 0;
                while (i11 < iMin) {
                    int i12 = this.f1833e.read(bArr, i11, iMin - i11);
                    if (i12 == -1) {
                        throw InvalidProtocolBufferException.f();
                    }
                    this.f1838k += i12;
                    i11 += i12;
                }
                i10 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int C() throws InvalidProtocolBufferException {
            int i10 = this.f1836i;
            if (this.f1835g - i10 < 4) {
                I(4);
                i10 = this.f1836i;
            }
            this.f1836i = i10 + 4;
            byte[] bArr = this.f1834f;
            return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        public final long D() throws InvalidProtocolBufferException {
            int i10 = this.f1836i;
            if (this.f1835g - i10 < 8) {
                I(8);
                i10 = this.f1836i;
            }
            this.f1836i = i10 + 8;
            byte[] bArr = this.f1834f;
            return ((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48) | ((bArr[i10 + 7] & 255) << 56);
        }

        public final int E() {
            int i10;
            int i11 = this.f1836i;
            int i12 = this.f1835g;
            if (i12 != i11) {
                int i13 = i11 + 1;
                byte[] bArr = this.f1834f;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f1836i = i13;
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
                    this.f1836i = i14;
                    return i10;
                }
            }
            return (int) G();
        }

        public final long F() {
            long j10;
            long j11;
            long j12;
            long j13;
            int i10 = this.f1836i;
            int i11 = this.f1835g;
            if (i11 != i10) {
                int i12 = i10 + 1;
                byte[] bArr = this.f1834f;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f1836i = i12;
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
                                j13 = (-2080896) ^ i18;
                            } else {
                                long j14 = i18;
                                i13 = i10 + 5;
                                long j15 = j14 ^ (bArr[i17] << 28);
                                if (j15 >= 0) {
                                    j12 = 266354560;
                                } else {
                                    i17 = i10 + 6;
                                    long j16 = j15 ^ (bArr[i13] << 35);
                                    if (j16 < 0) {
                                        j11 = -34093383808L;
                                    } else {
                                        i13 = i10 + 7;
                                        j15 = j16 ^ (bArr[i17] << 42);
                                        if (j15 >= 0) {
                                            j12 = 4363953127296L;
                                        } else {
                                            i17 = i10 + 8;
                                            j16 = j15 ^ (bArr[i13] << 49);
                                            if (j16 < 0) {
                                                j11 = -558586000294016L;
                                            } else {
                                                i13 = i10 + 9;
                                                long j17 = (j16 ^ (bArr[i17] << 56)) ^ 71499008037633920L;
                                                if (j17 < 0) {
                                                    int i19 = i10 + 10;
                                                    if (bArr[i13] >= 0) {
                                                        i13 = i19;
                                                    }
                                                }
                                                j10 = j17;
                                            }
                                        }
                                    }
                                    j13 = j11 ^ j16;
                                }
                                j10 = j12 ^ j15;
                            }
                            i13 = i17;
                            j10 = j13;
                        }
                    }
                    this.f1836i = i13;
                    return j10;
                }
            }
            return G();
        }

        public final long G() throws InvalidProtocolBufferException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                if (this.f1836i == this.f1835g) {
                    I(1);
                }
                int i11 = this.f1836i;
                this.f1836i = i11 + 1;
                j10 |= (r3 & 127) << i10;
                if ((this.f1834f[i11] & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.c();
        }

        public final void H() {
            int i10 = this.f1835g + this.h;
            this.f1835g = i10;
            int i11 = this.f1838k + i10;
            int i12 = this.f1839l;
            if (i11 <= i12) {
                this.h = 0;
                return;
            }
            int i13 = i11 - i12;
            this.h = i13;
            this.f1835g = i10 - i13;
        }

        public final void I(int i10) throws InvalidProtocolBufferException {
            if (K(i10)) {
                return;
            }
            if (i10 <= (this.f1825c - this.f1838k) - this.f1836i) {
                throw InvalidProtocolBufferException.f();
            }
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }

        public final void J(int i10) throws InvalidProtocolBufferException {
            int i11 = this.f1835g;
            int i12 = this.f1836i;
            int i13 = i11 - i12;
            if (i10 <= i13 && i10 >= 0) {
                this.f1836i = i12 + i10;
                return;
            }
            FileInputStream fileInputStream = this.f1833e;
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i14 = this.f1838k;
            int i15 = i14 + i12;
            int i16 = i15 + i10;
            int i17 = this.f1839l;
            if (i16 > i17) {
                J((i17 - i14) - i12);
                throw InvalidProtocolBufferException.f();
            }
            this.f1838k = i15;
            this.f1835g = 0;
            this.f1836i = 0;
            while (i13 < i10) {
                long j10 = i10 - i13;
                try {
                    long jSkip = fileInputStream.skip(j10);
                    if (jSkip < 0 || jSkip > j10) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i13 += (int) jSkip;
                    }
                } finally {
                    this.f1838k += i13;
                    H();
                }
            }
            if (i13 >= i10) {
                return;
            }
            int i18 = this.f1835g;
            int i19 = i18 - this.f1836i;
            this.f1836i = i18;
            I(1);
            while (true) {
                int i20 = i10 - i19;
                int i21 = this.f1835g;
                if (i20 <= i21) {
                    this.f1836i = i20;
                    return;
                } else {
                    i19 += i21;
                    this.f1836i = i21;
                    I(1);
                }
            }
        }

        public final boolean K(int i10) throws IOException {
            int i11 = this.f1836i;
            int i12 = i11 + i10;
            int i13 = this.f1835g;
            if (i12 <= i13) {
                throw new IllegalStateException(ai.onnxruntime.a.g(i10, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i14 = this.f1838k;
            int i15 = this.f1825c;
            if (i10 <= (i15 - i14) - i11 && i14 + i11 + i10 <= this.f1839l) {
                byte[] bArr = this.f1834f;
                if (i11 > 0) {
                    if (i13 > i11) {
                        System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                    }
                    this.f1838k += i11;
                    this.f1835g -= i11;
                    this.f1836i = 0;
                }
                int i16 = this.f1835g;
                int iMin = Math.min(bArr.length - i16, (i15 - this.f1838k) - i16);
                FileInputStream fileInputStream = this.f1833e;
                int i17 = fileInputStream.read(bArr, i16, iMin);
                if (i17 == 0 || i17 < -1 || i17 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i17 + "\nThe InputStream implementation is buggy.");
                }
                if (i17 > 0) {
                    this.f1835g += i17;
                    H();
                    if (this.f1835g >= i10) {
                        return true;
                    }
                    return K(i10);
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final void a(int i10) throws InvalidProtocolBufferException {
            if (this.f1837j != i10) {
                throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
            }
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int c() {
            return this.f1838k + this.f1836i;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean d() {
            return this.f1836i == this.f1835g && !K(1);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final void e(int i10) {
            this.f1839l = i10;
            H();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int f(int i10) throws InvalidProtocolBufferException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f1838k + this.f1836i + i10;
            int i12 = this.f1839l;
            if (i11 > i12) {
                throw InvalidProtocolBufferException.f();
            }
            this.f1839l = i11;
            H();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean g() {
            return F() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final ByteString h() throws IOException {
            int iE = E();
            int i10 = this.f1835g;
            int i11 = this.f1836i;
            int i12 = i10 - i11;
            byte[] bArr = this.f1834f;
            if (iE <= i12 && iE > 0) {
                ByteString byteStringB = ByteString.b(bArr, i11, iE);
                this.f1836i += iE;
                return byteStringB;
            }
            if (iE == 0) {
                return ByteString.f1717b;
            }
            byte[] bArrA = A(iE);
            if (bArrA != null) {
                return ByteString.b(bArrA, 0, bArrA.length);
            }
            int i13 = this.f1836i;
            int i14 = this.f1835g;
            int length = i14 - i13;
            this.f1838k += i14;
            this.f1836i = 0;
            this.f1835g = 0;
            ArrayList arrayListB = B(iE - length);
            byte[] bArr2 = new byte[iE];
            System.arraycopy(bArr, i13, bArr2, 0, length);
            int size = arrayListB.size();
            int i15 = 0;
            while (i15 < size) {
                Object obj = arrayListB.get(i15);
                i15++;
                byte[] bArr3 = (byte[]) obj;
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            ByteString byteString = ByteString.f1717b;
            return new ByteString.LiteralByteString(bArr2);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final double i() {
            return Double.longBitsToDouble(D());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int j() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int k() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long l() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final float m() {
            return Float.intBitsToFloat(C());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int n() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long o() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int p() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long q() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int r() {
            int iE = E();
            return (-(iE & 1)) ^ (iE >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long s() {
            return h.b(F());
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final String t() throws InvalidProtocolBufferException {
            int iE = E();
            byte[] bArr = this.f1834f;
            if (iE > 0) {
                int i10 = this.f1835g;
                int i11 = this.f1836i;
                if (iE <= i10 - i11) {
                    String str = new String(bArr, i11, iE, u.f1888a);
                    this.f1836i += iE;
                    return str;
                }
            }
            if (iE == 0) {
                return "";
            }
            if (iE > this.f1835g) {
                return new String(z(iE), u.f1888a);
            }
            I(iE);
            String str2 = new String(bArr, this.f1836i, iE, u.f1888a);
            this.f1836i += iE;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final String u() throws IOException {
            int iE = E();
            int i10 = this.f1836i;
            int i11 = this.f1835g;
            int i12 = i11 - i10;
            byte[] bArrZ = this.f1834f;
            if (iE <= i12 && iE > 0) {
                this.f1836i = i10 + iE;
            } else {
                if (iE == 0) {
                    return "";
                }
                i10 = 0;
                if (iE <= i11) {
                    I(iE);
                    this.f1836i = iE;
                } else {
                    bArrZ = z(iE);
                }
            }
            return Utf8.f1765a.a(bArrZ, i10, iE);
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int v() throws InvalidProtocolBufferException {
            if (d()) {
                this.f1837j = 0;
                return 0;
            }
            int iE = E();
            this.f1837j = iE;
            if ((iE >>> 3) != 0) {
                return iE;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final int w() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final long x() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.h
        public final boolean y(int i10) throws InvalidProtocolBufferException {
            int iV;
            int i11 = i10 & 7;
            int i12 = 0;
            if (i11 == 0) {
                int i13 = this.f1835g - this.f1836i;
                byte[] bArr = this.f1834f;
                if (i13 >= 10) {
                    while (i12 < 10) {
                        int i14 = this.f1836i;
                        this.f1836i = i14 + 1;
                        if (bArr[i14] < 0) {
                            i12++;
                        }
                    }
                    throw InvalidProtocolBufferException.c();
                }
                while (i12 < 10) {
                    if (this.f1836i == this.f1835g) {
                        I(1);
                    }
                    int i15 = this.f1836i;
                    this.f1836i = i15 + 1;
                    if (bArr[i15] < 0) {
                        i12++;
                    }
                }
                throw InvalidProtocolBufferException.c();
                return true;
            }
            if (i11 == 1) {
                J(8);
                return true;
            }
            if (i11 == 2) {
                J(E());
                return true;
            }
            if (i11 != 3) {
                if (i11 == 4) {
                    return false;
                }
                if (i11 != 5) {
                    throw InvalidProtocolBufferException.b();
                }
                J(4);
                return true;
            }
            do {
                iV = v();
                if (iV == 0) {
                    break;
                }
            } while (y(iV));
            a(((i10 >>> 3) << 3) | 4);
            return true;
        }

        public final byte[] z(int i10) throws IOException {
            byte[] bArrA = A(i10);
            if (bArrA != null) {
                return bArrA;
            }
            int i11 = this.f1836i;
            int i12 = this.f1835g;
            int length = i12 - i11;
            this.f1838k += i12;
            this.f1836i = 0;
            this.f1835g = 0;
            ArrayList arrayListB = B(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f1834f, i11, bArr, 0, length);
            int size = arrayListB.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayListB.get(i13);
                i13++;
                byte[] bArr2 = (byte[]) obj;
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }
    }

    public static long b(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public abstract void a(int i10);

    public abstract int c();

    public abstract boolean d();

    public abstract void e(int i10);

    public abstract int f(int i10);

    public abstract boolean g();

    public abstract ByteString h();

    public abstract double i();

    public abstract int j();

    public abstract int k();

    public abstract long l();

    public abstract float m();

    public abstract int n();

    public abstract long o();

    public abstract int p();

    public abstract long q();

    public abstract int r();

    public abstract long s();

    public abstract String t();

    public abstract String u();

    public abstract int v();

    public abstract int w();

    public abstract long x();

    public abstract boolean y(int i10);
}
