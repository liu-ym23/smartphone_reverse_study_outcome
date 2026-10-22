package com.bytedance.apm6.cpu.a;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.util.o;
import com.bytedance.common.utility.i;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: CpuReportEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.apm6.perf.base.model.a {
    private a.EnumC0128a g;
    private com.bytedance.watson.assist.a.c.a h;
    private String i;
    private double j;
    private double k;
    private double l;
    private double m;
    private float n;
    private boolean o;
    private boolean p;
    private List<o<String, Double>> q;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.a.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: CpuReportEvent.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5213a = null;

        static {
            int[] r0 = new int[a.EnumC0128a.values().length];
            f5213a = r0;
            r0[a.EnumC0128a.f5188a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f5213a[a.EnumC0128a.f5190c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f5213a[a.EnumC0128a.f5189b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.bytedance.apm6.monitor.b
    public boolean h() {
        return true;
    }

    public e(a.EnumC0128a r3, String r4, double r5, double r7, double r9, double r11, com.bytedance.watson.assist.a.c.a r13) {
        this.j = -1.0d;
        this.k = -1.0d;
        this.l = -1.0d;
        this.m = -1.0d;
        this.n = -1.0f;
        this.o = true;
        this.p = true;
        this.g = r3;
        this.i = r4;
        this.j = r5;
        this.k = r7;
        this.l = r9;
        this.m = r11;
        this.h = r13;
    }

    public e(a.EnumC0128a r3, String r4, List<o<String, Double>> r5, com.bytedance.watson.assist.a.c.a r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.j = -1.0d;
        this.k = -1.0d;
        this.l = -1.0d;
        this.m = -1.0d;
        this.n = -1.0f;
        this.o = true;
        this.p = true;
        this.q = new ArrayList(r7);
        this.g = r3;
        this.i = r4;
        this.h = r6;
    }

    public void a(boolean r1) {
        this.p = r1;
    }

    public void a(float r1) {
        this.n = r1;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public String a() {
        if (d_() == false) goto L6;
        return "cpu_thread";
    L6:
        return MonitorConstants.CPU;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject b() {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L31
        if (d_() == false) goto L20;
        Iterator<o<String, Double>> r8 = this.q.iterator();     // Catch: Throwable -> L31
    L7:
        if (r8.hasNext() == false) goto L30;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r8.next(), o.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        if (r2 == null) goto L7;
        if (r2.f4988a == 0) goto L7;
        if (((String) ZeusTransformUtils.preCheckCast(r2.f4988a, String.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L7;
        if (r2.f4989b == 0) goto L7;
        if (((Double) ZeusTransformUtils.preCheckCast(r2.f4989b, Double.class, "com.obric.aiagent.plugin")).doubleValue() == 0.0d) goto L7;
        r1.put((String) ZeusTransformUtils.preCheckCast(r2.f4988a, String.class, "com.obric.aiagent.plugin"), r2.f4989b);     // Catch: Throwable -> L31
    L30:
        return r1;
    L20:
        double r3 = this.j;     // Catch: Throwable -> L31
        if (r3 > (-1.0d)) goto L23;
    L25:
        double r4 = this.l;     // Catch: Throwable -> L31
        if (r4 <= (-1.0d)) goto L30;
        if (this.m <= (-1.0d)) goto L30;
        r1.put("app_stat_speed", r4);     // Catch: Throwable -> L31
        r1.put("app_max_stat_speed", this.m);     // Catch: Throwable -> L31
        goto L30
    L23:
        if (this.k <= (-1.0d)) goto L25;
        r1.put("app_usage_rate", r3);     // Catch: Throwable -> L31
        r1.put("app_max_usage_rate", this.k);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        a("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject c() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L14
        r0.put("process_name", com.bytedance.apm.c.c());     // Catch: Throwable -> L14
        r0.put("is_main_process", com.bytedance.apm.c.d());     // Catch: Throwable -> L14
        r0.put(DBHelper.BATTERY_COL_SCENE, this.i);     // Catch: Throwable -> L14
        int r3 = AnonymousClass1.f5213a[this.g.ordinal()];     // Catch: Throwable -> L14
        if (r3 != 1) goto L6;
        r0.put("data_type", "mix");     // Catch: Throwable -> L14
    L13:
        return r0;
    L6:
        if (r3 != 2) goto L8;
        r0.put("data_type", "back");     // Catch: Throwable -> L14
        goto L13
    L8:
        if (r3 != 3) goto L13;
        r0.put("data_type", DBHelper.COL_FRONT);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        a("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.a
    public JSONObject d() {
        JSONObject r1 = com.bytedance.apm6.perf.base.c.a().c();     // Catch: Throwable -> L10
        r1.put("is_auto_sample", this.o);     // Catch: Throwable -> L10
        if (this.h == null) goto L6;
        r1.put("network_type", i.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L10
        r1.put("battery_level", this.h.f11806c);     // Catch: Throwable -> L10
        r1.put("cpu_hardware", this.h.f11804a);     // Catch: Throwable -> L10
        r1.put("is_charging", this.h.f11805b);     // Catch: Throwable -> L10
        r1.put("power_save_mode", this.h.f11808e);     // Catch: Throwable -> L10
        r1.put("thermal_status", this.h.f11807d);     // Catch: Throwable -> L10
        r1.put("battery_thermal", this.h.f);     // Catch: Throwable -> L10
        r1.put("is_normal_sample_state", this.p);     // Catch: Throwable -> L10
    L6:
        float r5 = this.n;     // Catch: Throwable -> L10
        if (r5 <= 0.0f) goto L9;
        r1.put("battery_current", r5);     // Catch: Throwable -> L10
    L9:
        return r1;
    L10:
        th = move-exception;
        a("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    public boolean d_() {
        List<o<String, Double>> r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
