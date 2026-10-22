package za;

import com.tonyodev.fetch2core.Extras;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static Extras a(String jsonString) {
        kotlin.jvm.internal.g.f(jsonString, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(jsonString);
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return new Extras(linkedHashMap);
    }

    public static String b(Extras extras) throws JSONException {
        kotlin.jvm.internal.g.f(extras, "extras");
        if (extras.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : extras.getMap().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.c(string);
        return string;
    }

    public static LinkedHashMap c(String jsonString) {
        kotlin.jvm.internal.g.f(jsonString, "jsonString");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = new JSONObject(jsonString);
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.g.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, jSONObject.getString(next));
        }
        return linkedHashMap;
    }

    public static String d(Map headerMap) throws JSONException {
        kotlin.jvm.internal.g.f(headerMap, "headerMap");
        if (headerMap.isEmpty()) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : headerMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        String string = jSONObject.toString();
        kotlin.jvm.internal.g.c(string);
        return string;
    }
}
