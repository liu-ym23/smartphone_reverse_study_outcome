package com.google.crypto.tink.shaded.protobuf;

import java.util.logging.Logger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends b8.h {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f1486g = Logger.getLogger(l.class.getName());

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f1487h = n1.f1500e;

    /* renamed from: c, reason: collision with root package name */
    public l0 f1488c;
    public final byte[] d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1489e;

    /* renamed from: f, reason: collision with root package name */
    public int f1490f;

    public l(byte[] bArr, int i8) {
        if (((bArr.length - i8) | i8) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i8)));
        }
        this.d = bArr;
        this.f1490f = 0;
        this.f1489e = i8;
    }

    public static int S(int i8, i iVar) {
        return T(iVar) + Z(i8);
    }

    public static int T(i iVar) {
        int size = iVar.size();
        return a0(size) + size;
    }

    public static int U(int i8) {
        return Z(i8) + 4;
    }

    public static int V(int i8) {
        return Z(i8) + 8;
    }

    public static int W(int i8, a aVar, b1 b1Var) {
        return aVar.b(b1Var) + (Z(i8) * 2);
    }

    public static int X(int i8) {
        if (i8 >= 0) {
            return a0(i8);
        }
        return 10;
    }

    public static int Y(String str) {
        int length;
        try {
            length = q1.b(str);
        } catch (p1 unused) {
            length = str.getBytes(a0.f1428a).length;
        }
        return a0(length) + length;
    }

    public static int Z(int i8) {
        return a0(i8 << 3);
    }

    public static int a0(int i8) {
        if ((i8 & (-128)) == 0) {
            return 1;
        }
        if ((i8 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i8) == 0) {
            return 3;
        }
        return (i8 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int b0(long j4) {
        int i8;
        if (((-128) & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if (((-34359738368L) & j4) != 0) {
            j4 >>>= 28;
            i8 = 6;
        } else {
            i8 = 2;
        }
        if (((-2097152) & j4) != 0) {
            i8 += 2;
            j4 >>>= 14;
        }
        return (j4 & (-16384)) != 0 ? i8 + 1 : i8;
    }

    public final void c0(byte b9) throws androidx.datastore.preferences.protobuf.k {
        try {
            byte[] bArr = this.d;
            int i8 = this.f1490f;
            this.f1490f = i8 + 1;
            bArr[i8] = b9;
        } catch (IndexOutOfBoundsException e9) {
            throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), 1), e9);
        }
    }

    public final void d0(byte[] bArr, int i8, int i9) throws androidx.datastore.preferences.protobuf.k {
        try {
            System.arraycopy(bArr, i8, this.d, this.f1490f, i9);
            this.f1490f += i9;
        } catch (IndexOutOfBoundsException e9) {
            throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), Integer.valueOf(i9)), e9);
        }
    }

    public final void e0(int i8, int i9) throws androidx.datastore.preferences.protobuf.k {
        j0(i8, 5);
        f0(i9);
    }

    public final void f0(int i8) throws androidx.datastore.preferences.protobuf.k {
        try {
            byte[] bArr = this.d;
            int i9 = this.f1490f;
            int i10 = i9 + 1;
            this.f1490f = i10;
            bArr[i9] = (byte) (i8 & 255);
            int i11 = i9 + 2;
            this.f1490f = i11;
            bArr[i10] = (byte) ((i8 >> 8) & 255);
            int i12 = i9 + 3;
            this.f1490f = i12;
            bArr[i11] = (byte) ((i8 >> 16) & 255);
            this.f1490f = i9 + 4;
            bArr[i12] = (byte) ((i8 >> 24) & 255);
        } catch (IndexOutOfBoundsException e9) {
            throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), 1), e9);
        }
    }

    public final void g0(int i8, long j4) throws androidx.datastore.preferences.protobuf.k {
        j0(i8, 1);
        h0(j4);
    }

    public final void h0(long j4) throws androidx.datastore.preferences.protobuf.k {
        try {
            byte[] bArr = this.d;
            int i8 = this.f1490f;
            int i9 = i8 + 1;
            this.f1490f = i9;
            bArr[i8] = (byte) (((int) j4) & 255);
            int i10 = i8 + 2;
            this.f1490f = i10;
            bArr[i9] = (byte) (((int) (j4 >> 8)) & 255);
            int i11 = i8 + 3;
            this.f1490f = i11;
            bArr[i10] = (byte) (((int) (j4 >> 16)) & 255);
            int i12 = i8 + 4;
            this.f1490f = i12;
            bArr[i11] = (byte) (((int) (j4 >> 24)) & 255);
            int i13 = i8 + 5;
            this.f1490f = i13;
            bArr[i12] = (byte) (((int) (j4 >> 32)) & 255);
            int i14 = i8 + 6;
            this.f1490f = i14;
            bArr[i13] = (byte) (((int) (j4 >> 40)) & 255);
            int i15 = i8 + 7;
            this.f1490f = i15;
            bArr[i14] = (byte) (((int) (j4 >> 48)) & 255);
            this.f1490f = i8 + 8;
            bArr[i15] = (byte) (((int) (j4 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e9) {
            throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), 1), e9);
        }
    }

    public final void i0(int i8) throws androidx.datastore.preferences.protobuf.k {
        if (i8 >= 0) {
            k0(i8);
        } else {
            m0(i8);
        }
    }

    public final void j0(int i8, int i9) throws androidx.datastore.preferences.protobuf.k {
        k0((i8 << 3) | i9);
    }

    public final void k0(int i8) throws androidx.datastore.preferences.protobuf.k {
        while (true) {
            int i9 = i8 & (-128);
            byte[] bArr = this.d;
            if (i9 == 0) {
                int i10 = this.f1490f;
                this.f1490f = i10 + 1;
                bArr[i10] = (byte) i8;
                return;
            } else {
                try {
                    int i11 = this.f1490f;
                    this.f1490f = i11 + 1;
                    bArr[i11] = (byte) ((i8 & 127) | 128);
                    i8 >>>= 7;
                } catch (IndexOutOfBoundsException e9) {
                    throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), 1), e9);
                }
            }
            throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(this.f1489e), 1), e9);
        }
    }

    public final void l0(int i8, long j4) throws androidx.datastore.preferences.protobuf.k {
        j0(i8, 0);
        m0(j4);
    }

    public final void m0(long j4) throws androidx.datastore.preferences.protobuf.k {
        boolean z = f1487h;
        int i8 = this.f1489e;
        byte[] bArr = this.d;
        if (z && i8 - this.f1490f >= 10) {
            while ((j4 & (-128)) != 0) {
                int i9 = this.f1490f;
                this.f1490f = i9 + 1;
                n1.k(bArr, i9, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            int i10 = this.f1490f;
            this.f1490f = i10 + 1;
            n1.k(bArr, i10, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            try {
                int i11 = this.f1490f;
                this.f1490f = i11 + 1;
                bArr[i11] = (byte) ((((int) j4) & 127) | 128);
                j4 >>>= 7;
            } catch (IndexOutOfBoundsException e9) {
                throw new androidx.datastore.preferences.protobuf.k(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1490f), Integer.valueOf(i8), 1), e9);
            }
        }
        int i12 = this.f1490f;
        this.f1490f = i12 + 1;
        bArr[i12] = (byte) j4;
    }
}
