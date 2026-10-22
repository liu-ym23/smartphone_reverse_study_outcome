package F9;

import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.agentframework.adapter.coze.requestbody.ProgressRequestBody;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okio.ByteString;
import s2.C1912a;

/* renamed from: F9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0226d {
    public static void a(StringBuilder sb, String key) {
        kotlin.jvm.internal.k.f(key, "key");
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = key.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = key.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
    }

    public static void b(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(G9.b.g("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
            }
        }
    }

    public static void c(String str, String str2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb = new StringBuilder();
                sb.append(G9.b.g("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i), str2));
                sb.append(G9.b.o(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    public static C d(String str, ProgressRequestBody progressRequestBody) {
        StringBuilder sbV = androidx.compose.foundation.b.v("form-data; name=");
        B b = D.e;
        a(sbV, BffConstant.Type.File);
        if (str != null) {
            sbV.append("; filename=");
            a(sbV, str);
        }
        String string = sbV.toString();
        kotlin.jvm.internal.k.e(string, "StringBuilder().apply(builderAction).toString()");
        v vVar = new v(0);
        vVar.e("Content-Disposition", string);
        w wVarG = vVar.g();
        if (wVarG.b(HttpHeaders.CONTENT_TYPE) != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (wVarG.b(HttpHeaders.CONTENT_LENGTH) == null) {
            return new C(wVarG, progressRequestBody);
        }
        throw new IllegalArgumentException("Unexpected header: Content-Length");
    }

    public static int e(int i, String str, int i6, boolean z10) {
        while (i < i6) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z10)) {
                return i;
            }
            i++;
        }
        return i6;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static TlsVersion f(String javaName) {
        kotlin.jvm.internal.k.f(javaName, "javaName");
        int iHashCode = javaName.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (javaName.equals("TLSv1.1")) {
                            return TlsVersion.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (javaName.equals("TLSv1.2")) {
                            return TlsVersion.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (javaName.equals("TLSv1.3")) {
                            return TlsVersion.TLS_1_3;
                        }
                        break;
                }
            } else if (javaName.equals("TLSv1")) {
                return TlsVersion.TLS_1_0;
            }
        } else if (javaName.equals("SSLv3")) {
            return TlsVersion.SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(javaName));
    }

    public static B g(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        Matcher matcher = B.e.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.m(JsonFactory.DEFAULT_QUOTE_CHAR, "No subtype found for: \"", str).toString());
        }
        String strGroup = matcher.group(1);
        kotlin.jvm.internal.k.e(strGroup, "typeSubtype.group(1)");
        Locale US = Locale.US;
        kotlin.jvm.internal.k.e(US, "US");
        String lowerCase = strGroup.toLowerCase(US);
        kotlin.jvm.internal.k.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String strGroup2 = matcher.group(2);
        kotlin.jvm.internal.k.e(strGroup2, "typeSubtype.group(2)");
        String lowerCase2 = strGroup2.toLowerCase(US);
        kotlin.jvm.internal.k.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = B.f.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(iEnd);
                kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                throw new IllegalArgumentException(B7.a.g(JsonFactory.DEFAULT_QUOTE_CHAR, str, sb).toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (j9.t.e0(strGroup4, "'", false) && j9.t.W(strGroup4, "'", false) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                    kotlin.jvm.internal.k.e(strGroup4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new B(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
    }

    public static Protocol h(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return Protocol.HTTP_1_0;
        }
        if (str.equals("http/1.1")) {
            return Protocol.HTTP_1_1;
        }
        if (str.equals("h2_prior_knowledge")) {
            return Protocol.H2_PRIOR_KNOWLEDGE;
        }
        if (str.equals("h2")) {
            return Protocol.HTTP_2;
        }
        if (str.equals("spdy/3.1")) {
            return Protocol.SPDY_3;
        }
        if (str.equals("quic")) {
            return Protocol.QUIC;
        }
        throw new IOException("Unexpected protocol: ".concat(str));
    }

    public static w i(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i = 0;
        for (int i6 = 0; i6 < length; i6++) {
            String str = strArr2[i6];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i6] = j9.m.R0(str).toString();
        }
        int iD = Z6.k.D(0, strArr2.length - 1, 2);
        if (iD >= 0) {
            while (true) {
                String str2 = strArr2[i];
                String str3 = strArr2[i + 1];
                b(str2);
                c(str3, str2);
                if (i == iD) {
                    break;
                }
                i += 2;
            }
        }
        return new w(strArr2);
    }

    public static B j(String str) {
        kotlin.jvm.internal.k.f(str, "<this>");
        try {
            return g(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long k(int r14, java.lang.String r15) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F9.AbstractC0226d.k(int, java.lang.String):long");
    }

    public static String l(X509Certificate certificate) {
        kotlin.jvm.internal.k.f(certificate, "certificate");
        return "sha256/" + m(certificate).a();
    }

    public static ByteString m(X509Certificate x509Certificate) {
        kotlin.jvm.internal.k.f(x509Certificate, "<this>");
        ByteString byteString = ByteString.d;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        kotlin.jvm.internal.k.e(encoded, "publicKey.encoded");
        return C1912a.k(encoded).b("SHA-256");
    }
}
