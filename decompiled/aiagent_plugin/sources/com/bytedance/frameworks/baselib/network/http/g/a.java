package com.bytedance.frameworks.baselib.network.http.g;

import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: BaseSsInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.retrofit2.f.b {
    public void a(com.bytedance.retrofit2.b.c r1, ak r2) {
    }

    public a() {
    }

    public com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r6) {
        if (g.o() == true) goto L5;
    L9:
        if (r6 != null) goto L38;
        return null;
    L38:
        URL r1 = new URL(r6.b());     // Catch: MalformedURLException -> L34
        if ("http".equals(r1.getProtocol()) == false) goto L15;
        g.a(r1.getHost(), r1.getPath(), false, r6.p());     // Catch: MalformedURLException -> L34
    L15:
        String r0 = r6.b();
        if (ZeusTransformUtils.instanceOf(r6.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L18;
        String r2 = g.a(r0, (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r6.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin"), r6.p());
    L20:
        if (r6.b().startsWith("https:") == false) goto L25;
        if (r2.startsWith("http:") == false) goto L25;
        URL r3 = new URL(r2);     // Catch: Throwable -> L35
        g.a(r3.getHost(), r3.getPath(), true, r6.p());     // Catch: Throwable -> L35
    L25:
        if (r6.i() == false) goto L32;
        com.bytedance.frameworks.baselib.network.http.a.a r4 = com.bytedance.frameworks.baselib.network.http.a.b.a().b();
        if (r4 != null) goto L29;
    L31:
        r2 = a(r2, r6.p());
        goto L32
    L29:
        if (r4.a() == false) goto L31;
        r2 = com.bytedance.frameworks.baselib.network.http.a.b.a().a(r6, r2, r6.p());
    L32:
        com.bytedance.retrofit2.b.c.a r5 = r6.m();
        r5.a(r2);
        return r5.b();
    L18:
        r2 = g.a(r0, r6.p());
        goto L20
    L5:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L9;
        throw new IOException("You must not send request on main thread");
    }

    private String a(String r1, af r2) {
        return g.a(r1, true, r2);
    L5:
        th = move-exception;
        th.printStackTrace();
        return r1;
    }

    @Override // com.bytedance.retrofit2.d.b
    public ak a(com.bytedance.retrofit2.d.b.a r3) {
        com.bytedance.retrofit2.d.b.a r4 = (com.bytedance.retrofit2.d.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.d.b.a.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.b.c r0 = a(r4.a());
        if (com.bytedance.retrofit2.d.c.b() == false) goto L5;
        ak r5 = r4.b(r0);
    L6:
        a(r0, r5);
        return r5;
    L5:
        r5 = r4.a(r0);
        goto L6
    }
}
