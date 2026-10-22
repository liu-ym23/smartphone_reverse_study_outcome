package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.os.Build;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import me.ele.lancet.base.annotations.Skip;
import okhttp3.aa;
import okhttp3.ag;
import okhttp3.z;

/* JADX INFO: compiled from: OkHttp3Builder.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f8534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8535c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f8536a;

    /* JADX INFO: compiled from: OkHttp3Builder.java */
    public interface a {
        void a(z.a r1);
    }

    static {
    }

    public i() {
    }

    public static void a(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        if (f8535c != 0) goto L8;
        f8535c = r1;
        return;
    }

    private static z a(z r2) {
        int r0 = f8535c;
        if (r0 > 0) goto L5;
        return r2;
    L5:
        if (r0 >= 4) goto L10;
        if (r2 == null) goto L11;
        z.a r3 = r2.E();
        a(r3);
        return r3.E();
    L11:
        return r2;
    L10:
        return r2;
    }

    private static void a(z.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = f8535c;
        if (r1 != 1) goto L7;
        r0.add(aa.f39697e);
    L13:
        f8535c = 4;
        r0.add(aa.f39695c);
        r3.b(Collections.unmodifiableList(r0));
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.add(aa.f39696d);
        goto L13
    L9:
        if (r1 == 3) goto L13;
        r0.add(aa.f39697e);
        r0.add(aa.f39696d);
        goto L13
    }

    public z a(boolean r7) {
        if (r7 == false) goto L5;
        com.bytedance.frameworks.baselib.network.http.g.k();
    L5:
        monitor-enter(com.bytedance.frameworks.baselib.network.http.g.class);
        z r0 = this.f8536a;     // Catch: Throwable -> L22
        if (r0 == null) goto L11;
        a(r0);     // Catch: Throwable -> L22
        z r6 = this.f8536a;     // Catch: Throwable -> L22
        monitor-exit(com.bytedance.frameworks.baselib.network.http.g.class);     // Catch: Throwable -> L22
        return r6;
    L11:
        z.a r1 = new z.a();     // Catch: Throwable -> L22
        int r2 = f8535c;     // Catch: Throwable -> L22
        if (r2 > 0) goto L14;
    L16:
        r1.a(new okhttp3.k(15, 180000, TimeUnit.MILLISECONDS));     // Catch: Throwable -> L22
        r1.a(com.bytedance.frameworks.baselib.network.http.g.a(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.b(com.bytedance.frameworks.baselib.network.http.g.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.c(com.bytedance.frameworks.baselib.network.http.g.b(), TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        r1.b(new AnonymousClass1(this));     // Catch: Throwable -> L22
        r1.ttnetDns(k.a());     // Catch: Throwable -> L22
        r1.a(okhttp3.n.f40179b);     // Catch: Throwable -> L22
        r1.b(new j());     // Catch: Throwable -> L22
        r1.a(new n());     // Catch: Throwable -> L22
        r1.a(new o());     // Catch: Throwable -> L22
        r1.b(new l());     // Catch: Throwable -> L22
        z.a r3 = b(r1);     // Catch: Throwable -> L22
        r3.b(true);     // Catch: Throwable -> L22
        a r4 = f8534b;     // Catch: Throwable -> L22
        if (r4 == null) goto L19;
        r4.a(r3);     // Catch: Throwable -> L22
    L19:
        z r5 = r3.E();     // Catch: Throwable -> L22
        this.f8536a = r5;     // Catch: Throwable -> L22
        monitor-exit(com.bytedance.frameworks.baselib.network.http.g.class);     // Catch: Throwable -> L22
        return r5;
    L14:
        if (r2 >= 4) goto L16;
        a(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static z.a b(z.a r6) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L15:
        return r6;
    L5:
        if (Build.VERSION.SDK_INT >= 22) goto L15;
        SSLContext r2 = SSLContext.getInstance("TLSv1.2");     // Catch: Exception -> L13
        r2.init(null, null, null);     // Catch: Exception -> L13
        r6.a(new t(r2.getSocketFactory()));     // Catch: Exception -> L9
    L11:
        okhttp3.l r3 = new okhttp3.l.a(okhttp3.l.f40166c).a(new ag[]{ag.f39731c}).a();     // Catch: Exception -> L13
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L13
        r4.add(r3);     // Catch: Exception -> L13
        r4.add(okhttp3.l.f40167d);     // Catch: Exception -> L13
        r4.add(okhttp3.l.f40168e);     // Catch: Exception -> L13
        r6.a(r4);     // Catch: Exception -> L13
        goto L15
    L9:
        e = move-exception;
        a("OkHttpTLSCompat", "Error while setting TLS 1.2", e);     // Catch: Exception -> L13
        r6 = a(r6, r2);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        a("OkHttpTLSCompat", "Error while setting TLS 1.2", e);
        goto L15
    }

    private static z.a a(z.a r5, SSLContext r6) {
        TrustManagerFactory r0 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r0.init((KeyStore) ZeusTransformUtils.preCheckCast(null, KeyStore.class, "com.obric.aiagent.plugin"));
        TrustManager[] r1 = r0.getTrustManagers();
        if (r1.length != 1) goto L9;
        if (ZeusTransformUtils.instanceOf(r1[0], X509TrustManager.class) == false) goto L9;
        r5.a(new t(r6.getSocketFactory()), (X509TrustManager) ZeusTransformUtils.preCheckCast(r1[0], X509TrustManager.class, "com.obric.aiagent.plugin"));
        return r5;
    L9:
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(r1));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
