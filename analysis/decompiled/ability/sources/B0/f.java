package B0;

import F9.C0234l;
import H.h;
import H4.o;
import X8.K;
import android.app.Application;
import android.content.Intent;
import android.os.RemoteException;
import androidx.autofill.HintConstants;
import b7.InterfaceC0827a;
import com.bytedance.apm6.traffic.TrafficTransportService;
import g1.AbstractC1451a;
import h2.C1483a;
import h2.RunnableC1484b;
import h8.InterfaceC1507O;
import h8.InterfaceC1519b;
import h8.InterfaceC1524g;
import i1.C1552a;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import k1.AbstractC1620b;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;
import z2.l;

/* loaded from: classes2.dex */
public final class f implements b, C0.a, Y8.c, InterfaceC0827a {
    public static long d;

    /* renamed from: a, reason: collision with root package name */
    public Object f177a;
    public boolean b;
    public Object c;

    public f(C1483a c1483a) {
        this.b = false;
        RunnableC1484b runnableC1484b = new RunnableC1484b(this, 0);
        this.c = runnableC1484b;
        this.f177a = c1483a;
        l.i().b(runnableC1484b, 5000L);
    }

    public static void n(String str) {
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.d dVar;
        try {
            W5.c.a("ConfigController", "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            W5.c.a("ConfigController", "parseConfigJson 2, config json:" + jSONObject);
            W5.c.a("ConfigController", "parseAndApply, version: " + jSONObject.getInt("version"));
            boolean z10 = jSONObject.getBoolean("active");
            JSONObject jSONObject2 = jSONObject.getJSONObject("uploadPolicy");
            boolean z11 = jSONObject2.getBoolean("onStart");
            boolean z12 = jSONObject2.getBoolean("onCharge");
            boolean z13 = jSONObject2.getBoolean("onReconnect");
            long j5 = jSONObject2.getLong("interval") * 60000;
            int i = jSONObject2.getInt("cacheCapacity");
            long j6 = jSONObject2.getLong("mobileQuota");
            int i6 = jSONObject2.getInt("neartimeInterval");
            R5.d dVar2 = O5.c.f1037a.d;
            if (dVar2 == null) {
                W5.c.b("SDKInstanceImpl", "getEmitter fail, tracker is null");
                dVar = null;
            } else {
                dVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.d) dVar2.c;
            }
            dVar.b(z10, z11, z12, z13, j5, i, j6, i6);
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                String string = jSONObject3.getString(HintConstants.AUTOFILL_HINT_NAME);
                map.put(string, new R5.a(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean("neartime")));
            }
            R5.d dVar3 = O5.c.f1037a.d;
            if (dVar3 != null) {
                dVar3.a(map);
            }
        } catch (Exception e) {
            W5.c.b("ConfigController", "parseAndApply error, " + e.getMessage());
        }
    }

    @Override // B0.b
    public void a() {
        if (h.b) {
            o.r("APM-Traffic-Detail", "SubBiz start called");
        }
        this.b = true;
        e eVar = new e(this);
        Application application = h.f711a;
        int i = TrafficTransportService.b;
        application.bindService(new Intent(application, (Class<?>) TrafficTransportService.class), eVar, 1);
        int i6 = O.c.p;
        O.c cVar = O.b.f1029a;
        c cVar2 = (c) this.c;
        if (cVar.n.contains(cVar2)) {
            return;
        }
        cVar.n.add(cVar2);
    }

    @Override // B0.b
    public long b() {
        return 0L;
    }

    @Override // B0.b
    public Map c() {
        return null;
    }

    @Override // B0.b
    public void clear() {
    }

    @Override // B0.b
    public Map d() {
        return null;
    }

    @Override // Y8.c
    public boolean e(K c12, K c2) {
        boolean z10 = this.b;
        InterfaceC1519b interfaceC1519b = (InterfaceC1519b) this.f177a;
        InterfaceC1519b interfaceC1519b2 = (InterfaceC1519b) this.c;
        k.f(c12, "c1");
        k.f(c2, "c2");
        if (c12.equals(c2)) {
            return true;
        }
        InterfaceC1524g interfaceC1524gD = c12.d();
        InterfaceC1524g interfaceC1524gD2 = c2.d();
        if (!(interfaceC1524gD instanceof InterfaceC1507O) || !(interfaceC1524gD2 instanceof InterfaceC1507O)) {
            return false;
        }
        J8.b bVar = new J8.b(interfaceC1519b, interfaceC1519b2);
        return J8.c.f882a.c((InterfaceC1507O) interfaceC1524gD, (InterfaceC1507O) interfaceC1524gD2, z10, bVar);
    }

    @Override // B0.b
    public Map f() {
        return null;
    }

    @Override // B0.b
    public Map g() {
        return null;
    }

    @Override // B0.b
    public Map h() {
        return null;
    }

    @Override // C0.a
    public void i(D0.a aVar) {
        if (AbstractC1451a.f4467a) {
            o.r("APM-Traffic-Detail", "SubCollector updateConfig: " + aVar.b);
        }
        if (aVar.b) {
            ((b) A0.a.f67a.b).a();
        }
    }

    @Override // C0.a
    public void j(boolean z10, boolean z11) {
        if (this.b) {
            return;
        }
        this.b = true;
        AbstractC1620b.a(C1552a.class);
        Application application = AbstractC1451a.b;
        C0.e eVar = (C0.e) this.c;
        int i = TrafficTransportService.b;
        application.bindService(new Intent(application, (Class<?>) TrafficTransportService.class), eVar, 1);
    }

    @Override // B0.b
    public void k(long j5, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        String string;
        if (((cc.dd.ee.jj.a) this.f177a) != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            String string2 = jSONObject2 != null ? jSONObject2.toString() : "";
            ((cc.dd.ee.jj.a) this.f177a).a(j5, str, str2, str3, string, string2);
            if (h.b) {
                o.r("APM-Traffic-Detail", "SubBiz trafficStats(trafficBytes=" + j5 + ", sourceId=" + str + ", business=" + str2 + ", scene=" + str3 + ", extraStatus=" + string + ", extraLog=" + string2);
            }
        }
    }

    @Override // B0.b
    public void l(String str) {
    }

    @Override // B0.b
    public void m(double d6) {
    }

    @Override // B0.b
    public void o(double d6) {
    }

    @Override // B0.b
    public Map q() {
        return null;
    }

    @Override // B0.b
    public void s(String str, JSONObject jSONObject) {
        String string;
        if (((cc.dd.ee.jj.a) this.f177a) != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            ((cc.dd.ee.jj.a) this.f177a).a(str, string);
            if (h.b) {
                o.r("APM-Traffic-Detail", "SubBiz httpApiTrafficStats url=" + str + ", extJson=" + string);
            }
        }
    }

    public f(int i) {
        switch (i) {
            case 1:
                this.b = false;
                this.c = new C0.e(this);
                break;
            default:
                this.b = false;
                this.c = new c(this, 1);
                break;
        }
    }

    @Override // B0.b
    public void b(String str) {
        cc.dd.ee.jj.a aVar = (cc.dd.ee.jj.a) this.f177a;
        if (aVar != null) {
            try {
                aVar.b(str);
                if (h.b) {
                    o.r("APM-Traffic-Detail", "SubBiz initCustomMetricBizTrafficStats " + str);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // B0.b
    public Map c(String str) {
        return null;
    }

    @Override // B0.b
    public void c(JSONObject jSONObject) {
        String string;
        if (((cc.dd.ee.jj.a) this.f177a) != null) {
            if (jSONObject != null) {
                try {
                    string = jSONObject.toString();
                } catch (RemoteException unused) {
                    return;
                }
            } else {
                string = "";
            }
            ((cc.dd.ee.jj.a) this.f177a).c(string);
            if (h.b) {
                o.r("APM-Traffic-Detail", "SubBiz httpImageApiTrafficStats extJson=" + string);
            }
        }
    }

    public f(C0234l c0234l) {
        this.b = c0234l.f649a;
        this.f177a = (Q.a) c0234l.c;
        this.c = (F1.c) c0234l.d;
        boolean z10 = c0234l.b;
        h.b = z10;
        AbstractC1451a.f4467a = z10;
    }

    @Override // C0.a
    public void a(String str, boolean z10) {
        cc.dd.ee.jj.a aVar = (cc.dd.ee.jj.a) this.f177a;
        if (aVar != null) {
            try {
                aVar.a(str, z10);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // C0.a
    public void a(String str) {
        cc.dd.ee.jj.a aVar = (cc.dd.ee.jj.a) this.f177a;
        if (aVar != null) {
            try {
                aVar.a(str);
            } catch (RemoteException unused) {
            }
        }
    }

    public f(Locale locale, Predicate predicate, boolean z10) {
        this.f177a = locale;
        this.c = predicate;
        this.b = z10;
    }
}
