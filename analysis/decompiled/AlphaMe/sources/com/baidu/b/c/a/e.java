package com.baidu.b.c.a;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f4822a;

    /* renamed from: b, reason: collision with root package name */
    private int f4823b;

    /* renamed from: c, reason: collision with root package name */
    private int f4824c;

    /* renamed from: f, reason: collision with root package name */
    private int f4827f;

    /* renamed from: g, reason: collision with root package name */
    private i f4828g;

    /* renamed from: h, reason: collision with root package name */
    private f f4829h;

    /* renamed from: d, reason: collision with root package name */
    private int f4825d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f4826e = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f4830i = 1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4831j = false;

    public e(b bVar, int i4) {
        this.f4822a = null;
        this.f4828g = null;
        this.f4829h = null;
        this.f4823b = i4;
        this.f4824c = i4;
        this.f4827f = i4;
        this.f4822a = new byte[i4 * 2];
        this.f4829h = new d(bVar);
        this.f4828g = new h(this.f4823b);
    }

    public int a(int i4) {
        int i5 = this.f4825d + i4;
        i iVar = this.f4828g;
        if (iVar == null || this.f4831j) {
            return i5;
        }
        int i6 = this.f4824c;
        int i7 = this.f4823b;
        if (i6 == i7) {
            return i5 + iVar.a(i5);
        }
        int i8 = this.f4827f;
        return i5 < i8 ? i8 : (i5 + i7) - ((i5 - i8) % i7);
    }

    public int a(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iA;
        byte[] bArr3;
        int i7;
        i iVar;
        int iA2;
        int i8 = this.f4825d + i5;
        int i9 = this.f4824c;
        int i10 = this.f4823b;
        if (i9 != i10) {
            int i11 = this.f4827f;
            iA = i8 < i11 ? i11 - i8 : i10 - ((i8 - i11) % i10);
        } else {
            i iVar2 = this.f4828g;
            iA = iVar2 != null ? iVar2.a(i8) : 0;
        }
        if (iA > 0 && iA != this.f4823b && this.f4828g != null && this.f4831j) {
            throw new IllegalBlockSizeException(AbstractC0831a.d(new StringBuilder("Input length must be multiple of "), this.f4823b, " when decrypting with padded cipher"));
        }
        boolean z4 = this.f4831j;
        int i12 = (z4 || this.f4828g == null) ? i8 : i8 + iA;
        if (bArr2 == null) {
            throw new ShortBufferException("Output buffer is null");
        }
        int length = bArr2.length - i6;
        if (((!z4 || this.f4828g == null) && length < i12) || (z4 && length < i12 - this.f4823b)) {
            throw new ShortBufferException("Output buffer too short: " + length + " bytes given, " + i12 + " bytes needed");
        }
        int i13 = this.f4825d;
        if (i13 == 0 && (z4 || this.f4828g == null)) {
            bArr3 = bArr;
            i7 = i4;
        } else {
            byte[] bArr4 = new byte[i12];
            if (i13 != 0) {
                System.arraycopy(this.f4822a, 0, bArr4, 0, i13);
            }
            if (i5 != 0) {
                System.arraycopy(bArr, i4, bArr4, this.f4825d, i5);
            }
            if (!this.f4831j && (iVar = this.f4828g) != null) {
                iVar.a(bArr4, i8, iA);
            }
            bArr3 = bArr4;
            i7 = 0;
        }
        if (this.f4831j) {
            if (length < i12) {
                this.f4829h.b();
            }
            byte[] bArr5 = new byte[i8];
            iA2 = a(bArr3, i7, bArr5, 0, i8);
            i iVar3 = this.f4828g;
            if (iVar3 != null && (iA2 = iVar3.b(bArr5, 0, iA2)) < 0) {
                throw new BadPaddingException("Given final block not properly padded");
            }
            if (bArr2.length - i6 < iA2) {
                this.f4829h.c();
                throw new ShortBufferException("Output buffer too short: " + (bArr2.length - i6) + " bytes given, " + iA2 + " bytes needed");
            }
            for (int i14 = 0; i14 < iA2; i14++) {
                bArr2[i6 + i14] = bArr5[i14];
            }
        } else {
            iA2 = a(bArr3, i7, bArr2, i6, i12);
        }
        this.f4825d = 0;
        this.f4827f = this.f4823b;
        if (this.f4830i != 0) {
            this.f4829h.a();
        }
        return iA2;
    }

    private int a(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) throws IllegalBlockSizeException {
        if (bArr == null || i6 == 0) {
            return 0;
        }
        int i7 = this.f4830i;
        if (i7 != 2 && i7 != 3 && i6 % this.f4824c != 0 && i7 != 6) {
            if (this.f4828g != null) {
                throw new IllegalBlockSizeException(AbstractC0831a.d(new StringBuilder("Input length (with padding) not multiple of "), this.f4824c, " bytes"));
            }
            throw new IllegalBlockSizeException(AbstractC0831a.d(new StringBuilder("Input length not multiple of "), this.f4824c, " bytes"));
        }
        if (this.f4831j) {
            this.f4829h.d(bArr, i4, i6, bArr2, i5);
        } else {
            this.f4829h.c(bArr, i4, i6, bArr2, i5);
        }
        return i6;
    }

    public void a(int i4, byte[] bArr, byte[] bArr2, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        boolean z4 = i4 == 2 || i4 == 4;
        this.f4831j = z4;
        if (this.f4830i == 0) {
            if (bArr2 != null) {
                throw new InvalidAlgorithmParameterException("ECB mode cannot use IV");
            }
        } else if (bArr2 == null) {
            if (z4) {
                throw new InvalidAlgorithmParameterException("Parameters missing");
            }
            if (secureRandom == null) {
                secureRandom = c.f4817a;
            }
            bArr2 = new byte[this.f4823b];
            secureRandom.nextBytes(bArr2);
        }
        this.f4825d = 0;
        this.f4827f = this.f4823b;
        this.f4829h.a(this.f4831j, "", bArr, bArr2);
    }

    public byte[] a(byte[] bArr, int i4, int i5) throws BadPaddingException, IllegalBlockSizeException {
        try {
            int iA = a(i5);
            byte[] bArr2 = new byte[iA];
            int iA2 = a(bArr, i4, i5, bArr2, 0);
            if (iA2 >= iA) {
                return bArr2;
            }
            byte[] bArr3 = new byte[iA2];
            if (iA2 != 0) {
                try {
                    System.arraycopy(bArr2, 0, bArr3, 0, iA2);
                } catch (ShortBufferException unused) {
                }
            }
            return bArr3;
        } catch (ShortBufferException unused2) {
            return null;
        }
    }
}
