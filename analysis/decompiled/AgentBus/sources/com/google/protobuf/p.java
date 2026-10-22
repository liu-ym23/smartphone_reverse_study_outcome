package com.google.protobuf;

import java.util.Locale;

/* loaded from: classes.dex */
public final class p extends r {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2471d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2472e;

    /* renamed from: f, reason: collision with root package name */
    public int f2473f;

    public p(int i2, byte[] bArr) {
        if (((bArr.length - i2) | i2) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(m.x.k("Array range is invalid. Buffer.length=", bArr.length, i2, ", offset=0, length="));
        }
        this.f2471d = bArr;
        this.f2473f = 0;
        this.f2472e = i2;
    }

    @Override // ib.c
    public final void P(byte[] bArr, int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        v0(bArr, i2, i10);
    }

    @Override // com.google.protobuf.r
    public final void Y(byte b10) throws androidx.datastore.preferences.protobuf.l {
        int i2 = this.f2473f;
        try {
            int i10 = i2 + 1;
            try {
                this.f2471d[i2] = b10;
                this.f2473f = i10;
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                i2 = i10;
                throw new androidx.datastore.preferences.protobuf.l(i2, this.f2472e, 1, e);
            }
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
        }
    }

    @Override // com.google.protobuf.r
    public final void Z(int i2, boolean z4) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 0);
        Y(z4 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.protobuf.r
    public final void a0(int i2, byte[] bArr) throws androidx.datastore.preferences.protobuf.l {
        r0(i2);
        v0(bArr, 0, i2);
    }

    @Override // com.google.protobuf.r
    public final void b0(int i2, l lVar) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 2);
        c0(lVar);
    }

    @Override // com.google.protobuf.r
    public final void c0(l lVar) throws androidx.datastore.preferences.protobuf.l {
        r0(lVar.size());
        k kVar = (k) lVar;
        P(kVar.f2418i, kVar.k(), kVar.size());
    }

    @Override // com.google.protobuf.r
    public final void d0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 5);
        e0(i10);
    }

    @Override // com.google.protobuf.r
    public final void e0(int i2) throws androidx.datastore.preferences.protobuf.l {
        int i10 = this.f2473f;
        try {
            byte[] bArr = this.f2471d;
            bArr[i10] = (byte) (i2 & 255);
            bArr[i10 + 1] = (byte) ((i2 >> 8) & 255);
            bArr[i10 + 2] = (byte) ((i2 >> 16) & 255);
            bArr[i10 + 3] = (byte) ((i2 >> 24) & 255);
            this.f2473f = i10 + 4;
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(i10, this.f2472e, 4, e10);
        }
    }

    @Override // com.google.protobuf.r
    public final void f0(int i2, long j2) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 1);
        g0(j2);
    }

    @Override // com.google.protobuf.r
    public final void g0(long j2) throws androidx.datastore.preferences.protobuf.l {
        int i2 = this.f2473f;
        try {
            byte[] bArr = this.f2471d;
            bArr[i2] = (byte) (((int) j2) & 255);
            bArr[i2 + 1] = (byte) (((int) (j2 >> 8)) & 255);
            bArr[i2 + 2] = (byte) (((int) (j2 >> 16)) & 255);
            bArr[i2 + 3] = (byte) (((int) (j2 >> 24)) & 255);
            bArr[i2 + 4] = (byte) (((int) (j2 >> 32)) & 255);
            bArr[i2 + 5] = (byte) (((int) (j2 >> 40)) & 255);
            bArr[i2 + 6] = (byte) (((int) (j2 >> 48)) & 255);
            bArr[i2 + 7] = (byte) (((int) (j2 >> 56)) & 255);
            this.f2473f = i2 + 8;
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(i2, this.f2472e, 8, e10);
        }
    }

    @Override // com.google.protobuf.r
    public final void h0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 0);
        i0(i10);
    }

    @Override // com.google.protobuf.r
    public final void i0(int i2) throws androidx.datastore.preferences.protobuf.l {
        if (i2 >= 0) {
            r0(i2);
        } else {
            t0(i2);
        }
    }

    @Override // com.google.protobuf.r
    public final void j0(int i2, MessageLite messageLite, t3 t3Var) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 2);
        r0(((c) messageLite).a(t3Var));
        t3Var.f(messageLite, this.f2506a);
    }

    @Override // com.google.protobuf.r
    public final void k0(MessageLite messageLite) throws androidx.datastore.preferences.protobuf.l {
        r0(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    @Override // com.google.protobuf.r
    public final void l0(int i2, MessageLite messageLite) throws androidx.datastore.preferences.protobuf.l {
        p0(1, 3);
        q0(2, i2);
        p0(3, 2);
        k0(messageLite);
        p0(1, 4);
    }

    @Override // com.google.protobuf.r
    public final void m0(int i2, l lVar) throws androidx.datastore.preferences.protobuf.l {
        p0(1, 3);
        q0(2, i2);
        b0(3, lVar);
        p0(1, 4);
    }

    @Override // com.google.protobuf.r
    public final void n0(int i2, String str) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 2);
        o0(str);
    }

    @Override // com.google.protobuf.r
    public final void o0(String str) throws androidx.datastore.preferences.protobuf.l {
        int i2 = this.f2473f;
        try {
            int iV = r.V(str.length() * 3);
            int iV2 = r.V(str.length());
            byte[] bArr = this.f2471d;
            if (iV2 != iV) {
                r0(l4.b(str));
                this.f2473f = l4.f2432a.r(this.f2473f, u0(), str, bArr);
                return;
            }
            int i10 = i2 + iV2;
            this.f2473f = i10;
            int iR = l4.f2432a.r(i10, u0(), str, bArr);
            this.f2473f = i2;
            r0((iR - i2) - iV2);
            this.f2473f = iR;
        } catch (k4 e10) {
            this.f2473f = i2;
            X(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new androidx.datastore.preferences.protobuf.l(e11);
        }
    }

    @Override // com.google.protobuf.r
    public final void p0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        r0((i2 << 3) | i10);
    }

    @Override // com.google.protobuf.r
    public final void q0(int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 0);
        r0(i10);
    }

    @Override // com.google.protobuf.r
    public final void r0(int i2) throws androidx.datastore.preferences.protobuf.l {
        while (true) {
            int i10 = i2 & (-128);
            byte[] bArr = this.f2471d;
            if (i10 == 0) {
                int i11 = this.f2473f;
                this.f2473f = i11 + 1;
                bArr[i11] = (byte) i2;
                return;
            } else {
                try {
                    int i12 = this.f2473f;
                    this.f2473f = i12 + 1;
                    bArr[i12] = (byte) ((i2 | 128) & 255);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new androidx.datastore.preferences.protobuf.l(this.f2473f, this.f2472e, 1, e10);
                }
            }
            throw new androidx.datastore.preferences.protobuf.l(this.f2473f, this.f2472e, 1, e10);
        }
    }

    @Override // com.google.protobuf.r
    public final void s0(int i2, long j2) throws androidx.datastore.preferences.protobuf.l {
        p0(i2, 0);
        t0(j2);
    }

    @Override // com.google.protobuf.r
    public final void t0(long j2) throws androidx.datastore.preferences.protobuf.l {
        boolean z4 = r.f2505c;
        byte[] bArr = this.f2471d;
        if (z4 && u0() >= 10) {
            while ((j2 & (-128)) != 0) {
                int i2 = this.f2473f;
                this.f2473f = i2 + 1;
                i4.k(bArr, i2, (byte) ((((int) j2) | 128) & 255));
                j2 >>>= 7;
            }
            int i10 = this.f2473f;
            this.f2473f = i10 + 1;
            i4.k(bArr, i10, (byte) j2);
            return;
        }
        while ((j2 & (-128)) != 0) {
            try {
                int i11 = this.f2473f;
                this.f2473f = i11 + 1;
                bArr[i11] = (byte) ((((int) j2) | 128) & 255);
                j2 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new androidx.datastore.preferences.protobuf.l(this.f2473f, this.f2472e, 1, e10);
            }
        }
        int i12 = this.f2473f;
        this.f2473f = i12 + 1;
        bArr[i12] = (byte) j2;
    }

    public final int u0() {
        return this.f2472e - this.f2473f;
    }

    public final void v0(byte[] bArr, int i2, int i10) throws androidx.datastore.preferences.protobuf.l {
        try {
            System.arraycopy(bArr, i2, this.f2471d, this.f2473f, i10);
            this.f2473f += i10;
        } catch (IndexOutOfBoundsException e10) {
            throw new androidx.datastore.preferences.protobuf.l(this.f2473f, this.f2472e, i10, e10);
        }
    }
}
