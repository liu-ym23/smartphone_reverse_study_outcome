package P;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f1056a;

    @Override // N.b
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "flutter");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "flutter");
            jSONObject.put("flutter_module", this.f1056a);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // N.b
    public final boolean b() {
        return true;
    }

    @Override // N.b
    public final String d() {
        return "flutter";
    }

    @Override // N.b
    public final String g() {
        return "flutter";
    }
}
