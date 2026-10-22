package C0;

import D9.l;
import F.g;
import H.h;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.core.ActivityLifeObserver;
import g1.AbstractC1451a;
import i1.C1552a;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import k1.AbstractC1620b;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w0.C2086g;

/* loaded from: classes2.dex */
public final class d implements a, B.c {

    /* renamed from: s, reason: collision with root package name */
    public static String f275s = "bg_never_front";
    public Map e;
    public Map f;
    public Map g;
    public long h;
    public long n;
    public final g p;

    /* renamed from: q, reason: collision with root package name */
    public volatile D0.a f278q;

    /* renamed from: r, reason: collision with root package name */
    public final b f279r;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f276a = false;
    public volatile boolean b = false;
    public final l c = new l(20);
    public final l d = new l(20);
    public long i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f277j = 0;
    public long k = 0;
    public long l = 0;
    public long m = 0;
    public long o = 0;

    public d() {
        g gVar = A0.g.f73a;
        this.p = gVar;
        gVar.C();
        ((E0.a) gVar.b).f(h());
        this.f279r = new b(this);
    }

    public static void d(R0.b bVar, JSONObject jSONObject, String str) {
        boolean zB = AbstractC1451a.f4474w.b("traffic");
        boolean z10 = jSONObject.optInt(str, 0) == 1;
        if (zB || z10) {
            l lVar = P0.a.f1059a;
            if (bVar != null) {
                N0.a.a(bVar);
            }
        }
        if (AbstractC1451a.f4467a) {
            Log.d("Traffic", U7.a.e(new String[]{"isSampled=" + zB + " + metricEnabled=" + z10}));
        }
    }

    @Override // C0.a
    public final synchronized void a(String str, boolean z10) {
        L0.d.f925a.b(new c(0, this, z10, str));
    }

    public final void b(P.e eVar) {
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"sendPerfLog[" + eVar.f1057a + "] = " + eVar.a().toString()}));
        }
        C2086g.b().getClass();
        String strC = C2086g.c();
        JSONObject jSONObject = eVar.e;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(strC)) {
                strC = ActivityLifeObserver.getInstance().getTopActivityClassName();
            }
            jSONObject.put("scene", strC);
            jSONObject.put("process_name", h.c());
            jSONObject.put("is_main_process", h.g());
            if (jSONObject.isNull("is_front")) {
                jSONObject.put("is_front", ActivityLifeObserver.getInstance().isForeground());
            }
            eVar.e = jSONObject;
        } catch (JSONException unused) {
        }
        S0.b.z(eVar);
        O.a.g().c(eVar);
    }

    @Override // B.c
    public final void c(Activity activity) {
    }

    public final void e(Map map, String str, JSONArray jSONArray) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectB = ((B0.a) ((Map.Entry) it.next()).getValue()).b(this.f278q.g);
                if (!TextUtils.isEmpty(str)) {
                    jSONObjectB.put("traffic_category", str);
                }
                jSONArray.put(jSONObjectB);
            }
        } catch (Exception unused) {
        }
    }

    @Override // B.c
    public final void f(Activity activity) {
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"onBackground()"}));
        }
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"stop()"}));
        }
        if (this.b) {
            this.b = false;
            s1.b.a(cc.dd.ee.kk.ff.c.b).b(this.f279r);
        }
        ((E0.a) this.p.b).f(true);
    }

    @Override // B.c
    public final void g(Bundle bundle) {
    }

    public final boolean h() {
        if (AbstractC1451a.f4467a) {
            StringBuilder sb = new StringBuilder("isBackground(): ");
            sb.append(!ActivityLifeObserver.getInstance().isForeground());
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{sb.toString()}));
        }
        return !ActivityLifeObserver.getInstance().isForeground();
    }

    @Override // C0.a
    public final synchronized void i(D0.a aVar) {
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"updateConfig()"}));
        }
        if (aVar == null) {
            return;
        }
        this.f278q = aVar;
        if (!this.f276a) {
            if (AbstractC1451a.f4467a) {
                Log.d("APM-Traffic-Detail", U7.a.e(new String[]{"updateConfig called while TrafficCollector not being initialized already."}));
            }
            return;
        }
        if (aVar.b) {
            A0.b bVar = A0.a.f67a;
            ((B0.b) bVar.b).a();
            ((B0.b) bVar.b).o(aVar.e);
            ((B0.b) bVar.b).m(aVar.f);
        }
        JSONObject jSONObject = aVar.f370a;
        while (!((ConcurrentLinkedQueue) this.c.c).isEmpty()) {
            d((R0.b) ((ConcurrentLinkedQueue) this.c.c).poll(), jSONObject, (String) ((ConcurrentLinkedQueue) this.d.c).poll());
        }
        k();
    }

    @Override // C0.a
    public final void j(boolean z10, boolean z11) {
        d dVar;
        String str;
        D0.a aVar;
        long j5;
        if (this.f276a) {
            return;
        }
        this.f276a = true;
        AbstractC1620b.a(C1552a.class);
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"init()"}));
        }
        ActivityLifeObserver.getInstance().register(this);
        SharedPreferences sharedPreferences = AbstractC1451a.b.getSharedPreferences("traffic_monitor_info", 0);
        long j6 = sharedPreferences.getLong("init", -1L);
        long j10 = sharedPreferences.getLong("init_ts", 0L);
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{androidx.compose.foundation.b.p(j6, "initTraffic==")}));
        }
        if (j6 > -1) {
            long j11 = sharedPreferences.getLong("usage", 0L);
            long j12 = sharedPreferences.getLong("usage_ts", 0L);
            long j13 = j11 - j6;
            if (AbstractC1451a.f4467a) {
                j5 = j11;
                Log.i("APM-Traffic-Detail", U7.a.e(new String[]{androidx.compose.foundation.b.p(j11, "statsUsageTraffic=="), androidx.compose.foundation.b.p(j12, "statsUsageTrafficTs=="), androidx.compose.foundation.b.p(j13, "lastUsageTraffic==")}));
            } else {
                j5 = j11;
            }
            if (j13 > 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("total_usage", j13);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("total_usage_duration", ((j12 - j10) / 1000) / 60);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("init_ts", j10);
                    jSONObject3.put("usage_ts", j12);
                    jSONObject3.put("biz_usage", sharedPreferences.getLong("biz_usage", 0L));
                    jSONObject3.put("init", j6);
                    str = "usage";
                    try {
                        jSONObject3.put(str, j5);
                        String string = sharedPreferences.getString("biz_json", "");
                        if (AbstractC1451a.f4467a) {
                            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"detailUsage==" + string}));
                        }
                        if (!TextUtils.isEmpty(string)) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(str, new JSONArray(string));
                            jSONObject3.put("detail", jSONObject4);
                        }
                        dVar = this;
                        try {
                            String str2 = (String) dVar.p.c;
                            if (!TextUtils.isEmpty(str2)) {
                                jSONObject3.put("traffic_impl", str2);
                            }
                            P.e eVar = new P.e();
                            eVar.f1057a = "traffic";
                            eVar.d = jSONObject;
                            eVar.e = jSONObject2;
                            eVar.g = jSONObject3;
                            if (dVar.f278q.i) {
                                dVar.b(eVar);
                                if (h.b) {
                                    Log.d("ApmInsight", U7.a.e(new String[]{"total_usage"}));
                                }
                            }
                        } catch (JSONException unused) {
                        }
                    } catch (JSONException unused2) {
                        dVar = this;
                    }
                } catch (JSONException unused3) {
                }
            } else {
                dVar = this;
                str = "usage";
            }
        } else {
            dVar = this;
            str = "usage";
        }
        dVar.o = ((E0.a) dVar.p.b).g();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putLong("init", dVar.o);
        editorEdit.putLong("init_ts", System.currentTimeMillis());
        editorEdit.putLong(str, 0L);
        editorEdit.apply();
        C1552a c1552a = (C1552a) AbstractC1620b.a(C1552a.class);
        if (c1552a == null || (aVar = c1552a.f4604a) == null) {
            return;
        }
        dVar.i(aVar);
    }

    public final synchronized void k() {
        if (this.f278q != null && !this.b) {
            this.b = true;
            cc.dd.ee.kk.ff.c cVar = cc.dd.ee.kk.ff.c.b;
            s1.b.a(cVar).b(this.f279r);
            s1.b.a(cVar).c(this.f279r);
        }
    }

    @Override // B.c
    public final void onActivityStarted(Activity activity) {
    }

    @Override // B.c
    /* renamed from: c */
    public final void mo0c() {
        if (AbstractC1451a.f4467a) {
            Log.i("APM-Traffic-Detail", U7.a.e(new String[]{"onFront()"}));
        }
        if (this.f278q != null) {
            k();
        }
        f275s = "bg_ever_front";
        ((E0.a) this.p.b).f(false);
    }

    @Override // C0.a
    public final synchronized void a(String str) {
        L0.d.f925a.b(new A.a(2, this, str));
    }

    public final void a(long j5, boolean z10, boolean z11) {
        if (j5 > this.f278q.f) {
            String.format("periodTrafficBytes: %d, isWifi: %b, isFront: %b", Long.valueOf(j5), Boolean.valueOf(z10), Boolean.valueOf(z11));
        }
        if (AbstractC1451a.f4467a) {
            Log.i("APM-TrafficInfo", U7.a.e(new String[]{String.format("periodTrafficBytes: %d, isWifi: %b, isFront: %b", Long.valueOf(j5), Boolean.valueOf(z10), Boolean.valueOf(z11))}));
        }
    }
}
