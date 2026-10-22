package x5;

import c5.x;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class n extends u {
    public static final boolean A1(CharSequence charSequence, int i8, CharSequence other, int i9, int i10, boolean z) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        kotlin.jvm.internal.p.e(other, "other");
        if (i9 < 0 || i8 < 0 || i8 > charSequence.length() - i10 || i9 > other.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!x.f.N(charSequence.charAt(i8 + i11), other.charAt(i9 + i11), z)) {
                return false;
            }
        }
        return true;
    }

    public static String B1(String str, String prefix) {
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(prefix, "prefix");
        if (!I1(str, prefix, false)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String C1(String str, String suffix) {
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(suffix, "suffix");
        if (!k1(str, suffix)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String D1(String str, String str2) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (str.length() < str2.length() + str2.length() || !I1(str, str2, false) || !k1(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(str2.length(), str.length() - str2.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void E1(int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.j(i8, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List F1(int i8, String str, CharSequence charSequence) {
        E1(i8);
        int iO1 = o1(charSequence, str, 0, false);
        if (iO1 == -1 || i8 == 1) {
            return a.a.S(charSequence.toString());
        }
        boolean z = i8 > 0;
        int i9 = 10;
        if (z && i8 <= 10) {
            i9 = i8;
        }
        ArrayList arrayList = new ArrayList(i9);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iO1).toString());
            length = str.length() + iO1;
            if (z && arrayList.size() == i8 - 1) {
                break;
            }
            iO1 = o1(charSequence, str, length, false);
        } while (iO1 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List G1(CharSequence charSequence, String[] strArr, int i8, int i9) {
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return F1(i8, str, charSequence);
            }
        }
        E1(i8);
        x xVar = new x(1, new c(charSequence, i8, new com.stepos.stepclaw.c(9, c5.l.S(strArr))));
        ArrayList arrayList = new ArrayList(c5.o.n0(xVar, 10));
        Iterator it = xVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            u5.f range = (u5.f) bVar.next();
            kotlin.jvm.internal.p.e(range, "range");
            arrayList.add(charSequence.subSequence(range.f5663a, range.f5664b + 1).toString());
        }
    }

    public static List H1(String str, char[] cArr) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (cArr.length == 1) {
            return F1(0, String.valueOf(cArr[0]), str);
        }
        E1(0);
        x xVar = new x(1, new c(str, 0, new com.stepos.stepclaw.c(10, cArr)));
        ArrayList arrayList = new ArrayList(c5.o.n0(xVar, 10));
        Iterator it = xVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            u5.f range = (u5.f) bVar.next();
            kotlin.jvm.internal.p.e(range, "range");
            arrayList.add(str.subSequence(range.f5663a, range.f5664b + 1).toString());
        }
    }

    public static boolean I1(CharSequence charSequence, CharSequence prefix, boolean z) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        kotlin.jvm.internal.p.e(prefix, "prefix");
        return (!z && (charSequence instanceof String) && (prefix instanceof String)) ? u.c1((String) charSequence, (String) prefix, false) : A1(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static boolean J1(String str, char c3) {
        kotlin.jvm.internal.p.e(str, "<this>");
        return str.length() > 0 && x.f.N(str.charAt(0), c3, false);
    }

    public static String K1(String str, char c3, String str2) {
        int iQ1 = q1(str, c3, 0, 6);
        if (iQ1 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iQ1 + 1, str.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String L1(String missingDelimiterValue, String delimiter) {
        kotlin.jvm.internal.p.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.p.e(delimiter, "delimiter");
        kotlin.jvm.internal.p.e(missingDelimiterValue, "missingDelimiterValue");
        int iR1 = r1(missingDelimiterValue, delimiter, 0, false, 6);
        if (iR1 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(delimiter.length() + iR1, missingDelimiterValue.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String M1(String str, char c3, String str2) {
        int iW1 = w1(str, c3, 0, 6);
        if (iW1 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iW1 + 1, str.length());
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String N1(String missingDelimiterValue, char c3) {
        kotlin.jvm.internal.p.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.p.e(missingDelimiterValue, "missingDelimiterValue");
        int iQ1 = q1(missingDelimiterValue, c3, 0, 6);
        if (iQ1 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iQ1);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String O1(String missingDelimiterValue, String delimiter) {
        kotlin.jvm.internal.p.e(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.p.e(delimiter, "delimiter");
        kotlin.jvm.internal.p.e(missingDelimiterValue, "missingDelimiterValue");
        int iR1 = r1(missingDelimiterValue, delimiter, 0, false, 6);
        if (iR1 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iR1);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String P1(String str, String str2) {
        int iV1 = v1(6, str, str2);
        if (iV1 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iV1);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String Q1(int i8, String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i8 > length) {
            i8 = length;
        }
        String strSubstring = str.substring(0, i8);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String R1(int i8, String str) {
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i8 > length) {
            i8 = length;
        }
        String strSubstring = str.substring(length - i8);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static List S1(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        int length = str.length();
        if (length == 0) {
            return c5.s.f1092a;
        }
        if (length == 1) {
            return a.a.S(Character.valueOf(str.charAt(0)));
        }
        ArrayList arrayList = new ArrayList(str.length());
        for (int i8 = 0; i8 < str.length(); i8++) {
            arrayList.add(Character.valueOf(str.charAt(i8)));
        }
        return arrayList;
    }

    public static CharSequence T1(CharSequence charSequence) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i8 = 0;
        boolean z = false;
        while (i8 <= length) {
            boolean zJ0 = x.f.j0(charSequence.charAt(!z ? i8 : length));
            if (z) {
                if (!zJ0) {
                    break;
                }
                length--;
            } else if (zJ0) {
                i8++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i8, length + 1);
    }

    public static String U1(String str, char... cArr) {
        int length = str.length() - 1;
        int i8 = 0;
        boolean z = false;
        while (i8 <= length) {
            boolean zT = c5.l.T(cArr, str.charAt(!z ? i8 : length));
            if (z) {
                if (!zT) {
                    break;
                }
                length--;
            } else if (zT) {
                i8++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i8, length + 1).toString();
    }

    public static String V1(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.p.e(str, "<this>");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i8 = length - 1;
                if (!c5.l.T(cArr, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i8 < 0) {
                    break;
                }
                length = i8;
            }
            charSequenceSubSequence = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            charSequenceSubSequence = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return charSequenceSubSequence.toString();
    }

    public static CharSequence W1(String str) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            if (!x.f.j0(str.charAt(i8))) {
                return str.subSequence(i8, str.length());
            }
        }
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    public static String X1(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.p.e(str, "<this>");
        int length = str.length();
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                charSequenceSubSequence = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                break;
            }
            if (!c5.l.T(cArr, str.charAt(i8))) {
                charSequenceSubSequence = str.subSequence(i8, str.length());
                break;
            }
            i8++;
        }
        return charSequenceSubSequence.toString();
    }

    public static boolean g1(CharSequence charSequence, CharSequence other, boolean z) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        kotlin.jvm.internal.p.e(other, "other");
        if (other instanceof String) {
            if (r1(charSequence, (String) other, 0, z, 2) >= 0) {
                return true;
            }
        } else if (p1(charSequence, other, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean h1(CharSequence charSequence, char c3) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        return q1(charSequence, c3, 0, 2) >= 0;
    }

    public static String i1(int i8, String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i8 > length) {
            i8 = length;
        }
        String strSubstring = str.substring(i8);
        kotlin.jvm.internal.p.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence j1(StringBuilder sb) {
        int length = sb.length() - 1;
        if (length < 0) {
            length = 0;
        }
        if (length < 0) {
            throw new IllegalArgumentException(a8.b.k(length, "Requested character count ", " is less than zero.").toString());
        }
        int length2 = sb.length();
        if (length > length2) {
            length = length2;
        }
        return sb.subSequence(0, length);
    }

    public static boolean k1(CharSequence charSequence, CharSequence suffix) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        kotlin.jvm.internal.p.e(suffix, "suffix");
        return ((charSequence instanceof String) && (suffix instanceof String)) ? u.V0((String) charSequence, (String) suffix, false) : A1(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), false);
    }

    public static boolean l1(String str, char c3) {
        return str.length() > 0 && x.f.N(str.charAt(n1(str)), c3, false);
    }

    public static char m1(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        if (str.length() != 0) {
            return str.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int n1(CharSequence charSequence) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int o1(CharSequence charSequence, String string, int i8, boolean z) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        kotlin.jvm.internal.p.e(string, "string");
        return (z || !(charSequence instanceof String)) ? p1(charSequence, string, i8, charSequence.length(), z, false) : ((String) charSequence).indexOf(string, i8);
    }

    public static final int p1(CharSequence charSequence, CharSequence charSequence2, int i8, int i9, boolean z, boolean z2) {
        u5.d dVar;
        if (z2) {
            int iN1 = n1(charSequence);
            if (i8 > iN1) {
                i8 = iN1;
            }
            if (i9 < 0) {
                i9 = 0;
            }
            dVar = new u5.d(i8, i9, -1);
        } else {
            if (i8 < 0) {
                i8 = 0;
            }
            int length = charSequence.length();
            if (i9 > length) {
                i9 = length;
            }
            dVar = new u5.f(i8, i9, 1);
        }
        boolean z8 = charSequence instanceof String;
        int i10 = dVar.f5665c;
        int i11 = dVar.f5664b;
        int i12 = dVar.f5663a;
        if (!z8 || !(charSequence2 instanceof String)) {
            boolean z9 = z;
            if ((i10 > 0 && i12 <= i11) || (i10 < 0 && i11 <= i12)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z10 = z9;
                    z9 = z10;
                    if (!A1(charSequence4, 0, charSequence3, i12, charSequence2.length(), z10)) {
                        if (i12 == i11) {
                            break;
                        }
                        i12 += i10;
                        charSequence2 = charSequence4;
                        charSequence = charSequence3;
                    } else {
                        return i12;
                    }
                }
            }
        } else if ((i10 > 0 && i12 <= i11) || (i10 < 0 && i11 <= i12)) {
            int i13 = i12;
            while (true) {
                String str = (String) charSequence2;
                boolean z11 = z;
                if (!u.Y0(0, i13, str.length(), str, (String) charSequence, z11)) {
                    if (i13 == i11) {
                        break;
                    }
                    i13 += i10;
                    z = z11;
                } else {
                    return i13;
                }
            }
        }
        return -1;
    }

    public static int q1(CharSequence charSequence, char c3, int i8, int i9) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? s1(charSequence, new char[]{c3}, i8, false) : ((String) charSequence).indexOf(c3, i8);
    }

    public static /* synthetic */ int r1(CharSequence charSequence, String str, int i8, boolean z, int i9) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z = false;
        }
        return o1(charSequence, str, i8, z);
    }

    public static final int s1(CharSequence charSequence, char[] cArr, int i8, boolean z) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i8);
        }
        if (i8 < 0) {
            i8 = 0;
        }
        int iN1 = n1(charSequence);
        if (i8 > iN1) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i8);
            for (char c3 : cArr) {
                if (x.f.N(c3, cCharAt, z)) {
                    return i8;
                }
            }
            if (i8 == iN1) {
                return -1;
            }
            i8++;
        }
    }

    public static boolean t1(CharSequence charSequence) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            if (!x.f.j0(charSequence.charAt(i8))) {
                return false;
            }
        }
        return true;
    }

    public static char u1(CharSequence charSequence) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(n1(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int v1(int i8, String str, String string) {
        int iN1 = (i8 & 2) != 0 ? n1(str) : 0;
        kotlin.jvm.internal.p.e(str, "<this>");
        kotlin.jvm.internal.p.e(string, "string");
        return str.lastIndexOf(string, iN1);
    }

    public static int w1(String str, char c3, int i8, int i9) {
        if ((i9 & 2) != 0) {
            i8 = n1(str);
        }
        return str.lastIndexOf(c3, i8);
    }

    public static c5.k x1(CharSequence charSequence) {
        kotlin.jvm.internal.p.e(charSequence, "<this>");
        return new c5.k(5, charSequence);
    }

    public static List y1(String str) {
        kotlin.jvm.internal.p.e(str, "<this>");
        return w5.k.x0(x1(str));
    }

    public static String z1(int i8, String str) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.p.e(str, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(a8.b.k(i8, "Desired length ", " is less than zero."));
        }
        if (i8 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i8);
            int length = i8 - str.length();
            int i9 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i9 == length) {
                        break;
                    }
                    i9++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }
}
