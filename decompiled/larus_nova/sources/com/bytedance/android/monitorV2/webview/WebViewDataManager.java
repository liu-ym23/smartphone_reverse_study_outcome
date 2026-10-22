package com.bytedance.android.monitorV2.webview;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.TTNetInit;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class WebViewDataManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<WebView> f163285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f163286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f163288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f163289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public NavigationDataManager f163290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebViewLifeState f163291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f163292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NavigationDataManager f163293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap<WebViewLifeState, k> f163294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f163295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HashMap<String, Long> f163296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f163297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<String, Integer> f163298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f163299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f163300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f163301q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f163302r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f163303s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f163304t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f163305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f163306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap<String, Boolean> f163307w;

    public final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewDataManager f163308a;

        public a(WebViewDataManager r100) {
            this.f163308a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            nz2.b.a(this.f163308a.f163287c, "onViewAttachedToWindow() called with: v = " + r100);
            if ((r100 instanceof WebView) == false) goto L6;
            WebViewDataManager r101 = this.f163308a;
            r101.getClass();
            r101.g(WebViewLifeState.ATTACHED);
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            nz2.b.a(this.f163308a.f163287c, "onViewDetachedFromWindow() called with: v = " + r100);
            if ((r100 instanceof WebView) == false) goto L23;
            WebViewDataManager r101 = this.f163308a;
            r101.getClass();
            r101.g(WebViewLifeState.DETACHED);
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            WebView r103 = r101.f163285a.get();     // Catch: Throwable -> L11
            if (r103 == null) goto L8;
            String r104 = r103.getUrl();     // Catch: Throwable -> L11
        L9:
            Object r105 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r104), "disable_final_detect_when_detached"), "1")));     // Catch: Throwable -> L11
        L13:
            Boolean r106 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r105) == false) goto L17;
            r105 = r106;
        L17:
            if (((Boolean) r105).booleanValue() == true) goto L24;
            r101.a(r101.f163302r);
            return;
        L24:
            return;
        L8:
            r104 = null;
        L11:
            th = move-exception;
            Result.Companion r107 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L13
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewDataManager f163309a;

        public b(WebViewDataManager r100) {
            this.f163309a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NavigationDataManager r100 = this.f163309a.f163290f;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.d();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final com.bytedance.android.monitorV2.settings.j b() {
        return (com.bytedance.android.monitorV2.settings.j) this.f163305u.getValue();
    }

    public final c c() {
        return (c) this.f163289e.getValue();
    }

    public final WebView d() {
        WebView r100 = this.f163285a.get();
        if (r100 != null) goto L5;
        nz2.b.b(this.f163287c, "get webView from weakRef: null");
    L5:
        return r100;
    }

    public final void e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L108
        int r101 = com.bytedance.android.monitorV2.event.a.f163018p;     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.event.a r102 = com.bytedance.android.monitorV2.event.a.C2492a.a("blank", null);     // Catch: Throwable -> L108
        kz2.a.C6634a r103 = kz2.a.f506727a;     // Catch: Throwable -> L108
        NavigationDataManager r104 = this.f163290f;     // Catch: Throwable -> L108
        if (r104 == null) goto L6;
        Map<String, Map<String, String>> r105 = InternalWatcher.f162982a;     // Catch: Throwable -> L108
        InternalWatcher.b(r104.f163265g.navigationId, "blank_check", null, null, 12);     // Catch: Throwable -> L108
    L6:
        WebViewLifeState r106 = this.f163291g;     // Catch: Throwable -> L108
        if (r106 == null) goto L9;
        int r107 = r106.ordinal();     // Catch: Throwable -> L108
    L10:
        boolean r108 = false;
        if (r107 < WebViewLifeState.DESTROYED.ordinal()) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L17;
        r102.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L108
        return;
    L17:
        WebView r110 = d();     // Catch: Throwable -> L108
        if (r110 != null) goto L22;
        r102.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L108
        return;
    L22:
        if (r110.getUrl() != null) goto L24;
    L106:
        r102.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L108
        return;
    L24:
        if (Intrinsics.areEqual(r110.getUrl(), "about:blank") == true) goto L106;
        HashMap<String, Boolean> r111 = this.f163307w;     // Catch: Throwable -> L108
        String r112 = r110.getUrl();     // Catch: Throwable -> L108
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L108
        Boolean r113 = r111.get(r112);     // Catch: Throwable -> L108
        Boolean r114 = Boolean.TRUE;     // Catch: Throwable -> L108
        if (Intrinsics.areEqual(r113, r114) == false) goto L30;
        r102.onEventTerminated(HybridEvent.TerminateType.EVENT_REPEATED);     // Catch: Throwable -> L108
        return;
    L30:
        HashMap<String, Boolean> r115 = this.f163307w;     // Catch: Throwable -> L108
        String r116 = r110.getUrl();     // Catch: Throwable -> L108
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L108
        r115.put(r116, r114);     // Catch: Throwable -> L108
        if (Switches.webBlank.isEnabled() == true) goto L34;
        r102.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);     // Catch: Throwable -> L108
        return;
    L34:
        NavigationDataManager r117 = this.f163290f;     // Catch: Throwable -> L108
        if (r117 == null) goto L54;
        String[] r118 = b().c();     // Catch: Throwable -> L108
        int r119 = r118.length;     // Catch: Throwable -> L108
        int r120 = 0;
    L37:
        if (r120 >= r119) goto L45;
        String r121 = r118[r120];     // Catch: Throwable -> L108
        String r122 = r117.f163260b;     // Catch: Throwable -> L108
        if (r122 != null) goto L42;
        r122 = "";
    L42:
        if (StringsKt.contains$default(r122, r121, false, 2, null) == true) goto L43;
        r120 = r120 + 1;     // Catch: Throwable -> L108
        goto L37
    L43:
        boolean r123 = true;
    L46:
        if (r123 == false) goto L50;
        r102.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L108
        return;
    L50:
        if ((System.currentTimeMillis() - r117.f163261c) >= b().b()) goto L54;
        r102.onEventTerminated(HybridEvent.TerminateType.INVALID_CASE);     // Catch: Throwable -> L108
        return;
    L45:
        r123 = false;
    L54:
        if (b().d() == false) goto L63;
        kz2.a.C6634a r124 = kz2.a.f506727a;     // Catch: Throwable -> L108
        if (b().a() != 1) goto L62;
        nz2.b.f(this.f163287c, "kernel detect is blank: " + this.f163301q);     // Catch: Throwable -> L108
        uz2.a r125 = new uz2.a();     // Catch: Throwable -> L108
        if (this.f163301q == false) goto L60;
        int r126 = 1;
    L61:
        r125.f552172a = r126;     // Catch: Throwable -> L108
    L64:
        JSONObject r127 = new JSONObject();     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.q(r127, "event_type", "blank");     // Catch: Throwable -> L108
        if (r125.f552172a != 1) goto L67;
        int r128 = 1;
    L68:
        com.bytedance.android.monitorV2.util.l.n(r127, "is_blank", r128);     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.n(r127, "detect_type", b().a());     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.o(r127, HiAnalyticsConstant.BI_KEY_COST_TIME, r125.f552175d);     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.o(r127, "collect_time", r125.f552174c);     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.o(r127, "calculate_time", r125.f552173b);     // Catch: Throwable -> L108
        if (r125.f552172a != 3) goto L71;
        com.bytedance.android.monitorV2.util.l.n(r127, "error_code", r125.f552176e);     // Catch: Throwable -> L108
        com.bytedance.android.monitorV2.util.l.q(r127, "error_msg", r125.f552177f);     // Catch: Throwable -> L108
    L71:
        c r129 = c();     // Catch: Throwable -> L108
        if (r129 == null) goto L76;
        tz2.a r130 = r129.f163345j;     // Catch: Throwable -> L108
        if (r130 == null) goto L76;
        r130.b(r110, r125.f552175d);     // Catch: Throwable -> L108
        r130.a(r110, r125.f552172a);     // Catch: Throwable -> L108
    L76:
        com.bytedance.android.monitorV2.util.l.o(r127, "detect_start_time", System.currentTimeMillis() - r125.f552175d);     // Catch: Throwable -> L108
        NavigationDataManager r131 = this.f163290f;     // Catch: Throwable -> L108
        if (r131 == null) goto L114;
        com.bytedance.android.monitorV2.util.l.o(r127, BdpAppEventConstant.PARAMS_PAGE_STAY_DURATION, System.currentTimeMillis() - r131.f163261c);     // Catch: Throwable -> L108
    L114:
        int r132 = TTNetInit.getNetworkQuality().httpRttMs;     // Catch: Throwable -> L86
        int r133 = TTNetInit.getNetworkQuality().transportRttMs;     // Catch: Throwable -> L86
        JSONObject r134 = new JSONObject();     // Catch: Throwable -> L86
        if (r132 == 0) goto L82;
        com.bytedance.android.monitorV2.util.l.n(r134, "http_rtt_ms", r132);     // Catch: Throwable -> L86
    L82:
        if (r133 == 0) goto L84;
        com.bytedance.android.monitorV2.util.l.n(r134, "transport_rtt_ms", r133);     // Catch: Throwable -> L86
    L84:
        Unit r135 = Unit.INSTANCE;     // Catch: Throwable -> L86
        com.bytedance.android.monitorV2.util.l.p(r127, "assist_info", r134);     // Catch: Throwable -> L86
    L87:
        NavigationDataManager r136 = this.f163290f;     // Catch: Throwable -> L108
        if (r136 == null) goto L90;
        com.bytedance.android.monitorV2.util.l.c(r127, r136.f163268j.toJsonObject());     // Catch: Throwable -> L108
    L90:
        NavigationDataManager r137 = this.f163290f;     // Catch: Throwable -> L108
        if (r137 == null) goto L93;
        r137.h(r102, r127);     // Catch: Throwable -> L108
    L93:
        NavigationDataManager r138 = this.f163290f;     // Catch: Throwable -> L108
        if (r138 == null) goto L102;
        LinkedHashMap r139 = new LinkedHashMap();     // Catch: Throwable -> L108
        int r140 = r125.f552172a;     // Catch: Throwable -> L108
        if (r140 == 1) goto L101;
        if (r140 == 2) goto L100;
        r139.put("error_error_msg", "code:" + r125.f552176e + ", msg:" + r125.f552177f);     // Catch: Throwable -> L108
        r139.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "web blank check fail");     // Catch: Throwable -> L108
        Map<String, Map<String, String>> r141 = InternalWatcher.f162982a;     // Catch: Throwable -> L108
        InternalWatcher.b(r138.f163265g.navigationId, "internal_error", r139, null, 8);     // Catch: Throwable -> L108
        goto L102
    L100:
        r139.put("result", "0");     // Catch: Throwable -> L108
        Map<String, Map<String, String>> r142 = InternalWatcher.f162982a;     // Catch: Throwable -> L108
        InternalWatcher.b(r138.f163265g.navigationId, "blank_result", r139, null, 8);     // Catch: Throwable -> L108
        goto L102
    L101:
        r139.put("result", "1");     // Catch: Throwable -> L108
        Map<String, Map<String, String>> r143 = InternalWatcher.f162982a;     // Catch: Throwable -> L108
        InternalWatcher.b(r138.f163265g.navigationId, "blank_result", r139, null, 8);     // Catch: Throwable -> L108
    L102:
        i(r110);     // Catch: Throwable -> L108
        String r144 = this.f163287c;     // Catch: Throwable -> L108
        StringBuilder r145 = new StringBuilder();     // Catch: Throwable -> L108
        r145.append("handleBlankDetect: session: ");     // Catch: Throwable -> L108
        r145.append(this.f163288d);     // Catch: Throwable -> L108
        r145.append(", webView url: ");     // Catch: Throwable -> L108
        r145.append(r110.getUrl());     // Catch: Throwable -> L108
        r145.append(", result: ");     // Catch: Throwable -> L108
        if (r125.f552172a != 1) goto L105;
        r108 = true;
    L105:
        r145.append(r108);     // Catch: Throwable -> L108
        nz2.b.a(r144, r145.toString());     // Catch: Throwable -> L108
        Object r146 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L108
    L110:
        Throwable r147 = Result.m9452exceptionOrNullimpl(r146);
        if (r147 == null) goto L119;
        com.bytedance.android.monitorV2.util.f.b(r147);
        return;
    L119:
        return;
    L86:
        nz2.b.f(this.f163287c, "CronetEngine is not created maybe");     // Catch: Throwable -> L108
        goto L87
    L67:
        r128 = 0;
        goto L68
    L60:
        r126 = 2;
        goto L61
    L62:
        nz2.b.f(this.f163287c, "final pixel detect");     // Catch: Throwable -> L108
        r125 = uz2.c.b(r110);     // Catch: Throwable -> L108
        goto L64
    L63:
        r125 = new uz2.a();     // Catch: Throwable -> L108
        mq7.a.C6843a r148 = mq7.a.a(r110);     // Catch: Throwable -> L108
        r125.f552172a = r148.f514896a;     // Catch: Throwable -> L108
        r125.f552175d = r148.f514897b;     // Catch: Throwable -> L108
        r125.f552176e = r148.f514898c;     // Catch: Throwable -> L108
        r125.f552177f = r148.f514899d;     // Catch: Throwable -> L108
        goto L64
    L13:
        r109 = false;
        goto L14
    L9:
        r107 = WebViewLifeState.CREATED.ordinal();     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L110
    }

    public final void j() {
        WebViewMonitorJsBridge r100 = new WebViewMonitorJsBridge(this);
        WebView r101 = d();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getSettings().getJavaScriptEnabled() == true) goto L7;
        r101.getSettings().setJavaScriptEnabled(true);
    L7:
        nz2.b.f(this.f163287c, "registerJsInterface");
        r101.addJavascriptInterface(r100, "iesJsBridgeTransferMonitor");
        r101.addJavascriptInterface(new com.bytedance.android.anniex.monitor.salamander.g(this), "hybridMonitor");
    }

    public final void a(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f163303s == false) goto L7;
        return;
    L7:
        this.f163303s = true;
        h(true);
        WebView r101 = d();
        if (r101 == null) goto L41;
        Lazy r102 = TTUtils.f163378a;
        JSONObject r103 = TTUtils.b(r101, TTUtils.MetricsArgs.Errors);
        NavigationDataManager r104 = this.f163290f;
        if (r104 == null) goto L39;
        com.bytedance.android.monitorV2.util.k r105 = new com.bytedance.android.monitorV2.util.k(r103);
        jz2.e r106 = r104.f163268j;
        String r107 = "";
        String r108 = r105.e("webview_error.render_status", "");
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        r106.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f501135k = r108;
        jz2.e r109 = r104.f163268j;
        String r110 = r105.e("webview_error.dom_state", "");
        if (r110 != null) goto L17;
        r110 = "";
    L17:
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f501136l = r110;
        jz2.e r111 = r104.f163268j;
        String r112 = r105.e("webview_error.rendering_phase", "");
        if (r112 != null) goto L20;
        r112 = "";
    L20:
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "<set-?>");
        r111.f501137m = r112;
        jz2.e r113 = r104.f163268j;
        String r114 = r105.e("webview_error.js_hang", "");
        if (r114 == null) goto L24;
        r107 = r114;
    L24:
        r113.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r113.f501138n = r107;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        Intrinsics.checkNotNullParameter("webview_error", "key");
        Object r115 = r103.opt("webview_error");
        JSONArray r116 = null;
        if (r115 != null) goto L27;
    L29:
        JSONObject r117 = null;
    L30:
        if (r117 == null) goto L39;
        Intrinsics.checkNotNullParameter(r117, "<this>");
        Intrinsics.checkNotNullParameter("js_error", "key");
        Object r118 = r117.opt("js_error");
        if (r118 != null) goto L34;
    L36:
        if (r116 == null) goto L39;
        r104.f163268j.f501128d += r116.length();
        goto L39
    L34:
        if ((r118 instanceof JSONArray) == false) goto L36;
        r116 = (JSONArray) r118;
        goto L36
    L27:
        if ((r115 instanceof JSONObject) == false) goto L29;
        r117 = (JSONObject) r115;
    L39:
        if (((Boolean) this.f163306v.getValue()).booleanValue() == false) goto L41;
        nz2.b.f(this.f163287c, "KernelErrorInfo: WebView: " + r101 + ", Url: " + r101.getUrl() + ", KernelInfo: " + r103);
    L41:
        e();
        NavigationDataManager r119 = this.f163290f;
        if (r119 == null) goto L46;
        h r120 = r119.f163269k;
        if (r120 == null) goto L46;
        r120.f163352b.d();
    L46:
        this.f163297m.postDelayed(new b(this), 150);
    }

    public final void f(JSONObject r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        String r100 = com.bytedance.android.monitorV2.util.l.l(r110, NsdHelper.serviceTypeKey);
        if (Intrinsics.areEqual(r100, "") == false) goto L26;
        NavigationDataManager r101 = this.f163290f;
        if (r101 == null) goto L34;
        Intrinsics.checkNotNullParameter(r110, "jsonObject");
        JSONObject r102 = com.bytedance.android.monitorV2.util.l.r(com.bytedance.android.monitorV2.util.l.l(r110, "category"));
        JSONObject r103 = com.bytedance.android.monitorV2.util.l.r(com.bytedance.android.monitorV2.util.l.l(r110, "metrics"));
        JSONObject r104 = com.bytedance.android.monitorV2.util.l.r(com.bytedance.android.monitorV2.util.l.l(r110, "timing"));
        JSONObject r105 = com.bytedance.android.monitorV2.util.l.r(com.bytedance.android.monitorV2.util.l.l(r110, "extra"));
        String r106 = com.bytedance.android.monitorV2.util.l.l(r110, "bid");
        int r107 = com.bytedance.android.monitorV2.util.l.g(r110, "level");
        int r108 = com.bytedance.android.monitorV2.util.l.g(r110, "canSample");
        boolean r111 = r110.optBoolean("canSample", true);
        if (r110.has("level") == false) goto L12;
    L17:
        jz2.d.a r109 = new jz2.d.a(com.bytedance.android.monitorV2.util.l.l(r110, "eventName"));
        r109.f501116d = r102;
        r109.f501118f = r105;
        r109.f501119g = r104;
        r109.f501117e = r103;
        r109.b(r107);
        jz2.d r112 = r109.a();
        if (TextUtils.isEmpty(r106) == true) goto L20;
        r112.f501102b = r106;
    L20:
        com.bytedance.android.monitorV2.event.b r113 = new com.bytedance.android.monitorV2.event.b(r112);
        Map<String, Object> r114 = r113.f163005e;
        c r115 = r101.f163259a.c();
        if (r115 == null) goto L23;
        String r116 = r115.f163342g;
    L24:
        r114.put("config_bid", r116);
        r113.f163005e.put("jsb_bid", r101.f163262d);
        r113.c();
        r101.f(r113);
        return;
    L23:
        r116 = null;
        goto L24
    L12:
        if (r110.has("canSample") == false) goto L16;
        if (r108 == 0) goto L15;
        if (r111 == true) goto L16;
    L15:
        r107 = 0;
    L16:
        r107 = 2;
        goto L17
    L34:
        return;
    L26:
        if (Intrinsics.areEqual(r100, PerfLog.TAG_PERF) == false) goto L30;
        com.bytedance.android.monitorV2.util.l.l(r110, "url");
        NavigationDataManager r117 = this.f163290f;
        if (r117 == null) goto L36;
        r117.a(r110);
        return;
    L36:
        return;
    L30:
        NavigationDataManager r118 = this.f163290f;
        if (r118 == null) goto L38;
        r118.g(r100, r110);
        return;
    }

    public final void g(WebViewLifeState r100) {
        this.f163291g = r100;
        this.f163294j.put(r100, new k(System.currentTimeMillis()));
    }

    public final void h(boolean r100) {
        WebView r101 = d();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        String r102 = "true";
    L8:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r101.evaluateJavascript(String.format(" javascript: (function () {\n                    var target = {}\n                    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n                    var performacess = SlardarHybrid('getLatestPerformance');\n                    var resourcess = SlardarHybrid('getLatestResource');\n                    var cacheData = SlardarHybrid('flushCacheData');\n                    target.performance = performacess;\n                    target.resource = resourcess;\n                    target.cacheData = cacheData;\n                    target.needReport = %s;\n                    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n                })()", Arrays.copyOf(new Object[]{r102}, 1)), null);
        return;
    L7:
        r102 = "false";
        goto L8
    }

    public final void i(WebView r100) {
        JSONObject r101 = new JSONObject();
        boolean r102 = false;
        if (r100.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        r101.put("hm_webView_visibility", r103);
        if (this.f163295k <= 1) goto L9;
        r102 = true;
    L9:
        r101.put("hm_webView_reuse", r102);
        r101.put("hm_webView_load", this.f163295k);
        JSONObject r104 = new JSONObject();
        k r105 = this.f163294j.get(WebViewLifeState.CREATED);
        if (r105 == null) goto L12;
        long r106 = r105.f163357a;
    L13:
        r104.put("hm_webView_sd", System.currentTimeMillis() - r106);
        r104.put("hm_webView_width", r100.getWidth());
        r104.put("hm_webView_height", r100.getHeight());
        int r107 = com.bytedance.android.monitorV2.webview.ttweb.a.f163385a;
        boolean r108 = this.f163301q;
        com.bytedance.android.monitorV2.settings.j r109 = b();
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r109, "detectConfig");
        Intrinsics.checkNotNullParameter(r101, "category");
        Intrinsics.checkNotNullParameter(r104, "metrics");
        if (r100.getWidth() > 0) goto L16;
        return;
    L16:
        if (r100.getHeight() <= 0) goto L21;
        JSONObject r110 = new JSONObject();
        r110.put("is_blank", r108);
        r110.put("use_monitor_detect", r109.d());
        r110.put("detect_type", r109.a());
        r110.put("stay_duration", r109.b());
        m r111 = m.f163358f;
        jz2.d.a r112 = new jz2.d.a("ttwebview_blank_detect_from_monitor");
        r112.f501116d = com.bytedance.android.monitorV2.util.l.c(r101, r110);
        r112.f501117e = r104;
        r112.b(1);
        r111.j(r100, r112.a());
        return;
    L21:
        return;
    L12:
        r106 = System.currentTimeMillis();
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public WebViewDataManager(WeakReference<WebView> r100, n r110) {
        Intrinsics.checkNotNullParameter(r100, "webViewRef");
        Intrinsics.checkNotNullParameter(r110, "webViewMonitorHelperImpl");
        this.f163285a = r100;
        this.f163286b = r110;
        this.f163287c = "WebViewDataManager";
        String r101 = "";
        this.f163288d = "";
        this.f163289e = LazyKt.lazy(new WebViewDataManager$config$2(this));
        this.f163294j = new HashMap();
        this.f163296l = new HashMap();
        this.f163297m = new Handler(Looper.getMainLooper());
        this.f163298n = new HashMap();
        WebView r102 = d();     // Catch: Throwable -> L20
        if (r102 == null) goto L8;
        WebSettings r103 = r102.getSettings();     // Catch: Throwable -> L20
        if (r103 == null) goto L8;
        String r104 = r103.getUserAgentString();     // Catch: Throwable -> L20
    L9:
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        int r105 = StringsKt.indexOf$default(r104, "Chrome/", 0, false, 6, null);     // Catch: Throwable -> L20
        if (r105 == (-1)) goto L14;
        r105 = r105 + 7;     // Catch: Throwable -> L20
    L14:
        List r106 = StringsKt.split$default(r104.substring(r105), new String[]{" "}, false, 0, 6, null);     // Catch: Throwable -> L20
        if ((!r106.isEmpty()) == false) goto L18;
        r101 = (String) ListProtector.get(r106, 0);     // Catch: Throwable -> L20
    L8:
        r104 = null;
    L18:
        this.f163299o = r101;
        this.f163300p = true;
        this.f163301q = true;
        this.f163304t = LazyKt.lazy(new WebViewDataManager$webViewRootManager$2(this));
        this.f163305u = LazyKt.lazy(WebViewDataManager$blankConfig$2.INSTANCE);
        this.f163306v = LazyKt.lazy(WebViewDataManager$enableKernelBlankLog$2.INSTANCE);
        this.f163307w = new HashMap();
    }
}
