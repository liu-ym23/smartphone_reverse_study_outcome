package k3;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import java.util.Iterator;
import java.util.Map;
import m3.c;
import org.json.JSONException;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public final class a extends n3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f21015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f21016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f21017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f21018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f21019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f21020m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f21021n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f21022o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f21023p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f21024q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f21025r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f21026s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21027t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f21028u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Map f21029v;

    public a(long r10, long r11, long r12, long r13, boolean r14, long r15, long r16, long r17, long r19, long r21, long r23, double r25, boolean r27, boolean r28) {
        this.f21015h = r10;
        this.f21016i = r11;
        this.f21017j = r12;
        this.f21018k = r13;
        this.f21019l = r14;
        this.f21020m = r15;
        this.f21021n = r16;
        this.f21022o = r17;
        this.f21023p = r19;
        this.f21024q = r21;
        this.f21025r = r23;
        this.f21026s = r25;
        this.f21027t = r27;
        this.f21028u = r28;
    }

    @Override // n3.a
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("scene", c.a().getSceneString());     // Catch: Throwable -> L4
        r10.put("process_name", d3.a.m());     // Catch: Throwable -> L4
        r10.put(CommonKey.KEY_IS_FRONT, !this.f21019l);     // Catch: Throwable -> L4
        r10.put("is_main_process", d3.a.A());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    @Override // n3.a
    public JSONObject c() {
        JSONObject r10 = new JSONObject();
        r10.put(PerfConsts.KEY_GC_COUNT, this.f21015h);     // Catch: JSONException -> L6
        r10.put(PerfConsts.KEY_GC_TIME, this.f21016i);     // Catch: JSONException -> L6
        r10.put(PerfConsts.KEY_BLOCK_GC_COUNT, this.f21017j);     // Catch: JSONException -> L6
        r10.put(PerfConsts.KEY_BLOCK_GC_TIME, this.f21018k);     // Catch: JSONException -> L6
        if (this.f21019l == false) goto L8;
        r10.put(PerfConsts.PERF_MEM_DALVIK_PSS_BACKGROUND, this.f21023p);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_NATIVE_PSS_BACKGROUND, this.f21020m);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_PSS_BACKGROUND, this.f21021n);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_JAVA_BACKGROUND, this.f21022o);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_JAVA_BACKGROUND_USED_RATE, this.f21026s);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_VM_SIZE_BACKGROUND, this.f21025r);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_GRAPHICS_MEM_BACKGROUND, this.f21024q);     // Catch: JSONException -> L6
    L10:
        if (this.f21027t == false) goto L12;
        r10.put(PerfConsts.KEY_REACH_TOP_JAVA, 1);     // Catch: JSONException -> L6
    L12:
        f(r10);     // Catch: JSONException -> L6
    L15:
        return r10;
    L8:
        r10.put(PerfConsts.PERF_MEM_DALVIK_PSS_FOREGROUND, this.f21023p);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_NATIVE_PSS_FOREGROUND, this.f21020m);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_PSS_FOREGROUND, this.f21021n);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_JAVA_FOREGROUND, this.f21022o);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_TOTAL_JAVA_FOREGROUND_USED_RATE, this.f21026s);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_VM_SIZE_FOREGROUND, this.f21025r);     // Catch: JSONException -> L6
        r10.put(PerfConsts.PERF_MEM_GRAPHICS_MEM_FOREGROUND, this.f21024q);     // Catch: JSONException -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    @Override // n3.a
    public JSONObject d() {
        JSONObject r10 = c.a().getPerfFiltersJson();
        if (this.f21028u == true) goto L14;
    L6:
        IDeviceInfoService r11 = (IDeviceInfoService) o3.a.a(IDeviceInfoService.class);
        if (r11 != null) goto L12;
    L9:
        return r10;
    L12:
        e.a(r10, r11.getDeviceInfo());     // Catch: Exception -> L11
        goto L9
    L14:
        e.a(r10, c.a().getRealTimeMemInfo());     // Catch: Exception -> L10
        goto L6
    }

    @Override // n3.a
    public String e() {
        return "memory";
    }

    public final void f(JSONObject r10) {
        if (r10 != null) goto L14;
        return;
    L14:
        Map r11 = this.f21029v;     // Catch: Exception -> L13
        if (r11 != null) goto L7;
        return;
    L7:
        Iterator r12 = r11.entrySet().iterator();     // Catch: Exception -> L13
    L9:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Exception -> L13
        r10.put((String) r13.getKey(), Long.parseLong((String) r13.getValue()));     // Catch: Exception -> L13
    L18:
        return;
    }

    public double g() {
        return this.f21026s;
    }

    public i3.a h() {
        i3.a r10 = new i3.a();
        r10.f20488a = this.f21015h;
        r10.f20489b = this.f21016i;
        r10.f20490c = this.f21017j;
        r10.f20491d = this.f21018k;
        r10.f20492e = this.f21019l;
        r10.f20493f = this.f21020m;
        r10.f20494g = this.f21021n;
        r10.f20495h = this.f21022o;
        r10.f20496i = this.f21023p;
        r10.f20497j = this.f21024q;
        r10.f20498k = this.f21025r;
        r10.f20499l = this.f21027t;
        return r10;
    }

    public void i(Map r10) {
        this.f21029v = r10;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public String toString() {
        return "MemoryPerfMonitorable{gcCount=" + this.f21015h + ", gcTime=" + this.f21016i + ", blockingGcCount=" + this.f21017j + ", blockingGcTime=" + this.f21018k + ", background=" + this.f21019l + ", nativePss=" + this.f21020m + ", totalPss=" + this.f21021n + ", javaUsedMemory=" + this.f21022o + ", dalvikUsedSize=" + this.f21023p + ", graphics=" + this.f21024q + ", vmSize=" + this.f21025r + ", javaUsedMemoryRate=" + this.f21026s + ", isMemoryReachTop=" + this.f21027t + '}';
    }
}
