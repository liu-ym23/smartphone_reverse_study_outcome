package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.i;
import com.bytedance.frameworks.baselib.network.http.util.f;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.tnc.TNCManager;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes.dex */
public abstract class HttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile IHttpClientConfig f8107a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8108b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8109c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f8110d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f8111e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f8112f;

    public interface IHttpClientConfig {
        boolean isChromiumOpen();
    }

    public static /* synthetic */ class a {
    }

    public static class b extends c {
        public b() {
            super(null);
        }

        @Override // com.bytedance.ttnet.HttpClient.c
        public IHttpClient a() {
            return d.a(SsCronetHttpClient.y(TTNetInit.getTTNetDepend().getContext()));
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static class c {
        public c() {
        }

        public IHttpClient a() {
            Context r10 = TTNetInit.getTTNetDepend().getContext();
            i r11 = i.H(r10);
            if (f.e(r10) == false) goto L5;
            r11.R(TNCManager.h());
        L5:
            return r11;
        }

        public /* synthetic */ c(a r10) {
            this();
        }
    }

    public static class d implements IHttpClient {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile d f8113c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SsCronetHttpClient f8114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f8115b;

        public d(SsCronetHttpClient r10) {
            this.f8114a = r10;
        }

        public static d a(SsCronetHttpClient r10) {
            if (f8113c != null) goto L16;
            monitor-enter(d.class);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (f8113c != null) goto L11;
            f8113c = new d(r10);     // Catch: Throwable -> L9
        L11:
            monitor-exit(d.class);     // Catch: Throwable -> L9
        L16:
            return f8113c;
        }

        public final void b(Throwable r10) {
            if ((r10 instanceof MalformedURLException) == false) goto L6;
            return;
        L6:
            if (r10.getMessage() == null) goto L11;
            if (r10.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (TTNetInitMetrics.c().d() == false) goto L18;
            int r11 = this.f8115b + 1;
            this.f8115b = r11;
            if (r11 <= 3) goto L19;
            HttpClient.f8110d = true;
            String r12 = com.bytedance.ttnet.utils.c.b(r10);
            HttpClient.f8112f = r12;
            if (r12.length() <= 256) goto L20;
            HttpClient.f8112f = HttpClient.f8112f.substring(0, 256);
            return;
        L20:
            return;
        L19:
            return;
        }

        @Override // com.bytedance.retrofit2.client.Client
        public SsCall newSsCall(g6.b r10) {
            return this.f8114a.newSsCall(r10);
        L4:
            th = move-exception;
            b(th);
            TTNetInit.notifyColdStartFinish();
            return HttpClient.f8108b.a().newSsCall(r10);
        }
    }

    static {
        a r10 = null;
        f8108b = new c(r10);
        f8109c = new b(r10);
    }

    public static String a() {
        return f8112f;
    }

    public static IHttpClient b(String r10) {
        if (c() == false) goto L7;
        return f8109c.a();
    L7:
        return f8108b.a();
    }

    public static boolean c() {
        if (f8107a != null) goto L7;
        i.Q(9);
        return false;
    L7:
        if (f8107a.isChromiumOpen() == true) goto L10;
        return false;
    L10:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L14;
        i.Q(6);
        return false;
    L14:
        if (f8110d == true) goto L16;
        return true;
    L16:
        if (f8111e == true) goto L21;
        i.Q(7);
        i.P(f8112f);
        return false;
    L21:
        return true;
    }

    public static void d(boolean r10) {
        f8111e = r10;
    }

    public static void e(IHttpClientConfig r10) {
        f8107a = r10;
    }
}
