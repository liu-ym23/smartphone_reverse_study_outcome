package L1;

import com.stepos.activeview.utils.Constants;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1227a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1228b;

    /* renamed from: c, reason: collision with root package name */
    public int f1229c;

    public d(int i4, int i5, byte[] bArr) {
        this.f1227a = bArr;
        this.f1229c = i4;
        this.f1228b = i4 + i5;
    }

    public static int a(int i4) {
        return n(i4) + 1;
    }

    public static int b(int i4, a aVar) {
        return c(aVar) + n(i4);
    }

    public static int c(a aVar) {
        return i(aVar.f1217a.length) + aVar.f1217a.length;
    }

    public static int d(int i4) {
        return n(i4) + 8;
    }

    public static int e(int i4, int i5) {
        return f(i5) + n(i4);
    }

    public static int f(int i4) {
        if (i4 >= 0) {
            return i(i4);
        }
        return 10;
    }

    public static int g(int i4, long j4) {
        return j(j4) + n(i4);
    }

    public static int h(int i4, f fVar) {
        int iN = n(i4);
        int serializedSize = fVar.getSerializedSize();
        return i(serializedSize) + serializedSize + iN;
    }

    public static int i(int i4) {
        if ((i4 & (-128)) == 0) {
            return 1;
        }
        if ((i4 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i4) == 0) {
            return 3;
        }
        return (i4 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int j(long j4) {
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (((-16384) & j4) == 0) {
            return 2;
        }
        if (((-2097152) & j4) == 0) {
            return 3;
        }
        if (((-268435456) & j4) == 0) {
            return 4;
        }
        if (((-34359738368L) & j4) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j4) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j4) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j4) == 0) {
            return 8;
        }
        return (j4 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int k(int i4) {
        return i((i4 >> 31) ^ (i4 << 1));
    }

    public static int l(int i4, String str) {
        return m(str) + n(i4);
    }

    public static int m(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes(Constants.UTF_8_CODE);
            return i(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int n(int i4) {
        return i(i4 << 3);
    }

    public static int o(int i4, int i5) {
        return i(i5) + n(i4);
    }

    public final void A(int i4, String str) throws c, UnsupportedEncodingException {
        B(i4, 2);
        byte[] bytes = str.getBytes(Constants.UTF_8_CODE);
        x(bytes.length);
        w(bytes);
    }

    public final void B(int i4, int i5) throws c {
        x((i4 << 3) | i5);
    }

    public final void C(int i4, int i5) throws c {
        B(i4, 0);
        x(i5);
    }

    public final void p(int i4, boolean z4) throws c {
        B(i4, 0);
        v(z4 ? 1 : 0);
    }

    public final void q(int i4, a aVar) throws c {
        B(i4, 2);
        byte[] bArr = aVar.f1217a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        x(length);
        w(bArr2);
    }

    public final void r(int i4, double d4) throws c {
        B(i4, 1);
        long jDoubleToLongBits = Double.doubleToLongBits(d4);
        v(((int) jDoubleToLongBits) & 255);
        v(((int) (jDoubleToLongBits >> 8)) & 255);
        v(((int) (jDoubleToLongBits >> 16)) & 255);
        v(((int) (jDoubleToLongBits >> 24)) & 255);
        v(((int) (jDoubleToLongBits >> 32)) & 255);
        v(((int) (jDoubleToLongBits >> 40)) & 255);
        v(((int) (jDoubleToLongBits >> 48)) & 255);
        v(((int) (jDoubleToLongBits >> 56)) & 255);
    }

    public final void s(int i4, int i5) throws c {
        B(i4, 0);
        if (i5 >= 0) {
            x(i5);
        } else {
            y(i5);
        }
    }

    public final void t(int i4, long j4) throws c {
        B(i4, 0);
        y(j4);
    }

    public final void u(int i4, f fVar) throws c {
        B(i4, 2);
        x(fVar.getCachedSize());
        fVar.writeTo(this);
    }

    public final void v(int i4) throws c {
        byte b4 = (byte) i4;
        int i5 = this.f1229c;
        if (i5 == this.f1228b) {
            throw new c("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
        this.f1229c = i5 + 1;
        this.f1227a[i5] = b4;
    }

    public final void w(byte[] bArr) throws c {
        int length = bArr.length;
        int i4 = this.f1229c;
        int i5 = this.f1228b;
        int i6 = i5 - i4;
        byte[] bArr2 = this.f1227a;
        if (i6 >= length) {
            System.arraycopy(bArr, 0, bArr2, i4, length);
            this.f1229c += length;
        } else {
            System.arraycopy(bArr, 0, bArr2, i4, i6);
            this.f1229c = i5;
            throw new c("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public final void x(int i4) throws c {
        while ((i4 & (-128)) != 0) {
            v((i4 & 127) | 128);
            i4 >>>= 7;
        }
        v(i4);
    }

    public final void y(long j4) throws c {
        while (((-128) & j4) != 0) {
            v((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        v((int) j4);
    }

    public final void z(int i4, int i5) throws c {
        B(i4, 0);
        x((i5 << 1) ^ (i5 >> 31));
    }
}
