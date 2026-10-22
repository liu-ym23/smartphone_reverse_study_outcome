package I;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import m0.C1671e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f790a = new ConcurrentHashMap(4);

    public static void a(JSONArray jSONArray) {
        ConcurrentHashMap concurrentHashMap = f790a;
        try {
            if (concurrentHashMap != null) {
                try {
                    if (!concurrentHashMap.isEmpty()) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            String str = (String) entry.getKey();
                            C1671e c1671e = (C1671e) entry.getValue();
                            JSONObject jSONObject = new JSONObject();
                            String[] strArrSplit = str.split("#");
                            if (strArrSplit.length == 2) {
                                jSONObject.put("module_name", strArrSplit[0]);
                                jSONObject.put("span_name", strArrSplit[1]);
                            } else if (strArrSplit.length == 1) {
                                jSONObject.put("span_name", strArrSplit[0]);
                            }
                            jSONObject.put("start", c1671e.f5296a);
                            jSONObject.put("end", c1671e.b);
                            jSONObject.put("thread", c1671e.c);
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            concurrentHashMap.clear();
        } catch (Throwable th) {
            concurrentHashMap.clear();
            throw th;
        }
    }
}
