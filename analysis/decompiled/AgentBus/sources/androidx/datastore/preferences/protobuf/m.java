package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class m extends e1 {

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f901h = Logger.getLogger(m.class.getName());

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f902i = s1.f951e;

    /* renamed from: c, reason: collision with root package name */
    public i0 f903c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f904d;

    /* renamed from: e, reason: collision with root package name */
    public final int f905e;

    /* renamed from: f, reason: collision with root package name */
    public int f906f;

    /* renamed from: g, reason: collision with root package name */
    public final OutputStream f907g;

    public m(OutputStream outputStream, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i2, 20);
        this.f904d = new byte[iMax];
        this.f905e = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.f907g = outputStream;
    }

    public static int l(int i2, g gVar) {
        return m(gVar) + s(i2);
    }

    public static int m(g gVar) {
        int size = gVar.size();
        return t(size) + size;
    }

    public static int n(int i2) {
        return s(i2) + 4;
    }

    public static int o(int i2) {
        return s(i2) + 8;
    }

    public static int p(int i2, a aVar, z0 z0Var) {
        return aVar.a(z0Var) + (s(i2) * 2);
    }

    public static int q(int i2) {
        if (i2 >= 0) {
            return t(i2);
        }
        return 10;
    }

    public static int r(String str) {
        int length;
        try {
            length = v1.b(str);
        } catch (u1 unused) {
            length = str.getBytes(y.f968a).length;
        }
        return t(length) + length;
    }

    public static int s(int i2) {
        return t(i2 << 3);
    }

    public static int t(int i2) {
        if ((i2 & (-128)) == 0) {
            return 1;
        }
        if ((i2 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i2) == 0) {
            return 3;
        }
        return (i2 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int u(long j2) {
        int i2;
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if (((-34359738368L) & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? i2 + 1 : i2;
    }

    public final void A(int i2, g gVar) throws IOException {
        L(i2, 2);
        B(gVar);
    }

    public final void B(g gVar) throws IOException {
        N(gVar.size());
        f(gVar.f853g, gVar.j(), gVar.size());
    }

    public final void C(int i2, int i10) throws IOException {
        w(14);
        i(i2, 5);
        g(i10);
    }

    public final void D(int i2) throws IOException {
        w(4);
        g(i2);
    }

    public final void E(int i2, long j2) throws IOException {
        w(18);
        i(i2, 1);
        h(j2);
    }

    public final void F(long j2) throws IOException {
        w(8);
        h(j2);
    }

    public final void G(int i2, int i10) throws IOException {
        w(20);
        i(i2, 0);
        if (i10 >= 0) {
            j(i10);
        } else {
            k(i10);
        }
    }

    public final void H(int i2) throws IOException {
        if (i2 >= 0) {
            N(i2);
        } else {
            P(i2);
        }
    }

    public final void I(int i2, a aVar, z0 z0Var) throws IOException {
        L(i2, 2);
        N(aVar.a(z0Var));
        z0Var.e(aVar, this.f903c);
    }

    public final void J(int i2, String str) throws IOException {
        L(i2, 2);
        K(str);
    }

    public final void K(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iT = t(length);
            int i2 = iT + length;
            int i10 = this.f905e;
            if (i2 > i10) {
                byte[] bArr = new byte[length];
                int iB = v1.f961a.b(0, length, str, bArr);
                N(iB);
                y(bArr, 0, iB);
                return;
            }
            if (i2 > i10 - this.f906f) {
                v();
            }
            int iT2 = t(str.length());
            int i11 = this.f906f;
            byte[] bArr2 = this.f904d;
            try {
                try {
                    if (iT2 == iT) {
                        int i12 = i11 + iT2;
                        this.f906f = i12;
                        int iB2 = v1.f961a.b(i12, i10 - i12, str, bArr2);
                        this.f906f = i11;
                        j((iB2 - i11) - iT2);
                        this.f906f = iB2;
                    } else {
                        int iB3 = v1.b(str);
                        j(iB3);
                        this.f906f = v1.f961a.b(this.f906f, iB3, str, bArr2);
                    }
                } catch (u1 e10) {
                    this.f906f = i11;
                    throw e10;
                }
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new l(e11);
            }
        } catch (u1 e12) {
            f901h.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e12);
            byte[] bytes = str.getBytes(y.f968a);
            try {
                N(bytes.length);
                f(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e13) {
                throw new l(e13);
            }
        }
    }

    public final void L(int i2, int i10) throws IOException {
        N((i2 << 3) | i10);
    }

    public final void M(int i2, int i10) throws IOException {
        w(20);
        i(i2, 0);
        j(i10);
    }

    public final void N(int i2) throws IOException {
        w(5);
        j(i2);
    }

    public final void O(int i2, long j2) throws IOException {
        w(20);
        i(i2, 0);
        k(j2);
    }

    public final void P(long j2) throws IOException {
        w(10);
        k(j2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public final void f(byte[] bArr, int i2, int i10) throws IOException {
        y(bArr, i2, i10);
    }

    public final void g(int i2) {
        int i10 = this.f906f;
        int i11 = i10 + 1;
        this.f906f = i11;
        byte[] bArr = this.f904d;
        bArr[i10] = (byte) (i2 & 255);
        int i12 = i10 + 2;
        this.f906f = i12;
        bArr[i11] = (byte) ((i2 >> 8) & 255);
        int i13 = i10 + 3;
        this.f906f = i13;
        bArr[i12] = (byte) ((i2 >> 16) & 255);
        this.f906f = i10 + 4;
        bArr[i13] = (byte) ((i2 >> 24) & 255);
    }

    public final void h(long j2) {
        int i2 = this.f906f;
        int i10 = i2 + 1;
        this.f906f = i10;
        byte[] bArr = this.f904d;
        bArr[i2] = (byte) (j2 & 255);
        int i11 = i2 + 2;
        this.f906f = i11;
        bArr[i10] = (byte) ((j2 >> 8) & 255);
        int i12 = i2 + 3;
        this.f906f = i12;
        bArr[i11] = (byte) ((j2 >> 16) & 255);
        int i13 = i2 + 4;
        this.f906f = i13;
        bArr[i12] = (byte) (255 & (j2 >> 24));
        int i14 = i2 + 5;
        this.f906f = i14;
        bArr[i13] = (byte) (((int) (j2 >> 32)) & 255);
        int i15 = i2 + 6;
        this.f906f = i15;
        bArr[i14] = (byte) (((int) (j2 >> 40)) & 255);
        int i16 = i2 + 7;
        this.f906f = i16;
        bArr[i15] = (byte) (((int) (j2 >> 48)) & 255);
        this.f906f = i2 + 8;
        bArr[i16] = (byte) (((int) (j2 >> 56)) & 255);
    }

    public final void i(int i2, int i10) {
        j((i2 << 3) | i10);
    }

    public final void j(int i2) {
        boolean z4 = f902i;
        byte[] bArr = this.f904d;
        if (z4) {
            while ((i2 & (-128)) != 0) {
                int i10 = this.f906f;
                this.f906f = i10 + 1;
                s1.k(bArr, i10, (byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            int i11 = this.f906f;
            this.f906f = i11 + 1;
            s1.k(bArr, i11, (byte) i2);
            return;
        }
        while ((i2 & (-128)) != 0) {
            int i12 = this.f906f;
            this.f906f = i12 + 1;
            bArr[i12] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
        }
        int i13 = this.f906f;
        this.f906f = i13 + 1;
        bArr[i13] = (byte) i2;
    }

    public final void k(long j2) {
        boolean z4 = f902i;
        byte[] bArr = this.f904d;
        if (z4) {
            while ((j2 & (-128)) != 0) {
                int i2 = this.f906f;
                this.f906f = i2 + 1;
                s1.k(bArr, i2, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            int i10 = this.f906f;
            this.f906f = i10 + 1;
            s1.k(bArr, i10, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i11 = this.f906f;
            this.f906f = i11 + 1;
            bArr[i11] = (byte) ((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        int i12 = this.f906f;
        this.f906f = i12 + 1;
        bArr[i12] = (byte) j2;
    }

    public final void v() throws IOException {
        this.f907g.write(this.f904d, 0, this.f906f);
        this.f906f = 0;
    }

    public final void w(int i2) throws IOException {
        if (this.f905e - this.f906f < i2) {
            v();
        }
    }

    public final void x(byte b10) throws IOException {
        if (this.f906f == this.f905e) {
            v();
        }
        int i2 = this.f906f;
        this.f906f = i2 + 1;
        this.f904d[i2] = b10;
    }

    public final void y(byte[] bArr, int i2, int i10) throws IOException {
        int i11 = this.f906f;
        int i12 = this.f905e;
        int i13 = i12 - i11;
        byte[] bArr2 = this.f904d;
        if (i13 >= i10) {
            System.arraycopy(bArr, i2, bArr2, i11, i10);
            this.f906f += i10;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i11, i13);
        int i14 = i2 + i13;
        int i15 = i10 - i13;
        this.f906f = i12;
        v();
        if (i15 > i12) {
            this.f907g.write(bArr, i14, i15);
        } else {
            System.arraycopy(bArr, i14, bArr2, 0, i15);
            this.f906f = i15;
        }
    }

    public final void z(int i2, boolean z4) throws IOException {
        w(11);
        i(i2, 0);
        byte b10 = z4 ? (byte) 1 : (byte) 0;
        int i10 = this.f906f;
        this.f906f = i10 + 1;
        this.f904d[i10] = b10;
    }
}
