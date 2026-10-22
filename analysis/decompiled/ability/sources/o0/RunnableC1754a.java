package o0;

import D8.j;
import F.g;
import H.h;
import Z6.k;
import a2.InterfaceC0300b;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import b2.C0822a;
import com.apmplus.hybrid.webview.HybridMonitorManager;
import com.bytedance.android.monitor.webview.WebViewMonitorHelper;
import com.bytedance.apm.impl.net.UserHttpServiceImpl;
import com.bytedance.apm.insight.ApmInsight;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import com.bytedance.apm.insight.IDynamicParams;
import e2.C1404a;
import e2.C1406c;
import j0.AbstractC1591a;
import j1.C1592a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import r0.AbstractC1874a;
import v0.C2054a;
import w0.C2085f;

/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1754a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5411a = 0;
    public final /* synthetic */ ApmInsightInitConfig b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ IDynamicParams d;
    public final /* synthetic */ ApmInsight e;

    public RunnableC1754a(ApmInsight apmInsight, Context context, ApmInsightInitConfig apmInsightInitConfig, IDynamicParams iDynamicParams) {
        this.e = apmInsight;
        this.c = context;
        this.b = apmInsightInitConfig;
        this.d = iDynamicParams;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException {
        switch (this.f5411a) {
            case 0:
                IDynamicParams iDynamicParams = this.d;
                ApmInsightInitConfig apmInsightInitConfig = this.b;
                Context context = this.c;
                ApmInsight apmInsight = this.e;
                if (ApmInsight.b) {
                    return;
                }
                int i = ((SharedPreferences) AbstractC1874a.f5670a.b).getInt("monitor_status_value", 0);
                if (i != 4) {
                    L0.f fVar = L0.d.f925a;
                    fVar.b(new RunnableC1754a(apmInsight, apmInsightInitConfig, iDynamicParams, context));
                    fVar.b(new e(apmInsight, apmInsightInitConfig, context, iDynamicParams));
                    boolean unused = ApmInsight.b = true;
                    return;
                }
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{B7.a.h(i, "stop report,status=")}));
                }
                L0.d.f925a.b(new e(apmInsight, apmInsightInitConfig, context, iDynamicParams));
                J2.c.f865a.d.registerConfigListener(new C1592a(this, 1));
                return;
            case 1:
                i0.c cVar = new i0.c();
                cVar.f4597a = AbstractC1591a.b;
                cVar.b = AbstractC1591a.c;
                cVar.c = AbstractC1591a.f;
                cVar.l = new JSONObject();
                cVar.o = new HashSet();
                cVar.p = 10L;
                cVar.g = 2500L;
                cVar.f4599q = new i0.b();
                cVar.d = false;
                try {
                    cVar.l.put("aid", this.b.getAid());
                } catch (JSONException unused2) {
                }
                cVar.d = this.b.isWithBlockDetect();
                cVar.h = this.b.enableBatteryMonitor();
                cVar.e = this.b.isWithSeriousBlockDetect();
                cVar.i = this.b.enableMemoryMonitor();
                cVar.b = this.b.getDefaultLogReportUrls();
                cVar.f4597a = this.b.getSlardarConfigUrls();
                cVar.c = this.b.getExceptionLogReportUrls();
                Context context2 = this.c;
                String str = "";
                try {
                    str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    cVar.l.put("app_version", str);
                } catch (JSONException unused3) {
                }
                Context context3 = this.c;
                String str2 = "";
                try {
                    str2 = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0).versionCode + "";
                } catch (PackageManager.NameNotFoundException e6) {
                    e6.printStackTrace();
                }
                try {
                    cVar.l.put("update_version_code", str2);
                } catch (JSONException unused4) {
                }
                try {
                    cVar.l.put("channel", this.b.getChannel());
                } catch (JSONException unused5) {
                }
                cVar.f4598j = this.b.enableCpuMonitor();
                cVar.k = this.b.enableDiskMonitor();
                cVar.f = this.b.enableTrafficMonitor();
                cVar.m = new C2054a(this);
                IDynamicParams iDynamicParams2 = this.d;
                if (iDynamicParams2 != null && !TextUtils.isEmpty(iDynamicParams2.getDid())) {
                    try {
                        cVar.l.put("device_id", this.d.getDid());
                    } catch (JSONException unused6) {
                    }
                }
                if (this.b.enableMemoryMonitor()) {
                    boolean z10 = h.b;
                    cc.dd.hh.hh.a aVar = new cc.dd.hh.hh.a();
                    aVar.f2146a = z10;
                    aVar.b = 90;
                    aVar.c = 1;
                    A1.b bVar = new A1.b();
                    bVar.e = aVar;
                    h.g();
                    cVar.o.add(bVar);
                }
                if (this.b.enableLogRecovery()) {
                    Q1.b bVar2 = new Q1.b();
                    bVar2.d = false;
                    Arrays.asList("timer", "count", "disk", "memory", "cpu", "fps", "traffic", "start", "page_load", "image_monitor", "network", "api_error", "common_log", "event_log", "performance_monitor", "ui_action");
                    if (h.g()) {
                        cVar.o.add(bVar2);
                    }
                    j jVar = new j();
                    if (Q1.a.h) {
                        for (InterfaceC0300b interfaceC0300b : Q1.a.b().f1096a) {
                            if (interfaceC0300b instanceof C0822a) {
                                ((C0822a) interfaceC0300b).c = jVar;
                            }
                        }
                    } else {
                        Q1.a.g = jVar;
                    }
                }
                if (this.b.getNetworkClient() != null) {
                    cVar.n = new UserHttpServiceImpl(new b(this));
                }
                if (TextUtils.isEmpty(cVar.l.optString("aid"))) {
                    throw new IllegalArgumentException("aid must not be empty");
                }
                S0.b.O(cVar.l.optString("app_version"), "app_version");
                S0.b.O(cVar.l.optString("update_version_code"), "update_version_code");
                S0.b.O(cVar.l.optString("device_id"), "device_id");
                i0.c cVar2 = new i0.c();
                cVar2.l = cVar.l;
                cVar2.m = cVar.m;
                cVar2.f4597a = cVar.f4597a;
                cVar2.n = cVar.n;
                cVar2.d = cVar.f;
                cVar2.e = cVar.d;
                cVar2.f = cVar.e;
                cVar2.g = cVar.g;
                cVar2.h = cVar.h;
                cVar2.o = cVar.o;
                cVar2.b = cVar.b;
                cVar2.c = cVar.c;
                cVar2.p = cVar.p;
                cVar2.f4599q = cVar.f4599q;
                cVar2.i = cVar.i;
                cVar2.k = cVar.f4598j;
                cVar2.f4598j = cVar.k;
                J2.d dVar = J2.c.f865a;
                if (!dVar.f) {
                    throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start(). If you have any questions, pls lark wangkai.android");
                }
                if (!dVar.g) {
                    L0.f fVar2 = L0.d.f925a;
                    fVar2.c = true;
                    if (fVar2.b != null && !fVar2.f.isEmpty()) {
                        fVar2.b.a(fVar2.d);
                        fVar2.b.b(fVar2.d, 30000L);
                    }
                    if (fVar2.b != null && !fVar2.g.isEmpty()) {
                        fVar2.b.a(fVar2.e);
                        fVar2.b.b(fVar2.e, L0.f.h);
                    }
                    dVar.g = true;
                    dVar.b = cVar2;
                    fVar2.b(new A1.a(17));
                }
                if (this.b.enableWebViewMonitor()) {
                    B2.a aVarBuildConfig = WebViewMonitorHelper.getInstance().buildConfig();
                    aVarBuildConfig.d = new C2085f(1);
                    if (g.d == null) {
                        synchronized (g.class) {
                            try {
                                if (g.d == null) {
                                    g gVar = new g(0);
                                    gVar.b = new WeakHashMap();
                                    gVar.c = new WeakHashMap();
                                    g.d = gVar;
                                }
                            } finally {
                            }
                        }
                    }
                    aVarBuildConfig.f182a = g.d;
                    aVarBuildConfig.f = true;
                    aVarBuildConfig.e = true;
                    aVarBuildConfig.f183j = "live";
                    aVarBuildConfig.g = true;
                    aVarBuildConfig.b = new String[]{WebView.class.getName()};
                    WebViewMonitorHelper.getInstance().addConfig(aVarBuildConfig);
                    WebViewMonitorHelper.getInstance().setDefaultConfig(aVarBuildConfig);
                }
                if (this.b.enableHybridMonitor()) {
                    HybridMonitorManager.getInstance().init(this.b.enableHybridMonitor());
                    return;
                }
                return;
            default:
                C1406c c1406c = new C1406c(this.b.getAid(), this.b.getToken(), this.b.getChannel());
                IDynamicParams iDynamicParams3 = this.d;
                if (iDynamicParams3 != null && !TextUtils.isEmpty(iDynamicParams3.getDid())) {
                    c1406c.l = this.d.getDid();
                }
                if (!TextUtils.isEmpty(h.f713q)) {
                    g gVar2 = new g(6);
                    StringBuilder sb = new StringBuilder();
                    sb.append(k.f);
                    gVar2.b = B7.a.q(sb, h.f713q, "/apm/device_register");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(k.f);
                    gVar2.c = new String[]{B7.a.q(sb2, h.f713q, "/monitor/collect/c/session")};
                    c1406c.f = new A5.c(gVar2);
                }
                c1406c.d = new A0.b(this, 6);
                C1404a.d(this.c, c1406c, null);
                ApmInsight apmInsight2 = this.e;
                String aid = this.b.getAid();
                C1404a c1404aC = C1404a.c(aid);
                w.b.c(c1404aC.b != null ? c1404aC.b.a() : "").f6799a.add(new f(apmInsight2, aid));
                return;
        }
    }

    public RunnableC1754a(ApmInsight apmInsight, ApmInsightInitConfig apmInsightInitConfig, Context context, IDynamicParams iDynamicParams) {
        this.e = apmInsight;
        this.b = apmInsightInitConfig;
        this.c = context;
        this.d = iDynamicParams;
    }

    public RunnableC1754a(ApmInsight apmInsight, ApmInsightInitConfig apmInsightInitConfig, IDynamicParams iDynamicParams, Context context) {
        this.e = apmInsight;
        this.b = apmInsightInitConfig;
        this.d = iDynamicParams;
        this.c = context;
    }
}
