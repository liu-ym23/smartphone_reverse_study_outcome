package com.android.server.autofill;

import android.os.SystemClock;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public class SaveEventLogger {
    public static final int NO_SAVE_REASON_DATASET_MATCH = 7;
    public static final int NO_SAVE_REASON_FIELD_VALIDATION_FAILED = 6;
    public static final int NO_SAVE_REASON_HAS_EMPTY_REQUIRED = 4;
    public static final int NO_SAVE_REASON_NONE = 1;
    public static final int NO_SAVE_REASON_NO_SAVE_INFO = 2;
    public static final int NO_SAVE_REASON_NO_VALUE_CHANGED = 5;
    public static final int NO_SAVE_REASON_SCREEN_HAS_CREDMAN_FIELD = 10;
    public static final int NO_SAVE_REASON_SESSION_DESTROYED = 9;
    public static final int NO_SAVE_REASON_UNKNOWN = 0;
    public static final int NO_SAVE_REASON_WITH_DELAY_SAVE_FLAG = 3;
    public static final int NO_SAVE_REASON_WITH_DONT_SAVE_ON_FINISH_FLAG = 8;
    public static final int SAVE_UI_SHOWN_REASON_OPTIONAL_ID_CHANGE = 2;
    public static final int SAVE_UI_SHOWN_REASON_REQUIRED_ID_CHANGE = 1;
    public static final int SAVE_UI_SHOWN_REASON_TRIGGER_ID_SET = 3;
    public static final int SAVE_UI_SHOWN_REASON_UNKNOWN = 0;
    private static final String TAG = "SaveEventLogger";
    public static final long UNINITIATED_TIMESTAMP = Long.MIN_VALUE;
    private Optional<SaveEventInternal> mEventInternal;
    private final int mSessionId;
    private final long mSessionStartTimestamp;

    private static final class SaveEventInternal {
        int mAppPackageUid;
        boolean mCancelButtonClicked;
        boolean mDialogDismissed;
        long mFlag;
        boolean mIsFrameworkCreatedSaveInfo;
        boolean mIsNewField;
        boolean mIsSaved;
        long mLatencySaveFinishMillis;
        long mLatencySaveRequestMillis;
        long mLatencySaveUiDisplayMillis;
        int mRequestId;
        boolean mSaveButtonClicked;
        int mSaveUiNotShownReason;
        int mSaveUiShownReason;
        int mSaveUiTriggerIds;
        int mServiceUid;

        SaveEventInternal() {
            this.mAppPackageUid = -1;
            this.mSaveUiTriggerIds = -1;
            this.mFlag = -1;
            this.mIsNewField = false;
            this.mSaveUiShownReason = 0;
            this.mSaveUiNotShownReason = 0;
            this.mSaveButtonClicked = false;
            this.mCancelButtonClicked = false;
            this.mDialogDismissed = false;
            this.mIsSaved = false;
            this.mLatencySaveUiDisplayMillis = Long.MIN_VALUE;
            this.mLatencySaveRequestMillis = Long.MIN_VALUE;
            this.mLatencySaveFinishMillis = Long.MIN_VALUE;
            this.mIsFrameworkCreatedSaveInfo = false;
            this.mServiceUid = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveUiNotShownReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveUiShownReason {
    }

    public static /* synthetic */ void $r8$lambda$A16JBUmcZK2GPxVijkkYN95DijM(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetIsNewField$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ActSjgEw7GNLqFgBJ5O2Ut_e-hY, reason: not valid java name */
    public static /* synthetic */ void m2331$r8$lambda$ActSjgEw7GNLqFgBJ5O2Ut_ehY(int r0, SaveEventInternal r1) {
        lambda$maybeSetAutofillServiceUid$15(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BATZhAA-dQgNV7v2Df2qSDAr1DM, reason: not valid java name */
    public static /* synthetic */ void m2332$r8$lambda$BATZhAAdQgNV7v2Df2qSDAr1DM(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetIsFrameworkCreatedSaveInfo$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$BueTQ1MLCqp-nwgw2e8Tpc9WL7w, reason: not valid java name */
    public static /* synthetic */ void m2333$r8$lambda$BueTQ1MLCqpnwgw2e8Tpc9WL7w(long r0, SaveEventInternal r2) {
        lambda$maybeSetLatencySaveRequestMillis$12(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fau-GnFHAxBhd6b4HTPhVSKMGU0, reason: not valid java name */
    public static /* synthetic */ void m2334$r8$lambda$FauGnFHAxBhd6b4HTPhVSKMGU0(int r0, SaveEventInternal r1) {
        lambda$maybeSetSaveUiShownReason$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KM3kfdpT1_FtztVnb3B3WR9S8O4(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetIsSaved$10(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$R14UHEQp3YTr4-ESwSF7zPjPsVo, reason: not valid java name */
    public static /* synthetic */ void m2335$r8$lambda$R14UHEQp3YTr4ESwSF7zPjPsVo(long r0, SaveEventInternal r2) {
        lambda$maybeSetLatencySaveUiDisplayMillis$11(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Svb-BVoThSgsduCJfrVxOUxSfFU, reason: not valid java name */
    public static /* synthetic */ void m2336$r8$lambda$SvbBVoThSgsduCJfrVxOUxSfFU(int r0, SaveEventInternal r1) {
        lambda$maybeSetFlag$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$WvoDHp-2-iU--_ELaItfJfCIafQ, reason: not valid java name */
    public static /* synthetic */ void m2337$r8$lambda$WvoDHp2iU_ELaItfJfCIafQ(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetDialogDismissed$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$bJ8M9Y9akEsS7UPmKZWGStrXz1w(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetCancelButtonClicked$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$dik15tPV8dLfpTrajBceCb8kZQ4(int r0, SaveEventInternal r1) {
        lambda$maybeSetAppPackageUid$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fABNy0GcwdtN9yZlGiloXyRXrbY(int r0, SaveEventInternal r1) {
        lambda$maybeSetSaveUiTriggerIds$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hIFq3MJpTaBU4ULDV66WBknWmu8(int r0, SaveEventInternal r1) {
        lambda$maybeSetRequestId$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$leQ1_sS3kyVxAKaXQjTFdvhQhRg(boolean r0, SaveEventInternal r1) {
        lambda$maybeSetSaveButtonClicked$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$skYRrZjKDm5LEQ0Nk0lCfg3wrZ8(long r0, SaveEventInternal r2) {
        lambda$maybeSetLatencySaveFinishMillis$13(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$t0xCGQLeU5tdk0_cTWbJEMj4lBk(int r0, SaveEventInternal r1) {
        lambda$maybeSetSaveUiNotShownReason$6(r0, r1);
    }

    private SaveEventLogger(int sessionId, long sessionStartTimestamp) {
        this.mSessionId = sessionId;
        this.mEventInternal = Optional.of(new SaveEventInternal());
        this.mSessionStartTimestamp = sessionStartTimestamp;
    }

    public static SaveEventLogger forSessionId(int sessionId, long sessionStartTimestamp) {
        return new SaveEventLogger(sessionId, sessionStartTimestamp);
    }

    private static /* synthetic */ void lambda$maybeSetRequestId$0(int requestId, SaveEventInternal event) {
        event.mRequestId = requestId;
    }

    public void maybeSetRequestId(final int requestId) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda9(requestId));
    }

    public void maybeSetAppPackageUid(final int val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda0(val));
    }

    private static /* synthetic */ void lambda$maybeSetAppPackageUid$1(int val, SaveEventInternal event) {
        event.mAppPackageUid = val;
    }

    public void maybeSetSaveUiTriggerIds(final int val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda15(val));
    }

    private static /* synthetic */ void lambda$maybeSetSaveUiTriggerIds$2(int val, SaveEventInternal event) {
        event.mSaveUiTriggerIds = val;
    }

    public void maybeSetFlag(final int val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda1(val));
    }

    private static /* synthetic */ void lambda$maybeSetFlag$3(int val, SaveEventInternal event) {
        event.mFlag = val;
    }

    public void maybeSetIsNewField(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda8(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsNewField$4(boolean val, SaveEventInternal event) {
        event.mIsNewField = val;
    }

    public void maybeSetSaveUiShownReason(final int reason) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda11(reason));
    }

    private static /* synthetic */ void lambda$maybeSetSaveUiShownReason$5(int reason, SaveEventInternal event) {
        event.mSaveUiShownReason = reason;
    }

    public void maybeSetSaveUiNotShownReason(final int reason) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda14(reason));
    }

    private static /* synthetic */ void lambda$maybeSetSaveUiNotShownReason$6(int reason, SaveEventInternal event) {
        event.mSaveUiNotShownReason = reason;
    }

    public void maybeSetSaveButtonClicked(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda10(val));
    }

    private static /* synthetic */ void lambda$maybeSetSaveButtonClicked$7(boolean val, SaveEventInternal event) {
        event.mSaveButtonClicked = val;
    }

    public void maybeSetCancelButtonClicked(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda4(val));
    }

    private static /* synthetic */ void lambda$maybeSetCancelButtonClicked$8(boolean val, SaveEventInternal event) {
        event.mCancelButtonClicked = val;
    }

    public void maybeSetDialogDismissed(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda13(val));
    }

    private static /* synthetic */ void lambda$maybeSetDialogDismissed$9(boolean val, SaveEventInternal event) {
        event.mDialogDismissed = val;
    }

    public void maybeSetIsSaved(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda6(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsSaved$10(boolean val, SaveEventInternal event) {
        event.mIsSaved = val;
    }

    private long getElapsedTime() {
        return SystemClock.elapsedRealtime() - this.mSessionStartTimestamp;
    }

    public void maybeSetLatencySaveUiDisplayMillis(final long timestamp) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda7(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetLatencySaveUiDisplayMillis$11(long timestamp, SaveEventInternal event) {
        event.mLatencySaveUiDisplayMillis = timestamp;
    }

    public void maybeSetLatencySaveUiDisplayMillis() {
        maybeSetLatencySaveUiDisplayMillis(getElapsedTime());
    }

    public void maybeSetLatencySaveRequestMillis(final long timestamp) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda3(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetLatencySaveRequestMillis$12(long timestamp, SaveEventInternal event) {
        event.mLatencySaveRequestMillis = timestamp;
    }

    public void maybeSetLatencySaveRequestMillis() {
        maybeSetLatencySaveRequestMillis(getElapsedTime());
    }

    public void maybeSetLatencySaveFinishMillis(final long timestamp) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda2(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetLatencySaveFinishMillis$13(long timestamp, SaveEventInternal event) {
        event.mLatencySaveFinishMillis = timestamp;
    }

    public void maybeSetLatencySaveFinishMillis() {
        maybeSetLatencySaveFinishMillis(getElapsedTime());
    }

    public void maybeSetIsFrameworkCreatedSaveInfo(final boolean val) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda5(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsFrameworkCreatedSaveInfo$14(boolean val, SaveEventInternal event) {
        event.mIsFrameworkCreatedSaveInfo = val;
    }

    public void maybeSetAutofillServiceUid(final int uid) {
        this.mEventInternal.ifPresent(new SaveEventLogger$$ExternalSyntheticLambda12(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAutofillServiceUid$15(int uid, SaveEventInternal event) {
        event.mServiceUid = uid;
    }

    public void logAndEndEvent() {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillSaveEventReported again for same event");
        return;
    L6:
        SaveEventInternal event = this.mEventInternal.get();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Log AutofillSaveEventReported: requestId=" + event.mRequestId + " sessionId=" + this.mSessionId + " mAppPackageUid=" + event.mAppPackageUid + " mSaveUiTriggerIds=" + event.mSaveUiTriggerIds + " mFlag=" + event.mFlag + " mIsNewField=" + event.mIsNewField + " mSaveUiShownReason=" + event.mSaveUiShownReason + " mSaveUiNotShownReason=" + event.mSaveUiNotShownReason + " mSaveButtonClicked=" + event.mSaveButtonClicked + " mCancelButtonClicked=" + event.mCancelButtonClicked + " mDialogDismissed=" + event.mDialogDismissed + " mIsSaved=" + event.mIsSaved + " mLatencySaveUiDisplayMillis=" + event.mLatencySaveUiDisplayMillis + " mLatencySaveRequestMillis=" + event.mLatencySaveRequestMillis + " mLatencySaveFinishMillis=" + event.mLatencySaveFinishMillis + " mIsFrameworkCreatedSaveInfo=" + event.mIsFrameworkCreatedSaveInfo + " mServiceUid=" + event.mServiceUid);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_SAVE_EVENT_REPORTED, event.mRequestId, this.mSessionId, event.mAppPackageUid, event.mSaveUiTriggerIds, event.mFlag, event.mIsNewField, event.mSaveUiShownReason, event.mSaveUiNotShownReason, event.mSaveButtonClicked, event.mCancelButtonClicked, event.mDialogDismissed, event.mIsSaved, event.mLatencySaveUiDisplayMillis, event.mLatencySaveRequestMillis, event.mLatencySaveFinishMillis, event.mIsFrameworkCreatedSaveInfo, event.mServiceUid);
        this.mEventInternal = Optional.empty();
    }
}
