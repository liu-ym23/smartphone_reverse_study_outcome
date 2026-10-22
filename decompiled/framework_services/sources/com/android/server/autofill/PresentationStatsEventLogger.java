package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.service.autofill.Dataset;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class PresentationStatsEventLogger {
    public static final int AUTHENTICATION_RESULT_FAILURE = 2;
    public static final int AUTHENTICATION_RESULT_SUCCESS = 1;
    public static final int AUTHENTICATION_RESULT_UNKNOWN = 0;
    public static final int AUTHENTICATION_TYPE_DATASET_AUTHENTICATION = 1;
    public static final int AUTHENTICATION_TYPE_FULL_AUTHENTICATION = 2;
    public static final int AUTHENTICATION_TYPE_UNKNOWN = 0;
    private static final int DEFAULT_VALUE_INT = -1;
    public static final int DETECTION_PREFER_AUTOFILL_PROVIDER = 1;
    public static final int DETECTION_PREFER_PCC = 2;
    public static final int DETECTION_PREFER_UNKNOWN = 0;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_DELAY_AFTER_ANIMATION_END = 6;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_FILL_DIALOG_DISABLED = 1;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_LAST_TRIGGERED_ID_CHANGED = 3;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_SCREEN_HAS_CREDMAN_FIELD = 2;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_TIMEOUT_AFTER_DELAY = 7;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_TIMEOUT_SINCE_IME_ANIMATED = 5;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_UNKNOWN = 0;
    public static final int FILL_DIALOG_NOT_SHOWN_REASON_WAIT_FOR_IME_ANIMATION = 4;
    public static final int NOT_SHOWN_REASON_ACTIVITY_FINISHED = 4;
    public static final int NOT_SHOWN_REASON_ANY_SHOWN = 1;
    public static final int NOT_SHOWN_REASON_NO_FOCUS = 8;
    public static final int NOT_SHOWN_REASON_REQUEST_FAILED = 7;
    public static final int NOT_SHOWN_REASON_REQUEST_TIMEOUT = 5;
    public static final int NOT_SHOWN_REASON_SESSION_COMMITTED_PREMATURELY = 6;
    public static final int NOT_SHOWN_REASON_SUGGESTION_FILTERED = 10;
    public static final int NOT_SHOWN_REASON_UNKNOWN = 0;
    public static final int NOT_SHOWN_REASON_VIEW_CHANGED = 3;
    public static final int NOT_SHOWN_REASON_VIEW_FOCUSED_BEFORE_FILL_DIALOG_RESPONSE = 9;
    public static final int NOT_SHOWN_REASON_VIEW_FOCUS_CHANGED = 2;
    public static final int PICK_REASON_NO_PCC = 1;
    public static final int PICK_REASON_PCC_DETECTION_ONLY = 4;
    public static final int PICK_REASON_PCC_DETECTION_PREFERRED_WITH_PROVIDER = 5;
    public static final int PICK_REASON_PROVIDER_DETECTION_ONLY = 2;
    public static final int PICK_REASON_PROVIDER_DETECTION_PREFERRED_WITH_PCC = 3;
    public static final int PICK_REASON_UNKNOWN = 0;
    private static final String TAG = "PresentationStatsEventLogger";
    private final int mCallingAppUid;
    private Optional<PresentationStatsEventInternal> mEventInternal;
    private final int mSessionId;
    private final long mSessionStartTimestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthenticationResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthenticationType {
    }

    private static class CountContainer {
        int mAvailableCount;
        int mAvailablePccCount;
        int mAvailablePccOnlyCount;

        CountContainer() {
            this.mAvailableCount = 0;
            this.mAvailablePccCount = 0;
            this.mAvailablePccOnlyCount = 0;
        }

        CountContainer(int availableCount, int availablePccCount, int availablePccOnlyCount) {
            this.mAvailableCount = 0;
            this.mAvailablePccCount = 0;
            this.mAvailablePccOnlyCount = 0;
            this.mAvailableCount = availableCount;
            this.mAvailablePccCount = availablePccCount;
            this.mAvailablePccOnlyCount = availablePccOnlyCount;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DatasetPickedReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DetectionPreference {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FillDialogNotShownReason {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NotShownReason {
    }

    static final class PresentationStatsEventInternal {
        ArraySet<AutofillId> mAlreadyFilledAutofillIds;
        int mAuthenticationResult;
        int mAuthenticationType;
        ArraySet<AutofillId> mAutofillIdsAttemptedAutofill;
        int mAutofillServiceUid;
        int mAutofilledTimestampMs;
        int mAvailableCount;
        int mAvailablePccCount;
        int mAvailablePccOnlyCount;
        int mCountFilteredUserTyping;
        int mCountNotShownImePresentationNotDrawn;
        int mCountNotShownImeUserNotSeen;
        int mCountShown;
        int mDetectionPreference;
        boolean mDialogDismissed;
        int mDisplayPresentationType;
        ArraySet<AutofillId> mFailedAutofillIds;
        int mFieldClassificationRequestId;
        int mFieldFirstLength;
        int mFieldLastLength;
        int mFieldModifiedFirstTimestampMs;
        int mFieldModifiedLastTimestampMs;
        int mFillDialogNotShownReason;
        int mFillDialogReadyToShowMs;
        int mFillRequestSentTimestampMs;
        int mFillResponseReceivedTimestampMs;
        int mFilteredFillabaleViewCount;
        int mFixExpireResponseDuringAuthCount;
        int mFocusedId;
        int mFocusedVirtualAutofillId;
        boolean mHasRelayoutLog;
        int mImeAnimationFinishMs;
        int mInlineSuggestionHostUid;
        boolean mIsCredentialRequest;
        boolean mIsDatasetAvailable;
        boolean mIsRequestTriggered;
        int mLatencyAuthenticationUiDisplayMillis;
        int mLatencyDatasetDisplayMillis;
        boolean mNegativeCtaButtonClicked;
        int mNoPresentationReason;
        int mNotifyViewEnteredIgnoredDuringAuthCount;
        boolean mPositiveCtaButtonClicked;
        int mRequestId;
        int mSelectedDatasetId;
        int mSelectedDatasetPickedReason;
        int mSelectionTimestamp;
        int mSuggestionPresentedLastTimestampMs;
        int mSuggestionPresentedTimestampMs;
        int mSuggestionSentTimestampMs;
        int mViewFailedOnRefillCount;
        int mViewFailedPriorToRefillCount;
        int mViewFillFailureCount;
        int mViewFillSuccessCount;
        int mViewFillableTotalCount;
        int mViewFilledButUnexpectedCount;
        int mViewFilledSuccessfullyOnRefillCount;
        boolean mWebviewRequestedCredential;
        boolean shouldResetShownCount;

        PresentationStatsEventInternal() {
            this.mNoPresentationReason = 0;
            this.mCountShown = 0;
            this.mDisplayPresentationType = 0;
            this.mAutofillServiceUid = -1;
            this.mInlineSuggestionHostUid = -1;
            this.mFillRequestSentTimestampMs = -1;
            this.mFillResponseReceivedTimestampMs = -1;
            this.mSuggestionSentTimestampMs = -1;
            this.mSuggestionPresentedTimestampMs = -1;
            this.mSelectedDatasetId = -1;
            this.mDialogDismissed = false;
            this.mNegativeCtaButtonClicked = false;
            this.mPositiveCtaButtonClicked = false;
            this.mAuthenticationType = 0;
            this.mAuthenticationResult = 0;
            this.mLatencyAuthenticationUiDisplayMillis = -1;
            this.mLatencyDatasetDisplayMillis = -1;
            this.mAvailablePccCount = -1;
            this.mAvailablePccOnlyCount = -1;
            this.mSelectedDatasetPickedReason = 0;
            this.mDetectionPreference = 0;
            this.mFieldClassificationRequestId = -1;
            this.mIsCredentialRequest = false;
            this.mWebviewRequestedCredential = false;
            this.mFilteredFillabaleViewCount = -1;
            this.mViewFillableTotalCount = -1;
            this.mViewFillFailureCount = -1;
            this.mFocusedId = -1;
            this.mSelectionTimestamp = -1;
            this.mAutofilledTimestampMs = -1;
            this.mFieldModifiedFirstTimestampMs = -1;
            this.mFieldModifiedLastTimestampMs = -1;
            this.mSuggestionPresentedLastTimestampMs = -1;
            this.mFocusedVirtualAutofillId = -1;
            this.mFieldFirstLength = -1;
            this.mFieldLastLength = -1;
            this.mViewFillSuccessCount = 0;
            this.mViewFilledButUnexpectedCount = 0;
            this.mViewFailedPriorToRefillCount = 0;
            this.mViewFailedOnRefillCount = 0;
            this.mViewFilledSuccessfullyOnRefillCount = 0;
            this.mFixExpireResponseDuringAuthCount = 0;
            this.mNotifyViewEnteredIgnoredDuringAuthCount = 0;
            this.mFailedAutofillIds = new ArraySet();
            this.mAlreadyFilledAutofillIds = new ArraySet();
            this.shouldResetShownCount = false;
            this.mHasRelayoutLog = false;
            this.mFillDialogNotShownReason = 0;
            this.mFillDialogReadyToShowMs = -1;
            this.mImeAnimationFinishMs = -1;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2_M-LRswioqL_cN9fWHavb06cWQ, reason: not valid java name */
    public static /* synthetic */ void m2296$r8$lambda$2_MLRswioqL_cN9fWHavb06cWQ(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetDialogDismissed$20(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$2iCY15AYcjzToHRc7-48sO2bTEM, reason: not valid java name */
    public static /* synthetic */ void m2297$r8$lambda$2iCY15AYcjzToHRc748sO2bTEM(PresentationStatsEventLogger r0, long r1, PresentationStatsEventInternal r3) {
        r0.lambda$maybeSetFillDialogReadyToShowMs$47(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$2uM1ismps7tYNC9bDsE0RRgP3ds(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetNoPresentationEventReason$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$47qyeaFw58iOY_uUmF_ryOgsRwg(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetNegativeCtaButtonClicked$21(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$5mCurjGggUvWqpT_BZR8ZPj-u08, reason: not valid java name */
    public static /* synthetic */ void m2298$r8$lambda$5mCurjGggUvWqpT_BZR8ZPju08(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetDetectionPreference$33(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7ZgwylO2i3qPh8Hb-veQDyLpNZ4, reason: not valid java name */
    public static /* synthetic */ void m2299$r8$lambda$7ZgwylO2i3qPh8HbveQDyLpNZ4(PresentationStatsEventLogger r0, int r1, PresentationStatsEventInternal r2) {
        r0.lambda$logWhenDatasetShown$10(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$7wSYvJ8UpuKisM1JLJqKpzJK2Pk(PresentationStatsEventLogger r0, PresentationStatsEventInternal r1) {
        r0.lambda$maybeIncrementCountShown$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$8sRmcjSGRPiBcJ1yOjPJGajCuow(PresentationStatsEventInternal r0) {
        lambda$notifyViewEnteredIgnoredDuringAuthCount$45(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$AHBpxxZLZ3o9KBr-1_LuSWN32pM, reason: not valid java name */
    public static /* synthetic */ void m2300$r8$lambda$AHBpxxZLZ3o9KBr1_LuSWN32pM(PresentationStatsEventInternal r0) {
        lambda$maybeSetNotifyNotExpiringResponseDuringAuth$44(r0);
    }

    public static /* synthetic */ void $r8$lambda$Az55fhKYdGuVdg2jl8JVrH_E7Ys(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetCountFilteredUserTyping$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$CQf6yVYe6ZLvoP9CgsKhCINoo5k(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetCountNotShownImeUserNotSeen$13(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DcqcW-Kby76vioBuFq72zV6LpAk, reason: not valid java name */
    public static /* synthetic */ void m2301$r8$lambda$DcqcWKby76vioBuFq72zV6LpAk(PresentationStatsEventLogger r0, AutofillValue r1, PresentationStatsEventInternal r2) {
        r0.lambda$maybeSetNoPresentationEventReasonSuggestionsFiltered$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$IIlVYYuPbcXw1493I7K2s-cJgdU, reason: not valid java name */
    public static /* synthetic */ void m2302$r8$lambda$IIlVYYuPbcXw1493I7K2scJgdU(PresentationStatsEventLogger r0, int r1, PresentationStatsEventInternal r2) {
        r0.lambda$maybeSetSelectedDatasetPickReason$32(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Jj5ksCRkcBu4ROOPRza7b4-XfEM, reason: not valid java name */
    public static /* synthetic */ void m2303$r8$lambda$Jj5ksCRkcBu4ROOPRza7b4XfEM(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetRequestId$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$JqOm5Mg-KSIawOJ13_o4rRFNi28, reason: not valid java name */
    public static /* synthetic */ void m2304$r8$lambda$JqOm5MgKSIawOJ13_o4rRFNi28(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetLatencyDatasetDisplayMillis$29(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$KOG1Z2ZDRr1G83o1txF4d3VxDEA(PresentationStatsEventLogger r0, PresentationStatsEventInternal r1) {
        r0.lambda$setPresentationSelectedTimestamp$36(r1);
    }

    public static /* synthetic */ void $r8$lambda$LvXcmNUkYwwiRiwsNvwIeEvUORc(List r0, AutofillId r1, PresentationStatsEventInternal r2) {
        lambda$maybeSetCountShown$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$MttHF3jWZNLdVkQqOv--CfJSIV8, reason: not valid java name */
    public static /* synthetic */ void m2305$r8$lambda$MttHF3jWZNLdVkQqOvCfJSIV8(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetSuggestionSentTimestampMs$17(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$OnRnVhd-U4VCAlBxPBgVnt_FB8M, reason: not valid java name */
    public static /* synthetic */ void m2306$r8$lambda$OnRnVhdU4VCAlBxPBgVnt_FB8M(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetPositiveCtaButtonClicked$22(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$S0nWo7MdotEWpL2a0s1snwlcUgU(PresentationStatsEventInternal r0) {
        lambda$setHasRelayoutLog$49(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$SgCg_eAbw7hdbQWog-D3SfUULiY, reason: not valid java name */
    public static /* synthetic */ void m2307$r8$lambda$SgCg_eAbw7hdbQWogD3SfUULiY(AutofillValue r0, PresentationStatsEventInternal r1) {
        lambda$updateTextFieldLength$34(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$VAqzKIbt82B8nzvKfT571eFwKeI(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFillDialogNotShownReason$46(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$WV55Uw8UUYev1p8R6i8knfORIc4(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetIsCredentialRequest$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$WV6cK2z9ug7KiX4ptlbNuWjn1u8(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFillRequestSentTimestampMs$15(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$WsXjzVSWKY62PbytJGulmSKWSOc(PresentationStatsEventLogger r0, ViewState r1, AutofillValue r2, PresentationStatsEventInternal r3) {
        r0.lambda$onFieldTextUpdated$35(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$WxhRMQDxQ0RuK7PrMHIcGuaIST0(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFilteredFillableViewsCount$40(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZU3AAYaP-Rf67KwGMwqBLfJmLQ4, reason: not valid java name */
    public static /* synthetic */ void m2308$r8$lambda$ZU3AAYaPRf67KwGMwqBLfJmLQ4(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetAuthenticationResult$27(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZVhvmskeCTAeZTKLT07XswKyd2I(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetIsNewRequest$25(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$bWONHov9Ida2vWXavB-WAZDGF_E, reason: not valid java name */
    public static /* synthetic */ void m2309$r8$lambda$bWONHov9Ida2vWXavBWAZDGF_E(List r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetViewFillablesAndCount$38(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$cGlnkdTNd7Wirp-iJDndLherFuU, reason: not valid java name */
    public static /* synthetic */ void m2310$r8$lambda$cGlnkdTNd7WirpiJDndLherFuU(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetNoPresentationEventReasonIfNoReasonExists$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$edyheXD-DrJsYj7p0TQbL8jTDl8, reason: not valid java name */
    public static /* synthetic */ void m2311$r8$lambda$edyheXDDrJsYj7p0TQbL8jTDl8(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetSuggestionPresentedTimestampMs$18(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gg_guMDPJ28Y9wU3Pra9VnC6aEU(boolean r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetWebviewRequestedCredential$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$h3gdNo_UtJg1hlTa26VoCDrWeOo(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetAutofillServiceUid$24(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hD8eDAoQcLBIr2ZyMCkNELJtmMI(PresentationStatsEventInternal r0) {
        lambda$markShownCountAsResettable$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$kIHRHQC8TM1lKJy55394IXZ40OE(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFillResponseReceivedTimestampMs$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ldQo8dmHC3I582rLdV9deHgGM6o(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetLatencyAuthenticationUiDisplayMillis$28(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nDatkP8iwOpTt11W5UjuotO6tJA(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetSelectedDatasetId$19(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nq6URDhVBSOjg2oMU0G7O0GfLUM(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFieldClassificationRequestId$37(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nx4FQfLnWsu2Ml78L_Eji7HBn2c(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetCountNotShownImePresentationNotDrawn$12(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$qXVUB1ki1fTz2wCmZkcUTFrQhLk(PresentationStatsEventLogger r0, List r1, PresentationStatsEventInternal r2) {
        r0.lambda$maybeUpdateViewFillablesForRefillAttempt$39(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$qgI7eY-C9lPGuMp5qI9SY6pi0U8, reason: not valid java name */
    public static /* synthetic */ void m2312$r8$lambda$qgI7eYC9lPGuMp5qI9SY6pi0U8(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetAuthenticationType$26(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$sAesPPTtVuvEoUw35fL4BJo4wXM(List r0, AutofillId r1, PresentationStatsEventInternal r2) {
        lambda$maybeSetAvailableCount$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$sdI_FQ7mzLhvsznHargrTR-Vw6E, reason: not valid java name */
    public static /* synthetic */ void m2313$r8$lambda$sdI_FQ7mzLhvsznHargrTRVw6E(AutofillId r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetFocusedId$42(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$so-onAoTnII28w7KKTEuVQ-0F1s, reason: not valid java name */
    public static /* synthetic */ void m2314$r8$lambda$soonAoTnII28w7KKTEuVQ0F1s(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetAvailablePccOnlyCount$31(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$tAA_uyzxud3CEe7BPWnnb0q8MLQ(PresentationStatsEventLogger r0, List r1, boolean r2, PresentationStatsEventInternal r3) {
        r0.lambda$maybeSetViewFillFailureCounts$41(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$v0r_T4wLykXPwkFR_v62-Lt3eBk, reason: not valid java name */
    public static /* synthetic */ void m2315$r8$lambda$v0r_T4wLykXPwkFR_v62Lt3eBk(Context r0, int r1, PresentationStatsEventInternal r2) {
        lambda$maybeSetInlinePresentationAndSuggestionHostUid$23(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$vPAF-ACOIdaVsQzxa4mAbyecWvI, reason: not valid java name */
    public static /* synthetic */ void m2316$r8$lambda$vPAFACOIdaVsQzxa4mAbyecWvI(AutofillId r0, PresentationStatsEventInternal r1) {
        lambda$maybeAddSuccessId$43(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$vhApJrUYdaTUWbouhJ3fMJ3hObY(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetDisplayPresentationType$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$zBi97M6-U185C6fDvk033jo3rIo, reason: not valid java name */
    public static /* synthetic */ void m2317$r8$lambda$zBi97M6U185C6fDvk033jo3rIo(int r0, PresentationStatsEventInternal r1) {
        lambda$maybeSetAvailablePccCount$30(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$zrMQd83-VJaotFT8WfiC_-0nKzU, reason: not valid java name */
    public static /* synthetic */ void m2318$r8$lambda$zrMQd83VJaotFT8WfiC_0nKzU(PresentationStatsEventLogger r0, long r1, PresentationStatsEventInternal r3) {
        r0.lambda$maybeSetImeAnimationFinishMs$48(r1, r3);
    }

    private PresentationStatsEventLogger(int sessionId, int callingAppUid, long timestamp) {
        this.mSessionId = sessionId;
        this.mCallingAppUid = callingAppUid;
        this.mSessionStartTimestamp = timestamp;
        this.mEventInternal = Optional.empty();
    }

    public static PresentationStatsEventLogger createPresentationLog(int sessionId, int callingAppUid, long timestamp) {
        return new PresentationStatsEventLogger(sessionId, callingAppUid, timestamp);
    }

    public void startNewEvent() {
        if (this.mEventInternal.isPresent() == false) goto L6;
        Slog.e(TAG, "Failed to start new event because already have active event.");
        return;
    L6:
        Slog.d(TAG, "Started new PresentationStatsEvent");
        this.mEventInternal = Optional.of(new PresentationStatsEventInternal());
    }

    Optional<PresentationStatsEventInternal> getInternalEvent() {
        return this.mEventInternal;
    }

    private static /* synthetic */ void lambda$maybeSetRequestId$0(int requestId, PresentationStatsEventInternal event) {
        event.mRequestId = requestId;
    }

    public void maybeSetRequestId(final int requestId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda47(requestId));
    }

    private static /* synthetic */ void lambda$maybeSetIsCredentialRequest$1(boolean isCredentialRequest, PresentationStatsEventInternal event) {
        event.mIsCredentialRequest = isCredentialRequest;
    }

    public void maybeSetIsCredentialRequest(final boolean isCredentialRequest) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda34(isCredentialRequest));
    }

    public void maybeSetWebviewRequestedCredential(final boolean webviewRequestedCredential) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda3(webviewRequestedCredential));
    }

    private static /* synthetic */ void lambda$maybeSetWebviewRequestedCredential$2(boolean webviewRequestedCredential, PresentationStatsEventInternal event) {
        event.mWebviewRequestedCredential = webviewRequestedCredential;
    }

    public void maybeSetNoPresentationEventReason(final int reason) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda9(reason));
    }

    private static /* synthetic */ void lambda$maybeSetNoPresentationEventReason$3(int reason, PresentationStatsEventInternal event) {
        if (event.mCountShown != 0) goto L6;
        event.mNoPresentationReason = reason;
        return;
    }

    public void maybeSetNoPresentationEventReasonSuggestionsFiltered(final AutofillValue value) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda40(this, value));
    }

    private /* synthetic */ void lambda$maybeSetNoPresentationEventReasonSuggestionsFiltered$4(AutofillValue value, PresentationStatsEventInternal event) {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isText() == false) goto L12;
        int length = value.getTextValue().length();
        if (length <= 0) goto L11;
        maybeSetNoPresentationEventReason(10);
        return;
    L11:
        return;
    }

    public void maybeSetNoPresentationEventReasonIfNoReasonExists(final int reason) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda33(reason));
    }

    private static /* synthetic */ void lambda$maybeSetNoPresentationEventReasonIfNoReasonExists$5(int reason, PresentationStatsEventInternal event) {
        if (event.mCountShown == 0) goto L6;
        return;
    L6:
        if (event.mNoPresentationReason == 0) goto L8;
    L12:
        Slog.d(TAG, "Not setting no presentation reason because it already exists");
        return;
    L8:
        if (event.mNoPresentationReason != 8) goto L12;
        event.mNoPresentationReason = reason;
    }

    public void maybeSetAvailableCount(final List<Dataset> datasetList, final AutofillId currentViewId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda22(datasetList, currentViewId));
    }

    private static /* synthetic */ void lambda$maybeSetAvailableCount$6(List datasetList, AutofillId currentViewId, PresentationStatsEventInternal event) {
        CountContainer container = getDatasetCountForAutofillId(datasetList, currentViewId);
        event.mAvailableCount = container.mAvailableCount;
        event.mAvailablePccCount = container.mAvailablePccCount;
        event.mAvailablePccOnlyCount = container.mAvailablePccOnlyCount;
        if (container.mAvailableCount <= 0) goto L5;
        boolean r1 = true;
    L6:
        event.mIsDatasetAvailable = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void maybeIncrementCountShown() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda12(this));
    }

    private /* synthetic */ void lambda$maybeIncrementCountShown$7(PresentationStatsEventInternal event) {
        if (event.shouldResetShownCount == false) goto L6;
        event.shouldResetShownCount = false;
        event.mCountShown = 0;
    L6:
        if (event.mCountShown != 0) goto L8;
        maybeSetSuggestionPresentedTimestampMs();
    L8:
        event.mCountShown++;
    }

    public void markShownCountAsResettable() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda45());
    }

    private static /* synthetic */ void lambda$markShownCountAsResettable$8(PresentationStatsEventInternal event) {
        event.shouldResetShownCount = true;
    }

    public void maybeSetCountShown(final List<Dataset> datasetList, final AutofillId currentViewId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda0(datasetList, currentViewId));
    }

    private static /* synthetic */ void lambda$maybeSetCountShown$9(List datasetList, AutofillId currentViewId, PresentationStatsEventInternal event) {
        CountContainer container = getDatasetCountForAutofillId(datasetList, currentViewId);
        event.mCountShown = container.mAvailableCount;
        if (container.mAvailableCount <= 0) goto L6;
        event.mNoPresentationReason = 1;
        return;
    }

    public void logWhenDatasetShown(final int datasets) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda35(this, datasets));
    }

    private /* synthetic */ void lambda$logWhenDatasetShown$10(int datasets, PresentationStatsEventInternal event) {
        maybeSetSuggestionPresentedTimestampMs();
        event.mCountShown = datasets;
        event.mNoPresentationReason = 1;
    }

    private static CountContainer getDatasetCountForAutofillId(List<Dataset> datasetList, AutofillId currentViewId) {
        CountContainer container = new CountContainer();
        if (datasetList == null) goto L20;
        int i = 0;
    L6:
        if (i >= datasetList.size()) goto L20;
        Dataset data = datasetList.get(i);
        if (data == null) goto L19;
        if (data.getFieldIds() == null) goto L19;
        if (data.getFieldIds().contains(currentViewId) == false) goto L19;
        container.mAvailableCount++;
        if (data.getEligibleReason() != 4) goto L17;
        container.mAvailablePccOnlyCount++;
        container.mAvailablePccCount++;
        goto L19
    L17:
        if (data.getEligibleReason() != 5) goto L19;
        container.mAvailablePccCount++;
    L19:
        i = i + 1;
    L20:
        return container;
    }

    public void maybeSetCountFilteredUserTyping(final int countFilteredUserTyping) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda17(countFilteredUserTyping));
    }

    private static /* synthetic */ void lambda$maybeSetCountFilteredUserTyping$11(int countFilteredUserTyping, PresentationStatsEventInternal event) {
        event.mCountFilteredUserTyping = countFilteredUserTyping;
    }

    public void maybeSetCountNotShownImePresentationNotDrawn(final int countNotShownImePresentationNotDrawn) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda25(countNotShownImePresentationNotDrawn));
    }

    private static /* synthetic */ void lambda$maybeSetCountNotShownImePresentationNotDrawn$12(int countNotShownImePresentationNotDrawn, PresentationStatsEventInternal event) {
        event.mCountNotShownImePresentationNotDrawn = countNotShownImePresentationNotDrawn;
    }

    public void maybeSetCountNotShownImeUserNotSeen(final int countNotShownImeUserNotSeen) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda28(countNotShownImeUserNotSeen));
    }

    private static /* synthetic */ void lambda$maybeSetCountNotShownImeUserNotSeen$13(int countNotShownImeUserNotSeen, PresentationStatsEventInternal event) {
        event.mCountNotShownImeUserNotSeen = countNotShownImeUserNotSeen;
    }

    public void maybeSetDisplayPresentationType(final int uiType) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda18(uiType));
    }

    private static /* synthetic */ void lambda$maybeSetDisplayPresentationType$14(int uiType, PresentationStatsEventInternal event) {
        if (event.mDisplayPresentationType != 0) goto L6;
        event.mDisplayPresentationType = getDisplayPresentationType(uiType);
        return;
    }

    public void maybeSetFillRequestSentTimestampMs(final int timestamp) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda19(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetFillRequestSentTimestampMs$15(int timestamp, PresentationStatsEventInternal event) {
        event.mFillRequestSentTimestampMs = timestamp;
    }

    public void maybeSetFillRequestSentTimestampMs() {
        maybeSetFillRequestSentTimestampMs(getElapsedTime());
    }

    public void maybeSetFillResponseReceivedTimestampMs(final int timestamp) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda21(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetFillResponseReceivedTimestampMs$16(int timestamp, PresentationStatsEventInternal event) {
        event.mFillResponseReceivedTimestampMs = timestamp;
    }

    public void maybeSetFillResponseReceivedTimestampMs() {
        maybeSetFillResponseReceivedTimestampMs(getElapsedTime());
    }

    public void maybeSetSuggestionSentTimestampMs(final int timestamp) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda7(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetSuggestionSentTimestampMs$17(int timestamp, PresentationStatsEventInternal event) {
        if (event.mSuggestionSentTimestampMs != (-1)) goto L6;
        event.mSuggestionSentTimestampMs = timestamp;
        return;
    }

    public void maybeSetSuggestionSentTimestampMs() {
        maybeSetSuggestionSentTimestampMs(getElapsedTime());
    }

    public void maybeSetSuggestionPresentedTimestampMs(final int timestamp) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda26(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetSuggestionPresentedTimestampMs$18(int timestamp, PresentationStatsEventInternal event) {
        if (event.mSuggestionPresentedTimestampMs != (-1)) goto L5;
        event.mSuggestionPresentedTimestampMs = timestamp;
    L5:
        event.mSuggestionPresentedLastTimestampMs = timestamp;
    }

    public void maybeSetSuggestionPresentedTimestampMs() {
        maybeSetSuggestionPresentedTimestampMs(getElapsedTime());
    }

    public void maybeSetSelectedDatasetId(final int selectedDatasetId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda44(selectedDatasetId));
        setPresentationSelectedTimestamp();
    }

    private static /* synthetic */ void lambda$maybeSetSelectedDatasetId$19(int selectedDatasetId, PresentationStatsEventInternal event) {
        event.mSelectedDatasetId = selectedDatasetId;
    }

    public void maybeSetDialogDismissed(final boolean dialogDismissed) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda32(dialogDismissed));
    }

    private static /* synthetic */ void lambda$maybeSetDialogDismissed$20(boolean dialogDismissed, PresentationStatsEventInternal event) {
        event.mDialogDismissed = dialogDismissed;
    }

    public void maybeSetNegativeCtaButtonClicked(final boolean negativeCtaButtonClicked) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda8(negativeCtaButtonClicked));
    }

    private static /* synthetic */ void lambda$maybeSetNegativeCtaButtonClicked$21(boolean negativeCtaButtonClicked, PresentationStatsEventInternal event) {
        event.mNegativeCtaButtonClicked = negativeCtaButtonClicked;
    }

    public void maybeSetPositiveCtaButtonClicked(final boolean positiveCtaButtonClicked) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda39(positiveCtaButtonClicked));
    }

    private static /* synthetic */ void lambda$maybeSetPositiveCtaButtonClicked$22(boolean positiveCtaButtonClicked, PresentationStatsEventInternal event) {
        event.mPositiveCtaButtonClicked = positiveCtaButtonClicked;
    }

    public void maybeSetInlinePresentationAndSuggestionHostUid(final Context context, final int userId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda11(context, userId));
    }

    private static /* synthetic */ void lambda$maybeSetInlinePresentationAndSuggestionHostUid$23(Context context, int userId, PresentationStatsEventInternal event) {
        String imeString = Settings.Secure.getStringForUser(context.getContentResolver(), "default_input_method", userId);
        if (TextUtils.isEmpty(imeString) == false) goto L6;
        Slog.w(TAG, "No default IME found");
        return;
    L6:
        ComponentName imeComponent = ComponentName.unflattenFromString(imeString);
        if (imeComponent != null) goto L10;
        Slog.w(TAG, "No default IME found");
        return;
    L10:
        String packageName = imeComponent.getPackageName();
        int imeUid = context.getPackageManager().getApplicationInfoAsUser(packageName, PackageManager.ApplicationInfoFlags.of(0), userId).uid;     // Catch: PackageManager.NameNotFoundException -> L14
        event.mInlineSuggestionHostUid = imeUid;
        return;
    L15:
        Slog.w(TAG, "Couldn't find packageName: " + packageName);
    }

    public void maybeSetAutofillServiceUid(final int uid) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda31(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAutofillServiceUid$24(int uid, PresentationStatsEventInternal event) {
        event.mAutofillServiceUid = uid;
    }

    public void maybeSetIsNewRequest(final boolean isRequestTriggered) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda23(isRequestTriggered));
    }

    private static /* synthetic */ void lambda$maybeSetIsNewRequest$25(boolean isRequestTriggered, PresentationStatsEventInternal event) {
        event.mIsRequestTriggered = isRequestTriggered;
    }

    public void maybeSetAuthenticationType(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda20(val));
    }

    private static /* synthetic */ void lambda$maybeSetAuthenticationType$26(int val, PresentationStatsEventInternal event) {
        event.mAuthenticationType = val;
    }

    public void maybeSetAuthenticationResult(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda43(val));
    }

    private static /* synthetic */ void lambda$maybeSetAuthenticationResult$27(int val, PresentationStatsEventInternal event) {
        event.mAuthenticationResult = val;
    }

    public void maybeSetLatencyAuthenticationUiDisplayMillis(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda36(val));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyAuthenticationUiDisplayMillis$28(int val, PresentationStatsEventInternal event) {
        event.mLatencyAuthenticationUiDisplayMillis = val;
    }

    public void maybeSetLatencyAuthenticationUiDisplayMillis() {
        maybeSetLatencyAuthenticationUiDisplayMillis(getElapsedTime());
    }

    public void maybeSetLatencyDatasetDisplayMillis(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda29(val));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyDatasetDisplayMillis$29(int val, PresentationStatsEventInternal event) {
        event.mLatencyDatasetDisplayMillis = val;
    }

    public void maybeSetLatencyDatasetDisplayMillis() {
        maybeSetLatencyDatasetDisplayMillis(getElapsedTime());
    }

    public void maybeSetAvailablePccCount(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda13(val));
    }

    private static /* synthetic */ void lambda$maybeSetAvailablePccCount$30(int val, PresentationStatsEventInternal event) {
        event.mAvailablePccCount = val;
    }

    public void maybeSetAvailablePccOnlyCount(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda48(val));
    }

    private static /* synthetic */ void lambda$maybeSetAvailablePccOnlyCount$31(int val, PresentationStatsEventInternal event) {
        event.mAvailablePccOnlyCount = val;
    }

    public void maybeSetSelectedDatasetPickReason(final int val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda14(this, val));
    }

    private /* synthetic */ void lambda$maybeSetSelectedDatasetPickReason$32(int val, PresentationStatsEventInternal event) {
        event.mSelectedDatasetPickedReason = convertDatasetPickReason(val);
    }

    public void maybeSetDetectionPreference(final int detectionPreference) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda5(detectionPreference));
    }

    private static /* synthetic */ void lambda$maybeSetDetectionPreference$33(int detectionPreference, PresentationStatsEventInternal event) {
        event.mDetectionPreference = detectionPreference;
    }

    public void updateTextFieldLength(final AutofillValue value) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda2(value));
    }

    private static /* synthetic */ void lambda$updateTextFieldLength$34(AutofillValue value, PresentationStatsEventInternal event) {
        if (value != null) goto L4;
        return;
    L4:
        if (value.isText() == false) goto L12;
        int length = value.getTextValue().length();
        if (event.mFieldFirstLength != (-1)) goto L9;
        event.mFieldFirstLength = length;
    L9:
        event.mFieldLastLength = length;
        return;
    }

    public void onFieldTextUpdated(final ViewState state, final AutofillValue value) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda10(this, state, value));
    }

    private /* synthetic */ void lambda$onFieldTextUpdated$35(ViewState state, AutofillValue value, PresentationStatsEventInternal event) {
        int timestamp = getElapsedTime();
        if (state != null) goto L5;
    L18:
        Slog.w(TAG, "Bad view state for: " + event.mFocusedId + ", state: " + state);
        return;
    L5:
        if (state.id == null) goto L18;
        if (state.id.getViewId() != event.mFocusedId) goto L18;
        updateTextFieldLength(value);
        if ((state.getState() & 4) == 0) goto L14;
        event.mAutofilledTimestampMs = timestamp;
        return;
    L14:
        if (event.mFieldModifiedFirstTimestampMs != (-1)) goto L16;
        event.mFieldModifiedFirstTimestampMs = timestamp;
    L16:
        event.mFieldModifiedLastTimestampMs = timestamp;
    }

    public void setPresentationSelectedTimestamp() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda16(this));
    }

    private /* synthetic */ void lambda$setPresentationSelectedTimestamp$36(PresentationStatsEventInternal event) {
        event.mSelectionTimestamp = getElapsedTime();
    }

    private int getElapsedTime() {
        return (int) (SystemClock.elapsedRealtime() - this.mSessionStartTimestamp);
    }

    private int convertDatasetPickReason(int val) {
        switch(val) {
            case 0: goto L5;
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return val;
    }

    public void maybeSetFieldClassificationRequestId(final int requestId) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda4(requestId));
    }

    private static /* synthetic */ void lambda$maybeSetFieldClassificationRequestId$37(int requestId, PresentationStatsEventInternal event) {
        event.mFieldClassificationRequestId = requestId;
    }

    public void maybeSetViewFillablesAndCount(final List<AutofillId> autofillIds) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda46(autofillIds));
    }

    private static /* synthetic */ void lambda$maybeSetViewFillablesAndCount$38(List autofillIds, PresentationStatsEventInternal event) {
        event.mAutofillIdsAttemptedAutofill = new ArraySet(autofillIds);
        event.mViewFillableTotalCount = event.mAutofillIdsAttemptedAutofill.size();
    }

    public void maybeUpdateViewFillablesForRefillAttempt(final List<AutofillId> autofillIds) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda27(this, autofillIds));
    }

    private /* synthetic */ void lambda$maybeUpdateViewFillablesForRefillAttempt$39(List autofillIds, PresentationStatsEventInternal event) {
        event.mAutofillIdsAttemptedAutofill = new ArraySet(autofillIds);
        event.mFailedAutofillIds = new ArraySet(autofillIds);
        setHasRelayoutLog();
    }

    public void maybeSetFilteredFillableViewsCount(final int filteredViewsCount) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda24(filteredViewsCount));
    }

    private static /* synthetic */ void lambda$maybeSetFilteredFillableViewsCount$40(int filteredViewsCount, PresentationStatsEventInternal event) {
        event.mFilteredFillabaleViewCount = filteredViewsCount;
    }

    public void maybeSetViewFillFailureCounts(final List<AutofillId> ids, final boolean isRefill) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda1(this, ids, isRefill));
    }

    private /* synthetic */ void lambda$maybeSetViewFillFailureCounts$41(List ids, boolean isRefill, PresentationStatsEventInternal event) {
        int failureCount = ids.size();
        if (isRefill == false) goto L5;
        event.mViewFailedOnRefillCount = failureCount;
        setHasRelayoutLog();
        return;
    L5:
        event.mViewFillFailureCount = failureCount;
        event.mViewFailedPriorToRefillCount = failureCount;
        event.mFailedAutofillIds = new ArraySet(ids);
    }

    public void maybeSetFocusedId(final AutofillId id) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda6(id));
    }

    private static /* synthetic */ void lambda$maybeSetFocusedId$42(AutofillId id, PresentationStatsEventInternal event) {
        event.mFocusedId = id.getViewId();
        if (id.isVirtualInt() == false) goto L6;
        event.mFocusedVirtualAutofillId = id.getVirtualChildIntId() % 100;
        return;
    }

    public synchronized void maybeAddSuccessId(final AutofillId autofillId) {
        monitor-enter(this);
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda42(autofillId));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$maybeAddSuccessId$43(AutofillId autofillId, PresentationStatsEventInternal event) {
        ArraySet<AutofillId> autofillIds = event.mAutofillIdsAttemptedAutofill;
        if (autofillIds != null) goto L6;
        Slog.w(TAG, "Attempted autofill ids is null, but received autofillId:" + autofillId + " successfully filled");
        event.mViewFilledButUnexpectedCount = event.mViewFilledButUnexpectedCount + 1;
        return;
    L6:
        if (autofillIds.contains(autofillId) == false) goto L18;
        ArraySet<AutofillId> failedIds = event.mFailedAutofillIds;
        if (failedIds.contains(autofillId) == false) goto L14;
        if (Helper.sVerbose == false) goto L12;
        Slog.v(TAG, "Logging autofill refill of id:" + autofillId);
    L12:
        event.mViewFilledSuccessfullyOnRefillCount++;
        failedIds.remove(autofillId);
    L16:
        event.mViewFillSuccessCount++;
        autofillIds.remove(autofillId);
        event.mAlreadyFilledAutofillIds.add(autofillId);
        return;
    L14:
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "Logging autofill for id:" + autofillId);
        goto L16
    L18:
        if (event.mAlreadyFilledAutofillIds.contains(autofillId) == true) goto L20;
        Slog.w(TAG, "Successfully filled autofillId:" + autofillId + " not found in list of attempted autofill ids: " + autofillIds);
        event.mViewFilledButUnexpectedCount = event.mViewFilledButUnexpectedCount + 1;
        return;
    L20:
        if (Helper.sVerbose == false) goto L26;
        Slog.v(TAG, "Successfully filled autofillId:" + autofillId + " already processed ");
        return;
    }

    public void maybeSetNotifyNotExpiringResponseDuringAuth() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda38());
    }

    private static /* synthetic */ void lambda$maybeSetNotifyNotExpiringResponseDuringAuth$44(PresentationStatsEventInternal event) {
        event.mFixExpireResponseDuringAuthCount++;
    }

    public void notifyViewEnteredIgnoredDuringAuthCount() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda30());
    }

    private static /* synthetic */ void lambda$notifyViewEnteredIgnoredDuringAuthCount$45(PresentationStatsEventInternal event) {
        event.mNotifyViewEnteredIgnoredDuringAuthCount++;
    }

    public void maybeSetFillDialogNotShownReason(final int reason) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda41(reason));
    }

    private static /* synthetic */ void lambda$maybeSetFillDialogNotShownReason$46(int reason, PresentationStatsEventInternal event) {
        if (event.mFillDialogNotShownReason == 6) goto L7;
        if (event.mFillDialogNotShownReason == 4) goto L7;
    L9:
        event.mFillDialogNotShownReason = reason;
        return;
    L7:
        if (reason != 5) goto L9;
        event.mFillDialogNotShownReason = 7;
    }

    public void maybeSetFillDialogReadyToShowMs(final long val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda15(this, val));
    }

    private /* synthetic */ void lambda$maybeSetFillDialogReadyToShowMs$47(long val, PresentationStatsEventInternal event) {
        event.mFillDialogReadyToShowMs = (int) (val - this.mSessionStartTimestamp);
    }

    public void maybeSetImeAnimationFinishMs(final long val) {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda37(this, val));
    }

    private /* synthetic */ void lambda$maybeSetImeAnimationFinishMs$48(long val, PresentationStatsEventInternal event) {
        event.mImeAnimationFinishMs = (int) (val - this.mSessionStartTimestamp);
    }

    private void setHasRelayoutLog() {
        this.mEventInternal.ifPresent(new PresentationStatsEventLogger$$ExternalSyntheticLambda49());
    }

    private static /* synthetic */ void lambda$setHasRelayoutLog$49(PresentationStatsEventInternal event) {
        event.mHasRelayoutLog = true;
    }

    public void logAndEndEvent(String caller) {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillPresentationEventReported again for same event");
        return;
    L6:
        PresentationStatsEventInternal event = this.mEventInternal.get();
        if (event.mIsDatasetAvailable == false) goto L9;
    L15:
        boolean ignoreLogging = false;
    L17:
        if (Helper.sVerbose == false) goto L24;
        StringBuilder r4 = new StringBuilder();
        r4.append("(");
        r4.append(caller);
        r4.append(") ");
        if (ignoreLogging == false) goto L21;
        String r6 = "IGNORING - following event won't be logged: ";
    L22:
        r4.append(r6);
        r4.append("Log AutofillPresentationEventReported: requestId=");
        r4.append(event.mRequestId);
        r4.append(" sessionId=");
        r4.append(this.mSessionId);
        r4.append(" mNoPresentationEventReason=");
        r4.append(event.mNoPresentationReason);
        r4.append(" mAvailableCount=");
        r4.append(event.mAvailableCount);
        r4.append(" mCountShown=");
        r4.append(event.mCountShown);
        r4.append(" mCountFilteredUserTyping=");
        r4.append(event.mCountFilteredUserTyping);
        r4.append(" mCountNotShownImePresentationNotDrawn=");
        r4.append(event.mCountNotShownImePresentationNotDrawn);
        r4.append(" mCountNotShownImeUserNotSeen=");
        r4.append(event.mCountNotShownImeUserNotSeen);
        r4.append(" mDisplayPresentationType=");
        r4.append(event.mDisplayPresentationType);
        r4.append(" mAutofillServiceUid=");
        r4.append(event.mAutofillServiceUid);
        r4.append(" mInlineSuggestionHostUid=");
        r4.append(event.mInlineSuggestionHostUid);
        r4.append(" mIsRequestTriggered=");
        r4.append(event.mIsRequestTriggered);
        r4.append(" mFillRequestSentTimestampMs=");
        r4.append(event.mFillRequestSentTimestampMs);
        r4.append(" mFillResponseReceivedTimestampMs=");
        r4.append(event.mFillResponseReceivedTimestampMs);
        r4.append(" mSuggestionSentTimestampMs=");
        r4.append(event.mSuggestionSentTimestampMs);
        r4.append(" mSuggestionPresentedTimestampMs=");
        r4.append(event.mSuggestionPresentedTimestampMs);
        r4.append(" mSelectedDatasetId=");
        r4.append(event.mSelectedDatasetId);
        r4.append(" mDialogDismissed=");
        r4.append(event.mDialogDismissed);
        r4.append(" mNegativeCtaButtonClicked=");
        r4.append(event.mNegativeCtaButtonClicked);
        r4.append(" mPositiveCtaButtonClicked=");
        r4.append(event.mPositiveCtaButtonClicked);
        r4.append(" mAuthenticationType=");
        r4.append(event.mAuthenticationType);
        r4.append(" mAuthenticationResult=");
        r4.append(event.mAuthenticationResult);
        r4.append(" mLatencyAuthenticationUiDisplayMillis=");
        r4.append(event.mLatencyAuthenticationUiDisplayMillis);
        r4.append(" mLatencyDatasetDisplayMillis=");
        r4.append(event.mLatencyDatasetDisplayMillis);
        r4.append(" mAvailablePccCount=");
        r4.append(event.mAvailablePccCount);
        r4.append(" mAvailablePccOnlyCount=");
        r4.append(event.mAvailablePccOnlyCount);
        r4.append(" mSelectedDatasetPickedReason=");
        r4.append(event.mSelectedDatasetPickedReason);
        r4.append(" mDetectionPreference=");
        r4.append(event.mDetectionPreference);
        r4.append(" mFieldClassificationRequestId=");
        r4.append(event.mFieldClassificationRequestId);
        r4.append(" mAppPackageUid=");
        r4.append(this.mCallingAppUid);
        r4.append(" mIsCredentialRequest=");
        r4.append(event.mIsCredentialRequest);
        r4.append(" mWebviewRequestedCredential=");
        r4.append(event.mWebviewRequestedCredential);
        r4.append(" mFilteredFillabaleViewCount=");
        r4.append(event.mFilteredFillabaleViewCount);
        r4.append(" mViewFillableTotalCount=");
        r4.append(event.mViewFillableTotalCount);
        r4.append(" mViewFillFailureCount=");
        r4.append(event.mViewFillFailureCount);
        r4.append(" mFocusedId=");
        r4.append(event.mFocusedId);
        r4.append(" mViewFillSuccessCount=");
        r4.append(event.mViewFillSuccessCount);
        r4.append(" mViewFilledButUnexpectedCount=");
        r4.append(event.mViewFilledButUnexpectedCount);
        r4.append(" event.mSelectionTimestamp=");
        r4.append(event.mSelectionTimestamp);
        r4.append(" event.mAutofilledTimestampMs=");
        r4.append(event.mAutofilledTimestampMs);
        r4.append(" event.mFieldModifiedFirstTimestampMs=");
        r4.append(event.mFieldModifiedFirstTimestampMs);
        r4.append(" event.mFieldModifiedLastTimestampMs=");
        r4.append(event.mFieldModifiedLastTimestampMs);
        r4.append(" event.mSuggestionPresentedLastTimestampMs=");
        r4.append(event.mSuggestionPresentedLastTimestampMs);
        r4.append(" event.mFocusedVirtualAutofillId=");
        r4.append(event.mFocusedVirtualAutofillId);
        r4.append(" event.mFieldFirstLength=");
        r4.append(event.mFieldFirstLength);
        r4.append(" event.mFieldLastLength=");
        r4.append(event.mFieldLastLength);
        r4.append(" event.mViewFailedPriorToRefillCount=");
        r4.append(event.mViewFailedPriorToRefillCount);
        r4.append(" event.mViewFilledSuccessfullyOnRefillCount=");
        r4.append(event.mViewFilledSuccessfullyOnRefillCount);
        r4.append(" event.mViewFailedOnRefillCount=");
        r4.append(event.mViewFailedOnRefillCount);
        r4.append(" event.notExpiringResponseDuringAuthCount=");
        r4.append(event.mFixExpireResponseDuringAuthCount);
        r4.append(" event.notifyViewEnteredIgnoredDuringAuthCount=");
        r4.append(event.mNotifyViewEnteredIgnoredDuringAuthCount);
        r4.append(" event.fillDialogNotShownReason=");
        r4.append(event.mFillDialogNotShownReason);
        r4.append(" event.fillDialogReadyToShowMs=");
        r4.append(event.mFillDialogReadyToShowMs);
        r4.append(" event.imeAnimationFinishMs=");
        r4.append(event.mImeAnimationFinishMs);
        Slog.v(TAG, r4.toString());
        goto L24
    L21:
        r6 = "";
    L24:
        if (ignoreLogging == false) goto L27;
        Slog.w(TAG, "Empty dataset. Autofill ignoring log");
        this.mEventInternal = Optional.empty();
        return;
    L27:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_PRESENTATION_EVENT_REPORTED, event.mRequestId, this.mSessionId, event.mNoPresentationReason, event.mAvailableCount, event.mCountShown, event.mCountFilteredUserTyping, event.mCountNotShownImePresentationNotDrawn, event.mCountNotShownImeUserNotSeen, event.mDisplayPresentationType, event.mAutofillServiceUid, event.mInlineSuggestionHostUid, event.mIsRequestTriggered, event.mFillRequestSentTimestampMs, event.mFillResponseReceivedTimestampMs, event.mSuggestionSentTimestampMs, event.mSuggestionPresentedTimestampMs, event.mSelectedDatasetId, event.mDialogDismissed, event.mNegativeCtaButtonClicked, event.mPositiveCtaButtonClicked, event.mAuthenticationType, event.mAuthenticationResult, event.mLatencyAuthenticationUiDisplayMillis, event.mLatencyDatasetDisplayMillis, event.mAvailablePccCount, event.mAvailablePccOnlyCount, event.mSelectedDatasetPickedReason, event.mDetectionPreference, event.mFieldClassificationRequestId, this.mCallingAppUid, event.mIsCredentialRequest, event.mWebviewRequestedCredential, event.mViewFillableTotalCount, event.mViewFillFailureCount, event.mFocusedId, event.mViewFillSuccessCount, event.mViewFilledButUnexpectedCount, event.mSelectionTimestamp, event.mAutofilledTimestampMs, event.mFieldModifiedFirstTimestampMs, event.mFieldModifiedLastTimestampMs, event.mSuggestionPresentedLastTimestampMs, event.mFocusedVirtualAutofillId, event.mFieldFirstLength, event.mFieldLastLength, event.mFilteredFillabaleViewCount, event.mViewFailedPriorToRefillCount, event.mViewFilledSuccessfullyOnRefillCount, event.mViewFailedOnRefillCount, event.mFixExpireResponseDuringAuthCount, event.mNotifyViewEnteredIgnoredDuringAuthCount, event.mFillDialogNotShownReason, event.mFillDialogReadyToShowMs, event.mImeAnimationFinishMs);
        this.mEventInternal = Optional.empty();
        return;
    L9:
        if (event.mHasRelayoutLog == true) goto L15;
        if (event.mFixExpireResponseDuringAuthCount > 0) goto L15;
        if (event.mNotifyViewEnteredIgnoredDuringAuthCount > 0) goto L15;
        ignoreLogging = true;
        goto L17
    }

    static int getNoPresentationEventReason(int commitReason) {
        switch(commitReason) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L3;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 3;
    L7:
        return 6;
    L9:
        return 4;
    }

    private static int getDisplayPresentationType(int uiType) {
        switch(uiType) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    }
}
