package R0;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import g1.AbstractC1451a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements N0.b {

    /* renamed from: a, reason: collision with root package name */
    public String f1137a;
    public JSONObject b;

    @Override // N0.b
    public final boolean a() {
        return !TextUtils.isEmpty(this.f1137a);
    }

    @Override // N0.b
    public final JSONObject b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "service_monitor");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, this.f1137a);
            jSONObject.put("status", 0);
            JSONObject jSONObject2 = this.b;
            if (jSONObject2 != null) {
                jSONObject.put("value", jSONObject2);
            }
            return jSONObject;
        } catch (Exception e) {
            boolean z10 = AbstractC1451a.f4467a;
            if (!z10 || !z10) {
                return null;
            }
            Log.w("APM-CommonEvent", "toJsonObject Error.", e);
            return null;
        }
    }

    @Override // N0.b
    public final String c() {
        return "service_monitor";
    }

    public final String toString() {
        return B7.a.q(new StringBuilder("CommonEvent{serviceName='"), this.f1137a, "'}");
    }
}
