package com.bytedance.android.livesdkapi.summer;

/* JADX INFO: loaded from: classes12.dex */
public abstract class AbstractSummerTask implements ISummerTask {
    private static final String TAG = "BDLog";
    private volatile boolean mPendingCancel;
    private volatile boolean mPendingRelease;
    private volatile int mStatus;

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public int getPriority() {
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public int getTaskType() {
        return 1;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public abstract void onRelease();

    @Override // java.lang.Runnable
    public abstract void run();

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void cancelTask() {
        if (this.mStatus != 0) goto L6;
        this.mStatus = 3;
    L9:
        return;
    L6:
        if (this.mStatus != 1) goto L9;
        this.mPendingCancel = true;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final boolean isInterrupt() {
        if (this.mPendingCancel == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mPendingRelease == true) goto L8;
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void processTask() {
        if (this.mStatus != 0) goto L11;
        this.mStatus = 1;
        run();
        this.mStatus = 2;
        if (this.mPendingCancel == false) goto L8;
        this.mPendingCancel = false;
        this.mStatus = 3;
    L8:
        if (this.mPendingRelease == false) goto L12;
        this.mPendingRelease = false;
        this.mStatus = 4;
        onRelease();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final void releaseTask() {
        if (this.mStatus != 1) goto L5;
        this.mPendingRelease = true;
        return;
    L5:
        this.mStatus = 4;
        onRelease();
    }

    public AbstractSummerTask() {
        this.mStatus = 0;
        this.mPendingCancel = false;
        this.mPendingRelease = false;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public final int getStatus() {
        return this.mStatus;
    }

    @Override // com.bytedance.android.livesdkapi.summer.ISummerTask
    public Boolean needCancel() {
        return Boolean.FALSE;
    }
}
