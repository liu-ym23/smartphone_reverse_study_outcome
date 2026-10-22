package com.bytedance.frameworks.baselib.network.http.ok3.impl;

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

/* JADX INFO: loaded from: classes.dex */
public class b implements Interceptor {
    public b() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r11) {
        Request r10 = r11.request();
        URI r12 = r10.k().H();     // Catch: Exception -> L5
    L6:
        Request.a r13 = r10.h();
        CookieHandler r14 = CookieHandler.getDefault();
        Headers r15 = r10.e();
        HashMap r16 = new HashMap();     // Catch: Throwable -> L18
        if (r15 == null) goto L20;
        Set r17 = r15.e();     // Catch: Throwable -> L18
        if (r17 == null) goto L20;
        if (r17.isEmpty() == true) goto L20;
        Iterator r18 = r17.iterator();     // Catch: Throwable -> L18
    L15:
        if (r18.hasNext() == false) goto L20;
        String r19 = (String) r18.next();     // Catch: Throwable -> L18
        r16.put(r19, r15.k(r19));     // Catch: Throwable -> L18
    L20:
        if (r14 != null) goto L72;
    L25:
        Map<String, List<String>> r20 = null;
    L26:
        if (r20 != null) goto L28;
    L78:
        r10 = r13.b();     // Catch: Throwable -> L52
    L54:
        Response r110 = r11.proceed(r10);
        HashMap r111 = new HashMap();
        Headers r21 = r110.i();
        if (r21 == null) goto L64;
        Set r22 = r21.e();
        if (r22 == null) goto L64;
        if (r22.isEmpty() == true) goto L64;
        Iterator r23 = r22.iterator();
    L62:
        if (r23.hasNext() == false) goto L64;
        String r24 = (String) r23.next();
        r111.put(r24, r21.k(r24));
    L64:
        if (r14 != null) goto L76;
    L69:
        return r110;
    L76:
        r14.put(r12, r111);     // Catch: IOException -> L67
    L67:
        e = move-exception;
        e.printStackTrace();
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L54
    L28:
        if (r20.size() <= 0) goto L78;
        Iterator<Map.Entry<String, List<String>>> r25 = r20.entrySet().iterator();     // Catch: Throwable -> L18
    L30:
        if (r25.hasNext() == false) goto L78;
        Map.Entry<String, List<String>> r26 = r25.next();     // Catch: Throwable -> L18
        String r27 = r26.getKey();     // Catch: Throwable -> L18
        StringBuilder r28 = new StringBuilder();     // Catch: Throwable -> L18
        if ("X-SS-Cookie".equalsIgnoreCase(r27) == true) goto L39;
        if ("Cookie".equalsIgnoreCase(r27) == true) goto L39;
        if (SM.COOKIE2.equalsIgnoreCase(r27) == false) goto L30;
    L39:
        if (r26.getValue().isEmpty() == true) goto L30;
        Iterator<String> r29 = r26.getValue().iterator();     // Catch: Throwable -> L18
        int r30 = 0;
    L42:
        if (r29.hasNext() == false) goto L47;
        String r31 = r29.next();     // Catch: Throwable -> L18
        if (r30 <= 0) goto L46;
        r28.append("; ");     // Catch: Throwable -> L18
    L46:
        r28.append(r31);     // Catch: Throwable -> L18
        r30 = r30 + 1;     // Catch: Throwable -> L18
        goto L42
    L47:
        r13.a(r27, r28.toString());     // Catch: Throwable -> L18
        goto L30
    L72:
        r20 = r14.get(r12, r16);     // Catch: Throwable -> L18 IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
    L5:
        r12 = com.bytedance.frameworks.baselib.network.http.util.g.a(r10.k().toString());
        goto L6
    }
}
