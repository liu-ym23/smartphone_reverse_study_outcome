package io.ktor.http;

import La.C0951a;
import La.MatchGroup;
import Z8.C1173v;
import Z8.Q;
import Z8.Y;
import com.fasterxml.jackson.core.JsonFactory;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.util.Base64Kt;
import io.ktor.util.TextKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000P\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\f\u001a\u008d\u0001\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001d\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b \u0010\u001e\u001a\u0013\u0010!\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0013\u0010$\u001a\u00020\u0005*\u00020#H\u0002¢\u0006\u0004\b$\u0010%\u001a*\u0010'\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010&2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082\b¢\u0006\u0004\b'\u0010(\u001a\"\u0010)\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010&H\u0082\b¢\u0006\u0004\b)\u0010*\u001a \u0010+\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b+\u0010,\u001a\"\u0010-\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0082\b¢\u0006\u0004\b-\u0010.\u001a\u0013\u0010/\u001a\u00020\u0012*\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100\"\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0000018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103\"\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106\"\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020#018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00103¨\u00068"}, d2 = {"", "cookiesHeader", "Lio/ktor/http/Cookie;", "parseServerSetCookieHeader", "(Ljava/lang/String;)Lio/ktor/http/Cookie;", "", "skipEscaped", "", "parseClientCookiesHeader", "(Ljava/lang/String;Z)Ljava/util/Map;", "cookie", "renderSetCookieHeader", "(Lio/ktor/http/Cookie;)Ljava/lang/String;", "renderCookieHeader", "name", UxipConstants.f30680s, "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "secure", "httpOnly", "extensions", "includeEncoding", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Z)Ljava/lang/String;", "encodeCookieValue", "(Ljava/lang/String;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "encodedValue", "decodeCookieValue", "assertCookieName", "(Ljava/lang/String;)Ljava/lang/String;", "", "shouldEscapeInCookies", "(C)Z", "", "cookiePart", "(Ljava/lang/String;Ljava/lang/Object;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "cookiePartUnencoded", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "cookiePartFlag", "(Ljava/lang/String;Z)Ljava/lang/String;", "cookiePartExt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toIntClamping", "(Ljava/lang/String;)I", "", "loweredPartNames", "Ljava/util/Set;", "Lkotlin/text/Regex;", "clientCookieHeaderPattern", "Lkotlin/text/Regex;", "cookieCharsShouldBeEscaped", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CookieKt {
    private static final Set<String> loweredPartNames = Y.j(io.ktor.client.utils.CacheControl.MAX_AGE, "expires", "domain", "path", "secure", "httponly", "$x-enc");
    private static final Regex clientCookieHeaderPattern = new Regex("(^|;)\\s*([^;=\\{\\}\\s]+)\\s*(=\\s*(\"[^\"]*\"|[^;]*))?");
    private static final Set<Character> cookieCharsShouldBeEscaped = Y.j(';', ',', Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR));

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CookieEncoding.values().length];
            try {
                iArr[CookieEncoding.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CookieEncoding.DQUOTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CookieEncoding.BASE64_ENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CookieEncoding.URI_ENCODING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final String assertCookieName(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            if (shouldEscapeInCookies(str.charAt(i10))) {
                throw new IllegalArgumentException("Cookie name is not valid: " + str);
            }
        }
        return str;
    }

    private static final String cookiePart(String str, Object obj, CookieEncoding cookieEncoding) {
        if (obj == null) {
            return "";
        }
        return str + '=' + encodeCookieValue(obj.toString(), cookieEncoding);
    }

    private static final String cookiePartExt(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + '=' + encodeCookieValue(str2.toString(), CookieEncoding.RAW);
    }

    private static final String cookiePartFlag(String str, boolean z10) {
        return z10 ? str : "";
    }

    private static final String cookiePartUnencoded(String str, Object obj) {
        if (obj == null) {
            return "";
        }
        return str + '=' + obj;
    }

    public static final String decodeCookieValue(String encodedValue, CookieEncoding encoding) {
        kotlin.jvm.internal.p.i(encodedValue, "encodedValue");
        kotlin.jvm.internal.p.i(encoding, "encoding");
        int i10 = WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return (La.D.X(La.H.H1(encodedValue).toString(), "\"", false, 2, null) && La.D.K(La.H.F1(encodedValue).toString(), "\"", false, 2, null)) ? La.H.U0(La.H.D1(encodedValue).toString(), "\"") : encodedValue;
        }
        if (i10 == 3) {
            return Base64Kt.decodeBase64String(encodedValue);
        }
        if (i10 == 4) {
            return CodecsKt.decodeURLQueryComponent$default(encodedValue, 0, 0, true, null, 11, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String encodeCookieValue(String value, CookieEncoding encoding) {
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(encoding, "encoding");
        int i10 = WhenMappings.$EnumSwitchMapping$0[encoding.ordinal()];
        if (i10 == 1) {
            return value;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                return Base64Kt.encodeBase64(value);
            }
            if (i10 == 4) {
                return CodecsKt.encodeURLParameter(value, true);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (La.H.f0(value, JsonFactory.DEFAULT_QUOTE_CHAR, false, 2, null)) {
            throw new IllegalArgumentException("The cookie value contains characters that cannot be encoded in DQUOTES format. Consider URL_ENCODING mode");
        }
        for (int i11 = 0; i11 < value.length(); i11++) {
            if (shouldEscapeInCookies(value.charAt(i11))) {
                return JsonFactory.DEFAULT_QUOTE_CHAR + value + JsonFactory.DEFAULT_QUOTE_CHAR;
            }
        }
        return value;
    }

    public static final Map<String, String> parseClientCookiesHeader(String cookiesHeader, final boolean z10) {
        kotlin.jvm.internal.p.i(cookiesHeader, "cookiesHeader");
        return kotlin.collections.a.w(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Regex.f(clientCookieHeaderPattern, cookiesHeader, 0, 2, null), new InterfaceC5074l() { // from class: io.ktor.http.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CookieKt.parseClientCookiesHeader$lambda$4((La.m) obj);
            }
        }), new InterfaceC5074l() { // from class: io.ktor.http.q
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(CookieKt.parseClientCookiesHeader$lambda$5(z10, (Pair) obj));
            }
        }), new InterfaceC5074l() { // from class: io.ktor.http.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CookieKt.parseClientCookiesHeader$lambda$6((Pair) obj);
            }
        }));
    }

    public static /* synthetic */ Map parseClientCookiesHeader$default(String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return parseClientCookiesHeader(str, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseClientCookiesHeader$lambda$4(La.m it) {
        String value;
        String value2;
        kotlin.jvm.internal.p.i(it, "it");
        MatchGroup matchGroup = it.getGroups().get(2);
        String str = "";
        if (matchGroup == null || (value = matchGroup.getValue()) == null) {
            value = "";
        }
        MatchGroup matchGroup2 = it.getGroups().get(4);
        if (matchGroup2 != null && (value2 = matchGroup2.getValue()) != null) {
            str = value2;
        }
        return Y8.j.a(value, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseClientCookiesHeader$lambda$5(boolean z10, Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (z10 && La.D.X((String) it.e(), "$", false, 2, null)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair parseClientCookiesHeader$lambda$6(Pair cookie) {
        kotlin.jvm.internal.p.i(cookie, "cookie");
        return (La.D.X((String) cookie.f(), "\"", false, 2, null) && La.D.K((String) cookie.f(), "\"", false, 2, null)) ? Pair.d(cookie, null, La.H.U0((String) cookie.f(), "\""), 1, null) : cookie;
    }

    public static final Cookie parseServerSetCookieHeader(String cookiesHeader) {
        CookieEncoding cookieEncodingValueOf;
        kotlin.jvm.internal.p.i(cookiesHeader, "cookiesHeader");
        Map<String, String> clientCookiesHeader = parseClientCookiesHeader(cookiesHeader, false);
        Iterator<T> it = clientCookiesHeader.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!La.D.X((String) entry.getKey(), "$", false, 2, null)) {
                String str = clientCookiesHeader.get("$x-enc");
                if (str == null || (cookieEncodingValueOf = CookieEncoding.valueOf(str)) == null) {
                    cookieEncodingValueOf = CookieEncoding.RAW;
                }
                CookieEncoding cookieEncoding = cookieEncodingValueOf;
                LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(clientCookiesHeader.size()));
                Iterator<T> it2 = clientCookiesHeader.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it2.next();
                    linkedHashMap.put(TextKt.toLowerCasePreservingASCIIRules((String) entry2.getKey()), entry2.getValue());
                }
                String str2 = (String) entry.getKey();
                String strDecodeCookieValue = decodeCookieValue((String) entry.getValue(), cookieEncoding);
                String str3 = (String) linkedHashMap.get(io.ktor.client.utils.CacheControl.MAX_AGE);
                Integer numValueOf = str3 != null ? Integer.valueOf(toIntClamping(str3)) : null;
                String str4 = (String) linkedHashMap.get("expires");
                GMTDate gMTDateFromCookieToGmtDate = str4 != null ? DateUtilsKt.fromCookieToGmtDate(str4) : null;
                String str5 = (String) linkedHashMap.get("domain");
                String str6 = (String) linkedHashMap.get("path");
                boolean zContainsKey = linkedHashMap.containsKey("secure");
                boolean zContainsKey2 = linkedHashMap.containsKey("httponly");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, String> entry3 : clientCookiesHeader.entrySet()) {
                    String key = entry3.getKey();
                    if (!loweredPartNames.contains(TextKt.toLowerCasePreservingASCIIRules(key)) && !kotlin.jvm.internal.p.d(key, entry.getKey())) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                return new Cookie(str2, strDecodeCookieValue, cookieEncoding, numValueOf, gMTDateFromCookieToGmtDate, str5, str6, zContainsKey, zContainsKey2, linkedHashMap2);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final String renderCookieHeader(Cookie cookie) {
        kotlin.jvm.internal.p.i(cookie, "cookie");
        return cookie.getName() + '=' + encodeCookieValue(cookie.getValue(), cookie.getEncoding());
    }

    public static final String renderSetCookieHeader(Cookie cookie) {
        kotlin.jvm.internal.p.i(cookie, "cookie");
        return renderSetCookieHeader$default(cookie.getName(), cookie.getValue(), cookie.getEncoding(), cookie.getMaxAgeInt(), cookie.getExpires(), cookie.getDomain(), cookie.getPath(), cookie.getSecure(), cookie.getHttpOnly(), cookie.getExtensions(), false, 1024, null);
    }

    public static /* synthetic */ String renderSetCookieHeader$default(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z10, boolean z11, Map map, boolean z12, int i10, Object obj) {
        return renderSetCookieHeader(str, str2, (i10 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : gMTDate, (i10 & 32) != 0 ? null : str3, (i10 & 64) == 0 ? str4 : null, (i10 & 128) != 0 ? false : z10, (i10 & 256) == 0 ? z11 : false, (i10 & 512) != 0 ? kotlin.collections.a.i() : map, (i10 & 1024) != 0 ? true : z12);
    }

    private static final boolean shouldEscapeInCookies(char c10) {
        return C0951a.c(c10) || kotlin.jvm.internal.p.k(c10, 32) < 0 || cookieCharsShouldBeEscaped.contains(Character.valueOf(c10));
    }

    private static final int toIntClamping(String str) {
        return (int) C5685n.o(Long.parseLong(str), 0L, 2147483647L);
    }

    public static final String renderSetCookieHeader(String name, String value, CookieEncoding encoding, Integer num, GMTDate gMTDate, String str, String str2, boolean z10, boolean z11, Map<String, String> extensions, boolean z12) {
        String str3;
        String str4;
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(encoding, "encoding");
        kotlin.jvm.internal.p.i(extensions, "extensions");
        String str5 = assertCookieName(name) + '=' + encodeCookieValue(value.toString(), encoding);
        String str6 = "";
        String str7 = num != null ? "Max-Age=" + num : "";
        String httpDate = gMTDate != null ? DateUtilsKt.toHttpDate(gMTDate) : null;
        String str8 = httpDate == null ? "" : "Expires=" + ((Object) httpDate);
        CookieEncoding cookieEncoding = CookieEncoding.RAW;
        String str9 = str == null ? "" : "Domain=" + encodeCookieValue(str.toString(), cookieEncoding);
        String str10 = str2 == null ? "" : "Path=" + encodeCookieValue(str2.toString(), cookieEncoding);
        if (!z10) {
            str3 = "";
        } else {
            str3 = "Secure";
        }
        if (!z11) {
            str4 = "";
        } else {
            str4 = "HttpOnly";
        }
        List listP = C1173v.p(str5, str7, str8, str9, str10, str3, str4);
        ArrayList arrayList = new ArrayList(extensions.size());
        for (Map.Entry<String, String> entry : extensions.entrySet()) {
            String strAssertCookieName = assertCookieName(entry.getKey());
            String value2 = entry.getValue();
            if (value2 != null) {
                strAssertCookieName = strAssertCookieName + '=' + encodeCookieValue(value2.toString(), CookieEncoding.RAW);
            }
            arrayList.add(strAssertCookieName);
        }
        List listS0 = Z8.F.S0(listP, arrayList);
        if (z12) {
            String strName = encoding.name();
            str6 = strName == null ? "$x-enc" : "$x-enc=" + encodeCookieValue(strName.toString(), CookieEncoding.RAW);
        }
        List listT0 = Z8.F.T0(listS0, str6);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listT0) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        return Z8.F.A0(arrayList2, "; ", null, null, 0, null, null, 62, null);
    }
}
