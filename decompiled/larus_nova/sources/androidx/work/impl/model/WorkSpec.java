package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes17.dex */
public final class WorkSpec {
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = null;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = null;
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f15686id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    public long periodStartTime;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    public String workerClassName;

    public static class IdAndState {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f15687id;
        public WorkInfo.State state;

        public IdAndState() {
        }

        public int hashCode() {
            return (this.f15687id.hashCode() * 31) + this.state.hashCode();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof IdAndState) == true) goto L8;
            return false;
        L8:
            IdAndState r101 = (IdAndState) r100;
            if (this.state == r101.state) goto L12;
            return false;
        L12:
            return this.f15687id.equals(r101.f15687id);
        }
    }

    public static class WorkInfoPojo {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f15688id;
        public Data output;
        public List<Data> progress;
        public int runAttemptCount;
        public WorkInfo.State state;
        public List<String> tags;

        public WorkInfoPojo() {
        }

        public int hashCode() {
            String r100 = this.f15688id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            WorkInfo.State r104 = this.state;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Data r107 = this.output;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (((r106 + r108) * 31) + this.runAttemptCount) * 31;
            List<String> r110 = this.tags;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            List<Data> r113 = this.progress;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return r112 + r101;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public WorkInfo toWorkInfo() {
            List<Data> r100 = this.progress;
            if (r100 != null) goto L5;
        L7:
            Data r101 = Data.EMPTY;
        L8:
            UUID r102 = UUID.fromString(this.f15688id);
            WorkInfo.State r103 = this.state;
            Data r104 = this.output;
            List<String> r105 = this.tags;
            return new WorkInfo(r102, r103, r104, r105, r101, this.runAttemptCount);
        L5:
            if (r100.isEmpty() == true) goto L7;
            r101 = (Data) ListProtector.get(this.progress, 0);
            goto L8
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WorkInfoPojo) == true) goto L8;
            return false;
        L8:
            WorkInfoPojo r101 = (WorkInfoPojo) r100;
            if (this.runAttemptCount == r101.runAttemptCount) goto L11;
            return false;
        L11:
            String r102 = this.f15688id;
            if (r102 == null) goto L17;
            if (r102.equals(r101.f15688id) == true) goto L20;
        L18:
            return false;
        L20:
            if (this.state == r101.state) goto L22;
            return false;
        L22:
            Data r103 = this.output;
            if (r103 == null) goto L28;
            if (r103.equals(r101.output) == false) goto L29;
        L30:
            List<String> r104 = this.tags;
            if (r104 == null) goto L36;
            if (r104.equals(r101.tags) == false) goto L37;
        L38:
            List<Data> r105 = this.progress;
            List<Data> r106 = r101.progress;
            if (r105 != null) goto L45;
            if (r106 == null) goto L46;
            return false;
        L46:
            return true;
        L45:
            return r105.equals(r106);
        L37:
            return false;
        L36:
            if (r101.tags == null) goto L38;
        L29:
            return false;
        L28:
            if (r101.output == null) goto L30;
        L17:
            if (r101.f15688id == null) goto L20;
            goto L18
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkSpec");
        WORK_INFO_MAPPER = new AnonymousClass1();
    }

    public boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public int hashCode() {
        int r100 = ((((this.f15686id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String r101 = this.inputMergerClassName;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (((((r100 + r102) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31;
        long r104 = this.initialDelay;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.intervalDuration;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.flexDuration;
        int r109 = (((((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.constraints.hashCode()) * 31) + this.runAttemptCount) * 31) + this.backoffPolicy.hashCode()) * 31;
        long r110 = this.backoffDelayDuration;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.periodStartTime;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.minimumRetentionDuration;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.scheduleRequestedAt;
        return ((((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + (this.expedited ? 1 : 0)) * 31) + this.outOfQuotaPolicy.hashCode();
    L5:
        r102 = 0;
        goto L6
    }

    public boolean isBackedOff() {
        if (this.state == WorkInfo.State.ENQUEUED) goto L5;
    L7:
        return false;
    L5:
        if (this.runAttemptCount <= 0) goto L7;
        return true;
    }

    public boolean isPeriodic() {
        if (this.intervalDuration == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "{WorkSpec: " + this.f15686id + i.f25855d;
    }

    public long calculateNextRunTime() {
        boolean r100 = false;
        if (isBackedOff() == true) goto L5;
        long r101 = 0;
        if (isPeriodic() == false) goto L33;
        long r102 = System.currentTimeMillis();
        long r103 = this.periodStartTime;
        if (r103 != 0) goto L17;
        long r104 = r102 + this.initialDelay;
    L18:
        long r105 = this.flexDuration;
        long r110 = this.intervalDuration;
        if (r105 == r110) goto L21;
        r100 = true;
    L21:
        if (r100 == false) goto L28;
        if (r103 != 0) goto L26;
        r101 = r105 * (-1);
    L26:
        return (r104 + r110) + r101;
    L28:
        if (r103 == 0) goto L32;
        r101 = r110;
    L32:
        return r104 + r101;
    L17:
        r104 = r103;
        goto L18
    L33:
        long r106 = this.periodStartTime;
        if (r106 != 0) goto L37;
        r106 = System.currentTimeMillis();
    L37:
        return r106 + this.initialDelay;
    L5:
        if (this.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        r100 = true;
    L7:
        if (r100 == false) goto L9;
        long r107 = this.backoffDelayDuration * ((long) this.runAttemptCount);
    L11:
        return this.periodStartTime + Math.min(WorkRequest.MAX_BACKOFF_MILLIS, r107);
    L9:
        r107 = (long) Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1);
        goto L11
    }

    public WorkSpec(WorkSpec r100) {
        this.state = WorkInfo.State.ENQUEUED;
        Data r101 = Data.EMPTY;
        this.input = r101;
        this.output = r101;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f15686id = r100.f15686id;
        this.workerClassName = r100.workerClassName;
        this.state = r100.state;
        this.inputMergerClassName = r100.inputMergerClassName;
        this.input = new Data(r100.input);
        this.output = new Data(r100.output);
        this.initialDelay = r100.initialDelay;
        this.intervalDuration = r100.intervalDuration;
        this.flexDuration = r100.flexDuration;
        this.constraints = new Constraints(r100.constraints);
        this.runAttemptCount = r100.runAttemptCount;
        this.backoffPolicy = r100.backoffPolicy;
        this.backoffDelayDuration = r100.backoffDelayDuration;
        this.periodStartTime = r100.periodStartTime;
        this.minimumRetentionDuration = r100.minimumRetentionDuration;
        this.scheduleRequestedAt = r100.scheduleRequestedAt;
        this.expedited = r100.expedited;
        this.outOfQuotaPolicy = r100.outOfQuotaPolicy;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L71:
        return false;
    L8:
        if (WorkSpec.class != r100.getClass()) goto L71;
        WorkSpec r101 = (WorkSpec) r100;
        if (this.initialDelay == r101.initialDelay) goto L14;
        return false;
    L14:
        if (this.intervalDuration == r101.intervalDuration) goto L17;
        return false;
    L17:
        if (this.flexDuration == r101.flexDuration) goto L20;
        return false;
    L20:
        if (this.runAttemptCount == r101.runAttemptCount) goto L23;
        return false;
    L23:
        if (this.backoffDelayDuration == r101.backoffDelayDuration) goto L26;
        return false;
    L26:
        if (this.periodStartTime == r101.periodStartTime) goto L29;
        return false;
    L29:
        if (this.minimumRetentionDuration == r101.minimumRetentionDuration) goto L32;
        return false;
    L32:
        if (this.scheduleRequestedAt == r101.scheduleRequestedAt) goto L35;
        return false;
    L35:
        if (this.expedited == r101.expedited) goto L38;
        return false;
    L38:
        if (this.f15686id.equals(r101.f15686id) == true) goto L41;
        return false;
    L41:
        if (this.state == r101.state) goto L44;
        return false;
    L44:
        if (this.workerClassName.equals(r101.workerClassName) == true) goto L46;
        return false;
    L46:
        String r102 = this.inputMergerClassName;
        if (r102 == null) goto L52;
        if (r102.equals(r101.inputMergerClassName) == true) goto L55;
    L53:
        return false;
    L55:
        if (this.input.equals(r101.input) == true) goto L58;
        return false;
    L58:
        if (this.output.equals(r101.output) == true) goto L61;
        return false;
    L61:
        if (this.constraints.equals(r101.constraints) == true) goto L64;
        return false;
    L64:
        if (this.backoffPolicy == r101.backoffPolicy) goto L67;
        return false;
    L67:
        if (this.outOfQuotaPolicy == r101.outOfQuotaPolicy) goto L72;
        return false;
    L72:
        return true;
    L52:
        if (r101.inputMergerClassName == null) goto L55;
        goto L53
    }

    public void setBackoffDelayDuration(long r100) {
        if (r100 <= WorkRequest.MAX_BACKOFF_MILLIS) goto L6;
        Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value", new Throwable[0]);
        r100 = 18000000;
    L6:
        if (r100 >= 10000) goto L8;
        Logger.get().warning(TAG, "Backoff delay duration less than minimum value", new Throwable[0]);
        r100 = 10000;
    L8:
        this.backoffDelayDuration = r100;
    }

    public void setPeriodic(long r100) {
        if (r100 >= 900000) goto L5;
        Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L}), new Throwable[0]);
        r100 = 900000;
    L5:
        setPeriodic(r100, r100);
    }

    public WorkSpec(String r100, String r101) {
        this.state = WorkInfo.State.ENQUEUED;
        Data r102 = Data.EMPTY;
        this.input = r102;
        this.output = r102;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = BackoffPolicy.EXPONENTIAL;
        this.backoffDelayDuration = 30000;
        this.scheduleRequestedAt = -1;
        this.outOfQuotaPolicy = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f15686id = r100;
        this.workerClassName = r101;
    }

    public void setPeriodic(long r100, long r101) {
        if (r100 >= 900000) goto L6;
        Logger.get().warning(TAG, String.format("Interval duration lesser than minimum allowed value; Changed to %s", new Object[]{900000L}), new Throwable[0]);
        r100 = 900000;
    L6:
        if (r101 >= 300000) goto L9;
        Logger.get().warning(TAG, String.format("Flex duration lesser than minimum allowed value; Changed to %s", new Object[]{300000L}), new Throwable[0]);
        r101 = 300000;
    L9:
        if (r101 <= r100) goto L11;
        Logger.get().warning(TAG, String.format("Flex duration greater than interval duration; Changed to %s", new Object[]{Long.valueOf(r100)}), new Throwable[0]);
        r101 = r100;
    L11:
        this.intervalDuration = r100;
        this.flexDuration = r101;
    }
}
