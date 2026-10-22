package com.bytedance.android.monitor.webview;

import A6.l;
import B2.a;
import B2.f;
import F.b;
import F.c;
import F.d;
import F.e;
import F.i;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.android.monitor.logger.MonitorLog;
import g1.AbstractC1451a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WebViewMonitorHelper implements ITTLiveWebViewMonitorHelper, e {

    /* renamed from: a, reason: collision with root package name */
    public static ITTLiveWebViewMonitorHelper f2211a;
    public static e b;
    public static Map<String, String> c = new HashMap();
    public static a d;
    public Map<String, a> e = new HashMap();
    public Map<String, a> f = new HashMap();
    public Set<String> g = new HashSet();
    public f h = new f();
    public Handler i = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public B2.e f2212j;

    static {
        WebViewMonitorHelper webViewMonitorHelper = new WebViewMonitorHelper();
        f2211a = webViewMonitorHelper;
        b = webViewMonitorHelper;
    }

    public static ITTLiveWebViewMonitorHelper getInstance() {
        return f2211a;
    }

    public final boolean a(WebView webView) {
        d dVar;
        a aVarB = b(webView);
        if (aVarB == null || (dVar = aVarB.f182a) == null) {
            return false;
        }
        return dVar.k(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void addConfig(a aVar) {
        try {
            a aVarA = a(aVar);
            aVarA.getClass();
            String[] strArr = aVarA.b;
            if (strArr == null || strArr.length == 0) {
                return;
            }
            for (String str : strArr) {
                this.e.put(str, aVarA);
            }
        } catch (Exception unused) {
        }
    }

    public final a b(WebView webView) {
        Class<?> cls;
        a aVar;
        if (webView == null) {
            return d;
        }
        a aVar2 = this.f.get(createWebViewKey(webView));
        if (aVar2 != null) {
            return aVar2;
        }
        String name = webView.getClass().getName();
        a aVar3 = this.e.get(name);
        if (aVar3 != null) {
            return aVar3;
        }
        if (this.g.contains(name)) {
            return d;
        }
        Iterator it = new HashSet(this.e.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Class<?> cls2 = null;
            try {
                cls = Class.forName(name);
            } catch (Throwable unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName(str);
            } catch (Throwable unused2) {
            }
            if (((cls == null || cls2 == null) ? false : cls2.isAssignableFrom(cls)) && (aVar = this.e.get(str)) != null) {
                this.e.put(name, aVar);
                return aVar;
            }
        }
        this.g.add(name);
        return d;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public a buildConfig() {
        return new a();
    }

    @Override // F.e
    public void cover(WebView webView, String str, String str2, String str3) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.cover(webView, str, str2, str3);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public String createWebViewKey(WebView webView) {
        if (webView == null) {
            return "";
        }
        return webView.hashCode() + "";
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customParams(WebView webView, String str) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.p(webView, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customParseKey(WebView webView, Set<String> set) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.i(webView, set);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customReport(WebView webView, String str, String str2, String str3, String str4) {
        try {
            customReport(webView, null, null, str, str2, str3, str4);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void destroy(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                a(webView, false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void dispatchTouchEvent(WebView webView, MotionEvent motionEvent) {
        if (webView == null || motionEvent == null) {
            return;
        }
        try {
            if (motionEvent.getAction() == 1) {
                updateClickStartTime(webView);
            }
        } catch (Exception unused) {
        }
    }

    @Override // F.e
    public c getCustomCallback(WebView webView) {
        try {
            b(webView);
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // F.e
    public b getMonitor(WebView webView) {
        try {
            a aVarB = b(webView);
            if (aVarB == null) {
                return null;
            }
            return aVarB.d;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // F.e
    public F.f getTTWebviewDetect(WebView webView) {
        b(webView).getClass();
        return null;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void goBack(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                a(webView, false);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleFetchError(WebView webView, G.a aVar) {
        a aVarB;
        d dVar;
        if (webView == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.h();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleFetchSuccess(WebView webView) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleJSBError(WebView webView, G.b bVar) {
        a aVarB;
        d dVar;
        if (webView == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.u();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void handleRequestError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        a aVarB;
        d dVar;
        if (webView == null || webResourceRequest == null || webResourceError == null) {
            return;
        }
        try {
            if (isNeedMonitor(webView) && a(webView) && webResourceRequest.isForMainFrame() && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.s(webView, webResourceRequest.getUrl().toString(), webResourceError.getErrorCode(), webResourceError.getDescription().toString());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void initConfig(a aVar) {
        try {
            addConfig(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // F.e
    public void initTime(WebView webView, String str) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.l(webView, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // F.e
    public boolean isNeedAutoReport(WebView webView) {
        try {
            a aVarB = b(webView);
            if (aVarB != null) {
                return aVarB.g;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // F.e
    public boolean isNeedMonitor(WebView webView) {
        try {
            a aVarB = b(webView);
            if (aVarB == null) {
                return false;
            }
            return aVarB.f;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // F.e
    public String mapService(WebView webView, String str) {
        if (webView != null) {
            try {
                a aVarB = b(webView);
                if (aVarB != null && !TextUtils.isEmpty(str)) {
                    if ("custom".equals(str)) {
                        return "tt" + aVarB.f183j + "_webview_timing_monitor_custom_service";
                    }
                    return "bd_hybrid_monitor_service_" + str + "_web_" + aVarB.f183j;
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onClientOffline(WebView webView, String str, boolean z10) {
        d dVar;
        try {
            String strA = a(str);
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.g(webView, strA, z10);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onLoadUrl(WebView webView, String str) {
        try {
            if (isNeedMonitor(webView)) {
                b(webView, "ttlive_web_view_last_url_tag");
                MonitorLog.d("TTLiveWebViewMonitorHelper", "onLoadUrl : " + str);
                updateClickStartTime(webView);
                if (!isNeedMonitor(webView) || "ttlive_web_view_tag".equals(a(webView, "ttlive_web_view_tag"))) {
                    return;
                }
                TTLiveWebViewMonitorJsBridge tTLiveWebViewMonitorJsBridge = new TTLiveWebViewMonitorJsBridge(webView);
                if (!webView.getSettings().getJavaScriptEnabled()) {
                    webView.getSettings().setJavaScriptEnabled(true);
                }
                webView.addJavascriptInterface(tTLiveWebViewMonitorJsBridge, "JsBridgeTransferMonitor");
                a(webView, "ttlive_web_view_tag", "ttlive_web_view_tag");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onOffline(WebView webView, String str, boolean z10) {
        d dVar;
        try {
            String strA = a(str);
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.f(webView, strA, z10);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onOfflineInfoExtra(WebView webView, String str, String str2, String str3, String str4, String str5) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.q(webView, str, str2, str3, str4, str5);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onPageFinished(WebView webView, String str) {
        a aVarB;
        d dVar;
        try {
            if (isNeedMonitor(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.v(webView);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        try {
            onPageStarted(webView, str);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onProgressChanged(WebView webView, int i) {
        a aVarB;
        d dVar;
        try {
            a(webView, i);
            if (webView != null && isNeedMonitor(webView) && a(webView) && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.d(webView, i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void reload(WebView webView) {
        try {
            if (isNeedMonitor(webView)) {
                b(webView, "ttlive_web_view_last_url_tag");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void removeWebViewKey(String str) {
        try {
            Map<String, a> map = this.f;
            if (map != null) {
                map.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void report(WebView webView) {
        try {
            this.i.post(new A.a(1, this, webView));
            B2.e eVar = new B2.e(this, webView);
            this.f2212j = eVar;
            this.i.postDelayed(eVar, 200L);
        } catch (Exception unused) {
        }
    }

    @Override // F.e
    public void reportDirectly(WebView webView, String str, String str2) {
        d dVar;
        try {
            a aVarB = b(webView);
            if (aVarB != null && (dVar = aVarB.f182a) != null) {
                dVar.reportDirectly(webView, str, str2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void reportTruly(WebView webView) {
        d dVar;
        d dVar2;
        try {
            B2.e eVar = this.f2212j;
            if (eVar != null) {
                this.i.removeCallbacks(eVar);
                this.f2212j = null;
            }
            try {
                a aVarB = b(webView);
                if (aVarB != null && (dVar2 = aVarB.f182a) != null) {
                    dVar2.m(webView);
                }
            } catch (Exception unused) {
            }
            a aVarB2 = b(webView);
            if (aVarB2 != null && (dVar = aVarB2.f182a) != null) {
                dVar.report(webView);
            }
            b(webView, "ttlive_web_view_last_url_tag");
            b(webView, "ttlive_web_view_auto_report_tag");
            b(webView, "ttlive_web_view_tag");
            f fVar = this.h;
            if (fVar == null || webView == null) {
                return;
            }
            webView.removeOnAttachStateChangeListener(fVar);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setDefaultConfig(a aVar) {
        try {
            d = a(aVar);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void setGeckoClient(F.a aVar) {
        this.i.postDelayed(new l(this, 1), 20000L);
    }

    public void updateClickStartTime(WebView webView) {
        a aVarB;
        d dVar;
        if (webView == null || !isNeedMonitor(webView) || (aVarB = b(webView)) == null || (dVar = aVarB.f182a) == null) {
            return;
        }
        dVar.e(webView);
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void customReport(WebView webView, String str, String str2, String str3, String str4, String str5, String str6) {
        a aVarB;
        d dVar;
        d dVar2;
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObjectL0 = S0.b.l0(str5);
                try {
                    jSONObjectL0.put("event_name", str2);
                } catch (JSONException unused) {
                }
                str5 = jSONObjectL0.toString();
            }
            if ("0".equals(str6)) {
                a aVarB2 = b(webView);
                if (aVarB2 != null && (dVar2 = aVarB2.f182a) != null) {
                    dVar2.o(webView, str, str3, str4, str5);
                    return;
                }
                return;
            }
            String str7 = str5;
            if ("1".equals(str6) && (aVarB = b(webView)) != null && (dVar = aVarB.f182a) != null) {
                dVar.t(webView, str, str3, str4, str7);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper
    public void onPageStarted(WebView webView, String str) {
        d dVar;
        try {
            if (isNeedMonitor(webView)) {
                if (isNeedAutoReport(webView) && !"ttlive_web_view_auto_report_tag".equals(a(webView, "ttlive_web_view_auto_report_tag"))) {
                    if (this.h != null && isNeedAutoReport(webView)) {
                        f fVar = this.h;
                        fVar.getClass();
                        if (webView != null) {
                            webView.removeOnAttachStateChangeListener(fVar);
                            webView.addOnAttachStateChangeListener(fVar);
                        }
                    }
                    a(webView, "ttlive_web_view_auto_report_tag", "ttlive_web_view_auto_report_tag");
                }
                a aVarB = b(webView);
                if (aVarB != null && (dVar = aVarB.f182a) != null) {
                    dVar.n(webView, str);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(WebView webView, boolean z10) {
        if (b(webView) == null) {
            return;
        }
        String strM = B7.a.m(" javascript: (function () {\n    var target = {}\n    if (typeof SlardarHybrid !== 'undefined' && typeof jsIESLiveTimingMonitor !== 'undefined'){\n    var performacess = SlardarHybrid('getLatestPerformance');\n    var resourcess = SlardarHybrid('getLatestResource');\n    target.performance = performacess;\n    target.resource = resourcess;\n    target.needReport = ", z10 ? "true" : "false", ";\n    jsIESLiveTimingMonitor.reportPageLatestData(target);}\n })()");
        if (webView != null) {
            webView.evaluateJavascript(strM, null);
        }
    }

    public final a a(a aVar) {
        String[] strArr;
        JSONArray jSONArrayOptJSONArray;
        boolean zOptBoolean;
        String strM;
        a aVar2 = new a();
        aVar.f183j = aVar.f183j;
        if (aVar.e) {
            aVar.f183j = "live";
        }
        d dVar = aVar.f182a;
        if (dVar == null) {
            if (i.f514a == null) {
                synchronized (i.class) {
                    try {
                        if (i.f514a == null) {
                            i.f514a = new i();
                        }
                    } finally {
                    }
                }
            }
            dVar = i.f514a;
        }
        aVar2.f182a = dVar;
        String str = aVar.c;
        if (str == null) {
            str = "WebViewMonitor";
        }
        aVar2.c = str;
        b bVar = aVar.d;
        Z0.a aVar3 = new Z0.a();
        aVar3.f1582a = bVar;
        aVar2.d = aVar3;
        aVar2.e = aVar.e;
        aVar2.g = aVar.g;
        aVar2.i = null;
        aVar2.f = aVar.f;
        aVar2.b = aVar.b;
        aVar2.f183j = aVar.f183j;
        aVar2.h = TextUtils.isEmpty(aVar.h) ? "" : aVar.h;
        if (S0.b.l0("").opt("webview_classes") == null) {
            strArr = aVar2.b;
        } else {
            String[] strArr2 = new String[0];
            if (!TextUtils.isEmpty("") && (jSONArrayOptJSONArray = S0.b.l0("").optJSONArray("webview_classes")) != null) {
                strArr2 = new String[jSONArrayOptJSONArray.length()];
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    try {
                        strArr2[i] = jSONArrayOptJSONArray.getString(i);
                    } catch (JSONException unused) {
                    }
                }
            }
            strArr = strArr2;
        }
        aVar2.b = strArr;
        if (S0.b.l0("").opt("webview_is_need_monitor") == null) {
            zOptBoolean = aVar2.f;
        } else {
            zOptBoolean = S0.b.l0("").optBoolean("webview_is_need_monitor", false);
        }
        aVar2.f = zOptBoolean;
        if (TextUtils.isEmpty("")) {
            strM = aVar2.h;
        } else {
            JSONObject jSONObjectL0 = S0.b.l0("");
            JSONObject jSONObjectOptJSONObject = jSONObjectL0.optJSONObject("apmReportConfig");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectL0.optJSONObject("performanceReportConfig");
            JSONObject jSONObjectOptJSONObject3 = jSONObjectL0.optJSONObject("errorMsgReportConfig");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectL0.optJSONObject("resourceTimingReportConfig");
            JSONObject jSONObjectOptJSONObject5 = jSONObjectL0.optJSONObject("commonReportConfig");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("monitors", jSONObject2);
            } catch (JSONException unused2) {
            }
            try {
                jSONObject.put("sendCommonParams", jSONObjectOptJSONObject5);
            } catch (JSONException unused3) {
            }
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject2.put(next, jSONObjectOptJSONObject.opt(next));
                    } catch (JSONException unused4) {
                    }
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    try {
                        jSONObject2.put(next2, jSONObjectOptJSONObject2.opt(next2));
                    } catch (JSONException unused5) {
                    }
                }
            }
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys3 = jSONObjectOptJSONObject3.keys();
                while (itKeys3.hasNext()) {
                    String next3 = itKeys3.next();
                    try {
                        jSONObject2.put(next3, jSONObjectOptJSONObject3.opt(next3));
                    } catch (JSONException unused6) {
                    }
                }
            }
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys4 = jSONObjectOptJSONObject4.keys();
                while (itKeys4.hasNext()) {
                    String next4 = itKeys4.next();
                    try {
                        jSONObject2.put(next4, jSONObjectOptJSONObject4.opt(next4));
                    } catch (JSONException unused7) {
                    }
                }
            }
            strM = B7.a.m("RangersSiteHybridSDK('config', ", jSONObject.toString(), ")");
        }
        aVar2.h = strM;
        return aVar2;
    }

    public final void b(WebView webView, String str) {
        c.remove(androidx.appfunctions.metadata.a.l(str, createWebViewKey(webView)));
    }

    public final String a(String str) {
        int iIndexOf;
        return (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("?")) == -1) ? str : str.substring(0, iIndexOf);
    }

    public final void a(WebView webView, int i) {
        if (isNeedMonitor(webView) && i >= 15 && webView != null) {
            if (!webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            try {
                String url = webView.getUrl();
                if (url == null || !url.equals("about:blank")) {
                    String strA = a(webView, "ttlive_web_view_last_url_tag");
                    if (TextUtils.isEmpty(url) || url.equals(strA)) {
                        return;
                    }
                    a aVarB = b(webView);
                    String str = "";
                    String str2 = aVarB == null ? "" : aVarB.h;
                    if (aVarB != null) {
                        str = aVarB.i;
                    }
                    webView.evaluateJavascript(AbstractC1451a.g(webView.getContext(), true, str, str2), null);
                    a(webView, "ttlive_web_view_last_url_tag", url);
                    MonitorLog.d("WebViewMonitorHelper", "injectJsScript : ".concat(url));
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        c.put(androidx.appfunctions.metadata.a.l(str, createWebViewKey(webView)), str2);
    }

    public final String a(WebView webView, String str) {
        String strCreateWebViewKey = createWebViewKey(webView);
        String str2 = c.get(androidx.appfunctions.metadata.a.l(str, strCreateWebViewKey));
        if (str2 == null) {
            return null;
        }
        return str2.replaceAll(strCreateWebViewKey, "");
    }
}
