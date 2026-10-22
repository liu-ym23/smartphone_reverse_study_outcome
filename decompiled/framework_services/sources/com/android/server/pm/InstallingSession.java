package com.android.server.pm;

import android.apex.ApexInfo;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.PackageInfoLite;
import android.content.pm.PackageInstaller;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.PackageLite;
import android.content.pm.verify.domain.DomainSet;
import android.os.Environment;
import android.os.Trace;
import android.os.UserHandle;
import android.os.incremental.IncrementalManager;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.content.F2fsUtils;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.content.NativeLibraryHelper;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.util.Preconditions;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
class InstallingSession {
    final List<String> mAllowlistedRestrictedPermissions;
    final boolean mApplicationEnabledSettingPersistent;
    final int mAutoRevokePermissionsMode;
    final int mDataLoaderType;
    final boolean mDependencyInstallerEnabled;
    final int mDevelopmentInstallFlags;
    final String mDexoptCompilerFilter;
    private IExtInstallingSession mExt;
    final boolean mForceQueryableOverride;
    final boolean mHasAppMetadataFile;
    int mInstallFlags;
    final int mInstallReason;
    final int mInstallScenario;
    final InstallSource mInstallSource;
    final boolean mIsInherit;
    final int mMissingSharedLibraryCount;
    final MoveInfo mMoveInfo;
    final IPackageInstallObserver2 mObserver;
    final OriginInfo mOriginInfo;
    final String mPackageAbiOverride;
    final PackageLite mPackageLite;
    final int mPackageSource;
    MultiPackageInstallingSession mParentInstallingSession;
    final ArrayMap<String, Integer> mPermissionStates;
    final PackageManagerService mPm;
    final DomainSet mPreVerifiedDomains;
    final int mRequireUserAction;
    final long mRequiredInstalledVersionCode;
    int mRet;
    final int mSessionId;
    final SigningDetails mSigningDetails;
    int mTraceCookie;
    String mTraceMethod;
    private final UserHandle mUser;
    final String mVolumeUuid;

    private class MultiPackageInstallingSession {
        private final List<InstallingSession> mChildInstallingSessions;
        private final Set<InstallRequest> mCurrentInstallRequests;
        final PackageManagerService mPm;
        final UserHandle mUser;
        final /* synthetic */ InstallingSession this$0;

        public static /* synthetic */ void $r8$lambda$FG4z4NCeCPsiEmF_i1M46hmAqCo(MultiPackageInstallingSession r0, int r1, List r2) {
            r0.lambda$tryProcessInstallRequest$0(r1, r2);
        }

        MultiPackageInstallingSession(InstallingSession r2, UserHandle user, List<InstallingSession> childInstallingSessions, PackageManagerService pm) throws PackageManagerException {
            this.this$0 = r2;
            if (childInstallingSessions.size() == 0) goto L11;
            this.mPm = pm;
            this.mUser = user;
            this.mChildInstallingSessions = childInstallingSessions;
            int i = 0;
        L6:
            if (i >= childInstallingSessions.size()) goto L8;
            InstallingSession childInstallingSession = childInstallingSessions.get(i);
            childInstallingSession.mParentInstallingSession = this;
            i = i + 1;
            goto L6
        L8:
            this.mCurrentInstallRequests = new ArraySet(this.mChildInstallingSessions.size());
            return;
        L11:
            throw PackageManagerException.ofInternalError("No child sessions found!", -20);
        }

        public void start() {
            Trace.asyncTraceEnd(262144, "queueInstall", System.identityHashCode(this));
            Trace.traceBegin(262144, IMediaProjectionManagerServiceExt.NODE_START);
            int numChildSessions = this.mChildInstallingSessions.size();
            ArrayList<InstallRequest> installRequests = new ArrayList(numChildSessions);
            int i = 0;
        L3:
            if (i >= numChildSessions) goto L5;
            InstallingSession childSession = this.mChildInstallingSessions.get(i);
            InstallRequest installRequest = new InstallRequest(childSession);
            installRequests.add(installRequest);
            InstallingSession.m6675$$Nest$mhandleStartCopy(childSession, installRequest);
            i = i + 1;
            goto L3
        L5:
            int i2 = 0;
        L6:
            if (i2 >= numChildSessions) goto L8;
            InstallingSession.m6674$$Nest$mhandleReturnCode(this.mChildInstallingSessions.get(i2), installRequests.get(i2));
            i2 = i2 + 1;
            goto L6
        L8:
            Trace.traceEnd(262144);
        }

        public void tryProcessInstallRequest(InstallRequest request) {
            this.mCurrentInstallRequests.add(request);
            if (this.mCurrentInstallRequests.size() == this.mChildInstallingSessions.size()) goto L5;
            return;
        L5:
            int completeStatus = 1;
            Iterator<InstallRequest> r1 = this.mCurrentInstallRequests.iterator();
        L7:
            if (r1.hasNext() == false) goto L15;
            InstallRequest installRequest = r1.next();
            if (installRequest.getReturnCode() == 0) goto L10;
            if (installRequest.getReturnCode() == 1) goto L7;
            completeStatus = installRequest.getReturnCode();
            goto L15
        L10:
            return;
        L15:
            final List<InstallRequest> installRequests = new ArrayList(this.mCurrentInstallRequests.size());
            Iterator<InstallRequest> r2 = this.mCurrentInstallRequests.iterator();
        L17:
            if (r2.hasNext() == false) goto L19;
            InstallRequest installRequest2 = r2.next();
            installRequest2.setReturnCode(completeStatus);
            installRequests.add(installRequest2);
            goto L17
        L19:
            final int finalCompleteStatus = completeStatus;
            this.mPm.mHandler.post(new InstallingSession$MultiPackageInstallingSession$$ExternalSyntheticLambda0(this, finalCompleteStatus, installRequests));
        }

        private /* synthetic */ void lambda$tryProcessInstallRequest$0(int finalCompleteStatus, List installRequests) {
            InstallingSession r0 = this.this$0;
            boolean r1 = true;
            if (finalCompleteStatus == 1) goto L6;
            r1 = false;
        L6:
            InstallingSession.m6676$$Nest$mprocessInstallRequests(r0, r1, installRequests);
        }

        public String toString() {
            return "MultiPackageInstallingSession{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$3YxEVU-qWs8li-YcaWhP_DprQyQ, reason: not valid java name */
    public static /* synthetic */ void m6671$r8$lambda$3YxEVUqWs8liYcaWhP_DprQyQ(InstallingSession r0, InstallRequest r1) {
        r0.lambda$processPendingInstall$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$W6cR9Ys08-5335--4Z-HKpTJitw, reason: not valid java name */
    public static /* synthetic */ void m6672$r8$lambda$W6cR9Ys0853354ZHKpTJitw(InstallingSession r0, List r1) {
        r0.lambda$installApexPackages$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$gEcdI8cK9dzFagC4AcY_lMc7VaM(InstallingSession r0) {
        r0.start();
    }

    /* JADX INFO: renamed from: $r8$lambda$zYUVT-RGxbD5-C2bJNfd8Hvzf3M, reason: not valid java name */
    public static /* synthetic */ void m6673$r8$lambda$zYUVTRGxbD5C2bJNfd8Hvzf3M(InstallingSession r0, List r1) {
        r0.lambda$processInstallRequests$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleReturnCode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6674$$Nest$mhandleReturnCode(InstallingSession r0, InstallRequest r1) {
        r0.handleReturnCode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleStartCopy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6675$$Nest$mhandleStartCopy(InstallingSession r0, InstallRequest r1) {
        r0.handleStartCopy(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessInstallRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6676$$Nest$mprocessInstallRequests(InstallingSession r0, boolean r1, List r2) {
        r0.processInstallRequests(r1, r2);
    }

    InstallingSession(OriginInfo originInfo, MoveInfo moveInfo, IPackageInstallObserver2 observer, int installFlags, int developmentInstallFlags, InstallSource installSource, String volumeUuid, UserHandle user, String packageAbiOverride, int packageSource, PackageLite packageLite, PackageManagerService pm) {
        this.mExt = (IExtInstallingSession) ExtImplFactory.getImpl(IExtInstallingSession.class, new Object[]{this});
        this.mPm = pm;
        this.mUser = user;
        this.mOriginInfo = originInfo;
        this.mMoveInfo = moveInfo;
        this.mObserver = observer;
        this.mInstallFlags = installFlags;
        this.mDevelopmentInstallFlags = developmentInstallFlags;
        this.mInstallSource = (InstallSource) Preconditions.checkNotNull(installSource);
        this.mVolumeUuid = volumeUuid;
        this.mPackageAbiOverride = packageAbiOverride;
        this.mPermissionStates = new ArrayMap();
        this.mAllowlistedRestrictedPermissions = null;
        this.mAutoRevokePermissionsMode = 3;
        this.mSigningDetails = SigningDetails.UNKNOWN;
        this.mInstallReason = 0;
        this.mInstallScenario = 0;
        this.mForceQueryableOverride = false;
        this.mDataLoaderType = 0;
        this.mRequiredInstalledVersionCode = -1;
        this.mPackageSource = packageSource;
        this.mPackageLite = packageLite;
        this.mIsInherit = false;
        this.mSessionId = -1;
        this.mRequireUserAction = 0;
        this.mApplicationEnabledSettingPersistent = false;
        this.mPreVerifiedDomains = null;
        this.mHasAppMetadataFile = false;
        this.mDexoptCompilerFilter = null;
        this.mDependencyInstallerEnabled = false;
        this.mMissingSharedLibraryCount = 0;
    }

    InstallingSession(int sessionId, File stagedDir, IPackageInstallObserver2 observer, PackageInstaller.SessionParams sessionParams, InstallSource installSource, UserHandle user, SigningDetails signingDetails, int installerUid, PackageLite packageLite, DomainSet preVerifiedDomains, PackageManagerService pm, boolean hasAppMetadatafile, boolean dependencyInstallerEnabled, int missingSharedLibraryCount) {
        this.mExt = (IExtInstallingSession) ExtImplFactory.getImpl(IExtInstallingSession.class, new Object[]{this});
        this.mPm = pm;
        this.mUser = user;
        this.mOriginInfo = OriginInfo.fromStagedFile(stagedDir);
        this.mMoveInfo = null;
        this.mInstallReason = fixUpInstallReason(installSource.mInstallerPackageName, installerUid, sessionParams.installReason);
        this.mInstallScenario = sessionParams.installScenario;
        this.mObserver = observer;
        this.mInstallFlags = sessionParams.installFlags;
        this.mDevelopmentInstallFlags = sessionParams.developmentInstallFlags;
        this.mInstallSource = installSource;
        this.mVolumeUuid = sessionParams.volumeUuid;
        this.mPackageAbiOverride = sessionParams.abiOverride;
        this.mPermissionStates = sessionParams.getPermissionStates();
        this.mAllowlistedRestrictedPermissions = sessionParams.whitelistedRestrictedPermissions;
        this.mAutoRevokePermissionsMode = sessionParams.autoRevokePermissionsMode;
        this.mSigningDetails = signingDetails;
        this.mForceQueryableOverride = sessionParams.forceQueryableOverride;
        boolean r8 = false;
        if (sessionParams.dataLoaderParams == null) goto L5;
        int r7 = sessionParams.dataLoaderParams.getType();
    L6:
        this.mDataLoaderType = r7;
        this.mRequiredInstalledVersionCode = sessionParams.requiredInstalledVersionCode;
        this.mPackageSource = sessionParams.packageSource;
        this.mPackageLite = packageLite;
        if (sessionParams.mode != 2) goto L9;
        r8 = true;
    L9:
        this.mIsInherit = r8;
        this.mSessionId = sessionId;
        this.mRequireUserAction = sessionParams.requireUserAction;
        this.mApplicationEnabledSettingPersistent = sessionParams.applicationEnabledSettingPersistent;
        this.mPreVerifiedDomains = preVerifiedDomains;
        this.mHasAppMetadataFile = hasAppMetadatafile;
        this.mDexoptCompilerFilter = sessionParams.dexoptCompilerFilter;
        this.mDependencyInstallerEnabled = dependencyInstallerEnabled;
        this.mMissingSharedLibraryCount = missingSharedLibraryCount;
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public String toString() {
        return "InstallingSession{" + Integer.toHexString(System.identityHashCode(this)) + " file=" + this.mOriginInfo.mFile + "}";
    }

    private int overrideInstallLocation(String packageName, int recommendedInstallLocation, int installLocation) {
        if (this.mOriginInfo.mStaged == true) goto L5;
    L9:
        if (recommendedInstallLocation < 0) goto L11;
        Computer snapshot = this.mPm.snapshotComputer();
        PackageStateInternal installedPkgState = snapshot.getPackageStateInternal(packageName);
        if (installedPkgState != null) goto L15;
        AndroidPackage installedPkg = null;
    L16:
        if (installedPkg == null) goto L19;
        recommendedInstallLocation = InstallLocationUtils.installLocationPolicy(installLocation, recommendedInstallLocation, this.mInstallFlags, installedPkgState.isSystem(), installedPkg.isExternalStorage());
    L19:
        if ((this.mInstallFlags & 16) == 0) goto L21;
        boolean onInt = true;
    L22:
        if (onInt == false) goto L24;
    L27:
        return 1;
    L24:
        if (recommendedInstallLocation != 2) goto L26;
        this.mInstallFlags &= -17;
        goto L27
    L26:
        this.mInstallFlags |= 16;
        goto L27
    L21:
        onInt = false;
        goto L22
    L15:
        installedPkg = installedPkgState.getAndroidPackage();
        goto L16
    L11:
        return InstallLocationUtils.getInstallationErrorCode(recommendedInstallLocation);
    L5:
        if (this.mOriginInfo.mFile == null) goto L8;
        this.mInstallFlags |= 16;
        goto L9
    L8:
        throw new IllegalStateException("Invalid stage location");
    }

    private void handleStartCopy(InstallRequest request) {
        if ((this.mInstallFlags & 131072) == 0) goto L7;
        this.mRet = 1;
        return;
    L7:
        if (this.mRet != 0) goto L13;
        if (getExt().checkAdbInstall() == false) goto L13;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "InstallParams: show adb install dialog");
        return;
    L13:
        if (getExt().forbidInstall(this.mPackageLite, request) == false) goto L15;
        return;
    L15:
        PackageInfoLite pkgLite = PackageManagerServiceUtils.getMinimalPackageInfo(this.mPm.mContext, this.mPackageLite, this.mOriginInfo.mResolvedPath, this.mInstallFlags, this.mPackageAbiOverride);
        boolean ephemeral = false;
        if ((this.mInstallFlags & 2097152) == 0) goto L18;
        boolean isStaged = true;
    L19:
        if (isStaged == false) goto L25;
        Pair<Integer, String> ret = this.mPm.verifyReplacingVersionCode(pkgLite, this.mRequiredInstalledVersionCode, this.mInstallFlags);
        this.mRet = ((Integer) ret.first).intValue();
        if (this.mRet == 1) goto L25;
        request.setError(this.mRet, "Failed to verify version code");
        return;
    L25:
        if ((this.mInstallFlags & 2048) == 0) goto L28;
        ephemeral = true;
    L28:
        if (PackageManagerService.DEBUG_INSTANT == false) goto L32;
        if (ephemeral == false) goto L32;
        Slog.v(PackageManagerServiceMonitorEx.TAG, "pkgLite for install: " + pkgLite);
    L32:
        if (this.mOriginInfo.mStaged == false) goto L34;
    L36:
        this.mRet = overrideInstallLocation(pkgLite.packageName, pkgLite.recommendedInstallLocation, pkgLite.installLocation);
        if (this.mRet == 1) goto L40;
        request.setError(this.mRet, "Failed to override installation location");
        return;
    L40:
        return;
    L34:
        if (pkgLite.recommendedInstallLocation != (-1)) goto L36;
        pkgLite.recommendedInstallLocation = this.mPm.freeCacheForInstallation(pkgLite.recommendedInstallLocation, this.mPackageLite, this.mOriginInfo.mResolvedPath, this.mPackageAbiOverride, this.mInstallFlags);
        goto L36
    L18:
        isStaged = false;
        goto L19
    }

    private void handleReturnCode(InstallRequest installRequest) {
        if (getExt().needHandleReturnCode() == true) goto L6;
        getExt().reset();
        return;
    L6:
        processPendingInstall(installRequest);
    }

    private void processPendingInstall(final InstallRequest installRequest) {
        if (this.mRet != 1) goto L6;
        this.mRet = copyApk(installRequest);
    L6:
        if (this.mRet != 1) goto L8;
        F2fsUtils.releaseCompressedBlocks(this.mPm.mContext.getContentResolver(), new File(installRequest.getCodePath()));
    L8:
        installRequest.setReturnCode(this.mRet);
        if (this.mParentInstallingSession == null) goto L11;
        this.mParentInstallingSession.tryProcessInstallRequest(installRequest);
        return;
    L11:
        this.mPm.mHandler.post(new InstallingSession$$ExternalSyntheticLambda3(this, installRequest));
    }

    private /* synthetic */ void lambda$processPendingInstall$0(InstallRequest installRequest) {
        boolean r1 = true;
        if (this.mRet == 1) goto L6;
        r1 = false;
    L6:
        processInstallRequests(r1, Collections.singletonList(installRequest));
    }

    private int copyApk(InstallRequest request) {
        if (this.mMoveInfo != null) goto L7;
        return copyApkForFileInstall(request);
    L7:
        return copyApkForMoveInstall(request);
    }

    private int copyApkForFileInstall(InstallRequest request) {
        Trace.traceBegin(262144, "copyApk");
    L8:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    L4:
        if (this.mOriginInfo.mStaged == false) goto L50;
        request.setCodeFile(this.mOriginInfo.mFile);     // Catch: Throwable -> L8
        Trace.traceEnd(262144);
        return 1;
    L50:
    L41:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to create copy file: " + e);     // Catch: Throwable -> L8
        request.setError(-4, "Failed to create copy file");     // Catch: Throwable -> L8
        Trace.traceEnd(262144);
        return -4;
    L11:
        if ((this.mInstallFlags & 2048) == 0) goto L13;
        boolean isEphemeral = true;
    L14:
        request.setCodeFile(this.mPm.mInstallerService.allocateStageDirLegacy(this.mVolumeUuid, isEphemeral));     // Catch: Throwable -> L8 IOException -> L41
        int ret = PackageManagerServiceUtils.copyPackage(this.mOriginInfo.mFile.getAbsolutePath(), request.getCodeFile());     // Catch: Throwable -> L8
        if (ret == 1) goto L21;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to copy package");     // Catch: Throwable -> L8
        request.setError(ret, "Failed to copy package");     // Catch: Throwable -> L8
        Trace.traceEnd(262144);
        return ret;
    L21:
        boolean isIncremental = IncrementalManager.isIncrementalPath(request.getCodeFile().getAbsolutePath());     // Catch: Throwable -> L8
        File libraryRoot = new File(request.getCodeFile(), "lib");     // Catch: Throwable -> L8
        NativeLibraryHelper.Handle handle = null;
        handle = NativeLibraryHelper.Handle.create(request.getCodeFile());     // Catch: Throwable -> L27 IOException -> L29
        ret = NativeLibraryHelper.copyNativeBinariesWithOverride(handle, libraryRoot, request.getAbiOverride(), isIncremental);     // Catch: Throwable -> L27 IOException -> L29
        if (ret == 1) goto L31;
        request.setError(ret, "Failed to copy native libraries");     // Catch: Throwable -> L27 IOException -> L29
    L31:
        IoUtils.closeQuietly(handle);     // Catch: Throwable -> L8
    L37:
        Trace.traceEnd(262144);
        return ret;
    L27:
        th = move-exception;
        IoUtils.closeQuietly(handle);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L29:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Copying native libraries failed", e);     // Catch: Throwable -> L27
        request.setError(PackageManagerException.ofInternalError("Copying native libraries failed", -1));     // Catch: Throwable -> L27
        IoUtils.closeQuietly(handle);     // Catch: Throwable -> L8
        goto L37
    L13:
        isEphemeral = false;
        goto L14
    }

    private int copyApkForMoveInstall(InstallRequest request) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: Installer.InstallerException -> L8
        this.mPm.mInstaller.moveCompleteApp(this.mMoveInfo.mFromUuid, this.mMoveInfo.mToUuid, this.mMoveInfo.mPackageName, this.mMoveInfo.mAppId, this.mMoveInfo.mSeInfo, this.mMoveInfo.mTargetSdkVersion, this.mMoveInfo.mFromCodePath);     // Catch: Throwable -> L12
        if (installLock == null) goto L10;
        installLock.close();     // Catch: Installer.InstallerException -> L8
    L10:
        String toPathName = new File(this.mMoveInfo.mFromCodePath).getName();
        request.setCodeFile(new File(Environment.getDataAppDirectory(this.mMoveInfo.mToUuid), toPathName));
        return 1;
    L12:
        th = move-exception;
        if (installLock == null) goto L28;
        installLock.close();     // Catch: Throwable -> L17
    L29:
        throw th;     // Catch: Installer.InstallerException -> L8
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Installer.InstallerException -> L8
        throw th;     // Catch: Installer.InstallerException -> L8
    L28:
        throw th;     // Catch: Installer.InstallerException -> L8
    L8:
        e = move-exception;
        request.setError(PackageManagerException.ofInternalError("Failed to move app", -2));
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to move app", e);
        return -110;
    }

    private int fixUpInstallReason(String installerPackageName, int installerUid, int installReason) {
        if (this.mPm.snapshotComputer().checkUidPermission("android.permission.INSTALL_PACKAGES", installerUid) != 0) goto L5;
        return installReason;
    L5:
        String ownerPackage = this.mPm.mProtectedPackages.getDeviceOwnerOrProfileOwnerPackage(UserHandle.getUserId(installerUid));
        if (ownerPackage != null) goto L8;
    L10:
        if (installReason != 1) goto L13;
        return 0;
    L13:
        return installReason;
    L8:
        if (ownerPackage.equals(installerPackageName) == false) goto L10;
        return 1;
    }

    public void installStage() {
        setTraceMethod("installStage").setTraceCookie(System.identityHashCode(this));
        Trace.asyncTraceBegin(262144, "installStage", System.identityHashCode(this));
        Trace.asyncTraceBegin(262144, "queueInstall", System.identityHashCode(this));
        this.mPm.mHandler.post(new InstallingSession$$ExternalSyntheticLambda2(this));
    }

    public void installStage(List<InstallingSession> children) throws PackageManagerException {
        final MultiPackageInstallingSession installingSession = new MultiPackageInstallingSession(this, getUser(), children, this.mPm);
        setTraceMethod("installStageMultiPackage").setTraceCookie(System.identityHashCode(installingSession));
        Trace.asyncTraceBegin(262144, "installStageMultiPackage", System.identityHashCode(installingSession));
        Trace.asyncTraceBegin(262144, "queueInstall", System.identityHashCode(installingSession));
        this.mPm.mHandler.post(new InstallingSession$$ExternalSyntheticLambda4(installingSession));
    }

    public void movePackage() {
        setTraceMethod("movePackage").setTraceCookie(System.identityHashCode(this));
        Trace.asyncTraceBegin(262144, "movePackage", System.identityHashCode(this));
        Trace.asyncTraceBegin(262144, "queueInstall", System.identityHashCode(this));
        this.mPm.mHandler.post(new InstallingSession$$ExternalSyntheticLambda2(this));
    }

    public UserHandle getUser() {
        return this.mUser;
    }

    private void start() {
        Trace.asyncTraceEnd(262144, "queueInstall", System.identityHashCode(this));
        Trace.traceBegin(262144, "startInstall");
        InstallRequest installRequest = new InstallRequest(this);
        handleStartCopy(installRequest);
        handleReturnCode(installRequest);
        Trace.traceEnd(262144);
    }

    private InstallingSession setTraceMethod(String traceMethod) {
        this.mTraceMethod = traceMethod;
        return this;
    }

    private void setTraceCookie(int traceCookie) {
        this.mTraceCookie = traceCookie;
    }

    private void processInstallRequests(boolean success, List<InstallRequest> installRequests) {
        final List<InstallRequest> apexInstallRequests = new ArrayList();
        List<InstallRequest> apkInstallRequests = new ArrayList();
        Iterator<InstallRequest> r2 = installRequests.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        InstallRequest request = r2.next();
        if ((request.getInstallFlags() & 131072) != 0) goto L7;
        apkInstallRequests.add(request);
        goto L4
    L7:
        apexInstallRequests.add(request);
        goto L4
    L11:
        if (apexInstallRequests.isEmpty() == true) goto L18;
        if (apkInstallRequests.isEmpty() == true) goto L18;
        throw new IllegalStateException("Attempted to do a multi package install of both APEXes and APKs");
    L18:
        if (apexInstallRequests.isEmpty() == true) goto L23;
        if (success == false) goto L21;
        Thread t = new Thread(new InstallingSession$$ExternalSyntheticLambda1(this, apexInstallRequests), "installApexPackages");
        t.start();
        return;
    L21:
        InstallRequest request2 = apexInstallRequests.get(0);
        this.mPm.notifyInstallObserver(request2);
        return;
    L23:
        processApkInstallRequests(success, installRequests);
    }

    private /* synthetic */ void lambda$processInstallRequests$1(List apexInstallRequests) {
        installApexPackagesTraced(apexInstallRequests);
    }

    private void processApkInstallRequests(boolean success, List<InstallRequest> installRequests) {
        if (success == true) goto L15;
        Iterator<InstallRequest> r0 = installRequests.iterator();
    L5:
        if (r0.hasNext() == false) goto L10;
        InstallRequest request = r0.next();
        if (request.getReturnCode() == 1) goto L5;
        cleanUpForFailedInstall(request);
        goto L5
    L10:
        Iterator<InstallRequest> r1 = installRequests.iterator();
    L12:
        if (r1.hasNext() == false) goto L23;
        InstallRequest request2 = r1.next();
        this.mPm.restoreAndPostInstall(request2);
        goto L12
    L23:
        return;
    L15:
        this.mPm.installPackagesTraced(installRequests, this.mMoveInfo);
    }

    private void cleanUpForFailedInstall(InstallRequest request) {
        if (request.isInstallMove() == false) goto L5;
        this.mPm.cleanUpForMoveInstall(request.getMoveToUuid(), request.getMovePackageName(), request.getMoveFromCodePath());
        return;
    L5:
        this.mPm.removeCodePath(request.getCodeFile());
    }

    private void installApexPackagesTraced(List<InstallRequest> requests) {
        Trace.traceBegin(262144, "installApexPackages");     // Catch: Throwable -> L6
        installApexPackages(requests);     // Catch: Throwable -> L6
        Trace.traceEnd(262144);
        return;
    L6:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    private void installApexPackages(final List<InstallRequest> requests) {
        if (requests.isEmpty() == false) goto L6;
        return;
    L6:
        if (requests.size() != 1) goto L38;
        InstallRequest request = requests.get(0);
        if ((request.getDevelopmentInstallFlags() & 1) == 0) goto L10;
        boolean force = true;
    L43:
        File dir = request.getOriginInfo().mResolvedFile;     // Catch: PackageManagerException -> L20
        File[] apexes = dir.listFiles();     // Catch: PackageManagerException -> L20
        if (apexes == null) goto L34;
        if (apexes.length != 1) goto L32;
        PackageParser2 packageParser = this.mPm.mInjector.getScanningPackageParser();     // Catch: PackageManagerException -> L20
        ApexInfo apexInfo = this.mPm.mApexManager.installPackage(apexes[0], force);     // Catch: Throwable -> L23
        request.setApexInfo(apexInfo);     // Catch: Throwable -> L23
        request.setApexModuleName(apexInfo.moduleName);     // Catch: Throwable -> L23
        this.mPm.mHandler.post(new InstallingSession$$ExternalSyntheticLambda0(this, requests));     // Catch: Throwable -> L23
        if (packageParser == null) goto L22;
        packageParser.close();     // Catch: PackageManagerException -> L20
        return;
    L22:
        return;
    L23:
        th = move-exception;
        if (packageParser != null) goto L39;
    L30:
        throw th;     // Catch: PackageManagerException -> L20
    L39:
        packageParser.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: PackageManagerException -> L20
        goto L30
    L32:
        throw PackageManagerException.ofInternalError("Expected exactly one .apex file under " + dir.getAbsolutePath() + " got: " + apexes.length, -37);     // Catch: PackageManagerException -> L20
    L34:
        throw PackageManagerException.ofInternalError(dir.getAbsolutePath() + " is not a directory", -36);     // Catch: PackageManagerException -> L20
    L20:
        e = move-exception;
        request.setError("APEX installation failed", e);
        PackageManagerService.invalidatePackageInfoCache();
        this.mPm.notifyInstallObserver(request);
        return;
    L10:
        force = false;
        goto L43
    L38:
        throw new IllegalStateException("Only a non-staged install of a single APEX is supported");
    }

    private /* synthetic */ void lambda$installApexPackages$2(List requests) {
        processApkInstallRequests(true, requests);
    }

    public IExtInstallingSession getExt() {
        return this.mExt;
    }
}
