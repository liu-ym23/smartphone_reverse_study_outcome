package com.android.server.am;

import android.app.IApplicationThread;
import android.os.Bundle;
import android.os.Debug;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SmtUidUtil;
import bytedanceos.util.FeatLog;
import bytedanceos.util.SmtRingBuffer;
import com.android.server.ApplicationFreezerHelperSmt;
import com.android.server.ApplicationFreezerInternalSmt;
import com.android.server.ISmtResourceControl;
import com.android.server.SysOptBridge;
import com.android.server.wm.FrozenPendingEvent;
import com.android.server.wm.WindowProcessListenerSmtBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ProcessRecordSmtBase implements WindowProcessListenerSmtBase {
    public static final int FREEZING = 1;
    public static final int FROZEN = 2;
    public static final int NONE = 0;
    static final String PSS_TAG = "pss_history";
    private static int TIME_PSS_COLLECT_INTERVAL_1_MIN = 0;
    private static int TIME_PSS_COLLECT_INTERVAL_2_MINS = 0;
    public static final int TYPE_ACTIVE_BACKGROUND = 1;
    public static final int TYPE_BOOST_TO_TOP_GROUP = 2;
    public static final int TYPE_NONE = 0;
    boolean adjHasReachedZero;
    boolean attachCompleted;
    boolean browserGpuProc;
    int bytedanceFlag;
    Bundle cacheData;
    public int cantSwap;
    int collectBadAppLevel;
    int compactIntervalFactor;
    Object compactLock;
    int compactedStage;
    boolean delayFreezing;
    long failedFrozenTime;
    long failedPushTime;
    int freezeBlockFlags;
    boolean freezeFromPrefetch;
    IApplicationFreezer.Mode freezeMode;
    IFreezeStats freezeStats;
    int freezingStat;
    public long graphicKeepAliveTime;
    public boolean hasOnGoingNotification;
    boolean hasUpdated;
    SmtRingBuffer<Long> history;
    public boolean hotLaunchStage;
    boolean inSwapfile;
    boolean isColdLaunchDone;
    public boolean isGphSwapSupported;
    public boolean isKeepAlive;
    public boolean isPrefetch;
    public boolean isPreviousAlive;
    boolean isStartDuringPrefetch;
    public boolean isVRKeepAlive;
    int killType;
    public String killedReason;
    private long lastUnfreezeTs;
    public long lastVoiceTime;
    boolean launchFromPrefetchUnfreeze;
    volatile int mCompactedType;
    public long mEGL;
    public int mFinalLaunchCpusetLevel;
    public int mFinalRunningCpusetLevel;
    private ApplicationFreezerInternalSmt.IFrozenCallback mFrozenCallback;
    long mLastCompactedTime;
    public long mLaunchCpusetLevelUpdateTime;
    public long mLaunchCpusetTimeOut;
    final Object mProcLock;
    protected ProcessRecord mProcessRecord;
    public long mPss;
    public long mPssSwapped;
    public long mPssToBeSwapped;
    public long mRunningCpusetLevelUpdateTime;
    public long mRunningCpusetTimeOut;
    private int mState;
    private boolean mXrCrashed;
    boolean mainProc;
    long memInUfsSize;
    Debug.MemoryInfo memoryInfo;
    int not3rdReasonFlag;
    int notFreezeReason;
    int origAdj;
    volatile int pid;
    public long prefetchFrozenTime;
    int pssCount;
    boolean setCgroup;
    protected String smtExtraInfo;
    int smtUid;
    public int stickineFraction;
    public volatile long stoppingTime;
    public int swapPercent;
    private IApplicationThread thread;
    public boolean unFreezeForLaunch;
    public IApplicationFreezer.UnfreezeReason unFreezeReason;
    private ArraySet waitingProviders;

    public void increaseCompactFactor() {
        if (this.compactIntervalFactor >= 10) goto L6;
        this.compactIntervalFactor++;
        return;
    }

    public void decreaseCompactFactor() {
        if (this.compactIntervalFactor <= 1) goto L6;
        this.compactIntervalFactor >>= 1;
        return;
    }

    public void resetCompactFactor() {
        this.compactIntervalFactor = 1;
    }

    public void setPid(int _pid) {
        this.setCgroup = false;
    }

    public void resetPreviousAlive() {
        this.isPreviousAlive = false;
    }

    public int getSmtUid(int uid, String packageName) {
        if (uid == 1000) goto L5;
        return uid;
    L5:
        if (this.smtUid != 1000) goto L7;
        this.smtUid = SmtUidUtil.getSystemUidForPackage(packageName);
    L7:
        int result = this.smtUid;
        return result;
    }

    public int getSmtUid() {
        int result = this.mProcessRecord.uid;
        if (this.mProcessRecord.info == null) goto L6;
        int result2 = getSmtUid(this.mProcessRecord.info.uid, this.mProcessRecord.info.packageName);
        return result2;
    L6:
        return result;
    }

    public boolean checkCpusetEffectiveTime(long now) {
        if (this.mRunningCpusetTimeOut >= 0) goto L5;
    L8:
        return true;
    L5:
        if ((now - this.mRunningCpusetLevelUpdateTime) < this.mRunningCpusetTimeOut) goto L8;
        if ((now - this.mLaunchCpusetLevelUpdateTime) < this.mLaunchCpusetTimeOut) goto L8;
        return false;
    }

    public int computeCurrentSchedulingGroup(int defaultSchedGroup, long now) {
        int schedGroup = defaultSchedGroup;
        if (this.mFinalLaunchCpusetLevel != 0) goto L7;
        if (this.mFinalRunningCpusetLevel != 0) goto L7;
    L25:
        return schedGroup;
    L7:
        if (checkCpusetEffectiveTime(now) == true) goto L9;
        this.mFinalLaunchCpusetLevel = 0;
    L24:
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 40, "process  :" + this.mProcessRecord + "  final sched group  : " + schedGroup + "   default group :" + defaultSchedGroup);
        goto L25
    L9:
        if (this.mFinalLaunchCpusetLevel != 1) goto L11;
    L22:
        schedGroup = 3;
        goto L24
    L11:
        if (this.mFinalRunningCpusetLevel == 1) goto L22;
        if (this.mFinalLaunchCpusetLevel != 2) goto L16;
    L21:
        schedGroup = 2;
        goto L24
    L16:
        if (this.mFinalRunningCpusetLevel == 2) goto L21;
        if (this.mFinalRunningCpusetLevel != 5) goto L24;
        schedGroup = 12;
        goto L24
    }

    public void updateFinalCpusetLevel(int cpusetLevel, int scenes, long timeOut) {
        if (scenes != 1) goto L9;
        this.mFinalLaunchCpusetLevel = cpusetLevel;
        if (cpusetLevel == 0) goto L7;
        this.mLaunchCpusetLevelUpdateTime = SystemClock.uptimeMillis();
    L7:
        this.mLaunchCpusetTimeOut = timeOut;
    L14:
        FeatLog.i("SmtResourceControl", "FEAT_PERF_RES_CONTROL", 30, "process  :" + this.mProcessRecord + "  cpuset has been set to : " + cpusetLevel + "  timeout" + timeOut + "   scenes : " + scenes);
        return;
    L9:
        if (scenes != 2) goto L14;
        this.mFinalRunningCpusetLevel = cpusetLevel;
        if (cpusetLevel == 0) goto L13;
        this.mRunningCpusetLevelUpdateTime = SystemClock.uptimeMillis();
    L13:
        this.mRunningCpusetTimeOut = timeOut;
        goto L14
    }

    static {
        TIME_PSS_COLLECT_INTERVAL_1_MIN = 60000;
        TIME_PSS_COLLECT_INTERVAL_2_MINS = 120000;
    }

    public ProcessRecordSmtBase(ProcessRecord processRecord) {
        this.isStartDuringPrefetch = false;
        this.delayFreezing = false;
        this.freezeFromPrefetch = false;
        this.attachCompleted = false;
        this.not3rdReasonFlag = -1;
        this.stoppingTime = 0;
        this.launchFromPrefetchUnfreeze = false;
        this.hotLaunchStage = false;
        this.smtUid = 1000;
        this.compactLock = new Object();
        this.mCompactedType = 0;
        this.compactIntervalFactor = 1;
        this.mLastCompactedTime = 0;
        this.memInUfsSize = -1;
        this.isKeepAlive = false;
        this.isPreviousAlive = false;
        this.mainProc = false;
        this.browserGpuProc = false;
        this.setCgroup = false;
        this.mProcLock = new Object();
        this.mFinalLaunchCpusetLevel = 0;
        this.mLaunchCpusetLevelUpdateTime = 0;
        this.mLaunchCpusetTimeOut = ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME;
        this.mFinalRunningCpusetLevel = 0;
        this.mRunningCpusetLevelUpdateTime = 0;
        this.mRunningCpusetTimeOut = 3600000;
        this.adjHasReachedZero = false;
        this.pssCount = 0;
        this.hasUpdated = false;
        this.history = new SmtRingBuffer(3);
        this.freezeMode = IApplicationFreezer.Mode.INVALID;
        this.freezeBlockFlags = 0;
        this.waitingProviders = new ArraySet();
        this.freezeStats = SysOptBridge.getFactory().createFreezeStats();
        this.inSwapfile = false;
        this.failedFrozenTime = 0;
        this.failedPushTime = 0;
        this.isColdLaunchDone = false;
        this.unFreezeForLaunch = false;
        this.mFrozenCallback = new AnonymousClass1(this);
        this.origAdj = ProcessList.INVALID_ADJ;
        this.bytedanceFlag = 0;
        this.mEGL = 0;
        this.mPss = 0;
        this.mPssSwapped = 0;
        this.mPssToBeSwapped = 0;
        this.memoryInfo = null;
        this.cacheData = new Bundle();
        this.mXrCrashed = false;
        this.mState = 0;
        this.mProcessRecord = processRecord;
        this.isGphSwapSupported = SysOptBridge.getFactory().getAppRecordManagerService().isGameApp(processRecord);
    }

    boolean isColdLaunchDone() {
        return this.isColdLaunchDone;
    }

    void addPssHistoryLocked(long now, long pss, ProcessRecord proc) {
        proc.mSmtEx.pssCount++;
        this.history.add(Long.valueOf(pss));
        proc.mSmtEx.hasUpdated = true;
    }

    public void setTryUnfreezeTime(long ts) {
        this.lastUnfreezeTs = ts;
    }

    public long getTryUnfreezeTime() {
        return this.lastUnfreezeTs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("PRSmt{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" p:");
        sb.append(this.pid);
        sb.append(" rp:");
        sb.append(getPid());
        sb.append(" sa:");
        sb.append(this.mProcessRecord.mState.getSetAdj());
        UidRecord tmpUidRec = this.mProcessRecord.mUidRecord;
        if (tmpUidRec == null) goto L5;
        sb.append(" usps:");
        sb.append(tmpUidRec.getSetProcState());
    L5:
        sb.append(" sps:");
        sb.append(this.mProcessRecord.mState.getSetProcState());
        sb.append(" kt:");
        sb.append(this.killType);
        sb.append(" fs:");
        sb.append(this.freezingStat);
        sb.append(" inSfile:");
        sb.append(this.inSwapfile);
        sb.append(" freezeBlockFlags:");
        sb.append(this.freezeBlockFlags);
        sb.append(" pendingInstallProviderCount:");
        sb.append(this.waitingProviders.size());
        sb.append(" fm:");
        sb.append(this.freezeMode);
        sb.append('}');
        return sb.toString();
    }

    static boolean allowPssCollect(ProcessRecord pr, boolean memLowered, boolean wholeCollect, long now) {
        if (memLowered == false) goto L6;
        return true;
    L6:
        if (pr.mSmtEx.pssCount <= 5) goto L28;
        long timeInterval = TIME_PSS_COLLECT_INTERVAL_2_MINS;
        if (wholeCollect == false) goto L11;
        timeInterval = TIME_PSS_COLLECT_INTERVAL_1_MIN;
    L11:
        if (pr.mSmtEx.adjHasReachedZero == false) goto L28;
        if (now >= (pr.mProfile.getLastPssTime() + timeInterval)) goto L28;
        pr.mSmtEx.adjHasReachedZero = false;
        if (pr.mSmtEx.hasUpdated == true) goto L18;
        return false;
    L18:
        if (isHighSimilarity(pr.mSmtEx.history) == false) goto L28;
        if (ActivityManagerDebugConfig.DEBUG_PSS == false) goto L26;
        Slog.d(PSS_TAG, "-----------------------------------------------------------------------------");
        Slog.d(PSS_TAG, "little change for latest 3 times pss, pr= " + pr.processName + " pss count= " + pr.mSmtEx.pssCount);
        int i = 0;
    L23:
        if (i >= pr.mSmtEx.history.size()) goto L25;
        Slog.d(PSS_TAG, "history= " + pr.mSmtEx.history.get(i) + " (" + i + ")");
        i = i + 1;
        goto L23
    L25:
        Slog.d(PSS_TAG, "pss similarity= " + isHighSimilarity(pr.mSmtEx.history));
        Slog.d(PSS_TAG, "-----------------------------------------------------------------------------");
    L26:
        pr.mSmtEx.hasUpdated = false;
        return false;
    L28:
        return true;
    }

    private static boolean isHighSimilarity(SmtRingBuffer<Long> history) {
        int m = history.size();
        if (m > 0) goto L5;
        return false;
    L5:
        long sum = 0;
        int i = 0;
    L6:
        if (i >= m) goto L8;
        sum = sum + ((Long) history.get(i)).longValue();
        i = i + 1;
        goto L6
    L8:
        float dAve = sum / (m * 1.0f);
        int i2 = 0;
    L9:
        if (i2 >= m) goto L14;
        if ((Math.abs(((Long) history.get(i2)).longValue() - dAve) / dAve) >= 0.05d) goto L13;
        i2 = i2 + 1;
        goto L9
    L13:
        return false;
    L14:
        return true;
    }

    boolean isFreezing() {
        if (this.freezingStat == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isFrozen() {
        if (this.freezingStat != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean inFreezeStat() {
        if (this.freezingStat == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setFreezeMode(IApplicationFreezer.Mode mode, String reason) {
        this.freezeMode = mode;
        Slog.i("AMS.freeze", "setFreezeMode: " + mode + " reason: " + reason + " pid:" + getPid());
    }

    boolean inLightningMode() {
        if (this.freezeMode != IApplicationFreezer.Mode.LIGHTNING) goto L5;
        return true;
    L5:
        return false;
    }

    boolean inDefaultMode() {
        if (this.freezeMode != IApplicationFreezer.Mode.DEFAULT) goto L5;
        return true;
    L5:
        return false;
    }

    boolean inFreezeMode() {
        if (this.freezeMode == IApplicationFreezer.Mode.INVALID) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setHostPid(ProcessRecord host, int _pid) {
        host.setPid(_pid);
    }

    void setCurrentFreezingStat(ActivityManagerService service, ProcessRecord host, int stat) {
        this.freezingStat = stat;
        host.setShortStringName(null);
        host.setStringName(null);
        if (this.freezingStat != 1) goto L6;
        ApplicationFreezerHelperSmt.registerFrozenCallbackByPidOnce(host.getPid(), host.uid, this.mFrozenCallback);
        return;
    }

    public static ArrayList<ProcessRecord> getLruProcesses(ActivityManagerService mService) {
        return mService.mProcessList.mLruProcesses;
    }

    public static int getCurProcState(ProcessRecord r) {
        if (r != null) goto L6;
        return -1;
    L6:
        return r.mState.getCurProcState();
    }

    public static boolean isPersistent(ProcessRecord r) {
        if (r != null) goto L6;
        return false;
    L6:
        return r.isPersistent();
    }

    public static boolean hasActivities(ProcessRecord r) {
        if (r != null) goto L6;
        return false;
    L6:
        return r.hasActivities();
    }

    public static boolean isPcProcess(ProcessRecord r) {
        if (r != null) goto L6;
        return false;
    L6:
        return r.getSmtEx().isPcMode();
    }

    int getCurrentFreezingStat() {
        return this.freezingStat;
    }

    boolean isPcMode() {
        return false;
    }

    @Override // com.android.server.wm.WindowProcessListenerSmtBase
    public void unFreezeProcIfNeed(FrozenPendingEvent event) {
        ActivityManagerService r1 = this.mProcessRecord.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededLocked(this.mProcessRecord, event.unfreezeReason, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void reportKillingEvent(String reason) {
        if (this.mProcessRecord.mService == null) goto L6;
        this.mProcessRecord.getSmtEx().killedReason = reason;
        String killEvent = KillingStatsUtils.buildAmKillingEventItem(getCanonicalName(), this.mProcessRecord.uid, this.mProcessRecord.getPid(), this.mProcessRecord.mState.getSetAdj(), this.mProcessRecord.mState.getSetProcState(), reason);
        this.mProcessRecord.mService.getSmtEx().reportKillingEvent(killEvent);
        return;
    }

    @Override // com.android.server.wm.WindowProcessListenerSmtBase
    public void canclePrefetch() {
        SysOptBridge.getFactory().getPrefetchManager().canclePrefetch(this.mProcessRecord.info);
    }

    public String getCanonicalName() {
        if (this.mProcessRecord.isolated == false) goto L6;
        return this.mProcessRecord.info.packageName + ":" + this.mProcessRecord.processName;
    L6:
        return this.mProcessRecord.processName;
    }

    @Override // com.android.server.wm.WindowProcessListenerSmtBase
    public String getProcessName() {
        return this.mProcessRecord.processName;
    }

    public int getPid() {
        if (this.mProcessRecord.getPid() <= 0) goto L6;
        return this.mProcessRecord.getPid();
    L6:
        return this.pid;
    }

    public String getSmtExtraInfo() {
        return this.smtExtraInfo;
    }

    public void setSmtExtraInfo(String info) {
        this.smtExtraInfo = info;
    }

    public void syncAppData() {
    L9:
        e = move-exception;
        Slog.e("PRSmt", "sync app data failed", e);
        return;
    L4:
        if (this.mProcessRecord.getThread() == null) goto L16;
        Bundle settings = this.cacheData.getBundle("core_settings");     // Catch: RemoteException -> L9
        if (settings == null) goto L17;
        this.mProcessRecord.getThread().setCoreSettings(settings);     // Catch: RemoteException -> L9
        this.cacheData.remove("core_settings");     // Catch: RemoteException -> L9
        return;
    L17:
        return;
    }

    void resetFreezeBlockFlagsLocked(int flags) {
        if ((flags & 1) == 0) goto L6;
        this.freezeBlockFlags &= -2;
    L6:
        if ((flags & 2) == 0) goto L9;
        this.waitingProviders.clear();
        this.freezeBlockFlags &= -3;
        return;
    }

    void setFreezeBlockFlagsLocked(int flags, Object privData) {
        if ((flags & 1) == 0) goto L6;
        this.freezeBlockFlags |= 1;
    L6:
        if ((flags & 2) == 0) goto L9;
        this.freezeBlockFlags |= 2;
        this.waitingProviders.add(privData);
        return;
    }

    void clearFreezeBlockFlagsLocked(int flags, Object privData) {
        if ((flags & 1) == 0) goto L6;
        this.freezeBlockFlags &= -2;
    L6:
        if ((flags & 2) != 0) goto L8;
        return;
    L8:
        if (this.waitingProviders.remove(privData) == true) goto L10;
        return;
    L10:
        if (this.waitingProviders.isEmpty() == false) goto L15;
        this.freezeBlockFlags &= -3;
        return;
    }

    public void setXRCrashed() {
        this.mXrCrashed = true;
    }

    public boolean getXRCrashed() {
        return this.mXrCrashed;
    }

    @Override // com.android.server.wm.WindowProcessListenerSmtBase
    public void bringProcessToDefaultLocked() {
        ActivityManagerService r0 = this.mProcessRecord.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        SysOptBridge.getFactory().getActivityManager(this.mProcessRecord.mService).bringProcessToDefaultLocked(this.mProcessRecord.getWindowProcessController());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void setPriorityState(int state) {
        this.mState = state;
        if (state != 1) goto L5;
        int group = 5;
    L6:
        this.mProcessRecord.mState.setCurrentSchedulingGroup(group);
        SysOptBridge.getFactory().getActivityManager(this.mProcessRecord.mService).asyncSetProcessGroupAll(this.mProcessRecord, this.mProcessRecord.getPid(), group);
        return;
    L5:
        group = 12;
        goto L6
    }

    public int getPriorityState() {
        return this.mState;
    }

    public IApplicationThread getThread() {
        Object r0 = this.mProcLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.thread == null) goto L9;
        IApplicationThread r1 = this.thread;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L9:
        r1 = this.mProcessRecord.getThread();     // Catch: Throwable -> L7
        goto L10
    }

    public IApplicationThread getSmtThread() {
        Object r0 = this.mProcLock;
        monitor-enter(r0);
        IApplicationThread r1 = this.thread;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void backupThread() {
        Object r0 = this.mProcLock;
        monitor-enter(r0);
        this.thread = this.mProcessRecord.getThread();     // Catch: Throwable -> L7
        this.mProcessRecord.setThread(null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void restoreThread() {
        Object r0 = this.mProcLock;
        monitor-enter(r0);
        this.mProcessRecord.setThread(this.thread);     // Catch: Throwable -> L7
        this.thread = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String[] getPackageList() {
        Object r0 = this.mProcLock;
        monitor-enter(r0);
        String[] r1 = this.mProcessRecord.getPackageList();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
