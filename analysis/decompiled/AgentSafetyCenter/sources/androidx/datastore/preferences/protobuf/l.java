package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f1148f = Logger.getLogger(l.class.getName());

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f1149g = j1.f1142e;

    /* renamed from: a, reason: collision with root package name */
    public f0 f1150a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f1151b;

    /* renamed from: c, reason: collision with root package name */
    public int f1152c;

    /* renamed from: d, reason: collision with root package name */
    public int f1153d;

    /* renamed from: e, reason: collision with root package name */
    public od.h f1154e;

    public static int f(int i, f fVar) {
        int iH = h(i);
        int size = fVar.size();
        return i(size) + size + iH;
    }

    public static int g(String str) {
        int length;
        try {
            length = m1.a(str);
        } catch (l1 unused) {
            length = str.getBytes(x.f1218a).length;
        }
        return i(length) + length;
    }

    public static int h(int i) {
        return i(i << 3);
    }

    public static int i(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int j(long j10) {
        return (640 - (Long.numberOfLeadingZeros(j10) * 9)) >>> 6;
    }

    public final void A(String str) throws IOException {
        byte[] bArr = this.f1151b;
        int i = this.f1152c;
        try {
            int length = str.length() * 3;
            int i3 = i(length);
            int i10 = i3 + length;
            if (i10 > i) {
                byte[] bArr2 = new byte[length];
                int iQ = m1.f1157a.q(str, bArr2, 0, length);
                D(iQ);
                n(bArr2, 0, iQ);
                return;
            }
            if (i10 > i - this.f1153d) {
                k();
            }
            int i11 = i(str.length());
            int i12 = this.f1153d;
            try {
                if (i11 == i3) {
                    int i13 = i12 + i11;
                    this.f1153d = i13;
                    int iQ2 = m1.f1157a.q(str, bArr, i13, i - i13);
                    this.f1153d = i12;
                    d((iQ2 - i12) - i11);
                    this.f1153d = iQ2;
                } else {
                    int iA = m1.a(str);
                    d(iA);
                    this.f1153d = m1.f1157a.q(str, bArr, this.f1153d, iA);
                }
            } catch (l1 e10) {
                this.f1153d = i12;
                throw e10;
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new k(e11);
            }
        } catch (l1 e12) {
            f1148f.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e12);
            byte[] bytes = str.getBytes(x.f1218a);
            try {
                D(bytes.length);
                x(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e13) {
                throw new k(e13);
            }
        }
    }

    public final void B(int i, int i3) {
        D((i << 3) | i3);
    }

    public final void C(int i, int i3) throws IOException {
        l(20);
        c(i, 0);
        d(i3);
    }

    public final void D(int i) throws IOException {
        l(5);
        d(i);
    }

    public final void E(int i, long j10) throws IOException {
        l(20);
        c(i, 0);
        e(j10);
    }

    public final void F(long j10) throws IOException {
        l(10);
        e(j10);
    }

    public final void a(int i) {
        byte[] bArr = this.f1151b;
        int i3 = this.f1153d;
        int i10 = i3 + 1;
        this.f1153d = i10;
        bArr[i3] = (byte) (i & 255);
        int i11 = i3 + 2;
        this.f1153d = i11;
        bArr[i10] = (byte) ((i >> 8) & 255);
        int i12 = i3 + 3;
        this.f1153d = i12;
        bArr[i11] = (byte) ((i >> 16) & 255);
        this.f1153d = i3 + 4;
        bArr[i12] = (byte) ((i >> 24) & 255);
    }

    public final void b(long j10) {
        byte[] bArr = this.f1151b;
        int i = this.f1153d;
        int i3 = i + 1;
        this.f1153d = i3;
        bArr[i] = (byte) (j10 & 255);
        int i10 = i + 2;
        this.f1153d = i10;
        bArr[i3] = (byte) ((j10 >> 8) & 255);
        int i11 = i + 3;
        this.f1153d = i11;
        bArr[i10] = (byte) ((j10 >> 16) & 255);
        int i12 = i + 4;
        this.f1153d = i12;
        bArr[i11] = (byte) (255 & (j10 >> 24));
        int i13 = i + 5;
        this.f1153d = i13;
        bArr[i12] = (byte) (((int) (j10 >> 32)) & 255);
        int i14 = i + 6;
        this.f1153d = i14;
        bArr[i13] = (byte) (((int) (j10 >> 40)) & 255);
        int i15 = i + 7;
        this.f1153d = i15;
        bArr[i14] = (byte) (((int) (j10 >> 48)) & 255);
        this.f1153d = i + 8;
        bArr[i15] = (byte) (((int) (j10 >> 56)) & 255);
    }

    public final void c(int i, int i3) {
        d((i << 3) | i3);
    }

    public final void d(int i) {
        byte[] bArr = this.f1151b;
        if (f1149g) {
            while (true) {
                int i3 = i & (-128);
                int i10 = this.f1153d;
                if (i3 == 0) {
                    this.f1153d = i10 + 1;
                    j1.j(bArr, i10, (byte) i);
                    return;
                } else {
                    this.f1153d = i10 + 1;
                    j1.j(bArr, i10, (byte) ((i | 128) & 255));
                    i >>>= 7;
                }
            }
        } else {
            while (true) {
                int i11 = i & (-128);
                int i12 = this.f1153d;
                if (i11 == 0) {
                    this.f1153d = i12 + 1;
                    bArr[i12] = (byte) i;
                    return;
                } else {
                    this.f1153d = i12 + 1;
                    bArr[i12] = (byte) ((i | 128) & 255);
                    i >>>= 7;
                }
            }
        }
    }

    public final void e(long j10) {
        byte[] bArr = this.f1151b;
        if (f1149g) {
            while (true) {
                long j11 = j10 & (-128);
                int i = this.f1153d;
                if (j11 == 0) {
                    this.f1153d = i + 1;
                    j1.j(bArr, i, (byte) j10);
                    return;
                } else {
                    this.f1153d = i + 1;
                    j1.j(bArr, i, (byte) ((((int) j10) | 128) & 255));
                    j10 >>>= 7;
                }
            }
        } else {
            while (true) {
                long j12 = j10 & (-128);
                int i3 = this.f1153d;
                if (j12 == 0) {
                    this.f1153d = i3 + 1;
                    bArr[i3] = (byte) j10;
                    return;
                } else {
                    this.f1153d = i3 + 1;
                    bArr[i3] = (byte) ((((int) j10) | 128) & 255);
                    j10 >>>= 7;
                }
            }
        }
    }

    public final void k() throws IOException {
        this.f1154e.write(this.f1151b, 0, this.f1153d);
        this.f1153d = 0;
    }

    public final void l(int i) throws IOException {
        if (this.f1152c - this.f1153d < i) {
            k();
        }
    }

    public final void m(byte b10) throws IOException {
        if (this.f1153d == this.f1152c) {
            k();
        }
        byte[] bArr = this.f1151b;
        int i = this.f1153d;
        this.f1153d = i + 1;
        bArr[i] = b10;
    }

    public final void n(byte[] bArr, int i, int i3) throws IOException {
        int i10 = this.f1152c;
        int i11 = this.f1153d;
        int i12 = i10 - i11;
        byte[] bArr2 = this.f1151b;
        if (i12 >= i3) {
            System.arraycopy(bArr, i, bArr2, i11, i3);
            this.f1153d += i3;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i11, i12);
        int i13 = i + i12;
        int i14 = i3 - i12;
        this.f1153d = i10;
        k();
        if (i14 > i10) {
            this.f1154e.write(bArr, i13, i14);
        } else {
            System.arraycopy(bArr, i13, bArr2, 0, i14);
            this.f1153d = i14;
        }
    }

    public final void o(int i, boolean z10) throws IOException {
        l(11);
        c(i, 0);
        byte b10 = z10 ? (byte) 1 : (byte) 0;
        byte[] bArr = this.f1151b;
        int i3 = this.f1153d;
        this.f1153d = i3 + 1;
        bArr[i3] = b10;
    }

    public final void p(int i, f fVar) throws IOException {
        B(i, 2);
        q(fVar);
    }

    public final void q(f fVar) throws IOException {
        D(fVar.size());
        x(fVar.f1108f, fVar.e(), fVar.size());
    }

    public final void r(int i, int i3) throws IOException {
        l(14);
        c(i, 5);
        a(i3);
    }

    public final void s(int i) throws IOException {
        l(4);
        a(i);
    }

    public final void t(int i, long j10) throws IOException {
        l(18);
        c(i, 1);
        b(j10);
    }

    public final void u(long j10) throws IOException {
        l(8);
        b(j10);
    }

    public final void v(int i, int i3) throws IOException {
        l(20);
        c(i, 0);
        if (i3 >= 0) {
            d(i3);
        } else {
            e(i3);
        }
    }

    public final void w(int i) throws IOException {
        if (i >= 0) {
            D(i);
        } else {
            F(i);
        }
    }

    public final void x(byte[] bArr, int i, int i3) throws IOException {
        n(bArr, i, i3);
    }

    public final void y(int i, a aVar, w0 w0Var) throws IOException {
        B(i, 2);
        D(aVar.a(w0Var));
        w0Var.a(aVar, this.f1150a);
    }

    public final void z(int i, String str) throws IOException {
        B(i, 2);
        A(str);
    }
}
