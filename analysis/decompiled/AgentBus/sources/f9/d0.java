package f9;

/* loaded from: classes.dex */
public abstract class d0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f3537a = new b0();

    /* renamed from: b, reason: collision with root package name */
    public static final c0 f3538b = new c0();

    public static int a(int i2, int i10) {
        if (i2 > -12 || i10 > -65) {
            return -1;
        }
        return i2 ^ (i10 << 8);
    }

    public static int b(byte[] bArr, int i2, int i10) {
        byte b10 = bArr[i2 - 1];
        int i11 = i10 - i2;
        if (i11 == 0) {
            if (b10 > -12) {
                return -1;
            }
            return b10;
        }
        if (i11 == 1) {
            return a(b10, bArr[i2]);
        }
        if (i11 != 2) {
            throw new AssertionError();
        }
        byte b11 = bArr[i2];
        byte b12 = bArr[i2 + 1];
        if (b10 > -12 || b11 > -65 || b12 > -65) {
            return -1;
        }
        return (b12 << 16) ^ ((b11 << 8) ^ b10);
    }

    public static int c(byte[] bArr, int i2, int i10) {
        while (i2 < i10 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i10) {
            return 0;
        }
        while (i2 < i10) {
            int i11 = i2 + 1;
            byte b10 = bArr[i2];
            if (b10 >= 0) {
                i2 = i11;
            } else if (b10 < -32) {
                if (i11 >= i10) {
                    return b10;
                }
                if (b10 < -62) {
                    return -1;
                }
                i2 += 2;
                if (bArr[i11] > -65) {
                    return -1;
                }
            } else if (b10 < -16) {
                if (i11 >= i10 - 1) {
                    return b(bArr, i11, i10);
                }
                int i12 = i2 + 2;
                byte b11 = bArr[i11];
                if (b11 > -65) {
                    return -1;
                }
                if (b10 == -32 && b11 < -96) {
                    return -1;
                }
                if (b10 == -19 && b11 >= -96) {
                    return -1;
                }
                i2 += 3;
                if (bArr[i12] > -65) {
                    return -1;
                }
            } else {
                if (i11 >= i10 - 2) {
                    return b(bArr, i11, i10);
                }
                int i13 = i2 + 2;
                byte b12 = bArr[i11];
                if (b12 > -65) {
                    return -1;
                }
                if ((((b12 + 112) + (b10 << 28)) >> 30) != 0) {
                    return -1;
                }
                int i14 = i2 + 3;
                if (bArr[i13] > -65) {
                    return -1;
                }
                i2 += 4;
                if (bArr[i14] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
