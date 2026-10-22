package com.android.server.pm;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Trace;
import android.os.UserHandle;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
final class VerificationUtils {
    private static final long DEFAULT_STREAMING_VERIFICATION_TIMEOUT = 3000;
    private static final long DEFAULT_VERIFICATION_TIMEOUT = 10000;

    VerificationUtils() {
    }

    public static long getVerificationTimeout(Context context, boolean streaming) {
        if (streaming == false) goto L6;
        return getDefaultStreamingVerificationTimeout(context);
    L6:
        return getDefaultVerificationTimeout(context);
    }

    public static long getDefaultVerificationTimeout(Context context) {
        long timeout = android.provider.Settings.Global.getLong(context.getContentResolver(), "verifier_timeout", 10000);
        return Math.max(timeout, 10000);
    }

    public static long getDefaultStreamingVerificationTimeout(Context context) {
        long timeout = android.provider.Settings.Global.getLong(context.getContentResolver(), "streaming_verifier_timeout", 3000);
        return Math.max(timeout, 3000);
    }

    public static void broadcastPackageVerified(int verificationId, Uri packageUri, int verificationCode, String rootHashString, int dataLoaderType, UserHandle user, Context context) {
        Intent intent = new Intent("android.intent.action.PACKAGE_VERIFIED");
        intent.setDataAndType(packageUri, "application/vnd.android.package-archive");
        intent.addFlags(1);
        intent.putExtra("android.content.pm.extra.VERIFICATION_ID", verificationId);
        intent.putExtra("android.content.pm.extra.VERIFICATION_RESULT", verificationCode);
        if (rootHashString == null) goto L5;
        intent.putExtra("android.content.pm.extra.VERIFICATION_ROOT_HASH", rootHashString);
    L5:
        intent.putExtra("android.content.pm.extra.DATA_LOADER_TYPE", dataLoaderType);
        context.sendBroadcastAsUser(intent, user, "android.permission.PACKAGE_VERIFICATION_AGENT");
    }

    static void processVerificationResponseOnTimeout(int verificationId, PackageVerificationState state, PackageVerificationResponse response, PackageManagerService pms) {
        state.setVerifierResponseOnTimeout(response.callerUid, response.code);
        processVerificationResponse(verificationId, state, response.code, "Verification timed out", pms);
    }

    static void processVerificationResponse(int verificationId, PackageVerificationState state, PackageVerificationResponse response, PackageManagerService pms) {
        state.setVerifierResponse(response.callerUid, response.code);
        processVerificationResponse(verificationId, state, response.code, "Install not allowed", pms);
    }

    private static void processVerificationResponse(int verificationId, PackageVerificationState state, int verificationResult, String failureReason, PackageManagerService pms) {
        if (state.isVerificationComplete() == true) goto L5;
        return;
    L5:
        VerifyingSession verifyingSession = state.getVerifyingSession();
        if (verifyingSession == null) goto L8;
        Uri r1 = Uri.fromFile(verifyingSession.mOriginInfo.mResolvedFile);
    L9:
        Uri originUri = r1;
        if (state.isInstallAllowed() == false) goto L12;
        int verificationCode = verificationResult;
    L13:
        if (pms == null) goto L16;
        if (verifyingSession == null) goto L16;
        int verificationId2 = verificationId;
        broadcastPackageVerified(verificationId2, originUri, verificationCode, null, verifyingSession.getDataLoaderType(), verifyingSession.getUser(), pms.mContext);
    L18:
        if (state.isInstallAllowed() == false) goto L20;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Continuing with installation of " + originUri);
    L23:
        if (pms != null) goto L25;
    L27:
        Trace.asyncTraceEnd(262144, "verification", verificationId2);
        if (verifyingSession == null) goto L31;
        verifyingSession.handleVerificationFinished();
        return;
    L31:
        return;
    L25:
        if (state.areAllVerificationsComplete() == false) goto L27;
        pms.mPendingVerification.remove(verificationId2);
        goto L27
    L20:
        String errorMsg = failureReason + " for " + originUri;
        Slog.i(PackageManagerServiceMonitorEx.TAG, errorMsg);
        if (verifyingSession == null) goto L23;
        verifyingSession.setReturnCode(-22, errorMsg);
    L16:
        verificationId2 = verificationId;
        goto L18
    L12:
        verificationCode = -1;
        goto L13
    L8:
        r1 = null;
        goto L9
    }
}
