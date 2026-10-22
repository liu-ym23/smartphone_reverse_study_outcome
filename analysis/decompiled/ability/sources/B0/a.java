package B0;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f172a;
    public long c = 0;
    public final HashMap b = new HashMap();

    public a(String str) {
        this.f172a = str;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz", this.f172a);
            jSONObject.put("usage", this.c);
            JSONArray jSONArray = new JSONArray();
            HashMap map = this.b;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("source_id", entry.getKey());
                    jSONObject2.put("usage", entry.getValue());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("detail", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject b(long j5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("biz", this.f172a);
            jSONObject.put("usage", this.c);
            JSONArray jSONArray = new JSONArray();
            HashMap map = this.b;
            if (map != null && map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    if (((Long) entry.getValue()).longValue() >= j5) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("source_id", entry.getKey());
                        jSONObject2.put("usage", entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("detail", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void c(long j5, String str) {
        HashMap map = this.b;
        if (map.containsKey(str)) {
            map.put(str, Long.valueOf(((Long) map.get(str)).longValue() + j5));
        } else {
            map.put(str, Long.valueOf(j5));
        }
        this.c += j5;
    }
}
