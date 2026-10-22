package com.google.protobuf;

/* loaded from: classes3.dex */
public abstract class Y2 {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractC1002v2 f2904a;

    static {
        f2904a = (W2.e && W2.d && !AbstractC0944h.a()) ? new X2(1) : new X2(0);
    }

    public static int a(byte[] bArr, int i, int i6) {
        byte b = bArr[i - 1];
        int i10 = i6 - i;
        if (i10 == 0) {
            if (b > -12) {
                return -1;
            }
            return b;
        }
        if (i10 == 1) {
            return c(b, bArr[i]);
        }
        if (i10 == 2) {
            return d(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i10 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char cCharAt = str.charAt(i6);
            if (cCharAt < 2048) {
                i10 += (127 - cCharAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new Utf8$UnpairedSurrogateException(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i10 += i;
            }
        }
        if (i10 >= length) {
            return i10;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i10 + 4294967296L));
    }

    public static int c(int i, int i6) {
        if (i > -12 || i6 > -65) {
            return -1;
        }
        return i ^ (i6 << 8);
    }

    public static int d(int i, int i6, int i10) {
        if (i > -12 || i6 > -65 || i10 > -65) {
            return -1;
        }
        return (i ^ (i6 << 8)) ^ (i10 << 16);
    }
}
