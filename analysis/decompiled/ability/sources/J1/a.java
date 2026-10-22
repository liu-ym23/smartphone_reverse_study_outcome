package J1;

import w0.C2085f;

/* loaded from: classes2.dex */
public final class a {
    public static final a b;

    /* renamed from: a, reason: collision with root package name */
    public C2085f f862a;

    static {
        a aVar = new a();
        aVar.f862a = new C2085f(2);
        b = aVar;
    }

    public final String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=false, enableThreadCpuUsageStat=false, enableSystemCpuUsageStat=false, enableProcessTimeFreqPercent=false, enableSystemCpuTimeFreqPercent=false, cpuSampleBatteryTemp=37, cpuSampleBatteryLevel=30, cpuAbnormalConfig=" + this.f862a + '}';
    }
}
