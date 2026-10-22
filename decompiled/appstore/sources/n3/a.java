package n3;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.monitor.Monitorable;
import m3.c;
import org.json.JSONException;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Monitorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f22385g;

    public a() {
        this.f22379a = "log_type";
        this.f22380b = CommonKey.KEY_EXTRA_STATUS;
        this.f22381c = CommonKey.KEY_EXTRA_VALUES;
        this.f22382d = "filters";
        this.f22383e = "service";
        this.f22384f = "scene";
    }

    public JSONObject a() {
        return new JSONObject();
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("scene", c.a().getSceneString());     // Catch: Throwable -> L4
        r10.put("process_name", d3.a.m());     // Catch: Throwable -> L4
        r10.put("is_main_process", d3.a.A());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public abstract JSONObject c();

    public abstract JSONObject d();

    public abstract String e();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "performance_monitor";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
    L16:
        return null;
    L3:
        if (this.f22385g != null) goto L5;
        this.f22385g = a();     // Catch: JSONException -> L16
    L5:
        this.f22385g.put("log_type", "performance_monitor");     // Catch: JSONException -> L16
        this.f22385g.put("service", e());     // Catch: JSONException -> L16
        JSONObject r10 = c();     // Catch: JSONException -> L16
        if (e.d(r10) == true) goto L8;
        this.f22385g.put(CommonKey.KEY_EXTRA_VALUES, r10);     // Catch: JSONException -> L16
    L8:
        JSONObject r11 = b();     // Catch: JSONException -> L16
        if (e.d(r11) == true) goto L11;
        this.f22385g.put(CommonKey.KEY_EXTRA_STATUS, r11);     // Catch: JSONException -> L16
    L11:
        JSONObject r12 = d();     // Catch: JSONException -> L16
        if (e.d(r12) == true) goto L14;
        this.f22385g.put("filters", r12);     // Catch: JSONException -> L16
    L14:
        return this.f22385g;
    }
}
