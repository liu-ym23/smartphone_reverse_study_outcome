package com.android.server.pm;

import android.content.Intent;
import android.content.pm.InstantAppRequest;
import android.content.pm.PackageManagerInternal;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.Trace;
import android.os.UserHandle;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class PackageHandler extends Handler {
    private final PackageManagerService mPm;

    PackageHandler(Looper looper, PackageManagerService pm) {
        super(looper);
        this.mPm = pm;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        doHandleMessage(msg);     // Catch: Throwable -> L6
        Process.setThreadPriority(0);
        return;
    L6:
        th = move-exception;
        Process.setThreadPriority(0);
        throw th;
    }

    void doHandleMessage(Message msg) {
        boolean killApp = false;
        switch(msg.what) {
            case 1: goto L71;
            case 9: goto L55;
            case 13: goto L54;
            case 15: goto L47;
            case 16: goto L33;
            case 19: goto L32;
            case 20: goto L31;
            case 21: goto L24;
            case 22: goto L21;
            case 23: goto L17;
            case 24: goto L10;
            case 27: goto L9;
            case 28: goto L76;
            case 29: goto L10;
            default: goto L72;
        };
    L9:
        int messageCode = msg.arg1;
        Object object = msg.obj;
        this.mPm.mDomainVerificationManager.runMessage(messageCode, object);
        goto L72
    L10:
        String packageName = (String) msg.obj;
        if (packageName == null) goto L72;
        if (msg.what != 29) goto L15;
        killApp = true;
    L15:
        this.mPm.notifyInstallObserver(packageName, killApp);
        goto L72
    L17:
        CleanUpArgs args = (CleanUpArgs) msg.obj;
        if (args == null) goto L72;
        this.mPm.cleanUpResources(args.getPackageName(), args.getCodeFile(), args.getInstructionSets());
        goto L72
    L21:
        int enableRollbackToken = msg.arg1;
        int sessionId = msg.arg2;
        VerifyingSession params = this.mPm.mPendingEnableRollback.get(enableRollbackToken);
        if (params == null) goto L72;
        Uri originUri = Uri.fromFile(params.mOriginInfo.mResolvedFile);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Enable rollback timed out for " + originUri);
        this.mPm.mPendingEnableRollback.remove(enableRollbackToken);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Continuing with installation of " + originUri);
        Trace.asyncTraceEnd(262144, "enable_rollback", enableRollbackToken);
        params.handleRollbackEnabled();
        Intent rollbackTimeoutIntent = new Intent("android.intent.action.CANCEL_ENABLE_ROLLBACK");
        rollbackTimeoutIntent.putExtra(PackageManagerInternal.EXTRA_ENABLE_ROLLBACK_SESSION_ID, sessionId);
        rollbackTimeoutIntent.addFlags(AudioFormat.AAC_ADIF);
        this.mPm.mContext.sendBroadcastAsUser(rollbackTimeoutIntent, UserHandle.SYSTEM, "android.permission.PACKAGE_ROLLBACK_AGENT");
        goto L72
    L24:
        int enableRollbackToken2 = msg.arg1;
        int enableRollbackCode = msg.arg2;
        VerifyingSession params2 = this.mPm.mPendingEnableRollback.get(enableRollbackToken2);
        if (params2 != null) goto L27;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Invalid rollback enabled token " + enableRollbackToken2 + " received");
        goto L72
    L27:
        this.mPm.mPendingEnableRollback.remove(enableRollbackToken2);
        if (enableRollbackCode == 1) goto L30;
        Uri originUri2 = Uri.fromFile(params2.mOriginInfo.mResolvedFile);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to enable rollback for " + originUri2);
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Continuing with installation of " + originUri2);
    L30:
        Trace.asyncTraceEnd(262144, "enable_rollback", enableRollbackToken2);
        params2.handleRollbackEnabled();
        goto L72
    L31:
        InstantAppResolver.doInstantAppResolutionPhaseTwo(this.mPm.mContext, this.mPm.snapshotComputer(), this.mPm.mUserManager, this.mPm.mInstantAppResolverConnection, (InstantAppRequest) msg.obj, this.mPm.mInstantAppInstallerActivity, this.mPm.mHandler);
        goto L72
    L32:
        this.mPm.writePackageList(msg.arg1);
        goto L72
    L33:
        int verificationId = msg.arg1;
        if (msg.arg2 == 0) goto L36;
        killApp = true;
    L36:
        PackageVerificationState state = this.mPm.mPendingVerification.get(verificationId);
        if (state == null) goto L72;
        if (state.isVerificationComplete() == true) goto L72;
        PackageVerificationResponse response = (PackageVerificationResponse) msg.obj;
        if (killApp == false) goto L44;
    L46:
        VerificationUtils.processVerificationResponseOnTimeout(verificationId, state, response, this.mPm);
        goto L72
    L44:
        if (state.timeoutExtended(response.callerUid) == false) goto L46;
    L47:
        int verificationId2 = msg.arg1;
        PackageVerificationState state2 = this.mPm.mPendingVerification.get(verificationId2);
        if (state2 != null) goto L51;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Verification with id " + verificationId2 + " not found. It may be invalid or overridden by integrity verification");
        goto L72
    L51:
        if (state2.isVerificationComplete() == false) goto L53;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Verification with id " + verificationId2 + " already complete.");
        goto L72
    L53:
        VerificationUtils.processVerificationResponse(verificationId2, state2, (PackageVerificationResponse) msg.obj, this.mPm);
        goto L72
    L54:
        this.mPm.writeSettings(false);
        goto L72
    L55:
        SparseArray<InstallRequest> r5 = this.mPm.mRunningInstalls;
        monitor-enter(r5);
        InstallRequest request = this.mPm.mRunningInstalls.get(msg.arg1);     // Catch: Throwable -> L68
        int token = msg.arg1;     // Catch: Throwable -> L68
        if (msg.arg2 == 0) goto L60;
        killApp = true;
    L60:
        this.mPm.mRunningInstalls.delete(token);     // Catch: Throwable -> L68
        monitor-exit(r5);     // Catch: Throwable -> L68
        if (request == null) goto L72;
        request.onRestoreFinished();
        request.closeFreezer();
        request.onInstallCompleted();
        request.runPostInstallRunnable();
        if (request.isInstallExistingForUser() == true) goto L67;
        this.mPm.handlePackagePostInstall(request, killApp);
    L67:
        Trace.asyncTraceEnd(262144, "postInstall", token);
    L68:
        th = move-exception;
        throw th;
    L71:
        this.mPm.sendPendingBroadcasts((String) msg.obj, msg.arg1);
    L72:
        this.mPm.getSmtEx().handlePackageHandlerMessage(msg);
        return;
    L76:
        this.mPm.mInjector.getSharedLibrariesImpl().pruneUnusedStaticSharedLibraries(this.mPm.snapshotComputer(), Long.MAX_VALUE, android.provider.Settings.Global.getLong(this.mPm.mContext.getContentResolver(), "unused_static_shared_lib_min_cache_period", PackageManagerService.DEFAULT_UNUSED_STATIC_SHARED_LIB_MIN_CACHE_PERIOD));     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Log.w(PackageManagerServiceMonitorEx.TAG, "Failed to prune unused static shared libraries :" + e.getMessage());
        goto L72
    }

    private int getDefaultIntegrityVerificationResponse() {
        return -1;
    }
}
