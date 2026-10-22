package bsb;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f20370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f20372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f20373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20374l;

    public final String toString() {
        return "DevicePerfInfo{downgradeLevel=" + this.f20363a + ", isOverTemperature=" + this.f20364b + ", overTemperatureLevel=" + this.f20365c + ", isOverCpu=" + this.f20366d + ", overCpuLevel=" + this.f20367e + ", isOverMemory=" + this.f20368f + ", overMemoryLevel=" + this.f20369g + ", isLowDevice=" + this.f20370h + ", lowDeviceLevel=" + this.f20371i + ", curTemperature=" + this.f20372j + ", totalJavaMemoryMB=" + this.f20373k + ", last10SecondsCpuUsage=" + this.f20374l + '}';
    }

    public c() {
        this.f20373k = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        this.f20374l = 0;
    }
}
