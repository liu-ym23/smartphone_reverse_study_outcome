package q9;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f23587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f23588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f23591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f23592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f23593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f23594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f23595k;

    public c() {
    }

    public int a(c r10) {
        return this.f23588d.compareTo(r10.f23588d);
    }

    public float b() {
        return this.f23585a;
    }

    public String c() {
        return "seg_" + this.f23586b + ".ts";
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return a((c) r10);
    }

    public String d() {
        return this.f23594j;
    }

    public String e() {
        return this.f23593i;
    }

    public String f() {
        return "local.key";
    }

    public String g() {
        return this.f23592h;
    }

    public String h(String r10, int r11, String r12) {
        return String.format(Locale.US, "http://%s:%d/%s%s/%s/%s", new Object[]{r10, Integer.valueOf(r11), u9.d.e(this.f23587c), "&jeffmony&", r12, c()});
    }

    public long i() {
        return this.f23589e;
    }

    public String j() {
        return this.f23587c;
    }

    public boolean k() {
        return this.f23590f;
    }

    public boolean l() {
        return this.f23591g;
    }

    public void m(String r10, float r11, int r12, boolean r13, boolean r14) {
        this.f23587c = r10;
        this.f23588d = r10;
        this.f23585a = r11;
        this.f23586b = r12;
        this.f23590f = r13;
        this.f23591g = r14;
        this.f23589e = 0;
    }

    public boolean n() {
        return this.f23595k;
    }

    public void o(boolean r10) {
        this.f23595k = r10;
    }

    public void p(String r10, String r11, String r12) {
        this.f23592h = r10;
        this.f23593i = r11;
        this.f23594j = r12;
    }

    public void q(String r10) {
        this.f23588d = r10;
    }

    public void r(long r10) {
        this.f23589e = r10;
    }

    public String toString() {
        return "duration=" + this.f23585a + ", index=" + this.f23586b + ", name=" + this.f23588d;
    }
}
