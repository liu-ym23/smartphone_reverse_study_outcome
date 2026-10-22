package com.android.server.am;

import android.os.Binder;
import android.os.SystemClock;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.internal.app.procstats.AssociationState;
import com.android.internal.app.procstats.ProcessStats;
import com.android.server.slice.SliceClientPermissions;

/* JADX INFO: loaded from: classes.dex */
public final class ContentProviderConnection extends Binder implements OomAdjusterModernImpl.Connection {
    public AssociationState.SourceState association;
    public final ProcessRecord client;
    public final String clientPackage;
    public final long createTime;
    public boolean dead;
    final int mExpectedUserId;
    private final Object mLock;
    private int mNumStableIncs;
    private int mNumUnstableIncs;
    private volatile Object mProcStatsLock;
    private int mStableCount;
    private int mUnstableCount;
    public final ContentProviderRecord provider;
    public boolean waiting;

    public ContentProviderConnection(ContentProviderRecord _provider, ProcessRecord _client, String _clientPackage, int _expectedUserId) {
        this.mLock = new Object();
        this.provider = _provider;
        this.client = _client;
        this.clientPackage = _clientPackage;
        this.mExpectedUserId = _expectedUserId;
        this.createTime = SystemClock.elapsedRealtime();
    }

    @Override // com.android.server.am.OomAdjusterModernImpl.Connection
    public void computeHostOomAdjLSP(OomAdjuster oomAdjuster, ProcessRecord host, ProcessRecord client, long now, ProcessRecord topApp, boolean doingAll, int oomAdjReason, int cachedAdj) {
        oomAdjuster.computeProviderHostOomAdjLSP(this, host, client, now, topApp, doingAll, false, false, oomAdjReason, 1001, false, false);
    }

    @Override // com.android.server.am.OomAdjusterModernImpl.Connection
    public boolean canAffectCapabilities() {
        return false;
    }

    public void startAssociationIfNeeded() {
        if (this.association == null) goto L5;
        return;
    L5:
        if (this.provider.proc != null) goto L7;
        return;
    L7:
        if (this.provider.appInfo.uid == this.client.uid) goto L9;
    L10:
        ProcessStats.ProcessStateHolder holder = this.provider.proc.getPkgList().get(this.provider.name.getPackageName());
        if (holder != null) goto L14;
        Slog.wtf("ActivityManager", "No package in referenced provider " + this.provider.name.toShortString() + ": proc=" + this.provider.proc);
        return;
    L14:
        if (holder.pkg != null) goto L16;
        Slog.wtf("ActivityManager", "Inactive holder in referenced provider " + this.provider.name.toShortString() + ": proc=" + this.provider.proc);
        return;
    L16:
        this.mProcStatsLock = this.provider.proc.mService.mProcessStats.mLock;
        Object r1 = this.mProcStatsLock;
        monitor-enter(r1);
        this.association = holder.pkg.getAssociationStateLocked(holder.state, this.provider.name.getClassName()).startSource(this.client.uid, this.client.processName, this.clientPackage);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.provider.info.processName.equals(this.client.processName) == false) goto L10;
    }

    public void trackProcState(int procState, int seq) {
        if (this.association != null) goto L5;
        return;
    L5:
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.association == null) goto L12;
        this.association.trackProcState(procState, seq, SystemClock.uptimeMillis());     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void stopAssociation() {
        if (this.association != null) goto L5;
        return;
    L5:
        Object r0 = this.mProcStatsLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.association == null) goto L12;
        this.association.stop();     // Catch: Throwable -> L10
        this.association = null;     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("ContentProviderConnection{");
        toShortString(sb);
        sb.append('}');
        return sb.toString();
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder(128);
        toShortString(sb);
        return sb.toString();
    }

    public String toClientString() {
        StringBuilder sb = new StringBuilder(128);
        toClientString(sb);
        return sb.toString();
    }

    public void toShortString(StringBuilder sb) {
        sb.append(this.provider.toShortString());
        sb.append("->");
        toClientString(sb);
    }

    public void toClientString(StringBuilder sb) {
        sb.append(this.client.toShortString());
        Object r0 = this.mLock;
        monitor-enter(r0);
        sb.append(" s");     // Catch: Throwable -> L14
        sb.append(this.mStableCount);     // Catch: Throwable -> L14
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L14
        sb.append(this.mNumStableIncs);     // Catch: Throwable -> L14
        sb.append(" u");     // Catch: Throwable -> L14
        sb.append(this.mUnstableCount);     // Catch: Throwable -> L14
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L14
        sb.append(this.mNumUnstableIncs);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (this.waiting == false) goto L10;
        sb.append(" WAITING");
    L10:
        if (this.dead == false) goto L12;
        sb.append(" DEAD");
    L12:
        long nowReal = SystemClock.elapsedRealtime();
        sb.append(" ");
        TimeUtils.formatDuration(nowReal - this.createTime, sb);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void initializeCount(boolean stable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (stable == false) goto L9;
        this.mStableCount = 1;     // Catch: Throwable -> L7
        this.mNumStableIncs = 1;     // Catch: Throwable -> L7
        this.mUnstableCount = 0;     // Catch: Throwable -> L7
        this.mNumUnstableIncs = 0;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mStableCount = 0;     // Catch: Throwable -> L7
        this.mNumStableIncs = 0;     // Catch: Throwable -> L7
        this.mUnstableCount = 1;     // Catch: Throwable -> L7
        this.mNumUnstableIncs = 1;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public int incrementCount(boolean stable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_PROVIDER == false) goto L9;
        ContentProviderRecord cpr = this.provider;     // Catch: Throwable -> L7
        Slog.v("ActivityManager", "Adding provider requested by " + this.client.processName + " from process " + cpr.info.processName + ": " + cpr.name.flattenToShortString() + " scnt=" + this.mStableCount + " uscnt=" + this.mUnstableCount);     // Catch: Throwable -> L7
    L9:
        if (stable == false) goto L11;
        this.mStableCount++;     // Catch: Throwable -> L7
        this.mNumStableIncs++;     // Catch: Throwable -> L7
    L12:
        int r1 = this.mStableCount + this.mUnstableCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L11:
        this.mUnstableCount++;     // Catch: Throwable -> L7
        this.mNumUnstableIncs++;     // Catch: Throwable -> L7
        goto L12
    }

    public int decrementCount(boolean stable) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_PROVIDER == false) goto L9;
        ContentProviderRecord cpr = this.provider;     // Catch: Throwable -> L7
        Slog.v("ActivityManager", "Removing provider requested by " + this.client.processName + " from process " + cpr.info.processName + ": " + cpr.name.flattenToShortString() + " scnt=" + this.mStableCount + " uscnt=" + this.mUnstableCount);     // Catch: Throwable -> L7
    L9:
        if (stable == false) goto L11;
        this.mStableCount--;     // Catch: Throwable -> L7
    L12:
        int r1 = this.mStableCount + this.mUnstableCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L11:
        this.mUnstableCount--;     // Catch: Throwable -> L7
        goto L12
    }

    public void adjustCounts(int stableIncrement, int unstableIncrement) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (stableIncrement > 0) goto L27;
    L8:
        int stable = this.mStableCount + stableIncrement;     // Catch: Throwable -> L6
        if (stable < 0) goto L24;
        if (unstableIncrement <= 0) goto L12;
        this.mNumUnstableIncs += unstableIncrement;     // Catch: Throwable -> L6
    L12:
        int unstable = this.mUnstableCount + unstableIncrement;     // Catch: Throwable -> L6
        if (unstable < 0) goto L22;
        if ((stable + unstable) <= 0) goto L20;
        this.mStableCount = stable;     // Catch: Throwable -> L6
        this.mUnstableCount = unstable;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L20:
        throw new IllegalStateException("ref counts can't go to zero here: stable=" + stable + " unstable=" + unstable);     // Catch: Throwable -> L6
    L22:
        throw new IllegalStateException("unstableCount < 0: " + unstable);     // Catch: Throwable -> L6
    L24:
        throw new IllegalStateException("stableCount < 0: " + stable);     // Catch: Throwable -> L6
    L27:
        this.mNumStableIncs += stableIncrement;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public int stableCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mStableCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int unstableCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUnstableCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int totalRefCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mStableCount + this.mUnstableCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
