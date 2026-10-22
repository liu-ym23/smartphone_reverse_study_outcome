package gc;

import androidx.datastore.preferences.protobuf.b1;
import gc.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class q extends o {
    public static String A0(String str, String str2) {
        if (!o.e0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - str2.length());
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void B0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List C0(int i10, CharSequence charSequence, String str) {
        B0(i10);
        int iO0 = o0(charSequence, str, 0, false);
        if (iO0 == -1 || i10 == 1) {
            return b1.P(charSequence.toString());
        }
        boolean z = i10 > 0;
        int i11 = 10;
        if (z && i10 <= 10) {
            i11 = i10;
        }
        ArrayList arrayList = new ArrayList(i11);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iO0).toString());
            length = str.length() + iO0;
            if (z && arrayList.size() == i10 - 1) {
                break;
            }
            iO0 = o0(charSequence, str, length, false);
        } while (iO0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List D0(CharSequence charSequence, String[] strArr, int i10) {
        int i11 = (i10 & 4) != 0 ? 0 : 6;
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return C0(i11, charSequence, str);
            }
        }
        B0(i11);
        final List listG = b1.g(strArr);
        fc.n nVar = new fc.n(new b(charSequence, i11, new zb.p() { // from class: gc.p
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:6:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:6:0x002b A[EDGE_INSN: B:52:0x002b->B:6:0x002b BREAK  A[LOOP:0: B:18:0x0057->B:29:0x0088]] */
            @Override // zb.p
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke(java.lang.Object r17, java.lang.Object r18) {
                /*
                    r16 = this;
                    r2 = r17
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    r0 = r18
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    java.lang.String r1 = "$this$DelimitedRangesSequence"
                    kotlin.jvm.internal.g.f(r2, r1)
                    r1 = r16
                    java.util.List r6 = r1
                    int r1 = r6.size()
                    r3 = 0
                    r4 = 1
                    r7 = 0
                    if (r1 != r4) goto L39
                    java.lang.Object r1 = kotlin.collections.a.G0(r6)
                    java.lang.String r1 = (java.lang.String) r1
                    r4 = 4
                    int r0 = gc.q.r0(r2, r1, r0, r3, r4)
                    if (r0 >= 0) goto L2e
                L2b:
                    r2 = r7
                    goto Lc4
                L2e:
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                    kotlin.Pair r2 = new kotlin.Pair
                    r2.<init>(r0, r1)
                    goto Lc4
                L39:
                    dc.e r1 = new dc.e
                    if (r0 >= 0) goto L3e
                    r0 = r3
                L3e:
                    int r3 = r2.length()
                    r1.<init>(r0, r3, r4)
                    boolean r3 = r2 instanceof java.lang.String
                    r13 = 0
                    int r14 = r1.f8453c
                    int r15 = r1.f8452b
                    if (r3 == 0) goto L8a
                    if (r14 <= 0) goto L52
                    if (r0 <= r15) goto L56
                L52:
                    if (r14 >= 0) goto L2b
                    if (r15 > r0) goto L2b
                L56:
                    r9 = r0
                L57:
                    java.util.Iterator r0 = r6.iterator()
                L5b:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L77
                    java.lang.Object r1 = r0.next()
                    r11 = r1
                    java.lang.String r11 = (java.lang.String) r11
                    r12 = r2
                    java.lang.String r12 = (java.lang.String) r12
                    int r10 = r11.length()
                    r8 = 0
                    boolean r3 = gc.o.g0(r8, r9, r10, r11, r12, r13)
                    if (r3 == 0) goto L5b
                    goto L78
                L77:
                    r1 = r7
                L78:
                    java.lang.String r1 = (java.lang.String) r1
                    if (r1 == 0) goto L86
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
                    kotlin.Pair r2 = new kotlin.Pair
                    r2.<init>(r0, r1)
                    goto Lc4
                L86:
                    if (r9 == r15) goto L2b
                    int r9 = r9 + r14
                    goto L57
                L8a:
                    if (r14 <= 0) goto L8e
                    if (r0 <= r15) goto L92
                L8e:
                    if (r14 >= 0) goto L2b
                    if (r15 > r0) goto L2b
                L92:
                    r3 = r0
                L93:
                    java.util.Iterator r8 = r6.iterator()
                L97:
                    boolean r0 = r8.hasNext()
                    if (r0 == 0) goto Lb1
                    java.lang.Object r9 = r8.next()
                    r0 = r9
                    java.lang.String r0 = (java.lang.String) r0
                    r1 = 0
                    int r4 = r0.length()
                    r5 = r13
                    boolean r0 = gc.q.y0(r0, r1, r2, r3, r4, r5)
                    if (r0 == 0) goto L97
                    goto Lb2
                Lb1:
                    r9 = r7
                Lb2:
                    java.lang.String r9 = (java.lang.String) r9
                    if (r9 == 0) goto Lc0
                    java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
                    kotlin.Pair r2 = new kotlin.Pair
                    r2.<init>(r0, r9)
                    goto Lc4
                Lc0:
                    if (r3 == r15) goto L2b
                    int r3 = r3 + r14
                    goto L93
                Lc4:
                    if (r2 == 0) goto Lda
                    A r0 = r2.f9985a
                    B r1 = r2.f9986b
                    java.lang.String r1 = (java.lang.String) r1
                    int r1 = r1.length()
                    java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                    kotlin.Pair r2 = new kotlin.Pair
                    r2.<init>(r0, r1)
                    return r2
                Lda:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: gc.p.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }), 0);
        ArrayList arrayList = new ArrayList(mb.m.Z(nVar, 10));
        Iterator it = nVar.iterator();
        while (true) {
            b.a aVar = (b.a) it;
            if (!aVar.hasNext()) {
                return arrayList;
            }
            dc.e range = (dc.e) aVar.next();
            kotlin.jvm.internal.g.f(range, "range");
            arrayList.add(charSequence.subSequence(range.f8451a, range.f8452b + 1).toString());
        }
    }

    public static List E0(String str, char[] cArr) {
        kotlin.jvm.internal.g.f(str, "<this>");
        if (cArr.length == 1) {
            return C0(0, str, String.valueOf(cArr[0]));
        }
        B0(0);
        fc.n nVar = new fc.n(new b(str, 0, new b6.c(cArr, 4)), 0);
        ArrayList arrayList = new ArrayList(mb.m.Z(nVar, 10));
        Iterator it = nVar.iterator();
        while (true) {
            b.a aVar = (b.a) it;
            if (!aVar.hasNext()) {
                return arrayList;
            }
            dc.e range = (dc.e) aVar.next();
            kotlin.jvm.internal.g.f(range, "range");
            arrayList.add(str.subSequence(range.f8451a, range.f8452b + 1).toString());
        }
    }

    public static boolean F0(CharSequence prefix, String str) {
        kotlin.jvm.internal.g.f(prefix, "prefix");
        return prefix instanceof String ? o.k0(str, (String) prefix, false) : y0(str, 0, prefix, 0, prefix.length(), false);
    }

    public static String G0(String missingDelimiterValue, String delimiter) {
        kotlin.jvm.internal.g.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.g.f(delimiter, "delimiter");
        kotlin.jvm.internal.g.f(missingDelimiterValue, "missingDelimiterValue");
        int iR0 = r0(missingDelimiterValue, delimiter, 0, false, 6);
        if (iR0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(delimiter.length() + iR0, missingDelimiterValue.length());
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String H0(String str, char c9, String missingDelimiterValue) {
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(missingDelimiterValue, "missingDelimiterValue");
        int iV0 = v0(str, c9, 0, 6);
        if (iV0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iV0 + 1, str.length());
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String I0(String missingDelimiterValue) {
        kotlin.jvm.internal.g.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.g.f(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(6, missingDelimiterValue, ".");
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(1 + iU0, missingDelimiterValue.length());
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String J0(String missingDelimiterValue, char c9) {
        kotlin.jvm.internal.g.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.g.f(missingDelimiterValue, "missingDelimiterValue");
        int iQ0 = q0(missingDelimiterValue, c9, 0, 6);
        if (iQ0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iQ0);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String K0(String missingDelimiterValue, String str) {
        kotlin.jvm.internal.g.f(missingDelimiterValue, "<this>");
        kotlin.jvm.internal.g.f(missingDelimiterValue, "missingDelimiterValue");
        int iR0 = r0(missingDelimiterValue, str, 0, false, 6);
        if (iR0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iR0);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence L0(CharSequence charSequence) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z = false;
        while (i10 <= length) {
            boolean zN = b1.N(charSequence.charAt(!z ? i10 : length));
            if (z) {
                if (!zN) {
                    break;
                }
                length--;
            } else if (zN) {
                i10++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static String M0(String str, char... cArr) {
        kotlin.jvm.internal.g.f(str, "<this>");
        int length = str.length() - 1;
        int i10 = 0;
        boolean z = false;
        while (i10 <= length) {
            boolean zB0 = mb.l.b0(cArr, str.charAt(!z ? i10 : length));
            if (z) {
                if (!zB0) {
                    break;
                }
                length--;
            } else if (zB0) {
                i10++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i10, length + 1).toString();
    }

    public static CharSequence N0(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        int length = str.length() - 1;
        if (length < 0) {
            return "";
        }
        while (true) {
            int i10 = length - 1;
            if (!b1.N(str.charAt(length))) {
                return str.subSequence(0, length + 1);
            }
            if (i10 < 0) {
                return "";
            }
            length = i10;
        }
    }

    public static String O0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.g.f(str, "<this>");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (!mb.l.b0(cArr, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static String P0(String str, char... cArr) {
        CharSequence charSequenceSubSequence;
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!mb.l.b0(cArr, str.charAt(i10))) {
                charSequenceSubSequence = str.subSequence(i10, str.length());
                break;
            }
            i10++;
        }
        return charSequenceSubSequence.toString();
    }

    public static boolean l0(CharSequence charSequence, CharSequence other, boolean z) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        kotlin.jvm.internal.g.f(other, "other");
        if (other instanceof String) {
            if (r0(charSequence, (String) other, 0, z, 2) >= 0) {
                return true;
            }
        } else if (p0(charSequence, other, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean m0(CharSequence charSequence, char c9) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        return q0(charSequence, c9, 0, 2) >= 0;
    }

    public static int n0(CharSequence charSequence) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int o0(CharSequence charSequence, String string, int i10, boolean z) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        kotlin.jvm.internal.g.f(string, "string");
        return (z || !(charSequence instanceof String)) ? p0(charSequence, string, i10, charSequence.length(), z, false) : ((String) charSequence).indexOf(string, i10);
    }

    public static final int p0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z, boolean z3) {
        dc.c cVar;
        if (z3) {
            int iN0 = n0(charSequence);
            if (i10 > iN0) {
                i10 = iN0;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            cVar = new dc.c(i10, i11, -1);
        } else {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = charSequence.length();
            if (i11 > length) {
                i11 = length;
            }
            cVar = new dc.e(i10, i11, 1);
        }
        boolean z10 = charSequence instanceof String;
        int i12 = cVar.f8453c;
        int i13 = cVar.f8452b;
        int i14 = cVar.f8451a;
        if (!z10 || !(charSequence2 instanceof String)) {
            boolean z11 = z;
            if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z12 = z11;
                    z11 = z12;
                    if (!y0(charSequence4, 0, charSequence3, i14, charSequence2.length(), z12)) {
                        if (i14 == i13) {
                            break;
                        }
                        i14 += i12;
                        charSequence2 = charSequence4;
                        charSequence = charSequence3;
                    } else {
                        return i14;
                    }
                }
            }
        } else if ((i12 > 0 && i14 <= i13) || (i12 < 0 && i13 <= i14)) {
            int i15 = i14;
            while (true) {
                String str = (String) charSequence2;
                boolean z13 = z;
                if (!o.g0(0, i15, str.length(), str, (String) charSequence, z13)) {
                    if (i15 == i13) {
                        break;
                    }
                    i15 += i12;
                    z = z13;
                } else {
                    return i15;
                }
            }
        }
        return -1;
    }

    public static int q0(CharSequence charSequence, char c9, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        return !(charSequence instanceof String) ? s0(charSequence, new char[]{c9}, i10, false) : ((String) charSequence).indexOf(c9, i10);
    }

    public static /* synthetic */ int r0(CharSequence charSequence, String str, int i10, boolean z, int i11) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z = false;
        }
        return o0(charSequence, str, i10, z);
    }

    public static final int s0(CharSequence charSequence, char[] cArr, int i10, boolean z) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i10);
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int iN0 = n0(charSequence);
        if (i10 > iN0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i10);
            for (char c9 : cArr) {
                if (b1.E(c9, cCharAt, z)) {
                    return i10;
                }
            }
            if (i10 == iN0) {
                return -1;
            }
            i10++;
        }
    }

    public static boolean t0(CharSequence charSequence) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!b1.N(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static int u0(int i10, String str, String string) {
        int iN0 = (i10 & 2) != 0 ? n0(str) : 0;
        kotlin.jvm.internal.g.f(str, "<this>");
        kotlin.jvm.internal.g.f(string, "string");
        return str.lastIndexOf(string, iN0);
    }

    public static int v0(String str, char c9, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i10 = n0(str);
        }
        kotlin.jvm.internal.g.f(str, "<this>");
        return str.lastIndexOf(c9, i10);
    }

    public static List w0(String str) {
        kotlin.jvm.internal.g.f(str, "<this>");
        f fVar = new f(str);
        if (!fVar.hasNext()) {
            return EmptyList.f10001a;
        }
        String next = fVar.next();
        if (!fVar.hasNext()) {
            return b1.P(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (fVar.hasNext()) {
            arrayList.add(fVar.next());
        }
        return arrayList;
    }

    public static String x0(int i10, String str) {
        CharSequence charSequenceSubSequence;
        kotlin.jvm.internal.g.f(str, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Desired length ", " is less than zero."));
        }
        if (i10 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i10);
            int length = i10 - str.length();
            int i11 = 1;
            if (1 <= length) {
                while (true) {
                    sb2.append('0');
                    if (i11 == length) {
                        break;
                    }
                    i11++;
                }
            }
            sb2.append((CharSequence) str);
            charSequenceSubSequence = sb2;
        }
        return charSequenceSubSequence.toString();
    }

    public static final boolean y0(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z) {
        kotlin.jvm.internal.g.f(charSequence, "<this>");
        kotlin.jvm.internal.g.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b1.E(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z)) {
                return false;
            }
        }
        return true;
    }

    public static String z0(String str, String prefix) {
        kotlin.jvm.internal.g.f(prefix, "prefix");
        if (!F0(prefix, str)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
