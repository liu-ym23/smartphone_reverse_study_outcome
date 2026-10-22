package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: androidx.datastore.preferences.protobuf.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0267n extends AbstractC0268o {

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f3511f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3512g;

    /* renamed from: h, reason: collision with root package name */
    public int f3513h;

    /* renamed from: i, reason: collision with root package name */
    public final OutputStream f3514i;

    public C0267n(S.r rVar, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i4, 20);
        this.f3511f = new byte[iMax];
        this.f3512g = iMax;
        this.f3514i = rVar;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void I(byte b4) {
        if (this.f3513h == this.f3512g) {
            h0();
        }
        int i4 = this.f3513h;
        this.f3513h = i4 + 1;
        this.f3511f[i4] = b4;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void J(int i4, boolean z4) {
        i0(11);
        e0(i4, 0);
        byte b4 = z4 ? (byte) 1 : (byte) 0;
        int i5 = this.f3513h;
        this.f3513h = i5 + 1;
        this.f3511f[i5] = b4;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void K(int i4, byte[] bArr) throws IOException {
        Z(i4);
        j0(bArr, 0, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void L(int i4, AbstractC0259h abstractC0259h) throws IOException {
        X(i4, 2);
        M(abstractC0259h);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void M(AbstractC0259h abstractC0259h) throws IOException {
        Z(abstractC0259h.size());
        C0261i c0261i = (C0261i) abstractC0259h;
        j(c0261i.h(), c0261i.size(), c0261i.f3483d);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void N(int i4, int i5) {
        i0(14);
        e0(i4, 5);
        c0(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void O(int i4) {
        i0(4);
        c0(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void P(int i4, long j4) {
        i0(18);
        e0(i4, 1);
        d0(j4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void Q(long j4) {
        i0(8);
        d0(j4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void R(int i4, int i5) {
        i0(20);
        e0(i4, 0);
        if (i5 >= 0) {
            f0(i5);
        } else {
            g0(i5);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void S(int i4) {
        if (i4 >= 0) {
            Z(i4);
        } else {
            b0(i4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void T(int i4, AbstractC0247b abstractC0247b, InterfaceC0262i0 interfaceC0262i0) {
        X(i4, 2);
        Z(abstractC0247b.b(interfaceC0262i0));
        interfaceC0262i0.c(abstractC0247b, this.f3520c);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void U(AbstractC0247b abstractC0247b) {
        Z(abstractC0247b.a());
        abstractC0247b.c(this);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void V(int i4, String str) throws IOException {
        X(i4, 2);
        W(str);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void W(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iE = AbstractC0268o.E(length);
            int i4 = iE + length;
            int i5 = this.f3512g;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int iL = C0.f3395a.l(str, bArr, 0, length);
                Z(iL);
                j0(bArr, 0, iL);
                return;
            }
            if (i4 > i5 - this.f3513h) {
                h0();
            }
            int iE2 = AbstractC0268o.E(str.length());
            int i6 = this.f3513h;
            byte[] bArr2 = this.f3511f;
            try {
                try {
                    if (iE2 == iE) {
                        int i7 = i6 + iE2;
                        this.f3513h = i7;
                        int iL2 = C0.f3395a.l(str, bArr2, i7, i5 - i7);
                        this.f3513h = i6;
                        f0((iL2 - i6) - iE2);
                        this.f3513h = iL2;
                    } else {
                        int iB = C0.b(str);
                        f0(iB);
                        this.f3513h = C0.f3395a.l(str, bArr2, this.f3513h, iB);
                    }
                } catch (B0 e4) {
                    this.f3513h = i6;
                    throw e4;
                }
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw new C0266m(e5);
            }
        } catch (B0 e6) {
            H(str, e6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void X(int i4, int i5) {
        Z((i4 << 3) | i5);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void Y(int i4, int i5) {
        i0(20);
        e0(i4, 0);
        f0(i5);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void Z(int i4) {
        i0(5);
        f0(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void a0(int i4, long j4) {
        i0(20);
        e0(i4, 0);
        g0(j4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0268o
    public final void b0(long j4) {
        i0(10);
        g0(j4);
    }

    public final void c0(int i4) {
        int i5 = this.f3513h;
        byte[] bArr = this.f3511f;
        bArr[i5] = (byte) (i4 & 255);
        bArr[i5 + 1] = (byte) ((i4 >> 8) & 255);
        bArr[i5 + 2] = (byte) ((i4 >> 16) & 255);
        this.f3513h = i5 + 4;
        bArr[i5 + 3] = (byte) ((i4 >> 24) & 255);
    }

    public final void d0(long j4) {
        int i4 = this.f3513h;
        byte[] bArr = this.f3511f;
        bArr[i4] = (byte) (j4 & 255);
        bArr[i4 + 1] = (byte) ((j4 >> 8) & 255);
        bArr[i4 + 2] = (byte) ((j4 >> 16) & 255);
        bArr[i4 + 3] = (byte) (255 & (j4 >> 24));
        bArr[i4 + 4] = (byte) (((int) (j4 >> 32)) & 255);
        bArr[i4 + 5] = (byte) (((int) (j4 >> 40)) & 255);
        bArr[i4 + 6] = (byte) (((int) (j4 >> 48)) & 255);
        this.f3513h = i4 + 8;
        bArr[i4 + 7] = (byte) (((int) (j4 >> 56)) & 255);
    }

    public final void e0(int i4, int i5) {
        f0((i4 << 3) | i5);
    }

    public final void f0(int i4) {
        boolean z4 = AbstractC0268o.f3519e;
        byte[] bArr = this.f3511f;
        if (z4) {
            while ((i4 & (-128)) != 0) {
                int i5 = this.f3513h;
                this.f3513h = i5 + 1;
                z0.m(bArr, i5, (byte) ((i4 & 127) | 128));
                i4 >>>= 7;
            }
            int i6 = this.f3513h;
            this.f3513h = i6 + 1;
            z0.m(bArr, i6, (byte) i4);
            return;
        }
        while ((i4 & (-128)) != 0) {
            int i7 = this.f3513h;
            this.f3513h = i7 + 1;
            bArr[i7] = (byte) ((i4 & 127) | 128);
            i4 >>>= 7;
        }
        int i8 = this.f3513h;
        this.f3513h = i8 + 1;
        bArr[i8] = (byte) i4;
    }

    public final void g0(long j4) {
        boolean z4 = AbstractC0268o.f3519e;
        byte[] bArr = this.f3511f;
        if (z4) {
            while ((j4 & (-128)) != 0) {
                int i4 = this.f3513h;
                this.f3513h = i4 + 1;
                z0.m(bArr, i4, (byte) ((((int) j4) & 127) | 128));
                j4 >>>= 7;
            }
            int i5 = this.f3513h;
            this.f3513h = i5 + 1;
            z0.m(bArr, i5, (byte) j4);
            return;
        }
        while ((j4 & (-128)) != 0) {
            int i6 = this.f3513h;
            this.f3513h = i6 + 1;
            bArr[i6] = (byte) ((((int) j4) & 127) | 128);
            j4 >>>= 7;
        }
        int i7 = this.f3513h;
        this.f3513h = i7 + 1;
        bArr[i7] = (byte) j4;
    }

    public final void h0() {
        this.f3514i.write(this.f3511f, 0, this.f3513h);
        this.f3513h = 0;
    }

    public final void i0(int i4) {
        if (this.f3512g - this.f3513h < i4) {
            h0();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.X
    public final void j(int i4, int i5, byte[] bArr) throws IOException {
        j0(bArr, i4, i5);
    }

    public final void j0(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.f3513h;
        int i7 = this.f3512g;
        int i8 = i7 - i6;
        byte[] bArr2 = this.f3511f;
        if (i8 >= i5) {
            System.arraycopy(bArr, i4, bArr2, i6, i5);
            this.f3513h += i5;
            return;
        }
        System.arraycopy(bArr, i4, bArr2, i6, i8);
        int i9 = i4 + i8;
        int i10 = i5 - i8;
        this.f3513h = i7;
        h0();
        if (i10 > i7) {
            this.f3514i.write(bArr, i9, i10);
        } else {
            System.arraycopy(bArr, i9, bArr2, 0, i10);
            this.f3513h = i10;
        }
    }
}
