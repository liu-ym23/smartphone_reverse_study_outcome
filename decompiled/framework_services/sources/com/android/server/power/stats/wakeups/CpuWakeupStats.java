package com.android.server.power.stats.wakeups;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.IndentingPrintWriter;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IntPair;
import com.android.server.slice.SliceClientPermissions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.LongSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class CpuWakeupStats {
    private static final String SUBSYSTEM_ALARM_STRING = "Alarm";
    private static final String SUBSYSTEM_BLUETOOTH_STRING = "Bluetooth";
    private static final String SUBSYSTEM_CELLULAR_DATA_STRING = "Cellular_data";
    private static final String SUBSYSTEM_SENSOR_STRING = "Sensor";
    private static final String SUBSYSTEM_SOUND_TRIGGER_STRING = "Sound_trigger";
    private static final String SUBSYSTEM_WIFI_STRING = "Wifi";
    private static final String TAG = "CpuWakeupStats";
    private static final String TRACE_TRACK_WAKEUP_ATTRIBUTION = "wakeup_attribution";
    private static final long WAKEUP_WRITE_DELAY_MS = 0;
    final Config mConfig;
    private final Handler mHandler;
    private final IrqDeviceMap mIrqDeviceMap;
    private final WakingActivityHistory mRecentWakingActivity;
    private final SparseIntArray mReusableUidProcStates;
    final SparseIntArray mUidProcStates;
    final LongSparseArray<SparseArray<SparseIntArray>> mWakeupAttribution;
    final LongSparseArray<Wakeup> mWakeupEvents;

    static final class Config implements DeviceConfig.OnPropertiesChangedListener {
        private static final long DEFAULT_WAKEUP_MATCHING_WINDOW_MS = 0;
        static final long DEFAULT_WAKEUP_STATS_RETENTION_MS = 0;
        private static final long DEFAULT_WAKING_ACTIVITY_RETENTION_MS = 0;
        static final String KEY_WAKEUP_MATCHING_WINDOW_MS = "wakeup_matching_window_ms";
        static final String KEY_WAKEUP_STATS_RETENTION_MS = "wakeup_stats_retention_ms";
        static final String KEY_WAKING_ACTIVITY_RETENTION_MS = "waking_activity_retention_ms";
        private static final String[] PROPERTY_NAMES = null;
        public volatile long WAKEUP_MATCHING_WINDOW_MS;
        public volatile long WAKEUP_STATS_RETENTION_MS;
        public volatile long WAKING_ACTIVITY_RETENTION_MS;

        Config() {
            this.WAKEUP_STATS_RETENTION_MS = DEFAULT_WAKEUP_STATS_RETENTION_MS;
            this.WAKEUP_MATCHING_WINDOW_MS = DEFAULT_WAKEUP_MATCHING_WINDOW_MS;
            this.WAKING_ACTIVITY_RETENTION_MS = DEFAULT_WAKING_ACTIVITY_RETENTION_MS;
        }

        static {
            PROPERTY_NAMES = new String[]{KEY_WAKEUP_STATS_RETENTION_MS, KEY_WAKEUP_MATCHING_WINDOW_MS, KEY_WAKING_ACTIVITY_RETENTION_MS};
            DEFAULT_WAKEUP_STATS_RETENTION_MS = TimeUnit.DAYS.toMillis(3);
            DEFAULT_WAKEUP_MATCHING_WINDOW_MS = TimeUnit.SECONDS.toMillis(1);
            DEFAULT_WAKING_ACTIVITY_RETENTION_MS = TimeUnit.MINUTES.toMillis(5);
        }

        void register(Executor executor) {
            DeviceConfig.addOnPropertiesChangedListener("battery_stats", executor, this);
            onPropertiesChanged(DeviceConfig.getProperties("battery_stats", PROPERTY_NAMES));
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            Iterator r0 = properties.getKeyset().iterator();
        L4:
            if (r0.hasNext() == false) goto L27;
            String name = (String) r0.next();
            if (name == null) goto L4;
            switch(name.hashCode()) {
                case 241713043: goto L18;
                case 588912391: goto L15;
                case 1049257273: goto L12;
                default: goto L20;
            };
        L20:
            byte r2 = -1;
        L21:
            switch(r2) {
                case 0: goto L25;
                case 1: goto L24;
                case 2: goto L23;
                default: goto L4;
            };
        L23:
            this.WAKING_ACTIVITY_RETENTION_MS = properties.getLong(KEY_WAKING_ACTIVITY_RETENTION_MS, DEFAULT_WAKING_ACTIVITY_RETENTION_MS);
            goto L4
        L24:
            this.WAKEUP_MATCHING_WINDOW_MS = properties.getLong(KEY_WAKEUP_MATCHING_WINDOW_MS, DEFAULT_WAKEUP_MATCHING_WINDOW_MS);
            goto L4
        L25:
            this.WAKEUP_STATS_RETENTION_MS = properties.getLong(KEY_WAKEUP_STATS_RETENTION_MS, DEFAULT_WAKEUP_STATS_RETENTION_MS);
            goto L4
        L12:
            if (name.equals(KEY_WAKING_ACTIVITY_RETENTION_MS) == false) goto L20;
            r2 = 2;
            goto L21
        L15:
            if (name.equals(KEY_WAKEUP_STATS_RETENTION_MS) == false) goto L20;
            r2 = 0;
            goto L21
        L18:
            if (name.equals(KEY_WAKEUP_MATCHING_WINDOW_MS) == false) goto L20;
            r2 = 1;
            goto L21
        }

        void dump(IndentingPrintWriter pw) {
            pw.println("Config:");
            pw.increaseIndent();
            pw.print(KEY_WAKEUP_STATS_RETENTION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.WAKEUP_STATS_RETENTION_MS, pw);
            pw.println();
            pw.print(KEY_WAKEUP_MATCHING_WINDOW_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.WAKEUP_MATCHING_WINDOW_MS, pw);
            pw.println();
            pw.print(KEY_WAKING_ACTIVITY_RETENTION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.WAKING_ACTIVITY_RETENTION_MS, pw);
            pw.println();
            pw.decreaseIndent();
        }
    }

    static final class Wakeup {
        private static final String ABORT_REASON_PREFIX = "Abort";
        private static final String PARSER_TAG = "CpuWakeupStats.Wakeup";
        static final int TYPE_ABNORMAL = 2;
        static final int TYPE_IRQ = 1;
        private static final Pattern sIrqPattern = null;
        IrqDevice[] mDevices;
        long mElapsedMillis;
        SparseBooleanArray mResponsibleSubsystems;
        int mType;
        long mUptimeMillis;

        static final class IrqDevice {
            String mDevice;
            int mLine;

            IrqDevice(int line, String device) {
                this.mLine = line;
                this.mDevice = device;
            }

            public String toString() {
                return "IrqDevice{mLine=" + this.mLine + ", mDevice='" + this.mDevice + "'}";
            }
        }

        static {
            sIrqPattern = Pattern.compile("^(\\-?\\d+)\\s+(\\S+)");
        }

        private Wakeup(int type, IrqDevice[] devices, long elapsedMillis, long uptimeMillis, SparseBooleanArray responsibleSubsystems) {
            this.mType = type;
            this.mDevices = devices;
            this.mElapsedMillis = elapsedMillis;
            this.mUptimeMillis = uptimeMillis;
            this.mResponsibleSubsystems = responsibleSubsystems;
        }

        static Wakeup parseWakeup(String rawReason, long elapsedMillis, long uptimeMillis, IrqDeviceMap deviceMap) {
            String[] components = rawReason.split(":");
            if (ArrayUtils.isEmpty(components) == true) goto L42;
            if (components[0].startsWith(ABORT_REASON_PREFIX) == true) goto L52;
            int parsedDeviceCount = 0;
            IrqDevice[] parsedDevices = new IrqDevice[components.length];
            SparseBooleanArray responsibleSubsystems = new SparseBooleanArray();
            int r7 = components.length;
            int type = 1;
            int r8 = 0;
        L8:
            int type2 = -1;
            if (r8 >= r7) goto L32;
            String component = components[r8];
            Matcher matcher = sIrqPattern.matcher(component.trim());
            if (matcher.find() == false) goto L30;
            int line = Integer.parseInt(matcher.group(1));     // Catch: NumberFormatException -> L27
            String device = matcher.group(2);     // Catch: NumberFormatException -> L27
            if (line >= 0) goto L15;
            type = 2;
        L15:
            int parsedDeviceCount2 = parsedDeviceCount + 1;
            parsedDevices[parsedDeviceCount] = new IrqDevice(line, device);
            List<String> rawSubsystems = deviceMap.getSubsystemsForDevice(device);
            boolean anyKnownSubsystem = false;
            if (rawSubsystems == null) goto L24;
            int i = 0;
        L19:
            if (i >= rawSubsystems.size()) goto L24;
            int subsystem = CpuWakeupStats.stringToKnownSubsystem(rawSubsystems.get(i));
            if (subsystem == type2) goto L23;
            responsibleSubsystems.put(subsystem, true);
            anyKnownSubsystem = true;
        L23:
            i = i + 1;
            type2 = -1;
        L24:
            if (anyKnownSubsystem == true) goto L26;
            responsibleSubsystems.put(-1, true);
        L26:
            parsedDeviceCount = parsedDeviceCount2;
        L27:
            e = move-exception;
            Slog.e(PARSER_TAG, "Exception while parsing device names from part: " + component, e);
        L30:
            r8 = r8 + 1;
            goto L8
        L32:
            if (parsedDeviceCount != 0) goto L35;
            return null;
        L35:
            if (responsibleSubsystems.size() != 1) goto L40;
            if (responsibleSubsystems.get(-1, false) == false) goto L40;
            return null;
        L40:
            return new Wakeup(type, (IrqDevice[]) Arrays.copyOf(parsedDevices, parsedDeviceCount), elapsedMillis, uptimeMillis, responsibleSubsystems);
        L52:
            return null;
        L42:
            return null;
        }

        public String toString() {
            return "Wakeup{mType=" + this.mType + ", mElapsedMillis=" + this.mElapsedMillis + ", mUptimeMillis=" + this.mUptimeMillis + ", mDevices=" + Arrays.toString(this.mDevices) + ", mResponsibleSubsystems=" + this.mResponsibleSubsystems + '}';
        }
    }

    static final class WakingActivityHistory {
        private LongSupplier mRetentionSupplier;
        final SparseArray<LongSparseArray<SparseIntArray>> mWakingActivity;

        WakingActivityHistory(LongSupplier retentionSupplier) {
            this.mWakingActivity = new SparseArray();
            this.mRetentionSupplier = retentionSupplier;
        }

        void recordActivity(int subsystem, long elapsedRealtime, SparseIntArray uidProcStates) {
            if (uidProcStates != null) goto L4;
            return;
        L4:
            LongSparseArray<SparseIntArray> wakingActivity = this.mWakingActivity.get(subsystem);
            if (wakingActivity != null) goto L7;
            wakingActivity = new LongSparseArray();
            this.mWakingActivity.put(subsystem, wakingActivity);
        L7:
            SparseIntArray uidsToBlame = wakingActivity.get(elapsedRealtime);
            if (uidsToBlame != null) goto L10;
            wakingActivity.put(elapsedRealtime, uidProcStates.clone());
        L17:
            int endIdx = wakingActivity.lastIndexOnOrBefore(elapsedRealtime - this.mRetentionSupplier.getAsLong());
            int i = endIdx;
        L18:
            if (i < 0) goto L21;
            wakingActivity.removeAt(i);
            i = i - 1;
            goto L18
        L21:
            return;
        L10:
            int i2 = 0;
        L12:
            if (i2 >= uidProcStates.size()) goto L17;
            int uid = uidProcStates.keyAt(i2);
            if (uidsToBlame.indexOfKey(uid) >= 0) goto L16;
            uidsToBlame.put(uid, uidProcStates.valueAt(i2));
        L16:
            i2 = i2 + 1;
            goto L12
        }

        SparseIntArray removeBetween(int subsystem, long startElapsed, long endElapsed) {
            SparseIntArray uidsToReturn = new SparseIntArray();
            LongSparseArray<SparseIntArray> activityForSubsystem = this.mWakingActivity.get(subsystem);
            if (activityForSubsystem == null) goto L15;
            int startIdx = activityForSubsystem.firstIndexOnOrAfter(startElapsed);
            int endIdx = activityForSubsystem.lastIndexOnOrBefore(endElapsed);
            int i = endIdx;
        L5:
            if (i < startIdx) goto L11;
            SparseIntArray uidsForTime = activityForSubsystem.valueAt(i);
            int j = 0;
        L8:
            if (j >= uidsForTime.size()) goto L10;
            uidsToReturn.put(uidsForTime.keyAt(j), uidsForTime.valueAt(j));
            j = j + 1;
            goto L8
        L10:
            i = i - 1;
            goto L5
        L11:
            int i2 = endIdx;
        L12:
            if (i2 < startIdx) goto L15;
            activityForSubsystem.removeAt(i2);
            i2 = i2 - 1;
        L15:
            if (uidsToReturn.size() > 0) goto L22;
            return null;
        L22:
            return uidsToReturn;
        }

        void dump(IndentingPrintWriter pw, long nowElapsed) {
            pw.println("Recent waking activity:");
            pw.increaseIndent();
            int i = 0;
        L4:
            if (i >= this.mWakingActivity.size()) goto L21;
            pw.println("Subsystem " + CpuWakeupStats.subsystemToString(this.mWakingActivity.keyAt(i)) + ":");
            LongSparseArray<SparseIntArray> wakingActivity = this.mWakingActivity.valueAt(i);
            if (wakingActivity == null) goto L20;
            pw.increaseIndent();
            int j = wakingActivity.size() - 1;
        L9:
            if (j < 0) goto L19;
            TimeUtils.formatDuration(wakingActivity.keyAt(j), nowElapsed, pw);
            SparseIntArray uidsToBlame = wakingActivity.valueAt(j);
            if (uidsToBlame != null) goto L13;
            pw.println();
        L18:
            j = j - 1;
            goto L9
        L13:
            pw.print(": ");
            int k = 0;
        L15:
            if (k >= uidsToBlame.size()) goto L17;
            UserHandle.formatUid(pw, uidsToBlame.keyAt(k));
            pw.print(" [" + ActivityManager.procStateToString(uidsToBlame.valueAt(k)));
            pw.print("], ");
            k = k + 1;
            goto L15
        L17:
            pw.println();
            goto L18
        L19:
            pw.decreaseIndent();
        L20:
            i = i + 1;
            goto L4
        L21:
            pw.decreaseIndent();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$d7dhXD3GZkZXJedQxynsy4Ps-WI, reason: not valid java name */
    public static /* synthetic */ void m7867$r8$lambda$d7dhXD3GZkZXJedQxynsy4PsWI(CpuWakeupStats r0, Wakeup r1) {
        r0.lambda$noteWakeupTimeAndReason$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$l-D7NPzbgSwY5OseXB1GuV8c9rM, reason: not valid java name */
    public static /* synthetic */ long m7868$r8$lambda$lD7NPzbgSwY5OseXB1GuV8c9rM(CpuWakeupStats r2) {
        return r2.lambda$new$0();
    }

    static {
        WAKEUP_WRITE_DELAY_MS = TimeUnit.SECONDS.toMillis(30);
    }

    public CpuWakeupStats(Context context, int mapRes, Handler handler) {
        this.mConfig = new Config();
        this.mWakeupEvents = new LongSparseArray();
        this.mWakeupAttribution = new LongSparseArray();
        this.mUidProcStates = new SparseIntArray();
        this.mReusableUidProcStates = new SparseIntArray(4);
        this.mIrqDeviceMap = IrqDeviceMap.getInstance(context, mapRes);
        this.mRecentWakingActivity = new WakingActivityHistory(new CpuWakeupStats$$ExternalSyntheticLambda1(this));
        this.mHandler = handler;
    }

    private /* synthetic */ long lambda$new$0() {
        return this.mConfig.WAKING_ACTIVITY_RETENTION_MS;
    }

    public synchronized void systemServicesReady() {
        monitor-enter(this);
        this.mConfig.register(new HandlerExecutor(this.mHandler));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static int typeToStatsType(int wakeupType) {
        switch(wakeupType) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 1;
    }

    private static int subsystemToStatsReason(int subsystem) {
        switch(subsystem) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 1;
    }

    private synchronized void logWakeupAttribution(Wakeup wakeupToLog) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (ArrayUtils.isEmpty(wakeupToLog.mDevices) == false) goto L11;
        FrameworkStatsLog.write(FrameworkStatsLog.KERNEL_WAKEUP_ATTRIBUTED, 0, 0, null, wakeupToLog.mElapsedMillis, null);     // Catch: Throwable -> L9
        Trace.instantForTrack(131072, TRACE_TRACK_WAKEUP_ATTRIBUTION, wakeupToLog.mElapsedMillis + " --");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        SparseArray<SparseIntArray> wakeupAttribution = this.mWakeupAttribution.get(wakeupToLog.mElapsedMillis);     // Catch: Throwable -> L9
        if (wakeupAttribution != null) goto L16;
        Slog.wtf(TAG, "Unexpected null attribution found for " + wakeupToLog);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L16:
        StringBuilder traceEventBuilder = new StringBuilder();     // Catch: Throwable -> L9
        int i = 0;
    L18:
        if (i >= wakeupAttribution.size()) goto L35;
        int subsystem = wakeupAttribution.keyAt(i);     // Catch: Throwable -> L9
        SparseIntArray uidProcStates = wakeupAttribution.valueAt(i);     // Catch: Throwable -> L9
        if (uidProcStates == null) goto L28;
        if (uidProcStates.size() == 0) goto L28;
        int numUids = uidProcStates.size();     // Catch: Throwable -> L9
        int[] uids = new int[numUids];     // Catch: Throwable -> L9
        int[] procStatesProto = new int[numUids];     // Catch: Throwable -> L9
        int j = 0;
    L25:
        if (j >= numUids) goto L27;
        uids[j] = uidProcStates.keyAt(j);     // Catch: Throwable -> L9
        procStatesProto[j] = ActivityManager.processStateAmToProto(uidProcStates.valueAt(j));     // Catch: Throwable -> L9
        j = j + 1;     // Catch: Throwable -> L9
        goto L25
    L27:
        int[] uids2 = uids;
        int[] procStatesProto2 = procStatesProto;
    L29:
        FrameworkStatsLog.write(FrameworkStatsLog.KERNEL_WAKEUP_ATTRIBUTED, typeToStatsType(wakeupToLog.mType), subsystemToStatsReason(subsystem), uids2, wakeupToLog.mElapsedMillis, procStatesProto2);     // Catch: Throwable -> L9
        if (Trace.isTagEnabled(131072) == false) goto L34;
        if (i != 0) goto L33;
        traceEventBuilder.append(wakeupToLog.mElapsedMillis + " ");     // Catch: Throwable -> L9
    L33:
        traceEventBuilder.append(subsystemToString(subsystem));     // Catch: Throwable -> L9
        traceEventBuilder.append(":");     // Catch: Throwable -> L9
        traceEventBuilder.append(Arrays.toString(uids2));     // Catch: Throwable -> L9
        traceEventBuilder.append(" ");     // Catch: Throwable -> L9
    L34:
        i = i + 1;     // Catch: Throwable -> L9
    L28:
        int[] procStatesProto3 = new int[0];     // Catch: Throwable -> L9
        uids2 = procStatesProto3;
        procStatesProto2 = procStatesProto3;
        goto L29
    L35:
        Trace.instantForTrack(131072, TRACE_TRACK_WAKEUP_ATTRIBUTION, traceEventBuilder.toString().trim());     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    public synchronized void onUidRemoved(int uid) {
        monitor-enter(this);
        this.mUidProcStates.delete(uid);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void noteUidProcessState(int uid, int state) {
        monitor-enter(this);
        this.mUidProcStates.put(uid, state);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void noteWakeupTimeAndReason(long elapsedRealtime, long uptime, String rawReason) {
        monitor-enter(this);
        final Wakeup parsedWakeup = Wakeup.parseWakeup(rawReason, elapsedRealtime, uptime, this.mIrqDeviceMap);     // Catch: Throwable -> L10
        if (parsedWakeup != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mWakeupEvents.put(elapsedRealtime, parsedWakeup);     // Catch: Throwable -> L10
        attemptAttributionFor(parsedWakeup);     // Catch: Throwable -> L10
        long retentionDuration = this.mConfig.WAKEUP_STATS_RETENTION_MS;     // Catch: Throwable -> L10
        int lastIdx = this.mWakeupEvents.lastIndexOnOrBefore(elapsedRealtime - retentionDuration);     // Catch: Throwable -> L10
        int i = lastIdx;
    L8:
        if (i < 0) goto L12;
        this.mWakeupEvents.removeAt(i);     // Catch: Throwable -> L10
        i = i - 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        int lastIdx2 = this.mWakeupAttribution.lastIndexOnOrBefore(elapsedRealtime - retentionDuration);     // Catch: Throwable -> L10
        int i2 = lastIdx2;
    L13:
        if (i2 < 0) goto L15;
        this.mWakeupAttribution.removeAt(i2);     // Catch: Throwable -> L10
        i2 = i2 - 1;     // Catch: Throwable -> L10
        goto L13
    L15:
        this.mHandler.postDelayed(new CpuWakeupStats$$ExternalSyntheticLambda0(this, parsedWakeup), WAKEUP_WRITE_DELAY_MS);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$noteWakeupTimeAndReason$1(Wakeup parsedWakeup) {
        logWakeupAttribution(parsedWakeup);
    }

    public synchronized void noteWakingActivity(int subsystem, long elapsedRealtime, int... uids) {
        monitor-enter(this);
        if (uids != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        this.mReusableUidProcStates.clear();     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= uids.length) goto L13;
        this.mReusableUidProcStates.put(uids[i], this.mUidProcStates.get(uids[i], -1));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L13:
        if (attemptAttributionWith(subsystem, elapsedRealtime, this.mReusableUidProcStates) == true) goto L15;
        this.mRecentWakingActivity.recordActivity(subsystem, elapsedRealtime, this.mReusableUidProcStates);     // Catch: Throwable -> L10
    L15:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void attemptAttributionFor(Wakeup wakeup) {
        monitor-enter(this);
        SparseBooleanArray subsystems = wakeup.mResponsibleSubsystems;     // Catch: Throwable -> L6
        SparseArray<SparseIntArray> attribution = this.mWakeupAttribution.get(wakeup.mElapsedMillis);     // Catch: Throwable -> L6
        if (attribution != null) goto L8;
        attribution = new SparseArray();     // Catch: Throwable -> L6
        this.mWakeupAttribution.put(wakeup.mElapsedMillis, attribution);     // Catch: Throwable -> L6
    L8:
        long matchingWindowMillis = this.mConfig.WAKEUP_MATCHING_WINDOW_MS;     // Catch: Throwable -> L6
        int subsystemIdx = 0;
    L9:
        if (subsystemIdx >= subsystems.size()) goto L14;
        int subsystem = subsystems.keyAt(subsystemIdx);     // Catch: Throwable -> L6
        long startTime = wakeup.mElapsedMillis - matchingWindowMillis;     // Catch: Throwable -> L6
        long endTime = wakeup.mElapsedMillis + matchingWindowMillis;     // Catch: Throwable -> L6
        SparseIntArray uidsToBlame = this.mRecentWakingActivity.removeBetween(subsystem, startTime, endTime);     // Catch: Throwable -> L6
        attribution.put(subsystem, uidsToBlame);     // Catch: Throwable -> L6
        subsystemIdx = subsystemIdx + 1;
        goto L9
    L14:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized boolean attemptAttributionWith(int subsystem, long activityElapsed, SparseIntArray uidProcStates) {
        monitor-enter(this);
        long matchingWindowMillis = this.mConfig.WAKEUP_MATCHING_WINDOW_MS;     // Catch: Throwable -> L11
        int startIdx = this.mWakeupEvents.firstIndexOnOrAfter(activityElapsed - matchingWindowMillis);     // Catch: Throwable -> L11
        int endIdx = this.mWakeupEvents.lastIndexOnOrBefore(activityElapsed + matchingWindowMillis);     // Catch: Throwable -> L11
        int wakeupIdx = startIdx;
    L5:
        if (wakeupIdx > endIdx) goto L26;
        Wakeup wakeup = this.mWakeupEvents.valueAt(wakeupIdx);     // Catch: Throwable -> L11
        SparseBooleanArray subsystems = wakeup.mResponsibleSubsystems;     // Catch: Throwable -> L11
        if (subsystems.get(subsystem) == true) goto L8;
        wakeupIdx = wakeupIdx + 1;
        goto L5
    L8:
        SparseArray<SparseIntArray> attribution = this.mWakeupAttribution.get(wakeup.mElapsedMillis);     // Catch: Throwable -> L11
        if (attribution != null) goto L13;
        attribution = new SparseArray();     // Catch: Throwable -> L11
        this.mWakeupAttribution.put(wakeup.mElapsedMillis, attribution);     // Catch: Throwable -> L11
    L13:
        SparseIntArray uidsToBlame = attribution.get(subsystem);     // Catch: Throwable -> L11
        if (uidsToBlame != null) goto L16;
        attribution.put(subsystem, uidProcStates.clone());     // Catch: Throwable -> L11
    L21:
        monitor-exit(this);
        return true;
    L16:
        int i = 0;
    L18:
        if (i >= uidProcStates.size()) goto L21;
        uidsToBlame.put(uidProcStates.keyAt(i), uidProcStates.valueAt(i));     // Catch: Throwable -> L11
        i = i + 1;
        goto L18
    L26:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void dump(IndentingPrintWriter pw, long nowElapsed) {
        long r2 = nowElapsed;
        monitor-enter(this);
        pw.println("CPU wakeup stats:");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        this.mConfig.dump(pw);     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        this.mIrqDeviceMap.dump(pw);     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        this.mRecentWakingActivity.dump(pw, r2);     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        pw.println("Current proc-state map (" + this.mUidProcStates.size() + "):");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        int i = 0;
    L6:
        if (i >= this.mUidProcStates.size()) goto L12;
        if (i <= 0) goto L11;
        pw.print(", ");     // Catch: Throwable -> L9
    L11:
        UserHandle.formatUid(pw, this.mUidProcStates.keyAt(i));     // Catch: Throwable -> L9
        pw.print(":" + ActivityManager.procStateToString(this.mUidProcStates.valueAt(i)));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L6
    L12:
        pw.println();     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        SparseLongArray attributionStats = new SparseLongArray();     // Catch: Throwable -> L9
        pw.println("Wakeup events:");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        int i2 = this.mWakeupEvents.size() - 1;     // Catch: Throwable -> L9
    L13:
        if (i2 < 0) goto L34;
        TimeUtils.formatDuration(this.mWakeupEvents.keyAt(i2), r2, pw);     // Catch: Throwable -> L9
        pw.println(":");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        Wakeup wakeup = this.mWakeupEvents.valueAt(i2);     // Catch: Throwable -> L9
        pw.println(wakeup);     // Catch: Throwable -> L9
        pw.print("Attribution: ");     // Catch: Throwable -> L9
        SparseArray<SparseIntArray> attribution = this.mWakeupAttribution.get(wakeup.mElapsedMillis);     // Catch: Throwable -> L9
        if (attribution != null) goto L17;
        pw.println("N/A");     // Catch: Throwable -> L9
    L33:
        pw.decreaseIndent();     // Catch: Throwable -> L9
        i2 = i2 - 1;     // Catch: Throwable -> L9
        r2 = nowElapsed;
        goto L13
    L17:
        int subsystemIdx = 0;
    L19:
        if (subsystemIdx >= attribution.size()) goto L32;
        if (subsystemIdx <= 0) goto L22;
        pw.print(", ");     // Catch: Throwable -> L9
    L22:
        long counters = attributionStats.get(attribution.keyAt(subsystemIdx), IntPair.of(0, 0));     // Catch: Throwable -> L9
        int attributed = IntPair.first(counters);     // Catch: Throwable -> L9
        int total = IntPair.second(counters) + 1;     // Catch: Throwable -> L9
        pw.print(subsystemToString(attribution.keyAt(subsystemIdx)));     // Catch: Throwable -> L9
        pw.print(" [");     // Catch: Throwable -> L9
        SparseIntArray uidProcStates = attribution.valueAt(subsystemIdx);     // Catch: Throwable -> L9
        if (uidProcStates == null) goto L31;
        int uidIdx = 0;
    L26:
        if (uidIdx >= uidProcStates.size()) goto L30;
        if (uidIdx <= 0) goto L29;
        pw.print(", ");     // Catch: Throwable -> L9
    L29:
        UserHandle.formatUid(pw, uidProcStates.keyAt(uidIdx));     // Catch: Throwable -> L9
        pw.print(" " + ActivityManager.procStateToString(uidProcStates.valueAt(uidIdx)));     // Catch: Throwable -> L9
        uidIdx = uidIdx + 1;     // Catch: Throwable -> L9
        goto L26
    L30:
        attributed = attributed + 1;     // Catch: Throwable -> L9
    L31:
        pw.print("]");     // Catch: Throwable -> L9
        attributionStats.put(attribution.keyAt(subsystemIdx), IntPair.of(attributed, total));     // Catch: Throwable -> L9
        subsystemIdx = subsystemIdx + 1;     // Catch: Throwable -> L9
        goto L19
    L32:
        pw.println();     // Catch: Throwable -> L9
        goto L33
    L34:
        pw.decreaseIndent();     // Catch: Throwable -> L9
        pw.println("Attribution stats:");     // Catch: Throwable -> L9
        pw.increaseIndent();     // Catch: Throwable -> L9
        int i3 = 0;
    L36:
        if (i3 >= attributionStats.size()) goto L38;
        pw.print("Subsystem " + subsystemToString(attributionStats.keyAt(i3)));     // Catch: Throwable -> L9
        pw.print(": ");     // Catch: Throwable -> L9
        long ratio = attributionStats.valueAt(i3);     // Catch: Throwable -> L9
        pw.println(IntPair.first(ratio) + SliceClientPermissions.SliceAuthority.DELIMITER + IntPair.second(ratio));     // Catch: Throwable -> L9
        i3 = i3 + 1;     // Catch: Throwable -> L9
        goto L36
    L38:
        pw.println("Total: " + this.mWakeupEvents.size());     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
        pw.decreaseIndent();     // Catch: Throwable -> L9
        pw.println();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static int stringToKnownSubsystem(String rawSubsystem) {
        switch(rawSubsystem.hashCode()) {
            case -1822081062: goto L21;
            case -1102294721: goto L18;
            case -424380824: goto L15;
            case -322116978: goto L12;
            case 2695989: goto L9;
            case 63343153: goto L6;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L26;
            default: goto L25;
        };
    L25:
        return -1;
    L26:
        return 6;
    L28:
        return 5;
    L29:
        return 4;
    L30:
        return 3;
    L31:
        return 2;
    L32:
        return 1;
    L6:
        if (rawSubsystem.equals("Alarm") == false) goto L33;
        r0 = 0;
        goto L24
    L33:
        r0 = -1;
        goto L24
    L9:
        if (rawSubsystem.equals("Wifi") == false) goto L34;
        r0 = 1;
        goto L24
    L34:
        r0 = -1;
        goto L24
    L12:
        if (rawSubsystem.equals("Bluetooth") == false) goto L35;
        r0 = 5;
        goto L24
    L35:
        r0 = -1;
        goto L24
    L15:
        if (rawSubsystem.equals(SUBSYSTEM_SOUND_TRIGGER_STRING) == false) goto L36;
        r0 = 2;
        goto L24
    L36:
        r0 = -1;
        goto L24
    L18:
        if (rawSubsystem.equals(SUBSYSTEM_CELLULAR_DATA_STRING) == false) goto L37;
        r0 = 4;
        goto L24
    L37:
        r0 = -1;
        goto L24
    L21:
        if (rawSubsystem.equals(SUBSYSTEM_SENSOR_STRING) == false) goto L38;
        r0 = 3;
        goto L24
    L38:
        r0 = -1;
        goto L24
    }

    static String subsystemToString(int subsystem) {
        switch(subsystem) {
            case -1: goto L17;
            case 0: goto L3;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "N/A";
    L5:
        return "Bluetooth";
    L7:
        return SUBSYSTEM_CELLULAR_DATA_STRING;
    L9:
        return SUBSYSTEM_SENSOR_STRING;
    L11:
        return SUBSYSTEM_SOUND_TRIGGER_STRING;
    L13:
        return "Wifi";
    L15:
        return "Alarm";
    L17:
        return "Unknown";
    }
}
