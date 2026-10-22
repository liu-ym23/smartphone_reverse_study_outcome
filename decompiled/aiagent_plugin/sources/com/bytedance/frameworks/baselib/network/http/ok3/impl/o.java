package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.w;

/* JADX INFO: compiled from: OkHttp3TTPSandBoxInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f8548a;

    /* JADX INFO: compiled from: OkHttp3TTPSandBoxInterceptor.java */
    public interface a {
        boolean a(String r1, String r2, Map<String, List<String>> r3, String r4);
    }

    static {
    }

    public o() {
    }

    @Override // okhttp3.w
    public ad intercept(w.a r6) {
        w.a r5 = (w.a) ZeusTransformUtils.wrapperContextForParams(r6, w.a.class, "com.obric.aiagent.plugin");
        ab r7 = r5.a();
        if (f8548a == null) goto L12;
        if ("/get_domains/v5/".equals(r7.a().i()) == false) goto L12;
        if (f8548a.a(r7.b(), r7.a().toString(), r7.c().e(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r5.a(r7);
    }
}
