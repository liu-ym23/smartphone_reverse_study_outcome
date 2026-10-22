package m2;

import com.bytedance.apm6.monitor.Monitorable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements Monitorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONArray f22063a;

    public d(JSONArray r10) {
        this.f22063a = r10;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public final JSONObject toJsonObject() {
        return r3.b.b(getLogType(), this.f22063a);
    }

    public d(JSONObject r10) {
        JSONArray r11 = new JSONArray();
        r11.put(r10);
        this.f22063a = r11;
    }
}
