package com.networknt.schema;

import com.fasterxml.jackson.core.JsonPointer;
import com.networknt.schema.utils.Strings;
import io.ktor.sse.ServerSentEventKt;
import java.util.Objects;

/* loaded from: classes2.dex */
public class AbsoluteIri {
    private final String value;

    public AbsoluteIri(String str) {
        this.value = str;
    }

    private static boolean isAbsoluteIri(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == ':') {
                return true;
            }
            if (cCharAt == '/' || cCharAt == '?' || cCharAt == '#') {
                break;
            }
        }
        return false;
    }

    public static AbsoluteIri of(String str) {
        return new AbsoluteIri(str);
    }

    public static String parent(String str, int i10) {
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1 && (iLastIndexOf = str.lastIndexOf(58)) != -1) {
            iLastIndexOf++;
        }
        return (iLastIndexOf == -1 || iLastIndexOf <= i10) ? str : str.substring(0, iLastIndexOf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.value, ((AbsoluteIri) obj).value);
        }
        return false;
    }

    public String getScheme() {
        return getScheme(this.value);
    }

    public String getSchemeAuthority() {
        return getSchemeAuthority(this.value);
    }

    public int hashCode() {
        return Objects.hash(this.value);
    }

    public AbsoluteIri resolve(String str) {
        return new AbsoluteIri(resolve(this.value, str));
    }

    public String toString() {
        return this.value;
    }

    public static String getScheme(String str) {
        int iIndexOf;
        return (str == null || (iIndexOf = str.indexOf(58)) == -1) ? "" : str.substring(0, iIndexOf);
    }

    public static String getSchemeAuthority(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf("://");
        int iIndexOf2 = str.indexOf(47, iIndexOf == -1 ? 0 : iIndexOf + 3);
        return iIndexOf2 != -1 ? str.substring(0, iIndexOf2) : str;
    }

    public static String resolve(String str, String str2) {
        int iIndexOf;
        if (isAbsoluteIri(str2) || str == null) {
            return str2;
        }
        if (str2.startsWith("/")) {
            return getSchemeAuthority(str) + str2;
        }
        int iIndexOf2 = str.indexOf("://");
        if (iIndexOf2 == -1) {
            iIndexOf = str.indexOf(58);
            if (iIndexOf == -1) {
                iIndexOf = 0;
            }
        } else {
            iIndexOf = iIndexOf2 + 3;
        }
        String strParent = parent(str, iIndexOf);
        String[] strArrSplit = Strings.split(str2, JsonPointer.SEPARATOR);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            if ("..".equals(strArrSplit[i10])) {
                strParent = parent(strParent, iIndexOf);
            } else if (!".".equals(strArrSplit[i10])) {
                if (!strParent.endsWith(ServerSentEventKt.COLON)) {
                    strParent = strParent + "/" + strArrSplit[i10];
                } else if (str.length() <= strParent.length() || str.charAt(strParent.length()) != '/') {
                    strParent = strParent + strArrSplit[i10];
                } else {
                    strParent = strParent + "/" + strArrSplit[i10];
                }
            }
        }
        return strParent;
    }
}
