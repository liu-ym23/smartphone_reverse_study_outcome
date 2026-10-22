package com.android.server.pm;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.content.pm.SigningInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import android.os.UserHandle;
import android.os.incremental.IncrementalManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.permission.LegacyPermissionDataProvider;
import com.android.server.pm.permission.LegacyPermissionState;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.ArchiveState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUnserialized;
import com.android.server.pm.pkg.PackageUserState;
import com.android.server.pm.pkg.PackageUserStateImpl;
import com.android.server.pm.pkg.PackageUserStateInternal;
import com.android.server.pm.pkg.SharedLibrary;
import com.android.server.pm.pkg.SharedLibraryWrapper;
import com.android.server.pm.pkg.SuspendParams;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.SnapshotCache;
import com.android.server.utils.WatchedArraySet;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class PackageSetting extends SettingBase implements PackageStateInternal {
    private int categoryOverride;
    private InstallSource installSource;
    private PackageKeySetData keySetData;
    private long lastUpdateTime;

    @Deprecated
    private String legacyNativeLibraryPath;
    private int mAppId;
    private String mAppMetadataFilePath;
    private int mAppMetadataSource;
    private int mBaseRevisionCode;
    private int mBooleans;
    private String mCpuAbiOverride;
    private UUID mDomainSetId;
    private long mLastModifiedTime;
    private long mLoadingCompletedTime;
    private float mLoadingProgress;
    private String mName;
    private LinkedHashSet<File> mOldPaths;
    private int mPageSizeAppCompatFlags;
    private File mPath;
    private String mPathString;
    private String mPrimaryCpuAbi;
    private String mRealName;
    private byte[] mRestrictUpdateHash;
    private String mSecondaryCpuAbi;
    private int mSharedUserAppId;
    private final PackageSettingSmtEx mSmtEx;
    private final SnapshotCache<PackageSetting> mSnapshot;
    private String[] mSplitNames;
    private int[] mSplitRevisionCodes;
    private int mTargetSdkVersion;
    private final SparseArray<PackageUserStateImpl> mUserStates;
    private Map<String, Set<String>> mimeGroups;
    private AndroidPackageInternal pkg;
    private final PackageStateUnserialized pkgState;
    private PackageSignatures signatures;
    private String[] usesSdkLibraries;
    private boolean[] usesSdkLibrariesOptional;
    private long[] usesSdkLibrariesVersionsMajor;
    private String[] usesStaticLibraries;
    private long[] usesStaticLibrariesVersions;
    private long versionCode;
    private String volumeUuid;

    private static class Booleans {
        private static final int DEBUGGABLE = 32;
        private static final int FORCE_QUERYABLE_OVERRIDE = 4;
        private static final int INSTALL_PERMISSION_FIXED = 1;
        private static final int IS_LEAVING_SHARED_USER = 64;
        private static final int PENDING_RESTORE = 16;
        private static final int SCANNED_AS_STOPPED_SYSTEM_APP = 8;
        private static final int UPDATE_AVAILABLE = 2;

        public @interface Flags {
        }

        private Booleans() {
        }
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public /* bridge */ /* synthetic */ Set getOldPaths() {
        return getOldPaths();
    }

    @Override // com.android.server.utils.Snappable
    public /* bridge */ /* synthetic */ Object snapshot() {
        return snapshot();
    }

    private void setBoolean(int flag, boolean value) {
        if (value == false) goto L4;
        this.mBooleans |= flag;
        return;
    L4:
        this.mBooleans &= ~flag;
    }

    private boolean getBoolean(int flag) {
        if ((this.mBooleans & flag) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private SnapshotCache<PackageSetting> makeCache() {
        return new AnonymousClass1(this, this, this);
    }

    public PackageSetting(String name, String realName, File path, int pkgFlags, int pkgPrivateFlags, UUID domainSetId) {
        super(pkgFlags, pkgPrivateFlags);
        this.keySetData = new PackageKeySetData();
        this.mUserStates = new SparseArray();
        this.categoryOverride = -1;
        this.mPageSizeAppCompatFlags = 0;
        this.pkgState = new PackageStateUnserialized(this);
        this.mAppMetadataSource = 0;
        this.mSmtEx = new PackageSettingSmtEx(this);
        this.mName = name;
        this.mRealName = realName;
        this.mPath = path;
        this.mPathString = path.toString();
        this.signatures = new PackageSignatures();
        this.installSource = InstallSource.EMPTY;
        this.mDomainSetId = domainSetId;
        this.mSnapshot = makeCache();
    }

    PackageSetting(PackageSetting orig) {
        this(orig, false);
    }

    PackageSetting(PackageSetting base, String realPkgName) {
        this(base, false);
        this.mRealName = realPkgName;
    }

    public PackageSetting(PackageSetting original, boolean sealedSnapshot) {
        super(original);
        this.keySetData = new PackageKeySetData();
        this.mUserStates = new SparseArray();
        this.categoryOverride = -1;
        this.mPageSizeAppCompatFlags = 0;
        this.pkgState = new PackageStateUnserialized(this);
        this.mAppMetadataSource = 0;
        this.mSmtEx = new PackageSettingSmtEx(this);
        copyPackageSetting(original, sealedSnapshot);
        if (sealedSnapshot == false) goto L5;
        this.mSnapshot = new SnapshotCache.Sealed();
        return;
    L5:
        this.mSnapshot = makeCache();
    }

    @Override // com.android.server.utils.Snappable
    public PackageSetting snapshot() {
        return this.mSnapshot.snapshot();
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId, List<UserInfo> users, LegacyPermissionDataProvider dataProvider) {
        long packageToken = proto.start(fieldId);
        if (this.mRealName == null) goto L5;
        String r2 = this.mRealName;
    L6:
        proto.write(1138166333441L, r2);
        proto.write(1120986464258L, this.mAppId);
        proto.write(1120986464259L, this.versionCode);
        proto.write(1112396529670L, this.lastUpdateTime);
        proto.write(1138166333447L, this.installSource.mInstallerPackageName);
        if (this.pkg == null) goto L13;
        proto.write(1138166333444L, this.pkg.getVersionName());
        long splitToken = proto.start(2246267895816L);
        proto.write(1138166333441L, "base");
        proto.write(1120986464258L, this.pkg.getBaseRevisionCode());
        proto.end(splitToken);
        int i = 0;
    L10:
        if (i >= this.pkg.getSplitNames().length) goto L12;
        long splitToken2 = proto.start(2246267895816L);
        proto.write(1138166333441L, this.pkg.getSplitNames()[i]);
        proto.write(1120986464258L, this.pkg.getSplitRevisionCodes()[i]);
        proto.end(splitToken2);
        i = i + 1;
        goto L10
    L12:
        long sourceToken = proto.start(1146756268042L);
        proto.write(1138166333441L, this.installSource.mInitiatingPackageName);
        proto.write(1138166333442L, this.installSource.mOriginatingPackageName);
        proto.write(1138166333443L, this.installSource.mUpdateOwnerPackageName);
        proto.end(sourceToken);
    L13:
        proto.write(1133871366146L, isLoading());
        writeUsersInfoToProto(proto, 2246267895817L);
        writePackageUserPermissionsProto(proto, 2246267895820L, users, dataProvider);
        proto.end(packageToken);
        return;
    L5:
        r2 = this.mName;
        goto L6
    }

    public PackageSetting setAppId(int appId) {
        this.mAppId = appId;
        onChanged();
        return this;
    }

    public PackageSetting setCpuAbiOverride(String cpuAbiOverrideString) {
        this.mCpuAbiOverride = cpuAbiOverrideString;
        onChanged();
        return this;
    }

    public PackageSetting setFirstInstallTimeFromReplaced(PackageStateInternal replacedPkgSetting, int[] userIds) {
        int userId = 0;
    L4:
        if (userId >= userIds.length) goto L9;
        long previousFirstInstallTime = replacedPkgSetting.getUserStateOrDefault(userId).getFirstInstallTimeMillis();
        if (previousFirstInstallTime == 0) goto L8;
        modifyUserState(userId).setFirstInstallTimeMillis(previousFirstInstallTime);
    L8:
        userId = userId + 1;
        goto L4
    L9:
        onChanged();
        return this;
    }

    public PackageSetting setFirstInstallTime(long firstInstallTime, int userId) {
        if (userId != (-1)) goto L8;
        int userStateCount = this.mUserStates.size();
        int i = 0;
    L5:
        if (i >= userStateCount) goto L9;
        this.mUserStates.valueAt(i).setFirstInstallTimeMillis(firstInstallTime);
        i = i + 1;
    L9:
        onChanged();
        return this;
    L8:
        modifyUserState(userId).setFirstInstallTimeMillis(firstInstallTime);
        goto L9
    }

    public PackageSetting setForceQueryableOverride(boolean forceQueryableOverride) {
        setBoolean(4, forceQueryableOverride);
        onChanged();
        return this;
    }

    public PackageSetting setInstallerPackage(String installerPackageName, int installerPackageUid) {
        this.installSource = this.installSource.setInstallerPackage(installerPackageName, installerPackageUid);
        onChanged();
        return this;
    }

    public PackageSetting setUpdateOwnerPackage(String updateOwnerPackageName) {
        this.installSource = this.installSource.setUpdateOwnerPackageName(updateOwnerPackageName);
        onChanged();
        return this;
    }

    public PackageSetting setInstallSource(InstallSource installSource) {
        installSource.getClass();
        this.installSource = installSource;
        onChanged();
        return this;
    }

    PackageSetting removeInstallerPackage(String packageName) {
        this.installSource = this.installSource.removeInstallerPackage(packageName);
        onChanged();
        return this;
    }

    public PackageSetting setIsOrphaned(boolean isOrphaned) {
        this.installSource = this.installSource.setIsOrphaned(isOrphaned);
        onChanged();
        return this;
    }

    public PackageSetting setKeySetData(PackageKeySetData keySetData) {
        this.keySetData = keySetData;
        onChanged();
        return this;
    }

    public PackageSetting setLastModifiedTime(long timeStamp) {
        this.mLastModifiedTime = timeStamp;
        onChanged();
        return this;
    }

    public PackageSetting setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        onChanged();
        return this;
    }

    public PackageSetting setLongVersionCode(long versionCode) {
        this.versionCode = versionCode;
        onChanged();
        return this;
    }

    public boolean setMimeGroup(String mimeGroup, ArraySet<String> newMimeTypes) {
        if (this.mimeGroups != null) goto L5;
        Set<String> oldMimeTypes = null;
    L6:
        if (oldMimeTypes == null) goto L12;
        boolean hasChanges = !newMimeTypes.equals(oldMimeTypes);
        this.mimeGroups.put(mimeGroup, newMimeTypes);
        if (hasChanges == false) goto L10;
        onChanged();
    L10:
        return hasChanges;
    L12:
        throw new IllegalArgumentException("Unknown MIME group " + mimeGroup + " for package " + this.mName);
    L5:
        oldMimeTypes = this.mimeGroups.get(mimeGroup);
        goto L6
    }

    public PackageSetting setPkg(AndroidPackage pkg) {
        this.pkg = (AndroidPackageInternal) pkg;
        onChanged();
        return this;
    }

    public PackageSetting setPkgStateLibraryFiles(Collection<String> usesLibraryFiles) {
        Collection<String> oldUsesLibraryFiles = getUsesLibraryFiles();
        if (oldUsesLibraryFiles.size() == usesLibraryFiles.size()) goto L5;
    L6:
        this.pkgState.setUsesLibraryFiles(new ArrayList(usesLibraryFiles));
        onChanged();
    L7:
        return this;
    L5:
        if (oldUsesLibraryFiles.containsAll(usesLibraryFiles) == true) goto L7;
        goto L6
    }

    public PackageSetting setPrimaryCpuAbi(String primaryCpuAbiString) {
        this.mPrimaryCpuAbi = primaryCpuAbiString;
        onChanged();
        return this;
    }

    public PackageSetting setSecondaryCpuAbi(String secondaryCpuAbiString) {
        this.mSecondaryCpuAbi = secondaryCpuAbiString;
        onChanged();
        return this;
    }

    public PackageSetting setSignatures(PackageSignatures signatures) {
        this.signatures = signatures;
        onChanged();
        return this;
    }

    public PackageSetting setVolumeUuid(String volumeUuid) {
        this.volumeUuid = volumeUuid;
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isExternalStorage() {
        if ((getFlags() & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PackageSetting setUpdateAvailable(boolean updateAvailable) {
        setBoolean(2, updateAvailable);
        onChanged();
        return this;
    }

    public PackageSetting setSharedUserAppId(int sharedUserAppId) {
        this.mSharedUserAppId = sharedUserAppId;
        onChanged();
        return this;
    }

    public PackageSetting setTargetSdkVersion(int targetSdkVersion) {
        this.mTargetSdkVersion = targetSdkVersion;
        onChanged();
        return this;
    }

    public PackageSetting setRestrictUpdateHash(byte[] restrictUpdateHash) {
        this.mRestrictUpdateHash = restrictUpdateHash;
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public int getSharedUserAppId() {
        return this.mSharedUserAppId;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean hasSharedUser() {
        if (this.mSharedUserAppId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public PackageSetting setPendingRestore(boolean value) {
        setBoolean(16, value);
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isPendingRestore() {
        return getBoolean(16);
    }

    public PackageSetting setDebuggable(boolean value) {
        setBoolean(32, value);
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isDebuggable() {
        return getBoolean(32);
    }

    public PackageSetting setLeavingSharedUser(boolean value) {
        setBoolean(64, value);
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isLeavingSharedUser() {
        return getBoolean(64);
    }

    public PackageSetting setBaseRevisionCode(int value) {
        this.mBaseRevisionCode = value;
        onChanged();
        return this;
    }

    public int getBaseRevisionCode() {
        return this.mBaseRevisionCode;
    }

    public PackageSetting setSplitNames(String[] value) {
        this.mSplitNames = value;
        onChanged();
        return this;
    }

    public String[] getSplitNames() {
        if (this.pkg == null) goto L7;
        return this.pkg.getSplitNames();
    L7:
        if (this.mSplitNames != null) goto L10;
        return EmptyArray.STRING;
    L10:
        return this.mSplitNames;
    }

    public PackageSetting setSplitRevisionCodes(int[] value) {
        this.mSplitRevisionCodes = value;
        onChanged();
        return this;
    }

    public int[] getSplitRevisionCodes() {
        if (this.pkg == null) goto L7;
        return this.pkg.getSplitRevisionCodes();
    L7:
        if (this.mSplitRevisionCodes != null) goto L10;
        return EmptyArray.INT;
    L10:
        return this.mSplitRevisionCodes;
    }

    public String toString() {
        return "PackageSetting{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mName + SliceClientPermissions.SliceAuthority.DELIMITER + this.mAppId + "}";
    }

    private void copyMimeGroups(Map<String, Set<String>> newMimeGroups) {
        if (newMimeGroups != null) goto L5;
        this.mimeGroups = null;
        return;
    L5:
        this.mimeGroups = new ArrayMap(newMimeGroups.size());
        Iterator<String> r0 = newMimeGroups.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        String mimeGroup = r0.next();
        Set<String> mimeTypes = newMimeGroups.get(mimeGroup);
        if (mimeTypes != null) goto L10;
        this.mimeGroups.put(mimeGroup, new ArraySet());
        goto L7
    L10:
        this.mimeGroups.put(mimeGroup, new ArraySet(mimeTypes));
        goto L7
    }

    public void updateFrom(PackageSetting other) {
        copyPackageSetting(other, false);
        if (other.mimeGroups == null) goto L5;
        Set<String> mimeGroupNames = other.mimeGroups.keySet();
    L6:
        updateMimeGroups(mimeGroupNames);
        onChanged();
        return;
    L5:
        mimeGroupNames = null;
        goto L6
    }

    PackageSetting updateMimeGroups(Set<String> newMimeGroupNames) {
        if (newMimeGroupNames != null) goto L6;
        this.mimeGroups = null;
        return this;
    L6:
        if (this.mimeGroups != null) goto L8;
        this.mimeGroups = Collections.emptyMap();
    L8:
        ArrayMap<String, Set<String>> updatedMimeGroups = new ArrayMap(newMimeGroupNames.size());
        Iterator<String> r1 = newMimeGroupNames.iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        String mimeGroup = r1.next();
        if (this.mimeGroups.containsKey(mimeGroup) == true) goto L13;
        updatedMimeGroups.put(mimeGroup, new ArraySet());
        goto L10
    L13:
        updatedMimeGroups.put(mimeGroup, this.mimeGroups.get(mimeGroup));
        goto L10
    L16:
        onChanged();
        this.mimeGroups = updatedMimeGroups;
        return this;
    }

    @Override // com.android.server.pm.SettingBase, com.android.server.pm.pkg.PackageStateInternal
    @Deprecated
    public LegacyPermissionState getLegacyPermissionState() {
        return super.getLegacyPermissionState();
    }

    public PackageSetting setInstallPermissionsFixed(boolean installPermissionsFixed) {
        setBoolean(1, installPermissionsFixed);
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isPrivileged() {
        if ((getPrivateFlags() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isOem() {
        if ((getPrivateFlags() & 131072) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isVendor() {
        if ((getPrivateFlags() & 262144) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isProduct() {
        if ((getPrivateFlags() & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isRequiredForSystemUser() {
        if ((getPrivateFlags() & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isSystemExt() {
        if ((getPrivateFlags() & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isOdm() {
        if ((getPrivateFlags() & 1073741824) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isSystem() {
        if ((getFlags() & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRequestLegacyExternalStorage() {
        if ((getPrivateFlags() & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUserDataFragile() {
        if ((getPrivateFlags() & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public SigningDetails getSigningDetails() {
        return this.signatures.mSigningDetails;
    }

    public PackageSetting setSigningDetails(SigningDetails signingDetails) {
        this.signatures.mSigningDetails = signingDetails;
        onChanged();
        return this;
    }

    public void copyPackageSetting(PackageSetting other, boolean sealedSnapshot) {
        super.copySettingBase(other);
        this.mBooleans = other.mBooleans;
        this.mSharedUserAppId = other.mSharedUserAppId;
        this.mLoadingProgress = other.mLoadingProgress;
        this.mLoadingCompletedTime = other.mLoadingCompletedTime;
        this.legacyNativeLibraryPath = other.legacyNativeLibraryPath;
        this.mName = other.mName;
        this.mRealName = other.mRealName;
        this.mAppId = other.mAppId;
        this.pkg = other.pkg;
        this.mPath = other.mPath;
        this.mPathString = other.mPathString;
        long[] r1 = null;
        if (other.mOldPaths != null) goto L5;
        LinkedHashSet<File> r0 = null;
    L6:
        this.mOldPaths = r0;
        this.mPrimaryCpuAbi = other.mPrimaryCpuAbi;
        this.mSecondaryCpuAbi = other.mSecondaryCpuAbi;
        this.mCpuAbiOverride = other.mCpuAbiOverride;
        this.mLastModifiedTime = other.mLastModifiedTime;
        this.lastUpdateTime = other.lastUpdateTime;
        this.versionCode = other.versionCode;
        this.signatures = other.signatures;
        this.keySetData = new PackageKeySetData(other.keySetData);
        this.installSource = other.installSource;
        this.volumeUuid = other.volumeUuid;
        this.categoryOverride = other.categoryOverride;
        this.mDomainSetId = other.mDomainSetId;
        this.mAppMetadataFilePath = other.mAppMetadataFilePath;
        this.mAppMetadataSource = other.mAppMetadataSource;
        this.mTargetSdkVersion = other.mTargetSdkVersion;
        if (other.mRestrictUpdateHash != null) goto L9;
        byte[] r2 = null;
    L10:
        this.mRestrictUpdateHash = r2;
        this.mBaseRevisionCode = other.mBaseRevisionCode;
        if (other.mSplitNames == null) goto L13;
        String[] r3 = (String[]) Arrays.copyOf(other.mSplitNames, other.mSplitNames.length);
    L14:
        this.mSplitNames = r3;
        if (other.mSplitRevisionCodes == null) goto L17;
        int[] r4 = Arrays.copyOf(other.mSplitRevisionCodes, other.mSplitRevisionCodes.length);
    L18:
        this.mSplitRevisionCodes = r4;
        if (other.usesSdkLibraries == null) goto L21;
        String[] r5 = (String[]) Arrays.copyOf(other.usesSdkLibraries, other.usesSdkLibraries.length);
    L22:
        this.usesSdkLibraries = r5;
        if (other.usesSdkLibrariesVersionsMajor == null) goto L25;
        long[] r6 = Arrays.copyOf(other.usesSdkLibrariesVersionsMajor, other.usesSdkLibrariesVersionsMajor.length);
    L26:
        this.usesSdkLibrariesVersionsMajor = r6;
        if (other.usesSdkLibrariesOptional == null) goto L29;
        boolean[] r7 = Arrays.copyOf(other.usesSdkLibrariesOptional, other.usesSdkLibrariesOptional.length);
    L30:
        this.usesSdkLibrariesOptional = r7;
        if (other.usesStaticLibraries == null) goto L33;
        String[] r8 = (String[]) Arrays.copyOf(other.usesStaticLibraries, other.usesStaticLibraries.length);
    L34:
        this.usesStaticLibraries = r8;
        if (other.usesStaticLibrariesVersions == null) goto L38;
        r1 = Arrays.copyOf(other.usesStaticLibrariesVersions, other.usesStaticLibrariesVersions.length);
    L38:
        this.usesStaticLibrariesVersions = r1;
        this.mUserStates.clear();
        int i = 0;
    L40:
        if (i >= other.mUserStates.size()) goto L45;
        if (sealedSnapshot == false) goto L43;
        this.mUserStates.put(other.mUserStates.keyAt(i), other.mUserStates.valueAt(i).snapshot());
    L44:
        i = i + 1;
        goto L40
    L43:
        PackageUserStateImpl userState = other.mUserStates.valueAt(i);
        userState.setWatchable(this);
        this.mUserStates.put(other.mUserStates.keyAt(i), userState);
        goto L44
    L45:
        copyMimeGroups(other.mimeGroups);
        this.mPageSizeAppCompatFlags = other.mPageSizeAppCompatFlags;
        this.pkgState.updateFrom(other.pkgState);
        onChanged();
        return;
    L33:
        r8 = null;
        goto L34
    L29:
        r7 = null;
        goto L30
    L25:
        r6 = null;
        goto L26
    L21:
        r5 = null;
        goto L22
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = (byte[]) other.mRestrictUpdateHash.clone();
        goto L10
    L5:
        r0 = new LinkedHashSet(other.mOldPaths);
        goto L6
    }

    PackageUserStateImpl modifyUserState(int userId) {
        PackageUserStateImpl state = this.mUserStates.get(userId);
        if (state != null) goto L6;
        PackageUserStateImpl state2 = new PackageUserStateImpl(this);
        this.mUserStates.put(userId, state2);
        onChanged();
        return state2;
    L6:
        return state;
    }

    public PackageUserStateImpl getOrCreateUserState(int userId) {
        PackageUserStateImpl state = this.mUserStates.get(userId);
        if (state != null) goto L6;
        PackageUserStateImpl state2 = new PackageUserStateImpl(this);
        this.mUserStates.put(userId, state2);
        return state2;
    L6:
        return state;
    }

    public PackageUserStateInternal readUserState(int userId) {
        PackageUserStateInternal state = this.mUserStates.get(userId);
        if (state == null) goto L5;
        return state;
    L5:
        return PackageUserStateInternal.DEFAULT;
    }

    void setEnabled(int state, int userId, String callingPackage) {
        modifyUserState(userId).setEnabledState(state).setLastDisableAppCaller(callingPackage);
        onChanged();
    }

    int getEnabled(int userId) {
        return readUserState(userId).getEnabledState();
    }

    void setInstalled(boolean inst, int userId) {
        modifyUserState(userId).setInstalled(inst);
        onChanged();
    }

    void setArchiveState(ArchiveState archiveState, int userId) {
        modifyUserState(userId).setArchiveState(archiveState);
        onChanged();
    }

    boolean getInstalled(int userId) {
        return readUserState(userId).isInstalled();
    }

    boolean isArchived(int userId) {
        return PackageArchiver.isArchived(readUserState(userId));
    }

    boolean isArchivedOnAnyUser(int[] userIds) {
        int r0 = userIds.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        int user = userIds[r2];
        if (isArchived(user) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    int getInstallReason(int userId) {
        return readUserState(userId).getInstallReason();
    }

    void setInstallReason(int installReason, int userId) {
        modifyUserState(userId).setInstallReason(installReason);
        onChanged();
    }

    int getUninstallReason(int userId) {
        return readUserState(userId).getUninstallReason();
    }

    void setUninstallReason(int uninstallReason, int userId) {
        modifyUserState(userId).setUninstallReason(uninstallReason);
        onChanged();
    }

    OverlayPaths getOverlayPaths(int userId) {
        return readUserState(userId).getOverlayPaths();
    }

    boolean setOverlayPathsForLibrary(String libName, OverlayPaths overlayPaths, int userId) {
        boolean changed = modifyUserState(userId).setSharedLibraryOverlayPaths(libName, overlayPaths);
        onChanged();
        return changed;
    }

    boolean isInstalledOnAnyOtherUser(int[] allUsers, int currentUser) {
        int r0 = allUsers.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int user = allUsers[r2];
        if (user == currentUser) goto L11;
        PackageUserStateInternal userState = readUserState(user);
        if (userState.isInstalled() == false) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    boolean hasDataOnAnyOtherUser(int[] allUsers, int currentUser) {
        int r0 = allUsers.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        int user = allUsers[r2];
        if (user == currentUser) goto L11;
        PackageUserStateInternal userState = readUserState(user);
        if (userState.dataExists() == false) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    int[] queryInstalledUsers(int[] users, boolean installed) {
        IntArray installedUsers = new IntArray(users.length);
        int r1 = users.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        int user = users[r2];
        if (getInstalled(user) != installed) goto L7;
        installedUsers.add(user);
    L7:
        r2 = r2 + 1;
        goto L3
    L9:
        return installedUsers.toArray();
    }

    int[] queryUsersInstalledOrHasData(int[] users) {
        IntArray usersInstalledOrHasData = new IntArray(users.length);
        int r1 = users.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L11;
        int user = users[r2];
        if (getInstalled(user) == false) goto L7;
    L8:
        usersInstalledOrHasData.add(user);
    L9:
        r2 = r2 + 1;
        goto L3
    L7:
        if (readUserState(user).dataExists() == false) goto L9;
    L11:
        return usersInstalledOrHasData.toArray();
    }

    long getCeDataInode(int userId) {
        return readUserState(userId).getCeDataInode();
    }

    long getDeDataInode(int userId) {
        return readUserState(userId).getDeDataInode();
    }

    void setCeDataInode(long ceDataInode, int userId) {
        modifyUserState(userId).setCeDataInode(ceDataInode);
        onChanged();
    }

    void setDeDataInode(long deDataInode, int userId) {
        modifyUserState(userId).setDeDataInode(deDataInode);
        onChanged();
    }

    boolean getStopped(int userId) {
        return readUserState(userId).isStopped();
    }

    void setStopped(boolean stop, int userId) {
        modifyUserState(userId).setStopped(stop);
        onChanged();
    }

    public PackageSetting setScannedAsStoppedSystemApp(boolean stop) {
        setBoolean(8, stop);
        onChanged();
        return this;
    }

    boolean getNotLaunched(int userId) {
        return readUserState(userId).isNotLaunched();
    }

    void setNotLaunched(boolean stop, int userId) {
        modifyUserState(userId).setNotLaunched(stop);
        onChanged();
    }

    boolean getHidden(int userId) {
        return readUserState(userId).isHidden();
    }

    void setHidden(boolean hidden, int userId) {
        modifyUserState(userId).setHidden(hidden);
        onChanged();
    }

    int getDistractionFlags(int userId) {
        return readUserState(userId).getDistractionFlags();
    }

    void setDistractionFlags(int distractionFlags, int userId) {
        modifyUserState(userId).setDistractionFlags(distractionFlags);
        onChanged();
    }

    public boolean getInstantApp(int userId) {
        return readUserState(userId).isInstantApp();
    }

    void setInstantApp(boolean instantApp, int userId) {
        modifyUserState(userId).setInstantApp(instantApp);
        onChanged();
    }

    boolean getVirtualPreload(int userId) {
        return readUserState(userId).isVirtualPreload();
    }

    void setVirtualPreload(boolean virtualPreload, int userId) {
        modifyUserState(userId).setVirtualPreload(virtualPreload);
        onChanged();
    }

    void setUserState(int userId, long ceDataInode, long deDataInode, int enabled, boolean installed, boolean stopped, boolean notLaunched, boolean hidden, int distractionFlags, ArrayMap<UserPackage, SuspendParams> suspendParams, boolean instantApp, boolean virtualPreload, String lastDisableAppCaller, ArraySet<String> enabledComponents, ArraySet<String> disabledComponents, int installReason, int uninstallReason, String harmfulAppWarning, String splashScreenTheme, long firstInstallTime, int aspectRatio, ArchiveState archiveState) {
        modifyUserState(userId).setSuspendParams(suspendParams).setCeDataInode(ceDataInode).setDeDataInode(deDataInode).setEnabledState(enabled).setInstalled(installed).setStopped(stopped).setNotLaunched(notLaunched).setHidden(hidden).setDistractionFlags(distractionFlags).setLastDisableAppCaller(lastDisableAppCaller).setEnabledComponents(enabledComponents).setDisabledComponents(disabledComponents).setInstallReason(installReason).setUninstallReason(uninstallReason).setInstantApp(instantApp).setVirtualPreload(virtualPreload).setHarmfulAppWarning(harmfulAppWarning).setSplashScreenTheme(splashScreenTheme).setFirstInstallTimeMillis(firstInstallTime).setMinAspectRatio(aspectRatio).setArchiveState(archiveState);
        onChanged();
    }

    void setUserState(int userId, PackageUserStateInternal otherState) {
        long r2 = otherState.getCeDataInode();
        long r4 = otherState.getDeDataInode();
        int r6 = otherState.getEnabledState();
        boolean r7 = otherState.isInstalled();
        boolean r8 = otherState.isStopped();
        boolean r9 = otherState.isNotLaunched();
        boolean r10 = otherState.isHidden();
        int r11 = otherState.getDistractionFlags();
        ArraySet<String> r1 = null;
        if (otherState.getSuspendParams() != null) goto L5;
        ArrayMap<UserPackage, SuspendParams> r12 = null;
    L6:
        boolean r13 = otherState.isInstantApp();
        boolean r14 = otherState.isVirtualPreload();
        String r15 = otherState.getLastDisableAppCaller();
        if (otherState.getEnabledComponentsNoCopy() != null) goto L9;
        ArraySet<String> r16 = null;
    L11:
        if (otherState.getDisabledComponentsNoCopy() == null) goto L14;
        r1 = otherState.getDisabledComponentsNoCopy().untrackedStorage();
    L14:
        setUserState(userId, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r1, otherState.getInstallReason(), otherState.getUninstallReason(), otherState.getHarmfulAppWarning(), otherState.getSplashScreenTheme(), otherState.getFirstInstallTimeMillis(), otherState.getMinAspectRatio(), otherState.getArchiveState());
        return;
    L9:
        r16 = otherState.getEnabledComponentsNoCopy().untrackedStorage();
        goto L11
    L5:
        r12 = otherState.getSuspendParams().untrackedStorage();
        goto L6
    }

    WatchedArraySet<String> getEnabledComponents(int userId) {
        return readUserState(userId).getEnabledComponentsNoCopy();
    }

    WatchedArraySet<String> getDisabledComponents(int userId) {
        return readUserState(userId).getDisabledComponentsNoCopy();
    }

    void setEnabledComponents(WatchedArraySet<String> components, int userId) {
        modifyUserState(userId).setEnabledComponents(components);
        onChanged();
    }

    void setDisabledComponents(WatchedArraySet<String> components, int userId) {
        modifyUserState(userId).setDisabledComponents(components);
        onChanged();
    }

    void setEnabledComponentsCopy(WatchedArraySet<String> components, int userId) {
        PackageUserStateImpl r0 = modifyUserState(userId);
        if (components == null) goto L5;
        ArraySet<String> r1 = components.untrackedStorage();
    L6:
        r0.setEnabledComponents(r1);
        onChanged();
        return;
    L5:
        r1 = null;
        goto L6
    }

    void setDisabledComponentsCopy(WatchedArraySet<String> components, int userId) {
        PackageUserStateImpl r0 = modifyUserState(userId);
        if (components == null) goto L5;
        ArraySet<String> r1 = components.untrackedStorage();
    L6:
        r0.setDisabledComponents(r1);
        onChanged();
        return;
    L5:
        r1 = null;
        goto L6
    }

    PackageUserStateImpl modifyUserStateComponents(int userId, boolean disabled, boolean enabled) {
        PackageUserStateImpl state = modifyUserState(userId);
        boolean changed = false;
        if (disabled == true) goto L5;
    L7:
        if (enabled == true) goto L9;
    L11:
        if (changed == false) goto L13;
        onChanged();
    L13:
        return state;
    L9:
        if (state.getEnabledComponentsNoCopy() != null) goto L11;
        state.setEnabledComponents(new ArraySet(1));
        changed = true;
        goto L11
    L5:
        if (state.getDisabledComponentsNoCopy() != null) goto L7;
        state.setDisabledComponents(new ArraySet(1));
        changed = true;
        goto L7
    }

    void addDisabledComponent(String componentClassName, int userId) {
        modifyUserStateComponents(userId, true, false).getDisabledComponentsNoCopy().add(componentClassName);
        onChanged();
    }

    void addEnabledComponent(String componentClassName, int userId) {
        modifyUserStateComponents(userId, false, true).getEnabledComponentsNoCopy().add(componentClassName);
        onChanged();
    }

    boolean enableComponentLPw(String componentClassName, int userId) {
        boolean changed = false;
        PackageUserStateImpl state = modifyUserStateComponents(userId, false, true);
        if (state.getDisabledComponentsNoCopy() == null) goto L6;
        changed = state.getDisabledComponentsNoCopy().remove(componentClassName);
    L6:
        boolean changed2 = changed | state.getEnabledComponentsNoCopy().add(componentClassName);
        if (changed2 == false) goto L9;
        onChanged();
    L9:
        return changed2;
    }

    boolean disableComponentLPw(String componentClassName, int userId) {
        boolean changed = false;
        PackageUserStateImpl state = modifyUserStateComponents(userId, true, false);
        if (state.getEnabledComponentsNoCopy() == null) goto L6;
        changed = state.getEnabledComponentsNoCopy().remove(componentClassName);
    L6:
        boolean changed2 = changed | state.getDisabledComponentsNoCopy().add(componentClassName);
        if (changed2 == false) goto L9;
        onChanged();
    L9:
        return changed2;
    }

    boolean restoreComponentLPw(String componentClassName, int userId) {
        PackageUserStateImpl state = modifyUserStateComponents(userId, true, true);
        boolean r2 = false;
        if (state.getDisabledComponentsNoCopy() == null) goto L5;
        boolean changed = state.getDisabledComponentsNoCopy().remove(componentClassName);
    L7:
        if (state.getEnabledComponentsNoCopy() == null) goto L10;
        r2 = state.getEnabledComponentsNoCopy().remove(componentClassName);
    L10:
        boolean changed2 = changed | r2;
        if (changed2 == false) goto L13;
        onChanged();
    L13:
        return changed2;
    L5:
        changed = false;
        goto L7
    }

    void restoreComponentSettings(int userId) {
        PackageUserStateImpl state = modifyUserStateComponents(userId, true, true);
        WatchedArraySet<String> enabledComponents = state.getEnabledComponentsNoCopy();
        WatchedArraySet<String> disabledComponents = state.getDisabledComponentsNoCopy();
        boolean changed = false;
        int i = enabledComponents.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (AndroidPackageUtils.hasComponentClassName(this.pkg, enabledComponents.valueAt(i)) == true) goto L7;
        enabledComponents.removeAt(i);
        changed = true;
    L7:
        i = i - 1;
        goto L3
    L8:
        int i2 = disabledComponents.size();
        int i3 = i2 - 1;
    L9:
        if (i3 < 0) goto L15;
        if (AndroidPackageUtils.hasComponentClassName(this.pkg, disabledComponents.valueAt(i3)) == true) goto L13;
        disabledComponents.removeAt(i3);
        changed = true;
    L13:
        i3 = i3 - 1;
        goto L9
    L15:
        if (changed == false) goto L24;
        onChanged();
        return;
    }

    int getCurrentEnabledStateLPr(String componentName, int userId) {
        PackageUserStateInternal state = readUserState(userId);
        if (state.getEnabledComponentsNoCopy() == null) goto L9;
        if (state.getEnabledComponentsNoCopy().contains(componentName) == false) goto L9;
        return 1;
    L9:
        if (state.getDisabledComponentsNoCopy() != null) goto L11;
        return 0;
    L11:
        if (state.getDisabledComponentsNoCopy().contains(componentName) == false) goto L16;
        return 2;
    L16:
        return 0;
    }

    void removeUser(int userId) {
        this.mUserStates.delete(userId);
        onChanged();
    }

    public int[] getNotInstalledUserIds() {
        int userStateCount = this.mUserStates.size();
        IntArray notInstalledUsers = new IntArray(userStateCount);
        int i = 0;
    L3:
        if (i >= userStateCount) goto L9;
        if (this.mUserStates.valueAt(i).isInstalled() == true) goto L7;
        notInstalledUsers.add(this.mUserStates.keyAt(i));
    L7:
        i = i + 1;
        goto L3
    L9:
        return notInstalledUsers.toArray();
    }

    void writePackageUserPermissionsProto(ProtoOutputStream proto, long fieldId, List<UserInfo> users, LegacyPermissionDataProvider dataProvider) {
        Iterator<UserInfo> r0 = users.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        UserInfo user = r0.next();
        long permissionsToken = proto.start(2246267895820L);
        proto.write(1120986464257L, user.id);
        Collection<LegacyPermissionState.PermissionState> runtimePermissionStates = dataProvider.getLegacyPermissionState(this.mAppId).getPermissionStates(user.id);
        Iterator<LegacyPermissionState.PermissionState> r5 = runtimePermissionStates.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        LegacyPermissionState.PermissionState permission = r5.next();
        if (permission.isGranted() == false) goto L7;
        proto.write(2237677961218L, permission.getName());
        goto L7
    L12:
        proto.end(permissionsToken);
        goto L4
    }

    protected void writeUsersInfoToProto(ProtoOutputStream proto, long fieldId) {
        int count = this.mUserStates.size();
        int i = 0;
    L3:
        if (i >= count) goto L19;
        long userToken = proto.start(fieldId);
        int userId = this.mUserStates.keyAt(i);
        PackageUserStateInternal state = this.mUserStates.valueAt(i);
        proto.write(1120986464257L, userId);
        if (state.isInstantApp() == false) goto L8;
        int installType = 2;
    L11:
        proto.write(1159641169922L, installType);
        proto.write(1133871366147L, state.isHidden());
        proto.write(1120986464266L, state.getDistractionFlags());
        proto.write(1133871366148L, state.isSuspended());
        if (state.isSuspended() == false) goto L17;
        int j = 0;
    L15:
        if (j >= state.getSuspendParams().size()) goto L17;
        proto.write(2237677961225L, state.getSuspendParams().keyAt(j).packageName);
        j = j + 1;
    L17:
        proto.write(1133871366149L, state.isStopped());
        proto.write(1133871366150L, !state.isNotLaunched());
        proto.write(1159641169927L, state.getEnabledState());
        proto.write(1138166333448L, state.getLastDisableAppCaller());
        proto.write(1120986464267L, state.getFirstInstallTimeMillis());
        writeArchiveState(proto, state.getArchiveState());
        proto.end(userToken);
        i = i + 1;
        goto L3
    L8:
        if (state.isInstalled() == false) goto L10;
        installType = 1;
        goto L11
    L10:
        installType = 0;
        goto L11
    }

    private static void writeArchiveState(ProtoOutputStream proto, ArchiveState archiveState) {
        if (archiveState != null) goto L4;
        return;
    L4:
        long archiveStateToken = proto.start(1146756268044L);
        Iterator<ArchiveState.ArchiveActivityInfo> r2 = archiveState.getActivityInfos().iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        ArchiveState.ArchiveActivityInfo activityInfo = r2.next();
        long activityInfoToken = proto.start(2246267895809L);
        proto.write(1138166333441L, activityInfo.getTitle());
        proto.write(1138166333444L, activityInfo.getOriginalComponentName().flattenToString());
        if (activityInfo.getIconBitmap() == null) goto L11;
        proto.write(1138166333442L, activityInfo.getIconBitmap().toAbsolutePath().toString());
    L11:
        if (activityInfo.getMonochromeIconBitmap() == null) goto L13;
        proto.write(1138166333443L, activityInfo.getMonochromeIconBitmap().toAbsolutePath().toString());
    L13:
        proto.end(activityInfoToken);
        goto L6
    L14:
        proto.write(1138166333442L, archiveState.getInstallerTitle());
        proto.end(archiveStateToken);
    }

    public PackageSetting setPath(File path) {
        this.mPath = path;
        this.mPathString = path.toString();
        onChanged();
        return this;
    }

    public PackageSetting addOldPath(File path) {
        if (this.mOldPaths != null) goto L5;
        this.mOldPaths = new LinkedHashSet();
    L5:
        this.mOldPaths.add(path);
        onChanged();
        return this;
    }

    public PackageSetting removeOldPath(File path) {
        if (path != null) goto L4;
    L10:
        return this;
    L4:
        if (this.mOldPaths == null) goto L10;
        if (this.mOldPaths.remove(path) == false) goto L9;
        onChanged();
    L9:
        return this;
    }

    public boolean overrideNonLocalizedLabelAndIcon(ComponentName component, String label, Integer icon, int userId) {
        boolean changed = modifyUserState(userId).overrideLabelAndIcon(component, label, icon);
        onChanged();
        return changed;
    }

    public void resetOverrideComponentLabelIcon(int userId) {
        modifyUserState(userId).resetOverrideComponentLabelIcon();
        onChanged();
    }

    public String getSplashScreenTheme(int userId) {
        return readUserState(userId).getSplashScreenTheme();
    }

    public boolean isIncremental() {
        return IncrementalManager.isIncrementalPath(this.mPathString);
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public boolean isLoading() {
        if (Math.abs(1.0f - this.mLoadingProgress) < 1.0E-8f) goto L5;
        return true;
    L5:
        return false;
    }

    public PackageSetting setLoadingProgress(float progress) {
        if (this.mLoadingProgress >= progress) goto L5;
        this.mLoadingProgress = progress;
        onChanged();
    L5:
        return this;
    }

    public PackageSetting setLoadingCompletedTime(long loadingCompletedTime) {
        this.mLoadingCompletedTime = loadingCompletedTime;
        onChanged();
        return this;
    }

    public PackageSetting setAppMetadataFilePath(String path) {
        this.mAppMetadataFilePath = path;
        onChanged();
        return this;
    }

    public PackageSetting setAppMetadataSource(int source) {
        this.mAppMetadataSource = source;
        onChanged();
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long getVersionCode() {
        return this.versionCode;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public Map<String, Set<String>> getMimeGroups() {
        if (CollectionUtils.isEmpty(this.mimeGroups) == false) goto L6;
        return Collections.emptyMap();
    L6:
        return Collections.unmodifiableMap(this.mimeGroups);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getPackageName() {
        return this.mName;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public AndroidPackage getAndroidPackage() {
        return getPkg();
    }

    @Override // com.android.server.pm.pkg.PackageState
    public SigningInfo getSigningInfo() {
        return new SigningInfo(this.signatures.mSigningDetails);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String[] getUsesSdkLibraries() {
        if (this.usesSdkLibraries != null) goto L6;
        return EmptyArray.STRING;
    L6:
        return this.usesSdkLibraries;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long[] getUsesSdkLibrariesVersionsMajor() {
        if (this.usesSdkLibrariesVersionsMajor != null) goto L6;
        return EmptyArray.LONG;
    L6:
        return this.usesSdkLibrariesVersionsMajor;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean[] getUsesSdkLibrariesOptional() {
        if (this.usesSdkLibrariesOptional != null) goto L6;
        return EmptyArray.BOOLEAN;
    L6:
        return this.usesSdkLibrariesOptional;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String[] getUsesStaticLibraries() {
        if (this.usesStaticLibraries != null) goto L6;
        return EmptyArray.STRING;
    L6:
        return this.usesStaticLibraries;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long[] getUsesStaticLibrariesVersions() {
        if (this.usesStaticLibrariesVersions != null) goto L6;
        return EmptyArray.LONG;
    L6:
        return this.usesStaticLibrariesVersions;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public List<SharedLibrary> getSharedLibraryDependencies() {
        return Collections.unmodifiableList(this.pkgState.getUsesLibraryInfos());
    }

    public PackageSetting addUsesLibraryInfo(SharedLibraryInfo value) {
        this.pkgState.addUsesLibraryInfo(new SharedLibraryWrapper(value));
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public List<String> getUsesLibraryFiles() {
        return Collections.unmodifiableList(this.pkgState.getUsesLibraryFiles());
    }

    public PackageSetting addUsesLibraryFile(String value) {
        this.pkgState.addUsesLibraryFile(value);
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isHiddenUntilInstalled() {
        return this.pkgState.isHiddenUntilInstalled();
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long[] getLastPackageUsageTime() {
        return this.pkgState.getLastPackageUsageTimeInMills();
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isUpdatedSystemApp() {
        return this.pkgState.isUpdatedSystemApp();
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isApkInUpdatedApex() {
        return this.pkgState.isApkInUpdatedApex();
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getApexModuleName() {
        return this.pkgState.getApexModuleName();
    }

    public PackageSetting setDomainSetId(UUID domainSetId) {
        this.mDomainSetId = domainSetId;
        onChanged();
        return this;
    }

    public PackageSetting setCategoryOverride(int categoryHint) {
        this.categoryOverride = categoryHint;
        onChanged();
        return this;
    }

    public PackageSetting setPageSizeAppCompatFlags(int mode) {
        if (mode < 0) goto L14;
        if (mode >= 128) goto L14;
        this.mPageSizeAppCompatFlags |= mode;
        if (8 != mode) goto L9;
        this.mPageSizeAppCompatFlags &= -17;
    L11:
        onChanged();
        return this;
    L9:
        if (16 != mode) goto L11;
        this.mPageSizeAppCompatFlags &= -9;
    L14:
        throw new IllegalArgumentException("Invalid page size compat mode specified");
    }

    public int getPageSizeAppCompatFlags() {
        return this.mPageSizeAppCompatFlags;
    }

    public PackageSetting setLegacyNativeLibraryPath(String legacyNativeLibraryPathString) {
        this.legacyNativeLibraryPath = legacyNativeLibraryPathString;
        onChanged();
        return this;
    }

    public PackageSetting setMimeGroups(Map<String, Set<String>> mimeGroups) {
        if (mimeGroups == null) goto L4;
        copyMimeGroups(mimeGroups);
        onChanged();
    L4:
        return this;
    }

    public PackageSetting setUsesSdkLibraries(String[] usesSdkLibraries) {
        this.usesSdkLibraries = usesSdkLibraries;
        onChanged();
        return this;
    }

    public PackageSetting setUsesSdkLibrariesVersionsMajor(long[] usesSdkLibrariesVersions) {
        this.usesSdkLibrariesVersionsMajor = usesSdkLibrariesVersions;
        onChanged();
        return this;
    }

    public PackageSetting setUsesSdkLibrariesOptional(boolean[] usesSdkLibrariesOptional) {
        this.usesSdkLibrariesOptional = usesSdkLibrariesOptional;
        onChanged();
        return this;
    }

    public PackageSetting setUsesStaticLibraries(String[] usesStaticLibraries) {
        this.usesStaticLibraries = usesStaticLibraries;
        onChanged();
        return this;
    }

    public PackageSetting setUsesStaticLibrariesVersions(long[] usesStaticLibrariesVersions) {
        this.usesStaticLibrariesVersions = usesStaticLibrariesVersions;
        onChanged();
        return this;
    }

    public PackageSetting setApexModuleName(String apexModuleName) {
        this.pkgState.setApexModuleName(apexModuleName);
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public PackageStateUnserialized getTransientState() {
        return this.pkgState;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal, com.android.server.pm.pkg.PackageState
    public SparseArray<? extends PackageUserStateInternal> getUserStates() {
        return this.mUserStates;
    }

    public PackageSetting addMimeTypes(String mimeGroup, Set<String> mimeTypes) {
        if (this.mimeGroups != null) goto L5;
        this.mimeGroups = new ArrayMap();
    L5:
        Set<String> existingMimeTypes = this.mimeGroups.get(mimeGroup);
        if (existingMimeTypes != null) goto L8;
        existingMimeTypes = new ArraySet();
        this.mimeGroups.put(mimeGroup, existingMimeTypes);
    L8:
        existingMimeTypes.addAll(mimeTypes);
        return this;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public PackageUserState getStateForUser(UserHandle user) {
        PackageUserState userState = getUserStates().get(user.getIdentifier());
        if (userState != null) goto L6;
        return PackageUserState.DEFAULT;
    L6:
        return userState;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getPrimaryCpuAbi() {
        if (TextUtils.isEmpty(this.mPrimaryCpuAbi) == false) goto L9;
        if (this.pkg == null) goto L9;
        return AndroidPackageUtils.getRawPrimaryCpuAbi(this.pkg);
    L9:
        return this.mPrimaryCpuAbi;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getSecondaryCpuAbi() {
        if (TextUtils.isEmpty(this.mSecondaryCpuAbi) == false) goto L9;
        if (this.pkg == null) goto L9;
        return AndroidPackageUtils.getRawSecondaryCpuAbi(this.pkg);
    L9:
        return this.mSecondaryCpuAbi;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getSeInfo() {
        String overrideSeInfo = getTransientState().getOverrideSeInfo();
        if (TextUtils.isEmpty(overrideSeInfo) == true) goto L6;
        return overrideSeInfo;
    L6:
        return getTransientState().getSeInfo();
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public String getPrimaryCpuAbiLegacy() {
        return this.mPrimaryCpuAbi;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public String getSecondaryCpuAbiLegacy() {
        return this.mSecondaryCpuAbi;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public int getHiddenApiEnforcementPolicy() {
        return AndroidPackageUtils.getHiddenApiEnforcementPolicy(getAndroidPackage(), this);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isApex() {
        if (getAndroidPackage() != null) goto L5;
    L7:
        return false;
    L5:
        if (getAndroidPackage().isApex() == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isForceQueryableOverride() {
        return getBoolean(4);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isUpdateAvailable() {
        return getBoolean(2);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isInstallPermissionsFixed() {
        return getBoolean(1);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isDefaultToDeviceProtectedStorage() {
        if ((getPrivateFlags() & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isPersistent() {
        if ((getFlags() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isScannedAsStoppedSystemApp() {
        return getBoolean(8);
    }

    @Override // com.android.server.pm.pkg.PackageState
    public boolean isPageSizeAppCompatEnabled() {
        if ((this.mPageSizeAppCompatFlags & 64) == 0) goto L5;
        boolean manifestOverrideDisabled = true;
    L7:
        if ((this.mPageSizeAppCompatFlags & 16) == 0) goto L9;
        boolean settingsOverrideDisabled = true;
    L10:
        if (manifestOverrideDisabled == true) goto L18;
        if (settingsOverrideDisabled == true) goto L18;
        if ((this.mPageSizeAppCompatFlags & 44) == 0) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    L9:
        settingsOverrideDisabled = false;
        goto L10
    L5:
        manifestOverrideDisabled = false;
        goto L7
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getPageSizeCompatWarningMessage(Context context) {
        boolean elfNotAligned = false;
        if ((this.mPageSizeAppCompatFlags & 32) == 0) goto L5;
        boolean manifestOverrideEnabled = true;
    L7:
        if ((this.mPageSizeAppCompatFlags & 8) == 0) goto L9;
        boolean settingsOverrideEnabled = true;
    L11:
        if ((this.mPageSizeAppCompatFlags & 16) == 0) goto L13;
        boolean settingsOverrideDisabled = true;
    L15:
        if (manifestOverrideEnabled == true) goto L37;
        if (settingsOverrideEnabled == true) goto L37;
        if (settingsOverrideDisabled == true) goto L37;
        if ((this.mPageSizeAppCompatFlags & 2) == 0) goto L22;
        boolean uncompressedLibsNotAligned = true;
    L24:
        if ((this.mPageSizeAppCompatFlags & 4) == 0) goto L26;
        elfNotAligned = true;
    L26:
        if (uncompressedLibsNotAligned == false) goto L30;
        if (elfNotAligned == false) goto L30;
        return context.getText(R.string.permdesc_vibrate).toString();
    L30:
        if (uncompressedLibsNotAligned == true) goto L32;
        if (elfNotAligned == true) goto L35;
        return null;
    L35:
        return context.getText(R.string.permdesc_videoWrite).toString();
    L32:
        return context.getText(R.string.permdesc_vibrator_state).toString();
    L22:
        uncompressedLibsNotAligned = false;
    L37:
        return null;
    L13:
        settingsOverrideDisabled = false;
        goto L15
    L9:
        settingsOverrideEnabled = false;
        goto L11
    L5:
        manifestOverrideEnabled = false;
        goto L7
    }

    @Deprecated
    public String getLegacyNativeLibraryPath() {
        return this.legacyNativeLibraryPath;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public String getRealName() {
        return this.mRealName;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public AndroidPackageInternal getPkg() {
        return this.pkg;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public File getPath() {
        return this.mPath;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public String getPathString() {
        return this.mPathString;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public LinkedHashSet<File> getOldPaths() {
        return this.mOldPaths;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public float getLoadingProgress() {
        return this.mLoadingProgress;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public long getLoadingCompletedTime() {
        return this.mLoadingCompletedTime;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getCpuAbiOverride() {
        return this.mCpuAbiOverride;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long getLastModifiedTime() {
        return this.mLastModifiedTime;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public PackageSignatures getSignatures() {
        return this.signatures;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public PackageKeySetData getKeySetData() {
        return this.keySetData;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public InstallSource getInstallSource() {
        return this.installSource;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public String getVolumeUuid() {
        return this.volumeUuid;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public int getCategoryOverride() {
        return this.categoryOverride;
    }

    public PackageStateUnserialized getPkgState() {
        return this.pkgState;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public UUID getDomainSetId() {
        return this.mDomainSetId;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public String getAppMetadataFilePath() {
        return this.mAppMetadataFilePath;
    }

    @Override // com.android.server.pm.pkg.PackageStateInternal
    public int getAppMetadataSource() {
        return this.mAppMetadataSource;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public int getTargetSdkVersion() {
        return this.mTargetSdkVersion;
    }

    @Override // com.android.server.pm.pkg.PackageState
    public byte[] getRestrictUpdateHash() {
        return this.mRestrictUpdateHash;
    }

    @Deprecated
    private void __metadata() {
    }

    public PackageSettingSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
