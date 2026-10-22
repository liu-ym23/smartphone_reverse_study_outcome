package com.android.server.autofill;

import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class FieldClassificationEventLogger {
    public static final int STATUS_CANCELLED = 3;
    public static final int STATUS_FAIL = 2;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_UNKNOWN = 0;
    private static final String TAG = "FieldClassificationEventLogger";
    private Optional<FieldClassificationEventInternal> mEventInternal;

    private static final class FieldClassificationEventInternal {
        int mAppPackageUid;
        int mCountClassifications;
        boolean mIsSessionGc;
        long mLatencyClassificationRequestMillis;
        int mNextFillRequestId;
        int mRequestId;
        int mSessionId;
        int mStatus;

        FieldClassificationEventInternal() {
            this.mLatencyClassificationRequestMillis = -1;
            this.mCountClassifications = -1;
            this.mSessionId = -1;
            this.mRequestId = -1;
            this.mNextFillRequestId = -1;
            this.mAppPackageUid = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldClassificationStatus {
    }

    public static /* synthetic */ void $r8$lambda$3Q_Q_CxUyra6xw5awlgWdcO7eFU(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetSessionId$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$JckCvfx21W9S-KpiQqy-fgVlYQg, reason: not valid java name */
    public static /* synthetic */ void m2276$r8$lambda$JckCvfx21W9SKpiQqyfgVlYQg(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetCountClassifications$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ON-CG3AJtzAJuOGpv4GlBJzTrKg, reason: not valid java name */
    public static /* synthetic */ void m2277$r8$lambda$ONCG3AJtzAJuOGpv4GlBJzTrKg(long r0, FieldClassificationEventInternal r2) {
        lambda$maybeSetLatencyMillis$0(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$TBCcbY8h9ZW0darqC2ApqqH0iTQ(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetRequestStatus$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$c_qNDsg3exQGg4t9r7v_evNKS14(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetNextFillRequestId$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$rqPjZCqY_47A2xjd_2DUYW8avxA(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetRequestId$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$x2gYRUpZZ5jAi4MkMpAjIWXa2_g(int r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetAppPackageUid$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xqPIU9CQ3eBdDLWooILzLp3g3Po(boolean r0, FieldClassificationEventInternal r1) {
        lambda$maybeSetSessionGc$7(r0, r1);
    }

    private FieldClassificationEventLogger() {
        this.mEventInternal = Optional.empty();
    }

    public static FieldClassificationEventLogger createLogger() {
        return new FieldClassificationEventLogger();
    }

    public void startNewLogForRequest() {
        if (this.mEventInternal.isEmpty() == true) goto L5;
        Slog.w(TAG, "FieldClassificationEventLogger is not empty before starting for a new request");
    L5:
        this.mEventInternal = Optional.of(new FieldClassificationEventInternal());
    }

    public void maybeSetLatencyMillis(final long timestamp) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda3(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyMillis$0(long timestamp, FieldClassificationEventInternal event) {
        event.mLatencyClassificationRequestMillis = timestamp;
    }

    public void maybeSetCountClassifications(final int countClassifications) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda2(countClassifications));
    }

    private static /* synthetic */ void lambda$maybeSetCountClassifications$1(int countClassifications, FieldClassificationEventInternal event) {
        event.mCountClassifications = countClassifications;
    }

    public void maybeSetSessionId(final int sessionId) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda6(sessionId));
    }

    private static /* synthetic */ void lambda$maybeSetSessionId$2(int sessionId, FieldClassificationEventInternal event) {
        event.mSessionId = sessionId;
    }

    public void maybeSetRequestId(final int requestId) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda4(requestId));
    }

    private static /* synthetic */ void lambda$maybeSetRequestId$3(int requestId, FieldClassificationEventInternal event) {
        event.mRequestId = requestId;
    }

    public void maybeSetNextFillRequestId(final int nextFillRequestId) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda1(nextFillRequestId));
    }

    private static /* synthetic */ void lambda$maybeSetNextFillRequestId$4(int nextFillRequestId, FieldClassificationEventInternal event) {
        event.mNextFillRequestId = nextFillRequestId;
    }

    public void maybeSetAppPackageUid(final int uid) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda5(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAppPackageUid$5(int uid, FieldClassificationEventInternal event) {
        event.mAppPackageUid = uid;
    }

    public void maybeSetRequestStatus(final int status) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda0(status));
    }

    private static /* synthetic */ void lambda$maybeSetRequestStatus$6(int status, FieldClassificationEventInternal event) {
        event.mStatus = status;
    }

    public void maybeSetSessionGc(final boolean isSessionGc) {
        this.mEventInternal.ifPresent(new FieldClassificationEventLogger$$ExternalSyntheticLambda7(isSessionGc));
    }

    private static /* synthetic */ void lambda$maybeSetSessionGc$7(boolean isSessionGc, FieldClassificationEventInternal event) {
        event.mIsSessionGc = isSessionGc;
    }

    public void logAndEndEvent() {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillFieldClassificationEventInternal again for same event");
        return;
    L6:
        FieldClassificationEventInternal event = this.mEventInternal.get();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Log AutofillFieldClassificationEventReported: mLatencyClassificationRequestMillis=" + event.mLatencyClassificationRequestMillis + " mCountClassifications=" + event.mCountClassifications + " mSessionId=" + event.mSessionId + " mRequestId=" + event.mRequestId + " mNextFillRequestId=" + event.mNextFillRequestId + " mAppPackageUid=" + event.mAppPackageUid + " mStatus=" + event.mStatus + " mIsSessionGc=" + event.mIsSessionGc);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_FIELD_CLASSIFICATION_EVENT_REPORTED, event.mLatencyClassificationRequestMillis, event.mCountClassifications, event.mSessionId, event.mRequestId, event.mNextFillRequestId, event.mAppPackageUid, event.mStatus, event.mIsSessionGc);
        this.mEventInternal = Optional.empty();
    }
}
