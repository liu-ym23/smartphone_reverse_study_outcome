package b3;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5927c;

    public a(long r10, long r11, boolean r12) {
        this.f5925a = r10;
        this.f5926b = r11;
        this.f5927c = r12;
    }

    public long a() {
        return this.f5926b;
    }

    public long b() {
        return this.f5925a;
    }

    public boolean c() {
        return this.f5927c;
    }

    public String toString() {
        return "FdConfig{fdCountThreshold=" + this.f5925a + ", collectIntervalMs=" + this.f5926b + ", isSampled=" + this.f5927c + '}';
    }
}
