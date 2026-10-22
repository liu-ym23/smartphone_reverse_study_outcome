package com.bytedance.apm.battery.stats;

import android.os.SystemClock;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsBatteryTimeStats<T extends BaseHookInfo> extends AbsHookStatsTask<T> implements IBatteryStats {
    private static final Object innerLock = null;
    private volatile int mHoldCount;
    private volatile long mStartTime;
    private int mTotalCount;
    private long mTotalTime;

    abstract void reportAccumulatedIssue(double r1, double r3);

    protected abstract void reportSingleIssue(T r1, long r2);

    static /* synthetic */ void access$000(AbsBatteryTimeStats r0, long r1, boolean r3, String r4) {
        r0.record(r1, r3, r4);
    }

    static {
        innerLock = new Object();
    }

    AbsBatteryTimeStats(String r1) {
        super(r1);
        this.mHoldCount = 0;
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    protected void pollingTask(long r9, long r11, boolean r13) {
        this.mTotalCount = 0;
        this.mTotalTime = 0;
        innerRecord(r13);
        super.pollingTask(r9, r11, r13);
        long r10 = System.currentTimeMillis();
        reportAccumulatedIssue(((this.mTotalTime / (r10 - this.mLastPollingTime)) * 60000.0d) * 10.0d, ((((double) this.mTotalCount) / (r10 - this.mLastPollingTime)) * 60000.0d) * 10.0d);
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    protected void checkStats(T r6, long r7, long r9) {
        this.mTotalCount++;
        long r0 = r6.startTime;
        if (r0 < r7) goto L6;
        r7 = r0;
    L6:
        long r1 = r6.endTime;
        if (r1 > 0) goto L9;
    L12:
        reportSingleIssue(r6, r9 - r6.startTime);
        long r10 = r9 - r7;
        if (r10 <= 0) goto L16;
        this.mTotalTime += r10;
        return;
    L16:
        return;
    L9:
        if (r9 < r1) goto L12;
        r9 = r1;
        goto L12
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r1) {
        innerRecord(r1);
        super.onBack(r1);
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r1) {
        innerRecord(r1);
        super.onFront(r1);
    }

    private void innerRecord(boolean r7) {
        Object r0 = innerLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mHoldCount > 0) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStartTime <= 0) goto L12;
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r7 == false) goto L11;
        record(r1 - this.mStartTime, this.mIsFront, BatteryCollector.getInstance().getCurSceneSetStr());     // Catch: Throwable -> L14
    L11:
        this.mStartTime = r1;     // Catch: Throwable -> L14
        goto L12
    }

    void addHolderCount() {
        Object r1 = innerLock;
        monitor-enter(r1);
        ApmAlogHelper.i(Constants.TAG_BATTERY, "addHolderCount:" + this.mHoldCount + " type:" + getType());     // Catch: Throwable -> L9
        this.mHoldCount++;     // Catch: Throwable -> L9
        if (this.mHoldCount != 1) goto L7;
        this.mStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void reduceHolderCount() {
        Object r1 = innerLock;
        monitor-enter(r1);
        ApmAlogHelper.i(Constants.TAG_BATTERY, "reduceHolderCount:" + this.mHoldCount + " type:" + getType());     // Catch: Throwable -> L13
        if (this.mHoldCount != 0) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L8:
        this.mHoldCount--;     // Catch: Throwable -> L13
        if (this.mHoldCount != 0) goto L11;
        final boolean r0 = this.mIsFront;     // Catch: Throwable -> L13
        final long r2 = SystemClock.elapsedRealtime() - this.mStartTime;     // Catch: Throwable -> L13
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r2, r0));     // Catch: Throwable -> L13
        this.mStartTime = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void record(long r11, boolean r13, String r14) {
        BatteryLogEntity r9 = new BatteryLogEntity(r13, System.currentTimeMillis(), getType(), this.mIsCharging, r11, r14);
        BatteryDataManager.getInstance().record(r9);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r1, boolean r2) {
        innerRecord(r2);
        this.mIsCharging = r1;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r1, boolean r2) {
        innerRecord(r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r1, boolean r2) {
        innerRecord(r2);
    }
}
