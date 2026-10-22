package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes17.dex */
public abstract class WorkRequest {
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private UUID mId;
    private Set<String> mTags;
    private WorkSpec mWorkSpec;

    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        boolean mBackoffCriteriaSet;
        UUID mId;
        Set<String> mTags;
        WorkSpec mWorkSpec;
        Class<? extends ListenableWorker> mWorkerClass;

        public abstract W buildInternal();

        public abstract B getThis();

        public final W build() {
            W r100 = (W) buildInternal();
            Constraints r101 = this.mWorkSpec.constraints;
            int r102 = Build.VERSION.SDK_INT;
            if (r102 < 24) goto L7;
            if (r101.hasContentUriTriggers() == false) goto L7;
        L16:
            boolean r103 = true;
        L17:
            WorkSpec r104 = this.mWorkSpec;
            if (r104.expedited == false) goto L27;
            if (r103 == true) goto L26;
            if (r104.initialDelay <= 0) goto L27;
            throw new IllegalArgumentException("Expedited jobs cannot be delayed");
        L26:
            throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
        L27:
            this.mId = UUID.randomUUID();
            WorkSpec r105 = new WorkSpec(this.mWorkSpec);
            this.mWorkSpec = r105;
            r105.f15686id = this.mId.toString();
            return r100;
        L7:
            if (r101.requiresBatteryNotLow() == true) goto L16;
            if (r101.requiresCharging() == true) goto L16;
            if (r102 >= 23) goto L13;
        L15:
            r103 = false;
            goto L17
        L13:
            if (r101.requiresDeviceIdle() == false) goto L15;
            goto L15
        }

        public Builder(Class<? extends ListenableWorker> r100) {
            this.mBackoffCriteriaSet = false;
            this.mTags = new HashSet();
            this.mId = UUID.randomUUID();
            this.mWorkerClass = r100;
            this.mWorkSpec = new WorkSpec(this.mId.toString(), r100.getName());
            addTag(r100.getName());
        }

        public final B addTag(String r100) {
            this.mTags.add(r100);
            return (B) getThis();
        }

        public final B keepResultsForAtLeast(Duration r100) {
            WorkSpec r101 = this.mWorkSpec;
            r101.minimumRetentionDuration = r100.toMillis();
            return (B) getThis();
        }

        public final B setConstraints(Constraints r100) {
            this.mWorkSpec.constraints = r100;
            return (B) getThis();
        }

        public B setExpedited(OutOfQuotaPolicy r100) {
            WorkSpec r101 = this.mWorkSpec;
            r101.expedited = true;
            r101.outOfQuotaPolicy = r100;
            return (B) getThis();
        }

        public B setInitialDelay(Duration r100) {
            WorkSpec r101 = this.mWorkSpec;
            r101.initialDelay = r100.toMillis();
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.mWorkSpec.initialDelay) goto L7;
            return (B) getThis();
        L7:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final B setInitialRunAttemptCount(int r100) {
            this.mWorkSpec.runAttemptCount = r100;
            return (B) getThis();
        }

        public final B setInitialState(WorkInfo.State r100) {
            this.mWorkSpec.state = r100;
            return (B) getThis();
        }

        public final B setInputData(Data r100) {
            this.mWorkSpec.input = r100;
            return (B) getThis();
        }

        public final B keepResultsForAtLeast(long r100, TimeUnit r101) {
            WorkSpec r102 = this.mWorkSpec;
            r102.minimumRetentionDuration = r101.toMillis(r100);
            return (B) getThis();
        }

        public final B setBackoffCriteria(BackoffPolicy r100, Duration r101) {
            this.mBackoffCriteriaSet = true;
            WorkSpec r102 = this.mWorkSpec;
            r102.backoffPolicy = r100;
            r102.setBackoffDelayDuration(r101.toMillis());
            return (B) getThis();
        }

        public B setInitialDelay(long r100, TimeUnit r101) {
            WorkSpec r102 = this.mWorkSpec;
            r102.initialDelay = r101.toMillis(r100);
            if ((Long.MAX_VALUE - System.currentTimeMillis()) <= this.mWorkSpec.initialDelay) goto L7;
            return (B) getThis();
        L7:
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
        }

        public final B setPeriodStartTime(long r100, TimeUnit r101) {
            WorkSpec r102 = this.mWorkSpec;
            r102.periodStartTime = r101.toMillis(r100);
            return (B) getThis();
        }

        public final B setScheduleRequestedAt(long r100, TimeUnit r101) {
            WorkSpec r102 = this.mWorkSpec;
            r102.scheduleRequestedAt = r101.toMillis(r100);
            return (B) getThis();
        }

        public final B setBackoffCriteria(BackoffPolicy r100, long r101, TimeUnit r102) {
            this.mBackoffCriteriaSet = true;
            WorkSpec r103 = this.mWorkSpec;
            r103.backoffPolicy = r100;
            r103.setBackoffDelayDuration(r102.toMillis(r101));
            return (B) getThis();
        }
    }

    public String getStringId() {
        return this.mId.toString();
    }

    public UUID getId() {
        return this.mId;
    }

    public Set<String> getTags() {
        return this.mTags;
    }

    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    public WorkRequest(UUID r100, WorkSpec r101, Set<String> r102) {
        this.mId = r100;
        this.mWorkSpec = r101;
        this.mTags = r102;
    }
}
