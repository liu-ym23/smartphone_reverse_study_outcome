package u2;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f24828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f24829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f24830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f24831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map f24833h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f24834i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f24835j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24836k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24837l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f24838m;

    public b() {
        this.f24826a = false;
        this.f24827b = false;
        this.f24828c = 3.0d;
        this.f24829d = 6.0d;
        this.f24830e = 0.05d;
        this.f24832g = false;
        this.f24835j = true;
        this.f24838m = false;
    }

    public Map a() {
        return this.f24833h;
    }

    public Map b() {
        return this.f24834i;
    }

    public double c() {
        return this.f24828c;
    }

    public double d() {
        return this.f24829d;
    }

    public double e() {
        return this.f24830e;
    }

    public Map f() {
        return this.f24831f;
    }

    public int g() {
        return this.f24836k;
    }

    public int h() {
        return this.f24837l;
    }

    public boolean i() {
        return this.f24832g;
    }

    public boolean j() {
        return this.f24827b;
    }

    public boolean k() {
        return this.f24838m;
    }

    public boolean l() {
        return this.f24835j;
    }

    public boolean m() {
        return this.f24826a;
    }

    public void n(Map r10) {
        this.f24833h = r10;
    }

    public void o(boolean r10) {
        this.f24832g = r10;
    }

    public void p(boolean r10) {
        this.f24827b = r10;
    }

    public void q(boolean r10) {
        this.f24838m = r10;
    }

    public void r(boolean r10) {
        this.f24835j = r10;
    }

    public void s(Map r10) {
        this.f24834i = r10;
    }

    public void t(double r10) {
        this.f24828c = r10;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.f24826a + ", isCollectMainThread=" + this.f24827b + ", maxProcessBackCpuSpeed=" + this.f24828c + ", maxProcessForeCpuSpeed=" + this.f24829d + ", maxThreadCpuRate=" + this.f24830e + ", isCollectAllProcess=" + this.f24832g + ", backSceneMaxSpeedMap=" + this.f24833h + ", foreSceneMaxSpeedMap=" + this.f24834i + '}';
    }

    public void u(double r10) {
        this.f24829d = r10;
    }

    public void v(double r10) {
        this.f24830e = r10;
    }

    public void w(Map r10) {
        this.f24831f = r10;
    }

    public void x(boolean r10) {
        this.f24826a = r10;
    }

    public void y(int r10) {
        this.f24836k = r10;
    }

    public void z(int r10) {
        this.f24837l = r10;
    }
}
