package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class l4 {

    /* renamed from: a, reason: collision with root package name */
    public static final w7.e0 f2432a;

    static {
        f2432a = (i4.f2402e && i4.f2401d && !e.a()) ? new j4(1) : new j4(0);
    }

    public static int a(byte[] bArr, int i2, int i10) {
        byte b10 = bArr[i2 - 1];
        int i11 = i10 - i2;
        if (i11 == 0) {
            if (b10 > -12) {
                return -1;
            }
            return b10;
        }
        if (i11 == 1) {
            return c(b10, bArr[i2]);
        }
        if (i11 == 2) {
            return d(b10, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(String str) {
        int length = str.length();
        int i2 = 0;
        int i10 = 0;
        while (i10 < length && str.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt < 2048) {
                i11 += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                int length2 = str.length();
                while (i10 < length2) {
                    char cCharAt2 = str.charAt(i10);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i10) < 65536) {
                                throw new k4(i10, length2);
                            }
                            i10++;
                        }
                    }
                    i10++;
                }
                i11 += i2;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    public static int c(int i2, int i10) {
        if (i2 > -12 || i10 > -65) {
            return -1;
        }
        return i2 ^ (i10 << 8);
    }

    public static int d(int i2, int i10, int i11) {
        if (i2 > -12 || i10 > -65 || i11 > -65) {
            return -1;
        }
        return (i2 ^ (i10 << 8)) ^ (i11 << 16);
    }
}
