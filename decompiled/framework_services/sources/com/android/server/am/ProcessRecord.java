package com.android.server.am;

import android.app.BackgroundStartPrivileges;
import android.app.IApplicationThread;
import android.app.SysMonitorFwBridge;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ProcessInfo;
import android.content.pm.VersionedPackage;
import android.content.res.CompatibilityInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.system.OsConstants;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.EventLog;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.app.procstats.ProcessState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.os.Zygote;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.SysOptBridge;
import com.android.server.resmng.IAppStatus;
import com.android.server.wm.WindowProcessController;
import com.android.server.wm.WindowProcessListener;
import com.android.server.wm.WindowProcessListenerSmtBase;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class ProcessRecord implements WindowProcessListener {
    static final String TAG = "ActivityManager";
    final boolean appZygote;
    long diedTime;
    volatile ApplicationInfo info;
    public final boolean isSdkSandbox;
    final boolean isolated;
    private final ArrayMap<Binder, BackgroundStartPrivileges> mBackgroundStartPrivileges;
    private BackgroundStartPrivileges mBackgroundStartPrivilegesMerged;
    private volatile long mBindApplicationTime;
    private volatile boolean mBindMountPending;
    private int[] mCommonPoolTids;
    private CompatibilityInfo mCompat;
    public int mCrashPid;
    private IBinder.DeathRecipient mDeathRecipient;
    private boolean mDebugging;
    private long[] mDisabledCompatChanges;
    private int mDyingPid;
    final ProcessErrorStateRecord mErrorState;
    private int[] mGids;
    private volatile HostingRecord mHostingRecord;
    private boolean mInFullBackup;
    private ActiveInstrumentation mInstr;
    private String mInstructionSet;
    private String mIsolatedEntryPoint;
    private String[] mIsolatedEntryPointArgs;
    private long mKillTime;
    private boolean mKilled;
    private boolean mKilledByAm;
    private long mLastActivityTime;
    final OomAdjusterModernImpl.ProcessRecordNode[] mLinkedNodes;
    private long[] mLoggableCompatChanges;
    private int mLruSeq;
    ProcessRecordMonitorEx mMonitorEx;
    private volatile int mMountMode;
    private IApplicationThread mOnewayThread;
    final ProcessCachedOptimizerRecord mOptRecord;
    private boolean mPendingFinishAttach;
    private boolean mPendingStart;
    private volatile boolean mPersistent;
    public volatile int mPid;
    private ArraySet<String> mPkgDeps;
    private final PackageList mPkgList;
    volatile ProcessRecord mPredecessor;
    private final ActivityManagerGlobalLock mProcLock;
    volatile boolean mProcessGroupCreated;
    final ProcessProfileRecord mProfile;
    final ProcessProviderRecord mProviders;
    final ProcessReceiverRecord mReceivers;
    private volatile boolean mRemoved;
    private int mRenderThreadTid;
    private String mRequiredAbi;
    private volatile String mSeInfo;
    final ActivityManagerService mService;
    final ProcessServiceRecord mServices;
    private String mShortStringName;
    volatile boolean mSkipProcessGroupCreation;
    ProcessRecordSmtBase mSmtEx;
    private volatile long mStartElapsedTime;
    private long mStartSeq;
    private volatile int mStartUid;
    private volatile long mStartUptime;
    ProcessStateRecord mState;
    private String mStringName;
    volatile ProcessRecord mSuccessor;
    Runnable mSuccessorStartRunnable;
    private ApplicationThreadDeferred mThread;
    public UidRecord mUidRecord;
    private boolean mUnlocked;
    private boolean mUsingWrapper;
    private boolean mWaitedForDebugger;
    private String mWaitingToKill;
    volatile boolean mWasForceStopped;
    private final WindowProcessController mWindowProcessController;
    final ProcessInfo processInfo;
    final String processName;
    final String sdkSandboxClientAppPackage;
    final String sdkSandboxClientAppVolumeUuid;
    long sendSigChldTime;
    final int uid;
    final int userId;

    public static /* synthetic */ void $r8$lambda$HANeJKZz4r720moq9uNElrY05J8(ProcessState r0, ProcessStats.ProcessStateHolder r1) {
        lambda$resetPackageList$0(r0, r1);
    }

    @Override // com.android.server.wm.WindowProcessListener
    public /* bridge */ /* synthetic */ WindowProcessListenerSmtBase getSmtEx() {
        return getSmtEx();
    }

    void setStartParams(int startUid, HostingRecord hostingRecord, String seInfo, long startUptime, long startElapsedTime) {
        this.mStartUid = startUid;
        this.mHostingRecord = hostingRecord;
        this.mSeInfo = seInfo;
        this.mStartUptime = startUptime;
        this.mStartElapsedTime = startElapsedTime;
    }

    void dump(PrintWriter pw, String prefix) {
        long nowUptime = SystemClock.uptimeMillis();
        long nowElapsedTime = SystemClock.elapsedRealtime();
        pw.print(prefix);
        pw.print("user #");
        pw.print(this.userId);
        pw.print(" uid=");
        pw.print(this.info.uid);
        if (this.uid == this.info.uid) goto L5;
        pw.print(" ISOLATED uid=");
        pw.print(this.uid);
    L5:
        pw.print(" gids={");
        if (this.mGids == null) goto L13;
        int gi = 0;
    L9:
        if (gi >= this.mGids.length) goto L13;
        if (gi == 0) goto L12;
        pw.print(", ");
    L12:
        pw.print(this.mGids[gi]);
        gi = gi + 1;
    L13:
        pw.println("}");
        if (this.processInfo == null) goto L27;
        pw.print(prefix);
        pw.println("processInfo:");
        if (this.processInfo.deniedPermissions == null) goto L22;
        int i = 0;
    L19:
        if (i >= this.processInfo.deniedPermissions.size()) goto L22;
        pw.print(prefix);
        pw.print("  deny: ");
        pw.println((String) this.processInfo.deniedPermissions.valueAt(i));
        i = i + 1;
    L22:
        if (this.processInfo.gwpAsanMode == (-1)) goto L25;
        pw.print(prefix);
        pw.println("  gwpAsanMode=" + this.processInfo.gwpAsanMode);
    L25:
        if (this.processInfo.memtagMode == (-1)) goto L27;
        pw.print(prefix);
        pw.println("  memtagMode=" + this.processInfo.memtagMode);
    L27:
        pw.print(prefix);
        pw.print("mRequiredAbi=");
        pw.print(this.mRequiredAbi);
        pw.print(" instructionSet=");
        pw.println(this.mInstructionSet);
        if (this.info.className == null) goto L31;
        pw.print(prefix);
        pw.print("class=");
        pw.println(this.info.className);
    L31:
        if (this.info.manageSpaceActivityName == null) goto L33;
        pw.print(prefix);
        pw.print("manageSpaceActivityName=");
        pw.println(this.info.manageSpaceActivityName);
    L33:
        pw.print(prefix);
        pw.print("dir=");
        pw.print(this.info.sourceDir);
        pw.print(" publicDir=");
        pw.print(this.info.publicSourceDir);
        pw.print(" data=");
        pw.println(this.info.dataDir);
        this.mPkgList.dump(pw, prefix);
        if (this.mPkgDeps == null) goto L42;
        pw.print(prefix);
        pw.print("packageDependencies={");
        int i2 = 0;
    L37:
        if (i2 >= this.mPkgDeps.size()) goto L41;
        if (i2 <= 0) goto L40;
        pw.print(", ");
    L40:
        pw.print(this.mPkgDeps.valueAt(i2));
        i2 = i2 + 1;
        goto L37
    L41:
        pw.println("}");
    L42:
        pw.print(prefix);
        pw.print("compat=");
        pw.println(this.mCompat);
        if (this.mInstr == null) goto L45;
        pw.print(prefix);
        pw.print("mInstr=");
        pw.println(this.mInstr);
    L45:
        pw.print(prefix);
        pw.print("thread=");
        pw.println(this.mThread);
        pw.print(prefix);
        pw.print("pid=");
        pw.println(this.mPid);
        pw.print(prefix);
        pw.print("lastActivityTime=");
        TimeUtils.formatDuration(this.mLastActivityTime, nowUptime, pw);
        pw.print(prefix);
        pw.print("startUpTime=");
        TimeUtils.formatDuration(this.mStartUptime, nowUptime, pw);
        pw.print(prefix);
        pw.print("startElapsedTime=");
        TimeUtils.formatDuration(this.mStartElapsedTime, nowElapsedTime, pw);
        pw.println();
        if (this.mPersistent == false) goto L48;
    L49:
        pw.print(prefix);
        pw.print("persistent=");
        pw.print(this.mPersistent);
        pw.print(" removed=");
        pw.println(this.mRemoved);
    L51:
        if (this.mDebugging == false) goto L54;
        pw.print(prefix);
        pw.print("mDebugging=");
        pw.println(this.mDebugging);
    L54:
        if (this.mPendingStart == false) goto L56;
        pw.print(prefix);
        pw.print("pendingStart=");
        pw.println(this.mPendingStart);
    L56:
        pw.print(prefix);
        pw.print("startSeq=");
        pw.println(this.mStartSeq);
        pw.print(prefix);
        pw.print("mountMode=");
        pw.println(DebugUtils.valueToString(Zygote.class, "MOUNT_EXTERNAL_", this.mMountMode));
        if (this.mKilled == false) goto L59;
    L62:
        pw.print(prefix);
        pw.print("killed=");
        pw.print(this.mKilled);
        pw.print(" killedByAm=");
        pw.print(this.mKilledByAm);
        pw.print(" waitingToKill=");
        pw.println(this.mWaitingToKill);
    L64:
        if (this.mIsolatedEntryPoint == null) goto L66;
    L67:
        pw.print(prefix);
        pw.print("isolatedEntryPoint=");
        pw.println(this.mIsolatedEntryPoint);
        pw.print(prefix);
        pw.print("isolatedEntryPointArgs=");
        pw.println(Arrays.toString(this.mIsolatedEntryPointArgs));
    L69:
        if (this.mState.getSetProcState() <= 10) goto L71;
        this.mProfile.dumpCputime(pw, prefix);
    L71:
        this.mProfile.dumpPss(pw, prefix, nowUptime);
        this.mState.dump(pw, prefix, nowUptime);
        this.mErrorState.dump(pw, prefix, nowUptime);
        this.mServices.dump(pw, prefix, nowUptime);
        this.mProviders.dump(pw, prefix, nowUptime);
        this.mReceivers.dump(pw, prefix, nowUptime);
        this.mOptRecord.dump(pw, prefix, nowUptime);
        this.mWindowProcessController.dump(pw, prefix);
        return;
    L66:
        if (this.mIsolatedEntryPointArgs == null) goto L69;
    L59:
        if (this.mKilledByAm == true) goto L62;
        if (this.mWaitingToKill == null) goto L64;
    L48:
        if (this.mRemoved == false) goto L51;
        goto L49
    }

    ProcessRecord(ActivityManagerService _service, ApplicationInfo _info, String _processName, int _uid) {
        this(_service, _info, _processName, _uid, null, -1, null);
    }

    ProcessRecord(ActivityManagerService _service, ApplicationInfo _info, String _processName, int _uid, String _sdkSandboxClientAppPackage, int _definingUid, String _definingProcessName) {
        this.diedTime = 0;
        this.mPkgList = new PackageList(this);
        this.mBackgroundStartPrivileges = new ArrayMap();
        this.mBackgroundStartPrivilegesMerged = BackgroundStartPrivileges.NONE;
        this.mLinkedNodes = new OomAdjusterModernImpl.ProcessRecordNode[2];
        this.mMonitorEx = new ProcessRecordMonitorEx(this);
        this.mSmtEx = new ProcessRecordSmtBase(this);
        this.mService = _service;
        this.mProcLock = _service.mProcLock;
        this.info = _info;
        ProcessInfo procInfo = null;
        if (_service.mPackageManagerInt == null) goto L24;
        if (_definingUid <= 0) goto L10;
        ArrayMap<String, ProcessInfo> processes = _service.mPackageManagerInt.getProcessesForUid(_definingUid);
        if (processes == null) goto L13;
        procInfo = processes.get(_definingProcessName);
    L13:
        if (procInfo == null) goto L24;
        if (procInfo.deniedPermissions != null) goto L24;
        if (procInfo.gwpAsanMode != (-1)) goto L24;
        if (procInfo.memtagMode != (-1)) goto L24;
        if (procInfo.nativeHeapZeroInitialized != (-1)) goto L24;
        procInfo = null;
        goto L24
    L10:
        ArrayMap<String, ProcessInfo> processes2 = _service.mPackageManagerInt.getProcessesForUid(_uid);
        if (processes2 == null) goto L13;
        procInfo = processes2.get(_processName);
    L24:
        this.processInfo = procInfo;
        this.isolated = Process.isIsolated(_uid);
        this.isSdkSandbox = Process.isSdkSandboxUid(_uid);
        if (UserHandle.getAppId(_uid) >= 90000) goto L27;
    L29:
        boolean r1 = false;
    L30:
        this.appZygote = r1;
        this.uid = _uid;
        this.userId = UserHandle.getUserId(_uid);
        this.processName = _processName;
        this.sdkSandboxClientAppPackage = _sdkSandboxClientAppPackage;
        String r4 = null;
        if (this.isSdkSandbox == false) goto L37;
        ApplicationInfo clientInfo = getClientInfoForSdkSandbox();
        if (clientInfo == null) goto L36;
        r4 = clientInfo.volumeUuid;
    L36:
        this.sdkSandboxClientAppVolumeUuid = r4;
    L38:
        this.mPersistent = false;
        this.mRemoved = false;
        this.mProfile = new ProcessProfileRecord(this);
        this.mServices = new ProcessServiceRecord(this);
        this.mProviders = new ProcessProviderRecord(this);
        this.mReceivers = new ProcessReceiverRecord(this);
        this.mErrorState = new ProcessErrorStateRecord(this);
        this.mState = new ProcessStateRecord(this);
        this.mOptRecord = new ProcessCachedOptimizerRecord(this);
        long now = SystemClock.uptimeMillis();
        this.mProfile.init(now);
        this.mOptRecord.init(now);
        this.mState.init(now);
        this.mWindowProcessController = new WindowProcessController(this.mService.mActivityTaskManager, this.info, this.processName, this.uid, this.userId, this, this);
        this.mPkgList.put(_info.packageName, new ProcessStats.ProcessStateHolder(_info.longVersionCode));
        this.mSmtEx.isGphSwapSupported = SysOptBridge.getFactory().getAppRecordManagerService().isGameApp(this);
        this.mCrashPid = 0;
        this.sendSigChldTime = 0;
        updateProcessRecordNodes(this);
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
        return;
    L37:
        this.sdkSandboxClientAppVolumeUuid = null;
        goto L38
    L27:
        if (UserHandle.getAppId(_uid) > 98999) goto L29;
        r1 = true;
        goto L30
    }

    static void updateProcessRecordNodes(ProcessRecord app) {
        if (app.mService.mConstants.ENABLE_NEW_OOMADJ == false) goto L8;
        int i = 0;
    L6:
        if (i >= app.mLinkedNodes.length) goto L10;
        app.mLinkedNodes[i] = new OomAdjusterModernImpl.ProcessRecordNode(app);
        i = i + 1;
        goto L6
    L10:
        return;
    }

    void doEarlyCleanupIfNecessaryLocked() {
        if (getThread() != null) goto L6;
        this.mService.mOomAdjuster.onProcessEndLocked(this);
        return;
    }

    void resetCrashingOnRestart() {
        this.mErrorState.setCrashing(false);
    }

    UidRecord getUidRecord() {
        return this.mUidRecord;
    }

    void setUidRecord(UidRecord uidRecord) {
        this.mUidRecord = uidRecord;
    }

    PackageList getPkgList() {
        return this.mPkgList;
    }

    ArraySet<String> getPkgDeps() {
        return this.mPkgDeps;
    }

    void setPkgDeps(ArraySet<String> pkgDeps) {
        this.mPkgDeps = pkgDeps;
    }

    int getPid() {
        return this.mPid;
    }

    void setPid(int pid) {
        if (pid <= 0) goto L5;
        this.diedTime = 0;
        this.sendSigChldTime = 0;
    L5:
        if (pid != this.mPid) goto L7;
    L9:
        this.mPid = pid;
        this.mWindowProcessController.setPid(pid);
        this.mShortStringName = null;
        this.mStringName = null;
        Object r2 = this.mProfile.mProfilerLock;
        monitor-enter(r2);
        this.mProfile.setPid(pid);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        if (pid > 0) goto L15;
    L17:
        int pid2 = pid;
    L19:
        if (this.info == null) goto L21;
        SysOptBridge.getFactory().getProcLifeStats().setPid(this.info.uid, pid2, this.processName);
    L21:
        if (pid2 == 0) goto L23;
        return;
    L23:
        if (this.info == null) goto L38;
        this.info.getSysEx().doPrefetch = 0;
        return;
    L38:
        return;
    L15:
        if (this.info == null) goto L17;
        pid2 = pid;
        SysOptBridge.getFactory().getWarmStartPidCache().update(this.uid, this.processName, this.info.packageName, pid2, this.info.getSysEx().consistantsvp, this.mRenderThreadTid);
    L26:
        th = th;
    L34:
        throw th;
    L30:
        th = th;
        goto L34
    L7:
        if (this.mPid == 0) goto L9;
        setWasForceStopped(false);
        goto L9
    }

    int getSetAdj() {
        return this.mState.getSetAdj();
    }

    IApplicationThread getThread() {
        return this.mThread;
    }

    IApplicationThread getOnewayThread() {
        return this.mOnewayThread;
    }

    int getCurProcState() {
        return this.mState.getCurProcState();
    }

    int getSetProcState() {
        return this.mState.getSetProcState();
    }

    int getSetCapability() {
        return this.mState.getSetCapability();
    }

    public void makeActive(ApplicationThreadDeferred thread, ProcessStatsService tracker) {
        this.mProfile.onProcessActive(thread, tracker);
        this.mThread = thread;
        if (this.mPid != Process.myPid()) goto L5;
        this.mOnewayThread = new SameProcessApplicationThread(this.mThread, FgThread.getHandler());
    L6:
        this.mWindowProcessController.setThread(this.mThread);
        if (this.mWindowProcessController.useFifoUiScheduling() == false) goto L10;
        this.mService.mSpecifiedFifoProcesses.add(this);
        return;
    L10:
        return;
    L5:
        this.mOnewayThread = this.mThread;
        goto L6
    }

    public void makeInactive(ProcessStatsService tracker) {
        this.mThread = null;
        this.mOnewayThread = null;
        this.mWindowProcessController.setThread(null);
        if (this.mWindowProcessController.useFifoUiScheduling() == false) goto L5;
        this.mService.mSpecifiedFifoProcesses.remove(this);
    L5:
        this.mProfile.onProcessInactive(tracker);
    }

    boolean useFifoUiScheduling() {
        if (this.mService.mUseFifoUiScheduling == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mService.mAllowSpecifiedFifoScheduling == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mWindowProcessController.useFifoUiScheduling() == false) goto L9;
        goto L9
    }

    int getDyingPid() {
        return this.mDyingPid;
    }

    void setDyingPid(int dyingPid) {
        this.mDyingPid = dyingPid;
    }

    int[] getGids() {
        return this.mGids;
    }

    void setGids(int[] gids) {
        this.mGids = gids;
    }

    String getRequiredAbi() {
        return this.mRequiredAbi;
    }

    void setRequiredAbi(String requiredAbi) {
        this.mRequiredAbi = requiredAbi;
        this.mWindowProcessController.setRequiredAbi(requiredAbi);
    }

    String getInstructionSet() {
        return this.mInstructionSet;
    }

    void setInstructionSet(String instructionSet) {
        this.mInstructionSet = instructionSet;
    }

    void setPersistent(boolean persistent) {
        this.mPersistent = persistent;
        this.mWindowProcessController.setPersistent(persistent);
    }

    boolean isPersistent() {
        return this.mPersistent;
    }

    boolean isPendingStart() {
        return this.mPendingStart;
    }

    void setPendingStart(boolean pendingStart) {
        this.mPendingStart = pendingStart;
    }

    void setPendingFinishAttach(boolean pendingFinishAttach) {
        this.mPendingFinishAttach = pendingFinishAttach;
    }

    boolean isPendingFinishAttach() {
        return this.mPendingFinishAttach;
    }

    boolean isThreadReady() {
        if (this.mThread != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingFinishAttach == true) goto L7;
        return true;
    }

    long getStartSeq() {
        return this.mStartSeq;
    }

    void setStartSeq(long startSeq) {
        this.mStartSeq = startSeq;
    }

    HostingRecord getHostingRecord() {
        return this.mHostingRecord;
    }

    void setHostingRecord(HostingRecord hostingRecord) {
        this.mHostingRecord = hostingRecord;
    }

    String getSeInfo() {
        return this.mSeInfo;
    }

    void setSeInfo(String seInfo) {
        this.mSeInfo = seInfo;
    }

    long getStartUptime() {
        return this.mStartUptime;
    }

    @Deprecated
    long getStartTime() {
        return this.mStartUptime;
    }

    long getStartElapsedTime() {
        return this.mStartElapsedTime;
    }

    long getBindApplicationTime() {
        return this.mBindApplicationTime;
    }

    void setBindApplicationTime(long bindApplicationTime) {
        this.mBindApplicationTime = bindApplicationTime;
    }

    int getStartUid() {
        return this.mStartUid;
    }

    void setStartUid(int startUid) {
        this.mStartUid = startUid;
    }

    int getMountMode() {
        return this.mMountMode;
    }

    void setMountMode(int mountMode) {
        this.mMountMode = mountMode;
    }

    boolean isBindMountPending() {
        return this.mBindMountPending;
    }

    void setBindMountPending(boolean bindMountPending) {
        this.mBindMountPending = bindMountPending;
    }

    boolean isUnlocked() {
        return this.mUnlocked;
    }

    void setUnlocked(boolean unlocked) {
        this.mUnlocked = unlocked;
    }

    int getRenderThreadTid() {
        return this.mRenderThreadTid;
    }

    int[] getCommonPoolTids() {
        return this.mCommonPoolTids;
    }

    void setRenderThreadTid(int renderThreadTid, int[] commonPoolTids) {
        this.mRenderThreadTid = renderThreadTid;
        this.mCommonPoolTids = Arrays.copyOf(commonPoolTids, commonPoolTids.length);
        if (this.mPid > 0) goto L5;
        return;
    L5:
        if (this.info == null) goto L9;
        SysOptBridge.getFactory().getWarmStartPidCache().update(this.uid, this.processName, this.info.packageName, this.mPid, this.info.getSysEx().consistantsvp, this.mRenderThreadTid);
        return;
    }

    CompatibilityInfo getCompat() {
        return this.mCompat;
    }

    void setCompat(CompatibilityInfo compat) {
        this.mCompat = compat;
    }

    long[] getDisabledCompatChanges() {
        return this.mDisabledCompatChanges;
    }

    long[] getLoggableCompatChanges() {
        return this.mLoggableCompatChanges;
    }

    void setDisabledCompatChanges(long[] disabledCompatChanges) {
        this.mDisabledCompatChanges = disabledCompatChanges;
    }

    void setLoggableCompatChanges(long[] loggableCompatChanges) {
        this.mLoggableCompatChanges = loggableCompatChanges;
    }

    void unlinkDeathRecipient() {
        if (this.mDeathRecipient != null) goto L5;
    L7:
        this.mDeathRecipient = null;
        return;
    L5:
        if (this.mThread == null) goto L7;
        this.mThread.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
        goto L7
    }

    void setDeathRecipient(IBinder.DeathRecipient deathRecipient) {
        this.mDeathRecipient = deathRecipient;
    }

    IBinder.DeathRecipient getDeathRecipient() {
        return this.mDeathRecipient;
    }

    void setActiveInstrumentation(ActiveInstrumentation instr) {
        this.mInstr = instr;
        boolean r0 = false;
        if (instr == null) goto L5;
        boolean isInstrumenting = true;
    L6:
        WindowProcessController r3 = this.mWindowProcessController;
        if (isInstrumenting == false) goto L9;
        int r4 = instr.mSourceUid;
    L10:
        if (isInstrumenting == true) goto L12;
    L14:
        r3.setInstrumenting(isInstrumenting, r4, r0);
        return;
    L12:
        if (instr.mHasBackgroundActivityStartsPermission == false) goto L14;
        r0 = true;
        goto L14
    L9:
        r4 = -1;
        goto L10
    L5:
        isInstrumenting = false;
        goto L6
    }

    ActiveInstrumentation getActiveInstrumentation() {
        return this.mInstr;
    }

    boolean hasActiveInstrumentation() {
        if (this.mInstr == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isKilledByAm() {
        return this.mKilledByAm;
    }

    void setKilledByAm(boolean killedByAm) {
        this.mKilledByAm = killedByAm;
    }

    boolean isKilled() {
        return this.mKilled;
    }

    void setKilled(boolean killed) {
        this.mKilled = killed;
        if (killed == true) goto L5;
        return;
    L5:
        if (this.processName.equals(this.info.packageName) == true) goto L7;
        return;
    L7:
        if (ActivityManagerService.mUxPerf == null) goto L12;
        ActivityManagerService.mUxPerf.perfHint(4191, this.info.packageName, 0, 0);
        return;
    }

    long getKillTime() {
        return this.mKillTime;
    }

    void setKillTime(long killTime) {
        this.mKillTime = killTime;
    }

    String getWaitingToKill() {
        return this.mWaitingToKill;
    }

    void setWaitingToKill(String waitingToKill) {
        this.mWaitingToKill = waitingToKill;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public boolean isRemoved() {
        return this.mRemoved;
    }

    void setRemoved(boolean removed) {
        this.mRemoved = removed;
    }

    boolean isDebugging() {
        return this.mDebugging;
    }

    public ApplicationInfo getClientInfoForSdkSandbox() {
        if (this.isSdkSandbox == false) goto L9;
        if (this.sdkSandboxClientAppPackage == null) goto L9;
        PackageManagerInternal pm = this.mService.getPackageManagerInternal();
        return pm.getApplicationInfo(this.sdkSandboxClientAppPackage, 0, 1000, this.userId);
    L9:
        throw new IllegalStateException("getClientInfoForSdkSandbox called for non-sandbox process");
    }

    public boolean isDebuggable() {
        if ((this.info.flags & 2) == 0) goto L6;
        return true;
    L6:
        if (this.isSdkSandbox == false) goto L14;
        ApplicationInfo clientInfo = getClientInfoForSdkSandbox();
        if (clientInfo == null) goto L13;
        if ((clientInfo.flags & 2) == 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    void setDebugging(boolean debugging) {
        this.mDebugging = debugging;
        this.mWindowProcessController.setDebugging(debugging);
    }

    boolean hasWaitedForDebugger() {
        return this.mWaitedForDebugger;
    }

    void setWaitedForDebugger(boolean waitedForDebugger) {
        this.mWaitedForDebugger = waitedForDebugger;
    }

    long getLastActivityTime() {
        return this.mLastActivityTime;
    }

    void setLastActivityTime(long lastActivityTime) {
        this.mLastActivityTime = lastActivityTime;
    }

    boolean isUsingWrapper() {
        return this.mUsingWrapper;
    }

    void setUsingWrapper(boolean usingWrapper) {
        this.mUsingWrapper = usingWrapper;
        this.mWindowProcessController.setUsingWrapper(usingWrapper);
    }

    int getLruSeq() {
        return this.mLruSeq;
    }

    void setLruSeq(int lruSeq) {
        this.mLruSeq = lruSeq;
    }

    String getIsolatedEntryPoint() {
        return this.mIsolatedEntryPoint;
    }

    void setIsolatedEntryPoint(String isolatedEntryPoint) {
        this.mIsolatedEntryPoint = isolatedEntryPoint;
    }

    String[] getIsolatedEntryPointArgs() {
        return this.mIsolatedEntryPointArgs;
    }

    void setIsolatedEntryPointArgs(String[] isolatedEntryPointArgs) {
        this.mIsolatedEntryPointArgs = isolatedEntryPointArgs;
    }

    boolean isInFullBackup() {
        return this.mInFullBackup;
    }

    void setInFullBackup(boolean inFullBackup) {
        this.mInFullBackup = inFullBackup;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public boolean isCached() {
        return this.mState.isCached();
    }

    boolean hasActivities() {
        return this.mWindowProcessController.hasActivities();
    }

    boolean hasActivitiesOrRecentTasks() {
        return this.mWindowProcessController.hasActivitiesOrRecentTasks();
    }

    boolean hasRecentTasks() {
        return this.mWindowProcessController.hasRecentTasks();
    }

    public ApplicationInfo getApplicationInfo() {
        return this.info;
    }

    boolean onCleanupApplicationRecordLSP(ProcessStatsService processStats, boolean allowRestart, boolean unlinkDeath) {
        boolean freezing = getSmtEx().isFreezing();
        this.mErrorState.onCleanupApplicationRecordLSP();
        if (freezing == true) goto L9;
        resetPackageList(processStats);
        if (unlinkDeath == false) goto L7;
        unlinkDeathRecipient();
    L7:
        makeInactive(processStats);
        setWaitingToKill(null);
        this.mState.onCleanupApplicationRecordLSP();
        this.mService.mProcessStateController.onCleanupApplicationRecord(this.mServices);
        this.mReceivers.onCleanupApplicationRecordLocked();
        this.mService.mOomAdjuster.onProcessEndLocked(this);
    L9:
        return this.mProviders.onCleanupApplicationRecordLocked(allowRestart);
    }

    public boolean isInterestingToUserLocked() {
        if (this.mWindowProcessController.isInterestingToUser() == false) goto L7;
        return true;
    L7:
        return this.mServices.hasForegroundServices();
    }

    void scheduleCrashLocked(String message, int exceptionTypeId, Bundle extras) {
        if (this.mKilledByAm == false) goto L5;
        return;
    L5:
        if (this.mThread != null) goto L7;
        return;
    L7:
        if (this.mPid != Process.myPid()) goto L10;
        Slog.w(TAG, "scheduleCrash: trying to crash system process!");
        return;
    L10:
        long ident = Binder.clearCallingIdentity();
        this.mThread.scheduleCrash(message, exceptionTypeId, extras);     // Catch: Throwable -> L13 RemoteException -> L15
    L12:
        Binder.restoreCallingIdentity(ident);
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L16:
        killLocked("scheduleCrash for '" + message + "' failed", 4, true);     // Catch: Throwable -> L13
        goto L12
    }

    public long getRss(int pid) {
        long[] rss = Process.getRss(pid);
        if (rss != null) goto L5;
    L7:
        return 0;
    L5:
        if (rss.length <= 0) goto L7;
        return rss[0];
    }

    void killLocked(String reason, int reasonCode, boolean noisy) {
        killLocked(reason, reasonCode, 0, noisy, true);
    }

    void killLocked(String reason, int reasonCode, int subReason, boolean noisy) {
        killLocked(reason, reason, reasonCode, subReason, noisy, true);
    }

    void killLocked(String reason, String description, int reasonCode, int subReason, boolean noisy) {
        killLocked(reason, description, reasonCode, subReason, noisy, true);
    }

    void killLocked(String reason, int reasonCode, int subReason, boolean noisy, boolean asyncKPG) {
        killLocked(reason, reason, reasonCode, subReason, noisy, asyncKPG);
    }

    void killLocked(String reason, String description, int reasonCode, int subReason, boolean noisy, boolean asyncKPG) {
        if (this.mKilledByAm == true) goto L60;
        Trace.traceBegin(64, "kill");
        if (reasonCode != 6) goto L11;
        if (this.mErrorState.getAnrAnnotation() == null) goto L11;
        String description2 = description + ": " + this.mErrorState.getAnrAnnotation();
    L13:
        if (this.mService == null) goto L18;
        if (noisy == false) goto L16;
    L17:
        this.mService.reportUidInfoMessageLocked(TAG, "Killing " + toShortString() + " (adj " + this.mState.getSetAdj() + "): " + reason, this.info.uid);
        goto L18
    L16:
        if (this.info.uid == this.mService.mCurOomAdjUid) goto L17;
    L18:
        this.mOptRecord.setPendingFreeze(false);
        this.mOptRecord.setFrozen(false);
        if (this.mPid <= 0) goto L21;
        int r0 = this.mPid;
    L22:
        int _pid = r0;
        if (_pid <= 0) goto L25;
        this.mService.mProcessList.noteAppKill(this, reasonCode, subReason, description2);
        EventLog.writeEvent(EventLogTags.AM_KILL, new Object[]{Integer.valueOf(this.userId), Integer.valueOf(_pid), this.processName, Integer.valueOf(this.mState.getSetAdj()), reason, Long.valueOf(getRss(_pid))});
        Process.killProcessQuiet(_pid);
        killProcessGroupIfNecessaryLocked(asyncKPG);
        getSmtEx().reportKillingEvent(reason);
    L27:
        if (this.mPersistent == true) goto L39;
        ActivityManagerGlobalLock r2 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r2);
        this.mKilled = true;     // Catch: Throwable -> L34
        this.mKilledByAm = true;     // Catch: Throwable -> L34
        this.mKillTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
        monitor-exit(r2);     // Catch: Throwable -> L34
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L34:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L39:
        if (ActivityManagerService.mUxPerf != null) goto L41;
    L52:
        ActivityManagerService.mForceStopKill = false;
    L54:
        if (ActivityManagerService.mUxPerf != null) goto L56;
    L58:
        Trace.traceEnd(64);
        return;
    L56:
        if (this.processName.equals(this.info.packageName) == false) goto L58;
        ActivityManagerService.mUxPerf.perfHint(4191, this.info.packageName, 0, 0);
        goto L58
    L41:
        if (ActivityManagerService.mForceStopKill == true) goto L52;
        if (this.mErrorState.isNotResponding() == true) goto L52;
        if (this.mErrorState.isCrashing() == true) goto L52;
        if (ActivityManagerService.mUxPerf.board_first_api_lvl < 33) goto L49;
    L51:
        ActivityManagerService.mUxPerf.perfEvent(4243, this.processName, 2, new int[]{0, getPid()});
        goto L54
    L49:
        if (ActivityManagerService.mUxPerf.board_api_lvl >= 33) goto L51;
        ActivityManagerService.mUxPerf.perfUXEngine_events(4, 0, this.processName, 0);
        goto L51
    L25:
        this.mPendingStart = false;
        goto L27
    L21:
        r0 = getSmtEx().pid;
    L11:
        description2 = description;
        goto L13
    }

    void killProcessGroupIfNecessaryLocked(boolean async) {
        if (this.mPid <= 0) goto L5;
        int _pid = this.mPid;
    L7:
        if (this.mHostingRecord != null) goto L9;
    L22:
        boolean killProcessGroup = true;
    L23:
        if (killProcessGroup == true) goto L25;
        return;
    L25:
        if (this.mErrorState.isCrashing() == false) goto L27;
        SysMonitorFwBridge.getFactory().getStabUtil().checkHprofProcess(this.uid, _pid);
    L27:
        if (async == true) goto L29;
        Process.sendSignalToProcessGroup(this.uid, _pid, OsConstants.SIGKILL);
    L29:
        ProcessList.killProcessGroup(this.uid, _pid);
        return;
    L9:
        if (this.mHostingRecord.usesWebviewZygote() == false) goto L11;
    L12:
        monitor-enter(this);
        killProcessGroup = this.mProcessGroupCreated;     // Catch: Throwable -> L16
        if (killProcessGroup == true) goto L18;
        this.mSkipProcessGroupCreation = true;     // Catch: Throwable -> L16
    L18:
        monitor-exit(this);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L11:
        if (this.mHostingRecord.usesAppZygote() == false) goto L22;
    L5:
        _pid = getSmtEx().pid;
        goto L7
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        dumpDebug(proto, fieldId, -1);
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId, int lruIndex) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.mPid);
        proto.write(1138166333442L, this.processName);
        proto.write(1120986464259L, this.info.uid);
        if (UserHandle.getAppId(this.info.uid) < 10000) goto L6;
        proto.write(1120986464260L, this.userId);
        proto.write(1120986464261L, UserHandle.getAppId(this.info.uid));
    L6:
        if (this.uid == this.info.uid) goto L8;
        proto.write(1120986464262L, UserHandle.getAppId(this.uid));
    L8:
        proto.write(1133871366151L, this.mPersistent);
        if (lruIndex < 0) goto L11;
        proto.write(1120986464264L, lruIndex);
    L11:
        proto.end(token);
    }

    public String toShortString() {
        String shortStringName = this.mShortStringName;
        if (shortStringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        toShortString(sb);
        this.mShortStringName = sb.toString();
        return this.mShortStringName + ' ' + getSmtEx();
    L5:
        return shortStringName + ' ' + getSmtEx();
    }

    void toShortString(StringBuilder sb) {
        sb.append(this.mPid);
        sb.append(':');
        sb.append(this.processName);
        sb.append('/');
        if (this.info.uid >= 10000) goto L5;
        sb.append(this.uid);
        return;
    L5:
        sb.append('u');
        sb.append(this.userId);
        int appId = UserHandle.getAppId(this.info.uid);
        if (appId < 10000) goto L8;
        sb.append('a');
        sb.append(appId + ProcessList.INVALID_ADJ);
    L10:
        if (this.uid == this.info.uid) goto L14;
        sb.append('i');
        sb.append(UserHandle.getAppId(this.uid) - 99000);
        return;
    L14:
        return;
    L8:
        sb.append('s');
        sb.append(appId);
        goto L10
    }

    public String toString() {
        String stringName = this.mStringName;
        if (stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("ProcessRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        toShortString(sb);
        this.mStringName = sb.toString();
        return this.mStringName + " " + getSmtEx() + "}";
    L5:
        return stringName + " " + getSmtEx() + "}";
    }

    String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        dump(pw, "  ");
        sb.append(sw);
        return sb.toString();
    }

    public boolean addPackage(String pkg, long versionCode, ProcessStatsService tracker) {
        Object r1 = tracker.mLock;
        monitor-enter(r1);
        PackageList r2 = this.mPkgList;     // Catch: Throwable -> L33
        monitor-enter(r2);     // Catch: Throwable -> L33
    L17:
        th = move-exception;
        Throwable r11 = th;
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L15
        throw r11;     // Catch: Throwable -> L24
    L7:
        if (this.mPkgList.containsKey(pkg) == true) goto L27;
        ProcessStats.ProcessStateHolder holder = new ProcessStats.ProcessStateHolder(versionCode);     // Catch: Throwable -> L17
        ProcessState baseProcessTracker = this.mProfile.getBaseProcessTracker();     // Catch: Throwable -> L17
        if (baseProcessTracker == null) goto L19;
        tracker.updateProcessStateHolderLocked(holder, pkg, this.info.uid, versionCode, this.processName);     // Catch: Throwable -> L15
        this.mPkgList.put(pkg, holder);     // Catch: Throwable -> L15
        if (holder.state == baseProcessTracker) goto L20;
        holder.state.makeActive();     // Catch: Throwable -> L15
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L24
        return true;
    L19:
        this.mPkgList.put(pkg, holder);     // Catch: Throwable -> L15
        goto L20
    L27:
        monitor-exit(r2);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L24
        return false;
    L15:
        th = move-exception;
        r11 = th;
    L33:
        th = move-exception;
        Throwable r12 = th;
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw r12;
    L24:
        th = move-exception;
        r12 = th;
        goto L35
    }

    void onProcessFrozen() {
        this.mProfile.onProcessFrozen();
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ApplicationThreadDeferred t = this.mThread;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (t == null) goto L16;
        t.onProcessPaused();
        return;
    L16:
        return;
    L10:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onProcessUnfrozen() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ApplicationThreadDeferred t = this.mThread;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (t == null) goto L9;
        t.onProcessUnpaused();
    L9:
        this.mProfile.onProcessUnfrozen();
        this.mServices.onProcessUnfrozen();
        return;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void onProcessFrozenCancelled() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ApplicationThreadDeferred t = this.mThread;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (t == null) goto L9;
        t.onProcessPausedCancelled();
    L9:
        this.mServices.onProcessFrozenCancelled();
        return;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public void resetPackageList(ProcessStatsService tracker) {
        Object r8 = tracker.mLock;
        monitor-enter(r8);
        final ProcessState baseProcessTracker = this.mProfile.getBaseProcessTracker();     // Catch: Throwable -> L25
        PackageList r9 = this.mPkgList;     // Catch: Throwable -> L25
        monitor-enter(r9);     // Catch: Throwable -> L25
        int numOfPkgs = this.mPkgList.size();     // Catch: Throwable -> L17
        if (baseProcessTracker == null) goto L20;
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        baseProcessTracker.setState(-1, tracker.getMemFactorLocked(), now, this.mPkgList.getPackageListLocked());     // Catch: Throwable -> L17
        if (numOfPkgs == 1) goto L22;
        this.mPkgList.forEachPackageProcessStats(new ProcessRecord$$ExternalSyntheticLambda0(baseProcessTracker));     // Catch: Throwable -> L14
        this.mPkgList.clear();     // Catch: Throwable -> L14
        ProcessStats.ProcessStateHolder holder = new ProcessStats.ProcessStateHolder(this.info.longVersionCode);     // Catch: Throwable -> L14
        tracker.updateProcessStateHolderLocked(holder, this.info.packageName, this.info.uid, this.info.longVersionCode, this.processName);     // Catch: Throwable -> L14
        this.mPkgList.put(this.info.packageName, holder);     // Catch: Throwable -> L14
        if (holder.state == baseProcessTracker) goto L22;
        holder.state.makeActive();     // Catch: Throwable -> L14
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L25
        return;
    L20:
        if (numOfPkgs == 1) goto L22;
        this.mPkgList.clear();     // Catch: Throwable -> L14
        this.mPkgList.put(this.info.packageName, new ProcessStats.ProcessStateHolder(this.info.longVersionCode));     // Catch: Throwable -> L14
    L17:
        th = th;
    L27:
        monitor-exit(r9);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L25
    L14:
        th = th;
    L25:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$resetPackageList$0(ProcessState baseProcessTracker, ProcessStats.ProcessStateHolder holder) {
        if (holder.state != null) goto L5;
        return;
    L5:
        if (holder.state == baseProcessTracker) goto L9;
        holder.state.makeInactive();
        return;
    }

    String[] getPackageList() {
        return this.mPkgList.getPackageList();
    }

    List<VersionedPackage> getPackageListWithVersionCode() {
        return this.mPkgList.getPackageListWithVersionCode();
    }

    WindowProcessController getWindowProcessController() {
        return this.mWindowProcessController;
    }

    void addOrUpdateBackgroundStartPrivileges(Binder entity, BackgroundStartPrivileges backgroundStartPrivileges) {
        entity.getClass();
        backgroundStartPrivileges.getClass();
        Preconditions.checkArgument(backgroundStartPrivileges.allowsAny(), "backgroundStartPrivileges does not allow anything");
        this.mWindowProcessController.addOrUpdateBackgroundStartPrivileges(entity, backgroundStartPrivileges);
        setBackgroundStartPrivileges(entity, backgroundStartPrivileges);
    }

    void removeBackgroundStartPrivileges(Binder entity) {
        entity.getClass();
        this.mWindowProcessController.removeBackgroundStartPrivileges(entity);
        setBackgroundStartPrivileges(entity, null);
    }

    BackgroundStartPrivileges getBackgroundStartPrivileges() {
        ArrayMap<Binder, BackgroundStartPrivileges> r0 = this.mBackgroundStartPrivileges;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mBackgroundStartPrivilegesMerged != null) goto L11;
        this.mBackgroundStartPrivilegesMerged = BackgroundStartPrivileges.NONE;     // Catch: Throwable -> L9
        int i = this.mBackgroundStartPrivileges.size() - 1;     // Catch: Throwable -> L9
    L7:
        if (i < 0) goto L11;
        this.mBackgroundStartPrivilegesMerged = this.mBackgroundStartPrivilegesMerged.merge(this.mBackgroundStartPrivileges.valueAt(i));     // Catch: Throwable -> L9
        i = i - 1;     // Catch: Throwable -> L9
    L11:
        BackgroundStartPrivileges r1 = this.mBackgroundStartPrivilegesMerged;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    private void setBackgroundStartPrivileges(Binder entity, BackgroundStartPrivileges backgroundStartPrivileges) {
        ArrayMap<Binder, BackgroundStartPrivileges> r0 = this.mBackgroundStartPrivileges;
        monitor-enter(r0);
        boolean changed = false;
        if (backgroundStartPrivileges == null) goto L7;
        BackgroundStartPrivileges oldBsp = this.mBackgroundStartPrivileges.put(entity, backgroundStartPrivileges);     // Catch: Throwable -> L10
        if (backgroundStartPrivileges == oldBsp) goto L15;
        changed = true;
    L15:
        if (changed == false) goto L17;
        this.mBackgroundStartPrivilegesMerged = null;     // Catch: Throwable -> L10
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        if (this.mBackgroundStartPrivileges.remove(entity) == null) goto L15;
        changed = true;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void clearProfilerIfNeeded() {
        Object r0 = this.mService.mAppProfiler.mProfilerLock;
        monitor-enter(r0);
        this.mService.mAppProfiler.clearProfilerLPf();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void updateServiceConnectionActivities() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mServices.updateServiceConnectionActivitiesLocked(this.mServices);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void setPendingUiClean(boolean pendingUiClean) {
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        this.mProfile.setPendingUiClean(pendingUiClean);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void setPendingUiCleanAndForceProcessStateUpTo(int newState) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        setPendingUiClean(true);     // Catch: Throwable -> L9
        this.mState.forceProcessStateUpTo(newState);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void updateProcessInfo(boolean updateServiceConnectionActivities, boolean activityChange, boolean updateOomAdj) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        if (updateServiceConnectionActivities == false) goto L9;
        this.mService.mServices.updateServiceConnectionActivitiesLocked(this.mServices);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L9:
        if (this.mThread != null) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L6
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L13:
        this.mService.updateLruProcessLocked(this, activityChange, null);     // Catch: Throwable -> L6
        if (updateOomAdj == false) goto L16;
        this.mService.updateOomAdjLocked(this, 1);     // Catch: Throwable -> L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L6
        ActivityManagerService.resetPriorityAfterLockedSection();
    }

    @Override // com.android.server.wm.WindowProcessListener
    public long getCpuTime() {
        return this.mService.mAppProfiler.getCpuTimeForPid(this.mPid);
    }

    public long getCpuDelayTime() {
        return this.mService.mAppProfiler.getCpuDelayTimeForPid(this.mPid);
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void onStartActivity(int topProcessState, boolean setProfileProc, String packageName, long versionCode) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mWaitingToKill = null;     // Catch: Throwable -> L15
        if (setProfileProc == false) goto L18;
        Object r1 = this.mService.mAppProfiler.mProfilerLock;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        this.mService.mAppProfiler.setProfileProcLPf(this);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L18:
        if (packageName == null) goto L24;
        addPackage(packageName, versionCode, this.mService.mProcessStats);     // Catch: Throwable -> L15
        if (ActivityManagerService.mUxPerf == null) goto L24;
        if (this.processName.equals(packageName) == false) goto L24;
        ActivityManagerService.mUxPerf.perfHint(4190, packageName, 0, 0);     // Catch: Throwable -> L15
    L24:
        updateProcessInfo(false, true, true);     // Catch: Throwable -> L15
        setPendingUiClean(true);     // Catch: Throwable -> L15
        this.mService.mProcessStateController.setHasShownUi(this, true);     // Catch: Throwable -> L15
        this.mState.forceProcessStateUpTo(topProcessState);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L15:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void appDied(String reason) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.appDiedLocked(this, reason);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public void setRunningRemoteAnimation(boolean runningRemoteAnimation) {
        if (this.mPid != Process.myPid()) goto L6;
        Slog.wtf(TAG, "system can't run remote animation");
        return;
    L6:
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L9:
        if (this.mService.mProcessStateController.setRunningRemoteAnimation(this, runningRemoteAnimation) == false) goto L13;
        this.mService.mProcessStateController.runUpdate(this, 9);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
    }

    public long getInputDispatchingTimeoutMillis() {
        return this.mWindowProcessController.getInputDispatchingTimeoutMillis();
    }

    public int getProcessClassEnum() {
        if (this.mPid != ActivityManagerService.MY_PID) goto L7;
        return 3;
    L7:
        if (this.info != null) goto L11;
        return 0;
    L11:
        if ((this.info.flags & 1) == 0) goto L15;
        return 2;
    L15:
        return 1;
    }

    List<ProcessRecord> getLruProcessList() {
        return this.mService.mProcessList.getLruProcessesLOSP();
    }

    public void setWasForceStopped(boolean stopped) {
        this.mWasForceStopped = stopped;
    }

    public boolean wasForceStopped() {
        return this.mWasForceStopped;
    }

    boolean isFreezable() {
        if (this.mService.mOomAdjuster.mCachedAppOptimizer.useFreezer() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mOptRecord.isFreezeExempt() == true) goto L11;
        if (this.mOptRecord.shouldNotFreeze() == true) goto L11;
        if (this.mState.getCurAdj() < this.mService.mConstants.FREEZER_CUTOFF_ADJ) goto L11;
        return true;
    }

    public ApplicationInfo getAppInfo() {
        return this.info;
    }

    public int getUid() {
        return this.uid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public ActiveInstrumentation getInstrumentation() {
        return this.mInstr;
    }

    public WindowProcessController getWindowProcessControllerLM() {
        return this.mWindowProcessController;
    }

    public void forEachConnectionHost(Consumer<ProcessRecord> consumer) {
        int i = this.mServices.numberOfConnections() - 1;
    L3:
        if (i < 0) goto L5;
        ConnectionRecord cr = this.mServices.getConnectionAt(i);
        ProcessRecord service = cr.binding.service.app;
        consumer.accept(service);
        i = i - 1;
        goto L3
    L5:
        int i2 = this.mServices.numberOfSdkSandboxConnections() - 1;
    L6:
        if (i2 < 0) goto L8;
        ConnectionRecord cr2 = this.mServices.getSdkSandboxConnectionAt(i2);
        ProcessRecord service2 = cr2.binding.service.app;
        consumer.accept(service2);
        i2 = i2 - 1;
        goto L6
    L8:
        int i3 = this.mProviders.numberOfProviderConnections() - 1;
    L9:
        if (i3 < 0) goto L12;
        ContentProviderConnection cpc = this.mProviders.getProviderConnectionAt(i3);
        ProcessRecord provider = cpc.provider.proc;
        consumer.accept(provider);
        i3 = i3 - 1;
        goto L9
    }

    public void notifyAppNotResponding(String reason) {
        TimeoutRecord timeoutRecord = TimeoutRecord.forApp(reason);
        this.mService.appNotResponding(this, timeoutRecord);
    }

    public ProcessRecordMonitorEx getMonitorEx() {
        return this.mMonitorEx;
    }

    @Override // com.android.server.wm.WindowProcessListener
    public ProcessRecordSmtBase getSmtEx() {
        return this.mSmtEx;
    }

    public void setShortStringName(String shortStringName) {
        this.mShortStringName = shortStringName;
    }

    public void setStringName(String stringName) {
        this.mStringName = stringName;
    }

    void setThread(IApplicationThread thread) {
        this.mThread = (ApplicationThreadDeferred) thread;
    }

    public boolean checkProcessStatus(IAppStatus status) {
        return this.mService.getSmtEx().getProcessStatusChecker().check(this, status);
    }

    public void notifyWindowsDrawn(int startType) {
        getThread().notifyWindowsDrawn(startType);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void notifyTransitStatusChanged(int transitOptStatus, int duration) {
        getThread().notifyTransitStatusChanged(transitOptStatus, duration);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setAppAnimationLeakDetect(boolean enable, long windowTime, int maxCount, int continuousCount) {
    L10:
        e = move-exception;
        RemoteException e = e;
    L14:
        Slog.e(TAG, "setAppAnimationLeakDetect!", e);
        return;
    L3:
        if (getThread() == null) goto L20;
        getThread().setAppAnimationLeakDetect(enable, windowTime, maxCount, continuousCount);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e = e;
        goto L14
    }

    public void setActivityAnimationLeakDetect(boolean enable, String activityName, long windowTime, int maxCount, int continuousCount) {
    L10:
        e = move-exception;
        RemoteException e = e;
    L14:
        Slog.e(TAG, "setActivityAnimationLeakDetect!", e);
        return;
    L3:
        if (getThread() == null) goto L20;
        getThread().setActivityAnimationLeakDetect(enable, activityName, windowTime, maxCount, continuousCount);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e = e;
        goto L14
    }

    public void setAppHandlerLeakDetect(boolean enable, long windowTime, int maxCount, int continuousCount) {
    L10:
        e = move-exception;
        RemoteException e = e;
    L14:
        Slog.e(TAG, "setAppHandlerLeakDetect!", e);
        return;
    L3:
        if (getThread() == null) goto L20;
        getThread().setAppHandlerLeakDetect(enable, windowTime, maxCount, continuousCount);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e = e;
        goto L14
    }

    public void setViewVsyncScene(Bundle bundle) {
    L6:
        e = move-exception;
        Slog.e(TAG, "setViewVsyncScene!", e);
        return;
    L3:
        if (getThread() == null) goto L13;
        getThread().setViewVsyncScene(bundle);     // Catch: RemoteException -> L6
        return;
    }
}
