package com.google.crypto.tink.shaded.protobuf;

import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class k extends ib.c {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f2232e = Logger.getLogger(k.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f2233f = m1.f2248e;

    /* renamed from: a, reason: collision with root package name */
    public k0 f2234a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2235b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2236c;

    /* renamed from: d, reason: collision with root package name */
    public int f2237d;

    public k(int i2, byte[] bArr) {
        if (((bArr.length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
        }
        this.f2235b = bArr;
        this.f2237d = 0;
        this.f2236c = i2;
    }

    public static int Q(int i2, h hVar) {
        return R(hVar) + X(i2);
    }

    public static int R(h hVar) {
        int size = hVar.size();
        return Y(size) + size;
    }

    public static int S(int i2) {
        return X(i2) + 4;
    }

    public static int T(int i2) {
        return X(i2) + 8;
    }

    public static int U(int i2, a aVar, a1 a1Var) {
        return aVar.a(a1Var) + (X(i2) * 2);
    }

    public static int V(int i2) {
        if (i2 >= 0) {
            return Y(i2);
        }
        return 10;
    }

    public static int W(String str) {
        int length;
        try {
            length = p1.b(str);
        } catch (o1 unused) {
            length = str.getBytes(z.f2296a).length;
        }
        return Y(length) + length;
    }

    public static int X(int i2) {
        return Y(i2 << 3);
    }

    public static int Y(int i2) {
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

    public static int Z(long j2) {
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

    public final void a0(byte b10) throws androidx.datastore.preferences.protobuf.l {
        try {
            byte[] bArr = this.f2235b;
            int i2 = this.f2237d;
            this.f2237d = i2 + 1;
            bArr[i2] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), 1), e10);
        }
    }

    public final void b0(byte[] bArr, int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        try {
            System.arraycopy(bArr, i2, this.f2235b, this.f2237d, i10);
            this.f2237d += i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), Integer.valueOf(i10)), e10);
        }
    }

    public final void c0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        h0(i2, 5);
        d0(i10);
    }

    public final void d0(int i2) throws androidx.datastore.preferences.protobuf.l {
        try {
            byte[] bArr = this.f2235b;
            int i10 = this.f2237d;
            int i11 = i10 + 1;
            this.f2237d = i11;
            bArr[i10] = (byte) (i2 & 255);
            int i12 = i10 + 2;
            this.f2237d = i12;
            bArr[i11] = (byte) ((i2 >> 8) & 255);
            int i13 = i10 + 3;
            this.f2237d = i13;
            bArr[i12] = (byte) ((i2 >> 16) & 255);
            this.f2237d = i10 + 4;
            bArr[i13] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), 1), e10);
        }
    }

    public final void e0(int i2, long j2) throws androidx.datastore.preferences.protobuf.l {
        h0(i2, 1);
        f0(j2);
    }

    public final void f0(long j2) throws androidx.datastore.preferences.protobuf.l {
        try {
            byte[] bArr = this.f2235b;
            int i2 = this.f2237d;
            int i10 = i2 + 1;
            this.f2237d = i10;
            bArr[i2] = (byte) (((int) j2) & 255);
            int i11 = i2 + 2;
            this.f2237d = i11;
            bArr[i10] = (byte) (((int) (j2 >> 8)) & 255);
            int i12 = i2 + 3;
            this.f2237d = i12;
            bArr[i11] = (byte) (((int) (j2 >> 16)) & 255);
            int i13 = i2 + 4;
            this.f2237d = i13;
            bArr[i12] = (byte) (((int) (j2 >> 24)) & 255);
            int i14 = i2 + 5;
            this.f2237d = i14;
            bArr[i13] = (byte) (((int) (j2 >> 32)) & 255);
            int i15 = i2 + 6;
            this.f2237d = i15;
            bArr[i14] = (byte) (((int) (j2 >> 40)) & 255);
            int i16 = i2 + 7;
            this.f2237d = i16;
            bArr[i15] = (byte) (((int) (j2 >> 48)) & 255);
            this.f2237d = i2 + 8;
            bArr[i16] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), 1), e10);
        }
    }

    public final void g0(int i2) throws androidx.datastore.preferences.protobuf.l {
        if (i2 >= 0) {
            i0(i2);
        } else {
            k0(i2);
        }
    }

    public final void h0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        i0((i2 << 3) | i10);
    }

    public final void i0(int i2) throws androidx.datastore.preferences.protobuf.l {
        while (true) {
            int i10 = i2 & (-128);
            byte[] bArr = this.f2235b;
            if (i10 == 0) {
                int i11 = this.f2237d;
                this.f2237d = i11 + 1;
                bArr[i11] = (byte) i2;
                return;
            } else {
                try {
                    int i12 = this.f2237d;
                    this.f2237d = i12 + 1;
                    bArr[i12] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), 1), e10);
                }
            }
            throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(this.f2236c), 1), e10);
        }
    }

    public final void j0(int i2, long j2) throws androidx.datastore.preferences.protobuf.l {
        h0(i2, 0);
        k0(j2);
    }

    public final void k0(long j2) throws androidx.datastore.preferences.protobuf.l {
        boolean z4 = f2233f;
        int i2 = this.f2236c;
        byte[] bArr = this.f2235b;
        if (z4 && i2 - this.f2237d >= 10) {
            while ((j2 & (-128)) != 0) {
                int i10 = this.f2237d;
                this.f2237d = i10 + 1;
                m1.k(bArr, i10, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            int i11 = this.f2237d;
            this.f2237d = i11 + 1;
            m1.k(bArr, i11, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            try {
                int i12 = this.f2237d;
                this.f2237d = i12 + 1;
                bArr[i12] = (byte) ((((int) j2) & 127) | 128);
                j2 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new androidx.datastore.preferences.protobuf.l(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2237d), Integer.valueOf(i2), 1), e10);
            }
        }
        int i13 = this.f2237d;
        this.f2237d = i13 + 1;
        bArr[i13] = (byte) j2;
    }
}
