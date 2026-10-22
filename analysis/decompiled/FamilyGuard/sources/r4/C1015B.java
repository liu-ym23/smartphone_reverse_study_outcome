package r4;

import W3.C0396g;
import W3.C0403n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import q4.InterfaceC0988b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: r4.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1015B extends C1042y {

    /* renamed from: r4.B$a */
    public static final class a implements InterfaceC0988b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f20081a;

        public a(CharSequence charSequence) {
            this.f20081a = charSequence;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<String> iterator() {
            return new C1022e(this.f20081a);
        }
    }

    static /* synthetic */ int A(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z5, boolean z6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            z6 = false;
        }
        return z(charSequence, charSequence2, i5, i6, z5, z6);
    }

    public static /* synthetic */ int B(CharSequence charSequence, char c6, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return x(charSequence, c6, i5, z5);
    }

    public static /* synthetic */ int C(CharSequence charSequence, String str, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return y(charSequence, str, i5, z5);
    }

    public static final int D(CharSequence charSequence, char[] cArr, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(cArr, "chars");
        if (!z5 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(C0396g.s(cArr), i5);
        }
        int iB = kotlin.ranges.l.b(i5, 0);
        int iW = w(charSequence);
        if (iB > iW) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c6 : cArr) {
                if (C1019b.d(c6, cCharAt, z5)) {
                    return iB;
                }
            }
            if (iB == iW) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean E(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        for (int i5 = 0; i5 < charSequence.length(); i5++) {
            if (!C1018a.c(charSequence.charAt(i5))) {
                return false;
            }
        }
        return true;
    }

    public static final int F(CharSequence charSequence, char c6, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? J(charSequence, new char[]{c6}, i5, z5) : ((String) charSequence).lastIndexOf(c6, i5);
    }

    public static final int G(CharSequence charSequence, String str, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(str, "string");
        return (z5 || !(charSequence instanceof String)) ? z(charSequence, str, i5, 0, z5, true) : ((String) charSequence).lastIndexOf(str, i5);
    }

    public static /* synthetic */ int H(CharSequence charSequence, char c6, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = w(charSequence);
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return F(charSequence, c6, i5, z5);
    }

    public static /* synthetic */ int I(CharSequence charSequence, String str, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = w(charSequence);
        }
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return G(charSequence, str, i5, z5);
    }

    public static final int J(CharSequence charSequence, char[] cArr, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(cArr, "chars");
        if (!z5 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(C0396g.s(cArr), i5);
        }
        for (int iE = kotlin.ranges.l.e(i5, w(charSequence)); -1 < iE; iE--) {
            char cCharAt = charSequence.charAt(iE);
            for (char c6 : cArr) {
                if (C1019b.d(c6, cCharAt, z5)) {
                    return iE;
                }
            }
        }
        return -1;
    }

    public static final InterfaceC0988b<String> K(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List<String> L(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        return q4.e.g(K(charSequence));
    }

    private static final InterfaceC0988b<kotlin.ranges.h> M(CharSequence charSequence, final char[] cArr, int i5, final boolean z5, int i6) {
        T(i6);
        return new C1021d(charSequence, i5, i6, new i4.p() { // from class: r4.z
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return C1015B.Q(cArr, z5, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    private static final InterfaceC0988b<kotlin.ranges.h> N(CharSequence charSequence, String[] strArr, int i5, final boolean z5, int i6) {
        T(i6);
        final List listC = C0396g.c(strArr);
        return new C1021d(charSequence, i5, i6, new i4.p() { // from class: r4.A
            @Override // i4.p
            public final Object invoke(Object obj, Object obj2) {
                return C1015B.R(listC, z5, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    static /* synthetic */ InterfaceC0988b O(CharSequence charSequence, char[] cArr, int i5, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return M(charSequence, cArr, i5, z5, i6);
    }

    static /* synthetic */ InterfaceC0988b P(CharSequence charSequence, String[] strArr, int i5, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z5 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return N(charSequence, strArr, i5, z5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.m Q(char[] cArr, boolean z5, CharSequence charSequence, int i5) {
        j4.k.g(charSequence, "$this$DelimitedRangesSequence");
        int iD = D(charSequence, cArr, i5, z5);
        if (iD < 0) {
            return null;
        }
        return V3.r.a(Integer.valueOf(iD), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.m R(List list, boolean z5, CharSequence charSequence, int i5) {
        j4.k.g(charSequence, "$this$DelimitedRangesSequence");
        V3.m<Integer, String> mVarV = v(charSequence, list, i5, z5, false);
        if (mVarV != null) {
            return V3.r.a(mVarV.c(), Integer.valueOf(mVarV.d().length()));
        }
        return null;
    }

    public static final boolean S(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(charSequence2, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > charSequence2.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!C1019b.d(charSequence.charAt(i5 + i8), charSequence2.charAt(i6 + i8), z5)) {
                return false;
            }
        }
        return true;
    }

    public static final void T(int i5) {
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5).toString());
    }

    public static final List<String> U(CharSequence charSequence, char[] cArr, boolean z5, int i5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(cArr, "delimiters");
        if (cArr.length == 1) {
            return W(charSequence, String.valueOf(cArr[0]), z5, i5);
        }
        Iterable iterableE = q4.e.e(O(charSequence, cArr, 0, z5, i5, 2, null));
        ArrayList arrayList = new ArrayList(C0403n.r(iterableE, 10));
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            arrayList.add(Z(charSequence, (kotlin.ranges.h) it.next()));
        }
        return arrayList;
    }

    public static final List<String> V(CharSequence charSequence, String[] strArr, boolean z5, int i5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return W(charSequence, str, z5, i5);
            }
        }
        Iterable iterableE = q4.e.e(P(charSequence, strArr, 0, z5, i5, 2, null));
        ArrayList arrayList = new ArrayList(C0403n.r(iterableE, 10));
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            arrayList.add(Z(charSequence, (kotlin.ranges.h) it.next()));
        }
        return arrayList;
    }

    private static final List<String> W(CharSequence charSequence, String str, boolean z5, int i5) {
        T(i5);
        int length = 0;
        int iY = y(charSequence, str, 0, z5);
        if (iY == -1 || i5 == 1) {
            return C0403n.b(charSequence.toString());
        }
        boolean z6 = i5 > 0;
        ArrayList arrayList = new ArrayList(z6 ? kotlin.ranges.l.e(i5, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iY).toString());
            length = str.length() + iY;
            if (z6 && arrayList.size() == i5 - 1) {
                break;
            }
            iY = y(charSequence, str, length, z5);
        } while (iY != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List X(CharSequence charSequence, char[] cArr, boolean z5, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return U(charSequence, cArr, z5, i5);
    }

    public static /* synthetic */ List Y(CharSequence charSequence, String[] strArr, boolean z5, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z5 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return V(charSequence, strArr, z5, i5);
    }

    public static final String Z(CharSequence charSequence, kotlin.ranges.h hVar) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(hVar, "range");
        return charSequence.subSequence(hVar.n().intValue(), hVar.m().intValue() + 1).toString();
    }

    public static final String a0(String str, char c6, String str2) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "missingDelimiterValue");
        int iB = B(str, c6, 0, false, 6, null);
        if (iB == -1) {
            return str2;
        }
        String strSubstring = str.substring(iB + 1, str.length());
        j4.k.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String b0(String str, String str2, String str3) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "delimiter");
        j4.k.g(str3, "missingDelimiterValue");
        int iC = C(str, str2, 0, false, 6, null);
        if (iC == -1) {
            return str3;
        }
        String strSubstring = str.substring(iC + str2.length(), str.length());
        j4.k.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String c0(String str, char c6, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return a0(str, c6, str2);
    }

    public static /* synthetic */ String d0(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return b0(str, str2, str3);
    }

    public static String e0(String str, char c6, String str2) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "missingDelimiterValue");
        int iH = H(str, c6, 0, false, 6, null);
        if (iH == -1) {
            return str2;
        }
        String strSubstring = str.substring(iH + 1, str.length());
        j4.k.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String f0(String str, char c6, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return e0(str, c6, str2);
    }

    public static final String g0(String str, char c6, String str2) {
        j4.k.g(str, "<this>");
        j4.k.g(str2, "missingDelimiterValue");
        int iH = H(str, c6, 0, false, 6, null);
        if (iH == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iH);
        j4.k.f(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String h0(String str, char c6, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return g0(str, c6, str2);
    }

    public static CharSequence i0(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z5 = false;
        while (i5 <= length) {
            boolean zC = C1018a.c(charSequence.charAt(!z5 ? i5 : length));
            if (z5) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i5++;
            } else {
                z5 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static boolean t(CharSequence charSequence, CharSequence charSequence2, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(charSequence2, "other");
        return charSequence2 instanceof String ? C(charSequence, (String) charSequence2, 0, z5, 2, null) >= 0 : A(charSequence, charSequence2, 0, charSequence.length(), z5, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean u(CharSequence charSequence, CharSequence charSequence2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return t(charSequence, charSequence2, z5);
    }

    private static final V3.m<Integer, String> v(CharSequence charSequence, Collection<String> collection, int i5, boolean z5, boolean z6) {
        CharSequence charSequence2;
        Object next;
        boolean z7;
        Object next2;
        if (!z5 && collection.size() == 1) {
            String str = (String) C0403n.O(collection);
            int iC = !z6 ? C(charSequence, str, i5, false, 4, null) : I(charSequence, str, i5, false, 4, null);
            if (iC < 0) {
                return null;
            }
            return V3.r.a(Integer.valueOf(iC), str);
        }
        CharSequence charSequence3 = charSequence;
        kotlin.ranges.f hVar = !z6 ? new kotlin.ranges.h(kotlin.ranges.l.b(i5, 0), charSequence3.length()) : kotlin.ranges.l.i(kotlin.ranges.l.e(i5, w(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iA = hVar.a();
            int iC2 = hVar.c();
            int iF = hVar.f();
            if ((iF > 0 && iA <= iC2) || (iF < 0 && iC2 <= iA)) {
                int i6 = iA;
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z7 = z5;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z7 = z5;
                        if (C1042y.m(str2, 0, (String) charSequence3, i6, str2.length(), z7)) {
                            break;
                        }
                        z5 = z7;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i6 == iC2) {
                            break;
                        }
                        i6 += iF;
                        z5 = z7;
                    } else {
                        return V3.r.a(Integer.valueOf(i6), str3);
                    }
                }
            }
        } else {
            boolean z8 = z5;
            int iA2 = hVar.a();
            int iC3 = hVar.c();
            int iF2 = hVar.f();
            if ((iF2 > 0 && iA2 <= iC3) || (iF2 < 0 && iC3 <= iA2)) {
                int i7 = iA2;
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z9 = z8;
                        charSequence2 = charSequence3;
                        z8 = z9;
                        if (S(str4, 0, charSequence2, i7, str4.length(), z9)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i7 == iC3) {
                            break;
                        }
                        i7 += iF2;
                        charSequence3 = charSequence2;
                    } else {
                        return V3.r.a(Integer.valueOf(i7), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final int w(CharSequence charSequence) {
        j4.k.g(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int x(CharSequence charSequence, char c6, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        return (z5 || !(charSequence instanceof String)) ? D(charSequence, new char[]{c6}, i5, z5) : ((String) charSequence).indexOf(c6, i5);
    }

    public static final int y(CharSequence charSequence, String str, int i5, boolean z5) {
        j4.k.g(charSequence, "<this>");
        j4.k.g(str, "string");
        return (z5 || !(charSequence instanceof String)) ? A(charSequence, str, i5, charSequence.length(), z5, false, 16, null) : ((String) charSequence).indexOf(str, i5);
    }

    private static final int z(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z5, boolean z6) {
        kotlin.ranges.f hVar = !z6 ? new kotlin.ranges.h(kotlin.ranges.l.b(i5, 0), kotlin.ranges.l.e(i6, charSequence.length())) : kotlin.ranges.l.i(kotlin.ranges.l.e(i5, w(charSequence)), kotlin.ranges.l.b(i6, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iA = hVar.a();
            int iC = hVar.c();
            int iF = hVar.f();
            if ((iF <= 0 || iA > iC) && (iF >= 0 || iC > iA)) {
                return -1;
            }
            int i7 = iA;
            while (true) {
                String str = (String) charSequence2;
                boolean z7 = z5;
                if (C1042y.m(str, 0, (String) charSequence, i7, str.length(), z7)) {
                    return i7;
                }
                if (i7 == iC) {
                    return -1;
                }
                i7 += iF;
                z5 = z7;
            }
        } else {
            boolean z8 = z5;
            int iA2 = hVar.a();
            int iC2 = hVar.c();
            int iF2 = hVar.f();
            if ((iF2 <= 0 || iA2 > iC2) && (iF2 >= 0 || iC2 > iA2)) {
                return -1;
            }
            int i8 = iA2;
            while (true) {
                boolean z9 = z8;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z8 = z9;
                if (S(charSequence4, 0, charSequence3, i8, charSequence2.length(), z9)) {
                    return i8;
                }
                if (i8 == iC2) {
                    return -1;
                }
                i8 += iF2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }
}
