package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: classes.dex */
public class CpuCacheItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CpuDataType f6751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f6752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f6753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f6754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f6755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6758h;

    public static final enum CpuDataType extends Enum<CpuDataType> {
        private static final /* synthetic */ CpuDataType[] $VALUES = null;
        public static final CpuDataType BACK = null;
        public static final CpuDataType FRONT = null;
        public static final CpuDataType MIX = null;

        static {
            CpuDataType r10 = new CpuDataType("MIX", 0);
            MIX = r10;
            CpuDataType r11 = new CpuDataType("FRONT", 1);
            FRONT = r11;
            CpuDataType r12 = new CpuDataType("BACK", 2);
            BACK = r12;
            $VALUES = new CpuDataType[]{r10, r11, r12};
        }

        private CpuDataType(String r10, int r11) {
            super(r10, r11);
        }

        public static CpuDataType valueOf(String r10) {
            return (CpuDataType) Enum.valueOf(CpuDataType.class, r10);
        }

        public static CpuDataType[] values() {
            return (CpuDataType[]) $VALUES.clone();
        }
    }

    public CpuCacheItem(CpuDataType r10, long r11) {
        this.f6751a = r10;
        this.f6757g = r11;
        this.f6758h = 0;
    }

    public void a(double r10) {
        if (r10 >= 0.0d) goto L5;
        return;
    L5:
        this.f6752b += r10;
    }

    public void b(double r10) {
        if (r10 >= 0.0d) goto L5;
        return;
    L5:
        this.f6754d += r10;
    }

    public void c() {
        this.f6758h++;
    }

    public long d() {
        return this.f6757g;
    }

    public double e() {
        return this.f6754d;
    }

    public double f() {
        return this.f6755e;
    }

    public double g() {
        return this.f6753c;
    }

    public double h() {
        return this.f6752b;
    }

    public String i() {
        return this.f6756f;
    }

    public int j() {
        return this.f6758h;
    }

    public CpuCacheItem k(String r10) {
        this.f6756f = r10;
        return this;
    }

    public void l(double r10) {
        if (this.f6753c >= r10) goto L6;
        this.f6753c = r10;
        return;
    }

    public void m(double r10) {
        if (this.f6755e >= r10) goto L6;
        this.f6755e = r10;
        return;
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.f6751a + ", metricRate=" + this.f6752b + ", metricMaxRate=" + this.f6753c + ", metricCpuStats=" + this.f6754d + ", metricMaxCpuStats=" + this.f6755e + ", sceneString='" + this.f6756f + "', firstTs=" + this.f6757g + ", times=" + this.f6758h + '}';
    }
}
