package as3;

import androidx.camera.video.AudioStats;
import com.bytedance.apm.d;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.dumper.Scraps;
import js3.e;
import org.json.JSONObject;
import ss3.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
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
    public long f16096J;
    public int K;
    public int L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f16097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f16098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f16100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f16101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f16102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f16103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f16104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f16105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f16106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f16107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f16108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f16109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f16110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f16111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f16112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f16113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f16114r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f16115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f16116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f16117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f16118v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f16119w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f16120x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f16121y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f16122z;

    public c() {
        this.f16101e = 0;
        this.f16102f = 0;
        this.f16103g = 0;
        this.f16104h = 0;
        this.f16105i = 0;
        this.f16106j = 0;
        this.f16107k = 0;
        this.f16108l = 0;
        this.f16109m = 0;
        this.f16110n = 0;
        this.f16111o = 0;
        this.f16112p = 0;
        this.f16113q = 0;
        this.f16114r = 0;
        this.f16115s = 0;
        this.f16116t = 0;
        this.f16117u = 0;
        this.f16119w = true;
        this.I = 0;
        this.f16096J = 0;
        this.Q = 0;
        this.R = 0;
    }

    public final JSONObject a(boolean r210) throws Exception {
        JSONObject r100 = new JSONObject();
        if (this.f16097a <= 10000) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L35;
        r100.put("front_alarm", this.f16104h);
        r100.put("front_loc_p_time", (this.f16102f * 1.0f) / 1000.0f);
        r100.put("front_power_p_time", (this.f16103g * 1.0f) / 1000.0f);
        long r102 = this.f16101e;
        if (r102 < 0) goto L12;
        r100.put("front_cpu_active_time_p_time", (r102 * 1.0f) / 1000.0f);
        double r103 = (((this.f16104h * 0.002083333383779973d) + (this.f16101e * 6.944444612599909E-5d)) + (this.f16102f * 7.499999810534064E-6d)) + (this.f16103g * 6.944444521650439E-6d);
        if (this.f16119w == true) goto L18;
        if (r210 == false) goto L18;
    L20:
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L22;
        r100.put("front_score", r103);
        r100.put("front_p_time", (this.f16097a * 1.0f) / 1000.0f);
        float r104 = 60000.0f / this.f16097a;
        r100.put("front_alarm_per_min", this.f16104h * r104);
        r100.put("front_loc_per_min_p_time", (this.f16102f / 1000.0f) * r104);
        r100.put("front_power_per_min_p_time", (this.f16103g / 1000.0f) * r104);
        r100.put("front_cpu_active_time_per_min_p_time", (this.f16101e / 1000.0f) * r104);
        if (this.f16119w == true) goto L28;
        if (r210 == false) goto L28;
    L29:
        r100.put("front_score_per_min", r103 * ((double) r104));
        if (this.f16119w == false) goto L32;
        r100.put("front_battery_consume", this.f16109m);
        r100.put("front_battery_consume_per_min", this.f16109m * r104);
    L32:
        if (r210 == false) goto L35;
        this.C = (int) (((long) this.C) + this.f16104h);
        this.F = (int) (((long) this.F) + this.f16101e);
        this.D = (int) (((long) this.D) + this.f16102f);
        this.E = (int) (((long) this.E) + this.f16103g);
        this.f16099c += this.f16097a;
        this.G += this.f16105i;
        this.H += this.f16106j;
        this.I += this.f16107k;
        this.f16096J += this.f16108l;
    L28:
        r100.put("front_traffic_per_min_p_capacity", (this.f16105i / 1024.0f) * r104);
        r100.put("front_traffic_packets_per_min", this.f16106j * r104);
        r100.put("front_traffic_all_iface_per_min", ((this.f16107k * 1.0f) / 1024.0f) * r104);
        r100.put("front_traffic_packets_all_iface_per_min", this.f16108l * r104);
        goto L29
    L22:
        if (d.j() == false) goto L24;
        ps3.b.a(new String[]{" report data invalid, frontScore < 0 : " + r103});
    L24:
        return null;
    L18:
        r100.put("front_traffic_all_iface", (this.f16107k * 1.0f) / 1024.0f);
        r100.put("front_traffic_packets_all_iface", this.f16108l);
        r100.put("front_traffic_p_capacity", (this.f16105i * 1.0f) / 1024.0f);
        r100.put("front_traffic_packets", this.f16106j);
        r103 = r103 + (this.f16105i * 2.6666666030905617E-7d);
        goto L20
    L12:
        if (d.j() == false) goto L14;
        ps3.b.a(new String[]{" report data invalid, frontCpuMs < 0 : " + this.f16101e});
    L14:
        return null;
    L35:
        if (this.f16098b <= 5000) goto L37;
        boolean r105 = true;
    L38:
        if (r105 == false) goto L57;
        r100.put("back_alarm", this.f16113q);
        r100.put("back_loc_p_time", (this.f16111o * 1.0f) / 1000.0f);
        r100.put("back_power_p_time", (this.f16112p * 1.0f) / 1000.0f);
        long r106 = this.f16110n;
        if (r106 < 0) goto L43;
        r100.put("back_cpu_active_time_p_time", (r106 * 1.0f) / 1000.0f);
        double r107 = (((this.f16113q * 0.002083333383779973d) + (this.f16110n * 6.944444612599909E-5d)) + (this.f16111o * 7.499999810534064E-6d)) + (this.f16112p * 6.944444521650439E-6d);
        if (this.f16119w == true) goto L49;
        if (r210 == false) goto L49;
    L50:
        r100.put("back_score", r107);
        r100.put("back_p_time", (this.f16098b * 1.0f) / 1000.0f);
        float r108 = 60000.0f / this.f16098b;
        r100.put("back_alarm_per_min", this.f16113q * r108);
        r100.put("back_loc_per_min_p_time", (this.f16111o / 1000.0f) * r108);
        r100.put("back_power_per_min_p_time", (this.f16112p / 1000.0f) * r108);
        r100.put("back_cpu_active_time_per_min_p_time", (this.f16110n / 1000.0f) * r108);
        if (this.f16119w == true) goto L53;
        if (r210 == false) goto L53;
    L54:
        r100.put("back_score_per_min", r107 * ((double) r108));
        if (r210 == false) goto L57;
        this.K = (int) (((long) this.K) + this.f16113q);
        this.N = (int) (((long) this.N) + this.f16110n);
        this.L = (int) (((long) this.L) + this.f16111o);
        this.M = (int) (((long) this.M) + this.f16112p);
        this.f16100d += this.f16098b;
        this.Q += this.f16116t;
        this.R += this.f16117u;
        this.O += this.f16114r;
        this.P += this.f16115s;
    L53:
        r100.put("back_traffic_all_iface_per_min", ((this.f16116t * 1.0f) / 1024.0f) * r108);
        r100.put("back_traffic_packets_all_iface_per_min", this.f16117u * r108);
        r100.put("back_traffic_per_min_p_capacity", (this.f16114r / 1024.0f) * r108);
        r100.put("back_traffic_packets_per_min", this.f16115s * r108);
    L49:
        r100.put("back_traffic_all_iface", (this.f16116t * 1.0f) / 1024.0f);
        r100.put("back_traffic_packets_all_iface", this.f16117u);
        r100.put("back_traffic_p_capacity", (this.f16114r * 1.0f) / 1024.0f);
        r100.put("back_traffic_packets", this.f16115s);
        r107 = r107 + (this.f16114r * 2.6666666030905617E-7d);
        goto L50
    L43:
        if (d.j() == false) goto L45;
        ps3.b.a(new String[]{" report data invalid, mBackCpuMs < 0 : " + this.f16110n});
    L45:
        return null;
    L57:
        return r100;
    L37:
        r105 = false;
        goto L38
    L5:
        r101 = false;
        goto L7
    }

    public final boolean b(boolean r110) throws Exception {
        JSONObject r111 = a(r110);
        if (r111 != null) goto L6;
        boolean r112 = false;
    L12:
        if (r112 == false) goto L14;
    L16:
        this.f16097a = 0;
        this.f16098b = 0;
        this.f16101e = 0;
        this.f16102f = 0;
        this.f16103g = 0;
        this.f16104h = 0;
        this.f16105i = 0;
        this.f16106j = 0;
        this.f16107k = 0;
        this.f16108l = 0;
        this.f16109m = 0;
        this.f16110n = 0;
        this.f16111o = 0;
        this.f16112p = 0;
        this.f16113q = 0;
        this.f16114r = 0;
        this.f16115s = 0;
        this.f16116t = 0;
        this.f16117u = 0;
        this.f16119w = true;
        this.f16118v = false;
        this.f16120x = "";
        this.f16121y = "";
        this.f16122z = "";
        return r112;
    L14:
        if (d.j() == false) goto L16;
        ps3.b.a(new String[]{"stats report failed, processName: " + this.f16120x});
        goto L16
    L6:
        if (r111.length() == 0) goto L11;
        JSONObject r100 = new JSONObject();
        r100.put(LocationMonitorConst.IS_MAIN_PROCESS, this.f16119w);
        r100.put("process_name", this.f16120x);
        r100.put("scene", this.f16122z);
        r100.put("is_charging", this.f16118v ? 1 : 0);
        JSONObject r101 = new JSONObject();
        r101.put(WsConstants.KEY_SESSION_ID, this.f16121y);
        e r102 = new e(Scraps.BATTERY, "", r111, r100, r101);
        r102.f500222f = f.a().b(false);
        is3.a.h().b(r102);
        if (d.j() == false) goto L11;
        ps3.b.a(new String[]{"stats report, processName: " + this.f16120x + " Json:" + r111.toString()});
    L11:
        r112 = true;
        goto L12
    }
}
