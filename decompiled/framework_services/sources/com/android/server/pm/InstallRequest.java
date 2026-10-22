package com.android.server.pm;

import android.apex.ApexInfo;
import android.content.pm.ArchivedPackageParcel;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.PackageLite;
import android.content.pm.verify.domain.DomainSet;
import android.net.Uri;
import android.os.Build;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ExceptionUtils;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.ArrayUtils;
import com.android.server.art.model.DexoptResult;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class InstallRequest {
    private ApexInfo mApexInfo;
    private String mApexModuleName;
    private int mAppId;
    private ArchivedPackageParcel mArchivedPackage;
    private boolean mClearCodeCache;
    private final boolean mDependencyInstallerEnabled;
    private int mDexoptStatus;
    private PackageSetting mDisabledPs;
    private String mExistingPackageName;
    private int[] mFirstTimeBroadcastInstantUserIds;
    private int[] mFirstTimeBroadcastUserIds;
    private PackageFreezer mFreezer;
    private final boolean mHasAppMetadataFileFromInstaller;
    private final InstallArgs mInstallArgs;
    private int mInstallerUidForInstallExisting;
    private int mInternalErrorCode;
    private boolean mIsInstallForUsers;
    private boolean mIsInstallInherit;
    private boolean mKeepArtProfile;
    private ArrayList<AndroidPackage> mLibraryConsumers;
    private final int mMissingSharedLibraryCount;
    private String mName;
    private int[] mNewUsers;
    private String mOrigPackage;
    private String mOrigPermission;
    private int[] mOrigUsers;
    private PackageSetting mOriginalPs;
    private PackageLite mPackageLite;
    private final PackageMetrics mPackageMetrics;
    private int mParseFlags;
    private ParsedPackage mParsedPackage;
    private AndroidPackage mPkg;
    private Runnable mPostInstallRunnable;
    private DomainSet mPreVerifiedDomains;
    private PackageRemovedInfo mRemovedInfo;
    private boolean mReplace;
    private final int mRequireUserAction;
    private SparseArray<String> mResponsibleInstallerTitles;
    private int mReturnCode;
    private String mReturnMsg;
    private int mScanFlags;
    private ScanResult mScanResult;
    private final int mSessionId;
    private boolean mSystem;
    private int[] mUpdateBroadcastInstantUserIds;
    private int[] mUpdateBroadcastUserIds;
    private final int mUserId;
    private final ArrayList<String> mWarnings;

    InstallRequest(InstallingSession params) {
        this.mAppId = -1;
        this.mFirstTimeBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mFirstTimeBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mWarnings = new ArrayList();
        this.mInstallerUidForInstallExisting = -1;
        this.mKeepArtProfile = false;
        this.mUserId = params.getUser().getIdentifier();
        this.mInstallArgs = new InstallArgs(params.mOriginInfo, params.mMoveInfo, params.mObserver, params.mInstallFlags, params.mDevelopmentInstallFlags, params.mInstallSource, params.mVolumeUuid, params.getUser(), null, params.mPackageAbiOverride, params.mPermissionStates, params.mAllowlistedRestrictedPermissions, params.mAutoRevokePermissionsMode, params.mTraceMethod, params.mTraceCookie, params.mSigningDetails, params.mInstallReason, params.mInstallScenario, params.mForceQueryableOverride, params.mDataLoaderType, params.mPackageSource, params.mApplicationEnabledSettingPersistent, params.mDexoptCompilerFilter);
        this.mPackageLite = params.mPackageLite;
        this.mPackageMetrics = new PackageMetrics(this);
        this.mIsInstallInherit = params.mIsInherit;
        this.mSessionId = params.mSessionId;
        this.mRequireUserAction = params.mRequireUserAction;
        this.mPreVerifiedDomains = params.mPreVerifiedDomains;
        this.mHasAppMetadataFileFromInstaller = params.mHasAppMetadataFile;
        this.mDependencyInstallerEnabled = params.mDependencyInstallerEnabled;
        this.mMissingSharedLibraryCount = params.mMissingSharedLibraryCount;
    }

    InstallRequest(int userId, int returnCode, AndroidPackage pkg, int[] newUsers, Runnable runnable, int appId, int installerUid, boolean isSystem) {
        this.mAppId = -1;
        this.mFirstTimeBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mFirstTimeBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mWarnings = new ArrayList();
        this.mInstallerUidForInstallExisting = -1;
        this.mKeepArtProfile = false;
        this.mUserId = userId;
        this.mInstallArgs = null;
        this.mReturnCode = returnCode;
        this.mPkg = pkg;
        this.mNewUsers = newUsers;
        this.mPostInstallRunnable = runnable;
        this.mPackageMetrics = new PackageMetrics(this);
        this.mIsInstallForUsers = true;
        this.mSessionId = -1;
        this.mRequireUserAction = 0;
        this.mAppId = appId;
        this.mInstallerUidForInstallExisting = installerUid;
        this.mSystem = isSystem;
        this.mHasAppMetadataFileFromInstaller = false;
        this.mDependencyInstallerEnabled = false;
        this.mMissingSharedLibraryCount = 0;
    }

    InstallRequest(ParsedPackage parsedPackage, int parseFlags, int scanFlags, UserHandle user, ScanResult scanResult, PackageSetting disabledPs) {
        this.mAppId = -1;
        this.mFirstTimeBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mFirstTimeBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mWarnings = new ArrayList();
        this.mInstallerUidForInstallExisting = -1;
        this.mKeepArtProfile = false;
        if (user == null) goto L5;
        this.mUserId = user.getIdentifier();
    L6:
        this.mInstallArgs = null;
        this.mParsedPackage = parsedPackage;
        this.mArchivedPackage = null;
        this.mParseFlags = parseFlags;
        this.mScanFlags = scanFlags;
        this.mScanResult = scanResult;
        this.mPackageMetrics = null;
        this.mSessionId = -1;
        this.mRequireUserAction = 0;
        this.mDisabledPs = disabledPs;
        this.mHasAppMetadataFileFromInstaller = false;
        this.mDependencyInstallerEnabled = false;
        this.mMissingSharedLibraryCount = 0;
        return;
    L5:
        this.mUserId = 0;
        goto L6
    }

    public String getName() {
        return this.mName;
    }

    public String getReturnMsg() {
        return this.mReturnMsg;
    }

    public OriginInfo getOriginInfo() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mOriginInfo;
    }

    public PackageRemovedInfo getRemovedInfo() {
        return this.mRemovedInfo;
    }

    public String getOrigPackage() {
        return this.mOrigPackage;
    }

    public String getOrigPermission() {
        return this.mOrigPermission;
    }

    public File getCodeFile() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mCodeFile;
    }

    public String getCodePath() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mInstallArgs.mCodeFile == null) goto L7;
        return this.mInstallArgs.mCodeFile.getAbsolutePath();
    }

    public String getAbiOverride() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mAbiOverride;
    }

    public int getReturnCode() {
        return this.mReturnCode;
    }

    public int getInternalErrorCode() {
        return this.mInternalErrorCode;
    }

    public IPackageInstallObserver2 getObserver() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mObserver;
    }

    public boolean isInstallMove() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mInstallArgs.mMoveInfo == null) goto L7;
        return true;
    }

    public String getMoveToUuid() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mInstallArgs.mMoveInfo == null) goto L7;
        return this.mInstallArgs.mMoveInfo.mToUuid;
    }

    public String getMovePackageName() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mInstallArgs.mMoveInfo == null) goto L7;
        return this.mInstallArgs.mMoveInfo.mPackageName;
    }

    public String getMoveFromCodePath() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mInstallArgs.mMoveInfo == null) goto L7;
        return this.mInstallArgs.mMoveInfo.mFromCodePath;
    }

    public File getOldCodeFile() {
        if (this.mRemovedInfo != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mRemovedInfo.mArgs == null) goto L7;
        return this.mRemovedInfo.mArgs.getCodeFile();
    }

    public String[] getOldInstructionSet() {
        if (this.mRemovedInfo != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mRemovedInfo.mArgs == null) goto L7;
        return this.mRemovedInfo.mArgs.getInstructionSets();
    }

    public UserHandle getUser() {
        return new UserHandle(this.mUserId);
    }

    public int getUserId() {
        return this.mUserId;
    }

    public int getInstallFlags() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mInstallFlags;
    }

    public int getDevelopmentInstallFlags() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mDevelopmentInstallFlags;
    }

    public int getInstallReason() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mInstallReason;
    }

    public String getVolumeUuid() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mVolumeUuid;
    }

    public AndroidPackage getPkg() {
        return this.mPkg;
    }

    public PackageLite getPackageLite() {
        return this.mPackageLite;
    }

    public String getTraceMethod() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mTraceMethod;
    }

    public int getTraceCookie() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mTraceCookie;
    }

    public boolean isUpdate() {
        if (this.mRemovedInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRemovedInfo.mRemovedPackage == null) goto L7;
        return true;
    }

    public boolean isArchived() {
        return PackageInstallerSession.isArchivedInstallation(getInstallFlags());
    }

    public boolean hasAppMetadataFile() {
        return this.mHasAppMetadataFileFromInstaller;
    }

    public String getRemovedPackage() {
        if (this.mRemovedInfo != null) goto L7;
        return null;
    L7:
        return this.mRemovedInfo.mRemovedPackage;
    }

    public boolean isInstallExistingForUser() {
        if (this.mInstallArgs != null) goto L5;
        return true;
    L5:
        return false;
    }

    public InstallSource getInstallSource() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mInstallSource;
    }

    public String getInstallerPackageName() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return null;
    L5:
        if (this.mInstallArgs.mInstallSource == null) goto L7;
        return this.mInstallArgs.mInstallSource.mInstallerPackageName;
    }

    public int getInstallerPackageUid() {
        if (this.mInstallArgs == null) goto L8;
        if (this.mInstallArgs.mInstallSource == null) goto L8;
        return this.mInstallArgs.mInstallSource.mInstallerPackageUid;
    L8:
        return this.mInstallerUidForInstallExisting;
    }

    public int getDataLoaderType() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mDataLoaderType;
    }

    public int getSignatureSchemeVersion() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mSigningDetails.getSignatureSchemeVersion();
    }

    public SigningDetails getSigningDetails() {
        if (this.mInstallArgs != null) goto L6;
        return SigningDetails.UNKNOWN;
    L6:
        return this.mInstallArgs.mSigningDetails;
    }

    public Uri getOriginUri() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return Uri.fromFile(this.mInstallArgs.mOriginInfo.mResolvedFile);
    }

    public ApexInfo getApexInfo() {
        return this.mApexInfo;
    }

    public String getApexModuleName() {
        return this.mApexModuleName;
    }

    public SparseArray<String> getResponsibleInstallerTitles() {
        return this.mResponsibleInstallerTitles;
    }

    public boolean isRollback() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mInstallArgs.mInstallReason != 5) goto L7;
        return true;
    }

    public int[] getNewUsers() {
        return this.mNewUsers;
    }

    public int[] getOriginUsers() {
        return this.mOrigUsers;
    }

    public int getAppId() {
        return this.mAppId;
    }

    public ArrayMap<String, Integer> getPermissionStates() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mPermissionStates;
    }

    public ArrayList<AndroidPackage> getLibraryConsumers() {
        return this.mLibraryConsumers;
    }

    public List<String> getAllowlistedRestrictedPermissions() {
        if (this.mInstallArgs != null) goto L6;
        return null;
    L6:
        return this.mInstallArgs.mAllowlistedRestrictedPermissions;
    }

    public int getAutoRevokePermissionsMode() {
        if (this.mInstallArgs != null) goto L6;
        return 3;
    L6:
        return this.mInstallArgs.mAutoRevokePermissionsMode;
    }

    public int getPackageSource() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mPackageSource;
    }

    public int getInstallScenario() {
        if (this.mInstallArgs != null) goto L6;
        return 0;
    L6:
        return this.mInstallArgs.mInstallScenario;
    }

    public ParsedPackage getParsedPackage() {
        return this.mParsedPackage;
    }

    public ArchivedPackageParcel getArchivedPackage() {
        return this.mArchivedPackage;
    }

    public int getParseFlags() {
        return this.mParseFlags;
    }

    public int getScanFlags() {
        return this.mScanFlags;
    }

    public String getExistingPackageName() {
        return this.mExistingPackageName;
    }

    public AndroidPackage getScanRequestOldPackage() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mOldPkg;
    }

    public boolean isClearCodeCache() {
        return this.mClearCodeCache;
    }

    public boolean isInstallReplace() {
        return this.mReplace;
    }

    public boolean isInstallSystem() {
        return this.mSystem;
    }

    public boolean isInstallInherit() {
        return this.mIsInstallInherit;
    }

    public boolean isInstallForUsers() {
        return this.mIsInstallForUsers;
    }

    public boolean isInstallFromAdb() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return false;
    L5:
        if ((this.mInstallArgs.mInstallFlags & 32) == 0) goto L7;
        return true;
    }

    public PackageSetting getOriginalPackageSetting() {
        return this.mOriginalPs;
    }

    public PackageSetting getDisabledPackageSetting() {
        return this.mDisabledPs;
    }

    public PackageSetting getScanRequestOldPackageSetting() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mOldPkgSetting;
    }

    public PackageSetting getScanRequestOriginalPackageSetting() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mOriginalPkgSetting;
    }

    public PackageSetting getScanRequestPackageSetting() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mPkgSetting;
    }

    public PackageSetting getScanRequestDisabledPackageSetting() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mDisabledPkgSetting;
    }

    public String getRealPackageName() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mRealPkgName;
    }

    public List<String> getChangedAbiCodePath() {
        assertScanResultExists();
        return this.mScanResult.mChangedAbiCodePath;
    }

    public boolean isApplicationEnabledSettingPersistent() {
        if (this.mInstallArgs != null) goto L6;
        return false;
    L6:
        return this.mInstallArgs.mApplicationEnabledSettingPersistent;
    }

    public boolean isForceQueryableOverride() {
        if (this.mInstallArgs != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mInstallArgs.mForceQueryableOverride == false) goto L7;
        return true;
    }

    public SharedLibraryInfo getSdkSharedLibraryInfo() {
        assertScanResultExists();
        return this.mScanResult.mSdkSharedLibraryInfo;
    }

    public SharedLibraryInfo getStaticSharedLibraryInfo() {
        assertScanResultExists();
        return this.mScanResult.mStaticSharedLibraryInfo;
    }

    public List<SharedLibraryInfo> getDynamicSharedLibraryInfos() {
        assertScanResultExists();
        return this.mScanResult.mDynamicSharedLibraryInfos;
    }

    public void updateAllCodePaths(List<String> paths) {
        if (this.mScanResult.mSdkSharedLibraryInfo == null) goto L6;
        this.mScanResult.mSdkSharedLibraryInfo.setAllCodePaths(paths);
    L6:
        if (this.mScanResult.mStaticSharedLibraryInfo == null) goto L9;
        this.mScanResult.mStaticSharedLibraryInfo.setAllCodePaths(paths);
    L9:
        if (this.mScanResult.mDynamicSharedLibraryInfos == null) goto L14;
        Iterator<SharedLibraryInfo> r0 = this.mScanResult.mDynamicSharedLibraryInfos.iterator();
    L12:
        if (r0.hasNext() == false) goto L16;
        SharedLibraryInfo info = r0.next();
        info.setAllCodePaths(paths);
        goto L12
    L16:
        return;
    }

    public PackageSetting getScannedPackageSetting() {
        assertScanResultExists();
        return this.mScanResult.mPkgSetting;
    }

    public boolean isExistingSettingCopied() {
        assertScanResultExists();
        return this.mScanResult.mExistingSettingCopied;
    }

    public boolean needsNewAppId() {
        assertScanResultExists();
        if (this.mScanResult.mPreviousAppId == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getPreviousAppId() {
        assertScanResultExists();
        return this.mScanResult.mPreviousAppId;
    }

    public boolean isPlatformPackage() {
        assertScanResultExists();
        return this.mScanResult.mRequest.mIsPlatformPackage;
    }

    public boolean isInstantInstall() {
        if ((this.mScanFlags & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void assertScanResultExists() {
        if (this.mScanResult == null) goto L5;
        return;
    L5:
        if (Build.IS_USERDEBUG == true) goto L10;
        if (Build.IS_ENG == true) goto L10;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "ScanResult is null and it should not happen");
        return;
    L10:
        throw new IllegalStateException("ScanResult cannot be null.");
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public int getRequireUserAction() {
        return this.mRequireUserAction;
    }

    public int getDexoptStatus() {
        return this.mDexoptStatus;
    }

    public boolean isAllNewUsers() {
        if (this.mOrigUsers != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mOrigUsers.length == 0) goto L8;
        return false;
    }

    public int[] getFirstTimeBroadcastUserIds() {
        return this.mFirstTimeBroadcastUserIds;
    }

    public int[] getFirstTimeBroadcastInstantUserIds() {
        return this.mFirstTimeBroadcastInstantUserIds;
    }

    public int[] getUpdateBroadcastUserIds() {
        return this.mUpdateBroadcastUserIds;
    }

    public int[] getUpdateBroadcastInstantUserIds() {
        return this.mUpdateBroadcastInstantUserIds;
    }

    public ArrayList<String> getWarnings() {
        return this.mWarnings;
    }

    public String getDexoptCompilerFilter() {
        if (this.mInstallArgs != null) goto L7;
        return null;
    L7:
        return this.mInstallArgs.mDexoptCompilerFilter;
    }

    public void setScanFlags(int scanFlags) {
        this.mScanFlags = scanFlags;
    }

    public void closeFreezer() {
        if (this.mFreezer == null) goto L6;
        this.mFreezer.close();
        return;
    }

    public void setPostInstallRunnable(Runnable runnable) {
        this.mPostInstallRunnable = runnable;
    }

    public boolean hasPostInstallRunnable() {
        if (this.mPostInstallRunnable == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void runPostInstallRunnable() {
        if (this.mPostInstallRunnable == null) goto L6;
        this.mPostInstallRunnable.run();
        return;
    }

    public void setCodeFile(File codeFile) {
        if (this.mInstallArgs == null) goto L6;
        this.mInstallArgs.mCodeFile = codeFile;
        return;
    }

    public void setError(int code, String msg) {
        setReturnCode(code);
        setReturnMessage(msg);
        Slog.w(PackageManagerServiceMonitorEx.TAG, msg);
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onInstallFailed();
        return;
    }

    public void setError(PackageManagerException e) {
        setError(null, e);
    }

    public void setError(String msg, PackageManagerException e) {
        this.mInternalErrorCode = e.internalErrorCode;
        this.mReturnCode = e.error;
        setReturnMessage(ExceptionUtils.getCompleteMessage(msg, e));
        Slog.w(PackageManagerServiceMonitorEx.TAG, msg, e);
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onInstallFailed();
        return;
    }

    public void setReturnCode(int returnCode) {
        this.mReturnCode = returnCode;
    }

    public void setReturnMessage(String returnMsg) {
        this.mReturnMsg = returnMsg;
    }

    public void setApexInfo(ApexInfo apexInfo) {
        this.mApexInfo = apexInfo;
    }

    public void setApexModuleName(String apexModuleName) {
        this.mApexModuleName = apexModuleName;
    }

    public void setResponsibleInstallerTitles(SparseArray<String> responsibleInstallerTitles) {
        this.mResponsibleInstallerTitles = responsibleInstallerTitles;
    }

    public void setPkg(AndroidPackage pkg) {
        this.mPkg = pkg;
    }

    public void setAppId(int appId) {
        this.mAppId = appId;
    }

    public void setNewUsers(int[] newUsers) {
        this.mNewUsers = newUsers;
        populateBroadcastUsers();
    }

    public void setOriginPackage(String originPackage) {
        this.mOrigPackage = originPackage;
    }

    public void setOriginPermission(String originPermission) {
        this.mOrigPermission = originPermission;
    }

    public void setName(String packageName) {
        this.mName = packageName;
    }

    public void setOriginUsers(int[] userIds) {
        this.mOrigUsers = userIds;
    }

    public void setFreezer(PackageFreezer freezer) {
        this.mFreezer = freezer;
    }

    public void setRemovedInfo(PackageRemovedInfo removedInfo) {
        this.mRemovedInfo = removedInfo;
    }

    public void setLibraryConsumers(ArrayList<AndroidPackage> libraryConsumers) {
        this.mLibraryConsumers = libraryConsumers;
    }

    public void setPrepareResult(boolean replace, int scanFlags, int parseFlags, PackageState existingPackageState, ParsedPackage packageToScan, ArchivedPackageParcel archivedPackage, boolean clearCodeCache, boolean system, PackageSetting originalPs, PackageSetting disabledPs) {
        this.mReplace = replace;
        this.mScanFlags = scanFlags;
        this.mParseFlags = parseFlags;
        if (existingPackageState == null) goto L5;
        String r0 = existingPackageState.getPackageName();
    L6:
        this.mExistingPackageName = r0;
        this.mParsedPackage = packageToScan;
        this.mArchivedPackage = archivedPackage;
        this.mClearCodeCache = clearCodeCache;
        this.mSystem = system;
        this.mOriginalPs = originalPs;
        this.mDisabledPs = disabledPs;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void setScanResult(ScanResult scanResult) {
        this.mScanResult = scanResult;
    }

    public void setScannedPackageSettingAppId(int appId) {
        assertScanResultExists();
        this.mScanResult.mPkgSetting.setAppId(appId);
    }

    public void setScannedPackageSettingFirstInstallTimeFromReplaced(PackageStateInternal replacedPkgSetting, int[] userId) {
        assertScanResultExists();
        if (replacedPkgSetting != null) goto L5;
        return;
    L5:
        this.mScanResult.mPkgSetting.setFirstInstallTimeFromReplaced(replacedPkgSetting, userId);
    }

    public void setScannedPackageSettingLastUpdateTime(long lastUpdateTim) {
        assertScanResultExists();
        this.mScanResult.mPkgSetting.setLastUpdateTime(lastUpdateTim);
    }

    public void setScannedPackageSettingFirstInstallTime(long firstInstallTime) {
        assertScanResultExists();
        PackageUserStateInternal userState = this.mScanResult.mPkgSetting.getUserStates().get(this.mUserId);
        if (userState != null) goto L5;
        return;
    L5:
        if (userState.getFirstInstallTimeMillis() != 0) goto L9;
        this.mScanResult.mPkgSetting.setFirstInstallTime(firstInstallTime, this.mUserId);
        return;
    }

    public void setRemovedAppId(int appId) {
        if (this.mRemovedInfo == null) goto L6;
        this.mRemovedInfo.mUid = appId;
        this.mRemovedInfo.mIsAppIdRemoved = true;
        return;
    }

    private void populateBroadcastUsers() {
        assertScanResultExists();
        this.mFirstTimeBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mFirstTimeBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        this.mUpdateBroadcastInstantUserIds = PackageManagerService.EMPTY_INT_ARRAY;
        boolean allNewUsers = isAllNewUsers();
        int r1 = 0;
        if (allNewUsers == false) goto L12;
        int[] r2 = this.mNewUsers;
        int r3 = r2.length;
    L5:
        if (r1 >= r3) goto L11;
        int newUser = r2[r1];
        if (this.mScanResult.mPkgSetting.getUserStateOrDefault(newUser).isInstantApp() == false) goto L9;
        this.mFirstTimeBroadcastInstantUserIds = ArrayUtils.appendInt(this.mFirstTimeBroadcastInstantUserIds, newUser);
    L10:
        r1 = r1 + 1;
        goto L5
    L9:
        this.mFirstTimeBroadcastUserIds = ArrayUtils.appendInt(this.mFirstTimeBroadcastUserIds, newUser);
        goto L10
    L11:
        return;
    L12:
        int[] r4 = this.mNewUsers;
        int r5 = r4.length;
    L13:
        if (r1 >= r5) goto L23;
        int newUser2 = r4[r1];
        boolean isFirstTimeUser = !ArrayUtils.contains(this.mOrigUsers, newUser2);
        boolean isInstantApp = this.mScanResult.mPkgSetting.getUserStateOrDefault(newUser2).isInstantApp();
        if (isFirstTimeUser == false) goto L19;
        if (isInstantApp == false) goto L18;
        this.mFirstTimeBroadcastInstantUserIds = ArrayUtils.appendInt(this.mFirstTimeBroadcastInstantUserIds, newUser2);
    L22:
        r1 = r1 + 1;
        goto L13
    L18:
        this.mFirstTimeBroadcastUserIds = ArrayUtils.appendInt(this.mFirstTimeBroadcastUserIds, newUser2);
        goto L22
    L19:
        if (isInstantApp == false) goto L21;
        this.mUpdateBroadcastInstantUserIds = ArrayUtils.appendInt(this.mUpdateBroadcastInstantUserIds, newUser2);
        goto L22
    L21:
        this.mUpdateBroadcastUserIds = ArrayUtils.appendInt(this.mUpdateBroadcastUserIds, newUser2);
        goto L22
    }

    public DomainSet getPreVerifiedDomains() {
        return this.mPreVerifiedDomains;
    }

    public void addWarning(String warning) {
        this.mWarnings.add(warning);
    }

    public void onPrepareStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(1);
        return;
    }

    public void onPrepareFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(1);
        return;
    }

    public void onScanStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(2);
        return;
    }

    public void onScanFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(2);
        return;
    }

    public void onReconcileStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(3);
        return;
    }

    public void onReconcileFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(3);
        return;
    }

    public void onCommitStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(4);
        return;
    }

    public void onCommitFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(4);
        return;
    }

    public void onRestoreStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(7);
        return;
    }

    public void onRestoreFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(7);
        return;
    }

    public void onWaitDexoptStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(8);
        return;
    }

    public void onWaitDexoptFinished() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(8);
        return;
    }

    public void onDexoptFinished(DexoptResult dexoptResult) {
        if (isInstallFromAdb() == false) goto L16;
        LinkedHashSet<String> externalProfileErrors = new LinkedHashSet();
        Iterator r1 = dexoptResult.getPackageDexoptResults().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        DexoptResult.PackageDexoptResult packageResult = (DexoptResult.PackageDexoptResult) r1.next();
        Iterator r3 = packageResult.getDexContainerFileDexoptResults().iterator();
    L9:
        if (r3.hasNext() == false) goto L6;
        DexoptResult.DexContainerFileDexoptResult fileResult = (DexoptResult.DexContainerFileDexoptResult) r3.next();
        externalProfileErrors.addAll(fileResult.getExternalProfileErrors());
        goto L9
    L13:
        if (externalProfileErrors.isEmpty() == true) goto L16;
        addWarning("Error occurred during dexopt when processing external profiles:\n  " + String.join("\n  ", externalProfileErrors));
    L16:
        if (this.mPackageMetrics == null) goto L33;
        this.mDexoptStatus = dexoptResult.getFinalStatus();
        if (this.mDexoptStatus != 20) goto L34;
        long durationMillis = 0;
        Iterator r2 = dexoptResult.getPackageDexoptResults().iterator();
    L21:
        if (r2.hasNext() == false) goto L27;
        DexoptResult.PackageDexoptResult packageResult2 = (DexoptResult.PackageDexoptResult) r2.next();
        Iterator r4 = packageResult2.getDexContainerFileDexoptResults().iterator();
    L24:
        if (r4.hasNext() == false) goto L21;
        DexoptResult.DexContainerFileDexoptResult fileResult2 = (DexoptResult.DexContainerFileDexoptResult) r4.next();
        durationMillis = durationMillis + fileResult2.getDex2oatWallTimeMillis();
        goto L24
    L27:
        this.mPackageMetrics.onStepFinished(5, durationMillis);
        return;
    L34:
        return;
    }

    public void onInstallCompleted() {
        if (getReturnCode() == 1) goto L5;
        return;
    L5:
        if (this.mPackageMetrics == null) goto L9;
        this.mPackageMetrics.onInstallSucceed();
        return;
    }

    public void onFreezeStarted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepStarted(6);
        return;
    }

    public void onFreezeCompleted() {
        if (this.mPackageMetrics == null) goto L6;
        this.mPackageMetrics.onStepFinished(6);
        return;
    }

    void setKeepArtProfile(boolean keepArtProfile) {
        this.mKeepArtProfile = keepArtProfile;
    }

    boolean isKeepArtProfile() {
        return this.mKeepArtProfile;
    }

    int getMissingSharedLibraryCount() {
        return this.mMissingSharedLibraryCount;
    }

    boolean isDependencyInstallerEnabled() {
        return this.mDependencyInstallerEnabled;
    }
}
