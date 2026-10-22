package v1;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.service.perf.ICpuDataService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f24981a;

    public d() {
    }

    public static d b() {
        if (f24981a != null) goto L16;
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f24981a != null) goto L11;
        f24981a = new d();     // Catch: Throwable -> L9
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L16:
        return f24981a;
    }

    public JSONObject a() {
        JSONObject r10 = new JSONObject();
        ICpuDataService r11 = (ICpuDataService) o3.a.a(ICpuDataService.class);     // Catch: JSONException -> L5
        r10.put(PerfConsts.PERF_CPU_PROCESS_USAGE, r11.getCpuRate());     // Catch: JSONException -> L5
        r10.put(PerfConsts.PERF_CPU_STAT_SPEED, r11.getCpuSpeed());     // Catch: JSONException -> L5
        return r10;
    L6:
        return new JSONObject();
    }
}
