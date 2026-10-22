package com.baidu.b.a;

import kotlin.UByte;

/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4726a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f4727b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f4728c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4729d;

    /* renamed from: e, reason: collision with root package name */
    private int f4730e;

    /* renamed from: f, reason: collision with root package name */
    private int f4731f;

    public k() {
        this(0);
    }

    private static int a(byte[] bArr, int i4) {
        return (int) (b(bArr, i4, 4) & 4294967295L);
    }

    private static long b(byte[] bArr, int i4, int i5) {
        if (i5 > 8) {
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        long j4 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j4 |= (bArr[i4 + i6] & 255) << (i6 * 8);
        }
        return j4;
    }

    public k(int i4) {
        this.f4726a = new byte[1];
        this.f4727b = new int[4];
        this.f4728c = new byte[16];
        this.f4729d = i4;
        b();
    }

    private void b() {
        int[] iArr = this.f4727b;
        int i4 = this.f4729d;
        iArr[0] = 606290984 + i4;
        iArr[1] = (-2048144777) + i4;
        iArr[2] = i4;
        iArr[3] = i4 - (-1640531535);
    }

    public long a() {
        int iRotateLeft;
        int i4 = 0;
        if (this.f4730e > 16) {
            iRotateLeft = Integer.rotateLeft(this.f4727b[3], 18) + Integer.rotateLeft(this.f4727b[2], 12) + Integer.rotateLeft(this.f4727b[1], 7) + Integer.rotateLeft(this.f4727b[0], 1);
        } else {
            iRotateLeft = this.f4727b[2] + 374761393;
        }
        int iRotateLeft2 = iRotateLeft + this.f4730e;
        int i5 = this.f4731f - 4;
        while (i4 <= i5) {
            iRotateLeft2 = Integer.rotateLeft((a(this.f4728c, i4) * (-1028477379)) + iRotateLeft2, 17) * 668265263;
            i4 += 4;
        }
        while (i4 < this.f4731f) {
            iRotateLeft2 = (-1640531535) * Integer.rotateLeft(((this.f4728c[i4] & UByte.MAX_VALUE) * 374761393) + iRotateLeft2, 11);
            i4++;
        }
        int i6 = ((iRotateLeft2 >>> 15) ^ iRotateLeft2) * (-2048144777);
        int i7 = (i6 ^ (i6 >>> 13)) * (-1028477379);
        return (i7 ^ (i7 >>> 16)) & 4294967295L;
    }

    private void b(byte[] bArr, int i4) {
        int[] iArr = this.f4727b;
        int i5 = iArr[0];
        int i6 = iArr[1];
        int i7 = iArr[2];
        int i8 = iArr[3];
        int iRotateLeft = Integer.rotateLeft((a(bArr, i4) * (-2048144777)) + i5, 13) * (-1640531535);
        int iRotateLeft2 = Integer.rotateLeft((a(bArr, i4 + 4) * (-2048144777)) + i6, 13) * (-1640531535);
        int iRotateLeft3 = Integer.rotateLeft((a(bArr, i4 + 8) * (-2048144777)) + i7, 13) * (-1640531535);
        int iRotateLeft4 = Integer.rotateLeft((a(bArr, i4 + 12) * (-2048144777)) + i8, 13) * (-1640531535);
        int[] iArr2 = this.f4727b;
        iArr2[0] = iRotateLeft;
        iArr2[1] = iRotateLeft2;
        iArr2[2] = iRotateLeft3;
        iArr2[3] = iRotateLeft4;
        this.f4731f = 0;
    }

    public void a(byte[] bArr, int i4, int i5) {
        if (i5 <= 0) {
            return;
        }
        this.f4730e += i5;
        int i6 = i4 + i5;
        int i7 = this.f4731f;
        if (i7 + i5 < 16) {
            System.arraycopy(bArr, i4, this.f4728c, i7, i5);
            this.f4731f += i5;
            return;
        }
        if (i7 > 0) {
            int i8 = 16 - i7;
            System.arraycopy(bArr, i4, this.f4728c, i7, i8);
            b(this.f4728c, 0);
            i4 += i8;
        }
        int i9 = i6 - 16;
        while (i4 <= i9) {
            b(bArr, i4);
            i4 += 16;
        }
        if (i4 < i6) {
            int i10 = i6 - i4;
            this.f4731f = i10;
            System.arraycopy(bArr, i4, this.f4728c, 0, i10);
        }
    }
}
