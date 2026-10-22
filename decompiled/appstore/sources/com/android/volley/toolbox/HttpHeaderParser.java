package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes.dex */
public class HttpHeaderParser {
    public HttpHeaderParser() {
    }

    public static Cache.Entry parseCacheHeaders(NetworkResponse r19) {
        long r10 = System.currentTimeMillis();
        Map<String, String> r11 = r19.headers;
        String r12 = r11.get("Date");
        if (r12 == null) goto L5;
        long r13 = parseDateAsEpoch(r12);
    L6:
        String r14 = r11.get("Cache-Control");
        int r15 = 0;
        if (r14 == null) goto L35;
        String[] r16 = r14.split(",");
        boolean r17 = false;
        long r18 = 0;
        long r110 = 0;
    L10:
        if (r15 >= r16.length) goto L34;
        String r111 = r16[r15].trim();
        if (r111.equals("no-cache") == true) goto L32;
        if (r111.equals("no-store") == true) goto L69;
        if (r111.startsWith("max-age=") == false) goto L22;
        r18 = Long.parseLong(r111.substring(8));     // Catch: Exception -> L59
    L31:
        r15 = r15 + 1;
        goto L10
    L22:
        if (r111.startsWith("stale-while-revalidate=") == false) goto L27;
        r110 = Long.parseLong(r111.substring(23));     // Catch: Exception -> L59
        goto L31
    L27:
        if (r111.equals("must-revalidate") == false) goto L29;
    L30:
        r17 = true;
        goto L31
    L29:
        if (r111.equals("proxy-revalidate") == false) goto L31;
    L69:
        return null;
    L32:
        return null;
    L34:
        r15 = 1;
    L36:
        String r20 = r11.get("Expires");
        if (r20 == null) goto L39;
        long r21 = parseDateAsEpoch(r20);
    L40:
        String r22 = r11.get("Last-Modified");
        if (r22 == null) goto L43;
        long r112 = parseDateAsEpoch(r22);
    L44:
        String r23 = r11.get("ETag");
        if (r15 == 0) goto L51;
        long r24 = r10 + (r18 * 1000);
        if (r17 == false) goto L49;
        long r113 = r24;
    L50:
        long r25 = r113;
    L57:
        Cache.Entry r26 = new Cache.Entry();
        r26.data = r19.data;
        r26.etag = r23;
        r26.softTtl = r24;
        r26.ttl = r25;
        r26.serverDate = r13;
        r26.lastModified = r112;
        r26.responseHeaders = r11;
        return r26;
    L49:
        r113 = (r110 * 1000) + r24;
        goto L50
    L51:
        r25 = 0;
        if (r13 > 0) goto L54;
    L56:
        r24 = 0;
        goto L57
    L54:
        if (r21 < r13) goto L56;
        r24 = r10 + (r21 - r13);
        r25 = r24;
        goto L57
    L43:
        r112 = 0;
        goto L44
    L39:
        r21 = 0;
        goto L40
    L35:
        r17 = false;
        r18 = 0;
        r110 = 0;
        goto L36
    L5:
        r13 = 0;
        goto L6
    }

    public static String parseCharset(Map<String, String> r10, String r11) {
        String r12 = r10.get("Content-Type");
        if (r12 == null) goto L14;
        String[] r13 = r12.split(";");
        int r14 = 1;
    L6:
        if (r14 >= r13.length) goto L14;
        String[] r15 = r13[r14].trim().split("=");
        if (r15.length != 2) goto L13;
        if (r15[0].equals("charset") == false) goto L13;
        return r15[1];
    L13:
        r14 = r14 + 1;
    L14:
        return r11;
    }

    public static long parseDateAsEpoch(String r10) {
        return DateUtils.parseDate(r10).getTime();
    L4:
        return 0;
    }

    public static String parseCharset(Map<String, String> r10) {
        return parseCharset(r10, "ISO-8859-1");
    }
}
