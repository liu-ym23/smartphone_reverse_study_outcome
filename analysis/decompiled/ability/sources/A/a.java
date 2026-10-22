package A;

import H.h;
import H.k;
import H4.o;
import P.e;
import Va.l;
import Va.n;
import a.AbstractC0291a;
import a0.C0296e;
import a2.AbstractC0299a;
import a2.InterfaceC0300b;
import android.app.Activity;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import c0.C0868b;
import ca.AbstractC0897f;
import com.apm.insight.CrashType;
import com.apm.insight.g;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import com.bytedance.apm.insight.IDynamicParams;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import g1.AbstractC1451a;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import kotlin.coroutines.EmptyCoroutineContext;
import m0.C1668b;
import m9.AbstractC1683A;
import m9.C1703V;
import m9.C1718k;
import n3.InterfaceFutureC1739a;
import n9.C1748d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s9.f;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.C2005u;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.r;
import v9.C2072a;
import v9.InterfaceC2075d;
import w0.AbstractC2092m;
import w0.C2093n;
import w2.AbstractC2095a;
import w2.i;
import z.AbstractC2152a;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f64a;
    public Object b;
    public final Object c;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.f64a = i;
        this.c = obj;
        this.b = obj2;
    }

    private final void a() {
        f fVar = (f) this.c;
        int i = 0;
        while (true) {
            try {
                ((Runnable) this.b).run();
            } catch (Throwable th) {
                AbstractC1683A.k(EmptyCoroutineContext.f4908a, th);
            }
            Runnable runnableE = fVar.E();
            if (runnableE == null) {
                return;
            }
            this.b = runnableE;
            i++;
            if (i >= 16 && fVar.b.isDispatchNeeded(fVar)) {
                fVar.b.dispatch(fVar, this);
                return;
            }
        }
    }

    private final void c() {
        View view = (View) this.b;
        if (view == null || view.getWindowToken() == null || !((C2005u) this.c).f6632B.g()) {
            return;
        }
        view.setAlpha(0.2f);
    }

    private final void d() {
        r rVar = (r) this.b;
        C2005u c2005u = (C2005u) this.c;
        n nVar = c2005u.c;
        l lVar = nVar.d;
        if (lVar != null) {
            lVar.k(nVar);
        }
        View view = (View) c2005u.h;
        if (view != null && view.getWindowToken() != null && rVar.h()) {
            c2005u.f6631A = rVar;
            c2005u.i.setAlpha(0.2f);
        }
        c2005u.f6633C = null;
    }

    private final void e() {
        w2.l.b(this.b, (n2.d) this.c);
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ScheduledFuture scheduledFuture;
        u1.d dVar;
        boolean zD;
        boolean zF = false;
        switch (this.f64a) {
            case 0:
                Process.setThreadPriority(10);
                b bVar = ((c) this.c).b;
                if (bVar != null) {
                    bVar.e(Thread.currentThread().getId());
                }
                try {
                    Runnable runnable = (Runnable) this.b;
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    AbstractC2152a.f6923a.getClass();
                    return;
                }
            case 1:
                try {
                    WebViewMonitorHelper webViewMonitorHelper = (WebViewMonitorHelper) this.c;
                    WebView webView = (WebView) this.b;
                    ITTLiveWebViewMonitorHelper iTTLiveWebViewMonitorHelper = WebViewMonitorHelper.f2211a;
                    webViewMonitorHelper.a(webView, true);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            case 2:
                if (((C0.d) this.c).f278q == null && AbstractC1451a.f4467a) {
                    Log.d("APM-Traffic-Detail", U7.a.e(new String[]{"stopMetric config==null:"}));
                }
                Map map = ((C0.d) this.c).e;
                if (map == null || !map.containsKey((String) this.b)) {
                    if (AbstractC1451a.f4467a) {
                        Log.d("APM-Traffic-Detail", U7.a.e(new String[]{B7.a.q(new StringBuilder("stopMetric metric("), (String) this.b, ") not found")}));
                        return;
                    }
                    return;
                }
                long jLongValue = ((Long) ((M.c) ((C0.d) this.c).e.get((String) this.b)).f950a).longValue();
                long jG = ((E0.a) ((C0.d) this.c).p.b).g() - ((Long) ((M.c) ((C0.d) this.c).e.get((String) this.b)).b).longValue();
                long jD = ((E0.a) ((C0.d) this.c).p.b).d() - ((Long) ((M.c) ((C0.d) this.c).f.get((String) this.b)).b).longValue();
                long jC = ((E0.a) ((C0.d) this.c).p.b).c() - ((Long) ((M.c) ((C0.d) this.c).g.get((String) this.b)).b).longValue();
                ((C0.d) this.c).e.remove((String) this.b);
                ((C0.d) this.c).f.remove((String) this.b);
                ((C0.d) this.c).g.remove((String) this.b);
                if (jG < 0) {
                    if (AbstractC1451a.f4467a) {
                        Log.d("APM-Traffic-Detail", U7.a.e(new String[]{"stopMetric metric(" + ((String) this.b) + ") metricValue < 0:" + jG}));
                    }
                    ((B0.b) A0.a.f67a.b).l((String) this.b);
                    return;
                }
                Map mapC = ((B0.b) A0.a.f67a.b).c((String) this.b);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("init_ts", jLongValue);
                    jSONObject3.put("usage_ts", System.currentTimeMillis());
                    if (mapC != null && mapC.size() > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        try {
                            Iterator it = mapC.entrySet().iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObjectA = ((B0.a) ((Map.Entry) it.next()).getValue()).a();
                                Iterator it2 = it;
                                jSONObjectA.put("traffic_category", (String) this.b);
                                jSONArray.put(jSONObjectA);
                                it = it2;
                            }
                            jSONObject4.put("usage", jSONArray);
                            jSONObject3.put("detail", jSONObject4);
                        } catch (JSONException unused3) {
                        }
                    }
                    ((B0.b) A0.a.f67a.b).l((String) this.b);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put((String) this.b, jG);
                    jSONObject5.put(((String) this.b) + "$wifi", jD);
                    jSONObject5.put(((String) this.b) + "$mobile", jC);
                    try {
                        jSONObject3.put("log_type", "performance_monitor");
                        jSONObject3.put(NotificationCompat.CATEGORY_SERVICE, "traffic");
                        if (!S0.b.s0(jSONObject5)) {
                            jSONObject3.put("extra_values", jSONObject5);
                        }
                        if (TextUtils.equals("start", "traffic") && TextUtils.equals(TypedValues.TransitionType.S_FROM, jSONObject3.optString("monitor-plugin"))) {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("start_mode", h.i);
                        } else {
                            jSONObject2 = null;
                        }
                        if (!S0.b.s0(jSONObject2)) {
                            jSONObject3.put("extra_status", jSONObject2);
                        }
                        jSONObject = jSONObject3;
                    } catch (JSONException unused4) {
                        jSONObject = null;
                    }
                    R0.b bVar2 = new R0.b("performance_monitor", jSONObject);
                    if (((C0.d) this.c).f278q != null) {
                        C0.d.d(bVar2, ((C0.d) this.c).f278q.f370a, (String) this.b);
                        return;
                    }
                    ((C0.d) this.c).c.a(bVar2);
                    ((C0.d) this.c).d.a((String) this.b);
                    if (AbstractC1451a.f4467a) {
                        Log.d("APM-Traffic-Detail", U7.a.e(new String[]{"config==null:"}));
                        return;
                    }
                    return;
                } catch (Exception e) {
                    k.f723a.z("apm_error", e);
                    return;
                }
            case 3:
                O.a aVarG = O.a.g();
                B0.f fVar = (B0.f) this.b;
                String str = (String) fVar.f177a;
                JSONObject jSONObject6 = (JSONObject) fVar.c;
                JSONObject jSONObject7 = (JSONObject) this.c;
                P.c cVar = new P.c();
                cVar.f1055a = str;
                cVar.b = 0;
                cVar.c = null;
                cVar.d = jSONObject6;
                cVar.e = null;
                cVar.f = jSONObject7;
                aVarG.c(cVar);
                return;
            case 4:
                I1.a aVar = (I1.a) this.c;
                aVar.d.getClass();
                boolean zD2 = F1.b.b().d();
                if (zD2 && (scheduledFuture = aVar.e) != null && !scheduledFuture.isCancelled()) {
                    U7.a.j("canAnalyse, so cancel check", new Object[0]);
                    aVar.e.cancel(false);
                    aVar.f791a = true;
                }
                if (zD2 || aVar.c || aVar.b) {
                    return;
                }
                aVar.d.getClass();
                if (!D1.a.b().a()) {
                    if (System.currentTimeMillis() - H1.c.d().e().getLong("lastDumpTime", 0L) < 28800000) {
                        return;
                    }
                }
                if (Z6.k.c() >= ((cc.dd.hh.hh.a) this.b).b) {
                    ((I1.a) this.c).c = true;
                    ((I1.a) this.c).d.getClass();
                    F1.c.e().a(System.currentTimeMillis());
                    U7.a.j("begin dumpHeap", new Object[0]);
                    return;
                }
                return;
            case 5:
                try {
                    JSONObject jSONObject8 = new JSONObject();
                    IDynamicParams iDynamicParams = (IDynamicParams) this.b;
                    String userId = iDynamicParams != null ? iDynamicParams.getUserId() : "";
                    if (!TextUtils.isEmpty(userId)) {
                        jSONObject8.put("user_id", userId);
                    }
                    Q1.a.i = ((ApmInsightInitConfig) this.c).getAid();
                    AbstractC1451a.o(jSONObject8);
                    AbstractC1451a.j(jSONObject8);
                    IDynamicParams iDynamicParams2 = (IDynamicParams) this.b;
                    if (iDynamicParams2 != null) {
                        try {
                            jSONObject8.put("user_unique_id", iDynamicParams2.getUserUniqueID());
                        } catch (Exception unused5) {
                        }
                        try {
                            jSONObject8.put("ab_sdk_version", ((IDynamicParams) this.b).getAbSdkVersion());
                        } catch (Exception unused6) {
                        }
                        try {
                            jSONObject8.put("ssid", ((IDynamicParams) this.b).getSsid());
                        } catch (Exception unused7) {
                        }
                    }
                    S0.b.q0(jSONObject8, ((ApmInsightInitConfig) this.c).getHeader());
                    h.d = jSONObject8;
                    try {
                        S0.b.q0(h.c, jSONObject8);
                        return;
                    } catch (JSONException unused8) {
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            case 6:
                ((N.a) this.c).e((N.b) this.b);
                return;
            case 7:
                Q1.a aVar2 = (Q1.a) this.c;
                String str2 = (String) this.b;
                if (TextUtils.isEmpty(str2)) {
                    dVar = null;
                } else {
                    try {
                        dVar = new u1.d(8, zF);
                        JSONObject jSONObject9 = new JSONObject(str2);
                        dVar.d = jSONObject9.optString("command_id");
                        dVar.c = jSONObject9.optString("type");
                        String strOptString = jSONObject9.optString("params");
                        JSONObject jSONObject10 = new JSONObject();
                        if (!TextUtils.isEmpty(strOptString)) {
                            jSONObject10 = new JSONObject(strOptString);
                        }
                        dVar.b = strOptString;
                        dVar.e = jSONObject10;
                    } catch (Exception unused9) {
                    }
                }
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"handleCloudMessageInternal cloudMessage=" + dVar}));
                }
                if (dVar == null) {
                    return;
                }
                Iterator it3 = aVar2.f1096a.iterator();
                while (it3.hasNext()) {
                    AbstractC0299a abstractC0299a = (AbstractC0299a) ((InterfaceC0300b) it3.next());
                    synchronized (abstractC0299a) {
                        try {
                            if (abstractC0299a.a().equals((String) dVar.c)) {
                                if (AbstractC0299a.b(dVar) && abstractC0299a.c(dVar)) {
                                    if (R1.b.b(abstractC0299a.f1636a).c.b) {
                                        AbstractC0291a.m("start handle message:" + dVar);
                                    }
                                    zD = abstractC0299a.d(dVar);
                                } else if (R1.b.b(abstractC0299a.f1636a).c.b) {
                                    AbstractC0291a.m("checkCmdInterval false: ignored for now.");
                                }
                            }
                        } catch (Exception e6) {
                            StringWriter stringWriter = new StringWriter();
                            e6.printStackTrace(new PrintWriter(stringWriter));
                            String str3 = "系统错误：" + stringWriter.toString();
                            J9.k kVar = new J9.k(abstractC0299a.f1636a, (String) dVar.d, null);
                            kVar.b = 3;
                            kVar.e = str3;
                            S1.a.a(kVar);
                        } finally {
                        }
                        zD = false;
                    }
                    if (zD) {
                        return;
                    }
                }
                return;
            case 8:
                C0296e c0296e = (C0296e) this.c;
                try {
                    JSONObject jSONObject11 = new JSONObject();
                    C2093n c2093n = AbstractC2092m.f6826a;
                    jSONObject11.put("battery_temperature", c2093n.d);
                    jSONObject11.put("capacity_all", S0.b.v0());
                    jSONObject11.put("capacity_pct", c2093n.f);
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("scene", (String) this.b);
                    jSONObject12.put("is_front", !c0296e.b);
                    c0296e.a(new e(LlmRuntimeArgsBundle.KEY_TEMPERATURE, "", "", jSONObject11, jSONObject12, null));
                    Log.d("ApmInsight", U7.a.e(new String[]{LlmRuntimeArgsBundle.KEY_TEMPERATURE}));
                    return;
                } catch (Exception unused10) {
                    return;
                }
            case 9:
                C0868b c0868b = (C0868b) this.c;
                C1668b c1668b = (C1668b) this.b;
                if (h.b) {
                    Log.i("<monitor><battery>", U7.a.e(new String[]{"record batteryLog: " + c1668b.toString() + " , mReportedInMainProcess: " + c0868b.f2068a}));
                }
                if (!c0868b.f2068a && h.g()) {
                    c1668b.f = (String) c0868b.b;
                    synchronized (((LinkedList) c0868b.e)) {
                        try {
                            if (((LinkedList) c0868b.e).size() > 100) {
                                ((LinkedList) c0868b.e).poll();
                            }
                            ((LinkedList) c0868b.e).add(c1668b);
                        } finally {
                        }
                    }
                    return;
                }
                if (TextUtils.isEmpty((String) c0868b.c)) {
                    c0868b.c = String.valueOf(System.currentTimeMillis());
                }
                c1668b.k = h.g();
                c1668b.f5293j = h.c();
                c1668b.l = (String) c0868b.c;
                if (TextUtils.isEmpty(c1668b.f)) {
                    c1668b.f = (String) c0868b.b;
                }
                try {
                    if (h.b) {
                        Log.i("<monitor><battery>", U7.a.e(new String[]{"saveBatteryLog into db: " + c1668b}));
                    }
                    c0868b.b().k(c1668b);
                    return;
                } catch (Exception unused11) {
                    return;
                }
            case 10:
                try {
                    Window window = ((Activity) this.b).getWindow();
                    if (window != null) {
                        window.setSoftInputMode(((Integer) this.c).intValue());
                        return;
                    }
                    return;
                } catch (Exception unused12) {
                    return;
                }
            case 11:
                com.stepos.statsrpk.service.e eVar = (com.stepos.statsrpk.service.e) this.c;
                String str4 = (String) this.b;
                W5.c.a("a", "environmentChanged. changeName: ".concat(str4));
                ArrayList arrayListD = eVar.b.d();
                if ("CHANGE_NAME_NETWORKCONNECT".equals(str4)) {
                    Iterator it4 = arrayListD.iterator();
                    while (it4.hasNext()) {
                        eVar.c((String) it4.next());
                    }
                    return;
                } else {
                    if ("CHANGE_NAME_POWER".equals(str4)) {
                        Iterator it5 = arrayListD.iterator();
                        while (it5.hasNext()) {
                            eVar.c((String) it5.next());
                        }
                        return;
                    }
                    return;
                }
            case 12:
                i iVarA = i.a();
                F1.b bVar3 = (F1.b) this.b;
                String str5 = (String) bVar3.e;
                String str6 = (String) bVar3.d;
                String str7 = (String) bVar3.f;
                List list = (List) bVar3.g;
                iVarA.getClass();
                if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7) && list != null && list.size() != 0) {
                    try {
                        zF = AbstractC2095a.f(g.g.getAlogUploadUrl(), str5, str6, str7, list);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                S0.b.N("upload ALog " + ((List) bVar3.g));
                if (zF) {
                    M.a.s((String) this.c);
                    return;
                }
                return;
            case 13:
                ((C1718k) this.c).G((C1703V) this.b);
                return;
            case 14:
                ((C1718k) this.b).G((C1748d) this.c);
                return;
            case 15:
                U7.a.I((H7.c) this.b).resumeWith(kotlin.b.a((Throwable) this.c));
                return;
            case 16:
                C1718k c1718k = (C1718k) this.c;
                InterfaceFutureC1739a interfaceFutureC1739a = (InterfaceFutureC1739a) this.b;
                if (interfaceFutureC1739a.isCancelled()) {
                    c1718k.l(null);
                    return;
                }
                try {
                    c1718k.resumeWith(AbstractC0897f.D(interfaceFutureC1739a));
                    return;
                } catch (ExecutionException e9) {
                    Throwable cause = e9.getCause();
                    kotlin.jvm.internal.k.c(cause);
                    c1718k.resumeWith(kotlin.b.a(cause));
                    return;
                }
            case 17:
                Process.setThreadPriority(10);
                try {
                    ((Runnable) this.b).run();
                    return;
                } catch (Throwable th3) {
                    o.g("APM-AsyncTask", "SingleThreadFactory error when running in thread " + ((String) ((E1.b) this.c).b), th3);
                    return;
                }
            case 18:
                a();
                return;
            case 19:
                ActionBarCoordinatorLayout.e((ActionBarCoordinatorLayout) this.c, (StepOSRecyclerView) this.b);
                return;
            case 20:
                c();
                return;
            case 21:
                d();
                return;
            case 22:
                ((InterfaceC2075d) this.b).g((C2072a) this.c, C7.r.f317a);
                return;
            case 23:
                e();
                return;
            default:
                if (com.stepos.statsrpk.d.l(g.f2160a)) {
                    String str8 = (String) this.b;
                    com.apm.insight.d dVar2 = (com.apm.insight.d) this.c;
                    h2.c cVar2 = z2.l.g;
                    if (cVar2 != null) {
                        cVar2.stopWatching();
                    }
                    h2.c cVar3 = new h2.c(str8, dVar2, str8);
                    z2.l.g = cVar3;
                    cVar3.startWatching();
                    return;
                }
                return;
        }
    }

    public /* synthetic */ a(int i, Object obj, boolean z10, Object obj2) {
        this.f64a = i;
        this.b = obj;
        this.c = obj2;
    }

    public a(F1.b bVar, CrashType crashType, String str) {
        this.f64a = 12;
        this.b = bVar;
        this.c = str;
    }
}
