package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.ss.android.http.legacy.cookie.SM;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttp3CookieInterceptor implements Interceptor {
    public OkHttp3CookieInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r13) throws IOException {
        Request r0 = r13.request();
        if (r0 != null) goto L5;
    L92:
        URI r1 = r0.url().uri();     // Catch: Exception -> L12
    L13:
        Request.Builder r2 = r0.newBuilder();
        CookieHandler r3 = CookieHandler.getDefault();
        Headers r4 = r0.headers();
        Map<String, List<String>> r5 = null;
        if (r1 == null) goto L16;
        String r6 = BoeUtils.replaceUrlWithoutBoeHttpSuffix(r1.toString());
    L96:
        HashMap r7 = new HashMap();     // Catch: Throwable -> L66
        if (r4 == null) goto L28;
        Set<String> r8 = r4.names();     // Catch: Throwable -> L66
        if (r8 == null) goto L28;
        if (r8.isEmpty() == true) goto L28;
        Iterator<String> r9 = r8.iterator();     // Catch: Throwable -> L66
    L25:
        if (r9.hasNext() == false) goto L28;
        String r10 = r9.next();     // Catch: Throwable -> L66
        r7.put(r10, r4.values(r10));     // Catch: Throwable -> L66
    L28:
        if (r0 != null) goto L30;
    L34:
        boolean r11 = false;
    L35:
        if (r3 == null) goto L43;
        if (r11 == true) goto L43;
        if (r6 == null) goto L39;
        Map<String, List<String>> r12 = r3.get(new URI(r6), r7);     // Catch: IOException -> L41 Throwable -> L66
    L40:
        r5 = r12;
    L39:
        r12 = r3.get(r1, r7);     // Catch: IOException -> L41 Throwable -> L66
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
    L43:
        if (r5 != null) goto L45;
    L90:
        r0 = r2.build();     // Catch: Throwable -> L70
    L72:
        Response r14 = r13.proceed(r0);
        HashMap r15 = new HashMap();
        Headers r16 = r14.headers();
        if (r16 == null) goto L82;
        Set<String> r17 = r16.names();
        if (r17 == null) goto L82;
        if (r17.isEmpty() == true) goto L82;
        Iterator<String> r18 = r17.iterator();
    L80:
        if (r18.hasNext() == false) goto L82;
        String r19 = r18.next();
        r15.put(r19, r16.values(r19));
    L82:
        if (r3 != null) goto L99;
    L89:
        return r14;
    L99:
        if (r6 == null) goto L85;
        r3.put(new URI(r6), r15);     // Catch: Throwable -> L87
    L98:
        goto L89
    L85:
        r3.put(r1, r15);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.printStackTrace();
    L70:
        th = move-exception;
        th.printStackTrace();
        goto L72
    L45:
        if (r5.size() <= 0) goto L90;
        Iterator<Map.Entry<String, List<String>>> r110 = r5.entrySet().iterator();     // Catch: Throwable -> L66
    L47:
        if (r110.hasNext() == false) goto L90;
        Map.Entry<String, List<String>> r20 = r110.next();     // Catch: Throwable -> L66
        String r21 = r20.getKey();     // Catch: Throwable -> L66
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L66
        if ("X-SS-Cookie".equalsIgnoreCase(r21) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r21) == true) goto L56;
        if (SM.COOKIE2.equalsIgnoreCase(r21) == false) goto L47;
    L56:
        if (r20.getValue().isEmpty() == true) goto L47;
        Iterator<String> r23 = r20.getValue().iterator();     // Catch: Throwable -> L66
        int r24 = 0;
    L59:
        if (r23.hasNext() == false) goto L64;
        String r111 = r23.next();     // Catch: Throwable -> L66
        if (r24 <= 0) goto L63;
        r22.append("; ");     // Catch: Throwable -> L66
    L63:
        r22.append(r111);     // Catch: Throwable -> L66
        r24 = r24 + 1;     // Catch: Throwable -> L66
        goto L59
    L64:
        r2.addHeader(r21, r22.toString());     // Catch: Throwable -> L66
        goto L47
    L30:
        if (r0.headers() == null) goto L34;
        r11 = "1".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_OKHTTP_COOKIE));     // Catch: Throwable -> L66
        if ("1".equals(r0.header(RetryAndFollowUpInterceptor.BYPASS_DOWNGRADE_COOKIE_HEADER)) == false) goto L35;
        r11 = true;
    L66:
        th = move-exception;
        th.printStackTrace();
        goto L90
    L16:
        r6 = null;
    L12:
        r1 = URIUtils.createUriWithOutQuery(r0.url().toString());
        goto L13
    L5:
        if (r0.headers() == null) goto L92;
        if ("0".equals(r0.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER)) == false) goto L92;
        Request.Builder r112 = r0.newBuilder();
        r112.removeHeader(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER);
        return r13.proceed(r112.build());
    }
}
