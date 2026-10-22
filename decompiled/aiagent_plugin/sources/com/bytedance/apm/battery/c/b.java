package com.bytedance.apm.battery.c;

import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.c;
import com.bytedance.apm.h.e;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONObject;

/* JADX INFO: compiled from: BatteryStatsRet.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private long A;
    private long B;
    private int C;
    private int D;
    private int E;
    private int F;
    private long G;
    private long H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private long f4271J;
    private int K;
    private int L;
    private int M;
    private int N;
    private long O;
    private long P;
    private long Q;
    private long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f4276e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private String z;

    public b() {
        this.f4276e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.w = true;
        this.I = 0;
        this.f4271J = 0;
        this.Q = 0;
        this.R = 0;
    }

    void a(long r3) {
        this.f4273b += r3;
    }

    public void b(long r3) {
        this.n += r3;
    }

    public void c(long r3) {
        this.p += r3;
    }

    public void d(long r3) {
        this.r += r3;
    }

    public void e(long r3) {
        this.s += r3;
    }

    public void f(long r3) {
        this.t += r3;
    }

    public void g(long r3) {
        this.u += r3;
    }

    public void h(long r3) {
        this.o += r3;
    }

    public void i(long r3) {
        this.q += r3;
    }

    void j(long r3) {
        this.f4272a += r3;
    }

    public void k(long r3) {
        this.f4276e += r3;
    }

    public void l(long r3) {
        this.g += r3;
    }

    public void m(long r3) {
        this.i += r3;
    }

    public void n(long r3) {
        this.j += r3;
    }

    public void o(long r3) {
        this.k += r3;
    }

    public void p(long r3) {
        this.l += r3;
    }

    public void q(long r3) {
        this.f += r3;
    }

    public void r(long r3) {
        this.h += r3;
    }

    public void s(long r3) {
        this.m += r3;
    }

    void a(boolean r1) {
        this.w = r1;
    }

    void b(boolean r1) {
        this.v = r1;
    }

    void a(String r1) {
        this.x = r1;
    }

    void b(String r1) {
        this.y = r1;
    }

    void c(String r1) {
        this.z = r1;
    }

    void a() {
        this.f4272a = 0;
        this.f4273b = 0;
        this.f4276e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.w = true;
        this.v = false;
        this.x = "";
        this.y = "";
        this.z = "";
    }

    void b() {
        this.h = this.C;
        this.f4276e = this.F;
        this.f = this.D;
        this.g = this.E;
        this.f4272a = this.A;
        this.i = this.G;
        this.j = this.H;
        this.k = this.I;
        this.l = this.f4271J;
        this.q = this.K;
        this.n = this.N;
        this.o = this.L;
        this.p = this.M;
        this.f4273b = this.B;
        this.r = this.O;
        this.s = this.P;
        this.t = this.Q;
        this.u = this.R;
        this.w = false;
        this.x = "all_process";
        this.v = false;
        this.z = "";
        c(false);     // Catch: Exception -> L5
        return;
    }

    boolean c() {
        if (this.f4272a <= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    boolean d() {
        if (this.f4273b <= 5000) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean c(boolean r6) {
        boolean r7 = e(r6);
        if (r7 == false) goto L5;
    L7:
        a();
        return r7;
    L5:
        if (c.i() == false) goto L7;
        e.c(com.bytedance.apm.h.b.f4646b, new String[]{"stats report failed, processName: " + this.x});
        goto L7
    }

    public void e() {
        long r0 = this.f4274c;
        if (r0 <= this.A) goto L5;
        this.A = r0;
    L5:
        this.f4274c = 0;
        long r2 = this.f4275d;
        if (r2 <= this.B) goto L8;
        this.B = r2;
    L8:
        this.f4275d = 0;
    }

    private boolean e(boolean r10) {
        JSONObject r11 = d(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.length() != 0) goto L8;
        return true;
    L8:
        JSONObject r4 = new JSONObject();
        r4.put("is_main_process", this.w);
        r4.put("process_name", this.x);
        r4.put(DBHelper.BATTERY_COL_SCENE, this.z);
        r4.put("is_charging", this.v ? 1 : 0);
        JSONObject r5 = new JSONObject();
        r5.put("sid", this.y);
        com.bytedance.apm.d.b.e r8 = new com.bytedance.apm.d.b.e(Scraps.BATTERY, "", r11, r4, r5);
        com.bytedance.apm.perf.b.a(r8, false);
        com.bytedance.apm.d.a.a.c().a(r8);
        if (c.i() == false) goto L11;
        e.c(com.bytedance.apm.h.b.f4646b, new String[]{"stats report, processName: " + this.x + " Json:" + r11.toString()});
    L11:
        return true;
    }

    public JSONObject d(boolean r24) {
        JSONObject r1 = new JSONObject();
        if (c() == false) goto L31;
        r1.put("front_alarm", this.h);
        r1.put("front_loc_p_time", (this.f * 1.0f) / 1000.0f);
        r1.put("front_power_p_time", (this.g * 1.0f) / 1000.0f);
        long r4 = this.f4276e;
        if (r4 < 0) goto L8;
        r1.put("front_cpu_active_time_p_time", (r4 * 1.0f) / 1000.0f);
        double r5 = (((this.h * 0.002083333383779973d) + (this.f4276e * 6.944444612599909E-5d)) + (this.f * 7.499999810534064E-6d)) + (this.g * 6.944444521650439E-6d);
        if (this.w == true) goto L14;
        if (r24 == false) goto L14;
    L16:
        if (r5 < 0.0d) goto L18;
        r1.put("front_score", r5);
        r1.put("front_p_time", (this.f4272a * 1.0f) / 1000.0f);
        float r2 = 60000.0f / this.f4272a;
        r1.put("front_alarm_per_min", this.h * r2);
        r1.put("front_loc_per_min_p_time", (this.f / 1000.0f) * r2);
        r1.put("front_power_per_min_p_time", (this.g / 1000.0f) * r2);
        r1.put("front_cpu_active_time_per_min_p_time", (this.f4276e / 1000.0f) * r2);
        if (this.w == true) goto L24;
        if (r24 == false) goto L24;
    L25:
        r1.put("front_score_per_min", r5 * ((double) r2));
        if (this.w == false) goto L28;
        r1.put("front_battery_consume", this.m);
        r1.put("front_battery_consume_per_min", this.m * r2);
    L28:
        if (r24 == false) goto L31;
        this.C = (int) (((long) this.C) + this.h);
        this.F = (int) (((long) this.F) + this.f4276e);
        this.D = (int) (((long) this.D) + this.f);
        this.E = (int) (((long) this.E) + this.g);
        this.f4274c += this.f4272a;
        this.G += this.i;
        this.H += this.j;
        this.I += this.k;
        this.f4271J += this.l;
    L24:
        r1.put("front_traffic_per_min_p_capacity", (this.i / 1024.0f) * r2);
        r1.put("front_traffic_packets_per_min", this.j * r2);
        r1.put("front_traffic_all_iface_per_min", ((this.k * 1.0f) / 1024.0f) * r2);
        r1.put("front_traffic_packets_all_iface_per_min", this.l * r2);
        goto L25
    L18:
        if (c.i() == false) goto L20;
        e.b(com.bytedance.apm.h.b.f4646b, new String[]{" report data invalid, frontScore < 0 : " + r5});
    L20:
        return null;
    L14:
        r1.put("front_traffic_all_iface", (this.k * 1.0f) / 1024.0f);
        r1.put("front_traffic_packets_all_iface", this.l);
        r1.put("front_traffic_p_capacity", (this.i * 1.0f) / 1024.0f);
        r1.put("front_traffic_packets", this.j);
        r5 = r5 + (this.i * 2.6666666030905617E-7d);
        goto L16
    L8:
        if (c.i() == false) goto L10;
        e.b(com.bytedance.apm.h.b.f4646b, new String[]{" report data invalid, frontCpuMs < 0 : " + this.f4276e});
    L10:
        return null;
    L31:
        if (d() == false) goto L50;
        r1.put("back_alarm", this.q);
        r1.put("back_loc_p_time", (this.o * 1.0f) / 1000.0f);
        r1.put("back_power_p_time", (this.p * 1.0f) / 1000.0f);
        long r6 = this.n;
        if (r6 < 0) goto L36;
        r1.put("back_cpu_active_time_p_time", (r6 * 1.0f) / 1000.0f);
        double r3 = (((this.q * 0.002083333383779973d) + (this.n * 6.944444612599909E-5d)) + (this.o * 7.499999810534064E-6d)) + (this.p * 6.944444521650439E-6d);
        if (this.w == true) goto L42;
        if (r24 == false) goto L42;
    L43:
        r1.put("back_score", r3);
        r1.put("back_p_time", (this.f4273b * 1.0f) / 1000.0f);
        float r7 = 60000.0f / this.f4273b;
        r1.put("back_alarm_per_min", this.q * r7);
        r1.put("back_loc_per_min_p_time", (this.o / 1000.0f) * r7);
        r1.put("back_power_per_min_p_time", (this.p / 1000.0f) * r7);
        r1.put("back_cpu_active_time_per_min_p_time", (this.n / 1000.0f) * r7);
        if (this.w == true) goto L46;
        if (r24 == false) goto L46;
    L47:
        r1.put("back_score_per_min", r3 * ((double) r7));
        if (r24 == false) goto L50;
        this.K = (int) (((long) this.K) + this.q);
        this.N = (int) (((long) this.N) + this.n);
        this.L = (int) (((long) this.L) + this.o);
        this.M = (int) (((long) this.M) + this.p);
        this.f4275d += this.f4273b;
        this.Q += this.t;
        this.R += this.u;
        this.O += this.r;
        this.P += this.s;
    L46:
        r1.put("back_traffic_all_iface_per_min", ((this.t * 1.0f) / 1024.0f) * r7);
        r1.put("back_traffic_packets_all_iface_per_min", this.u * r7);
        r1.put("back_traffic_per_min_p_capacity", (this.r / 1024.0f) * r7);
        r1.put("back_traffic_packets_per_min", this.s * r7);
    L42:
        r1.put("back_traffic_all_iface", (this.t * 1.0f) / 1024.0f);
        r1.put("back_traffic_packets_all_iface", this.u);
        r1.put("back_traffic_p_capacity", (this.r * 1.0f) / 1024.0f);
        r1.put("back_traffic_packets", this.s);
        r3 = r3 + (this.r * 2.6666666030905617E-7d);
        goto L43
    L36:
        if (c.i() == false) goto L38;
        e.b(com.bytedance.apm.h.b.f4646b, new String[]{" report data invalid, mBackCpuMs < 0 : " + this.n});
    L38:
        return null;
    L50:
        return r1;
    }
}
