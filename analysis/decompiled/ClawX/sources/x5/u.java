package x5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class u extends t {
    public static String U0(char[] cArr, int i8, int i9) {
        kotlin.jvm.internal.p.e(cArr, "<this>");
        a.a.i(i8, i9, cArr.length);
        return new String(cArr, i8, i9 - i8);
    }

    public static boolean V0(String str, String suffix, boolean z) {
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(suffix, "suffix");
        return !z ? str.endsWith(suffix) : Y0(str.length() - suffix.length(), 0, suffix.length(), str, suffix, true);
    }

    public static boolean W0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final void X0(String str) {
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static boolean Y0(int i8, int i9, int i10, String str, String other, boolean z) {
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(other, "other");
        return !z ? str.regionMatches(i8, other, i9, i10) : str.regionMatches(z, i8, other, i9, i10);
    }

    public static String Z0(String str, char c3, char c8) {
        kotlin.jvm.internal.p.e(str, "<this>");
        String strReplace = str.replace(c3, c8);
        kotlin.jvm.internal.p.d(strReplace, "replace(...)");
        return strReplace;
    }

    public static String a1(String str, String str2, String str3) {
        kotlin.jvm.internal.p.e(str, "<this>");
        int iO1 = n.o1(str, str2, 0, false);
        if (iO1 < 0) {
            return str;
        }
        int length = str2.length();
        int i8 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i9 = 0;
        do {
            sb.append((CharSequence) str, i9, iO1);
            sb.append(str3);
            i9 = iO1 + length;
            if (iO1 >= str.length()) {
                break;
            }
            iO1 = n.o1(str, str2, iO1 + i8, false);
        } while (iO1 > 0);
        sb.append((CharSequence) str, i9, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    public static boolean b1(String str, String str2, int i8, boolean z) {
        kotlin.jvm.internal.p.e(str, "<this>");
        return !z ? str.startsWith(str2, i8) : Y0(i8, 0, str2.length(), str, str2, z);
    }

    public static boolean c1(String str, String prefix, boolean z) {
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(prefix, "prefix");
        return !z ? str.startsWith(prefix) : Y0(0, 0, prefix.length(), str, prefix, z);
    }

    public static Integer d1(String str) {
        boolean z;
        int i8;
        int i9;
        kotlin.jvm.internal.p.e(str, "<this>");
        x.f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        int i11 = -2147483647;
        if (kotlin.jvm.internal.p.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i11 = Integer.MIN_VALUE;
                z = true;
            }
        } else {
            z = false;
            i8 = 0;
        }
        int i12 = -59652323;
        while (i8 < length) {
            int iDigit = Character.digit((int) str.charAt(i8), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / 10))) || (i9 = i10 * 10) < i11 + iDigit) {
                return null;
            }
            i10 = i9 - iDigit;
            i8++;
        }
        return z ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    public static Long e1(int i8, String str) {
        boolean z;
        kotlin.jvm.internal.p.e(str, "<this>");
        x.f.r(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        long j4 = -9223372036854775807L;
        if (kotlin.jvm.internal.p.g(cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i9 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j4 = Long.MIN_VALUE;
                i9 = 1;
            }
        } else {
            z = false;
        }
        long j8 = 0;
        long j9 = -256204778801521550L;
        while (i9 < length) {
            int iDigit = Character.digit((int) str.charAt(i9), i8);
            if (iDigit < 0) {
                return null;
            }
            if (j8 < j9) {
                if (j9 != -256204778801521550L) {
                    return null;
                }
                j9 = j4 / i8;
                if (j8 < j9) {
                    return null;
                }
            }
            long j10 = j8 * i8;
            long j11 = iDigit;
            if (j10 < j4 + j11) {
                return null;
            }
            j8 = j10 - j11;
            i9++;
        }
        return z ? Long.valueOf(j8) : Long.valueOf(-j8);
    }

    public static Long f1(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        return e1(10, str);
    }
}
