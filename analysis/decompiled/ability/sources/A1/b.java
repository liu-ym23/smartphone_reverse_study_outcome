package A1;

import H.h;
import H.i;
import Z6.k;
import a.AbstractC0291a;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.Npth;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.slardar.config.IConfigManager;
import h2.d;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends i {
    public boolean b;
    public boolean c;
    public volatile boolean d;
    public cc.dd.hh.hh.a e;
    public volatile boolean f;
    public Context g;
    public volatile boolean h;
    public JSONObject i;

    public static List d(String str, List list) {
        try {
            if (!S0.b.a0(list)) {
                ArrayList arrayList = new ArrayList(2);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    String host = new URL((String) list.get(i)).getHost();
                    if (!TextUtils.isEmpty(host) && host.indexOf(46) > 0) {
                        arrayList.add(k.f + host + str);
                    }
                }
                return arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    @Override // H.i
    public final void a(Context context) {
        this.g = context;
        IConfigManager iConfigManager = (IConfigManager) L2.a.a(IConfigManager.class);
        if (iConfigManager != null) {
            iConfigManager.registerConfigListener(this);
        }
        D1.a.b().f371a = this.g;
        D1.a.b().f = this.e != null ? null : "";
        try {
            F1.b.b();
        } catch (Exception unused) {
            this.h = true;
        }
    }

    @Override // H.i
    public final void b(d dVar) {
        if (TextUtils.isEmpty(h.f713q)) {
            List list = (List) dVar.f4555a;
            if (list == null || list.size() <= 0) {
                return;
            }
            List listD = d("/monitor/collect/c/memory_upload_check?aid=%d&os=android", list);
            if (listD != null && listD.size() > 0) {
                C1.a.f281a = listD;
            }
            List listD2 = d("/monitor/collect/c/mom_dump_collect", list);
            if (listD2 == null || listD2.size() <= 0) {
                return;
            }
            C1.a.b = listD2;
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(k.f + h.f713q + "/monitor/collect/c/memory_upload_check?aid=%d&os=android");
        C1.a.f281a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(k.f + h.f713q + "/monitor/collect/c/mom_dump_collect");
        C1.a.b = arrayList2;
    }

    @Override // H.i, B.c
    /* renamed from: c */
    public final void mo0c() {
        if (this.f) {
            if ((this.b || this.c) && this.e.c == 2) {
                U7.a.j("onFront", new Object[0]);
                D1.a.b().c();
            }
        }
    }

    @Override // B.c
    public final void f(Activity activity) {
        if (this.f) {
            if ((this.b || this.c) && this.e.c == 2) {
                I1.a aVarA = I1.a.a();
                aVarA.getClass();
                U7.a.j("stopCheck", new Object[0]);
                aVarA.b = true;
                ScheduledFuture scheduledFuture = aVarA.e;
                if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                    return;
                }
                aVarA.e.cancel(false);
            }
        }
    }

    @Override // H.i, C.a
    public final void onRefresh(JSONObject jSONObject, boolean z10) {
        super.onRefresh(jSONObject, z10);
        if (this.h) {
            return;
        }
        U7.a.j("onRefresh run", new Object[0]);
        this.c = this.e.f2146a;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("performance_modules");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("memory");
            this.i = jSONObjectOptJSONObject2;
            if (jSONObjectOptJSONObject2 != null) {
                this.b = jSONObjectOptJSONObject2.optInt("enable_widget_memory", 0) == 1;
            }
        }
        if (this.b || this.c) {
            if (!this.f) {
                AbstractC0291a.f1622a = this.e.f2146a;
                IActivityLifeManager iActivityLifeManager = (IActivityLifeManager) L2.a.a(IActivityLifeManager.class);
                if (iActivityLifeManager != null) {
                    iActivityLifeManager.register(this);
                }
                JSONObject jSONObject2 = this.i;
                if (jSONObject2 != null) {
                    int iOptInt = jSONObject2.optInt("rate_memory_occupied", 100);
                    if (iOptInt >= 100 || iOptInt < 50) {
                        U7.a.j("oom mode", new Object[0]);
                        this.e.c = 1;
                    } else {
                        U7.a.j("reach top mode", new Object[0]);
                        this.e.c = 2;
                    }
                    this.e.b = iOptInt;
                }
                D1.a aVarB = D1.a.b();
                Context context = this.g;
                cc.dd.hh.hh.a aVar = this.e;
                if (!aVarB.d) {
                    S0.b.L(context, "Context mustn't be null");
                    aVarB.f371a = context;
                    aVarB.b = aVar;
                    AbstractC0291a.f1622a = aVar.f2146a;
                    try {
                        Npth.registerOOMCallback(new G1.a());
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (h.b) {
                            Log.d("ApmInsight", U7.a.e(new String[]{"Npth.registerOOMCallback() error :" + th.getMessage()}));
                        }
                    }
                    aVarB.d = true;
                }
                U7.a.j("memorywidget is inited", new Object[0]);
                this.f = true;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new a(0), D1.a.b().a() ? 0L : 20000L);
        }
        if (this.d) {
            return;
        }
        this.d = true;
        new Handler(Looper.getMainLooper()).postDelayed(new a(1), 10000L);
    }
}
