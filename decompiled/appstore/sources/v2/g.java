package v2;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f25076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f25079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25080h;

    public g() {
    }

    public double a() {
        return this.f25076d;
    }

    public int b() {
        return this.f25080h;
    }

    public long c() {
        return this.f25079g;
    }

    public String d() {
        return this.f25078f;
    }

    public long e() {
        return this.f25075c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (f() != r11.f()) goto L14;
        if (g().equals(r11.g()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int f() {
        return this.f25073a;
    }

    public String g() {
        return this.f25074b;
    }

    public String h() {
        return this.f25077e;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(f()), g()});
    }

    public void i(double r10) {
        this.f25076d = r10;
    }

    public void j(int r10) {
        this.f25080h = r10;
    }

    public void k(long r10) {
        this.f25079g = r10;
    }

    public void l(String r10) {
        this.f25078f = r10;
    }

    public void m(long r10) {
        this.f25075c = r10;
    }

    public void n(int r10) {
        this.f25073a = r10;
    }

    public void o(String r10) {
        this.f25074b = r10;
    }

    public void p(String r10) {
        this.f25077e = r10;
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.f25073a + ", threadName='" + this.f25074b + "', threadCpuTime=" + this.f25075c + ", processCpuTime=" + this.f25079g + ", cpuUsage=" + this.f25076d + ", weight=" + this.f25077e + ", nice=" + this.f25080h + '}';
    }
}
