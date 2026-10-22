package P;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import g1.AbstractC1451a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public String f1055a;
    public int b;
    public JSONObject c;
    public JSONObject d;
    public JSONObject e;
    public JSONObject f;

    public c(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f1055a = str;
        this.b = i;
        this.c = jSONObject;
        this.d = jSONObject2;
        this.e = jSONObject3;
        this.f = jSONObject4;
    }

    @Override // N.b
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "event_log");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "event_log");
            jSONObject.put("event_name", this.f1055a);
            jSONObject.put("status", this.b);
            JSONObject jSONObject2 = this.c;
            if (jSONObject2 != null) {
                jSONObject.put("value", jSONObject2);
            }
            JSONObject jSONObject3 = this.d;
            if (jSONObject3 != null) {
                jSONObject.put(TypedValues.Custom.S_DIMENSION, jSONObject3);
            }
            JSONObject jSONObject4 = this.e;
            if (jSONObject4 != null) {
                jSONObject.put("metrics", jSONObject4);
            }
            JSONObject jSONObject5 = this.f;
            if (jSONObject5 != null) {
                jSONObject.put("extraValue", jSONObject5);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // N.b
    public final boolean b() {
        return AbstractC1451a.f4474w.getServiceSwitch(this.f1055a);
    }

    @Override // N.b
    public final String d() {
        return "event_log";
    }

    @Override // N.b
    public final String g() {
        return "event_log";
    }
}
