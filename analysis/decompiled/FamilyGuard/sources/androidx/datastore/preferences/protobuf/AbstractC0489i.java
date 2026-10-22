package androidx.datastore.preferences.protobuf;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.libpag.BuildConfig;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0489i {

    /* renamed from: a, reason: collision with root package name */
    int f10021a;

    /* renamed from: b, reason: collision with root package name */
    int f10022b;

    /* renamed from: c, reason: collision with root package name */
    int f10023c;

    /* renamed from: d, reason: collision with root package name */
    C0490j f10024d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f10025e;

    /* renamed from: androidx.datastore.preferences.protobuf.i$b */
    private static final class b extends AbstractC0489i {

        /* renamed from: f, reason: collision with root package name */
        private final byte[] f10026f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f10027g;

        /* renamed from: h, reason: collision with root package name */
        private int f10028h;

        /* renamed from: i, reason: collision with root package name */
        private int f10029i;

        /* renamed from: j, reason: collision with root package name */
        private int f10030j;

        /* renamed from: k, reason: collision with root package name */
        private int f10031k;

        /* renamed from: l, reason: collision with root package name */
        private int f10032l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f10033m;

        /* renamed from: n, reason: collision with root package name */
        private int f10034n;

        private void M() {
            int i5 = this.f10028h + this.f10029i;
            this.f10028h = i5;
            int i6 = i5 - this.f10031k;
            int i7 = this.f10034n;
            if (i6 <= i7) {
                this.f10029i = 0;
                return;
            }
            int i8 = i6 - i7;
            this.f10029i = i8;
            this.f10028h = i5 - i8;
        }

        private void P() throws B {
            if (this.f10028h - this.f10030j >= 10) {
                Q();
            } else {
                R();
            }
        }

        private void Q() throws B {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.f10026f;
                int i6 = this.f10030j;
                this.f10030j = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw B.e();
        }

        private void R() throws B {
            for (int i5 = 0; i5 < 10; i5++) {
                if (F() >= 0) {
                    return;
                }
            }
            throw B.e();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public String A() throws B {
            int iJ = J();
            if (iJ > 0) {
                int i5 = this.f10028h;
                int i6 = this.f10030j;
                if (iJ <= i5 - i6) {
                    String strE = t0.e(this.f10026f, i6, iJ);
                    this.f10030j += iJ;
                    return strE;
                }
            }
            if (iJ == 0) {
                return BuildConfig.FLAVOR;
            }
            if (iJ <= 0) {
                throw B.f();
            }
            throw B.k();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int B() throws B {
            if (e()) {
                this.f10032l = 0;
                return 0;
            }
            int iJ = J();
            this.f10032l = iJ;
            if (u0.a(iJ) != 0) {
                return this.f10032l;
            }
            throw B.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int C() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long D() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean E(int i5) throws B {
            int iB = u0.b(i5);
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
                a(u0.c(u0.a(i5), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw B.d();
            }
            O(4);
            return true;
        }

        public byte F() throws B {
            int i5 = this.f10030j;
            if (i5 == this.f10028h) {
                throw B.k();
            }
            byte[] bArr = this.f10026f;
            this.f10030j = i5 + 1;
            return bArr[i5];
        }

        public byte[] G(int i5) throws B {
            if (i5 > 0) {
                int i6 = this.f10028h;
                int i7 = this.f10030j;
                if (i5 <= i6 - i7) {
                    int i8 = i5 + i7;
                    this.f10030j = i8;
                    return Arrays.copyOfRange(this.f10026f, i7, i8);
                }
            }
            if (i5 > 0) {
                throw B.k();
            }
            if (i5 == 0) {
                return A.f9907c;
            }
            throw B.f();
        }

        public int H() throws B {
            int i5 = this.f10030j;
            if (this.f10028h - i5 < 4) {
                throw B.k();
            }
            byte[] bArr = this.f10026f;
            this.f10030j = i5 + 4;
            return (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24);
        }

        public long I() throws B {
            int i5 = this.f10030j;
            if (this.f10028h - i5 < 8) {
                throw B.k();
            }
            byte[] bArr = this.f10026f;
            this.f10030j = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        public int J() {
            int i5;
            int i6 = this.f10030j;
            int i7 = this.f10028h;
            if (i7 != i6) {
                byte[] bArr = this.f10026f;
                int i8 = i6 + 1;
                byte b6 = bArr[i6];
                if (b6 >= 0) {
                    this.f10030j = i8;
                    return b6;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b6;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b7 = bArr[i13];
                                int i15 = (i14 ^ (b7 << 28)) ^ 266354560;
                                if (b7 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.f10030j = i9;
                    return i5;
                }
            }
            return (int) L();
        }

        public long K() {
            long j5;
            long j6;
            long j7;
            int i5 = this.f10030j;
            int i6 = this.f10028h;
            if (i6 != i5) {
                byte[] bArr = this.f10026f;
                int i7 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 >= 0) {
                    this.f10030j = i7;
                    return b6;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b6;
                    if (i9 < 0) {
                        j5 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j5 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j8 = (-2080896) ^ i13;
                                i8 = i12;
                                j5 = j8;
                            } else {
                                long j9 = i13;
                                i8 = i5 + 5;
                                long j10 = j9 ^ (bArr[i12] << 28);
                                if (j10 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j11 = j10 ^ (bArr[i8] << 35);
                                    if (j11 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j10 = j11 ^ (bArr[i14] << 42);
                                        if (j10 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j11 = j10 ^ (bArr[i8] << 49);
                                            if (j11 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j12 = (j11 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                if (j12 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j5 = j12;
                                            }
                                        }
                                    }
                                    j5 = j11 ^ j6;
                                    i8 = i14;
                                }
                                j5 = j10 ^ j7;
                            }
                        }
                    }
                    this.f10030j = i8;
                    return j5;
                }
            }
            return L();
        }

        long L() throws B {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                j5 |= (r3 & 127) << i5;
                if ((F() & 128) == 0) {
                    return j5;
                }
            }
            throw B.e();
        }

        public void N() throws B {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void O(int i5) throws B {
            if (i5 >= 0) {
                int i6 = this.f10028h;
                int i7 = this.f10030j;
                if (i5 <= i6 - i7) {
                    this.f10030j = i7 + i5;
                    return;
                }
            }
            if (i5 >= 0) {
                throw B.k();
            }
            throw B.f();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public void a(int i5) throws B {
            if (this.f10032l != i5) {
                throw B.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int d() {
            return this.f10030j - this.f10031k;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean e() {
            return this.f10030j == this.f10028h;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public void k(int i5) {
            this.f10034n = i5;
            M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int l(int i5) throws B {
            if (i5 < 0) {
                throw B.f();
            }
            int iD = i5 + d();
            int i6 = this.f10034n;
            if (iD > i6) {
                throw B.k();
            }
            this.f10034n = iD;
            M();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean m() {
            return K() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public AbstractC0488h n() {
            int iJ = J();
            if (iJ > 0) {
                int i5 = this.f10028h;
                int i6 = this.f10030j;
                if (iJ <= i5 - i6) {
                    AbstractC0488h abstractC0488hD = (this.f10027g && this.f10033m) ? AbstractC0488h.D(this.f10026f, i6, iJ) : AbstractC0488h.m(this.f10026f, i6, iJ);
                    this.f10030j += iJ;
                    return abstractC0488hD;
                }
            }
            return iJ == 0 ? AbstractC0488h.f10009b : AbstractC0488h.C(G(iJ));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public double o() {
            return Double.longBitsToDouble(I());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int p() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int q() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long r() {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public float s() {
            return Float.intBitsToFloat(H());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int t() {
            return J();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long u() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int v() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long w() {
            return I();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int x() {
            return AbstractC0489i.b(J());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long y() {
            return AbstractC0489i.c(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public String z() throws B {
            int iJ = J();
            if (iJ > 0) {
                int i5 = this.f10028h;
                int i6 = this.f10030j;
                if (iJ <= i5 - i6) {
                    String str = new String(this.f10026f, i6, iJ, A.f9905a);
                    this.f10030j += iJ;
                    return str;
                }
            }
            if (iJ == 0) {
                return BuildConfig.FLAVOR;
            }
            if (iJ < 0) {
                throw B.f();
            }
            throw B.k();
        }

        private b(byte[] bArr, int i5, int i6, boolean z5) {
            super();
            this.f10034n = Integer.MAX_VALUE;
            this.f10026f = bArr;
            this.f10028h = i6 + i5;
            this.f10030j = i5;
            this.f10031k = i5;
            this.f10027g = z5;
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.i$c */
    private static final class c extends AbstractC0489i {

        /* renamed from: f, reason: collision with root package name */
        private final InputStream f10035f;

        /* renamed from: g, reason: collision with root package name */
        private final byte[] f10036g;

        /* renamed from: h, reason: collision with root package name */
        private int f10037h;

        /* renamed from: i, reason: collision with root package name */
        private int f10038i;

        /* renamed from: j, reason: collision with root package name */
        private int f10039j;

        /* renamed from: k, reason: collision with root package name */
        private int f10040k;

        /* renamed from: l, reason: collision with root package name */
        private int f10041l;

        /* renamed from: m, reason: collision with root package name */
        private int f10042m;

        private AbstractC0488h F(int i5) throws IOException {
            byte[] bArrI = I(i5);
            if (bArrI != null) {
                return AbstractC0488h.i(bArrI);
            }
            int i6 = this.f10039j;
            int i7 = this.f10037h;
            int length = i7 - i6;
            this.f10041l += i7;
            this.f10039j = 0;
            this.f10037h = 0;
            List<byte[]> listJ = J(i5 - length);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f10036g, i6, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return AbstractC0488h.C(bArr);
        }

        private byte[] H(int i5, boolean z5) throws IOException {
            byte[] bArrI = I(i5);
            if (bArrI != null) {
                return z5 ? (byte[]) bArrI.clone() : bArrI;
            }
            int i6 = this.f10039j;
            int i7 = this.f10037h;
            int length = i7 - i6;
            this.f10041l += i7;
            this.f10039j = 0;
            this.f10037h = 0;
            List<byte[]> listJ = J(i5 - length);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f10036g, i6, bArr, 0, length);
            for (byte[] bArr2 : listJ) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] I(int i5) throws IOException {
            if (i5 == 0) {
                return A.f9907c;
            }
            if (i5 < 0) {
                throw B.f();
            }
            int i6 = this.f10041l;
            int i7 = this.f10039j;
            int i8 = i6 + i7 + i5;
            if (i8 - this.f10023c > 0) {
                throw B.j();
            }
            int i9 = this.f10042m;
            if (i8 > i9) {
                S((i9 - i6) - i7);
                throw B.k();
            }
            int i10 = this.f10037h - i7;
            int i11 = i5 - i10;
            if (i11 >= 4096 && i11 > this.f10035f.available()) {
                return null;
            }
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f10036g, this.f10039j, bArr, 0, i10);
            this.f10041l += this.f10037h;
            this.f10039j = 0;
            this.f10037h = 0;
            while (i10 < i5) {
                int i12 = this.f10035f.read(bArr, i10, i5 - i10);
                if (i12 == -1) {
                    throw B.k();
                }
                this.f10041l += i12;
                i10 += i12;
            }
            return bArr;
        }

        private List<byte[]> J(int i5) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i5 > 0) {
                int iMin = Math.min(i5, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
                byte[] bArr = new byte[iMin];
                int i6 = 0;
                while (i6 < iMin) {
                    int i7 = this.f10035f.read(bArr, i6, iMin - i6);
                    if (i7 == -1) {
                        throw B.k();
                    }
                    this.f10041l += i7;
                    i6 += i7;
                }
                i5 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void P() {
            int i5 = this.f10037h + this.f10038i;
            this.f10037h = i5;
            int i6 = this.f10041l + i5;
            int i7 = this.f10042m;
            if (i6 <= i7) {
                this.f10038i = 0;
                return;
            }
            int i8 = i6 - i7;
            this.f10038i = i8;
            this.f10037h = i5 - i8;
        }

        private void Q(int i5) throws B {
            if (X(i5)) {
                return;
            }
            if (i5 <= (this.f10023c - this.f10041l) - this.f10039j) {
                throw B.k();
            }
            throw B.j();
        }

        private void T(int i5) throws B {
            if (i5 < 0) {
                throw B.f();
            }
            int i6 = this.f10041l;
            int i7 = this.f10039j;
            int i8 = i6 + i7 + i5;
            int i9 = this.f10042m;
            if (i8 > i9) {
                S((i9 - i6) - i7);
                throw B.k();
            }
            this.f10041l = i6 + i7;
            int i10 = this.f10037h - i7;
            this.f10037h = 0;
            this.f10039j = 0;
            while (i10 < i5) {
                try {
                    long j5 = i5 - i10;
                    long jSkip = this.f10035f.skip(j5);
                    if (jSkip < 0 || jSkip > j5) {
                        throw new IllegalStateException(this.f10035f.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i10 += (int) jSkip;
                    }
                } finally {
                    this.f10041l += i10;
                    P();
                }
            }
            if (i10 >= i5) {
                return;
            }
            int i11 = this.f10037h;
            int i12 = i11 - this.f10039j;
            this.f10039j = i11;
            Q(1);
            while (true) {
                int i13 = i5 - i12;
                int i14 = this.f10037h;
                if (i13 <= i14) {
                    this.f10039j = i13;
                    return;
                } else {
                    i12 += i14;
                    this.f10039j = i14;
                    Q(1);
                }
            }
        }

        private void U() throws B {
            if (this.f10037h - this.f10039j >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws B {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.f10036g;
                int i6 = this.f10039j;
                this.f10039j = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw B.e();
        }

        private void W() throws B {
            for (int i5 = 0; i5 < 10; i5++) {
                if (G() >= 0) {
                    return;
                }
            }
            throw B.e();
        }

        private boolean X(int i5) throws IOException {
            int i6 = this.f10039j;
            int i7 = i6 + i5;
            int i8 = this.f10037h;
            if (i7 <= i8) {
                throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
            }
            int i9 = this.f10023c;
            int i10 = this.f10041l;
            if (i5 > (i9 - i10) - i6 || i10 + i6 + i5 > this.f10042m) {
                return false;
            }
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.f10036g;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                this.f10041l += i6;
                this.f10037h -= i6;
                this.f10039j = 0;
            }
            InputStream inputStream = this.f10035f;
            byte[] bArr2 = this.f10036g;
            int i11 = this.f10037h;
            int i12 = inputStream.read(bArr2, i11, Math.min(bArr2.length - i11, (this.f10023c - this.f10041l) - i11));
            if (i12 == 0 || i12 < -1 || i12 > this.f10036g.length) {
                throw new IllegalStateException(this.f10035f.getClass() + "#read(byte[]) returned invalid result: " + i12 + "\nThe InputStream implementation is buggy.");
            }
            if (i12 <= 0) {
                return false;
            }
            this.f10037h += i12;
            P();
            if (this.f10037h >= i5) {
                return true;
            }
            return X(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public String A() throws IOException {
            byte[] bArrH;
            int iM = M();
            int i5 = this.f10039j;
            int i6 = this.f10037h;
            if (iM <= i6 - i5 && iM > 0) {
                bArrH = this.f10036g;
                this.f10039j = i5 + iM;
            } else {
                if (iM == 0) {
                    return BuildConfig.FLAVOR;
                }
                i5 = 0;
                if (iM <= i6) {
                    Q(iM);
                    bArrH = this.f10036g;
                    this.f10039j = iM;
                } else {
                    bArrH = H(iM, false);
                }
            }
            return t0.e(bArrH, i5, iM);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int B() throws B {
            if (e()) {
                this.f10040k = 0;
                return 0;
            }
            int iM = M();
            this.f10040k = iM;
            if (u0.a(iM) != 0) {
                return this.f10040k;
            }
            throw B.b();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int C() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long D() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean E(int i5) throws B {
            int iB = u0.b(i5);
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
                a(u0.c(u0.a(i5), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw B.d();
            }
            S(4);
            return true;
        }

        public byte G() throws B {
            if (this.f10039j == this.f10037h) {
                Q(1);
            }
            byte[] bArr = this.f10036g;
            int i5 = this.f10039j;
            this.f10039j = i5 + 1;
            return bArr[i5];
        }

        public int K() throws B {
            int i5 = this.f10039j;
            if (this.f10037h - i5 < 4) {
                Q(4);
                i5 = this.f10039j;
            }
            byte[] bArr = this.f10036g;
            this.f10039j = i5 + 4;
            return (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24);
        }

        public long L() throws B {
            int i5 = this.f10039j;
            if (this.f10037h - i5 < 8) {
                Q(8);
                i5 = this.f10039j;
            }
            byte[] bArr = this.f10036g;
            this.f10039j = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        public int M() {
            int i5;
            int i6 = this.f10039j;
            int i7 = this.f10037h;
            if (i7 != i6) {
                byte[] bArr = this.f10036g;
                int i8 = i6 + 1;
                byte b6 = bArr[i6];
                if (b6 >= 0) {
                    this.f10039j = i8;
                    return b6;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b6;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b7 = bArr[i13];
                                int i15 = (i14 ^ (b7 << 28)) ^ 266354560;
                                if (b7 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.f10039j = i9;
                    return i5;
                }
            }
            return (int) O();
        }

        public long N() {
            long j5;
            long j6;
            long j7;
            int i5 = this.f10039j;
            int i6 = this.f10037h;
            if (i6 != i5) {
                byte[] bArr = this.f10036g;
                int i7 = i5 + 1;
                byte b6 = bArr[i5];
                if (b6 >= 0) {
                    this.f10039j = i7;
                    return b6;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b6;
                    if (i9 < 0) {
                        j5 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j5 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j8 = (-2080896) ^ i13;
                                i8 = i12;
                                j5 = j8;
                            } else {
                                long j9 = i13;
                                i8 = i5 + 5;
                                long j10 = j9 ^ (bArr[i12] << 28);
                                if (j10 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j11 = j10 ^ (bArr[i8] << 35);
                                    if (j11 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j10 = j11 ^ (bArr[i14] << 42);
                                        if (j10 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j11 = j10 ^ (bArr[i8] << 49);
                                            if (j11 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j12 = (j11 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                if (j12 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j5 = j12;
                                            }
                                        }
                                    }
                                    j5 = j11 ^ j6;
                                    i8 = i14;
                                }
                                j5 = j10 ^ j7;
                            }
                        }
                    }
                    this.f10039j = i8;
                    return j5;
                }
            }
            return O();
        }

        long O() throws B {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                j5 |= (r3 & 127) << i5;
                if ((G() & 128) == 0) {
                    return j5;
                }
            }
            throw B.e();
        }

        public void R() throws B {
            int iB;
            do {
                iB = B();
                if (iB == 0) {
                    return;
                }
            } while (E(iB));
        }

        public void S(int i5) throws B {
            int i6 = this.f10037h;
            int i7 = this.f10039j;
            if (i5 > i6 - i7 || i5 < 0) {
                T(i5);
            } else {
                this.f10039j = i7 + i5;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public void a(int i5) throws B {
            if (this.f10040k != i5) {
                throw B.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int d() {
            return this.f10041l + this.f10039j;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean e() {
            return this.f10039j == this.f10037h && !X(1);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public void k(int i5) {
            this.f10042m = i5;
            P();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int l(int i5) throws B {
            if (i5 < 0) {
                throw B.f();
            }
            int i6 = i5 + this.f10041l + this.f10039j;
            int i7 = this.f10042m;
            if (i6 > i7) {
                throw B.k();
            }
            this.f10042m = i6;
            P();
            return i7;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public boolean m() {
            return N() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public AbstractC0488h n() {
            int iM = M();
            int i5 = this.f10037h;
            int i6 = this.f10039j;
            if (iM > i5 - i6 || iM <= 0) {
                return iM == 0 ? AbstractC0488h.f10009b : F(iM);
            }
            AbstractC0488h abstractC0488hM = AbstractC0488h.m(this.f10036g, i6, iM);
            this.f10039j += iM;
            return abstractC0488hM;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public double o() {
            return Double.longBitsToDouble(L());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int p() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int q() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long r() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public float s() {
            return Float.intBitsToFloat(K());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int t() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long u() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int v() {
            return K();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long w() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public int x() {
            return AbstractC0489i.b(M());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public long y() {
            return AbstractC0489i.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0489i
        public String z() throws B {
            int iM = M();
            if (iM > 0) {
                int i5 = this.f10037h;
                int i6 = this.f10039j;
                if (iM <= i5 - i6) {
                    String str = new String(this.f10036g, i6, iM, A.f9905a);
                    this.f10039j += iM;
                    return str;
                }
            }
            if (iM == 0) {
                return BuildConfig.FLAVOR;
            }
            if (iM > this.f10037h) {
                return new String(H(iM, false), A.f9905a);
            }
            Q(iM);
            String str2 = new String(this.f10036g, this.f10039j, iM, A.f9905a);
            this.f10039j += iM;
            return str2;
        }

        private c(InputStream inputStream, int i5) {
            super();
            this.f10042m = Integer.MAX_VALUE;
            A.b(inputStream, "input");
            this.f10035f = inputStream;
            this.f10036g = new byte[i5];
            this.f10037h = 0;
            this.f10039j = 0;
            this.f10041l = 0;
        }
    }

    public static int b(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long c(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static AbstractC0489i f(InputStream inputStream) {
        return g(inputStream, RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT);
    }

    public static AbstractC0489i g(InputStream inputStream, int i5) {
        if (i5 > 0) {
            return inputStream == null ? h(A.f9907c) : new c(inputStream, i5);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static AbstractC0489i h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public static AbstractC0489i i(byte[] bArr, int i5, int i6) {
        return j(bArr, i5, i6, false);
    }

    static AbstractC0489i j(byte[] bArr, int i5, int i6, boolean z5) {
        b bVar = new b(bArr, i5, i6, z5);
        try {
            bVar.l(i6);
            return bVar;
        } catch (B e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    public abstract String A();

    public abstract int B();

    public abstract int C();

    public abstract long D();

    public abstract boolean E(int i5);

    public abstract void a(int i5);

    public abstract int d();

    public abstract boolean e();

    public abstract void k(int i5);

    public abstract int l(int i5);

    public abstract boolean m();

    public abstract AbstractC0488h n();

    public abstract double o();

    public abstract int p();

    public abstract int q();

    public abstract long r();

    public abstract float s();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract long w();

    public abstract int x();

    public abstract long y();

    public abstract String z();

    private AbstractC0489i() {
        this.f10022b = 100;
        this.f10023c = Integer.MAX_VALUE;
        this.f10025e = false;
    }
}
