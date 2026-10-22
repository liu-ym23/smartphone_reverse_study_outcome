package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.u;
import okhttp3.w;

/* JADX INFO: compiled from: OkHttp3CookieInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements w {
    public j() {
    }

    @Override // okhttp3.w
    public ad intercept(w.a r14) {
        w.a r15 = (w.a) ZeusTransformUtils.wrapperContextForParams(r14, w.a.class, "com.obric.aiagent.plugin");
        ab r0 = r15.a();
        if (r0 != null) goto L5;
    L92:
        URI r2 = r0.a().f();     // Catch: Exception -> L12
    L13:
        ab.a r3 = r0.h();
        CookieHandler r4 = CookieHandler.getDefault();
        u r5 = r0.c();
        Map<String, List<String>> r6 = null;
        if (r2 == null) goto L16;
        String r7 = com.bytedance.frameworks.baselib.network.http.i.c.a(r2.toString());
    L94:
        HashMap r8 = new HashMap();     // Catch: Throwable -> L66
        if (r5 == null) goto L28;
        Set<String> r9 = r5.b();     // Catch: Throwable -> L66
        if (r9 == null) goto L28;
        if (r9.isEmpty() == true) goto L28;
        Iterator<String> r10 = r9.iterator();     // Catch: Throwable -> L66
    L25:
        if (r10.hasNext() == false) goto L28;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
        r8.put(r11, r5.b(r11));     // Catch: Throwable -> L66
    L28:
        if (r0 != null) goto L30;
    L34:
        boolean r12 = false;
    L35:
        if (r4 == null) goto L43;
        if (r12 == true) goto L43;
        if (r7 == null) goto L39;
        Map<String, List<String>> r13 = r4.get(new URI(r7), r8);     // Catch: IOException -> L41 Throwable -> L66
    L40:
        r6 = r13;
    L39:
        r13 = r4.get(r2, r8);     // Catch: IOException -> L41 Throwable -> L66
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
    L43:
        if (r6 != null) goto L45;
    L90:
        r0 = r3.b();     // Catch: Throwable -> L70
    L72:
        ad r16 = r15.a(r0);
        HashMap r17 = new HashMap();
        u r1 = r16.f();
        if (r1 == null) goto L82;
        Set<String> r18 = r1.b();
        if (r18 == null) goto L82;
        if (r18.isEmpty() == true) goto L82;
        Iterator<String> r19 = r18.iterator();
    L80:
        if (r19.hasNext() == false) goto L82;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin");
        r17.put(r20, r1.b(r20));
    L82:
        if (r4 != null) goto L99;
    L89:
        return r16;
    L99:
        if (r7 == null) goto L85;
        r4.put(new URI(r7), r17);     // Catch: Throwable -> L87
    L98:
        goto L89
    L85:
        r4.put(r2, r17);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.printStackTrace();
    L70:
        th = move-exception;
        th.printStackTrace();
        goto L72
    L45:
        if (r6.size() <= 0) goto L90;
        Iterator<Map.Entry<String, List<String>>> r110 = r6.entrySet().iterator();     // Catch: Throwable -> L66
    L47:
        if (r110.hasNext() == false) goto L90;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
        StringBuilder r23 = new StringBuilder();     // Catch: Throwable -> L66
        if ("X-SS-Cookie".equalsIgnoreCase(r22) == true) goto L56;
        if ("Cookie".equalsIgnoreCase(r22) == true) goto L56;
        if ("Cookie2".equalsIgnoreCase(r22) == false) goto L47;
    L56:
        if (((List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L47;
        Iterator r24 = ((List) ZeusTransformUtils.preCheckCast(r21.getValue(), List.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L66
        int r111 = 0;
    L59:
        if (r24.hasNext() == false) goto L64;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L66
        if (r111 <= 0) goto L63;
        r23.append("; ");     // Catch: Throwable -> L66
    L63:
        r23.append(r112);     // Catch: Throwable -> L66
        r111 = r111 + 1;     // Catch: Throwable -> L66
        goto L59
    L64:
        r3.b(r22, r23.toString());     // Catch: Throwable -> L66
        goto L47
    L30:
        if (r0.c() == null) goto L34;
        r12 = "1".equals(r0.a("x-metasec-bypass-okhttp-cookie"));     // Catch: Throwable -> L66
        if ("1".equals(r0.a("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L35;
        r12 = true;
    L66:
        th = move-exception;
        th.printStackTrace();
        goto L90
    L16:
        r7 = null;
    L12:
        r2 = com.bytedance.frameworks.baselib.network.http.i.j.b(r0.a().toString());
        goto L13
    L5:
        if (r0.c() == null) goto L92;
        if ("0".equals(r0.a("x-ttnet-bypass-cookie")) == false) goto L92;
        ab.a r113 = r0.h();
        r113.b("x-ttnet-bypass-cookie");
        return r15.a(r113.b());
    }
}
