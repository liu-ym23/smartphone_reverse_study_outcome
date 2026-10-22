package androidx.datastore.preferences.protobuf;

import com.stepos.core.common.util.TraceIdKeys;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1765a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super(a0.a.f("Unpaired surrogate at index ", i10, i11, " of "));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {
        public static void a(byte b10, byte b11, byte b12, byte b13, char[] cArr, int i10) throws InvalidProtocolBufferException {
            if (!d(b11)) {
                if ((((b11 + 112) + (b10 << 28)) >> 30) == 0 && !d(b12) && !d(b13)) {
                    int i11 = ((b10 & 7) << 18) | ((b11 & 63) << 12) | ((b12 & 63) << 6) | (b13 & 63);
                    cArr[i10] = (char) ((i11 >>> 10) + 55232);
                    cArr[i10 + 1] = (char) ((i11 & 1023) + 56320);
                    return;
                }
            }
            throw InvalidProtocolBufferException.a();
        }

        public static void b(byte b10, byte b11, char[] cArr, int i10) throws InvalidProtocolBufferException {
            if (b10 < -62 || d(b11)) {
                throw InvalidProtocolBufferException.a();
            }
            cArr[i10] = (char) (((b10 & 31) << 6) | (b11 & 63));
        }

        public static void c(byte b10, byte b11, byte b12, char[] cArr, int i10) throws InvalidProtocolBufferException {
            if (d(b11) || ((b10 == -32 && b11 < -96) || ((b10 == -19 && b11 >= -96) || d(b12)))) {
                throw InvalidProtocolBufferException.a();
            }
            cArr[i10] = (char) (((b10 & 15) << 12) | ((b11 & 63) << 6) | (b12 & 63));
        }

        public static boolean d(byte b10) {
            return b10 > -65;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b {
        public abstract String a(byte[] bArr, int i10, int i11);

        public abstract int b(byte[] bArr, int i10, int i11, String str);

        public abstract int c(byte[] bArr, int i10, int i11);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends b {
        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final String a(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte b10 = bArr[i10];
                if (b10 < 0) {
                    break;
                }
                i10++;
                cArr[i13] = (char) b10;
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte b11 = bArr[i10];
                if (b11 >= 0) {
                    int i16 = i14 + 1;
                    cArr[i14] = (char) b11;
                    int i17 = i15;
                    while (i17 < i12) {
                        byte b12 = bArr[i17];
                        if (b12 < 0) {
                            break;
                        }
                        i17++;
                        cArr[i16] = (char) b12;
                        i16++;
                    }
                    i14 = i16;
                    i10 = i17;
                } else if (b11 < -32) {
                    if (i15 >= i12) {
                        throw InvalidProtocolBufferException.a();
                    }
                    i10 += 2;
                    a.b(b11, bArr[i15], cArr, i14);
                    i14++;
                } else if (b11 < -16) {
                    if (i15 >= i12 - 1) {
                        throw InvalidProtocolBufferException.a();
                    }
                    int i18 = i10 + 2;
                    i10 += 3;
                    a.c(b11, bArr[i15], bArr[i18], cArr, i14);
                    i14++;
                } else {
                    if (i15 >= i12 - 2) {
                        throw InvalidProtocolBufferException.a();
                    }
                    byte b13 = bArr[i15];
                    int i19 = i10 + 3;
                    byte b14 = bArr[i10 + 2];
                    i10 += 4;
                    a.a(b11, b13, b14, bArr[i19], cArr, i14);
                    i14 += 2;
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int b(byte[] bArr, int i10, int i11, String str) {
            int i12;
            int i13;
            char cCharAt;
            int length = str.length();
            int i14 = i11 + i10;
            int i15 = 0;
            while (i15 < length && (i13 = i15 + i10) < i14 && (cCharAt = str.charAt(i15)) < 128) {
                bArr[i13] = (byte) cCharAt;
                i15++;
            }
            if (i15 == length) {
                return i10 + length;
            }
            int i16 = i10 + i15;
            while (i15 < length) {
                char cCharAt2 = str.charAt(i15);
                if (cCharAt2 < 128 && i16 < i14) {
                    bArr[i16] = (byte) cCharAt2;
                    i16++;
                } else if (cCharAt2 < 2048 && i16 <= i14 - 2) {
                    int i17 = i16 + 1;
                    bArr[i16] = (byte) ((cCharAt2 >>> 6) | 960);
                    i16 += 2;
                    bArr[i17] = (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i16 > i14 - 3) {
                        if (i16 > i14 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i15 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i12)))) {
                                throw new UnpairedSurrogateException(i15, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i16);
                        }
                        int i18 = i15 + 1;
                        if (i18 != str.length()) {
                            char cCharAt3 = str.charAt(i18);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | TraceIdKeys.MAX_LENGTH);
                                int i19 = i16 + 3;
                                bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | TraceIdKeys.MAX_LENGTH);
                                i16 += 4;
                                bArr[i19] = (byte) ((codePoint & 63) | TraceIdKeys.MAX_LENGTH);
                                i15 = i18;
                            } else {
                                i15 = i18;
                            }
                        }
                        throw new UnpairedSurrogateException(i15 - 1, length);
                    }
                    bArr[i16] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i20 = i16 + 2;
                    bArr[i16 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | TraceIdKeys.MAX_LENGTH);
                    i16 += 3;
                    bArr[i20] = (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH);
                }
                i15++;
            }
            return i16;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int c(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 >= i11) {
                return 0;
            }
            while (i10 < i11) {
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 >= 0) {
                    i10 = i12;
                } else if (b10 < -32) {
                    if (i12 >= i11) {
                        return b10;
                    }
                    if (b10 < -62) {
                        return -1;
                    }
                    i10 += 2;
                    if (bArr[i12] > -65) {
                        return -1;
                    }
                } else if (b10 < -16) {
                    if (i12 >= i11 - 1) {
                        return Utf8.a(bArr, i12, i11);
                    }
                    int i13 = i10 + 2;
                    byte b11 = bArr[i12];
                    if (b11 > -65) {
                        return -1;
                    }
                    if (b10 == -32 && b11 < -96) {
                        return -1;
                    }
                    if (b10 == -19 && b11 >= -96) {
                        return -1;
                    }
                    i10 += 3;
                    if (bArr[i13] > -65) {
                        return -1;
                    }
                } else {
                    if (i12 >= i11 - 2) {
                        return Utf8.a(bArr, i12, i11);
                    }
                    int i14 = i10 + 2;
                    byte b12 = bArr[i12];
                    if (b12 > -65) {
                        return -1;
                    }
                    if ((((b12 + 112) + (b10 << 28)) >> 30) != 0) {
                        return -1;
                    }
                    int i15 = i10 + 3;
                    if (bArr[i14] > -65) {
                        return -1;
                    }
                    i10 += 4;
                    if (bArr[i15] > -65) {
                        return -1;
                    }
                }
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d extends b {
        public static int d(long j10, byte[] bArr, int i10, int i11) {
            if (i11 == 0) {
                b bVar = Utf8.f1765a;
                if (i10 > -12) {
                    return -1;
                }
                return i10;
            }
            if (i11 == 1) {
                return Utf8.c(i10, g1.f(bArr, j10));
            }
            if (i11 == 2) {
                return Utf8.d(i10, g1.f(bArr, j10), g1.f(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final String a(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
            if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (i10 < i12) {
                byte bF = g1.f(bArr, i10);
                if (bF < 0) {
                    break;
                }
                i10++;
                cArr[i13] = (char) bF;
                i13++;
            }
            int i14 = i13;
            while (i10 < i12) {
                int i15 = i10 + 1;
                byte bF2 = g1.f(bArr, i10);
                if (bF2 >= 0) {
                    int i16 = i14 + 1;
                    cArr[i14] = (char) bF2;
                    while (i15 < i12) {
                        byte bF3 = g1.f(bArr, i15);
                        if (bF3 < 0) {
                            break;
                        }
                        i15++;
                        cArr[i16] = (char) bF3;
                        i16++;
                    }
                    i14 = i16;
                    i10 = i15;
                } else if (bF2 < -32) {
                    if (i15 >= i12) {
                        throw InvalidProtocolBufferException.a();
                    }
                    i10 += 2;
                    a.b(bF2, g1.f(bArr, i15), cArr, i14);
                    i14++;
                } else if (bF2 < -16) {
                    if (i15 >= i12 - 1) {
                        throw InvalidProtocolBufferException.a();
                    }
                    int i17 = i10 + 2;
                    i10 += 3;
                    a.c(bF2, g1.f(bArr, i15), g1.f(bArr, i17), cArr, i14);
                    i14++;
                } else {
                    if (i15 >= i12 - 2) {
                        throw InvalidProtocolBufferException.a();
                    }
                    byte bF4 = g1.f(bArr, i15);
                    int i18 = i10 + 3;
                    byte bF5 = g1.f(bArr, i10 + 2);
                    i10 += 4;
                    a.a(bF2, bF4, bF5, g1.f(bArr, i18), cArr, i14);
                    i14 += 2;
                }
            }
            return new String(cArr, 0, i14);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int b(byte[] bArr, int i10, int i11, String str) {
            long j10;
            long j11;
            long j12;
            int i12;
            char cCharAt;
            long j13 = i10;
            long j14 = i11 + j13;
            int length = str.length();
            if (length > i11 || bArr.length - i11 < i10) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length - 1) + " at index " + (i10 + i11));
            }
            int i13 = 0;
            while (true) {
                j10 = 1;
                if (i13 >= length || (cCharAt = str.charAt(i13)) >= 128) {
                    break;
                }
                g1.j(bArr, j13, (byte) cCharAt);
                i13++;
                j13 = 1 + j13;
            }
            if (i13 == length) {
                return (int) j13;
            }
            while (i13 < length) {
                char cCharAt2 = str.charAt(i13);
                if (cCharAt2 < 128 && j13 < j14) {
                    g1.j(bArr, j13, (byte) cCharAt2);
                    j12 = j14;
                    j11 = j10;
                    j13 += j10;
                } else if (cCharAt2 >= 2048 || j13 > j14 - 2) {
                    j11 = j10;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j13 > j14 - 3) {
                        j12 = j14;
                        if (j13 > j12 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i13 + 1) == length || !Character.isSurrogatePair(cCharAt2, str.charAt(i12)))) {
                                throw new UnpairedSurrogateException(i13, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j13);
                        }
                        int i14 = i13 + 1;
                        if (i14 != length) {
                            char cCharAt3 = str.charAt(i14);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                g1.j(bArr, j13, (byte) ((codePoint >>> 18) | 240));
                                g1.j(bArr, j13 + j11, (byte) (((codePoint >>> 12) & 63) | TraceIdKeys.MAX_LENGTH));
                                long j15 = j13 + 3;
                                g1.j(bArr, j13 + 2, (byte) (((codePoint >>> 6) & 63) | TraceIdKeys.MAX_LENGTH));
                                j13 += 4;
                                g1.j(bArr, j15, (byte) ((codePoint & 63) | TraceIdKeys.MAX_LENGTH));
                                i13 = i14;
                            } else {
                                i13 = i14;
                            }
                        }
                        throw new UnpairedSurrogateException(i13 - 1, length);
                    }
                    g1.j(bArr, j13, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j16 = j13 + 2;
                    j12 = j14;
                    g1.j(bArr, j13 + j11, (byte) (((cCharAt2 >>> 6) & 63) | TraceIdKeys.MAX_LENGTH));
                    j13 += 3;
                    g1.j(bArr, j16, (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH));
                } else {
                    j11 = j10;
                    long j17 = j13 + j11;
                    g1.j(bArr, j13, (byte) ((cCharAt2 >>> 6) | 960));
                    j13 += 2;
                    g1.j(bArr, j17, (byte) ((cCharAt2 & '?') | TraceIdKeys.MAX_LENGTH));
                    j12 = j14;
                }
                i13++;
                j10 = j11;
                j14 = j12;
            }
            return (int) j13;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.b
        public final int c(byte[] bArr, int i10, int i11) {
            int i12;
            if ((i10 | i11 | (bArr.length - i11)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            long j10 = i10;
            int i13 = (int) (i11 - j10);
            if (i13 >= 16) {
                i12 = 0;
                long j11 = j10;
                while (true) {
                    if (i12 >= i13) {
                        i12 = i13;
                        break;
                    }
                    long j12 = j11 + 1;
                    if (g1.f(bArr, j11) < 0) {
                        break;
                    }
                    i12++;
                    j11 = j12;
                }
            } else {
                i12 = 0;
            }
            int i14 = i13 - i12;
            long j13 = j10 + i12;
            while (true) {
                byte bF = 0;
                while (true) {
                    if (i14 <= 0) {
                        break;
                    }
                    long j14 = j13 + 1;
                    bF = g1.f(bArr, j13);
                    if (bF < 0) {
                        j13 = j14;
                        break;
                    }
                    i14--;
                    j13 = j14;
                }
                if (i14 == 0) {
                    return 0;
                }
                int i15 = i14 - 1;
                if (bF < -32) {
                    if (i15 == 0) {
                        return bF;
                    }
                    i14 -= 2;
                    if (bF < -62) {
                        return -1;
                    }
                    long j15 = j13 + 1;
                    if (g1.f(bArr, j13) > -65) {
                        return -1;
                    }
                    j13 = j15;
                } else if (bF < -16) {
                    if (i15 < 2) {
                        return d(j13, bArr, bF, i15);
                    }
                    i14 -= 3;
                    long j16 = j13 + 1;
                    byte bF2 = g1.f(bArr, j13);
                    if (bF2 > -65) {
                        return -1;
                    }
                    if (bF == -32 && bF2 < -96) {
                        return -1;
                    }
                    if (bF == -19 && bF2 >= -96) {
                        return -1;
                    }
                    j13 += 2;
                    if (g1.f(bArr, j16) > -65) {
                        return -1;
                    }
                } else {
                    if (i15 < 3) {
                        return d(j13, bArr, bF, i15);
                    }
                    i14 -= 4;
                    long j17 = j13 + 1;
                    byte bF3 = g1.f(bArr, j13);
                    if (bF3 > -65) {
                        return -1;
                    }
                    if ((((bF3 + 112) + (bF << 28)) >> 30) != 0) {
                        return -1;
                    }
                    long j18 = 2 + j13;
                    if (g1.f(bArr, j17) > -65) {
                        return -1;
                    }
                    j13 += 3;
                    if (g1.f(bArr, j18) > -65) {
                        return -1;
                    }
                }
            }
        }
    }

    static {
        f1765a = (g1.f1820f && g1.f1819e && !androidx.datastore.preferences.protobuf.d.a()) ? new d() : new c();
    }

    public static int a(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            if (b10 > -12) {
                return -1;
            }
            return b10;
        }
        if (i12 == 1) {
            return c(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return d(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && str.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char cCharAt = str.charAt(i11);
            if (cCharAt < 2048) {
                i12 += (127 - cCharAt) >>> 31;
                i11++;
            } else {
                int length2 = str.length();
                while (i11 < length2) {
                    char cCharAt2 = str.charAt(i11);
                    if (cCharAt2 < 2048) {
                        i10 += (127 - cCharAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i11) < 65536) {
                                throw new UnpairedSurrogateException(i11, length2);
                            }
                            i11++;
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i12 + 4294967296L));
    }

    public static int c(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    public static int d(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }
}
