package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.u;
import okhttp3.w;

/* JADX INFO: compiled from: OkHttp3SecurityFactorInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements w {
    public n() {
    }

    @Override // okhttp3.w
    public ad intercept(w.a r9) {
        w.a r8 = (w.a) ZeusTransformUtils.wrapperContextForParams(r9, w.a.class, "com.obric.aiagent.plugin");
        ab r10 = r8.a();
        if ("1".equals(r10.c().a("x-metasec-bypass-mssdk")) == false) goto L6;
        ab.a r11 = r10.h();
        r11.b("x-metasec-bypass-mssdk");
        return r8.a(r11.b());
    L6:
        Map<String, String> r1 = com.bytedance.frameworks.baselib.network.http.g.a(r10.a().toString(), r10.c().e());
        Map<String, String> r2 = null;
        if ("1".equals(r10.c().a("x-tt-oec-opaque-enable")) == false) goto L9;
        r2 = com.bytedance.frameworks.baselib.network.http.g.b(r10.a().toString(), r10.c().e());
    L9:
        if (r1 != null) goto L13;
        if (r2 != null) goto L13;
        return r8.a(r10);
    L13:
        ab.a r3 = new ab.a();
        r3.a(r10.a());
        r3.a(r10.b(), r10.d());
        r3.a(r10.g());
        u.a r12 = r10.c().d();
        if (r1 == null) goto L19;
        Iterator<Map.Entry<String, String>> r4 = r1.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L19;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r12.a((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.aiagent.plugin"));
    L19:
        if (r2 == null) goto L24;
        Iterator<Map.Entry<String, String>> r6 = r2.entrySet().iterator();
    L22:
        if (r6.hasNext() == false) goto L24;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r12.a((String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.aiagent.plugin"));
    L24:
        r12.b("x-tt-oec-opaque-enable");
        r3.a(r12.b());
        return r8.a(r3.b());
    }
}
