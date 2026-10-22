package hc;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends o {
    public static boolean X(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        charSequence.getClass();
        charSequence2.getClass();
        if (charSequence2 instanceof String) {
            if (e0(charSequence, (String) charSequence2, 0, z10, 2) >= 0) {
                return true;
            }
        } else if (c0(charSequence, charSequence2, 0, charSequence.length(), z10, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean Y(CharSequence charSequence, char c9) {
        charSequence.getClass();
        return d0(charSequence, c9, 0, 2) >= 0;
    }

    public static boolean Z(CharSequence charSequence, String str) {
        charSequence.getClass();
        return charSequence instanceof String ? o.P((String) charSequence, str, false) : k0(charSequence, charSequence.length() - str.length(), str, 0, str.length(), false);
    }

    public static boolean a0(String str, char c9) {
        return str.length() > 0 && com.stepos.statsrpk.h.m(str.charAt(str.length() - 1), c9, false);
    }

    public static final int b0(CharSequence charSequence, String str, int i, boolean z10) {
        charSequence.getClass();
        str.getClass();
        return (z10 || !(charSequence instanceof String)) ? c0(charSequence, str, i, charSequence.length(), z10, false) : ((String) charSequence).indexOf(str, i);
    }

    public static final int c0(CharSequence charSequence, CharSequence charSequence2, int i, int i3, boolean z10, boolean z11) {
        ec.f fVar;
        CharSequence charSequence3 = charSequence;
        CharSequence charSequence4 = charSequence2;
        int i10 = i;
        int i11 = i3;
        if (z11) {
            charSequence3.getClass();
            int length = charSequence3.length() - 1;
            if (i10 > length) {
                i10 = length;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            fVar = new ec.f(i10, i11, -1);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            int length2 = charSequence3.length();
            if (i11 > length2) {
                i11 = length2;
            }
            fVar = new ec.g(i10, i11, 1);
        }
        boolean z12 = charSequence3 instanceof String;
        int i12 = fVar.f3760g;
        int i13 = fVar.f3759f;
        int i14 = fVar.f3758c;
        if (z12 && (charSequence4 instanceof String)) {
            if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
                int i15 = i14;
                while (true) {
                    String str = (String) charSequence4;
                    if (!o.R(str, 0, (String) charSequence3, i15, str.length(), z10)) {
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
            while (!k0(charSequence4, 0, charSequence3, i14, charSequence4.length(), z10)) {
                if (i14 != i13) {
                    i14 += i12;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
            }
            return i14;
        }
        return -1;
    }

    public static int d0(CharSequence charSequence, char c9, int i, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? f0(charSequence, new char[]{c9}, i, false) : ((String) charSequence).indexOf(c9, i);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, String str, int i, boolean z10, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z10 = false;
        }
        return b0(charSequence, str, i, z10);
    }

    public static final int f0(CharSequence charSequence, char[] cArr, int i, boolean z10) {
        charSequence.getClass();
        if (!z10 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kb.k.t0(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c9 : cArr) {
                if (com.stepos.statsrpk.h.m(c9, cCharAt, z10)) {
                    return i;
                }
            }
            if (i == length) {
                return -1;
            }
            i++;
        }
    }

    public static boolean g0(CharSequence charSequence) {
        charSequence.getClass();
        for (int i = 0; i < charSequence.length(); i++) {
            if (!com.stepos.statsrpk.h.v(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int h0(CharSequence charSequence, char c9, int i, int i3) {
        if ((i3 & 2) != 0) {
            charSequence.getClass();
            i = charSequence.length() - 1;
        }
        charSequence.getClass();
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c9, i);
        }
        char[] cArr = {c9};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(kb.k.t0(cArr), i);
        }
        int length = charSequence.length() - 1;
        if (i > length) {
            i = length;
        }
        while (-1 < i) {
            if (com.stepos.statsrpk.h.m(cArr[0], charSequence.charAt(i), false)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static final gc.n i0(String str) {
        gc.n nVar = new gc.n(2);
        nVar.f4705b = str;
        VarHandle.storeStoreFence();
        return nVar;
    }

    public static String j0(int i, String str) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        if (i < 0) {
            g5.f.s(k0.a.k(i, "Desired length ", " is less than zero."));
            return null;
        }
        if (i <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i);
            int length = i - str.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb2.append('0');
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb2.append((CharSequence) str);
            charSequenceSubSequence = sb2;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean k0(CharSequence charSequence, int i, CharSequence charSequence2, int i3, int i10, boolean z10) {
        charSequence.getClass();
        charSequence2.getClass();
        if (i3 < 0 || i < 0 || i > charSequence.length() - i10 || i3 > charSequence2.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!com.stepos.statsrpk.h.m(charSequence.charAt(i + i11), charSequence2.charAt(i3 + i11), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String l0(String str, String str2) {
        str.getClass();
        return o.U(str, str2, false) ? str.substring(str2.length()) : str;
    }

    public static String m0(String str, String str2) {
        str.getClass();
        return (str.length() >= str2.length() + str2.length() && o.U(str, str2, false) && Z(str, str2)) ? str.substring(str2.length(), str.length() - str2.length()) : str;
    }

    public static final List n0(CharSequence charSequence, String str) {
        int iB0 = b0(charSequence, str, 0, false);
        if (iB0 == -1) {
            return ac.a.E(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iB0).toString());
            length = str.length() + iB0;
            iB0 = b0(charSequence, str, length, false);
        } while (iB0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List o0(CharSequence charSequence, String[] strArr) {
        charSequence.getClass();
        int i = 0;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return n0(charSequence, str);
            }
        }
        List listAsList = Arrays.asList(strArr);
        listAsList.getClass();
        p pVar = new p(i);
        pVar.f5466f = listAsList;
        VarHandle.storeStoreFence();
        gc.i iVar = new gc.i(charSequence, pVar);
        gc.p pVar2 = new gc.p(i);
        pVar2.f4707f = iVar;
        VarHandle.storeStoreFence();
        ArrayList arrayList = new ArrayList(kb.m.m0(pVar2, 10));
        Iterator it = iVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            ec.g gVar = (ec.g) bVar.next();
            gVar.getClass();
            arrayList.add(charSequence.subSequence(gVar.f3758c, gVar.f3759f + 1).toString());
        }
    }

    public static List p0(String str, char[] cArr) {
        str.getClass();
        int i = 0;
        int i3 = 1;
        if (cArr.length == 1) {
            return n0(str, String.valueOf(cArr[0]));
        }
        e9.m mVar = new e9.m(i3);
        mVar.f3688f = cArr;
        VarHandle.storeStoreFence();
        gc.i iVar = new gc.i(str, mVar);
        gc.p pVar = new gc.p(i);
        pVar.f4707f = iVar;
        VarHandle.storeStoreFence();
        ArrayList arrayList = new ArrayList(kb.m.m0(pVar, 10));
        Iterator it = iVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList;
            }
            ec.g gVar = (ec.g) bVar.next();
            gVar.getClass();
            arrayList.add(str.subSequence(gVar.f3758c, gVar.f3759f + 1).toString());
        }
    }

    public static String q0(String str, String str2) {
        int iE0 = e0(str, str2, 0, false, 6);
        return iE0 == -1 ? str : str.substring(str2.length() + iE0, str.length());
    }

    public static String r0(String str, char c9, String str2) {
        str.getClass();
        str2.getClass();
        int iH0 = h0(str, c9, 0, 6);
        return iH0 == -1 ? str2 : str.substring(iH0 + 1, str.length());
    }

    public static String s0(String str, char c9) {
        str.getClass();
        str.getClass();
        int iD0 = d0(str, c9, 0, 6);
        return iD0 == -1 ? str : str.substring(0, iD0);
    }

    public static String t0(int i, String str) {
        str.getClass();
        if (i < 0) {
            od.f.c(k0.a.k(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(0, i);
    }

    public static String u0(int i, String str) {
        str.getClass();
        if (i < 0) {
            od.f.c(k0.a.k(i, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        return str.substring(length - i);
    }

    public static Boolean v0(String str) {
        str.getClass();
        if (str.equals("true")) {
            return Boolean.TRUE;
        }
        if (str.equals("false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static CharSequence w0(CharSequence charSequence) {
        charSequence.getClass();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean zV = com.stepos.statsrpk.h.v(charSequence.charAt(!z10 ? i : length));
            if (z10) {
                if (!zV) {
                    break;
                }
                length--;
            } else if (zV) {
                i++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static String x0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        str.getClass();
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                char cCharAt = str.charAt(length);
                int length2 = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (cCharAt == cArr[i3]) {
                        break;
                    }
                    i3++;
                }
                if (!(i3 >= 0)) {
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
}
