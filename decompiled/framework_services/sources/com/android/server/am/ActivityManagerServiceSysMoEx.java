package com.android.server.am;

import android.app.IActivityManagerSysMoEx;
import android.app.ISysClient;
import android.os.Binder;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Slog;
import com.android.server.IActivityManagerOptEx;
import com.android.server.ServiceThread;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.wm.ActivityRecord;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerServiceSysMoEx extends IActivityManagerSysMoEx.Stub {
    private static final String TAG = "ActivityManagerService";
    public static volatile boolean mCleanupCancelled = false;
    protected static IActivityManagerOptEx mSmtOptEx = null;
    static final int sSystemMask = 129;
    private ActivityManagerService mActivityManagerService;
    final List<ActivityRecord> mPendingLaunchRecords;

    public interface CpuStateObserver {

        public static final enum CPU_USAGE_STATE extends Enum<CPU_USAGE_STATE> {
            private static final /* synthetic */ CPU_USAGE_STATE[] $VALUES = null;
            public static final CPU_USAGE_STATE CPU_BUSY = null;
            public static final CPU_USAGE_STATE CPU_NORMAL = null;

            private static /* synthetic */ CPU_USAGE_STATE[] $values() {
                return new CPU_USAGE_STATE[]{CPU_NORMAL, CPU_BUSY};
            }

            private CPU_USAGE_STATE(String r1, int r2) {
                super(r1, r2);
            }

            public static CPU_USAGE_STATE valueOf(String name) {
                return (CPU_USAGE_STATE) Enum.valueOf(CPU_USAGE_STATE.class, name);
            }

            public static CPU_USAGE_STATE[] values() {
                return (CPU_USAGE_STATE[]) $VALUES.clone();
            }

            static {
                CPU_NORMAL = new CPU_USAGE_STATE("CPU_NORMAL", 0);
                CPU_BUSY = new CPU_USAGE_STATE("CPU_BUSY", 1);
                $VALUES = $values();
            }
        }

        public static final enum NOTIFY_FREQUENCY extends Enum<NOTIFY_FREQUENCY> {
            private static final /* synthetic */ NOTIFY_FREQUENCY[] $VALUES = null;
            public static final NOTIFY_FREQUENCY EVERY_TIME = null;
            public static final NOTIFY_FREQUENCY ONLY_CHANGE = null;

            private static /* synthetic */ NOTIFY_FREQUENCY[] $values() {
                return new NOTIFY_FREQUENCY[]{EVERY_TIME, ONLY_CHANGE};
            }

            private NOTIFY_FREQUENCY(String r1, int r2) {
                super(r1, r2);
            }

            public static NOTIFY_FREQUENCY valueOf(String name) {
                return (NOTIFY_FREQUENCY) Enum.valueOf(NOTIFY_FREQUENCY.class, name);
            }

            public static NOTIFY_FREQUENCY[] values() {
                return (NOTIFY_FREQUENCY[]) $VALUES.clone();
            }

            static {
                EVERY_TIME = new NOTIFY_FREQUENCY("EVERY_TIME", 0);
                ONLY_CHANGE = new NOTIFY_FREQUENCY("ONLY_CHANGE", 1);
                $VALUES = $values();
            }
        }

        NOTIFY_FREQUENCY getNotifyRequest();

        void onCpuState(CPU_USAGE_STATE r1, long r2);
    }

    public interface CpuStateProvider {
        default void registerCpuStateObserver(CpuStateObserver observer) {
        }

        default void unregisterCpuStateObserver(CpuStateObserver observer) {
        }
    }

    static {
        mCleanupCancelled = false;
    }

    protected ActivityManagerServiceSysMoEx(ActivityManagerService activityManagerService) {
        this.mPendingLaunchRecords = new LinkedList();
        this.mActivityManagerService = activityManagerService;
        mSmtOptEx = SysMonitorSvcBridge.getFactory().getActivityManager(activityManagerService);
    }

    protected ActivityManagerServiceSysMoEx(ActivityManagerService activityManagerService, ActivityManagerService.Injector injector, ServiceThread handlerThread) {
        this.mPendingLaunchRecords = new LinkedList();
        this.mActivityManagerService = activityManagerService;
        mSmtOptEx = SysMonitorSvcBridge.getFactory().getActivityManager(activityManagerService);
    }

    public void registerSysClient(ISysClient client) {
        int callingPid = Binder.getCallingPid();
        SysMonitorSvcBridge.getFactory().getAnrMonitor().addClient(callingPid, client);
    }

    public boolean onTransactMonitorEx(int code, Parcel data, Parcel reply, int flags) {
        switch(code) {
            case 7709: goto L9;
            case 7710: goto L7;
            case 7711: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        data.enforceInterface("android.app.IActivityManager");
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(107, new int[0]);
        return true;
    L7:
        data.enforceInterface("android.app.IActivityManager");
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(106, new int[0]);
        return true;
    L9:
        data.enforceInterface("android.app.IActivityManager");
        int loopDump = data.readInt();
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(105, new int[0]);
        SysMonitorSvcBridge.getFactory().getSysPerfMonitorService().transact(108, new int[]{loopDump});
        return true;
    }

    public long getRomFreeMemoryKb() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long availableBytes = stat.getAvailableBytes();
        return availableBytes / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
    }

    public String getSmtExtraInfo(int pid) {
        if (SysMonitorSvcBridge.getFactory().getSysMonitorService().checkSignatures(Binder.getCallingUid()) == true) goto L6;
        return "";
    L6:
        ActivityManagerService.PidMap r0 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord proc = this.mActivityManagerService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L13
        if (proc == null) goto L16;
        long bootTime = System.currentTimeMillis() - SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        String r4 = "start_time : " + proc.getStartTime() + bootTime;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean isForegroundProcess(String processName) {
        if (SysMonitorSvcBridge.getFactory().getSysMonitorService().checkSignatures(Binder.getCallingUid()) == true) goto L5;
        return false;
    L5:
        Iterator<ProcessRecord> r0 = this.mActivityManagerService.mProcessList.getLruProcessesLOSP().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        ProcessRecord r = r0.next();
        if (r.processName.equals(processName) == false) goto L7;
        return r.isInterestingToUserLocked();
    L13:
        return false;
    }

    public String getPackageName(int pid) {
        if (SysMonitorSvcBridge.getFactory().getSysMonitorService().checkSignatures(Binder.getCallingUid()) == true) goto L6;
        return "";
    L6:
        ActivityManagerService.PidMap r0 = this.mActivityManagerService.mPidsSelfLocked;
        monitor-enter(r0);
        ProcessRecord proc = this.mActivityManagerService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L13
        if (proc == null) goto L16;
        String r2 = proc.info.packageName;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return "";
    L13:
        th = move-exception;
        throw th;
    }

    public static void cleanupProcessesScreenOffForCpu(ActivityManagerService ams) {
    L33:
        e = move-exception;
        Slog.e(TAG, e.getMessage());
        return;
    L3:
        if (mCleanupCancelled == false) goto L5;
        return;
    L5:
        Slog.d(TAG, "check processes stage 1");     // Catch: Exception -> L33
        ArrayList<Integer> killUidlist = new ArrayList();     // Catch: Exception -> L33
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L33
        monitor-enter(ams);     // Catch: Exception -> L33
        Iterator<ProcessRecord> r1 = ams.mProcessList.getLruProcessesLOSP().iterator();     // Catch: Throwable -> L15
    L9:
        if (r1.hasNext() == false) goto L19;
        ProcessRecord r = r1.next();     // Catch: Throwable -> L15
        if ((r.info.getSysEx().peroptFlag & 256) == 0) goto L9;
        if (killUidlist.contains(Integer.valueOf(r.uid)) == true) goto L9;
        killUidlist.add(Integer.valueOf(r.uid));     // Catch: Throwable -> L15
        goto L9
    L19:
        if (mCleanupCancelled == false) goto L24;
        monitor-exit(ams);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L24:
        if (mSmtOptEx.getmUidCpuRunner() == null) goto L30;
        int killUidSize = killUidlist.size();     // Catch: Throwable -> L15
        if (killUidSize <= 0) goto L30;
        int killedUidSize = mSmtOptEx.getmUidCpuRunner().removeUids(killUidlist, false, false, killUidSize);     // Catch: Throwable -> L15
        if (killedUidSize == killUidSize) goto L30;
        Slog.w(TAG, "cleanup UidSize= " + killUidSize + " killedUidSize= " + killedUidSize);     // Catch: Throwable -> L15
    L30:
        monitor-exit(ams);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L33
        return;
    L15:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L33
        throw th;     // Catch: Exception -> L33
    }

    public void clearPendingLaunchRecords() {
        List<ActivityRecord> r0 = this.mPendingLaunchRecords;
        monitor-enter(r0);
        Slog.i(TAG, "clear all has not complete start activity when new Activity start complete");     // Catch: Throwable -> L8
        Iterator<ActivityRecord> r1 = this.mPendingLaunchRecords.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        ActivityRecord r = r1.next();     // Catch: Throwable -> L8
        r.getActivityRecordMonitorEx().launchTimeStatistics.clearLaunchStepIfPausing("clearPendingLaunchRecords");     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mPendingLaunchRecords.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
