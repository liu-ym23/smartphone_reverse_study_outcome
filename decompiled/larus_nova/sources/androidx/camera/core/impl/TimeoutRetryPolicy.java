package androidx.camera.core.impl;

import androidx.camera.core.RetryPolicy;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class TimeoutRetryPolicy implements RetryPolicy {
    private final RetryPolicy mDelegatePolicy;
    private final long mTimeoutInMillis;

    @Override // androidx.camera.core.RetryPolicy
    public long getTimeoutInMillis() {
        return this.mTimeoutInMillis;
    }

    @Override // androidx.camera.core.RetryPolicy
    public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r100) {
        RetryPolicy.RetryConfig r101 = this.mDelegatePolicy.onRetryDecisionRequested(r100);
        if (getTimeoutInMillis() > 0) goto L5;
        return r101;
    L5:
        if (r100.getExecutedTimeInMillis() >= (getTimeoutInMillis() - r101.getRetryDelayInMillis())) goto L7;
        return r101;
    L7:
        return RetryPolicy.RetryConfig.NOT_RETRY;
    }

    public TimeoutRetryPolicy(long r100, RetryPolicy r101) {
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "Timeout must be non-negative.");
        this.mTimeoutInMillis = r100;
        this.mDelegatePolicy = r101;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
