package j9;

import D7.w;
import ca.AbstractC0897f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class m extends t {
    public static StringBuilder A0(String str, int i, int i6, CharSequence replacement) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(replacement, "replacement");
        if (i6 < i) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.o(i6, "End index (", i, ") is less than start index (", ")."));
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str, 0, i);
        sb.append(replacement);
        sb.append((CharSequence) str, i6, str.length());
        return sb;
    }

    public static final void B0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List C0(String str, CharSequence charSequence, int i) {
        B0(i);
        int iN0 = n0(charSequence, str, 0, false);
        if (iN0 == -1 || i == 1) {
            return H4.o.M(charSequence.toString());
        }
        boolean z10 = i > 0;
        int i6 = 10;
        if (z10 && i <= 10) {
            i6 = i;
        }
        ArrayList arrayList = new ArrayList(i6);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iN0).toString());
            length = str.length() + iN0;
            if (z10 && arrayList.size() == i - 1) {
                break;
            }
            iN0 = n0(charSequence, str, length, false);
        } while (iN0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List D0(CharSequence charSequence, String[] strArr, int i) {
        int i6 = (i & 4) != 0 ? 0 : 2;
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return C0(str, charSequence, i6);
            }
        }
        B0(i6);
        C1609c<Y7.f> c1609c = new C1609c(charSequence, i6, new com.stepos.motionkit.fx.material.c(D7.q.L(strArr), 1));
        ArrayList arrayList = new ArrayList(w.c0(new D7.s(c1609c, 6), 10));
        for (Y7.f range : c1609c) {
            kotlin.jvm.internal.k.f(range, "range");
            arrayList.add(charSequence.subSequence(range.f1569a, range.b + 1).toString());
        }
        return arrayList;
    }

    public static List E0(String str, char[] cArr) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (cArr.length == 1) {
            return C0(String.valueOf(cArr[0]), str, 0);
        }
        B0(0);
        C1609c<Y7.f> c1609c = new C1609c(str, 0, new G6.e(cArr, 6));
        ArrayList arrayList = new ArrayList(w.c0(new D7.s(c1609c, 6), 10));
        for (Y7.f range : c1609c) {
            kotlin.jvm.internal.k.f(range, "range");
            arrayList.add(str.subSequence(range.f1569a, range.b + 1).toString());
        }
        return arrayList;
    }

    public static boolean F0(String str, char c) {
        return str.length() > 0 && AbstractC0897f.w(str.charAt(0), c, false);
    }

    public static String G0(char c, String str, String str2) {
        int iP0 = p0(str, c, 0, 6);
        if (iP0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iP0 + 1, str.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String H0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(delimiter, "delimiter");
        kotlin.jvm.internal.k.f(missingDelimiterValue, "missingDelimiterValue");
        int iQ0 = q0(str, delimiter, 0, false, 6);
        if (iQ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(delimiter.length() + iQ0, str.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String I0(char c, String str, String missingDelimiterValue) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(missingDelimiterValue, "missingDelimiterValue");
        int iV0 = v0(str, c, 0, 6);
        if (iV0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iV0 + 1, str.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String J0(String str, String str2, String missingDelimiterValue) {
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(0, 6, str, str2);
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(str2.length() + iU0, str.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String K0(String missingDelimiterValue, char c) {
        kotlin.jvm.internal.k.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.k.f(missingDelimiterValue, "missingDelimiterValue");
        int iP0 = p0(missingDelimiterValue, c, 0, 6);
        if (iP0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iP0);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String L0(String missingDelimiterValue, String str) {
        kotlin.jvm.internal.k.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.k.f(missingDelimiterValue, "missingDelimiterValue");
        int iQ0 = q0(missingDelimiterValue, str, 0, false, 6);
        if (iQ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iQ0);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String M0(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        int iU0 = u0(0, 6, str, ".");
        if (iU0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iU0);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String N0(int i, String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String O0(int i, String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(length - i);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static Boolean P0(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (str.equals("true")) {
            return Boolean.TRUE;
        }
        if (str.equals("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static void Q0(CharSequence charSequence, Collection destination) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        for (int i = 0; i < charSequence.length(); i++) {
            destination.add(Character.valueOf(charSequence.charAt(i)));
        }
    }

    public static CharSequence R0(CharSequence charSequence) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean zF = AbstractC0897f.F(charSequence.charAt(!z10 ? i : length));
            if (z10) {
                if (!zF) {
                    break;
                }
                length--;
            } else if (zF) {
                i++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static String S0(String str, char... cArr) {
        int length = str.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            char cCharAt = str.charAt(!z10 ? i : length);
            int length2 = cArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length2) {
                    i6 = -1;
                    break;
                }
                if (cCharAt == cArr[i6]) {
                    break;
                }
                i6++;
            }
            boolean z11 = i6 >= 0;
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i++;
            } else {
                z10 = true;
            }
        }
        return str.subSequence(i, length + 1).toString();
    }

    public static String T0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.k.f(str, "<this>");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char cCharAt = str.charAt(length);
                int length2 = cArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        i6 = -1;
                        break;
                    }
                    if (cCharAt == cArr[i6]) {
                        break;
                    }
                    i6++;
                }
                if (!(i6 >= 0)) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static CharSequence U0(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!AbstractC0897f.F(str.charAt(i))) {
                return str.subSequence(i, str.length());
            }
        }
        return "";
    }

    public static boolean h0(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        if (other instanceof String) {
            if (q0(charSequence, (String) other, 0, z10, 2) >= 0) {
                return true;
            }
        } else if (o0(charSequence, other, 0, charSequence.length(), z10, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean i0(CharSequence charSequence, char c) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        return p0(charSequence, c, 0, 2) >= 0;
    }

    public static String j0(int i, String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(i);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean k0(CharSequence charSequence, String str) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        return charSequence instanceof String ? t.W((String) charSequence, str, false) : x0(charSequence, charSequence.length() - str.length(), str, 0, str.length(), false);
    }

    public static boolean l0(String str, char c) {
        kotlin.jvm.internal.k.f(str, "<this>");
        return str.length() > 0 && AbstractC0897f.w(str.charAt(m0(str)), c, false);
    }

    public static int m0(CharSequence charSequence) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int n0(CharSequence charSequence, String string, int i, boolean z10) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        kotlin.jvm.internal.k.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? o0(charSequence, string, i, charSequence.length(), z10, false) : ((String) charSequence).indexOf(string, i);
    }

    public static final int o0(CharSequence charSequence, CharSequence charSequence2, int i, int i6, boolean z10, boolean z11) {
        Y7.d dVar;
        CharSequence charSequence3 = charSequence2;
        int i10 = i;
        int i11 = i6;
        if (z11) {
            int iM0 = m0(charSequence);
            if (i10 > iM0) {
                i10 = iM0;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            dVar = new Y7.d(i10, i11, -1);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence.length();
            if (i11 > length) {
                i11 = length;
            }
            dVar = new Y7.f(i10, i11, 1);
        }
        boolean z12 = charSequence instanceof String;
        int i12 = dVar.c;
        int i13 = dVar.b;
        int i14 = dVar.f1569a;
        if (z12 && (charSequence3 instanceof String)) {
            if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
                int i15 = i14;
                while (true) {
                    String str = (String) charSequence3;
                    if (!t.Z(str, 0, z10, (String) charSequence, i15, str.length())) {
                        if (i15 == i13) {
                            break;
                        }
                        i15 += i12;
                    } else {
                        return i15;
                    }
                }
            }
        } else if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
            int i16 = i14;
            while (!x0(charSequence3, 0, charSequence, i16, charSequence3.length(), z10)) {
                if (i16 != i13) {
                    i16 += i12;
                    charSequence3 = charSequence2;
                }
            }
            return i16;
        }
        return -1;
    }

    public static int p0(CharSequence charSequence, char c, int i, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        return !(charSequence instanceof String) ? r0(charSequence, new char[]{c}, i, false) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int q0(CharSequence charSequence, String str, int i, boolean z10, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            z10 = false;
        }
        return n0(charSequence, str, i, z10);
    }

    public static final int r0(CharSequence charSequence, char[] cArr, int i, boolean z10) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i);
        }
        if (i < 0) {
            i = 0;
        }
        int iM0 = m0(charSequence);
        if (i > iM0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (AbstractC0897f.w(c, cCharAt, z10)) {
                    return i;
                }
            }
            if (i == iM0) {
                return -1;
            }
            i++;
        }
    }

    public static boolean s0(CharSequence charSequence) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!AbstractC0897f.F(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char t0(CharSequence charSequence) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(m0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int u0(int i, int i6, String str, String string) {
        if ((i6 & 2) != 0) {
            i = m0(str);
        }
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(string, "string");
        return str.lastIndexOf(string, i);
    }

    public static int v0(String str, char c, int i, int i6) {
        if ((i6 & 2) != 0) {
            i = m0(str);
        }
        kotlin.jvm.internal.k.f(str, "<this>");
        return str.lastIndexOf(c, i);
    }

    public static List w0(CharSequence charSequence) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        return kotlin.sequences.a.o0(new D7.t(charSequence, 7));
    }

    public static final boolean x0(CharSequence charSequence, int i, CharSequence other, int i6, int i10, boolean z10) {
        kotlin.jvm.internal.k.f(charSequence, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        if (i6 < 0 || i < 0 || i > charSequence.length() - i10 || i6 > other.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!AbstractC0897f.w(charSequence.charAt(i + i11), other.charAt(i6 + i11), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String y0(CharSequence prefix, String str) {
        CharSequence charSequence;
        String str2;
        boolean zX0;
        kotlin.jvm.internal.k.f(str, "<this>");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        if (prefix instanceof String) {
            zX0 = t.e0(str, (String) prefix, false);
            charSequence = prefix;
            str2 = str;
        } else {
            charSequence = prefix;
            str2 = str;
            zX0 = x0(str2, 0, charSequence, 0, prefix.length(), false);
        }
        if (!zX0) {
            return str2;
        }
        String strSubstring = str2.substring(charSequence.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String z0(String str, String str2) {
        kotlin.jvm.internal.k.f(str, "<this>");
        if (!k0(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - str2.length());
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
