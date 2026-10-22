package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.util.Pair;
import android.util.TimeUtils;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class ProcessCachedOptimizerRecord {
    static final String IS_FROZEN = "isFrozen";
    static final int SHOULD_NOT_FREEZE_REASON_BINDER_ALLOW_OOM_MANAGEMENT = 4;
    static final int SHOULD_NOT_FREEZE_REASON_BIND_WAIVE_PRIORITY = 8;
    static final int SHOULD_NOT_FREEZE_REASON_NONE = 1;
    static final int SHOULD_NOT_FREEZE_REASON_UID_ALLOWLISTED = 2;
    private final ProcessRecord mApp;
    private long mEarliestFreezableTimeMillis;
    private boolean mForceCompact;
    private boolean mFreezeExempt;
    private boolean mFreezeSticky;
    private long mFreezeUnfreezeTime;
    boolean mFreezerOverride;
    private boolean mFrozen;
    final CopyOnWriteArrayList<Pair<Executor, ActivityManagerInternal.FrozenProcessListener>> mFrozenProcessListeners;
    private boolean mHasCollectedFrozenPSS;
    private CachedAppOptimizer.CompactProfile mLastCompactProfile;
    private long mLastCompactTime;
    private int mLastOomAdjChangeReason;
    private long mLastUsedTimeout;
    private boolean mPendingCompact;
    private boolean mPendingFreeze;
    private final ActivityManagerGlobalLock mProcLock;
    private CachedAppOptimizer.CompactProfile mReqCompactProfile;
    private CachedAppOptimizer.CompactSource mReqCompactSource;
    private boolean mShouldNotFreeze;
    private int mShouldNotFreezeAdjSeq;
    private int mShouldNotFreezeReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShouldNotFreezeReason {
    }

    /* JADX INFO: renamed from: $r8$lambda$6e1WKBdmUHOww6OyL-WUh31gNYE, reason: not valid java name */
    public static /* synthetic */ void m1553$r8$lambda$6e1WKBdmUHOww6OyLWUh31gNYE(ProcessCachedOptimizerRecord r0, Pair r1) {
        r0.lambda$dispatchFrozenEvent$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$HBmyY4u0xa6PxtuMQNuHUc2IWu0(PrintWriter r0, Pair r1) {
        lambda$dump$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LTcRtyqLvcipvWyqTX8k356MCns(ProcessCachedOptimizerRecord r0, Pair r1) {
        r0.lambda$dispatchUnfrozenEvent$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$lZHn3tWVRvIRmtdxS9KMoU_F4R4(ProcessCachedOptimizerRecord r0, Pair r1) {
        r0.lambda$dispatchFrozenEvent$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$m-6XxJyWq6MDe_Td30gYfonqo00, reason: not valid java name */
    public static /* synthetic */ void m1554$r8$lambda$m6XxJyWq6MDe_Td30gYfonqo00(ProcessCachedOptimizerRecord r0, Pair r1) {
        r0.lambda$dispatchUnfrozenEvent$3(r1);
    }

    long getLastCompactTime() {
        return this.mLastCompactTime;
    }

    void setLastCompactTime(long lastCompactTime) {
        this.mLastCompactTime = lastCompactTime;
    }

    CachedAppOptimizer.CompactProfile getReqCompactProfile() {
        return this.mReqCompactProfile;
    }

    void setReqCompactProfile(CachedAppOptimizer.CompactProfile reqCompactProfile) {
        this.mReqCompactProfile = reqCompactProfile;
    }

    CachedAppOptimizer.CompactSource getReqCompactSource() {
        return this.mReqCompactSource;
    }

    void setReqCompactSource(CachedAppOptimizer.CompactSource stat) {
        this.mReqCompactSource = stat;
    }

    void setLastOomAdjChangeReason(int reason) {
        this.mLastOomAdjChangeReason = reason;
    }

    int getLastOomAdjChangeReason() {
        return this.mLastOomAdjChangeReason;
    }

    CachedAppOptimizer.CompactProfile getLastCompactProfile() {
        if (this.mLastCompactProfile != null) goto L6;
        this.mLastCompactProfile = CachedAppOptimizer.CompactProfile.FULL;
    L6:
        return this.mLastCompactProfile;
    }

    void setLastCompactProfile(CachedAppOptimizer.CompactProfile lastCompactProfile) {
        this.mLastCompactProfile = lastCompactProfile;
    }

    boolean hasPendingCompact() {
        return this.mPendingCompact;
    }

    void setHasPendingCompact(boolean pendingCompact) {
        this.mPendingCompact = pendingCompact;
    }

    boolean isForceCompact() {
        return this.mForceCompact;
    }

    void setForceCompact(boolean forceCompact) {
        this.mForceCompact = forceCompact;
    }

    boolean isFrozen() {
        return this.mFrozen;
    }

    void setFrozen(boolean frozen) {
        this.mFrozen = frozen;
    }

    void setFreezeSticky(boolean sticky) {
        this.mFreezeSticky = sticky;
    }

    boolean isFreezeSticky() {
        return this.mFreezeSticky;
    }

    boolean skipPSSCollectionBecauseFrozen() {
        boolean collected = this.mHasCollectedFrozenPSS;
        if (this.mFrozen == true) goto L6;
        return false;
    L6:
        this.mHasCollectedFrozenPSS = true;
        return collected;
    }

    void setHasCollectedFrozenPSS(boolean collected) {
        this.mHasCollectedFrozenPSS = collected;
    }

    boolean hasFreezerOverride() {
        return this.mFreezerOverride;
    }

    void setFreezerOverride(boolean freezerOverride) {
        this.mFreezerOverride = freezerOverride;
    }

    long getFreezeUnfreezeTime() {
        return this.mFreezeUnfreezeTime;
    }

    void setFreezeUnfreezeTime(long freezeUnfreezeTime) {
        this.mFreezeUnfreezeTime = freezeUnfreezeTime;
    }

    boolean shouldNotFreeze() {
        return this.mShouldNotFreeze;
    }

    int shouldNotFreezeReason() {
        return this.mShouldNotFreezeReason;
    }

    int shouldNotFreezeAdjSeq() {
        return this.mShouldNotFreezeAdjSeq;
    }

    void setShouldNotFreeze(boolean shouldNotFreeze, int reason, int adjSeq) {
        setShouldNotFreeze(shouldNotFreeze, false, reason, adjSeq);
    }

    boolean setShouldNotFreeze(boolean shouldNotFreeze, boolean dryRun, int reason, int adjSeq) {
        if (dryRun == true) goto L5;
        if (shouldNotFreeze == false) goto L11;
        int reason2 = reason & (-2);
    L13:
        if (reason2 == this.mShouldNotFreezeReason) goto L15;
    L16:
        this.mShouldNotFreezeAdjSeq = adjSeq;
    L17:
        this.mShouldNotFreezeReason = reason2;
        this.mShouldNotFreeze = shouldNotFreeze;
        return false;
    L15:
        if (shouldNotFreeze == this.mShouldNotFreeze) goto L17;
    L11:
        reason2 = 1;
        goto L13
    L5:
        if (this.mShouldNotFreeze == shouldNotFreeze) goto L19;
        return true;
    L19:
        return false;
    }

    long getEarliestFreezableTime() {
        return this.mEarliestFreezableTimeMillis;
    }

    void setEarliestFreezableTime(long earliestFreezableTimeMillis) {
        this.mEarliestFreezableTimeMillis = earliestFreezableTimeMillis;
    }

    long getLastUsedTimeout() {
        return this.mLastUsedTimeout;
    }

    void setLastUsedTimeout(long lastUsedTimeout) {
        this.mLastUsedTimeout = lastUsedTimeout;
    }

    boolean isFreezeExempt() {
        return this.mFreezeExempt;
    }

    void setPendingFreeze(boolean freeze) {
        this.mPendingFreeze = freeze;
    }

    boolean isPendingFreeze() {
        return this.mPendingFreeze;
    }

    void setFreezeExempt(boolean exempt) {
        this.mFreezeExempt = exempt;
    }

    void addFrozenProcessListener(Executor executor, ActivityManagerInternal.FrozenProcessListener listener) {
        this.mFrozenProcessListeners.add(new Pair(executor, listener));
    }

    void dispatchFrozenEvent() {
        this.mFrozenProcessListeners.forEach(new ProcessCachedOptimizerRecord$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$dispatchFrozenEvent$0(Pair pair) {
        ((ActivityManagerInternal.FrozenProcessListener) pair.second).onProcessFrozen(this.mApp.mPid);
    }

    private /* synthetic */ void lambda$dispatchFrozenEvent$1(final Pair pair) {
        ((Executor) pair.first).execute(new ProcessCachedOptimizerRecord$$ExternalSyntheticLambda2(this, pair));
    }

    void dispatchUnfrozenEvent() {
        this.mFrozenProcessListeners.forEach(new ProcessCachedOptimizerRecord$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$dispatchUnfrozenEvent$2(Pair pair) {
        ((ActivityManagerInternal.FrozenProcessListener) pair.second).onProcessUnfrozen(this.mApp.mPid);
    }

    private /* synthetic */ void lambda$dispatchUnfrozenEvent$3(final Pair pair) {
        ((Executor) pair.first).execute(new ProcessCachedOptimizerRecord$$ExternalSyntheticLambda3(this, pair));
    }

    ProcessCachedOptimizerRecord(ProcessRecord app) {
        this.mFrozenProcessListeners = new CopyOnWriteArrayList();
        this.mApp = app;
        this.mProcLock = app.mService.mProcLock;
    }

    void init(long nowUptime) {
        this.mFreezeUnfreezeTime = nowUptime;
        this.mLastCompactTime = nowUptime;
    }

    @NeverCompile
    void dump(final PrintWriter pw, String prefix, long nowUptime) {
        pw.print(prefix);
        pw.print("lastCompactTime=");
        pw.print(this.mLastCompactTime);
        pw.print(" lastCompactProfile=");
        pw.println(this.mLastCompactProfile);
        pw.print(prefix);
        pw.print("hasPendingCompaction=");
        pw.print(this.mPendingCompact);
        pw.print(prefix);
        pw.print("isFreezeExempt=");
        pw.print(this.mFreezeExempt);
        pw.print(" isPendingFreeze=");
        pw.print(this.mPendingFreeze);
        pw.print(" isFrozen=");
        pw.println(this.mFrozen);
        pw.print(prefix);
        pw.print("earliestFreezableTimeMs=");
        TimeUtils.formatDuration(this.mEarliestFreezableTimeMillis, nowUptime, pw);
        if (this.mFrozenProcessListeners.isEmpty() == true) goto L5;
        pw.print(" mFrozenProcessListeners=");
        this.mFrozenProcessListeners.forEach(new ProcessCachedOptimizerRecord$$ExternalSyntheticLambda4(pw));
    L5:
        pw.println();
    }

    private static /* synthetic */ void lambda$dump$4(PrintWriter pw, Pair pair) {
        pw.print(pair.second + ", ");
    }
}
