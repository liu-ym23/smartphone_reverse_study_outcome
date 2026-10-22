package f9;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3551a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3552b;

    /* renamed from: c, reason: collision with root package name */
    public int f3553c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final OutputStream f3554d;

    public f(OutputStream outputStream, byte[] bArr) {
        this.f3554d = outputStream;
        this.f3551a = bArr;
        this.f3552b = bArr.length;
    }

    public static int a(int i2, int i10) {
        return c(i10) + h(i2);
    }

    public static int b(int i2, int i10) {
        return c(i10) + h(i2);
    }

    public static int c(int i2) {
        if (i2 >= 0) {
            return f(i2);
        }
        return 10;
    }

    public static int d(int i2, a aVar) {
        return e(aVar) + h(i2);
    }

    public static int e(a aVar) {
        int iA = aVar.a();
        return f(iA) + iA;
    }

    public static int f(int i2) {
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

    public static int g(long j2) {
        if (((-128) & j2) == 0) {
            return 1;
        }
        if (((-16384) & j2) == 0) {
            return 2;
        }
        if (((-2097152) & j2) == 0) {
            return 3;
        }
        if (((-268435456) & j2) == 0) {
            return 4;
        }
        if (((-34359738368L) & j2) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j2) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j2) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j2) == 0) {
            return 8;
        }
        return (j2 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int h(int i2) {
        return f(i2 << 3);
    }

    public static f j(OutputStream outputStream, int i2) {
        return new f(outputStream, new byte[i2]);
    }

    public final void i() throws IOException {
        if (this.f3554d != null) {
            k();
        }
    }

    public final void k() throws IOException {
        OutputStream outputStream = this.f3554d;
        if (outputStream == null) {
            throw new androidx.datastore.preferences.protobuf.l("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
        outputStream.write(this.f3551a, 0, this.f3553c);
        this.f3553c = 0;
    }

    public final void l(int i2, int i10) throws IOException {
        x(i2, 0);
        n(i10);
    }

    public final void m(int i2, int i10) throws IOException {
        x(i2, 0);
        n(i10);
    }

    public final void n(int i2) throws IOException {
        if (i2 >= 0) {
            v(i2);
        } else {
            w(i2);
        }
    }

    public final void o(int i2, a aVar) throws IOException {
        x(i2, 2);
        p(aVar);
    }

    public final void p(a aVar) throws IOException {
        v(aVar.a());
        aVar.d(this);
    }

    public final void q(int i2) throws IOException {
        byte b10 = (byte) i2;
        if (this.f3553c == this.f3552b) {
            k();
        }
        int i10 = this.f3553c;
        this.f3553c = i10 + 1;
        this.f3551a[i10] = b10;
    }

    public final void r(d dVar) throws IOException {
        int size = dVar.size();
        int i2 = this.f3553c;
        int i10 = this.f3552b;
        int i11 = i10 - i2;
        byte[] bArr = this.f3551a;
        if (i11 >= size) {
            dVar.h(0, i2, size, bArr);
            this.f3553c += size;
            return;
        }
        dVar.h(0, i2, i11, bArr);
        int i12 = size - i11;
        this.f3553c = i10;
        k();
        if (i12 <= i10) {
            dVar.h(i11, 0, i12, bArr);
            this.f3553c = i12;
            return;
        }
        if (i11 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i11);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i12 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i12);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i13 = i11 + i12;
        if (i13 <= dVar.size()) {
            if (i12 > 0) {
                dVar.s(this.f3554d, i11, i12);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i13);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public final void s(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i2 = this.f3553c;
        int i10 = this.f3552b;
        int i11 = i10 - i2;
        byte[] bArr2 = this.f3551a;
        if (i11 >= length) {
            System.arraycopy(bArr, 0, bArr2, i2, length);
            this.f3553c += length;
            return;
        }
        System.arraycopy(bArr, 0, bArr2, i2, i11);
        int i12 = length - i11;
        this.f3553c = i10;
        k();
        if (i12 > i10) {
            this.f3554d.write(bArr, i11, i12);
        } else {
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            this.f3553c = i12;
        }
    }

    public final void t(int i2) throws IOException {
        q(i2 & 255);
        q((i2 >> 8) & 255);
        q((i2 >> 16) & 255);
        q((i2 >> 24) & 255);
    }

    public final void u(long j2) throws IOException {
        q(((int) j2) & 255);
        q(((int) (j2 >> 8)) & 255);
        q(((int) (j2 >> 16)) & 255);
        q(((int) (j2 >> 24)) & 255);
        q(((int) (j2 >> 32)) & 255);
        q(((int) (j2 >> 40)) & 255);
        q(((int) (j2 >> 48)) & 255);
        q(((int) (j2 >> 56)) & 255);
    }

    public final void v(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            q((i2 & 127) | 128);
            i2 >>>= 7;
        }
        q(i2);
    }

    public final void w(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            q((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        q((int) j2);
    }

    public final void x(int i2, int i10) throws IOException {
        v((i2 << 3) | i10);
    }
}
