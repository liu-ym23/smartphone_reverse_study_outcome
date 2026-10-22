package p6;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f11438b = new c(new JSONObject());

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f11439a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                Object objOpt = jSONObject.opt(next);
                if ((obj instanceof JSONObject) && (objOpt instanceof JSONObject)) {
                    JSONObject jSONObject3 = (JSONObject) objOpt;
                    a(jSONObject3, (JSONObject) obj);
                    jSONObject.put(next, jSONObject3);
                } else {
                    jSONObject.put(next, obj);
                }
            }
            return jSONObject;
        }
    }

    public c(JSONObject jSONObject) {
        this.f11439a = jSONObject;
    }

    public final c a(String str) {
        JSONObject jSONObjectOptJSONObject = this.f11439a.optJSONObject(str);
        return jSONObjectOptJSONObject != null ? new c(jSONObjectOptJSONObject) : f11438b;
    }

    public final String b(String str, String str2) {
        JSONObject jSONObject = this.f11439a;
        if (!jSONObject.has(str)) {
            return str2;
        }
        String strOptString = jSONObject.optString(str, str2);
        kotlin.jvm.internal.g.e(strOptString, "optString(...)");
        return strOptString;
    }

    public final c c(c cVar) throws JSONException {
        if (cVar != null) {
            JSONObject jSONObject = cVar.f11439a;
            if (jSONObject.length() != 0) {
                JSONObject jSONObject2 = this.f11439a;
                if (jSONObject2.length() == 0) {
                    return cVar;
                }
                JSONObject jSONObject3 = new JSONObject(jSONObject2.toString());
                a.a(jSONObject3, jSONObject);
                return new c(jSONObject3);
            }
        }
        return this;
    }
}
