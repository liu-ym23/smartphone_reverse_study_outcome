package com.android.server.pm;

import android.apex.ApexInfo;
import android.app.AppOpsManager;
import android.app.ApplicationPackageManager;
import android.app.BroadcastOptions;
import android.app.SysMonitorFwBridge;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.backup.IBackupManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInfoLite;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.content.pm.VerifierInfo;
import android.content.pm.parsing.ApkLiteParseUtils;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SELinux;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.incremental.IncrementalManager;
import android.os.incremental.IncrementalStorage;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.pico.utils.ExtImplFactory;
import android.system.Os;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.BoostFramework;
import android.util.EventLog;
import android.util.ExceptionUtils;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Utils;
import com.android.internal.content.F2fsUtils;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.PackageParserException;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.parsing.pkg.AndroidPackageLegacyUtils;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.component.ComponentMutateUtils;
import com.android.internal.pm.pkg.component.ParsedActivity;
import com.android.internal.pm.pkg.component.ParsedInstrumentation;
import com.android.internal.pm.pkg.component.ParsedIntentInfo;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedPermissionGroup;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.server.EventLogTags;
import com.android.server.SystemConfig;
import com.android.server.am.IProcessIntercept;
import com.android.server.audio.ZDtsSceneManager$$ExternalSyntheticLambda7;
import com.android.server.criticalevents.CriticalEventLog;
import com.android.server.notification.NotificationManagerServiceSmtEx;
import com.android.server.pm.dex.DexManager;
import com.android.server.pm.parsing.PackageCacher;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.permission.Permission;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUnserialized;
import com.android.server.pm.pkg.SharedLibraryWrapper;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.rollback.RollbackManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.WatchedArrayMap;
import com.android.server.utils.WatchedLongSparseArray;
import com.obric.utils.ObricImplFactory;
import dalvik.system.VMRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
final class InstallPackageHelper {
    private static final String INSTALLER_WAKE_LOCK_TAG = "installer:packages";
    private static final String PROPERTY_NO_RIL = "ro.radio.noril";
    private static final String PROPERTY_QSPA_Enabled = "ro.boot.vendor.qspa";
    private static final long WAKELOCK_TIMEOUT_MS = 660000;
    private final ApexManager mApexManager;
    private final AppDataHelper mAppDataHelper;
    private final BroadcastHelper mBroadcastHelper;
    private final Context mContext;
    final DeletePackageHelper mDeletePackageHelper;
    private final DexManager mDexManager;
    private final IExtInstallPackageHelper mExt;
    private final IncrementalManager mIncrementalManager;
    private final PackageManagerServiceInjector mInjector;
    private PowerManager.WakeLock mInstallingWakeLock;
    private final Object mInternalLock;
    private IObricInstallPackageHelper mObricExt;
    private final PackageAbiHelper mPackageAbiHelper;
    private final HashMap<String, String> mPackagesToBeDisabled;
    final PackageManagerService mPm;
    private final RemovePackageHelper mRemovePackageHelper;
    private final SharedLibrariesImpl mSharedLibraries;
    private final UpdateOwnershipHelper mUpdateOwnershipHelper;

    private static final class CeDataDirState {
        final File ceDir;
        final boolean ceDirExists;
        final boolean ceStoragePrepared;
        final boolean ceStorageUnlocked;

        CeDataDirState(boolean ceStorageUnlocked, boolean ceStoragePrepared, boolean ceDirExists, File ceDir) {
            this.ceStorageUnlocked = ceStorageUnlocked;
            this.ceStoragePrepared = ceStoragePrepared;
            this.ceDirExists = ceDirExists;
            this.ceDir = ceDir;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0mR6hZ7RAv-HW6b5LelB2kIPkw4, reason: not valid java name */
    public static /* synthetic */ void m6665$r8$lambda$0mR6hZ7RAvHW6b5LelB2kIPkw4(InstallPackageHelper r0, String r1, int r2, IntentSender r3) {
        r0.lambda$installExistingPackageAsUser$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$2mhA691Pd83-AXeC_cKJ3qReGOo, reason: not valid java name */
    public static /* synthetic */ void m6666$r8$lambda$2mhA691Pd83AXeC_cKJ3qReGOo(InstallPackageHelper r0, Runnable r1) {
        r0.lambda$prepPerformDexoptIfNeeded$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$5L4gieL_nGl58G96mjB5V2oXyg4(InstallPackageHelper r0, PackageSetting r1) {
        r0.lambda$commitReconciledScanResultLocked$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$ISyipyH6eyXNS8Ywq4v5OkHeLCM(int[] r0, PackageSetting r1, PackageSetting r2, PackageStateMutator r3) {
        lambda$restoreDisabledSystemPackageLIF$8(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Nvd3mg3KF2nCNWvp0cl-vZ7qZPk, reason: not valid java name */
    public static /* synthetic */ void m6667$r8$lambda$Nvd3mg3KF2nCNWvp0clvZ7qZPk(InstallPackageHelper r0, List r1, List r2, Map r3, MoveInfo r4, long r5) {
        r0.lambda$installPackagesTraced$3(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ CompletableFuture[] $r8$lambda$Q3GnjlzvbT0QUr93RPwbCWFRz3E(int r0) {
        return lambda$prepPerformDexoptIfNeeded$4(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$jJ7CS5F4oa02fYdRyiJoC-dzXVg, reason: not valid java name */
    public static /* synthetic */ void m6668$r8$lambda$jJ7CS5F4oa02fYdRyiJoCdzXVg(InstallPackageHelper r0, boolean r1, InstallRequest r2) {
        r0.lambda$restoreAndPostInstall$2(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$nNQKsv4Eiv6cMvCDAojZVcAljdo(InstallPackageHelper r0, PackageSetting r1, int r2) {
        return r0.lambda$executePostCommitStepsLIF$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$uhoJpaA7kkWA-GlZ2jUpoVYBb70, reason: not valid java name */
    public static /* synthetic */ int m6669$r8$lambda$uhoJpaA7kkWAGlZ2jUpoVYBb70(ArrayMap r0, ParallelPackageParser.ParseResult r1, ParallelPackageParser.ParseResult r2) {
        return lambda$scanApexPackages$9(r0, r1, r2);
    }

    InstallPackageHelper(PackageManagerService pm, AppDataHelper appDataHelper, RemovePackageHelper removePackageHelper, DeletePackageHelper deletePackageHelper, BroadcastHelper broadcastHelper) {
        this.mPackagesToBeDisabled = new HashMap();
        this.mInternalLock = new Object();
        this.mObricExt = (IObricInstallPackageHelper) ObricImplFactory.getImpl(IObricInstallPackageHelper.class, new Object[]{this});
        this.mExt = (IExtInstallPackageHelper) ExtImplFactory.getImpl(IExtInstallPackageHelper.class, new Object[]{this});
        this.mPm = pm;
        this.mInjector = pm.mInjector;
        this.mAppDataHelper = appDataHelper;
        this.mBroadcastHelper = broadcastHelper;
        this.mRemovePackageHelper = removePackageHelper;
        this.mDeletePackageHelper = deletePackageHelper;
        this.mIncrementalManager = pm.mInjector.getIncrementalManager();
        this.mApexManager = pm.mInjector.getApexManager();
        this.mDexManager = pm.mInjector.getDexManager();
        this.mContext = pm.mInjector.getContext();
        this.mPackageAbiHelper = pm.mInjector.getAbiHelper();
        this.mSharedLibraries = pm.mInjector.getSharedLibrariesImpl();
        this.mUpdateOwnershipHelper = pm.mInjector.getUpdateOwnershipHelper();
    }

    /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
    private AndroidPackage commitReconciledScanResultLocked(ReconciledPackage reconciledPkg, int[] allUsers) {
        InstallRequest request = reconciledPkg.mInstallRequest;
        ParsedPackage parsedPackage = request.getParsedPackage();
        if (parsedPackage != null) goto L5;
    L7:
        int scanFlags = request.getScanFlags();
        PackageSetting oldPkgSetting = request.getScanRequestOldPackageSetting();
        PackageSetting originalPkgSetting = request.getScanRequestOriginalPackageSetting();
        String realPkgName = request.getRealPackageName();
        if (request.getScanRequestPackageSetting() == null) goto L16;
        SharedUserSetting requestSharedUserSetting = this.mPm.mSettings.getSharedUserSettingLPr(request.getScanRequestPackageSetting());
        SharedUserSetting resultSharedUserSetting = this.mPm.mSettings.getSharedUserSettingLPr(request.getScannedPackageSetting());
        if (requestSharedUserSetting == null) goto L16;
        if (requestSharedUserSetting == resultSharedUserSetting) goto L16;
        requestSharedUserSetting.removePackage(request.getScanRequestPackageSetting());
        if (this.mPm.mSettings.checkAndPruneSharedUserLPw(requestSharedUserSetting, false) == false) goto L16;
        request.setRemovedAppId(requestSharedUserSetting.mAppId);
    L16:
        if (request.isExistingSettingCopied() == false) goto L18;
        PackageSetting pkgSetting = request.getScanRequestPackageSetting();
        pkgSetting.updateFrom(request.getScannedPackageSetting());
        final PackageSetting pkgSetting2 = pkgSetting;
    L23:
        SharedUserSetting sharedUserSetting = this.mPm.mSettings.getSharedUserSettingLPr(pkgSetting2);
        if (sharedUserSetting == null) goto L33;
        sharedUserSetting.addPackage(pkgSetting2);
        if (parsedPackage.isLeavingSharedUser() == false) goto L33;
        if (SharedUidMigration.applyStrategy(2) == false) goto L33;
        if (sharedUserSetting.isSingleUser() == false) goto L33;
        this.mPm.mSettings.convertSharedUserSettingsLPw(sharedUserSetting);
    L33:
        if (request.isForceQueryableOverride() == false) goto L35;
        pkgSetting2.setForceQueryableOverride(true);
    L35:
        InstallSource installSource = request.getInstallSource();
        if ((67108864 & scanFlags) == 0) goto L38;
        boolean r12 = true;
    L39:
        boolean isApex = r12;
        if (oldPkgSetting == null) goto L42;
        boolean r13 = true;
    L43:
        boolean pkgAlreadyExists = r13;
        if (pkgAlreadyExists == false) goto L46;
        String oldUpdateOwner = oldPkgSetting.getInstallSource().mUpdateOwnerPackageName;
    L47:
        if (isApex == false) goto L49;
    L52:
        String updateOwnerFromSysconfig = null;
    L53:
        boolean isUpdateOwnershipDenylisted = this.mUpdateOwnershipHelper.isUpdateOwnershipDenylisted(parsedPackage.getPackageName());
        if (oldUpdateOwner == null) goto L56;
        boolean r15 = true;
    L57:
        boolean isUpdateOwnershipEnabled = r15;
        if (installSource == null) goto L102;
        int r18 = 33554432;
        if (PackageManagerServiceUtils.isInstalledByAdb(installSource.mInitiatingPackageName) == true) goto L64;
        PackageSetting ips = this.mPm.mSettings.getPackageLPr(installSource.mInitiatingPackageName);
        if (ips == null) goto L64;
        installSource = installSource.setInitiatingPackageSignatures(ips.getSignatures());
    L64:
        if (isApex == false) goto L66;
        InstallRequest request2 = request;
        int scanFlags2 = scanFlags;
    L101:
        pkgSetting2.setInstallSource(installSource);
    L116:
        if ((scanFlags2 & 8388608) != 0) goto L118;
    L126:
        pkgSetting2.getPkgState().setApexModuleName(request2.getApexModuleName());
        parsedPackage.setUid(pkgSetting2.getAppId());
        AndroidPackage pkg = parsedPackage.hideAsFinal();
        this.mPm.mSettings.writeUserRestrictionsLPw(pkgSetting2, oldPkgSetting);
        if (realPkgName == null) goto L130;
        this.mPm.mTransferredPackages.add(pkg.getPackageName());
    L130:
        if (reconciledPkg.mCollectedSharedLibraryInfos != null) goto L134;
        if (oldPkgSetting != null) goto L133;
    L135:
        KeySetManagerService ksms = this.mPm.mSettings.getKeySetManagerService();
        if (reconciledPkg.mRemoveAppKeySetData == false) goto L139;
        ksms.removeAppKeySetDataLPw(pkg.getPackageName());
    L139:
        if (reconciledPkg.mSharedUserSignaturesChanged == false) goto L141;
        sharedUserSetting.signaturesChanged = Boolean.TRUE;
        sharedUserSetting.signatures.mSigningDetails = reconciledPkg.mSigningDetails;
    L141:
        pkgSetting2.setSigningDetails(reconciledPkg.mSigningDetails);
        int userId = request2.getUserId();
        commitPackageSettings(pkg, pkgSetting2, oldPkgSetting, reconciledPkg);
        if (pkgSetting2.getInstantApp(userId) == false) goto L145;
        this.mPm.mInstantAppRegistry.addInstantApp(userId, pkgSetting2.getAppId());
    L145:
        if (IncrementalManager.isIncrementalPath(pkgSetting2.getPathString()) == true) goto L148;
        pkgSetting2.setLoadingProgress(1.0f);
    L148:
        if (UpdateOwnershipHelper.hasValidOwnershipDenyList(pkgSetting2) == false) goto L150;
        this.mPm.mHandler.post(new InstallPackageHelper$$ExternalSyntheticLambda6(this, pkgSetting2));
    L150:
        return pkg;
    L133:
        if (oldPkgSetting.getSharedLibraryDependencies().isEmpty() == true) goto L135;
    L134:
        this.mSharedLibraries.executeSharedLibrariesUpdate(pkg, pkgSetting2, null, null, reconciledPkg.mCollectedSharedLibraryInfos, allUsers);
        goto L135
    L118:
        if ((scanFlags2 & r18) == 0) goto L120;
        boolean isFactory = true;
    L121:
        PackageStateUnserialized r5 = pkgSetting2.getPkgState();
        if (isFactory == true) goto L124;
        boolean r14 = true;
    L125:
        r5.setApkInUpdatedApex(r14);
        goto L126
    L124:
        r14 = false;
        goto L125
    L120:
        isFactory = false;
        goto L121
    L66:
        if (installSource.mInstallerPackageUid == (-1)) goto L68;
        int userId2 = UserHandle.getUserId(installSource.mInstallerPackageUid);
    L70:
        if (pkgAlreadyExists == false) goto L78;
        if (userId2 < 0) goto L75;
        request2 = request;
        if (oldPkgSetting.getInstalled(userId2) == true) goto L77;
    L79:
        boolean isUpdate = false;
    L81:
        if ((request2.getInstallFlags() & 33554432) == 0) goto L83;
        boolean isRequestUpdateOwnership = true;
    L84:
        boolean isUpdate2 = isUpdate;
        boolean isSameUpdateOwner = TextUtils.equals(oldUpdateOwner, installSource.mInstallerPackageName);
        scanFlags2 = scanFlags;
        boolean isInstallerUpdateOwnerDenylistProvider = this.mUpdateOwnershipHelper.isUpdateOwnershipDenyListProvider(installSource.mUpdateOwnerPackageName);
        if (isUpdate2 == true) goto L97;
        if (isRequestUpdateOwnership == false) goto L95;
        if (isUpdateOwnershipDenylisted == true) goto L95;
        if (isInstallerUpdateOwnerDenylistProvider == false) goto L90;
        String r6 = null;
    L96:
        installSource = installSource.setUpdateOwnerPackageName(r6);
        goto L101
    L90:
        if (isUpdateOwnershipEnabled == true) goto L92;
        if (pkgAlreadyExists == false) goto L92;
    L94:
        installSource = installSource.setUpdateOwnerPackageName(null);
    L92:
        if (isUpdateOwnershipEnabled == false) goto L101;
        if (isSameUpdateOwner == true) goto L101;
    L95:
        r6 = null;
        goto L96
    L97:
        if (isSameUpdateOwner == false) goto L99;
        if (isUpdateOwnershipEnabled == true) goto L101;
    L99:
        installSource = installSource.setUpdateOwnerPackageName(null);
        goto L101
    L83:
        isRequestUpdateOwnership = false;
    L77:
        isUpdate = true;
        goto L81
    L75:
        request2 = request;
        if (oldPkgSetting.getNotInstalledUserIds().length > UserManager.isHeadlessSystemUserMode()) goto L79;
    L78:
        request2 = request;
        goto L79
    L68:
        userId2 = request.getUserId();
        goto L70
    L102:
        request2 = request;
        scanFlags2 = scanFlags;
        r18 = 33554432;
        if (pkgSetting2.isSystem() == false) goto L116;
        if (isUpdateOwnershipEnabled == true) goto L106;
    L108:
        boolean isSameUpdateOwner2 = false;
    L110:
        if (pkgAlreadyExists == false) goto L114;
        if (isSameUpdateOwner2 == true) goto L114;
        pkgSetting2.setUpdateOwnerPackage(null);
    L114:
        pkgSetting2.setUpdateOwnerPackage(updateOwnerFromSysconfig);
        goto L116
    L106:
        if (TextUtils.equals(oldUpdateOwner, updateOwnerFromSysconfig) == false) goto L108;
        isSameUpdateOwner2 = true;
        goto L110
    L56:
        r15 = false;
        goto L57
    L49:
        if (pkgSetting2.isSystem() == false) goto L52;
        updateOwnerFromSysconfig = this.mPm.mInjector.getSystemConfig().getSystemAppUpdateOwnerPackageName(parsedPackage.getPackageName());
        goto L53
    L46:
        oldUpdateOwner = null;
        goto L47
    L42:
        r13 = false;
        goto L43
    L38:
        r12 = false;
        goto L39
    L18:
        PackageSetting pkgSetting3 = request.getScannedPackageSetting();
        if (originalPkgSetting == null) goto L21;
        this.mPm.mSettings.addRenamedPackageLPw(AndroidPackageUtils.getRealPackageOrNull(parsedPackage, pkgSetting3.isSystem()), originalPkgSetting.getPackageName());
        this.mPm.mTransferredPackages.add(originalPkgSetting.getPackageName());
    L22:
        pkgSetting2 = pkgSetting3;
        goto L23
    L21:
        this.mPm.mSettings.removeRenamedPackageLPw(parsedPackage.getPackageName());
        goto L22
    L5:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(parsedPackage.getPackageName()) == false) goto L7;
        parsedPackage.setVersionCode(this.mPm.getSdkVersion()).setVersionCodeMajor(0);
        goto L7
    }

    private /* synthetic */ void lambda$commitReconciledScanResultLocked$0(PackageSetting pkgSetting) {
        handleUpdateOwnerDenyList(pkgSetting);
    }

    private void handleUpdateOwnerDenyList(PackageSetting pkgSetting) {
        ArraySet<String> listItems = this.mUpdateOwnershipHelper.readUpdateOwnerDenyList(pkgSetting);
        if (listItems != null) goto L5;
        return;
    L5:
        if (listItems.isEmpty() == true) goto L31;
        this.mUpdateOwnershipHelper.addToUpdateOwnerDenyList(pkgSetting.getPackageName(), listItems);
        SystemConfig config = SystemConfig.getInstance();
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Iterator<String> r3 = listItems.iterator();     // Catch: Throwable -> L16
    L10:
        if (r3.hasNext() == false) goto L19;
        String unownedPackage = r3.next();     // Catch: Throwable -> L16
        PackageSetting unownedSetting = this.mPm.mSettings.getPackageLPr(unownedPackage);     // Catch: Throwable -> L16
        if (unownedSetting == null) goto L10;
        if (config.getSystemAppUpdateOwnerPackageName(unownedPackage) != null) goto L10;
        unownedSetting.setUpdateOwnerPackage(null);     // Catch: Throwable -> L16
        goto L10
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void commitPackageSettings(AndroidPackage pkg, PackageSetting pkgSetting, PackageSetting oldPkgSetting, ReconciledPackage reconciledPkg) {
        AndroidPackage r3 = pkg;
        String pkgName = r3.getPackageName();
        InstallRequest request = reconciledPkg.mInstallRequest;
        AndroidPackage oldPkg = request.getScanRequestOldPackage();
        int scanFlags = request.getScanFlags();
        if ((request.getParseFlags() & Integer.MIN_VALUE) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean chatty = r0;
        if (this.mPm.mCustomResolverComponentName != null) goto L9;
    L11:
        if (oldPkgSetting == null) goto L16;
        if (oldPkgSetting.getLastUpdateTime() >= pkgSetting.getLastUpdateTime()) goto L16;
        pkgSetting.setAppMetadataFilePath(null);
        pkgSetting.setAppMetadataSource(0);
    L16:
        if (pkgSetting.getAppMetadataFilePath() != null) goto L26;
        String dir = r3.getPath();
        if (pkgSetting.isSystem() == false) goto L20;
        dir = Environment.getDataDirectoryPath() + "/app-metadata/" + r3.getPackageName();
    L20:
        String appMetadataFilePath = dir + SliceClientPermissions.SliceAuthority.DELIMITER + PackageManagerService.APP_METADATA_FILE_NAME;
        if (request.hasAppMetadataFile() == false) goto L23;
        pkgSetting.setAppMetadataFilePath(appMetadataFilePath);
        pkgSetting.setAppMetadataSource(2);
        goto L26
    L23:
        Map<String, PackageManager.Property> properties = r3.getProperties();
        if (properties.containsKey("android.content.PROPERTY_ANDROID_SAFETY_LABEL") == false) goto L26;
        pkgSetting.setAppMetadataFilePath(appMetadataFilePath);
        pkgSetting.setAppMetadataSource(1);
    L26:
        String dir2 = r3.getPackageName();
        if (dir2.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L29;
        this.mPm.setPlatformPackage(r3, pkgSetting);
    L29:
        int r1 = 2;
        ArrayList<AndroidPackage> clientLibPkgs = this.mSharedLibraries.commitSharedLibraryChanges(r3, pkgSetting, reconciledPkg.mAllowedSharedLibraryInfos, reconciledPkg.getCombinedAvailablePackages(), scanFlags);
        request.setLibraryConsumers(clientLibPkgs);
        if ((scanFlags & 16) == 0) goto L33;
    L39:
        boolean isReplace = request.isInstallReplace();
        if (clientLibPkgs != null) goto L42;
        int r17 = 2;
    L52:
        long r13 = 262144;
        Trace.traceBegin(262144, "updateSettings");
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        this.mPm.mSettings.insertPackageSettingLPw(pkgSetting, r3);     // Catch: Throwable -> L131
        this.mPm.mPackages.put(r3.getPackageName(), r3);     // Catch: Throwable -> L131
        if ((8388608 & scanFlags) == 0) goto L62;
        this.mApexManager.registerApkInApex(r3);     // Catch: Throwable -> L59
    L59:
        th = th;
    L133:
        monitor-exit(r2);     // Catch: Throwable -> L124
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L62:
        if (this.mPm.isDeviceUpgrading() == true) goto L64;
    L65:
        if (isReplace == false) goto L70;
    L66:
        int[] r4 = this.mPm.mUserManager.getUserIds();     // Catch: Throwable -> L59
        int r6 = r4.length;     // Catch: Throwable -> L59
        int r9 = 0;
    L67:
        if (r9 >= r6) goto L69;
        int userId = r4[r9];     // Catch: Throwable -> L59
        pkgSetting.restoreComponentSettings(userId);     // Catch: Throwable -> L59
        r9 = r9 + 1;     // Catch: Throwable -> L59
        r13 = r13;
        goto L67
    L69:
        long r21 = r13;
    L72:
        if ((67108864 & scanFlags) != 0) goto L74;
        KeySetManagerService ksms = this.mPm.mSettings.getKeySetManagerService();     // Catch: Throwable -> L59
        ksms.addScannedPackageLPw(r3);     // Catch: Throwable -> L59
    L74:
        Computer snapshot = this.mPm.snapshotComputer();     // Catch: Throwable -> L131
        this.mPm.mComponentResolver.addAllComponents(r3, chatty, this.mPm.mSetupWizardPackage, snapshot);     // Catch: Throwable -> L131
        AppsFilterImpl r5 = this.mPm.mAppsFilter;     // Catch: Throwable -> L131
        if ((scanFlags & 1024) == 0) goto L77;
        boolean r10 = true;
    L78:
        r5.addPackage(snapshot, pkgSetting, isReplace, r10);     // Catch: Throwable -> L131
        this.mPm.addAllPackageProperties(r3);     // Catch: Throwable -> L131
        if (request.isArchived() == true) goto L86;
        if (oldPkgSetting == null) goto L85;
        if (oldPkgSetting.getPkg() == null) goto L85;
        this.mPm.mDomainVerificationManager.migrateState(oldPkgSetting, pkgSetting, request.getPreVerifiedDomains());     // Catch: Throwable -> L59
    L85:
        this.mPm.mDomainVerificationManager.addPackage(pkgSetting, request.getPreVerifiedDomains());     // Catch: Throwable -> L59
    L86:
        int collectionSize = ArrayUtils.size(r3.getInstrumentations());     // Catch: Throwable -> L131
        int i = 0;
        StringBuilder r = null;
    L88:
        if (i >= collectionSize) goto L136;
        ParsedInstrumentation a = (ParsedInstrumentation) r3.getInstrumentations().get(i);     // Catch: Throwable -> L100
        ComponentMutateUtils.setPackageName(a, pkg.getPackageName());     // Catch: Throwable -> L100
        boolean isReplace2 = isReplace;
        this.mPm.addInstrumentation(a.getComponentName(), a);     // Catch: Throwable -> L95
        if (chatty == false) goto L99;
        if (r != null) goto L97;
        r = new StringBuilder(256);     // Catch: Throwable -> L95
    L98:
        r.append(a.getName());     // Catch: Throwable -> L95
        goto L99
    L97:
        r.append(' ');     // Catch: Throwable -> L95
    L99:
        i = i + 1;
        r3 = pkg;
        isReplace = isReplace2;
    L95:
        th = th;
    L100:
        th = th;
        goto L133
    L136:
        List<String> protectedBroadcasts = pkg.getProtectedBroadcasts();     // Catch: Throwable -> L129
        if (protectedBroadcasts.isEmpty() == true) goto L113;
        ArraySet<String> r7 = this.mPm.mProtectedBroadcasts;     // Catch: Throwable -> L95
        monitor-enter(r7);     // Catch: Throwable -> L95
        this.mPm.mProtectedBroadcasts.addAll(protectedBroadcasts);     // Catch: Throwable -> L110
        monitor-exit(r7);     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        throw th;     // Catch: Throwable -> L95
    L113:
        PermissionManagerServiceInternal r8 = this.mPm.mPermissionManager;     // Catch: Throwable -> L129
        if ((scanFlags & 8192) == 0) goto L116;
        boolean r11 = true;
    L117:
        r8.onPackageAdded(pkgSetting, r11, oldPkg);     // Catch: Throwable -> L129
        ApplicationInfo info = snapshot.getApplicationInfo(pkgSetting.getPackageName(), 0, 0);     // Catch: Throwable -> L124
        if (info != null) goto L122;
    L126:
        monitor-exit(r2);     // Catch: Throwable -> L124
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Trace.traceEnd(r21);
        return;
    L122:
        if ((info.getSmtEx().appTypeFlag & 2) != r17) goto L126;
        this.mPm.mLegacyPermissionManager.onPackageAdded(pkgSetting);     // Catch: Throwable -> L124
        goto L126
    L116:
        r11 = false;
    L129:
        th = th;
        goto L133
    L77:
        r10 = false;
        goto L78
    L70:
        r21 = 262144;
        goto L72
    L64:
        if (pkgSetting.isSystem() == true) goto L66;
    L131:
        th = th;
    L124:
        th = th;
        goto L133
    L42:
        if (r3.getStaticSharedLibraryName() == null) goto L46;
        if (isReplace == true) goto L46;
        r17 = 2;
    L46:
        int i2 = 0;
    L48:
        if (i2 >= clientLibPkgs.size()) goto L50;
        AndroidPackage clientPkg = clientLibPkgs.get(i2);
        int r18 = r1;
        String packageName = clientPkg.getPackageName();
        this.mPm.killApplication(packageName, clientPkg.getUid(), "update lib", 12);
        i2 = i2 + 1;
        r1 = r18;
        clientLibPkgs = clientLibPkgs;
        goto L48
    L50:
        r17 = r1;
        goto L52
    L33:
        if ((scanFlags & 1024) != 0) goto L39;
        if ((scanFlags & 2048) != 0) goto L39;
        this.mPm.snapshotComputer().checkPackageFrozen(pkgName);
        goto L39
    L9:
        if (this.mPm.mCustomResolverComponentName.getPackageName().equals(r3.getPackageName()) == false) goto L11;
        this.mPm.setUpCustomResolverActivity(r3, pkgSetting);
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public Pair<Integer, IntentSender> installExistingPackageAsUser(final String packageName, final int userId, int installFlags, int installReason, List<String> allowlistedRestrictedPermissions, final IntentSender intentSender) {
        final InstallPackageHelper r1 = this;
        IntentSender intentSender2 = intentSender;
        int callingUid = Binder.getCallingUid();
        if (r1.mContext.checkCallingOrSelfPermission("android.permission.INSTALL_PACKAGES") != 0) goto L5;
    L9:
        Computer preLockSnapshot = r1.mPm.snapshotComputer();
        preLockSnapshot.enforceCrossUserPermission(callingUid, userId, true, true, "installExistingPackage for user " + userId);
        if (r1.mPm.isUserRestricted(userId, "no_install_apps") == true) goto L12;
        long callingId = Binder.clearCallingIdentity();
        if ((installFlags & 2048) == 0) goto L16;
        boolean r0 = true;
    L17:
        boolean instantApp = r0;
        if ((installFlags & 16384) == 0) goto L20;
        boolean r2 = true;
    L21:
        boolean fullApp = r2;
        boolean isPackageDeviceAdmin = r1.mPm.isPackageDeviceAdmin(packageName, userId);     // Catch: Throwable -> L153
        if (r1.mPm.mProtectedPackages != null) goto L204;
    L29:
        boolean r3 = false;
    L30:
        boolean isProtectedPackage = r3;
        PackageManagerTracedLock r9 = r1.mPm.mLock;     // Catch: Throwable -> L153
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L153
        monitor-enter(r9);     // Catch: Throwable -> L153
        Computer snapshot = r1.mPm.snapshotComputer();     // Catch: Throwable -> L169
        PackageSetting pkgSetting = r1.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L169
        if (pkgSetting == null) goto L216;
        if (pkgSetting.getPkg() == null) goto L216;
        if (instantApp == false) goto L53;
    L46:
        th = th;
    L194:
        monitor-exit(r9);     // Catch: Throwable -> L181
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L160
        throw th;     // Catch: Throwable -> L160
    L181:
        th = th;
        goto L194
    L40:
        if (pkgSetting.isSystem() == true) goto L48;
        if (pkgSetting.isUpdatedSystemApp() == true) goto L48;
        if (isPackageDeviceAdmin == true) goto L48;
        if (isProtectedPackage == false) goto L53;
    L48:
        Pair<Integer, IntentSender> r6 = Pair.create(-3, intentSender2);     // Catch: Throwable -> L46
        monitor-exit(r9);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return r6;
    L53:
        if (snapshot.canViewInstantApps(callingUid, UserHandle.getUserId(callingUid)) == true) goto L73;
        boolean installAllowed = false;
        int[] r4 = r1.mPm.mUserManager.getUserIds();     // Catch: Throwable -> L71
        boolean installed = false;
        int r5 = r4.length;     // Catch: Throwable -> L64
        int checkUserId = 0;
    L59:
        if (checkUserId >= r5) goto L66;
        int r24 = checkUserId;
        installAllowed = !pkgSetting.getInstantApp(r4[checkUserId]);     // Catch: Throwable -> L64
        if (installAllowed == true) goto L66;
        checkUserId = r24 + 1;     // Catch: Throwable -> L64
    L66:
        if (installAllowed == true) goto L205;
        Pair<Integer, IntentSender> r7 = Pair.create(-3, intentSender2);     // Catch: Throwable -> L64
        monitor-exit(r9);     // Catch: Throwable -> L64
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return r7;
    L205:
    L167:
        th = th;
        goto L194
    L75:
        if (pkgSetting.getInstalled(userId) == true) goto L88;
        pkgSetting.setInstalled(true, userId);     // Catch: Throwable -> L85
        pkgSetting.setHidden(false, userId);     // Catch: Throwable -> L85
        pkgSetting.setInstallReason(installReason, userId);     // Catch: Throwable -> L64
        pkgSetting.setUninstallReason(0, userId);     // Catch: Throwable -> L64
        pkgSetting.setFirstInstallTime(System.currentTimeMillis(), userId);     // Catch: Throwable -> L83
        r1 = this;
        r1.mPm.mInstallerService.mPackageArchiver.clearArchiveState(pkgSetting, userId);     // Catch: Throwable -> L64
        r1.mPm.mSettings.writePackageRestrictionsLPr(userId);     // Catch: Throwable -> L64
        r1.mPm.mSettings.writeKernelMappingLPr(pkgSetting);     // Catch: Throwable -> L64
        installed = true;
    L92:
        ScanPackageUtils.setInstantAppForUser(r1.mPm.mInjector, pkgSetting, userId, instantApp, fullApp);     // Catch: Throwable -> L167
        monitor-exit(r9);     // Catch: Throwable -> L167
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L153
        if (installed == false) goto L164;
        String updateOwner = pkgSetting.getInstallSource().mUpdateOwnerPackageName;     // Catch: Throwable -> L153
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) r1.mInjector.getLocalService(DevicePolicyManagerInternal.class);     // Catch: Throwable -> L153
        if (dpmi != null) goto L100;
    L102:
        boolean r8 = false;
    L103:
        boolean isFromManagedUserOrProfile = r8;
        if (preLockSnapshot.isCallerSameApp(updateOwner, callingUid) == true) goto L111;
        if (pkgSetting.isSystem() == false) goto L109;
        if (isFromManagedUserOrProfile == true) goto L111;
    L109:
        pkgSetting.setUpdateOwnerPackage(null);     // Catch: Throwable -> L27
    L111:
        if (pkgSetting.getPkg() == null) goto L131;
        PermissionManagerServiceInternal.PackageInstalledParams.Builder permissionParamsBuilder = new PermissionManagerServiceInternal.PackageInstalledParams.Builder();     // Catch: Throwable -> L27
        if ((4194304 & installFlags) == 0) goto L115;
        PermissionManagerServiceInternal.PackageInstalledParams.Builder permissionParamsBuilder2 = permissionParamsBuilder;
        permissionParamsBuilder2.setAllowlistedRestrictedPermissions(new ArrayList(pkgSetting.getPkg().getRequestedPermissions()));     // Catch: Throwable -> L27
    L116:
        r1.mPm.mPermissionManager.onPackageInstalled(pkgSetting.getPkg(), -1, permissionParamsBuilder2.build(), userId);     // Catch: Throwable -> L27
        PackageManagerTracedLock installLock = r1.mPm.mInstallLock.acquireLock();     // Catch: Throwable -> L27
        boolean isArchived = false;
        r1.mAppDataHelper.prepareAppDataPostCommitLIF(pkgSetting, 0, new int[]{userId});     // Catch: Throwable -> L122
        if (installLock == null) goto L133;
        installLock.close();     // Catch: Throwable -> L27
    L133:
        if (pkgSetting.getPkg() != null) goto L135;
        isArchived = true;
    L135:
        int r20 = 1;
        r1.mBroadcastHelper.sendPackageAddedForUser(r1.mPm.snapshotComputer(), packageName, pkgSetting, userId, isArchived, 0, r1.mPm.mAppPredictionServicePackage);     // Catch: Throwable -> L153
        PackageManagerTracedLock r10 = r1.mPm.mLock;     // Catch: Throwable -> L153
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L153
        monitor-enter(r10);     // Catch: Throwable -> L153
        r1.mPm.updateSequenceNumberLP(pkgSetting, new int[]{userId});     // Catch: Throwable -> L155
        monitor-exit(r10);     // Catch: Throwable -> L155
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L153
        intentSender2 = null;
        InstallRequest request = new InstallRequest(userId, 1, pkgSetting.getPkg(), new int[]{userId}, new InstallPackageHelper$$ExternalSyntheticLambda2(r1, packageName, userId, intentSender), pkgSetting.getAppId(), callingUid, pkgSetting.isSystem());     // Catch: Throwable -> L149
        r1.restoreAndPostInstall(request);     // Catch: Throwable -> L147
    L165:
        Binder.restoreCallingIdentity(callingId);
        return Pair.create(Integer.valueOf(r20), intentSender2);
    L147:
        th = th;
    L183:
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L149:
        th = th;
    L151:
        th = th;
        goto L183
    L155:
        th = th;
    L212:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L160
        throw th;     // Catch: Throwable -> L160
    L162:
        th = th;
        goto L212
    L122:
        th = move-exception;
        if (installLock == null) goto L225;
        installLock.close();     // Catch: Throwable -> L127
    L226:
        throw th;     // Catch: Throwable -> L27
    L127:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L225:
        throw th;     // Catch: Throwable -> L27
    L27:
        th = th;
        goto L183
    L115:
        permissionParamsBuilder2 = permissionParamsBuilder;
        goto L116
    L131:
        isArchived = false;
        goto L133
    L100:
        if (dpmi.isUserOrganizationManaged(userId) == false) goto L102;
        r8 = true;
        goto L103
    L164:
        r20 = 1;
    L83:
        th = th;
    L85:
        th = th;
        goto L194
    L88:
        if (fullApp == false) goto L92;
        if (pkgSetting.getInstantApp(userId) == false) goto L92;
        installed = true;
    L64:
        th = th;
    L71:
        th = th;
        goto L194
    L73:
        installed = false;
    L216:
        Pair<Integer, IntentSender> r11 = Pair.create(-3, intentSender2);     // Catch: Throwable -> L176
        monitor-exit(r9);     // Catch: Throwable -> L176
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Binder.restoreCallingIdentity(callingId);
        return r11;
    L176:
        th = th;
    L169:
        th = th;
    L160:
        th = th;
        goto L183
    L204:
        if (r1.mPm.mProtectedPackages.isPackageStateProtected(userId, packageName) == false) goto L29;
        r3 = true;
    L153:
        th = th;
        goto L183
    L20:
        r2 = false;
        goto L21
    L16:
        r0 = false;
        goto L17
    L12:
        return Pair.create(Integer.valueOf(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SYNCADAPTER_OR_NOTILISTENER), intentSender2);
    L5:
        if (r1.mContext.checkCallingOrSelfPermission("com.android.permission.INSTALL_EXISTING_PACKAGES") == 0) goto L9;
        throw new SecurityException("Neither user " + callingUid + " nor current process has android.permission.INSTALL_PACKAGES.");
    }

    private /* synthetic */ void lambda$installExistingPackageAsUser$1(String packageName, int userId, IntentSender onCompleteSender) {
        this.mPm.restorePermissionsAndUpdateRolesForNewUserInstall(packageName, userId);
        if (onCompleteSender == null) goto L6;
        onInstallComplete(1, this.mContext, onCompleteSender);
        return;
    }

    static void onInstallComplete(int returnCode, Context context, IntentSender target) {
        Intent fillIn = new Intent();
        fillIn.putExtra("android.content.pm.extra.STATUS", PackageManager.installStatusToPublicStatus(returnCode));
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: IntentSender.SendIntentException -> L9
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);     // Catch: IntentSender.SendIntentException -> L9
        target.sendIntent(context, 0, fillIn, null, options.toBundle(), null, null);     // Catch: IntentSender.SendIntentException -> L7
        return;
    L17:
        return;
    }

    public void restoreAndPostInstall(final InstallRequest request) {
        int userId = request.getUserId();
        PackageSetting packageSetting = null;
        boolean update = request.isUpdate();
        boolean doRestore = false;
        if (request.getPkg() != null) goto L5;
    L22:
        final boolean hasNeverBeenRestored = true;
        if (this.mPm.mNextInstallToken >= 0) goto L25;
        this.mPm.mNextInstallToken = 1;
    L25:
        PackageManagerService r4 = this.mPm;
        int token = r4.mNextInstallToken;
        r4.mNextInstallToken = token + 1;
        SparseArray<InstallRequest> r5 = this.mPm.mRunningInstalls;
        monitor-enter(r5);
        this.mPm.mRunningInstalls.put(token, request);     // Catch: Throwable -> L62
        monitor-exit(r5);     // Catch: Throwable -> L62
        if (request.getReturnCode() != 1) goto L32;
        boolean succeeded = true;
    L33:
        if (succeeded == false) goto L49;
        request.onRestoreStarted();
        if (doRestore == false) goto L37;
        request.closeFreezer();
        doRestore = performBackupManagerRestore(userId, token, request);
    L37:
        if (doRestore == true) goto L40;
        if (update == false) goto L40;
        doRestore = performRollbackManagerRestore(userId, token, request);
    L40:
        if (doRestore == false) goto L49;
        if (request.hasPostInstallRunnable() == true) goto L49;
        if (packageSetting != null) goto L45;
    L47:
        hasNeverBeenRestored = false;
    L48:
        request.setPostInstallRunnable(new InstallPackageHelper$$ExternalSyntheticLambda7(this, hasNeverBeenRestored, request));
        goto L49
    L45:
        if (packageSetting.isPendingRestore() == false) goto L47;
    L49:
        if (doRestore == false) goto L60;
        if (packageSetting == null) goto L71;
        PackageManagerTracedLock r6 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        packageSetting.setPendingRestore(false);     // Catch: Throwable -> L56
        monitor-exit(r6);     // Catch: Throwable -> L56
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L56:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L71:
        return;
    L60:
        request.closeFreezer();
        Trace.asyncTraceBegin(262144, "postInstall", token);
        Message msg = this.mPm.mHandler.obtainMessage(9, token, 0);
        this.mPm.mHandler.sendMessage(msg);
        return;
    L32:
        succeeded = false;
    L62:
        th = move-exception;
        throw th;
    L5:
        if (request.isArchived() == true) goto L22;
        if (update == true) goto L8;
        doRestore = true;
        goto L22
    L8:
        String packageName = request.getPkg().getPackageName();
        PackageManagerTracedLock r7 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        packageSetting = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L15
        if (packageSetting != null) goto L13;
    L17:
        monitor-exit(r7);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L22
    L13:
        if (packageSetting.isPendingRestore() == false) goto L17;
        doRestore = true;
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$restoreAndPostInstall$2(boolean hasNeverBeenRestored, InstallRequest request) {
        if (hasNeverBeenRestored == false) goto L4;
        int[] userIdsToRestorePermissions = request.getUpdateBroadcastUserIds();
    L5:
        int r1 = userIdsToRestorePermissions.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int restorePermissionUserId = userIdsToRestorePermissions[r2];
        this.mPm.restorePermissionsAndUpdateRolesForNewUserInstall(request.getName(), restorePermissionUserId);
        r2 = r2 + 1;
        goto L6
    L8:
        return;
    L4:
        userIdsToRestorePermissions = request.getFirstTimeBroadcastUserIds();
        goto L5
    }

    private boolean performBackupManagerRestore(int userId, int token, InstallRequest request) {
        if (request.getPkg() != null) goto L5;
        return false;
    L5:
        IBackupManager iBackupManager = this.mInjector.getIBackupManager();
        if (iBackupManager != null) goto L8;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Backup Manager not found!");
        return false;
    L8:
        if (userId != (-1)) goto L10;
        userId = 0;
    L10:
        Trace.asyncTraceBegin(262144, "restore", token);
    L15:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Exception trying to enqueue restore", e);
        return false;
    L12:
        if (iBackupManager.isUserReadyForBackup(userId) == false) goto L19;
        iBackupManager.restoreAtInstallForUser(userId, request.getPkg().getPackageName(), token);     // Catch: Exception -> L15 RemoteException -> L17
        goto L23
    L19:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "User " + userId + " is not ready. Restore at install didn't take place.");     // Catch: Exception -> L15 RemoteException -> L17
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.android.server.rollback.RollbackManagerInternal] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.android.server.pm.PackageManagerTracedLock] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [long] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.android.server.pm.PackageManagerTracedLock] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    private boolean performRollbackManagerRestore(int r18, int r19, InstallRequest r20) {
        if (r20.getPkg() != null) goto L5;
        return false;
    L5:
        String r4 = r20.getPkg().getPackageName();
        int[] r11 = this.mPm.mUserManager.getUserIds();
        ?? r7 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        PackageSetting r0 = this.mPm.mSettings.getPackageLPr(r4);     // Catch: Throwable -> L14
        if (r0 == null) goto L17;
        int r8 = r0.getAppId();     // Catch: Throwable -> L14
        long r9 = r0.getCeDataInode(r18);     // Catch: Throwable -> L12
        int[] r14 = r0.queryInstalledUsers(r11, true);     // Catch: Throwable -> L12
        r7 = r9;
        int r6 = r8;
    L45:
        monitor-exit(r7);     // Catch: Throwable -> L32
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int r15 = r20.getInstallFlags();
        if ((262144 & r15) == 0) goto L22;
    L25:
        boolean r3 = true;
    L26:
        boolean r16 = r3;
        if (r0 == null) goto L31;
        if (r16 == false) goto L31;
        ((RollbackManagerInternal) this.mInjector.getLocalService(RollbackManagerInternal.class)).snapshotAndRestoreUserData(r4, UserHandle.toUserHandles(r14), r6, r7, r0.getSeInfo(), r19);
        return true;
    L31:
        return false;
    L22:
        if ((r15 & 128) != 0) goto L25;
        r3 = false;
        goto L26
    L32:
        th = th;
        ?? r10 = r7;
    L39:
        monitor-exit(r10);     // Catch: Throwable -> L37
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L37:
        th = th;
        goto L39
    L17:
        r14 = new int[0];     // Catch: Throwable -> L12
        r7 = -1;
        r6 = -1;
    L12:
        th = th;
    L13:
        r10 = r7;
    L14:
        th = th;
        goto L13
    }

    void installPackagesTraced(final List<InstallRequest> requests, final MoveInfo moveInfo) {
        Trace.traceBegin(262144, "installPackages");
        boolean pendingForDexopt = false;
        final Map<String, Boolean> createdAppId = new ArrayMap(requests.size());
        Map<String, Settings.VersionInfo> versionInfos = new ArrayMap(requests.size());
        final long acquireTime = acquireWakeLock(requests.size());
        CriticalEventLog.getInstance().logInstallPackagesStarted();     // Catch: Throwable -> L16
        if (prepareInstallPackages(requests) == true) goto L6;
    L18:
        if (pendingForDexopt == true) goto L27;
        completeInstallProcess(requests, createdAppId, false);
        Trace.traceEnd(262144);
        doPostInstall(requests, moveInfo);
        releaseWakeLock(acquireTime, requests.size());
        return;
    L27:
        return;
    L6:
        if (scanInstallPackages(requests, createdAppId, versionInfos) == false) goto L18;
        final List<ReconciledPackage> reconciledPackages = reconcileInstallPackages(requests, versionInfos);     // Catch: Throwable -> L16
        if (reconciledPackages != null) goto L13;
        if (0 != 0) goto L26;
        completeInstallProcess(requests, createdAppId, false);
        Trace.traceEnd(262144);
        doPostInstall(requests, moveInfo);
        releaseWakeLock(acquireTime, requests.size());
        return;
    L26:
        return;
    L13:
        if (renameAndUpdatePaths(requests) == false) goto L18;
        pendingForDexopt = true;
        Runnable actionsAfterDexopt = new InstallPackageHelper$$ExternalSyntheticLambda8(this, reconciledPackages, requests, createdAppId, moveInfo, acquireTime);     // Catch: Throwable -> L16
        prepPerformDexoptIfNeeded(reconciledPackages, actionsAfterDexopt);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (pendingForDexopt == true) goto L23;
        completeInstallProcess(requests, createdAppId, false);
        Trace.traceEnd(262144);
        doPostInstall(requests, moveInfo);
        releaseWakeLock(acquireTime, requests.size());
    L23:
        throw th;
    }

    private /* synthetic */ void lambda$installPackagesTraced$3(List reconciledPackages, List requests, Map createdAppId, MoveInfo moveInfo, long acquireTime) {
        doPostDexopt(reconciledPackages, requests, createdAppId, moveInfo, acquireTime);
    }

    void doPostDexopt(List<ReconciledPackage> reconciledPackages, List<InstallRequest> requests, Map<String, Boolean> createdAppId, MoveInfo moveInfo, long acquireTime) {
        Iterator<InstallRequest> r0 = requests.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        InstallRequest request = r0.next();
        request.onWaitDexoptFinished();
        goto L4
    L6:
        boolean success = false;
        if (commitInstallPackages(reconciledPackages) == false) goto L10;
        success = true;
    L10:
        completeInstallProcess(requests, createdAppId, success);
        Trace.traceEnd(262144);
        doPostInstall(requests, moveInfo);
        releaseWakeLock(acquireTime, requests.size());
        return;
    L12:
        th = move-exception;
        completeInstallProcess(requests, createdAppId, false);
        Trace.traceEnd(262144);
        doPostInstall(requests, moveInfo);
        releaseWakeLock(acquireTime, requests.size());
        throw th;
    }

    private void doPostInstall(List<InstallRequest> requests, MoveInfo moveInfo) {
        Iterator<InstallRequest> r0 = requests.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        InstallRequest request = r0.next();
        doPostInstallCleanUp(request, moveInfo);
        goto L4
    L6:
        Iterator<InstallRequest> r1 = requests.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        InstallRequest request2 = r1.next();
        restoreAndPostInstall(request2);
        goto L8
    }

    private void doPostInstallCleanUp(InstallRequest request, MoveInfo moveInfo) {
        if (moveInfo == null) goto L9;
        if (request.getReturnCode() != 1) goto L7;
        this.mRemovePackageHelper.cleanUpForMoveInstall(moveInfo.mFromUuid, moveInfo.mPackageName, moveInfo.mFromCodePath);
        return;
    L7:
        this.mRemovePackageHelper.cleanUpForMoveInstall(moveInfo.mToUuid, moveInfo.mPackageName, moveInfo.mFromCodePath);
        return;
    L9:
        if (request.getReturnCode() == 1) goto L14;
        this.mRemovePackageHelper.removeCodePath(request.getCodeFile());
        return;
    }

    private long acquireWakeLock(int count) {
        if (this.mPm.isSystemReady() == true) goto L5;
        return -1;
    L5:
        Object r0 = this.mInternalLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mInstallingWakeLock != null) goto L17;
        PowerManager pwm = (PowerManager) this.mContext.getSystemService(PowerManager.class);     // Catch: Throwable -> L12
        if (pwm == null) goto L14;
        this.mInstallingWakeLock = pwm.newWakeLock(1, INSTALLER_WAKE_LOCK_TAG);     // Catch: Throwable -> L12
        goto L17
    L14:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unable to obtain power manager while obtaining wake lock");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return -1;
    L17:
        this.mInstallingWakeLock.acquire(((long) count) * WAKELOCK_TIMEOUT_MS);     // Catch: Throwable -> L12
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    }

    private void releaseWakeLock(long acquireTime, int count) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 >= 0) goto L7
            return
        L7:
            java.lang.Object r0 = r4.mInternalLock
            monitor-enter(r0)
            android.os.PowerManager$WakeLock r1 = r4.mInstallingWakeLock     // Catch: java.lang.Throwable -> L10 java.lang.RuntimeException -> L20
            if (r1 != 0) goto L12
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L10
            return
        L10:
            r1 = move-exception
            goto L2d
        L12:
            android.os.PowerManager$WakeLock r1 = r4.mInstallingWakeLock     // Catch: java.lang.Throwable -> L10 java.lang.RuntimeException -> L20
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L10 java.lang.RuntimeException -> L20
            if (r1 == 0) goto L22
            android.os.PowerManager$WakeLock r1 = r4.mInstallingWakeLock     // Catch: java.lang.Throwable -> L10 java.lang.RuntimeException -> L20
            r1.release()     // Catch: java.lang.Throwable -> L10 java.lang.RuntimeException -> L20
            goto L22
        L20:
            r1 = move-exception
            goto L23
        L22:
            goto L2b
        L23:
            java.lang.String r2 = "PackageManager"
            java.lang.String r3 = "Error while releasing installer lock"
            android.util.Slog.wtf(r2, r3, r1)     // Catch: java.lang.Throwable -> L10
        L2b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L10
            return
        L2d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L10
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.pm.InstallPackageHelper.releaseWakeLock(long, int):void");
    }

    private int[] getNewUsers(InstallRequest installRequest, int[] allUsers) throws PackageManagerException {
        int userId = installRequest.getUserId();
        if (userId != (-1)) goto L5;
    L11:
        IntArray newUserIds = new IntArray();
        if (userId == (-1)) goto L14;
        newUserIds.add(userId);
    L31:
        if (newUserIds.size() == 0) goto L35;
        return newUserIds.toArray();
    L35:
        throw new PackageManagerException(-38, "User " + userId + " doesn't exist or has been removed");
    L14:
        if (allUsers == null) goto L31;
        int[] installedForUsers = installRequest.getOriginUsers();
        int r6 = allUsers.length;
        int r8 = 0;
    L17:
        if (r8 >= r6) goto L31;
        int currentUserId = allUsers[r8];
        boolean installedForCurrentUser = ArrayUtils.contains(installedForUsers, currentUserId);
        if (this.mPm.isUserRestricted(currentUserId, "no_install_apps") == false) goto L21;
    L24:
        boolean restrictedByPolicy = true;
    L26:
        if (installedForCurrentUser == true) goto L28;
        if (restrictedByPolicy == false) goto L28;
    L29:
        r8 = r8 + 1;
    L28:
        newUserIds.add(currentUserId);
        goto L29
    L21:
        if (this.mPm.isUserRestricted(currentUserId, "no_debugging_features") == true) goto L24;
        restrictedByPolicy = false;
        goto L26
    L5:
        if (userId == (-2)) goto L11;
        if (ArrayUtils.contains(allUsers, userId) == true) goto L11;
        throw new PackageManagerException(-38, "User " + userId + " doesn't exist or has been removed");
    }

    private void prepPerformDexoptIfNeeded(List<ReconciledPackage> reconciledPackages, final Runnable actionsAfterDexopt) {
        List<CompletableFuture<Void>> completableFutures = new ArrayList();
        Iterator<ReconciledPackage> r0 = reconciledPackages.iterator();
    L4:
        if (r0.hasNext() == false) goto L33;
        ReconciledPackage reconciledPkg = r0.next();
        InstallRequest request = reconciledPkg.mInstallRequest;
        PackageSetting ps = request.getScannedPackageSetting();
        PackageSetting oldPkgSetting = request.getScanRequestOldPackageSetting();
        int[] allUsers = this.mPm.mUserManager.getUserIds();
        if (reconciledPkg.mCollectedSharedLibraryInfos != null) goto L10;
        if (oldPkgSetting != null) goto L9;
    L37:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: PackageManagerException -> L21
        int[] newUsers = getNewUsers(request, allUsers);     // Catch: Throwable -> L16
        logPrepPerformDexoptAppDataState("before prepareAppDataPostCommitLIF", ps, newUsers);     // Catch: Throwable -> L16
        this.mAppDataHelper.prepareAppDataPostCommitLIF(ps, 0, newUsers);     // Catch: Throwable -> L16
        logPrepPerformDexoptAppDataState("after prepareAppDataPostCommitLIF", ps, newUsers);     // Catch: Throwable -> L16
        if (request.isClearCodeCache() == false) goto L18;
        this.mAppDataHelper.clearAppDataLIF(ps.getPkg(), -1, 39);     // Catch: Throwable -> L16
    L18:
        if (installLock == null) goto L23;
        installLock.close();     // Catch: PackageManagerException -> L21
    L23:
        request.setKeepArtProfile(true);
        CompletableFuture<Void> future = DexOptHelper.performDexoptIfNeededAsync(request, this.mDexManager);
        completableFutures.add(future);
        request.onWaitDexoptStarted();
    L16:
        th = move-exception;
        if (installLock == null) goto L46;
        installLock.close();     // Catch: Throwable -> L27
    L47:
        throw th;     // Catch: PackageManagerException -> L21
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: PackageManagerException -> L21
        throw th;     // Catch: PackageManagerException -> L21
    L46:
        throw th;     // Catch: PackageManagerException -> L21
    L21:
        e = move-exception;
        request.setError(e.error, e.getMessage());
        goto L33
    L9:
        if (oldPkgSetting.getSharedLibraryDependencies().isEmpty() == true) goto L37;
    L10:
        this.mSharedLibraries.executeSharedLibrariesUpdate(request.getParsedPackage(), ps, null, null, reconciledPkg.mCollectedSharedLibraryInfos, allUsers);
    L33:
        if (completableFutures.isEmpty() == true) goto L35;
        CompletableFuture<Void> allFutures = CompletableFuture.allOf((CompletableFuture[]) completableFutures.toArray(new InstallPackageHelper$$ExternalSyntheticLambda0()));
        allFutures.thenRun(new InstallPackageHelper$$ExternalSyntheticLambda1(this, actionsAfterDexopt));
        return;
    L35:
        actionsAfterDexopt.run();
    }

    private static /* synthetic */ CompletableFuture[] lambda$prepPerformDexoptIfNeeded$4(int x$0) {
        return new CompletableFuture[x$0];
    }

    private /* synthetic */ void lambda$prepPerformDexoptIfNeeded$5(Runnable actionsAfterDexopt) {
        this.mPm.mHandler.post(actionsAfterDexopt);
    }

    private void logPrepPerformDexoptAppDataState(String stage, PackageSetting ps, int[] userIds) {
        int r0 = userIds.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = userIds[r1];
        CeDataDirState ceDataDirState = getCeDataDirState(ps, userId);
        Slog.d(PackageManagerServiceMonitorEx.TAG, "prepPerformDexoptIfNeeded: " + stage + " packageName=" + ps.getPackageName() + " userId=" + userId + " ceDataInode=" + ps.getCeDataInode(userId) + " deDataInode=" + ps.getDeDataInode(userId) + " ceStorageUnlocked=" + ceDataDirState.ceStorageUnlocked + " ceStoragePrepared=" + ceDataDirState.ceStoragePrepared + " ceDirExists=" + ceDataDirState.ceDirExists + " ceDir=" + ceDataDirState.ceDir);
        r1 = r1 + 1;
        goto L3
    }

    private boolean isCeStorageUnlockedAndPrepared(int userId) {
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        if (StorageManager.isCeStorageUnlocked(userId) == false) goto L8;
        if (smInternal == null) goto L8;
        if (smInternal.isCeStoragePrepared(userId) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private File getCeDataPackageDirectory(PackageSetting ps, int userId) {
        return Environment.getDataUserCePackageDirectory(ps.getVolumeUuid(), userId, ps.getPackageName());
    }

    private CeDataDirState getCeDataDirState(PackageSetting ps, int userId) {
        StorageManagerInternal smInternal = (StorageManagerInternal) this.mInjector.getLocalService(StorageManagerInternal.class);
        boolean ceStorageUnlocked = StorageManager.isCeStorageUnlocked(userId);
        if (smInternal != null) goto L5;
    L7:
        boolean ceStoragePrepared = false;
    L8:
        File ceDir = getCeDataPackageDirectory(ps, userId);
        return new CeDataDirState(ceStorageUnlocked, ceStoragePrepared, ceDir.exists(), ceDir);
    L5:
        if (smInternal.isCeStoragePrepared(userId) == false) goto L7;
        ceStoragePrepared = true;
        goto L8
    }

    private boolean renameAndUpdatePaths(List<InstallRequest> requests) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        Iterator<InstallRequest> r1 = requests.iterator();     // Catch: Throwable -> L15
    L4:
        boolean isApex = true;
        if (r1.hasNext() == false) goto L23;
        InstallRequest request = r1.next();     // Catch: Throwable -> L15
        ParsedPackage parsedPackage = request.getParsedPackage();     // Catch: Throwable -> L15
        if ((request.getScanFlags() & 67108864) != 0) goto L11;
        isApex = false;
    L11:
        if (isApex == true) goto L4;
        doRenameLI(request, parsedPackage);     // Catch: Throwable -> L15 PrepareFailure -> L17
        PackageSetting scannedPackageSetting = request.getScannedPackageSetting();     // Catch: Throwable -> L15
        scannedPackageSetting.setPath(new File(parsedPackage.getPath()));     // Catch: Throwable -> L15
        scannedPackageSetting.setLegacyNativeLibraryPath(parsedPackage.getNativeLibraryRootDir());     // Catch: Throwable -> L15
        goto L4
    L17:
        e = move-exception;
        request.setError(e);     // Catch: Throwable -> L15
        if (installLock == null) goto L21;
        installLock.close();
    L21:
        return false;
    L23:
        if (installLock == null) goto L25;
        installLock.close();
    L25:
        return true;
    L15:
        th = move-exception;
        if (installLock != null) goto L32;
    L31:
        throw th;
    L32:
        installLock.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);
        goto L31
    }

    private boolean prepareInstallPackages(List<InstallRequest> requests) {
        Iterator<InstallRequest> r0 = requests.iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        InstallRequest request = r0.next();
        Trace.traceBegin(262144, "preparePackage");     // Catch: Throwable -> L8 PrepareFailure -> L10
        request.onPrepareStarted();     // Catch: Throwable -> L8 PrepareFailure -> L10
        preparePackage(request);     // Catch: Throwable -> L8 PrepareFailure -> L10
        request.onPrepareFinished();
        Trace.traceEnd(262144);
        goto L4
    L10:
        prepareFailure = move-exception;
        request.setError(prepareFailure.error, prepareFailure.getMessage());     // Catch: Throwable -> L8
        request.setOriginPackage(prepareFailure.mConflictingPackage);     // Catch: Throwable -> L8
        request.setOriginPermission(prepareFailure.mConflictingPermission);     // Catch: Throwable -> L8
        request.onPrepareFinished();
        Trace.traceEnd(262144);
        return false;
    L8:
        th = move-exception;
        request.onPrepareFinished();
        Trace.traceEnd(262144);
        throw th;
    L16:
        return true;
    }

    private boolean scanInstallPackages(List<InstallRequest> requests, Map<String, Boolean> createdAppId, Map<String, Settings.VersionInfo> versionInfos) {
        Set<String> scannedPackages = new ArraySet(requests.size());
        Iterator<InstallRequest> r0 = requests.iterator();
    L3:
        boolean isApex = true;
        if (r0.hasNext() == false) goto L51;
        InstallRequest request = r0.next();
        AndroidPackage r4 = request.getParsedPackage();
        if (r4 == null) goto L7;
        request.setReturnCode(1);
        String packageName = r4.getPackageName();
        request.onScanStarted();     // Catch: PackageManagerException -> L14
        ScanResult scanResult = scanPackageTraced(request.getParsedPackage(), request.getParseFlags(), request.getScanFlags(), System.currentTimeMillis(), request.getUser(), request.getAbiOverride());     // Catch: PackageManagerException -> L14
        request.setScanResult(scanResult);     // Catch: PackageManagerException -> L14
        request.onScanFinished();     // Catch: PackageManagerException -> L14
        if (scannedPackages.add(packageName) == false) goto L12;
        if (checkNoAppStorageIsConsistent(request.getScanRequestOldPackage(), r4) == false) goto L19;
        this.mPm.getSmtEx().onPackageScanned(scanResult);     // Catch: PackageManagerException -> L14
        if ((request.getScanFlags() & 67108864) != 0) goto L25;
        isApex = false;
    L25:
        r4.isSdkLibrary();     // Catch: PackageManagerException -> L14
        if (isApex == false) goto L55;
        request.getScannedPackageSetting().setAppId(-1);     // Catch: PackageManagerException -> L30
    L52:
        versionInfos.put(packageName, this.mPm.getSettingsVersionForPackage(r4));     // Catch: PackageManagerException -> L47
        boolean isApex2 = request.isArchived();
        if (isApex2 == false) goto L3;
        SparseArray<String> responsibleInstallerTitles = PackageArchiver.getResponsibleInstallerTitles(this.mContext, this.mPm.snapshotComputer(), request.getInstallSource(), request.getUserId(), this.mPm.mUserManager.getUserIds());
        if (responsibleInstallerTitles == null) goto L44;
        if (responsibleInstallerTitles.size() == 0) goto L44;
        request.setResponsibleInstallerTitles(responsibleInstallerTitles);
    L44:
        request.setError(PackageManagerException.ofInternalError("Failed to obtain the responsible installer info", -39));
        return false;
    L47:
        e = e;
    L48:
        request.setError("Scanning Failed.", e);
        return false;
    L55:
        createdAppId.put(packageName, Boolean.valueOf(optimisticallyRegisterAppId(request)));     // Catch: PackageManagerException -> L30
    L30:
        e = e;
        goto L48
    L19:
        request.setError(-7, "Update attempted to change value of android.internal.PROPERTY_NO_APP_DATA_STORAGE");     // Catch: PackageManagerException -> L14
        return false;
    L12:
        request.setError(-5, "Duplicate package " + packageName + " in multi-package install request.");     // Catch: PackageManagerException -> L14
        return false;
    L14:
        e = e;
        goto L48
    L7:
        request.setError(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Failed to obtain package to scan");
        return false;
    L51:
        return true;
    }

    private List<ReconciledPackage> reconcileInstallPackages(List<InstallRequest> requests, Map<String, Settings.VersionInfo> versionInfos) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        PackageManagerTracedLock r2 = this.mPm.mLock;     // Catch: Throwable -> L46
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L46
        monitor-enter(r2);     // Catch: Throwable -> L46
        Trace.traceBegin(262144, "reconcilePackages");     // Catch: Throwable -> L21 ReconcileFailure -> L23
        List<InstallRequest> requests2 = requests;
        List<ReconciledPackage> r13 = ReconcilePackageUtils.reconcilePackages(requests2, Collections.unmodifiableMap(this.mPm.mPackages), versionInfos, this.mSharedLibraries, this.mPm.mSettings.getKeySetManagerService(), this.mPm.mSettings, this.mPm.mInjector.getSystemConfig());     // Catch: Throwable -> L17 ReconcileFailure -> L19
        Trace.traceEnd(262144);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (installLock == null) goto L14;
        installLock.close();
    L14:
        return r13;
    L19:
        e = move-exception;
        ReconcileFailure e = e;
    L26:
        Iterator<InstallRequest> r14 = requests2.iterator();     // Catch: Throwable -> L17
    L27:
        if (r14.hasNext() == false) goto L32;
        InstallRequest request = r14.next();     // Catch: Throwable -> L17
        request.setError("Reconciliation failed...", e);     // Catch: Throwable -> L17
        goto L27
    L32:
        Trace.traceEnd(262144);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (installLock == null) goto L68;
        installLock.close();
        return null;
    L68:
        return null;
    L17:
        th = move-exception;
        ReconcileFailure e2 = th;
    L39:
        Trace.traceEnd(262144);     // Catch: Throwable -> L15
        throw e2;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Throwable r15 = th;
    L48:
        if (installLock == null) goto L66;
        installLock.close();     // Catch: Throwable -> L51
        throw r15;
    L51:
        th = move-exception;
        r15.addSuppressed(th);
        throw r15;
    L66:
        throw r15;
    L23:
        e = move-exception;
        requests2 = requests;
        e = e;
    L21:
        th = move-exception;
        e2 = th;
    L46:
        th = move-exception;
        r15 = th;
        goto L48
    }

    private boolean commitInstallPackages(List<ReconciledPackage> reconciledPackages) {
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        Iterator<ReconciledPackage> r0 = reconciledPackages.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L13;
        ReconciledPackage reconciledPkg = r0.next();     // Catch: Throwable -> L11
        InstallRequest installRequest = reconciledPkg.mInstallRequest;     // Catch: Throwable -> L11
        String packageName = installRequest.getParsedPackage().getPackageName();     // Catch: Throwable -> L11
        this.mExt.showUpdateAppToastIfNeed(installRequest);     // Catch: Throwable -> L11
        PackageFreezer freezer = freezePackageForInstall(packageName, -1, installRequest.getInstallFlags(), "installPackageLI", 16, installRequest);     // Catch: Throwable -> L9
        installRequest.setFreezer(freezer);     // Catch: Throwable -> L9
    L9:
        th = th;
    L10:
        Throwable r2 = th;
        if (installLock == null) goto L46;
        installLock.close();     // Catch: Throwable -> L35
        throw r2;
    L35:
        th = move-exception;
        r2.addSuppressed(th);
        throw r2;
    L46:
        throw r2;
    L13:
        PackageManagerTracedLock r3 = this.mPm.mLock;     // Catch: Throwable -> L9
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L9
        monitor-enter(r3);     // Catch: Throwable -> L9
        Trace.traceBegin(262144, "commitPackages");     // Catch: Throwable -> L26
        commitPackagesLocked(reconciledPackages, this.mPm.mUserManager.getUserIds());     // Catch: Throwable -> L26
        Trace.traceEnd(262144);     // Catch: Throwable -> L24
        monitor-exit(r3);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L9
        executePostCommitStepsLIF(reconciledPackages);     // Catch: Throwable -> L9
        if (installLock == null) goto L48;
        installLock.close();
        return true;
    L48:
        return true;
    L24:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L26:
        th = move-exception;
        Trace.traceEnd(262144);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L11:
        th = th;
        goto L10
    }

    private void completeInstallProcess(List<InstallRequest> requests, Map<String, Boolean> createdAppId, boolean success) {
        int r3 = 0;
        char r4 = 1;
        if (success == false) goto L81;
        Iterator<InstallRequest> r5 = requests.iterator();
    L6:
        if (r5.hasNext() == false) goto L99;
        InstallRequest request = r5.next();
        this.mInjector.getAppOpsManagerInternal().onPackageAdded(request.getName(), request.getAppId());
        ParsedPackage parsedPkg = request.getParsedPackage();
        char r9 = 2;
        if (parsedPkg.getUid() > 10000) goto L10;
    L72:
        r3 = r3;
    L74:
        if (request.getDataLoaderType() != 2) goto L75;
        if (request.getSignatureSchemeVersion() != 4) goto L78;
        String baseCodePath = request.getPkg().getBaseApkPath();
        String[] splitCodePaths = request.getPkg().getSplitCodePaths();
        Uri originUri = request.getOriginUri();
        PackageManagerService r6 = this.mPm;
        int verificationId = r6.mPendingVerificationToken;
        r6.mPendingVerificationToken = verificationId + 1;
        String rootHashString = PackageManagerServiceUtils.buildVerificationRootHashString(baseCodePath, splitCodePaths);
        VerificationUtils.broadcastPackageVerified(verificationId, originUri, 1, rootHashString, request.getDataLoaderType(), request.getUser(), this.mContext);
        r4 = 1;
        goto L6
    L78:
        r4 = 1;
        goto L6
    L75:
        r4 = 1;
        goto L6
    L10:
        if (parsedPkg.getBaseApkPath().endsWith("/base.apk") == false) goto L72;
        String prePath = parsedPkg.getBaseApkPath().substring(r3, parsedPkg.getBaseApkPath().length() - "/base.apk".length());
        BufferedReader reader = new BufferedReader(new FileReader("/data/syslog/root_path.log"));     // Catch: IOException -> L69
        List<String> lines = new ArrayList();     // Catch: Throwable -> L20
        int need_write = 0;
    L15:
        String line = reader.readLine();     // Catch: Throwable -> L20
        if (line == null) goto L41;
        String line2 = line.trim();     // Catch: Throwable -> L20
        if (line2.isEmpty() == true) goto L19;
        if (line2.startsWith(parsedPkg.getPackageName()) == true) goto L26;
        lines.add(line2);     // Catch: Throwable -> L34
        r3 = r3;
        r4 = 1;
        r9 = 2;
        goto L15
    L26:
        if (line2.contains(",") == true) goto L27;
        lines.add(parsedPkg.getPackageName() + "," + prePath + "," + parsedPkg.getUid());     // Catch: Throwable -> L34
        need_write = 1;
        r3 = r3;
        r4 = 1;
        r9 = 2;
        goto L15
    L27:
        String[] parts = line2.split(",", 3);     // Catch: Throwable -> L20
        String old_Path = parts[r4];     // Catch: Throwable -> L20
        int old_uid = Integer.parseInt(parts[r9]);     // Catch: Throwable -> L20
        if (old_Path.equals(prePath) == false) goto L36;
        int r16 = r3;
        if (parsedPkg.getUid() != old_uid) goto L37;
        lines.add(line2);     // Catch: Throwable -> L34
    L38:
        r3 = r16;
        r4 = 1;
        r9 = 2;
    L37:
        lines.add(parsedPkg.getPackageName() + "," + prePath + "," + parsedPkg.getUid());     // Catch: Throwable -> L34
        need_write = 1;
        goto L38
    L36:
        r16 = r3;
        goto L37
    L19:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "root_path.log line is empty");     // Catch: Throwable -> L20
        int need_write2 = 0;
    L43:
        if (need_write2 == 1) goto L106;
    L100:
        reader.close();     // Catch: IOException -> L62
    L71:
        Slog.e("RecordRootPath", "Failed to write root_path.log");
        goto L74
    L106:
        BufferedWriter writer = new BufferedWriter(new FileWriter("/data/syslog/root_path.log"));     // Catch: Throwable -> L34
        Iterator<String> r0 = lines.iterator();     // Catch: Throwable -> L51
    L48:
        if (r0.hasNext() == false) goto L53;
        String line_write = r0.next();     // Catch: Throwable -> L51
        writer.write(line_write);     // Catch: Throwable -> L51
        writer.newLine();     // Catch: Throwable -> L51
    L53:
        writer.close();     // Catch: Throwable -> L34
        File recordFile = new File("/data/syslog/root_path.log");     // Catch: Throwable -> L34
        FileUtils.setPermissions(recordFile.getAbsolutePath(), 509, -1, -1);     // Catch: Throwable -> L34
    L51:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L57
    L59:
        throw th;     // Catch: Throwable -> L34
    L57:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L34
    L34:
        th = th;
    L22:
        Throwable r7 = th;
        reader.close();     // Catch: Throwable -> L66
    L68:
        throw r7;     // Catch: IOException -> L62
    L66:
        th = move-exception;
        r7.addSuppressed(th);     // Catch: IOException -> L62
        goto L68
    L41:
        need_write2 = need_write;
    L20:
        th = th;
        r3 = r3;
    L70:
        r3 = r3;
        goto L71
    L99:
        return;
    L81:
        int r17 = 0;
        Iterator<InstallRequest> r1 = requests.iterator();
    L83:
        if (r1.hasNext() == false) goto L91;
        InstallRequest installRequest = r1.next();
        if (installRequest.getParsedPackage() == null) goto L83;
        if (createdAppId.getOrDefault(installRequest.getParsedPackage().getPackageName(), false).booleanValue() == false) goto L83;
        cleanUpAppIdCreation(installRequest);
        goto L83
    L91:
        Iterator<InstallRequest> r2 = requests.iterator();
    L93:
        if (r2.hasNext() == false) goto L148;
        InstallRequest request2 = r2.next();
        request2.closeFreezer();
        if (request2.getReturnCode() != 1) goto L97;
        int r8 = r17;
        request2.setReturnCode(r8);
    L98:
        r17 = r8;
        goto L93
    L97:
        r8 = r17;
        goto L98
    }

    private boolean checkNoAppStorageIsConsistent(AndroidPackage oldPkg, AndroidPackage newPkg) {
        if (oldPkg != null) goto L5;
        return true;
    L5:
        PackageManager.Property curProp = (PackageManager.Property) oldPkg.getProperties().get("android.internal.PROPERTY_NO_APP_DATA_STORAGE");
        PackageManager.Property newProp = (PackageManager.Property) newPkg.getProperties().get("android.internal.PROPERTY_NO_APP_DATA_STORAGE");
        if (curProp != null) goto L8;
    L16:
        if (newProp != null) goto L18;
        return true;
    L18:
        if (newProp.getBoolean() == true) goto L21;
        return true;
    L21:
        return false;
    L8:
        if (curProp.getBoolean() == false) goto L16;
        if (newProp == null) goto L15;
        if (newProp.getBoolean() == false) goto L15;
        return true;
    L15:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.android.server.pm.PackageFreezer] */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.android.server.pm.PackageFreezer] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r51v0, types: [com.android.server.pm.InstallRequest] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v80 */
    /* JADX WARN: Type inference failed for: r5v82 */
    /* JADX WARN: Type inference failed for: r5v84 */
    /* JADX WARN: Type inference failed for: r5v85 */
    /* JADX WARN: Type inference failed for: r5v89 */
    /* JADX WARN: Type inference failed for: r5v90 */
    /* JADX WARN: Type inference failed for: r5v91 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    private void preparePackage(InstallRequest r51) throws PrepareFailure {
        InstallPackageHelper r1 = this;
        int[] r13 = r1.mPm.mUserManager.getUserIds();
        int r14 = r51.getInstallFlags();
        if (r51.getVolumeUuid() == null) goto L5;
        boolean r0 = true;
    L6:
        boolean r15 = r0;
        if ((r14 & 2048) == 0) goto L9;
        boolean r2 = true;
    L10:
        boolean r16 = r2;
        if ((r14 & 16384) == 0) goto L13;
        boolean r3 = true;
    L14:
        boolean r17 = r3;
        if ((r14 & 65536) == 0) goto L17;
        boolean r5 = true;
    L18:
        boolean r18 = r5;
        if ((r14 & 131072) == 0) goto L21;
        boolean r6 = true;
    L22:
        boolean r19 = r6;
        if (r51.getInstallReason() != 5) goto L25;
        boolean r7 = true;
    L26:
        boolean r26 = r7;
        int r8 = 6;
        if (r51.isInstallMove() == false) goto L30;
        r8 = 6 | 512;
    L30:
        if ((r14 & 4096) == 0) goto L32;
        r8 = r8 | 1024;
    L32:
        if (r16 == false) goto L34;
        r8 = r8 | 8192;
    L34:
        if (r17 == false) goto L36;
        r8 = r8 | 16384;
    L36:
        if (r18 == false) goto L38;
        r8 = r8 | 32768;
    L38:
        if (r19 == false) goto L41;
        r8 = r8 | 67108864;
    L41:
        if (r19 == false) goto L43;
        String r9 = r51.getApexInfo().modulePath;
    L44:
        File r10 = new File(r9);
        if (r16 == false) goto L50;
        if (r15 == false) goto L50;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Incompatible ephemeral install; external=" + r15);
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION);
    L50:
        int r11 = (r1.mPm.getDefParseFlags() | Integer.MIN_VALUE) | 64;
        if (r15 == false) goto L53;
        int r12 = 8;
    L54:
        int r20 = r11 | r12;
        int r110 = r8;
        long r21 = 262144;
        Trace.traceBegin(262144, "parsePackage");
        PackageParser2 r111 = r1.mPm.mInjector.getPreparingPackageParser();     // Catch: Throwable -> L754 PackageParserException -> L756
        if (r51.getPackageLite() == null) goto L863;
        if (r51.isArchived() == false) goto L863;
        r21 = 262144;
        ParsedPackage r22 = r111.parsePackageFromPackageLite(r51.getPackageLite(), r20);     // Catch: Throwable -> L64
        ArchivedPackageParcel r23 = r51.getPackageLite().getArchivedPackage();     // Catch: Throwable -> L64
    L71:
        if (r22 != null) goto L73;
    L76:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "preparePackageLI pkg: " + r22.getPackageName() + " applicationInfo null");     // Catch: Throwable -> L739
    L77:
        r1.mPm.getExt().updateAppCategory(r22);     // Catch: Throwable -> L739
        if (r111 != null) goto L872;
    L85:
        Trace.traceEnd(r21);
        if ((16777216 & r14) == 0) goto L88;
        boolean r4 = true;
    L89:
        if (r4 == false) goto L91;
    L93:
        boolean r38 = Utils.isXtsPkg(r22.getPackageName());
        if (SystemProperties.getBoolean("persist.sys.debug.allow_bypass_low_target_sdk_block", false) == true) goto L99;
        if (r38 == true) goto L99;
        if (Utils.isSpecialBypassLowTargetApp(r22.getPackageName()) == true) goto L99;
        boolean r40 = false;
    L101:
        if (r40 == true) goto L115;
        int r24 = 24;
        if (r38 == false) goto L108;
        if (r22.getTargetSdkVersion() >= 24) goto L115;
    L109:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "App " + r22.getPackageName() + " targets deprecated sdk version");
        StringBuilder r25 = new StringBuilder();
        r25.append("App package must target at least SDK version ");
        if (r38 == true) goto L113;
        r24 = PackageManagerService.MIN_INSTALLABLE_TARGET_SDK;
    L113:
        r25.append(r24);
        r25.append(", but found ");
        r25.append(r22.getTargetSdkVersion());
        throw new PrepareFailure(-29, r25.toString());
    L108:
        if (r22.getTargetSdkVersion() < PackageManagerService.MIN_INSTALLABLE_TARGET_SDK) goto L109;
    L115:
        if (r16 == false) goto L126;
        if (r22.getTargetSdkVersion() >= 26) goto L119;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Instant app package " + r22.getPackageName() + " does not target at least O");
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Instant app package must target at least O");
    L119:
        if (r22.getSharedUserId() == null) goto L126;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Instant app package " + r22.getPackageName() + " may not declare sharedUserId.");
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Instant app package may not declare a sharedUserId");
    L126:
        if (r22.isStaticSharedLibrary() == false) goto L132;
        PackageManagerService.renameStaticSharedLibraryPackage(r22);
        if (r15 == false) goto L132;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Static shared libs can only be installed on internal storage.");
        throw new PrepareFailure(-19, "Static shared libs can only be installed on internal storage.");
    L132:
        String r27 = r22.getPackageName();
        r51.setName(r27);
        if (r22.isTestOnly() == false) goto L140;
        if ((r14 & 4) != 0) goto L140;
        throw new PrepareFailure(-15, "Failed to install test-only apk. Did you forget to add -t?");
    L140:
        if (r51.getSigningDetails() == SigningDetails.UNKNOWN) goto L142;
        r22.setSigningDetails(r51.getSigningDetails());
    L145:
        r1.mObricExt.checkAssistInstallRestriction(r22);
        if (r16 == true) goto L148;
    L152:
        boolean r112 = false;
        PackageManagerTracedLock r28 = r1.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r28);
        PackageSetting r29 = r1.mPm.mSettings.getPackageLPr(r27);     // Catch: Throwable -> L730
        ArchivedPackageParcel r42 = r23;
        if ((r14 & 2) != 0) goto L861;
        Object r210 = r27;
        r20 = r20;
        boolean r211 = false;
        r110 = r110;
        PackageSetting r30 = r29;
    L241:
        PackageSetting r31 = r30;
        PackageSetting r32 = r31;
        if (r31 != null) goto L820;
        r32 = r31;
        if (r22.isSdkLibrary() == false) goto L820;
        WatchedLongSparseArray<SharedLibraryInfo> r33 = r1.mSharedLibraries.getSharedLibraryInfos(r22.getSdkLibraryName());     // Catch: Throwable -> L251
        r32 = r31;
        if (r33 == null) goto L820;
        r32 = r31;
        if (r33.size() <= 0) goto L820;
        r32 = r1.mPm.mSettings.getPackageLPr(r33.valueAt(0).getPackageName());     // Catch: Throwable -> L251
    L251:
        th = th;
    L850:
        monitor-exit(r28);     // Catch: Throwable -> L735
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L735:
        th = th;
    L820:
        PackageSetting r34 = r32;
        if (r22.isStaticSharedLibrary() == false) goto L259;
        SharedLibraryInfo r35 = r1.mSharedLibraries.getLatestStaticSharedLibraVersion(r22);     // Catch: Throwable -> L251
        r34 = r32;
        if (r35 == null) goto L259;
        r34 = r1.mPm.mSettings.getPackageLPr(r35.getPackageName());     // Catch: Throwable -> L251
    L259:
        if (r34 != null) goto L765;
        int r113 = r110;
        Object r212 = r210;
    L297:
        if (r30 == null) goto L302;
        boolean r36 = r30.isSystem();     // Catch: Throwable -> L269
        r51.setOriginUsers(r30.queryUsersInstalledOrHasData(r13));     // Catch: Throwable -> L179
        boolean r37 = r36;
    L801:
        int r39 = ArrayUtils.size(r22.getPermissionGroups());     // Catch: Throwable -> L726
        int r41 = 0;
        PackageSetting r43 = r30;
    L305:
        if (r41 >= r39) goto L324;
        ParsedPermissionGroup r114 = (ParsedPermissionGroup) r22.getPermissionGroups().get(r41);     // Catch: Throwable -> L315
        int r213 = r41;
        PackageSetting r214 = r43;
        PermissionGroupInfo r44 = r1.mPm.getPermissionGroupInfo(r114.getName(), 0);     // Catch: Throwable -> L315
        if (r44 == null) goto L323;
        if (cannotInstallWithBadPermissionGroups(r22) == false) goto L323;
        String r45 = r44.packageName;     // Catch: Throwable -> L315
        if (r112 == true) goto L318;
        if (r22.getPackageName().equals(r45) == true) goto L323;
    L318:
        if (r1.doesSignatureMatchForPermissions(r45, r22, r113) == true) goto L323;
        EventLog.writeEvent(1397638484, new Object[]{"146211400", -1, r22.getPackageName()});     // Catch: Throwable -> L315
        throw new PrepareFailure(-126, "Package " + r22.getPackageName() + " attempting to redeclare permission group " + r114.getName() + " already owned by " + r45);     // Catch: Throwable -> L315
    L323:
        r41 = r213 + 1;
        r43 = r214;
    L315:
        th = th;
        goto L850
    L324:
        PackageSetting r215 = r43;
        int r46 = ArrayUtils.size(r22.getPermissions());     // Catch: Throwable -> L726
        int r47 = r46 - 1;
    L327:
        if (r47 < 0) goto L392;
        ParsedPermission r48 = (ParsedPermission) r22.getPermissions().get(r47);     // Catch: Throwable -> L390
        int r216 = r46;
        Permission r49 = r1.mPm.mPermissionManager.getPermissionTEMP(r48.getName());     // Catch: Throwable -> L390
        if ((r48.getProtectionLevel() & 4096) == 0) goto L340;
        if (r37 == true) goto L340;
        StringBuilder r50 = new StringBuilder();     // Catch: Throwable -> L338
        boolean r217 = r112;
        r50.append("Non-System package ");     // Catch: Throwable -> L336
        r50.append(r22.getPackageName());     // Catch: Throwable -> L336
        r50.append(" attempting to delcare ephemeral permission ");     // Catch: Throwable -> L336
        r50.append(r48.getName());     // Catch: Throwable -> L336
        r50.append("; Removing ephemeral.");     // Catch: Throwable -> L336
        Slog.w(PackageManagerServiceMonitorEx.TAG, r50.toString());     // Catch: Throwable -> L336
        ComponentMutateUtils.setProtectionLevel(r48, r48.getProtectionLevel() & (-4097));     // Catch: Throwable -> L336
    L341:
        if (r49 != 0) goto L771;
        int r410 = r14;
    L364:
        if (r48.getGroup() == null) goto L389;
        if (cannotInstallWithBadPermissionGroups(r22) == false) goto L389;
        boolean r52 = false;
        int r115 = 0;
    L368:
        if (r115 >= r39) goto L373;
        if (((ParsedPermissionGroup) r22.getPermissionGroups().get(r115)).getName().equals(r48.getGroup()) == true) goto L371;
        r115 = r115 + 1;     // Catch: Throwable -> L349
        goto L368
    L371:
        r52 = true;
    L373:
        if (r52 == true) goto L389;
        PermissionGroupInfo r116 = r1.mPm.getPermissionGroupInfo(r48.getGroup(), 0);     // Catch: Throwable -> L349
        if (r116 == null) goto L384;
        String r117 = r116.packageName;     // Catch: Throwable -> L349
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(r117) == true) goto L389;
        if (r1.doesSignatureMatchForPermissions(r117, r22, r113) == true) goto L389;
        EventLog.writeEvent(1397638484, new Object[]{"146211400", -1, r22.getPackageName()});     // Catch: Throwable -> L349
        throw new PrepareFailure(-127, "Package " + r22.getPackageName() + " attempting to declare permission " + r48.getName() + " in group " + r48.getGroup() + " owned by package " + r117 + " with incompatible certificate");     // Catch: Throwable -> L349
    L384:
        EventLog.writeEvent(1397638484, new Object[]{"146211400", -1, r22.getPackageName()});     // Catch: Throwable -> L349
        throw new PrepareFailure(-127, "Package " + r22.getPackageName() + " attempting to declare permission " + r48.getName() + " in non-existing group " + r48.getGroup());     // Catch: Throwable -> L349
    L389:
        r47 = r47 - 1;
        r46 = r216;
        r112 = r217;
        r39 = r39;
        r14 = r410;
        goto L327
    L771:
        String r53 = r49.getPackageName();     // Catch: Throwable -> L351
        if (r1.doesSignatureMatchForPermissions(r53, r22, r113) == false) goto L345;
        r410 = r14;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(r22.getPackageName()) == true) goto L364;
        if ((r48.getProtectionLevel() & 15) != 1) goto L364;
        if (r49.isRuntime() == true) goto L364;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package " + r22.getPackageName() + " trying to change a non-runtime permission " + r48.getName() + " to runtime; keeping old protection level");     // Catch: Throwable -> L349
        ComponentMutateUtils.setProtectionLevel(r48, r49.getProtectionLevel());     // Catch: Throwable -> L349
        goto L364
    L345:
        if (r53.equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L354;
        StringBuilder r118 = new StringBuilder();     // Catch: Throwable -> L351
        r410 = r14;
        r118.append("Package ");     // Catch: Throwable -> L349
        r118.append(r22.getPackageName());     // Catch: Throwable -> L349
        r118.append(" attempting to redeclare system permission ");     // Catch: Throwable -> L349
        r118.append(r48.getName());     // Catch: Throwable -> L349
        r118.append("; ignoring new declaration");     // Catch: Throwable -> L349
        Slog.w(PackageManagerServiceMonitorEx.TAG, r118.toString());     // Catch: Throwable -> L349
        r22.removePermission(r47);     // Catch: Throwable -> L349
    L349:
        th = th;
        goto L850
    L354:
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_ILLEGAL_START, "Package " + r22.getPackageName() + " attempting to redeclare permission " + r48.getName() + " already owned by " + r53).conflictsWithExistingPermission(r48.getName(), r53);     // Catch: Throwable -> L349
    L351:
        th = th;
    L336:
        th = th;
    L338:
        th = th;
    L340:
        r217 = r112;
    L390:
        th = th;
        goto L850
    L392:
        boolean r218 = r112;
        int r411 = r14;
        monitor-exit(r28);     // Catch: Throwable -> L724
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (r1.mPm.isStorageLow() == true) goto L723;
        if (r37 == false) goto L405;
        if (r15 == true) goto L403;
        if (r16 == false) goto L405;
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Cannot update a system app with an instant app");
    L403:
        throw new PrepareFailure(-19, "Cannot install updates to system apps on sdcard");
    L405:
        if (r51.isInstallMove() == false) goto L419;
        int r54 = (r113 | 1) | 256;
        PackageManagerTracedLock r55 = r1.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r55);
        PackageSetting r56 = r1.mPm.mSettings.getPackageLPr(r27);     // Catch: Throwable -> L411
        if (r56 != null) goto L413;
        r51.setError(PackageManagerException.ofInternalError("Missing settings for moved package " + r27, -3));     // Catch: Throwable -> L411
    L413:
        r22.setPrimaryCpuAbi(r56.getPrimaryCpuAbiLegacy()).setSecondaryCpuAbi(r56.getSecondaryCpuAbiLegacy());     // Catch: Throwable -> L411
        monitor-exit(r55);     // Catch: Throwable -> L411
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        ParsedPackage r119 = r22;
        int r120 = r54;
    L470:
        if (r19 == false) goto L472;
        r119.setPath(r51.getApexInfo().modulePath);
        r119.setBaseApkPath(r51.getApexInfo().modulePath);
    L472:
        String r57 = null;
        ?? r58 = 1;
        r58 = 1;
        r58 = 1;
        r58 = 1;
        int r59 = r120;
        int r60 = r20;
        if (r218 == true) goto L818;
        r57 = null;
        String r61 = r119.getPackageName();     // Catch: Throwable -> L701
        PackageManagerTracedLock r62 = r1.mPm.mLock;     // Catch: Throwable -> L701
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L701
        monitor-enter(r62);     // Catch: Throwable -> L701
        String r63 = r1.mPm.mSettings.getRenamedPackageLPr(r61);     // Catch: Throwable -> L703
        if (r63 != null) goto L711;
        if (r1.mPm.mPackages.containsKey(r61) == true) goto L707;
        monitor-exit(r62);     // Catch: Throwable -> L703
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L701
        PackageSetting r121 = null;
        PackageSetting r64 = null;
        boolean r65 = false;
        int r66 = r59;
        PackageSetting r122 = null;
        int r67 = r60;
    L692:
        ?? r68 = r57;
        r51.setPrepareResult(r218, r66, r67, r64, r119, r42, r218, r65, r121, r122);     // Catch: Throwable -> L699
        if (r68 == 0) goto L899;
        r51.setFreezer(r68);
        if (0 == 0) goto L900;
        r68.close();
        return;
    L900:
        return;
    L899:
        return;
    L699:
        th = th;
        r58 = 0;
        ?? r69 = r68;
    L717:
        if (r69 == 0) goto L721;
        r51.setFreezer(r69);
        if (r58 == 0) goto L721;
        r69.close();
    L721:
        throw th;
    L707:
        throw new PrepareFailure(-1, "Attempt to re-install " + r61 + " without first uninstalling.");     // Catch: Throwable -> L708
    L711:
        throw new PrepareFailure(-1, "Attempt to re-install " + r61 + " without first uninstalling package running as " + r63);     // Catch: Throwable -> L708
    L703:
        th = th;
        InstallPackageHelper r70 = null;
    L712:
        monitor-exit(r62);     // Catch: Throwable -> L708
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L715
        throw th;     // Catch: Throwable -> L715
    L715:
        th = th;
        r58 = 1;
        r69 = r70;
    L708:
        th = th;
        r70 = r1;
    L701:
        th = th;
        r69 = 0;
        r58 = 1;
        goto L717
    L818:
        String r71 = r119.getPackageName();     // Catch: Throwable -> L673
        PackageManagerTracedLock r123 = r1.mPm.mLock;     // Catch: Throwable -> L673
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L673
        monitor-enter(r123);     // Catch: Throwable -> L673
        PackageSetting r124 = r1.mPm.mSettings.getPackageLPr(r71);     // Catch: Throwable -> L675
        monitor-exit(r123);     // Catch: Throwable -> L675
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L673
        AndroidPackage r125 = r124.getAndroidPackage();     // Catch: Throwable -> L673
        if (r119.isStaticSharedLibrary() == false) goto L499;
        if (r125 == null) goto L499;
        if ((r411 & 32) != 0) goto L499;
    L490:
        th = th;
        r69 = 0;
        goto L717
    L489:
        throw new PrepareFailure(-5, "Packages declaring static-shared libs cannot be updated");     // Catch: Throwable -> L490
    L494:
        th = th;
        r69 = 0;
    L499:
        if ((r120 & 8192) == 0) goto L501;
        boolean r72 = true;
    L805:
        PackageManagerTracedLock r73 = r1.mPm.mLock;     // Catch: Throwable -> L671
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L671
        monitor-enter(r73);     // Catch: Throwable -> L671
        boolean r219 = r72;
        PackageSetting r74 = r1.mPm.mSettings.getPackageLPr(r71);     // Catch: Throwable -> L666
        PackageSetting r75 = r1.mPm.mSettings.getDisabledSystemPkgLPr(r74);     // Catch: Throwable -> L664
        SharedUserSetting r76 = r1.mPm.mSettings.getSharedUserSettingLPr(r74);     // Catch: Throwable -> L664
        KeySetManagerService r77 = r1.mPm.mSettings.getKeySetManagerService();     // Catch: Throwable -> L662
        if (r77.shouldCheckUpgradeKeySetLocked(r74, r76, r120) == false) goto L519;
    L516:
        th = th;
    L668:
        monitor-exit(r73);     // Catch: Throwable -> L584
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L623
        throw th;     // Catch: Throwable -> L623
    L512:
        if (r77.checkUpgradeKeySetLocked(r74, r119) == false) goto L515;
        int r310 = r59;
    L537:
        if (r124.getRestrictUpdateHash() == null) goto L556;
        if (r124.isSystem() == false) goto L556;
        MessageDigest r78 = MessageDigest.getInstance("SHA-512");     // Catch: Throwable -> L530 Throwable -> L545
        updateDigest(r78, new File(r119.getBaseApkPath()));     // Catch: Throwable -> L530 Throwable -> L545
        if (ArrayUtils.isEmpty(r119.getSplitCodePaths()) == true) goto L547;
        String[] r79 = r119.getSplitCodePaths();     // Catch: Throwable -> L530 Throwable -> L545
        int r80 = r79.length;     // Catch: Throwable -> L530 Throwable -> L545
        int r81 = 0;
    L543:
        if (r81 >= r80) goto L547;
        updateDigest(r78, new File(r79[r81]));     // Catch: Throwable -> L530 Throwable -> L545
        r81 = r81 + 1;     // Catch: Throwable -> L530 Throwable -> L545
        r80 = r80;
    L547:
        goto L554
    L549:
        if (Arrays.equals(r124.getRestrictUpdateHash(), r78.digest()) == false) goto L552;
        r119.setRestrictUpdateHash(r124.getRestrictUpdateHash());     // Catch: Throwable -> L530
        goto L556
    L552:
        throw new PrepareFailure(-2, "New package fails restrict-update check: " + r71);     // Catch: Throwable -> L530
    L530:
        th = th;
    L554:
        throw new PrepareFailure(-2, "Could not compute hash: " + r71);     // Catch: Throwable -> L530
    L556:
        if (r1.mPm.mSettings.getSharedUserSettingLPr(r124) == null) goto L559;
        String r82 = r1.mPm.mSettings.getSharedUserSettingLPr(r124).name;     // Catch: Throwable -> L530
    L561:
        if (r119.getSharedUserId() == null) goto L564;
        String r83 = r119.getSharedUserId();     // Catch: Throwable -> L530
    L566:
        if (r82.equals("<nothing>") == false) goto L572;
        if (r119.isLeavingSharedUser() == false) goto L572;
        r83 = "<nothing>";
    L572:
        if (r82.equals(r83) == true) goto L590;
        if (r82.equals("<nothing>") == true) goto L576;
    L580:
        StringBuilder r84 = new StringBuilder();     // Catch: Throwable -> L586
        r84.append("Package ");     // Catch: Throwable -> L584
        r84.append(r119.getPackageName());     // Catch: Throwable -> L584
        r84.append(" shared user changed from ");     // Catch: Throwable -> L584
        r84.append(r82);     // Catch: Throwable -> L584
        r84.append(" to ");     // Catch: Throwable -> L584
        r84.append(r83);     // Catch: Throwable -> L584
        throw new PrepareFailure(-24, r84.toString());     // Catch: Throwable -> L584
    L586:
        th = th;
        goto L668
    L576:
        if (r74.getPkg() != null) goto L580;
        if (r74.isArchivedOnAnyUser(r13) == false) goto L580;
    L590:
        if (r124.isLeavingSharedUser() == true) goto L592;
    L596:
        int[] r85 = r74.queryInstalledUsers(r13, true);     // Catch: Throwable -> L584
        int[] r311 = r74.queryInstalledUsers(r13, false);     // Catch: Throwable -> L584
        if (r219 == false) goto L614;
        if (r51.getUserId() != (-1)) goto L609;
        int r86 = r13.length;     // Catch: Throwable -> L584
        int r87 = 0;
    L601:
        if (r87 >= r86) goto L614;
        int r412 = r13[r87];     // Catch: Throwable -> L584
        int r413 = r86;
        if (r74.getInstantApp(r412) == false) goto L605;
        r87 = r87 + 1;     // Catch: Throwable -> L584
        r86 = r413;
        goto L601
    L605:
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Can't replace full app with instant app: " + r71 + " for user: " + r412);     // Catch: Throwable -> L584
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION);     // Catch: Throwable -> L584
    L609:
        if (r74.getInstantApp(r51.getUserId()) == true) goto L614;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Can't replace full app with instant app: " + r71 + " for user: " + r51.getUserId());     // Catch: Throwable -> L584
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION);     // Catch: Throwable -> L584
    L614:
        monitor-exit(r73);     // Catch: Throwable -> L584
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L623
        PackageRemovedInfo r88 = new PackageRemovedInfo();     // Catch: Throwable -> L623
        r88.mUid = r74.getAppId();     // Catch: Throwable -> L623
        r88.mRemovedPackage = r74.getPackageName();     // Catch: Throwable -> L623
        r88.mInstallerPackageName = r74.getInstallSource().mInstallerPackageName;     // Catch: Throwable -> L623
        if (r119.getStaticSharedLibraryName() == null) goto L618;
        boolean r89 = true;
    L619:
        r88.mIsStaticSharedLib = r89;     // Catch: Throwable -> L623
        r88.mIsUpdate = true;     // Catch: Throwable -> L623
        r88.mOrigUsers = r85;     // Catch: Throwable -> L623
        r88.mInstallReasons = new SparseIntArray(r85.length);     // Catch: Throwable -> L623
        int r90 = 0;
    L621:
        if (r90 >= r85.length) goto L625;
        int r91 = r85[r90];     // Catch: Throwable -> L623
        r88.mInstallReasons.put(r91, r74.getInstallReason(r91));     // Catch: Throwable -> L623
        r90 = r90 + 1;     // Catch: Throwable -> L623
        goto L621
    L625:
        int[] r92 = r311;
        r88.mUninstallReasons = new SparseIntArray(r92.length);     // Catch: Throwable -> L623
        int r93 = 0;
    L627:
        if (r93 >= r92.length) goto L629;
        int r94 = r92[r93];     // Catch: Throwable -> L623
        r88.mUninstallReasons.put(r94, r74.getUninstallReason(r94));     // Catch: Throwable -> L623
        r93 = r93 + 1;     // Catch: Throwable -> L623
        r92 = r92;
        goto L627
    L629:
        r88.mIsExternal = r124.isExternalStorage();     // Catch: Throwable -> L623
        r88.mRemovedPackageVersionCode = r124.getVersionCode();     // Catch: Throwable -> L623
        r51.setRemovedInfo(r88);     // Catch: Throwable -> L623
        if ((r119.getApplicationInfoSmtEx().bytedanceFlag & 256) != 0) goto L632;
        r65 = r124.isSystem();     // Catch: Throwable -> L623
    L633:
        if (r65 == false) goto L660;
        boolean r95 = r124.isPrivileged();     // Catch: Throwable -> L623
        boolean r96 = r124.isOem();     // Catch: Throwable -> L623
        boolean r220 = r124.isVendor();     // Catch: Throwable -> L623
        boolean r312 = r124.isProduct();     // Catch: Throwable -> L623
        boolean r313 = r124.isOdm();     // Catch: Throwable -> L623
        boolean r414 = r124.isSystemExt();     // Catch: Throwable -> L623
        int r415 = r20;
        int r97 = 65536 | r120;     // Catch: Throwable -> L623
        if (r95 == false) goto L637;
        int r221 = 131072;
    L638:
        int r98 = r97 | r221;     // Catch: Throwable -> L623
        if (r96 == false) goto L641;
        int r222 = 262144;
    L642:
        int r99 = r98 | r222;     // Catch: Throwable -> L623
        if (r220 == false) goto L645;
        int r223 = 524288;
    L646:
        int r100 = r99 | r223;     // Catch: Throwable -> L623
        if (r312 == false) goto L649;
        int r224 = 1048576;
    L650:
        int r101 = r100 | r224;     // Catch: Throwable -> L623
        if (r313 == false) goto L653;
        int r225 = 4194304;
    L654:
        int r102 = r101 | r225;     // Catch: Throwable -> L623
        if (r414 == false) goto L657;
        int r314 = 2097152;
    L658:
        int r103 = r102 | r314;     // Catch: Throwable -> L623
        r51.setReturnCode(1);     // Catch: Throwable -> L623
        r51.setApexModuleName(r124.getApexModuleName());     // Catch: Throwable -> L623
        int r104 = r415;
        int r105 = r103;
    L661:
        r66 = r105;
        r67 = r104;
        r64 = r124;
        r122 = r75;
        r121 = r74;
        goto L692
    L657:
        r314 = 0;
        goto L658
    L653:
        r225 = 0;
        goto L654
    L649:
        r224 = 0;
        goto L650
    L645:
        r223 = 0;
        goto L646
    L641:
        r222 = 0;
        goto L642
    L637:
        r221 = 0;
        goto L638
    L660:
        r104 = r60;
        r105 = r310;
        goto L661
    L632:
        r65 = false;
        goto L633
    L618:
        r89 = false;
        goto L619
    L592:
        if (r119.isLeavingSharedUser() == true) goto L596;
        throw new PrepareFailure(-24, "Package " + r119.getPackageName() + " attempting to rejoin " + r83);     // Catch: Throwable -> L584
    L564:
        r83 = "<nothing>";
        goto L566
    L559:
        r82 = "<nothing>";
        goto L561
    L515:
        throw new PrepareFailure(-7, "New package not signed by keys specified by upgrade-keysets: " + r71);     // Catch: Throwable -> L516
    L519:
        SigningDetails r106 = r119.getSigningDetails();     // Catch: Throwable -> L662
        SigningDetails r107 = r124.getSigningDetails();     // Catch: Throwable -> L662
        r310 = r59;
        if (r106.checkCapability(r107, 1) == true) goto L537;
        if (r107.checkCapability(r106, 8) == true) goto L537;
        if (r26 == false) goto L533;
        if (r107.hasAncestorOrSelf(r106) == true) goto L537;
    L533:
        throw new PrepareFailure(-7, "New package has a different signature: " + r71);     // Catch: Throwable -> L530
    L662:
        th = th;
    L664:
        th = th;
    L666:
        th = th;
    L584:
        th = th;
    L671:
        th = th;
        r69 = r57;
        goto L717
    L501:
        r72 = false;
        goto L805
    L675:
        th = th;
    L846:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L623
        throw th;     // Catch: Throwable -> L623
    L680:
        th = th;
    L623:
        th = th;
        r69 = r212;
        r58 = r215;
    L673:
        th = th;
        r69 = 0;
    L411:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L419:
        int r108 = r113 | 1;
        if (r19 == false) goto L785;
        r119 = r22;
    L469:
        r120 = r108;
        goto L470
    L785:
        PackageManagerTracedLock r109 = r1.mPm.mLock;     // Catch: PackageManagerException -> L457
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L457
        monitor-enter(r109);     // Catch: PackageManagerException -> L457
        PackageSetting r126 = r1.mPm.mSettings.getPackageLPr(r27);     // Catch: Throwable -> L459
        monitor-exit(r109);     // Catch: Throwable -> L459
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L457
        if (r126 != null) goto L859;
    L432:
        boolean r127 = false;
    L434:
        String r315 = PackageManagerServiceUtils.deriveAbiOverride(r51.getAbiOverride());     // Catch: PackageManagerException -> L457
        if (r126 == null) goto L439;
        if (r126.isSystem() == false) goto L439;
        boolean r128 = true;
    L441:
        PackageAbiHelper r129 = r1.mPackageAbiHelper;     // Catch: PackageManagerException -> L457
        if (r127 == true) goto L446;
        if (r128 == true) goto L446;
        boolean r316 = false;
    L447:
        ParsedPackage r226 = r22;
        Pair<PackageAbiHelper.Abis, PackageAbiHelper.NativeLibraryPaths> r130 = r129.derivePackageAbi(r226, r37, r316, r315, ScanPackageUtils.getAppLib32InstallDir());     // Catch: PackageManagerException -> L455
        r119 = r226;
        ((PackageAbiHelper.Abis) r130.first).applyTo(r119);     // Catch: PackageManagerException -> L453
        ((PackageAbiHelper.NativeLibraryPaths) r130.second).applyTo(r119);     // Catch: PackageManagerException -> L453
    L455:
        e = e;
    L466:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Error deriving application ABI", e);
        throw PrepareFailure.ofInternalError("Error deriving application ABI: " + e.getMessage(), -4);
    L446:
        r316 = true;
    L430:
        e = e;
    L439:
        r128 = false;
        goto L441
    L859:
        if (r126.isUpdatedSystemApp() == false) goto L432;
        r127 = true;
        goto L434
    L453:
        e = e;
    L459:
        th = th;
    L835:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L453
        throw th;     // Catch: PackageManagerException -> L453
    L464:
        th = th;
    L457:
        e = e;
        goto L466
    L723:
        throw new PrepareFailure(-4, "Error install failed insufficient storage");
    L724:
        th = th;
    L726:
        th = th;
        goto L850
    L302:
        r37 = r211;
        goto L801
    L765:
        KeySetManagerService r131 = r1.mPm.mSettings.getKeySetManagerService();     // Catch: Throwable -> L294
        SharedUserSetting r227 = r1.mPm.mSettings.getSharedUserSettingLPr(r34);     // Catch: Throwable -> L294
        r113 = r110;
    L269:
        th = th;
        goto L850
    L263:
        if (r131.shouldCheckUpgradeKeySetLocked(r34, r227, r113) == false) goto L865;
        if (r131.checkUpgradeKeySetLocked(r34, r22) == false) goto L268;
        r212 = r227;
        goto L297
    L268:
        throw new PrepareFailure(-7, "Package " + r22.getPackageName() + " upgrade keys do not match the previously installed version");     // Catch: Throwable -> L269
    L865:
        SharedUserSetting r228 = r227;
        boolean r132 = PackageManagerServiceUtils.verifySignatures(r34, r228, null, r22.getSigningDetails(), ReconcilePackageUtils.isCompatSignatureUpdateNeeded(r1.mPm.getSettingsVersionForPackage(r22)), ReconcilePackageUtils.isRecoverSignatureUpdateNeeded(r1.mPm.getSettingsVersionForPackage(r22)), r26);     // Catch: Throwable -> L269 PackageManagerException -> L282
        r212 = r228;
        if (r132 == false) goto L297;
        PackageManagerTracedLock r133 = r1.mPm.mLock;     // Catch: Throwable -> L269 PackageManagerException -> L282
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L269 PackageManagerException -> L282
        monitor-enter(r133);     // Catch: Throwable -> L269 PackageManagerException -> L282
        r131.removeAppKeySetDataLPw(r22.getPackageName());     // Catch: Throwable -> L284
        monitor-exit(r133);     // Catch: Throwable -> L284
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L269 PackageManagerException -> L282
        r212 = r228;
    L284:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L269 PackageManagerException -> L282
        throw th;     // Catch: Throwable -> L269 PackageManagerException -> L282
    L282:
        e = e;
    L293:
        throw new PrepareFailure(e.error, e.getMessage());     // Catch: Throwable -> L269
    L289:
        e = e;
    L294:
        th = th;
    L728:
        th = th;
        goto L850
    L861:
        String r134 = r1.mPm.mSettings.getRenamedPackageLPr(r27);     // Catch: Throwable -> L238
        String r229 = r27;
        if (r22.getOriginalPackages().contains(r134) == true) goto L783;
    L167:
        r27 = r229;
        PackageSetting r135 = r29;
    L168:
        if (r135 == null) goto L189;
        r112 = true;
        if (r27 != null) goto L869;
        r20 = r20;
    L190:
        if (r112 == true) goto L812;
        r211 = false;
        boolean r230 = r112;
    L235:
        r112 = r230;
        r30 = r135;
        r210 = r135;
        goto L241
    L812:
        int r136 = r135.getTargetSdkVersion();     // Catch: Throwable -> L230
        int r137 = r22.getTargetSdkVersion();     // Catch: Throwable -> L230
        if (r136 <= 22) goto L199;
        if (r137 > 22) goto L199;
        throw new PrepareFailure(-26, "Package " + r22.getPackageName() + " new target SDK " + r137 + " doesn't support runtime permissions but the old target SDK " + r136 + " does.");     // Catch: Throwable -> L179
    L199:
        if (r135.isPersistent() == false) goto L208;
        if ((r14 & 2097152) != 0) goto L208;
        if (r1.allowPersistentAppUpdateByZte(r27) == true) goto L208;
        throw new PrepareFailure(-2, "Package " + r27 + " is a persistent app. Persistent apps are not updateable.");     // Catch: Throwable -> L179
    L208:
        if (r22.isSdkLibrary() == true) goto L210;
    L233:
        r211 = false;
        r230 = r112;
        goto L235
    L210:
        if (r135.getPkg() == null) goto L233;
        if (r135.getPkg().isSdkLibrary() == false) goto L232;
        int r138 = r135.getPkg().getMinSdkVersion();     // Catch: Throwable -> L230
        int r139 = r22.getMinSdkVersion();     // Catch: Throwable -> L230
        if (r136 != r137) goto L218;
        if (r138 != r139) goto L218;
        r211 = false;
        r230 = r112;
    L218:
        int r231 = r135.getPkg().getSdkLibVersionMajor();     // Catch: Throwable -> L230
        int r232 = r22.getSdkLibVersionMajor();     // Catch: Throwable -> L230
        r211 = false;
        r230 = r112;
        if (r231 != r232) goto L235;
        StringBuilder r140 = new StringBuilder();     // Catch: Throwable -> L228
        r140.append("Failure updating ");     // Catch: Throwable -> L226
        r140.append(r27);     // Catch: Throwable -> L226
        r140.append(" as it updates an sdk library <");     // Catch: Throwable -> L226
        r140.append(r22.getSdkLibraryName());     // Catch: Throwable -> L226
        r140.append("> without changing the versionMajor, but the targetSdkVersion or minSdkVersion has changed: Old targetSdkVersion: ");     // Catch: Throwable -> L226
        r140.append(r136);     // Catch: Throwable -> L226
        r140.append(" new targetSdkVersion: ");     // Catch: Throwable -> L226
        r140.append(r137);     // Catch: Throwable -> L226
        r140.append(" Old minSdkVersion: ");     // Catch: Throwable -> L226
        r140.append(r138);     // Catch: Throwable -> L226
        r140.append(" new minSdkVersion: ");     // Catch: Throwable -> L226
        r140.append(r139);     // Catch: Throwable -> L226
        r140.append(" versionMajor: ");     // Catch: Throwable -> L226
        r140.append(r232);     // Catch: Throwable -> L226
        throw new PrepareFailure(-7, r140.toString());     // Catch: Throwable -> L226
    L226:
        th = th;
    L228:
        th = th;
        goto L850
    L232:
        r211 = false;
        r230 = r112;
    L230:
        th = th;
        goto L850
    L869:
        BoostFramework r233 = new BoostFramework();     // Catch: Throwable -> L186
    L182:
        th = th;
        goto L850
    L174:
        if (r233.board_first_api_lvl >= 33) goto L184;
        if (r233.board_api_lvl >= 33) goto L184;
        r233.perfUXEngine_events(8, 0, r27, 1);     // Catch: Throwable -> L179
    L179:
        th = th;
    L184:
        r233.perfEvent(4242, r27, 2, new int[]{0, -1});     // Catch: Throwable -> L179
    L186:
        th = th;
        goto L850
    L189:
        r20 = r20;
        goto L190
    L783:
    L165:
        th = th;
        goto L850
    L162:
        if (r1.mPm.mPackages.containsKey(r134) == false) goto L167;
        r22.setPackageName(r134);     // Catch: Throwable -> L165
        r229 = r134;
        r135 = r1.mPm.mSettings.getPackageLPr(r134);     // Catch: Throwable -> L165
        r27 = r229;
    L236:
        th = th;
    L238:
        th = th;
    L730:
        th = th;
        goto L850
    L148:
        if (r22.getSigningDetails().getSignatureSchemeVersion() >= 2) goto L152;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Instant app package " + r22.getPackageName() + " is not signed with at least APK Signature Scheme v2");
        throw new PrepareFailure(IProcessIntercept.REASON_SERVICE_NOT_ALLOW_FOR_SELFRESCUE_ACTION, "Instant app package must be signed with APK Signature Scheme v2 or greater");
    L142:
        ParseResult r141 = ParsingPackageUtils.getSigningDetails(ParseTypeImpl.forDefaultParsing(), r22, false);
        if (r141.isError() == true) goto L738;
        r22.setSigningDetails((SigningDetails) r141.getResult());
        goto L145
    L738:
        throw new PrepareFailure("Failed collect during installPackageLI", r141.getException());
    L99:
        r40 = r4;
        goto L101
    L91:
        if (r22.isTestOnly() == false) goto L93;
        r4 = true;
        goto L93
    L88:
        r4 = false;
        goto L89
    L872:
        r111.close();     // Catch: Throwable -> L81 PackageParserException -> L83
    L83:
        e = e;
    L760:
        throw new PrepareFailure(e.error, ExceptionUtils.getCompleteMessage("Failed parse during installPackageLI", e));     // Catch: Throwable -> L748
    L81:
        th = th;
    L761:
        Trace.traceEnd(r21);
        throw th;
    L739:
        th = th;
    L740:
        Throwable r142 = th;
    L743:
        if (r111 != null) goto L767;
        throw r142;     // Catch: Throwable -> L748 PackageParserException -> L750
    L750:
        e = e;
        goto L760
    L767:
        r111.close();     // Catch: Throwable -> L746
        throw r142;     // Catch: Throwable -> L748 PackageParserException -> L750
    L746:
        th = move-exception;
        r142.addSuppressed(th);     // Catch: Throwable -> L748 PackageParserException -> L750
        throw r142;     // Catch: Throwable -> L748 PackageParserException -> L750
    L73:
        if (r22.getApplicationInfoSysEx() == null) goto L76;
        r1.mPm.getSmtEx().updateBytedanceFlagValue(r22.getPackageName(), r22.getApplicationInfoSysEx(), r22.getVersionName());     // Catch: Throwable -> L64
    L64:
        th = th;
    L65:
        r142 = th;
    L66:
        th = th;
    L863:
        r22 = r111.parsePackage(r10, r20, false);     // Catch: Throwable -> L739
        AndroidPackageUtils.validatePackageDexMetadata(r22);     // Catch: Throwable -> L739
        r23 = null;
    L741:
        th = th;
        goto L740
    L748:
        th = th;
    L756:
        e = e;
    L754:
        th = th;
        r21 = 262144;
        goto L761
    L53:
        r12 = 0;
        goto L54
    L43:
        r9 = r51.getCodePath();
        goto L44
    L25:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L17:
        r5 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private boolean allowPersistentAppUpdateByZte(String pkgName) {
        if ("com.zte.dbneopush".equals(pkgName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private void doRenameLI(InstallRequest request, ParsedPackage parsedPackage) throws PrepareFailure {
        int status = request.getReturnCode();
        String statusMsg = request.getReturnMsg();
        boolean onIncremental = true;
        if (request.isInstallMove() == false) goto L8;
        if (status != 1) goto L6;
        return;
    L6:
        this.mRemovePackageHelper.cleanUpForMoveInstall(request.getMoveToUuid(), request.getMovePackageName(), request.getMoveFromCodePath());
        throw new PrepareFailure(status, statusMsg);
    L8:
        if (status != 1) goto L45;
        File targetDir = resolveTargetDir(request.getInstallFlags(), request.getCodeFile());
        File beforeCodeFile = request.getCodeFile();
        File afterCodeFile = PackageManagerServiceUtils.getNextCodePath(targetDir, parsedPackage.getPackageName());
        if (this.mPm.mIncrementalManager != null) goto L12;
    L14:
        onIncremental = false;
    L49:
        PackageManagerServiceUtils.makeDirRecursive(afterCodeFile.getParentFile(), 505);     // Catch: Throwable -> L19
        if (onIncremental == false) goto L21;
        this.mPm.mIncrementalManager.linkCodePath(beforeCodeFile, afterCodeFile);     // Catch: Throwable -> L19
    L23:
        if (onIncremental == false) goto L25;
    L29:
        request.setCodeFile(afterCodeFile);
        String afterCanonicalPath = afterCodeFile.getCanonicalPath();     // Catch: IOException -> L34
        String beforeCanonicalPath = beforeCodeFile.getCanonicalPath();     // Catch: IOException -> L34
        parsedPackage.setPath(afterCanonicalPath);     // Catch: IOException -> L34
        parsedPackage.setNativeLibraryDir(parsedPackage.getNativeLibraryDir().replace(beforeCanonicalPath, afterCanonicalPath));     // Catch: IOException -> L34
        parsedPackage.setNativeLibraryRootDir(parsedPackage.getNativeLibraryRootDir().replace(beforeCanonicalPath, afterCanonicalPath));     // Catch: IOException -> L34
        String secondaryNativeLibraryDir = parsedPackage.getSecondaryNativeLibraryDir();     // Catch: IOException -> L34
        if (secondaryNativeLibraryDir == null) goto L36;
        parsedPackage.setSecondaryNativeLibraryDir(secondaryNativeLibraryDir.replace(beforeCanonicalPath, afterCanonicalPath));     // Catch: IOException -> L34
    L36:
        parsedPackage.setBaseApkPath(FileUtils.rewriteAfterRename(beforeCodeFile, afterCodeFile, parsedPackage.getBaseApkPath()));
        parsedPackage.setSplitCodePaths(FileUtils.rewriteAfterRename(beforeCodeFile, afterCodeFile, parsedPackage.getSplitCodePaths()));
        if (Build.isDebuggable() == false) goto L39;
        SysMonitorFwBridge.getFactory().getCustomLeakCanaryUtils().renameCustomLeakCanarySplit(parsedPackage);
    L39:
        request.updateAllCodePaths(AndroidPackageUtils.getAllCodePaths(parsedPackage));
        return;
    L34:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to get path: " + afterCodeFile, e);
        throw new PrepareFailure(-20, "Failed to get path: " + afterCodeFile);
    L25:
        if (SELinux.restoreconRecursive(afterCodeFile) == true) goto L29;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to restorecon");
        throw new PrepareFailure(-20, "Failed to restorecon");
    L21:
        Os.rename(beforeCodeFile.getAbsolutePath(), afterCodeFile.getAbsolutePath());     // Catch: Throwable -> L19
    L19:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to rename", e);
        throw new PrepareFailure(-4, "Failed to rename");
    L12:
        if (IncrementalManager.isIncrementalPath(beforeCodeFile.getAbsolutePath()) == false) goto L14;
    L45:
        this.mRemovePackageHelper.removeCodePath(request.getCodeFile());
        throw new PrepareFailure(status, statusMsg);
    }

    private File resolveTargetDir(int installFlags, File codeFile) {
        if ((2097152 & installFlags) == 0) goto L5;
        boolean isStagedInstall = true;
    L6:
        if (isStagedInstall == false) goto L10;
        return Environment.getDataAppDirectory(null);
    L10:
        return codeFile.getParentFile();
    L5:
        isStagedInstall = false;
        goto L6
    }

    private static boolean cannotInstallWithBadPermissionGroups(ParsedPackage parsedPackage) {
        if (parsedPackage.getTargetSdkVersion() < 31) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean doesSignatureMatchForPermissions(String sourcePackageName, ParsedPackage parsedPackage, int scanFlags) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting sourcePackageSetting = this.mPm.mSettings.getPackageLPr(sourcePackageName);     // Catch: Throwable -> L33
        KeySetManagerService ksms = this.mPm.mSettings.getKeySetManagerService();     // Catch: Throwable -> L33
        SharedUserSetting sharedUserSetting = this.mPm.mSettings.getSharedUserSettingLPr(sourcePackageSetting);     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (sourcePackageSetting != null) goto L9;
        SigningDetails sourceSigningDetails = SigningDetails.UNKNOWN;
    L11:
        if (sourcePackageName.equals(parsedPackage.getPackageName()) == false) goto L17;
        if (ksms.shouldCheckUpgradeKeySetLocked(sourcePackageSetting, sharedUserSetting, scanFlags) == false) goto L17;
        return ksms.checkUpgradeKeySetLocked(sourcePackageSetting, parsedPackage);
    L17:
        if (sourceSigningDetails.checkCapability(parsedPackage.getSigningDetails(), 4) == false) goto L20;
        return true;
    L20:
        if (parsedPackage.getSigningDetails().checkCapability(sourceSigningDetails, 4) == false) goto L31;
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        sourcePackageSetting.setSigningDetails(parsedPackage.getSigningDetails());     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return true;
    L27:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L31:
        return false;
    L9:
        sourceSigningDetails = sourcePackageSetting.getSigningDetails();
    L33:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private PackageFreezer freezePackageForInstall(String packageName, int userId, int installFlags, String killReason, int exitInfoReason, InstallRequest request) {
        if ((installFlags & 4096) == 0) goto L7;
        return new PackageFreezer(this.mPm, request);
    L7:
        return this.mPm.freezePackage(packageName, userId, killReason, exitInfoReason, request);
    }

    private static void updateDigest(MessageDigest digest, File file) throws IOException {
        DigestInputStream digestStream = new DigestInputStream(new FileInputStream(file), digest);
        int total = 0;
    L15:
        int length = digestStream.read();     // Catch: Throwable -> L9
        if (length == (-1)) goto L7;
        total = total + length;
        goto L15
    L7:
        digestStream.close();
        return;
    L9:
        th = move-exception;
        digestStream.close();     // Catch: Throwable -> L12
    L14:
        throw th;
    L12:
        th = move-exception;
        th.addSuppressed(th);
        goto L14
    }

    private void commitPackagesLocked(List<ReconciledPackage> reconciledPackages, int[] allUsers) {
        Iterator<ReconciledPackage> r9 = reconciledPackages.iterator();
    L4:
        if (r9.hasNext() == false) goto L51;
        ReconciledPackage reconciledPkg = r9.next();
        InstallRequest installRequest = reconciledPkg.mInstallRequest;
        ParsedPackage parsedPackage = installRequest.getParsedPackage();
        String packageName = parsedPackage.getPackageName();
        installRequest.onCommitStarted();
        if (installRequest.isInstallReplace() == false) goto L43;
        AndroidPackage oldPackage = this.mPm.mPackages.get(packageName);
        PackageStateInternal deletedPkgSetting = this.mPm.snapshotComputer().getPackageStateInternal(packageName);
        installRequest.setScannedPackageSettingFirstInstallTimeFromReplaced(deletedPkgSetting, allUsers);
        long currentTime = System.currentTimeMillis();
        installRequest.setScannedPackageSettingLastUpdateTime(currentTime);
        installRequest.setScannedPackageSettingFirstInstallTime(currentTime);
        PackageRemovedInfo r0 = installRequest.getRemovedInfo();
        r0.mBroadcastAllowList = this.mPm.mAppsFilter.getVisibilityAllowList(this.mPm.snapshotComputer(), installRequest.getScannedPackageSetting(), allUsers, this.mPm.mSettings.getPackagesLocked());
        if (installRequest.isInstallSystem() == false) goto L53;
        this.mRemovePackageHelper.removePackage(oldPackage, true);
        if (disableSystemPackageLPw(oldPackage) == true) goto L12;
        PackageRemovedInfo r1 = installRequest.getRemovedInfo();
        r1.mArgs = new CleanUpArgs(packageName, oldPackage.getPath(), InstructionSets.getAppDexInstructionSets(deletedPkgSetting.getPrimaryCpuAbi(), deletedPkgSetting.getSecondaryCpuAbi()));
        goto L43
    L12:
        installRequest.getRemovedInfo().mArgs = null;
        goto L43
    L53:
        this.mDeletePackageHelper.executeDeletePackage(reconciledPkg.mDeletePackageAction, packageName, true, allUsers, false, installRequest.isKeepArtProfile());     // Catch: SystemDeleteException -> L22
    L33:
        if (installRequest.getReturnCode() != 1) goto L43;
        PackageSetting ps2 = this.mPm.mSettings.getPackageLPr(parsedPackage.getPackageName());
        if (ps2 == null) goto L43;
        PackageRemovedInfo r2 = installRequest.getRemovedInfo();
        if (this.mPm.mPackages.get(ps2.getPackageName()) != null) goto L39;
        boolean r5 = true;
    L40:
        r2.mRemovedForAllUsers = r5;
        goto L43
    L39:
        r5 = false;
    L22:
        e = e;
    L31:
        if (this.mPm.mIsEngBuild == false) goto L33;
        throw new RuntimeException("Unexpected failure", e);
    L24:
        e = e;
    L26:
        e = e;
    L28:
        e = e;
    L43:
        AndroidPackage pkg = commitReconciledScanResultLocked(reconciledPkg, allUsers);
        updateSettingsLI(pkg, allUsers, installRequest);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);
        if (ps == null) goto L46;
        int r6 = 1;
        installRequest.setNewUsers(ps.queryInstalledUsers(allUsers, true));
        ps.setUpdateAvailable(false);
    L48:
        if (installRequest.getReturnCode() != r6) goto L50;
        this.mPm.markPackageAsArchivedIfNeeded(ps, installRequest.getArchivedPackage(), installRequest.getResponsibleInstallerTitles(), installRequest.getNewUsers());
        this.mPm.updateSequenceNumberLP(ps, installRequest.getNewUsers());
        this.mPm.updateInstantAppInstallerLocked(packageName);
        ps.setSplitNames(null);
        ps.setSplitRevisionCodes(null);
        this.mExt.modifyPackageSetting(ps, installRequest);
    L50:
        installRequest.onCommitFinished();
        goto L4
    L46:
        r6 = 1;
        goto L48
    L51:
        ApplicationPackageManager.invalidateGetPackagesForUidCache();
    }

    private boolean disableSystemPackageLPw(AndroidPackage oldPkg) {
        return this.mPm.mSettings.disableSystemPackageLPw(oldPkg.getPackageName(), true);
    }

    private void updateSettingsLI(AndroidPackage newPackage, int[] allUsers, InstallRequest installRequest) {
        updateSettingsInternalLI(newPackage, allUsers, installRequest);
    }

    private void updateSettingsInternalLI(AndroidPackage pkg, int[] allUsers, InstallRequest installRequest) {
        Trace.traceBegin(262144, "updateSettingsInternal");
        String pkgName = pkg.getPackageName();
        int[] installedForUsers = installRequest.getOriginUsers();
        int installReason = installRequest.getInstallReason();
        String installerPackageName = installRequest.getInstallerPackageName();
        int userId = installRequest.getUserId();
        int r0 = -1;
        if (userId == (-1)) goto L11;
        if (userId == (-2)) goto L11;
        if (this.mPm.mUserManager.exists(userId) == true) goto L11;
        installRequest.setError(PackageManagerException.ofInternalError("User " + userId + " doesn't exist or has been removed", -38));
        return;
    L11:
        if (pkgName == null) goto L18;
        BoostFramework mPerf = new BoostFramework();
        if (mPerf.board_first_api_lvl < 33) goto L15;
    L17:
        mPerf.perfEvent(4259, pkgName, 2, new int[]{0, 0});
        goto L18
    L15:
        if (mPerf.board_api_lvl >= 33) goto L17;
        mPerf.perfUXEngine_events(8, 0, pkgName, 0);
    L18:
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(pkgName);     // Catch: Throwable -> L102
        if (ps == null) goto L166;
        if (ps.isSystem() == false) goto L50;
        if (installedForUsers != null) goto L173;
    L39:
        if (allUsers == null) goto L44;
        if (installedForUsers == null) goto L44;
        int r1 = allUsers.length;     // Catch: Throwable -> L37
        int r14 = 0;
    L42:
        if (r14 >= r1) goto L44;
        int currentUserId = allUsers[r14];     // Catch: Throwable -> L37
        boolean installed = ArrayUtils.contains(installedForUsers, currentUserId);     // Catch: Throwable -> L37
        ps.setInstalled(installed, currentUserId);     // Catch: Throwable -> L37
        r14 = r14 + 1;     // Catch: Throwable -> L37
    L44:
        if (allUsers == null) goto L50;
        int r2 = allUsers.length;     // Catch: Throwable -> L37
        int r12 = 0;
    L46:
        if (r12 >= r2) goto L50;
        ps.resetOverrideComponentLabelIcon(allUsers[r12]);     // Catch: Throwable -> L37
        r12 = r12 + 1;
        goto L46
    L173:
    L37:
        th = th;
    L170:
        monitor-exit(r5);     // Catch: Throwable -> L100
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L26:
        if (installRequest.isApplicationEnabledSettingPersistent() == true) goto L39;
        int r15 = installedForUsers.length;     // Catch: Throwable -> L37
        int r16 = 0;
    L28:
        if (r16 >= r15) goto L39;
        int origUserId = installedForUsers[r16];     // Catch: Throwable -> L37
        if (userId == r0) goto L34;
        int origUserId2 = origUserId;
        if (userId != origUserId2) goto L36;
    L35:
        ps.setEnabled(0, origUserId2, installerPackageName);     // Catch: Throwable -> L37
    L36:
        r16 = r16 + 1;     // Catch: Throwable -> L37
        r0 = -1;
        goto L28
    L34:
        origUserId2 = origUserId;
    L50:
        if (ps.getPkgState().getUsesLibraryInfos().isEmpty() == true) goto L66;
        Iterator<SharedLibraryWrapper> r3 = ps.getPkgState().getUsesLibraryInfos().iterator();     // Catch: Throwable -> L37
    L53:
        if (r3.hasNext() == false) goto L66;
        SharedLibraryWrapper sharedLib = r3.next();     // Catch: Throwable -> L37
        int r17 = allUsers.length;     // Catch: Throwable -> L37
        int r18 = 0;
    L55:
        if (r18 >= r17) goto L53;
        int currentUserId2 = allUsers[r18];     // Catch: Throwable -> L37
        Iterator<SharedLibraryWrapper> r20 = r3;
        if (sharedLib.getType() != 1) goto L63;
        PackageSetting libPs = this.mPm.mSettings.getPackageLPr(sharedLib.getPackageName());     // Catch: Throwable -> L37
        if (libPs == null) goto L63;
        ps.setOverlayPathsForLibrary(sharedLib.getName(), libPs.getOverlayPaths(currentUserId2), currentUserId2);     // Catch: Throwable -> L37
    L63:
        r18 = r18 + 1;     // Catch: Throwable -> L37
        r17 = r17;
        r3 = r20;
        sharedLib = sharedLib;
    L66:
        if (userId == (-1)) goto L71;
        ps.setInstalled(true, userId);     // Catch: Throwable -> L37
        if (installRequest.isApplicationEnabledSettingPersistent() == true) goto L70;
        ps.setEnabled(0, userId, installerPackageName);     // Catch: Throwable -> L37
    L70:
        this.mPm.mInstallerService.mPackageArchiver.clearArchiveState(ps, userId);     // Catch: Throwable -> L37
    L91:
        this.mPm.mSettings.addInstallerPackageNames(ps.getInstallSource());     // Catch: Throwable -> L102
        Set<Integer> previousUserIds = new ArraySet();     // Catch: Throwable -> L102
        if (installRequest.getRemovedInfo() == null) goto L108;
        if (installRequest.getRemovedInfo().mInstallReasons == null) goto L108;
        int installReasonCount = installRequest.getRemovedInfo().mInstallReasons.size();     // Catch: Throwable -> L102
        int i = 0;
    L96:
        if (i >= installReasonCount) goto L108;
        int previousUserId = installRequest.getRemovedInfo().mInstallReasons.keyAt(i);     // Catch: Throwable -> L102
        int previousInstallReason = installRequest.getRemovedInfo().mInstallReasons.valueAt(i);     // Catch: Throwable -> L102
        ps.setInstallReason(previousInstallReason, previousUserId);     // Catch: Throwable -> L102
        int[] installedForUsers2 = installedForUsers;
        previousUserIds.add(Integer.valueOf(previousUserId));     // Catch: Throwable -> L100
        i = i + 1;     // Catch: Throwable -> L100
        installedForUsers = installedForUsers2;
    L108:
        if (installRequest.getRemovedInfo() == null) goto L116;
        if (installRequest.getRemovedInfo().mUninstallReasons == null) goto L116;
        int i2 = 0;
    L113:
        if (i2 >= installRequest.getRemovedInfo().mUninstallReasons.size()) goto L116;
        int previousUserId2 = installRequest.getRemovedInfo().mUninstallReasons.keyAt(i2);     // Catch: Throwable -> L100
        int previousReason = installRequest.getRemovedInfo().mUninstallReasons.valueAt(i2);     // Catch: Throwable -> L100
        ps.setUninstallReason(previousReason, previousUserId2);     // Catch: Throwable -> L100
        i2 = i2 + 1;     // Catch: Throwable -> L100
    L116:
        if (userId != (-1)) goto L126;
        int r8 = allUsers.length;     // Catch: Throwable -> L100
        int r13 = 0;
    L118:
        if (r13 >= r8) goto L128;
        int currentUserId3 = allUsers[r13];     // Catch: Throwable -> L100
        if (previousUserIds.contains(Integer.valueOf(currentUserId3)) == true) goto L124;
        if (ps.getInstalled(currentUserId3) == false) goto L124;
        ps.setInstallReason(installReason, currentUserId3);     // Catch: Throwable -> L100
    L124:
        r13 = r13 + 1;     // Catch: Throwable -> L100
    L128:
        String codePath = ps.getPathString();     // Catch: Throwable -> L100
        if (IncrementalManager.isIncrementalPath(codePath) == true) goto L131;
    L133:
        int r19 = allUsers.length;     // Catch: Throwable -> L100
        int r110 = 0;
    L134:
        if (r110 >= r19) goto L140;
        int currentUserId4 = allUsers[r110];     // Catch: Throwable -> L100
        if (ps.getInstalled(currentUserId4) == false) goto L139;
        ps.setUninstallReason(0, currentUserId4);     // Catch: Throwable -> L100
    L139:
        r110 = r110 + 1;     // Catch: Throwable -> L100
        goto L134
    L140:
        this.mPm.mSettings.writeKernelMappingLPr(ps);     // Catch: Throwable -> L100
        PermissionManagerServiceInternal.PackageInstalledParams.Builder permissionParamsBuilder = new PermissionManagerServiceInternal.PackageInstalledParams.Builder();     // Catch: Throwable -> L100
        if ((installRequest.getInstallFlags() & 256) == 0) goto L143;
        boolean grantRequestedPermissions = true;
    L144:
        if (grantRequestedPermissions == true) goto L149;
        ArrayMap<String, Integer> permissionStates = installRequest.getPermissionStates();     // Catch: Throwable -> L100
        if (permissionStates == null) goto L155;
        permissionParamsBuilder.setPermissionStates(permissionStates);     // Catch: Throwable -> L100
    L155:
        if ((installRequest.getInstallFlags() & 4194304) == 0) goto L157;
        boolean allowlistAllRestrictedPermissions = true;
    L158:
        if (allowlistAllRestrictedPermissions == false) goto L160;
        List<String> allowlistedRestrictedPermissions = new ArrayList(pkg.getRequestedPermissions());     // Catch: Throwable -> L100
    L162:
        if (allowlistedRestrictedPermissions == null) goto L164;
        permissionParamsBuilder.setAllowlistedRestrictedPermissions(allowlistedRestrictedPermissions);     // Catch: Throwable -> L100
    L164:
        int autoRevokePermissionsMode = installRequest.getAutoRevokePermissionsMode();     // Catch: Throwable -> L100
        permissionParamsBuilder.setAutoRevokePermissionsMode(autoRevokePermissionsMode);     // Catch: Throwable -> L100
        this.mPm.mPermissionManager.onPackageInstalled(pkg, installRequest.getPreviousAppId(), permissionParamsBuilder.build(), userId);     // Catch: Throwable -> L100
        goto L166
    L160:
        allowlistedRestrictedPermissions = installRequest.getAllowlistedRestrictedPermissions();     // Catch: Throwable -> L100
        goto L162
    L157:
        allowlistAllRestrictedPermissions = false;
        goto L158
    L149:
        ArrayMap<String, Integer> permissionStates2 = new ArrayMap();     // Catch: Throwable -> L100
        Iterator r111 = pkg.getRequestedPermissions().iterator();     // Catch: Throwable -> L100
    L151:
        if (r111.hasNext() == false) goto L153;
        String permissionName = (String) r111.next();     // Catch: Throwable -> L100
        permissionStates2.put(permissionName, 1);     // Catch: Throwable -> L100
        previousUserIds = previousUserIds;
        goto L151
    L153:
        permissionParamsBuilder.setPermissionStates(permissionStates2);     // Catch: Throwable -> L100
        goto L155
    L143:
        grantRequestedPermissions = false;
        goto L144
    L131:
        if (this.mIncrementalManager == null) goto L133;
        this.mIncrementalManager.registerLoadingProgressCallback(codePath, new IncrementalProgressListener(ps.getPackageName(), this.mPm));     // Catch: Throwable -> L100
        goto L133
    L126:
        if (previousUserIds.contains(Integer.valueOf(userId)) == true) goto L128;
        ps.setInstallReason(installReason, userId);     // Catch: Throwable -> L100
        goto L128
    L71:
        if (allUsers == null) goto L91;
        int r4 = allUsers.length;     // Catch: Throwable -> L37
        int r112 = 0;
    L73:
        if (r112 >= r4) goto L91;
        int currentUserId5 = allUsers[r112];     // Catch: Throwable -> L37
        boolean installedForCurrentUser = ArrayUtils.contains(installedForUsers, currentUserId5);     // Catch: Throwable -> L37
        int r113 = r4;
        if (this.mPm.isUserRestricted(currentUserId5, "no_install_apps") == false) goto L77;
    L80:
        boolean restrictedByPolicy = true;
    L82:
        if (installedForCurrentUser == true) goto L86;
        if (restrictedByPolicy == false) goto L86;
        ps.setInstalled(false, currentUserId5);     // Catch: Throwable -> L37
    L90:
        r112 = r112 + 1;
        r4 = r113;
    L86:
        ps.setInstalled(true, currentUserId5);     // Catch: Throwable -> L37
        if (installRequest.isApplicationEnabledSettingPersistent() == true) goto L89;
        ps.setEnabled(0, currentUserId5, installerPackageName);     // Catch: Throwable -> L37
    L89:
        this.mPm.mInstallerService.mPackageArchiver.clearArchiveState(ps, currentUserId5);     // Catch: Throwable -> L37
        goto L90
    L77:
        if (this.mPm.isUserRestricted(currentUserId5, "no_debugging_features") == true) goto L80;
        restrictedByPolicy = false;
    L166:
        installRequest.setName(pkgName);     // Catch: Throwable -> L100
        installRequest.setAppId(pkg.getUid());     // Catch: Throwable -> L100
        installRequest.setPkg(pkg);     // Catch: Throwable -> L100
        installRequest.setReturnCode(1);     // Catch: Throwable -> L100
        Trace.traceBegin(262144, "writeSettings");     // Catch: Throwable -> L100
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L100
        Trace.traceEnd(262144);     // Catch: Throwable -> L100
        monitor-exit(r5);     // Catch: Throwable -> L100
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Trace.traceEnd(262144);
        return;
    L100:
        th = th;
    L102:
        th = th;
        goto L170
    }

    private void setAccessRestrictedSettingsMode(String pkgName, int appId, int userId, int mode) {
        AppOpsManager appOpsManager = (AppOpsManager) this.mPm.mContext.getSystemService(AppOpsManager.class);
        int uid = UserHandle.getUid(userId, appId);
        appOpsManager.setMode(119, uid, pkgName, mode);
    }

    private void executePostCommitStepsLIF(List<ReconciledPackage> reconciledPackages) {
        ArraySet<IncrementalStorage> incrementalStorages = new ArraySet();
        Iterator<ReconciledPackage> r1 = reconciledPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        ReconciledPackage reconciledPkg = r1.next();
        InstallRequest installRequest = reconciledPkg.mInstallRequest;
        final PackageSetting ps = installRequest.getScannedPackageSetting();
        String packageName = ps.getPackageName();
        String codePath = ps.getPathString();
        AndroidPackageInternal r7 = ps.getPkg();
        if (this.mIncrementalManager != null) goto L8;
    L10:
        boolean onIncremental = false;
    L12:
        if (onIncremental == false) goto L19;
        IncrementalStorage storage = this.mIncrementalManager.openStorage(codePath);
        if (storage == null) goto L17;
        incrementalStorages.add(storage);
        goto L19
    L17:
        throw new IllegalArgumentException("Install: null storage for incremental package " + packageName);
    L19:
        if (installRequest.isInstallReplace() == false) goto L22;
        if (r7 == null) goto L22;
        this.mDexManager.notifyPackageUpdated(packageName, r7.getBaseApkPath(), r7.getSplitCodePaths());
    L22:
        int[] usersToPrepare = Arrays.stream(installRequest.getNewUsers()).filter(new InstallPackageHelper$$ExternalSyntheticLambda4(this, ps)).toArray();
        logPostCommitAppDataFallbackState(ps, installRequest.getNewUsers(), usersToPrepare);
        if (usersToPrepare.length <= 0) goto L25;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "executePostCommitStepsLIF: usersToPrepare=" + Arrays.toString(usersToPrepare) + " packageName= " + ps.getPackageName());
        this.mAppDataHelper.prepareAppDataPostCommitLIF(ps, 0, usersToPrepare);
    L25:
        this.mPm.getObricExt().clearObricAssistPermission(packageName, ps.getAppId());
        goto L4
    L8:
        if (IncrementalManager.isIncrementalPath(codePath) == false) goto L10;
        onIncremental = true;
        goto L12
    L26:
        PackageManagerServiceUtils.waitForNativeBinariesExtractionForIncremental(incrementalStorages);
    }

    private /* synthetic */ boolean lambda$executePostCommitStepsLIF$6(PackageSetting ps, int userId) {
        return shouldPrepareAppDataAfterCommit(ps, userId);
    }

    Pair<Integer, String> verifyReplacingVersionCode(PackageInfoLite pkgLite, long requiredInstalledVersionCode, int installFlags) {
        if ((131072 & installFlags) != 0) goto L5;
        String packageName = pkgLite.packageName;
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        PackageSetting dataOwnerPs = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L16
        if (dataOwnerPs == null) goto L11;
        AndroidPackage dataOwnerPkg = dataOwnerPs.getPkg();     // Catch: Throwable -> L16
        if (requiredInstalledVersionCode == (-1)) goto L36;
        if (dataOwnerPkg != null) goto L30;
        String errorMsg = "Required installed version code was " + requiredInstalledVersionCode + " but package is not installed";     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg);     // Catch: Throwable -> L16
        Pair<Integer, String> r4 = Pair.create(-121, errorMsg);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r4;
    L30:
        if (dataOwnerPkg.getLongVersionCode() == requiredInstalledVersionCode) goto L36;
        String errorMsg2 = "Required installed version code was " + requiredInstalledVersionCode + " but actual installed version is " + dataOwnerPkg.getLongVersionCode();     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg2);     // Catch: Throwable -> L16
        Pair<Integer, String> r5 = Pair.create(-121, errorMsg2);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r5;
    L36:
        if (dataOwnerPkg != null) goto L47;
        if (PackageManagerServiceUtils.isDowngradePermitted(installFlags, dataOwnerPs.isDebuggable()) == false) goto L82;
    L73:
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return Pair.create(1, null);
    L82:
        PackageManagerServiceUtils.checkDowngrade(dataOwnerPs, pkgLite);     // Catch: Throwable -> L16 PackageManagerException -> L41
    L41:
        e = move-exception;
        String errorMsg3 = "Downgrade detected on app uninstalled with DELETE_KEEP_DATA: " + e.getMessage();     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg3);     // Catch: Throwable -> L16
        Pair<Integer, String> r6 = Pair.create(-25, errorMsg3);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r6;
    L47:
        if (dataOwnerPkg.isSdkLibrary() == true) goto L73;
        if (PackageManagerServiceUtils.isDowngradePermitted(installFlags, dataOwnerPkg.isDebuggable()) == true) goto L58;
        PackageManagerServiceUtils.checkDowngrade(dataOwnerPkg, pkgLite);     // Catch: Throwable -> L16 PackageManagerException -> L52
    L52:
        e = move-exception;
        String errorMsg4 = "Downgrade detected: " + e.getMessage();     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg4);     // Catch: Throwable -> L16
        Pair<Integer, String> r7 = Pair.create(-25, errorMsg4);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r7;
    L58:
        if (dataOwnerPs.isSystem() == false) goto L73;
        PackageSetting disabledPs = this.mPm.mSettings.getDisabledSystemPkgLPr(dataOwnerPs);     // Catch: Throwable -> L16
        if (disabledPs == null) goto L63;
        dataOwnerPkg = disabledPs.getPkg();     // Catch: Throwable -> L16
    L63:
        if (Build.IS_DEBUGGABLE == true) goto L73;
        if (dataOwnerPkg.isDebuggable() == true) goto L73;
        PackageManagerServiceUtils.checkDowngrade(dataOwnerPkg, pkgLite);     // Catch: Throwable -> L16 PackageManagerException -> L68
    L68:
        e = move-exception;
        String errorMsg5 = "System app: " + packageName + " cannot be downgraded to older than its preloaded version on the system image. " + e.getMessage();     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg5);     // Catch: Throwable -> L16
        Pair<Integer, String> r8 = Pair.create(-25, errorMsg5);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r8;
    L11:
        if (requiredInstalledVersionCode == (-1)) goto L18;
        String errorMsg6 = "Required installed version code was " + requiredInstalledVersionCode + " but package is not installed";     // Catch: Throwable -> L16
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg6);     // Catch: Throwable -> L16
        Pair<Integer, String> r9 = Pair.create(-121, errorMsg6);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r9;
    L18:
        Pair<Integer, String> r3 = Pair.create(1, null);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        return verifyReplacingVersionCodeForApex(pkgLite, requiredInstalledVersionCode, installFlags);
    }

    private Pair<Integer, String> verifyReplacingVersionCodeForApex(PackageInfoLite pkgLite, long requiredInstalledVersionCode, int installFlags) {
        String packageName = pkgLite.packageName;
        boolean isAppDebuggable = false;
        PackageInfo activePackage = this.mPm.snapshotComputer().getPackageInfo(packageName, 1073741824, 0);
        if (activePackage != null) goto L6;
        String errorMsg = "Attempting to install new APEX package " + packageName;
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg);
        return Pair.create(-23, errorMsg);
    L6:
        long activeVersion = activePackage.getLongVersionCode();
        if (requiredInstalledVersionCode == (-1)) goto L13;
        if (activeVersion == requiredInstalledVersionCode) goto L13;
        String errorMsg2 = "Installed version of APEX package " + packageName + " does not match required. Active version: " + activeVersion + " required: " + requiredInstalledVersionCode;
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg2);
        return Pair.create(-121, errorMsg2);
    L13:
        if ((activePackage.applicationInfo.flags & 2) == 0) goto L15;
        isAppDebuggable = true;
    L15:
        long newVersionCode = pkgLite.getLongVersionCode();
        if (PackageManagerServiceUtils.isDowngradePermitted(installFlags, isAppDebuggable) == true) goto L22;
        if (newVersionCode >= activeVersion) goto L22;
        String errorMsg3 = "Downgrade of APEX package " + packageName + " is not allowed. Active version: " + activeVersion + " attempted: " + newVersionCode;
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg3);
        return Pair.create(-25, errorMsg3);
    L22:
        return Pair.create(1, null);
    }

    int getUidForVerifier(VerifierInfo verifierInfo) {
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        AndroidPackage pkg = this.mPm.mPackages.get(verifierInfo.packageName);     // Catch: Throwable -> L9
        if (pkg != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L12:
        if (pkg.getSigningDetails().getSignatures().length == 1) goto L35;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Verifier package " + verifierInfo.packageName + " has more than one signature; ignoring");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L35:
        Signature verifierSig = pkg.getSigningDetails().getSignatures()[0];     // Catch: Throwable -> L9 CertificateException -> L28
        PublicKey publicKey = verifierSig.getPublicKey();     // Catch: Throwable -> L9 CertificateException -> L28
        byte[] expectedPublicKey = publicKey.getEncoded();     // Catch: Throwable -> L9 CertificateException -> L28
        byte[] actualPublicKey = verifierInfo.publicKey.getEncoded();     // Catch: Throwable -> L9
        if (Arrays.equals(actualPublicKey, expectedPublicKey) == true) goto L24;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Verifier package " + verifierInfo.packageName + " does not have the expected public key; ignoring");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L24:
        int r2 = pkg.getUid();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r2;
    L30:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void sendPendingBroadcasts(String reasonForTrace, int callingUidForTrace) {
        int numBroadcasts = 0;
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        SparseArray<ArrayMap<String, ArrayList<String>>> userIdToPackagesToComponents = this.mPm.mPendingBroadcasts.copiedMap();     // Catch: Throwable -> L7
        int numUsers = userIdToPackagesToComponents.size();     // Catch: Throwable -> L7
        int n = 0;
    L5:
        if (n >= numUsers) goto L10;
        numBroadcasts = numBroadcasts + userIdToPackagesToComponents.valueAt(n).size();     // Catch: Throwable -> L7
        n = n + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        if (numBroadcasts != 0) goto L14;
        monitor-exit(r3);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        String[] packages = new String[numBroadcasts];     // Catch: Throwable -> L7
        ArrayList<String>[] components = new ArrayList[numBroadcasts];     // Catch: Throwable -> L7
        int[] uids = new int[numBroadcasts];     // Catch: Throwable -> L7
        int i = 0;
        int n2 = 0;
    L15:
        if (n2 >= numUsers) goto L24;
        int packageUserId = userIdToPackagesToComponents.keyAt(n2);     // Catch: Throwable -> L7
        ArrayMap<String, ArrayList<String>> componentsToBroadcast = userIdToPackagesToComponents.valueAt(n2);     // Catch: Throwable -> L7
        int numComponents = CollectionUtils.size(componentsToBroadcast);     // Catch: Throwable -> L7
        int index = 0;
    L17:
        if (index >= numComponents) goto L23;
        packages[i] = componentsToBroadcast.keyAt(index);     // Catch: Throwable -> L7
        components[i] = componentsToBroadcast.valueAt(index);     // Catch: Throwable -> L7
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packages[i]);     // Catch: Throwable -> L7
        if (ps == null) goto L21;
        int r15 = UserHandle.getUid(packageUserId, ps.getAppId());     // Catch: Throwable -> L7
    L22:
        uids[i] = r15;     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        index = index + 1;     // Catch: Throwable -> L7
        goto L17
    L21:
        r15 = -1;
        goto L22
    L23:
        n2 = n2 + 1;     // Catch: Throwable -> L7
        goto L15
    L24:
        int numBroadcasts2 = i;
        this.mPm.mPendingBroadcasts.clear();     // Catch: Throwable -> L7
        monitor-exit(r3);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Computer snapshot = this.mPm.snapshotComputer();
        int i2 = 0;
    L27:
        if (i2 >= numBroadcasts2) goto L30;
        this.mBroadcastHelper.sendPackageChangedBroadcast(snapshot, packages[i2], true, components[i2], uids[i2], null, reasonForTrace, callingUidForTrace);
        i2 = i2 + 1;
        goto L27
    L30:
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    void handlePackagePostInstall(InstallRequest request, boolean launchedForRestore) {
        if ((request.getInstallFlags() & 4096) != 0) goto L5;
        boolean killApp = true;
    L7:
        if (request.getReturnCode() != 1) goto L9;
        boolean r0 = true;
    L10:
        boolean succeeded = r0;
        boolean update = request.isUpdate();
        boolean archived = request.isArchived();
        String packageName = request.getName();
        Computer snapshot = this.mPm.snapshotComputer();
        CleanUpArgs r1 = null;
        if (succeeded == false) goto L13;
        PackageStateInternal r3 = snapshot.getPackageStateInternal(packageName);
    L14:
        PackageStateInternal pkgSetting = r3;
        if (pkgSetting != null) goto L17;
    L22:
        boolean r4 = true;
    L23:
        boolean removedBeforeUpdate = r4;
        if (succeeded == false) goto L28;
        if (removedBeforeUpdate == false) goto L28;
        Slog.e(PackageManagerServiceMonitorEx.TAG, packageName + " was removed before handlePackagePostInstall could be executed");
        request.setReturnCode(-23);
        request.setReturnMessage("Package was removed before install could complete.");
        this.mRemovePackageHelper.cleanUpResources(packageName, request.getOldCodeFile(), request.getOldInstructionSet());
        this.mPm.notifyInstallObserver(request);
        return;
    L28:
        if (succeeded == false) goto L85;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "installation completed for package:" + packageName + ". Final code path: " + pkgSetting.getPath().getPath());
        if (pkgSetting.getAppMetadataSource() == 1) goto L32;
    L45:
        this.mPm.mPerUidReadTimeoutsCache = null;
        this.mPm.notifyInstantAppPackageInstalled(request.getPkg().getPackageName(), request.getNewUsers());
        int[] firstUserIds = request.getFirstTimeBroadcastUserIds();
        if (request.getPkg().getStaticSharedLibraryName() != null) goto L48;
        this.mPm.mProcessLoggingHandler.invalidateBaseApkHash(request.getPkg().getBaseApkPath());
    L48:
        BroadcastHelper r2 = this.mBroadcastHelper;
        PackageManagerService r7 = this.mPm;
        r7.getClass();
        r2.sendPostInstallBroadcasts(new DistractingPackageHelper$$ExternalSyntheticLambda1(r7), request, packageName, this.mPm.mRequiredPermissionControllerPackage, this.mPm.mRequiredVerifierPackages, this.mPm.mRequiredInstallerPackage, this.mPm, launchedForRestore, killApp, update, archived);
        if (request.isAllNewUsers() == false) goto L52;
        if (update == true) goto L52;
        this.mPm.notifyPackageAdded(packageName, request.getAppId());
    L53:
        EventLog.writeEvent(EventLogTags.UNKNOWN_SOURCES_ENABLED, getUnknownSourcesSettings());
        if (request.getRemovedInfo() == null) goto L57;
        r1 = request.getRemovedInfo().mArgs;
    L57:
        CleanUpArgs args = r1;
        if (args == null) goto L74;
        if (killApp == true) goto L73;
        this.mPm.scheduleDeferredNoKillPostDelete(args);
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        PackageManagerServiceUtils.linkFilesToOldDirs(this.mPm.mInstaller, packageName, pkgSetting.getPath(), pkgSetting.getOldPaths());     // Catch: Throwable -> L65
        if (installLock == null) goto L75;
        installLock.close();
    L75:
        if (archived == true) goto L83;
        int r5 = firstUserIds.length;
        int r6 = 0;
    L78:
        if (r6 >= r5) goto L85;
        int userId = firstUserIds[r6];
        PackageInfo info = snapshot.getPackageInfo(packageName, 0, userId);
        if (info == null) goto L82;
        this.mDexManager.notifyPackageInstalled(info, userId);
    L82:
        r6 = r6 + 1;
        goto L78
    L83:
        PackageRemovedInfo info2 = new PackageRemovedInfo();
        info2.mRemovedPackage = packageName;
        info2.mInstallerPackageName = request.getInstallerPackageName();
        info2.mRemovedUsers = firstUserIds;
        info2.mBroadcastUsers = firstUserIds;
        info2.mUid = request.getAppId();
        info2.mRemovedPackageVersionCode = request.getPkg().getLongVersionCode();
        info2.mRemovedForAllUsers = true;
        this.mBroadcastHelper.sendPackageRemovedBroadcasts(info2, this.mPm, false, false, true);
    L65:
        th = move-exception;
        if (installLock == null) goto L107;
        installLock.close();     // Catch: Throwable -> L70
        throw th;
    L70:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L107:
        throw th;
    L73:
        this.mRemovePackageHelper.cleanUpResources(packageName, args.getCodeFile(), args.getInstructionSets());
        goto L75
    L74:
        VMRuntime.getRuntime().requestConcurrentGC();
    L52:
        this.mPm.notifyPackageChanged(packageName, request.getAppId());
        goto L53
    L32:
        if (PackageManagerServiceUtils.extractAppMetadataFromApk(request.getPkg(), pkgSetting.getAppMetadataFilePath(), pkgSetting.isSystem()) == true) goto L45;
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        PackageSetting setting = this.mPm.mSettings.getPackageLPr(packageName);     // Catch: Throwable -> L38
        if (setting == null) goto L40;
        setting.setAppMetadataFilePath(null).setAppMetadataSource(0);     // Catch: Throwable -> L38
    L40:
        monitor-exit(r8);     // Catch: Throwable -> L38
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L38:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L85:
        if (succeeded == false) goto L88;
        if (update == false) goto L88;
        boolean deferInstallObserver = true;
    L89:
        if (deferInstallObserver == false) goto L93;
        if (killApp == false) goto L92;
        this.mPm.scheduleDeferredPendingKillInstallObserver(request);
    L94:
        this.mPm.schedulePruneUnusedStaticSharedLibraries(true);
        if (request.getTraceMethod() == null) goto L109;
        Trace.asyncTraceEnd(262144, request.getTraceMethod(), request.getTraceCookie());
        return;
    L109:
        return;
    L92:
        this.mPm.scheduleDeferredNoKillInstallObserver(request);
        goto L94
    L93:
        this.mPm.notifyInstallObserver(request);
    L88:
        deferInstallObserver = false;
        goto L89
    L17:
        if (pkgSetting.isSystem() == true) goto L19;
    L21:
        r4 = false;
        goto L23
    L19:
        if (pkgSetting.getPath().getPath().equals(request.getPkg().getPath()) == true) goto L21;
    L13:
        r3 = null;
        goto L14
    L9:
        r0 = false;
        goto L10
    L5:
        killApp = false;
        goto L7
    }

    private /* synthetic */ void lambda$handlePackagePostInstall$7(int[] firstUserIds, String packageName, int appId) {
        int r0 = firstUserIds.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = firstUserIds[r1];
        setAccessRestrictedSettingsMode(packageName, appId, userId, 2);
        r1 = r1 + 1;
        goto L3
    }

    private int getUnknownSourcesSettings() {
        return android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "install_non_market_apps", -1, 0);
    }

    void installSystemStubPackages(List<String> systemStubPackageNames, int scanFlags) {
        int i = systemStubPackageNames.size();
    L3:
        i = i - 1;
        if (i < 0) goto L21;
        String packageName = systemStubPackageNames.get(i);
        if (this.mPm.mSettings.isDisabledSystemPackageLPr(packageName) == false) goto L8;
        systemStubPackageNames.remove(i);
        goto L3
    L8:
        AndroidPackage pkg = this.mPm.mPackages.get(packageName);
        if (pkg != null) goto L11;
        systemStubPackageNames.remove(i);
        goto L3
    L11:
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);
        if (ps == null) goto L26;
        int enabledState = ps.getEnabled(0);
        if (enabledState != 3) goto L26;
        systemStubPackageNames.remove(i);
    L26:
        installStubPackageLI(pkg, 0, scanFlags);     // Catch: PackageManagerException -> L18
        ps.setEnabled(0, 0, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: PackageManagerException -> L18
        systemStubPackageNames.remove(i);     // Catch: PackageManagerException -> L18
    L18:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to parse uncompressed system package: " + e.getMessage());
        goto L3
    L21:
        int i2 = systemStubPackageNames.size();
        int i3 = i2 - 1;
    L22:
        if (i3 < 0) goto L25;
        String pkgName = systemStubPackageNames.get(i3);
        this.mPm.mSettings.getPackageLPr(pkgName).setEnabled(2, 0, PackageManagerService.PLATFORM_PACKAGE_NAME);
        PackageManagerServiceUtils.logCriticalInfo(6, "Stub disabled; pkg: " + pkgName);
        i3 = i3 + (-1);
        goto L22
    }

    boolean enableCompressedPackage(AndroidPackage stubPkg, PackageSetting stubPkgSetting) {
        int parseFlags = (this.mPm.getDefParseFlags() | Integer.MIN_VALUE) | 64;
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();
        PackageFreezer freezer = this.mPm.freezePackage(stubPkg.getPackageName(), -1, "setEnabledSetting", 16, null);     // Catch: Throwable -> L19 PackageManagerException -> L21
        AndroidPackage pkg = installStubPackageLI(stubPkg, parseFlags, 0);     // Catch: Throwable -> L28
        this.mAppDataHelper.prepareAppDataAfterInstallLIF(pkg);     // Catch: Throwable -> L28
        PackageManagerTracedLock r12 = this.mPm.mLock;     // Catch: Throwable -> L28
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L28
        monitor-enter(r12);     // Catch: Throwable -> L28
        this.mSharedLibraries.updateSharedLibraries(pkg, stubPkgSetting, null, null, Collections.unmodifiableMap(this.mPm.mPackages));     // Catch: Throwable -> L9 PackageManagerException -> L11
    L13:
        this.mPm.mPermissionManager.onPackageInstalled(pkg, -1, PermissionManagerServiceInternal.PackageInstalledParams.DEFAULT, -1);     // Catch: Throwable -> L9
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L28
        if (freezer == null) goto L24;
        freezer.close();     // Catch: Throwable -> L19 PackageManagerException -> L21
    L24:
        this.mAppDataHelper.clearAppDataLIF(pkg, -1, 39);     // Catch: Throwable -> L19
        this.mDexManager.notifyPackageUpdated(pkg.getPackageName(), pkg.getBaseApkPath(), pkg.getSplitCodePaths());     // Catch: Throwable -> L19
        if (installLock == null) goto L27;
        installLock.close();
    L27:
        return true;
    L11:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "updateAllSharedLibrariesLPw failed: ", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        if (freezer == null) goto L144;
        freezer.close();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L19 PackageManagerException -> L21
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19 PackageManagerException -> L21
        throw th;     // Catch: Throwable -> L19 PackageManagerException -> L21
    L144:
        throw th;     // Catch: Throwable -> L19 PackageManagerException -> L21
    L129:
        PackageFreezer freezer2 = this.mPm.freezePackage(stubPkg.getPackageName(), -1, "setEnabledSetting", 16, null);     // Catch: Throwable -> L51 PackageManagerException -> L53
        PackageManagerTracedLock r8 = this.mPm.mLock;     // Catch: Throwable -> L69
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L69
        monitor-enter(r8);     // Catch: Throwable -> L69
        this.mPm.mSettings.enableSystemPackageLPw(stubPkg.getPackageName());     // Catch: Throwable -> L71
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L69
        installPackageFromSystemLIF(stubPkg.getPath(), this.mPm.mUserManager.getUserIds(), null, true);     // Catch: Throwable -> L69
        if (freezer2 == null) goto L55;
        freezer2.close();     // Catch: Throwable -> L51 PackageManagerException -> L53
    L55:
        PackageManagerTracedLock r3 = this.mPm.mLock;     // Catch: Throwable -> L19
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r3);     // Catch: Throwable -> L19
        PackageSetting stubPs = this.mPm.mSettings.getPackageLPr(stubPkg.getPackageName());     // Catch: Throwable -> L60
        if (stubPs == null) goto L62;
        stubPs.setEnabled(2, 0, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L60
    L62:
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L60
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
    L96:
        if (installLock == null) goto L98;
        installLock.close();
    L98:
        return false;
    L60:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L71:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        if (freezer2 == null) goto L148;
        freezer2.close();     // Catch: Throwable -> L78
        throw th;     // Catch: Throwable -> L51 PackageManagerException -> L53
    L78:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L51 PackageManagerException -> L53
        throw th;     // Catch: Throwable -> L51 PackageManagerException -> L53
    L148:
        throw th;     // Catch: Throwable -> L51 PackageManagerException -> L53
    L53:
        pme = move-exception;
        Slog.wtf(PackageManagerServiceMonitorEx.TAG, "Failed to restore system package:" + stubPkg.getPackageName(), pme);     // Catch: Throwable -> L51
        PackageManagerTracedLock r4 = this.mPm.mLock;     // Catch: Throwable -> L19
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r4);     // Catch: Throwable -> L19
        PackageSetting stubPs2 = this.mPm.mSettings.getPackageLPr(stubPkg.getPackageName());     // Catch: Throwable -> L89
        if (stubPs2 == null) goto L91;
        stubPs2.setEnabled(2, 0, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L89
    L91:
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L89
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        goto L96
    L89:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L51:
        th = move-exception;
        PackageManagerTracedLock r5 = this.mPm.mLock;     // Catch: Throwable -> L19
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        monitor-enter(r5);     // Catch: Throwable -> L19
        PackageSetting stubPs3 = this.mPm.mSettings.getPackageLPr(stubPkg.getPackageName());     // Catch: Throwable -> L106
        if (stubPs3 == null) goto L108;
        stubPs3.setEnabled(2, 0, PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L106
    L108:
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L106
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L106:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        if (installLock == null) goto L150;
        installLock.close();     // Catch: Throwable -> L118
        throw th;
    L118:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L150:
        throw th;
    }

    private AndroidPackage installStubPackageLI(AndroidPackage stubPkg, int parseFlags, int scanFlags) throws PackageManagerException {
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L5;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Uncompressing system stub; pkg: " + stubPkg.getPackageName());
    L5:
        File scanFile = decompressPackage(stubPkg.getPackageName(), stubPkg.getPath());
        if (scanFile == null) goto L22;
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mPm.mSettings.disableSystemPackageLPw(stubPkg.getPackageName(), true);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mRemovePackageHelper.removePackage(stubPkg, true);
        return initPackageTracedLI(scanFile, parseFlags, scanFlags);
    L14:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to install compressed system package:" + stubPkg.getPackageName(), e);
        this.mRemovePackageHelper.removeCodePath(scanFile);
        throw e;
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L22:
        throw PackageManagerException.ofInternalError("Unable to decompress stub at " + stubPkg.getPath(), -11);
    }

    private File decompressPackage(String packageName, String codePath) {
        if (PackageManagerServiceUtils.compressedFileExists(codePath) == false) goto L5;
        File dstCodePath = PackageManagerServiceUtils.getNextCodePath(Environment.getDataAppDirectory(null), packageName);
        int ret = PackageManagerServiceUtils.decompressFiles(codePath, dstCodePath, packageName);
        if (ret != 1) goto L11;
        ret = PackageManagerServiceUtils.extractNativeBinaries(dstCodePath, packageName);
    L11:
        if (ret != 1) goto L21;
        if (this.mPm.isSystemReady() == false) goto L15;
        ContentResolver resolver = this.mContext.getContentResolver();
        F2fsUtils.releaseCompressedBlocks(resolver, dstCodePath);
    L19:
        return dstCodePath;
    L15:
        if (this.mPm.mReleaseOnSystemReady != null) goto L17;
        this.mPm.mReleaseOnSystemReady = new ArrayList();
    L17:
        this.mPm.mReleaseOnSystemReady.add(dstCodePath);
        goto L19
    L21:
        if (dstCodePath.exists() == true) goto L23;
        return null;
    L23:
        this.mRemovePackageHelper.removeCodePath(dstCodePath);
        return null;
    L5:
        if (PackageManagerService.DEBUG_COMPRESSION == false) goto L7;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "No files to decompress at: " + codePath);
    L7:
        return null;
    }

    public void restoreDisabledSystemPackageLIF(DeletePackageAction action, int[] allUserHandles, boolean writeSettings) throws SystemDeleteException {
        final PackageSetting deletedPs = action.mDeletingPs;
        PackageRemovedInfo outInfo = action.mRemovedInfo;
        final PackageSetting disabledPs = action.mDisabledPs;
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        this.mPm.mSettings.enableSystemPackageLPw(disabledPs.getPkg().getPackageName());     // Catch: Throwable -> L55
        PackageManagerServiceUtils.removeNativeBinariesLI(deletedPs);     // Catch: Throwable -> L55
        monitor-exit(r3);     // Catch: Throwable -> L55
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Re-installing system package: " + disabledPs);
        if (outInfo != null) goto L68;
        final int[] origUsers = null;
    L10:
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: Throwable -> L14 PackageManagerException -> L16
        installPackageFromSystemLIF(disabledPs.getPathString(), allUserHandles, origUsers, writeSettings);     // Catch: Throwable -> L32
        if (installLock == null) goto L18;
        installLock.close();     // Catch: Throwable -> L14 PackageManagerException -> L16
    L18:
        if (origUsers == null) goto L21;
        this.mPm.commitPackageStateMutation(null, new InstallPackageHelper$$ExternalSyntheticLambda5(origUsers, disabledPs, deletedPs));     // Catch: Throwable -> L14 PackageManagerException -> L16
    L21:
        if (disabledPs.getPkg().isStub() == false) goto L31;
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        disableStubPackage(action, deletedPs, allUserHandles);     // Catch: Throwable -> L27
        monitor-exit(r4);     // Catch: Throwable -> L27
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L27:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L31:
        return;
    L32:
        th = move-exception;
        if (installLock != null) goto L69;
    L39:
        throw th;     // Catch: Throwable -> L14 PackageManagerException -> L16
    L69:
        installLock.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14 PackageManagerException -> L16
        goto L39
    L68:
        origUsers = outInfo.mOrigUsers;     // Catch: Throwable -> L14 PackageManagerException -> L16
    L16:
        e = move-exception;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Failed to restore system package:" + deletedPs.getPackageName() + ": " + e.getMessage());     // Catch: Throwable -> L14
        throw new SystemDeleteException(e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (disabledPs.getPkg().isStub() == false) goto L54;
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        disableStubPackage(action, deletedPs, allUserHandles);     // Catch: Throwable -> L50
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L50:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L54:
        throw th;
    L55:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$restoreDisabledSystemPackageLIF$8(int[] origUsers, PackageSetting disabledPs, PackageSetting deletedPs, PackageStateMutator mutator) {
        int r0 = origUsers.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = origUsers[r1];
        mutator.forPackage(disabledPs.getPackageName()).userState(userId).setOverlayPaths(deletedPs.getOverlayPaths(userId));
        r1 = r1 + 1;
        goto L3
    }

    private void disableStubPackage(DeletePackageAction action, PackageSetting deletedPs, int[] allUserHandles) {
        PackageSetting stubPs = this.mPm.mSettings.getPackageLPr(deletedPs.getPackageName());
        if (stubPs != null) goto L5;
        return;
    L5:
        if (action.mUser != null) goto L7;
        int userId = -1;
    L9:
        if (userId != (-1)) goto L14;
        int r2 = allUserHandles.length;
        int r5 = 0;
    L12:
        if (r5 >= r2) goto L20;
        int aUserId = allUserHandles[r5];
        stubPs.setEnabled(2, aUserId, PackageManagerService.PLATFORM_PACKAGE_NAME);
        r5 = r5 + 1;
        goto L12
    L20:
        return;
    L14:
        if (userId < 0) goto L19;
        stubPs.setEnabled(2, userId, PackageManagerService.PLATFORM_PACKAGE_NAME);
        return;
    L19:
        return;
    L7:
        userId = action.mUser.getIdentifier();
        goto L9
    }

    private void installPackageFromSystemLIF(String codePathString, int[] allUserHandles, int[] origUserHandles, boolean writeSettings) throws PackageManagerException {
        File codePath = new File(codePathString);
        int parseFlags = (this.mPm.getDefParseFlags() | 1) | 16;
        int scanFlags = this.mPm.getSystemPackageScanFlags(codePath);
        AndroidPackage pkg = initPackageTracedLI(codePath, parseFlags, scanFlags);
        PackageManagerTracedLock r10 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
        PackageSetting pkgSetting = this.mPm.mSettings.getPackageLPr(pkg.getPackageName());     // Catch: Throwable -> L7
        this.mSharedLibraries.updateSharedLibraries(pkg, pkgSetting, null, null, Collections.unmodifiableMap(this.mPm.mPackages));     // Catch: Throwable -> L7 PackageManagerException -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        setPackageInstalledForSystemPackage(pkg, allUserHandles, origUserHandles, writeSettings);
        this.mAppDataHelper.prepareAppDataAfterInstallLIF(pkg);
        return;
    L9:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "updateAllSharedLibrariesLPw failed: " + e.getMessage());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void setPackageInstalledForSystemPackage(AndroidPackage pkg, int[] allUserHandles, int[] origUserHandles, boolean writeSettings) {
        PackageManagerTracedLock r3 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(pkg.getPackageName());     // Catch: Throwable -> L17
        if (origUserHandles == null) goto L7;
        boolean applyUserRestrictions = true;
    L8:
        if (applyUserRestrictions == false) goto L23;
        boolean installedStateChanged = false;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Propagating install state across reinstall");     // Catch: Throwable -> L17
        int r7 = allUserHandles.length;     // Catch: Throwable -> L17
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L20;
        int userId = allUserHandles[r8];     // Catch: Throwable -> L17
        boolean installed = ArrayUtils.contains(origUserHandles, userId);     // Catch: Throwable -> L17
        Slog.d(PackageManagerServiceMonitorEx.TAG, "    user " + userId + " => " + installed);     // Catch: Throwable -> L17
        if (installed == ps.getInstalled(userId)) goto L14;
        installedStateChanged = true;
    L14:
        ps.setInstalled(installed, userId);     // Catch: Throwable -> L17
        if (installed == false) goto L19;
        ps.setUninstallReason(0, userId);     // Catch: Throwable -> L17
    L19:
        r8 = r8 + 1;     // Catch: Throwable -> L17
        goto L10
    L20:
        this.mPm.mSettings.writeAllUsersPackageRestrictionsLPr();     // Catch: Throwable -> L17
        if (installedStateChanged == false) goto L23;
        this.mPm.mSettings.writeKernelMappingLPr(ps);     // Catch: Throwable -> L17
    L23:
        this.mPm.mPermissionManager.onPackageInstalled(pkg, -1, PermissionManagerServiceInternal.PackageInstalledParams.DEFAULT, -1);     // Catch: Throwable -> L17
        int r6 = allUserHandles.length;     // Catch: Throwable -> L17
        int r9 = 0;
    L24:
        if (r9 >= r6) goto L29;
        int userId2 = allUserHandles[r9];     // Catch: Throwable -> L17
        if (applyUserRestrictions == false) goto L28;
        this.mPm.mSettings.writePermissionStateForUserLPr(userId2, false);     // Catch: Throwable -> L17
    L28:
        r9 = r9 + 1;     // Catch: Throwable -> L17
        goto L24
    L29:
        if (writeSettings == false) goto L31;
        this.mPm.writeSettingsLPrTEMP();     // Catch: Throwable -> L17
    L31:
        monitor-exit(r3);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        applyUserRestrictions = false;
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void prepareSystemPackageCleanUp(WatchedArrayMap<String, PackageSetting> packageSettings, List<String> possiblyDeletedUpdatedSystemApps, ArrayMap<String, File> expectingBetter, int[] userIds) {
        int index = packageSettings.size() - 1;
    L3:
        if (index < 0) goto L26;
        PackageSetting ps = packageSettings.valueAt(index);
        String packageName = ps.getPackageName();
        if (ps.isSystem() == false) goto L24;
        AndroidPackage scannedPkg = this.mPm.mPackages.get(packageName);
        PackageSetting disabledPs = this.mPm.mSettings.getDisabledSystemPkgLPr(packageName);
        if (scannedPkg != null) goto L9;
        if (disabledPs != null) goto L16;
        PackageManagerServiceUtils.logCriticalInfo(5, "System package " + packageName + " no longer exists; its data will be wiped");
        this.mRemovePackageHelper.removePackageData(ps, userIds);
        this.mPm.getExt().setPendingClearAppData(ps.getPackageName());
        goto L24
    L16:
        if (disabledPs.getPath() != null) goto L18;
    L23:
        possiblyDeletedUpdatedSystemApps.add(packageName);
        goto L24
    L18:
        if (disabledPs.getPath().exists() == false) goto L23;
        if (disabledPs.getPkg() == null) goto L23;
        expectingBetter.put(disabledPs.getPackageName(), disabledPs.getPath());
        goto L24
    L9:
        if (scannedPkg.isApex() == true) goto L24;
        if (disabledPs == null) goto L24;
        PackageManagerServiceUtils.logCriticalInfo(5, "Expecting better updated system app for " + packageName + "; removing system app.  Last known codePath=" + ps.getPathString() + ", versionCode=" + ps.getVersionCode() + "; scanned versionCode=" + scannedPkg.getLongVersionCode());
        this.mRemovePackageHelper.removePackage(scannedPkg, true);
        expectingBetter.put(ps.getPackageName(), ps.getPath());
    L24:
        index = index - 1;
        goto L3
    }

    public void cleanupDisabledPackageSettings(List<String> possiblyDeletedUpdatedSystemApps, int[] userIds, int scanFlags) {
        int i = possiblyDeletedUpdatedSystemApps.size() - 1;
    L3:
        if (i < 0) goto L38;
        String packageName = possiblyDeletedUpdatedSystemApps.get(i);
        AndroidPackage pkg = this.mPm.mPackages.get(packageName);
        this.mPm.mSettings.removeDisabledSystemPackageLPw(packageName);
        if (pkg != null) goto L7;
        String msg = "Updated system package " + packageName + " no longer exists; removing its data";
    L31:
        PackageSetting ps = this.mPm.mSettings.getPackageLPr(packageName);
        if (ps == null) goto L36;
        if (this.mPm.mPackages.get(packageName) != null) goto L36;
        this.mRemovePackageHelper.removePackageData(ps, userIds);
    L36:
        PackageManagerServiceUtils.logCriticalInfo(5, msg);
        i = i - 1;
        goto L3
    L7:
        msg = "Updated system package " + packageName + " no longer exists; rescanning package on data";
        this.mRemovePackageHelper.removePackage(pkg, true);
        PackageSetting ps2 = this.mPm.mSettings.getPackageLPr(packageName);
        if (ps2 == null) goto L11;
        ps2.getPkgState().setUpdatedSystemApp(false);
    L11:
        if (NotificationManagerServiceSmtEx.ASSISTANT_PKG.equals(packageName) == false) goto L13;
        Slog.i(PackageManagerServiceMonitorEx.TAG, "remove updated system package: " + packageName);
        goto L31
    L13:
        File codePath = new File(pkg.getPath());
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: PackageManagerException -> L19
        initPackageTracedLI(codePath, 0, scanFlags);     // Catch: Throwable -> L22
        if (installLock == null) goto L31;
        installLock.close();     // Catch: PackageManagerException -> L19
        goto L31
    L22:
        th = move-exception;
        if (installLock != null) goto L43;
    L29:
        throw th;     // Catch: PackageManagerException -> L19
    L43:
        installLock.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: PackageManagerException -> L19
    L19:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to parse updated, ex-system package: " + e.getMessage());
        goto L31
    }

    public List<ApexManager.ScanResult> scanApexPackages(ApexInfo[] allPackages, int parseFlags, int scanFlags, PackageParser2 packageParser, ExecutorService executorService) {
        InstallPackageHelper r1 = this;
        if (allPackages == null) goto L5;
        ParallelPackageParser parallelPackageParser = new ParallelPackageParser(packageParser, executorService);
        final ArrayMap<File, ApexInfo> parsingApexInfo = new ArrayMap();
        int r0 = allPackages.length;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        ApexInfo ai = allPackages[r2];
        File apexFile = new File(ai.modulePath);
        parallelPackageParser.submit(apexFile, parseFlags);
        parsingApexInfo.put(apexFile, ai);
        r2 = r2 + 1;
        goto L7
    L9:
        List<ParallelPackageParser.ParseResult> parseResults = new ArrayList(parsingApexInfo.size());
        int i = 0;
    L11:
        if (i >= parsingApexInfo.size()) goto L13;
        parseResults.add(parallelPackageParser.take());
        i = i + 1;
        goto L11
    L13:
        Collections.sort(parseResults, new InstallPackageHelper$$ExternalSyntheticLambda3(parsingApexInfo));
        List<ApexManager.ScanResult> results = new ArrayList(parsingApexInfo.size());
        int i2 = 0;
    L15:
        if (i2 >= parseResults.size()) goto L48;
        ParallelPackageParser.ParseResult parseResult = parseResults.get(i2);
        Throwable throwable = parseResult.throwable;
        ApexInfo ai2 = parsingApexInfo.get(parseResult.scanFile);
        int newScanFlags = r1.mPm.getSystemPackageScanFlags(parseResult.scanFile) | (scanFlags | 67108864);
        if (ai2.isFactory == true) goto L19;
        int newParseFlags = parseFlags & (-17);
        int newParseFlags2 = newParseFlags;
        int newParseFlags3 = newScanFlags | 4;
    L20:
        if (throwable != 0) goto L42;
        ApexInfo ai3 = ai2;
        r1 = this;
        r1.addForInitLI(parseResult.parsedPackage, newParseFlags2, newParseFlags3, null, new ApexManager.ActiveApexInfo(ai2));     // Catch: PackageManagerException -> L31
        AndroidPackageInternal r3 = parseResult.parsedPackage.hideAsFinal();     // Catch: PackageManagerException -> L31
        if (ai3.isFactory == true) goto L29;
    L33:
        results.add(new ApexManager.ScanResult(ai3, r3, r3.getPackageName()));     // Catch: PackageManagerException -> L31
        i2 = i2 + 1;
        goto L15
    L29:
        if (ai3.isActive == true) goto L33;
        r1.disableSystemPackageLPw(r3);     // Catch: PackageManagerException -> L31
    L31:
        e = e;
    L40:
        throw new IllegalStateException("Failed to scan: " + ai3.modulePath, e);
    L35:
        e = e;
        ai3 = ai2;
    L37:
        e = e;
        ai3 = ai2;
        goto L40
    L42:
        if ((throwable instanceof PackageManagerException) == false) goto L46;
        throw new IllegalStateException("Unable to parse: " + ai2.modulePath, throwable);
    L46:
        throw new IllegalStateException("Unexpected exception occurred while parsing " + ai2.modulePath, throwable);
    L19:
        newParseFlags2 = parseFlags;
        newParseFlags3 = newScanFlags;
        goto L20
    L48:
        return results;
    L5:
        return Collections.EMPTY_LIST;
    }

    private static /* synthetic */ int lambda$scanApexPackages$9(ArrayMap parsingApexInfo, ParallelPackageParser.ParseResult a, ParallelPackageParser.ParseResult b) {
        ApexInfo i1 = (ApexInfo) parsingApexInfo.get(a.scanFile);
        ApexInfo i2 = (ApexInfo) parsingApexInfo.get(b.scanFile);
        return Boolean.compare(i2.isFactory, i1.isFactory);
    }

    public void installPackagesFromDir(File scanDir, int parseFlags, int scanFlags, PackageParser2 packageParser, ExecutorService executorService, ApexManager.ActiveApexInfo apexInfo) {
        File[] files = scanDir.listFiles();
        if (ArrayUtils.isEmpty(files) == false) goto L6;
        Log.d(PackageManagerServiceMonitorEx.TAG, "No files in app dir " + scanDir);
        return;
    L6:
        ParallelPackageParser parallelPackageParser = new ParallelPackageParser(packageParser, executorService);
        int fileCount = 0;
        int r2 = files.length;
        int r13 = 0;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L31;
        File file = files[r3];
        if (ApkLiteParseUtils.isApkFile(file) == true) goto L13;
        if (file.isDirectory() == true) goto L13;
    L15:
        boolean isPackage = false;
    L16:
        if (isPackage == false) goto L30;
        if ((scanFlags & 16777216) == 0) goto L22;
        PackageCacher cacher = new PackageCacher(this.mPm.getCacheDir(), this.mPm.mPackageParserCallback);
        Log.w(PackageManagerServiceMonitorEx.TAG, "Dropping cache of " + file.getAbsolutePath());
        cacher.cleanCachedResult(file);
    L22:
        if (this.mPackagesToBeDisabled.values() != null) goto L24;
    L29:
        parallelPackageParser.submit(file, parseFlags);
        fileCount = fileCount + 1;
        goto L30
    L24:
        if (this.mPackagesToBeDisabled.values().contains(file.toString()) == true) goto L27;
        Stream<String> r5 = this.mPackagesToBeDisabled.values().stream();
        String r6 = file.toString();
        r6.getClass();
        if (r5.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(r6)) == false) goto L29;
    L27:
        Slog.d(PackageManagerServiceMonitorEx.TAG, "ignoring package: " + file);
    L30:
        r3 = r3 + 1;
    L13:
        if (PackageInstallerService.isStageName(file.getName()) == true) goto L15;
        isPackage = true;
        goto L16
    L31:
        int fileCount2 = fileCount;
    L32:
        if (fileCount2 <= 0) goto L80;
        ParallelPackageParser.ParseResult parseResult = parallelPackageParser.take();
        Throwable throwable = parseResult.throwable;
        int errorCode = 1;
        String errorMsg = null;
        if (throwable == null) goto L85;
        ParallelPackageParser.ParseResult parseResult2 = parseResult;
        if ((throwable instanceof PackageManagerException) == false) goto L79;
        PackageManagerException e = (PackageManagerException) throwable;
        int errorCode2 = e.error;
        String errorMsg2 = "Failed to parse " + parseResult2.scanFile + ": " + e.getMessage();
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg2);
    L67:
        if ((scanFlags & 8388608) == 0) goto L72;
        if (errorCode2 == 1) goto L72;
        this.mApexManager.reportErrorWithApkInApex(scanDir.getAbsolutePath(), errorMsg2);
    L72:
        if ((scanFlags & 65536) != 0) goto L77;
        if (errorCode2 == 1) goto L77;
        PackageManagerServiceUtils.logCriticalInfo(5, "Deleting invalid package at " + parseResult2.scanFile);
        this.mRemovePackageHelper.removeCodePath(parseResult2.scanFile);
    L77:
        fileCount2 = fileCount2 - 1;
        r13 = 0;
        goto L32
    L79:
        throw new IllegalStateException("Unexpected exception occurred while parsing " + parseResult2.scanFile, throwable);
    L85:
        Trace.traceBegin(262144, "addForInitLI");     // Catch: Throwable -> L50 PackageManagerException -> L52
    L87:
        ParsedPackage r4 = parseResult.parsedPackage;     // Catch: Throwable -> L46 PackageManagerException -> L48
        UserHandle r7 = new UserHandle(r13);     // Catch: Throwable -> L46 PackageManagerException -> L48
        parseResult2 = parseResult;
        long r19 = 262144;
        addForInitLI(r4, parseFlags, scanFlags, r7, apexInfo);     // Catch: Throwable -> L42 PackageManagerException -> L44
        Trace.traceEnd(262144);
    L58:
        errorCode2 = errorCode;
        errorMsg2 = errorMsg;
        goto L67
    L42:
        th = th;
    L61:
        Trace.traceEnd(r19);
        throw th;
    L44:
        e = e;
    L55:
        errorCode = e.error;     // Catch: Throwable -> L42
        String errorMsg3 = "Failed to scan " + parseResult2.scanFile + ": " + e.getMessage();     // Catch: Throwable -> L42
        Slog.w(PackageManagerServiceMonitorEx.TAG, errorMsg3);     // Catch: Throwable -> L59
        Trace.traceEnd(r19);
        errorMsg = errorMsg3;
    L59:
        th = th;
        goto L61
    L48:
        e = e;
        parseResult2 = parseResult;
        r19 = 262144;
    L46:
        th = th;
        r19 = 262144;
    L52:
        e = e;
        parseResult2 = parseResult;
        r19 = 262144;
    L50:
        th = th;
        r19 = 262144;
        goto L61
    }

    protected void readListOfTelephonyPackagesToBeDisabled() {
        boolean wifiOnly = SystemProperties.getBoolean(PROPERTY_NO_RIL, false);
        if (wifiOnly == true) goto L5;
        return;
    L5:
        File telephonyPackagesFile = new File(Environment.getVendorDirectory(), "etc/telephony_packages.xml");
        FileReader packagesReader = null;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Disabling packages for wifi-only device, source: " + telephonyPackagesFile);
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        factory.setNamespaceAware(true);     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        XmlPullParser packagesParser = factory.newPullParser();     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        packagesReader = new FileReader(telephonyPackagesFile);     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        if (packagesParser == null) goto L28;
        packagesParser.setInput(packagesReader);     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        int eventType = packagesParser.getEventType();     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
    L9:
        if (eventType == 1) goto L28;
        String tagName = packagesParser.getName();     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        switch(eventType) {
            case 2: goto L14;
            default: goto L23;
        };     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
    L23:
        eventType = packagesParser.next();     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        goto L9
    L14:
        if (TextUtils.equals(tagName, "packageinfo") == false) goto L23;
        String name = packagesParser.getAttributeValue(null, "name");     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        String path = packagesParser.getAttributeValue(null, "path");     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        this.mPackagesToBeDisabled.put(name, path);     // Catch: Exception -> L16 IOException -> L18 XmlPullParserException -> L20
        goto L23
    L28:
        if (packagesReader == null) goto L38;
        packagesReader.close();     // Catch: IOException -> L31
        return;
    L32:
        return;
    L38:
        return;
    L18:
        e = move-exception;
        Log.e(PackageManagerServiceMonitorEx.TAG, "IOException parsing '" + telephonyPackagesFile + "'", e);
    L20:
        e = move-exception;
        Log.e(PackageManagerServiceMonitorEx.TAG, "XmlPullParserException parsing '" + telephonyPackagesFile + "'", e);
    L16:
        e = move-exception;
        Log.e(PackageManagerServiceMonitorEx.TAG, "Exception parsing '" + telephonyPackagesFile + "'", e);
        goto L28
    }

    protected void readListOfPackagesToBeDisabled() {
        String r0 = "propertyValue";
        String r2 = "propertyCheck";
        boolean qspaEnabled = SystemProperties.getBoolean(PROPERTY_QSPA_Enabled, false);
        if (qspaEnabled == true) goto L5;
        return;
    L5:
        String QSPA_PACKAGES_PATH = "etc/qspa_application_packages.xml";
        File qspaPackagesFile = new File(Environment.getVendorDirectory(), "etc/qspa_application_packages.xml");
        if (qspaPackagesFile.exists() == true) goto L9;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "File not found: " + qspaPackagesFile);
        return;
    L9:
        FileReader packagesReader = null;
        Slog.d(PackageManagerServiceMonitorEx.TAG, "Disabling packages for qspa enabled targets, source: " + qspaPackagesFile);
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        int r10 = 1;
        factory.setNamespaceAware(true);     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        XmlPullParser packagesParser = factory.newPullParser();     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        packagesReader = new FileReader(qspaPackagesFile);     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        if (packagesParser == null) goto L82;
        packagesParser.setInput(packagesReader);     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        int eventType = packagesParser.getEventType();     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
    L13:
        if (eventType == r10) goto L82;
        String tagName = packagesParser.getName();     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        switch(eventType) {
            case 2: goto L18;
            default: goto L16;
        };     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
    L16:
        String r20 = r0;
        String r18 = r2;
    L95:
        eventType = packagesParser.next();     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        qspaEnabled = qspaEnabled;
        QSPA_PACKAGES_PATH = QSPA_PACKAGES_PATH;
        r2 = r18;
        r0 = r20;
        r10 = 1;
        goto L13
    L32:
        e = e;
    L80:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "IOException parsing '" + qspaPackagesFile + "'", e);
    L34:
        e = e;
    L81:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "XmlPullParserException parsing '" + qspaPackagesFile + "'", e);
    L30:
        e = e;
    L79:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Exception parsing '" + qspaPackagesFile + "'", e);
        goto L82
    L18:
        if (TextUtils.equals(tagName, r2) == false) goto L73;
        String subsystem = packagesParser.getAttributeValue(null, "subsystem");     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        String systemPropertyName = "ro.boot.vendor.qspa." + subsystem;     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
        String currValue = SystemProperties.get(systemPropertyName);     // Catch: Exception -> L67 IOException -> L69 XmlPullParserException -> L71
    L97:
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L61 IOException -> L63 XmlPullParserException -> L65
    L23:
        r4.append("subsystem: ");     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        r4.append(subsystem);     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        r4.append(" currValue: ");     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        r4.append(currValue);     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        Slog.d(PackageManagerServiceMonitorEx.TAG, r4.toString());     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        int innerEventType = packagesParser.next();     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
    L25:
        if (innerEventType != 3) goto L37;
        if (TextUtils.equals(packagesParser.getName(), r2) == false) goto L37;
        r20 = r0;
        r18 = r2;
    L37:
        if (innerEventType == 2) goto L39;
        String r21 = r0;
        String r19 = r2;
    L60:
        innerEventType = packagesParser.next();     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        r2 = r19;
        r0 = r21;
        goto L25
    L39:
        if (TextUtils.equals(packagesParser.getName(), r0) == false) goto L58;
        r19 = r2;
        String systemPropertyValue = packagesParser.getAttributeValue(null, "value");     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        if (TextUtils.equals(currValue, systemPropertyValue) == false) goto L57;
        int packageEventType = packagesParser.next();     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
    L43:
        int innerEventType2 = innerEventType;
        if (packageEventType != 3) goto L50;
        if (TextUtils.equals(packagesParser.getName(), r0) == false) goto L50;
        r21 = r0;
    L50:
        if (packageEventType != 2) goto L55;
        String r22 = r0;
        if (TextUtils.equals(packagesParser.getName(), "packageinfo") == false) goto L56;
        String name = packagesParser.getAttributeValue(null, "name");     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        String path = packagesParser.getAttributeValue(null, "path");     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        this.mPackagesToBeDisabled.put(name, path);     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
    L56:
        packageEventType = packagesParser.next();     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        innerEventType = innerEventType2;
        r0 = r22;
        goto L43
    L55:
        r22 = r0;
        goto L56
    L57:
        r21 = r0;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Ignoring disabling packages due to systemPropertyName: " + systemPropertyName + " with value: " + systemPropertyValue);     // Catch: Exception -> L30 IOException -> L32 XmlPullParserException -> L34
        goto L60
    L58:
        r21 = r0;
        r19 = r2;
    L63:
        e = e;
    L65:
        e = e;
    L61:
        e = e;
        goto L79
    L73:
        r20 = r0;
        r18 = r2;
    L82:
        if (packagesReader != null) goto L91;
    L86:
        Iterator<String> r1 = this.mPackagesToBeDisabled.keySet().iterator();
    L88:
        if (r1.hasNext() == false) goto L90;
        String packageName = r1.next();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "readListOfPackagesToBeDisabled, package: " + packageName + ", path: " + this.mPackagesToBeDisabled.get(packageName));
        goto L88
    L90:
        return;
    L91:
        packagesReader.close();     // Catch: IOException -> L85
    L69:
        e = e;
    L71:
        e = e;
    L67:
        e = e;
        goto L79
    }

    public void checkExistingBetterPackages(ArrayMap<String, File> expectingBetterPackages, List<String> stubSystemApps, int systemScanFlags, int systemParseFlags) {
        int i = 0;
    L4:
        if (i >= expectingBetterPackages.size()) goto L35;
        String packageName = expectingBetterPackages.keyAt(i);
        if (this.mPm.mPackages.containsKey(packageName) == true) goto L33;
        File scanFile = expectingBetterPackages.valueAt(i);
        PackageManagerServiceUtils.logCriticalInfo(5, "Expected better " + packageName + " but never showed up; reverting to system");
        Pair<Integer, Integer> rescanAndReparseFlags = this.mPm.getSystemPackageRescanFlagsAndReparseFlags(scanFile, systemScanFlags, systemParseFlags);
        int rescanFlags = ((Integer) rescanAndReparseFlags.first).intValue();
        int reparseFlags = ((Integer) rescanAndReparseFlags.second).intValue();
        if (rescanFlags != 0) goto L11;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Ignoring unexpected fallback path " + scanFile);
        goto L33
    L11:
        this.mPm.mSettings.enableSystemPackageLPw(packageName);
        PackageManagerTracedLock installLock = this.mPm.mInstallLock.acquireLock();     // Catch: PackageManagerException -> L22
        AndroidPackage newPkg = initPackageTracedLI(scanFile, reparseFlags, rescanFlags);     // Catch: Throwable -> L17
        if (newPkg.isStub() == false) goto L19;
        stubSystemApps.add(packageName);     // Catch: Throwable -> L17
    L19:
        if (installLock == null) goto L33;
        installLock.close();     // Catch: PackageManagerException -> L22
    L17:
        th = move-exception;
        if (installLock != null) goto L40;
    L31:
        throw th;     // Catch: PackageManagerException -> L22
    L40:
        installLock.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: PackageManagerException -> L22
    L22:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to parse original system package: " + e.getMessage());
    L33:
        i = i + 1;
        goto L4
    }

    public AndroidPackage initPackageTracedLI(File scanFile, int parseFlags, int scanFlags) throws PackageManagerException {
        Trace.traceBegin(262144, "scanPackage [" + scanFile.toString() + "]");
        AndroidPackage r0 = initPackageLI(scanFile, parseFlags, scanFlags);     // Catch: Throwable -> L6
        Trace.traceEnd(262144);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    private AndroidPackage initPackageLI(File scanFile, int parseFlags, int scanFlags) throws PackageManagerException {
        Trace.traceBegin(262144, "parsePackage");
        PackageParser2 pp = this.mPm.mInjector.getScanningPackageParser();     // Catch: Throwable -> L10 PackageParserException -> L12
        ParsedPackage parsedPackage = pp.parsePackage(scanFile, parseFlags, false);     // Catch: Throwable -> L14
        pp.close();     // Catch: Throwable -> L10 PackageParserException -> L12
        Trace.traceEnd(262144);
        return addForInitLI(parsedPackage, parseFlags, scanFlags, new UserHandle(0), null);
    L14:
        th = move-exception;
        if (pp != null) goto L33;
        throw th;     // Catch: Throwable -> L22 PackageParserException -> L24
    L24:
        e = move-exception;
        PackageParserException e = e;
    L30:
        throw new PackageManagerException(e.error, e.getMessage(), e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r13 = th;
    L31:
        Trace.traceEnd(262144);
        throw r13;
    L33:
        pp.close();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L22 PackageParserException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L22 PackageParserException -> L24
        throw th;     // Catch: Throwable -> L22 PackageParserException -> L24
    L12:
        e = move-exception;
        e = e;
    L10:
        th = move-exception;
        r13 = th;
        goto L31
    }

    private AndroidPackage addForInitLI(ParsedPackage parsedPackage, int parseFlags, int scanFlags, UserHandle user, ApexManager.ActiveApexInfo activeApexInfo) throws PackageManagerException {
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        if (activeApexInfo == null) goto L103;
    L10:
        PackageSetting disabledPkgSetting = this.mPm.mSettings.getDisabledSystemPkgLPr(parsedPackage.getPackageName());     // Catch: Throwable -> L8
        if (activeApexInfo == null) goto L14;
        if (disabledPkgSetting == null) goto L14;
        disabledPkgSetting.setApexModuleName(activeApexInfo.apexModuleName);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (parsedPackage.getApplicationInfoSysEx() == null) goto L18;
        this.mPm.getSmtEx().updateBytedanceFlagValue(parsedPackage.getPackageName(), parsedPackage.getApplicationInfoSysEx(), parsedPackage.getVersionName());
    L19:
        Pair<ScanResult, Boolean> scanResultPair = scanPackageForInitLI(parsedPackage, parseFlags, scanFlags, user);
        ScanResult scanResult = (ScanResult) scanResultPair.first;
        boolean shouldHideSystemApp = ((Boolean) scanResultPair.second).booleanValue();
        InstallRequest installRequest = new InstallRequest(parsedPackage, parseFlags, scanFlags, user, scanResult, disabledPkgSetting);
        String existingApexModuleName = null;
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        PackageSetting existingPkgSetting = this.mPm.mSettings.getPackageLPr(parsedPackage.getPackageName());     // Catch: Throwable -> L24
        if (existingPkgSetting == null) goto L26;
        existingApexModuleName = existingPkgSetting.getApexModuleName();     // Catch: Throwable -> L24
    L26:
        monitor-exit(r5);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (activeApexInfo == null) goto L30;
        installRequest.setApexModuleName(activeApexInfo.apexModuleName);
    L34:
        PackageManagerTracedLock r6 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        boolean appIdCreated = false;
        String pkgName = scanResult.mPkgSetting.getPackageName();     // Catch: Throwable -> L40 PackageManagerException -> L42
        List<ReconciledPackage> reconcileResult = ReconcilePackageUtils.reconcilePackages(Collections.singletonList(installRequest), this.mPm.mPackages, Collections.singletonMap(pkgName, this.mPm.getSettingsVersionForPackage(parsedPackage)), this.mSharedLibraries, this.mPm.mSettings.getKeySetManagerService(), this.mPm.mSettings, this.mPm.mInjector.getSystemConfig());     // Catch: Throwable -> L40 PackageManagerException -> L42
        if ((scanFlags & 67108864) != 0) goto L44;
        appIdCreated = optimisticallyRegisterAppId(installRequest);     // Catch: Throwable -> L40 PackageManagerException -> L42
    L45:
        commitReconciledScanResultLocked(reconcileResult.get(0), this.mPm.mUserManager.getUserIds());     // Catch: Throwable -> L40 PackageManagerException -> L42
        this.mPm.getSmtEx().onPackageScanned(scanResult);     // Catch: Throwable -> L40 PackageManagerException -> L42
        monitor-exit(r6);     // Catch: Throwable -> L40
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (shouldHideSystemApp == false) goto L59;
        PackageManagerTracedLock r7 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        this.mPm.mSettings.disableSystemPackageLPw(parsedPackage.getPackageName(), true);     // Catch: Throwable -> L54
        monitor-exit(r7);     // Catch: Throwable -> L54
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L54:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L59:
        if (this.mIncrementalManager == null) goto L68;
        if (IncrementalManager.isIncrementalPath(parsedPackage.getPath()) == false) goto L68;
        if (scanResult.mPkgSetting == null) goto L68;
        if (scanResult.mPkgSetting.isLoading() == false) goto L68;
        this.mIncrementalManager.registerLoadingProgressCallback(parsedPackage.getPath(), new IncrementalProgressListener(parsedPackage.getPackageName(), this.mPm));
    L68:
        if (scanResult.mPkgSetting.getAppMetadataSource() != 1) goto L81;
        if (PackageManagerServiceUtils.extractAppMetadataFromApk(parsedPackage, scanResult.mPkgSetting.getAppMetadataFilePath(), scanResult.mPkgSetting.isSystem()) == true) goto L81;
        PackageManagerTracedLock r8 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        scanResult.mPkgSetting.setAppMetadataFilePath(null).setAppMetadataSource(0);     // Catch: Throwable -> L76
        monitor-exit(r8);     // Catch: Throwable -> L76
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L76:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L81:
        return scanResult.mPkgSetting.getPkg();
    L44:
        installRequest.setScannedPackageSettingAppId(-1);     // Catch: Throwable -> L40 PackageManagerException -> L42
    L40:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L42:
        e = move-exception;
        if (appIdCreated == false) goto L86;
        cleanUpAppIdCreation(installRequest);     // Catch: Throwable -> L40
    L86:
        throw e;     // Catch: Throwable -> L40
    L30:
        if (disabledPkgSetting == null) goto L32;
        installRequest.setApexModuleName(disabledPkgSetting.getApexModuleName());
        goto L34
    L32:
        if (existingApexModuleName == null) goto L34;
        installRequest.setApexModuleName(existingApexModuleName);
    L24:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L18:
        Slog.e(PackageManagerServiceMonitorEx.TAG, "addForInitLI pkg: " + parsedPackage.getPackageName() + " applicationInfo null");
    L8:
        th = th;
    L100:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L96:
        th = th;
        goto L100
    L103:
        if (parsedPackage.isStaticSharedLibrary() == false) goto L10;
        PackageManagerService.renameStaticSharedLibraryPackage(parsedPackage);     // Catch: Throwable -> L8
        goto L10
    }

    private boolean optimisticallyRegisterAppId(InstallRequest installRequest) throws PackageManagerException {
        if (installRequest.isExistingSettingCopied() == true) goto L5;
    L9:
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mPm.mSettings.registerAppIdLPw(installRequest.getScannedPackageSetting(), installRequest.needsNewAppId());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        if (installRequest.needsNewAppId() == true) goto L9;
        return false;
    }

    private void cleanUpAppIdCreation(InstallRequest installRequest) {
        if (installRequest.getScannedPackageSetting() != null) goto L5;
        return;
    L5:
        if (installRequest.getScannedPackageSetting().getAppId() <= 0) goto L18;
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPm.mSettings.removeAppIdLPw(installRequest.getScannedPackageSetting().getAppId());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private ScanResult scanPackageTraced(ParsedPackage parsedPackage, int parseFlags, int scanFlags, long currentTime, UserHandle user, String cpuAbiOverride) throws PackageManagerException {
        Trace.traceBegin(262144, "scanPackage");
        ScanResult r0 = scanPackageNew(parsedPackage, parseFlags, scanFlags, currentTime, user, cpuAbiOverride);     // Catch: Throwable -> L6
        Trace.traceEnd(262144);
        return r0;
    L6:
        th = move-exception;
        Trace.traceEnd(262144);
        throw th;
    }

    private ScanRequest prepareInitialScanRequest(ParsedPackage parsedPackage, int parseFlags, int scanFlags, UserHandle user, String cpuAbiOverride) throws PackageManagerException {
        SharedUserSetting oldSharedUserSetting = null;
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        AndroidPackage platformPackage = this.mPm.getPlatformPackage();     // Catch: Throwable -> L7
        boolean isSystemApp = AndroidPackageLegacyUtils.isSystem(parsedPackage);     // Catch: Throwable -> L7
        String renamedPkgName = this.mPm.mSettings.getRenamedPackageLPr(AndroidPackageUtils.getRealPackageOrNull(parsedPackage, isSystemApp));     // Catch: Throwable -> L7
        String realPkgName = ScanPackageUtils.getRealPackageName(parsedPackage, renamedPkgName, isSystemApp);     // Catch: Throwable -> L7
        if (realPkgName == null) goto L9;
        ScanPackageUtils.ensurePackageRenamed(parsedPackage, renamedPkgName);     // Catch: Throwable -> L7
    L9:
        PackageSetting originalPkgSetting = getOriginalPackageLocked(parsedPackage, renamedPkgName);     // Catch: Throwable -> L7
        PackageSetting installedPkgSetting = this.mPm.mSettings.getPackageLPr(parsedPackage.getPackageName());     // Catch: Throwable -> L7
        if (this.mPm.mTransferredPackages.contains(parsedPackage.getPackageName()) == false) goto L12;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Package " + parsedPackage.getPackageName() + " was transferred to another, but its .apk remains");     // Catch: Throwable -> L7
    L12:
        PackageSetting disabledPkgSetting = this.mPm.mSettings.getDisabledSystemPkgLPr(parsedPackage.getPackageName());     // Catch: Throwable -> L7
        boolean ignoreSharedUserId = false;
        if (installedPkgSetting != null) goto L15;
    L16:
        ignoreSharedUserId = parsedPackage.isLeavingSharedUser();     // Catch: Throwable -> L7
    L17:
        boolean isPlatformPackage = false;
        if (ignoreSharedUserId == false) goto L20;
    L22:
        SharedUserSetting sharedUserSetting = null;
    L23:
        if (installedPkgSetting == null) goto L25;
        oldSharedUserSetting = this.mPm.mSettings.getSharedUserSettingLPr(installedPkgSetting);     // Catch: Throwable -> L7
    L25:
        monitor-exit(r4);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (platformPackage != null) goto L29;
    L32:
        SharedUserSetting oldSharedUserSetting2 = oldSharedUserSetting;
        if (installedPkgSetting != null) goto L35;
        AndroidPackage r5 = null;
    L37:
        return new ScanRequest(parsedPackage, oldSharedUserSetting2, r5, installedPkgSetting, sharedUserSetting, disabledPkgSetting, originalPkgSetting, realPkgName, parseFlags, scanFlags, isPlatformPackage, user, cpuAbiOverride);
    L35:
        r5 = installedPkgSetting.getPkg();
        goto L37
    L29:
        if (platformPackage.getPackageName().equals(parsedPackage.getPackageName()) == false) goto L32;
        isPlatformPackage = true;
        goto L32
    L20:
        if (parsedPackage.getSharedUserId() == null) goto L22;
        sharedUserSetting = this.mPm.mSettings.getSharedUserLPw(parsedPackage.getSharedUserId(), 0, 0, true);     // Catch: Throwable -> L7
        goto L23
    L15:
        if (installedPkgSetting.hasSharedUser() == true) goto L17;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private ScanResult scanPackageNew(ParsedPackage parsedPackage, int parseFlags, int scanFlags, long currentTime, UserHandle user, String cpuAbiOverride) throws PackageManagerException {
        ScanRequest initialScanRequest = prepareInitialScanRequest(parsedPackage, parseFlags, scanFlags, user, cpuAbiOverride);
        PackageSetting installedPkgSetting = initialScanRequest.mPkgSetting;
        PackageSetting disabledPkgSetting = initialScanRequest.mDisabledPkgSetting;
        if (installedPkgSetting == null) goto L5;
        boolean isUpdatedSystemApp = installedPkgSetting.isUpdatedSystemApp();
    L9:
        int newScanFlags = adjustScanFlags(scanFlags, installedPkgSetting, disabledPkgSetting, user, parsedPackage);
        ScanPackageUtils.applyPolicy(parsedPackage, newScanFlags, this.mPm.getPlatformPackage(), isUpdatedSystemApp);
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        assertPackageIsValid(parsedPackage, parseFlags, newScanFlags);     // Catch: Throwable -> L50
        PackageManagerTracedLock r18 = r5;
        ScanRequest request = new ScanRequest(parsedPackage, initialScanRequest.mOldSharedUserSetting, initialScanRequest.mOldPkg, installedPkgSetting, initialScanRequest.mSharedUserSetting, disabledPkgSetting, initialScanRequest.mOriginalPkgSetting, initialScanRequest.mRealPkgName, parseFlags, scanFlags, initialScanRequest.mIsPlatformPackage, user, cpuAbiOverride);     // Catch: Throwable -> L36
        ScanResult r1 = ScanPackageUtils.scanPackageOnly(request, this.mPm.mInjector, this.mPm.mFactoryTest, currentTime);     // Catch: Throwable -> L32
        monitor-exit(r18);     // Catch: Throwable -> L32
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L34:
        th = th;
    L52:
        monitor-exit(r18);     // Catch: Throwable -> L32
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L36:
        th = th;
    L38:
        th = th;
        r18 = r5;
    L41:
        th = th;
        r18 = r5;
    L43:
        th = th;
        r18 = r5;
    L45:
        th = th;
        r18 = r5;
    L48:
        th = th;
        r18 = r5;
    L32:
        th = th;
    L50:
        th = th;
        r18 = r5;
        goto L52
    L5:
        if (disabledPkgSetting == null) goto L7;
        boolean r0 = true;
    L8:
        isUpdatedSystemApp = r0;
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    private Pair<ScanResult, Boolean> scanPackageForInitLI(ParsedPackage parsedPackage, int parseFlags, int scanFlags, UserHandle user) throws PackageManagerException {
        boolean isApexPkg = true;
        if ((parseFlags & 16) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean scanSystemPartition = r0;
        ScanRequest initialScanRequest = prepareInitialScanRequest(parsedPackage, parseFlags, scanFlags, user, null);
        PackageSetting installedPkgSetting = initialScanRequest.mPkgSetting;
        PackageSetting originalPkgSetting = initialScanRequest.mOriginalPkgSetting;
        if (originalPkgSetting != null) goto L9;
        PackageSetting r1 = installedPkgSetting;
    L10:
        PackageSetting pkgSetting = r1;
        if (pkgSetting == null) goto L13;
        boolean r2 = true;
    L14:
        boolean pkgAlreadyExists = r2;
        if (pkgAlreadyExists == false) goto L17;
        String r3 = pkgSetting.getPackageName();
    L18:
        String disabledPkgName = r3;
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        boolean isUpgrade = this.mPm.isDeviceUpgrading();     // Catch: Throwable -> L185
        if (scanSystemPartition == false) goto L30;
        if (pkgAlreadyExists == true) goto L30;
    L28:
        th = th;
        PackageManagerTracedLock r26 = r5;
    L212:
        monitor-exit(r26);     // Catch: Throwable -> L190
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L190:
        th = th;
        goto L212
    L25:
        if (this.mPm.mSettings.getDisabledSystemPkgLPr(disabledPkgName) == null) goto L30;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Inconsistent package setting of updated system app for " + disabledPkgName + ". To recover it, enable the system app and install it as non-updated system app.");     // Catch: Throwable -> L28
        this.mPm.mSettings.removeDisabledSystemPackageLPw(disabledPkgName);     // Catch: Throwable -> L28
    L30:
        PackageSetting disabledPkgSetting = this.mPm.mSettings.getDisabledSystemPkgLPr(disabledPkgName);     // Catch: Throwable -> L185
        if (disabledPkgSetting == null) goto L34;
        boolean r4 = true;
    L35:
        boolean isSystemPkgUpdated = r4;
        if (scanSystemPartition == false) goto L59;
        if (isSystemPkgUpdated == false) goto L59;
        InstallPackageHelper r14 = this;
        r26 = r5;
        ScanRequest initialScanRequest2 = initialScanRequest;
        int scanFlags2 = scanFlags;
        ScanRequest request = new ScanRequest(parsedPackage, this.mPm.mSettings.getSharedUserSettingLPr(disabledPkgSetting), null, disabledPkgSetting, initialScanRequest.mSharedUserSetting, null, null, null, parseFlags, scanFlags2, initialScanRequest.mIsPlatformPackage, user, null);     // Catch: Throwable -> L52
        ParsedPackage r6 = parsedPackage;
        PackageSetting disabledPkgSetting2 = disabledPkgSetting;
        ScanPackageUtils.applyPolicy(r6, scanFlags2, r14.mPm.getPlatformPackage(), true);     // Catch: Throwable -> L50
        ScanResult scanResult = ScanPackageUtils.scanPackageOnly(request, r14.mPm.mInjector, r14.mPm.mFactoryTest, -1);     // Catch: Throwable -> L50
        if (scanResult.mExistingSettingCopied == true) goto L47;
    L196:
        monitor-exit(r26);     // Catch: Throwable -> L183
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (pkgAlreadyExists == true) goto L64;
    L66:
        boolean r7 = false;
    L67:
        boolean newPkgChangedPaths = r7;
        if (pkgAlreadyExists == true) goto L70;
    L72:
        boolean r8 = false;
    L73:
        boolean newPkgVersionGreater = r8;
        if (pkgAlreadyExists == false) goto L79;
        ScanRequest initialScanRequest3 = initialScanRequest2;
        if (initialScanRequest3.mOldSharedUserSetting == initialScanRequest3.mSharedUserSetting) goto L79;
        boolean r9 = true;
    L80:
        boolean newSharedUserSetting = r9;
        if (scanSystemPartition == false) goto L87;
        if (isSystemPkgUpdated == false) goto L87;
        if (newPkgChangedPaths == false) goto L87;
        if (newPkgVersionGreater == true) goto L86;
        if (newSharedUserSetting == false) goto L87;
    L86:
        boolean r10 = true;
    L88:
        boolean isSystemPkgBetter = r10;
        if (isSystemPkgBetter == false) goto L107;
        PackageManagerTracedLock r11 = r14.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r11);
        r14.mPm.mPackages.remove(pkgSetting.getPackageName());     // Catch: Throwable -> L103
        monitor-exit(r11);     // Catch: Throwable -> L103
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageManagerServiceUtils.logCriticalInfo(5, "System package updated; name: " + pkgSetting.getPackageName() + "; " + pkgSetting.getVersionCode() + " --> " + r6.getLongVersionCode() + "; " + pkgSetting.getPathString() + " --> " + r6.getPath());
        r14.mRemovePackageHelper.cleanUpResources(pkgSetting.getPackageName(), new File(pkgSetting.getPathString()), InstructionSets.getAppDexInstructionSets(pkgSetting.getPrimaryCpuAbiLegacy(), pkgSetting.getSecondaryCpuAbiLegacy()));
        PackageManagerTracedLock r12 = r14.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r12);
        r14.mPm.mSettings.enableSystemPackageLPw(pkgSetting.getPackageName());     // Catch: Throwable -> L99
        monitor-exit(r12);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L99:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L103:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L107:
        if (scanSystemPartition == false) goto L124;
        if (isSystemPkgUpdated == false) goto L124;
        if (isSystemPkgBetter == true) goto L124;
        if (r14.needSignatureMatchToSystem(r6.getPackageName()) == false) goto L117;
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<SigningDetails> result = ParsingPackageUtils.getSigningDetails(input, r6, false);
        if (result.isError() == true) goto L116;
        disabledPkgSetting2.setSigningDetails((SigningDetails) result.getResult());
        goto L117
    L116:
        throw new PrepareFailure("Failed collect during scanPackageForInitLI", result.getException());
    L117:
        r6.hideAsFinal();
        StringBuilder r13 = new StringBuilder();
        r13.append("Package ");
        r13.append(r6.getPackageName());
        r13.append(" at ");
        r13.append(r6.getPath());
        r13.append(" ignored: updated version ");
        if (pkgAlreadyExists == false) goto L120;
        String r15 = String.valueOf(pkgSetting.getVersionCode());
    L121:
        r13.append(r15);
        r13.append(" better than this ");
        r13.append(r6.getLongVersionCode());
        throw PackageManagerException.ofInternalError(r13.toString(), -12);
    L120:
        r15 = "unknown";
    L124:
        if (scanSystemPartition == false) goto L126;
        boolean forceCollect = isUpgrade;
    L131:
        ScanPackageUtils.collectCertificatesLI(pkgSetting, r6, r14.mPm.getSettingsVersionForPackage(r6), forceCollect, scanSystemPartition, r14.mPm.isPreNMR1Upgrade());
        r14.maybeClearProfilesForUpgradesLI(pkgSetting, r6);
        if (scanSystemPartition == false) goto L162;
        if (isSystemPkgUpdated == true) goto L162;
        if (pkgAlreadyExists == false) goto L162;
        if (pkgSetting.isSystem() == true) goto L162;
        if (r14.mObricExt.deletePackageForAssist(pkgSetting.getPackageName(), r6) == true) goto L162;
        if (r6.getSigningDetails().checkCapability(pkgSetting.getSigningDetails(), 1) == false) goto L143;
    L157:
        if (newPkgVersionGreater == true) goto L161;
        if (newSharedUserSetting == true) goto L161;
        PackageManagerServiceUtils.logCriticalInfo(4, "System package disabled; name: " + pkgSetting.getPackageName() + "; old: " + pkgSetting.getPathString() + " @ " + pkgSetting.getVersionCode() + "; new: " + r6.getPath() + " @ " + r6.getLongVersionCode());
        boolean shouldHideSystemApp = true;
    L164:
        if ((67108864 & scanFlags2) != 0) goto L168;
        isApexPkg = false;
    L168:
        if (r14.mPm.mShouldStopSystemPackagesByDefault == false) goto L181;
        if (scanSystemPartition == false) goto L181;
        if (pkgAlreadyExists == true) goto L181;
        if (isApexPkg == true) goto L181;
        if (r6.isOverlayIsStatic() == true) goto L181;
        String packageName = r6.getPackageName();
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.contentEquals(packageName) == true) goto L181;
        if (r14.mPm.mInitialNonStoppedSystemPackages.contains(packageName) == true) goto L181;
        if (hasLauncherEntry(r6) == false) goto L181;
        scanFlags2 = 134217728 | scanFlags2;
    L181:
        long firstInstallTime = System.currentTimeMillis();
        return new Pair(r14.scanPackageNew(r6, parseFlags, scanFlags2 | 2, firstInstallTime, user, null), Boolean.valueOf(shouldHideSystemApp));
    L161:
        PackageManagerServiceUtils.logCriticalInfo(5, "System package enabled; name: " + pkgSetting.getPackageName() + "; " + pkgSetting.getVersionCode() + " --> " + r6.getLongVersionCode() + "; " + pkgSetting.getPathString() + " --> " + r6.getPath());
        r14.mRemovePackageHelper.cleanUpResources(pkgSetting.getPackageName(), new File(pkgSetting.getPathString()), InstructionSets.getAppDexInstructionSets(pkgSetting.getPrimaryCpuAbiLegacy(), pkgSetting.getSecondaryCpuAbiLegacy()));
        goto L162
    L143:
        if (pkgSetting.getSigningDetails().checkCapability(r6.getSigningDetails(), 8) == true) goto L157;
        PackageManagerServiceUtils.logCriticalInfo(5, "System package signature mismatch; name: " + pkgSetting.getPackageName());
        PackageFreezer freezer = r14.mPm.freezePackage(r6.getPackageName(), -1, "scanPackageInternalLI", 13, null);
        r14.mDeletePackageHelper.deletePackageLIF(r6.getPackageName(), null, true, r14.mPm.mUserManager.getUserIds(), 0, new PackageRemovedInfo(), false);     // Catch: Throwable -> L149
        if (freezer == null) goto L162;
        freezer.close();
    L149:
        th = move-exception;
        if (freezer == null) goto L218;
        freezer.close();     // Catch: Throwable -> L154
        throw th;
    L154:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L218:
        throw th;
    L162:
        shouldHideSystemApp = false;
        goto L164
    L126:
        if (pkgAlreadyExists == true) goto L128;
    L130:
        forceCollect = false;
        goto L131
    L128:
        if (r14.needSignatureMatchToSystem(pkgSetting.getPackageName()) == false) goto L130;
        forceCollect = true;
    L87:
        r10 = false;
    L79:
        r9 = false;
        goto L80
    L70:
        if (r6.getLongVersionCode() <= pkgSetting.getVersionCode()) goto L72;
        r8 = true;
        goto L73
    L64:
        if (pkgSetting.getPathString().equals(r6.getPath()) == true) goto L66;
        r7 = true;
    L183:
        th = th;
        goto L212
    L47:
        if (scanResult.mRequest.mPkgSetting == null) goto L196;
        scanResult.mRequest.mPkgSetting.updateFrom(scanResult.mPkgSetting);     // Catch: Throwable -> L50
    L50:
        th = th;
    L52:
        th = th;
    L54:
        th = th;
        r26 = r5;
    L57:
        th = th;
        r26 = r5;
    L59:
        scanFlags2 = scanFlags;
        r14 = this;
        r26 = r5;
        initialScanRequest2 = initialScanRequest;
        disabledPkgSetting2 = disabledPkgSetting;
        r6 = parsedPackage;
        goto L196
    L34:
        r4 = false;
    L185:
        th = th;
        r26 = r5;
        goto L212
    L17:
        r3 = parsedPackage.getPackageName();
        goto L18
    L13:
        r2 = false;
        goto L14
    L9:
        r1 = originalPkgSetting;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static boolean hasLauncherEntry(ParsedPackage parsedPackage) {
        HashSet<String> categories = new HashSet();
        categories.add("android.intent.category.LAUNCHER");
        List<ParsedActivity> activities = parsedPackage.getActivities();
        int indexActivity = 0;
    L4:
        if (indexActivity >= activities.size()) goto L21;
        ParsedActivity activity = activities.get(indexActivity);
        if (activity.isEnabled() == false) goto L20;
        if (activity.isExported() == false) goto L20;
        List<ParsedIntentInfo> intents = activity.getIntents();
        int indexIntent = 0;
    L12:
        if (indexIntent >= intents.size()) goto L20;
        IntentFilter intentFilter = intents.get(indexIntent).getIntentFilter();
        if (intentFilter == null) goto L19;
        if (intentFilter.matchCategories(categories) != null) goto L19;
        return true;
    L19:
        indexIntent = indexIntent + 1;
    L20:
        indexActivity = indexActivity + 1;
        goto L4
    L21:
        return false;
    }

    private boolean needSignatureMatchToSystem(String packageName) {
        return this.mPm.mInjector.getSystemConfig().getPreinstallPackagesWithStrictSignatureCheck().contains(packageName);
    }

    private void maybeClearProfilesForUpgradesLI(PackageSetting originalPkgSetting, AndroidPackage pkg) {
        if (originalPkgSetting != null) goto L4;
        return;
    L4:
        if (this.mPm.isDeviceUpgrading() == true) goto L7;
        return;
    L7:
        if (originalPkgSetting.getVersionCode() != pkg.getLongVersionCode()) goto L9;
        return;
    L9:
        this.mAppDataHelper.clearAppProfilesLIF(pkg);
    }

    private PackageSetting getOriginalPackageLocked(AndroidPackage pkg, String renamedPkgName) {
        if (ScanPackageUtils.isPackageRenamed(pkg, renamedPkgName) == false) goto L5;
        return null;
    L5:
        int i = ArrayUtils.size(pkg.getOriginalPackages()) - 1;
    L6:
        if (i < 0) goto L20;
        PackageSetting originalPs = this.mPm.mSettings.getPackageLPr((String) pkg.getOriginalPackages().get(i));
        if (originalPs == null) goto L18;
        if (verifyPackageUpdateLPr(originalPs, pkg) == false) goto L18;
        if (this.mPm.mSettings.getSharedUserSettingLPr(originalPs) == null) goto L17;
        String sharedUserSettingsName = this.mPm.mSettings.getSharedUserSettingLPr(originalPs).name;
        if (sharedUserSettingsName.equals(pkg.getSharedUserId()) == true) goto L17;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unable to migrate data from " + originalPs.getPackageName() + " to " + pkg.getPackageName() + ": old shared user settings name " + sharedUserSettingsName + " differs from " + pkg.getSharedUserId());
    L17:
        return originalPs;
    L18:
        i = i - 1;
        goto L6
    L20:
        return null;
    }

    private boolean verifyPackageUpdateLPr(PackageSetting oldPkg, AndroidPackage newPkg) {
        if ((oldPkg.getFlags() & 1) != 0) goto L7;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unable to update from " + oldPkg.getPackageName() + " to " + newPkg.getPackageName() + ": old package not in system partition");
        return false;
    L7:
        if (this.mPm.mPackages.get(oldPkg.getPackageName()) == null) goto L10;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Unable to update from " + oldPkg.getPackageName() + " to " + newPkg.getPackageName() + ": old package still exists");
        return false;
    L10:
        return true;
    }

    private void assertPackageIsValid(AndroidPackage pkg, int parseFlags, int scanFlags) throws PackageManagerException {
        if ((parseFlags & 64) == 0) goto L6;
        ScanPackageUtils.assertCodePolicy(pkg);
    L6:
        if (pkg.getPath() == null) goto L83;
        boolean installApex = false;
        if ((scanFlags & 16) != 0) goto L10;
        boolean isUserInstall = true;
    L12:
        if ((scanFlags & 4096) == 0) goto L14;
        boolean isFirstBootOrUpgrade = true;
    L16:
        if ((67108864 & scanFlags) == 0) goto L19;
        installApex = true;
    L19:
        if (isUserInstall == true) goto L22;
        if (isFirstBootOrUpgrade == true) goto L22;
    L27:
        KeySetManagerService ksms = this.mPm.mSettings.getKeySetManagerService();
        ksms.assertScannedPackageValid(pkg);
        PackageManagerTracedLock r5 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
    L36:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L30:
        if (pkg.getPackageName().equals(PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L39;
        if (this.mPm.getCoreAndroidApplication() == null) goto L39;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "*************************************************");     // Catch: Throwable -> L36
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Core android package being redefined.  Skipping.");     // Catch: Throwable -> L36
        Slog.w(PackageManagerServiceMonitorEx.TAG, " codePath=" + pkg.getPath());     // Catch: Throwable -> L36
        Slog.w(PackageManagerServiceMonitorEx.TAG, "*************************************************");     // Catch: Throwable -> L36
        throw new PackageManagerException(-5, "Core android package being redefined.  Skipping.");     // Catch: Throwable -> L36
    L39:
        if ((scanFlags & 4) != 0) goto L46;
        if (this.mPm.mPackages.containsKey(pkg.getPackageName()) == false) goto L46;
        throw new PackageManagerException(-5, "Application package " + pkg.getPackageName() + " already installed.  Skipping duplicate.");     // Catch: Throwable -> L36
    L46:
        if (pkg.isStaticSharedLibrary() == false) goto L56;
        if ((scanFlags & 4) == 0) goto L50;
    L54:
        ScanPackageUtils.assertStaticSharedLibraryIsValid(pkg, scanFlags);     // Catch: Throwable -> L36
        assertStaticSharedLibraryVersionCodeIsValid(pkg);     // Catch: Throwable -> L36
        goto L56
    L50:
        if (this.mPm.mPackages.containsKey(pkg.getManifestPackageName()) == false) goto L54;
        throw PackageManagerException.ofInternalError("Duplicate static shared lib provider package", -13);     // Catch: Throwable -> L36
    L56:
        if ((scanFlags & 128) == 0) goto L70;
        if (this.mPm.isExpectingBetter(pkg.getPackageName()) == false) goto L60;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Relax SCAN_REQUIRE_KNOWN requirement for package " + pkg.getPackageName());     // Catch: Throwable -> L36
        goto L70
    L60:
        PackageSetting known = this.mPm.mSettings.getPackageLPr(pkg.getPackageName());     // Catch: Throwable -> L36
        if (known == null) goto L68;
        if (pkg.getPath().equals(known.getPathString()) == true) goto L70;
        throw new PackageManagerException(-23, "Application package " + pkg.getPackageName() + " found at " + pkg.getPath() + " but expected at " + known.getPathString() + "; ignoring.");     // Catch: Throwable -> L36
    L68:
        throw new PackageManagerException(-19, "Application package " + pkg.getPackageName() + " not found; ignoring.");     // Catch: Throwable -> L36
    L70:
        if ((scanFlags & 4) == 0) goto L72;
        this.mPm.mComponentResolver.assertProvidersNotDefined(pkg);     // Catch: Throwable -> L36
    L72:
        ScanPackageUtils.assertProcessesAreValid(pkg);     // Catch: Throwable -> L36
        assertPackageWithSharedUserIdIsPrivileged(pkg);     // Catch: Throwable -> L36
        if (pkg.getOverlayTarget() == null) goto L75;
        assertOverlayIsValid(pkg, parseFlags, scanFlags);     // Catch: Throwable -> L36
    L75:
        ScanPackageUtils.assertMinSignatureSchemeIsValid(pkg, parseFlags);     // Catch: Throwable -> L36
        monitor-exit(r5);     // Catch: Throwable -> L36
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L22:
        if (this.mPm.snapshotComputer().isApexPackage(pkg.getPackageName()) == false) goto L27;
        if (installApex == true) goto L27;
        throw new PackageManagerException(-5, pkg.getPackageName() + " is an APEX package and can't be installed as an APK.");
    L14:
        isFirstBootOrUpgrade = false;
        goto L16
    L10:
        isUserInstall = false;
        goto L12
    L83:
        throw new PackageManagerException(-2, "Code and resource paths haven't been set correctly");
    }

    private void assertStaticSharedLibraryVersionCodeIsValid(AndroidPackage pkg) throws PackageManagerException {
        long minVersionCode = Long.MIN_VALUE;
        long maxVersionCode = Long.MAX_VALUE;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = this.mSharedLibraries.getSharedLibraryInfos(pkg.getStaticSharedLibraryName());
        if (versionedLib == null) goto L15;
        int versionCount = versionedLib.size();
        int i = 0;
    L5:
        if (i >= versionCount) goto L15;
        SharedLibraryInfo libInfo = versionedLib.valueAt(i);
        long libVersionCode = libInfo.getDeclaringPackage().getLongVersionCode();
        if (libInfo.getLongVersion() >= pkg.getStaticSharedLibraryVersion()) goto L10;
        minVersionCode = Math.max(minVersionCode, 1 + libVersionCode);
    L12:
        i = i + 1;
        goto L5
    L10:
        if (libInfo.getLongVersion() <= pkg.getStaticSharedLibraryVersion()) goto L13;
        maxVersionCode = Math.min(maxVersionCode, libVersionCode - 1);
        goto L12
    L13:
        maxVersionCode = libVersionCode;
        minVersionCode = libVersionCode;
    L15:
        if (pkg.getLongVersionCode() < minVersionCode) goto L20;
        if (pkg.getLongVersionCode() > maxVersionCode) goto L20;
        return;
    L20:
        throw PackageManagerException.ofInternalError("Static shared lib version codes must be ordered as lib versions", -14);
    }

    private void assertOverlayIsValid(AndroidPackage pkg, int parseFlags, int scanFlags) throws PackageManagerException {
        if ((65536 & scanFlags) == 0) goto L20;
        if ((parseFlags & 16) != 0) goto L12;
        if (this.mPm.isOverlayMutable(pkg.getPackageName()) == false) goto L10;
        return;
    L10:
        throw PackageManagerException.ofInternalError("Overlay " + pkg.getPackageName() + " is static and cannot be upgraded.", -15);
    L12:
        if ((4718592 & scanFlags) == 0) goto L17;
        if (pkg.getTargetSdkVersion() >= ScanPackageUtils.getVendorPartitionVersion()) goto L65;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "System overlay " + pkg.getPackageName() + " targets an SDK below the required SDK level of vendor overlays (" + ScanPackageUtils.getVendorPartitionVersion() + "). This will become an install error in a future release");
        return;
    L65:
        return;
    L17:
        if (pkg.getTargetSdkVersion() >= Build.VERSION.SDK_INT) goto L73;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "System overlay " + pkg.getPackageName() + " targets an SDK below the required SDK level of system overlays (" + Build.VERSION.SDK_INT + "). This will become an install error in a future release");
        return;
    L73:
        return;
    L20:
        if (pkg.getTargetSdkVersion() >= 29) goto L35;
        PackageManagerTracedLock r0 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        PackageSetting platformPkgSetting = this.mPm.mSettings.getPackageLPr(PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L30
        monitor-exit(r0);     // Catch: Throwable -> L30
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (PackageManagerServiceUtils.comparePackageSignatures(platformPkgSetting, pkg.getSigningDetails()) == true) goto L35;
        throw PackageManagerException.ofInternalError("Overlay " + pkg.getPackageName() + " must target Q or later, or be signed with the platform certificate", -16);
    L30:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L35:
        if (pkg.getOverlayTargetOverlayableName() != null) goto L75;
        PackageManagerTracedLock r1 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        PackageSetting targetPkgSetting = this.mPm.mSettings.getPackageLPr(pkg.getOverlayTarget());     // Catch: Throwable -> L61
        monitor-exit(r1);     // Catch: Throwable -> L61
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (targetPkgSetting != null) goto L43;
        return;
    L43:
        if (PackageManagerServiceUtils.comparePackageSignatures(targetPkgSetting, pkg.getSigningDetails()) == false) goto L45;
        return;
    L45:
        if (this.mPm.mOverlayConfigSignaturePackage == null) goto L60;
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        PackageSetting refPkgSetting = this.mPm.mSettings.getPackageLPr(this.mPm.mOverlayConfigSignaturePackage);     // Catch: Throwable -> L55
        monitor-exit(r2);     // Catch: Throwable -> L55
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (PackageManagerServiceUtils.comparePackageSignatures(refPkgSetting, pkg.getSigningDetails()) == false) goto L54;
        return;
    L54:
        throw PackageManagerException.ofInternalError("Overlay " + pkg.getPackageName() + " signed with a different certificate than both the reference package and target " + pkg.getOverlayTarget() + ", and the overlay lacks <overlay android:targetName>", -18);
    L55:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L60:
        throw PackageManagerException.ofInternalError("Overlay " + pkg.getPackageName() + " and target " + pkg.getOverlayTarget() + " signed with different certificates, and the overlay lacks <overlay android:targetName>", -17);
    L61:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void assertPackageWithSharedUserIdIsPrivileged(AndroidPackage pkg) throws PackageManagerException {
        if (AndroidPackageLegacyUtils.isPrivileged(pkg) == false) goto L5;
        return;
    L5:
        if (pkg.getSharedUserId() != null) goto L7;
        return;
    L7:
        if (pkg.isLeavingSharedUser() == true) goto L44;
        SharedUserSetting sharedUserSetting = null;
        PackageManagerTracedLock r1 = this.mPm.mLock;     // Catch: PackageManagerException -> L15
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L15
        monitor-enter(r1);     // Catch: PackageManagerException -> L15
        sharedUserSetting = this.mPm.mSettings.getSharedUserLPw(pkg.getSharedUserId(), 0, 0, false);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L15
        goto L21
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();     // Catch: PackageManagerException -> L15
        throw th;     // Catch: PackageManagerException -> L15
    L21:
        if (sharedUserSetting != null) goto L23;
        return;
    L23:
        if (sharedUserSetting.isPrivileged() == false) goto L46;
        PackageManagerTracedLock r2 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        PackageSetting platformPkgSetting = this.mPm.mSettings.getPackageLPr(PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L33
        monitor-exit(r2);     // Catch: Throwable -> L33
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (PackageManagerServiceUtils.comparePackageSignatures(platformPkgSetting, pkg.getSigningDetails()) == false) goto L32;
        return;
    L32:
        throw PackageManagerException.ofInternalError("Apps that share a user with a privileged app must themselves be marked as privileged. " + pkg.getPackageName() + " shares privileged user " + pkg.getSharedUserId() + ".", -19);
    L33:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L46:
        return;
    }

    private int adjustScanFlags(int scanFlags, PackageSetting existingPkgSetting, PackageSetting disabledPkgSetting, UserHandle user, AndroidPackage pkg) {
        int scanFlags2 = ScanPackageUtils.adjustScanFlagsWithPackageSetting(scanFlags, existingPkgSetting, disabledPkgSetting, user);
        if ((524288 & scanFlags2) != 0) goto L5;
    L7:
        boolean skipVendorPrivilegeScan = false;
    L9:
        if ((scanFlags2 & 131072) == 0) goto L11;
    L35:
        return scanFlags2;
    L11:
        if (AndroidPackageLegacyUtils.isPrivileged(pkg) == true) goto L35;
        if (pkg.getSharedUserId() == null) goto L35;
        if (skipVendorPrivilegeScan == true) goto L35;
        if (pkg.isLeavingSharedUser() == true) goto L35;
        SharedUserSetting sharedUserSetting = null;
        PackageManagerTracedLock r4 = this.mPm.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        sharedUserSetting = this.mPm.mSettings.getSharedUserLPw(pkg.getSharedUserId(), 0, 0, false);     // Catch: Throwable -> L21 PackageManagerException -> L23
    L21:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L24:
        if (sharedUserSetting != null) goto L26;
    L30:
        monitor-exit(r4);     // Catch: Throwable -> L21
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L35
    L26:
        if (sharedUserSetting.isPrivileged() == false) goto L30;
        PackageSetting platformPkgSetting = this.mPm.mSettings.getPackageLPr(PackageManagerService.PLATFORM_PACKAGE_NAME);     // Catch: Throwable -> L21
        if (PackageManagerServiceUtils.compareSignatures(platformPkgSetting.getSigningDetails(), pkg.getSigningDetails()) == 0) goto L30;
        scanFlags2 = scanFlags2 | 131072;     // Catch: Throwable -> L21
        goto L30
    L5:
        if (ScanPackageUtils.getVendorPartitionVersion() >= 28) goto L7;
        skipVendorPrivilegeScan = true;
        goto L9
    }

    public IObricInstallPackageHelper getObricExt() {
        return this.mObricExt;
    }

    public IExtInstallPackageHelper getExt() {
        return this.mExt;
    }

    private boolean shouldPrepareAppDataAfterCommit(PackageSetting ps, int userId) {
        if (ps.getCeDataInode(userId) != 0) goto L7;
        return true;
    L7:
        if (isCeStorageUnlockedAndPrepared(userId) == true) goto L10;
        return false;
    L10:
        File ceDir = getCeDataPackageDirectory(ps, userId);
        boolean ceDirExists = ceDir.exists();
        Slog.d(PackageManagerServiceMonitorEx.TAG, "executePostCommitStepsLIF: compare CE dir fallback packageName=" + ps.getPackageName() + " userId=" + userId + " ceDataInode=" + ps.getCeDataInode(userId) + " deDataInode=" + ps.getDeDataInode(userId) + " ceDirExists=" + ceDirExists + " ceDir=" + ceDir);
        if (ceDirExists == true) goto L14;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "executePostCommitStepsLIF: CE inode exists but dir is missing");
    L14:
        return !ceDirExists;
    }

    private void logPostCommitAppDataFallbackState(PackageSetting ps, int[] newUsers, int[] usersToPrepare) {
        int r0 = newUsers.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int userId = newUsers[r1];
        CeDataDirState ceDataDirState = getCeDataDirState(ps, userId);
        Slog.d(PackageManagerServiceMonitorEx.TAG, "executePostCommitStepsLIF: appDataFallbackState packageName=" + ps.getPackageName() + " userId=" + userId + " ceDataInode=" + ps.getCeDataInode(userId) + " deDataInode=" + ps.getDeDataInode(userId) + " ceStorageUnlocked=" + ceDataDirState.ceStorageUnlocked + " ceStoragePrepared=" + ceDataDirState.ceStoragePrepared + " ceDirExists=" + ceDataDirState.ceDirExists + " ceDir=" + ceDataDirState.ceDir + " selected=" + ArrayUtils.contains(usersToPrepare, userId));
        r1 = r1 + 1;
        goto L3
    }
}
