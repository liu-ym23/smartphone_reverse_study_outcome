package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: MonitorConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f5773a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f5774b = 1024;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f5775c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f5776d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile long f5777e = 300000;
    public static volatile long f = 30000;
    public static volatile int g = 7;
    public static volatile boolean h = false;
    public static volatile int i;
    public static volatile Map<String, Integer> j;
    private SharedPreferences k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private long p;
    private long q;
    private int r;
    private boolean s;
    private int t;
    private Map<String, Integer> u;
    private JSONObject v;
    private volatile boolean w;

    static {
    }

    public c() {
        this.l = f5773a;
        this.m = f5774b * 1024;
        this.n = f5775c;
        this.o = f5776d;
        this.p = f5777e;
        this.q = f;
        this.r = g;
        this.s = h;
        this.t = i;
        this.u = j;
        this.v = null;
        this.w = false;
    }

    public void a(boolean r1) {
        if (r1 == true) goto L5;
        this.w = false;
        return;
    L5:
        this.w = true;
        f5773a = true;
        h = true;
        i = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
        j = null;
        this.l = f5773a;
        this.s = h;
        this.t = i;
        this.u = j;
    }

    public void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.k = r5.getSharedPreferences(r4 + "@applog_monitor_config", 0);
        l();
    }

    public boolean a() {
        return this.l;
    }

    public int b() {
        return this.m;
    }

    public int c() {
        return this.n;
    }

    public boolean d() {
        return this.o;
    }

    public long e() {
        return this.p;
    }

    public long f() {
        return this.q;
    }

    public int g() {
        return this.r;
    }

    public boolean h() {
        return this.s;
    }

    public int i() {
        return this.t;
    }

    public boolean j() {
        return this.w;
    }

    public Map<String, Integer> k() {
        return this.u;
    }

    public void a(JSONObject r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SharedPreferences.Editor r0 = null;
        SharedPreferences r1 = this.k;
        if (r1 == null) goto L7;
        r0 = r1.edit();
    L8:
        boolean r3 = false;
        if (r8.optInt("enabled", f5773a ? 1 : 0) != 1) goto L11;
        boolean r2 = true;
    L12:
        this.l = r2;
        if (r0 == null) goto L16;
        r0.putBoolean("enabled", r2);
    L16:
        if (r8.has("max_request_body_size_kb") == false) goto L21;
        int r4 = r8.optInt("max_request_body_size_kb", f5774b) * 1024;
        this.m = r4;
        if (r0 == null) goto L21;
        r0.putInt("max_request_body_size_kb", r4);
    L21:
        if (r8.has("max_request_count") == false) goto L26;
        int r5 = r8.optInt("max_request_count", f5775c);
        this.n = r5;
        if (r0 == null) goto L26;
        r0.putInt("max_request_count", r5);
    L26:
        if (r8.has("error_report_enable") == false) goto L35;
        if (r8.optInt("error_report_enable", f5776d ? 1 : 0) != 1) goto L30;
        boolean r6 = true;
    L31:
        this.o = r6;
        if (r0 == null) goto L35;
        r0.putBoolean("error_report_enable", r6);
        goto L35
    L30:
        r6 = false;
    L35:
        if (r8.has("report_interval_ms") == false) goto L40;
        long r7 = r8.optLong("report_interval_ms", f5777e);
        this.p = r7;
        if (r0 == null) goto L40;
        r0.putLong("report_interval_ms", r7);
    L40:
        if (r8.has("coldstart_report_delay_ms") == false) goto L45;
        long r9 = r8.optLong("coldstart_report_delay_ms", f);
        this.q = r9;
        if (r0 == null) goto L45;
        r0.putLong("coldstart_report_delay_ms", r9);
    L45:
        if (r8.has("data_keep_alive_days") == false) goto L50;
        int r10 = r8.optInt("data_keep_alive_days", g);
        this.r = r10;
        if (r0 == null) goto L50;
        r0.putLong("data_keep_alive_days", r10);
    L50:
        if (r8.has("sentry_enabled") == false) goto L58;
        if (r8.optInt("sentry_enabled", h ? 1 : 0) != 1) goto L54;
        r3 = true;
    L54:
        this.s = r3;
        if (r0 == null) goto L58;
        r0.putBoolean("sentry_enabled", r3);
    L58:
        if (r8.has("sentry_coldstart_sampling_rate") == false) goto L63;
        int r11 = r8.optInt("sentry_coldstart_sampling_rate", i);
        this.t = r11;
        if (r0 == null) goto L63;
        r0.putInt("sentry_coldstart_sampling_rate", r11);
    L63:
        if (r8.has("sentry_events") == false) goto L67;
        JSONObject r12 = r8.optJSONObject("sentry_events");
        b(r12);
        if (r0 == null) goto L67;
        r0.putString("sentry_events", r12.toString());
    L67:
        if (r0 == null) goto L70;
        r0.apply();
    L70:
        if (this.w == false) goto L73;
        a(true);
        return;
    L73:
        return;
    L11:
        r2 = false;
        goto L12
    L7:
        this.v = r8;
        goto L8
    }

    private void l() {
        JSONObject r0 = this.v;
        if (r0 == null) goto L9;
        if (this.k == null) goto L9;
        a(r0);
        return;
    L9:
        if (this.k.contains("enabled") == true) goto L11;
        this.l = f5773a;
        this.m = f5774b * 1024;
        this.n = f5775c;
        this.o = f5776d;
        this.p = f5777e;
        this.q = f;
        this.r = g;
        this.s = h;
        this.t = i;
        this.u = j;
    L15:
        if (this.w == false) goto L21;
        a(true);
        return;
    L21:
        return;
    L11:
        this.l = this.k.getBoolean("enabled", f5773a);
        this.m = this.k.getInt("max_request_body_size_kb", f5774b * 1024);
        this.n = this.k.getInt("max_request_count", f5775c);
        this.o = this.k.getBoolean("error_report_enable", f5776d);
        this.p = this.k.getLong("report_interval_ms", f5777e);
        this.q = this.k.getLong("coldstart_report_delay_ms", f);
        this.r = this.k.getInt("data_keep_alive_days", g);
        this.s = this.k.getBoolean("sentry_enabled", h);
        this.t = this.k.getInt("sentry_coldstart_sampling_rate", i);
        String r1 = this.k.getString("sentry_events", null);
        if (TextUtils.isEmpty(r1) == true) goto L15;
        b(new JSONObject(r1));     // Catch: Throwable -> L18
        goto L15
    }

    private void b(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.u.clear();
        Iterator<String> r0 = r5.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        int r2 = r5.optInt(r1, 0);
        if (r2 <= 0) goto L6;
        if (r2 > 10000) goto L6;
        this.u.put(r1, Integer.valueOf(r2));
        goto L6
    }
}
