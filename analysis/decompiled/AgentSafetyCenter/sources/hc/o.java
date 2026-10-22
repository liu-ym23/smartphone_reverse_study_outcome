package hc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o extends n {
    public static boolean P(String str, String str2, boolean z10) {
        str.getClass();
        return !z10 ? str.endsWith(str2) : str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static boolean Q(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final boolean R(String str, int i, String str2, int i3, int i10, boolean z10) {
        str.getClass();
        str2.getClass();
        return !z10 ? str.regionMatches(i, str2, i3, i10) : str.regionMatches(z10, i, str2, i3, i10);
    }

    public static String S(String str, String str2, String str3) {
        str.getClass();
        int iB0 = h.b0(str, str2, 0, false);
        if (iB0 < 0) {
            return str;
        }
        int length = str2.length();
        int i = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb2.append((CharSequence) str, i3, iB0);
            sb2.append(str3);
            i3 = iB0 + length;
            if (iB0 >= str.length()) {
                break;
            }
            iB0 = h.b0(str, str2, iB0 + i, false);
        } while (iB0 > 0);
        sb2.append((CharSequence) str, i3, str.length());
        return sb2.toString();
    }

    public static boolean T(String str, String str2, int i, boolean z10) {
        str.getClass();
        return !z10 ? str.startsWith(str2, i) : R(str, i, str2, 0, str2.length(), z10);
    }

    public static boolean U(String str, String str2, boolean z10) {
        str.getClass();
        return !z10 ? str.startsWith(str2) : R(str, 0, str2, 0, str2.length(), z10);
    }

    public static Integer V(String str) {
        boolean z10;
        int i;
        int i3;
        com.stepos.statsrpk.h.f(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        int i11 = -2147483647;
        if (yb.k.b(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z10 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i11 = Integer.MIN_VALUE;
                z10 = true;
            }
        } else {
            z10 = false;
            i = 0;
        }
        int i12 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / 10))) || (i3 = i10 * 10) < i11 + iDigit) {
                return null;
            }
            i10 = i3 - iDigit;
            i++;
        }
        return z10 ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    public static Long W(String str) {
        boolean z10;
        str.getClass();
        com.stepos.statsrpk.h.f(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        long j10 = -9223372036854775807L;
        if (yb.k.b(cCharAt, 48) < 0) {
            z10 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z10 = false;
                i = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j10 = Long.MIN_VALUE;
                i = 1;
            }
        } else {
            z10 = false;
        }
        long j11 = 0;
        long j12 = -256204778801521550L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j11 < j12) {
                if (j12 != -256204778801521550L) {
                    return null;
                }
                j12 = j10 / 10;
                if (j11 < j12) {
                    return null;
                }
            }
            long j13 = j11 * 10;
            long j14 = iDigit;
            if (j13 < j10 + j14) {
                return null;
            }
            j11 = j13 - j14;
            i++;
        }
        return z10 ? Long.valueOf(j11) : Long.valueOf(-j11);
    }
}
