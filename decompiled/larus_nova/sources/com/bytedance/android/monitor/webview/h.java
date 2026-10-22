package com.bytedance.android.monitor.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements cz2.c, az2.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h f162933g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h f162934h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, String> f162935i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, com.bytedance.android.monitor.webview.b> f162936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, com.bytedance.android.monitor.webview.b> f162937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f162938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f162939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f162940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f162941f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f162942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f162943b;

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f162943b;     // Catch: Throwable -> L18 Exception -> L24
            WebView r101 = this.f162942a;     // Catch: Throwable -> L18 Exception -> L24
            com.bytedance.android.monitor.webview.b r102 = r100.k(r101);     // Catch: Throwable -> L18 Exception -> L24
            if (r102 != null) goto L6;
            return;
        L6:
            if (r100.q(r101) == true) goto L9;
            return;
        L9:
            if (h.r(r102.f162904l) == true) goto L12;
            return;
        L12:
            if (r100.s(r101) == true) goto L29;
            String r103 = String.format(" javascript: (function () {\n    var target = {}\n    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n    var performacess = SlardarHybrid('getLatestPerformance');\n    var resourcess = SlardarHybrid('getLatestResource');\n    target.performance = performacess;\n    target.resource = resourcess;\n    target.needReport = %s;\n    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n })()", new Object[]{"true"});     // Catch: Throwable -> L18 Exception -> L24
            if (r101 == null) goto L30;
            r101.evaluateJavascript(r103, null);     // Catch: Throwable -> L18 Exception -> L24
            goto L33
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L18:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L32;
            throw th;
        L32:
            return;
        }

        public a(h r100, WebView r101) {
            this.f162943b = r100;
            this.f162942a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WebView f162944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f162945b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f162945b.x(this.f162944a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r100, WebView r101) {
            this.f162945b = r100;
            this.f162944a = r101;
        }
    }

    public static class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            if ((r100 instanceof WebView) == false) goto L17;
            WebView r101 = (WebView) r100;
            h r102 = h.f162934h;
            r102.getClass();
            com.bytedance.android.monitor.webview.b r103 = r102.k(r101);     // Catch: Exception -> L13
            if (r103 == null) goto L18;
            com.bytedance.android.monitor.webview.c r104 = r103.f162894b;     // Catch: Exception -> L13
            if (r104 == null) goto L19;
            r104.b(r101);     // Catch: Exception -> L13
            return;
        L19:
            return;
        L18:
            return;
        L13:
            bz2.c.a();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            if ((r100 instanceof WebView) == false) goto L29;
            WebView r101 = (WebView) r100;
            h r102 = h.f162934h;
            r102.getClass();
            com.bytedance.android.monitor.webview.b r103 = r102.k(r101);     // Catch: Exception -> L13
            if (r103 == null) goto L14;
            com.bytedance.android.monitor.webview.c r104 = r103.f162894b;     // Catch: Exception -> L13
            if (r104 == null) goto L14;
            r104.a(r101);     // Catch: Exception -> L13
        L14:
            h r105 = h.f162934h;
            r105.getClass();
            com.bytedance.android.monitor.webview.b r106 = r105.k(r101);     // Catch: Exception -> L20
            if (r106 == null) goto L21;
            if (r106.f162906n == false) goto L21;
            boolean r107 = true;
        L22:
            if (r107 == false) goto L30;
            h.f162933g.u(r101);
            return;
        L30:
            return;
        L21:
            r107 = false;
        L20:
            bz2.c.a();
        L13:
            bz2.c.a();
            goto L14
        }
    }

    @Override // az2.c
    public final void a() {
    }

    static {
        f162935i = new HashMap();
        h r100 = new h();
        f162933g = r100;
        f162934h = r100;
    }

    public final boolean p() {
        if (this.f162940e == false) goto L5;
        m().getClass();
        return true;
    L5:
        return false;
    }

    public h() {
        this.f162936a = new HashMap();
        this.f162937b = new HashMap();
        this.f162938c = new HashSet();
        this.f162939d = new c();
        this.f162940e = true;
        this.f162941f = new Handler(Looper.getMainLooper());
        az2.e.f16801b.put("web", this);
        Class r100 = d("com.bytedance.lynx.webview.TTWebSdk");     // Catch: Exception -> L5
        Class<?> r101 = d("com.bytedance.lynx.webview.monitors.IWebViewDelegate");     // Catch: Exception -> L5
        Class<?> r102 = d("com.bytedance.lynx.webview.monitors.IWebViewClientDelegate");     // Catch: Exception -> L5
        Class<?> r103 = d("com.bytedance.lynx.webview.monitors.IWebChromeClientDelegate");     // Catch: Exception -> L5
        Method r104 = r100.getDeclaredMethod("registerGlobalWebViewDelegate", new Class[]{r101});     // Catch: Exception -> L5
        k r105 = new k();     // Catch: Exception -> L5
        r105.f162950a = k.a("com.bytedance.lynx.webview.monitors.IWebViewDelegate");     // Catch: Exception -> L5
        r105.f162951b = k.a("com.bytedance.lynx.webview.monitors.WebViewDelegate").newInstance();     // Catch: Exception -> L5
        r104.invoke(null, new Object[]{Proxy.newProxyInstance(r105.f162950a.getClassLoader(), new Class[]{r105.f162950a}, r105)});     // Catch: Exception -> L5
        Method r106 = r100.getDeclaredMethod("registerGlobalWebViewClientDelegate", new Class[]{r102});     // Catch: Exception -> L5
        j r107 = new j();     // Catch: Exception -> L5
        r107.f162948a = j.a("com.bytedance.lynx.webview.monitors.IWebViewClientDelegate");     // Catch: Exception -> L5
        r107.f162949b = j.a("com.bytedance.lynx.webview.monitors.WebViewClientDelegate").newInstance();     // Catch: Exception -> L5
        r106.invoke(null, new Object[]{Proxy.newProxyInstance(r107.f162948a.getClassLoader(), new Class[]{r107.f162948a}, r107)});     // Catch: Exception -> L5
        Method r108 = r100.getDeclaredMethod("registerGlobalWebChromeClientDelegate", new Class[]{r103});     // Catch: Exception -> L5
        i r109 = new i();     // Catch: Exception -> L5
        r109.f162946a = i.a("com.bytedance.lynx.webview.monitors.IWebChromeClientDelegate");     // Catch: Exception -> L5
        r109.f162947b = i.a("com.bytedance.lynx.webview.monitors.WebChromeClientDelegate").newInstance();     // Catch: Exception -> L5
        r108.invoke(null, new Object[]{Proxy.newProxyInstance(r109.f162946a.getClassLoader(), new Class[]{r109.f162946a}, r109)});     // Catch: Exception -> L5
        return;
    L5:
        bz2.c.a();
    }

    public static zy2.d m() {
        zy2.a r100 = (zy2.a) HybridMonitor.getInstance().getSettingManager();
        if (r100.f573916a != null) goto L6;
        r100.f573916a = new zy2.d();
    L6:
        return r100.f573916a;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d(String r100) throws ClassNotFoundException {
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

    public static com.bytedance.android.monitor.webview.b g(com.bytedance.android.monitor.webview.b r100) {
        com.bytedance.android.monitor.webview.b r101 = new com.bytedance.android.monitor.webview.b();
        r100.f162911s = r100.f162911s;
        com.bytedance.android.monitor.webview.c r102 = r100.f162894b;
        if (r102 != null) goto L6;
        r102 = d.x();
    L6:
        r101.f162894b = r102;
        String r103 = r100.f162897e;
        if (r103 != null) goto L10;
        r103 = "WebViewMonitor";
    L10:
        r101.f162897e = r103;
        r101.f162893a = r100.f162893a;
        r101.f162899g = r100.f162899g;
        r101.f162898f = r100.f162898f;
        r101.f162906n = r100.f162906n;
        r101.f162907o = r100.f162907o;
        r101.f162905m = r100.f162905m;
        r101.f162908p = r100.f162908p;
        r101.f162896d = r100.f162896d;
        r101.f162895c = r100.f162895c;
        r101.f162911s = r100.f162911s;
        if (TextUtils.isEmpty(r100.f162909q) == false) goto L13;
        String r104 = "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    L14:
        r101.f162909q = r104;
        r101.f162910r = r100.f162910r;
        r101.f162901i = r100.f162901i;
        r101.f162903k = r100.f162903k;
        r101.f162902j = r100.f162902j;
        r101.f162904l = r100.f162904l;
        if (TextUtils.isEmpty(r100.f162900h) == true) goto L60;
        JSONObject r105 = bz2.e.j(r100.f162900h);
        if (bz2.e.d(r105, "webview_classes") != null) goto L19;
        String[] r106 = r101.f162895c;
    L31:
        r101.f162895c = r106;
        if (bz2.e.d(r105, "webview_is_need_monitor") != null) goto L34;
        boolean r107 = r101.f162905m;
    L35:
        r101.f162905m = r107;
        if (TextUtils.isEmpty(r100.f162900h) == false) goto L38;
        String r108 = r101.f162909q;
    L39:
        r101.f162909q = r108;
        if (bz2.e.d(r105, "webview_is_open_blankdetect") != null) goto L42;
        boolean r109 = r101.f162901i;
    L43:
        r101.f162901i = r109;
        if (bz2.e.d(r105, "webview_is_open_jsb") != null) goto L46;
        boolean r110 = r101.f162902j;
    L47:
        r101.f162902j = r110;
        if (bz2.e.d(r105, "webview_is_open_fetch") != null) goto L50;
        boolean r111 = r101.f162903k;
    L51:
        r101.f162903k = r111;
        if (bz2.e.d(r105, "webview_is_inject_js") != null) goto L54;
        boolean r112 = r101.f162908p;
    L55:
        r101.f162908p = r112;
        if (bz2.e.d(r105, "webview_is_update_page_data") != null) goto L58;
        boolean r113 = r101.f162904l;
    L59:
        r101.f162904l = r113;
        goto L60
    L58:
        r113 = bz2.e.b(r105, "webview_is_update_page_data", Boolean.FALSE);
        goto L59
    L54:
        r112 = bz2.e.b(r105, "webview_is_inject_js", Boolean.FALSE);
        goto L55
    L50:
        r111 = bz2.e.b(r105, "webview_is_open_fetch", Boolean.FALSE);
        goto L51
    L46:
        r110 = bz2.e.b(r105, "webview_is_open_jsb", Boolean.FALSE);
        goto L47
    L42:
        r109 = bz2.e.b(r105, "webview_is_open_blankdetect", Boolean.FALSE);
        goto L43
    L38:
        JSONObject r114 = bz2.e.j(r100.f162900h);
        JSONObject r115 = bz2.e.c(r114, "apmReportConfig");
        JSONObject r116 = bz2.e.c(r114, "performanceReportConfig");
        JSONObject r117 = bz2.e.c(r114, "errorMsgReportConfig");
        JSONObject r118 = bz2.e.c(r114, "resourceTimingReportConfig");
        JSONObject r119 = bz2.e.c(r114, "commonReportConfig");
        JSONObject r120 = new JSONObject();
        JSONObject r121 = new JSONObject();
        bz2.e.h(r120, "monitors", r121);
        bz2.e.h(r120, "sendCommonParams", r119);
        f.a(r121, r115);
        f.a(r121, r116);
        f.a(r121, r117);
        f.a(r121, r118);
        r108 = "SlardarHybrid('config', " + r120.toString() + ")";
        goto L39
    L34:
        r107 = bz2.e.b(bz2.e.j(r100.f162900h), "webview_is_need_monitor", Boolean.FALSE);
        goto L35
    L19:
        String r122 = r100.f162900h;
        int r123 = 0;
        String[] r124 = new String[0];
        if (TextUtils.isEmpty(r122) == true) goto L24;
        JSONArray r125 = bz2.e.j(r122).optJSONArray("webview_classes");
        if (r125 == null) goto L24;
        String[] r126 = new String[r125.length()];
    L27:
        if (r123 >= r125.length()) goto L30;
        r126[r123] = JSONArrayProtectorUtils.getString(r125, r123);     // Catch: JSONException -> L61
    L29:
        r123 = r123 + 1;
        goto L27
    L30:
        r106 = r126;
    L24:
        r106 = r124;
    L60:
        return r101;
    L13:
        r104 = r100.f162909q;
        goto L14
    }

    public static String i(WebView r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.hashCode() + "";
    }

    public static boolean r(boolean r100) {
        if (HybridMonitor.isDebuggable() == true) goto L7;
        if (r100 == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // cz2.c
    public final boolean c(WebView r100) {
        return ((Boolean) d("com.bytedance.lynx.webview.TTWebSdk").getDeclaredMethod("isTTWebView", new Class[]{WebView.class}).invoke(null, new Object[]{r100})).booleanValue();
    L5:
        bz2.c.a();
        return false;
    }

    public final void e(com.bytedance.android.monitor.webview.b r100) {
        com.bytedance.android.monitor.webview.b r101 = g(r100);     // Catch: Exception -> L18
        String[] r102 = r101.f162896d;     // Catch: Exception -> L18
        int r103 = 0;
        if (r102 != null) goto L5;
    L9:
        String[] r104 = r101.f162895c;     // Catch: Exception -> L18
        if (r104 != null) goto L12;
    L16:
        ((HashSet) this.f162938c).clear();     // Catch: Exception -> L18
        return;
    L12:
        if (r104.length == 0) goto L16;
        int r105 = r104.length;     // Catch: Exception -> L18
    L14:
        if (r103 >= r105) goto L16;
        String r106 = r104[r103];     // Catch: Exception -> L18
        ((HashMap) this.f162936a).put(r106, r101);     // Catch: Exception -> L18
        r103 = r103 + 1;     // Catch: Exception -> L18
        goto L14
    L5:
        if (r102.length == 0) goto L9;
        int r107 = r102.length;     // Catch: Exception -> L18
        int r108 = 0;
    L7:
        if (r108 >= r107) goto L9;
        String r109 = r102[r108];     // Catch: Exception -> L18
        ((HashMap) this.f162937b).put(r109, r101);     // Catch: Exception -> L18
        r108 = r108 + 1;     // Catch: Exception -> L18
    L18:
        bz2.c.a();
    }

    public final boolean f(WebView r100) {
        com.bytedance.android.monitor.webview.b r101 = k(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.monitor.webview.c r102 = r101.f162894b;
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.m(r100);
    }

    public final com.bytedance.android.monitor.webview.b k(WebView r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.monitor.webview.b r101 = (com.bytedance.android.monitor.webview.b) ((HashMap) this.f162937b).get(i(r100));
        if (r101 == null) goto L8;
        return r101;
    L8:
        String r102 = r100.getClass().getName();
        com.bytedance.android.monitor.webview.b r103 = (com.bytedance.android.monitor.webview.b) ((HashMap) this.f162936a).get(r102);
        if (r103 == null) goto L12;
        return r103;
    L12:
        if (((HashSet) this.f162938c).contains(r102) == false) goto L14;
        return null;
    L14:
        Iterator r104 = new HashSet(((HashMap) this.f162936a).keySet()).iterator();
    L16:
        if (r104.hasNext() == false) goto L34;
        String r105 = (String) r104.next();
        Class<?> r106 = d(r102);     // Catch: Throwable -> L20
    L36:
        Class r107 = d(r105);     // Catch: Throwable -> L23
    L24:
        if (r106 == null) goto L28;
        if (r107 == null) goto L28;
        boolean r108 = r107.isAssignableFrom(r106);
    L29:
        if (r108 == false) goto L16;
        com.bytedance.android.monitor.webview.b r109 = (com.bytedance.android.monitor.webview.b) ((HashMap) this.f162936a).get(r105);
        if (r109 == null) goto L16;
        ((HashMap) this.f162936a).put(r102, r109);
        return r109;
    L28:
        r108 = false;
    L23:
        bz2.c.a();
        r107 = null;
    L20:
        bz2.c.a();
        r106 = null;
        goto L36
    L34:
        ((HashSet) this.f162938c).add(r102);
        return null;
    }

    public final cz2.b l(WebView r100) {
    L16:
        bz2.c.a();
    L17:
        return null;
    L4:
        if (p() == true) goto L7;
        return null;
    L7:
        if (q(r100) == false) goto L17;
        com.bytedance.android.monitor.webview.b r101 = k(r100);     // Catch: Exception -> L16
        if (r101 != null) goto L11;
        return null;
    L11:
        com.bytedance.android.monitor.webview.c r102 = r101.f162894b;     // Catch: Exception -> L16
        if (r102 != null) goto L14;
        return null;
    L14:
        return r102.n(r100);
    }

    public final boolean q(WebView r100) {
        com.bytedance.android.monitor.webview.b r101 = k(r100);     // Catch: Exception -> L8
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.f162905m;
    L8:
        bz2.c.a();
        return false;
    }

    public final boolean s(WebView r100) {
        com.bytedance.android.monitor.webview.b r101 = k(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.monitor.webview.c r102 = r101.f162894b;
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.l(r100);
    }

    public final void u(WebView r100) {
        if (r100 == null) goto L4;
        b r101 = new b(this, r100);     // Catch: Exception -> L10
        if (s(r100) == false) goto L8;
        this.f162941f.post(r101);     // Catch: Exception -> L10
    L12:
        return;
    L8:
        this.f162941f.post(new a(this, r100));     // Catch: Exception -> L10
        this.f162941f.postDelayed(r101, 500);     // Catch: Exception -> L10
        goto L12
    L4:
        x(null);     // Catch: Exception -> L10
    L10:
        bz2.c.a();
    }

    public final void x(WebView r100) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            if (r3 != 0) goto L3
            goto L1e
        L3:
            boolean r0 = r2.q(r3)     // Catch: java.lang.Exception -> L1b
            if (r0 != 0) goto La
            goto L1e
        La:
            com.bytedance.android.monitor.webview.b r0 = r2.k(r3)     // Catch: java.lang.Exception -> L1b
            if (r0 != 0) goto L11
            goto L1e
        L11:
            com.bytedance.android.monitor.webview.c r0 = r0.f162894b     // Catch: java.lang.Exception -> L1b
            if (r0 != 0) goto L16
            goto L1e
        L16:
            boolean r0 = r0.e(r3)     // Catch: java.lang.Exception -> L1b
            goto L1f
        L1b:
            bz2.c.a()     // Catch: java.lang.Exception -> Lb7
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto Lba
            com.bytedance.android.monitor.webview.b r0 = r2.k(r3)     // Catch: java.lang.Exception -> L31
            if (r0 != 0) goto L28
            goto L34
        L28:
            com.bytedance.android.monitor.webview.c r0 = r0.f162894b     // Catch: java.lang.Exception -> L31
            if (r0 != 0) goto L2d
            goto L34
        L2d:
            r0.o(r3)     // Catch: java.lang.Exception -> L31
            goto L34
        L31:
            bz2.c.a()     // Catch: java.lang.Exception -> Lb7
        L34:
            r2.k(r3)     // Catch: java.lang.Exception -> L38
            goto L3b
        L38:
            bz2.c.a()     // Catch: java.lang.Exception -> Lb7
        L3b:
            boolean r0 = r2.s(r3)     // Catch: java.lang.Exception -> L88
            if (r0 == 0) goto L42
            goto L8b
        L42:
            if (r3 == 0) goto L8b
            java.lang.String r0 = r3.getUrl()     // Catch: java.lang.Exception -> L88
            if (r0 == 0) goto L8b
            java.lang.String r0 = r3.getUrl()     // Catch: java.lang.Exception -> L88
            java.lang.String r1 = "about:blank"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L88
            if (r0 == 0) goto L57
            goto L8b
        L57:
            boolean r0 = r2.q(r3)     // Catch: java.lang.Exception -> L88
            if (r0 != 0) goto L5e
            goto L8b
        L5e:
            com.bytedance.android.monitor.webview.b r0 = r2.k(r3)     // Catch: java.lang.Exception -> L88
            if (r0 != 0) goto L65
            goto L8b
        L65:
            boolean r1 = r0.f162901i     // Catch: java.lang.Exception -> L88
            boolean r1 = r(r1)     // Catch: java.lang.Exception -> L88
            if (r1 != 0) goto L6e
            goto L8b
        L6e:
            zy2.d r1 = m()     // Catch: java.lang.Exception -> L88
            r1.getClass()     // Catch: java.lang.Exception -> L88
            com.bytedance.android.monitor.webview.c r0 = r0.f162894b     // Catch: java.lang.Exception -> L88
            if (r0 != 0) goto L7a
            goto L8b
        L7a:
            boolean r1 = r2.s(r3)     // Catch: java.lang.Exception -> L88
            if (r1 != 0) goto L8b
            mq7.a$a r1 = mq7.a.a(r3)     // Catch: java.lang.Exception -> L88
            r0.h(r3, r1)     // Catch: java.lang.Exception -> L88
            goto L8b
        L88:
            bz2.c.a()     // Catch: java.lang.Exception -> Lb7
        L8b:
            java.lang.String r0 = "loc_after_detach"
            r2.w(r3, r0)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r0 = "ttlive_web_view_last_url_tag"
            t(r3, r0)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r0 = "ttlive_web_view_auto_report_tag"
            t(r3, r0)     // Catch: java.lang.Exception -> Lb7
            java.lang.String r0 = "ttlive_web_view_tag"
            t(r3, r0)     // Catch: java.lang.Exception -> Lb7
            java.util.Map<java.lang.String, com.bytedance.android.monitor.webview.b> r0 = r2.f162937b     // Catch: java.lang.Exception -> Lb7
            java.lang.String r1 = i(r3)     // Catch: java.lang.Exception -> Lb7
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch: java.lang.Exception -> Lb7
            r0.remove(r1)     // Catch: java.lang.Exception -> Lb7
            com.bytedance.android.monitor.webview.h$c r0 = r2.f162939d     // Catch: java.lang.Exception -> Lb7
            if (r0 == 0) goto Lba
            if (r3 == 0) goto Lba
            r3.removeOnAttachStateChangeListener(r0)     // Catch: java.lang.Exception -> Lb7
            goto Lba
        Lb7:
            bz2.c.a()
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.monitor.webview.h.x(android.webkit.WebView):void");
    }

    public static void t(WebView r100, String r101) {
        ((HashMap) f162935i).remove(r101 + i(r100));
    }

    public final void j(WebView r100, py2.d r101) {
        if (r100 == null) goto L26;
        cz2.b r102 = l(r100);
        if (r102 == null) goto L26;
        String r103 = "";
        if (TextUtils.isEmpty(r101.f530982b) == false) goto L13;
        com.bytedance.android.monitor.webview.b r104 = f162934h.k(((e) r102).f162931a);
        if (r104 == null) goto L10;
        String r105 = r104.f162911s;
    L11:
        r101.f530982b = r105;
        goto L13
    L10:
        r105 = "";
    L13:
        if (TextUtils.isEmpty(r101.f530981a) == false) goto L16;
        r101.f530981a = ((e) r102).a();
    L16:
        if (TextUtils.isEmpty(r101.f530989i) == false) goto L21;
        com.bytedance.android.monitor.webview.b r106 = f162934h.k(((e) r102).f162931a);
        if (r106 == null) goto L20;
        r103 = r106.f162893a;
    L20:
        r101.f530989i = r103;
    L21:
        com.bytedance.android.monitor.webview.b r107 = k(r100);
        if (r107 == null) goto L26;
        com.bytedance.android.monitor.webview.a r108 = r107.f162899g;
        if (r108 == null) goto L26;
        r101.f530991k = r108;
    L26:
        bz2.e.f(r101.f530988h, "platform", 0);
        HybridMonitor.getInstance().customReport(r101);
    }

    public final void n(WebView r100, py2.f r101) {
    L22:
        bz2.c.a();
        return;
    L3:
        if (p() == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        return;
    L8:
        if (q(r100) == true) goto L10;
        return;
    L10:
        if (f(r100) == false) goto L28;
        com.bytedance.android.monitor.webview.b r102 = k(r100);     // Catch: Exception -> L22
        if (r102 != null) goto L14;
        return;
    L14:
        if (r(r102.f162903k) == false) goto L26;
        m().getClass();     // Catch: Exception -> L22
        com.bytedance.android.monitor.webview.c r103 = r102.f162894b;     // Catch: Exception -> L22
        if (r103 != null) goto L19;
        return;
    L19:
        r103.q(r100, r101);     // Catch: Exception -> L22
        return;
    L26:
        return;
    }

    public final void o(WebView r100, py2.h r101) {
    L20:
        bz2.c.a();
        return;
    L3:
        if (p() == true) goto L6;
        return;
    L6:
        if (q(r100) == true) goto L8;
        return;
    L8:
        if (f(r100) == false) goto L26;
        com.bytedance.android.monitor.webview.b r102 = k(r100);     // Catch: Exception -> L20
        if (r102 != null) goto L12;
        return;
    L12:
        if (r(r102.f162902j) == false) goto L24;
        m().getClass();     // Catch: Exception -> L20
        com.bytedance.android.monitor.webview.c r103 = r102.f162894b;     // Catch: Exception -> L20
        if (r103 != null) goto L17;
        return;
    L17:
        r103.p(r100, r101);     // Catch: Exception -> L20
        return;
    L24:
        return;
    }

    public final void w(WebView r100, String r101) {
        com.bytedance.android.monitor.webview.b r102 = k(r100);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f162907o != null) goto L8;
        return;
    L8:
        com.bytedance.android.monitor.webview.c r103 = r102.f162894b;
        if (r103 != null) goto L12;
        return;
    L12:
        if ("loc_force".equals(r101) == false) goto L14;
    L17:
        r103.j(r100, r101);
        return;
    L14:
        if ("loc_after_detach".equals(r101) == true) goto L17;
        if (r102.f162907o.equals(r101) == true) goto L17;
    }

    @Override // az2.c
    public final void b(View r100, py2.a r101, az2.b r102) {
    L19:
        bz2.c.a();
        return;
    L3:
        if (p() == true) goto L5;
        return;
    L5:
        com.bytedance.android.monitor.webview.c r103 = null;
        if (r100 != null) goto L8;
    L14:
        WebView r104 = null;
    L15:
        if (r103 == null) goto L17;
        r103.i(r104, r101, r102);     // Catch: Exception -> L19
        return;
    L17:
        d.x().i(r104, r101, r102);     // Catch: Exception -> L19
        return;
    L8:
        if ((r100 instanceof WebView) == false) goto L14;
        r104 = (WebView) r100;     // Catch: Exception -> L19
        if (q(r104) == false) goto L15;
        if (f(r104) == false) goto L15;
        r103 = k(r104).f162894b;     // Catch: Exception -> L19
        goto L15
    }

    public final void v(WebView r100, String r101, String r102) {
        com.bytedance.android.monitor.webview.b r103 = k(r100);     // Catch: Exception -> L10
        if (r103 != null) goto L5;
        return;
    L5:
        com.bytedance.android.monitor.webview.c r104 = r103.f162894b;     // Catch: Exception -> L10
        if (r104 != null) goto L8;
        return;
    L8:
        r104.r(r100, r101, r102);     // Catch: Exception -> L10
        return;
    L10:
        bz2.c.a();
    }

    public final void h(WebView r100, String r101, String r102, String r103) {
        com.bytedance.android.monitor.webview.b r104 = k(r100);     // Catch: Exception -> L10
        if (r104 != null) goto L5;
        return;
    L5:
        com.bytedance.android.monitor.webview.c r105 = r104.f162894b;     // Catch: Exception -> L10
        if (r105 != null) goto L8;
        return;
    L8:
        r105.d(r100, r101, r102, r103);     // Catch: Exception -> L10
        w(r100, "loc_after_tti");     // Catch: Exception -> L10
        return;
    L10:
        bz2.c.a();
    }
}
