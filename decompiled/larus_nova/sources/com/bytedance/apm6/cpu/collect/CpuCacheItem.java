package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: classes14.dex */
public final class CpuCacheItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CpuDataType f190763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f190764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f190765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f190766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f190767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f190768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f190769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f190770h;

    public static final enum CpuDataType extends Enum<CpuDataType> {
        public static final CpuDataType BACK = null;
        public static final CpuDataType FRONT = null;
        public static final CpuDataType MIX = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CpuDataType[] f190771a = null;

        static {
            CpuDataType r100 = new CpuDataType("MIX", 0);
            MIX = r100;
            CpuDataType r101 = new CpuDataType("FRONT", 1);
            FRONT = r101;
            CpuDataType r102 = new CpuDataType("BACK", 2);
            BACK = r102;
            f190771a = new CpuDataType[]{r100, r101, r102};
        }

        public static CpuDataType[] values() {
            return (CpuDataType[]) f190771a.clone();
        }

        public static CpuDataType valueOf(String r100) {
            return (CpuDataType) r27.a.a(CpuDataType.class, r100);
        }

        public CpuDataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "CpuCacheItem{type=" + this.f190763a + ", metricRate=" + this.f190764b + ", metricMaxRate=" + this.f190765c + ", metricCpuStats=" + this.f190766d + ", metricMaxCpuStats=" + this.f190767e + ", sceneString='" + this.f190768f + "', firstTs=" + this.f190769g + ", times=" + this.f190770h + '}';
    }

    public CpuDataType getType() {
        return this.f190763a;
    }

    public CpuCacheItem(CpuDataType r100, long r101) {
        this.f190763a = r100;
        this.f190769g = r101;
        this.f190770h = 0;
    }
}
