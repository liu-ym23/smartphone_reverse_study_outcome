package com.baidu.b.c.a;

import javax.crypto.ShortBufferException;

/* loaded from: classes.dex */
final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    private int f4836a;

    public h(int i4) {
        this.f4836a = i4;
    }

    @Override // com.baidu.b.c.a.i
    public int a(int i4) {
        int i5 = this.f4836a;
        return i5 - (i4 % i5);
    }

    @Override // com.baidu.b.c.a.i
    public int b(byte[] bArr, int i4, int i5) {
        int i6;
        if (bArr == null || i5 == 0) {
            return 0;
        }
        int i7 = i5 + i4;
        int i8 = bArr[i7 - 1];
        int i9 = i8 & 255;
        if (i9 < 1 || i9 > this.f4836a || (i6 = i7 - i9) < i4) {
            return -1;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (bArr[i6 + i10] != i8) {
                return -1;
            }
        }
        return i6;
    }

    @Override // com.baidu.b.c.a.i
    public void a(byte[] bArr, int i4, int i5) throws ShortBufferException {
        if (bArr == null) {
            return;
        }
        if (i4 + i5 > bArr.length) {
            throw new ShortBufferException("Buffer too small to hold padding");
        }
        byte b4 = (byte) (i5 & 255);
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6 + i4] = b4;
        }
    }
}
