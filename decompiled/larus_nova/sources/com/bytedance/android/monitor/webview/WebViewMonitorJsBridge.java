package com.bytedance.android.monitor.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
class WebViewMonitorJsBridge {
    private WeakReference<WebView> mWebViewRef;
    private Handler mainHandler;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f162871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162872c;

        public final void a() {
            String r100 = bz2.e.e(bz2.e.j(this.f162870a), "url");     // Catch: Throwable -> L4
            h.f162934h.h((WebView) WebViewMonitorJsBridge.access$000(this.f162872c).get(), r100, this.f162871b, this.f162870a);     // Catch: Throwable -> L4
            return;
        L4:
            bz2.c.a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(WebViewMonitorJsBridge r100, String r101, String r102) {
            this.f162872c = r100;
            this.f162870a = r101;
            this.f162871b = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f162874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162875c;

        @Override // java.lang.Runnable
        public final void run() {
            h.f162934h.v((WebView) WebViewMonitorJsBridge.access$000(this.f162875c).get(), this.f162873a, this.f162874b);     // Catch: Throwable -> L4
            return;
        L4:
            bz2.c.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L10;
            return;
        L10:
            throw th;
        }

        public b(WebViewMonitorJsBridge r100, String r101, String r102) {
            this.f162875c = r100;
            this.f162873a = r101;
            this.f162874b = r102;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162877b;

        public final void a() {
            JSONArray r100 = new JSONArray(this.f162876a);     // Catch: Exception -> L13
            int r101 = 0;
        L3:
            if (r101 >= r100.length()) goto L22;
            JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r100, r101);     // Catch: Exception -> L13
            String r103 = r102.toString();     // Catch: Exception -> L13
            String r104 = bz2.e.e(r102, NsdHelper.serviceTypeKey);     // Catch: Exception -> L13
            if (r104.equals("") == false) goto L9;
            JSONObject r105 = bz2.e.j(bz2.e.e(r102, "category"));     // Catch: Exception -> L13
            JSONObject r106 = bz2.e.j(bz2.e.e(r102, "metrics"));     // Catch: Exception -> L13
            JSONObject r107 = bz2.e.j(bz2.e.e(r102, "timing"));     // Catch: Exception -> L13
            JSONObject r108 = bz2.e.j(bz2.e.e(r102, "extra"));     // Catch: Exception -> L13
            String r109 = bz2.e.e(r102, "eventName");     // Catch: Exception -> L13
            boolean r110 = bz2.e.b(r102, "canSample", Boolean.TRUE);     // Catch: Exception -> L13
            py2.d r111 = new py2.d();     // Catch: Exception -> L13
            r111.f530983c = r109;     // Catch: Exception -> L13
            r111.f530981a = null;     // Catch: Exception -> L13
            r111.f530982b = null;     // Catch: Exception -> L13
            r111.f530984d = r105;     // Catch: Exception -> L13
            r111.f530985e = r106;     // Catch: Exception -> L13
            r111.f530986f = r108;     // Catch: Exception -> L13
            r111.f530987g = r107;     // Catch: Exception -> L13
            r111.f530988h = new JSONObject();     // Catch: Exception -> L13
            r111.f530990j = r110;     // Catch: Exception -> L13
            r111.f530989i = null;     // Catch: Exception -> L13
            r111.f530991k = HybridMonitor.getInstance().getCustomReportMonitor();     // Catch: Exception -> L13
            h.f162933g.j((WebView) WebViewMonitorJsBridge.access$000(this.f162877b).get(), r111);     // Catch: Exception -> L13
        L12:
            r101 = r101 + 1;
            goto L3
        L9:
            if (r104.equals(PerfLog.TAG_PERF) == false) goto L11;
            String r112 = bz2.e.e(r102, "url");     // Catch: Exception -> L13
            h.f162934h.h((WebView) WebViewMonitorJsBridge.access$000(this.f162877b).get(), r112, r104, r103);     // Catch: Exception -> L13
            goto L12
        L11:
            h.f162934h.v((WebView) WebViewMonitorJsBridge.access$000(this.f162877b).get(), r104, r103);     // Catch: Exception -> L13
            goto L12
        L22:
            return;
        L13:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(WebViewMonitorJsBridge r100, String r101) {
            this.f162877b = r100;
            this.f162876a = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f162879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f162880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f162881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f162882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f162883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162884g;

        public final void a() {
            JSONObject r100 = bz2.e.j(this.f162878a);     // Catch: Throwable -> L4
            JSONObject r101 = bz2.e.j(this.f162879b);     // Catch: Throwable -> L4
            JSONObject r102 = bz2.e.j(this.f162880c);     // Catch: Throwable -> L4
            JSONObject r103 = bz2.e.j(this.f162881d);     // Catch: Throwable -> L4
            String r104 = this.f162882e;     // Catch: Throwable -> L4
            boolean r105 = this.f162883f;     // Catch: Throwable -> L4
            py2.d r106 = new py2.d();     // Catch: Throwable -> L4
            r106.f530983c = r104;     // Catch: Throwable -> L4
            r106.f530981a = null;     // Catch: Throwable -> L4
            r106.f530982b = null;     // Catch: Throwable -> L4
            r106.f530984d = r100;     // Catch: Throwable -> L4
            r106.f530985e = r101;     // Catch: Throwable -> L4
            r106.f530986f = r102;     // Catch: Throwable -> L4
            r106.f530987g = r103;     // Catch: Throwable -> L4
            r106.f530988h = new JSONObject();     // Catch: Throwable -> L4
            r106.f530990j = r105;     // Catch: Throwable -> L4
            r106.f530989i = null;     // Catch: Throwable -> L4
            r106.f530991k = HybridMonitor.getInstance().getCustomReportMonitor();     // Catch: Throwable -> L4
            h.f162933g.j((WebView) WebViewMonitorJsBridge.access$000(this.f162884g).get(), r106);     // Catch: Throwable -> L4
            return;
        L4:
            bz2.c.a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(WebViewMonitorJsBridge r100, String r101, String r102, String r103, String r104, String r105, boolean r106) {
            this.f162884g = r100;
            this.f162878a = r101;
            this.f162879b = r102;
            this.f162880c = r103;
            this.f162881d = r104;
            this.f162882e = r105;
            this.f162883f = r106;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162886b;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = h.f162934h;     // Catch: Throwable -> L13
            WebView r101 = (WebView) WebViewMonitorJsBridge.access$000(this.f162886b).get();     // Catch: Throwable -> L13
            String r102 = this.f162885a;     // Catch: Throwable -> L13
            r100.getClass();     // Catch: Throwable -> L13
            com.bytedance.android.monitor.webview.b r103 = r100.k(r101);     // Catch: Exception -> L11 Throwable -> L13
            if (r103 == null) goto L18;
            com.bytedance.android.monitor.webview.c r104 = r103.f162894b;     // Catch: Exception -> L11 Throwable -> L13
            if (r104 == null) goto L18;
            r104.g(r101, r102);     // Catch: Exception -> L11 Throwable -> L13
        L18:
            return;
        L11:
            bz2.c.a();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }

        public e(WebViewMonitorJsBridge r100, String r101) {
            this.f162886b = r100;
            this.f162885a = r101;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162888b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f162889a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ f f162890b;

            public final void a() {
                ty2.a.a("TTLiveWebViewMonitorJsBridge");     // Catch: Throwable -> L8
                String r100 = bz2.e.e(this.f162889a, "needReport");     // Catch: Throwable -> L8
                if (TextUtils.isEmpty(r100) == false) goto L5;
                return;
            L5:
                if (r100.equals("true") == false) goto L13;
                h.f162933g.x((WebView) WebViewMonitorJsBridge.access$000(this.f162890b.f162888b).get());     // Catch: Throwable -> L8
                return;
            L13:
                return;
            L8:
                bz2.c.a();
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(f r100, String r101, JSONObject r102) {
                this.f162890b = r100;
                this.f162889a = r102;
            }
        }

        public final void a() {
            h r100 = h.f162934h;
            if (r100.q((WebView) WebViewMonitorJsBridge.access$000(this.f162888b).get()) == true) goto L5;
            return;
        L5:
            JSONObject r101 = bz2.e.j(this.f162887a);
            String r102 = bz2.e.e(r101, "performance");
            String r103 = bz2.e.e(bz2.e.j(r102), NsdHelper.serviceTypeKey);
            String r104 = bz2.e.e(r101, "resource");
            String r105 = bz2.e.e(bz2.e.j(r104), NsdHelper.serviceTypeKey);
            String r106 = bz2.e.e(r101, "url");
            r100.h((WebView) WebViewMonitorJsBridge.access$000(this.f162888b).get(), r106, r103, r102);
            r100.v((WebView) WebViewMonitorJsBridge.access$000(this.f162888b).get(), r105, r104);
            WebViewMonitorJsBridge.access$100(this.f162888b).post(new a(this, r106, r101));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(WebViewMonitorJsBridge r100, String r101) {
            this.f162888b = r100;
            this.f162887a = r101;
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f162891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebViewMonitorJsBridge f162892b;

        public final void a() {
            h r100 = h.f162934h;
            if (r100.q((WebView) WebViewMonitorJsBridge.access$000(this.f162892b).get()) == true) goto L5;
            return;
        L5:
            WebView r101 = (WebView) WebViewMonitorJsBridge.access$000(this.f162892b).get();
            long r102 = this.f162891a;
            r100.getClass();
            com.bytedance.android.monitor.webview.b r103 = r100.k(r101);     // Catch: Exception -> L14
            if (r103 == null) goto L18;
            com.bytedance.android.monitor.webview.c r104 = r103.f162894b;     // Catch: Exception -> L14
            if (r104 == null) goto L19;
            r104.k(r101, r102);     // Catch: Exception -> L14
            return;
        L19:
            return;
        L18:
            return;
        L14:
            bz2.c.a();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(WebViewMonitorJsBridge r100, long r101) {
            this.f162892b = r100;
            this.f162891a = r101;
        }
    }

    @JavascriptInterface
    public String getVersion() {
        return "1.2.2-rc.3.1-bugfix";
    }

    @JavascriptInterface
    public void injectJS() {
        ry2.b.b(new g(this, System.currentTimeMillis()));
    }

    public WebViewMonitorJsBridge(WebView r100) {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mWebViewRef = new WeakReference(r100);
    }

    public static /* synthetic */ WeakReference access$000(WebViewMonitorJsBridge r100) {
        return r100.mWebViewRef;
    }

    public static /* synthetic */ Handler access$100(WebViewMonitorJsBridge r100) {
        return r100.mainHandler;
    }

    @JavascriptInterface
    public void batch(String r100) {
        if (h.f162934h.q(this.mWebViewRef.get()) == true) goto L5;
        return;
    L5:
        ry2.b.b(new c(this, r100));
    }

    @JavascriptInterface
    public void reportPageLatestData(String r100) {
        ry2.b.b(new f(this, r100));
    }

    @JavascriptInterface
    public void sendInitTimeInfo(String r100) {
        if (h.f162934h.q(this.mWebViewRef.get()) == true) goto L5;
        return;
    L5:
        ry2.b.b(new e(this, r100));
    }

    @JavascriptInterface
    public void cover(String r100, String r101) {
        if (h.f162934h.q(this.mWebViewRef.get()) == true) goto L5;
        return;
    L5:
        ry2.b.b(new a(this, r100, r101));
    }

    @JavascriptInterface
    public void reportDirectly(String r100, String r101) {
        if (h.f162934h.q(this.mWebViewRef.get()) == true) goto L5;
        return;
    L5:
        ry2.b.b(new b(this, r101, r100));
    }

    @JavascriptInterface
    public void customReport(String r110, String r111, String r112, boolean r113, String r114, String r115) {
        if (h.f162934h.q(this.mWebViewRef.get()) == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return;
    L8:
        ry2.b.b(new d(this, r112, r111, r114, r115, r110, r113));
    }
}
