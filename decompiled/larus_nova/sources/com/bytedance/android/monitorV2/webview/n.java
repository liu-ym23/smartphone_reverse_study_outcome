package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.util.r;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.lynx.webview.extension.TTWebViewExtension;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, c> f163364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, c> f163365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f163366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, WebViewDataManager> f163367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f163368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f163369f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f163370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f163371b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f163370a, r101.f163370a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f163371b, r101.f163371b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f163370a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            c r104 = this.f163371b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ConfigObj(source=" + this.f163370a + ", config=" + this.f163371b + ')';
        }

        public a(String r100, c r101) {
            this.f163370a = r100;
            this.f163371b = r101;
        }
    }

    public n() {
        this.f163364a = new HashMap();
        this.f163365b = new HashMap();
        this.f163366c = new HashSet();
        new Handler(Looper.getMainLooper());
        this.f163367d = new ConcurrentHashMap(new HashMap());
        this.f163368e = new ConcurrentHashMap(new WeakHashMap());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static c b(c r100) {
        c r101 = new c();
        String r102 = r100.f163342g;
        r100.f163342g = r102;
        r101.f163343h = r100.f163343h;
        r101.f163348m = null;
        r101.f163341f = r100.f163341f;
        r101.f163338c = r100.f163338c;
        r101.f163337b = r100.f163337b;
        r101.f163336a = r100.f163336a;
        r101.f163342g = r102;
        r101.f163345j = r100.f163345j;
        if (TextUtils.isEmpty(r100.f163347l) == false) goto L5;
        String r103 = "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    L6:
        r101.f163347l = r103;
        r101.f163346k = r100.f163346k;
        r101.f163344i = r100.f163344i;
        r101.f163340e = r100.f163340e;
        r101.f163349n = r100.f163349n;
        if (TextUtils.isEmpty(r100.f163339d) == true) goto L31;
        JSONObject r104 = com.bytedance.android.monitorV2.util.l.r(r100.f163339d);
        if (com.bytedance.android.monitorV2.util.l.k(r104, "webview_classes") != null) goto L11;
        String[] r105 = r101.f163336a;
    L22:
        r101.f163336a = r105;
        if (com.bytedance.android.monitorV2.util.l.k(r104, "webview_is_need_monitor") != null) goto L25;
        boolean r106 = r101.f163341f;
    L26:
        r101.f163341f = r106;
        if (TextUtils.isEmpty(r100.f163339d) == false) goto L29;
        String r107 = r101.f163347l;
    L30:
        r101.f163347l = r107;
        goto L31
    L29:
        JSONObject r108 = com.bytedance.android.monitorV2.util.l.r(r100.f163339d);
        JSONObject r109 = com.bytedance.android.monitorV2.util.l.i(r108, "apmReportConfig");
        JSONObject r110 = com.bytedance.android.monitorV2.util.l.i(r108, "performanceReportConfig");
        JSONObject r111 = com.bytedance.android.monitorV2.util.l.i(r108, "errorMsgReportConfig");
        JSONObject r112 = com.bytedance.android.monitorV2.util.l.i(r108, "resourceTimingReportConfig");
        JSONObject r113 = com.bytedance.android.monitorV2.util.l.i(r108, "commonReportConfig");
        JSONObject r114 = new JSONObject();
        JSONObject r115 = new JSONObject();
        com.bytedance.android.monitorV2.util.l.p(r114, "monitors", r115);
        com.bytedance.android.monitorV2.util.l.p(r114, "sendCommonParams", r113);
        l.a(r115, r109);
        l.a(r115, r110);
        l.a(r115, r111);
        l.a(r115, r112);
        r107 = "SlardarHybrid('config', " + r114.toString() + ")";
        goto L30
    L25:
        r106 = com.bytedance.android.monitorV2.util.l.r(r100.f163339d).optBoolean("webview_is_need_monitor", false);
        goto L26
    L11:
        String r116 = r100.f163339d;
        String[] r117 = new String[0];
        if (TextUtils.isEmpty(r116) == true) goto L16;
        JSONArray r118 = com.bytedance.android.monitorV2.util.l.h(com.bytedance.android.monitorV2.util.l.r(r116), "webview_classes");
        if (r118 == null) goto L16;
        String[] r119 = new String[r118.length()];
        int r120 = r118.length();
        int r121 = 0;
    L18:
        if (r121 >= r120) goto L21;
        r119[r121] = JSONArrayProtectorUtils.getString(r118, r121);     // Catch: JSONException -> L32
    L20:
        r121 = r121 + 1;
        goto L18
    L21:
        r105 = r119;
    L16:
        r105 = r117;
    L31:
        return r101;
    L5:
        r103 = r100.f163347l;
        goto L6
    }

    public static String c(WebView r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.hashCode() + "";
    }

    public final a e(WebView r100) {
        if (r100 == null) goto L5;
        String r101 = c(r100);
        String r102 = r100.getClass().getName();
        c r103 = this.f163365b.get(r101);
        if (r103 != null) goto L9;
        c r104 = this.f163364a.get(r102);
        if (r104 == null) goto L15;
        return new a("mWebViewClasses:".concat(r102), r104);
    L15:
        if (this.f163366c.contains(r102) == true) goto L17;
        Iterator r105 = new HashSet(this.f163364a.keySet()).iterator();
    L20:
        if (r105.hasNext() == false) goto L40;
        String r106 = (String) r105.next();
        Class<?> r107 = a(r102);     // Catch: Throwable -> L24
    L42:
        Class r108 = a(r106);     // Catch: Throwable -> L28
    L30:
        if (r107 == null) goto L34;
        if (r108 == null) goto L34;
        boolean r109 = r108.isAssignableFrom(r107);
    L35:
        if (r109 == false) goto L20;
        c r110 = this.f163364a.get(r106);
        if (r110 == null) goto L20;
        this.f163364a.put(r102, r110);
        return new a(r102 + " isAssignedFrom:" + r106, r110);
    L34:
        r109 = false;
    L28:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        r108 = null;
    L24:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        r107 = null;
        goto L42
    L40:
        this.f163366c.add(r102);
        return new a("objects classes superclass all miss", null);
    L17:
        return new a("webViewClazz in mWebViewMissClasses", null);
    L9:
        return new a("mWebViewObjs:" + r101 + " viewClass:" + r102, r103);
    L5:
        return new a("view is null", null);
    }

    public final WebViewDataManager f(WebView r100) {
        String r101 = c(r100);
        WebViewDataManager r102 = this.f163367d.get(r101);
        if (r102 != null) goto L9;
        WebViewDataManager r103 = new WebViewDataManager(new WeakReference(r100), this);
        WebViewDataManager r104 = this.f163367d.putIfAbsent(r101, r103);
        if (r104 != null) goto L8;
        return r103;
    L8:
        return r104;
    L9:
        return r102;
    }

    public final boolean h(WebView r100) {
        c r101 = e(r100).f163371b;     // Catch: Exception -> L7
        if (r101 == null) goto L6;
        boolean r102 = r101.f163341f;     // Catch: Exception -> L7
    L10:
        if (this.f163369f == r102) goto L12;
        nz2.b.f("WebViewMonitorHelperImp", "isNeedMonitor: " + r102);
        this.f163369f = r102;
    L12:
        return r102;
    L6:
        r102 = true;
    L7:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
        r102 = false;
        goto L10
    }

    public final boolean i(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        String r101 = c(r100);
        if (this.f163368e.containsKey(r101) == true) goto L5;
        ConcurrentHashMap<String, Boolean> r102 = this.f163368e;
        Lazy r103 = TTUtils.f163378a;
        r102.put(r101, Boolean.valueOf(TTUtils.a(r100)));
    L5:
        Boolean r104 = this.f163368e.get(r101);
        if (r104 != null) goto L9;
        return false;
    L9:
        return r104.booleanValue();
    }

    public final void j(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        WebViewDataManager r101 = f(r100);
        if (r101.f163292h != null) goto L5;
        nz2.b.b(r101.f163287c, "handleViewCreated not work, onAttachedToWindow invoked");
        r101.j();
        r101.g(WebViewLifeState.ATTACHED);
    L5:
        WebView r102 = r101.d();
        if (r102 == null) goto L9;
        sz2.a r103 = sz2.a.f543906a;
        sz2.a.e(r102, new i(r101));
        return;
    }

    public final void o(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        WebViewDataManager r101 = f(r100);
        r101.f163290f = new NavigationDataManager(r101);
        r101.g(WebViewLifeState.CREATED);
        WebView r102 = r101.d();
        if (r102 != null) goto L5;
    L10:
        r101.j();
        WebView r103 = r101.d();
        if (r103 == null) goto L14;
        new TTWebViewExtension(r103).setPerformanceTimingListener(new com.bytedance.android.monitorV2.webview.ttweb.c(new j(r101)));
        return;
    L14:
        return;
    L5:
        if (r101.f163292h != null) goto L7;
        r101.f163292h = new WebViewDataManager.a(r101);
    L7:
        WebViewDataManager.a r104 = r101.f163292h;
        if (r104 == null) goto L10;
        Intrinsics.checkNotNullParameter(r102, "webView");
        r102.removeOnAttachStateChangeListener(r104);
        r102.addOnAttachStateChangeListener(r104);
        goto L10
    }

    public final void p(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        WebViewDataManager r101 = f(r100);
        r101.a(true);
        r101.g(WebViewLifeState.DESTROYED);
        WebView r102 = r101.d();
        if (r102 == null) goto L7;
        WebViewDataManager.a r103 = r101.f163292h;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNullParameter(r102, "webView");
        r102.removeOnAttachStateChangeListener(r103);
    L7:
        String r104 = c(r100);
        this.f163367d.remove(r104);
        this.f163368e.remove(r104);
        this.f163365b.remove(r104);
    }

    public final void d(WebView r100, com.bytedance.android.monitorV2.event.b r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "customEvent");
        WebViewDataManager r102 = f(r100);
        Intrinsics.checkNotNullParameter(r101, "customEvent");
        NavigationDataManager r103 = r102.f163290f;
        if (r103 == null) goto L5;
        r103.f(r101);
        Unit r104 = Unit.INSTANCE;
    L6:
        if (r104 != null) goto L9;
        r101.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);
        return;
    L9:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void g(WebView r100, RenderProcessGoneDetail r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "detail");
        WebViewDataManager r102 = f(r100);
        Intrinsics.checkNotNullParameter(r101, "webdetail");
        WebView r103 = r102.d();
        if (r103 == null) goto L14;
        String r104 = r103.getUrl();
        if (TextUtils.isEmpty(r104) == true) goto L14;
        if (r104 == null) goto L14;
        if (r102.f163290f != null) goto L13;
        r102.f163290f = new NavigationDataManager(r102, r104);
    L13:
        nz2.b.a(r102.f163287c, "handleRenderProcessGone: ");
    L14:
        this.f163367d.remove(c(r100));
        this.f163368e.remove(c(r100));
    }

    public final void k(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "url");
        WebViewDataManager r102 = f(r100);
        Intrinsics.checkNotNullParameter(r101, "url");
        boolean r103 = true;
        r102.f163295k++;
        r102.f163296l.put(r101, Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L6:
        NavigationDataManager r104 = r102.f163290f;
        if (r104 == null) goto L9;
        String r105 = r104.f163260b;
    L11:
        if (TextUtils.isEmpty(r105) == false) goto L13;
    L15:
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r102.h(false);
        r102.e();
    L18:
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("engine_type", "web");
        r106.put("url", r101);
        WebView r107 = r102.f163285a.get();
        if (r107 == null) goto L25;
        sz2.a r108 = sz2.a.f543906a;
        List r109 = sz2.a.d(r107);
        if (((ArrayList) r109).isEmpty() == true) goto L25;
        String r110 = (String) ListProtector.get(r109, 0);
        Intrinsics.checkNotNullParameter(r110, "monitorId");
        Object r111 = sz2.a.a(r110).get("container_name");
        if (r111 == null) goto L25;
        r106.put("container_name", (String) r111);
    L25:
        InternalWatcher.b(null, "url_load", r106, null, 8);
        return;
    L13:
        if (Intrinsics.areEqual(r105, "about:blank") == true) goto L15;
    L9:
        r105 = null;
        goto L11
    L5:
        if (Intrinsics.areEqual("about:blank", r101) == false) goto L15;
        goto L6
    }

    public final void l(WebView r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "webView");
        Intrinsics.checkNotNullParameter(r111, "url");
        WebViewDataManager r112 = f(r110);
        Intrinsics.checkNotNullParameter(r111, "url");
        NavigationDataManager r113 = r112.f163290f;
        if (r113 == null) goto L43;
        wz2.b r114 = r113.f163279u;
        if (r114.f561922f != 0) goto L7;
        r114.f561922f = System.currentTimeMillis();
    L7:
        WebView r115 = r113.f163259a.d();
        if (r115 == null) goto L38;
        Lazy r100 = TTUtils.f163378a;
        JSONObject r101 = TTUtils.b(r115, TTUtils.MetricsArgs.Metrics);
        HybridSettingInitConfig r102 = com.bytedance.android.monitorV2.g.e().d().getInitConfig();
        if (r102 == null) goto L19;
        String r103 = r102.f163095g;
        if (r103 == null) goto L19;
        if (Intrinsics.areEqual(r103, "local_test") == true) goto L17;
        r103 = null;
    L17:
        if (r103 == null) goto L19;
        r113.f163279u.f561932p = r101;
    L19:
        int r104 = com.bytedance.android.monitorV2.webview.ttweb.a.f163385a;
        Intrinsics.checkNotNullParameter(r115, "webView");
        Intrinsics.checkNotNullParameter(r101, "metrics");
        JSONObject r105 = com.bytedance.android.monitorV2.util.l.i(r101, "loading");
        if (r105 != null) goto L22;
        r105 = new JSONObject();
    L22:
        JSONObject r106 = com.bytedance.android.monitorV2.util.l.i(r105, "top_level_timing");
        if (r106 != null) goto L25;
        r106 = new JSONObject();
    L25:
        JSONObject r107 = com.bytedance.android.monitorV2.util.l.i(r105, "create_webview_timing");
        if (r107 != null) goto L28;
        r107 = new JSONObject();
    L28:
        JSONObject r108 = com.bytedance.android.monitorV2.util.l.i(r105, "main_resource_timing");
        if (r108 != null) goto L31;
        r108 = new JSONObject();
    L31:
        JSONObject r109 = com.bytedance.android.monitorV2.util.l.i(r105, "render_timing");
        if (r109 != null) goto L34;
        r109 = new JSONObject();
    L34:
        JSONObject r116 = com.bytedance.android.monitorV2.util.l.i(r105, "ttwebview_info");
        if (r116 != null) goto L37;
        r116 = new JSONObject();
    L37:
        JSONObject r117 = new JSONObject();
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "fcp", r109.optLong("tick_fcp") - r108.optLong("tick_navigation_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "lcp", r106.optLong("tick_lcp") - r108.optLong("tick_navigation_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "fmp", r109.optLong("tick_fmp") - r108.optLong("tick_navigation_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "tti", r109.optLong("tick_tti") - r108.optLong("tick_navigation_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_main_resource_load", r108.optLong("tick_response_end") - r108.optLong("tick_navigation_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_resource_load", r106.optLong("tick_page_finished") - r106.optLong("tick_page_started"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_javascript_execute", r109.optLong("dur_js_execution_before_lcp"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_layout", r106.optLong("dur_layout_before_lcp"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_paint", r106.optLong("dur_paint_before_lcp"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_webview_create_time", r106.optLong("tick_create_webview_end") - r106.optLong("tick_create_webview_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_init_ttwebview_provider", r107.optLong("tick_init_ttwebview_provider_end") - r107.optLong("tick_init_ttwebview_provider_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_create_factory_provider", r107.optLong("tick_create_factory_provider_end") - r107.optLong("tick_create_factory_provider_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_webview_chromium_construct", r107.optLong("tick_webview_chromium_construct_end") - r107.optLong("tick_webview_chromium_construct_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_webview_chromium_init", r107.optLong("tick_webview_chromium_init_end") - r107.optLong("tick_webview_chromium_init_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_load_library", r107.optLong("tick_load_library_end") - r107.optLong("tick_load_library_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_start_engines", r107.optLong("tick_start_engines_end") - r107.optLong("tick_start_engines_start"));
        com.bytedance.android.monitorV2.webview.ttweb.a.a(r117, "dur_wait_render_process_ready_time", r106.optLong("tick_render_process_ready") - r106.optLong("tick_loadurl"));
        m r118 = m.f163358f;
        jz2.d.a r119 = new jz2.d.a("ttwebview_metrics_from_monitor");
        r119.f501117e = r117;
        r119.f501116d = r116;
        r119.b(2);
        r118.j(r115, r119.a());
    L38:
        r113.j();
        Lazy<yz2.a> r120 = NavigationDataManager.C;
        yz2.a r121 = NavigationDataManager.a.a();
        if (r121 == null) goto L41;
        r121.onPageFinished();
    L41:
        r113.f163268j.a(3);
        return;
    }

    public final void m(WebView r110, com.bytedance.android.monitorV2.event.a r111) {
        Intrinsics.checkNotNullParameter(r110, "webView");
        Intrinsics.checkNotNullParameter(r111, "event");
        WebViewDataManager r112 = f(r110);
        Intrinsics.checkNotNullParameter(r111, "event");
        String r100 = r111.f163006f.url;
        NavigationDataManager r101 = r112.f163293i;
        if (r101 == null) goto L5;
        r101.d();
    L5:
        jz2.b r102 = null;
        if (r112.f163293i == null) goto L9;
        r112.f163293i = null;
    L9:
        if (xz2.a.f565506a.contains(r100) == false) goto L11;
        r112.f163290f = null;
        r112.f163293i = null;
        r111.onEventTerminated(HybridEvent.TerminateType.BLOCK_LIST);
        return;
    L11:
        Long r103 = r112.f163296l.get(r100);
        if (r103 != null) goto L14;
    L33:
        NavigationDataManager r104 = new NavigationDataManager(r112, r100);
        r112.f163290f = r104;
        r104.f163275q = System.currentTimeMillis();
        Unit r105 = Unit.INSTANCE;
    L34:
        NavigationDataManager r106 = r112.f163293i;
        if (r106 != null) goto L37;
    L48:
        NavigationDataManager r107 = r112.f163290f;
        if (r107 == null) goto L67;
        Intrinsics.checkNotNullParameter(r111, "event");
        if (Intrinsics.areEqual(r107.f163260b, "about:blank") == true) goto L67;
        WebView r108 = r107.f163259a.d();
        if (r108 == null) goto L56;
        jz2.a r109 = sz2.a.g(r108);
    L57:
        r107.f163266h = r109;
        WebView r113 = r107.f163259a.d();
        if (r113 == null) goto L60;
        r102 = sz2.a.h(r113);
    L60:
        r107.f163267i = r102;
        r107.i();
        r111.h(r107.f163265g);
        wz2.b r114 = r107.f163279u;
        r114.getClass();
        r114.f561925i = System.currentTimeMillis();
        boolean r115 = r107.f163273o;
        wz2.b r116 = r107.f163279u;
        if (r116.f561921e != 0) goto L63;
        r116.f561921e = System.currentTimeMillis();
    L63:
        r116.f561929m = r115;
        r107.j();
        JSONObject r117 = new JSONObject();
        com.bytedance.android.monitorV2.util.l.o(r117, "invoke_ts", System.currentTimeMillis());
        r107.h(r111, r117);
        nz2.b.a("NavigationDataManager", "handlePv");
        Lazy<yz2.a> r118 = NavigationDataManager.C;
        yz2.a r119 = NavigationDataManager.a.a();
        if (r119 == null) goto L66;
        r119.a();
    L66:
        r107.f163268j.a(1);
        nz2.b.a("NavigationDataManager", "handlePageStart: url : " + r107.f163260b);
        goto L67
    L56:
        r109 = null;
    L67:
        r112.f163293i = r112.f163290f;
        r112.f163300p = false;
        r112.f163302r = true;
        return;
    L37:
        if (TextUtils.equals(r100, r106.f163260b) == false) goto L48;
        if (r106.f163265g.getClickStartTime() == r.a()) goto L41;
        boolean r120 = true;
    L42:
        if (r120 == true) goto L48;
        NavigationDataManager r121 = r112.f163290f;
        if (r121 == null) goto L47;
        r121.f163264f = false;
    L47:
        HashMap r122 = new HashMap();
        r122.put("repeat_page_start_url", r100);
        Map<String, Map<String, String>> r123 = InternalWatcher.f162982a;
        InternalWatcher.a(null, "repeat_page_start", r122, null);
        return;
    L41:
        r120 = false;
        goto L42
    L14:
        if (r112.f163290f != null) goto L17;
        r112.f163290f = new NavigationDataManager(r112, r100);
    L17:
        if (r112.f163300p == true) goto L19;
        r112.f163290f = new NavigationDataManager(r112, r100);
    L19:
        NavigationDataManager r124 = r112.f163290f;
        if (r124 == null) goto L32;
        String r125 = r124.f163260b;
        if (r125 != null) goto L24;
    L27:
        boolean r126 = true;
    L28:
        if (r126 == false) goto L30;
        r124.f163260b = r100;
        r124.f163265g.url = r100;
    L30:
        r124.f163273o = true;
        r124.f163275q = r103.longValue();
        goto L32
    L24:
        if (r125.length() == 0) goto L27;
        r126 = false;
    L32:
        if (r112.f163296l.remove(r100) != null) goto L34;
        goto L33
    }

    public final void n(WebView r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "webView");
        WebViewDataManager r112 = f(r110);
        WebView r100 = r112.d();
        if (r100 != null) goto L5;
    L7:
        NavigationDataManager r113 = r112.f163290f;
        if (r113 == null) goto L73;
        WebView r101 = r113.f163259a.d();
        if (r101 != null) goto L12;
    L65:
        wz2.b r114 = r113.f163279u;
        if (r111 == 100) goto L68;
        r114.getClass();
        return;
    L68:
        if (r114.f561923g != 0) goto L74;
        r114.f561923g = System.currentTimeMillis();
        return;
    L74:
        return;
    L12:
        if (r111 < r113.f163278t) goto L65;
        if (r101.getSettings().getJavaScriptEnabled() == true) goto L72;
        r101.getSettings().setJavaScriptEnabled(true);
    L72:
        nz2.b.f("NavigationDataManager", "try inject JsScript, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        String r115 = r101.getUrl();     // Catch: Exception -> L63
        if (r115 != null) goto L22;
        nz2.b.f("NavigationDataManager", "try inject JsScript, but url is null, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        goto L65
    L22:
        if (Intrinsics.areEqual(r115, "about:blank") == false) goto L25;
        nz2.b.f("NavigationDataManager", "try inject JsScript, but url is blank url, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        goto L65
    L25:
        if (r113.f163264f == false) goto L27;
        nz2.b.f("NavigationDataManager", "try inject JsScript, but this webView is injected, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        goto L65
    L27:
        c r102 = r113.f163259a.c();     // Catch: Exception -> L63
        if (r102 != null) goto L30;
    L32:
        Switches r103 = Switches.webInject;     // Catch: Exception -> L63
        if (r103.isEnabled() == true) goto L35;
    L41:
        com.bytedance.android.monitorV2.hybridSetting.h r104 = com.bytedance.android.monitorV2.g.e().d();     // Catch: Exception -> L63
        if (r104 == null) goto L51;
        HybridSettingInitConfig r105 = r104.getInitConfig();     // Catch: Exception -> L63
        if (r105 == null) goto L51;
        HybridSettingInitConfig.IThirdConfig r106 = r105.f163100l;     // Catch: Exception -> L63
        if (r106 == null) goto L51;
        if (r106.isThirdPartyUrl(r101.getUrl()) == true) goto L65;
    L51:
        if (TextUtils.isEmpty(r115) == true) goto L65;
        if (r113.f163264f == true) goto L65;
        c r107 = r113.f163259a.c();     // Catch: Exception -> L63
        if (r107 != null) goto L57;
        String r108 = "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    L58:
        if (r107 != null) goto L60;
        String r109 = "";
    L61:
        r101.evaluateJavascript(zz2.b.a(r101.getContext(), r109, r108, r103.isEnabled()), null);     // Catch: Exception -> L63
        long r116 = System.currentTimeMillis();     // Catch: Exception -> L63
        r113.f163264f = true;     // Catch: Exception -> L63
        r113.f163279u.f561924h = r116;     // Catch: Exception -> L63
        r113.j();     // Catch: Exception -> L63
        nz2.b.f("NavigationDataManager", "injected JsScript, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        Map<String, Map<String, String>> r117 = InternalWatcher.f162982a;     // Catch: Exception -> L63
        InternalWatcher.b(r113.f163265g.navigationId, "jssdk_load", null, null, 12);     // Catch: Exception -> L63
        goto L65
    L60:
        r109 = r107.f163348m;     // Catch: Exception -> L63
        goto L61
    L57:
        r108 = r107.f163347l;     // Catch: Exception -> L63
        goto L58
    L35:
        if (Switches.webDomainWhiteList.isEnabled() == false) goto L41;
        if (hz2.a.f487671c == true) goto L41;
        if (r113.e(r115) == true) goto L41;
        nz2.b.f("NavigationDataManager", "try inject JsScript, but this url not in white list, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
        goto L65
    L30:
        if (r102.f163340e == true) goto L32;
        nz2.b.f("NavigationDataManager", "try inject JsScript, but webViewDataManager.config.mIsNeedInjectBrowser disable, navigation_id: " + r113.f163277s + " url: " + r101.getUrl());     // Catch: Exception -> L63
    L63:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
        goto L65
    L73:
        return;
    L5:
        if (r100.getSettings().getJavaScriptEnabled() == true) goto L7;
        r100.getSettings().setJavaScriptEnabled(true);
        goto L7
    }
}
