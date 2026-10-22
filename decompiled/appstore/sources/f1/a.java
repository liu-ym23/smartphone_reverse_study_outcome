package f1;

import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19435e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f19437g;

    public a() {
    }

    public long b() {
        int r10 = this.f19435e;
        if (r10 == 1) goto L9;
        if (r10 == 0) goto L9;
        return (this.f19438a + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    L9:
        return this.f19438a;
    }

    public boolean c() {
        int r10 = this.f19435e;
        if (r10 == 2) goto L7;
        if (r10 == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public JSONObject d() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("start_time", this.f19438a);     // Catch: Throwable -> L4
        r10.put("end_time", this.f19439b);     // Catch: Throwable -> L4
        r10.put("thread_name", this.f19440c);     // Catch: Throwable -> L4
        r10.put("thread_stack", a());     // Catch: Throwable -> L4
        r10.put("interval", this.f19436f);     // Catch: Throwable -> L4
        r10.put("type", this.f19435e);     // Catch: Throwable -> L4
        r10.put("intent_info", this.f19437g);     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.f19435e + ", interval=" + this.f19436f + ", intentInfo=" + this.f19437g + ", startTime=" + this.f19438a + ", endTime=" + this.f19439b + ", threadName=" + this.f19440c + ", threadStack=" + a() + '}';
    }
}
