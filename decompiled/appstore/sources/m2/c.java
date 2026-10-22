package m2;

import android.text.TextUtils;
import com.bytedance.apm6.monitor.Monitorable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Monitorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f22062b;

    public c(String r10, JSONObject r11) {
        this.f22061a = r10;
        this.f22062b = r11;
    }

    public JSONObject a() {
        return this.f22062b;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return this.f22061a;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f22061a);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r10 = a();     // Catch: Exception -> L5
        if (r10 != null) goto L7;
        r10 = new JSONObject();     // Catch: Exception -> L5
    L7:
        r10.put("log_type", getLogType());     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        if (r3.a.c() == false) goto L16;
        s3.a.g("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L16:
        return null;
    }

    public String toString() {
        return "Apm5LegacyEvent{logType='" + this.f22061a + "'}";
    }
}
