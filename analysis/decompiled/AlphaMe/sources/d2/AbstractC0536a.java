package d2;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0536a {

    /* renamed from: a, reason: collision with root package name */
    public String f12416a;

    /* renamed from: b, reason: collision with root package name */
    public String f12417b;

    /* renamed from: c, reason: collision with root package name */
    public String f12418c;

    public static JSONObject a(JSONObject jSONObject, AbstractC0536a abstractC0536a) throws JSONException {
        if (abstractC0536a == null) {
            return null;
        }
        jSONObject.put("app_id", abstractC0536a.f12416a);
        jSONObject.put("code", abstractC0536a.f12417b);
        jSONObject.put("message", abstractC0536a.f12418c);
        return jSONObject;
    }

    public static AbstractC0536a b(JSONObject jSONObject, AbstractC0536a abstractC0536a) {
        if (!jSONObject.isNull("app_id")) {
            abstractC0536a.f12416a = jSONObject.getString("app_id");
        }
        if (!jSONObject.isNull("code")) {
            abstractC0536a.f12417b = jSONObject.getString("code");
        }
        if (!jSONObject.isNull("message")) {
            abstractC0536a.f12418c = jSONObject.getString("message");
        }
        return abstractC0536a;
    }

    public String toString() {
        return "appId=" + this.f12416a + ", code=" + this.f12417b + ", message=" + this.f12418c;
    }
}
