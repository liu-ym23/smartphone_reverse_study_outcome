package com.android.server.am;

import android.companion.virtualcamera.SensorOrientation;
import android.os.DebugSmtEx;
import com.android.internal.app.ProcessMap;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.usb.descriptors.UsbDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IApplicationFreezer {
    public static final int BLOCK_NONE = 0;
    public static final int BLOCK_PUBLISH_PROVIDER = 1;
    public static final int BLOCK_WAIT_PROVIDER = 2;
    public static final int FREEZE_ERRNO_BLOCKED = -1;
    public static final int FREEZE_ERRNO_FOCUS = -3;
    public static final int FREEZE_ERRNO_PENDING_UID = -2;
    public static final int FREEZE_ERRNO_SUCCESS = 0;
    public static final int HOOK_ALLOC_BINDER_FREEZE = 2;
    public static final int HOOK_ALLOC_NEW_BUF_FREEZE = 4;
    public static final int HOOK_BINDER_TRANS = 1;
    public static final int HOOK_PKG_LOCAL_IN_FILTER = 8;

    public static class CallerInfo {
        String action;
        int callerPid;
        int callerUid;
        String extraMsg;
        boolean fg;
        String packageName;
        int procState;
        String type;

        public CallerInfo() {
        }

        public CallerInfo setPid(int pid) {
            this.callerPid = pid;
            return this;
        }

        public CallerInfo setUid(int uid) {
            this.callerUid = uid;
            return this;
        }

        public CallerInfo setPackageName(String name) {
            this.packageName = name;
            return this;
        }

        public CallerInfo setType(String type) {
            this.type = type;
            return this;
        }

        public CallerInfo setAction(String a) {
            this.action = a;
            return this;
        }

        public CallerInfo setFg(boolean fg) {
            this.fg = fg;
            return this;
        }

        public CallerInfo setProcState(int s) {
            this.procState = s;
            return this;
        }

        public CallerInfo setExtraMsg(String msg) {
            this.extraMsg = msg;
            return this;
        }

        public String formattedString() {
            return this.callerUid + "|" + this.callerPid + "|" + this.packageName + "|" + this.type + "|" + this.action + "|" + this.fg + "|" + this.procState + "|" + this.extraMsg;
        }

        public String toString() {
            return "Caller:{" + formattedString() + "}";
        }
    }

    public static class FreezeInfo {
        CallerInfo callerInfo;
        long id;
        long lightningTimeout;

        public FreezeInfo() {
        }

        public FreezeInfo setCallerInfo(CallerInfo info) {
            this.callerInfo = info;
            return this;
        }

        public FreezeInfo setId(long id) {
            this.id = id;
            return this;
        }

        public FreezeInfo setLightningTimeout(long timeout) {
            this.lightningTimeout = timeout;
            return this;
        }

        public long getLightningTimeout() {
            return this.lightningTimeout;
        }

        public String toString() {
            return "FreezeInfo:{" + this.callerInfo.formattedString() + ", id:" + this.id + ", lightningTimeout:" + this.lightningTimeout + "}";
        }
    }

    public static final enum FreezeReason extends Enum<FreezeReason> {
        private static final /* synthetic */ FreezeReason[] $VALUES = null;
        public static final FreezeReason AUTO_FREEZE = null;
        public static final FreezeReason BUSY_BACKGROUND = null;
        public static final FreezeReason CAMERA_SCENE = null;
        public static final FreezeReason FREEZE_FOREGROUND = null;
        public static final FreezeReason FREEZE_FOREGROUND_CHECK = null;
        public static final FreezeReason FREEZE_PREFETCH = null;
        public static final FreezeReason FREEZE_WINDOW = null;
        public static final FreezeReason HIGH_TEMP = null;
        public static final FreezeReason KEEP_ALIVE = null;
        public static final FreezeReason LIGHTNING = null;
        public static final FreezeReason MEM_LOW = null;
        public static final FreezeReason NONE = null;
        public static final FreezeReason NO_CONDITION = null;
        public static final FreezeReason POWER = null;
        public static final FreezeReason PREFETCH = null;
        public static final FreezeReason SMART_SCENSE = null;
        public static final FreezeReason SMART_SCENSE_STATE_DOZE = null;
        public static final FreezeReason SMART_SCENSE_STATE_IDLE = null;
        public static final FreezeReason TNT_MEM_LOW = null;
        private int value;

        private static /* synthetic */ FreezeReason[] $values() {
            return new FreezeReason[]{NONE, NO_CONDITION, BUSY_BACKGROUND, FREEZE_WINDOW, TNT_MEM_LOW, PREFETCH, KEEP_ALIVE, FREEZE_PREFETCH, POWER, MEM_LOW, SMART_SCENSE, SMART_SCENSE_STATE_IDLE, SMART_SCENSE_STATE_DOZE, AUTO_FREEZE, FREEZE_FOREGROUND, FREEZE_FOREGROUND_CHECK, LIGHTNING, HIGH_TEMP, CAMERA_SCENE};
        }

        public static FreezeReason valueOf(String name) {
            return (FreezeReason) Enum.valueOf(FreezeReason.class, name);
        }

        public static FreezeReason[] values() {
            return (FreezeReason[]) $VALUES.clone();
        }

        static {
            NONE = new FreezeReason("NONE", 0, -1);
            NO_CONDITION = new FreezeReason("NO_CONDITION", 1, 0);
            BUSY_BACKGROUND = new FreezeReason("BUSY_BACKGROUND", 2, 1);
            FREEZE_WINDOW = new FreezeReason("FREEZE_WINDOW", 3, 2);
            TNT_MEM_LOW = new FreezeReason("TNT_MEM_LOW", 4, 3);
            PREFETCH = new FreezeReason("PREFETCH", 5, 10);
            KEEP_ALIVE = new FreezeReason("KEEP_ALIVE", 6, 20);
            FREEZE_PREFETCH = new FreezeReason("FREEZE_PREFETCH", 7, 30);
            POWER = new FreezeReason("POWER", 8, 100);
            MEM_LOW = new FreezeReason("MEM_LOW", 9, 200);
            SMART_SCENSE = new FreezeReason("SMART_SCENSE", 10, 300);
            SMART_SCENSE_STATE_IDLE = new FreezeReason("SMART_SCENSE_STATE_IDLE", 11, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ALARM_MANAGER_ALARM_CLOCK);
            SMART_SCENSE_STATE_DOZE = new FreezeReason("SMART_SCENSE_STATE_DOZE", 12, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_ALARM_MANAGER_WHILE_IDLE);
            AUTO_FREEZE = new FreezeReason("AUTO_FREEZE", 13, 400);
            FREEZE_FOREGROUND = new FreezeReason("FREEZE_FOREGROUND", 14, 500);
            FREEZE_FOREGROUND_CHECK = new FreezeReason("FREEZE_FOREGROUND_CHECK", 15, 501);
            LIGHTNING = new FreezeReason("LIGHTNING", 16, 600);
            HIGH_TEMP = new FreezeReason("HIGH_TEMP", 17, 610);
            CAMERA_SCENE = new FreezeReason("CAMERA_SCENE", 18, 620);
            $VALUES = $values();
        }

        private FreezeReason(String r1, int r2, int v) {
            super(r1, r2);
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum FreezeStatus extends Enum<FreezeStatus> {
        private static final /* synthetic */ FreezeStatus[] $VALUES = null;
        public static final FreezeStatus FREEZING = null;
        public static final FreezeStatus FROZEN = null;
        public static final FreezeStatus NOT_FROZEN = null;
        public static final FreezeStatus SHOULD_NOT_UNFREEZE = null;
        public static final FreezeStatus UNFROZEN = null;

        private static /* synthetic */ FreezeStatus[] $values() {
            return new FreezeStatus[]{NOT_FROZEN, FREEZING, FROZEN, SHOULD_NOT_UNFREEZE, UNFROZEN};
        }

        private FreezeStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static FreezeStatus valueOf(String name) {
            return (FreezeStatus) Enum.valueOf(FreezeStatus.class, name);
        }

        public static FreezeStatus[] values() {
            return (FreezeStatus[]) $VALUES.clone();
        }

        static {
            NOT_FROZEN = new FreezeStatus("NOT_FROZEN", 0);
            FREEZING = new FreezeStatus("FREEZING", 1);
            FROZEN = new FreezeStatus("FROZEN", 2);
            SHOULD_NOT_UNFREEZE = new FreezeStatus("SHOULD_NOT_UNFREEZE", 3);
            UNFROZEN = new FreezeStatus("UNFROZEN", 4);
            $VALUES = $values();
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode DEFAULT = null;
        public static final Mode INVALID = null;
        public static final Mode LIGHTNING = null;
        public static final Mode LITE = null;

        private static /* synthetic */ Mode[] $values() {
            return new Mode[]{DEFAULT, LITE, LIGHTNING, INVALID};
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static Mode valueOf(String name) {
            return (Mode) Enum.valueOf(Mode.class, name);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            DEFAULT = new Mode("DEFAULT", 0);
            LITE = new Mode("LITE", 1);
            LIGHTNING = new Mode("LIGHTNING", 2);
            INVALID = new Mode("INVALID", 3);
            $VALUES = $values();
        }
    }

    @FunctionalInterface
    public interface ProcessFilter {
        int canFreeze(ProcessRecord r1);
    }

    @FunctionalInterface
    public interface TraverseCallback {
        ProcessRecord onProcess(ProcessRecord r1);
    }

    @FunctionalInterface
    public interface UidFrozenStateCallback {
        void onUidUnfreeze(int r1, boolean r2);
    }

    public static final enum UnfreezeReason extends Enum<UnfreezeReason> {
        private static final /* synthetic */ UnfreezeReason[] $VALUES = null;
        public static final UnfreezeReason ASYNC_BINDER = null;
        public static final UnfreezeReason AUTO_FREEZE = null;
        public static final UnfreezeReason BINDER_ST = null;
        public static final UnfreezeReason DISABLE_SOL = null;
        public static final UnfreezeReason FREEZE_WINDOW = null;
        public static final UnfreezeReason FREE_BUFFER_FULL = null;
        public static final UnfreezeReason KEYGUARD_GOINGAWAY = null;
        public static final UnfreezeReason LIGHTNING = null;
        public static final UnfreezeReason LIGHTNING_FAILED = null;
        public static final UnfreezeReason LIGHTNING_TIMEOUT = null;
        public static final UnfreezeReason NEED_AUDIO_FOCUSED = null;
        public static final UnfreezeReason NEED_AUDIO_FOCUSED_RETURN = null;
        public static final UnfreezeReason NEED_BACKUP_AGENT = null;
        public static final UnfreezeReason NEED_BROADCAST = null;
        public static final UnfreezeReason NEED_CONTENT_PROVIDER = null;
        public static final UnfreezeReason NEED_DESTROY_ACTIVITY = null;
        public static final UnfreezeReason NEED_FOCUSED = null;
        public static final UnfreezeReason NEED_HEARTBEAT = null;
        public static final UnfreezeReason NEED_KILLED = null;
        public static final UnfreezeReason NEED_MEDIA = null;
        public static final UnfreezeReason NEED_NETWORK = null;
        public static final UnfreezeReason NEED_NO_CONDITION = null;
        public static final UnfreezeReason NEED_RESUME_ACTIVITY = null;
        public static final UnfreezeReason NEED_RESUME_ALIVE = null;
        public static final UnfreezeReason NEED_SERVICE = null;
        public static final UnfreezeReason NEED_START_ACTIVITY = null;
        public static final UnfreezeReason NEED_START_PROCESS = null;
        public static final UnfreezeReason NEED_UPDATE_VISIBILITY = null;
        public static final UnfreezeReason NONE = null;
        public static final UnfreezeReason PKG_NET = null;
        public static final UnfreezeReason POWER_ON = null;
        public static final UnfreezeReason POWER_RESTORE = null;
        public static final UnfreezeReason SCHEDULE_TASK_TRANSACTION = null;
        public static final UnfreezeReason START_ACTIVITY = null;
        public static final UnfreezeReason SYNC_BINDER = null;
        public static final UnfreezeReason UNABLE_FREEZE_BINDER = null;
        private int value;

        private static /* synthetic */ UnfreezeReason[] $values() {
            return new UnfreezeReason[]{NONE, NEED_NO_CONDITION, NEED_START_PROCESS, FREEZE_WINDOW, NEED_CONTENT_PROVIDER, NEED_SERVICE, NEED_BACKUP_AGENT, NEED_START_ACTIVITY, NEED_RESUME_ACTIVITY, NEED_UPDATE_VISIBILITY, NEED_DESTROY_ACTIVITY, NEED_BROADCAST, NEED_AUDIO_FOCUSED_RETURN, NEED_FOCUSED, NEED_RESUME_ALIVE, NEED_KILLED, NEED_NETWORK, NEED_HEARTBEAT, AUTO_FREEZE, LIGHTNING, LIGHTNING_TIMEOUT, LIGHTNING_FAILED, UNABLE_FREEZE_BINDER, NEED_AUDIO_FOCUSED, ASYNC_BINDER, FREE_BUFFER_FULL, SYNC_BINDER, NEED_MEDIA, PKG_NET, BINDER_ST, DISABLE_SOL, KEYGUARD_GOINGAWAY, POWER_ON, POWER_RESTORE, START_ACTIVITY, SCHEDULE_TASK_TRANSACTION};
        }

        public static UnfreezeReason valueOf(String name) {
            return (UnfreezeReason) Enum.valueOf(UnfreezeReason.class, name);
        }

        public static UnfreezeReason[] values() {
            return (UnfreezeReason[]) $VALUES.clone();
        }

        static {
            NONE = new UnfreezeReason("NONE", 0, -1);
            NEED_NO_CONDITION = new UnfreezeReason("NEED_NO_CONDITION", 1, 0);
            NEED_START_PROCESS = new UnfreezeReason("NEED_START_PROCESS", 2, 1);
            FREEZE_WINDOW = new UnfreezeReason("FREEZE_WINDOW", 3, 2);
            NEED_CONTENT_PROVIDER = new UnfreezeReason("NEED_CONTENT_PROVIDER", 4, 10);
            NEED_SERVICE = new UnfreezeReason("NEED_SERVICE", 5, 20);
            NEED_BACKUP_AGENT = new UnfreezeReason("NEED_BACKUP_AGENT", 6, 30);
            NEED_START_ACTIVITY = new UnfreezeReason("NEED_START_ACTIVITY", 7, 40);
            NEED_RESUME_ACTIVITY = new UnfreezeReason("NEED_RESUME_ACTIVITY", 8, 50);
            NEED_UPDATE_VISIBILITY = new UnfreezeReason("NEED_UPDATE_VISIBILITY", 9, 55);
            NEED_DESTROY_ACTIVITY = new UnfreezeReason("NEED_DESTROY_ACTIVITY", 10, 50);
            NEED_BROADCAST = new UnfreezeReason("NEED_BROADCAST", 11, 60);
            NEED_AUDIO_FOCUSED_RETURN = new UnfreezeReason("NEED_AUDIO_FOCUSED_RETURN", 12, 65);
            NEED_FOCUSED = new UnfreezeReason("NEED_FOCUSED", 13, 70);
            NEED_RESUME_ALIVE = new UnfreezeReason("NEED_RESUME_ALIVE", 14, 80);
            NEED_KILLED = new UnfreezeReason("NEED_KILLED", 15, 100);
            NEED_NETWORK = new UnfreezeReason("NEED_NETWORK", 16, 150);
            NEED_HEARTBEAT = new UnfreezeReason("NEED_HEARTBEAT", 17, 160);
            AUTO_FREEZE = new UnfreezeReason("AUTO_FREEZE", 18, 170);
            LIGHTNING = new UnfreezeReason("LIGHTNING", 19, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_LAUNCH_OTHER_APP);
            LIGHTNING_TIMEOUT = new UnfreezeReason("LIGHTNING_TIMEOUT", 20, 180);
            LIGHTNING_FAILED = new UnfreezeReason("LIGHTNING_FAILED", 21, 181);
            UNABLE_FREEZE_BINDER = new UnfreezeReason("UNABLE_FREEZE_BINDER", 22, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__PLATFORM_PROVISIONING_COPY_ACCOUNT_MS);
            NEED_AUDIO_FOCUSED = new UnfreezeReason("NEED_AUDIO_FOCUSED", 23, 200);
            ASYNC_BINDER = new UnfreezeReason("ASYNC_BINDER", 24, 210);
            FREE_BUFFER_FULL = new UnfreezeReason("FREE_BUFFER_FULL", 25, UsbDescriptor.CLASSID_DIAGNOSTIC);
            SYNC_BINDER = new UnfreezeReason("SYNC_BINDER", 26, FrameworkStatsLog.APP_PROCESS_DIED__IMPORTANCE__IMPORTANCE_PERCEPTIBLE);
            NEED_MEDIA = new UnfreezeReason("NEED_MEDIA", 27, FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED);
            PKG_NET = new UnfreezeReason("PKG_NET", 28, 250);
            BINDER_ST = new UnfreezeReason("BINDER_ST", 29, 260);
            DISABLE_SOL = new UnfreezeReason("DISABLE_SOL", 30, SensorOrientation.ORIENTATION_270);
            KEYGUARD_GOINGAWAY = new UnfreezeReason("KEYGUARD_GOINGAWAY", 31, 275);
            POWER_ON = new UnfreezeReason("POWER_ON", 32, FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS);
            POWER_RESTORE = new UnfreezeReason("POWER_RESTORE", 33, 290);
            START_ACTIVITY = new UnfreezeReason("START_ACTIVITY", 34, 300);
            SCHEDULE_TASK_TRANSACTION = new UnfreezeReason("SCHEDULE_TASK_TRANSACTION", 35, 310);
            $VALUES = $values();
        }

        private UnfreezeReason(String r1, int r2, int v) {
            super(r1, r2);
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    default boolean isEnable() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default ProcessRecord unfreezeAppIfNeededLocked(ProcessRecord app, String processName, int uid, UnfreezeReason reason, ProcessRecord caller, Object startingInfo, FreezeInfo freezeInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void unfreezeAppIfNeededAsync(ProcessRecord app, String processName, int uid, UnfreezeReason reason, ProcessRecord caller, Object startingInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean unfreezeAppIfNeededLocked(ProcessRecord app, UnfreezeReason reason, ProcessRecord caller, Object startingInfo, FreezeInfo freezeInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default ProcessRecord traverse(TraverseCallback cb) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default boolean unfreezeProcessLocked(ProcessRecord oneApp, boolean allAppInUid, UnfreezeReason reason, FreezeInfo freezeInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void setFocusedAppLocked(ProcessRecord app) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default ProcessRecord get(String processName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default ProcessRecord get(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default String getFrozenPkgNameByPid(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default ProcessRecord getFrozenProc(int pid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default ProcessRecord takeoutByProcessLocked(ProcessRecord app) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default ProcessRecord takeoutByNameLocked(String name, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default ProcessMap<ProcessRecord> getFrozenProcesses() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default boolean freezeUidLocked(int uid, FreezeReason reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean freezeUidLocked(int uid, FreezeReason reason, boolean force) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean freezeUidLocked(int uid, FreezeReason reason, Mode mode) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean registerProcessFilter(ProcessFilter filter, boolean register) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean freezeProcessLiteLocked(int[] pid, FreezeReason reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean unfreezeProcessLiteLocked(int[] pid, UnfreezeReason reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean freezeProcessLocked(ProcessRecord oneApp, boolean allAppInUid, FreezeReason reason, Mode mode, FreezeInfo freezeInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void unfreezeForQuickFreeze(String packageName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean unfreezeForQuickFreeze(List<ProcessRecord> apps, UnfreezeReason reason, Mode mode, FreezeInfo freezeInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isUidFrozen(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean toggleUnfreezeWhitelist(String packageName, boolean add) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean unfreezePackage(String pkg, UnfreezeReason reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void triggerForKernel(int type, int callerPid, int targetUid, int targetPid, String rpcName, int rpcCode, int intParam) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int enableHook(int param) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default int setNetFilter(int targetUid, int type) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default int checkPidBinderSt(int targetPid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default int checkUidBinderSt(int targetUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return -1;
    }

    default void checkProcessFreezeState(FreezeErrorData data) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isNetUnfreezeApp(String packageName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean unfreezeUidLocked(int uid, UnfreezeReason reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void dump(PrintWriter pw, String[] args) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void sendUnFreezeTimeoutMsg(int pid, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void removeUnfreezeTimeoutMsg(int pid, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyPowerOn() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void setSupportGki(boolean supportGki) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isSupportGki() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void notifyAudioFocusGain(String pkgName, int uid, boolean isReturn) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyAudioFocusLoss(String loserPkg, int loserUid, int focusLoss, String winnerPkg, int winnerUid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
