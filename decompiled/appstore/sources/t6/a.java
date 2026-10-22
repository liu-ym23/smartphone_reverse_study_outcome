package t6;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static a f24728i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f24729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f24734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f24735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0381a f24736h;

    /* JADX INFO: renamed from: t6.a$a, reason: collision with other inner class name */
    public static class C0381a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f24739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f24740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f24741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f24742f;

        public C0381a() {
            this.f24737a = "unknown";
            this.f24738b = "default";
            this.f24739c = 0.0f;
            this.f24740d = 0.0f;
            this.f24741e = 0.0f;
            this.f24742f = 0.0f;
        }

        public float a() {
            return this.f24742f;
        }

        public float b() {
            return this.f24739c;
        }

        public String toString() {
            return "CpuAbnormalConfig{cpuHardWare='" + this.f24737a + "', scene='" + this.f24738b + "', cpuSpeed=" + this.f24739c + ", smallCpuCoreTimePercent=" + this.f24740d + ", middleCpuCoreTimePercent=" + this.f24741e + ", BigCpuCoreTimePercent=" + this.f24742f + '}';
        }
    }

    static {
        f24728i = new a();
    }

    public a() {
        this.f24729a = false;
        this.f24730b = false;
        this.f24731c = false;
        this.f24732d = false;
        this.f24733e = false;
        this.f24734f = 37;
        this.f24735g = 30;
        this.f24736h = new C0381a();
    }

    public C0381a a() {
        return this.f24736h;
    }

    public int b() {
        return this.f24735g;
    }

    public int c() {
        return this.f24734f;
    }

    public boolean d() {
        return this.f24729a;
    }

    public boolean e() {
        return this.f24732d;
    }

    public boolean f() {
        return this.f24733e;
    }

    public boolean g() {
        return this.f24731c;
    }

    public boolean h() {
        return this.f24730b;
    }

    public String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=" + this.f24729a + ", enableThreadCpuUsageStat=" + this.f24730b + ", enableSystemCpuUsageStat=" + this.f24731c + ", enableProcessTimeFreqPercent=" + this.f24732d + ", enableSystemCpuTimeFreqPercent=" + this.f24733e + ", cpuSampleBatteryTemp=" + this.f24734f + ", cpuSampleBatteryLevel=" + this.f24735g + ", cpuAbnormalConfig=" + this.f24736h + '}';
    }
}
