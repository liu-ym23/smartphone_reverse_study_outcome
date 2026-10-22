package com.android.server.am;

import android.R;
import android.app.AlarmManager;
import android.app.StatsManager;
import android.app.usage.NetworkStatsManager;
import android.bluetooth.BluetoothActivityEnergyInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.power.stats.PowerEntity;
import android.hardware.power.stats.State;
import android.hardware.power.stats.StateResidency;
import android.hardware.power.stats.StateResidencyResult;
import android.net.ConnectivityManager;
import android.net.INetworkManagementEventObserver;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.BatteryConsumer;
import android.os.BatteryManagerInternal;
import android.os.BatteryStats;
import android.os.BatteryStatsInternal;
import android.os.BatteryUsageStats;
import android.os.BatteryUsageStatsQuery;
import android.os.Binder;
import android.os.BluetoothBatteryStats;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.INetworkManagementService;
import android.os.Parcel;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UidBatteryConsumer;
import android.os.UserHandle;
import android.os.WakeLockStats;
import android.os.WorkSource;
import android.os.connectivity.CellularBatteryStats;
import android.os.connectivity.GpsBatteryStats;
import android.os.connectivity.WifiActivityEnergyInfo;
import android.os.connectivity.WifiBatteryStats;
import android.os.health.HealthStatsParceler;
import android.os.health.HealthStatsWriter;
import android.os.health.UidHealthStats;
import android.power.PowerStatsInternal;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.telephony.ModemActivityInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.StatsEvent;
import com.android.internal.app.IBatteryStats;
import com.android.internal.os.BinderCallsStats;
import com.android.internal.os.Clock;
import com.android.internal.os.CpuScalingPolicies;
import com.android.internal.os.CpuScalingPolicyReader;
import com.android.internal.os.MonotonicClock;
import com.android.internal.os.PowerProfile;
import com.android.internal.os.RailStats;
import com.android.internal.os.RpmStats;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.ParseUtils;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.utils.build.SdkLevel;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.Watchdog;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.power.feature.PowerManagerFlags;
import com.android.server.power.stats.BatteryExternalStatsWorker;
import com.android.server.power.stats.BatteryStatsDumpHelperImpl;
import com.android.server.power.stats.BatteryStatsImpl;
import com.android.server.power.stats.BatteryUsageStatsProvider;
import com.android.server.power.stats.PowerAttributor;
import com.android.server.power.stats.PowerStatsScheduler;
import com.android.server.power.stats.PowerStatsStore;
import com.android.server.power.stats.PowerStatsUidResolver;
import com.android.server.power.stats.SystemServerCpuThreadReader;
import com.android.server.power.stats.processor.MultiStatePowerAttributor;
import com.android.server.power.stats.wakeups.CpuWakeupStats;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryStatsService extends IBatteryStats.Stub implements PowerManagerInternal.LowPowerModeListener, BatteryStatsImpl.PlatformIdleStateCallback, BatteryStatsImpl.EnergyStatsRetriever, Watchdog.Monitor {
    private static final String BATTERY_USAGE_STATS_BEFORE_RESET_TIMESTAMP_PROPERTY = "BATTERY_USAGE_STATS_BEFORE_RESET_TIMESTAMP";
    static final boolean DBG = false;
    private static final String DEVICE_CONFIG_NAMESPACE = "backstage_power";
    private static final int MAX_LOW_POWER_STATS_SIZE = 32768;
    private static final String MIN_CONSUMED_POWER_THRESHOLD_KEY = "min_consumed_power_threshold";
    private static final int POWER_STATS_QUERY_TIMEOUT_MILLIS = 2000;
    static final String TAG = "BatteryStatsService";
    static final String TRACE_TRACK_WAKEUP_REASON = "wakeup_reason";
    private static IBatteryStats sService;
    private final INetworkManagementEventObserver mActivityChangeObserver;
    private BatteryManagerInternal mBatteryManagerInternal;
    private final BatteryStatsImpl.BatteryStatsConfig mBatteryStatsConfig;
    private final BatteryUsageStatsProvider mBatteryUsageStatsProvider;
    private final AtomicFile mConfigFile;
    private final Context mContext;
    private final CpuScalingPolicies mCpuScalingPolicies;
    final CpuWakeupStats mCpuWakeupStats;
    private CharsetDecoder mDecoderStat;
    private final BatteryStats.BatteryStatsDumpHelper mDumpHelper;
    private Map<Integer, String> mEntityNames;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private int mLastPowerStateFromRadio;
    private int mLastPowerStateFromWifi;
    private final Object mLock;
    private volatile boolean mMonitorEnabled;
    private final MonotonicClock mMonotonicClock;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private final PowerAttributor mPowerAttributor;
    private final PowerManagerFlags mPowerManagerFlags;
    private final PowerProfile mPowerProfile;
    private PowerStatsInternal mPowerStatsInternal;
    private final Object mPowerStatsLock;
    private final PowerStatsScheduler mPowerStatsScheduler;
    private final PowerStatsStore mPowerStatsStore;
    private final PowerStatsUidResolver mPowerStatsUidResolver;
    private boolean mRailsStatsCollectionEnabled;
    private Map<Integer, Map<Integer, String>> mStateNames;
    final BatteryStatsImpl mStats;
    private final ConditionVariable mSystemReady;
    private final BatteryStatsImpl.UserInfoProvider mUserManagerUserInfoProvider;
    private final BatteryExternalStatsWorker mWorker;

    public static class FrameworkStatsLogger {
        public FrameworkStatsLogger() {
        }

        public StatsEvent buildStatsEvent(long sessionStartTs, long sessionEndTs, long sessionDuration, int sessionDischargePercentage, long sessionDischargeDuration, int uid, int processState, long timeInStateMillis, String powerComponentName, float totalConsumedPowerMah, float powerComponentMah, long powerComponentDurationMillis) {
            return FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.BATTERY_USAGE_STATS_PER_UID, sessionStartTs, sessionEndTs, sessionDuration, sessionDischargePercentage, sessionDischargeDuration, uid, processState, timeInStateMillis, powerComponentName, totalConsumedPowerMah, powerComponentMah, powerComponentDurationMillis);
        }
    }

    private final class LocalService extends BatteryStatsInternal {
        final /* synthetic */ BatteryStatsService this$0;

        /* synthetic */ LocalService(BatteryStatsService r1, BatteryStatsServiceIA r2) {
            this(r1);
        }

        private LocalService(BatteryStatsService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.BatteryStatsInternal
        public String[] getWifiIfaces() {
            return (String[]) this.this$0.mStats.getWifiIfaces().clone();
        }

        @Override // android.os.BatteryStatsInternal
        public String[] getMobileIfaces() {
            return (String[]) this.this$0.mStats.getMobileIfaces().clone();
        }

        @Override // android.os.BatteryStatsInternal
        public SystemServerCpuThreadReader.SystemServiceCpuThreadTimes getSystemServiceCpuThreadTimes() {
            return this.this$0.mStats.getSystemServiceCpuThreadTimes();
        }

        @Override // android.os.BatteryStatsInternal
        public List<BatteryUsageStats> getBatteryUsageStats(List<BatteryUsageStatsQuery> queries) {
            return this.this$0.getBatteryUsageStats(queries);
        }

        @Override // android.os.BatteryStatsInternal
        public void noteJobsDeferred(int uid, int numDeferred, long sinceLast) {
            this.this$0.noteJobsDeferred(uid, numDeferred, sinceLast);
        }

        private int transportToSubsystem(NetworkCapabilities nc) {
            if (nc.hasTransport(1) == false) goto L7;
            return 2;
        L7:
            if (nc.hasTransport(0) == false) goto L10;
            return 5;
        L10:
            return -1;
        }

        @Override // android.os.BatteryStatsInternal
        public void noteCpuWakingNetworkPacket(Network network, long elapsedMillis, int uid) {
            if (uid >= 0) goto L6;
            Slog.e(BatteryStatsService.TAG, "Invalid uid for waking network packet: " + uid);
            return;
        L6:
            ConnectivityManager cm = (ConnectivityManager) BatteryStatsService.m1419$$Nest$fgetmContext(this.this$0).getSystemService(ConnectivityManager.class);
            NetworkCapabilities nc = cm.getNetworkCapabilities(network);
            int subsystem = transportToSubsystem(nc);
            if (subsystem != (-1)) goto L10;
            Slog.wtf(BatteryStatsService.TAG, "Could not map transport for network: " + network + " while attributing wakeup by packet sent to uid: " + uid);
            return;
        L10:
            this.this$0.noteCpuWakingActivity(subsystem, elapsedMillis, new int[]{uid});
        }

        @Override // android.os.BatteryStatsInternal
        public void noteCpuWakingBluetoothProxyPacket(int uid, long elapsedMillis) {
            if (uid >= 0) goto L5;
            Slog.e(BatteryStatsService.TAG, "Invalid uid for waking bluetooth proxy packet: " + uid);
            return;
        L5:
            this.this$0.noteCpuWakingActivity(6, elapsedMillis, new int[]{uid});
        }

        @Override // android.os.BatteryStatsInternal
        public void noteBinderCallStats(int workSourceUid, long incrementatCallCount, Collection<BinderCallsStats.CallStat> callStats) {
            Object r1 = BatteryStatsService.m1421$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            Handler r0 = BatteryStatsService.m1420$$Nest$fgetmHandler(this.this$0);     // Catch: Throwable -> L11
            final BatteryStatsImpl r2 = this.this$0.mStats;     // Catch: Throwable -> L11
            r2.getClass();     // Catch: Throwable -> L11
            r0.sendMessage(PooledLambda.obtainMessage(new BatteryStatsService$LocalService$$ExternalSyntheticLambda0(r2), Integer.valueOf(workSourceUid), Long.valueOf(incrementatCallCount), callStats, Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(SystemClock.uptimeMillis())));     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            Throwable r14 = th;
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L9
            throw r14;
        L11:
            th = move-exception;
            r14 = th;
            goto L13
        }

        @Override // android.os.BatteryStatsInternal
        public void noteBinderThreadNativeIds(int[] binderThreadNativeTids) {
            Object r0 = BatteryStatsService.m1421$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.this$0.mStats.noteBinderThreadNativeIds(binderThreadNativeTids);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.os.BatteryStatsInternal
        public void noteWakingSoundTrigger(long elapsedMillis, int uid) {
            this.this$0.noteCpuWakingActivity(3, elapsedMillis, new int[]{uid});
        }

        @Override // android.os.BatteryStatsInternal
        public void noteWakingAlarmBatch(long elapsedMillis, int... uids) {
            this.this$0.noteCpuWakingActivity(1, elapsedMillis, uids);
        }

        @Override // android.os.BatteryStatsInternal
        public int getOwnerUid(int uid) {
            if (Process.isSdkSandboxUid(uid) == false) goto L7;
            return Process.getAppUidForSdkSandboxUid(uid);
        L7:
            return BatteryStatsService.m1422$$Nest$fgetmPowerStatsUidResolver(this.this$0).mapUid(uid);
        }
    }

    public static class StatsPerUidLogger {
        private static final int STATSD_METRIC_MAX_DIMENSIONS_COUNT = 3000;
        private static final int[] UID_PROCESS_STATES = null;
        private final FrameworkStatsLogger mFrameworkStatsLogger;

        public static final class SessionInfo extends Record {
            private final long dischargeDuration;
            private final int dischargePercentage;
            private final long duration;
            private final long endTs;
            private final long startTs;

            private /* synthetic */ boolean $record$equals(Object r5) {
                if ((r5 instanceof SessionInfo) == false) goto L16;
                SessionInfo r6 = (SessionInfo) r5;
                if (this.dischargePercentage == r6.dischargePercentage) goto L7;
                return false;
            L7:
                if (this.startTs == r6.startTs) goto L9;
                return false;
            L9:
                if (this.endTs == r6.endTs) goto L11;
                return false;
            L11:
                if (this.duration == r6.duration) goto L13;
                return false;
            L13:
                if (this.dischargeDuration != r6.dischargeDuration) goto L22;
                return true;
            L22:
                return false;
            L16:
                return false;
            }

            private /* synthetic */ Object[] $record$getFieldsAsObjects() {
                return new Object[]{Long.valueOf(this.startTs), Long.valueOf(this.endTs), Long.valueOf(this.duration), Integer.valueOf(this.dischargePercentage), Long.valueOf(this.dischargeDuration)};
            }

            public SessionInfo(long startTs, long endTs, long duration, int dischargePercentage, long dischargeDuration) {
                this.startTs = startTs;
                this.endTs = endTs;
                this.duration = duration;
                this.dischargePercentage = dischargePercentage;
                this.dischargeDuration = dischargeDuration;
            }

            public long dischargeDuration() {
                return this.dischargeDuration;
            }

            public int dischargePercentage() {
                return this.dischargePercentage;
            }

            public long duration() {
                return this.duration;
            }

            public long endTs() {
                return this.endTs;
            }

            @Override // java.lang.Record
            public final boolean equals(Object o) {
                return $record$equals(o);
            }

            @Override // java.lang.Record
            public final int hashCode() {
                return BatteryStatsService$StatsPerUidLogger$SessionInfo$$ExternalSyntheticRecord0.m(this.dischargePercentage, this.startTs, this.endTs, this.duration, this.dischargeDuration);
            }

            public long startTs() {
                return this.startTs;
            }

            @Override // java.lang.Record
            public final String toString() {
                return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), SessionInfo.class, "startTs;endTs;duration;dischargePercentage;dischargeDuration");
            }
        }

        static {
            UID_PROCESS_STATES = new int[]{0, 1, 2, 3, 4};
        }

        public StatsPerUidLogger(FrameworkStatsLogger frameworkStatsLogger) {
            this.mFrameworkStatsLogger = frameworkStatsLogger;
        }

        private static float clampPowerMah(double powerMah, String consumer) {
            float resultPowerMah = Double.valueOf(powerMah).floatValue();
            if (Float.isInfinite(resultPowerMah) == false) goto L6;
            Slog.d(BatteryStatsService.TAG, consumer + " reported powerMah float overflow : " + powerMah);
            return 0.0f;
        L6:
            return resultPowerMah;
        }

        public int logStats(BatteryUsageStats bus, List<StatsEvent> data) {
            SessionInfo sessionInfo = new SessionInfo(bus.getStatsStartTimestamp(), bus.getStatsEndTimestamp(), bus.getStatsDuration(), bus.getDischargePercentage(), bus.getDischargeDurationMs());
            BatteryConsumer deviceConsumer = bus.getAggregateBatteryConsumer(0);
            float totalDeviceConsumedPowerMah = clampPowerMah(deviceConsumer.getConsumedPower(), "AggregateBatteryConsumer");
            int[] r12 = deviceConsumer.getPowerComponentIds();
            int r13 = r12.length;
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L16;
            int powerComponentId = r12[r14];
            if (powerComponentId == 18) goto L15;
            int[] r15 = UID_PROCESS_STATES;
            int r1 = r15.length;
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L15;
            int r16 = r1;
            int r17 = r2;
            float totalDeviceConsumedPowerMah2 = totalDeviceConsumedPowerMah;
            BatteryConsumer deviceConsumer2 = deviceConsumer;
            if (addStatsForPowerComponent(data, sessionInfo, -1, r15[r2], totalDeviceConsumedPowerMah, 0, deviceConsumer, powerComponentId) == false) goto L12;
            r2 = r17 + 1;
            r1 = r16;
            deviceConsumer = deviceConsumer2;
            totalDeviceConsumedPowerMah = totalDeviceConsumedPowerMah2;
            goto L9
        L12:
            return 0;
        L15:
            r14 = r14 + 1;
            deviceConsumer = deviceConsumer;
            totalDeviceConsumedPowerMah = totalDeviceConsumedPowerMah;
            goto L4
        L16:
            List<UidBatteryConsumer> uidConsumers = bus.getUidBatteryConsumers();
            uidConsumers.sort(Comparator.comparingDouble(new BatteryStatsService$StatsPerUidLogger$$ExternalSyntheticLambda0()).reversed());
            Iterator<UidBatteryConsumer> r18 = uidConsumers.iterator();
        L18:
            if (r18.hasNext() == false) goto L34;
            UidBatteryConsumer uidConsumer = r18.next();
            int uid = uidConsumer.getUid();
            float totalConsumedPowerMah = clampPowerMah(uidConsumer.getConsumedPower(), "uidConsumer-" + uid);
            int[] r19 = uidConsumer.getPowerComponentIds();
            int r3 = r19.length;
            int r4 = 0;
        L21:
            if (r4 >= r3) goto L18;
            int powerComponentId2 = r19[r4];
            if (powerComponentId2 == 18) goto L32;
            int[] r5 = UID_PROCESS_STATES;
            int r7 = r5.length;
            int r8 = 0;
        L26:
            if (r8 >= r7) goto L32;
            int[] r110 = r5;
            int processState = r110[r8];
            int r111 = r7;
            int r20 = r8;
            long timeInProcessStateMs = uidConsumer.getTimeInProcessStateMs(processState);
            int r112 = r4;
            int r113 = r3;
            if (addStatsForPowerComponent(data, sessionInfo, uid, processState, totalConsumedPowerMah, timeInProcessStateMs, uidConsumer, powerComponentId2) == false) goto L29;
            r8 = r20 + 1;
            r3 = r113;
            r4 = r112;
            r5 = r110;
            r7 = r111;
            goto L26
        L29:
            return 0;
        L32:
            r4 = r4 + 1;
            r3 = r3;
            goto L21
        L34:
            return 0;
        }

        private boolean addStatsForPowerComponent(List<StatsEvent> data, SessionInfo sessionInfo, int uid, int processState, float totalConsumedPowerMah, long timeInState, BatteryConsumer batteryConsumer, int componentId) {
            BatteryConsumer.Key key = batteryConsumer.getKey(componentId, processState);
            if (key != null) goto L5;
            return true;
        L5:
            String powerComponentName = batteryConsumer.getPowerComponentName(componentId);
            double consumedPowerMah = batteryConsumer.getConsumedPower(key);
            float powerMah = clampPowerMah(consumedPowerMah, "uid-" + uid + "-" + powerComponentName);
            long powerComponentDurationMillis = batteryConsumer.getUsageDurationMillis(key);
            if (powerMah != 0.0f) goto L11;
            if (powerComponentDurationMillis != 0) goto L11;
            return true;
        L11:
            return addStatsAtom(data, sessionInfo, uid, processState, timeInState, powerComponentName, totalConsumedPowerMah, powerMah, powerComponentDurationMillis);
        }

        private boolean addStatsAtom(List<StatsEvent> data, SessionInfo sessionInfo, int uid, int processState, long timeInStateMillis, String powerComponentName, float totalConsumedPowerMah, float powerComponentMah, long powerComponentDurationMillis) {
            data.add(this.mFrameworkStatsLogger.buildStatsEvent(sessionInfo.startTs(), sessionInfo.endTs(), sessionInfo.duration(), sessionInfo.dischargePercentage(), sessionInfo.dischargeDuration(), uid, processState, timeInStateMillis, powerComponentName, totalConsumedPowerMah, powerComponentMah, powerComponentDurationMillis));
            if (data.size() != 3000) goto L6;
            Slog.w(BatteryStatsService.TAG, "BATTERY_USAGE_STATS_PER_UID is complete reaching dimension guardrail");
            return false;
        L6:
            return true;
        }
    }

    private class StatsPullAtomCallbackImpl implements StatsManager.StatsPullAtomCallback {
        private static final long BATTERY_USAGE_STATS_PER_UID_MAX_STATS_AGE = 0;
        final /* synthetic */ BatteryStatsService this$0;

        /* synthetic */ StatsPullAtomCallbackImpl(BatteryStatsService r1, BatteryStatsServiceIA r2) {
            this(r1);
        }

        private StatsPullAtomCallbackImpl(BatteryStatsService r1) {
            this.this$0 = r1;
        }

        static {
            BATTERY_USAGE_STATS_PER_UID_MAX_STATS_AGE = TimeUnit.HOURS.toMillis(2);
        }

        public int onPullAtom(int atomTag, List<StatsEvent> data) {
            switch(atomTag) {
                case 10111: goto L18;
                case 10112: goto L17;
                case 10113: goto L15;
                case 10209: goto L6;
                default: goto L5;
            };
        L6:
            double minConsumedPowerThreshold = DeviceConfig.getFloat(BatteryStatsService.DEVICE_CONFIG_NAMESPACE, BatteryStatsService.MIN_CONSUMED_POWER_THRESHOLD_KEY, 0.0f);
            BatteryUsageStatsQuery.Builder query = new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0).includeProcessStateData().includeVirtualUids().setMinConsumedPowerThreshold(minConsumedPowerThreshold);
            if (BatteryStatsService.m1424$$Nest$smisBatteryUsageStatsAccumulationSupported() == false) goto L9;
            query.accumulated().setMaxStatsAgeMs(BATTERY_USAGE_STATS_PER_UID_MAX_STATS_AGE);
        L9:
            BatteryUsageStats bus = this.this$0.getBatteryUsageStats(List.of(query.build())).get(0);
            int pullResult = new StatsPerUidLogger(new FrameworkStatsLogger()).logStats(bus, data);
            bus.close();     // Catch: IOException -> L12
        L14:
            return pullResult;
        L12:
            e = move-exception;
            Slog.w(BatteryStatsService.TAG, "Failure close BatteryUsageStats", e);
            goto L14
        L15:
            return 1;
        L17:
            double minConsumedPowerThreshold2 = DeviceConfig.getFloat(BatteryStatsService.DEVICE_CONFIG_NAMESPACE, BatteryStatsService.MIN_CONSUMED_POWER_THRESHOLD_KEY, 0.0f);
            BatteryUsageStatsQuery querySinceReset = new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0).includeProcessStateData().includeVirtualUids().includePowerModels().setMinConsumedPowerThreshold(minConsumedPowerThreshold2).build();
            BatteryUsageStats bus2 = this.this$0.getBatteryUsageStats(List.of(querySinceReset)).get(0);
        L23:
            byte[] statsProto = bus2.getStatsProto();
            bus2.close();     // Catch: IOException -> L26
        L28:
            data.add(FrameworkStatsLog.buildStatsEvent(atomTag, statsProto));
            return 0;
        L26:
            e = move-exception;
            Slog.w(BatteryStatsService.TAG, "Failure close BatteryUsageStats", e);
            goto L28
        L18:
            long sessionStart = this.this$0.getLastBatteryUsageStatsBeforeResetAtomPullTimestamp();
            BatteryStatsImpl r0 = this.this$0.mStats;
            monitor-enter(r0);
            long sessionEnd = this.this$0.mStats.getStartClockTime();     // Catch: Throwable -> L30
            monitor-exit(r0);     // Catch: Throwable -> L30
            BatteryUsageStatsQuery queryBeforeReset = new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0).includeProcessStateData().includeVirtualUids().aggregateSnapshots(sessionStart, sessionEnd).build();
            bus2 = this.this$0.getBatteryUsageStats(List.of(queryBeforeReset)).get(0);
            this.this$0.setLastBatteryUsageStatsBeforeResetAtomPullTimestamp(sessionEnd);
        L30:
            th = move-exception;
            throw th;
        L5:
            throw new UnsupportedOperationException("Unknown tagId=" + atomTag);
        }
    }

    final class WakeupReasonThread extends Thread {
        private static final int MAX_REASON_SIZE = 512;
        private CharsetDecoder mDecoder;
        private CharBuffer mUtf16Buffer;
        private ByteBuffer mUtf8Buffer;
        final /* synthetic */ BatteryStatsService this$0;

        WakeupReasonThread(BatteryStatsService this$0) {
            this.this$0 = this$0;
            super("BatteryStats_wakeupReason");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-2);
            this.mDecoder = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?");
            this.mUtf8Buffer = ByteBuffer.allocateDirect(512);
            this.mUtf16Buffer = CharBuffer.allocate(512);
        L18:
            String reason = waitWakeup();     // Catch: RuntimeException -> L13
            if (reason == null) goto L23;
            long nowElapsed = SystemClock.elapsedRealtime();     // Catch: RuntimeException -> L13
            long nowUptime = SystemClock.uptimeMillis();     // Catch: RuntimeException -> L13
            Trace.instantForTrack(131072, BatteryStatsService.TRACE_TRACK_WAKEUP_REASON, nowElapsed + " " + reason);     // Catch: RuntimeException -> L13
            BatteryStatsService.m1423$$Nest$mawaitCompletion(this.this$0);     // Catch: RuntimeException -> L13
            this.this$0.mCpuWakeupStats.noteWakeupTimeAndReason(nowElapsed, nowUptime, reason);     // Catch: RuntimeException -> L13
            BatteryStatsImpl r7 = this.this$0.mStats;     // Catch: RuntimeException -> L13
            monitor-enter(r7);     // Catch: RuntimeException -> L13
            this.this$0.mStats.noteWakeupReasonLocked(reason, nowElapsed, nowUptime);     // Catch: Throwable -> L10
            SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWakeupReason(reason);     // Catch: Throwable -> L10
            monitor-exit(r7);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: RuntimeException -> L13
        L23:
            return;
        L13:
            e = move-exception;
            Slog.e(BatteryStatsService.TAG, "Failure reading wakeup reasons", e);
        }

        private String waitWakeup() {
            this.mUtf8Buffer.clear();
            this.mUtf16Buffer.clear();
            this.mDecoder.reset();
            int bytesWritten = BatteryStatsService.m1425$$Nest$smnativeWaitWakeup(this.mUtf8Buffer);
            if (bytesWritten >= 0) goto L6;
            return null;
        L6:
            if (bytesWritten != 0) goto L9;
            return "unknown";
        L9:
            this.mUtf8Buffer.limit(bytesWritten);
            this.mDecoder.decode(this.mUtf8Buffer, this.mUtf16Buffer, true);
            this.mUtf16Buffer.flip();
            return this.mUtf16Buffer.toString();
        }
    }

    public static /* synthetic */ void $r8$lambda$1aCrL1KQYxlLS0wPffBEKia4qAM(BatteryStatsService r0, int r1, String r2, String r3, long r4, long r6) {
        r0.lambda$noteServiceStopLaunch$108(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$1uKH0jAFkVzTTJkWSgJZQVni4Yk(BatteryStatsService r0, SignalStrength r1, long r2, long r4) {
        r0.lambda$notePhoneSignalStrength$48(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$2RnfhMxRf1S72QybMHW0pG1AEl4(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$notePhoneOn$46(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$2Za_x-OkAyZsRGRIDoud6jqPMU8, reason: not valid java name */
    public static /* synthetic */ void m1391$r8$lambda$2Za_xOkAyZsRGRIDoud6jqPMU8(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteVibratorOff$36(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$2ZbvDR6kcXkeNIUCcdjshWnXSaM(BatteryStatsService r0, int r1, String r2, String r3, long r4, long r6) {
        r0.lambda$noteServiceStartLaunch$107(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$2cAHmvokO1tg_wZZEcuWLIeaags(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteProcessFinish$13(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$3BueiV6UHR5hG8LNSs8GraPVSKM(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteFlashlightOff$60(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$3KHPtNQjdXmQazQTwbuWyc8Dlbk(BatteryStatsService r0, PowerSaveState r1, long r2, long r4) {
        r0.lambda$onLowPowerModeChanged$5(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$3_6UsWv46A0g87MXqkQxHXOlOJ0(BatteryStatsService r0, String r1, int r2, WorkSource r3, String r4, long r5, long r7, WorkSource r9) {
        r0.lambda$noteWakupAlarm$21(r1, r2, r3, r4, r5, r7, r9);
    }

    public static /* synthetic */ void $r8$lambda$3rUJzlhZrYQ5oiX6maGsDR_OIYI(BatteryStatsService r0, String r1, long r2, long r4) {
        r0.lambda$notePackageUninstalled$88(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$3zccex7oHISt-gseufVEpZbBIN4, reason: not valid java name */
    public static /* synthetic */ void m1392$r8$lambda$3zccex7oHIStgseufVEpZbBIN4(BatteryStatsService r0, ModemActivityInfo r1, long r2, long r4, NetworkStatsManager r6) {
        r0.lambda$noteModemControllerActivity$95(r1, r2, r4, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$40a0_E2ErldC-wDLcHt6Ye0i6Q8, reason: not valid java name */
    public static /* synthetic */ void m1393$r8$lambda$40a0_E2ErldCwDLcHt6Ye0i6Q8(BatteryStatsService r0, int r1, String r2, String r3, long r4, long r6) {
        r0.lambda$noteServiceStopRunning$106(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$4JjW7XwJIiSJZGc7WgZOdk6mf_E(BatteryStatsService r0, int r1, long r2, int r4, long r5, long r7) {
        r0.lambda$noteWifiRadioPowerState$65(r1, r2, r4, r5, r7);
    }

    public static /* synthetic */ void $r8$lambda$4_L017BN9XQBcztYd4QNBiVHALU(BatteryStatsService r0, int r1, long r2) {
        r0.lambda$onCleanupUser$8(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$56b8zMgEX_p_ptd2j1fMfLGcmUw(BatteryStatsService r0, int r1, String r2, long r3, long r5, long r7) {
        r0.lambda$updateForegroundTimeIfOnBattery$100(r1, r2, r3, r5, r7);
    }

    public static /* synthetic */ void $r8$lambda$5Dn201ryqKCHVmxl0uP3DuW4qQc(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$notePhoneState$50(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$60xjkTzlo_XjchQLFyfzj__3o3s(BatteryStatsService r0, int r1, int r2, long r3, long r5) {
        r0.lambda$noteUserActivity$41(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$7etxBG5oBgaLj1M5iGKaBXuG8O8(BatteryStatsService r0, int r1, boolean r2, int r3, int r4, int r5, long r6, long r8) {
        r0.lambda$notePhoneDataConnectionState$49(r1, r2, r3, r4, r5, r6, r8);
    }

    public static /* synthetic */ void $r8$lambda$8JM5MhNddIBqh73dzjAuFa66X5Y(BatteryStatsService r0, int r1, String r2, int r3, long r4, long r6) {
        r0.lambda$noteDeviceIdleMode$86(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$9LYMV8G3WoAH6TNl8q2kOWiTRI4(BatteryStatsService r0, WorkSource r1, long r2, long r4, WorkSource r6) {
        r0.lambda$noteWifiScanStartedFromSource$80(r1, r2, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$AEWP8qtCZLdhfQP4Jto5oo3q3R8(BatteryStatsService r0, int r1, long r2, long r4, long r6) {
        r0.lambda$noteVibratorOn$35(r1, r2, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$Ai7ZnLCIrHgKxq3zj_6LPPEKUo8(BatteryStatsService r0) {
        r0.lambda$scheduleWriteToDisk$6();
    }

    public static /* synthetic */ void $r8$lambda$Bl2NAzncEY4CERUQf2yMNxE_Bks(BatteryStatsService r0, int r1, int r2, long r3, long r5) {
        r0.lambda$noteStartSensor$33(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$CIOtHUdIWKZT2Pb9BwGHMy34680(BatteryStatsService r0, String r1, WorkSource r2, int r3, long r4, long r6) {
        r0.lambda$noteAlarmStart$22(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$CvQiPKO5k22uQf8SPuDwEZUYD2w(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteResetCamera$63(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$D-MLJNUlBvQ5uPg53HYrMuh7rok, reason: not valid java name */
    public static /* synthetic */ void m1394$r8$lambda$DMLJNUlBvQ5uPg53HYrMuh7rok(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteBleScanReset$91(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$E2zZySja-QLWcx-iSOhrqHJf6yg, reason: not valid java name */
    public static /* synthetic */ void m1395$r8$lambda$E2zZySjaQLWcxiSOhrqHJf6yg(BatteryStatsService r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9, long r11, long r13, long r15) {
        r0.lambda$setBatteryState$97(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15);
    }

    public static /* synthetic */ void $r8$lambda$EptPGuQSOwroFEdHrFLDXbtnbXo(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStartAudio$53(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$Ftytodr6oNMHE8mmE3YRUz2HX1k(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteSyncFinish$17(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ga7cv1gJzbv-DHnYiIGRaAisI3k, reason: not valid java name */
    public static /* synthetic */ void m1396$r8$lambda$Ga7cv1gJzbvDHnYiIGRaAisI3k(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteWifiScanStarted$74(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$GqBpfKTCt7r9HglrAcC-I_LN8-E, reason: not valid java name */
    public static /* synthetic */ void m1397$r8$lambda$GqBpfKTCt7r9HglrAcCI_LN8E(BatteryStatsService r0, String r1, int r2, int r3, long r4, long r6) {
        r0.lambda$noteJobFinish$19(r1, r2, r3, r4, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$Gvr-7ZKRjOER4wcajtOLu7aThcY, reason: not valid java name */
    public static /* synthetic */ void m1398$r8$lambda$Gvr7ZKRjOER4wcajtOLu7aThcY(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStopVideo$56(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$IFhzeNKV23kO-pimm_OcDthJmPs, reason: not valid java name */
    public static /* synthetic */ void m1399$r8$lambda$IFhzeNKV23kOpimm_OcDthJmPs(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStartCamera$61(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$IabXb9gHSqwc43BsnsbE_mP-5CQ, reason: not valid java name */
    public static /* synthetic */ void m1400$r8$lambda$IabXb9gHSqwc43BsnsbE_mP5CQ(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteResetVideo$58(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$IupjSlkY0NO9Qp20ySi_Erku3uI(BatteryStatsService r0, WorkSource r1, boolean r2, long r3, long r5, WorkSource r7) {
        r0.lambda$noteBleScanStarted$89(r1, r2, r3, r5, r7);
    }

    public static /* synthetic */ void $r8$lambda$K1GdpdqsgXyDT_MmuIn_iqYTG5U(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteSyncStart$16(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$KEUFOs7T3pqu1K5KSNKgHuowa2U(BatteryStatsService r0, WorkSource r1, int r2, String r3, String r4, int r5, WorkSource r6, int r7, String r8, String r9, int r10, boolean r11, long r12, long r14) {
        r0.lambda$noteChangeWakelockFromSource$27(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14);
    }

    public static /* synthetic */ void $r8$lambda$KEeKc4sRXh5XaBPp5rkOnDhVsg0(BatteryStatsService r0, String r1, long r2, long r4, long r6) {
        r0.lambda$notePackageInstalled$87(r1, r2, r4, r6);
    }

    public static /* synthetic */ Long $r8$lambda$KbIILFaoZRfUTKIZpT2c3D2hxKA(BatteryStatsService r0) {
        return r0.lambda$createPowerStatsScheduler$2();
    }

    public static /* synthetic */ void $r8$lambda$LFzJO_XlKSRWF_hb_wSeNAZGaVU(BatteryStatsService r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9, long r11, long r13, long r15) {
        r0.lambda$setBatteryState$98(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15);
    }

    public static /* synthetic */ void $r8$lambda$LHHtqCn9yX30FAHeGjso4HNbj1o(BatteryStatsService r0, WorkSource r1, long r2, long r4) {
        r0.lambda$noteWifiBatchedScanStoppedFromSource$83(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$M_bq2aJIuy6ao-9wkN4k08GyMdg, reason: not valid java name */
    public static /* synthetic */ void m1401$r8$lambda$M_bq2aJIuy6ao9wkN4k08GyMdg(BatteryStatsService r0, int r1) {
        r0.lambda$onUserRemoved$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$MqiolLdPC6t1W7NovGXCX2XTxN4(BatteryStatsService r0, int r1, String r2, long r3, long r5) {
        r0.lambda$reportExcessiveCpu$104(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$O0kwjmVNci5MOBbn8aNQhom9Saw(BatteryStatsService r0, WorkSource r1, long r2, long r4, WorkSource r6) {
        r0.lambda$noteWifiScanStoppedFromSource$81(r1, r2, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$OnbgsTCNyXR6NrrFcSS2fDoMBjk(BatteryStatsService r0, long r1, String r3, AlarmManager.OnAlarmListener r4, Handler r5) {
        r0.lambda$createPowerStatsScheduler$1(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$PCwM-7iw-1PbupolUlFOWq4Pcy0, reason: not valid java name */
    public static /* synthetic */ void m1402$r8$lambda$PCwM7iw1PbupolUlFOWq4Pcy0(BatteryStatsService r0, WorkSource r1, WorkSource r2, long r3, long r5) {
        r0.lambda$noteGpsChanged$37(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$PYuHBTuqV08a9r0rAYn7jXZJlx8(BatteryStatsService r0, BluetoothActivityEnergyInfo r1, long r2, long r4) {
        r0.lambda$noteBluetoothControllerActivity$94(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$QCm1Z6ZHhURABdBXs610YJBmQTs(CountDownLatch r0) {
        lambda$awaitCompletion$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$QHB9wdOiuQcdDBiazhM3T7y4zdk(BatteryStatsService r0, WorkSource r1, int r2, String r3, String r4, int r5, boolean r6, long r7, long r9) {
        r0.lambda$noteStartWakelockFromSource$26(r1, r2, r3, r4, r5, r6, r7, r9);
    }

    public static /* synthetic */ void $r8$lambda$QlKekjKgi7rEeeEd6DQT0K107P8(BatteryStatsService r0, WorkSource r1, long r2, long r4) {
        r0.lambda$noteWifiStopped$68(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$QqDpq1tf8PeA6zDrbCkkVFeF5Hg(BatteryStatsService r0, int r1, int r2, long r3, long r5) {
        r0.lambda$noteScreenBrightness$40(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$TWGTasgDsMoe4tQf4whMg_QYxT8(BatteryStatsService r0, String r1, int[] r2) {
        r0.lambda$noteNetworkInterfaceForTransports$84(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TsgteX6Cqfwovz6Fm5fYPWaBPP4(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteWifiMulticastDisabled$77(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$TwmWdLOeLvEzPz9Ao4BjfPlNkiw(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStartVideo$55(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$TxFLL1QhxJEODOr9EiQ_Z4_ogOU(BatteryStatsService r0, WorkSource r1, long r2, long r4) {
        r0.lambda$noteFullWifiLockReleasedFromSource$79(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$UwCbIz-g_CPidtnuo34q3nXKi3w, reason: not valid java name */
    public static /* synthetic */ void m1403$r8$lambda$UwCbIzg_CPidtnuo34q3nXKi3w(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteFullWifiLockAcquired$72(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$VEKXtCZT__VcqiM9431_LON32OI(BatteryStatsService r0, String r1, String r2, int r3, long r4, long r6) {
        r0.lambda$noteLongPartialWakelockFinish$31(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$WDeM8T9bDQ3TxyOMxnevQ8uAboc(BatteryStatsService r0, WifiActivityEnergyInfo r1, long r2, long r4, NetworkStatsManager r6) {
        r0.lambda$noteWifiControllerActivity$93(r1, r2, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$W_m_pC8qgzHLEsmltX2zAZ9pPHU(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteGpsSignalQuality$38(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$Xlgb0QL12zWhyhEZsJj3wtpNlYA(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteFlashlightOn$59(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$YPVH1fkeYiuI_ZyRfVy_MhQAmwc(BatteryStatsService r0, String r1, WorkSource r2, int r3, long r4, long r6) {
        r0.lambda$noteAlarmFinish$23(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$YS5UPlTwGM0lcQKIspBYovN4mNQ(BatteryStatsService r0, WorkSource r1, long r2, long r4) {
        r0.lambda$noteFullWifiLockAcquiredFromSource$78(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$YSSoKtuOfeC-pu2GlOBeY-KWqHs, reason: not valid java name */
    public static /* synthetic */ void m1404$r8$lambda$YSSoKtuOfeCpu2GlOBeYKWqHs(BatteryStatsService r0, WorkSource r1, WorkSource r2, long r3, long r5) {
        r0.lambda$noteWifiRunningChanged$67(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$YvcUzo2V1BJoZIdqGiH0_pdXOFY(BatteryStatsService r0, int r1, int r2, long r3, long r5) {
        r0.lambda$noteStopSensor$34(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$_E_6wE6nKqYvLRHhz8EbEluJ12I(BatteryStatsService r0, WorkSource r1, int r2, String r3, String r4, int r5, long r6, long r8) {
        r0.lambda$noteStopWakelockFromSource$28(r1, r2, r3, r4, r5, r6, r8);
    }

    public static /* synthetic */ void $r8$lambda$_XQtArHfzmT6bWDc98Smjj2N4hU(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteWifiOn$51(r1, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$aHB8iQ1wo1I0_3d-C0dXoZ1MT0A, reason: not valid java name */
    public static /* synthetic */ void m1405$r8$lambda$aHB8iQ1wo1I0_3dC0dXoZ1MT0A(BatteryStatsService r0, String r1, String r2, int r3, long r4, long r6) {
        r0.lambda$noteLongPartialWakelockStart$29(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$aSyIcVg0mDlkGVxzBoJp1TKGPQ8(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteWifiScanStopped$75(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$b5MQqLcI7cEyfhOYxX7Rh2WCdnQ(BatteryStatsService r0, int r1, int r2, long r3, long r5, long r7) {
        r0.lambda$noteJobsDeferred$20(r1, r2, r3, r5, r7);
    }

    public static /* synthetic */ void $r8$lambda$bQPheCpAfogSMCmRtZ2jQPi79RM(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteWifiMulticastEnabled$76(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$cPSYBn-mqsEpuW4e2D5tsmd9aTw, reason: not valid java name */
    public static /* synthetic */ void m1406$r8$lambda$cPSYBnmqsEpuW4e2D5tsmd9aTw(BatteryStatsService r0, int r1, long r2, int r4, long r5, long r7) {
        r0.lambda$noteMobileRadioPowerState$45(r1, r2, r4, r5, r7);
    }

    public static /* synthetic */ double $r8$lambda$ciMg9FlozhJ3llhSoybBUr31n7w(BatteryStatsService r2) {
        return r2.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$dYC84f6xdiIlDy80ISXqT8e6cGU(BatteryStatsService r0, int r1, String r2, String r3, long r4, long r6) {
        r0.lambda$noteServiceStartRunning$105(r1, r2, r3, r4, r6);
    }

    public static /* synthetic */ void $r8$lambda$e9ud3NMN9AG5Ft1kbYrE_Cm6JmA(BatteryStatsService r0, String r1, String r2, WorkSource r3, long r4, long r6, WorkSource r8) {
        r0.lambda$noteLongPartialWakelockStartFromSource$30(r1, r2, r3, r4, r6, r8);
    }

    public static /* synthetic */ void $r8$lambda$e_iR63TEbtw6XpYTwjEOPpZliNQ(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteFullWifiLockReleased$73(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$eo1mW3o7ng_z3xqZJ2Qy2wsrsaE(BatteryStatsService r0, int r1, String r2, int r3, long r4, long r6) {
        r0.lambda$noteEvent$15(r1, r2, r3, r4, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$gP6_SHv4O0AlMf6V-gDjL6YqYXk, reason: not valid java name */
    public static /* synthetic */ void m1407$r8$lambda$gP6_SHv4O0AlMf6VgDjL6YqYXk(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteResetAudio$57(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$hE7OcHy_0PbP5yZu3PMEKZ6NMzA(BatteryStatsService r0, String r1, String r2, WorkSource r3, long r4, long r6, WorkSource r8) {
        r0.lambda$noteLongPartialWakelockFinishFromSource$32(r1, r2, r3, r4, r6, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$hRy7dLSx4IfCuJ-vlPxMGBdmc8c, reason: not valid java name */
    public static /* synthetic */ void m1408$r8$lambda$hRy7dLSx4IfCuJvlPxMGBdmc8c(BatteryStatsService r0, int r1, String r2, long r3) {
        r0.lambda$noteWifiState$69(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$hrcE20PH0CEA0UOlvjqhV4dNSFY(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteJobStart$18(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$iSuuQzTLRfjm1jElqn8K_huq8VI(BatteryStatsService r0, int r1, String r2, long r3, long r5) {
        r0.lambda$noteConnectivityChanged$44(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$iW9S28e_Nc4pRhYyRF402vVykYg(BatteryStatsService r0, int r1, int r2, String r3, String r4, int r5, boolean r6, long r7, long r9) {
        r0.lambda$noteStartWakelock$24(r1, r2, r3, r4, r5, r6, r7, r9);
    }

    public static /* synthetic */ void $r8$lambda$jtXXNzC3pXJGy7mQd97vAtNDKp8(BatteryStatsService r0, boolean r1, int r2, long r3, long r5) {
        r0.lambda$updateBatteryStatsOnActivityUsage$102(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$ksppEni-y1t1rmkoTm8ntlbzfcU, reason: not valid java name */
    public static /* synthetic */ void m1409$r8$lambda$ksppEniy1t1rmkoTm8ntlbzfcU(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteWakeUp$42(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$m0B7ml1VR-qc-rStjDPMCc_2b90, reason: not valid java name */
    public static /* synthetic */ void m1410$r8$lambda$m0B7ml1VRqcrStjDPMCc_2b90(BatteryStatsService r0, int r1, int r2, int r3, long r4, long r6, long r8) {
        r0.lambda$noteScreenState$39(r1, r2, r3, r4, r6, r8);
    }

    public static /* synthetic */ void $r8$lambda$maEh_77a7IFLNHY95bdoNasQLaY(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStopAudio$54(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$nDz09w8XvVp2IiJzEeVzlEBoCuk(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$notePhoneOff$47(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$nNiFUD5Hg2kBtBcDlY2zVHfl29w(BatteryStatsService r0, WorkSource r1, long r2, long r4) {
        r0.lambda$noteWifiRunning$66(r1, r2, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$pJY0x-n8fCvkoTcsgx9wPQDjqwI, reason: not valid java name */
    public static /* synthetic */ void m1411$r8$lambda$pJY0xn8fCvkoTcsgx9wPQDjqwI(BatteryStatsService r0, int r1, boolean r2, long r3, long r5) {
        r0.lambda$noteWifiSupplicantStateChanged$70(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$pSxO7jxz5Ta17BvhtNx-T2Ena9U, reason: not valid java name */
    public static /* synthetic */ void m1412$r8$lambda$pSxO7jxz5Ta17BvhtNxT2Ena9U(BatteryStatsService r0, int r1, long r2) {
        r0.lambda$removeUid$7(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$pdWI2hSg2S6GhRp-2t_0IxGhaws, reason: not valid java name */
    public static /* synthetic */ void m1413$r8$lambda$pdWI2hSg2S6GhRp2t_0IxGhaws(BatteryStatsService r0) {
        r0.lambda$noteNetworkStatsEnabled$85();
    }

    public static /* synthetic */ void $r8$lambda$peRNQKiPI_V5r54aYz9lstU7S9A(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteProcessStart$10(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$poVe73UtdkAokPl7DWl5pZTVg7o(BatteryStatsService r0, int r1, int r2, long r3, long r5) {
        r0.lambda$noteUidProcessState$14(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$puwRmEc5LyEa1LyUwKP5muYaQyY(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteStopCamera$62(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$quPvBsxVJfQTfKA32wJni1_R90E(BatteryStatsService r0, boolean r1, long r2) {
        r0.lambda$noteInteractive$43(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$t3mPUmSdDo7gVAnV99W_JqRwzyI(BatteryStatsService r0, int r1, long r2, int[] r4) {
        r0.lambda$noteCpuWakingActivity$3(r1, r2, r4);
    }

    public static /* synthetic */ void $r8$lambda$tFQz7DB9bDL3bie1hVBNp1wlM0g(BatteryStatsService r0, long r1, long r3, long r5) {
        r0.lambda$noteCurrentTimeChanged$101(r1, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$u-OibtaX3kIg04dugWi12MMuABU, reason: not valid java name */
    public static /* synthetic */ void m1414$r8$lambda$uOibtaX3kIg04dugWi12MMuABU(BatteryStatsService r0, WorkSource r1, boolean r2, long r3, long r5, WorkSource r7) {
        r0.lambda$noteBleScanStopped$90(r1, r2, r3, r5, r7);
    }

    public static /* synthetic */ void $r8$lambda$u8vSJjtTcZv6Pk5qWG288PR7TA0(BatteryStatsService r0, int[] r1, ResultReceiver r2) {
        r0.lambda$takeUidSnapshotsAsync$99(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$uPcBn70Mo5l8wpUFYuEnNmT-25I, reason: not valid java name */
    public static /* synthetic */ void m1415$r8$lambda$uPcBn70Mo5l8wpUFYuEnNmT25I(BatteryStatsService r0, int r1, int r2) {
        r0.lambda$noteProcessDied$103(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$urOovnjOKNNkoo7jyT-IA30T0S0, reason: not valid java name */
    public static /* synthetic */ void m1416$r8$lambda$urOovnjOKNNkoo7jyTIA30T0S0(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteResetFlashlight$64(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$vLt9HebbnK7vzU1AuoOmeTlgDO4(BatteryStatsService r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, long r9, long r11, long r13, long r15) {
        r0.lambda$setBatteryState$96(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r13, r15);
    }

    public static /* synthetic */ void $r8$lambda$wGrzANiPC9RXOPQIsi5L0I6qPdM(BatteryStatsService r0, long r1, long r3) {
        r0.lambda$noteWifiOff$52(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$x4iD39uC1vxdastdvuGFCCqpb24(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteProcessAnr$12(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$x74EpGX_JPiEFqkuNlwPqOyYx8I(BatteryStatsService r0, WorkSource r1, int r2, long r3, long r5) {
        r0.lambda$noteWifiBatchedScanStartedFromSource$82(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$xX2sjpoWKQc8CQoecsmzt1fBhto(BatteryStatsService r0, WorkSource r1, int r2, long r3, long r5) {
        r0.lambda$noteBleScanResults$92(r1, r2, r3, r5);
    }

    public static /* synthetic */ void $r8$lambda$xxJfqbRWkf5GuOgrGTepkkEodyA(BatteryStatsService r0, String r1, int r2, long r3, long r5) {
        r0.lambda$noteProcessCrash$11(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$z4KWsHBUrEJ3mKeXD_NI-HKR8Xw, reason: not valid java name */
    public static /* synthetic */ void m1417$r8$lambda$z4KWsHBUrEJ3mKeXD_NIHKR8Xw(BatteryStatsService r0, int r1, int r2, String r3, String r4, int r5, long r6, long r8) {
        r0.lambda$noteStopWakelock$25(r1, r2, r3, r4, r5, r6, r8);
    }

    /* JADX INFO: renamed from: $r8$lambda$zBNSWELwQzYyjpSOnaL-h9h-3Eo, reason: not valid java name */
    public static /* synthetic */ void m1418$r8$lambda$zBNSWELwQzYyjpSOnaLh9h3Eo(BatteryStatsService r0, int r1, long r2, long r4) {
        r0.lambda$noteWifiRssiChanged$71(r1, r2, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1419$$Nest$fgetmContext(BatteryStatsService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m1420$$Nest$fgetmHandler(BatteryStatsService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1421$$Nest$fgetmLock(BatteryStatsService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerStatsUidResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerStatsUidResolver m1422$$Nest$fgetmPowerStatsUidResolver(BatteryStatsService r0) {
        return r0.mPowerStatsUidResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$mawaitCompletion, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1423$$Nest$mawaitCompletion(BatteryStatsService r0) {
        r0.awaitCompletion();
    }

    /* JADX INFO: renamed from: -$$Nest$smisBatteryUsageStatsAccumulationSupported, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1424$$Nest$smisBatteryUsageStatsAccumulationSupported() {
        return isBatteryUsageStatsAccumulationSupported();
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeWaitWakeup, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1425$$Nest$smnativeWaitWakeup(ByteBuffer r0) {
        return nativeWaitWakeup(r0);
    }

    private native void getRailEnergyPowerStats(RailStats r1);

    private static native int nativeWaitWakeup(ByteBuffer r0);

    private void populatePowerEntityMaps() {
        PowerEntity[] entities = this.mPowerStatsInternal.getPowerEntityInfo();
        if (entities != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= entities.length) goto L14;
        PowerEntity entity = entities[i];
        Map<Integer, String> states = new HashMap();
        int j = 0;
    L10:
        if (j >= entity.states.length) goto L12;
        State state = entity.states[j];
        states.put(Integer.valueOf(state.id), state.name);
        j = j + 1;
        goto L10
    L12:
        this.mEntityNames.put(Integer.valueOf(entity.id), entity.name);
        this.mStateNames.put(Integer.valueOf(entity.id), states);
        i = i + 1;
        goto L7
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.PlatformIdleStateCallback
    public void fillLowPowerStats(RpmStats rpmStats) {
        Object r0 = this.mPowerStatsLock;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.mPowerStatsInternal == null) goto L30;
        if (this.mEntityNames.isEmpty() == true) goto L30;
        if (this.mStateNames.isEmpty() == true) goto L30;
        monitor-exit(r0);     // Catch: Throwable -> L28
        StateResidencyResult[] results = this.mPowerStatsInternal.getStateResidencyAsync(new int[0]).get(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L25
        if (results != null) goto L15;
        return;
    L15:
        int i = 0;
    L17:
        if (i >= results.length) goto L24;
        StateResidencyResult result = results[i];
        RpmStats.PowerStateSubsystem subsystem = rpmStats.getSubsystem(this.mEntityNames.get(Integer.valueOf(result.id)));
        int j = 0;
    L20:
        if (j >= result.stateResidencyData.length) goto L22;
        StateResidency stateResidency = result.stateResidencyData[j];
        subsystem.putState(this.mStateNames.get(Integer.valueOf(result.id)).get(Integer.valueOf(stateResidency.id)), stateResidency.totalTimeInStateMs, (int) stateResidency.totalStateEntryCount);
        j = j + 1;
        goto L20
    L22:
        i = i + 1;
        goto L17
    L24:
        return;
    L25:
        e = move-exception;
        Slog.e(TAG, "Failed to getStateResidencyAsync", e);
        return;
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L28
    }

    public void setRailsStatsCollectionEnabled(boolean railsStatsCollectionEnabled) {
        this.mRailsStatsCollectionEnabled = railsStatsCollectionEnabled;
    }

    @Override // com.android.server.power.stats.BatteryStatsImpl.EnergyStatsRetriever
    public void fillRailDataStats(RailStats railStats) {
        if (this.mRailsStatsCollectionEnabled == true) goto L10;
        railStats.setRailStatsAvailability(false);
        return;
    L10:
        getRailEnergyPowerStats(railStats);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    BatteryStatsService(Context context, File systemDir) {
        this.mPowerStatsUidResolver = new PowerStatsUidResolver();
        this.mPowerManagerFlags = new PowerManagerFlags();
        this.mMonitorEnabled = true;
        this.mRailsStatsCollectionEnabled = true;
        this.mDecoderStat = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?");
        this.mLock = new Object();
        this.mSystemReady = new ConditionVariable(false);
        this.mPowerStatsLock = new Object();
        this.mPowerStatsInternal = null;
        this.mEntityNames = new HashMap();
        this.mStateNames = new HashMap();
        this.mLastPowerStateFromRadio = 1;
        this.mLastPowerStateFromWifi = 1;
        this.mActivityChangeObserver = new AnonymousClass1(this);
        this.mNetworkCallback = new AnonymousClass2(this);
        this.mContext = context;
        SysMonitorSvcBridge.getFactory().getBatteryStatsServiceOptEx().init(this.mContext, this);
        this.mUserManagerUserInfoProvider = new AnonymousClass3(this);
        this.mHandlerThread = new HandlerThread("batterystats-handler");
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        Handler r0 = this.mHandler;
        final ConditionVariable r1 = this.mSystemReady;
        r1.getClass();
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda104(r1));
        this.mMonotonicClock = new MonotonicClock(new File(systemDir, "monotonic_clock.xml"));
        this.mPowerProfile = new PowerProfile(context);
        this.mCpuScalingPolicies = new CpuScalingPolicyReader().read();
        boolean resetOnUnplugHighBatteryLevel = context.getResources().getBoolean(R.bool.config_bg_current_drain_auto_restrict_abusive_apps);
        boolean resetOnUnplugAfterSignificantCharge = context.getResources().getBoolean(R.bool.config_batterymeterDualTone);
        int batteryHistoryStorageSize = context.getResources().getInteger(R.integer.config_bluetooth_idle_cur_ma);
        BatteryStatsImpl.BatteryStatsConfig.Builder batteryStatsConfigBuilder = new BatteryStatsImpl.BatteryStatsConfig.Builder().setResetOnUnplugHighBatteryLevel(resetOnUnplugHighBatteryLevel).setResetOnUnplugAfterSignificantCharge(resetOnUnplugAfterSignificantCharge).setMaxHistorySizeBytes(batteryHistoryStorageSize);
        setPowerStatsThrottlePeriods(batteryStatsConfigBuilder, context.getResources().getString(R.string.config_wallpaperCropperPackage));
        this.mBatteryStatsConfig = batteryStatsConfigBuilder.build();
        this.mStats = new BatteryStatsImpl(this.mBatteryStatsConfig, Clock.SYSTEM_CLOCK, this.mMonotonicClock, systemDir, this.mHandler, this, this, this.mUserManagerUserInfoProvider, this.mPowerProfile, this.mCpuScalingPolicies, this.mPowerStatsUidResolver);
        this.mWorker = new BatteryExternalStatsWorker(context, this.mStats, this.mHandler);
        this.mStats.setExternalStatsSyncLocked(this.mWorker);
        this.mStats.setRadioScanningTimeoutLocked(((long) this.mContext.getResources().getInteger(R.integer.config_satellite_max_retry_count_for_validating_possible_change_in_allowed_region)) * 1000);
        this.mPowerStatsStore = new PowerStatsStore(systemDir, this.mHandler);
        this.mPowerAttributor = new MultiStatePowerAttributor(this.mContext, this.mPowerStatsStore, this.mPowerProfile, this.mCpuScalingPolicies, new BatteryStatsService$$ExternalSyntheticLambda105(this));
        this.mPowerStatsScheduler = createPowerStatsScheduler(this.mContext);
        int accumulatedBatteryUsageStatsSpanSize = this.mContext.getResources().getInteger(R.integer.config_activeTaskDurationHours);
        this.mBatteryUsageStatsProvider = new BatteryUsageStatsProvider(context, this.mPowerAttributor, this.mPowerProfile, this.mCpuScalingPolicies, this.mPowerStatsStore, accumulatedBatteryUsageStatsSpanSize, Clock.SYSTEM_CLOCK, this.mMonotonicClock);
        this.mDumpHelper = new BatteryStatsDumpHelperImpl(this.mBatteryUsageStatsProvider);
        this.mCpuWakeupStats = new CpuWakeupStats(context, R.xml.irq_device_map, this.mHandler);
        this.mConfigFile = new AtomicFile(new File(systemDir, "battery_usage_stats_config"));
    }

    private /* synthetic */ double lambda$new$0() {
        return this.mStats.getBatteryCapacity();
    }

    private PowerStatsScheduler createPowerStatsScheduler(Context context) {
        long aggregatedPowerStatsSpanDuration = context.getResources().getInteger(R.integer.config_alertDialogController);
        long powerStatsAggregationPeriod = context.getResources().getInteger(R.integer.config_safe_media_volume_index);
        PowerStatsScheduler.AlarmScheduler alarmScheduler = new BatteryStatsService$$ExternalSyntheticLambda14(this);
        final BatteryStatsImpl r1 = this.mStats;
        r1.getClass();
        return new PowerStatsScheduler(new BatteryStatsService$$ExternalSyntheticLambda15(r1), this.mStats.getHistory(), this.mPowerAttributor, aggregatedPowerStatsSpanDuration, powerStatsAggregationPeriod, this.mPowerStatsStore, alarmScheduler, Clock.SYSTEM_CLOCK, this.mMonotonicClock, new BatteryStatsService$$ExternalSyntheticLambda16(this), this.mHandler);
    }

    private /* synthetic */ void lambda$createPowerStatsScheduler$1(long triggerAtMillis, String tag, AlarmManager.OnAlarmListener onAlarmListener, Handler aHandler) {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        alarmManager.set(3, triggerAtMillis, tag, onAlarmListener, aHandler);
    }

    private /* synthetic */ Long lambda$createPowerStatsScheduler$2() {
        return Long.valueOf(this.mStats.getHistory().getStartTime());
    }

    private void setPowerStatsThrottlePeriods(BatteryStatsImpl.BatteryStatsConfig.Builder builder, String configString) {
        if (configString != null) goto L4;
        return;
    L4:
        Matcher matcher = Pattern.compile("([^:]+):(\\d+)\\s*").matcher(configString);
    L6:
        if (matcher.find() == false) goto L17;
        String powerComponentName = matcher.group(1);
        long throttlePeriod = Long.parseLong(matcher.group(2));     // Catch: NumberFormatException -> L14
        if (powerComponentName.equals(SettingsToPropertiesMapper.NAMESPACE_REBOOT_STAGING_DELIMITER) == true) goto L11;
        builder.setPowerStatsThrottlePeriodMillis(powerComponentName, throttlePeriod);
        goto L6
    L11:
        builder.setDefaultPowerStatsThrottlePeriodMillis(throttlePeriod);
    L16:
        throw new IllegalArgumentException("Invalid config_powerStatsThrottlePeriods format: " + configString);
    }

    public static BatteryStatsService create(Context context, File systemDir, Handler handler, BatteryStatsImpl.BatteryCallback callback) {
        BatteryStatsService service = new BatteryStatsService(context, systemDir);
        service.mStats.setCallback(callback);
        BatteryStatsImpl r1 = service.mStats;
        monitor-enter(r1);
        service.mStats.readLocked();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        service.scheduleWriteToDisk();
        return service;
    L8:
        th = move-exception;
        throw th;
    }

    public void publish() {
        LocalServices.addService(BatteryStatsInternal.class, new LocalService(this, null));
        ServiceManager.addService("batterystats", asBinder());
    }

    public void systemServicesReady() {
        this.mStats.setBatteryHistoryCompressionEnabled(true);
        this.mStats.saveBatteryUsageStatsOnReset(this.mBatteryUsageStatsProvider, this.mPowerStatsStore, isBatteryUsageStatsAccumulationSupported());
        this.mStats.resetBatteryHistoryOnNewSession(false);
        MultiStatePowerAttributor attributor = (MultiStatePowerAttributor) this.mPowerAttributor;
        this.mStats.setPowerStatsCollectorEnabled(1, true);
        attributor.setPowerComponentSupported(1, true);
        this.mStats.setPowerStatsCollectorEnabled(12, true);
        attributor.setPowerComponentSupported(12, true);
        this.mStats.setPowerStatsCollectorEnabled(0, true);
        attributor.setPowerComponentSupported(0, true);
        this.mStats.setPowerStatsCollectorEnabled(15, true);
        attributor.setPowerComponentSupported(15, true);
        this.mStats.setPowerStatsCollectorEnabled(8, true);
        attributor.setPowerComponentSupported(8, true);
        attributor.setPowerComponentSupported(14, true);
        this.mStats.setPowerStatsCollectorEnabled(11, true);
        attributor.setPowerComponentSupported(11, true);
        this.mStats.setPowerStatsCollectorEnabled(2, true);
        attributor.setPowerComponentSupported(2, true);
        this.mStats.setPowerStatsCollectorEnabled(4, true);
        attributor.setPowerComponentSupported(4, true);
        this.mStats.setPowerStatsCollectorEnabled(5, true);
        attributor.setPowerComponentSupported(5, true);
        this.mStats.setPowerStatsCollectorEnabled(6, true);
        attributor.setPowerComponentSupported(6, true);
        this.mStats.setPowerStatsCollectorEnabled(10, true);
        attributor.setPowerComponentSupported(10, true);
        attributor.setPowerComponentSupported(9, true);
        this.mStats.setPowerStatsCollectorEnabled(3, true);
        attributor.setPowerComponentSupported(3, true);
        this.mStats.setPowerStatsCollectorEnabled(13, true);
        attributor.setPowerComponentSupported(13, true);
        this.mStats.setPowerStatsCollectorEnabled(-1, true);
        attributor.setPowerComponentSupported(-1, true);
        this.mStats.setMoveWscLoggingToNotifierEnabled(this.mPowerManagerFlags.isMoveWscLoggingToNotifierEnabled());
        this.mWorker.systemServicesReady();
        this.mStats.systemServicesReady(this.mContext);
        this.mCpuWakeupStats.systemServicesReady();
        INetworkManagementService nms = INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        ConnectivityManager cm = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
    L6:
        e = move-exception;
        Slog.e(TAG, "Could not register INetworkManagement event observer " + e);
    L11:
        Object r3 = this.mPowerStatsLock;
        monitor-enter(r3);
        this.mPowerStatsInternal = (PowerStatsInternal) LocalServices.getService(PowerStatsInternal.class);     // Catch: Throwable -> L16
        if (this.mPowerStatsInternal == null) goto L18;
        populatePowerEntityMaps();     // Catch: Throwable -> L16
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L16
        this.mBatteryManagerInternal = (BatteryManagerInternal) LocalServices.getService(BatteryManagerInternal.class);
        Watchdog.getInstance().addMonitor(this);
        DataConnectionStats dataConnectionStats = new DataConnectionStats(this.mContext, this.mHandler);
        dataConnectionStats.startMonitoring();
        registerStatsCallbacks();
        this.mSystemReady.open();
        return;
    L18:
        Slog.e(TAG, "Could not register PowerStatsInternal");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L4:
        if (SdkLevel.isAtLeastV() == true) goto L8;
        nms.registerObserver(this.mActivityChangeObserver);     // Catch: RemoteException -> L6
    L8:
        cm.registerDefaultNetworkCallback(this.mNetworkCallback);     // Catch: RemoteException -> L6
        goto L11
    }

    private static boolean isBatteryUsageStatsAccumulationSupported() {
        return true;
    }

    public void onSystemReady() {
        this.mStats.onSystemReady(this.mContext);
        this.mPowerStatsScheduler.start(true);
    }

    void noteCpuWakingActivity(final int subsystem, final long elapsedMillis, final int... uids) {
        uids.getClass();
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda17(this, subsystem, elapsedMillis, uids));
    }

    private /* synthetic */ void lambda$noteCpuWakingActivity$3(int subsystem, long elapsedMillis, int[] uids) {
        this.mCpuWakeupStats.noteWakingActivity(subsystem, elapsedMillis, uids);
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        if (this.mMonitorEnabled == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L15
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    private static void awaitUninterruptibly(Future<?> future) {
    L8:
        future.get();     // Catch: InterruptedException -> L4 Throwable -> L6
    L3:
        return;
    }

    protected void syncStats(String reason, int flags) {
        this.mStats.collectPowerStatsSamples();
        this.mWorker.scheduleSync(reason, flags);
        awaitCompletion();
    }

    private void awaitCompletion() {
        final CountDownLatch latch = new CountDownLatch(1);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda88(latch));
        latch.await();     // Catch: InterruptedException -> L5
        return;
    }

    private static /* synthetic */ void lambda$awaitCompletion$4(CountDownLatch latch) {
        latch.countDown();
    }

    public void initPowerManagement() {
        PowerManagerInternal powerMgr = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        powerMgr.registerLowPowerModeObserver(this);
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        this.mStats.notePowerSaveModeLockedInit(powerMgr.getLowPowerState(9).batterySaverEnabled, SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        new WakeupReasonThread(this).start();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        Slog.w("BatteryStats", "Writing battery stats before shutdown...");
        awaitCompletion();
        syncStats("shutdown", 127);
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.shutdownLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mWorker.shutdown();
        this.mMonotonicClock.write();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static IBatteryStats getService() {
        if (sService != null) goto L5;
        IBinder b = ServiceManager.getService("batterystats");
        sService = IBatteryStats.Stub.asInterface(b);
        return sService;
    L5:
        return sService;
    }

    public static void overrideService(IBatteryStats service) {
        sService = service;
    }

    public int getServiceType() {
        return 9;
    }

    public void onLowPowerModeChanged(final PowerSaveState result) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda98(this, result, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L11:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$onLowPowerModeChanged$5(PowerSaveState result, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.notePowerSaveModeLocked(result.batterySaverEnabled, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public BatteryStatsImpl getActiveStatistics() {
        return this.mStats;
    }

    public void scheduleWriteToDisk() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda34(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$scheduleWriteToDisk$6() {
        this.mWorker.scheduleWrite();
    }

    void removeUid(final int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda42(this, uid, elapsedRealtime));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$removeUid$7(int uid, long elapsedRealtime) {
        this.mCpuWakeupStats.onUidRemoved(uid);
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.removeUidStatsLocked(uid, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onCleanupUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda67(this, userId, elapsedRealtime));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onCleanupUser$8(int userId, long elapsedRealtime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.onCleanupUserLocked(userId, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onUserRemoved(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda101(this, userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onUserRemoved$9(int userId) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.onUserRemovedLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addIsolatedUid(int isolatedUid, int appUid) {
        this.mPowerStatsUidResolver.noteIsolatedUidAdded(isolatedUid, appUid);
        FrameworkStatsLog.write(43, appUid, isolatedUid, 1);
    }

    void removeIsolatedUid(int isolatedUid, int appUid) {
        this.mPowerStatsUidResolver.noteIsolatedUidRemoved(isolatedUid, appUid);
        FrameworkStatsLog.write(43, -1, isolatedUid, 0);
    }

    void noteProcessStart(final String name, final int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda55(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write(28, uid, name, 1);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteProcessStart$10(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteProcessStartLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void noteProcessCrash(final String name, final int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda94(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write(28, uid, name, 2);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteProcessCrash$11(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteProcessCrashLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void noteProcessAnr(final String name, final int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda20(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L11:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteProcessAnr$12(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteProcessAnrLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void noteProcessFinish(final String name, final int uid) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda7(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write(28, uid, name, 0);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteProcessFinish$13(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteProcessFinishLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void noteUidProcessState(final int uid, final int state) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda84(this, uid, state, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L11:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteUidProcessState$14(int uid, int state, long elapsedRealtime, long uptime) {
        this.mCpuWakeupStats.noteUidProcessState(uid, state);
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteUidProcessStateLocked(uid, state, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public List<BatteryUsageStats> getBatteryUsageStats(List<BatteryUsageStatsQuery> queries) {
        super.getBatteryUsageStats_enforcePermission();
        awaitCompletion();
        if (BatteryUsageStatsProvider.shouldUpdateStats(queries, SystemClock.elapsedRealtime(), this.mWorker.getLastCollectionTimeStamp()) == false) goto L6;
        syncStats("get-stats", 127);
        this.mStats.collectPowerStatsSamples();
    L6:
        return this.mBatteryUsageStatsProvider.getBatteryUsageStats(this.mStats, queries);
    }

    private void registerStatsCallbacks() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        StatsPullAtomCallbackImpl pullAtomCallback = new StatsPullAtomCallbackImpl(this, null);
        statsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_USAGE_STATS_SINCE_RESET, null, ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
        statsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_USAGE_STATS_SINCE_RESET_USING_POWER_PROFILE_MODEL, null, ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
        statsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_USAGE_STATS_BEFORE_RESET, null, ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
        statsManager.setPullAtomCallback(FrameworkStatsLog.BATTERY_USAGE_STATS_PER_UID, new StatsManager.PullAtomMetadata.Builder().setTimeoutMillis(BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS).build(), ConcurrentUtils.DIRECT_EXECUTOR, pullAtomCallback);
    }

    public boolean isCharging() {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        boolean r1 = this.mStats.isCharging();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long computeBatteryTimeRemaining() {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        long time = this.mStats.computeBatteryTimeRemaining(SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
        if (time < 0) goto L9;
        long r3 = time / 1000;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L9:
        r3 = time;
    L7:
        th = move-exception;
        throw th;
    }

    public long computeChargeTimeRemaining() {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        long time = this.mStats.computeChargeTimeRemaining(SystemClock.elapsedRealtime());     // Catch: Throwable -> L7
        if (time < 0) goto L9;
        long r3 = time / 1000;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L9:
        r3 = time;
    L7:
        th = move-exception;
        throw th;
    }

    public long computeBatteryScreenOffRealtimeMs() {
        super.computeBatteryScreenOffRealtimeMs_enforcePermission();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        long curTimeUs = SystemClock.elapsedRealtimeNanos() / 1000;     // Catch: Throwable -> L7
        long timeUs = this.mStats.computeBatteryScreenOffRealtime(curTimeUs, 0);     // Catch: Throwable -> L7
        long r3 = timeUs / 1000;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public long getScreenOffDischargeMah() {
        super.getScreenOffDischargeMah_enforcePermission();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        long dischargeUah = this.mStats.getUahDischargeScreenOff(0);     // Catch: Throwable -> L7
        long r3 = dischargeUah / 1000;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteEvent(final int code, final String name, final int uid) {
        super.noteEvent_enforcePermission();
        if (name != null) goto L6;
        Slog.wtfStack(TAG, "noteEvent called with null name. code = " + code);
        return;
    L6:
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda81(this, code, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r9);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteEvent$15(int code, String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteEventLocked(code, name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteSyncStart(final String name, final int uid) {
        super.noteSyncStart_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda13(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(7, uid, null, name, 1);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteSyncStart$16(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteSyncStartLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteSyncStateChange(name, uid, true);
        return;
    L10:
        th = move-exception;
        Throwable r10 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r10;
    L12:
        th = move-exception;
        r10 = th;
        goto L14
    }

    public void noteSyncFinish(final String name, final int uid) {
        super.noteSyncFinish_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda23(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(7, uid, null, name, 0);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteSyncFinish$17(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteSyncFinishLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteSyncStateChange(name, uid, false);
        return;
    L10:
        th = move-exception;
        Throwable r10 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r10;
    L12:
        th = move-exception;
        r10 = th;
        goto L14
    }

    public void noteJobStart(final String name, final int uid) {
        super.noteJobStart_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda35(this, name, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteJobStart$18(String name, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteJobStartLocked(name, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteJobStateChange(name, uid, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteJobFinish(final String name, final int uid, final int stopReason) {
        super.noteJobFinish_enforcePermission();
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda71(this, name, uid, stopReason, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteJobFinish$19(String name, int uid, int stopReason, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteJobFinishLocked(name, uid, stopReason, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteJobStateChange(name, uid, false);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void noteJobsDeferred(final int uid, final int numDeferred, final long sinceLast) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda65(this, uid, numDeferred, sinceLast, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteJobsDeferred$20(int uid, int numDeferred, long sinceLast, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteJobsDeferredLocked(uid, numDeferred, sinceLast, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteWakupAlarm(final String name, final int uid, final WorkSource workSource, final String tag) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", "noteWakupAlarm");
        if (workSource == null) goto L6;
        WorkSource r0 = new WorkSource(workSource);
    L5:
        final WorkSource localWs = r0;
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda90(this, name, uid, localWs, tag, elapsedRealtime, uptime, workSource));     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L6:
        r0 = null;
        goto L5
    }

    private /* synthetic */ void lambda$noteWakupAlarm$21(String name, int uid, WorkSource localWs, String tag, long elapsedRealtime, long uptime, WorkSource workSource) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWakupAlarmLocked(name, uid, localWs, tag, elapsedRealtime, uptime);     // Catch: Throwable -> L11
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWakupAlarm(name, uid, workSource, tag);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L9:
        th = th;
        goto L13
    }

    public void noteAlarmStart(final String name, WorkSource workSource, final int uid) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", "noteAlarmStart");
        if (workSource == null) goto L5;
        WorkSource r0 = new WorkSource(workSource);
    L6:
        final WorkSource localWs = r0;
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda29(this, name, localWs, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L13
        throw r12;
    L13:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteAlarmStart$22(String name, WorkSource localWs, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteAlarmStartLocked(name, localWs, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteAlarmFinish(final String name, WorkSource workSource, final int uid) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_DEVICE_STATS", "noteAlarmFinish");
        if (workSource == null) goto L5;
        WorkSource r0 = new WorkSource(workSource);
    L6:
        final WorkSource localWs = r0;
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda63(this, name, localWs, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L13
        throw r12;
    L13:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteAlarmFinish$23(String name, WorkSource localWs, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteAlarmFinishLocked(name, localWs, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteStartWakelock(final int uid, final int pid, final String name, final String historyName, final int type, final boolean unimportantForLogging) {
        super.noteStartWakelock_enforcePermission();
        Object r12 = this.mLock;
        monitor-enter(r12);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda1(this, uid, pid, name, historyName, type, unimportantForLogging, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteStartWakelock$24(int uid, int pid, String name, String historyName, int type, boolean unimportantForLogging, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStartWakeLocked(uid, pid, null, name, historyName, type, unimportantForLogging, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteStopWakelock(final int uid, final int pid, final String name, final String historyName, final int type) {
        super.noteStopWakelock_enforcePermission();
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda9(this, uid, pid, name, historyName, type, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteStopWakelock$25(int uid, int pid, String name, String historyName, int type, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStopWakeLocked(uid, pid, null, name, historyName, type, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteStartWakelockFromSource(WorkSource ws, final int pid, final String name, final String historyName, final int type, final boolean unimportantForLogging) {
        super.noteStartWakelockFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r14 = this.mLock;
        monitor-enter(r14);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda21(this, localWs, pid, name, historyName, type, unimportantForLogging, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r14);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteStartWakelockFromSource$26(WorkSource localWs, int pid, String name, String historyName, int type, boolean unimportantForLogging, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStartWakeFromSourceLocked(localWs, pid, name, historyName, type, unimportantForLogging, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteChangeWakelockFromSource(WorkSource ws, final int pid, final String name, final String historyName, final int type, WorkSource newWs, final int newPid, final String newName, final String newHistoryName, final int newType, final boolean newUnimportantForLogging) {
        super.noteChangeWakelockFromSource_enforcePermission();
        WorkSource r0 = null;
        if (ws == null) goto L5;
        WorkSource localWs = new WorkSource(ws);
    L6:
        if (newWs == null) goto L8;
        r0 = new WorkSource(newWs);
    L8:
        final WorkSource localNewWs = r0;
        Object r5 = this.mLock;
        monitor-enter(r5);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        final WorkSource localWs2 = localWs;
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda33(this, localWs2, pid, name, historyName, type, localNewWs, newPid, newName, newHistoryName, newType, newUnimportantForLogging, elapsedRealtime, uptime));     // Catch: Throwable -> L15
        monitor-exit(r5);     // Catch: Throwable -> L15
        return;
    L15:
        th = th;
    L19:
        monitor-exit(r5);     // Catch: Throwable -> L15
        throw th;
    L17:
        th = th;
        goto L19
    L5:
        localWs = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteChangeWakelockFromSource$27(WorkSource localWs, int pid, String name, String historyName, int type, WorkSource localNewWs, int newPid, String newName, String newHistoryName, int newType, boolean newUnimportantForLogging, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        this.mStats.noteChangeWakelockFromSourceLocked(localWs, pid, name, historyName, type, localNewWs, newPid, newName, newHistoryName, newType, newUnimportantForLogging, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteStopWakelockFromSource(WorkSource ws, final int pid, final String name, final String historyName, final int type) {
        super.noteStopWakelockFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r12 = this.mLock;
        monitor-enter(r12);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda38(this, localWs, pid, name, historyName, type, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteStopWakelockFromSource$28(WorkSource localWs, int pid, String name, String historyName, int type, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStopWakeFromSourceLocked(localWs, pid, name, historyName, type, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteLongPartialWakelockStart(final String name, final String historyName, final int uid) {
        super.noteLongPartialWakelockStart_enforcePermission();
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda110(this, name, historyName, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteLongPartialWakelockStart$29(String name, String historyName, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteLongPartialWakelockStart(name, historyName, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteLongPartialWakelock(name, historyName, uid);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteLongPartialWakelockStartFromSource(final String name, final String historyName, final WorkSource workSource) {
        super.noteLongPartialWakelockStartFromSource_enforcePermission();
        if (workSource == null) goto L5;
        WorkSource r0 = new WorkSource(workSource);
    L6:
        final WorkSource localWs = r0;
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda45(this, name, historyName, localWs, elapsedRealtime, uptime, workSource));     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r13 = th;
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L13
        throw r13;
    L15:
        th = move-exception;
        r13 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteLongPartialWakelockStartFromSource$30(String name, String historyName, WorkSource localWs, long elapsedRealtime, long uptime, WorkSource workSource) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteLongPartialWakelockStartFromSource(name, historyName, localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L11
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteLongPartialWakelockStartFromSource(name, historyName, workSource);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    public void noteLongPartialWakelockFinish(final String name, final String historyName, final int uid) {
        super.noteLongPartialWakelockFinish_enforcePermission();
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda37(this, name, historyName, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteLongPartialWakelockFinish$31(String name, String historyName, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteLongPartialWakelockFinish(name, historyName, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteLongPartialWakelockFinish(name, historyName, uid);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteLongPartialWakelockFinishFromSource(final String name, final String historyName, final WorkSource workSource) {
        super.noteLongPartialWakelockFinishFromSource_enforcePermission();
        if (workSource == null) goto L5;
        WorkSource r0 = new WorkSource(workSource);
    L6:
        final WorkSource localWs = r0;
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda52(this, name, historyName, localWs, elapsedRealtime, uptime, workSource));     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r13 = th;
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L13
        throw r13;
    L15:
        th = move-exception;
        r13 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteLongPartialWakelockFinishFromSource$32(String name, String historyName, WorkSource localWs, long elapsedRealtime, long uptime, WorkSource workSource) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteLongPartialWakelockFinishFromSource(name, historyName, localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L11
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteLongPartialWakelockFinishFromSource(name, historyName, workSource);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    public void noteStartSensor(final int uid, final int sensor) {
        super.noteStartSensor_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda32(this, uid, sensor, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(5, uid, null, sensor, 1);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStartSensor$33(int uid, int sensor, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStartSensorLocked(uid, sensor, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWakeupSensorEvent(long elapsedNanos, int uid, int sensorHandle) {
        int callingUid = Binder.getCallingUid();
        if (callingUid != 1000) goto L14;
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(elapsedNanos);
        SensorManager sm = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        Sensor sensor = sm.getSensorByHandle(sensorHandle);
        if (sensor != null) goto L8;
        Slog.w(TAG, "Unknown sensor handle " + sensorHandle + " received in noteWakeupSensorEvent");
        return;
    L8:
        if (uid >= 0) goto L11;
        Slog.wtf(TAG, "Invalid uid " + uid + " for sensor event with sensor: " + sensor);
        return;
    L11:
        noteCpuWakingActivity(4, elapsedMillis, new int[]{uid});
        return;
    L14:
        throw new SecurityException("Calling uid " + callingUid + " is not system uid");
    }

    public void noteStopSensor(final int uid, final int sensor) {
        super.noteStopSensor_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda86(this, uid, sensor, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(5, uid, null, sensor, 0);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStopSensor$34(int uid, int sensor, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteStopSensorLocked(uid, sensor, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteVibratorOn(final int uid, final long durationMillis) {
        super.noteVibratorOn_enforcePermission();
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda99(this, uid, durationMillis, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteVibratorOn$35(int uid, long durationMillis, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteVibratorOnLocked(uid, durationMillis, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setVibratorState(uid, true);     // Catch: Throwable -> L7
        SysOptBridge.getFactory().getAppRecordManagerService().uidStartVibrator(uid);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteVibratorOff(final int uid) {
        super.noteVibratorOff_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda24(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteVibratorOff$36(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteVibratorOffLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setVibratorState(uid, false);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStopVibrator(uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteGpsChanged(WorkSource oldWs, WorkSource newWs) {
        super.noteGpsChanged_enforcePermission();
        WorkSource r0 = null;
        if (oldWs == null) goto L5;
        WorkSource r1 = new WorkSource(oldWs);
    L6:
        final WorkSource localOldWs = r1;
        if (newWs == null) goto L9;
        r0 = new WorkSource(newWs);
    L9:
        final WorkSource localNewWs = r0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda91(this, localOldWs, localNewWs, elapsedRealtime, uptime));     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteGpsChanged$37(WorkSource localOldWs, WorkSource localNewWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteGpsChangedLocked(localOldWs, localNewWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteGpsSignalQuality(final int signalLevel) {
        super.noteGpsSignalQuality_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda103(this, signalLevel, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteGpsSignalQuality$38(int signalLevel, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteGpsSignalQualityLocked(signalLevel, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteScreenState(final int displayId, final int state, final int reason) {
        super.noteScreenState_enforcePermission();
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        final long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda75(this, displayId, state, reason, elapsedRealtime, uptime, currentTime));     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        FrameworkStatsLog.write(29, state);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteScreenState$39(int displayId, int state, int reason, long elapsedRealtime, long uptime, long currentTime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteScreenStateLocked(displayId, state, reason, elapsedRealtime, uptime, currentTime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteScreenBrightness(final int displayId, final int brightness) {
        super.noteScreenBrightness_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda50(this, displayId, brightness, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write(9, brightness);
        return;
    L10:
        th = move-exception;
        Throwable r13 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r13;
    L12:
        th = move-exception;
        r13 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteScreenBrightness$40(int displayId, int brightness, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteScreenBrightnessLocked(displayId, brightness, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setScreenBrightness(brightness);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteUserActivity(final int uid, final int event) {
        super.noteUserActivity_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda56(this, uid, event, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteUserActivity$41(int uid, int event, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteUserActivityLocked(uid, event, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWakeUp(final String reason, final int reasonUid) {
        super.noteWakeUp_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda82(this, reason, reasonUid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWakeUp$42(String reason, int reasonUid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWakeUpLocked(reason, reasonUid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteInteractive(final boolean interactive) {
        super.noteInteractive_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda109(this, interactive, elapsedRealtime));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteInteractive$43(boolean interactive, long elapsedRealtime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteInteractiveLocked(interactive, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteConnectivityChanged(final int type, final String extra) {
        super.noteConnectivityChanged_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda62(this, type, extra, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteConnectivityChanged$44(int type, String extra, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteConnectivityChangedLocked(type, extra, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteMobileRadioPowerState(final int powerState, final long timestampNs, final int uid) {
        super.noteMobileRadioPowerState_enforcePermission();
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
    L20:
        th = th;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L14
    L15:
        throw th;
    L7:
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda102(this, powerState, timestampNs, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        FrameworkStatsLog.write_non_chained(12, uid, null, powerState);
        return;
    L11:
        th = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteMobileRadioPowerState$45(int powerState, long timestampNs, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastPowerStateFromRadio != powerState) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mLastPowerStateFromRadio = powerState;     // Catch: Throwable -> L8
        this.mStats.noteMobileRadioPowerStateLocked(powerState, timestampNs, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
    }

    public void notePhoneOn() {
        super.notePhoneOn_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda51(this, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notePhoneOn$46(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.notePhoneOnLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notePhoneOff() {
        super.notePhoneOff_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda64(this, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notePhoneOff$47(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.notePhoneOffLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notePhoneSignalStrength(final SignalStrength signalStrength) {
        super.notePhoneSignalStrength_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda74(this, signalStrength, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$notePhoneSignalStrength$48(SignalStrength signalStrength, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.notePhoneSignalStrengthLocked(signalStrength, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().notePhoneSignalStrength(signalStrength.getLevel());     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void notePhoneDataConnectionState(final int dataType, final boolean hasData, final int serviceType, final int nrState, final int nrFrequency) {
        super.notePhoneDataConnectionState_enforcePermission();
        Object r11 = this.mLock;
        monitor-enter(r11);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda79(this, dataType, hasData, serviceType, nrState, nrFrequency, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notePhoneDataConnectionState$49(int dataType, boolean hasData, int serviceType, int nrState, int nrFrequency, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.notePhoneDataConnectionStateLocked(dataType, hasData, serviceType, nrState, nrFrequency, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notePhoneState(final int state) {
        super.notePhoneState_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda53(this, state, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$notePhoneState$50(int state, long elapsedRealtime, long uptime) {
        int simState = ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).getSimState();
        BatteryStatsImpl r8 = this.mStats;
        monitor-enter(r8);
        this.mStats.notePhoneStateLocked(state, simState, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L9
        throw r10;
    L11:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWifiOn() {
        super.noteWifiOn_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda39(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write(113, 1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteWifiOn$51(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteWifiOnLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteWifiOff() {
        super.noteWifiOff_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda31(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write(113, 0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteWifiOff$52(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteWifiOffLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteStartAudio(final int uid) {
        super.noteStartAudio_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda80(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(23, uid, null, 1);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStartAudio$53(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteAudioOnLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStartAudio(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("audio", 1, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteStopAudio(final int uid) {
        super.noteStopAudio_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda100(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(23, uid, null, 0);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStopAudio$54(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteAudioOffLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStopAudio(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("audio", 0, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteStartVideo(final int uid) {
        super.noteStartVideo_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda76(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(24, uid, null, 1);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStartVideo$55(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteVideoOnLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStartVideo(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("video", 1, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteStopVideo(final int uid) {
        super.noteStopVideo_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda28(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(24, uid, null, 0);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStopVideo$56(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteVideoOffLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStopVideo(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("video", 0, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteResetAudio() {
        super.noteResetAudio_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda27(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write_non_chained(23, -1, null, 2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteResetAudio$57(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteResetAudioLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("audio", -1, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteResetVideo() {
        super.noteResetVideo_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda12(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write_non_chained(24, -1, null, 2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteResetVideo$58(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteResetVideoLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("video", -1, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteFlashlightOn(final int uid) {
        super.noteFlashlightOn_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda49(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(26, uid, null, 1);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteFlashlightOn$59(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFlashlightOnLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setFlashlightState(true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteFlashlightOff(final int uid) {
        super.noteFlashlightOff_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda54(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(26, uid, null, 0);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteFlashlightOff$60(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFlashlightOffLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().setFlashlightState(false);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteStartCamera(final int uid) {
        super.noteStartCamera_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda93(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(25, uid, null, 1);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStartCamera$61(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteCameraOnLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStartCamera(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("camera", 1, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteStopCamera(final int uid) {
        super.noteStopCamera_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        Handler r0 = this.mHandler;     // Catch: Throwable -> L12
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda48(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FrameworkStatsLog.write_non_chained(25, uid, null, 0);
        return;
    L10:
        th = move-exception;
        Throwable r12 = th;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L12:
        th = move-exception;
        r12 = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteStopCamera$62(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteCameraOffLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysOptBridge.getFactory().getAppRecordManagerService().uidStopCamera(uid);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("camera", 0, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteResetCamera() {
        super.noteResetCamera_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda0(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write_non_chained(25, -1, null, 2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteResetCamera$63(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteResetCameraLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteStateChanged("camera", -1, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteResetFlashlight() {
        super.noteResetFlashlight_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda92(this, elapsedRealtime, uptime));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        FrameworkStatsLog.write_non_chained(26, -1, null, 2);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteResetFlashlight$64(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteResetFlashlightLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteWifiRadioPowerState(final int powerState, final long tsNanos, final int uid) {
        super.noteWifiRadioPowerState_enforcePermission();
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
    L20:
        th = th;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L14
    L15:
        throw th;
    L7:
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda22(this, powerState, tsNanos, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        FrameworkStatsLog.write_non_chained(13, uid, null, powerState);
        return;
    L11:
        th = th;
        goto L14
    }

    private /* synthetic */ void lambda$noteWifiRadioPowerState$65(int powerState, long tsNanos, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastPowerStateFromWifi != powerState) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        this.mLastPowerStateFromWifi = powerState;     // Catch: Throwable -> L8
        if (this.mStats.isOnBattery() == true) goto L13;
    L19:
        this.mStats.noteWifiRadioPowerState(powerState, tsNanos, uid, elapsedRealtime, uptime);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L13:
        if (powerState == 3) goto L17;
        if (powerState == 2) goto L17;
        String type = "inactive";
    L18:
        this.mWorker.scheduleSync("wifi-data: " + type, 2);     // Catch: Throwable -> L8
    L17:
        type = DomainVerificationPersistence.TAG_ACTIVE;
        goto L18
    }

    public void noteWifiRunning(WorkSource ws) {
        super.noteWifiRunning_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda8(this, localWs, elapsedRealtime, uptime));     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        FrameworkStatsLog.write(114, ws, 1);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiRunning$66(WorkSource localWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiRunningLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiRunningChanged(WorkSource oldWs, WorkSource newWs) {
        super.noteWifiRunningChanged_enforcePermission();
        WorkSource r0 = null;
        if (oldWs == null) goto L5;
        WorkSource r1 = new WorkSource(oldWs);
    L6:
        final WorkSource localOldWs = r1;
        if (newWs == null) goto L9;
        r0 = new WorkSource(newWs);
    L9:
        final WorkSource localNewWs = r0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda58(this, localOldWs, localNewWs, elapsedRealtime, uptime));     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        FrameworkStatsLog.write(114, newWs, 1);
        FrameworkStatsLog.write(114, oldWs, 0);
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        r1 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiRunningChanged$67(WorkSource localOldWs, WorkSource localNewWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiRunningChangedLocked(localOldWs, localNewWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWifiStopped(WorkSource ws) {
        super.noteWifiStopped_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda26(this, localWs, elapsedRealtime, uptime));     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        FrameworkStatsLog.write(114, ws, 0);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r0 = ws;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiStopped$68(WorkSource localWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiStoppedLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiState(final int wifiState, final String accessPoint) {
        super.noteWifiState_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda46(this, wifiState, accessPoint, elapsedRealtime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r11 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L11:
        th = move-exception;
        r11 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiState$69(int wifiState, String accessPoint, long elapsedRealtime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteWifiStateLocked(wifiState, accessPoint, elapsedRealtime);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteWifiSupplicantStateChanged(final int supplState, final boolean failedAuth) {
        super.noteWifiSupplicantStateChanged_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda41(this, supplState, failedAuth, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r13 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r13;
    L9:
        th = move-exception;
        r13 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiSupplicantStateChanged$70(int supplState, boolean failedAuth, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiSupplicantStateChangedLocked(supplState, failedAuth, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWifiRssiChanged(final int newRssi) {
        super.noteWifiRssiChanged_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda44(this, newRssi, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiRssiChanged$71(int newRssi, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiRssiChangedLocked(newRssi, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWifiRssiChangedLocked(newRssi);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteFullWifiLockAcquired(final int uid) {
        super.noteFullWifiLockAcquired_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda2(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteFullWifiLockAcquired$72(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFullWifiLockAcquiredLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteFullWifiLockStateChange(uid, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteFullWifiLockReleased(final int uid) {
        super.noteFullWifiLockReleased_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda59(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteFullWifiLockReleased$73(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFullWifiLockReleasedLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteFullWifiLockStateChange(uid, false);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiScanStarted(final int uid) {
        super.noteWifiScanStarted_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda83(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiScanStarted$74(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiScanStartedLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWifiScanStateChange(uid, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiScanStopped(final int uid) {
        super.noteWifiScanStopped_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda57(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiScanStopped$75(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiScanStoppedLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWifiScanStateChange(uid, false);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiMulticastEnabled(final int uid) {
        super.noteWifiMulticastEnabled_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda4(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiMulticastEnabled$76(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiMulticastEnabledLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiMulticastDisabled(final int uid) {
        super.noteWifiMulticastDisabled_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda25(this, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$noteWifiMulticastDisabled$77(int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiMulticastDisabledLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteFullWifiLockAcquiredFromSource(WorkSource ws) {
        super.noteFullWifiLockAcquiredFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda97(this, localWs, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteFullWifiLockAcquiredFromSource$78(WorkSource localWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFullWifiLockAcquiredFromSourceLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteFullWifiLockStateChange(localWs, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteFullWifiLockReleasedFromSource(WorkSource ws) {
        super.noteFullWifiLockReleasedFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda36(this, localWs, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteFullWifiLockReleasedFromSource$79(WorkSource localWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteFullWifiLockReleasedFromSourceLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteFullWifiLockStateChange(localWs, false);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiScanStartedFromSource(final WorkSource ws) {
        super.noteWifiScanStartedFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda61(this, localWs, elapsedRealtime, uptime, ws));     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r11 = th;
    L17:
        monitor-exit(r9);     // Catch: Throwable -> L13
        throw r11;
    L15:
        th = move-exception;
        r11 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiScanStartedFromSource$80(WorkSource localWs, long elapsedRealtime, long uptime, WorkSource ws) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiScanStartedFromSourceLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWifiScanStateChange(ws, true);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiScanStoppedFromSource(final WorkSource ws) {
        super.noteWifiScanStoppedFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda69(this, localWs, elapsedRealtime, uptime, ws));     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r11 = th;
    L17:
        monitor-exit(r9);     // Catch: Throwable -> L13
        throw r11;
    L15:
        th = move-exception;
        r11 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiScanStoppedFromSource$81(WorkSource localWs, long elapsedRealtime, long uptime, WorkSource ws) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiScanStoppedFromSourceLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteWifiScanStateChange(ws, false);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteWifiBatchedScanStartedFromSource(WorkSource ws, final int csph) {
        super.noteWifiBatchedScanStartedFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda107(this, localWs, csph, elapsedRealtime, uptime));     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r9);     // Catch: Throwable -> L13
        throw r12;
    L15:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiBatchedScanStartedFromSource$82(WorkSource localWs, int csph, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiBatchedScanStartedFromSourceLocked(localWs, csph, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWifiBatchedScanStoppedFromSource(WorkSource ws) {
        super.noteWifiBatchedScanStoppedFromSource_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda3(this, localWs, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteWifiBatchedScanStoppedFromSource$83(WorkSource localWs, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteWifiBatchedScanStoppedFromSourceLocked(localWs, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteNetworkInterfaceForTransports(final String iface, final int[] transportTypes) {
        super.noteNetworkInterfaceForTransports_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda96(this, iface, transportTypes));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteNetworkInterfaceForTransports$84(String iface, int[] transportTypes) {
        this.mStats.noteNetworkInterfaceForTransports(iface, transportTypes);
    }

    public void noteNetworkStatsEnabled() {
        super.noteNetworkStatsEnabled_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda70(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteNetworkStatsEnabled$85() {
        this.mWorker.scheduleSync("network-stats-enabled", 6);
    }

    public void noteDeviceIdleMode(final int mode, final String activeReason, final int activeUid) {
        super.noteDeviceIdleMode_enforcePermission();
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda72(this, mode, activeReason, activeUid, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteDeviceIdleMode$86(int mode, String activeReason, int activeUid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteDeviceIdleModeLocked(mode, activeReason, activeUid, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notePackageInstalled(final String pkgName, final long versionCode) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda40(this, pkgName, versionCode, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$notePackageInstalled$87(String pkgName, long versionCode, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.notePackageInstalledLocked(pkgName, versionCode, elapsedRealtime, uptime);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notePackageUninstalled(final String pkgName) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda85(this, pkgName, elapsedRealtime, uptime));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r12 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L11:
        th = move-exception;
        r12 = th;
        goto L13
    }

    private /* synthetic */ void lambda$notePackageUninstalled$88(String pkgName, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.notePackageUninstalledLocked(pkgName, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L9:
        th = move-exception;
        r9 = th;
        goto L13
    }

    public void noteBleScanStarted(final WorkSource ws, final boolean isUnoptimized) {
        super.noteBleScanStarted_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda6(this, localWs, isUnoptimized, elapsedRealtime, uptime, ws));     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L13
        throw r12;
    L15:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteBleScanStarted$89(WorkSource localWs, boolean isUnoptimized, long elapsedRealtime, long uptime, WorkSource ws) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteBluetoothScanStartedFromSourceLocked(localWs, isUnoptimized, elapsedRealtime, uptime);     // Catch: Throwable -> L11
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteBleScanStarted(ws, isUnoptimized);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    public void noteBleScanStopped(final WorkSource ws, final boolean isUnoptimized) {
        super.noteBleScanStopped_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda95(this, localWs, isUnoptimized, elapsedRealtime, uptime, ws));     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L13
        throw r12;
    L15:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteBleScanStopped$90(WorkSource localWs, boolean isUnoptimized, long elapsedRealtime, long uptime, WorkSource ws) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteBluetoothScanStoppedFromSourceLocked(localWs, isUnoptimized, elapsedRealtime, uptime);     // Catch: Throwable -> L11
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteBleScanStopped(ws, isUnoptimized);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    public void noteBleScanReset() {
        super.noteBleScanReset_enforcePermission();
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda43(this, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteBleScanReset$91(long elapsedRealtime, long uptime) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteResetBluetoothScanLocked(elapsedRealtime, uptime);     // Catch: Throwable -> L7
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteResetBleScan();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void noteBleScanResults(WorkSource ws, final int numNewResults) {
        super.noteBleScanResults_enforcePermission();
        if (ws == null) goto L5;
        WorkSource r0 = new WorkSource(ws);
    L6:
        final WorkSource localWs = r0;
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        Handler r1 = this.mHandler;     // Catch: Throwable -> L15
        r1.post(new BatteryStatsService$$ExternalSyntheticLambda73(this, localWs, numNewResults, elapsedRealtime, uptime));     // Catch: Throwable -> L13
        monitor-exit(r9);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r9);     // Catch: Throwable -> L13
        throw r12;
    L15:
        th = move-exception;
        r12 = th;
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$noteBleScanResults$92(WorkSource localWs, int numNewResults, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteBluetoothScanResultsFromSourceLocked(localWs, numNewResults, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    public void noteWifiControllerActivity(final WifiActivityEnergyInfo info) {
        super.noteWifiControllerActivity_enforcePermission();
        if (info == null) goto L21;
        if (info.isValid() == false) goto L21;
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L16
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L16
        final NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);     // Catch: Throwable -> L16
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda47(this, info, elapsedRealtime, uptime, networkStatsManager));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Throwable r13 = th;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r13;
    L16:
        th = move-exception;
        r13 = th;
    L21:
        Slog.e(TAG, "invalid wifi data given: " + info);
    }

    private /* synthetic */ void lambda$noteWifiControllerActivity$93(WifiActivityEnergyInfo info, long elapsedRealtime, long uptime, NetworkStatsManager networkStatsManager) {
        this.mStats.updateWifiState(info, -1, elapsedRealtime, uptime, networkStatsManager);
    }

    public void noteBluetoothControllerActivity(final BluetoothActivityEnergyInfo info) {
        super.noteBluetoothControllerActivity_enforcePermission();
        if (info == null) goto L21;
        if (info.isValid() == false) goto L21;
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L16
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L16
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda30(this, info, elapsedRealtime, uptime));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Throwable r12 = th;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r12;
    L16:
        th = move-exception;
        r12 = th;
    L21:
        Slog.e(TAG, "invalid bluetooth data given: " + info);
    }

    private /* synthetic */ void lambda$noteBluetoothControllerActivity$94(BluetoothActivityEnergyInfo info, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.updateBluetoothStateLocked(info, -1, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L9:
        th = move-exception;
        r11 = th;
        goto L13
    }

    public void noteModemControllerActivity(final ModemActivityInfo info) {
        super.noteModemControllerActivity_enforcePermission();
        if (info != null) goto L6;
        Slog.e(TAG, "invalid modem data given: " + info);
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
        final NetworkStatsManager networkStatsManager = (NetworkStatsManager) this.mContext.getSystemService(NetworkStatsManager.class);     // Catch: Throwable -> L15
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda66(this, info, elapsedRealtime, uptime, networkStatsManager));     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Throwable r13 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        throw r13;
    L15:
        th = move-exception;
        r13 = th;
        goto L17
    }

    private /* synthetic */ void lambda$noteModemControllerActivity$95(ModemActivityInfo info, long elapsedRealtime, long uptime, NetworkStatsManager networkStatsManager) {
        this.mStats.noteModemControllerActivity(info, -1, elapsedRealtime, uptime, networkStatsManager);
    }

    public boolean isOnBattery() {
        return this.mStats.isOnBattery();
    }

    public void setBatteryState(final int status, final int health, final int plugType, final int level, final int temp, final int volt, final int chargeUAh, final int chargeFullUAh, final long chargeTimeToFullSeconds) {
        super.setBatteryState_enforcePermission();
        Object r2 = this.mLock;
        monitor-enter(r2);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        final long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new BatteryStatsService$$ExternalSyntheticLambda11(this, plugType, status, health, level, temp, volt, chargeUAh, chargeFullUAh, chargeTimeToFullSeconds, elapsedRealtime, uptime, currentTime));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    private /* synthetic */ void lambda$setBatteryState$98(final int plugType, final int status, final int health, final int level, final int temp, final int volt, final int chargeUAh, final int chargeFullUAh, final long chargeTimeToFullSeconds, final long elapsedRealtime, final long uptime, final long currentTime) {
        this.mWorker.scheduleRunnable(new BatteryStatsService$$ExternalSyntheticLambda60(this, plugType, status, health, level, temp, volt, chargeUAh, chargeFullUAh, chargeTimeToFullSeconds, elapsedRealtime, uptime, currentTime));
    }

    private /* synthetic */ void lambda$setBatteryState$97(final int plugType, final int status, final int health, final int level, final int temp, final int volt, final int chargeUAh, final int chargeFullUAh, final long chargeTimeToFullSeconds, final long elapsedRealtime, final long uptime, final long currentTime) {
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        boolean onBattery = BatteryStatsImpl.isOnBattery(plugType, status);     // Catch: Throwable -> L9
        if (this.mStats.isOnBattery() != onBattery) goto L12;
        this.mStats.setBatteryStateLocked(status, health, plugType, level, temp, volt, chargeUAh, chargeFullUAh, chargeTimeToFullSeconds, elapsedRealtime, uptime, currentTime);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L9
        this.mWorker.scheduleSync("battery-state", 127);
        this.mWorker.scheduleRunnable(new BatteryStatsService$$ExternalSyntheticLambda89(this, status, health, plugType, level, temp, volt, chargeUAh, chargeFullUAh, chargeTimeToFullSeconds, elapsedRealtime, uptime, currentTime));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setBatteryState$96(int status, int health, int plugType, int level, int temp, int volt, int chargeUAh, int chargeFullUAh, long chargeTimeToFullSeconds, long elapsedRealtime, long uptime, long currentTime) {
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        this.mStats.setBatteryStateLocked(status, health, plugType, level, temp, volt, chargeUAh, chargeFullUAh, chargeTimeToFullSeconds, elapsedRealtime, uptime, currentTime);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long getAwakeTimeBattery() {
        super.getAwakeTimeBattery_enforcePermission();
        return this.mStats.getAwakeTimeBattery();
    }

    public long getAwakeTimePlugged() {
        super.getAwakeTimePlugged_enforcePermission();
        return this.mStats.getAwakeTimePlugged();
    }

    private void dumpHelp(PrintWriter pw) {
        pw.println("Battery stats (batterystats) dump options:");
        pw.println("  [--checkin] [--proto] [--history] [--history-start] [--charged] [-c]");
        pw.println("  [--daily] [--reset] [--reset-all] [--write] [--new-daily] [--read-daily]");
        pw.println("  [-h] [<package.name>]");
        pw.println("  --checkin: generate output for a checkin report; will write (and clear) the");
        pw.println("             last old completed stats when they had been reset.");
        pw.println("  -c: write the current stats in checkin format.");
        pw.println("  --proto: write the current aggregate stats (without history) in proto format.");
        pw.println("  --history: show only history data.");
        pw.println("  --history-start <num>: show only history data starting at given time offset.");
        pw.println("  --history-create-events <num>: create <num> of battery history events.");
        pw.println("  --charged: only output data since last charged.");
        pw.println("  --daily: only output full daily data.");
        pw.println("  --reset: reset the stats, clearing all current data.");
        pw.println("  --reset-all: reset the stats, clearing all current and past data.");
        pw.println("  --write: force write current collected stats to disk.");
        pw.println("  --new-daily: immediately create and write new daily stats record.");
        pw.println("  --read-daily: read-load last written daily stats.");
        pw.println("  --settings: dump the settings key/values related to batterystats");
        pw.println("  --cpu: dump cpu stats for debugging purpose");
        pw.println("  --wakeups: dump CPU wakeup history and attribution.");
        pw.println("  --power-profile: dump the power profile constants");
        pw.println("  --usage: write battery usage stats. Optional arguments:");
        pw.println("     --proto: output as a binary protobuffer");
        pw.println("     --model power-profile: use the power profile model even if measured energy is available");
        pw.println("  --sample: collect and dump a sample of stats for debugging purpose");
        if (isBatteryUsageStatsAccumulationSupported() == false) goto L5;
        pw.println("  --accumulated: continuously accumulated since setup or reset-all");
    L5:
        pw.println("  <package.name>: optional name of package to filter output by.");
        pw.println("  -h: print this help text.");
        pw.println("Battery stats (batterystats) commands:");
        pw.println("  enable|disable <option>");
        pw.println("    Enable or disable a running option.  Option state is not saved across boots.");
        pw.println("    Options are:");
        pw.println("      full-history: include additional detailed events in battery history:");
        pw.println("          wake_lock_in, alarms and proc events");
        pw.println("      no-auto-reset: don't automatically reset stats when unplugged");
        pw.println("      pretend-screen-off: pretend the screen is off, even if screen state changes");
    }

    private void dumpSettings(PrintWriter pw) {
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.dumpConstantsLocked(pw);     // Catch: Throwable -> L7
        pw.println("Flags:");     // Catch: Throwable -> L7
        pw.println("    com.android.server.power.optimization.streamlined_battery_stats: true");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpCpuStats(PrintWriter pw) {
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.dumpCpuStatsLocked(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpStatsSample(PrintWriter pw) {
        this.mStats.dumpStatsSample(pw);
    }

    private void dumpAggregatedStats(PrintWriter pw) {
        this.mPowerStatsScheduler.aggregateAndDumpPowerStats(pw);
    }

    private void dumpPowerStatsStore(PrintWriter pw) {
        this.mPowerStatsStore.dump(new IndentingPrintWriter(pw, "  "));
    }

    private void dumpPowerStatsStoreTableOfContents(PrintWriter pw) {
        this.mPowerStatsStore.dumpTableOfContents(new IndentingPrintWriter(pw, "  "));
    }

    private void dumpMeasuredEnergyStats(PrintWriter pw) {
        awaitCompletion();
        syncStats(ArchiveStreamFactory.DUMP, 127);
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.dumpEnergyConsumerStatsLocked(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpPowerProfile(PrintWriter pw) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.dumpPowerProfileLocked(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpUsageStats(FileDescriptor fd, PrintWriter pw, boolean proto, boolean accumulated) {
        awaitCompletion();
        syncStats(ArchiveStreamFactory.DUMP, 127);
        BatteryUsageStatsQuery.Builder builder = new BatteryUsageStatsQuery.Builder().setMaxStatsAgeMs(0).includeProcessStateData().includePowerModels();
        builder.includeScreenStateData().includePowerStateData();
        if (accumulated == false) goto L5;
        builder.accumulated();
    L5:
        BatteryUsageStatsQuery query = builder.build();
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        this.mStats.prepareForDumpLocked();     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L31
        this.mStats.collectPowerStatsSamples();
        BatteryUsageStats batteryUsageStats = this.mBatteryUsageStatsProvider.getBatteryUsageStats(this.mStats, query);     // Catch: IOException -> L19
        if (proto == false) goto L15;
        batteryUsageStats.dumpToProto(fd);     // Catch: Throwable -> L13
    L16:
        if (batteryUsageStats == null) goto L41;
        batteryUsageStats.close();     // Catch: IOException -> L19
        return;
    L41:
        return;
    L15:
        batteryUsageStats.dump(pw, "  ");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (batteryUsageStats != null) goto L36;
    L28:
        throw th;     // Catch: IOException -> L19
    L36:
        batteryUsageStats.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Cannot close BatteryUsageStats", e);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    private int doEnableOrDisable(PrintWriter pw, int i, String[] args, boolean enable) {
        int i2 = i + 1;
        if (i2 < args.length) goto L11;
        StringBuilder r0 = new StringBuilder();
        r0.append("Missing option argument for ");
        if (enable == false) goto L7;
        String r2 = "--enable";
    L8:
        r0.append(r2);
        pw.println(r0.toString());
        dumpHelp(pw);
        return -1;
    L7:
        r2 = "--disable";
        goto L8
    L11:
        if ("full-wake-history".equals(args[i2]) == false) goto L13;
    L37:
        awaitCompletion();
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.setRecordAllHistoryLocked(enable);     // Catch: Throwable -> L42
        monitor-exit(r1);     // Catch: Throwable -> L42
    L41:
        return i2;
    L42:
        th = move-exception;
        throw th;
    L13:
        if ("full-history".equals(args[i2]) == true) goto L37;
        if ("no-auto-reset".equals(args[i2]) == false) goto L26;
        awaitCompletion();
        BatteryStatsImpl r3 = this.mStats;
        monitor-enter(r3);
        this.mStats.setNoAutoReset(enable);     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L26:
        if ("pretend-screen-off".equals(args[i2]) == false) goto L35;
        awaitCompletion();
        BatteryStatsImpl r4 = this.mStats;
        monitor-enter(r4);
        this.mStats.setPretendScreenOff(enable);     // Catch: Throwable -> L32
        monitor-exit(r4);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    L35:
        pw.println("Unknown enable/disable option: " + args[i2]);
        dumpHelp(pw);
        return -1;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        this.mMonitorEnabled = false;
        dumpUnmonitored(fd, pw, args);     // Catch: Throwable -> L6
        this.mMonitorEnabled = true;
        return;
    L6:
        th = move-exception;
        this.mMonitorEnabled = true;
        throw th;
    }

    private void dumpUnmonitored(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        int reqUid = -1;
        if (args == null) goto L206;
        int i = 0;
        long historyStart = -1;
        boolean writeData = false;
        boolean writeData2 = false;
        int r6 = 0;
        boolean isRealCheckin = false;
        boolean isRealCheckin2 = false;
        int flags = 0;
    L8:
        int flags2 = args.length;
        if (i >= flags2) goto L205;
        String arg = args[i];
        if ("--checkin".equals(arg) == false) goto L14;
        r6 = 1;
        isRealCheckin2 = true;
    L189:
        i = i + 1;
        goto L8
    L14:
        if ("--history".equals(arg) == false) goto L17;
        flags = flags | 8;
        goto L189
    L17:
        if ("--history-start".equals(arg) == false) goto L24;
        int flags3 = flags | 8;
        i = i + 1;
        if (i >= args.length) goto L20;
        long historyStart2 = ParseUtils.parseLong(args[i], 0);
        writeData = true;
        historyStart = historyStart2;
        flags = flags3;
        goto L189
    L20:
        pw.println("Missing time argument for --history-since");
        dumpHelp(pw);
        return;
    L24:
        if ("--history-create-events".equals(arg) == false) goto L37;
        int i2 = i + 1;
        if (i2 >= args.length) goto L27;
        int flags4 = flags;
        boolean useCheckinFormat = isRealCheckin2;
        long events = ParseUtils.parseLong(args[i2], 0);
        awaitCompletion();
        BatteryStatsImpl r9 = this.mStats;
        monitor-enter(r9);
        this.mStats.createFakeHistoryEvents(events);     // Catch: Throwable -> L34
        pw.println("Battery history create events started.");     // Catch: Throwable -> L34
        writeData2 = true;
        monitor-exit(r9);     // Catch: Throwable -> L34
        i = i2;
        isRealCheckin2 = useCheckinFormat;
        flags = flags4;
    L34:
        th = move-exception;
        throw th;
    L27:
        pw.println("Missing events argument for --history-create-events");
        dumpHelp(pw);
        return;
    L37:
        int flags5 = flags;
        boolean useCheckinFormat2 = isRealCheckin2;
        if ("-c".equals(arg) == false) goto L41;
        flags = flags5 | 16;
        isRealCheckin2 = true;
        goto L189
    L41:
        if ("--proto".equals(arg) == false) goto L44;
        isRealCheckin = true;
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
        goto L189
    L44:
        if ("--charged".equals(arg) == false) goto L47;
        flags = flags5 | 2;
        isRealCheckin2 = useCheckinFormat2;
        goto L189
    L47:
        if ("--daily".equals(arg) == false) goto L50;
        flags = flags5 | 4;
        isRealCheckin2 = useCheckinFormat2;
        goto L189
    L50:
        if ("--reset-all".equals(arg) == false) goto L60;
        awaitCompletion();
        BatteryStatsImpl r3 = this.mStats;
        monitor-enter(r3);
        this.mStats.resetAllStatsAndHistoryLocked(2);     // Catch: Throwable -> L56
        this.mPowerStatsStore.reset();     // Catch: Throwable -> L56
        pw.println("Battery stats and history reset.");     // Catch: Throwable -> L56
        writeData2 = true;
        monitor-exit(r3);     // Catch: Throwable -> L56
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
    L56:
        th = move-exception;
        throw th;
    L60:
        if ("--reset".equals(arg) == false) goto L70;
        awaitCompletion();
        BatteryStatsImpl r4 = this.mStats;
        monitor-enter(r4);
        this.mStats.resetAllStatsAndHistoryLocked(2);     // Catch: Throwable -> L66
        pw.println("Battery stats reset.");     // Catch: Throwable -> L66
        writeData2 = true;
        monitor-exit(r4);     // Catch: Throwable -> L66
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
    L66:
        th = move-exception;
        throw th;
    L70:
        if ("--write".equals(arg) == false) goto L80;
        awaitCompletion();
        syncStats(ArchiveStreamFactory.DUMP, 127);
        BatteryStatsImpl r2 = this.mStats;
        monitor-enter(r2);
        this.mStats.writeSyncLocked();     // Catch: Throwable -> L76
        pw.println("Battery stats written.");     // Catch: Throwable -> L76
        writeData2 = true;
        monitor-exit(r2);     // Catch: Throwable -> L76
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
    L76:
        th = move-exception;
        throw th;
    L80:
        if ("--new-daily".equals(arg) == false) goto L90;
        awaitCompletion();
        BatteryStatsImpl r5 = this.mStats;
        monitor-enter(r5);
        this.mStats.recordDailyStatsLocked();     // Catch: Throwable -> L86
        pw.println("New daily stats written.");     // Catch: Throwable -> L86
        writeData2 = true;
        monitor-exit(r5);     // Catch: Throwable -> L86
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
    L86:
        th = move-exception;
        throw th;
    L90:
        if ("--read-daily".equals(arg) == false) goto L100;
        awaitCompletion();
        BatteryStatsImpl r7 = this.mStats;
        monitor-enter(r7);
        this.mStats.readDailyStatsLocked();     // Catch: Throwable -> L96
        pw.println("Last daily stats read.");     // Catch: Throwable -> L96
        writeData2 = true;
        monitor-exit(r7);     // Catch: Throwable -> L96
        isRealCheckin2 = useCheckinFormat2;
        flags = flags5;
    L96:
        th = move-exception;
        throw th;
    L100:
        if ("--enable".equals(arg) == true) goto L200;
        if ("enable".equals(arg) == true) goto L200;
        if ("--disable".equals(arg) == true) goto L194;
        if ("disable".equals(arg) == true) goto L194;
        if ("-h".equals(arg) == true) goto L111;
        if ("--settings".equals(arg) == true) goto L115;
        if ("--cpu".equals(arg) == true) goto L119;
        if ("--measured-energy".equals(arg) == true) goto L123;
        if ("--power-profile".equals(arg) == true) goto L127;
        if ("--usage".equals(arg) == true) goto L131;
        if ("--wakeups".equals(arg) == true) goto L153;
        boolean toProto = isRealCheckin;
        int r8 = r6;
        if ("--sample".equals(arg) == true) goto L157;
        if ("--aggregated".equals(arg) == true) goto L161;
        if ("--store".equals(arg) == true) goto L165;
        if ("--store-toc".equals(arg) == true) goto L169;
        if ("-a".equals(arg) == false) goto L175;
        flags = flags5 | 32;
        r6 = r8;
        isRealCheckin2 = useCheckinFormat2;
        isRealCheckin = toProto;
        goto L189
    L175:
        if ("--debug".equals(arg) == false) goto L182;
        i = i + 1;
        if (i >= args.length) goto L178;
        flags = flags5 | ParseUtils.parseIntWithBase(args[i], 16, 0);
        r6 = r8;
        isRealCheckin2 = useCheckinFormat2;
        isRealCheckin = toProto;
        goto L189
    L178:
        pw.println("Missing time argument for --flags HEX");
        dumpHelp(pw);
        return;
    L182:
        if (arg.length() > 0) goto L184;
    L302:
        int reqUid2 = this.mContext.getPackageManager().getPackageUidAsUser(arg, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L190
        reqUid = reqUid2;
        r6 = r8;
        isRealCheckin2 = useCheckinFormat2;
        isRealCheckin = toProto;
        flags = flags5;
    L191:
        pw.println("Unknown package: " + arg);
        dumpHelp(pw);
        return;
    L184:
        if (arg.charAt(0) != '-') goto L302;
        pw.println("Unknown option: " + arg);
        dumpHelp(pw);
        return;
    L169:
        dumpPowerStatsStoreTableOfContents(pw);
        return;
    L165:
        dumpPowerStatsStore(pw);
        return;
    L161:
        dumpAggregatedStats(pw);
        return;
    L157:
        dumpStatsSample(pw);
        return;
    L153:
        this.mCpuWakeupStats.dump(new IndentingPrintWriter(pw, "  "), SystemClock.elapsedRealtime());
        return;
    L131:
        boolean proto = false;
        boolean accumulated = false;
        int j = i + 1;
    L133:
        if (j >= args.length) goto L149;
        String r13 = args[j];
        switch(r13.hashCode()) {
            case -1616754616: goto L140;
            case 1316953506: goto L137;
            default: goto L136;
        };
    L136:
        int j2 = j;
    L143:
        byte r10 = -1;
    L144:
        switch(r10) {
            case 0: goto L147;
            case 1: goto L146;
            default: goto L148;
        };
    L146:
        accumulated = true;
        goto L148
    L147:
        proto = true;
    L148:
        j = j2 + 1;
        goto L133
    L137:
        j2 = j;
        if (r13.equals("--accumulated") == false) goto L143;
        r10 = 1;
        goto L144
    L140:
        j2 = j;
        if (r13.equals("--proto") == false) goto L143;
        r10 = 0;
        goto L144
    L149:
        dumpUsageStats(fd, pw, proto, accumulated);
        return;
    L127:
        dumpPowerProfile(pw);
        return;
    L123:
        dumpMeasuredEnergyStats(pw);
        return;
    L119:
        dumpCpuStats(pw);
        return;
    L115:
        dumpSettings(pw);
        return;
    L111:
        dumpHelp(pw);
        return;
    L194:
        int i3 = doEnableOrDisable(pw, i, args, false);
        if (i3 >= 0) goto L197;
        return;
    L197:
        pw.println("Disabled: " + args[i3]);
        return;
    L200:
        int i4 = doEnableOrDisable(pw, i, args, true);
        if (i4 >= 0) goto L203;
        return;
    L203:
        pw.println("Enabled: " + args[i4]);
        return;
    L205:
        int flags6 = flags;
        boolean useCheckinFormat3 = isRealCheckin2;
        boolean toProto2 = isRealCheckin;
        boolean noOutput = writeData2;
        int r44 = reqUid;
        int reqUid3 = r6;
        long r45 = historyStart;
        boolean writeData3 = writeData;
        int reqUid4 = r44;
        long historyStart3 = r45;
    L207:
        if (noOutput == false) goto L209;
        return;
    L209:
        long ident = Binder.clearCallingIdentity();
    L296:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L211:
        if (BatteryStats.checkWifiOnly(this.mContext) == false) goto L213;
        flags6 = flags6 | 64;     // Catch: Throwable -> L296
    L213:
        awaitCompletion();     // Catch: Throwable -> L296
        syncStats(ArchiveStreamFactory.DUMP, 127);     // Catch: Throwable -> L296
        Binder.restoreCallingIdentity(ident);
        if (reqUid4 >= 0) goto L217;
    L219:
        int flags7 = flags6;
    L221:
        if (toProto2 == false) goto L265;
        List<ApplicationInfo> apps = this.mContext.getPackageManager().getInstalledApplications(4325376);
        if (reqUid3 == 0) goto L250;
        AtomicFile r11 = this.mStats.mCheckinFile;
        monitor-enter(r11);
    L236:
        th = th;
    L248:
        monitor-exit(r11);     // Catch: Throwable -> L236
        throw th;
    L227:
        if (this.mStats.mCheckinFile.exists() == true) goto L311;
    L246:
        monitor-exit(r11);     // Catch: Throwable -> L236
        goto L250
    L311:
        byte[] raw = this.mStats.mCheckinFile.readFully();     // Catch: Throwable -> L236 Throwable -> L238
        if (raw == null) goto L246;
        Parcel in = Parcel.obtain();     // Catch: Throwable -> L236 Throwable -> L238
        in.unmarshall(raw, 0, raw.length);     // Catch: Throwable -> L236 Throwable -> L238
        in.setDataPosition(0);     // Catch: Throwable -> L236 Throwable -> L238
        BatteryStatsImpl checkinStats = new BatteryStatsImpl(this.mBatteryStatsConfig, Clock.SYSTEM_CLOCK, this.mMonotonicClock, null, this.mStats.mHandler, null, null, this.mUserManagerUserInfoProvider, this.mPowerProfile, this.mCpuScalingPolicies, new PowerStatsUidResolver());     // Catch: Throwable -> L236 Throwable -> L238
        checkinStats.readSummaryFromParcel(in);     // Catch: Throwable -> L236 Throwable -> L238
        in.recycle();     // Catch: Throwable -> L236 Throwable -> L238
        int flags8 = flags7;
        long historyStart4 = historyStart3;
        checkinStats.dumpProtoLocked(this.mContext, fd, apps, flags8, historyStart4, this.mDumpHelper);     // Catch: Throwable -> L240 Throwable -> L242
        this.mStats.mCheckinFile.delete();     // Catch: Throwable -> L236 Throwable -> L238 Throwable -> L238
        monitor-exit(r11);     // Catch: Throwable -> L236
        return;
    L242:
        e = e;
        flags7 = flags8;
        historyStart3 = historyStart4;
    L245:
        Slog.w(TAG, "Failure reading checkin file " + this.mStats.mCheckinFile.getBaseFile(), e);     // Catch: Throwable -> L236
    L240:
        th = th;
    L238:
        e = e;
    L250:
        awaitCompletion();
        BatteryStatsImpl r12 = this.mStats;
        monitor-enter(r12);
    L257:
        th = th;
    L263:
        monitor-exit(r12);     // Catch: Throwable -> L257
        throw th;
    L300:
        this.mStats.dumpProtoLocked(this.mContext, fd, apps, flags7, historyStart3, this.mDumpHelper);     // Catch: Throwable -> L261
        if (writeData3 == false) goto L259;
        this.mStats.writeAsyncLocked();     // Catch: Throwable -> L257
    L259:
        monitor-exit(r12);     // Catch: Throwable -> L257
        return;
    L261:
        th = th;
        goto L263
    L265:
        if (useCheckinFormat3 == false) goto L291;
        List<ApplicationInfo> apps2 = this.mContext.getPackageManager().getInstalledApplications(4325376);
        if (reqUid3 == 0) goto L287;
        AtomicFile r14 = this.mStats.mCheckinFile;
        monitor-enter(r14);
    L277:
        th = move-exception;
        throw th;
    L271:
        if (this.mStats.mCheckinFile.exists() == true) goto L313;
    L283:
        monitor-exit(r14);     // Catch: Throwable -> L277
        goto L287
    L313:
        byte[] raw2 = this.mStats.mCheckinFile.readFully();     // Catch: Throwable -> L277 Throwable -> L279
        if (raw2 == null) goto L283;
        Parcel in2 = Parcel.obtain();     // Catch: Throwable -> L277 Throwable -> L279
        in2.unmarshall(raw2, 0, raw2.length);     // Catch: Throwable -> L277 Throwable -> L279
        in2.setDataPosition(0);     // Catch: Throwable -> L277 Throwable -> L279
        BatteryStatsImpl checkinStats2 = new BatteryStatsImpl(this.mBatteryStatsConfig, Clock.SYSTEM_CLOCK, this.mMonotonicClock, null, this.mStats.mHandler, null, null, this.mUserManagerUserInfoProvider, this.mPowerProfile, this.mCpuScalingPolicies, new PowerStatsUidResolver());     // Catch: Throwable -> L277 Throwable -> L279
        checkinStats2.readSummaryFromParcel(in2);     // Catch: Throwable -> L277 Throwable -> L279
        in2.recycle();     // Catch: Throwable -> L277 Throwable -> L279
        checkinStats2.dumpCheckin(this.mContext, pw, apps2, flags7, historyStart3, this.mDumpHelper);     // Catch: Throwable -> L277 Throwable -> L279
        this.mStats.mCheckinFile.delete();     // Catch: Throwable -> L277 Throwable -> L279
        monitor-exit(r14);     // Catch: Throwable -> L277
        return;
    L279:
        e = move-exception;
        Slog.w(TAG, "Failure reading checkin file " + this.mStats.mCheckinFile.getBaseFile(), e);     // Catch: Throwable -> L277
    L287:
        awaitCompletion();
        this.mStats.dumpCheckin(this.mContext, pw, apps2, flags7, historyStart3, this.mDumpHelper);
        if (writeData3 == false) goto L367;
        this.mStats.writeAsyncLocked();
    L367:
        return;
    L291:
        awaitCompletion();
        int flags9 = flags7;
        int flags10 = reqUid4;
        this.mStats.dump(this.mContext, pw, flags9, flags10, historyStart3, this.mDumpHelper);
        if (writeData3 == false) goto L294;
        this.mStats.writeAsyncLocked();
    L294:
        pw.println();
        this.mCpuWakeupStats.dump(new IndentingPrintWriter(pw, "  "), SystemClock.elapsedRealtime());
        return;
    L217:
        if ((flags6 & 10) != 0) goto L219;
        flags7 = (flags6 | 2) & (-17);
        goto L221
    L206:
        flags6 = 0;
        useCheckinFormat3 = false;
        toProto2 = false;
        noOutput = false;
        writeData3 = false;
        historyStart3 = -1;
        reqUid4 = -1;
        reqUid3 = 0;
        goto L207
    }

    public CellularBatteryStats getCellularBatteryStats() {
        super.getCellularBatteryStats_enforcePermission();
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        CellularBatteryStats r1 = this.mStats.getCellularBatteryStats();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public WifiBatteryStats getWifiBatteryStats() {
        super.getWifiBatteryStats_enforcePermission();
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        WifiBatteryStats r1 = this.mStats.getWifiBatteryStats();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public GpsBatteryStats getGpsBatteryStats() {
        super.getGpsBatteryStats_enforcePermission();
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        GpsBatteryStats r1 = this.mStats.getGpsBatteryStats();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public WakeLockStats getWakeLockStats() {
        super.getWakeLockStats_enforcePermission();
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        WakeLockStats r1 = this.mStats.getWakeLockStats();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public BluetoothBatteryStats getBluetoothBatteryStats() {
        super.getBluetoothBatteryStats_enforcePermission();
        awaitCompletion();
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        BluetoothBatteryStats r1 = this.mStats.getBluetoothBatteryStats();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public HealthStatsParceler takeUidSnapshot(int requestUid) {
        if (requestUid == Binder.getCallingUid()) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.BATTERY_STATS", null);
    L5:
        long ident = Binder.clearCallingIdentity();
        awaitCompletion();     // Catch: Throwable -> L9 Exception -> L11
        if (shouldCollectExternalStats() == false) goto L13;
        syncStats("get-health-stats-for-uids", 127);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        BatteryStatsImpl r2 = this.mStats;     // Catch: Throwable -> L9 Exception -> L11
        monitor-enter(r2);     // Catch: Throwable -> L9 Exception -> L11
        HealthStatsParceler r3 = getHealthStatsForUidLocked(requestUid);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);
        return r3;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L11:
        ex = move-exception;
        Slog.w(TAG, "Crashed while writing for takeUidSnapshot(" + requestUid + ")", ex);     // Catch: Throwable -> L9
        throw ex;     // Catch: Throwable -> L9
    }

    public HealthStatsParceler[] takeUidSnapshots(int[] requestUids) {
        if (onlyCaller(requestUids) == true) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.BATTERY_STATS", null);
    L5:
        long ident = Binder.clearCallingIdentity();
        awaitCompletion();     // Catch: Throwable -> L9 Exception -> L11
        if (shouldCollectExternalStats() == false) goto L13;
        syncStats("get-health-stats-for-uids", 127);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        BatteryStatsImpl r3 = this.mStats;     // Catch: Throwable -> L9 Exception -> L11
        monitor-enter(r3);     // Catch: Throwable -> L9 Exception -> L11
        int N = requestUids.length;     // Catch: Throwable -> L18
        HealthStatsParceler[] results = new HealthStatsParceler[N];     // Catch: Throwable -> L18
        int i = 0;
    L16:
        if (i >= N) goto L20;
        results[i] = getHealthStatsForUidLocked(requestUids[i]);     // Catch: Throwable -> L18
        i = i + 1;     // Catch: Throwable -> L18
        goto L16
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);
        return results;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9 Exception -> L11
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L11:
        ex = move-exception;
        throw ex;     // Catch: Throwable -> L9
    }

    public void takeUidSnapshotsAsync(final int[] requestUids, final ResultReceiver resultReceiver) {
        if (onlyCaller(requestUids) == true) goto L10;
        this.mContext.enforceCallingOrSelfPermission("android.permission.BATTERY_STATS", null);     // Catch: SecurityException -> L6
    L6:
        ex = move-exception;
        resultReceiver.send(2, Bundle.forPair("exception", ex.getMessage()));
        return;
    L10:
        if (shouldCollectExternalStats() == false) goto L12;
        this.mWorker.scheduleSync("get-health-stats-for-uids", 127);
    L12:
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda87(this, requestUids, resultReceiver));
    }

    private /* synthetic */ void lambda$takeUidSnapshotsAsync$99(int[] requestUids, ResultReceiver resultReceiver) {
        long ident = Binder.clearCallingIdentity();
        int count = requestUids.length;     // Catch: Throwable -> L19 Exception -> L21
        HealthStatsParceler[] results = new HealthStatsParceler[count];     // Catch: Throwable -> L19 Exception -> L21
        BatteryStatsImpl r6 = this.mStats;     // Catch: Throwable -> L19 Exception -> L21
        monitor-enter(r6);     // Catch: Throwable -> L19 Exception -> L21
        int i = 0;
    L32:
        if (i >= count) goto L10;
        results[i] = getHealthStatsForUidLocked(requestUids[i]);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13 Exception -> L15
    L10:
        monitor-exit(r6);     // Catch: Throwable -> L8
        Bundle resultData = new Bundle(1);     // Catch: Throwable -> L13 Exception -> L15
        resultData.putParcelableArray("uid_snapshots", results);     // Catch: Throwable -> L13 Exception -> L15
        resultReceiver.send(0, resultData);     // Catch: Throwable -> L13 Exception -> L15
    L12:
        Binder.restoreCallingIdentity(ident);
        return;
    L15:
        Exception ex = e;
    L24:
        resultReceiver.send(1, Bundle.forPair("exception", ex.getMessage()));     // Catch: Throwable -> L13
        goto L12
    L13:
        Throwable th = th;
    L27:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L21:
        e = move-exception;
        ex = e;
    L19:
        th = move-exception;
        th = th;
        goto L27
    }

    protected boolean shouldCollectExternalStats() {
        if ((SystemClock.elapsedRealtime() - this.mWorker.getLastCollectionTimeStamp()) <= this.mStats.getExternalStatsCollectionRateLimitMs()) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean onlyCaller(int[] requestUids) {
        int caller = Binder.getCallingUid();
        int N = requestUids.length;
        int i = 0;
    L3:
        if (i >= N) goto L9;
        if (requestUids[i] != caller) goto L6;
        i = i + 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    HealthStatsParceler getHealthStatsForUidLocked(int requestUid) {
        HealthStatsBatteryStatsWriter writer = new HealthStatsBatteryStatsWriter();
        HealthStatsWriter uidWriter = new HealthStatsWriter(UidHealthStats.CONSTANTS);
        BatteryStats.Uid uid = this.mStats.getUidStats().get(requestUid);
        if (uid == null) goto L6;
        writer.writeUid(uidWriter, this.mStats, uid);
    L6:
        return new HealthStatsParceler(uidWriter);
    }

    public boolean setChargingStateUpdateDelayMillis(int delayMillis) {
        super.setChargingStateUpdateDelayMillis_enforcePermission();
        long ident = Binder.clearCallingIdentity();
        ContentResolver contentResolver = this.mContext.getContentResolver();     // Catch: Throwable -> L6
        boolean r3 = Settings.Global.putLong(contentResolver, "battery_charging_state_update_delay", delayMillis);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void updateForegroundTimeIfOnBattery(final String packageName, final int uid, final long cpuTimeDiff) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda68(this, uid, packageName, elapsedRealtime, uptime, cpuTimeDiff));     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateForegroundTimeIfOnBattery$100(int uid, String packageName, long elapsedRealtime, long uptime, long cpuTimeDiff) {
        if (isOnBattery() == true) goto L5;
        return;
    L5:
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        BatteryStatsImpl.Uid.Proc ps = this.mStats.getProcessStatsLocked(uid, packageName, elapsedRealtime, uptime);     // Catch: Throwable -> L16
        if (ps == null) goto L14;
        ps.addForegroundTimeLocked(cpuTimeDiff);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L16:
        th = th;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L11
        throw th;
    L11:
        th = th;
        goto L18
    }

    void noteCurrentTimeChanged() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        final long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L7
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda10(this, currentTime, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteCurrentTimeChanged$101(long currentTime, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.noteCurrentTimeChangedLocked(currentTime, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void updateBatteryStatsOnActivityUsage(String packageName, String className, final int uid, int userId, final boolean resumed) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda18(this, resumed, uid, elapsedRealtime, uptime));     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        if (resumed == false) goto L8;
        int r0 = 1;
    L9:
        FrameworkStatsLog.write(42, uid, packageName, className, r0);
        return;
    L8:
        r0 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$updateBatteryStatsOnActivityUsage$102(boolean resumed, int uid, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        if (resumed == false) goto L24;
        this.mStats.noteActivityResumedLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L9
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r11 = th;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L24:
        this.mStats.noteActivityPausedLocked(uid, elapsedRealtime, uptime);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r11 = th;
    L9:
        th = move-exception;
        r11 = th;
        goto L20
    }

    void noteProcessDied(final int uid, final int pid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda78(this, uid, pid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteProcessDied$103(int uid, int pid) {
        BatteryStatsImpl r0 = this.mStats;
        monitor-enter(r0);
        this.mStats.noteProcessDiedLocked(uid, pid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void reportExcessiveCpu(final int uid, final String processName, final long uptimeSince, final long cputimeUsed) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda77(this, uid, processName, uptimeSince, cputimeUsed));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$reportExcessiveCpu$104(int uid, String processName, long uptimeSince, long cputimeUsed) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        this.mStats.reportExcessiveCpuLocked(uid, processName, uptimeSince, cputimeUsed);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        Throwable r10 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r10;
    L9:
        th = move-exception;
        r10 = th;
        goto L13
    }

    void noteServiceStartRunning(final int uid, final String pkg, final String name) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda106(this, uid, pkg, name, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteServiceStartRunning$105(int uid, String pkg, String name, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        BatteryStatsImpl.Uid.Pkg.Serv stats = this.mStats.getServiceStatsLocked(uid, pkg, name, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        stats.startRunningLocked(uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    void noteServiceStopRunning(final int uid, final String pkg, final String name) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda19(this, uid, pkg, name, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteServiceStopRunning$106(int uid, String pkg, String name, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        BatteryStatsImpl.Uid.Pkg.Serv stats = this.mStats.getServiceStatsLocked(uid, pkg, name, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        stats.stopRunningLocked(uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    void noteServiceStartLaunch(final int uid, final String pkg, final String name) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda108(this, uid, pkg, name, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteServiceStartLaunch$107(int uid, String pkg, String name, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        BatteryStatsImpl.Uid.Pkg.Serv stats = this.mStats.getServiceStatsLocked(uid, pkg, name, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        stats.startLaunchedLocked(uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    void noteServiceStopLaunch(final int uid, final String pkg, final String name) {
        Object r9 = this.mLock;
        monitor-enter(r9);
        final long elapsedRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        final long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
        this.mHandler.post(new BatteryStatsService$$ExternalSyntheticLambda5(this, uid, pkg, name, elapsedRealtime, uptime));     // Catch: Throwable -> L7
        monitor-exit(r9);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteServiceStopLaunch$108(int uid, String pkg, String name, long elapsedRealtime, long uptime) {
        BatteryStatsImpl r1 = this.mStats;
        monitor-enter(r1);
        BatteryStatsImpl.Uid.Pkg.Serv stats = this.mStats.getServiceStatsLocked(uid, pkg, name, elapsedRealtime, uptime);     // Catch: Throwable -> L9
        stats.stopLaunchedLocked(uptime);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw th;
    L11:
        th = th;
        goto L13
    }

    public void setLastBatteryUsageStatsBeforeResetAtomPullTimestamp(long timestamp) {
        AtomicFile r0 = this.mConfigFile;
        monitor-enter(r0);
        Properties props = new Properties();     // Catch: Throwable -> L10
        InputStream in = this.mConfigFile.openRead();     // Catch: Throwable -> L10 IOException -> L12
        props.load(in);     // Catch: Throwable -> L15
        if (in == null) goto L25;
        in.close();     // Catch: Throwable -> L10 IOException -> L12
    L25:
        props.put(BATTERY_USAGE_STATS_BEFORE_RESET_TIMESTAMP_PROPERTY, String.valueOf(timestamp));     // Catch: Throwable -> L10
        FileOutputStream out = null;
        out = this.mConfigFile.startWrite();     // Catch: Throwable -> L10 IOException -> L29
        props.store(out, "Statsd atom pull timestamps");     // Catch: Throwable -> L10 IOException -> L29
        this.mConfigFile.finishWrite(out);     // Catch: Throwable -> L10 IOException -> L29
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L29:
        e = move-exception;
        this.mConfigFile.failWrite(out);     // Catch: Throwable -> L10
        Slog.e(TAG, "Cannot save config file " + this.mConfigFile, e);     // Catch: Throwable -> L10
    L15:
        th = move-exception;
        if (in != null) goto L36;
    L22:
        throw th;     // Catch: Throwable -> L10 IOException -> L12
    L36:
        in.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 IOException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Cannot load config file " + this.mConfigFile, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public long getLastBatteryUsageStatsBeforeResetAtomPullTimestamp() {
        AtomicFile r0 = this.mConfigFile;
        monitor-enter(r0);
        Properties props = new Properties();     // Catch: Throwable -> L10
        InputStream in = this.mConfigFile.openRead();     // Catch: Throwable -> L10 IOException -> L12
        props.load(in);     // Catch: Throwable -> L15
        if (in == null) goto L25;
        in.close();     // Catch: Throwable -> L10 IOException -> L12
    L25:
        long r2 = Long.parseLong(props.getProperty(BATTERY_USAGE_STATS_BEFORE_RESET_TIMESTAMP_PROPERTY, "0"));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L15:
        th = move-exception;
        if (in != null) goto L31;
    L22:
        throw th;     // Catch: Throwable -> L10 IOException -> L12
    L31:
        in.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10 IOException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Cannot load config file " + this.mConfigFile, e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void setChargerAcOnline(boolean online, boolean forceUpdate) {
        super.setChargerAcOnline_enforcePermission();
        this.mBatteryManagerInternal.setChargerAcOnline(online, forceUpdate);
    }

    public void setBatteryLevel(int level, boolean forceUpdate) {
        super.setBatteryLevel_enforcePermission();
        this.mBatteryManagerInternal.setBatteryLevel(level, forceUpdate);
    }

    public void unplugBattery(boolean forceUpdate) {
        super.unplugBattery_enforcePermission();
        this.mBatteryManagerInternal.unplugBattery(forceUpdate);
    }

    public void resetBattery(boolean forceUpdate) {
        super.resetBattery_enforcePermission();
        this.mBatteryManagerInternal.resetBattery(forceUpdate);
    }

    public void suspendBatteryInput() {
        super.suspendBatteryInput_enforcePermission();
        this.mBatteryManagerInternal.suspendBatteryInput();
    }
}
