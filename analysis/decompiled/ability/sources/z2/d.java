package z2;

import D7.N;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {
    public static final HashMap c = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f6928a;
    public boolean b;

    public static void a(String str, JSONObject jSONObject) {
        HashMap map = c;
        d dVar = (d) map.get(str);
        if (dVar != null) {
            dVar.b(jSONObject);
            return;
        }
        d dVar2 = new d();
        dVar2.f6928a = null;
        dVar2.b = false;
        dVar2.b(jSONObject);
        map.put(str, dVar2);
        S0.b.N("after update aid " + str);
    }

    public static boolean d(String str) {
        return c.get(str) != null;
    }

    public final void b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.f6928a = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.b = jSONObjectOptJSONObject.optInt("switcher") == 1 && jSONObjectOptJSONObject.optInt("err_sampling_rate") == 1;
    }

    public final boolean c() {
        JSONObject jSONObject = this.f6928a;
        return jSONObject != null && 1 == N.b(jSONObject, 0, "crash_module", "switcher");
    }

    public final boolean e() {
        try {
            JSONObject jSONObject = this.f6928a;
            if (jSONObject != null) {
                if (jSONObject.optInt("status") != 0) {
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }
}
