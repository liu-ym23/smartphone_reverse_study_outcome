package com.baidu.b.c.a;

import java.security.InvalidKeyException;

/* loaded from: classes.dex */
class d extends f {

    /* renamed from: a, reason: collision with root package name */
    protected byte[] f4819a;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f4820e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f4821f;

    public d(b bVar) {
        super(bVar);
        this.f4821f = null;
        int i4 = this.f4833c;
        this.f4820e = new byte[i4];
        this.f4819a = new byte[i4];
    }

    @Override // com.baidu.b.c.a.f
    public void a() {
        System.arraycopy(this.f4834d, 0, this.f4819a, 0, this.f4833c);
    }

    @Override // com.baidu.b.c.a.f
    public void b() {
        if (this.f4821f == null) {
            this.f4821f = new byte[this.f4833c];
        }
        System.arraycopy(this.f4819a, 0, this.f4821f, 0, this.f4833c);
    }

    @Override // com.baidu.b.c.a.f
    public void c() {
        System.arraycopy(this.f4821f, 0, this.f4819a, 0, this.f4833c);
    }

    @Override // com.baidu.b.c.a.f
    public void a(boolean z4, String str, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr == null || bArr2 == null || bArr2.length != this.f4833c) {
            throw new InvalidKeyException("Internal error");
        }
        this.f4834d = bArr2;
        a();
        this.f4832b.a(z4, str, bArr);
    }

    @Override // com.baidu.b.c.a.f
    public void b(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        int i7;
        int i8 = i5 + i4;
        byte[] bArr3 = (bArr != bArr2 || i4 < i6 || i4 - i6 >= this.f4833c) ? null : (byte[]) bArr.clone();
        while (i4 < i8) {
            this.f4832b.b(bArr, i4, this.f4820e, 0);
            int i9 = 0;
            while (true) {
                i7 = this.f4833c;
                if (i9 >= i7) {
                    break;
                }
                bArr2[i9 + i6] = (byte) (this.f4820e[i9] ^ this.f4819a[i9]);
                i9++;
            }
            byte[] bArr4 = this.f4819a;
            if (bArr3 == null) {
                System.arraycopy(bArr, i4, bArr4, 0, i7);
            } else {
                System.arraycopy(bArr3, i4, bArr4, 0, i7);
            }
            int i10 = this.f4833c;
            i4 += i10;
            i6 += i10;
        }
    }

    @Override // com.baidu.b.c.a.f
    public void a(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        int i7 = i5 + i4;
        while (i4 < i7) {
            for (int i8 = 0; i8 < this.f4833c; i8++) {
                this.f4820e[i8] = (byte) (bArr[i8 + i4] ^ this.f4819a[i8]);
            }
            this.f4832b.a(this.f4820e, 0, bArr2, i6);
            System.arraycopy(bArr2, i6, this.f4819a, 0, this.f4833c);
            int i9 = this.f4833c;
            i4 += i9;
            i6 += i9;
        }
    }
}
