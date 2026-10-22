package io.ktor.http;

import La.C0951a;
import Z8.C1172u;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.CharsetKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a3\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a+\u0010\u0011\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u000e\u001a+\u0010\u0012\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000e\u001a'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a#\u0010\u0019\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0014\u001a\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u0015H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\" \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/http/URLBuilder;", "", "urlString", "takeFrom", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "takeFromUnsafe", "", "startIndex", "endIndex", "slashCount", "LY8/t;", "parseFile", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;III)V", "parseMailto", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)V", "parseQuery", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;II)I", "parseFragment", "fillHost", "findScheme", "(Ljava/lang/String;II)I", "", "char", "count", "(Ljava/lang/String;IIC)I", "indexOfColonInHostPort", "", "isLetter", "(C)Z", "", "ROOT_PATH", "Ljava/util/List;", "getROOT_PATH", "()Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLParserKt {
    private static final List<String> ROOT_PATH = C1172u.e("");

    private static final int count(String str, int i10, int i11, char c10) {
        int i12 = 0;
        while (true) {
            int i13 = i10 + i12;
            if (i13 >= i11 || str.charAt(i13) != c10) {
                break;
            }
            i12++;
        }
        return i12;
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i10, int i11) throws NumberFormatException {
        int i12;
        Integer numValueOf = Integer.valueOf(indexOfColonInHostPort(str, i10, i11));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : i11;
        String strSubstring = str.substring(i10, iIntValue);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        uRLBuilder.setHost(strSubstring);
        int i13 = iIntValue + 1;
        if (i13 < i11) {
            String strSubstring2 = str.substring(i13, i11);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            i12 = Integer.parseInt(strSubstring2);
        } else {
            i12 = 0;
        }
        uRLBuilder.setPort(i12);
    }

    private static final int findScheme(String str, int i10, int i11) {
        int i12;
        int i13;
        char cCharAt = str.charAt(i10);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i12 = i10;
            i13 = i12;
        } else {
            i12 = i10;
            i13 = -1;
        }
        while (i12 < i11) {
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 == ':') {
                if (i13 == -1) {
                    return i12 - i10;
                }
                throw new IllegalArgumentException("Illegal character in scheme at position " + i13);
            }
            if (cCharAt2 == '#' || cCharAt2 == '/' || cCharAt2 == '?') {
                break;
            }
            if (i13 == -1 && (('a' > cCharAt2 || cCharAt2 >= '{') && (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')))) {
                i13 = i12;
            }
            i12++;
        }
        return -1;
    }

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    private static final int indexOfColonInHostPort(String str, int i10, int i11) {
        boolean z10 = false;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != ':') {
                if (cCharAt == '[') {
                    z10 = true;
                } else if (cCharAt == ']') {
                    z10 = false;
                }
            } else if (!z10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static final boolean isLetter(char c10) {
        char lowerCase = Character.toLowerCase(c10);
        return 'a' <= lowerCase && lowerCase < '{';
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i10, int i11, int i12) {
        if (i12 == 1) {
            uRLBuilder.setHost("");
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            URLBuilderKt.setEncodedPath(uRLBuilder, strSubstring);
            return;
        }
        if (i12 != 2) {
            if (i12 != 3) {
                throw new IllegalArgumentException("Invalid file url: " + str);
            }
            uRLBuilder.setHost("");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(JsonPointer.SEPARATOR);
            String strSubstring2 = str.substring(i10, i11);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            sb2.append(strSubstring2);
            URLBuilderKt.setEncodedPath(uRLBuilder, sb2.toString());
            return;
        }
        int iT0 = La.H.t0(str, JsonPointer.SEPARATOR, i10, false, 4, null);
        if (iT0 == -1 || iT0 == i11) {
            String strSubstring3 = str.substring(i10, i11);
            kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
            uRLBuilder.setHost(strSubstring3);
        } else {
            String strSubstring4 = str.substring(i10, iT0);
            kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
            uRLBuilder.setHost(strSubstring4);
            String strSubstring5 = str.substring(iT0, i11);
            kotlin.jvm.internal.p.h(strSubstring5, "substring(...)");
            URLBuilderKt.setEncodedPath(uRLBuilder, strSubstring5);
        }
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i10, int i11) {
        if (i10 >= i11 || str.charAt(i10) != '#') {
            return;
        }
        String strSubstring = str.substring(i10 + 1, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        uRLBuilder.setEncodedFragment(strSubstring);
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i10, int i11) {
        int iU0 = La.H.u0(str, "@", i10, false, 4, null);
        if (iU0 == -1) {
            throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
        }
        String strSubstring = str.substring(i10, iU0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        uRLBuilder.setUser(CodecsKt.decodeURLPart$default(strSubstring, 0, 0, null, 7, null));
        String strSubstring2 = str.substring(iU0 + 1, i11);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        uRLBuilder.setHost(strSubstring2);
    }

    private static final int parseQuery(final URLBuilder uRLBuilder, String str, int i10, int i11) {
        int i12 = i10 + 1;
        if (i12 == i11) {
            uRLBuilder.setTrailingQuery(true);
            return i11;
        }
        Integer numValueOf = Integer.valueOf(La.H.t0(str, '#', i12, false, 4, null));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            i11 = numValueOf.intValue();
        }
        String strSubstring = str.substring(i12, i11);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        QueryKt.parseQueryString$default(strSubstring, 0, 0, false, 6, null).forEach(new p9.p() { // from class: io.ktor.http.C
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return URLParserKt.parseQuery$lambda$5(uRLBuilder, (String) obj, (List) obj2);
            }
        });
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t parseQuery$lambda$5(URLBuilder uRLBuilder, String key, List values) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(values, "values");
        uRLBuilder.getEncodedParameters().appendAll(key, values);
        return Y8.t.f7040a;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String urlString) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(urlString, "urlString");
        if (La.H.x0(urlString)) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, urlString);
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    public static final URLBuilder takeFromUnsafe(URLBuilder uRLBuilder, String urlString) throws NumberFormatException {
        int i10;
        int iIntValue;
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(urlString, "urlString");
        int length = urlString.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            if (!C0951a.c(urlString.charAt(i11))) {
                break;
            }
            i11++;
        }
        int length2 = urlString.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i12 = length2 - 1;
                if (!C0951a.c(urlString.charAt(length2))) {
                    i10 = length2;
                    break;
                }
                if (i12 < 0) {
                    break;
                }
                length2 = i12;
            }
            i10 = -1;
        } else {
            i10 = -1;
        }
        int i13 = i10 + 1;
        int iFindScheme = findScheme(urlString, i11, i13);
        if (iFindScheme > 0) {
            String strSubstring = urlString.substring(i11, i11 + iFindScheme);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            uRLBuilder.setProtocol(URLProtocol.INSTANCE.createOrDefault(strSubstring));
            i11 += iFindScheme + 1;
        }
        if (kotlin.jvm.internal.p.d(uRLBuilder.getProtocol().getName(), "data")) {
            String strSubstring2 = urlString.substring(i11, i13);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            uRLBuilder.setHost(strSubstring2);
            return uRLBuilder;
        }
        int iCount = count(urlString, i11, i13, JsonPointer.SEPARATOR);
        int query = i11 + iCount;
        if (kotlin.jvm.internal.p.d(uRLBuilder.getProtocol().getName(), Const.STR_FILE)) {
            parseFile(uRLBuilder, urlString, query, i13, iCount);
            return uRLBuilder;
        }
        if (kotlin.jvm.internal.p.d(uRLBuilder.getProtocol().getName(), "mailto")) {
            if (iCount != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            parseMailto(uRLBuilder, urlString, query, i13);
            return uRLBuilder;
        }
        if (kotlin.jvm.internal.p.d(uRLBuilder.getProtocol().getName(), "about")) {
            if (iCount != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strSubstring3 = urlString.substring(query, i13);
            kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
            uRLBuilder.setHost(strSubstring3);
            return uRLBuilder;
        }
        if (kotlin.jvm.internal.p.d(uRLBuilder.getProtocol().getName(), "tel")) {
            if (iCount != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strSubstring4 = urlString.substring(query, i13);
            kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
            uRLBuilder.setHost(strSubstring4);
            return uRLBuilder;
        }
        if (iCount >= 2) {
            while (true) {
                Integer numValueOf = Integer.valueOf(La.H.w0(urlString, CharsetKt.toCharArray("@/\\?#"), query, false, 4, null));
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i13;
                if (iIntValue >= i13 || urlString.charAt(iIntValue) != '@') {
                    break;
                }
                int iIndexOfColonInHostPort = indexOfColonInHostPort(urlString, query, iIntValue);
                if (iIndexOfColonInHostPort != -1) {
                    String strSubstring5 = urlString.substring(query, iIndexOfColonInHostPort);
                    kotlin.jvm.internal.p.h(strSubstring5, "substring(...)");
                    uRLBuilder.setEncodedUser(strSubstring5);
                    String strSubstring6 = urlString.substring(iIndexOfColonInHostPort + 1, iIntValue);
                    kotlin.jvm.internal.p.h(strSubstring6, "substring(...)");
                    uRLBuilder.setEncodedPassword(strSubstring6);
                } else {
                    String strSubstring7 = urlString.substring(query, iIntValue);
                    kotlin.jvm.internal.p.h(strSubstring7, "substring(...)");
                    uRLBuilder.setEncodedUser(strSubstring7);
                }
                query = iIntValue + 1;
            }
            fillHost(uRLBuilder, urlString, query, iIntValue);
            query = iIntValue;
        }
        if (query >= i13) {
            uRLBuilder.setEncodedPathSegments(urlString.charAt(i10) == '/' ? ROOT_PATH : C1173v.m());
            return uRLBuilder;
        }
        uRLBuilder.setEncodedPathSegments(iCount == 0 ? Z8.F.i0(uRLBuilder.getEncodedPathSegments(), 1) : C1173v.m());
        Integer numValueOf2 = Integer.valueOf(La.H.w0(urlString, CharsetKt.toCharArray("?#"), query, false, 4, null));
        Integer num = numValueOf2.intValue() > 0 ? numValueOf2 : null;
        int iIntValue2 = num != null ? num.intValue() : i13;
        if (iIntValue2 > query) {
            String strSubstring8 = urlString.substring(query, iIntValue2);
            kotlin.jvm.internal.p.h(strSubstring8, "substring(...)");
            uRLBuilder.setEncodedPathSegments(Z8.F.S0((uRLBuilder.getEncodedPathSegments().size() == 1 && ((CharSequence) Z8.F.q0(uRLBuilder.getEncodedPathSegments())).length() == 0) ? C1173v.m() : uRLBuilder.getEncodedPathSegments(), Z8.F.S0(iCount == 1 ? ROOT_PATH : C1173v.m(), kotlin.jvm.internal.p.d(strSubstring8, "/") ? ROOT_PATH : La.H.a1(strSubstring8, new char[]{JsonPointer.SEPARATOR}, false, 0, 6, null))));
            query = iIntValue2;
        }
        if (query < i13 && urlString.charAt(query) == '?') {
            query = parseQuery(uRLBuilder, urlString, query, i13);
        }
        parseFragment(uRLBuilder, urlString, query, i13);
        return uRLBuilder;
    }
}
