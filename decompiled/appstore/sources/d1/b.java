package d1;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import m1.e;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public long A;
    public long B;
    public int C;
    public int D;
    public int E;
    public int F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public long f18997J;
    public int K;
    public int L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f19001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f19002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f19004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f19005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f19007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f19008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f19009l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f19010m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f19011n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f19012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f19013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f19014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f19015r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f19016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f19017t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f19018u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19019v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f19020w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f19021x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f19022y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f19023z;

    public b() {
        this.f19002e = 0;
        this.f19003f = 0;
        this.f19004g = 0;
        this.f19005h = 0;
        this.f19006i = 0;
        this.f19007j = 0;
        this.f19008k = 0;
        this.f19009l = 0;
        this.f19010m = 0;
        this.f19011n = 0;
        this.f19012o = 0;
        this.f19013p = 0;
        this.f19014q = 0;
        this.f19015r = 0;
        this.f19016s = 0;
        this.f19017t = 0;
        this.f19018u = 0;
        this.f19020w = true;
        this.I = 0;
        this.f18997J = 0;
        this.Q = 0;
        this.R = 0;
    }

    public void A() {
        this.f19005h = this.C;
        this.f19002e = this.F;
        this.f19003f = this.D;
        this.f19004g = this.E;
        this.f18998a = this.A;
        this.f19006i = this.G;
        this.f19007j = this.H;
        this.f19008k = this.I;
        this.f19009l = this.f18997J;
        this.f19014q = this.K;
        this.f19011n = this.N;
        this.f19012o = this.L;
        this.f19013p = this.M;
        this.f18999b = this.B;
        this.f19015r = this.O;
        this.f19016s = this.P;
        this.f19017t = this.Q;
        this.f19018u = this.R;
        this.f19020w = false;
        this.f19021x = "all_process";
        this.f19019v = false;
        this.f19023z = "";
        z(false);     // Catch: Exception -> L5
        return;
    }

    public void B(boolean r10) {
        this.f19019v = r10;
    }

    public void C(boolean r10) {
        this.f19020w = r10;
    }

    public void D(String r10) {
        this.f19021x = r10;
    }

    public void E(String r10) {
        this.f19023z = r10;
    }

    public void F(String r10) {
        this.f19022y = r10;
    }

    public void a(long r10) {
        this.f19017t += r10;
    }

    public void b(long r10) {
        this.f19011n += r10;
    }

    public void c(long r10) {
        this.f18999b += r10;
    }

    public void d(long r10) {
        this.f19012o += r10;
    }

    public void e(long r10) {
        this.f19018u += r10;
    }

    public void f(long r10) {
        this.f19015r += r10;
    }

    public void g(long r10) {
        this.f19016s += r10;
    }

    public void h(long r10) {
        this.f19013p += r10;
    }

    public void i(long r10) {
        this.f19014q += r10;
    }

    public void j(long r10) {
        this.f19010m += r10;
    }

    public void k(long r10) {
        this.f19008k += r10;
    }

    public void l(long r10) {
        this.f19002e += r10;
    }

    public void m(long r10) {
        this.f18998a += r10;
    }

    public void n(long r10) {
        this.f19003f += r10;
    }

    public void o(long r10) {
        this.f19009l += r10;
    }

    public void p(long r10) {
        this.f19006i += r10;
    }

    public void q(long r10) {
        this.f19007j += r10;
    }

    public void r(long r10) {
        this.f19004g += r10;
    }

    public void s(long r10) {
        this.f19005h += r10;
    }

    public void t() {
        this.f18998a = 0;
        this.f18999b = 0;
        this.f19002e = 0;
        this.f19003f = 0;
        this.f19004g = 0;
        this.f19005h = 0;
        this.f19006i = 0;
        this.f19007j = 0;
        this.f19008k = 0;
        this.f19009l = 0;
        this.f19010m = 0;
        this.f19011n = 0;
        this.f19012o = 0;
        this.f19013p = 0;
        this.f19014q = 0;
        this.f19015r = 0;
        this.f19016s = 0;
        this.f19017t = 0;
        this.f19018u = 0;
        this.f19020w = true;
        this.f19019v = false;
        this.f19021x = "";
        this.f19022y = "";
        this.f19023z = "";
    }

    public final boolean u(boolean r10) {
        JSONObject r11 = v(r10);
        if (r11 != null) goto L6;
        return false;
    L6:
        if (r11.length() != 0) goto L8;
        return true;
    L8:
        JSONObject r12 = new JSONObject();
        r12.put("is_main_process", this.f19020w);
        r12.put("process_name", this.f19021x);
        r12.put("scene", this.f19023z);
        r12.put(CommonKey.KEY_IS_CHARGING, this.f19019v ? 1 : 0);
        JSONObject r13 = new JSONObject();
        r13.put("sid", this.f19022y);
        e r14 = new e("battery", "", r11, r12, r13);
        v1.b.a(r14, false);
        l1.a.p().e(r14);
        if (c.B() == false) goto L11;
        s1.c.d(s1.b.f24484b, new String[]{"stats report, processName: " + this.f19021x + " Json:" + r11.toString()});
    L11:
        return true;
    }

    public JSONObject v(boolean r21) {
        JSONObject r10 = new JSONObject();
        if (x() == false) goto L31;
        r10.put("front_alarm", this.f19005h);
        r10.put("front_loc_p_time", (this.f19003f * 1.0f) / 1000.0f);
        r10.put("front_power_p_time", (this.f19004g * 1.0f) / 1000.0f);
        long r11 = this.f19002e;
        if (r11 < 0) goto L8;
        r10.put("front_cpu_active_time_p_time", (r11 * 1.0f) / 1000.0f);
        double r12 = (((this.f19005h * 0.002083333383779973d) + (this.f19002e * 6.944444612599909E-5d)) + (this.f19003f * 7.499999810534064E-6d)) + (this.f19004g * 6.944444521650439E-6d);
        if (this.f19020w == true) goto L14;
        if (r21 == false) goto L14;
    L16:
        if (r12 < 0.0d) goto L18;
        r10.put("front_score", r12);
        r10.put("front_p_time", (this.f18998a * 1.0f) / 1000.0f);
        float r13 = 60000.0f / this.f18998a;
        r10.put("front_alarm_per_min", this.f19005h * r13);
        r10.put("front_loc_per_min_p_time", (this.f19003f / 1000.0f) * r13);
        r10.put("front_power_per_min_p_time", (this.f19004g / 1000.0f) * r13);
        r10.put("front_cpu_active_time_per_min_p_time", (this.f19002e / 1000.0f) * r13);
        if (this.f19020w == true) goto L24;
        if (r21 == false) goto L24;
    L25:
        r10.put("front_score_per_min", r12 * ((double) r13));
        if (this.f19020w == false) goto L28;
        r10.put("front_battery_consume", this.f19010m);
        r10.put("front_battery_consume_per_min", this.f19010m * r13);
    L28:
        if (r21 == false) goto L31;
        this.C = (int) (((long) this.C) + this.f19005h);
        this.F = (int) (((long) this.F) + this.f19002e);
        this.D = (int) (((long) this.D) + this.f19003f);
        this.E = (int) (((long) this.E) + this.f19004g);
        this.f19000c += this.f18998a;
        this.G += this.f19006i;
        this.H += this.f19007j;
        this.I += this.f19008k;
        this.f18997J += this.f19009l;
    L24:
        r10.put("front_traffic_per_min_p_capacity", (this.f19006i / 1024.0f) * r13);
        r10.put("front_traffic_packets_per_min", this.f19007j * r13);
        r10.put("front_traffic_all_iface_per_min", ((this.f19008k * 1.0f) / 1024.0f) * r13);
        r10.put("front_traffic_packets_all_iface_per_min", this.f19009l * r13);
        goto L25
    L18:
        if (c.B() == false) goto L20;
        s1.c.g(s1.b.f24484b, new String[]{" report data invalid, frontScore < 0 : " + r12});
    L20:
        return null;
    L14:
        r10.put("front_traffic_all_iface", (this.f19008k * 1.0f) / 1024.0f);
        r10.put("front_traffic_packets_all_iface", this.f19009l);
        r10.put("front_traffic_p_capacity", (this.f19006i * 1.0f) / 1024.0f);
        r10.put("front_traffic_packets", this.f19007j);
        r12 = r12 + (this.f19006i * 2.6666666030905617E-7d);
        goto L16
    L8:
        if (c.B() == false) goto L10;
        s1.c.g(s1.b.f24484b, new String[]{" report data invalid, frontCpuMs < 0 : " + this.f19002e});
    L10:
        return null;
    L31:
        if (w() == false) goto L50;
        r10.put("back_alarm", this.f19014q);
        r10.put("back_loc_p_time", (this.f19012o * 1.0f) / 1000.0f);
        r10.put("back_power_p_time", (this.f19013p * 1.0f) / 1000.0f);
        long r14 = this.f19011n;
        if (r14 < 0) goto L36;
        r10.put("back_cpu_active_time_p_time", (r14 * 1.0f) / 1000.0f);
        double r15 = (((this.f19014q * 0.002083333383779973d) + (this.f19011n * 6.944444612599909E-5d)) + (this.f19012o * 7.499999810534064E-6d)) + (this.f19013p * 6.944444521650439E-6d);
        if (this.f19020w == true) goto L42;
        if (r21 == false) goto L42;
    L43:
        r10.put("back_score", r15);
        r10.put("back_p_time", (this.f18999b * 1.0f) / 1000.0f);
        float r16 = 60000.0f / this.f18999b;
        r10.put("back_alarm_per_min", this.f19014q * r16);
        r10.put("back_loc_per_min_p_time", (this.f19012o / 1000.0f) * r16);
        r10.put("back_power_per_min_p_time", (this.f19013p / 1000.0f) * r16);
        r10.put("back_cpu_active_time_per_min_p_time", (this.f19011n / 1000.0f) * r16);
        if (this.f19020w == true) goto L46;
        if (r21 == false) goto L46;
    L47:
        r10.put("back_score_per_min", r15 * ((double) r16));
        if (r21 == false) goto L50;
        this.K = (int) (((long) this.K) + this.f19014q);
        this.N = (int) (((long) this.N) + this.f19011n);
        this.L = (int) (((long) this.L) + this.f19012o);
        this.M = (int) (((long) this.M) + this.f19013p);
        this.f19001d += this.f18999b;
        this.Q += this.f19017t;
        this.R += this.f19018u;
        this.O += this.f19015r;
        this.P += this.f19016s;
    L46:
        r10.put("back_traffic_all_iface_per_min", ((this.f19017t * 1.0f) / 1024.0f) * r16);
        r10.put("back_traffic_packets_all_iface_per_min", this.f19018u * r16);
        r10.put("back_traffic_per_min_p_capacity", (this.f19015r / 1024.0f) * r16);
        r10.put("back_traffic_packets_per_min", this.f19016s * r16);
    L42:
        r10.put("back_traffic_all_iface", (this.f19017t * 1.0f) / 1024.0f);
        r10.put("back_traffic_packets_all_iface", this.f19018u);
        r10.put("back_traffic_p_capacity", (this.f19015r * 1.0f) / 1024.0f);
        r10.put("back_traffic_packets", this.f19016s);
        r15 = r15 + (this.f19015r * 2.6666666030905617E-7d);
        goto L43
    L36:
        if (c.B() == false) goto L38;
        s1.c.g(s1.b.f24484b, new String[]{" report data invalid, mBackCpuMs < 0 : " + this.f19011n});
    L38:
        return null;
    L50:
        return r10;
    }

    public boolean w() {
        if (this.f18999b <= PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean x() {
        if (this.f18998a <= 10000) goto L5;
        return true;
    L5:
        return false;
    }

    public void y() {
        long r10 = this.f19000c;
        if (r10 <= this.A) goto L5;
        this.A = r10;
    L5:
        this.f19000c = 0;
        long r11 = this.f19001d;
        if (r11 <= this.B) goto L8;
        this.B = r11;
    L8:
        this.f19001d = 0;
    }

    public boolean z(boolean r10) {
        boolean r11 = u(r10);
        if (r11 == false) goto L5;
    L7:
        t();
        return r11;
    L5:
        if (c.B() == false) goto L7;
        s1.c.d(s1.b.f24484b, new String[]{"stats report failed, processName: " + this.f19021x});
        goto L7
    }
}
