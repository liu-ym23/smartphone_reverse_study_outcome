package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.w;

/* JADX INFO: compiled from: OkHttp3PureControlInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8540a;

    /* JADX INFO: compiled from: OkHttp3PureControlInterceptor.java */
    public interface a {
        void a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public l() {
    }

    @Override // okhttp3.w
    public ad intercept(w.a r7) {
        w.a r6 = (w.a) ZeusTransformUtils.wrapperContextForParams(r7, w.a.class, "com.obric.aiagent.plugin");
        ab r8 = r6.a();
        if (r8 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        ArrayList r2 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r3 = r8.c().e().entrySet().iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        String r4 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin");
        if (r4.equals("x-tt-bypass-dp") == false) goto L17;
        if (r1 == false) goto L17;
    L18:
        r2.add(r4);
    L17:
        if (r4.startsWith("x-metasec") == false) goto L12;
    L20:
        if (r2.size() <= 0) goto L27;
        ab.a r9 = r8.h();
        Iterator r5 = r2.iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        r9.b((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin"));
        goto L23
    L25:
        r8 = r9.b();
    L27:
        if (f8540a == null) goto L30;
        f8540a.a(r8.b(), r8.a().toString(), r8.c().e(), "");
    L30:
        return r6.a(r8);
    L5:
        if (r8.c() == null) goto L9;
        if (r8.c().a("x-metasec-bypass-ttnet-features") == null) goto L9;
        r1 = "1".equals(r8.c().a("x-metasec-bypass-ttnet-features"));
        goto L10
    }
}
