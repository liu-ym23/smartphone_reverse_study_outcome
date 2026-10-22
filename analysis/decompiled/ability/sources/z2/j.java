package z2;

import D7.N;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static JSONObject f6932a = new JSONObject();

    public static boolean a(JSONArray jSONArray, f fVar) {
        if (!N.g(jSONArray)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    int i6 = com.apm.insight.b.f2156a;
                    M0.i.k("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
                } else if (c(jSONObjectOptJSONObject, fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject, Object obj) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray.length() == 0) {
            return false;
        }
        String strOptString = jSONObject.optString("op");
        String strValueOf = String.valueOf(obj);
        if (strOptString.equals("=")) {
            return strValueOf.equals(String.valueOf(jSONArrayOptJSONArray.opt(0)));
        }
        if (strOptString.equals("in")) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                if (String.valueOf(jSONArrayOptJSONArray.opt(i)).equals(strValueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject, f fVar) {
        Iterator<String> itKeys = jSONObject.keys();
        boolean z10 = false;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("header_")) {
                    if (!b(jSONObject.optJSONObject(next), fVar.b(next.substring(7)))) {
                        S0.b.N("not match ".concat(next));
                        return false;
                    }
                    z10 = true;
                } else {
                    if (!next.startsWith("java_")) {
                        S0.b.N("no rules match ".concat(next));
                    } else if (!b(jSONObject.optJSONObject(next), fVar.a(next.substring(5)))) {
                        S0.b.N("not match ".concat(next));
                        return false;
                    }
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public static boolean d(C2154a c2154a) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = f6932a;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("java_crash_ignore")) == null || a(jSONObjectOptJSONObject.optJSONArray("disable"), c2154a)) {
            return false;
        }
        return a(jSONObjectOptJSONObject.optJSONArray("enable"), c2154a);
    }

    public static JSONObject e(JSONObject jSONObject) {
        StringBuilder sb;
        Iterator<String> itKeys = jSONObject.keys();
        f fVar = new f();
        JSONObject jSONObject2 = new JSONObject();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!"configType".equals(next)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject == null) {
                    int i = com.apm.insight.b.f2156a;
                    M0.i.k("NPTH_CATCH", new IllegalArgumentException(B7.a.k("err config with key: ", next)));
                } else {
                    if (a(jSONObjectOptJSONObject.optJSONArray("disable"), fVar)) {
                        sb = new StringBuilder("match diable ");
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("enable");
                        JSONArray jSONArray = new JSONArray();
                        if (!N.g(jSONArrayOptJSONArray)) {
                            for (int i6 = 0; i6 < jSONArrayOptJSONArray.length(); i6++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i6);
                                if (jSONObjectOptJSONObject2 == null) {
                                    int i10 = com.apm.insight.b.f2156a;
                                    M0.i.k("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArrayOptJSONArray));
                                } else if (c(jSONObjectOptJSONObject2, fVar)) {
                                    jSONArray.put(jSONObjectOptJSONObject2);
                                }
                            }
                        }
                        if (N.g(jSONArray)) {
                            sb = new StringBuilder("not match ");
                        } else {
                            try {
                                jSONObject2.put(next, new JSONObject().put("enable", jSONArray));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    sb.append(next);
                    S0.b.N(sb.toString());
                }
            }
        }
        return jSONObject2;
    }
}
