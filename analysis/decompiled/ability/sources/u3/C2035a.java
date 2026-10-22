package u3;

import ca.AbstractC0897f;
import java.util.Objects;

/* renamed from: u3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2035a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6694a;

    public C2035a(String str) {
        this.f6694a = str;
    }

    public static String a(int i, String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1 && (iLastIndexOf = str.lastIndexOf(58)) != -1) {
            iLastIndexOf++;
        }
        return (iLastIndexOf == -1 || iLastIndexOf <= i) ? str : str.substring(0, iLastIndexOf);
    }

    public final C2035a b(String str) {
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
        String strSubstring = this.f6694a;
        if (strSubstring != null) {
            if (str.startsWith("/")) {
                StringBuilder sb = new StringBuilder();
                int iIndexOf2 = strSubstring.indexOf("://");
                int iIndexOf3 = strSubstring.indexOf(47, iIndexOf2 == -1 ? 0 : iIndexOf2 + 3);
                if (iIndexOf3 != -1) {
                    strSubstring = strSubstring.substring(0, iIndexOf3);
                }
                str = B7.a.q(sb, strSubstring, str);
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
                String[] strArrL = AbstractC0897f.L(str);
                for (int i6 = 0; i6 < strArrL.length; i6++) {
                    if ("..".equals(strArrL[i6])) {
                        strA = a(iIndexOf, strA);
                    } else if (!".".equals(strArrL[i6])) {
                        if (!strA.endsWith(":")) {
                            StringBuilder sbX = androidx.appfunctions.metadata.a.x(strA, "/");
                            sbX.append(strArrL[i6]);
                            strA = sbX.toString();
                        } else if (strSubstring.length() <= strA.length() || strSubstring.charAt(strA.length()) != '/') {
                            StringBuilder sbV = androidx.compose.foundation.b.v(strA);
                            sbV.append(strArrL[i6]);
                            strA = sbV.toString();
                        } else {
                            StringBuilder sbX2 = androidx.appfunctions.metadata.a.x(strA, "/");
                            sbX2.append(strArrL[i6]);
                            strA = sbX2.toString();
                        }
                    }
                }
                str = strA;
            }
        }
        return new C2035a(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C2035a.class == obj.getClass()) {
            return Objects.equals(this.f6694a, ((C2035a) obj).f6694a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f6694a);
    }

    public final String toString() {
        return this.f6694a;
    }
}
