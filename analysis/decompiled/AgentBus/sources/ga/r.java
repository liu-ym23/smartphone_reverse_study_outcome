package ga;

/* loaded from: classes.dex */
public abstract class r extends q {
    public static boolean Z(String str, String str2, boolean z4) {
        q7.k.e(str, "<this>");
        q7.k.e(str2, "suffix");
        return !z4 ? str.endsWith(str2) : b0(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static boolean a0(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static boolean b0(String str, int i2, String str2, int i10, int i11, boolean z4) {
        q7.k.e(str, "<this>");
        q7.k.e(str2, "other");
        return !z4 ? str.regionMatches(i2, str2, i10, i11) : str.regionMatches(z4, i2, str2, i10, i11);
    }

    public static String c0(int i2, String str) {
        if (i2 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        int i10 = 1;
        if (i2 == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = str.charAt(0);
            char[] cArr = new char[i2];
            for (int i11 = 0; i11 < i2; i11++) {
                cArr[i11] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb2 = new StringBuilder(str.length() * i2);
        if (1 <= i2) {
            while (true) {
                sb2.append((CharSequence) str);
                if (i10 == i2) {
                    break;
                }
                i10++;
            }
        }
        String string = sb2.toString();
        q7.k.b(string);
        return string;
    }

    public static String d0(String str, char c10, char c11) {
        q7.k.e(str, "<this>");
        String strReplace = str.replace(c10, c11);
        q7.k.d(strReplace, "replace(...)");
        return strReplace;
    }

    public static String e0(String str, String str2, String str3) {
        q7.k.e(str, "<this>");
        int iP0 = k.p0(str, str2, 0, false);
        if (iP0 < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i10 = 0;
        do {
            sb2.append((CharSequence) str, i10, iP0);
            sb2.append(str3);
            i10 = iP0 + length;
            if (iP0 >= str.length()) {
                break;
            }
            iP0 = k.p0(str, str2, iP0 + i2, false);
        } while (iP0 > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public static boolean f0(int i2, String str, String str2, boolean z4) {
        q7.k.e(str, "<this>");
        return !z4 ? str.startsWith(str2, i2) : b0(str, i2, str2, 0, str2.length(), z4);
    }

    public static boolean g0(String str, String str2, boolean z4) {
        q7.k.e(str, "<this>");
        q7.k.e(str2, "prefix");
        return !z4 ? str.startsWith(str2) : b0(str, 0, str2, 0, str2.length(), z4);
    }

    public static Integer i0(String str) {
        boolean z4;
        int i2;
        int i10;
        q7.k.e(str, "<this>");
        ib.c.o(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        int i12 = -2147483647;
        if (q7.k.f(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z4 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i12 = Integer.MIN_VALUE;
                z4 = true;
            }
        } else {
            z4 = false;
            i2 = 0;
        }
        int i13 = -59652323;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / 10))) || (i10 = i11 * 10) < i12 + iDigit) {
                return null;
            }
            i11 = i10 - iDigit;
            i2++;
        }
        return z4 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    public static Long j0(String str) {
        boolean z4;
        q7.k.e(str, "<this>");
        ib.c.o(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        if (q7.k.f(cCharAt, 48) < 0) {
            z4 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z4 = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j2 = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z4 = false;
        }
        long j4 = 0;
        long j10 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j4 < j10) {
                if (j10 != -256204778801521550L) {
                    return null;
                }
                j10 = j2 / 10;
                if (j4 < j10) {
                    return null;
                }
            }
            long j11 = j4 * 10;
            long j12 = iDigit;
            if (j11 < j2 + j12) {
                return null;
            }
            j4 = j11 - j12;
            i2++;
        }
        return z4 ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
