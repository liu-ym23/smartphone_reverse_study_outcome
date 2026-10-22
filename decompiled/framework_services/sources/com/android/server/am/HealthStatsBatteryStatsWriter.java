package com.android.server.am;

import android.os.BatteryStats;
import android.os.SystemClock;
import android.os.health.HealthStatsWriter;
import android.os.health.PackageHealthStats;
import android.os.health.PidHealthStats;
import android.os.health.ProcessHealthStats;
import android.os.health.ServiceHealthStats;
import android.os.health.TimerStat;
import android.util.SparseArray;
import com.android.internal.util.FrameworkStatsLog;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HealthStatsBatteryStatsWriter {
    private final long mNowRealtimeMs;
    private final long mNowUptimeMs;

    public HealthStatsBatteryStatsWriter() {
        this.mNowRealtimeMs = SystemClock.elapsedRealtime();
        this.mNowUptimeMs = SystemClock.uptimeMillis();
    }

    public void writeUid(HealthStatsWriter uidWriter, BatteryStats bs, BatteryStats.Uid uid) {
        long r6 = 1000;
        uidWriter.addMeasurement(10001, bs.computeBatteryRealtime(this.mNowRealtimeMs * 1000, 0) / 1000);
        uidWriter.addMeasurement(10002, bs.computeBatteryUptime(this.mNowUptimeMs * 1000, 0) / 1000);
        uidWriter.addMeasurement(10003, bs.computeBatteryScreenOffRealtime(this.mNowRealtimeMs * 1000, 0) / 1000);
        uidWriter.addMeasurement(10004, bs.computeBatteryScreenOffUptime(this.mNowUptimeMs * 1000, 0) / 1000);
        Iterator r4 = uid.getWakelockStats().entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, ? extends BatteryStats.Uid.Wakelock> entry = (Map.Entry) r4.next();
        String key = entry.getKey();
        BatteryStats.Uid.Wakelock wakelock = (BatteryStats.Uid.Wakelock) entry.getValue();
        BatteryStats.Timer timer = wakelock.getWakeTime(1);
        addTimers(uidWriter, 10005, key, timer);
        BatteryStats.Timer timer2 = wakelock.getWakeTime(0);
        addTimers(uidWriter, FrameworkStatsLog.BLUETOOTH_BYTES_TRANSFER, key, timer2);
        BatteryStats.Timer timer3 = wakelock.getWakeTime(2);
        addTimers(uidWriter, FrameworkStatsLog.BLUETOOTH_ACTIVITY_INFO, key, timer3);
        BatteryStats.Timer timer4 = wakelock.getWakeTime(18);
        addTimers(uidWriter, 10008, key, timer4);
        goto L4
    L6:
        Iterator r5 = uid.getSyncStats().entrySet().iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry<String, ? extends BatteryStats.Timer> entry2 = (Map.Entry) r5.next();
        addTimers(uidWriter, FrameworkStatsLog.CPU_TIME_PER_UID, entry2.getKey(), (BatteryStats.Timer) entry2.getValue());
        goto L8
    L10:
        Iterator r7 = uid.getJobStats().entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        Map.Entry<String, ? extends BatteryStats.Timer> entry3 = (Map.Entry) r7.next();
        addTimers(uidWriter, FrameworkStatsLog.CPU_TIME_PER_UID_FREQ, entry3.getKey(), (BatteryStats.Timer) entry3.getValue());
        goto L12
    L14:
        SparseArray<? extends BatteryStats.Uid.Sensor> sensors = uid.getSensorStats();
        int N = sensors.size();
        int i = 0;
    L15:
        if (i >= N) goto L21;
        int sensorId = sensors.keyAt(i);
        if (sensorId != (-10000)) goto L19;
        addTimer(uidWriter, FrameworkStatsLog.WIFI_ACTIVITY_INFO, ((BatteryStats.Uid.Sensor) sensors.valueAt(i)).getSensorTime());
    L20:
        i = i + 1;
        goto L15
    L19:
        addTimers(uidWriter, FrameworkStatsLog.MODEM_ACTIVITY_INFO, Integer.toString(sensorId), ((BatteryStats.Uid.Sensor) sensors.valueAt(i)).getSensorTime());
        goto L20
    L21:
        SparseArray<? extends BatteryStats.Uid.Pid> pids = uid.getPidStats();
        int N2 = pids.size();
        int i2 = 0;
    L22:
        if (i2 >= N2) goto L24;
        HealthStatsWriter writer = new HealthStatsWriter(PidHealthStats.CONSTANTS);
        writePid(writer, (BatteryStats.Uid.Pid) pids.valueAt(i2));
        uidWriter.addStats(FrameworkStatsLog.PROCESS_MEMORY_STATE, Integer.toString(pids.keyAt(i2)), writer);
        i2 = i2 + 1;
        goto L22
    L24:
        Iterator r12 = uid.getProcessStats().entrySet().iterator();
    L26:
        if (r12.hasNext() == false) goto L28;
        Map.Entry<String, ? extends BatteryStats.Uid.Proc> entry4 = (Map.Entry) r12.next();
        HealthStatsWriter writer2 = new HealthStatsWriter(ProcessHealthStats.CONSTANTS);
        writeProc(writer2, (BatteryStats.Uid.Proc) entry4.getValue());
        uidWriter.addStats(10014, entry4.getKey(), writer2);
        r6 = r6;
        goto L26
    L28:
        long r16 = r6;
        Iterator r8 = uid.getPackageStats().entrySet().iterator();
    L30:
        if (r8.hasNext() == false) goto L32;
        Map.Entry<String, ? extends BatteryStats.Uid.Pkg> entry5 = (Map.Entry) r8.next();
        HealthStatsWriter writer3 = new HealthStatsWriter(PackageHealthStats.CONSTANTS);
        writePkg(writer3, (BatteryStats.Uid.Pkg) entry5.getValue());
        uidWriter.addStats(FrameworkStatsLog.SYSTEM_UPTIME, entry5.getKey(), writer3);
        goto L30
    L32:
        BatteryStats.ControllerActivityCounter controller = uid.getWifiControllerActivity();
        if (controller == null) goto L38;
        uidWriter.addMeasurement(FrameworkStatsLog.CPU_ACTIVE_TIME, controller.getIdleTimeCounter().getCountLocked(0));
        uidWriter.addMeasurement(FrameworkStatsLog.CPU_CLUSTER_TIME, controller.getRxTimeCounter().getCountLocked(0));
        long sum = 0;
        BatteryStats.LongCounter[] r9 = controller.getTxTimeCounters();
        int r14 = r9.length;
        int r15 = 0;
    L35:
        if (r15 >= r14) goto L37;
        BatteryStats.LongCounter counter = r9[r15];
        sum = sum + counter.getCountLocked(0);
        r15 = r15 + 1;
        goto L35
    L37:
        uidWriter.addMeasurement(10018, sum);
        uidWriter.addMeasurement(FrameworkStatsLog.REMAINING_BATTERY_CAPACITY, controller.getPowerCounter().getCountLocked(0));
    L38:
        BatteryStats.ControllerActivityCounter controller2 = uid.getBluetoothControllerActivity();
        if (controller2 == null) goto L44;
        uidWriter.addMeasurement(FrameworkStatsLog.FULL_BATTERY_CAPACITY, controller2.getIdleTimeCounter().getCountLocked(0));
        uidWriter.addMeasurement(FrameworkStatsLog.TEMPERATURE, controller2.getRxTimeCounter().getCountLocked(0));
        long sum2 = 0;
        BatteryStats.LongCounter[] r10 = controller2.getTxTimeCounters();
        int r11 = r10.length;
        int r17 = 0;
    L41:
        if (r17 >= r11) goto L43;
        BatteryStats.LongCounter counter2 = r10[r17];
        sum2 = sum2 + counter2.getCountLocked(0);
        r17 = r17 + 1;
        goto L41
    L43:
        uidWriter.addMeasurement(FrameworkStatsLog.BINDER_CALLS, sum2);
        uidWriter.addMeasurement(FrameworkStatsLog.BINDER_CALLS_EXCEPTIONS, controller2.getPowerCounter().getCountLocked(0));
    L44:
        BatteryStats.ControllerActivityCounter controller3 = uid.getModemControllerActivity();
        if (controller3 == null) goto L50;
        uidWriter.addMeasurement(FrameworkStatsLog.LOOPER_STATS, controller3.getIdleTimeCounter().getCountLocked(0));
        uidWriter.addMeasurement(FrameworkStatsLog.DISK_STATS, controller3.getRxTimeCounter().getCountLocked(0));
        long sum3 = 0;
        BatteryStats.LongCounter[] r13 = controller3.getTxTimeCounters();
        int r18 = r13.length;
        int r19 = 0;
    L47:
        if (r19 >= r18) goto L49;
        BatteryStats.LongCounter counter3 = r13[r19];
        sum3 = sum3 + counter3.getCountLocked(0);
        r19 = r19 + 1;
        goto L47
    L49:
        uidWriter.addMeasurement(FrameworkStatsLog.DIRECTORY_USAGE, sum3);
        uidWriter.addMeasurement(FrameworkStatsLog.APP_SIZE, controller3.getPowerCounter().getCountLocked(0));
    L50:
        long sum4 = this.mNowRealtimeMs;
        uidWriter.addMeasurement(FrameworkStatsLog.CATEGORY_SIZE, uid.getWifiRunningTime(sum4 * r16, 0) / r16);
        uidWriter.addMeasurement(FrameworkStatsLog.PROC_STATS, uid.getFullWifiLockTime(this.mNowRealtimeMs * r16, 0) / r16);
        uidWriter.addTimer(FrameworkStatsLog.BATTERY_VOLTAGE, uid.getWifiScanCount(0), uid.getWifiScanTime(this.mNowRealtimeMs * r16, 0) / r16);
        uidWriter.addMeasurement(FrameworkStatsLog.NUM_FINGERPRINTS_ENROLLED, uid.getWifiMulticastTime(this.mNowRealtimeMs * r16, 0) / r16);
        addTimer(uidWriter, FrameworkStatsLog.DISK_IO, uid.getAudioTurnedOnTimer());
        addTimer(uidWriter, FrameworkStatsLog.POWER_PROFILE, uid.getVideoTurnedOnTimer());
        addTimer(uidWriter, FrameworkStatsLog.PROC_STATS_PKG_PROC, uid.getFlashlightTurnedOnTimer());
        addTimer(uidWriter, FrameworkStatsLog.PROCESS_CPU_TIME, uid.getCameraTurnedOnTimer());
        addTimer(uidWriter, 10036, uid.getForegroundActivityTimer());
        addTimer(uidWriter, FrameworkStatsLog.CPU_TIME_PER_THREAD_FREQ, uid.getBluetoothScanTimer());
        addTimer(uidWriter, FrameworkStatsLog.ON_DEVICE_POWER_MEASUREMENT, uid.getProcessStateTimer(0));
        addTimer(uidWriter, FrameworkStatsLog.DEVICE_CALCULATED_POWER_USE, uid.getProcessStateTimer(1));
        addTimer(uidWriter, 10040, uid.getProcessStateTimer(4));
        addTimer(uidWriter, 10041, uid.getProcessStateTimer(2));
        addTimer(uidWriter, FrameworkStatsLog.PROCESS_MEMORY_HIGH_WATER_MARK, uid.getProcessStateTimer(3));
        addTimer(uidWriter, FrameworkStatsLog.BATTERY_LEVEL, uid.getProcessStateTimer(6));
        addTimer(uidWriter, FrameworkStatsLog.BUILD_INFORMATION, uid.getVibratorOnTimer());
        uidWriter.addMeasurement(FrameworkStatsLog.BATTERY_CYCLE_COUNT, uid.getUserActivityCount(0, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.DEBUG_ELAPSED_CLOCK, uid.getUserActivityCount(1, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.DEBUG_FAILING_ELAPSED_CLOCK, uid.getUserActivityCount(2, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.NUM_FACES_ENROLLED, uid.getNetworkActivityBytes(0, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.ROLE_HOLDER, uid.getNetworkActivityBytes(1, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.DANGEROUS_PERMISSION_STATE, uid.getNetworkActivityBytes(2, 0));
        uidWriter.addMeasurement(10051, uid.getNetworkActivityBytes(3, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.TIME_ZONE_DATA_INFO, uid.getNetworkActivityBytes(4, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.EXTERNAL_STORAGE_INFO, uid.getNetworkActivityBytes(5, 0));
        uidWriter.addMeasurement(10054, uid.getNetworkActivityPackets(0, 0));
        uidWriter.addMeasurement(10055, uid.getNetworkActivityPackets(1, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.SYSTEM_ION_HEAP_SIZE, uid.getNetworkActivityPackets(2, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.APPS_ON_EXTERNAL_STORAGE_INFO, uid.getNetworkActivityPackets(3, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.FACE_SETTINGS, uid.getNetworkActivityPackets(4, 0));
        uidWriter.addMeasurement(FrameworkStatsLog.COOLING_DEVICE, uid.getNetworkActivityPackets(5, 0));
        uidWriter.addTimer(FrameworkStatsLog.PROCESS_SYSTEM_ION_HEAP_SIZE, uid.getMobileRadioActiveCount(0), uid.getMobileRadioActiveTime(0));
        uidWriter.addMeasurement(10062, uid.getUserCpuTimeUs(0) / r16);
        uidWriter.addMeasurement(10063, uid.getSystemCpuTimeUs(0) / r16);
        uidWriter.addMeasurement(FrameworkStatsLog.PROCESS_MEMORY_SNAPSHOT, 0);
    }

    public void writePid(HealthStatsWriter pidWriter, BatteryStats.Uid.Pid pid) {
        if (pid != null) goto L4;
        return;
    L4:
        pidWriter.addMeasurement(20001, pid.mWakeNesting);
        pidWriter.addMeasurement(20002, pid.mWakeSumMs);
        pidWriter.addMeasurement(20002, pid.mWakeStartMs);
    }

    public void writeProc(HealthStatsWriter procWriter, BatteryStats.Uid.Proc proc) {
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_FINISH_ACTIVITY, proc.getUserTime(0));
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_TASK_TO_FRONT, proc.getSystemTime(0));
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_NEW_INTENT, proc.getStarts(0));
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_CREATE_TASK, proc.getNumCrashes(0));
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_CREATE_ACTIVITY, proc.getNumAnrs(0));
        procWriter.addMeasurement(com.android.server.wm.EventLogTags.WM_RESTART_ACTIVITY, proc.getForegroundTime(0));
    }

    public void writePkg(HealthStatsWriter pkgWriter, BatteryStats.Uid.Pkg pkg) {
        Iterator r0 = pkg.getServiceStats().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, ? extends BatteryStats.Uid.Pkg.Serv> entry = (Map.Entry) r0.next();
        HealthStatsWriter writer = new HealthStatsWriter(ServiceHealthStats.CONSTANTS);
        writeServ(writer, (BatteryStats.Uid.Pkg.Serv) entry.getValue());
        pkgWriter.addStats(com.android.server.EventLogTags.STREAM_DEVICES_CHANGED, entry.getKey(), writer);
        goto L4
    L6:
        Iterator r1 = pkg.getWakeupAlarmStats().entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, ? extends BatteryStats.Counter> entry2 = (Map.Entry) r1.next();
        BatteryStats.Counter counter = (BatteryStats.Counter) entry2.getValue();
        if (counter == null) goto L8;
        pkgWriter.addMeasurements(40002, entry2.getKey(), counter.getCountLocked(0));
        goto L8
    }

    public void writeServ(HealthStatsWriter servWriter, BatteryStats.Uid.Pkg.Serv serv) {
        servWriter.addMeasurement(50001, serv.getStarts(0));
        servWriter.addMeasurement(50002, serv.getLaunches(0));
    }

    private void addTimer(HealthStatsWriter writer, int key, BatteryStats.Timer timer) {
        if (timer == null) goto L5;
        writer.addTimer(key, timer.getCountLocked(0), timer.getTotalTimeLocked(this.mNowRealtimeMs * 1000, 0) / 1000);
        return;
    }

    private void addTimers(HealthStatsWriter writer, int key, String name, BatteryStats.Timer timer) {
        if (timer == null) goto L5;
        writer.addTimers(key, name, new TimerStat(timer.getCountLocked(0), timer.getTotalTimeLocked(this.mNowRealtimeMs * 1000, 0) / 1000));
        return;
    }
}
