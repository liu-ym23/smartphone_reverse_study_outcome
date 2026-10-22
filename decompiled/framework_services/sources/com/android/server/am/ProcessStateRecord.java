package com.android.server.am;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.SystemClock;
import android.util.TimeUtils;
import com.android.server.wm.WindowProcessController;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class ProcessStateRecord {
    private static final boolean TRACE_OOM_ADJ = false;
    private static final int VALUE_FALSE = 0;
    private static final int VALUE_INVALID = -1;
    private static final int VALUE_TRUE = 1;
    private int mAdjSeq;
    private Object mAdjSource;
    private int mAdjSourceProcState;
    private Object mAdjTarget;
    private String mAdjType;
    private int mAdjTypeCode;
    private final ProcessRecord mApp;
    private boolean mBackgroundRestricted;
    private long mCacheOomRankerRss;
    private long mCacheOomRankerRssTimeMs;
    private int mCacheOomRankerUseCount;
    private int mCachedAdj;
    private String mCachedAdjType;
    private int[] mCachedCompatChanges;
    private boolean mCachedForegroundActivities;
    private int mCachedHasActivities;
    private int mCachedHasRecentTasks;
    private int mCachedHasVisibleActivities;
    private int mCachedIsHeavyWeight;
    private int mCachedIsHomeProcess;
    private int mCachedIsPreviousProcess;
    private int mCachedIsReceivingBroadcast;
    private int mCachedProcState;
    private int mCachedSchedGroup;
    private int mCompletedAdjSeq;
    private boolean mContainsCycle;
    private int mCurAdj;
    private boolean mCurBoundByNonBgRestrictedApp;
    private int mCurCapability;
    private int mCurProcState;
    private int mCurRawAdj;
    private int mCurRawProcState;
    private int mCurSchedGroup;
    private long mFgInteractionTime;
    private long mFollowupUpdateUptimeMs;
    private Object mForcingToImportant;
    private boolean mHasForegroundActivities;
    private boolean mHasOverlayUi;
    private boolean mHasShownUi;
    private boolean mHasStartedServices;
    private boolean mHasTopUi;
    private long mInteractionEventTime;
    private long mLastCanKillOnBgRestrictedAndIdleTime;
    private long mLastInvisibleTime;
    private long mLastStateTime;
    private long mLastTopTime;
    private int mMaxAdj;
    private boolean mNoKillOnBgRestrictedAndIdle;
    private boolean mNotCachedSinceIdle;
    private final ActivityManagerGlobalLock mProcLock;
    private boolean mProcStateChanged;
    private boolean mReachable;
    private boolean mRepForegroundActivities;
    private int mRepProcState;
    private boolean mReportedInteraction;
    private boolean mRunningRemoteAnimation;
    private int mSavedPriority;
    private boolean mScheduleLikeTopApp;
    private final ActivityManagerService mService;
    private boolean mServiceB;
    private boolean mServiceHighRam;
    private int mSetAdj;
    private boolean mSetBoundByNonBgRestrictedApp;
    private boolean mSetCached;
    private int mSetCapability;
    private boolean mSetNoKillOnBgRestrictedAndIdle;
    private int mSetProcState;
    private int mSetRawAdj;
    private int mSetSchedGroup;
    private boolean mSystemNoUi;
    private int mVerifiedAdj;
    private long mWhenUnimportant;

    ProcessStateRecord(ProcessRecord app) {
        this.mMaxAdj = 1001;
        this.mCurRawAdj = ProcessList.INVALID_ADJ;
        this.mSetRawAdj = ProcessList.INVALID_ADJ;
        this.mCurAdj = ProcessList.INVALID_ADJ;
        this.mSetAdj = ProcessList.INVALID_ADJ;
        this.mVerifiedAdj = ProcessList.INVALID_ADJ;
        this.mCurCapability = 0;
        this.mSetCapability = 0;
        this.mCurSchedGroup = 0;
        this.mSetSchedGroup = 0;
        this.mCurProcState = 20;
        this.mRepProcState = 20;
        this.mCurRawProcState = 20;
        this.mSetProcState = 20;
        this.mLastTopTime = Long.MIN_VALUE;
        this.mBackgroundRestricted = false;
        this.mCurBoundByNonBgRestrictedApp = false;
        this.mSetBoundByNonBgRestrictedApp = false;
        this.mCachedHasActivities = -1;
        this.mCachedIsHeavyWeight = -1;
        this.mCachedHasVisibleActivities = -1;
        this.mCachedIsHomeProcess = -1;
        this.mCachedIsPreviousProcess = -1;
        this.mCachedHasRecentTasks = -1;
        this.mCachedIsReceivingBroadcast = -1;
        this.mCachedCompatChanges = new int[]{-1, -1, -1};
        this.mCachedAdjType = null;
        this.mCachedAdj = ProcessList.INVALID_ADJ;
        this.mCachedForegroundActivities = false;
        this.mCachedProcState = 19;
        this.mCachedSchedGroup = 0;
        this.mScheduleLikeTopApp = false;
        this.mFollowupUpdateUptimeMs = Long.MAX_VALUE;
        this.mApp = app;
        this.mService = app.mService;
        this.mProcLock = this.mService.mProcLock;
    }

    void init(long now) {
        this.mLastStateTime = now;
    }

    void setMaxAdj(int maxAdj) {
        this.mMaxAdj = maxAdj;
    }

    int getMaxAdj() {
        return this.mMaxAdj;
    }

    void setCurRawAdj(int curRawAdj) {
        setCurRawAdj(curRawAdj, false);
    }

    boolean setCurRawAdj(int curRawAdj, boolean dryRun) {
        boolean r0 = true;
        if (dryRun == true) goto L5;
        this.mCurRawAdj = curRawAdj;
        WindowProcessController r2 = this.mApp.getWindowProcessController();
        if (curRawAdj <= 200) goto L13;
        r0 = false;
    L13:
        r2.setPerceptible(r0);
        return false;
    L5:
        if (this.mCurRawAdj <= curRawAdj) goto L8;
        return true;
    L8:
        return false;
    }

    int getCurRawAdj() {
        return this.mCurRawAdj;
    }

    void setSetRawAdj(int setRawAdj) {
        this.mSetRawAdj = setRawAdj;
    }

    int getSetRawAdj() {
        return this.mSetRawAdj;
    }

    void setCurAdj(int curAdj) {
        this.mCurAdj = curAdj;
        this.mApp.getWindowProcessController().setCurrentAdj(curAdj);
    }

    int getCurAdj() {
        return this.mCurAdj;
    }

    void setSetAdj(int setAdj) {
        this.mSetAdj = setAdj;
    }

    int getSetAdj() {
        return this.mSetAdj;
    }

    int getSetAdjWithServices() {
        if (this.mSetAdj < 900) goto L9;
        if (this.mHasStartedServices == false) goto L9;
        return 800;
    L9:
        return this.mSetAdj;
    }

    void setVerifiedAdj(int verifiedAdj) {
        this.mVerifiedAdj = verifiedAdj;
    }

    int getVerifiedAdj() {
        return this.mVerifiedAdj;
    }

    void setCurCapability(int curCapability) {
        this.mCurCapability = curCapability;
    }

    int getCurCapability() {
        return this.mCurCapability;
    }

    void setSetCapability(int setCapability) {
        this.mSetCapability = setCapability;
    }

    int getSetCapability() {
        return this.mSetCapability;
    }

    void setCurrentSchedulingGroup(int curSchedGroup) {
        this.mCurSchedGroup = curSchedGroup;
        this.mApp.getWindowProcessController().setCurrentSchedulingGroup(curSchedGroup);
    }

    int getCurrentSchedulingGroup() {
        return this.mCurSchedGroup;
    }

    void setSetSchedGroup(int setSchedGroup) {
        this.mSetSchedGroup = setSchedGroup;
    }

    int getSetSchedGroup() {
        return this.mSetSchedGroup;
    }

    void setCurProcState(int curProcState) {
        this.mCurProcState = curProcState;
        this.mApp.getWindowProcessController().setCurrentProcState(this.mCurProcState);
    }

    int getCurProcState() {
        return this.mCurProcState;
    }

    void setCurRawProcState(int curRawProcState) {
        setCurRawProcState(curRawProcState, false);
    }

    boolean setCurRawProcState(int curRawProcState, boolean dryRun) {
        if (dryRun == true) goto L5;
        this.mCurRawProcState = curRawProcState;
        return false;
    L5:
        if (this.mCurRawProcState <= curRawProcState) goto L10;
        return true;
    L10:
        return false;
    }

    int getCurRawProcState() {
        return this.mCurRawProcState;
    }

    void setReportedProcState(int repProcState) {
        this.mRepProcState = repProcState;
        this.mApp.getWindowProcessController().setReportedProcState(repProcState);
    }

    int getReportedProcState() {
        return this.mRepProcState;
    }

    void forceProcessStateUpTo(int newState) {
        if (this.mRepProcState <= newState) goto L13;
        ActivityManagerGlobalLock r0 = this.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r0);
        int prevProcState = this.mRepProcState;     // Catch: Throwable -> L9
        setReportedProcState(newState);     // Catch: Throwable -> L9
        setCurProcState(newState);     // Catch: Throwable -> L9
        setCurRawProcState(newState);     // Catch: Throwable -> L9
        this.mService.mOomAdjuster.onProcessStateChanged(this.mApp, prevProcState);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    void setSetProcState(int setProcState) {
        if (ActivityManager.isProcStateCached(this.mSetProcState) == true) goto L5;
    L7:
        this.mSetProcState = setProcState;
        return;
    L5:
        if (ActivityManager.isProcStateCached(setProcState) == true) goto L7;
        this.mCacheOomRankerUseCount++;
        goto L7
    }

    int getSetProcState() {
        return this.mSetProcState;
    }

    void setLastStateTime(long lastStateTime) {
        this.mLastStateTime = lastStateTime;
    }

    long getLastStateTime() {
        return this.mLastStateTime;
    }

    void setSavedPriority(int savedPriority) {
        this.mSavedPriority = savedPriority;
    }

    int getSavedPriority() {
        return this.mSavedPriority;
    }

    void setServiceB(boolean serviceb) {
        this.mServiceB = serviceb;
    }

    boolean isServiceB() {
        return this.mServiceB;
    }

    void setServiceHighRam(boolean serviceHighRam) {
        this.mServiceHighRam = serviceHighRam;
    }

    boolean isServiceHighRam() {
        return this.mServiceHighRam;
    }

    void setNotCachedSinceIdle(boolean notCachedSinceIdle) {
        this.mNotCachedSinceIdle = notCachedSinceIdle;
    }

    boolean isNotCachedSinceIdle() {
        return this.mNotCachedSinceIdle;
    }

    void setHasStartedServices(boolean hasStartedServices) {
        this.mHasStartedServices = hasStartedServices;
        if (hasStartedServices == false) goto L5;
        this.mApp.mProfile.addHostingComponentType(128);
        return;
    L5:
        this.mApp.mProfile.clearHostingComponentType(128);
    }

    boolean hasStartedServices() {
        return this.mHasStartedServices;
    }

    void setHasForegroundActivities(boolean hasForegroundActivities) {
        this.mHasForegroundActivities = hasForegroundActivities;
    }

    boolean hasForegroundActivities() {
        return this.mHasForegroundActivities;
    }

    void setRepForegroundActivities(boolean repForegroundActivities) {
        this.mRepForegroundActivities = repForegroundActivities;
    }

    boolean hasRepForegroundActivities() {
        return this.mRepForegroundActivities;
    }

    void setHasShownUi(boolean hasShownUi) {
        this.mHasShownUi = hasShownUi;
    }

    boolean hasShownUi() {
        return this.mHasShownUi;
    }

    void setHasTopUi(boolean hasTopUi) {
        this.mHasTopUi = hasTopUi;
        this.mApp.getWindowProcessController().setHasTopUi(hasTopUi);
    }

    boolean hasTopUi() {
        return this.mHasTopUi;
    }

    void setHasOverlayUi(boolean hasOverlayUi) {
        this.mHasOverlayUi = hasOverlayUi;
        this.mApp.getWindowProcessController().setHasOverlayUi(hasOverlayUi);
    }

    boolean hasOverlayUi() {
        return this.mHasOverlayUi;
    }

    boolean isRunningRemoteAnimation() {
        return this.mRunningRemoteAnimation;
    }

    void setRunningRemoteAnimation(boolean runningRemoteAnimation) {
        this.mRunningRemoteAnimation = runningRemoteAnimation;
    }

    void setProcStateChanged(boolean procStateChanged) {
        this.mProcStateChanged = procStateChanged;
    }

    boolean hasProcStateChanged() {
        return this.mProcStateChanged;
    }

    void setReportedInteraction(boolean reportedInteraction) {
        this.mReportedInteraction = reportedInteraction;
    }

    boolean hasReportedInteraction() {
        return this.mReportedInteraction;
    }

    void setInteractionEventTime(long interactionEventTime) {
        this.mInteractionEventTime = interactionEventTime;
        this.mApp.getWindowProcessController().setInteractionEventTime(interactionEventTime);
    }

    long getInteractionEventTime() {
        return this.mInteractionEventTime;
    }

    void setFgInteractionTime(long fgInteractionTime) {
        this.mFgInteractionTime = fgInteractionTime;
        this.mApp.getWindowProcessController().setFgInteractionTime(fgInteractionTime);
    }

    long getFgInteractionTime() {
        return this.mFgInteractionTime;
    }

    void setForcingToImportant(Object forcingToImportant) {
        this.mForcingToImportant = forcingToImportant;
    }

    Object getForcingToImportant() {
        return this.mForcingToImportant;
    }

    void setAdjSeq(int adjSeq) {
        this.mAdjSeq = adjSeq;
    }

    void decAdjSeq() {
        this.mAdjSeq--;
    }

    int getAdjSeq() {
        return this.mAdjSeq;
    }

    void setCompletedAdjSeq(int completedAdjSeq) {
        this.mCompletedAdjSeq = completedAdjSeq;
    }

    void decCompletedAdjSeq() {
        this.mCompletedAdjSeq--;
    }

    int getCompletedAdjSeq() {
        return this.mCompletedAdjSeq;
    }

    void setContainsCycle(boolean containsCycle) {
        this.mContainsCycle = containsCycle;
    }

    boolean containsCycle() {
        return this.mContainsCycle;
    }

    void setWhenUnimportant(long whenUnimportant) {
        this.mWhenUnimportant = whenUnimportant;
        this.mApp.getWindowProcessController().setWhenUnimportant(whenUnimportant);
    }

    long getWhenUnimportant() {
        return this.mWhenUnimportant;
    }

    void setLastTopTime(long lastTopTime) {
        this.mLastTopTime = lastTopTime;
    }

    long getLastTopTime() {
        return this.mLastTopTime;
    }

    boolean isEmpty() {
        if (this.mCurProcState < 19) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isCached() {
        if (this.mCurAdj < 900) goto L5;
        return true;
    L5:
        return false;
    }

    int getCacheOomRankerUseCount() {
        return this.mCacheOomRankerUseCount;
    }

    void setSystemNoUi(boolean systemNoUi) {
        this.mSystemNoUi = systemNoUi;
    }

    boolean isSystemNoUi() {
        return this.mSystemNoUi;
    }

    void setAdjType(String adjType) {
        this.mAdjType = adjType;
    }

    String getAdjType() {
        return this.mAdjType;
    }

    void setAdjTypeCode(int adjTypeCode) {
        this.mAdjTypeCode = adjTypeCode;
    }

    int getAdjTypeCode() {
        return this.mAdjTypeCode;
    }

    void setAdjSource(Object adjSource) {
        this.mAdjSource = adjSource;
    }

    Object getAdjSource() {
        return this.mAdjSource;
    }

    void setAdjSourceProcState(int adjSourceProcState) {
        this.mAdjSourceProcState = adjSourceProcState;
    }

    int getAdjSourceProcState() {
        return this.mAdjSourceProcState;
    }

    void setAdjTarget(Object adjTarget) {
        this.mAdjTarget = adjTarget;
    }

    Object getAdjTarget() {
        return this.mAdjTarget;
    }

    boolean isReachable() {
        return this.mReachable;
    }

    void setReachable(boolean reachable) {
        this.mReachable = reachable;
    }

    void resetCachedInfo() {
        this.mCachedHasActivities = -1;
        this.mCachedIsHeavyWeight = -1;
        this.mCachedHasVisibleActivities = -1;
        this.mCachedIsHomeProcess = -1;
        this.mCachedIsPreviousProcess = -1;
        this.mCachedHasRecentTasks = -1;
        this.mCachedIsReceivingBroadcast = -1;
        this.mCachedAdj = ProcessList.INVALID_ADJ;
        this.mCachedForegroundActivities = false;
        this.mCachedProcState = 19;
        this.mCachedSchedGroup = 0;
        this.mCachedAdjType = null;
    }

    boolean getCachedHasActivities() {
        if (this.mCachedHasActivities != (-1)) goto L13;
        if (this.mApp.getWindowProcessController().hasActivities() == false) goto L7;
        int r0 = 1;
    L8:
        this.mCachedHasActivities = r0;
        if (this.mCachedHasActivities != 1) goto L11;
        this.mApp.mProfile.addHostingComponentType(16);
        goto L13
    L11:
        this.mApp.mProfile.clearHostingComponentType(16);
        goto L13
    L7:
        r0 = 0;
    L13:
        if (this.mCachedHasActivities == 1) goto L15;
        return false;
    L15:
        return true;
    }

    boolean getCachedIsHeavyWeight() {
        if (this.mCachedIsHeavyWeight != (-1)) goto L10;
        if (this.mApp.getWindowProcessController().isHeavyWeightProcess() == false) goto L7;
        int r0 = 1;
    L8:
        this.mCachedIsHeavyWeight = r0;
        goto L10
    L7:
        r0 = 0;
    L10:
        if (this.mCachedIsHeavyWeight == 1) goto L12;
        return false;
    L12:
        return true;
    }

    boolean getCachedHasVisibleActivities() {
        if (this.mCachedHasVisibleActivities != (-1)) goto L10;
        if (this.mApp.getWindowProcessController().hasVisibleActivities() == false) goto L7;
        int r0 = 1;
    L8:
        this.mCachedHasVisibleActivities = r0;
        goto L10
    L7:
        r0 = 0;
    L10:
        if (this.mCachedHasVisibleActivities == 1) goto L12;
        return false;
    L12:
        return true;
    }

    boolean getCachedIsHomeProcess() {
        if (this.mCachedIsHomeProcess != (-1)) goto L9;
        if (this.mApp.getWindowProcessController().isHomeProcess() == false) goto L7;
        this.mCachedIsHomeProcess = 1;
        this.mService.mAppProfiler.mHasHomeProcess = true;
        goto L9
    L7:
        this.mCachedIsHomeProcess = 0;
    L9:
        if (this.mCachedIsHomeProcess == 1) goto L11;
        return false;
    L11:
        return true;
    }

    boolean getCachedIsPreviousProcess() {
        if (this.mCachedIsPreviousProcess != (-1)) goto L9;
        if (this.mApp.getWindowProcessController().isPreviousProcess() == false) goto L7;
        this.mCachedIsPreviousProcess = 1;
        this.mService.mAppProfiler.mHasPreviousProcess = true;
        goto L9
    L7:
        this.mCachedIsPreviousProcess = 0;
    L9:
        if (this.mCachedIsPreviousProcess == 1) goto L11;
        return false;
    L11:
        return true;
    }

    boolean getCachedHasRecentTasks() {
        if (this.mCachedHasRecentTasks != (-1)) goto L10;
        if (this.mApp.getWindowProcessController().hasRecentTasks() == false) goto L7;
        int r0 = 1;
    L8:
        this.mCachedHasRecentTasks = r0;
        goto L10
    L7:
        r0 = 0;
    L10:
        if (this.mCachedHasRecentTasks == 1) goto L12;
        return false;
    L12:
        return true;
    }

    boolean getCachedIsReceivingBroadcast(int[] outSchedGroup) {
        if (this.mCachedIsReceivingBroadcast != (-1)) goto L13;
        if (this.mService.isReceivingBroadcastLocked(this.mApp, outSchedGroup) == false) goto L7;
        int r0 = 1;
    L8:
        this.mCachedIsReceivingBroadcast = r0;
        if (this.mCachedIsReceivingBroadcast != 1) goto L11;
        this.mCachedSchedGroup = outSchedGroup[0];
        this.mApp.mProfile.addHostingComponentType(32);
        goto L13
    L11:
        this.mApp.mProfile.clearHostingComponentType(32);
        goto L13
    L7:
        r0 = 0;
    L13:
        if (this.mCachedIsReceivingBroadcast == 1) goto L15;
        return false;
    L15:
        return true;
    }

    boolean getCachedCompatChange(int cachedCompatChangeId) {
        if (this.mCachedCompatChanges[cachedCompatChangeId] != (-1)) goto L10;
        int[] r0 = this.mCachedCompatChanges;
        if (this.mService.mOomAdjuster.isChangeEnabled(cachedCompatChangeId, this.mApp.info, false) == false) goto L7;
        int r1 = 1;
    L8:
        r0[cachedCompatChangeId] = r1;
        goto L10
    L7:
        r1 = 0;
    L10:
        if (this.mCachedCompatChanges[cachedCompatChangeId] != 1) goto L13;
        return true;
    L13:
        return false;
    }

    void computeOomAdjFromActivitiesIfNecessary(OomAdjuster.ComputeOomAdjWindowCallback r11, int r12, boolean r13, boolean r14, int r15, int r16, int r17, int r18, int r19) {
        if (this.mCachedAdj == (-10000)) goto L5;
        return;
    L5:
        r11.initialize(this.mApp, r12, r13, r14, r15, r16, r17, r18, r19);
        int r1 = this.mApp.getWindowProcessController().getActivityStateFlags();
        if ((65536 & r1) == 0) goto L9;
        r11.onVisibleActivity(r1);
    L19:
        this.mCachedAdj = r11.adj;
        this.mCachedForegroundActivities = r11.foregroundActivities;
        this.mCachedHasVisibleActivities = r11.mHasVisibleActivities ? 1 : 0;
        this.mCachedProcState = r11.procState;
        this.mCachedSchedGroup = r11.schedGroup;
        this.mCachedAdjType = r11.mAdjType;
        if (this.mCachedAdj != 100) goto L23;
        this.mCachedAdj += Math.min(99, 65535 & r1);
        return;
    L23:
        return;
    L9:
        if ((131072 & r1) == 0) goto L12;
        r11.onPausedActivity();
        goto L19
    L12:
        if ((262144 & r1) != 0) goto L14;
        r11.onOtherActivity(this.mApp.getWindowProcessController().getPerceptibleTaskStoppedTimeMillis());
        goto L19
    L14:
        if ((524288 & r1) == 0) goto L16;
        boolean r2 = true;
    L17:
        r11.onStoppingActivity(r2);
        goto L19
    L16:
        r2 = false;
        goto L17
    }

    int getCachedAdj() {
        return this.mCachedAdj;
    }

    boolean getCachedForegroundActivities() {
        return this.mCachedForegroundActivities;
    }

    int getCachedProcState() {
        return this.mCachedProcState;
    }

    int getCachedSchedGroup() {
        return this.mCachedSchedGroup;
    }

    String getCachedAdjType() {
        return this.mCachedAdjType;
    }

    boolean shouldScheduleLikeTopApp() {
        return this.mScheduleLikeTopApp;
    }

    void setScheduleLikeTopApp(boolean scheduleLikeTopApp) {
        this.mScheduleLikeTopApp = scheduleLikeTopApp;
    }

    long getFollowupUpdateUptimeMs() {
        return this.mFollowupUpdateUptimeMs;
    }

    void setFollowupUpdateUptimeMs(long updateUptimeMs) {
        this.mFollowupUpdateUptimeMs = updateUptimeMs;
    }

    public String makeAdjReason() {
        if (this.mAdjSource == null) goto L5;
    L9:
        StringBuilder sb = new StringBuilder(128);
        sb.append(' ');
        if ((this.mAdjTarget instanceof ComponentName) == false) goto L13;
        sb.append(((ComponentName) this.mAdjTarget).flattenToShortString());
    L16:
        sb.append("<=");
        if ((this.mAdjSource instanceof ProcessRecord) == false) goto L20;
        sb.append("Proc{");
        sb.append(((ProcessRecord) this.mAdjSource).toShortString());
        sb.append("}");
    L24:
        return sb.toString();
    L20:
        if (this.mAdjSource == null) goto L22;
        sb.append(this.mAdjSource.toString());
        goto L24
    L22:
        sb.append("{null}");
        goto L24
    L13:
        if (this.mAdjTarget == null) goto L15;
        sb.append(this.mAdjTarget.toString());
        goto L16
    L15:
        sb.append("{null}");
        goto L16
    L5:
        if (this.mAdjTarget != null) goto L9;
        return null;
    }

    void onCleanupApplicationRecordLSP() {
        setHasForegroundActivities(false);
        this.mHasShownUi = false;
        this.mForcingToImportant = null;
        this.mVerifiedAdj = ProcessList.INVALID_ADJ;
        this.mSetAdj = ProcessList.INVALID_ADJ;
        this.mCurAdj = ProcessList.INVALID_ADJ;
        this.mSetRawAdj = ProcessList.INVALID_ADJ;
        this.mCurRawAdj = ProcessList.INVALID_ADJ;
        this.mSetCapability = 0;
        this.mCurCapability = 0;
        this.mSetSchedGroup = 0;
        this.mCurSchedGroup = 0;
        this.mSetProcState = 20;
        this.mCurRawProcState = 20;
        this.mCurProcState = 20;
        int i = 0;
    L4:
        if (i >= this.mCachedCompatChanges.length) goto L7;
        this.mCachedCompatChanges[i] = -1;
        i = i + 1;
        goto L4
    }

    boolean isBackgroundRestricted() {
        return this.mBackgroundRestricted;
    }

    void setBackgroundRestricted(boolean restricted) {
        this.mBackgroundRestricted = restricted;
    }

    boolean isCurBoundByNonBgRestrictedApp() {
        return this.mCurBoundByNonBgRestrictedApp;
    }

    void setCurBoundByNonBgRestrictedApp(boolean bound) {
        this.mCurBoundByNonBgRestrictedApp = bound;
    }

    boolean isSetBoundByNonBgRestrictedApp() {
        return this.mSetBoundByNonBgRestrictedApp;
    }

    void setSetBoundByNonBgRestrictedApp(boolean bound) {
        this.mSetBoundByNonBgRestrictedApp = bound;
    }

    void updateLastInvisibleTime(boolean hasVisibleActivities) {
        if (hasVisibleActivities == false) goto L6;
        this.mLastInvisibleTime = Long.MAX_VALUE;
        return;
    L6:
        if (this.mLastInvisibleTime != Long.MAX_VALUE) goto L10;
        this.mLastInvisibleTime = SystemClock.elapsedRealtime();
        return;
    }

    long getLastInvisibleTime() {
        return this.mLastInvisibleTime;
    }

    void setNoKillOnBgRestrictedAndIdle(boolean shouldNotKill) {
        this.mNoKillOnBgRestrictedAndIdle = shouldNotKill;
    }

    boolean shouldNotKillOnBgRestrictedAndIdle() {
        return this.mNoKillOnBgRestrictedAndIdle;
    }

    void setSetCached(boolean cached) {
        this.mSetCached = cached;
    }

    boolean isSetCached() {
        return this.mSetCached;
    }

    void setSetNoKillOnBgRestrictedAndIdle(boolean shouldNotKill) {
        this.mSetNoKillOnBgRestrictedAndIdle = shouldNotKill;
    }

    boolean isSetNoKillOnBgRestrictedAndIdle() {
        return this.mSetNoKillOnBgRestrictedAndIdle;
    }

    void setLastCanKillOnBgRestrictedAndIdleTime(long now) {
        this.mLastCanKillOnBgRestrictedAndIdleTime = now;
    }

    long getLastCanKillOnBgRestrictedAndIdleTime() {
        return this.mLastCanKillOnBgRestrictedAndIdleTime;
    }

    public void setCacheOomRankerRss(long rss, long rssTimeMs) {
        this.mCacheOomRankerRss = rss;
        this.mCacheOomRankerRssTimeMs = rssTimeMs;
    }

    public long getCacheOomRankerRss() {
        return this.mCacheOomRankerRss;
    }

    public long getCacheOomRankerRssTimeMs() {
        return this.mCacheOomRankerRssTimeMs;
    }

    void dump(PrintWriter pw, String prefix, long nowUptime) {
        if (this.mReportedInteraction == false) goto L5;
    L6:
        pw.print(prefix);
        pw.print("reportedInteraction=");
        pw.print(this.mReportedInteraction);
        if (this.mInteractionEventTime == 0) goto L10;
        pw.print(" time=");
        TimeUtils.formatDuration(this.mInteractionEventTime, SystemClock.elapsedRealtime(), pw);
    L10:
        if (this.mFgInteractionTime == 0) goto L12;
        pw.print(" fgInteractionTime=");
        TimeUtils.formatDuration(this.mFgInteractionTime, SystemClock.elapsedRealtime(), pw);
    L12:
        pw.println();
    L13:
        pw.print(prefix);
        pw.print("adjSeq=");
        pw.print(this.mAdjSeq);
        pw.print(" lruSeq=");
        pw.println(this.mApp.getLruSeq());
        pw.print(prefix);
        pw.print("oom adj: max=");
        pw.print(this.mMaxAdj);
        pw.print(" curRaw=");
        pw.print(this.mCurRawAdj);
        pw.print(" setRaw=");
        pw.print(this.mSetRawAdj);
        pw.print(" cur=");
        pw.print(this.mCurAdj);
        pw.print(" set=");
        pw.println(this.mSetAdj);
        pw.print(prefix);
        pw.print("mCurSchedGroup=");
        pw.print(this.mCurSchedGroup);
        pw.print(" setSchedGroup=");
        pw.print(this.mSetSchedGroup);
        pw.print(" systemNoUi=");
        pw.println(this.mSystemNoUi);
        pw.print(prefix);
        pw.print("curProcState=");
        pw.print(getCurProcState());
        pw.print(" mRepProcState=");
        pw.print(this.mRepProcState);
        pw.print(" setProcState=");
        pw.print(this.mSetProcState);
        pw.print(" lastStateTime=");
        TimeUtils.formatDuration(getLastStateTime(), nowUptime, pw);
        pw.println();
        pw.print(prefix);
        pw.print("curCapability=");
        ActivityManager.printCapabilitiesFull(pw, this.mCurCapability);
        pw.print(" setCapability=");
        ActivityManager.printCapabilitiesFull(pw, this.mSetCapability);
        pw.println();
        if (this.mBackgroundRestricted == false) goto L16;
        pw.print(" backgroundRestricted=");
        pw.print(this.mBackgroundRestricted);
        pw.print(" boundByNonBgRestrictedApp=");
        pw.print(this.mSetBoundByNonBgRestrictedApp);
    L16:
        pw.println();
        if (this.mHasShownUi == false) goto L19;
    L20:
        pw.print(prefix);
        pw.print("hasShownUi=");
        pw.print(this.mHasShownUi);
        pw.print(" pendingUiClean=");
        pw.println(this.mApp.mProfile.hasPendingUiClean());
    L21:
        pw.print(prefix);
        pw.print("cached=");
        pw.print(isCached());
        pw.print(" empty=");
        pw.println(isEmpty());
        if (this.mServiceB == false) goto L25;
        pw.print(prefix);
        pw.print("serviceb=");
        pw.print(this.mServiceB);
        pw.print(" serviceHighRam=");
        pw.println(this.mServiceHighRam);
    L25:
        if (this.mNotCachedSinceIdle == false) goto L32;
        pw.print(prefix);
        pw.print("notCachedSinceIdle=");
        pw.print(this.mNotCachedSinceIdle);
        if (this.mService.mAppProfiler.isProfilingPss() == false) goto L29;
        pw.print(" initialIdlePss=");
    L30:
        pw.println(this.mApp.mProfile.getInitialIdlePssOrRss());
        goto L32
    L29:
        pw.print(" initialIdleRss=");
    L32:
        if (hasTopUi() == false) goto L34;
    L37:
        pw.print(prefix);
        pw.print("hasTopUi=");
        pw.print(hasTopUi());
        pw.print(" hasOverlayUi=");
        pw.print(hasOverlayUi());
        pw.print(" runningRemoteAnimation=");
        pw.println(this.mRunningRemoteAnimation);
    L39:
        if (this.mHasForegroundActivities == false) goto L41;
    L42:
        pw.print(prefix);
        pw.print("foregroundActivities=");
        pw.print(this.mHasForegroundActivities);
        pw.print(" (rep=");
        pw.print(this.mRepForegroundActivities);
        pw.println(")");
    L44:
        if (this.mSetProcState <= 10) goto L47;
        pw.print(prefix);
        pw.print("whenUnimportant=");
        TimeUtils.formatDuration(this.mWhenUnimportant - nowUptime, pw);
        pw.println();
    L47:
        if (this.mLastTopTime <= 0) goto L50;
        pw.print(prefix);
        pw.print("lastTopTime=");
        TimeUtils.formatDuration(this.mLastTopTime, nowUptime, pw);
        pw.println();
    L50:
        if (this.mLastInvisibleTime <= 0) goto L55;
        if (this.mLastInvisibleTime >= Long.MAX_VALUE) goto L55;
        pw.print(prefix);
        pw.print("lastInvisibleTime=");
        long elapsedRealtimeNow = SystemClock.elapsedRealtime();
        long currentTimeNow = System.currentTimeMillis();
        long lastInvisibleCurrentTime = (currentTimeNow - elapsedRealtimeNow) + this.mLastInvisibleTime;
        TimeUtils.dumpTimeWithDelta(pw, lastInvisibleCurrentTime, currentTimeNow);
        pw.println();
    L55:
        if (this.mHasStartedServices == false) goto L58;
        pw.print(prefix);
        pw.print("hasStartedServices=");
        pw.println(this.mHasStartedServices);
        return;
    L58:
        return;
    L41:
        if (this.mRepForegroundActivities == false) goto L44;
    L34:
        if (hasOverlayUi() == true) goto L37;
        if (this.mRunningRemoteAnimation == false) goto L39;
    L19:
        if (this.mApp.mProfile.hasPendingUiClean() == false) goto L21;
    L5:
        if (this.mFgInteractionTime == 0) goto L13;
        goto L6
    }
}
