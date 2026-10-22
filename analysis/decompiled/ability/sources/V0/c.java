package V0;

import androidx.core.app.NotificationCompat;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements N0.b {
    @Override // N0.b
    public final boolean a() {
        return true;
    }

    @Override // N0.b
    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "service_monitor");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "apm_error");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "large_data");
            jSONObject.put(QueryAlgorithmBundle.KEY_CATEGORY, jSONObject2);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // N0.b
    public final String c() {
        return "service_monitor";
    }
}
