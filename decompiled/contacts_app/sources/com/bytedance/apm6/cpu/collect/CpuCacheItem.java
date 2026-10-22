package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: classes2.dex */
public class CpuCacheItem {
    private long firstTs;
    private double metricCpuStats;
    private double metricMaxCpuStats;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private int times;
    private CpuDataType type;

    public static final enum CpuDataType extends Enum<CpuDataType> {
        private static final /* synthetic */ CpuDataType[] $VALUES = null;
        public static final CpuDataType BACK = null;
        public static final CpuDataType FRONT = null;
        public static final CpuDataType MIX = null;

        private CpuDataType(String r1, int r2) {
            super(r1, r2);
        }

        public static CpuDataType valueOf(String r1) {
            return (CpuDataType) Enum.valueOf(CpuDataType.class, r1);
        }

        public static CpuDataType[] values() {
            return (CpuDataType[]) $VALUES.clone();
        }

        static {
            CpuDataType r0 = new CpuDataType("MIX", 0);
            MIX = r0;
            CpuDataType r1 = new CpuDataType("FRONT", 1);
            FRONT = r1;
            CpuDataType r3 = new CpuDataType("BACK", 2);
            BACK = r3;
            $VALUES = new CpuDataType[]{r0, r1, r3};
        }
    }

    public CpuCacheItem(CpuDataType r1, long r2) {
        this.type = r1;
        this.firstTs = r2;
        this.times = 0;
    }

    public CpuCacheItem injectScene(String r1) {
        this.sceneString = r1;
        return this;
    }

    public CpuDataType getType() {
        return this.type;
    }

    public double getMetricRate() {
        return this.metricRate;
    }

    public double getMetricMaxRate() {
        return this.metricMaxRate;
    }

    public double getMetricCpuSpeed() {
        return this.metricCpuStats;
    }

    public double getMetricMaxCpuSpeed() {
        return this.metricMaxCpuStats;
    }

    public String getSceneString() {
        return this.sceneString;
    }

    public long getFirstTs() {
        return this.firstTs;
    }

    public int getTimes() {
        return this.times;
    }

    public void addTimes() {
        this.times++;
    }

    public void addRate(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.metricRate += r3;
    }

    public void refreshMaxRate(double r3) {
        if (this.metricMaxRate >= r3) goto L6;
        this.metricMaxRate = r3;
        return;
    }

    public void addSpeed(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.metricCpuStats += r3;
    }

    public void refreshMaxSpeed(double r3) {
        if (this.metricMaxCpuStats >= r3) goto L6;
        this.metricMaxCpuStats = r3;
        return;
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.type + ", metricRate=" + this.metricRate + ", metricMaxRate=" + this.metricMaxRate + ", metricCpuStats=" + this.metricCpuStats + ", metricMaxCpuStats=" + this.metricMaxCpuStats + ", sceneString='" + this.sceneString + "', firstTs=" + this.firstTs + ", times=" + this.times + '}';
    }
}
