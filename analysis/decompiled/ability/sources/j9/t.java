package j9;

import ca.AbstractC0897f;
import com.mdisdk.capability.framework.FrameworkRegister;

/* loaded from: classes4.dex */
public abstract class t extends s {
    public static boolean V(CharSequence charSequence, CharSequence charSequence2) {
        boolean z10 = charSequence instanceof String;
        if (z10 && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        if (z10 && (charSequence2 instanceof String)) {
            return kotlin.jvm.internal.k.b(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence != null && charSequence2 != null && charSequence.length() == charSequence2.length()) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (charSequence.charAt(i) == charSequence2.charAt(i)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean W(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(suffix, "suffix");
        return !z10 ? str.endsWith(suffix) : Z(str, str.length() - suffix.length(), true, suffix, 0, suffix.length());
    }

    public static boolean X(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static final void Y(String str) {
        throw new NumberFormatException(androidx.compose.foundation.b.m('\'', "Invalid number format: '", str));
    }

    public static boolean Z(String str, int i, boolean z10, String other, int i6, int i10) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        return !z10 ? str.regionMatches(i, other, i6, i10) : str.regionMatches(z10, i, other, i6, i10);
    }

    public static String a0(int i, String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.k("Count 'n' must be non-negative, but was ", i, '.').toString());
        }
        if (i == 0) {
            return "";
        }
        int i6 = 1;
        if (i == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = str.charAt(0);
            char[] cArr = new char[i];
            for (int i10 = 0; i10 < i; i10++) {
                cArr[i10] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(str.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append((CharSequence) str);
                if (i6 == i) {
                    break;
                }
                i6++;
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.k.c(string);
        return string;
    }

    public static String b0(String str, char c, char c2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        String strReplace = str.replace(c, c2);
        kotlin.jvm.internal.k.e(strReplace, "replace(...)");
        return strReplace;
    }

    public static String c0(String str, String oldValue, String newValue) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(oldValue, "oldValue");
        kotlin.jvm.internal.k.f(newValue, "newValue");
        int iN0 = m.n0(str, oldValue, 0, false);
        if (iN0 < 0) {
            return str;
        }
        int length = oldValue.length();
        int i = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i6 = 0;
        do {
            sb.append((CharSequence) str, i6, iN0);
            sb.append(newValue);
            i6 = iN0 + length;
            if (iN0 >= str.length()) {
                break;
            }
            iN0 = m.n0(str, oldValue, iN0 + i, false);
        } while (iN0 > 0);
        sb.append((CharSequence) str, i6, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static boolean d0(int i, String str, String str2, boolean z10) {
        kotlin.jvm.internal.k.f(str, "<this>");
        return !z10 ? str.startsWith(str2, i) : Z(str, i, z10, str2, 0, str2.length());
    }

    public static boolean e0(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : Z(str, 0, z10, prefix, 0, prefix.length());
    }

    public static Integer f0(String str) {
        boolean z10;
        int i;
        int i6;
        kotlin.jvm.internal.k.f(str, "<this>");
        AbstractC0897f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        int iG = kotlin.jvm.internal.k.g(cCharAt, 48);
        int i11 = FrameworkRegister.TYPE_ACTIVITY_MOVE_TO_FOREGROUND;
        if (iG < 0) {
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
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / 10))) || (i6 = i10 * 10) < i11 + iDigit) {
                return null;
            }
            i10 = i6 - iDigit;
            i++;
        }
        return z10 ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    public static Long g0(String str) {
        boolean z10;
        kotlin.jvm.internal.k.f(str, "<this>");
        AbstractC0897f.r(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        long j5 = -9223372036854775807L;
        if (kotlin.jvm.internal.k.g(cCharAt, 48) < 0) {
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
                j5 = Long.MIN_VALUE;
                i = 1;
            }
        } else {
            z10 = false;
        }
        long j6 = 0;
        long j10 = -256204778801521550L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j6 < j10) {
                if (j10 != -256204778801521550L) {
                    return null;
                }
                j10 = j5 / 10;
                if (j6 < j10) {
                    return null;
                }
            }
            long j11 = j6 * 10;
            long j12 = iDigit;
            if (j11 < j5 + j12) {
                return null;
            }
            j6 = j11 - j12;
            i++;
        }
        return z10 ? Long.valueOf(j6) : Long.valueOf(-j6);
    }
}
