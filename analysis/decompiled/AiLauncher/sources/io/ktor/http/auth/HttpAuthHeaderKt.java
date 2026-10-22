package io.ktor.http.auth;

import La.H;
import La.K;
import La.m;
import Z8.C1173v;
import Z8.Y;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.http.CookieUtilsKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.auth.HttpAuthHeaderKt;
import io.ktor.http.parsing.ParseException;
import io.ktor.util.date.GMTDateParser;
import io.ktor.utils.io.InternalAPI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002¢\u0006\u0004\b\u0003\u0010\f\u001a7\u0010\u000f\u001a\u0004\u0018\u00010\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a3\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u001c\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010\u001e\u001a\u00020\b*\u00020\u00002\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u0017\u001a\u0013\u0010 \u001a\u00020\u001f*\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!\u001a\u0013\u0010\"\u001a\u00020\u001f*\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010!\"\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)¨\u0006+"}, d2 = {"", "headerValue", "Lio/ktor/http/auth/HttpAuthHeader;", "parseAuthorizationHeader", "(Ljava/lang/String;)Lio/ktor/http/auth/HttpAuthHeader;", "", "parseAuthorizationHeaders", "(Ljava/lang/String;)Ljava/util/List;", "", "startIndex", "", "headers", "(Ljava/lang/String;ILjava/util/List;)I", "header", "index", "nextChallengeIndex", "(Ljava/util/List;Lio/ktor/http/auth/HttpAuthHeader;ILjava/lang/String;)Ljava/lang/Integer;", "", "parameters", "matchParameters", "(Ljava/lang/String;ILjava/util/Map;)I", "matchParameter", "matchToken68", "(Ljava/lang/String;I)I", "unescaped", "(Ljava/lang/String;)Ljava/lang/String;", "", "delimiter", "skipDelimiter", "(Ljava/lang/String;IC)I", "skipSpaces", "", "isToken68", "(C)Z", "isToken", "", "TOKEN_EXTRA", "Ljava/util/Set;", "TOKEN68_EXTRA", "Lkotlin/text/Regex;", "token68Pattern", "Lkotlin/text/Regex;", "escapeRegex", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpAuthHeaderKt {
    private static final Set<Character> TOKEN68_EXTRA;
    private static final Set<Character> TOKEN_EXTRA;
    private static final Regex escapeRegex;
    private static final Regex token68Pattern;

    static {
        Character chValueOf = Character.valueOf(GMTDateParser.ANY);
        Character chValueOf2 = Character.valueOf(JsonPointer.ESC);
        TOKEN_EXTRA = Y.j('!', '#', '$', '%', '&', '\'', chValueOf, '+', '-', '.', '^', '_', '`', '|', chValueOf2);
        TOKEN68_EXTRA = Y.j('-', '.', '_', chValueOf2, '+', Character.valueOf(JsonPointer.SEPARATOR));
        token68Pattern = new Regex("[a-zA-Z0-9\\-._~+/]+=*");
        escapeRegex = new Regex("\\\\.");
    }

    private static final boolean isToken(char c10) {
        if ('a' > c10 || c10 >= '{') {
            return ('A' <= c10 && c10 < '[') || CookieUtilsKt.isDigit(c10) || TOKEN_EXTRA.contains(Character.valueOf(c10));
        }
        return true;
    }

    private static final boolean isToken68(char c10) {
        if ('a' > c10 || c10 >= '{') {
            return ('A' <= c10 && c10 < '[') || CookieUtilsKt.isDigit(c10) || TOKEN68_EXTRA.contains(Character.valueOf(c10));
        }
        return true;
    }

    private static final int matchParameter(String str, int i10, Map<String, String> map) {
        int i11;
        int iSkipSpaces = skipSpaces(str, i10);
        int i12 = iSkipSpaces;
        while (i12 < str.length() && isToken(str.charAt(i12))) {
            i12++;
        }
        String strL1 = H.l1(str, C5685n.s(iSkipSpaces, i12));
        int iSkipSpaces2 = skipSpaces(str, i12);
        if (iSkipSpaces2 == str.length() || str.charAt(iSkipSpaces2) != '=') {
            return i10;
        }
        int iSkipSpaces3 = skipSpaces(str, iSkipSpaces2 + 1);
        boolean z10 = false;
        if (str.charAt(iSkipSpaces3) == '\"') {
            iSkipSpaces3++;
            i11 = iSkipSpaces3;
            boolean z11 = false;
            while (i11 < str.length() && (str.charAt(i11) != '\"' || z11)) {
                z11 = !z11 && str.charAt(i11) == '\\';
                i11++;
            }
            if (i11 == str.length()) {
                throw new ParseException("Expected closing quote'\"' in parameter", null, 2, null);
            }
            z10 = true;
        } else {
            i11 = iSkipSpaces3;
            while (i11 < str.length() && str.charAt(i11) != ' ' && str.charAt(i11) != ',') {
                i11++;
            }
        }
        String strL12 = H.l1(str, C5685n.s(iSkipSpaces3, i11));
        if (z10) {
            strL12 = unescaped(strL12);
        }
        map.put(strL1, strL12);
        return z10 ? i11 + 1 : i11;
    }

    private static final int matchParameters(String str, int i10, Map<String, String> map) {
        while (i10 > 0 && i10 < str.length()) {
            int iMatchParameter = matchParameter(str, i10, map);
            if (iMatchParameter == i10) {
                break;
            }
            i10 = skipDelimiter(str, iMatchParameter, ',');
        }
        return i10;
    }

    private static final int matchToken68(String str, int i10) {
        int iSkipSpaces = skipSpaces(str, i10);
        while (iSkipSpaces < str.length() && isToken68(str.charAt(iSkipSpaces))) {
            iSkipSpaces++;
        }
        while (iSkipSpaces < str.length() && str.charAt(iSkipSpaces) == '=') {
            iSkipSpaces++;
        }
        return skipSpaces(str, iSkipSpaces);
    }

    private static final Integer nextChallengeIndex(List<HttpAuthHeader> list, HttpAuthHeader httpAuthHeader, int i10, String str) {
        if (i10 != str.length() && str.charAt(i10) != ',') {
            return null;
        }
        list.add(httpAuthHeader);
        if (i10 == str.length()) {
            return -1;
        }
        if (str.charAt(i10) == ',') {
            return Integer.valueOf(i10 + 1);
        }
        throw new IllegalStateException("");
    }

    public static final HttpAuthHeader parseAuthorizationHeader(String headerValue) {
        p.i(headerValue, "headerValue");
        int iSkipSpaces = skipSpaces(headerValue, 0);
        int i10 = iSkipSpaces;
        while (i10 < headerValue.length() && isToken(headerValue.charAt(i10))) {
            i10++;
        }
        String strL1 = H.l1(headerValue, C5685n.s(iSkipSpaces, i10));
        int iSkipSpaces2 = skipSpaces(headerValue, i10);
        if (H.x0(strL1)) {
            return null;
        }
        if (headerValue.length() == iSkipSpaces2) {
            return new HttpAuthHeader.Parameterized(strL1, C1173v.m(), (HeaderValueEncoding) null, 4, (i) null);
        }
        int iMatchToken68 = matchToken68(headerValue, iSkipSpaces2);
        String string = H.D1(H.l1(headerValue, C5685n.s(iSkipSpaces2, iMatchToken68))).toString();
        if (string.length() > 0 && iMatchToken68 == headerValue.length()) {
            return new HttpAuthHeader.Single(strL1, string);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (matchParameters(headerValue, iSkipSpaces2, linkedHashMap) != -1) {
            throw new ParseException("Function parseAuthorizationHeader can parse only one header", null, 2, null);
        }
        return new HttpAuthHeader.Parameterized(strL1, linkedHashMap, (HeaderValueEncoding) null, 4, (i) null);
    }

    @InternalAPI
    public static final List<HttpAuthHeader> parseAuthorizationHeaders(String headerValue) {
        p.i(headerValue, "headerValue");
        ArrayList arrayList = new ArrayList();
        int authorizationHeader = 0;
        while (authorizationHeader != -1) {
            authorizationHeader = parseAuthorizationHeader(headerValue, authorizationHeader, arrayList);
        }
        return arrayList;
    }

    private static final int skipDelimiter(String str, int i10, char c10) {
        int iSkipSpaces = skipSpaces(str, i10);
        if (iSkipSpaces == str.length()) {
            return -1;
        }
        if (str.charAt(iSkipSpaces) == c10) {
            return skipSpaces(str, iSkipSpaces + 1);
        }
        throw new ParseException("Expected delimiter " + c10 + " at position " + iSkipSpaces, null, 2, null);
    }

    private static final int skipSpaces(String str, int i10) {
        while (i10 < str.length() && str.charAt(i10) == ' ') {
            i10++;
        }
        return i10;
    }

    private static final String unescaped(String str) {
        return escapeRegex.m(str, new InterfaceC5074l() { // from class: n8.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpAuthHeaderKt.unescaped$lambda$2((m) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence unescaped$lambda$2(m it) {
        p.i(it, "it");
        return K.S1(it.getValue(), 1);
    }

    private static final int parseAuthorizationHeader(String str, int i10, List<HttpAuthHeader> list) {
        Integer numNextChallengeIndex;
        int iSkipSpaces = skipSpaces(str, i10);
        int i11 = iSkipSpaces;
        while (i11 < str.length() && isToken(str.charAt(i11))) {
            i11++;
        }
        String strL1 = H.l1(str, C5685n.s(iSkipSpaces, i11));
        if (!H.x0(strL1)) {
            int iSkipSpaces2 = skipSpaces(str, i11);
            Integer numNextChallengeIndex2 = nextChallengeIndex(list, new HttpAuthHeader.Parameterized(strL1, C1173v.m(), (HeaderValueEncoding) null, 4, (i) null), iSkipSpaces2, str);
            if (numNextChallengeIndex2 != null) {
                return numNextChallengeIndex2.intValue();
            }
            int iMatchToken68 = matchToken68(str, iSkipSpaces2);
            String string = H.D1(H.l1(str, C5685n.s(iSkipSpaces2, iMatchToken68))).toString();
            if (string.length() > 0 && (numNextChallengeIndex = nextChallengeIndex(list, new HttpAuthHeader.Single(strL1, string), iMatchToken68, str)) != null) {
                return numNextChallengeIndex.intValue();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int iMatchParameters = matchParameters(str, iSkipSpaces2, linkedHashMap);
            list.add(new HttpAuthHeader.Parameterized(strL1, linkedHashMap, (HeaderValueEncoding) null, 4, (i) null));
            return iMatchParameters;
        }
        throw new ParseException("Invalid authScheme value: it should be token, can't be blank", null, 2, null);
    }
}
