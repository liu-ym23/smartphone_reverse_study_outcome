package w7;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f15287a;

    public a(String str) {
        this.f15287a = str;
    }

    public static String a(int i, String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1 && (iLastIndexOf = str.lastIndexOf(58)) != -1) {
            iLastIndexOf++;
        }
        return (iLastIndexOf == -1 || iLastIndexOf <= i) ? str : str.substring(0, iLastIndexOf);
    }

    public final a b(String str) {
        int iIndexOf;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ':') {
                break;
            }
            if (cCharAt == '/' || cCharAt == '?' || cCharAt == '#') {
                break;
            }
        }
        String strSubstring = this.f15287a;
        if (strSubstring != null) {
            if (str.startsWith("/")) {
                StringBuilder sb2 = new StringBuilder();
                int iIndexOf2 = strSubstring.indexOf("://");
                int iIndexOf3 = strSubstring.indexOf(47, iIndexOf2 == -1 ? 0 : iIndexOf2 + 3);
                if (iIndexOf3 != -1) {
                    strSubstring = strSubstring.substring(0, iIndexOf3);
                }
                str = androidx.activity.b.n(sb2, strSubstring, str);
            } else {
                int iIndexOf4 = strSubstring.indexOf("://");
                if (iIndexOf4 == -1) {
                    iIndexOf = strSubstring.indexOf(58);
                    if (iIndexOf == -1) {
                        iIndexOf = 0;
                    }
                } else {
                    iIndexOf = iIndexOf4 + 3;
                }
                String strA = a(iIndexOf, strSubstring);
                String[] strArrK = p5.f.K(str);
                for (int i3 = 0; i3 < strArrK.length; i3++) {
                    if ("..".equals(strArrK[i3])) {
                        strA = a(iIndexOf, strA);
                    } else if (!".".equals(strArrK[i3])) {
                        if (!strA.endsWith(":")) {
                            StringBuilder sbV = k0.a.v(strA, "/");
                            sbV.append(strArrK[i3]);
                            strA = sbV.toString();
                        } else if (strSubstring.length() <= strA.length() || strSubstring.charAt(strA.length()) != '/') {
                            StringBuilder sbC = w2.c.c(strA);
                            sbC.append(strArrK[i3]);
                            strA = sbC.toString();
                        } else {
                            StringBuilder sbV2 = k0.a.v(strA, "/");
                            sbV2.append(strArrK[i3]);
                            strA = sbV2.toString();
                        }
                    }
                }
                str = strA;
            }
        }
        return new a(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return Objects.equals(this.f15287a, ((a) obj).f15287a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f15287a);
    }

    public final String toString() {
        return this.f15287a;
    }
}
