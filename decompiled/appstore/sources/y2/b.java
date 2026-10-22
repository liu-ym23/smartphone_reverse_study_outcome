package y2;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.UiType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public class b extends n3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f26043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f26044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f26045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f26046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f26047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f26048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f26049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f26050o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONArray f26051p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JSONArray f26052q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public JSONArray f26053r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public JSONArray f26054s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f26055t;

    public b(long r10, long r11, long r12, long r13, long r14, long r15, long r16, double r18, JSONArray r20, JSONArray r21, JSONArray r22, JSONArray r23) {
        this.f26055t = UiType.FLAG_TIMER_CARD;
        this.f26043h = r10;
        this.f26044i = r11;
        this.f26045j = r12;
        this.f26046k = r13;
        this.f26047l = r14;
        this.f26048m = r15;
        this.f26049n = r16;
        this.f26050o = r18;
        this.f26051p = r20;
        this.f26052q = r21;
        this.f26053r = r22;
        this.f26054s = r23;
    }

    public static long f(JSONArray r10) {
        return r10.toString().getBytes("UTF-8").length;
    L5:
        return 0;
    }

    @Override // n3.a
    public JSONObject a() {
        JSONObject r10 = new JSONObject();
        JSONArray r11 = this.f26051p;     // Catch: Exception -> L20
        if (r11 == null) goto L6;
        r10.put(PerfConsts.PERF_DISK_TOP_USAGE, r11);     // Catch: Exception -> L20
    L6:
        JSONArray r12 = this.f26052q;     // Catch: Exception -> L20
        if (r12 == null) goto L9;
        r10.put(PerfConsts.PERF_DISK_EXCEPTION_FOLDERS, r12);     // Catch: Exception -> L20
    L9:
        JSONArray r13 = this.f26053r;     // Catch: Exception -> L20
        if (r13 == null) goto L13;
        r10.put(PerfConsts.PERF_DISK_OUTDATED_FILES, r13);     // Catch: Exception -> L20
    L13:
        if (this.f26054s == null) goto L19;
        int r14 = r10.toString().getBytes("UTF-8").length;     // Catch: Exception -> L16
    L18:
        this.f26055t = 249856 - r14;     // Catch: Exception -> L20
        JSONArray r15 = h(this.f26054s);     // Catch: Exception -> L20
        this.f26054s = r15;     // Catch: Exception -> L20
        r10.put(PerfConsts.PERF_DISK_DISK_INFO, r15);     // Catch: Exception -> L20
    L16:
        r14 = 0;
    L19:
        return r10;
    }

    @Override // n3.a
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("scene", m3.c.a().getSceneString());     // Catch: Throwable -> L4
        r10.put("process_name", d3.a.m());     // Catch: Throwable -> L4
        r10.put(CommonKey.KEY_IS_FRONT, false);     // Catch: Throwable -> L4
        r10.put("is_main_process", d3.a.A());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    @Override // n3.a
    public JSONObject c() {
        JSONObject r10 = new JSONObject();
        long r11 = this.f26043h;     // Catch: Exception -> L28
        if (r11 <= 0) goto L6;
        r10.put("data", r11);     // Catch: Exception -> L28
    L6:
        long r12 = this.f26044i;     // Catch: Exception -> L28
        if (r12 <= 0) goto L9;
        r10.put("cache", r12);     // Catch: Exception -> L28
    L9:
        long r13 = this.f26045j;     // Catch: Exception -> L28
        if (r13 <= 0) goto L12;
        r10.put(PerfConsts.PERF_DISK_TOTAL, r13);     // Catch: Exception -> L28
    L12:
        long r14 = this.f26046k;     // Catch: Exception -> L28
        if (r14 <= 0) goto L15;
        r10.put(PerfConsts.PERF_DISK_ROM_FREE, r14);     // Catch: Exception -> L28
    L15:
        long r15 = this.f26047l;     // Catch: Exception -> L28
        if (r15 <= 0) goto L18;
        r10.put("app_usage", r15);     // Catch: Exception -> L28
    L18:
        long r16 = this.f26048m;     // Catch: Exception -> L28
        if (r16 <= 0) goto L21;
        r10.put("total_capacity", r16);     // Catch: Exception -> L28
    L21:
        long r17 = this.f26049n;     // Catch: Exception -> L28
        if (r17 <= 0) goto L24;
        r10.put("free_capacity", r17);     // Catch: Exception -> L28
    L24:
        double r18 = this.f26050o;     // Catch: Exception -> L28
        if (r18 <= 0.0d) goto L27;
        r10.put("app_occupied_rate", r18);     // Catch: Exception -> L28
    L27:
        return r10;
    }

    @Override // n3.a
    public JSONObject d() {
        JSONObject r10 = m3.c.a().getPerfFiltersJson();
        e.a(r10, m3.c.a().getRealTimeMemInfo());     // Catch: Exception -> L5
    L4:
        return r10;
    }

    @Override // n3.a
    public String e() {
        return "disk";
    }

    public final JSONArray g(JSONArray r10, int r11) {
        JSONArray r12 = new JSONArray();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L16;
        JSONObject r14 = r10.getJSONObject(r13);
        if (r14.getLong("size") < r11) goto L15;
        JSONArray r15 = r14.optJSONArray("next_disk");
        if (r15 == null) goto L14;
        JSONArray r16 = g(r15, r11);
        if (r16.length() <= 0) goto L13;
        r14.put("next_disk", r16);
        goto L14
    L13:
        r14.remove("next_disk");
    L14:
        r12.put(r14);
    L15:
        r13 = r13 + 1;
        goto L4
    L16:
        return r12;
    }

    public final JSONArray h(JSONArray r10) {
        if (r10 == null) goto L4;
        int r11 = 102400;
        int r12 = 0;
    L7:
        if (f(r10) <= this.f26055t) goto L12;
        if (r12 > 10) goto L12;
        r10 = g(r10, r11);     // Catch: JSONException -> L13
    L11:
        r11 = r11 * 2;
        r12 = r12 + 1;
    L12:
        return r10;
    L4:
        return new JSONArray();
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }
}
