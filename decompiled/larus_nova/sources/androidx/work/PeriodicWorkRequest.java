package androidx.work;

import android.os.Build;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes17.dex */
public final class PeriodicWorkRequest extends WorkRequest {
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        @Override // androidx.work.WorkRequest.Builder
        public Builder getThis() {
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        public PeriodicWorkRequest buildInternal() {
            if (this.mBackoffCriteriaSet == false) goto L12;
            if (Build.VERSION.SDK_INT < 23) goto L12;
            if (this.mWorkSpec.constraints.requiresDeviceIdle() == false) goto L12;
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        L12:
            if (this.mWorkSpec.expedited == true) goto L16;
            return new PeriodicWorkRequest(this);
        L16:
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest.Builder getThis() {
            return getThis();
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest buildInternal() {
            return buildInternal();
        }

        public Builder(Class<? extends ListenableWorker> r100, Duration r101) {
            super(r100);
            this.mWorkSpec.setPeriodic(r101.toMillis());
        }

        public Builder(Class<? extends ListenableWorker> r100, Duration r101, Duration r102) {
            super(r100);
            this.mWorkSpec.setPeriodic(r101.toMillis(), r102.toMillis());
        }

        public Builder(Class<? extends ListenableWorker> r100, long r101, TimeUnit r102) {
            super(r100);
            this.mWorkSpec.setPeriodic(r102.toMillis(r101));
        }

        public Builder(Class<? extends ListenableWorker> r100, long r101, TimeUnit r102, long r103, TimeUnit r104) {
            super(r100);
            this.mWorkSpec.setPeriodic(r102.toMillis(r101), r104.toMillis(r103));
        }
    }

    public PeriodicWorkRequest(Builder r100) {
        super(r100.mId, r100.mWorkSpec, r100.mTags);
    }
}
