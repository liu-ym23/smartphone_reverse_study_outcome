package u2;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f24821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f24822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f24823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f24824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f24825g;

    public a() {
        this.f24819a = false;
        this.f24820b = false;
        this.f24821c = 120;
        this.f24822d = 600;
        this.f24823e = 1200;
        this.f24824f = 120;
        this.f24825g = 600;
    }

    public long a() {
        return this.f24822d * 1000;
    }

    public long b() {
        return this.f24825g * 1000;
    }

    public long c() {
        return this.f24821c * 1000;
    }

    public long d() {
        return this.f24824f * 1000;
    }

    public long e() {
        return this.f24823e * 1000;
    }

    public boolean f() {
        return this.f24820b;
    }

    public boolean g() {
        return this.f24819a;
    }

    public void h(long r10) {
        this.f24822d = r10;
    }

    public void i(long r10) {
        this.f24825g = r10;
    }

    public void j(boolean r10) {
        this.f24820b = r10;
    }

    public void k(boolean r10) {
        this.f24819a = r10;
    }

    public void l(long r10) {
        this.f24821c = r10;
    }

    public void m(long r10) {
        this.f24824f = r10;
    }

    public void n(long r10) {
        this.f24823e = r10;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.f24819a + ", mCollectAllProcess=" + this.f24820b + ", mFrontCollectInterval=" + this.f24821c + ", mBackCollectInterval=" + this.f24822d + ", mMonitorInterval=" + this.f24823e + ", mFrontThreadCollectInterval=" + this.f24824f + ", mBackThreadCollectInterval=" + this.f24825g + '}';
    }
}
