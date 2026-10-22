package com.android.server.pm;

import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.PackageInfoLite;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.SigningDetails;
import android.content.pm.VerifierInfo;
import android.content.pm.parsing.PackageLite;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.incremental.IncrementalManager;
import android.pico.utils.Features;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import com.android.server.DeviceIdleInternal;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class VerifyingSession {
    private static final long DEFAULT_ENABLE_ROLLBACK_TIMEOUT_MILLIS = 10000;
    private static final long DEFAULT_INTEGRITY_VERIFICATION_TIMEOUT = 30000;
    private static final boolean DEFAULT_VERIFY_ENABLE = true;
    private static final String PROPERTY_ENABLE_ROLLBACK_TIMEOUT_MILLIS = "enable_rollback_timeout";
    private final int mDataLoaderType;
    private String mErrorMessage;
    private final int mInstallFlags;
    private final int mInstallReason;
    private final InstallSource mInstallSource;
    private final boolean mIsInherit;
    private final boolean mIsStaged;
    final IPackageInstallObserver2 mObserver;
    final OriginInfo mOriginInfo;
    private final String mPackageAbiOverride;
    private final PackageLite mPackageLite;
    MultiPackageVerifyingSession mParentVerifyingSession;
    private final PackageManagerService mPm;
    private final long mRequiredInstalledVersionCode;
    private int mRet;
    private final int mSessionId;
    private final SigningDetails mSigningDetails;
    private final UserHandle mUser;
    private final boolean mUserActionRequired;
    private final int mUserActionRequiredType;
    private final VerificationInfo mVerificationInfo;
    private boolean mWaitForEnableRollbackToComplete;
    private boolean mWaitForVerificationToComplete;

    public static /* synthetic */ void $r8$lambda$xNyXQ1No_dHYiE45ZanZzyDqER8(VerifyingSession r0) {
        r0.start();
    }

    VerifyingSession(UserHandle user, File stagedDir, IPackageInstallObserver2 observer, PackageInstaller.SessionParams sessionParams, InstallSource installSource, int installerUid, SigningDetails signingDetails, int sessionId, PackageLite lite, boolean userActionRequired, PackageManagerService pm) {
        boolean r1 = true;
        this.mRet = 1;
        this.mErrorMessage = null;
        this.mPm = pm;
        this.mUser = user;
        this.mOriginInfo = OriginInfo.fromStagedFile(stagedDir);
        this.mObserver = observer;
        this.mInstallFlags = sessionParams.installFlags;
        this.mInstallSource = installSource;
        this.mPackageAbiOverride = sessionParams.abiOverride;
        this.mVerificationInfo = new VerificationInfo(sessionParams.originatingUri, sessionParams.referrerUri, sessionParams.originatingUid, installerUid);
        this.mSigningDetails = signingDetails;
        this.mRequiredInstalledVersionCode = sessionParams.requiredInstalledVersionCode;
        if (sessionParams.dataLoaderParams == null) goto L5;
        int r6 = sessionParams.dataLoaderParams.getType();
    L6:
        this.mDataLoaderType = r6;
        this.mSessionId = sessionId;
        this.mPackageLite = lite;
        this.mUserActionRequired = userActionRequired;
        this.mUserActionRequiredType = sessionParams.requireUserAction;
        if (sessionParams.mode == 2) goto L10;
        r1 = false;
    L10:
        this.mIsInherit = r1;
        this.mIsStaged = sessionParams.isStaged;
        this.mInstallReason = sessionParams.installReason;
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public String toString() {
        return "VerifyingSession{" + Integer.toHexString(System.identityHashCode(this)) + " file=" + this.mOriginInfo.mFile + "}";
    }

    public void handleStartVerify() {
        PackageInfoLite pkgLite = PackageManagerServiceUtils.getMinimalPackageInfo(this.mPm.mContext, this.mPackageLite, this.mOriginInfo.mResolvedPath, this.mInstallFlags, this.mPackageAbiOverride);
        Pair<Integer, String> ret = this.mPm.verifyReplacingVersionCode(pkgLite, this.mRequiredInstalledVersionCode, this.mInstallFlags);
        setReturnCode(((Integer) ret.first).intValue(), (String) ret.second);
        if (this.mRet == 1) goto L6;
        return;
    L6:
        if (this.mOriginInfo.mExisting == true) goto L17;
        boolean verifyForRollback = !isARollback();
        if (isApex() == true) goto L14;
        if (isArchivedInstallation() == true) goto L14;
        if (verifyForRollback == false) goto L14;
        sendApkVerificationRequest(pkgLite);
    L14:
        if ((this.mInstallFlags & 262144) == 0) goto L18;
        sendEnableRollbackRequest();
        return;
    L18:
        return;
    }

    private boolean isARollback() {
        if (this.mInstallReason == 5) goto L5;
    L7:
        return false;
    L5:
        if (this.mInstallSource.mInitiatingPackageName.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L7;
        return true;
    }

    private void sendApkVerificationRequest(PackageInfoLite pkgLite) {
        PackageManagerService r0 = this.mPm;
        int verificationId = r0.mPendingVerificationToken;
        r0.mPendingVerificationToken = verificationId + 1;
        PackageVerificationState verificationState = new PackageVerificationState(this);
        this.mPm.mPendingVerification.append(verificationId, verificationState);
        sendPackageVerificationRequest(verificationId, pkgLite, verificationState);
        if (verificationState.areAllVerificationsComplete() == false) goto L6;
        this.mPm.mPendingVerification.remove(verificationId);
        return;
    }

    void sendEnableRollbackRequest() {
        PackageManagerService r0 = this.mPm;
        int enableRollbackToken = r0.mPendingEnableRollbackToken;
        r0.mPendingEnableRollbackToken = enableRollbackToken + 1;
        Trace.asyncTraceBegin(262144, "enable_rollback", enableRollbackToken);
        this.mPm.mPendingEnableRollback.append(enableRollbackToken, this);
        Intent enableRollbackIntent = new Intent("android.intent.action.PACKAGE_ENABLE_ROLLBACK");
        enableRollbackIntent.putExtra(PackageManagerInternal.EXTRA_ENABLE_ROLLBACK_TOKEN, enableRollbackToken);
        enableRollbackIntent.putExtra(PackageManagerInternal.EXTRA_ENABLE_ROLLBACK_SESSION_ID, this.mSessionId);
        enableRollbackIntent.setType("application/vnd.android.package-archive");
        enableRollbackIntent.addFlags(268435457);
        enableRollbackIntent.addFlags(67108864);
        this.mPm.mContext.sendBroadcastAsUser(enableRollbackIntent, UserHandle.SYSTEM, "android.permission.PACKAGE_ROLLBACK_AGENT");
        this.mWaitForEnableRollbackToComplete = true;
        long rollbackTimeout = DeviceConfig.getLong("rollback", PROPERTY_ENABLE_ROLLBACK_TIMEOUT_MILLIS, 10000);
        if (rollbackTimeout >= 0) goto L5;
        rollbackTimeout = 10000;
    L5:
        Message msg = this.mPm.mHandler.obtainMessage(22);
        msg.arg1 = enableRollbackToken;
        msg.arg2 = this.mSessionId;
        this.mPm.mHandler.sendMessageDelayed(msg, rollbackTimeout);
    }

    private void sendPackageVerificationRequest(int verificationId, PackageInfoLite pkgLite, PackageVerificationState verificationState) {
        VerifyingSession r0 = this;
        UserHandle verifierUser = r0.getUser();
        if (verifierUser != UserHandle.ALL) goto L6;
        verifierUser = UserHandle.of(r0.mPm.mUserManager.getCurrentUserId());
    L6:
        if (pkgLite.isSdkLibrary == false) goto L8;
        UserHandle verifierUser2 = UserHandle.SYSTEM;
    L9:
        int verifierUserId = verifierUser2.getIdentifier();
        List<String> requiredVerifierPackages = new ArrayList(Arrays.asList(r0.mPm.mRequiredVerifierPackages));
        if (Features.FEAT_FW_OVERSEAS == true) goto L17;
        int i = requiredVerifierPackages.size() - 1;
    L12:
        if (i < 0) goto L17;
        if (r0.packageExists(requiredVerifierPackages.get(i)) == false) goto L16;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Required verifier: " + requiredVerifierPackages.get(i) + " do not exist");
        requiredVerifierPackages.remove(i);
    L16:
        i = i - 1;
    L17:
        boolean r18 = false;
        if ((r0.mInstallFlags & 32) != 0) goto L20;
    L36:
        List<String> requiredVerifierPackages2 = requiredVerifierPackages;
        boolean requiredVerifierPackagesOverridden = false;
    L38:
        if (r0.mOriginInfo.mExisting == true) goto L118;
        if (r0.isVerificationEnabled(pkgLite, verifierUserId, requiredVerifierPackages2) == false) goto L118;
        Computer snapshot = r0.mPm.snapshotComputer();
        int numRequiredVerifierPackages = requiredVerifierPackages2.size();
        int i2 = numRequiredVerifierPackages - 1;
    L43:
        if (i2 < 0) goto L48;
        if (snapshot.isApplicationEffectivelyEnabled(requiredVerifierPackages2.get(i2), verifierUser2) == true) goto L47;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Required verifier: " + requiredVerifierPackages2.get(i2) + " is disabled");
        requiredVerifierPackages2.remove(i2);
    L47:
        i2 = i2 - 1;
        goto L43
    L48:
        Iterator<String> r3 = requiredVerifierPackages2.iterator();
    L50:
        if (r3.hasNext() == false) goto L52;
        String requiredVerifierPackage = r3.next();
        int requiredUid = snapshot.getPackageUid(requiredVerifierPackage, 268435456, verifierUserId);
        verificationState.addRequiredVerifierUid(requiredUid);
        goto L50
    L52:
        String r4 = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";
        Intent verification = new Intent("android.intent.action.PACKAGE_NEEDS_VERIFICATION");
        verification.addFlags(268435456);
        verification.setDataAndType(Uri.fromFile(new File(r0.mOriginInfo.mResolvedPath)), "application/vnd.android.package-archive");
        verification.addFlags(1);
        String r25 = "application/vnd.android.package-archive";
        ParceledListSlice<ResolveInfo> receivers = r0.mPm.queryIntentReceivers(snapshot, verification, "application/vnd.android.package-archive", 0, verifierUserId);
        int verifierUserId2 = verifierUserId;
        String requiredVerifierPackage2 = "android.content.pm.extra.VERIFICATION_ID";
        verification.putExtra("android.content.pm.extra.VERIFICATION_ID", verificationId);
        verification.putExtra("android.content.pm.extra.VERIFICATION_INSTALL_FLAGS", r0.mInstallFlags);
        verification.putExtra("android.content.pm.extra.VERIFICATION_PACKAGE_NAME", pkgLite.packageName);
        verification.putExtra("android.content.pm.extra.VERIFICATION_VERSION_CODE", pkgLite.versionCode);
        verification.putExtra("android.content.pm.extra.VERIFICATION_LONG_VERSION_CODE", pkgLite.getLongVersionCode());
        String baseCodePath = r0.mPackageLite.getBaseApkPath();
        String[] splitCodePaths = r0.mPackageLite.getSplitApkPaths();
        String r2 = "android.content.pm.extra.VERIFICATION_ROOT_HASH";
        if (IncrementalManager.isIncrementalPath(baseCodePath) == false) goto L55;
        String rootHashString = PackageManagerServiceUtils.buildVerificationRootHashString(baseCodePath, splitCodePaths);
        verification.putExtra("android.content.pm.extra.VERIFICATION_ROOT_HASH", rootHashString);
    L56:
        String baseCodePath2 = baseCodePath;
        String baseCodePath3 = "android.content.pm.extra.DATA_LOADER_TYPE";
        verification.putExtra("android.content.pm.extra.DATA_LOADER_TYPE", r0.mDataLoaderType);
        String r1 = "android.content.pm.extra.SESSION_ID";
        verification.putExtra("android.content.pm.extra.SESSION_ID", r0.mSessionId);
        Computer snapshot2 = snapshot;
        verification.putExtra("android.content.pm.extra.USER_ACTION_REQUIRED", r0.mUserActionRequired);
        r0.populateInstallerExtras(verification);
        if (r0.mDataLoaderType == 2) goto L59;
    L64:
        boolean streaming = r18;
        long verificationTimeout = VerificationUtils.getVerificationTimeout(r0.mPm.mContext, streaming);
        List<ComponentName> sufficientVerifiers = r0.matchVerifiers(pkgLite, receivers.getList(), verificationState);
        Intent verification2 = verification;
        if (pkgLite.isSdkLibrary == false) goto L72;
        boolean streaming2 = streaming;
        if ("com.test.sdk1_1".equals(pkgLite.packageName) == true) goto L73;
        if (sufficientVerifiers != null) goto L70;
        sufficientVerifiers = new ArrayList();
    L70:
        requiredVerifierPackage2 = "android.content.pm.extra.VERIFICATION_ID";
        ComponentName sdkSandboxComponentName = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, "com.android.server.sdksandbox.SdkSandboxVerifierReceiver");
        sufficientVerifiers.add(sdkSandboxComponentName);
        verificationState.addSufficientVerifier(Process.myUid());
        List<ComponentName> sufficientVerifiers2 = sufficientVerifiers;
    L74:
        DeviceIdleInternal idleController = (DeviceIdleInternal) r0.mPm.mInjector.getLocalService(DeviceIdleInternal.class);
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setTemporaryAppAllowlist(verificationTimeout, 0, 305, "");
        if (sufficientVerifiers2 == null) goto L83;
        int n = sufficientVerifiers2.size();
        if (n != 0) goto L79;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Additional verifiers required, but none installed.");
        r0.setReturnCode(-22, "Additional verifiers required, but none installed.");
        String rootHashString2 = rootHashString;
        int verifierUserId3 = verifierUserId2;
        Computer snapshot3 = snapshot2;
        boolean streaming3 = streaming2;
        DeviceIdleInternal idleController2 = idleController;
        String baseCodePath4 = "android.content.pm.extra.VERIFICATION_ROOT_HASH";
        Intent verification3 = verification2;
        long verificationTimeout2 = verificationTimeout;
    L85:
        if (requiredVerifierPackages2.size() != 0) goto L89;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "No required verifiers");
        return;
    L89:
        if (requiredVerifierPackages2.contains(pkgLite.packageName) == false) goto L91;
        int verificationCodeAtTimeout = 2;
    L95:
        Iterator<String> r34 = requiredVerifierPackages2.iterator();
    L97:
        if (r34.hasNext() == false) goto L115;
        String requiredVerifierPackage3 = r34.next();
        int requiredUid2 = snapshot3.getPackageUid(requiredVerifierPackage3, 268435456, verifierUserId3);
        if (requiredVerifierPackagesOverridden == false) goto L109;
        if (requiredVerifierPackages2.size() == 1) goto L109;
        Intent requiredIntent = new Intent(r4);
        requiredIntent.addFlags(1);
        requiredIntent.addFlags(268435456);
        requiredIntent.addFlags(32);
        r25 = r25;
        requiredIntent.setDataAndType(Uri.fromFile(new File(r0.mOriginInfo.mResolvedPath)), r25);
        requiredIntent.putExtra(r1, r0.mSessionId);
        requiredIntent.putExtra(baseCodePath3, r0.mDataLoaderType);
        if (rootHashString2 == null) goto L106;
        String r6 = baseCodePath4;
        rootHashString2 = rootHashString2;
        requiredIntent.putExtra(r6, rootHashString2);
    L107:
        requiredIntent.setPackage(requiredVerifierPackage3);
        verificationId = verificationId;
        r1 = r1;
        baseCodePath4 = r6;
        requiredVerifierPackage2 = requiredVerifierPackage2;
        requiredIntent.putExtra(requiredVerifierPackage2, -verificationId);
        String r5 = null;
    L114:
        String receiverPermission = r5;
        List<String> requiredVerifierPackages3 = requiredVerifierPackages2;
        String r7 = r25;
        long verificationTimeout3 = verificationTimeout2;
        int verifierUserId4 = verifierUserId3;
        DeviceIdleInternal idleController3 = idleController2;
        idleController3.addPowerSaveTempWhitelistApp(Process.myUid(), requiredVerifierPackage3, verificationTimeout3, verifierUserId4, false, 305, "package verifier");
        PackageVerificationResponse response = new PackageVerificationResponse(verificationCodeAtTimeout, requiredUid2);
        Intent verification4 = verification3;
        boolean streaming4 = streaming3;
        int r8 = verificationId;
        r0 = this;
        r0.startVerificationTimeoutCountdown(r8, streaming4, response, verificationTimeout3);
        r0.mPm.mContext.sendOrderedBroadcastAsUser(requiredIntent, verifierUser2, receiverPermission, -1, options.toBundle(), null, null, 0, null, null);
        requiredVerifierPackage2 = requiredVerifierPackage2;
        verifierUserId3 = verifierUserId4;
        verificationCodeAtTimeout = verificationCodeAtTimeout;
        verification3 = verification4;
        baseCodePath2 = baseCodePath2;
        requiredVerifierPackages2 = requiredVerifierPackages3;
        baseCodePath4 = baseCodePath4;
        idleController2 = idleController3;
        rootHashString2 = rootHashString2;
        r1 = r1;
        streaming3 = streaming4;
        verificationTimeout2 = verificationTimeout3;
        r4 = r4;
        r25 = r7;
        baseCodePath3 = baseCodePath3;
        goto L97
    L106:
        r6 = baseCodePath4;
        rootHashString2 = rootHashString2;
    L109:
        requiredIntent = new Intent(verification3);
        if (requiredVerifierPackagesOverridden == true) goto L112;
        ComponentName requiredVerifierComponent = matchComponentForVerifier(requiredVerifierPackage3, receivers.getList());
        requiredIntent.setComponent(requiredVerifierComponent);
    L113:
        r5 = "android.permission.PACKAGE_VERIFICATION_AGENT";
        goto L114
    L112:
        requiredIntent.setPackage(requiredVerifierPackage3);
        goto L113
    L115:
        Trace.asyncTraceBegin(262144, "verification", verificationId);
        r0.mWaitForVerificationToComplete = true;
        return;
    L91:
        int verificationCodeAtTimeout2 = r0.getDefaultVerificationResponse();
        if (verificationCodeAtTimeout2 != 1) goto L94;
        verificationCodeAtTimeout = 2;
        goto L95
    L94:
        verificationCodeAtTimeout = -1;
        goto L95
    L79:
        int i3 = 0;
    L80:
        if (i3 >= n) goto L82;
        ComponentName verifierComponent = sufficientVerifiers2.get(i3);
        List<ComponentName> sufficientVerifiers3 = sufficientVerifiers2;
        DeviceIdleInternal idleController4 = idleController;
        int n2 = n;
        Intent verification5 = verification2;
        long verificationTimeout4 = verificationTimeout;
        idleController4.addPowerSaveTempWhitelistApp(Process.myUid(), verifierComponent.getPackageName(), verificationTimeout4, verifierUserId2, false, 305, "package verifier");
        Intent sufficientIntent = new Intent(verification5);
        sufficientIntent.setComponent(verifierComponent);
        r0.mPm.mContext.sendBroadcastAsUser(sufficientIntent, verifierUser2, null, options.toBundle());
        verifierUserId2 = verifierUserId2;
        idleController = idleController4;
        splitCodePaths = splitCodePaths;
        sufficientVerifiers2 = sufficientVerifiers3;
        n = n2;
        snapshot2 = snapshot2;
        i3 = i3 + 1;
        rootHashString = rootHashString;
        verification2 = verification5;
        r2 = r2;
        streaming2 = streaming2;
        verificationTimeout = verificationTimeout4;
        goto L80
    L82:
        rootHashString2 = rootHashString;
        verifierUserId3 = verifierUserId2;
        snapshot3 = snapshot2;
        streaming3 = streaming2;
        idleController2 = idleController;
        long r46 = verificationTimeout;
        baseCodePath4 = r2;
        verification3 = verification2;
        verificationTimeout2 = r46;
        goto L85
    L83:
        rootHashString2 = rootHashString;
        verifierUserId3 = verifierUserId2;
        snapshot3 = snapshot2;
        streaming3 = streaming2;
        idleController2 = idleController;
        baseCodePath4 = "android.content.pm.extra.VERIFICATION_ROOT_HASH";
        verification3 = verification2;
        verificationTimeout2 = verificationTimeout;
    L73:
        sufficientVerifiers2 = sufficientVerifiers;
        goto L74
    L72:
        streaming2 = streaming;
        goto L73
    L59:
        if (r0.mSigningDetails.getSignatureSchemeVersion() != 4) goto L64;
        if (r0.getDefaultVerificationResponse() != 1) goto L64;
        r18 = true;
        goto L64
    L55:
        rootHashString = null;
    L118:
        verificationState.passRequiredVerification();
        return;
    L20:
        if ((r0.mInstallFlags & 524288) != 0) goto L36;
        String property = SystemProperties.get("debug.pm.adb_verifier_override_packages", "");
        if (TextUtils.isEmpty(property) == true) goto L36;
        String[] verifierPackages = property.split(";");
        List<String> adbVerifierOverridePackages = new ArrayList();
        int r15 = verifierPackages.length;
        int r12 = 0;
    L24:
        if (r12 >= r15) goto L32;
        String verifierPackage = verifierPackages[r12];
        if (TextUtils.isEmpty(verifierPackage) == true) goto L30;
        if (r0.packageExists(verifierPackage) == false) goto L30;
        adbVerifierOverridePackages.add(verifierPackage);
    L30:
        r12 = r12 + 1;
        goto L24
    L32:
        if (adbVerifierOverridePackages.size() <= 0) goto L36;
        if (r0.isAdbVerificationEnabled(pkgLite, verifierUserId, true) == true) goto L36;
        requiredVerifierPackages2 = adbVerifierOverridePackages;
        requiredVerifierPackagesOverridden = true;
        goto L38
    L8:
        verifierUser2 = verifierUser;
        goto L9
    }

    private void startVerificationTimeoutCountdown(int r3, boolean r4, PackageVerificationResponse r5, long r6) {
        Message r0 = this.mPm.mHandler.obtainMessage(16);
        r0.arg1 = r3;
        r0.arg2 = r4 ? 1 : 0;
        r0.obj = r5;
        this.mPm.mHandler.sendMessageDelayed(r0, r6);
    }

    int getDefaultVerificationResponse() {
        if (this.mPm.mUserManager.hasUserRestriction("ensure_verify_apps", getUser().getIdentifier()) == false) goto L7;
        return -1;
    L7:
        return android.provider.Settings.Global.getInt(this.mPm.mContext.getContentResolver(), "verifier_default_response", 1);
    }

    private boolean packageExists(String packageName) {
        Computer snapshot = this.mPm.snapshotComputer();
        if (snapshot.getPackageStateInternal(packageName) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isAdbVerificationEnabled(PackageInfoLite pkgInfoLite, int userId, boolean requestedDisableVerification) {
        if (android.provider.Settings.Global.getInt(this.mPm.mContext.getContentResolver(), "verifier_verify_adb_installs", 1) == 0) goto L5;
        boolean verifierIncludeAdb = true;
    L7:
        if (this.mPm.isUserRestricted(userId, "ensure_verify_apps") == false) goto L11;
        if (verifierIncludeAdb == true) goto L10;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Force verification of ADB install because of user restriction.");
    L10:
        return true;
    L11:
        if (verifierIncludeAdb == true) goto L13;
        return false;
    L13:
        if (requestedDisableVerification == true) goto L15;
        return true;
    L15:
        if (packageExists(pkgInfoLite.packageName) == true) goto L18;
        return true;
    L18:
        return !pkgInfoLite.debuggable;
    L5:
        verifierIncludeAdb = false;
        goto L7
    }

    private boolean isVerificationEnabled(PackageInfoLite pkgInfoLite, int userId, List<String> requiredVerifierPackages) {
        if (this.mVerificationInfo != null) goto L5;
        int installerUid = -1;
    L7:
        if ((this.mInstallFlags & 524288) == 0) goto L9;
        boolean requestedDisableVerification = true;
    L11:
        if ((this.mInstallFlags & 32) != 0) goto L13;
        if (requestedDisableVerification == false) goto L17;
        return false;
    L17:
        if (isInstant() == true) goto L19;
    L29:
        return true;
    L19:
        if (this.mPm.mInstantAppInstallerActivity == null) goto L29;
        String installerPackage = this.mPm.mInstantAppInstallerActivity.packageName;
        Iterator<String> r5 = requiredVerifierPackages.iterator();
    L22:
        if (r5.hasNext() == false) goto L29;
        String requiredVerifierPackage = r5.next();
        if (installerPackage.equals(requiredVerifierPackage) == false) goto L22;
        ((AppOpsManager) this.mPm.mInjector.getSystemService(AppOpsManager.class)).checkPackage(installerUid, requiredVerifierPackage);     // Catch: SecurityException -> L27
        return false;
    L13:
        return isAdbVerificationEnabled(pkgInfoLite, userId, requestedDisableVerification);
    L9:
        requestedDisableVerification = false;
        goto L11
    L5:
        installerUid = this.mVerificationInfo.mInstallerUid;
        goto L7
    }

    private List<ComponentName> matchVerifiers(PackageInfoLite pkgInfo, List<ResolveInfo> receivers, PackageVerificationState verificationState) {
        if (pkgInfo.verifiers != null) goto L5;
        return null;
    L5:
        if (pkgInfo.verifiers.length == 0) goto L25;
        int n = pkgInfo.verifiers.length;
        List<ComponentName> sufficientVerifiers = new ArrayList(n + 1);
        int i = 0;
    L8:
        if (i >= n) goto L18;
        VerifierInfo verifierInfo = pkgInfo.verifiers[i];
        ComponentName comp = matchComponentForVerifier(verifierInfo.packageName, receivers);
        if (comp == null) goto L16;
        int verifierUid = this.mPm.getUidForVerifier(verifierInfo);
        if (verifierUid == (-1)) goto L16;
        sufficientVerifiers.add(comp);
        verificationState.addSufficientVerifier(verifierUid);
    L16:
        i = i + 1;
        goto L8
    L18:
        return sufficientVerifiers;
    L25:
        return null;
    }

    private static ComponentName matchComponentForVerifier(String packageName, List<ResolveInfo> receivers) {
        ActivityInfo targetReceiver = null;
        int nr = receivers.size();
        int i = 0;
    L3:
        if (i >= nr) goto L11;
        ResolveInfo info = receivers.get(i);
        if (info.activityInfo == null) goto L10;
        if (packageName.equals(info.activityInfo.packageName) == false) goto L10;
        targetReceiver = info.activityInfo;
    L10:
        i = i + 1;
    L11:
        if (targetReceiver != null) goto L15;
        return null;
    L15:
        return new ComponentName(targetReceiver.packageName, targetReceiver.name);
    }

    void populateInstallerExtras(Intent intent) {
        intent.putExtra("android.content.pm.extra.VERIFICATION_INSTALLER_PACKAGE", this.mInstallSource.mInitiatingPackageName);
        if (this.mVerificationInfo != null) goto L5;
        return;
    L5:
        if (this.mVerificationInfo.mOriginatingUri == null) goto L8;
        intent.putExtra("android.intent.extra.ORIGINATING_URI", this.mVerificationInfo.mOriginatingUri);
    L8:
        if (this.mVerificationInfo.mReferrer == null) goto L11;
        intent.putExtra("android.intent.extra.REFERRER", this.mVerificationInfo.mReferrer);
    L11:
        if (this.mVerificationInfo.mOriginatingUid < 0) goto L14;
        intent.putExtra("android.intent.extra.ORIGINATING_UID", this.mVerificationInfo.mOriginatingUid);
    L14:
        if (this.mVerificationInfo.mInstallerUid < 0) goto L18;
        intent.putExtra("android.content.pm.extra.VERIFICATION_INSTALLER_UID", this.mVerificationInfo.mInstallerUid);
        return;
    }

    void setReturnCode(int ret, String message) {
        if (this.mRet != 1) goto L6;
        this.mRet = ret;
        this.mErrorMessage = message;
        return;
    }

    void handleVerificationFinished() {
        this.mWaitForVerificationToComplete = false;
        handleReturnCode();
    }

    void handleRollbackEnabled() {
        this.mWaitForEnableRollbackToComplete = false;
        handleReturnCode();
    }

    void handleReturnCode() {
        if (this.mWaitForVerificationToComplete == false) goto L5;
        return;
    L5:
        if (this.mWaitForEnableRollbackToComplete == true) goto L13;
        sendVerificationCompleteNotification();
        if (this.mRet == 1) goto L12;
        PackageMetrics.onVerificationFailed(this);
        return;
    L12:
        return;
    }

    private void sendVerificationCompleteNotification() {
        if (this.mParentVerifyingSession == null) goto L10;
        this.mParentVerifyingSession.trySendVerificationCompleteNotification(this);
        return;
    L10:
        this.mObserver.onPackageInstalled(null, this.mRet, this.mErrorMessage, new Bundle());     // Catch: RemoteException -> L7
        return;
    L8:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Observer no longer exists.");
    }

    private void start() {
        Trace.asyncTraceEnd(262144, "queueVerify", System.identityHashCode(this));
        Trace.traceBegin(262144, IMediaProjectionManagerServiceExt.NODE_START);
        handleStartVerify();
        handleReturnCode();
        Trace.traceEnd(262144);
    }

    public void verifyStage() {
        Trace.asyncTraceBegin(262144, "queueVerify", System.identityHashCode(this));
        this.mPm.mHandler.post(new VerifyingSession$$ExternalSyntheticLambda1(this));
    }

    public void verifyStage(List<VerifyingSession> children) throws PackageManagerException {
        final MultiPackageVerifyingSession multiPackageVerifyingSession = new MultiPackageVerifyingSession(this, children);
        this.mPm.mHandler.post(new VerifyingSession$$ExternalSyntheticLambda0(multiPackageVerifyingSession));
    }

    public int getRet() {
        return this.mRet;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public UserHandle getUser() {
        return this.mUser;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public int getDataLoaderType() {
        return this.mDataLoaderType;
    }

    public int getUserActionRequiredType() {
        return this.mUserActionRequiredType;
    }

    public boolean isInstant() {
        if ((this.mInstallFlags & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInherit() {
        return this.mIsInherit;
    }

    public int getInstallerPackageUid() {
        return this.mInstallSource.mInstallerPackageUid;
    }

    public boolean isApex() {
        if ((this.mInstallFlags & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isArchivedInstallation() {
        if ((this.mInstallFlags & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStaged() {
        return this.mIsStaged;
    }
}
