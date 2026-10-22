package com.bytedance.apm6.cpu.c.a;

import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm6.cpu.c.j;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CpuNormalExceptionEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements com.bytedance.apm6.monitor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f5238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<j> f5242e;

    @Override // com.bytedance.apm6.monitor.b
    public String g() {
        return "cpu_exception_trace";
    }

    public b(double r3, double r5, List<j> r7, String r8, boolean r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.f5238a = r3;
        this.f5239b = r5;
        this.f5240c = r8;
        this.f5241d = r9;
        this.f5242e = new ArrayList(r10);
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        List<j> r0 = this.f5242e;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L11;
        if (this.f5238a <= 0.0d) goto L11;
        if (this.f5239b <= 0.0d) goto L11;
        return true;
    }

    @Override // com.bytedance.apm6.monitor.b
    public JSONObject i() {
        JSONObject r2 = new JSONObject();
        r2.put("event_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r2.put("log_type", "cpu_exception_trace");     // Catch: Throwable -> L24
        r2.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Throwable -> L24
        r2.put("crash_time", System.currentTimeMillis());     // Catch: Throwable -> L24
        r2.put("is_main_process", com.bytedance.apm.c.d());     // Catch: Throwable -> L24
        r2.put("process_name", com.bytedance.apm.c.c());     // Catch: Throwable -> L24
        if (this.f5241d == false) goto L7;
        r2.put("data_type", "back");     // Catch: Throwable -> L24
    L8:
        r2.put(DBHelper.BATTERY_COL_SCENE, this.f5240c);     // Catch: Throwable -> L24
        r2.put("report_scene", this.f5240c);     // Catch: Throwable -> L24
        if (com.bytedance.apm.c.u() <= com.bytedance.apm.c.g()) goto L12;
    L14:
        r2.put("app_launch_start_time", com.bytedance.apm.c.g());     // Catch: Throwable -> L24
    L15:
        r2.put("process_speed_avg", this.f5238a);     // Catch: Throwable -> L24
        r2.put("process_speed_max", this.f5239b);     // Catch: Throwable -> L24
        r2.put("battery_temperature", com.bytedance.apm.perf.g.a().b());     // Catch: Throwable -> L24
        r2.put("battery_recharge_state", com.bytedance.apm.perf.g.a().c());     // Catch: Throwable -> L24
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L24
        Iterator<j> r8 = this.f5242e.iterator();     // Catch: Throwable -> L24
    L17:
        if (r8.hasNext() == false) goto L22;
        j r3 = (j) ZeusTransformUtils.preCheckCast(r8.next(), j.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r3 == null) goto L17;
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L24
        r4.put("nice", r3.a());     // Catch: Throwable -> L24
        r4.put("weight", Double.valueOf(r3.b()));     // Catch: Throwable -> L24
        r4.put("cpu_usage", r3.e());     // Catch: Throwable -> L24
        r4.put("thread_name", r3.g());     // Catch: Throwable -> L24
        r4.put("thread_back_trace", r3.d());     // Catch: Throwable -> L24
        r4.put("thread_id", r3.f());     // Catch: Throwable -> L24
        r1.put(r4);     // Catch: Throwable -> L24
        goto L17
    L22:
        r2.put("threads_info", r1);     // Catch: Throwable -> L24
    L27:
        a("APM-CPU", "exception data: " + r2);
        return r2;
    L12:
        if (com.bytedance.apm.c.u() == 0) goto L14;
        r2.put("app_launch_start_time", com.bytedance.apm.c.u());     // Catch: Throwable -> L24
        goto L15
    L7:
        r2.put("data_type", DBHelper.COL_FRONT);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        com.bytedance.apm6.util.c.b.b("APM-CPU", "cpu_exception_data_assemble", th);
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L29
        r5.put("exception", th.getLocalizedMessage());     // Catch: Throwable -> L29
        com.bytedance.apm6.commonevent.a.a("cpu_exception_no_stack", r5, null);     // Catch: Throwable -> L29
        goto L27
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
