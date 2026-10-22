package ga;

import d7.t;
import d7.z;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class k extends r {
    public static String A0(String str, String str2) {
        q7.k.e(str, "<this>");
        if (str.length() < str2.length() + str2.length() || !r.g0(str, str2, false) || !r.Z(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length(), str.length() - str2.length());
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void B0(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(n.f.c(i2, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List C0(int i2, CharSequence charSequence, String str) {
        B0(i2);
        int iP0 = p0(charSequence, str, 0, false);
        if (iP0 == -1 || i2 == 1) {
            return a.a.S(charSequence.toString());
        }
        boolean z4 = i2 > 0;
        int i10 = 10;
        if (z4 && i2 <= 10) {
            i10 = i2;
        }
        ArrayList arrayList = new ArrayList(i10);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iP0).toString());
            length = str.length() + iP0;
            if (z4 && arrayList.size() == i2 - 1) {
                break;
            }
            iP0 = p0(charSequence, str, length, false);
        } while (iP0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List D0(CharSequence charSequence, String[] strArr, int i2) {
        int i10 = (i2 & 4) != 0 ? 0 : 2;
        q7.k.e(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return C0(i10, charSequence, str);
            }
        }
        B0(i10);
        c<v7.d> cVar = new c(charSequence, i10, new b0.r(4, d7.n.S(strArr)));
        ArrayList arrayList = new ArrayList(t.A0(new d7.p(2, cVar), 10));
        for (v7.d dVar : cVar) {
            q7.k.e(dVar, "range");
            arrayList.add(charSequence.subSequence(dVar.f10523f, dVar.f10524g + 1).toString());
        }
        return arrayList;
    }

    public static List E0(String str, char[] cArr) {
        q7.k.e(str, "<this>");
        if (cArr.length == 1) {
            return C0(0, str, String.valueOf(cArr[0]));
        }
        B0(0);
        c<v7.d> cVar = new c(str, 0, new b0.r(3, cArr));
        ArrayList arrayList = new ArrayList(t.A0(new d7.p(2, cVar), 10));
        for (v7.d dVar : cVar) {
            q7.k.e(dVar, "range");
            arrayList.add(str.subSequence(dVar.f10523f, dVar.f10524g + 1).toString());
        }
        return arrayList;
    }

    public static String F0(String str, String str2, String str3) {
        q7.k.e(str2, "delimiter");
        int iR0 = r0(str, str2, 0, false, 6);
        if (iR0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iR0, str.length());
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String G0(char c10, String str, String str2) {
        q7.k.e(str, "<this>");
        q7.k.e(str2, "missingDelimiterValue");
        int iW0 = w0(str, c10, 0, 6);
        if (iW0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iW0 + 1, str.length());
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String H0(String str, String str2, String str3) {
        int iV0 = v0(6, str, str2);
        if (iV0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iV0, str.length());
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String I0(String str, char c10) {
        q7.k.e(str, "<this>");
        q7.k.e(str, "missingDelimiterValue");
        int iQ0 = q0(str, c10, 0, 6);
        if (iQ0 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iQ0);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String J0(String str, String str2) {
        q7.k.e(str, "<this>");
        q7.k.e(str, "missingDelimiterValue");
        int iR0 = r0(str, str2, 0, false, 6);
        if (iR0 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iR0);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String K0(String str, String str2, String str3) {
        q7.k.e(str, "<this>");
        int iV0 = v0(6, str, str2);
        if (iV0 == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iV0);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String L0(int i2, String str) {
        q7.k.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String M0(int i2, String str) {
        q7.k.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.f(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(length - i2);
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence N0(CharSequence charSequence) {
        q7.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z4 = false;
        while (i2 <= length) {
            boolean zE = ib.c.E(charSequence.charAt(!z4 ? i2 : length));
            if (z4) {
                if (!zE) {
                    break;
                }
                length--;
            } else if (zE) {
                i2++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static String O0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        q7.k.e(str, "<this>");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                char cCharAt = str.charAt(length);
                int length2 = cArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        i10 = -1;
                        break;
                    }
                    if (cCharAt == cArr[i10]) {
                        break;
                    }
                    i10++;
                }
                if (!(i10 >= 0)) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static String P0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        q7.k.e(str, "<this>");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            char cCharAt = str.charAt(i2);
            int length2 = cArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length2) {
                    i10 = -1;
                    break;
                }
                if (cCharAt == cArr[i10]) {
                    break;
                }
                i10++;
            }
            if (!(i10 >= 0)) {
                charSequenceSubSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequenceSubSequence.toString();
    }

    public static boolean k0(CharSequence charSequence, String str, boolean z4) {
        q7.k.e(charSequence, "<this>");
        return r0(charSequence, str, 0, z4, 2) >= 0;
    }

    public static boolean l0(CharSequence charSequence, char c10) {
        q7.k.e(charSequence, "<this>");
        return q0(charSequence, c10, 0, 2) >= 0;
    }

    public static String m0(String str) {
        int length = str.length() - 2;
        if (length < 0) {
            length = 0;
        }
        return L0(length, str);
    }

    public static boolean n0(String str, char c10) {
        q7.k.e(str, "<this>");
        return str.length() > 0 && ib.c.w(str.charAt(o0(str)), c10, false);
    }

    public static int o0(CharSequence charSequence) {
        q7.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int p0(CharSequence charSequence, String str, int i2, boolean z4) {
        q7.k.e(charSequence, "<this>");
        q7.k.e(str, "string");
        if (!z4 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        int length = charSequence.length();
        int i10 = i2 < 0 ? 0 : i2;
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        v7.d dVar = new v7.d(i10, length, 1);
        boolean z10 = charSequence instanceof String;
        int i11 = dVar.f10525h;
        int i12 = dVar.f10524g;
        int i13 = dVar.f10523f;
        if (!z10 || !(str instanceof String)) {
            if ((i11 <= 0 || i13 > i12) && (i11 >= 0 || i12 > i13)) {
                return -1;
            }
            while (!y0(str, 0, charSequence, i13, str.length(), z4)) {
                if (i13 == i12) {
                    return -1;
                }
                i13 += i11;
            }
            return i13;
        }
        if ((i11 <= 0 || i13 > i12) && (i11 >= 0 || i12 > i13)) {
            return -1;
        }
        int i14 = i13;
        while (!r.b0(str, 0, (String) charSequence, i14, str.length(), z4)) {
            if (i14 == i12) {
                return -1;
            }
            i14 += i11;
        }
        return i14;
    }

    public static int q0(CharSequence charSequence, char c10, int i2, int i10) {
        if ((i10 & 2) != 0) {
            i2 = 0;
        }
        q7.k.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? s0(charSequence, new char[]{c10}, i2, false) : ((String) charSequence).indexOf(c10, i2);
    }

    public static /* synthetic */ int r0(CharSequence charSequence, String str, int i2, boolean z4, int i10) {
        if ((i10 & 2) != 0) {
            i2 = 0;
        }
        if ((i10 & 4) != 0) {
            z4 = false;
        }
        return p0(charSequence, str, i2, z4);
    }

    public static final int s0(CharSequence charSequence, char[] cArr, int i2, boolean z4) {
        q7.k.e(charSequence, "<this>");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(d7.n.q0(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iO0 = o0(charSequence);
        if (i2 > iO0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            for (char c10 : cArr) {
                if (ib.c.w(c10, cCharAt, z4)) {
                    return i2;
                }
            }
            if (i2 == iO0) {
                return -1;
            }
            i2++;
        }
    }

    public static boolean t0(CharSequence charSequence) {
        q7.k.e(charSequence, "<this>");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (!ib.c.E(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static char u0(CharSequence charSequence) {
        if (charSequence.length() != 0) {
            return charSequence.charAt(o0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int v0(int i2, String str, String str2) {
        int iO0 = (i2 & 2) != 0 ? o0(str) : 0;
        q7.k.e(str, "<this>");
        q7.k.e(str2, "string");
        return str.lastIndexOf(str2, iO0);
    }

    public static int w0(String str, char c10, int i2, int i10) {
        if ((i10 & 2) != 0) {
            i2 = o0(str);
        }
        q7.k.e(str, "<this>");
        return str.lastIndexOf(c10, i2);
    }

    public static List x0(String str) {
        q7.k.e(str, "<this>");
        d dVar = new d(str);
        if (!dVar.hasNext()) {
            return z.f2978f;
        }
        Object next = dVar.next();
        if (!dVar.hasNext()) {
            return a.a.S(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (dVar.hasNext()) {
            arrayList.add(dVar.next());
        }
        return arrayList;
    }

    public static final boolean y0(CharSequence charSequence, int i2, CharSequence charSequence2, int i10, int i11, boolean z4) {
        q7.k.e(charSequence, "<this>");
        q7.k.e(charSequence2, "other");
        if (i10 < 0 || i2 < 0 || i2 > charSequence.length() - i11 || i10 > charSequence2.length() - i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!ib.c.w(charSequence.charAt(i2 + i12), charSequence2.charAt(i10 + i12), z4)) {
                return false;
            }
        }
        return true;
    }

    public static String z0(String str, String str2) {
        q7.k.e(str, "<this>");
        if (!r.g0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        q7.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
