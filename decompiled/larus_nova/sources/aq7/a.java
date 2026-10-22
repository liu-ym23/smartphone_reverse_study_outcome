package aq7;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f15910d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0207a f15913c;

    /* JADX INFO: renamed from: aq7.a$a, reason: collision with other inner class name */
    public static class C0207a {
        public final String toString() {
            return "CpuAbnormalConfig{cpuHardWare='unknown', scene='default', cpuSpeed=0.0, smallCpuCoreTimePercent=0.0, middleCpuCoreTimePercent=0.0, BigCpuCoreTimePercent=0.0}";
        }

        public C0207a() {
        }
    }

    static {
        f15910d = new a();
    }

    public final String toString() {
        return "AssistConfig{enableProcessCpuSpeedStat=false, enableProcessCpuUsageStat=" + this.f15911a + ", threadCpuUsageStatProcessThreshold=0.0, threadCpuSpeedStatProcessThreshold=0.0, enableThreadCpuSpeedStat=false, enableThreadCpuUsageStat=" + this.f15912b + ", enableCareThreadStat=false, enableSystemCpuUsageStat=false, enableProcessTimeFreqPercent=false, enableSystemCpuTimeFreqPercent=false, cpuSampleBatteryTemp=37, cpuSampleBatteryLevel=30, cpuAbnormalConfig=" + this.f15913c + ", enableProcExtraInfo=false, enableNormalizedCpuUsage=false}";
    }

    public a() {
        this.f15911a = false;
        this.f15912b = false;
        this.f15913c = new C0207a();
    }
}
