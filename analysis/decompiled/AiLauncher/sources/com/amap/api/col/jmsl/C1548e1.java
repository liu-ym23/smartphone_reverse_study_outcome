package com.amap.api.col.jmsl;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amap.api.col.jmsl.Z;
import com.amap.api.maps.AMapCallback;
import java.io.File;
import java.io.IOException;
import java.net.ResponseCache;
import java.util.Map;

/* renamed from: com.amap.api.col.jmsl.e1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1548e1 extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16595a;

    /* renamed from: b, reason: collision with root package name */
    public final R2 f16596b;

    /* renamed from: c, reason: collision with root package name */
    public C1555g0 f16597c;

    /* renamed from: e, reason: collision with root package name */
    public C1618w0 f16599e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16598d = true;

    /* renamed from: f, reason: collision with root package name */
    public String f16600f = null;

    /* renamed from: com.amap.api.col.jmsl.e1$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Z f16601a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f16602b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f16603c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f16604d;

        public a(Z z10, String str, long j10, String str2) {
            this.f16601a = z10;
            this.f16602b = str;
            this.f16603c = j10;
            this.f16604d = str2;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            C1548e1.this.b(this.f16601a, this.f16602b);
            if (C1623x1.f17030a) {
                r.f(111, "response cost " + (System.currentTimeMillis() - this.f16603c) + " url " + this.f16604d);
            }
        }
    }

    public C1548e1(Context context) throws IOException {
        this.f16595a = context;
        this.f16596b = new R2(context);
        if (this.f16598d) {
            try {
                HttpResponseCache.install(new File(context.getCacheDir(), "amap_http_cache"), 104857600L);
                C1555g0 c1555g0 = new C1555g0(ResponseCache.getDefault());
                this.f16597c = c1555g0;
                ResponseCache.setDefault(c1555g0);
            } catch (IOException e10) {
                Log.i("mapcore", "HTTP response cache installation failed:" + e10);
            }
            C1618w0 c1618w0 = new C1618w0(context, new File(context.getCacheDir(), "amap_disk_cache"), 104857600L, 100);
            this.f16599e = c1618w0;
            c1618w0.g(this.f16596b);
        }
    }

    public final WebResourceResponse a(Uri uri, Map<String, String> map) throws Throwable {
        WebResourceResponse webResourceResponse;
        try {
            if (this.f16600f == null) {
                this.f16600f = C1567j0.n(this.f16595a);
            }
            Q q10 = new Q(uri, map, this.f16595a, this.f16600f);
            q10.c();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String string = q10.e().toString();
            if (C1623x1.f17030a) {
                r.f(111, "start getdata " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + string);
            }
            String strF = f(map, "Content-Type");
            String strF2 = f(map, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h);
            C1618w0 c1618w0 = this.f16599e;
            boolean z10 = false;
            if (c1618w0 != null) {
                WebResourceResponse webResourceResponseB = c1618w0.b(string);
                if (webResourceResponseB != null) {
                    if (C1623x1.f17030a) {
                        r.f(111, "response from data diskcache cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + string);
                    }
                    z10 = true;
                } else {
                    webResourceResponseB = this.f16599e.c(string, q10.e().getPath(), strF, strF2);
                    if (webResourceResponseB != null) {
                        if (C1623x1.f17030a) {
                            r.f(111, "response from assets or file diskcache cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + string);
                        }
                        return webResourceResponseB;
                    }
                }
                webResourceResponse = webResourceResponseB;
            } else {
                webResourceResponse = null;
            }
            q10.b();
            String string2 = q10.e().toString();
            if (C1623x1.f17030a) {
                r.f(111, "start request   " + string2);
            }
            Z z11 = new Z(this.f16595a, q10);
            if (z10) {
                C1534b.a().b(new a(z11, string, jCurrentTimeMillis, string2));
                return webResourceResponse;
            }
            WebResourceResponse webResourceResponseB2 = b(z11, string);
            if (webResourceResponseB2 != null) {
                if (C1623x1.f17030a) {
                    r.f(111, "response cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " url " + string2);
                }
                return webResourceResponseB2;
            }
            if (C1623x1.f17030a) {
                r.f(111, "response cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " resResult.response is null" + string2);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final WebResourceResponse b(Z z10, String str) throws IOException {
        Z.a aVarM;
        try {
            aVarM = z10.m();
        } catch (C1599r1 e10) {
            if (C1623x1.f17030a) {
                r.f(111, "makeHttpRequestAndSave failed " + str);
            }
            e10.printStackTrace();
            aVarM = null;
        }
        if (aVarM == null) {
            return null;
        }
        C1618w0 c1618w0 = this.f16599e;
        if (c1618w0 != null) {
            c1618w0.i(str, aVarM.f16496a.getMimeType(), aVarM.f16496a.getEncoding(), aVarM.f16497b);
        }
        return aVarM.f16496a;
    }

    public WebResourceResponse d(String str, Map<String, String> map) {
        WebResourceResponse webResourceResponseC;
        try {
            Uri uri = Uri.parse(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String scheme = uri.getScheme();
            if (scheme != null && scheme.equals("http")) {
                return a(uri, map);
            }
            if (C1623x1.f17030a) {
                r.f(111, "start getdata " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + str);
            }
            String strF = f(map, "Content-Type");
            String strF2 = f(map, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30849h);
            C1618w0 c1618w0 = this.f16599e;
            if (c1618w0 == null || (webResourceResponseC = c1618w0.c(str, uri.getPath(), strF, strF2)) == null) {
                if (C1623x1.f17030a) {
                    r.f(111, "response cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " response is null " + str);
                }
                return null;
            }
            if (C1623x1.f17030a) {
                r.f(111, "response from assets or file diskcache cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + str);
            }
            return webResourceResponseC;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public R2 e() {
        return this.f16596b;
    }

    public final String f(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getKey().equals(str)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void g(String str, String str2, int i10, AMapCallback<Boolean> aMapCallback) throws Throwable {
        this.f16599e.h(str, str2, i10, aMapCallback);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (!this.f16598d || str == null || str.contains("blob:")) {
            return null;
        }
        return d(str, null);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String string;
        if (!this.f16598d || (string = webResourceRequest.getUrl().toString()) == null || string.contains("blob:")) {
            return null;
        }
        return d(string, webResourceRequest.getRequestHeaders());
    }
}
