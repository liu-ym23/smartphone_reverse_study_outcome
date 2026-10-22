package F;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import cc.dd.dd.b0.e$a;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.mcp.sdk.base.AppUI;
import e3.C1417f;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import m0.C1670d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qa.C1860l;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import z3.G;

/* loaded from: classes2.dex */
public final class g implements d, OnApplyWindowInsetsListener, InterfaceC1855g, G {
    public static volatile g d;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f506a;
    public Object b;
    public Object c;

    public /* synthetic */ g(int i) {
        this.f506a = i;
    }

    public void A(JSONObject jSONObject) throws JSONException {
        b();
        ArrayList arrayList = (ArrayList) this.c;
        e$a e_a = e$a.c;
        arrayList.add(e_a);
        M.b bVar = (M.b) this.b;
        bVar.write("{");
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            e$a e_aB = B();
            if (e_aB == e$a.e) {
                bVar.write(44);
            } else if (e_aB != e_a) {
                throw new JSONException("Nesting problem");
            }
            arrayList.set(arrayList.size() - 1, e$a.d);
            y(next);
            c(obj);
        }
        B();
        arrayList.remove(arrayList.size() - 1);
        bVar.write("}");
    }

    public e$a B() {
        return (e$a) ((ArrayList) this.c).get(r1.size() - 1);
    }

    public void C() {
        if (H.h.f712j) {
            E0.c cVar = new E0.c();
            cVar.f451a = false;
            cVar.d = 0L;
            cVar.e = 0L;
            cVar.f = 0L;
            cVar.g = 0L;
            cVar.h = -1L;
            cVar.i = true;
            cVar.k = -1;
            this.b = cVar;
            this.c = "new";
        } else {
            this.b = new C1417f(1);
            this.c = "dummy";
        }
        if (H.h.b) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"TrafficStatsImpl: ".concat(((E0.a) this.b).getClass().getName())}));
        }
        ((E0.a) this.b).f();
    }

    public synchronized h D(WebView webView) {
        List list = (List) ((WeakHashMap) this.b).get(webView);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (h) list.get(list.size() - 1);
    }

    public synchronized h E(WebView webView, String str) {
        List list = (List) ((WeakHashMap) this.b).get(webView);
        if (list != null && list.size() > 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                h hVar = (h) list.get(size);
                if (hVar != null && str.equals(hVar.i)) {
                    return hVar;
                }
            }
        }
        return null;
    }

    public C1670d a(long j5) {
        y1.b bVar = (y1.b) this.b;
        synchronized (bVar) {
            List listE = bVar.e(" _id = ?", new String[]{String.valueOf(j5)}, "_id DESC LIMIT 1", bVar);
            if (S0.b.a0(listE)) {
                return null;
            }
            return (C1670d) listE.get(0);
        }
    }

    public void b() {
        M.b bVar = (M.b) this.b;
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList.isEmpty()) {
            return;
        }
        e$a e_aB = B();
        e$a e_a = e$a.f2131a;
        e$a e_a2 = e$a.b;
        if (e_aB == e_a) {
            arrayList.set(arrayList.size() - 1, e_a2);
            return;
        }
        if (e_aB == e_a2) {
            bVar.write(44);
        } else if (e_aB == e$a.d) {
            bVar.write(":");
            arrayList.set(arrayList.size() - 1, e$a.e);
        } else if (e_aB != e$a.f) {
            throw new JSONException("Nesting problem");
        }
    }

    public void c(Object obj) throws JSONException {
        ArrayList arrayList = (ArrayList) this.c;
        M.b bVar = (M.b) this.b;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            b();
            arrayList.add(e$a.f2131a);
            bVar.write("[");
            for (int i = 0; i < jSONArray.length(); i++) {
                c(jSONArray.get(i));
            }
            B();
            arrayList.remove(arrayList.size() - 1);
            bVar.write("]");
            return;
        }
        if (obj instanceof JSONObject) {
            A((JSONObject) obj);
            return;
        }
        b();
        if (obj == null || obj == JSONObject.NULL) {
            bVar.write("null");
            return;
        }
        if (obj instanceof Boolean) {
            bVar.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            bVar.write(JSONObject.numberToString((Number) obj));
        } else {
            y(obj.toString());
        }
    }

    @Override // F.d
    public void cover(WebView webView, String str, String str2, String str3) {
        h hVarE = E(webView, str);
        if (hVarE != null) {
            hVarE.e(str3);
            hVarE.b(str2);
        }
    }

    @Override // F.d
    public void d(WebView webView, int i) {
        h hVarD = D(webView);
        if (hVarD != null && i == 100 && hVarD.f512t == 0) {
            hVarD.f512t = System.currentTimeMillis();
        }
    }

    @Override // F.d
    public void e(WebView webView) {
        ((WeakHashMap) this.c).put(webView, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // F.d
    public void f(WebView webView, String str, boolean z10) {
        h hVarD = D(webView);
        if (hVarD != null) {
            Map linkedHashMap = hVarD.k;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            if (z10) {
                linkedHashMap.put(h.f(str), Boolean.valueOf(z10));
            } else {
                linkedHashMap.remove(h.f(str));
            }
            hVarD.k = linkedHashMap;
        }
    }

    @Override // F.d
    public void g(WebView webView, String str, boolean z10) {
        h hVarD = D(webView);
        if (hVarD != null) {
            Map linkedHashMap = hVarD.l;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            if (z10) {
                linkedHashMap.put(h.f(str), Boolean.valueOf(z10));
            } else {
                linkedHashMap.remove(h.f(str));
            }
            hVarD.l = linkedHashMap;
        }
    }

    @Override // F.d
    public void h() {
        try {
            new JSONObject().put("event_type", "fetchError");
        } catch (Exception unused) {
        }
        throw null;
    }

    @Override // F.d
    public void i(WebView webView, Set set) {
        h hVarD = D(webView);
        if (hVarD != null) {
            hVarD.m = set;
        }
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        ((C1860l) this.c).f5655a.execute(new A4.e(this, (InterfaceC1855g) this.b, l, 12));
    }

    @Override // F.d
    public boolean k(WebView webView) {
        return E(webView, webView.getUrl()) != null;
    }

    @Override // F.d
    public void l(WebView webView, String str) {
        h hVarD = D(webView);
        if (hVarD != null) {
            long j5 = hVarD.f508j;
            if (j5 != 0) {
                long j6 = Long.parseLong(str) - j5;
                hVarD.u = j6;
                if (j6 < 0) {
                    hVarD.u = 0L;
                }
                MonitorLog.d("WebViewMonitorDataCache", " updateMonitorInitTimeData initTime : " + hVarD.u);
            }
        }
    }

    @Override // F.d
    public void m(WebView webView) {
        h hVarD = D(webView);
        if (hVarD != null) {
            hVarD.f509q = System.currentTimeMillis();
            MonitorLog.d("WebViewMonitorDataCache", "handlePageExit url : " + hVarD.i + "   showEnd: " + hVarD.f509q + "   navigation: " + hVarD.f);
        }
    }

    @Override // F.d
    public void n(WebView webView, String str) {
        WeakHashMap weakHashMap = (WeakHashMap) this.b;
        WeakHashMap weakHashMap2 = (WeakHashMap) this.c;
        h hVarD = D(webView);
        if (!TextUtils.isEmpty(hVarD != null ? hVarD.i : null)) {
            m(webView);
        }
        MonitorLog.d("MonitorCacheInfoHandler", "buildNewNavigation new url : " + str);
        WebViewMonitorHelper.b.getTTWebviewDetect(webView);
        long jLongValue = weakHashMap2.containsKey(webView) ? ((Long) weakHashMap2.get(webView)).longValue() : 0L;
        h hVar = new h();
        hVar.c = new LinkedHashMap();
        hVar.g = new LinkedHashMap();
        hVar.h = new LinkedHashMap();
        hVar.l = new LinkedHashMap();
        hVar.f513v = new JSONObject();
        hVar.o = AppUI.TYPE_WEB;
        hVar.i = str;
        hVar.f508j = jLongValue;
        hVar.f = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
        List arrayList = (List) weakHashMap.get(webView);
        if (arrayList == null) {
            arrayList = new ArrayList();
            weakHashMap.put(webView, arrayList);
        }
        arrayList.add(hVar);
        h hVarD2 = D(webView);
        if (hVarD2 != null) {
            hVarD2.p = System.currentTimeMillis();
            MonitorLog.d("WebViewMonitorDataCache", "handlePageEnter url : " + hVarD2.i + "   startTime: " + hVarD2.p + "   navigation: " + hVarD2.f);
            if (hVarD2.f510r == 0) {
                hVarD2.f510r = System.currentTimeMillis();
            }
        }
    }

    @Override // F.d
    public void o(WebView webView, String str, String str2, String str3, String str4) {
        h hVarD = D(webView);
        if (hVarD != null) {
            if (TextUtils.isEmpty(str)) {
                str = hVarD.i;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put("client_category", S0.b.l0(str2));
                } catch (JSONException unused) {
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                try {
                    jSONObject.put("client_metric", S0.b.l0(str3));
                } catch (JSONException unused2) {
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject.put("client_extra", S0.b.l0(str4));
                } catch (JSONException unused3) {
                }
            }
            try {
                jSONObject.put("ev_type", "custom");
            } catch (Exception unused4) {
            }
            if (TextUtils.isEmpty(str)) {
                JSONArray jSONArray = hVarD.e;
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                jSONArray.put(jSONObject);
                hVarD.e = jSONArray;
                return;
            }
            try {
                jSONObject.put(BffConstant.Type.Url, str);
            } catch (Exception unused5) {
            }
            Map linkedHashMap = hVarD.c;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            JSONArray jSONArray2 = (JSONArray) linkedHashMap.get(h.f(str));
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            jSONArray2.put(jSONObject);
            linkedHashMap.put(h.f(str), jSONArray2);
            hVarD.c = linkedHashMap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r14, androidx.core.view.WindowInsetsCompat r15) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.b
            com.google.android.material.bottomsheet.b r0 = (com.google.android.material.bottomsheet.b) r0
            java.lang.Object r13 = r13.c
            com.google.android.material.internal.n r13 = (com.google.android.material.internal.n) r13
            int r1 = r13.f2504a
            int r2 = r13.b
            int r13 = r13.c
            int r3 = androidx.core.view.WindowInsetsCompat.Type.systemBars()
            androidx.core.graphics.Insets r3 = r15.getInsets(r3)
            int r4 = androidx.core.view.WindowInsetsCompat.Type.mandatorySystemGestures()
            androidx.core.graphics.Insets r4 = r15.getInsets(r4)
            com.google.android.material.bottomsheet.BottomSheetBehavior r5 = r0.b
            int r6 = r3.top
            r5.f2341w = r6
            int r6 = r14.getLayoutDirection()
            r7 = 0
            r8 = 1
            if (r6 != r8) goto L2e
            r6 = r8
            goto L2f
        L2e:
            r6 = r7
        L2f:
            int r9 = r14.getPaddingBottom()
            int r10 = r14.getPaddingLeft()
            int r11 = r14.getPaddingRight()
            boolean r12 = r5.o
            if (r12 == 0) goto L46
            int r9 = r15.getSystemWindowInsetBottom()
            r5.f2340v = r9
            int r9 = r9 + r13
        L46:
            boolean r13 = r5.p
            if (r13 == 0) goto L52
            if (r6 == 0) goto L4e
            r13 = r2
            goto L4f
        L4e:
            r13 = r1
        L4f:
            int r10 = r3.left
            int r10 = r10 + r13
        L52:
            boolean r13 = r5.f2336q
            if (r13 == 0) goto L5e
            if (r6 == 0) goto L59
            goto L5a
        L59:
            r1 = r2
        L5a:
            int r13 = r3.right
            int r11 = r1 + r13
        L5e:
            android.view.ViewGroup$LayoutParams r13 = r14.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
            boolean r1 = r5.f2338s
            if (r1 == 0) goto L71
            int r1 = r13.leftMargin
            int r2 = r3.left
            if (r1 == r2) goto L71
            r13.leftMargin = r2
            r7 = r8
        L71:
            boolean r1 = r5.f2339t
            if (r1 == 0) goto L7e
            int r1 = r13.rightMargin
            int r2 = r3.right
            if (r1 == r2) goto L7e
            r13.rightMargin = r2
            r7 = r8
        L7e:
            boolean r1 = r5.u
            if (r1 == 0) goto L8b
            int r1 = r13.topMargin
            int r2 = r3.top
            if (r1 == r2) goto L8b
            r13.topMargin = r2
            goto L8c
        L8b:
            r8 = r7
        L8c:
            if (r8 == 0) goto L91
            r14.setLayoutParams(r13)
        L91:
            int r13 = r14.getPaddingTop()
            r14.setPadding(r10, r13, r11, r9)
            boolean r13 = r0.f2345a
            if (r13 == 0) goto La0
            int r14 = r4.bottom
            r5.m = r14
        La0:
            if (r12 != 0) goto La6
            if (r13 == 0) goto La5
            goto La6
        La5:
            return r15
        La6:
            r5.t()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: F.g.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
    }

    @Override // F.d
    public void p(WebView webView, String str) {
        h hVarD = D(webView);
        if (hVarD != null) {
            hVarD.n = str;
        }
    }

    @Override // F.d
    public void q(WebView webView, String str, String str2, String str3, String str4, String str5) {
        String host;
        String path = "";
        h hVarD = D(webView);
        if (hVarD != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bid", str2);
            } catch (JSONException unused) {
            }
            try {
                jSONObject.put("navigation_id", str3);
            } catch (JSONException unused2) {
            }
            try {
                host = new URL(str).getHost();
            } catch (Exception unused3) {
                host = "";
            }
            try {
                jSONObject.put("host", host);
            } catch (JSONException unused4) {
            }
            try {
                path = new URL(str).getPath();
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put(SingleFileBundle.KEY_PATH, path);
            } catch (JSONException unused6) {
            }
            try {
                jSONObject.put("ev_type", str4);
            } catch (JSONException unused7) {
            }
            try {
                jSONObject.put(BffConstant.Type.Url, h.f(str));
            } catch (JSONException unused8) {
            }
            try {
                jSONObject.put(NotificationCompat.CATEGORY_EVENT, S0.b.l0(str5));
            } catch (JSONException unused9) {
            }
            hVarD.e(jSONObject.toString());
        }
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1860l) this.c).f5655a.execute(new A4.e(this, (InterfaceC1855g) this.b, th, 13));
    }

    @Override // F.d
    public void report(WebView webView) {
        List<h> list;
        Object obj;
        JSONObject jSONObjectS0;
        synchronized (this) {
            list = (List) ((WeakHashMap) this.b).remove(webView);
        }
        if (list != null) {
            for (h hVar : list) {
                Map map = hVar.f507a;
                Map map2 = hVar.b;
                Map map3 = hVar.c;
                Set<String> set = hVar.m;
                String str = hVar.n;
                hVar.c = null;
                hVar.b = null;
                hVar.f507a = null;
                hVar.m = null;
                hVar.n = null;
                if (map != null && !map.isEmpty()) {
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        JSONObject jSONObject = (JSONObject) map.get((String) it.next());
                        String strH1 = S0.b.h1(NotificationCompat.CATEGORY_SERVICE, jSONObject);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("event_type", "performance");
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject2.put("show_start", hVar.p);
                        } catch (Exception unused2) {
                        }
                        try {
                            jSONObject2.put("show_end", hVar.f509q);
                        } catch (Exception unused3) {
                        }
                        try {
                            jSONObject2.put("initTime", hVar.u);
                        } catch (Exception unused4) {
                        }
                        try {
                            jSONObject2.put("event_counts", hVar.f513v);
                        } catch (JSONException unused5) {
                        }
                        try {
                            jSONObject2.put("page_start", hVar.f510r);
                        } catch (Exception unused6) {
                        }
                        try {
                            jSONObject2.put("page_finish", hVar.f511s);
                        } catch (Exception unused7) {
                        }
                        try {
                            jSONObject2.put("page_progress_100", hVar.f512t);
                        } catch (Exception unused8) {
                        }
                        try {
                            jSONObject.put("nativeInfo", jSONObject2);
                        } catch (JSONException unused9) {
                        }
                        hVar.a(webView, strH1, jSONObject);
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("performanceTiming", S0.b.S0(NotificationCompat.CATEGORY_NAVIGATION, S0.b.S0(NotificationCompat.CATEGORY_EVENT, jSONObject)));
                        } catch (JSONException unused10) {
                        }
                        try {
                            jSONObject3.put(BffConstant.Type.Url, jSONObject == null ? new Object() : jSONObject.opt(BffConstant.Type.Url));
                        } catch (JSONException unused11) {
                        }
                        try {
                            jSONObject3.put("bid", jSONObject == null ? new Object() : jSONObject.opt("bid"));
                        } catch (JSONException unused12) {
                        }
                        try {
                            jSONObject3.put(Constants.PARAM_PID, jSONObject == null ? new Object() : jSONObject.opt(Constants.PARAM_PID));
                        } catch (JSONException unused13) {
                        }
                        try {
                            jSONObject3.put("ev_type", "custom");
                        } catch (JSONException unused14) {
                        }
                        JSONObject jSONObjectL0 = S0.b.l0(str);
                        Iterator<String> itKeys = jSONObjectL0.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            try {
                                jSONObject3.put(next, jSONObjectL0.opt(next));
                            } catch (JSONException unused15) {
                            }
                        }
                        if (map2 != null && !map2.isEmpty() && (jSONObjectS0 = S0.b.S0("client_metric", (JSONObject) map2.get(h.f(S0.b.h1(BffConstant.Type.Url, jSONObject))))) != null && set != null) {
                            for (String str2 : set) {
                                try {
                                    jSONObject3.put(str2, jSONObjectS0.opt(str2));
                                } catch (JSONException unused16) {
                                }
                            }
                        }
                        String strOptString = jSONObject3.optString(BffConstant.Type.Url, "");
                        if (!TextUtils.isEmpty(strOptString) && !strOptString.contains("about:blank")) {
                            WebViewMonitorHelper.b.getCustomCallback(webView);
                        }
                    }
                }
                if (map2 != null && !map2.isEmpty()) {
                    for (String str3 : map2.keySet()) {
                        JSONObject jSONObject4 = (JSONObject) map2.get(h.f(str3));
                        JSONObject jSONObject5 = (map == null || map.isEmpty()) ? new JSONObject() : (JSONObject) map.get((String) hVar.g.get(h.f(str3)));
                        String strH12 = S0.b.h1("bid", jSONObject5);
                        String strH13 = S0.b.h1(Constants.PARAM_PID, jSONObject5);
                        try {
                            jSONObject4.put("bid", strH12);
                        } catch (Exception unused17) {
                        }
                        try {
                            jSONObject4.put(Constants.PARAM_PID, strH13);
                        } catch (Exception unused18) {
                        }
                        hVar.a(webView, "custom", jSONObject4);
                    }
                }
                if (map3 != null && !map3.isEmpty()) {
                    for (String str4 : map3.keySet()) {
                        JSONArray jSONArray = (JSONArray) map3.get(h.f(str4));
                        JSONObject jSONObject6 = (map == null || map.isEmpty()) ? new JSONObject() : (JSONObject) map.get((String) hVar.g.get(h.f(str4)));
                        String strH14 = S0.b.h1("bid", jSONObject6);
                        String strH15 = S0.b.h1(Constants.PARAM_PID, jSONObject6);
                        if (jSONArray == null || jSONArray.length() <= 0) {
                            break;
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                obj = jSONArray.opt(i);
                            } catch (Exception unused19) {
                                obj = new Object();
                            }
                            if (obj instanceof JSONObject) {
                                JSONObject jSONObject7 = (JSONObject) obj;
                                try {
                                    jSONObject7.put("bid", strH14);
                                } catch (Exception unused20) {
                                }
                                try {
                                    jSONObject7.put(Constants.PARAM_PID, strH15);
                                } catch (Exception unused21) {
                                }
                                hVar.a(webView, "custom", jSONObject7);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // F.d
    public void reportDirectly(WebView webView, String str, String str2) {
        String strOptString = S0.b.l0(str2).optString(BffConstant.Type.Url, "");
        if (TextUtils.isEmpty(strOptString)) {
            h hVarD = D(webView);
            if (hVarD != null) {
                hVarD.a(webView, str, S0.b.l0(str2));
                hVarD.b(str);
                return;
            }
            return;
        }
        h hVarE = E(webView, strOptString);
        if (hVarE != null) {
            hVarE.a(webView, str, S0.b.l0(str2));
            hVarE.b(str);
        }
    }

    @Override // F.d
    public void s(WebView webView, String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", "nativeError");
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("error_code", i);
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("error_msg", str2);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("scene", "requestMainFrame");
        } catch (Exception unused4) {
        }
        h hVarE = E(webView, str);
        if (hVarE != null) {
            if (!TextUtils.isEmpty("nativeError")) {
                String strMapService = WebViewMonitorHelper.b.mapService(webView, "nativeError");
                if (!TextUtils.equals("nativeError", strMapService) && !TextUtils.isEmpty(strMapService)) {
                    try {
                        jSONObject.put(NotificationCompat.CATEGORY_SERVICE, strMapService);
                    } catch (Exception unused5) {
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("nativeInfo", jSONObject);
                } catch (JSONException unused6) {
                }
                hVarE.d(jSONObject2);
                WebViewMonitorHelper.b.getMonitor(webView).c(jSONObject2);
            }
            hVarE.b("nativeError");
        }
    }

    @Override // F.d
    public void t(WebView webView, String str, String str2, String str3, String str4) {
        h hVarD = D(webView);
        if (hVarD != null) {
            if (TextUtils.isEmpty(str)) {
                str = hVarD.i;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put("client_category", S0.b.l0(str2));
                } catch (JSONException unused) {
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                try {
                    jSONObject.put("client_metric", S0.b.l0(str3));
                } catch (JSONException unused2) {
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject.put("client_extra", S0.b.l0(str4));
                } catch (JSONException unused3) {
                }
            }
            JSONObject jSONObject2 = hVarD.d;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            try {
                jSONObject2.put("ev_type", "custom");
            } catch (Exception unused4) {
            }
            if (TextUtils.isEmpty(str)) {
                h.c("client_category", jSONObject2, jSONObject);
                h.c("client_metric", jSONObject2, jSONObject);
                h.c("client_extra", jSONObject2, jSONObject);
                hVarD.d = jSONObject2;
                return;
            }
            Map linkedHashMap = hVarD.b;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            try {
                jSONObject2.put(BffConstant.Type.Url, str);
            } catch (Exception unused5) {
            }
            h.c("client_category", jSONObject2, jSONObject);
            h.c("client_metric", jSONObject2, jSONObject);
            h.c("client_extra", jSONObject2, jSONObject);
            linkedHashMap.put(h.f(str), jSONObject2);
            hVarD.b = linkedHashMap;
        }
    }

    public String toString() {
        switch (this.f506a) {
            case 3:
                return "";
            default:
                return super.toString();
        }
    }

    @Override // F.d
    public void u() {
        try {
            new JSONObject().put("event_type", "jsbError");
        } catch (Exception unused) {
        }
        throw null;
    }

    @Override // F.d
    public void v(WebView webView) {
        h hVarD = D(webView);
        if (hVarD == null || hVarD.f511s != 0) {
            return;
        }
        hVarD.f511s = System.currentTimeMillis();
    }

    @Override // z3.G
    public String w() {
        return (String) this.c;
    }

    @Override // z3.G
    public boolean x(JsonNode jsonNode) {
        JsonNode jsonNode2 = (JsonNode) this.b;
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.NEGATIVE_INFINITY) {
            return false;
        }
        if (jsonNode2.isDouble() && jsonNode2.doubleValue() == Double.POSITIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.NEGATIVE_INFINITY) {
            return true;
        }
        if (jsonNode.isDouble() && jsonNode.doubleValue() == Double.POSITIVE_INFINITY) {
            return false;
        }
        int iCompareTo = new BigDecimal(jsonNode.asText()).compareTo(new BigDecimal((String) this.c));
        return iCompareTo < 0 || iCompareTo == 0;
    }

    public void y(String str) {
        StackTraceElement stackTraceElement;
        switch (this.f506a) {
            case 2:
                HashSet hashSet = (HashSet) this.c;
                if (((i) this.b) != null && !hashSet.contains(str)) {
                    hashSet.add(str);
                    i iVar = (i) this.b;
                    String strConcat = "apm_".concat(str);
                    iVar.getClass();
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace != null) {
                        try {
                            if (stackTrace.length > 4 && (stackTraceElement = stackTrace[3]) != null) {
                                String className = stackTraceElement.getClassName();
                                String methodName = stackTraceElement.getMethodName();
                                int lineNumber = stackTraceElement.getLineNumber();
                                String strS = S0.b.s(stackTrace);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("event_type", "exception");
                                jSONObject.put("timestamp", System.currentTimeMillis());
                                jSONObject.put("class_ref", className);
                                jSONObject.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, methodName);
                                jSONObject.put("line_num", lineNumber);
                                jSONObject.put("stack", strS);
                                jSONObject.put("exception_type", 1);
                                jSONObject.put("is_core", 1);
                                if (!TextUtils.isEmpty(strConcat)) {
                                    if (strConcat.length() > 1024) {
                                        jSONObject.put("message", strConcat.substring(0, 1024));
                                    } else {
                                        jSONObject.put("message", strConcat);
                                    }
                                }
                                S0.b.U(jSONObject);
                                t1.a.a().b(jSONObject.toString(), strConcat, true);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (H.h.b && str.length() != 0) {
                    if (str.length() <= 3072) {
                        Log.e("apm_", str);
                        break;
                    } else {
                        while (str.length() > 3072) {
                            String strSubstring = str.substring(0, 3072);
                            str = str.replace(strSubstring, "");
                            Log.e("apm_", strSubstring);
                        }
                        Log.e("apm_", str);
                        break;
                    }
                }
                break;
            default:
                M.b bVar = (M.b) this.b;
                bVar.write("\"");
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt == '\f') {
                        bVar.write("\\f");
                    } else if (cCharAt == '\r') {
                        bVar.write("\\r");
                    } else if (cCharAt != '\"' && cCharAt != '/' && cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                bVar.write("\\b");
                                break;
                            case '\t':
                                bVar.write("\\t");
                                break;
                            case '\n':
                                bVar.write("\\n");
                                break;
                            default:
                                if (cCharAt <= 31) {
                                    bVar.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                                    break;
                                } else {
                                    bVar.write(cCharAt);
                                    break;
                                }
                        }
                    } else {
                        bVar.write(92);
                        bVar.write(cCharAt);
                    }
                }
                bVar.write("\"");
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(java.lang.String r11, java.lang.Throwable r12) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F.g.z(java.lang.String, java.lang.Throwable):void");
    }

    public /* synthetic */ g(int i, Object obj, Object obj2) {
        this.f506a = i;
        this.b = obj;
        this.c = obj2;
    }

    public g(M.b bVar) {
        this.f506a = 3;
        this.c = new ArrayList();
        this.b = bVar;
    }

    public g(C1860l c1860l, InterfaceC1855g interfaceC1855g) {
        this.f506a = 8;
        this.c = c1860l;
        this.b = interfaceC1855g;
    }
}
