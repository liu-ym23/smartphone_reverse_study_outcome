package X0;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1500a;
    public HashMap b;

    public static b a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        b bVar = new b();
        bVar.b = new HashMap();
        bVar.f1500a = jSONObject.optInt("default", 1) == 1;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals(next, "default") && (jSONObjectOptJSONObject = jSONObject.optJSONObject(next)) != null) {
                bVar.b.put(next, jSONObjectOptJSONObject);
            }
        }
        return bVar;
    }

    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("default", this.f1500a ? 1 : 0);
            for (Map.Entry entry : this.b.entrySet()) {
                jSONObject.put((String) entry.getKey(), (JSONObject) entry.getValue());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
