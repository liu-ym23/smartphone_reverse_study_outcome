package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2497d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2498e;

    /* renamed from: f, reason: collision with root package name */
    public int f2499f;

    /* renamed from: g, reason: collision with root package name */
    public final OutputStream f2500g;

    public q(OutputStream outputStream, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i2, 20);
        this.f2497d = new byte[iMax];
        this.f2498e = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.f2500g = outputStream;
    }

    public final void A0(int i2) {
        if (this.f2498e - this.f2499f < i2) {
            z0();
        }
    }

    public final void B0(byte[] bArr, int i2, int i10) throws IOException {
        int i11 = this.f2499f;
        int i12 = this.f2498e;
        int i13 = i12 - i11;
        byte[] bArr2 = this.f2497d;
        if (i13 >= i10) {
            System.arraycopy(bArr, i2, bArr2, i11, i10);
            this.f2499f += i10;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i11, i13);
        int i14 = i2 + i13;
        int i15 = i10 - i13;
        this.f2499f = i12;
        z0();
        if (i15 > i12) {
            this.f2500g.write(bArr, i14, i15);
        } else {
            System.arraycopy(bArr, i14, bArr2, 0, i15);
            this.f2499f = i15;
        }
    }

    @Override // ib.c
    public final void P(byte[] bArr, int i2, int i10) throws IOException {
        B0(bArr, i2, i10);
    }

    @Override // com.google.protobuf.r
    public final void Y(byte b10) {
        if (this.f2499f == this.f2498e) {
            z0();
        }
        int i2 = this.f2499f;
        this.f2499f = i2 + 1;
        this.f2497d[i2] = b10;
    }

    @Override // com.google.protobuf.r
    public final void Z(int i2, boolean z4) {
        A0(11);
        w0(i2, 0);
        byte b10 = z4 ? (byte) 1 : (byte) 0;
        int i10 = this.f2499f;
        this.f2499f = i10 + 1;
        this.f2497d[i10] = b10;
    }

    @Override // com.google.protobuf.r
    public final void a0(int i2, byte[] bArr) throws IOException {
        r0(i2);
        B0(bArr, 0, i2);
    }

    @Override // com.google.protobuf.r
    public final void b0(int i2, l lVar) {
        p0(i2, 2);
        c0(lVar);
    }

    @Override // com.google.protobuf.r
    public final void c0(l lVar) {
        r0(lVar.size());
        k kVar = (k) lVar;
        P(kVar.f2418i, kVar.k(), kVar.size());
    }

    @Override // com.google.protobuf.r
    public final void d0(int i2, int i10) {
        A0(14);
        w0(i2, 5);
        u0(i10);
    }

    @Override // com.google.protobuf.r
    public final void e0(int i2) {
        A0(4);
        u0(i2);
    }

    @Override // com.google.protobuf.r
    public final void f0(int i2, long j2) {
        A0(18);
        w0(i2, 1);
        v0(j2);
    }

    @Override // com.google.protobuf.r
    public final void g0(long j2) {
        A0(8);
        v0(j2);
    }

    @Override // com.google.protobuf.r
    public final void h0(int i2, int i10) {
        A0(20);
        w0(i2, 0);
        if (i10 >= 0) {
            x0(i10);
        } else {
            y0(i10);
        }
    }

    @Override // com.google.protobuf.r
    public final void i0(int i2) {
        if (i2 >= 0) {
            r0(i2);
        } else {
            t0(i2);
        }
    }

    @Override // com.google.protobuf.r
    public final void j0(int i2, MessageLite messageLite, t3 t3Var) {
        p0(i2, 2);
        r0(((c) messageLite).a(t3Var));
        t3Var.f(messageLite, this.f2506a);
    }

    @Override // com.google.protobuf.r
    public final void k0(MessageLite messageLite) {
        r0(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    @Override // com.google.protobuf.r
    public final void l0(int i2, MessageLite messageLite) {
        p0(1, 3);
        q0(2, i2);
        p0(3, 2);
        k0(messageLite);
        p0(1, 4);
    }

    @Override // com.google.protobuf.r
    public final void m0(int i2, l lVar) {
        p0(1, 3);
        q0(2, i2);
        b0(3, lVar);
        p0(1, 4);
    }

    @Override // com.google.protobuf.r
    public final void n0(int i2, String str) throws IOException {
        p0(i2, 2);
        o0(str);
    }

    @Override // com.google.protobuf.r
    public final void o0(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iV = r.V(length);
            int i2 = iV + length;
            int i10 = this.f2498e;
            if (i2 > i10) {
                byte[] bArr = new byte[length];
                int iR = l4.f2432a.r(0, length, str, bArr);
                r0(iR);
                B0(bArr, 0, iR);
                return;
            }
            if (i2 > i10 - this.f2499f) {
                z0();
            }
            int iV2 = r.V(str.length());
            int i11 = this.f2499f;
            byte[] bArr2 = this.f2497d;
            try {
                try {
                    if (iV2 == iV) {
                        int i12 = i11 + iV2;
                        this.f2499f = i12;
                        int iR2 = l4.f2432a.r(i12, i10 - i12, str, bArr2);
                        this.f2499f = i11;
                        x0((iR2 - i11) - iV2);
                        this.f2499f = iR2;
                    } else {
                        int iB = l4.b(str);
                        x0(iB);
                        this.f2499f = l4.f2432a.r(this.f2499f, iB, str, bArr2);
                    }
                } catch (k4 e10) {
                    this.f2499f = i11;
                    throw e10;
                }
            } catch (ArrayIndexOutOfBoundsException e11) {
                throw new androidx.datastore.preferences.protobuf.l(e11);
            }
        } catch (k4 e12) {
            X(str, e12);
        }
    }

    @Override // com.google.protobuf.r
    public final void p0(int i2, int i10) {
        r0((i2 << 3) | i10);
    }

    @Override // com.google.protobuf.r
    public final void q0(int i2, int i10) {
        A0(20);
        w0(i2, 0);
        x0(i10);
    }

    @Override // com.google.protobuf.r
    public final void r0(int i2) {
        A0(5);
        x0(i2);
    }

    @Override // com.google.protobuf.r
    public final void s0(int i2, long j2) {
        A0(20);
        w0(i2, 0);
        y0(j2);
    }

    @Override // com.google.protobuf.r
    public final void t0(long j2) {
        A0(10);
        y0(j2);
    }

    public final void u0(int i2) {
        int i10 = this.f2499f;
        int i11 = i10 + 1;
        this.f2499f = i11;
        byte[] bArr = this.f2497d;
        bArr[i10] = (byte) (i2 & 255);
        int i12 = i10 + 2;
        this.f2499f = i12;
        bArr[i11] = (byte) ((i2 >> 8) & 255);
        int i13 = i10 + 3;
        this.f2499f = i13;
        bArr[i12] = (byte) ((i2 >> 16) & 255);
        this.f2499f = i10 + 4;
        bArr[i13] = (byte) ((i2 >> 24) & 255);
    }

    public final void v0(long j2) {
        int i2 = this.f2499f;
        int i10 = i2 + 1;
        this.f2499f = i10;
        byte[] bArr = this.f2497d;
        bArr[i2] = (byte) (j2 & 255);
        int i11 = i2 + 2;
        this.f2499f = i11;
        bArr[i10] = (byte) ((j2 >> 8) & 255);
        int i12 = i2 + 3;
        this.f2499f = i12;
        bArr[i11] = (byte) ((j2 >> 16) & 255);
        int i13 = i2 + 4;
        this.f2499f = i13;
        bArr[i12] = (byte) (255 & (j2 >> 24));
        int i14 = i2 + 5;
        this.f2499f = i14;
        bArr[i13] = (byte) (((int) (j2 >> 32)) & 255);
        int i15 = i2 + 6;
        this.f2499f = i15;
        bArr[i14] = (byte) (((int) (j2 >> 40)) & 255);
        int i16 = i2 + 7;
        this.f2499f = i16;
        bArr[i15] = (byte) (((int) (j2 >> 48)) & 255);
        this.f2499f = i2 + 8;
        bArr[i16] = (byte) (((int) (j2 >> 56)) & 255);
    }

    public final void w0(int i2, int i10) {
        x0((i2 << 3) | i10);
    }

    public final void x0(int i2) {
        boolean z4 = r.f2505c;
        byte[] bArr = this.f2497d;
        if (z4) {
            while ((i2 & (-128)) != 0) {
                int i10 = this.f2499f;
                this.f2499f = i10 + 1;
                i4.k(bArr, i10, (byte) ((i2 | 128) & 255));
                i2 >>>= 7;
            }
            int i11 = this.f2499f;
            this.f2499f = i11 + 1;
            i4.k(bArr, i11, (byte) i2);
            return;
        }
        while ((i2 & (-128)) != 0) {
            int i12 = this.f2499f;
            this.f2499f = i12 + 1;
            bArr[i12] = (byte) ((i2 | 128) & 255);
            i2 >>>= 7;
        }
        int i13 = this.f2499f;
        this.f2499f = i13 + 1;
        bArr[i13] = (byte) i2;
    }

    public final void y0(long j2) {
        boolean z4 = r.f2505c;
        byte[] bArr = this.f2497d;
        if (z4) {
            while ((j2 & (-128)) != 0) {
                int i2 = this.f2499f;
                this.f2499f = i2 + 1;
                i4.k(bArr, i2, (byte) ((((int) j2) | 128) & 255));
                j2 >>>= 7;
            }
            int i10 = this.f2499f;
            this.f2499f = i10 + 1;
            i4.k(bArr, i10, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i11 = this.f2499f;
            this.f2499f = i11 + 1;
            bArr[i11] = (byte) ((((int) j2) | 128) & 255);
            j2 >>>= 7;
        }
        int i12 = this.f2499f;
        this.f2499f = i12 + 1;
        bArr[i12] = (byte) j2;
    }

    public final void z0() {
        this.f2500g.write(this.f2497d, 0, this.f2499f);
        this.f2499f = 0;
    }
}
