package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1731k0 extends AbstractC1739m0 {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f20090d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20091e;

    /* renamed from: f, reason: collision with root package name */
    public int f20092f;

    public C1731k0(byte[] bArr, int i10, int i11) {
        super(null);
        int length = bArr.length;
        if (((length - i11) | i11) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i11)));
        }
        this.f20090d = bArr;
        this.f20092f = 0;
        this.f20091e = i11;
    }

    public final void D(byte[] bArr, int i10, int i11) throws IOException {
        try {
            System.arraycopy(bArr, i10, this.f20090d, this.f20092f, i11);
            this.f20092f += i11;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), Integer.valueOf(i11)), e10);
        }
    }

    public final void E(String str) throws IOException {
        int i10 = this.f20092f;
        try {
            int iA = AbstractC1739m0.a(str.length() * 3);
            int iA2 = AbstractC1739m0.a(str.length());
            if (iA2 != iA) {
                w(Y1.e(str));
                byte[] bArr = this.f20090d;
                int i11 = this.f20092f;
                this.f20092f = Y1.d(str, bArr, i11, this.f20091e - i11);
                return;
            }
            int i12 = i10 + iA2;
            this.f20092f = i12;
            int iD = Y1.d(str, this.f20090d, i12, this.f20091e - i12);
            this.f20092f = i10;
            w((iD - i10) - iA2);
            this.f20092f = iD;
        } catch (zzhd e10) {
            this.f20092f = i10;
            d(str, e10);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzdl(e11);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final int f() {
        return this.f20091e - this.f20092f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void g(byte b10) throws IOException {
        try {
            byte[] bArr = this.f20090d;
            int i10 = this.f20092f;
            this.f20092f = i10 + 1;
            bArr[i10] = b10;
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void h(int i10, boolean z10) throws IOException {
        w(i10 << 3);
        g(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void i(int i10, zzdf zzdfVar) throws IOException {
        w((i10 << 3) | 2);
        w(zzdfVar.f());
        zzdfVar.u(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void j(int i10, int i11) throws IOException {
        w((i10 << 3) | 5);
        k(i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void k(int i10) throws IOException {
        try {
            byte[] bArr = this.f20090d;
            int i11 = this.f20092f;
            int i12 = i11 + 1;
            this.f20092f = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.f20092f = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.f20092f = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f20092f = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void l(int i10, long j10) throws IOException {
        w((i10 << 3) | 1);
        m(j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void m(long j10) throws IOException {
        try {
            byte[] bArr = this.f20090d;
            int i10 = this.f20092f;
            int i11 = i10 + 1;
            this.f20092f = i11;
            bArr[i10] = (byte) (((int) j10) & 255);
            int i12 = i10 + 2;
            this.f20092f = i12;
            bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
            int i13 = i10 + 3;
            this.f20092f = i13;
            bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
            int i14 = i10 + 4;
            this.f20092f = i14;
            bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
            int i15 = i10 + 5;
            this.f20092f = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.f20092f = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.f20092f = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f20092f = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e10) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), 1), e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void n(int i10, int i11) throws IOException {
        w(i10 << 3);
        o(i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void o(int i10) throws IOException {
        if (i10 >= 0) {
            w(i10);
        } else {
            y(i10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void p(byte[] bArr, int i10, int i11) throws IOException {
        D(bArr, 0, i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void q(int i10, InterfaceC1720h1 interfaceC1720h1, InterfaceC1791z1 interfaceC1791z1) throws IOException {
        w((i10 << 3) | 2);
        w(((T) interfaceC1720h1).b(interfaceC1791z1));
        interfaceC1791z1.b(interfaceC1720h1, this.f20114a);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void r(int i10, InterfaceC1720h1 interfaceC1720h1) throws IOException {
        w(11);
        v(2, i10);
        w(26);
        w(interfaceC1720h1.a());
        interfaceC1720h1.d(this);
        w(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void s(int i10, zzdf zzdfVar) throws IOException {
        w(11);
        v(2, i10);
        i(3, zzdfVar);
        w(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void t(int i10, String str) throws IOException {
        w((i10 << 3) | 2);
        E(str);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void u(int i10, int i11) throws IOException {
        w((i10 << 3) | i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void v(int i10, int i11) throws IOException {
        w(i10 << 3);
        w(i11);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void w(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            try {
                byte[] bArr = this.f20090d;
                int i11 = this.f20092f;
                this.f20092f = i11 + 1;
                bArr[i11] = (byte) ((i10 | 128) & 255);
                i10 >>>= 7;
            } catch (IndexOutOfBoundsException e10) {
                throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), 1), e10);
            }
        }
        byte[] bArr2 = this.f20090d;
        int i12 = this.f20092f;
        this.f20092f = i12 + 1;
        bArr2[i12] = (byte) i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void x(int i10, long j10) throws IOException {
        w(i10 << 3);
        y(j10);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1739m0
    public final void y(long j10) throws IOException {
        if (!AbstractC1739m0.f20113c || this.f20091e - this.f20092f < 10) {
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f20090d;
                    int i10 = this.f20092f;
                    this.f20092f = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) | 128) & 255);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f20092f), Integer.valueOf(this.f20091e), 1), e10);
                }
            }
            byte[] bArr2 = this.f20090d;
            int i11 = this.f20092f;
            this.f20092f = i11 + 1;
            bArr2[i11] = (byte) j10;
            return;
        }
        while (true) {
            int i12 = (int) j10;
            if ((j10 & (-128)) == 0) {
                byte[] bArr3 = this.f20090d;
                int i13 = this.f20092f;
                this.f20092f = i13 + 1;
                T1.s(bArr3, i13, (byte) i12);
                return;
            }
            byte[] bArr4 = this.f20090d;
            int i14 = this.f20092f;
            this.f20092f = i14 + 1;
            T1.s(bArr4, i14, (byte) ((i12 | 128) & 255));
            j10 >>>= 7;
        }
    }
}
