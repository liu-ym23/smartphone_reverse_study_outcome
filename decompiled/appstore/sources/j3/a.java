package j3;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f20898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20902f;

    public a(long r10, double r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        if (r10 > 0) goto L5;
        this.f20897a = 120;
    L6:
        this.f20898b = r11;
        this.f20902f = r15;
        this.f20899c = r12;
        this.f20900d = r13;
        this.f20901e = r14;
        return;
    L5:
        this.f20897a = r10;
        goto L6
    }

    public boolean a() {
        return this.f20902f;
    }

    public boolean b() {
        return this.f20900d;
    }

    public boolean c() {
        return this.f20899c;
    }

    public boolean d() {
        return this.f20901e;
    }

    public long e() {
        return this.f20897a;
    }

    public double f() {
        double r10 = this.f20898b;
        if (r10 <= 0.5d) goto L5;
        return r10;
    L5:
        return 0.8d;
    }

    public void g(boolean r10) {
        this.f20900d = r10;
    }

    public void h(boolean r10) {
        this.f20899c = r10;
    }

    public String toString() {
        return "MemoryConfig{memoryCollectionInterval=" + this.f20897a + ", memoryTopCheckThreshold=" + this.f20898b + ", isStopWhenBackground=" + this.f20899c + ", isRealTimeMemEnable=" + this.f20900d + ", isUploadEnable=" + this.f20901e + ", isApm6SampleEnable=" + this.f20902f + '}';
    }
}
