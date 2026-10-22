package f1;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19444f;

    public d() {
    }

    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("flags", this.f19443e);     // Catch: Throwable -> L4
        r10.put("tag", this.f19444f);     // Catch: Throwable -> L4
        r10.put("start_time", this.f19438a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f19439b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f19440c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "WakeLockInfo{flags=" + this.f19443e + ", tag=" + this.f19444f + ", startTime=" + this.f19438a + ", endTime=" + this.f19439b + ", threadName=" + this.f19440c + ", threadStack=" + a() + '}';
    }
}
