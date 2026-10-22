package H8;

/* loaded from: classes4.dex */
public abstract class A {

    /* renamed from: a, reason: collision with root package name */
    public static final y f760a = new y();
    public static final z b = new z();

    public static int a(int i, int i6) {
        if (i > -12 || i6 > -65) {
            return -1;
        }
        return i ^ (i6 << 8);
    }

    public static int b(byte[] bArr, int i, int i6) {
        byte b5 = bArr[i - 1];
        int i10 = i6 - i;
        if (i10 == 0) {
            if (b5 > -12) {
                return -1;
            }
            return b5;
        }
        if (i10 == 1) {
            return a(b5, bArr[i]);
        }
        if (i10 != 2) {
            throw new AssertionError();
        }
        byte b10 = bArr[i];
        byte b11 = bArr[i + 1];
        if (b5 > -12 || b10 > -65 || b11 > -65) {
            return -1;
        }
        return (b11 << 16) ^ ((b10 << 8) ^ b5);
    }

    public static int c(byte[] bArr, int i, int i6) {
        while (i < i6 && bArr[i] >= 0) {
            i++;
        }
        if (i >= i6) {
            return 0;
        }
        while (i < i6) {
            int i10 = i + 1;
            byte b5 = bArr[i];
            if (b5 >= 0) {
                i = i10;
            } else if (b5 < -32) {
                if (i10 >= i6) {
                    return b5;
                }
                if (b5 < -62) {
                    return -1;
                }
                i += 2;
                if (bArr[i10] > -65) {
                    return -1;
                }
            } else if (b5 < -16) {
                if (i10 >= i6 - 1) {
                    return b(bArr, i10, i6);
                }
                int i11 = i + 2;
                byte b10 = bArr[i10];
                if (b10 > -65) {
                    return -1;
                }
                if (b5 == -32 && b10 < -96) {
                    return -1;
                }
                if (b5 == -19 && b10 >= -96) {
                    return -1;
                }
                i += 3;
                if (bArr[i11] > -65) {
                    return -1;
                }
            } else {
                if (i10 >= i6 - 2) {
                    return b(bArr, i10, i6);
                }
                int i12 = i + 2;
                byte b11 = bArr[i10];
                if (b11 > -65) {
                    return -1;
                }
                if ((((b11 + 112) + (b5 << 28)) >> 30) != 0) {
                    return -1;
                }
                int i13 = i + 3;
                if (bArr[i12] > -65) {
                    return -1;
                }
                i += 4;
                if (bArr[i13] > -65) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
