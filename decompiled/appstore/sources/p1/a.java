package p1;

import com.bytedance.apm.constant.CommonKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f23269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f23270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f23271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f23273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f23275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f23276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f23277m;

    public a(boolean r10, long r11, String r12, boolean r13, long r14, String r15) {
        this.f23266b = r10;
        this.f23267c = r11;
        this.f23268d = r12;
        this.f23269e = r13;
        this.f23271g = r14;
        this.f23270f = r15;
    }

    public long a() {
        return this.f23271g;
    }

    public long b() {
        return this.f23265a;
    }

    public String c() {
        return this.f23274j;
    }

    public String d() {
        return this.f23270f;
    }

    public String e() {
        return this.f23272h;
    }

    public String f() {
        return this.f23276l;
    }

    public long g() {
        return this.f23267c;
    }

    public String h() {
        return this.f23268d;
    }

    public long i() {
        return this.f23273i;
    }

    public boolean j() {
        return !this.f23266b;
    }

    public boolean k() {
        return this.f23266b;
    }

    public boolean l() {
        return this.f23275k;
    }

    public boolean m() {
        return this.f23269e;
    }

    public boolean n() {
        return this.f23269e;
    }

    public void o(long r10) {
        this.f23265a = r10;
    }

    public void p(boolean r10) {
        this.f23275k = r10;
    }

    public void q(String r10) {
        this.f23274j = r10;
    }

    public void r(String r10) {
        this.f23270f = r10;
    }

    public void s(String r10) {
        this.f23276l = r10;
    }

    public void t(boolean r10) {
        this.f23269e = r10;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.f23265a + ", front=" + this.f23266b + ", time=" + this.f23267c + ", type='" + this.f23268d + "', status=" + this.f23269e + ", scene='" + this.f23270f + "', accumulation=" + this.f23271g + ", source='" + this.f23272h + "', versionId=" + this.f23273i + ", processName='" + this.f23274j + "', mainProcess=" + this.f23275k + ", startUuid='" + this.f23276l + "', deleteFlag=" + this.f23277m + '}';
    }

    public void u(long r10) {
        this.f23273i = r10;
    }

    public JSONObject v() {
        JSONObject r10 = new JSONObject();
        r10.put(CommonKey.KEY_FRONT, this.f23266b);
        r10.put("time", this.f23267c);
        r10.put("type", this.f23268d);
        r10.put("scene", this.f23270f);
        r10.put("processName", this.f23274j);
        return r10;
    }

    public a(boolean r10, long r11, String r12, boolean r13, long r14, String r15, String r16) {
        this.f23266b = r10;
        this.f23267c = r11;
        this.f23268d = r12;
        this.f23269e = r13;
        this.f23271g = r14;
        this.f23270f = r15;
        this.f23272h = r16;
    }
}
