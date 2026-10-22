package com.android.server.autofill;

import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public final class SessionCommittedEventLogger {
    private static final String TAG = "SessionCommittedEventLogger";
    private Optional<SessionCommittedEventInternal> mEventInternal;
    private final int mSessionId;

    private static final class SessionCommittedEventInternal {
        int mCommitReason;
        int mComponentPackageUid;
        boolean mLastFillResponseHasSaveInfo;
        int mRequestCount;
        int mSaveDataTypeCount;
        int mSaveInfoCount;
        int mServiceUid;
        long mSessionDurationMillis;

        SessionCommittedEventInternal() {
            this.mComponentPackageUid = -1;
            this.mRequestCount = 0;
            this.mCommitReason = 0;
            this.mSessionDurationMillis = 0;
            this.mSaveInfoCount = -1;
            this.mSaveDataTypeCount = -1;
            this.mLastFillResponseHasSaveInfo = false;
            this.mServiceUid = -1;
        }
    }

    public static /* synthetic */ void $r8$lambda$BlSVEKxPp9P4avERxsDAaz58jd8(long r0, SessionCommittedEventInternal r2) {
        lambda$maybeSetSessionDurationMillis$4(r0, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$HsqkxAYc58iyLU4WNd-Mk5xk_H0, reason: not valid java name */
    public static /* synthetic */ void m2405$r8$lambda$HsqkxAYc58iyLU4WNdMk5xk_H0(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetCommitReason$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$LY4Ou2aqc536Lj2KOQB7gxeLyxU(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetCommitReasonIfUnset$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$O8D0U-ZFMbQ9K-k6cv1g0NVoX3M, reason: not valid java name */
    public static /* synthetic */ void m2406$r8$lambda$O8D0UZFMbQ9Kk6cv1g0NVoX3M(boolean r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetLastFillResponseHasSaveInfo$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$QNwSlTdk9UL7p_QrJ6DefjJ6uoA(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetSaveInfoCount$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mslFZYMhJ8u326ComgYz6ovFgSk(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetRequestCount$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ny2JbwLP97Bu2zo1p4umW6asfOA(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetAutofillServiceUid$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qGLRZewFU1njUV1aReG5bVmk-ls, reason: not valid java name */
    public static /* synthetic */ void m2407$r8$lambda$qGLRZewFU1njUV1aReG5bVmkls(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetComponentPackageUid$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xAUSKFAWNmZqjXPE67ZKGiJwK2Q(int r0, SessionCommittedEventInternal r1) {
        lambda$maybeSetSaveDataTypeCount$7(r0, r1);
    }

    private SessionCommittedEventLogger(int sessionId) {
        this.mSessionId = sessionId;
        this.mEventInternal = Optional.of(new SessionCommittedEventInternal());
    }

    public static SessionCommittedEventLogger forSessionId(int sessionId) {
        return new SessionCommittedEventLogger(sessionId);
    }

    public void maybeSetComponentPackageUid(final int val) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda0(val));
    }

    private static /* synthetic */ void lambda$maybeSetComponentPackageUid$0(int val, SessionCommittedEventInternal event) {
        event.mComponentPackageUid = val;
    }

    public void maybeSetRequestCount(final int val) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda4(val));
    }

    private static /* synthetic */ void lambda$maybeSetRequestCount$1(int val, SessionCommittedEventInternal event) {
        event.mRequestCount = val;
    }

    public void maybeSetCommitReason(final int val) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda3(val));
    }

    private static /* synthetic */ void lambda$maybeSetCommitReason$2(int val, SessionCommittedEventInternal event) {
        event.mCommitReason = val;
    }

    public void maybeSetCommitReasonIfUnset(final int val) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda1(val));
    }

    private static /* synthetic */ void lambda$maybeSetCommitReasonIfUnset$3(int val, SessionCommittedEventInternal event) {
        if (event.mCommitReason == 0) goto L5;
        return;
    L5:
        event.mCommitReason = val;
    }

    public void maybeSetSessionDurationMillis(final long timestamp) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda2(timestamp));
    }

    private static /* synthetic */ void lambda$maybeSetSessionDurationMillis$4(long timestamp, SessionCommittedEventInternal event) {
        event.mSessionDurationMillis = timestamp;
    }

    public void maybeSetAutofillServiceUid(final int uid) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda8(uid));
    }

    private static /* synthetic */ void lambda$maybeSetAutofillServiceUid$5(int uid, SessionCommittedEventInternal event) {
        event.mServiceUid = uid;
    }

    public void maybeSetSaveInfoCount(final int saveInfoCount) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda6(saveInfoCount));
    }

    private static /* synthetic */ void lambda$maybeSetSaveInfoCount$6(int saveInfoCount, SessionCommittedEventInternal event) {
        event.mSaveInfoCount = saveInfoCount;
    }

    public void maybeSetSaveDataTypeCount(final int saveDataTypeCount) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda5(saveDataTypeCount));
    }

    private static /* synthetic */ void lambda$maybeSetSaveDataTypeCount$7(int saveDataTypeCount, SessionCommittedEventInternal event) {
        event.mSaveDataTypeCount = saveDataTypeCount;
    }

    public void maybeSetLastFillResponseHasSaveInfo(final boolean lastFillResponseHasSaveInfo) {
        this.mEventInternal.ifPresent(new SessionCommittedEventLogger$$ExternalSyntheticLambda7(lastFillResponseHasSaveInfo));
    }

    private static /* synthetic */ void lambda$maybeSetLastFillResponseHasSaveInfo$8(boolean lastFillResponseHasSaveInfo, SessionCommittedEventInternal event) {
        event.mLastFillResponseHasSaveInfo = lastFillResponseHasSaveInfo;
    }

    public void logAndEndEvent() {
        if (this.mEventInternal.isPresent() == true) goto L6;
        Slog.w(TAG, "Shouldn't be logging AutofillSessionCommitted again for same session.");
        return;
    L6:
        SessionCommittedEventInternal event = this.mEventInternal.get();
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "Log AutofillSessionCommitted: sessionId=" + this.mSessionId + " mComponentPackageUid=" + event.mComponentPackageUid + " mRequestCount=" + event.mRequestCount + " mCommitReason=" + event.mCommitReason + " mSessionDurationMillis=" + event.mSessionDurationMillis + " mServiceUid=" + event.mServiceUid + " mSaveInfoCount=" + event.mSaveInfoCount + " mSaveDataTypeCount=" + event.mSaveDataTypeCount + " mLastFillResponseHasSaveInfo=" + event.mLastFillResponseHasSaveInfo);
    L9:
        FrameworkStatsLog.write(FrameworkStatsLog.AUTOFILL_SESSION_COMMITTED, this.mSessionId, event.mComponentPackageUid, event.mRequestCount, event.mCommitReason, event.mSessionDurationMillis, event.mServiceUid, event.mSaveInfoCount, event.mSaveDataTypeCount, event.mLastFillResponseHasSaveInfo);
        this.mEventInternal = Optional.empty();
    }
}
