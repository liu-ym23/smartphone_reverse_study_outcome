package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public abstract class C0 {

    /* renamed from: a, reason: collision with root package name */
    public static final A0 f3395a;

    static {
        f3395a = (z0.f3560f && z0.f3559e && !AbstractC0251d.a()) ? new A0(1) : new A0(0);
    }

    public static int a(int i4, int i5, byte[] bArr) {
        byte b4 = bArr[i4 - 1];
        int i6 = i5 - i4;
        if (i6 == 0) {
            if (b4 > -12) {
                b4 = -1;
            }
            return b4;
        }
        if (i6 == 1) {
            return c(b4, bArr[i4]);
        }
        if (i6 == 2) {
            return d(b4, bArr[i4], bArr[i4 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 >= length) {
                break;
            }
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt < 2048) {
                i6 += (127 - cCharAt) >>> 31;
                i5++;
            } else {
                int length2 = charSequence.length();
                while (i5 < length2) {
                    char cCharAt2 = charSequence.charAt(i5);
                    if (cCharAt2 < 2048) {
                        i4 += (127 - cCharAt2) >>> 31;
                    } else {
                        i4 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i5) < 65536) {
                                throw new B0(i5, length2);
                            }
                            i5++;
                        }
                    }
                    i5++;
                }
                i6 += i4;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i6 + 4294967296L));
    }

    public static int c(int i4, int i5) {
        if (i4 > -12 || i5 > -65) {
            return -1;
        }
        return i4 ^ (i5 << 8);
    }

    public static int d(int i4, int i5, int i6) {
        if (i4 > -12 || i5 > -65 || i6 > -65) {
            return -1;
        }
        return (i4 ^ (i5 << 8)) ^ (i6 << 16);
    }
}
