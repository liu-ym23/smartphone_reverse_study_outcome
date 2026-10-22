package a1;

import H.h;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cc.dd.ee.ee.cc.a$a;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements N0.b {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f1633a;
    public a$a b;
    public J1.b c;
    public String d;
    public double e;
    public double f;
    public double g;
    public double h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public String f1634j;
    public ArrayList k;

    @Override // N0.b
    public final boolean a() {
        return true;
    }

    @Override // N0.b
    public final JSONObject b() {
        try {
            if (this.f1633a == null) {
                this.f1633a = new JSONObject();
            }
            this.f1633a.put("log_type", "performance_monitor");
            this.f1633a.put(NotificationCompat.CATEGORY_SERVICE, this.f1634j);
            JSONObject jSONObjectE = e();
            if (!S0.b.E0(jSONObjectE)) {
                this.f1633a.put("extra_values", jSONObjectE);
            }
            JSONObject jSONObjectD = d();
            if (!S0.b.E0(jSONObjectD)) {
                this.f1633a.put("extra_status", jSONObjectD);
            }
            JSONObject jSONObjectF = f();
            if (!S0.b.E0(jSONObjectF)) {
                this.f1633a.put("filters", jSONObjectF);
            }
            return this.f1633a;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // N0.b
    public final String c() {
        return "performance_monitor";
    }

    public final JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("process_name", h.c());
            jSONObject.put("is_main_process", h.g());
            jSONObject.put("scene", this.d);
            int iOrdinal = this.b.ordinal();
            if (iOrdinal == 0) {
                jSONObject.put("data_type", "mix");
                return jSONObject;
            }
            if (iOrdinal == 1) {
                jSONObject.put("data_type", "front");
                return jSONObject;
            }
            if (iOrdinal != 2) {
                return jSONObject;
            }
            jSONObject.put("data_type", "back");
            return jSONObject;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    public final JSONObject e() {
        ArrayList arrayList = this.k;
        double d = this.h;
        double d6 = this.f;
        try {
            JSONObject jSONObject = new JSONObject();
            double d10 = this.e;
            if (d10 > -1.0d && d6 > -1.0d) {
                jSONObject.put("app_usage_rate", d10);
                jSONObject.put("app_max_usage_rate", d6);
            }
            double d11 = this.g;
            if (d11 > -1.0d && d > -1.0d) {
                jSONObject.put("app_stat_speed", d11);
                jSONObject.put("app_max_stat_speed", d);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    M.c cVar = (M.c) it.next();
                    if (cVar != null) {
                        Object obj = cVar.b;
                        Object obj2 = cVar.f950a;
                        if (obj2 != null && !((String) obj2).isEmpty() && obj != null && ((Double) obj).doubleValue() >= 0.0d) {
                            jSONObject2.put((String) obj2, obj);
                        }
                    }
                }
                jSONObject.put("thread_cpu_usage", jSONObject2);
            }
            return jSONObject;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }

    public final JSONObject f() {
        J1.b bVar = this.c;
        try {
            JSONObject jSONObjectB = O0.a.a().b();
            jSONObjectB.put("is_auto_sample", true);
            if (bVar != null) {
                jSONObjectB.put("network_type", D2.b.c(h.f711a));
                jSONObjectB.put("battery_level", bVar.c);
                jSONObjectB.put("cpu_hardware", bVar.f863a);
                jSONObjectB.put("is_charging", bVar.b);
                jSONObjectB.put("power_save_mode", bVar.e);
                jSONObjectB.put("thermal_status", bVar.d);
                jSONObjectB.put("battery_thermal", bVar.f);
                jSONObjectB.put("is_normal_sample_state", this.i);
            }
            return jSONObjectB;
        } catch (Throwable th) {
            Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
            return null;
        }
    }
}
