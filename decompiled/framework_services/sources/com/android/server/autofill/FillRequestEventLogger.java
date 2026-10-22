package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class FillRequestEventLogger {
    private static final String TAG = "FillRequestEventLogger";
    public static final int TRIGGER_REASON_EXPLICITLY_REQUESTED = 1;
    public static final int TRIGGER_REASON_NORMAL_TRIGGER = 4;
    public static final int TRIGGER_REASON_PRE_TRIGGER = 3;
    public static final int TRIGGER_REASON_RETRIGGER = 2;
    public static final int TRIGGER_REASON_SERVED_FROM_CACHED_RESPONSE = 5;
    public static final int TRIGGER_REASON_UNKNOWN = 0;
    private Optional<FillRequestEventInternal> mEventInternal;
    private final int mSessionId;

    private static final class FillRequestEventInternal {
        int mAppPackageUid;
        int mAutofillServiceUid;
        int mFlags;
        int mInlineSuggestionHostUid;
        boolean mIsAugmented;
        boolean mIsClientSuggestionFallback;
        boolean mIsFillDialogEligible;
        int mLatencyFillRequestSentMillis;
        int mRequestId;
        int mRequestTriggerReason;

        FillRequestEventInternal() {
            this.mAppPackageUid = -1;
            this.mAutofillServiceUid = -1;
            this.mInlineSuggestionHostUid = -1;
            this.mIsAugmented = false;
            this.mIsClientSuggestionFallback = false;
            this.mIsFillDialogEligible = false;
            this.mRequestTriggerReason = 0;
            this.mFlags = -1;
            this.mLatencyFillRequestSentMillis = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TriggerReason {
    }

    /* JADX INFO: renamed from: $r8$lambda$24CQjw4dL7b-huLdlSskbHJw-nA, reason: not valid java name */
    public static /* synthetic */ void m2284$r8$lambda$24CQjw4dL7bhuLdlSskbHJwnA(Context r0, int r1, FillRequestEventInternal r2) {
        lambda$maybeSetInlineSuggestionHostUid$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$CoLd8fUyUXqxNcPnnKTfLRAOBEA(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetRequestTriggerReason$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$MGuxFg3f8YvuvuBADs6jZIeanV4(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetAppPackageUid$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$P52z3KHVd_RH5GQjZM1ubMwXfq0(boolean r0, FillRequestEventInternal r1) {
        lambda$maybeSetIsClientSuggestionFallback$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aoCj0znXXSsx22eGJx0uYy5ER3U(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetLatencyFillRequestSentMillis$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$e4nwCc8H8ZxIJkGwa5LuSXqdjfc(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetAutofillServiceUid$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$p4mBgqvO-ilbiqEiuAuUVYoD5H4, reason: not valid java name */
    public static /* synthetic */ void m2285$r8$lambda$p4mBgqvOilbiqEiuAuUVYoD5H4(boolean r0, FillRequestEventInternal r1) {
        lambda$maybeSetIsAugmented$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$r65oIv5z-u1jhECskrxZ9M64864, reason: not valid java name */
    public static /* synthetic */ void m2286$r8$lambda$r65oIv5zu1jhECskrxZ9M64864(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetFlags$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xDKLxfATc0NkqDV4VgeNx4Y7l3s(boolean r0, FillRequestEventInternal r1) {
        lambda$maybeSetIsFillDialogEligible$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$y-LmHkHf9Wz_pehkMaq1N423xuY, reason: not valid java name */
    public static /* synthetic */ void m2287$r8$lambda$yLmHkHf9Wz_pehkMaq1N423xuY(int r0, FillRequestEventInternal r1) {
        lambda$maybeSetRequestId$0(r0, r1);
    }

    private FillRequestEventLogger(int sessionId) {
        this.mSessionId = sessionId;
        this.mEventInternal = Optional.empty();
    }

    public static FillRequestEventLogger forSessionId(int sessionId) {
        return new FillRequestEventLogger(sessionId);
    }

    public void startLogForNewRequest() {
        if (this.mEventInternal.isEmpty() == true) goto L5;
        Slog.w(TAG, "FillRequestEventLogger is not empty before starting for a new request");
    L5:
        this.mEventInternal = Optional.of(new FillRequestEventInternal());
    }

    private static /* synthetic */ void lambda$maybeSetRequestId$0(int requestId, FillRequestEventInternal event) {
        event.mRequestId = requestId;
    }

    public void maybeSetRequestId(final int requestId) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda7(requestId));
    }

    public void maybeSetAutofillServiceUid(final int uid) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda0(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAutofillServiceUid$1(int uid, FillRequestEventInternal event) {
        event.mAutofillServiceUid = uid;
    }

    public void maybeSetInlineSuggestionHostUid(final Context context, final int userId) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda3(context, userId));
    }

    private static /* synthetic */ void lambda$maybeSetInlineSuggestionHostUid$2(Context context, int userId, FillRequestEventInternal event) {
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

    public void maybeSetFlags(final int flags) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda9(flags));
    }

    private static /* synthetic */ void lambda$maybeSetFlags$3(int flags, FillRequestEventInternal event) {
        event.mFlags = flags;
    }

    public void maybeSetRequestTriggerReason(final int reason) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda6(reason));
    }

    private static /* synthetic */ void lambda$maybeSetRequestTriggerReason$4(int reason, FillRequestEventInternal event) {
        event.mRequestTriggerReason = reason;
    }

    public void maybeSetIsAugmented(final boolean val) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda5(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsAugmented$5(boolean val, FillRequestEventInternal event) {
        event.mIsAugmented = val;
    }

    public void maybeSetIsClientSuggestionFallback(final boolean val) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda8(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsClientSuggestionFallback$6(boolean val, FillRequestEventInternal event) {
        event.mIsClientSuggestionFallback = val;
    }

    public void maybeSetIsFillDialogEligible(final boolean val) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda2(val));
    }

    private static /* synthetic */ void lambda$maybeSetIsFillDialogEligible$7(boolean val, FillRequestEventInternal event) {
        event.mIsFillDialogEligible = val;
    }

    public void maybeSetLatencyFillRequestSentMillis(final int timestamp) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda4(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetLatencyFillRequestSentMillis$8(int timestamp, FillRequestEventInternal event) {
        event.mLatencyFillRequestSentMillis = timestamp;
    }

    public void maybeSetAppPackageUid(final int uid) {
        this.mEventInternal.ifPresent(new FillRequestEventLogger$$ExternalSyntheticLambda1(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAppPackageUid$9(int uid, FillRequestEventInternal event) {
        event.mAppPackageUid = uid;
    }

    public void logAndEndEvent() {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillFillRequestReported again for same event");
        return;
    L6:
        FillRequestEventInternal event = this.mEventInternal.get();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Log AutofillFillRequestReported: requestId=" + event.mRequestId + " sessionId=" + this.mSessionId + " mAutofillServiceUid=" + event.mAutofillServiceUid + " mInlineSuggestionHostUid=" + event.mInlineSuggestionHostUid + " mIsAugmented=" + event.mIsAugmented + " mIsClientSuggestionFallback=" + event.mIsClientSuggestionFallback + " mIsFillDialogEligible=" + event.mIsFillDialogEligible + " mRequestTriggerReason=" + event.mRequestTriggerReason + " mFlags=" + event.mFlags + " mLatencyFillRequestSentMillis=" + event.mLatencyFillRequestSentMillis + " mAppPackageUid=" + event.mAppPackageUid);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_FILL_REQUEST_REPORTED, event.mRequestId, this.mSessionId, event.mAutofillServiceUid, event.mInlineSuggestionHostUid, event.mIsAugmented, event.mIsClientSuggestionFallback, event.mIsFillDialogEligible, event.mRequestTriggerReason, event.mFlags, event.mLatencyFillRequestSentMillis, event.mAppPackageUid);
        this.mEventInternal = Optional.empty();
    }
}
