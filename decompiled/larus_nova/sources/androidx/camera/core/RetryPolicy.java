package androidx.camera.core;

import androidx.camera.core.impl.CameraProviderInitRetryPolicy;
import androidx.camera.core.impl.RetryPolicyInternal;
import androidx.camera.core.impl.TimeoutRetryPolicy;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface RetryPolicy {
    public static final RetryPolicy DEFAULT = null;
    public static final long DEFAULT_RETRY_TIMEOUT_IN_MILLIS = 6000;
    public static final RetryPolicy NEVER = null;
    public static final RetryPolicy RETRY_UNAVAILABLE_CAMERA = null;

    /* JADX INFO: renamed from: androidx.camera.core.RetryPolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getTimeoutInMillis(RetryPolicy r100) {
            return 0;
        }

        static {
            RetryPolicy r100 = RetryPolicy.NEVER;
        }

        public static long getDefaultRetryTimeoutInMillis() {
            return RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        }

        public static /* synthetic */ RetryConfig lambda$static$0(ExecutionState r100) {
            return RetryConfig.NOT_RETRY;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.core.RetryPolicy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private final RetryPolicy mBasePolicy;
        private long mTimeoutInMillis;

        public RetryPolicy build() {
            RetryPolicy r100 = this.mBasePolicy;
            if ((r100 instanceof RetryPolicyInternal) == false) goto L7;
            return ((RetryPolicyInternal) r100).copy(this.mTimeoutInMillis);
        L7:
            return new TimeoutRetryPolicy(this.mTimeoutInMillis, r100);
        }

        public Builder(RetryPolicy r100) {
            this.mBasePolicy = r100;
            this.mTimeoutInMillis = r100.getTimeoutInMillis();
        }

        public Builder setTimeoutInMillis(long r100) {
            this.mTimeoutInMillis = r100;
            return this;
        }
    }

    public interface ExecutionState {
        public static final int STATUS_CAMERA_UNAVAILABLE = 2;
        public static final int STATUS_CONFIGURATION_FAIL = 1;
        public static final int STATUS_UNKNOWN_ERROR = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
        }

        Throwable getCause();

        long getExecutedTimeInMillis();

        int getNumOfAttempts();

        int getStatus();
    }

    public static final class RetryConfig {
        public static RetryConfig COMPLETE_WITHOUT_FAILURE = null;
        private static final long DEFAULT_DELAY_MILLIS = 500;
        public static final RetryConfig DEFAULT_DELAY_RETRY = null;
        private static final long MINI_DELAY_MILLIS = 100;
        public static final RetryConfig MINI_DELAY_RETRY = null;
        public static final RetryConfig NOT_RETRY = null;
        private final boolean mCompleteWithoutFailure;
        private final long mDelayInMillis;
        private final boolean mShouldRetry;

        public static final class Builder {
            private boolean mShouldRetry;
            private long mTimeoutInMillis;

            public RetryConfig build() {
                return new RetryConfig(this.mShouldRetry, this.mTimeoutInMillis, null);
            }

            public Builder() {
                this.mShouldRetry = true;
                this.mTimeoutInMillis = RetryConfig.getDefaultRetryDelayInMillis();
            }

            public Builder setRetryDelayInMillis(long r100) {
                this.mTimeoutInMillis = r100;
                return this;
            }

            public Builder setShouldRetry(boolean r100) {
                this.mShouldRetry = r100;
                return this;
            }
        }

        public static long getDefaultRetryDelayInMillis() {
            return 500;
        }

        static {
            NOT_RETRY = new RetryConfig(false, 0);
            DEFAULT_DELAY_RETRY = new RetryConfig(true);
            MINI_DELAY_RETRY = new RetryConfig(true, 100);
            COMPLETE_WITHOUT_FAILURE = new RetryConfig(false, 0, true);
        }

        public long getRetryDelayInMillis() {
            return this.mDelayInMillis;
        }

        public boolean shouldCompleteWithoutFailure() {
            return this.mCompleteWithoutFailure;
        }

        public boolean shouldRetry() {
            return this.mShouldRetry;
        }

        private RetryConfig(boolean r100) {
            this(r100, getDefaultRetryDelayInMillis());
        }

        private RetryConfig(boolean r100, long r101) {
            this(r100, r101, false);
        }

        private RetryConfig(boolean r100, long r101, boolean r102) {
            this.mShouldRetry = r100;
            this.mDelayInMillis = r101;
            if (r102 == false) goto L5;
            Preconditions.checkArgument(!r100, "shouldRetry must be false when completeWithoutFailure is set to true");
        L5:
            this.mCompleteWithoutFailure = r102;
        }

        public /* synthetic */ RetryConfig(boolean r100, long r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    long getTimeoutInMillis();

    RetryConfig onRetryDecisionRequested(ExecutionState r100);

    static {
        NEVER = new d0();
        DEFAULT = new CameraProviderInitRetryPolicy.Legacy(CC.getDefaultRetryTimeoutInMillis());
        RETRY_UNAVAILABLE_CAMERA = new CameraProviderInitRetryPolicy(CC.getDefaultRetryTimeoutInMillis());
    }
}
