package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends a.a {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f507f = Logger.getLogger(l.class.getName());

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f508g = h1.f489e;

    /* renamed from: a, reason: collision with root package name */
    public e0 f509a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f510b;

    /* renamed from: c, reason: collision with root package name */
    public final int f511c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final j0.x0 f512e;

    public l(j0.x0 x0Var, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i8, 20);
        this.f510b = new byte[iMax];
        this.f511c = iMax;
        this.f512e = x0Var;
    }

    public static int o0(int i8, g gVar) {
        int iQ0 = q0(i8);
        int size = gVar.size();
        return r0(size) + size + iQ0;
    }

    public static int p0(String str) {
        int length;
        try {
            length = k1.a(str);
        } catch (j1 unused) {
            length = str.getBytes(x.f579a).length;
        }
        return r0(length) + length;
    }

    public static int q0(int i8) {
        return r0(i8 << 3);
    }

    public static int r0(int i8) {
        return (352 - (Integer.numberOfLeadingZeros(i8) * 9)) >>> 6;
    }

    public static int s0(long j4) {
        return (640 - (Long.numberOfLeadingZeros(j4) * 9)) >>> 6;
    }

    public final void A0(int i8, int i9) {
        u0(14);
        l0(i8, 5);
        j0(i9);
    }

    public final void B0(int i8) throws IOException {
        u0(4);
        j0(i8);
    }

    public final void C0(int i8, long j4) {
        u0(18);
        l0(i8, 1);
        k0(j4);
    }

    public final void D0(long j4) throws IOException {
        u0(8);
        k0(j4);
    }

    public final void E0(int i8, int i9) throws IOException {
        u0(20);
        l0(i8, 0);
        if (i9 >= 0) {
            m0(i9);
        } else {
            n0(i9);
        }
    }

    public final void F0(int i8) throws IOException {
        if (i8 >= 0) {
            L0(i8);
        } else {
            N0(i8);
        }
    }

    public final void G0(int i8, a aVar, u0 u0Var) throws IOException {
        J0(i8, 2);
        L0(aVar.a(u0Var));
        u0Var.e(aVar, this.f509a);
    }

    public final void H0(int i8, String str) throws IOException {
        J0(i8, 2);
        I0(str);
    }

    public final void I0(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iR0 = r0(length);
            int i8 = iR0 + length;
            int i9 = this.f511c;
            if (i8 > i9) {
                byte[] bArr = new byte[length];
                int iM = k1.f506a.m(str, bArr, 0, length);
                L0(iM);
                w0(bArr, 0, iM);
                return;
            }
            if (i8 > i9 - this.d) {
                t0();
            }
            int iR02 = r0(str.length());
            int i10 = this.d;
            byte[] bArr2 = this.f510b;
            try {
                if (iR02 == iR0) {
                    int i11 = i10 + iR02;
                    this.d = i11;
                    int iM2 = k1.f506a.m(str, bArr2, i11, i9 - i11);
                    this.d = i10;
                    m0((iM2 - i10) - iR02);
                    this.d = iM2;
                } else {
                    int iA = k1.a(str);
                    m0(iA);
                    this.d = k1.f506a.m(str, bArr2, this.d, iA);
                }
            } catch (j1 e9) {
                this.d = i10;
                throw e9;
            } catch (ArrayIndexOutOfBoundsException e10) {
                throw new k(e10);
            }
        } catch (j1 e11) {
            f507f.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e11);
            byte[] bytes = str.getBytes(x.f579a);
            try {
                L0(bytes.length);
                i0(0, bytes.length, bytes);
            } catch (IndexOutOfBoundsException e12) {
                throw new k(e12);
            }
        }
    }

    public final void J0(int i8, int i9) {
        L0((i8 << 3) | i9);
    }

    public final void K0(int i8, int i9) throws IOException {
        u0(20);
        l0(i8, 0);
        m0(i9);
    }

    public final void L0(int i8) throws IOException {
        u0(5);
        m0(i8);
    }

    public final void M0(int i8, long j4) {
        u0(20);
        l0(i8, 0);
        n0(j4);
    }

    public final void N0(long j4) throws IOException {
        u0(10);
        n0(j4);
    }

    @Override // a.a
    public final void i0(int i8, int i9, byte[] bArr) throws IOException {
        w0(bArr, i8, i9);
    }

    public final void j0(int i8) {
        int i9 = this.d;
        int i10 = i9 + 1;
        this.d = i10;
        byte[] bArr = this.f510b;
        bArr[i9] = (byte) (i8 & 255);
        int i11 = i9 + 2;
        this.d = i11;
        bArr[i10] = (byte) ((i8 >> 8) & 255);
        int i12 = i9 + 3;
        this.d = i12;
        bArr[i11] = (byte) ((i8 >> 16) & 255);
        this.d = i9 + 4;
        bArr[i12] = (byte) ((i8 >> 24) & 255);
    }

    public final void k0(long j4) {
        int i8 = this.d;
        int i9 = i8 + 1;
        this.d = i9;
        byte[] bArr = this.f510b;
        bArr[i8] = (byte) (j4 & 255);
        int i10 = i8 + 2;
        this.d = i10;
        bArr[i9] = (byte) ((j4 >> 8) & 255);
        int i11 = i8 + 3;
        this.d = i11;
        bArr[i10] = (byte) ((j4 >> 16) & 255);
        int i12 = i8 + 4;
        this.d = i12;
        bArr[i11] = (byte) (255 & (j4 >> 24));
        int i13 = i8 + 5;
        this.d = i13;
        bArr[i12] = (byte) (((int) (j4 >> 32)) & 255);
        int i14 = i8 + 6;
        this.d = i14;
        bArr[i13] = (byte) (((int) (j4 >> 40)) & 255);
        int i15 = i8 + 7;
        this.d = i15;
        bArr[i14] = (byte) (((int) (j4 >> 48)) & 255);
        this.d = i8 + 8;
        bArr[i15] = (byte) (((int) (j4 >> 56)) & 255);
    }

    public final void l0(int i8, int i9) {
        m0((i8 << 3) | i9);
    }

    public final void m0(int i8) {
        boolean z = f508g;
        byte[] bArr = this.f510b;
        if (z) {
            while ((i8 & (-128)) != 0) {
                int i9 = this.d;
                this.d = i9 + 1;
                h1.j(bArr, i9, (byte) ((i8 | 128) & 255));
                i8 >>>= 7;
            }
            int i10 = this.d;
            this.d = i10 + 1;
            h1.j(bArr, i10, (byte) i8);
            return;
        }
        while ((i8 & (-128)) != 0) {
            int i11 = this.d;
            this.d = i11 + 1;
            bArr[i11] = (byte) ((i8 | 128) & 255);
            i8 >>>= 7;
        }
        int i12 = this.d;
        this.d = i12 + 1;
        bArr[i12] = (byte) i8;
    }

    public final void n0(long j4) {
        boolean z = f508g;
        byte[] bArr = this.f510b;
        if (z) {
            while ((j4 & (-128)) != 0) {
                int i8 = this.d;
                this.d = i8 + 1;
                h1.j(bArr, i8, (byte) ((((int) j4) | 128) & 255));
                j4 >>>= 7;
            }
            int i9 = this.d;
            this.d = i9 + 1;
            h1.j(bArr, i9, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            int i10 = this.d;
            this.d = i10 + 1;
            bArr[i10] = (byte) ((((int) j4) | 128) & 255);
            j4 >>>= 7;
        }
        int i11 = this.d;
        this.d = i11 + 1;
        bArr[i11] = (byte) j4;
    }

    public final void t0() throws IOException {
        this.f512e.write(this.f510b, 0, this.d);
        this.d = 0;
    }

    public final void u0(int i8) throws IOException {
        if (this.f511c - this.d < i8) {
            t0();
        }
    }

    public final void v0(byte b9) throws IOException {
        if (this.d == this.f511c) {
            t0();
        }
        int i8 = this.d;
        this.d = i8 + 1;
        this.f510b[i8] = b9;
    }

    public final void w0(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = this.d;
        int i11 = this.f511c;
        int i12 = i11 - i10;
        byte[] bArr2 = this.f510b;
        if (i12 >= i9) {
            System.arraycopy(bArr, i8, bArr2, i10, i9);
            this.d += i9;
            return;
        }
        System.arraycopy(bArr, i8, bArr2, i10, i12);
        int i13 = i8 + i12;
        int i14 = i9 - i12;
        this.d = i11;
        t0();
        if (i14 > i11) {
            this.f512e.write(bArr, i13, i14);
        } else {
            System.arraycopy(bArr, i13, bArr2, 0, i14);
            this.d = i14;
        }
    }

    public final void x0(int i8, boolean z) throws IOException {
        u0(11);
        l0(i8, 0);
        byte b9 = z ? (byte) 1 : (byte) 0;
        int i9 = this.d;
        this.d = i9 + 1;
        this.f510b[i9] = b9;
    }

    public final void y0(int i8, g gVar) {
        J0(i8, 2);
        z0(gVar);
    }

    public final void z0(g gVar) throws IOException {
        L0(gVar.size());
        i0(gVar.j(), gVar.size(), gVar.f475b);
    }
}
