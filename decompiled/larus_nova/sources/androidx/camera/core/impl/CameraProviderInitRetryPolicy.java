package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.RetryPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class CameraProviderInitRetryPolicy implements RetryPolicyInternal {
    private final RetryPolicy mDelegatePolicy;

    public static final class Legacy implements RetryPolicyInternal {
        private final RetryPolicy mBasePolicy;

        @Override // androidx.camera.core.RetryPolicy
        public long getTimeoutInMillis() {
            return this.mBasePolicy.getTimeoutInMillis();
        }

        public Legacy(long r100) {
            this.mBasePolicy = new CameraProviderInitRetryPolicy(r100);
        }

        @Override // androidx.camera.core.impl.RetryPolicyInternal
        public RetryPolicy copy(long r100) {
            return new Legacy(r100);
        }

        @Override // androidx.camera.core.RetryPolicy
        public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r100) {
            if (this.mBasePolicy.onRetryDecisionRequested(r100).shouldRetry() == true) goto L13;
            Throwable r101 = r100.getCause();
            if ((r101 instanceof CameraValidator.CameraIdListIncorrectException) == false) goto L11;
            Logger.e("CameraX", "The device might underreport the amount of the cameras. Finish the initialize task since we are already reaching the maximum number of retries.");
            if (((CameraValidator.CameraIdListIncorrectException) r101).getAvailableCameraCount() <= 0) goto L11;
            return RetryPolicy.RetryConfig.COMPLETE_WITHOUT_FAILURE;
        L11:
            return RetryPolicy.RetryConfig.NOT_RETRY;
        L13:
            return RetryPolicy.RetryConfig.DEFAULT_DELAY_RETRY;
        }
    }

    @Override // androidx.camera.core.RetryPolicy
    public long getTimeoutInMillis() {
        return this.mDelegatePolicy.getTimeoutInMillis();
    }

    public CameraProviderInitRetryPolicy(final long r100) {
        this.mDelegatePolicy = new TimeoutRetryPolicy(r100, new AnonymousClass1(this, r100));
    }

    @Override // androidx.camera.core.impl.RetryPolicyInternal
    public RetryPolicy copy(long r100) {
        return new CameraProviderInitRetryPolicy(r100);
    }

    @Override // androidx.camera.core.RetryPolicy
    public RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState r100) {
        return this.mDelegatePolicy.onRetryDecisionRequested(r100);
    }
}
