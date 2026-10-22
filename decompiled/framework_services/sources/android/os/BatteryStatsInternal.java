package android.os;

import android.net.Network;
import com.android.internal.os.BinderCallsStats;
import com.android.server.power.stats.SystemServerCpuThreadReader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BatteryStatsInternal {
    public static final int CPU_WAKEUP_SUBSYSTEM_ALARM = 1;
    public static final int CPU_WAKEUP_SUBSYSTEM_BLUETOOTH = 6;
    public static final int CPU_WAKEUP_SUBSYSTEM_CELLULAR_DATA = 5;
    public static final int CPU_WAKEUP_SUBSYSTEM_SENSOR = 4;
    public static final int CPU_WAKEUP_SUBSYSTEM_SOUND_TRIGGER = 3;
    public static final int CPU_WAKEUP_SUBSYSTEM_UNKNOWN = -1;
    public static final int CPU_WAKEUP_SUBSYSTEM_WIFI = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CpuWakeupSubsystem {
    }

    public abstract List<BatteryUsageStats> getBatteryUsageStats(List<BatteryUsageStatsQuery> r1);

    public abstract String[] getMobileIfaces();

    public abstract int getOwnerUid(int r1);

    public abstract SystemServerCpuThreadReader.SystemServiceCpuThreadTimes getSystemServiceCpuThreadTimes();

    public abstract String[] getWifiIfaces();

    public abstract void noteBinderCallStats(int r1, long r2, Collection<BinderCallsStats.CallStat> r4);

    public abstract void noteBinderThreadNativeIds(int[] r1);

    public abstract void noteCpuWakingBluetoothProxyPacket(int r1, long r2);

    public abstract void noteCpuWakingNetworkPacket(Network r1, long r2, int r4);

    public abstract void noteJobsDeferred(int r1, int r2, long r3);

    public abstract void noteWakingAlarmBatch(long r1, int... r3);

    public abstract void noteWakingSoundTrigger(long r1, int r3);

    public BatteryStatsInternal() {
    }
}
