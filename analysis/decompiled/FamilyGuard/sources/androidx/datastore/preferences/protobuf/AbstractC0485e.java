package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.B;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.u0;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;

/* renamed from: androidx.datastore.preferences.protobuf.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0485e implements g0 {

    /* renamed from: androidx.datastore.preferences.protobuf.e$a */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9991a;

        static {
            int[] iArr = new int[u0.b.values().length];
            f9991a = iArr;
            try {
                iArr[u0.b.f10164j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9991a[u0.b.f10168n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9991a[u0.b.f10157c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9991a[u0.b.f10170p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9991a[u0.b.f10163i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9991a[u0.b.f10162h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9991a[u0.b.f10158d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9991a[u0.b.f10161g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9991a[u0.b.f10159e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9991a[u0.b.f10167m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9991a[u0.b.f10171q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9991a[u0.b.f10172r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9991a[u0.b.f10173s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9991a[u0.b.f10174t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9991a[u0.b.f10165k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9991a[u0.b.f10169o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9991a[u0.b.f10160f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.e$b */
    private static final class b extends AbstractC0485e {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f9992a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f9993b;

        /* renamed from: c, reason: collision with root package name */
        private int f9994c;

        /* renamed from: d, reason: collision with root package name */
        private final int f9995d;

        /* renamed from: e, reason: collision with root package name */
        private int f9996e;

        /* renamed from: f, reason: collision with root package name */
        private int f9997f;

        /* renamed from: g, reason: collision with root package name */
        private int f9998g;

        public b(ByteBuffer byteBuffer, boolean z5) {
            super(null);
            this.f9992a = z5;
            this.f9993b = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f9994c = iArrayOffset;
            this.f9995d = iArrayOffset;
            this.f9996e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            return this.f9994c == this.f9996e;
        }

        private byte S() throws B {
            int i5 = this.f9994c;
            if (i5 == this.f9996e) {
                throw B.k();
            }
            byte[] bArr = this.f9993b;
            this.f9994c = i5 + 1;
            return bArr[i5];
        }

        private Object T(u0.b bVar, Class<?> cls, C0496p c0496p) {
            switch (a.f9991a[bVar.ordinal()]) {
                case 1:
                    return Boolean.valueOf(k());
                case 2:
                    return D();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(u());
                case 5:
                    return Integer.valueOf(j());
                case 6:
                    return Long.valueOf(e());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(F());
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    return Long.valueOf(M());
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    return f(cls, c0496p);
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    return Integer.valueOf(I());
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    return Long.valueOf(l());
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    return Integer.valueOf(w());
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    return Long.valueOf(x());
                case 15:
                    return N();
                case 16:
                    return Integer.valueOf(o());
                case 17:
                    return Long.valueOf(d());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T U(h0<T> h0Var, C0496p c0496p) {
            int i5 = this.f9998g;
            this.f9998g = u0.c(u0.a(this.f9997f), 4);
            try {
                T tH = h0Var.h();
                h0Var.b(tH, this, c0496p);
                h0Var.c(tH);
                if (this.f9997f == this.f9998g) {
                    return tH;
                }
                throw B.g();
            } finally {
                this.f9998g = i5;
            }
        }

        private int V() throws B {
            f0(4);
            return W();
        }

        private int W() {
            int i5 = this.f9994c;
            byte[] bArr = this.f9993b;
            this.f9994c = i5 + 4;
            return (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24);
        }

        private long X() throws B {
            f0(8);
            return Y();
        }

        private long Y() {
            int i5 = this.f9994c;
            byte[] bArr = this.f9993b;
            this.f9994c = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        private <T> T Z(h0<T> h0Var, C0496p c0496p) throws B {
            int iC0 = c0();
            f0(iC0);
            int i5 = this.f9996e;
            int i6 = this.f9994c + iC0;
            this.f9996e = i6;
            try {
                T tH = h0Var.h();
                h0Var.b(tH, this, c0496p);
                h0Var.c(tH);
                if (this.f9994c == i6) {
                    return tH;
                }
                throw B.g();
            } finally {
                this.f9996e = i5;
            }
        }

        private int c0() throws B {
            int i5;
            int i6 = this.f9994c;
            int i7 = this.f9996e;
            if (i7 == i6) {
                throw B.k();
            }
            byte[] bArr = this.f9993b;
            int i8 = i6 + 1;
            byte b6 = bArr[i6];
            if (b6 >= 0) {
                this.f9994c = i8;
                return b6;
            }
            if (i7 - i8 < 9) {
                return (int) e0();
            }
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
                                            if (bArr[i11] < 0) {
                                                throw B.e();
                                            }
                                            i9 = i16;
                                            i5 = i15;
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
            this.f9994c = i9;
            return i5;
        }

        private long e0() throws B {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                j5 |= (r3 & 127) << i5;
                if ((S() & 128) == 0) {
                    return j5;
                }
            }
            throw B.e();
        }

        private void f0(int i5) throws B {
            if (i5 < 0 || i5 > this.f9996e - this.f9994c) {
                throw B.k();
            }
        }

        private void g0(int i5) throws B {
            if (this.f9994c != i5) {
                throw B.k();
            }
        }

        private void h0(int i5) throws B.a {
            if (u0.b(this.f9997f) != i5) {
                throw B.d();
            }
        }

        private void i0(int i5) throws B {
            f0(i5);
            this.f9994c += i5;
        }

        private void j0() throws B {
            int i5 = this.f9998g;
            this.f9998g = u0.c(u0.a(this.f9997f), 4);
            while (A() != Integer.MAX_VALUE && H()) {
            }
            if (this.f9997f != this.f9998g) {
                throw B.g();
            }
            this.f9998g = i5;
        }

        private void k0() throws B {
            int i5 = this.f9996e;
            int i6 = this.f9994c;
            if (i5 - i6 >= 10) {
                byte[] bArr = this.f9993b;
                int i7 = 0;
                while (i7 < 10) {
                    int i8 = i6 + 1;
                    if (bArr[i6] >= 0) {
                        this.f9994c = i8;
                        return;
                    } else {
                        i7++;
                        i6 = i8;
                    }
                }
            }
            l0();
        }

        private void l0() throws B {
            for (int i5 = 0; i5 < 10; i5++) {
                if (S() >= 0) {
                    return;
                }
            }
            throw B.e();
        }

        private void m0(int i5) throws B {
            f0(i5);
            if ((i5 & 3) != 0) {
                throw B.g();
            }
        }

        private void n0(int i5) throws B {
            f0(i5);
            if ((i5 & 7) != 0) {
                throw B.g();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int A() throws B {
            if (R()) {
                return Integer.MAX_VALUE;
            }
            int iC0 = c0();
            this.f9997f = iC0;
            if (iC0 == this.f9998g) {
                return Integer.MAX_VALUE;
            }
            return u0.a(iC0);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void B(List<String> list) throws B.a {
            b0(list, false);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void C(List<String> list) throws B.a {
            b0(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public AbstractC0488h D() throws B {
            h0(2);
            int iC0 = c0();
            if (iC0 == 0) {
                return AbstractC0488h.f10009b;
            }
            f0(iC0);
            AbstractC0488h abstractC0488hD = this.f9992a ? AbstractC0488h.D(this.f9993b, this.f9994c, iC0) : AbstractC0488h.m(this.f9993b, this.f9994c, iC0);
            this.f9994c += iC0;
            return abstractC0488hD;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void E(List<Float> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0502w)) {
                int iB = u0.b(this.f9997f);
                if (iB == 2) {
                    int iC0 = c0();
                    m0(iC0);
                    int i7 = this.f9994c + iC0;
                    while (this.f9994c < i7) {
                        list.add(Float.valueOf(Float.intBitsToFloat(W())));
                    }
                    return;
                }
                if (iB != 5) {
                    throw B.d();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0502w c0502w = (C0502w) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 2) {
                int iC02 = c0();
                m0(iC02);
                int i8 = this.f9994c + iC02;
                while (this.f9994c < i8) {
                    c0502w.h(Float.intBitsToFloat(W()));
                }
                return;
            }
            if (iB2 != 5) {
                throw B.d();
            }
            do {
                c0502w.h(readFloat());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int F() throws B.a {
            h0(0);
            return c0();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> void G(List<T> list, h0<T> h0Var, C0496p c0496p) throws B.a {
            int i5;
            if (u0.b(this.f9997f) != 3) {
                throw B.d();
            }
            int i6 = this.f9997f;
            do {
                list.add(U(h0Var, c0496p));
                if (R()) {
                    return;
                } else {
                    i5 = this.f9994c;
                }
            } while (c0() == i6);
            this.f9994c = i5;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public boolean H() throws B {
            int i5;
            if (R() || (i5 = this.f9997f) == this.f9998g) {
                return false;
            }
            int iB = u0.b(i5);
            if (iB == 0) {
                k0();
                return true;
            }
            if (iB == 1) {
                i0(8);
                return true;
            }
            if (iB == 2) {
                i0(c0());
                return true;
            }
            if (iB == 3) {
                j0();
                return true;
            }
            if (iB != 5) {
                throw B.d();
            }
            i0(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int I() throws B.a {
            h0(5);
            return V();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void J(List<AbstractC0488h> list) throws B.a {
            int i5;
            if (u0.b(this.f9997f) != 2) {
                throw B.d();
            }
            do {
                list.add(D());
                if (R()) {
                    return;
                } else {
                    i5 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i5;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void K(List<Double> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0493m)) {
                int iB = u0.b(this.f9997f);
                if (iB == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = c0();
                n0(iC0);
                int i7 = this.f9994c + iC0;
                while (this.f9994c < i7) {
                    list.add(Double.valueOf(Double.longBitsToDouble(Y())));
                }
                return;
            }
            C0493m c0493m = (C0493m) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 1) {
                do {
                    c0493m.h(readDouble());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = c0();
            n0(iC02);
            int i8 = this.f9994c + iC02;
            while (this.f9994c < i8) {
                c0493m.h(Double.longBitsToDouble(Y()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> void L(List<T> list, h0<T> h0Var, C0496p c0496p) throws B.a {
            int i5;
            if (u0.b(this.f9997f) != 2) {
                throw B.d();
            }
            int i6 = this.f9997f;
            do {
                list.add(Z(h0Var, c0496p));
                if (R()) {
                    return;
                } else {
                    i5 = this.f9994c;
                }
            } while (c0() == i6);
            this.f9994c = i5;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public long M() throws B.a {
            h0(0);
            return d0();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public String N() {
            return a0(true);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void O(List<Long> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof I)) {
                int iB = u0.b(this.f9997f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(e()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = c0();
                n0(iC0);
                int i7 = this.f9994c + iC0;
                while (this.f9994c < i7) {
                    list.add(Long.valueOf(Y()));
                }
                return;
            }
            I i8 = (I) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 1) {
                do {
                    i8.i(e());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = c0();
            n0(iC02);
            int i9 = this.f9994c + iC02;
            while (this.f9994c < i9) {
                i8.i(Y());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> T P(h0<T> h0Var, C0496p c0496p) throws B.a {
            h0(3);
            return (T) U(h0Var, c0496p);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int a() {
            return this.f9997f;
        }

        public String a0(boolean z5) throws B {
            h0(2);
            int iC0 = c0();
            if (iC0 == 0) {
                return BuildConfig.FLAVOR;
            }
            f0(iC0);
            if (z5) {
                byte[] bArr = this.f9993b;
                int i5 = this.f9994c;
                if (!t0.n(bArr, i5, i5 + iC0)) {
                    throw B.c();
                }
            }
            String str = new String(this.f9993b, this.f9994c, iC0, A.f9905a);
            this.f9994c += iC0;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> T b(h0<T> h0Var, C0496p c0496p) throws B.a {
            h0(2);
            return (T) Z(h0Var, c0496p);
        }

        public void b0(List<String> list, boolean z5) throws B.a {
            int i5;
            int i6;
            if (u0.b(this.f9997f) != 2) {
                throw B.d();
            }
            if (!(list instanceof G) || z5) {
                do {
                    list.add(a0(z5));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            G g5 = (G) list;
            do {
                g5.e(D());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void c(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw B.d();
                    }
                    int iC0 = this.f9994c + c0();
                    while (this.f9994c < iC0) {
                        list.add(Integer.valueOf(AbstractC0489i.b(c0())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(w()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw B.d();
                }
                int iC02 = this.f9994c + c0();
                while (this.f9994c < iC02) {
                    c0505z.h(AbstractC0489i.b(c0()));
                }
                return;
            }
            do {
                c0505z.h(w());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public long d() throws B.a {
            h0(0);
            return d0();
        }

        public long d0() throws B {
            long j5;
            long j6;
            long j7;
            int i5 = this.f9994c;
            int i6 = this.f9996e;
            if (i6 == i5) {
                throw B.k();
            }
            byte[] bArr = this.f9993b;
            int i7 = i5 + 1;
            byte b6 = bArr[i5];
            if (b6 >= 0) {
                this.f9994c = i7;
                return b6;
            }
            if (i6 - i7 < 9) {
                return e0();
            }
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
                                            if (bArr[i8] < 0) {
                                                throw B.e();
                                            }
                                            i8 = i15;
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
            this.f9994c = i8;
            return j5;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public long e() throws B.a {
            h0(1);
            return X();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> T f(Class<T> cls, C0496p c0496p) throws B.a {
            h0(2);
            return (T) Z(d0.a().d(cls), c0496p);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void g(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB == 2) {
                    int iC0 = c0();
                    m0(iC0);
                    int i7 = this.f9994c + iC0;
                    while (this.f9994c < i7) {
                        list.add(Integer.valueOf(W()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw B.d();
                }
                do {
                    list.add(Integer.valueOf(I()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 2) {
                int iC02 = c0();
                m0(iC02);
                int i8 = this.f9994c + iC02;
                while (this.f9994c < i8) {
                    c0505z.h(W());
                }
                return;
            }
            if (iB2 != 5) {
                throw B.d();
            }
            do {
                c0505z.h(I());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void h(List<Long> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof I)) {
                int iB = u0.b(this.f9997f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw B.d();
                    }
                    int iC0 = this.f9994c + c0();
                    while (this.f9994c < iC0) {
                        list.add(Long.valueOf(AbstractC0489i.c(d0())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(x()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            I i7 = (I) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw B.d();
                }
                int iC02 = this.f9994c + c0();
                while (this.f9994c < iC02) {
                    i7.i(AbstractC0489i.c(d0()));
                }
                return;
            }
            do {
                i7.i(x());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void i(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw B.d();
                    }
                    int iC0 = this.f9994c + c0();
                    while (this.f9994c < iC0) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(o()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw B.d();
                }
                int iC02 = this.f9994c + c0();
                while (this.f9994c < iC02) {
                    c0505z.h(c0());
                }
                return;
            }
            do {
                c0505z.h(o());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int j() throws B.a {
            h0(5);
            return V();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public boolean k() throws B.a {
            h0(0);
            return c0() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public long l() throws B.a {
            h0(1);
            return X();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void m(List<Long> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof I)) {
                int iB = u0.b(this.f9997f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(d()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = this.f9994c + c0();
                while (this.f9994c < iC0) {
                    list.add(Long.valueOf(d0()));
                }
                g0(iC0);
                return;
            }
            I i7 = (I) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 0) {
                do {
                    i7.i(d());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = this.f9994c + c0();
            while (this.f9994c < iC02) {
                i7.i(d0());
            }
            g0(iC02);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public <T> T n(Class<T> cls, C0496p c0496p) throws B.a {
            h0(3);
            return (T) U(d0.a().d(cls), c0496p);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int o() throws B.a {
            h0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void p(List<Long> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof I)) {
                int iB = u0.b(this.f9997f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(M()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = this.f9994c + c0();
                while (this.f9994c < iC0) {
                    list.add(Long.valueOf(d0()));
                }
                g0(iC0);
                return;
            }
            I i7 = (I) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 0) {
                do {
                    i7.i(M());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = this.f9994c + c0();
            while (this.f9994c < iC02) {
                i7.i(d0());
            }
            g0(iC02);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void q(List<Long> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof I)) {
                int iB = u0.b(this.f9997f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(l()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = c0();
                n0(iC0);
                int i7 = this.f9994c + iC0;
                while (this.f9994c < i7) {
                    list.add(Long.valueOf(Y()));
                }
                return;
            }
            I i8 = (I) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 1) {
                do {
                    i8.i(l());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = c0();
            n0(iC02);
            int i9 = this.f9994c + iC02;
            while (this.f9994c < i9) {
                i8.i(Y());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void r(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB == 0) {
                    do {
                        list.add(Integer.valueOf(F()));
                        if (R()) {
                            return;
                        } else {
                            i5 = this.f9994c;
                        }
                    } while (c0() == this.f9997f);
                    this.f9994c = i5;
                    return;
                }
                if (iB != 2) {
                    throw B.d();
                }
                int iC0 = this.f9994c + c0();
                while (this.f9994c < iC0) {
                    list.add(Integer.valueOf(c0()));
                }
                g0(iC0);
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 0) {
                do {
                    c0505z.h(F());
                    if (R()) {
                        return;
                    } else {
                        i6 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i6;
                return;
            }
            if (iB2 != 2) {
                throw B.d();
            }
            int iC02 = this.f9994c + c0();
            while (this.f9994c < iC02) {
                c0505z.h(c0());
            }
            g0(iC02);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public double readDouble() throws B.a {
            h0(1);
            return Double.longBitsToDouble(X());
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public float readFloat() throws B.a {
            h0(5);
            return Float.intBitsToFloat(V());
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void s(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw B.d();
                    }
                    int iC0 = this.f9994c + c0();
                    while (this.f9994c < iC0) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(u()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw B.d();
                }
                int iC02 = this.f9994c + c0();
                while (this.f9994c < iC02) {
                    c0505z.h(c0());
                }
                return;
            }
            do {
                c0505z.h(u());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.g0
        public <K, V> void t(Map<K, V> map, K.a<K, V> aVar, C0496p c0496p) throws B {
            h0(2);
            int iC0 = c0();
            f0(iC0);
            int i5 = this.f9996e;
            this.f9996e = this.f9994c + iC0;
            try {
                Object objT = aVar.f9949b;
                Object objT2 = aVar.f9951d;
                while (true) {
                    int iA = A();
                    if (iA == Integer.MAX_VALUE) {
                        map.put(objT, objT2);
                        return;
                    }
                    if (iA == 1) {
                        objT = T(aVar.f9948a, null, null);
                    } else if (iA != 2) {
                        try {
                            if (!H()) {
                                throw new B("Unable to parse map entry.");
                            }
                        } catch (B.a unused) {
                            if (!H()) {
                                throw new B("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objT2 = T(aVar.f9950c, aVar.f9951d.getClass(), c0496p);
                    }
                }
            } finally {
                this.f9996e = i5;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int u() throws B.a {
            h0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void v(List<Integer> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0505z)) {
                int iB = u0.b(this.f9997f);
                if (iB == 2) {
                    int iC0 = c0();
                    m0(iC0);
                    int i7 = this.f9994c + iC0;
                    while (this.f9994c < i7) {
                        list.add(Integer.valueOf(W()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw B.d();
                }
                do {
                    list.add(Integer.valueOf(j()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0505z c0505z = (C0505z) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 == 2) {
                int iC02 = c0();
                m0(iC02);
                int i8 = this.f9994c + iC02;
                while (this.f9994c < i8) {
                    c0505z.h(W());
                }
                return;
            }
            if (iB2 != 5) {
                throw B.d();
            }
            do {
                c0505z.h(j());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public int w() throws B.a {
            h0(0);
            return AbstractC0489i.b(c0());
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public long x() throws B.a {
            h0(0);
            return AbstractC0489i.c(d0());
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public void y(List<Boolean> list) throws B {
            int i5;
            int i6;
            if (!(list instanceof C0486f)) {
                int iB = u0.b(this.f9997f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw B.d();
                    }
                    int iC0 = this.f9994c + c0();
                    while (this.f9994c < iC0) {
                        list.add(Boolean.valueOf(c0() != 0));
                    }
                    g0(iC0);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(k()));
                    if (R()) {
                        return;
                    } else {
                        i5 = this.f9994c;
                    }
                } while (c0() == this.f9997f);
                this.f9994c = i5;
                return;
            }
            C0486f c0486f = (C0486f) list;
            int iB2 = u0.b(this.f9997f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw B.d();
                }
                int iC02 = this.f9994c + c0();
                while (this.f9994c < iC02) {
                    c0486f.i(c0() != 0);
                }
                g0(iC02);
                return;
            }
            do {
                c0486f.i(k());
                if (R()) {
                    return;
                } else {
                    i6 = this.f9994c;
                }
            } while (c0() == this.f9997f);
            this.f9994c = i6;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        public String z() {
            return a0(false);
        }
    }

    /* synthetic */ AbstractC0485e(a aVar) {
        this();
    }

    public static AbstractC0485e Q(ByteBuffer byteBuffer, boolean z5) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z5);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private AbstractC0485e() {
    }
}
