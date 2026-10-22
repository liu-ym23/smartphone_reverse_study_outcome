package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraProviderExecutionState implements RetryPolicy.ExecutionState {
    private final int mAttemptCount;
    private final Throwable mCause;
    private final int mStatus;
    private final long mTaskExecutedTimeInMillis;

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public Throwable getCause() {
        return this.mCause;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public long getExecutedTimeInMillis() {
        return this.mTaskExecutedTimeInMillis;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public int getNumOfAttempts() {
        return this.mAttemptCount;
    }

    @Override // androidx.camera.core.RetryPolicy.ExecutionState
    public int getStatus() {
        return this.mStatus;
    }

    public CameraProviderExecutionState(long r100, int r101, Throwable r102) {
        this.mTaskExecutedTimeInMillis = SystemClock.elapsedRealtime() - r100;
        this.mAttemptCount = r101;
        if ((r102 instanceof CameraValidator.CameraIdListIncorrectException) == false) goto L6;
        this.mStatus = 2;
        this.mCause = r102;
        return;
    L6:
        if ((r102 instanceof InitializationException) == false) goto L17;
        Throwable r103 = r102.getCause();
        if (r103 == null) goto L10;
        r102 = r103;
    L10:
        this.mCause = r102;
        if ((r102 instanceof CameraUnavailableException) == false) goto L14;
        this.mStatus = 2;
        return;
    L14:
        if ((r102 instanceof IllegalArgumentException) == false) goto L16;
        this.mStatus = 1;
        return;
    L16:
        this.mStatus = 0;
        return;
    L17:
        this.mStatus = 0;
        this.mCause = r102;
    }
}
