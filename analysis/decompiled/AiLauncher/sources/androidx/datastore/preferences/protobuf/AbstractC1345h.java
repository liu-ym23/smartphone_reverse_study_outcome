package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1345h {

    /* renamed from: a, reason: collision with root package name */
    public int f13555a;

    /* renamed from: b, reason: collision with root package name */
    public int f13556b;

    /* renamed from: c, reason: collision with root package name */
    public int f13557c;

    /* renamed from: d, reason: collision with root package name */
    public C1346i f13558d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13559e;

    /* renamed from: androidx.datastore.preferences.protobuf.h$b */
    public static final class b extends AbstractC1345h {

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f13560f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f13561g;

        /* renamed from: h, reason: collision with root package name */
        public int f13562h;

        /* renamed from: i, reason: collision with root package name */
        public int f13563i;

        /* renamed from: j, reason: collision with root package name */
        public int f13564j;

        /* renamed from: k, reason: collision with root package name */
        public int f13565k;

        /* renamed from: l, reason: collision with root package name */
        public int f13566l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f13567m;

        /* renamed from: n, reason: collision with root package name */
        public int f13568n;

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public String A() throws IOException {
            int iJ = J();
            if (iJ > 0) {
                int i10 = this.f13562h;
                int i11 = this.f13564j;
                if (iJ <= i10 - i11) {
                    String strE = Utf8.e(this.f13560f, i11, iJ);
                    this.f13564j += iJ;
                    return strE;
                }
            }
            if (iJ == 0) {
                return "";
            }
            if (iJ <= 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int B() throws IOException {
            if (e()) {
                this.f13566l = 0;
                return 0;
            }
            int iJ = J();
            this.f13566l = iJ;
            if (WireFormat.a(iJ) != 0) {
                return this.f13566l;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int C() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long D() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean E(int i10) throws IOException {
            int iB = WireFormat.b(i10);
            if (iB == 0) {
                P();
                return true;
            }
            if (iB == 1) {
                O(8);
                return true;
            }
            if (iB == 2) {
                O(J());
                return true;
            }
            if (iB == 3) {
                N();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            O(4);
            return true;
        }

        public byte F() throws IOException {
            int i10 = this.f13564j;
            if (i10 == this.f13562h) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13560f;
            this.f13564j = i10 + 1;
            return bArr[i10];
        }

        public byte[] G(int i10) throws IOException {
            if (i10 > 0) {
                int i11 = this.f13562h;
                int i12 = this.f13564j;
                if (i10 <= i11 - i12) {
                    int i13 = i10 + i12;
                    this.f13564j = i13;
                    return Arrays.copyOfRange(this.f13560f, i12, i13);
                }
            }
            if (i10 > 0) {
                throw InvalidProtocolBufferException.k();
            }
            if (i10 == 0) {
                return C1359w.f13644c;
            }
            throw InvalidProtocolBufferException.f();
        }

        public int H() throws IOException {
            int i10 = this.f13564j;
            if (this.f13562h - i10 < 4) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13560f;
            this.f13564j = i10 + 4;
            return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
        }

        public long I() throws IOException {
            int i10 = this.f13564j;
            if (this.f13562h - i10 < 8) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13560f;
            this.f13564j = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        public int J() throws IOException {
            int i10;
            int i11 = this.f13564j;
            int i12 = this.f13562h;
            if (i12 != i11) {
                byte[] bArr = this.f13560f;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13564j = i13;
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
                    this.f13564j = i14;
                    return i10;
                }
            }
            return (int) L();
        }

        public long K() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10 = this.f13564j;
            int i11 = this.f13562h;
            if (i11 != i10) {
                byte[] bArr = this.f13560f;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f13564j = i12;
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
                    this.f13564j = i13;
                    return j10;
                }
            }
            return L();
        }

        public long L() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((F() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public final void M() {
            int i10 = this.f13562h + this.f13563i;
            this.f13562h = i10;
            int i11 = i10 - this.f13565k;
            int i12 = this.f13568n;
            if (i11 <= i12) {
                this.f13563i = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f13563i = i13;
            this.f13562h = i10 - i13;
        }

        public void N() throws IOException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void O(int i10) throws IOException {
            if (i10 >= 0) {
                int i11 = this.f13562h;
                int i12 = this.f13564j;
                if (i10 <= i11 - i12) {
                    this.f13564j = i12 + i10;
                    return;
                }
            }
            if (i10 >= 0) {
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.f();
        }

        public final void P() throws IOException {
            if (this.f13562h - this.f13564j >= 10) {
                Q();
            } else {
                R();
            }
        }

        public final void Q() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f13560f;
                int i11 = this.f13564j;
                this.f13564j = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public final void R() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (F() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f13566l != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int d() {
            return this.f13564j - this.f13565k;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean e() throws IOException {
            return this.f13564j == this.f13562h;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public void k(int i10) {
            this.f13568n = i10;
            M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int l(int i10) throws InvalidProtocolBufferException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int iD = i10 + d();
            int i11 = this.f13568n;
            if (iD > i11) {
                throw InvalidProtocolBufferException.k();
            }
            this.f13568n = iD;
            M();
            return i11;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean m() throws IOException {
            return K() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public ByteString n() throws IOException {
            int iJ = J();
            if (iJ > 0) {
                int i10 = this.f13562h;
                int i11 = this.f13564j;
                if (iJ <= i10 - i11) {
                    ByteString byteStringK = (this.f13561g && this.f13567m) ? ByteString.K(this.f13560f, i11, iJ) : ByteString.j(this.f13560f, i11, iJ);
                    this.f13564j += iJ;
                    return byteStringK;
                }
            }
            return iJ == 0 ? ByteString.f13407b : ByteString.J(G(iJ));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public double o() throws IOException {
            return Double.longBitsToDouble(I());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int p() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int q() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long r() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public float s() throws IOException {
            return Float.intBitsToFloat(H());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int t() throws IOException {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long u() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int v() throws IOException {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long w() throws IOException {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int x() throws IOException {
            return AbstractC1345h.b(J());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long y() throws IOException {
            return AbstractC1345h.c(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public String z() throws IOException {
            int iJ = J();
            if (iJ > 0) {
                int i10 = this.f13562h;
                int i11 = this.f13564j;
                if (iJ <= i10 - i11) {
                    String str = new String(this.f13560f, i11, iJ, C1359w.f13642a);
                    this.f13564j += iJ;
                    return str;
                }
            }
            if (iJ == 0) {
                return "";
            }
            if (iJ < 0) {
                throw InvalidProtocolBufferException.f();
            }
            throw InvalidProtocolBufferException.k();
        }

        public b(byte[] bArr, int i10, int i11, boolean z10) {
            super();
            this.f13568n = Integer.MAX_VALUE;
            this.f13560f = bArr;
            this.f13562h = i11 + i10;
            this.f13564j = i10;
            this.f13565k = i10;
            this.f13561g = z10;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.h$c */
    public static final class c extends AbstractC1345h {

        /* renamed from: f, reason: collision with root package name */
        public final InputStream f13569f;

        /* renamed from: g, reason: collision with root package name */
        public final byte[] f13570g;

        /* renamed from: h, reason: collision with root package name */
        public int f13571h;

        /* renamed from: i, reason: collision with root package name */
        public int f13572i;

        /* renamed from: j, reason: collision with root package name */
        public int f13573j;

        /* renamed from: k, reason: collision with root package name */
        public int f13574k;

        /* renamed from: l, reason: collision with root package name */
        public int f13575l;

        /* renamed from: m, reason: collision with root package name */
        public int f13576m;

        private void P() {
            int i10 = this.f13571h + this.f13572i;
            this.f13571h = i10;
            int i11 = this.f13575l + i10;
            int i12 = this.f13576m;
            if (i11 <= i12) {
                this.f13572i = 0;
                return;
            }
            int i13 = i11 - i12;
            this.f13572i = i13;
            this.f13571h = i10 - i13;
        }

        private void U() throws IOException {
            if (this.f13571h - this.f13573j >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                byte[] bArr = this.f13570g;
                int i11 = this.f13573j;
                this.f13573j = i11 + 1;
                if (bArr[i11] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        private void W() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (G() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public String A() throws IOException {
            byte[] bArrH;
            int iM = M();
            int i10 = this.f13573j;
            int i11 = this.f13571h;
            if (iM <= i11 - i10 && iM > 0) {
                bArrH = this.f13570g;
                this.f13573j = i10 + iM;
            } else {
                if (iM == 0) {
                    return "";
                }
                i10 = 0;
                if (iM <= i11) {
                    Q(iM);
                    bArrH = this.f13570g;
                    this.f13573j = iM;
                } else {
                    bArrH = H(iM, false);
                }
            }
            return Utf8.e(bArrH, i10, iM);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int B() throws IOException {
            if (e()) {
                this.f13574k = 0;
                return 0;
            }
            int iM = M();
            this.f13574k = iM;
            if (WireFormat.a(iM) != 0) {
                return this.f13574k;
            }
            throw InvalidProtocolBufferException.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int C() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long D() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean E(int i10) throws IOException {
            int iB = WireFormat.b(i10);
            if (iB == 0) {
                U();
                return true;
            }
            if (iB == 1) {
                S(8);
                return true;
            }
            if (iB == 2) {
                S(M());
                return true;
            }
            if (iB == 3) {
                R();
                a(WireFormat.c(WireFormat.a(i10), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            S(4);
            return true;
        }

        public final ByteString F(int i10) throws IOException {
            byte[] bArrI = I(i10);
            if (bArrI != null) {
                return ByteString.i(bArrI);
            }
            int i11 = this.f13573j;
            int i12 = this.f13571h;
            int length = i12 - i11;
            this.f13575l += i12;
            this.f13573j = 0;
            this.f13571h = 0;
            List<byte[]> listJ = J(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f13570g, i11, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.J(bArr);
        }

        public byte G() throws IOException {
            if (this.f13573j == this.f13571h) {
                Q(1);
            }
            byte[] bArr = this.f13570g;
            int i10 = this.f13573j;
            this.f13573j = i10 + 1;
            return bArr[i10];
        }

        public final byte[] H(int i10, boolean z10) throws IOException {
            byte[] bArrI = I(i10);
            if (bArrI != null) {
                return z10 ? (byte[]) bArrI.clone() : bArrI;
            }
            int i11 = this.f13573j;
            int i12 = this.f13571h;
            int length = i12 - i11;
            this.f13575l += i12;
            this.f13573j = 0;
            this.f13571h = 0;
            List<byte[]> listJ = J(i10 - length);
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f13570g, i11, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] I(int i10) throws IOException {
            if (i10 == 0) {
                return C1359w.f13644c;
            }
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i11 = this.f13575l;
            int i12 = this.f13573j;
            int i13 = i11 + i12 + i10;
            if (i13 - this.f13557c > 0) {
                throw InvalidProtocolBufferException.j();
            }
            int i14 = this.f13576m;
            if (i13 > i14) {
                S((i14 - i11) - i12);
                throw InvalidProtocolBufferException.k();
            }
            int i15 = this.f13571h - i12;
            int i16 = i10 - i15;
            if (i16 >= 4096 && i16 > this.f13569f.available()) {
                return null;
            }
            byte[] bArr = new byte[i10];
            System.arraycopy(this.f13570g, this.f13573j, bArr, 0, i15);
            this.f13575l += this.f13571h;
            this.f13573j = 0;
            this.f13571h = 0;
            while (i15 < i10) {
                int i17 = this.f13569f.read(bArr, i15, i10 - i15);
                if (i17 == -1) {
                    throw InvalidProtocolBufferException.k();
                }
                this.f13575l += i17;
                i15 += i17;
            }
            return bArr;
        }

        public final List<byte[]> J(int i10) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i10 > 0) {
                int iMin = Math.min(i10, 4096);
                byte[] bArr = new byte[iMin];
                int i11 = 0;
                while (i11 < iMin) {
                    int i12 = this.f13569f.read(bArr, i11, iMin - i11);
                    if (i12 == -1) {
                        throw InvalidProtocolBufferException.k();
                    }
                    this.f13575l += i12;
                    i11 += i12;
                }
                i10 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public int K() throws IOException {
            int i10 = this.f13573j;
            if (this.f13571h - i10 < 4) {
                Q(4);
                i10 = this.f13573j;
            }
            byte[] bArr = this.f13570g;
            this.f13573j = i10 + 4;
            return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
        }

        public long L() throws IOException {
            int i10 = this.f13573j;
            if (this.f13571h - i10 < 8) {
                Q(8);
                i10 = this.f13573j;
            }
            byte[] bArr = this.f13570g;
            this.f13573j = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        public int M() throws IOException {
            int i10;
            int i11 = this.f13573j;
            int i12 = this.f13571h;
            if (i12 != i11) {
                byte[] bArr = this.f13570g;
                int i13 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 >= 0) {
                    this.f13573j = i13;
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
                    this.f13573j = i14;
                    return i10;
                }
            }
            return (int) O();
        }

        public long N() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10 = this.f13573j;
            int i11 = this.f13571h;
            if (i11 != i10) {
                byte[] bArr = this.f13570g;
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    this.f13573j = i12;
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
                    this.f13573j = i13;
                    return j10;
                }
            }
            return O();
        }

        public long O() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((G() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public final void Q(int i10) throws IOException {
            if (X(i10)) {
                return;
            }
            if (i10 <= (this.f13557c - this.f13575l) - this.f13573j) {
                throw InvalidProtocolBufferException.k();
            }
            throw InvalidProtocolBufferException.j();
        }

        public void R() throws IOException {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void S(int i10) throws IOException {
            int i11 = this.f13571h;
            int i12 = this.f13573j;
            if (i10 > i11 - i12 || i10 < 0) {
                T(i10);
            } else {
                this.f13573j = i12 + i10;
            }
        }

        public final void T(int i10) throws IOException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i11 = this.f13575l;
            int i12 = this.f13573j;
            int i13 = i11 + i12 + i10;
            int i14 = this.f13576m;
            if (i13 > i14) {
                S((i14 - i11) - i12);
                throw InvalidProtocolBufferException.k();
            }
            this.f13575l = i11 + i12;
            int i15 = this.f13571h - i12;
            this.f13571h = 0;
            this.f13573j = 0;
            while (i15 < i10) {
                try {
                    long j10 = i10 - i15;
                    long jSkip = this.f13569f.skip(j10);
                    if (jSkip < 0 || jSkip > j10) {
                        throw new IllegalStateException(this.f13569f.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i15 += (int) jSkip;
                    }
                } finally {
                    this.f13575l += i15;
                    P();
                }
            }
            if (i15 >= i10) {
                return;
            }
            int i16 = this.f13571h;
            int i17 = i16 - this.f13573j;
            this.f13573j = i16;
            Q(1);
            while (true) {
                int i18 = i10 - i17;
                int i19 = this.f13571h;
                if (i18 <= i19) {
                    this.f13573j = i18;
                    return;
                } else {
                    i17 += i19;
                    this.f13573j = i19;
                    Q(1);
                }
            }
        }

        public final boolean X(int i10) throws IOException {
            int i11 = this.f13573j;
            int i12 = i11 + i10;
            int i13 = this.f13571h;
            if (i12 <= i13) {
                throw new IllegalStateException("refillBuffer() called when " + i10 + " bytes were already available in buffer");
            }
            int i14 = this.f13557c;
            int i15 = this.f13575l;
            if (i10 > (i14 - i15) - i11 || i15 + i11 + i10 > this.f13576m) {
                return false;
            }
            if (i11 > 0) {
                if (i13 > i11) {
                    byte[] bArr = this.f13570g;
                    System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                }
                this.f13575l += i11;
                this.f13571h -= i11;
                this.f13573j = 0;
            }
            InputStream inputStream = this.f13569f;
            byte[] bArr2 = this.f13570g;
            int i16 = this.f13571h;
            int i17 = inputStream.read(bArr2, i16, Math.min(bArr2.length - i16, (this.f13557c - this.f13575l) - i16));
            if (i17 == 0 || i17 < -1 || i17 > this.f13570g.length) {
                throw new IllegalStateException(this.f13569f.getClass() + "#read(byte[]) returned invalid result: " + i17 + "\nThe InputStream implementation is buggy.");
            }
            if (i17 <= 0) {
                return false;
            }
            this.f13571h += i17;
            P();
            if (this.f13571h >= i10) {
                return true;
            }
            return X(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public void a(int i10) throws InvalidProtocolBufferException {
            if (this.f13574k != i10) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int d() {
            return this.f13575l + this.f13573j;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean e() throws IOException {
            return this.f13573j == this.f13571h && !X(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public void k(int i10) {
            this.f13576m = i10;
            P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int l(int i10) throws InvalidProtocolBufferException {
            if (i10 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i11 = i10 + this.f13575l + this.f13573j;
            int i12 = this.f13576m;
            if (i11 > i12) {
                throw InvalidProtocolBufferException.k();
            }
            this.f13576m = i11;
            P();
            return i12;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public boolean m() throws IOException {
            return N() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public ByteString n() throws IOException {
            int iM = M();
            int i10 = this.f13571h;
            int i11 = this.f13573j;
            if (iM > i10 - i11 || iM <= 0) {
                return iM == 0 ? ByteString.f13407b : F(iM);
            }
            ByteString byteStringJ = ByteString.j(this.f13570g, i11, iM);
            this.f13573j += iM;
            return byteStringJ;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public double o() throws IOException {
            return Double.longBitsToDouble(L());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int p() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int q() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long r() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public float s() throws IOException {
            return Float.intBitsToFloat(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int t() throws IOException {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long u() throws IOException {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int v() throws IOException {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long w() throws IOException {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public int x() throws IOException {
            return AbstractC1345h.b(M());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public long y() throws IOException {
            return AbstractC1345h.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC1345h
        public String z() throws IOException {
            int iM = M();
            if (iM > 0) {
                int i10 = this.f13571h;
                int i11 = this.f13573j;
                if (iM <= i10 - i11) {
                    String str = new String(this.f13570g, i11, iM, C1359w.f13642a);
                    this.f13573j += iM;
                    return str;
                }
            }
            if (iM == 0) {
                return "";
            }
            if (iM > this.f13571h) {
                return new String(H(iM, false), C1359w.f13642a);
            }
            Q(iM);
            String str2 = new String(this.f13570g, this.f13573j, iM, C1359w.f13642a);
            this.f13573j += iM;
            return str2;
        }

        public c(InputStream inputStream, int i10) {
            super();
            this.f13576m = Integer.MAX_VALUE;
            C1359w.b(inputStream, "input");
            this.f13569f = inputStream;
            this.f13570g = new byte[i10];
            this.f13571h = 0;
            this.f13573j = 0;
            this.f13575l = 0;
        }
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static AbstractC1345h f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static AbstractC1345h g(InputStream inputStream, int i10) {
        if (i10 > 0) {
            return inputStream == null ? h(C1359w.f13644c) : new c(inputStream, i10);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC1345h h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static AbstractC1345h i(byte[] bArr, int i10, int i11) {
        return j(bArr, i10, i11, false);
    }

    public static AbstractC1345h j(byte[] bArr, int i10, int i11, boolean z10) {
        b bVar = new b(bArr, i10, i11, z10);
        try {
            bVar.l(i11);
            return bVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract String A() throws IOException;

    public abstract int B() throws IOException;

    public abstract int C() throws IOException;

    public abstract long D() throws IOException;

    public abstract boolean E(int i10) throws IOException;

    public abstract void a(int i10) throws InvalidProtocolBufferException;

    public abstract int d();

    public abstract boolean e() throws IOException;

    public abstract void k(int i10);

    public abstract int l(int i10) throws InvalidProtocolBufferException;

    public abstract boolean m() throws IOException;

    public abstract ByteString n() throws IOException;

    public abstract double o() throws IOException;

    public abstract int p() throws IOException;

    public abstract int q() throws IOException;

    public abstract long r() throws IOException;

    public abstract float s() throws IOException;

    public abstract int t() throws IOException;

    public abstract long u() throws IOException;

    public abstract int v() throws IOException;

    public abstract long w() throws IOException;

    public abstract int x() throws IOException;

    public abstract long y() throws IOException;

    public abstract String z() throws IOException;

    public AbstractC1345h() {
        this.f13556b = 100;
        this.f13557c = Integer.MAX_VALUE;
        this.f13559e = false;
    }
}
