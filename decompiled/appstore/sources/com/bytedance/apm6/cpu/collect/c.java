package com.bytedance.apm6.cpu.collect;

import android.util.Log;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.util.m;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends n3.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CpuCacheItem.CpuDataType f6778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IAssistStat.b f6779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public double f6781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public double f6782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public double f6783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f6784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f6788r;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6789a = null;

        static {
            int[] r10 = new int[CpuCacheItem.CpuDataType.values().length];
            f6789a = r10;
            r10[CpuCacheItem.CpuDataType.MIX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f6789a[CpuCacheItem.CpuDataType.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f6789a[CpuCacheItem.CpuDataType.FRONT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public c(CpuCacheItem.CpuDataType r10, String r11, double r12, double r13, double r14, double r15, IAssistStat.b r16) {
        this.f6785o = -1.0f;
        this.f6786p = true;
        this.f6787q = true;
        this.f6778h = r10;
        this.f6780j = r11;
        this.f6781k = r12;
        this.f6782l = r13;
        this.f6783m = r14;
        this.f6784n = r15;
        this.f6779i = r16;
    }

    @Override // n3.a
    public JSONObject b() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L11
        r10.put("process_name", w0.c.h());     // Catch: Throwable -> L11
        r10.put("is_main_process", w0.c.F());     // Catch: Throwable -> L11
        r10.put("scene", this.f6780j);     // Catch: Throwable -> L11
        int r11 = a.f6789a[this.f6778h.ordinal()];     // Catch: Throwable -> L11
        if (r11 != 1) goto L6;
        r10.put("data_type", "mix");     // Catch: Throwable -> L11
    L15:
        return r10;
    L6:
        if (r11 != 2) goto L8;
        r10.put("data_type", "back");     // Catch: Throwable -> L11
        goto L15
    L8:
        if (r11 != 3) goto L15;
        r10.put("data_type", CommonKey.KEY_FRONT);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // n3.a
    public JSONObject c() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L19
        if (f() == false) goto L21;
        Iterator r11 = this.f6788r.iterator();     // Catch: Throwable -> L19
    L6:
        if (r11.hasNext() == false) goto L31;
        m r12 = (m) r11.next();     // Catch: Throwable -> L19
        if (r12 == null) goto L6;
        Object r13 = r12.f6665a;     // Catch: Throwable -> L19
        if (r13 == null) goto L6;
        if (((String) r13).isEmpty() == true) goto L6;
        Object r14 = r12.f6666b;     // Catch: Throwable -> L19
        if (r14 == null) goto L6;
        if (((Double) r14).doubleValue() == 0.0d) goto L6;
        r10.put((String) r12.f6665a, r12.f6666b);     // Catch: Throwable -> L19
    L31:
        return r10;
    L21:
        double r15 = this.f6781k;     // Catch: Throwable -> L19
        if (r15 > (-1.0d)) goto L24;
    L26:
        double r16 = this.f6783m;     // Catch: Throwable -> L19
        if (r16 <= (-1.0d)) goto L31;
        if (this.f6784n <= (-1.0d)) goto L31;
        r10.put(PerfConsts.PERF_APP_STAT_SPEED, r16);     // Catch: Throwable -> L19
        r10.put(PerfConsts.PERF_APP_MAX_STAT_SPEED, this.f6784n);     // Catch: Throwable -> L19
        goto L31
    L24:
        if (this.f6782l <= (-1.0d)) goto L26;
        r10.put(PerfConsts.PERF_CPU_APP_USAGE_RATE, r15);     // Catch: Throwable -> L19
        r10.put(PerfConsts.PERF_CPU_APP_MAX_USAGE_RATE, this.f6782l);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // n3.a
    public JSONObject d() {
        JSONObject r10 = m3.c.a().getPerfFiltersJson();     // Catch: Throwable -> L5
        r10.put("is_auto_sample", this.f6786p);     // Catch: Throwable -> L5
        if (this.f6779i == null) goto L7;
        r10.put("network_type", NetworkUtils.g(w0.c.g()));     // Catch: Throwable -> L5
        r10.put("battery_level", this.f6779i.f8218c);     // Catch: Throwable -> L5
        r10.put("cpu_hardware", this.f6779i.f8216a);     // Catch: Throwable -> L5
        r10.put(CommonKey.KEY_IS_CHARGING, this.f6779i.f8217b);     // Catch: Throwable -> L5
        r10.put("power_save_mode", this.f6779i.f8220e);     // Catch: Throwable -> L5
        r10.put("thermal_status", this.f6779i.f8219d);     // Catch: Throwable -> L5
        r10.put("battery_thermal", this.f6779i.f8221f);     // Catch: Throwable -> L5
        r10.put("is_normal_sample_state", this.f6787q);     // Catch: Throwable -> L5
    L7:
        float r11 = this.f6785o;     // Catch: Throwable -> L5
        if (r11 <= 0.0f) goto L10;
        r10.put("battery_current", r11);     // Catch: Throwable -> L5
    L10:
        return r10;
    L5:
        th = move-exception;
        Log.e("APM-CPU", "error: " + th.getLocalizedMessage());
        return null;
    }

    @Override // n3.a
    public String e() {
        if (f() == false) goto L6;
        return "cpu_thread";
    L6:
        return "cpu";
    }

    public boolean f() {
        List r10 = this.f6788r;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L7;
        return true;
    }

    public void g(float r10) {
        this.f6785o = r10;
    }

    public void h(boolean r10) {
        this.f6787q = r10;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    public c(CpuCacheItem.CpuDataType r10, String r11, List r12, IAssistStat.b r13) {
        this.f6781k = -1.0d;
        this.f6782l = -1.0d;
        this.f6783m = -1.0d;
        this.f6784n = -1.0d;
        this.f6785o = -1.0f;
        this.f6786p = true;
        this.f6787q = true;
        this.f6788r = new ArrayList(r12);
        this.f6778h = r10;
        this.f6780j = r11;
        this.f6779i = r13;
    }
}
