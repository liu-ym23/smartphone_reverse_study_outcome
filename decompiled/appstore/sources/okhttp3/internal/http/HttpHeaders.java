package okhttp3.internal.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.channels.Channel;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.c;
import okhttp3.e;
import okhttp3.internal.Util;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public final class HttpHeaders {
    private static final Pattern PARAMETER = null;
    private static final String QUOTED_STRING = "\"([^\"]*)\"";
    private static final String TOKEN = "([^ \"=]*)";

    static {
        PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    private HttpHeaders() {
    }

    public static long contentLength(Response r10) {
        return contentLength(r10.i());
    }

    public static boolean hasBody(Response r10) {
        if (r10.r().g().equals("HEAD") == false) goto L5;
        return false;
    L5:
        int r11 = r10.d();
        if (r11 < 100) goto L10;
        if (r11 >= 200) goto L10;
    L15:
        if (contentLength(r10) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(r10.f("Transfer-Encoding")) == true) goto L20;
        return false;
    L10:
        if (r11 == 204) goto L15;
        if (r11 == 304) goto L15;
        return true;
    }

    public static boolean hasVaryAll(Response r10) {
        return hasVaryAll(r10.i());
    }

    public static List<c> parseChallenges(Headers r13, String r14) {
        ArrayList r10 = new ArrayList();
        Iterator r15 = r13.k(r14).iterator();
    L4:
        if (r15.hasNext() == false) goto L29;
        String r16 = (String) r15.next();
        int r11 = r16.indexOf(32);
        if (r11 == (-1)) goto L4;
        String r12 = r16.substring(0, r11);
        Matcher r17 = PARAMETER.matcher(r16);
        String r18 = null;
        String r19 = null;
    L10:
        if (r17.find(r11) == false) goto L21;
        if (r16.regionMatches(true, r17.start(1), "realm", 0, 5) == false) goto L15;
        r18 = r17.group(3);
    L17:
        if (r18 == null) goto L20;
        if (r19 != null) goto L21;
    L20:
        r11 = r17.end();
        goto L10
    L15:
        if (r16.regionMatches(true, r17.start(1), "charset", 0, 7) == false) goto L17;
        r19 = r17.group(3);
    L21:
        if (r18 == null) goto L4;
        c r110 = new c(r12, r18);
        if (r19 == null) goto L28;
        if (r19.equalsIgnoreCase("UTF-8") == false) goto L4;
        r110 = r110.a(Util.UTF_8);
    L28:
        r10.add(r110);
        goto L4
    L29:
        return r10;
    }

    public static int parseSeconds(String r10, int r11) {
        long r12 = Long.parseLong(r10);     // Catch: NumberFormatException -> L13
        if (r12 <= 2147483647L) goto L8;
        return Channel.UNLIMITED;
    L8:
        if (r12 >= 0) goto L12;
        return 0;
    L12:
        return (int) r12;
    L13:
        return r11;
    }

    public static void receiveHeaders(CookieJar r10, HttpUrl r11, Headers r12) {
        if (r10 != CookieJar.NO_COOKIES) goto L5;
        return;
    L5:
        List<e> r13 = e.f(r11, r12);
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        r10.saveFromResponse(r11, r13);
    }

    public static int skipUntil(String r10, int r11, String r12) {
    L3:
        if (r11 >= r10.length()) goto L8;
        if (r12.indexOf(r10.charAt(r11)) != (-1)) goto L8;
        r11 = r11 + 1;
    L8:
        return r11;
    }

    public static int skipWhitespace(String r10, int r11) {
    L3:
        if (r11 >= r10.length()) goto L10;
        char r12 = r10.charAt(r11);
        if (r12 == ' ') goto L9;
        if (r12 != '\t') goto L10;
    L9:
        r11 = r11 + 1;
    L10:
        return r11;
    }

    private static long stringToLong(String r10) {
        if (r10 != null) goto L8;
        return -1;
    L8:
        return Long.parseLong(r10);
    L10:
        return -1;
    }

    private static Set<String> varyFields(Response r10) {
        return varyFields(r10.i());
    }

    public static Headers varyHeaders(Response r10) {
        return varyHeaders(r10.m().r().e(), r10.i());
    }

    public static boolean varyMatches(Response r10, Headers r11, Request r12) {
        Iterator<String> r13 = varyFields(r10).iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        String r14 = r13.next();
        if (Util.equal(r11.k(r14), r12.d(r14)) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static long contentLength(Headers r10) {
        return stringToLong(r10.b("Content-Length"));
    }

    public static boolean hasVaryAll(Headers r10) {
        return varyFields(r10).contains("*");
    }

    public static Set<String> varyFields(Headers r10) {
        Set<String> r11 = Collections.emptySet();
        int r12 = r10.h();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L14;
        if ("Vary".equalsIgnoreCase(r10.d(r13)) == false) goto L13;
        String r14 = r10.j(r13);
        if (r11.isEmpty() == false) goto L10;
        r11 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    L10:
        String[] r15 = r14.split(",");
        int r16 = r15.length;
        int r17 = 0;
    L11:
        if (r17 >= r16) goto L13;
        r11.add(r15[r17].trim());
        r17 = r17 + 1;
    L13:
        r13 = r13 + 1;
        goto L3
    L14:
        return r11;
    }

    public static Headers varyHeaders(Headers r10, Headers r11) {
        Set<String> r12 = varyFields(r11);
        if (r12.isEmpty() == true) goto L5;
        Headers.Builder r13 = new Headers.Builder();
        int r14 = r10.h();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L13;
        String r16 = r10.d(r15);
        if (r12.contains(r16) == false) goto L11;
        r13.a(r16, r10.j(r15));
    L11:
        r15 = r15 + 1;
        goto L7
    L13:
        return r13.d();
    L5:
        return new Headers.Builder().d();
    }
}
