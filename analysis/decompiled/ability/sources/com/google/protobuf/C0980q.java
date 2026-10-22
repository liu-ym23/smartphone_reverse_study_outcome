package com.google.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.protobuf.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0980q extends AbstractC1002v2 {
    public static final Logger g = Logger.getLogger(C0980q.class.getName());
    public static final boolean h = W2.e;
    public F1 c;
    public final byte[] d;
    public final int e;
    public int f;

    public C0980q(byte[] bArr, int i) {
        if (((bArr.length - i) | i) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
        }
        this.d = bArr;
        this.f = 0;
        this.e = i;
    }

    public static int J(int i) {
        return R(i) + 1;
    }

    public static int K(int i, ByteString byteString) {
        return L(byteString) + R(i);
    }

    public static int L(ByteString byteString) {
        int size = byteString.size();
        return S(size) + size;
    }

    public static int M(int i, int i6) {
        return O(i6) + R(i);
    }

    public static int N(int i, int i6) {
        return O(i6) + R(i);
    }

    public static int O(int i) {
        if (i >= 0) {
            return S(i);
        }
        return 10;
    }

    public static int P(int i, X1 x12) {
        int iR = R(i);
        int serializedSize = x12.getSerializedSize();
        return S(serializedSize) + serializedSize + iR;
    }

    public static int Q(String str) {
        int length;
        try {
            length = Y2.b(str);
        } catch (Utf8$UnpairedSurrogateException unused) {
            length = str.getBytes(AbstractC0989s1.f2940a).length;
        }
        return S(length) + length;
    }

    public static int R(int i) {
        return S(i << 3);
    }

    public static int S(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int T(long j5) {
        int i;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            j5 >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j5) != 0) {
            i += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i + 1 : i;
    }

    public final void U(byte b) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    public final void V(byte[] bArr, int i, int i6) {
        try {
            System.arraycopy(bArr, i, this.d, this.f, i6);
            this.f += i6;
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i6)), e);
        }
    }

    public final void W(int i, boolean z10) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 0);
        U(z10 ? (byte) 1 : (byte) 0);
    }

    public final void X(int i, ByteString byteString) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 2);
        l0(byteString.size());
        byteString.r(this);
    }

    public final void Y(int i, int i6) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 5);
        Z(i6);
    }

    public final void Z(int i) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.d;
            int i6 = this.f;
            int i10 = i6 + 1;
            this.f = i10;
            bArr[i6] = (byte) (i & 255);
            int i11 = i6 + 2;
            this.f = i11;
            bArr[i10] = (byte) ((i >> 8) & 255);
            int i12 = i6 + 3;
            this.f = i12;
            bArr[i11] = (byte) ((i >> 16) & 255);
            this.f = i6 + 4;
            bArr[i12] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    public final void a0(int i, long j5) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 1);
        b0(j5);
    }

    public final void b0(long j5) throws CodedOutputStream$OutOfSpaceException {
        try {
            byte[] bArr = this.d;
            int i = this.f;
            int i6 = i + 1;
            this.f = i6;
            bArr[i] = (byte) (((int) j5) & 255);
            int i10 = i + 2;
            this.f = i10;
            bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
            int i11 = i + 3;
            this.f = i11;
            bArr[i10] = (byte) (((int) (j5 >> 16)) & 255);
            int i12 = i + 4;
            this.f = i12;
            bArr[i11] = (byte) (((int) (j5 >> 24)) & 255);
            int i13 = i + 5;
            this.f = i13;
            bArr[i12] = (byte) (((int) (j5 >> 32)) & 255);
            int i14 = i + 6;
            this.f = i14;
            bArr[i13] = (byte) (((int) (j5 >> 40)) & 255);
            int i15 = i + 7;
            this.f = i15;
            bArr[i14] = (byte) (((int) (j5 >> 48)) & 255);
            this.f = i + 8;
            bArr[i15] = (byte) (((int) (j5 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    public final void c0(int i, X1 x12) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 3);
        x12.c(this);
        k0(i, 4);
    }

    public final void d0(int i, int i6) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 0);
        e0(i6);
    }

    public final void e0(int i) throws CodedOutputStream$OutOfSpaceException {
        if (i >= 0) {
            l0(i);
        } else {
            n0(i);
        }
    }

    public final void f0(int i, X1 x12) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 2);
        g0(x12);
    }

    public final void g0(X1 x12) throws CodedOutputStream$OutOfSpaceException {
        l0(x12.getSerializedSize());
        x12.c(this);
    }

    public final void h0(int i, X1 x12) throws CodedOutputStream$OutOfSpaceException {
        k0(1, 3);
        k0(2, 0);
        l0(i);
        f0(3, x12);
        k0(1, 4);
    }

    public final void i0(int i, ByteString byteString) throws CodedOutputStream$OutOfSpaceException {
        k0(1, 3);
        k0(2, 0);
        l0(i);
        X(3, byteString);
        k0(1, 4);
    }

    public final void j0(String str) throws CodedOutputStream$OutOfSpaceException {
        int i = this.f;
        try {
            int iS = S(str.length() * 3);
            int iS2 = S(str.length());
            int i6 = this.e;
            byte[] bArr = this.d;
            if (iS2 != iS) {
                l0(Y2.b(str));
                int i10 = this.f;
                this.f = Y2.f2904a.t(str, bArr, i10, i6 - i10);
                return;
            }
            int i11 = i + iS2;
            this.f = i11;
            int iT = Y2.f2904a.t(str, bArr, i11, i6 - i11);
            this.f = i;
            l0((iT - i) - iS2);
            this.f = iT;
        } catch (Utf8$UnpairedSurrogateException e) {
            this.f = i;
            g.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
            byte[] bytes = str.getBytes(AbstractC0989s1.f2940a);
            try {
                l0(bytes.length);
                V(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e6) {
                throw new CodedOutputStream$OutOfSpaceException(e6);
            }
        } catch (IndexOutOfBoundsException e9) {
            throw new CodedOutputStream$OutOfSpaceException(e9);
        }
    }

    public final void k0(int i, int i6) throws CodedOutputStream$OutOfSpaceException {
        l0((i << 3) | i6);
    }

    public final void l0(int i) throws CodedOutputStream$OutOfSpaceException {
        while (true) {
            int i6 = i & (-128);
            byte[] bArr = this.d;
            if (i6 == 0) {
                int i10 = this.f;
                this.f = i10 + 1;
                bArr[i10] = (byte) i;
                return;
            } else {
                try {
                    int i11 = this.f;
                    this.f = i11 + 1;
                    bArr[i11] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
                }
            }
            throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(this.e), 1), e);
        }
    }

    public final void m0(int i, long j5) throws CodedOutputStream$OutOfSpaceException {
        k0(i, 0);
        n0(j5);
    }

    public final void n0(long j5) throws CodedOutputStream$OutOfSpaceException {
        boolean z10 = h;
        int i = this.e;
        byte[] bArr = this.d;
        if (z10 && i - this.f >= 10) {
            while ((j5 & (-128)) != 0) {
                int i6 = this.f;
                this.f = i6 + 1;
                W2.k(bArr, i6, (byte) ((((int) j5) & 127) | 128));
                j5 >>>= 7;
            }
            int i10 = this.f;
            this.f = i10 + 1;
            W2.k(bArr, i10, (byte) j5);
            return;
        }
        while ((j5 & (-128)) != 0) {
            try {
                int i11 = this.f;
                this.f = i11 + 1;
                bArr[i11] = (byte) ((((int) j5) & 127) | 128);
                j5 >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new CodedOutputStream$OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f), Integer.valueOf(i), 1), e);
            }
        }
        int i12 = this.f;
        this.f = i12 + 1;
        bArr[i12] = (byte) j5;
    }
}
