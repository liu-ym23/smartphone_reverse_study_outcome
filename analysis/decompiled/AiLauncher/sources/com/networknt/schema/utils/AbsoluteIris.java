package com.networknt.schema.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.networknt.schema.AbsoluteIri;
import io.ktor.sse.ServerSentEventKt;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URI;
import java.net.URLEncoder;
import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public class AbsoluteIris {

    public static class IDNBUGHOLDER {
        private static final boolean IDN_TOASCII_PRESERVES_TRAILING_DOTS = keepsTrailingDot();

        private IDNBUGHOLDER() {
        }

        private static boolean keepsTrailingDot() {
            return "a.".equals(IDN.toASCII("a."));
        }
    }

    public static /* synthetic */ boolean a(int i10) {
        return i10 < 127;
    }

    public static void handleQuery(StringBuilder sb2, String str) {
        String[] strArrSplit = str.split(Const.STR_MART_ADD);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].split("=");
            try {
                sb2.append(URLEncoder.encode(strArrSplit2[0], "UTF-8"));
                if (strArrSplit2.length == 2) {
                    sb2.append("=");
                    sb2.append(URLEncoder.encode(strArrSplit2[1], "UTF-8"));
                }
                if (i10 != strArrSplit.length - 1) {
                    sb2.append(Const.STR_MART_ADD);
                }
            } catch (UnsupportedEncodingException e10) {
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public static boolean isAscii(String str) {
        return str.codePoints().allMatch(new IntPredicate() { // from class: com.networknt.schema.utils.a
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                return AbsoluteIris.a(i10);
            }
        });
    }

    public static String toUri(AbsoluteIri absoluteIri) {
        String string = absoluteIri.toString();
        if (isAscii(string)) {
            int iIndexOf = string.indexOf(63);
            if (iIndexOf == -1) {
                return string;
            }
            int i10 = iIndexOf + 1;
            String strSubstring = string.substring(0, i10);
            String strSubstring2 = string.substring(i10);
            StringBuilder sb2 = new StringBuilder(strSubstring);
            handleQuery(sb2, strSubstring2);
            return sb2.toString();
        }
        String[] strArrSplit = string.split(ServerSentEventKt.COLON);
        if (strArrSplit.length != 2) {
            return string;
        }
        StringBuilder sb3 = new StringBuilder(strArrSplit[0]);
        sb3.append(ServerSentEventKt.COLON);
        String strSubstring3 = strArrSplit[1];
        if (strSubstring3.startsWith("//")) {
            strSubstring3 = strSubstring3.substring(2);
            sb3.append("//");
        } else if (strSubstring3.startsWith("/")) {
            strSubstring3 = strSubstring3.substring(1);
            sb3.append("/");
        }
        String[] strArrSplit2 = strSubstring3.split("\\?");
        String[] strArrSplit3 = strArrSplit2[0].split("/");
        for (int i11 = 0; i11 < strArrSplit3.length; i11++) {
            String str = strArrSplit3[i11];
            if (i11 != 0 || isAscii(str)) {
                sb3.append(str);
            } else {
                sb3.append(unicodeToASCII(str));
            }
            if (i11 != strArrSplit3.length - 1) {
                sb3.append("/");
            }
        }
        if (strArrSplit2[0].endsWith("/")) {
            sb3.append("/");
        }
        if (strArrSplit2.length == 2) {
            sb3.append("?");
            handleQuery(sb3, strArrSplit2[1]);
        }
        return URI.create(sb3.toString()).toASCIIString();
    }

    public static String unicodeToASCII(String str) {
        try {
            String ascii = IDN.toASCII(str);
            if (!IDNBUGHOLDER.IDN_TOASCII_PRESERVES_TRAILING_DOTS) {
                int length = str.length();
                if (length == 0) {
                    return str;
                }
                char cCharAt = str.charAt(length - 1);
                if (cCharAt == '.' || cCharAt == 12290 || cCharAt == 65294 || cCharAt == 65377) {
                    return ascii + ".";
                }
            }
            return ascii;
        } catch (IllegalArgumentException unused) {
            return str;
        }
    }
}
