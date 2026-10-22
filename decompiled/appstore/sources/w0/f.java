package w0;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f25280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f25281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f25282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map f25283l;

    public f() {
    }

    public int a() {
        return this.f25272a;
    }

    public String b() {
        return this.f25280i;
    }

    public String c() {
        return this.f25275d;
    }

    public String d() {
        return this.f25273b;
    }

    public int e() {
        return this.f25278g;
    }

    public Map f() {
        return this.f25283l;
    }

    public String g() {
        return this.f25281j;
    }

    public String h() {
        if (c.i() != null) goto L5;
        return null;
    L5:
        return c.i().getSessionId();
    }

    public JSONObject i() {
        return this.f25282k;
    }

    public long j() {
        if (c.i() != null) goto L5;
        return 0;
    L5:
        return c.i().getUid();
    }

    public int k() {
        return this.f25276e;
    }

    public String l() {
        return this.f25277f;
    }

    public void m(int r10) {
        this.f25272a = r10;
    }

    public void n(String r10) {
        this.f25280i = r10;
    }

    public void o(String r10) {
        this.f25275d = r10;
    }

    public void p(String r10) {
        this.f25273b = r10;
    }

    public void q(int r10) {
        this.f25278g = r10;
    }

    public void r(Map r10) {
        this.f25283l = r10;
    }

    public void s(String r10) {
        this.f25274c = r10;
    }

    public void t(String r10) {
        this.f25281j = r10;
    }

    public void u(JSONObject r10) {
        this.f25282k = r10;
    }

    public void v(int r10) {
        this.f25276e = r10;
    }

    public void w(int r10) {
        this.f25279h = r10;
    }

    public void x(String r10) {
        this.f25277f = r10;
    }
}
