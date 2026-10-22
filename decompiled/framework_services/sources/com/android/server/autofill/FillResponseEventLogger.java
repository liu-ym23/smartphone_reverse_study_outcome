package com.android.server.autofill;

import android.os.SystemClock;
import android.service.autofill.Dataset;
import android.util.Slog;
import android.view.autofill.AutofillId;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class FillResponseEventLogger {
    public static final int AUTHENTICATION_RESULT_FAILURE = 2;
    public static final int AUTHENTICATION_RESULT_SUCCESS = 1;
    public static final int AUTHENTICATION_RESULT_UNKNOWN = 0;
    public static final int AUTHENTICATION_TYPE_DATASET_AHTHENTICATION = 1;
    public static final int AUTHENTICATION_TYPE_FULL_AHTHENTICATION = 2;
    public static final int AUTHENTICATION_TYPE_UNKNOWN = 0;
    public static final int AVAILABLE_COUNT_WHEN_FILL_REQUEST_FAILED_OR_TIMEOUT = -1;
    public static final int DETECTION_PREFER_AUTOFILL_PROVIDER = 1;
    public static final int DETECTION_PREFER_PCC = 2;
    public static final int DETECTION_PREFER_UNKNOWN = 0;
    public static final int DISPLAY_PRESENTATION_TYPE_DIALOG = 3;
    public static final int DISPLAY_PRESENTATION_TYPE_INLINE = 2;
    public static final int DISPLAY_PRESENTATION_TYPE_MENU = 1;
    public static final int DISPLAY_PRESENTATION_TYPE_UNKNOWN = 0;
    public static final int HAVE_SAVE_TRIGGER_ID = 1;
    public static final int RESPONSE_STATUS_CANCELLED = 3;
    public static final int RESPONSE_STATUS_FAILURE = 1;
    public static final int RESPONSE_STATUS_SESSION_DESTROYED = 5;
    public static final int RESPONSE_STATUS_SUCCESS = 2;
    public static final int RESPONSE_STATUS_TIMEOUT = 4;
    public static final int RESPONSE_STATUS_TRANSACTION_TOO_LARGE = 6;
    public static final int RESPONSE_STATUS_UNKNOWN = 0;
    private static final String TAG = "FillResponseEventLogger";
    private static final long UNINITIALIZED_TIMESTAMP = -1;
    private Optional<FillResponseEventInternal> mEventInternal;
    private final int mSessionId;
    private long startResponseProcessingTimestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthenticationResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthenticationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DetectionPreference {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayPresentationType {
    }

    private static final class FillResponseEventInternal {
        int mAppPackageUid;
        int mAuthenticationFailureReason;
        int mAuthenticationResult;
        int mAuthenticationType;
        int mAvailableCount;
        int mAvailablePccCount;
        int mAvailablePccOnlyCount;
        int mDetectionPref;
        int mDisplayPresentationType;
        int mLatencyAuthenticationUiDisplayMillis;
        int mLatencyDatasetDisplayMillis;
        int mLatencyFillResponseReceivedMillis;
        long mLatencyResponseProcessingMillis;
        int mRequestId;
        int mResponseStatus;
        int mSaveUiTriggerIds;
        int mTotalDatasetsProvided;

        FillResponseEventInternal() {
            this.mRequestId = -1;
            this.mAppPackageUid = -1;
            this.mDisplayPresentationType = 0;
            this.mAvailableCount = 0;
            this.mSaveUiTriggerIds = -1;
            this.mLatencyFillResponseReceivedMillis = -1;
            this.mAuthenticationType = 0;
            this.mAuthenticationResult = 0;
            this.mAuthenticationFailureReason = -1;
            this.mLatencyAuthenticationUiDisplayMillis = -1;
            this.mLatencyDatasetDisplayMillis = -1;
            this.mResponseStatus = 0;
            this.mLatencyResponseProcessingMillis = -1;
            this.mAvailablePccCount = -1;
            this.mAvailablePccOnlyCount = -1;
            this.mTotalDatasetsProvided = -1;
            this.mDetectionPref = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResponseStatus {
    }

    public static /* synthetic */ void $r8$lambda$0SVvZgJluIjJEoZ0Bngpf2tfSgk(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetResponseStatus$13(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$2Xyi8ZwyoSDdudF-der-5D5iuTQ, reason: not valid java name */
    public static /* synthetic */ void m2288$r8$lambda$2Xyi8ZwyoSDdudFder5D5iuTQ(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetDetectionPreference$18(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5F9kb4lLADxpQmWRph3-XQQpBE0, reason: not valid java name */
    public static /* synthetic */ void m2289$r8$lambda$5F9kb4lLADxpQmWRph3XQQpBE0(FillResponseEventLogger r0, FillResponseEventInternal r1) {
        r0.lambda$maybeSetLatencyResponseProcessingMillis$14(r1);
    }

    public static /* synthetic */ void $r8$lambda$5Up8iUb67YZh43rTSkZ0obC6Mvw(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetTotalDatasetsProvided$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$63APLJWVVNPbSRr8bMXQnfbbmAM(List r0, AutofillId r1, FillResponseEventInternal r2) {
        lambda$maybeSetAvailableCount$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$9XXa9CLQODjefrwmdBOCryFMDJw(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAvailablePccOnlyCount$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$E7H5KCNYQtQsXFKUrGaKYvyNJe4(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAuthenticationType$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$FEb71_Aly0uPssr9OGjybjeoAPE(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetLatencyFillResponseReceivedMillis$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FSgpKa7-ZA4oxf2tLs7ciH4FrJw, reason: not valid java name */
    public static /* synthetic */ void m2290$r8$lambda$FSgpKa7ZA4oxf2tLs7ciH4FrJw(List r0, FillResponseEventInternal r1) {
        lambda$maybeSetDatasetsCountAfterPotentialPccFiltering$17(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JJFHL2IFU1QJ2Dy6RYwed6aqYbI(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAvailableCount$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OsHHTfEXfcUUxjjXztaID-lxgic, reason: not valid java name */
    public static /* synthetic */ void m2291$r8$lambda$OsHHTfEXfcUUxjjXztaIDlxgic(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetLatencyDatasetDisplayMillis$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$T6Lnr3LUwL-IFQtrvQViFRJLD9o, reason: not valid java name */
    public static /* synthetic */ void m2292$r8$lambda$T6Lnr3LUwLIFQtrvQViFRJLD9o(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAuthenticationFailureReason$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Y7JB1pL0EiytCqzz5f_4l4IS2T4(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetRequestId$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$_BHt3bPQez2R0B1ef2LcfsYWabI(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetLatencyAuthenticationUiDisplayMillis$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$n7ygMu9wyKqSXVRpOqn7OxRlM9I(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAvailablePccCount$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nLmC09edZneH5BKbLQIOi5YB4TY(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetDisplayPresentationType$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oAPnNdhqiyiTPP0Pt1UvYyPkHYQ(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAppPackageUid$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$u6YAjw5-I455KGmeMaxj5qeteVA, reason: not valid java name */
    public static /* synthetic */ void m2293$r8$lambda$u6YAjw5I455KGmeMaxj5qeteVA(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetSaveUiTriggerIds$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xQEyPUY7plEXA1nsjhnac2GajE0(int r0, FillResponseEventInternal r1) {
        lambda$maybeSetAuthenticationResult$9(r0, r1);
    }

    private FillResponseEventLogger(int sessionId) {
        this.startResponseProcessingTimestamp = -1;
        this.mSessionId = sessionId;
        this.mEventInternal = Optional.empty();
    }

    public static FillResponseEventLogger forSessionId(int sessionId) {
        return new FillResponseEventLogger(sessionId);
    }

    public void startLogForNewResponse() {
        if (this.mEventInternal.isEmpty() == true) goto L5;
        Slog.w(TAG, "FillResponseEventLogger is not empty before starting for a new request");
    L5:
        this.mEventInternal = Optional.of(new FillResponseEventInternal());
    }

    private static /* synthetic */ void lambda$maybeSetRequestId$0(int val, FillResponseEventInternal event) {
        event.mRequestId = val;
    }

    public void maybeSetRequestId(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda9(val));
    }

    public void maybeSetAppPackageUid(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda1(val));
    }

    private static /* synthetic */ void lambda$maybeSetAppPackageUid$1(int val, FillResponseEventInternal event) {
        event.mAppPackageUid = val;
    }

    public void maybeSetDisplayPresentationType(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda7(val));
    }

    private static /* synthetic */ void lambda$maybeSetDisplayPresentationType$2(int val, FillResponseEventInternal event) {
        event.mDisplayPresentationType = val;
    }

    public void maybeSetAvailableCount(final List<Dataset> datasetList, final AutofillId currentViewId) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda0(datasetList, currentViewId));
    }

    private static /* synthetic */ void lambda$maybeSetAvailableCount$3(List datasetList, AutofillId currentViewId, FillResponseEventInternal event) {
        int availableCount = getDatasetCountForAutofillId(datasetList, currentViewId);
        event.mAvailableCount = availableCount;
    }

    public void maybeSetAvailableCount(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda3(val));
    }

    private static /* synthetic */ void lambda$maybeSetAvailableCount$4(int val, FillResponseEventInternal event) {
        event.mAvailableCount = val;
    }

    public void maybeSetTotalDatasetsProvided(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda10(val));
    }

    private static /* synthetic */ void lambda$maybeSetTotalDatasetsProvided$5(int val, FillResponseEventInternal event) {
        if (event.mTotalDatasetsProvided != (-1)) goto L6;
        event.mTotalDatasetsProvided = val;
        return;
    }

    private static int getDatasetCountForAutofillId(List<Dataset> datasetList, AutofillId currentViewId) {
        int availableCount = 0;
        if (datasetList == null) goto L15;
        int i = 0;
    L6:
        if (i >= datasetList.size()) goto L15;
        Dataset data = datasetList.get(i);
        if (data == null) goto L14;
        if (data.getFieldIds() == null) goto L14;
        if (data.getFieldIds().contains(currentViewId) == false) goto L14;
        availableCount = availableCount + 1;
    L14:
        i = i + 1;
    L15:
        return availableCount;
    }

    public void maybeSetSaveUiTriggerIds(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda2(val));
    }

    private static /* synthetic */ void lambda$maybeSetSaveUiTriggerIds$6(int val, FillResponseEventInternal event) {
        event.mSaveUiTriggerIds = val;
    }

    public void maybeSetLatencyFillResponseReceivedMillis(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda18(val));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyFillResponseReceivedMillis$7(int val, FillResponseEventInternal event) {
        event.mLatencyFillResponseReceivedMillis = val;
    }

    public void maybeSetAuthenticationType(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda13(val));
    }

    private static /* synthetic */ void lambda$maybeSetAuthenticationType$8(int val, FillResponseEventInternal event) {
        event.mAuthenticationType = val;
    }

    public void maybeSetAuthenticationResult(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda12(val));
    }

    private static /* synthetic */ void lambda$maybeSetAuthenticationResult$9(int val, FillResponseEventInternal event) {
        event.mAuthenticationResult = val;
    }

    public void maybeSetAuthenticationFailureReason(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda14(val));
    }

    private static /* synthetic */ void lambda$maybeSetAuthenticationFailureReason$10(int val, FillResponseEventInternal event) {
        event.mAuthenticationFailureReason = val;
    }

    public void maybeSetLatencyAuthenticationUiDisplayMillis(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda5(val));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyAuthenticationUiDisplayMillis$11(int val, FillResponseEventInternal event) {
        event.mLatencyAuthenticationUiDisplayMillis = val;
    }

    public void maybeSetLatencyDatasetDisplayMillis(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda17(val));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyDatasetDisplayMillis$12(int val, FillResponseEventInternal event) {
        event.mLatencyDatasetDisplayMillis = val;
    }

    public void maybeSetResponseStatus(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda6(val));
    }

    private static /* synthetic */ void lambda$maybeSetResponseStatus$13(int val, FillResponseEventInternal event) {
        event.mResponseStatus = val;
    }

    public void startResponseProcessingTime() {
        this.startResponseProcessingTimestamp = SystemClock.elapsedRealtime();
    }

    public void maybeSetLatencyResponseProcessingMillis() {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda11(this));
    }

    private /* synthetic */ void lambda$maybeSetLatencyResponseProcessingMillis$14(FillResponseEventInternal event) {
        if (this.startResponseProcessingTimestamp == (-1)) goto L5;
    L7:
        event.mLatencyResponseProcessingMillis = SystemClock.elapsedRealtime() - this.startResponseProcessingTimestamp;
        return;
    L5:
        if (Helper.sVerbose == false) goto L7;
        Slog.v(TAG, "uninitialized startResponseProcessingTimestamp");
        goto L7
    }

    public void maybeSetAvailablePccCount(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda15(val));
    }

    private static /* synthetic */ void lambda$maybeSetAvailablePccCount$15(int val, FillResponseEventInternal event) {
        event.mAvailablePccCount = val;
    }

    public void maybeSetAvailablePccOnlyCount(final int val) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda16(val));
    }

    private static /* synthetic */ void lambda$maybeSetAvailablePccOnlyCount$16(int val, FillResponseEventInternal event) {
        event.mAvailablePccOnlyCount = val;
    }

    public void maybeSetDatasetsCountAfterPotentialPccFiltering(final List<Dataset> datasetList) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda4(datasetList));
    }

    private static /* synthetic */ void lambda$maybeSetDatasetsCountAfterPotentialPccFiltering$17(List datasetList, FillResponseEventInternal event) {
        int pccOnlyCount = 0;
        int pccCount = 0;
        int totalCount = 0;
        if (datasetList == null) goto L16;
        totalCount = datasetList.size();
        int i = 0;
    L6:
        if (i >= datasetList.size()) goto L16;
        Dataset dataset = (Dataset) datasetList.get(i);
        if (dataset == null) goto L15;
        if (dataset.getEligibleReason() != 4) goto L13;
        pccOnlyCount = pccOnlyCount + 1;
        pccCount = pccCount + 1;
        goto L15
    L13:
        if (dataset.getEligibleReason() != 5) goto L15;
        pccCount = pccCount + 1;
    L15:
        i = i + 1;
    L16:
        event.mAvailablePccOnlyCount = pccOnlyCount;
        event.mAvailablePccCount = pccCount;
        event.mAvailableCount = totalCount;
    }

    public void maybeSetDetectionPreference(final int detectionPreference) {
        this.mEventInternal.ifPresent(new FillResponseEventLogger$$ExternalSyntheticLambda8(detectionPreference));
    }

    private static /* synthetic */ void lambda$maybeSetDetectionPreference$18(int detectionPreference, FillResponseEventInternal event) {
        event.mDetectionPref = detectionPreference;
    }

    public void logAndEndEvent() {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillFillRequestReported again for same event");
        return;
    L6:
        FillResponseEventInternal event = this.mEventInternal.get();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Log AutofillFillResponseReported: requestId=" + event.mRequestId + " sessionId=" + this.mSessionId + " mAppPackageUid=" + event.mAppPackageUid + " mDisplayPresentationType=" + event.mDisplayPresentationType + " mAvailableCount=" + event.mAvailableCount + " mSaveUiTriggerIds=" + event.mSaveUiTriggerIds + " mLatencyFillResponseReceivedMillis=" + event.mLatencyFillResponseReceivedMillis + " mAuthenticationType=" + event.mAuthenticationType + " mAuthenticationResult=" + event.mAuthenticationResult + " mAuthenticationFailureReason=" + event.mAuthenticationFailureReason + " mLatencyAuthenticationUiDisplayMillis=" + event.mLatencyAuthenticationUiDisplayMillis + " mLatencyDatasetDisplayMillis=" + event.mLatencyDatasetDisplayMillis + " mResponseStatus=" + event.mResponseStatus + " mLatencyResponseProcessingMillis=" + event.mLatencyResponseProcessingMillis + " mAvailablePccCount=" + event.mAvailablePccCount + " mAvailablePccOnlyCount=" + event.mAvailablePccOnlyCount + " mTotalDatasetsProvided=" + event.mTotalDatasetsProvided + " mDetectionPref=" + event.mDetectionPref);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_FILL_RESPONSE_REPORTED, event.mRequestId, this.mSessionId, event.mAppPackageUid, event.mDisplayPresentationType, event.mAvailableCount, event.mSaveUiTriggerIds, event.mLatencyFillResponseReceivedMillis, event.mAuthenticationType, event.mAuthenticationResult, event.mAuthenticationFailureReason, event.mLatencyAuthenticationUiDisplayMillis, event.mLatencyDatasetDisplayMillis, event.mResponseStatus, event.mLatencyResponseProcessingMillis, event.mAvailablePccCount, event.mAvailablePccOnlyCount, event.mTotalDatasetsProvided, event.mDetectionPref);
        this.mEventInternal = Optional.empty();
    }
}
