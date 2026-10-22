package f1;

import com.obric.capabilitykit.common.Ext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f19442e;

    public c() {
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("start_time", this.f19438a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f19439b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f19440c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        r10.put(Ext.KEY_REQUEST, this.f19442e);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "LocInfo{request=" + this.f19442e + ", startTime=" + this.f19438a + ", endTime=" + this.f19439b + ", threadName=" + this.f19440c + ", threadStack=" + a() + '}';
    }
}
