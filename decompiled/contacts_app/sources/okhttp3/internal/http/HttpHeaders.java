package okhttp3.internal.http;

import com.android.contacts.ContactsUtils;
import com.android.contacts.common.SimContactsConstants;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.io.encoding.Base64;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = null;
    private static final ByteString TOKEN_DELIMITERS = null;

    static {
        QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");
    }

    private HttpHeaders() {
    }

    public static long contentLength(Response r2) {
        return contentLength(r2.headers());
    }

    public static long contentLength(Headers r2) {
        return stringToLong(r2.get("Content-Length"));
    }

    private static long stringToLong(String r2) {
        if (r2 != null) goto L8;
        return -1;
    L8:
        return Long.parseLong(r2);
    L10:
        return -1;
    }

    public static boolean varyMatches(Response r2, Headers r3, Request r4) {
        Iterator<String> r5 = varyFields(r2).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        String r0 = r5.next();
        if (Util.equal(r3.values(r0), r4.headers(r0)) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean hasVaryAll(Response r0) {
        return hasVaryAll(r0.headers());
    }

    public static boolean hasVaryAll(Headers r1) {
        return varyFields(r1).contains(ContactsUtils.CHAR_STAR);
    }

    private static Set<String> varyFields(Response r0) {
        return varyFields(r0.headers());
    }

    public static Set<String> varyFields(Headers r8) {
        Set<String> r0 = Collections.emptySet();
        int r1 = r8.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        if (com.google.common.net.HttpHeaders.VARY.equalsIgnoreCase(r8.name(r3)) == false) goto L13;
        String r4 = r8.value(r3);
        if (r0.isEmpty() == false) goto L10;
        r0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    L10:
        String[] r5 = r4.split(SimContactsConstants.EMAIL_SEP);
        int r6 = r5.length;
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L13;
        r0.add(r5[r7].trim());
        r7 = r7 + 1;
    L13:
        r3 = r3 + 1;
        goto L3
    L14:
        return r0;
    }

    public static Headers varyHeaders(Response r1) {
        return varyHeaders(r1.networkResponse().request().headers(), r1.headers());
    }

    public static Headers varyHeaders(Headers r5, Headers r6) {
        Set<String> r7 = varyFields(r6);
        if (r7.isEmpty() == true) goto L5;
        Headers.Builder r0 = new Headers.Builder();
        int r1 = r5.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        String r3 = r5.name(r2);
        if (r7.contains(r3) == false) goto L11;
        r0.add(r3, r5.value(r2));
    L11:
        r2 = r2 + 1;
        goto L7
    L13:
        return r0.build();
    L5:
        return new Headers.Builder().build();
    }

    public static List<Challenge> parseChallenges(Headers r4, String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L9;
        if (r5.equalsIgnoreCase(r4.name(r1)) == false) goto L8;
        parseChallengeHeader(r0, new Buffer().writeUtf8(r4.value(r1)));
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    private static void parseChallengeHeader(List<Challenge> r8, Buffer r9) {
    L3:
        String r1 = null;
    L4:
        if (r1 != null) goto L8;
        skipWhitespaceAndCommas(r9);
        r1 = readToken(r9);
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = skipWhitespaceAndCommas(r9);
        String r3 = readToken(r9);
        if (r3 == null) goto L11;
        int r5 = skipAll(r9, Base64.padSymbol);
        boolean r6 = skipWhitespaceAndCommas(r9);
        if (r2 == true) goto L21;
        if (r6 == true) goto L20;
        if (r9.exhausted() == false) goto L21;
    L20:
        String r7 = (String) null;
        r8.add(new Challenge(r1, Collections.singletonMap(null, r3 + repeat('=', r5))));
    L21:
        LinkedHashMap r4 = new LinkedHashMap();
        int r10 = r5 + skipAll(r9, Base64.padSymbol);
    L22:
        if (r3 != null) goto L27;
        r3 = readToken(r9);
        if (skipWhitespaceAndCommas(r9) == true) goto L28;
        r10 = skipAll(r9, Base64.padSymbol);
    L28:
        r8.add(new Challenge(r1, r4));
        r1 = r3;
    L27:
        if (r10 == 0) goto L28;
        if (r10 > 1) goto L31;
        if (skipWhitespaceAndCommas(r9) == true) goto L34;
        if (r9.exhausted() == false) goto L38;
    L40:
        String r11 = readToken(r9);
    L41:
        if (r11 == null) goto L42;
        if (((String) r4.put(r3, r11)) != null) goto L45;
        if (skipWhitespaceAndCommas(r9) == true) goto L51;
        if (r9.exhausted() == true) goto L51;
        return;
    L51:
        r3 = null;
        goto L22
    L45:
        return;
    L42:
        return;
    L38:
        if (r9.getByte(0) != 34) goto L40;
        r11 = readQuotedString(r9);
        goto L41
    L34:
        return;
    L31:
        return;
    L11:
        if (r9.exhausted() == true) goto L13;
        return;
    L13:
        r8.add(new Challenge(r1, Collections.emptyMap()));
    }

    private static boolean skipWhitespaceAndCommas(Buffer r3) {
        boolean r0 = false;
    L4:
        if (r3.exhausted() == true) goto L13;
        byte r1 = r3.getByte(0);
        if (r1 == 44) goto L7;
        if (r1 != 32) goto L11;
    L12:
        r3.readByte();
        goto L4
    L11:
        if (r1 != 9) goto L13;
    L7:
        r3.readByte();
        r0 = true;
    L13:
        return r0;
    }

    private static int skipAll(Buffer r3, byte r4) {
        int r0 = 0;
    L4:
        if (r3.exhausted() == true) goto L8;
        if (r3.getByte(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.readByte();
    L8:
        return r0;
    }

    private static String readQuotedString(Buffer r12) {
        if (r12.readByte() != 34) goto L17;
        Buffer r0 = new Buffer();
    L5:
        long r2 = r12.indexOfElement(QUOTED_STRING_DELIMITERS);
        if (r2 == (-1)) goto L7;
        if (r12.getByte(r2) == 34) goto L10;
        if (r12.size() == (r2 + 1)) goto L14;
        r0.write(r12, r2);
        r12.readByte();
        r0.write(r12, 1);
        goto L5
    L14:
        return null;
    L10:
        r0.write(r12, r2);
        r12.readByte();
        return r0.readUtf8();
    L7:
        return null;
    L17:
        throw new IllegalArgumentException();
    }

    private static String readToken(Buffer r4) {
        long r0 = r4.indexOfElement(TOKEN_DELIMITERS);     // Catch: EOFException -> L11
        if (r0 != (-1)) goto L6;
        r0 = r4.size();     // Catch: EOFException -> L11
    L6:
        if (r0 == 0) goto L9;
        return r4.readUtf8(r0);
    L9:
        return null;
    L12:
        throw new AssertionError();
    }

    private static String repeat(char r0, int r1) {
        char[] r2 = new char[r1];
        Arrays.fill(r2, r0);
        return new String(r2);
    }

    public static void receiveHeaders(CookieJar r1, HttpUrl r2, Headers r3) {
        if (r1 != CookieJar.NO_COOKIES) goto L5;
        return;
    L5:
        List<Cookie> r4 = Cookie.parseAll(r2, r3);
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        r1.saveFromResponse(r2, r4);
    }

    public static boolean hasBody(Response r8) {
        if (r8.request().method().equals(HttpMethodContrants.HEAD) == false) goto L5;
        return false;
    L5:
        int r0 = r8.code();
        if (r0 < 100) goto L10;
        if (r0 >= 200) goto L10;
    L15:
        if (contentLength(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r8.header("Transfer-Encoding")) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }

    public static int skipUntil(String r2, int r3, String r4) {
    L3:
        if (r3 >= r2.length()) goto L8;
        if (r4.indexOf(r2.charAt(r3)) != (-1)) goto L8;
        r3 = r3 + 1;
    L8:
        return r3;
    }

    public static int skipWhitespace(String r2, int r3) {
    L3:
        if (r3 >= r2.length()) goto L10;
        char r0 = r2.charAt(r3);
        if (r0 == ' ') goto L9;
        if (r0 != '\t') goto L10;
    L9:
        r3 = r3 + 1;
    L10:
        return r3;
    }

    public static int parseSeconds(String r2, int r3) {
        long r4 = Long.parseLong(r2);     // Catch: NumberFormatException -> L13
        if (r4 <= 2147483647L) goto L8;
        return Integer.MAX_VALUE;
    L8:
        if (r4 >= 0) goto L12;
        return 0;
    L12:
        return (int) r4;
    L13:
        return r3;
    }
}
