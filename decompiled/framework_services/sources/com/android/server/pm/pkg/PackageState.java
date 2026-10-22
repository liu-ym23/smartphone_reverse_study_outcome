package com.android.server.pm.pkg;

import android.annotation.SystemApi;
import android.content.Context;
import android.content.pm.SigningInfo;
import android.os.UserHandle;
import android.util.SparseArray;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public interface PackageState {
    AndroidPackage getAndroidPackage();

    String getApexModuleName();

    int getAppId();

    int getCategoryOverride();

    String getCpuAbiOverride();

    int getHiddenApiEnforcementPolicy();

    long getLastModifiedTime();

    long[] getLastPackageUsageTime();

    long getLastUpdateTime();

    Map<String, Set<String>> getMimeGroups();

    String getPackageName();

    String getPageSizeCompatWarningMessage(Context r1);

    File getPath();

    String getPrimaryCpuAbi();

    byte[] getRestrictUpdateHash();

    String getSeInfo();

    String getSecondaryCpuAbi();

    List<SharedLibrary> getSharedLibraryDependencies();

    int getSharedUserAppId();

    SigningInfo getSigningInfo();

    PackageUserState getStateForUser(UserHandle r1);

    int getTargetSdkVersion();

    SparseArray<? extends PackageUserState> getUserStates();

    List<String> getUsesLibraryFiles();

    String[] getUsesSdkLibraries();

    boolean[] getUsesSdkLibrariesOptional();

    long[] getUsesSdkLibrariesVersionsMajor();

    String[] getUsesStaticLibraries();

    long[] getUsesStaticLibrariesVersions();

    long getVersionCode();

    String getVolumeUuid();

    boolean hasSharedUser();

    boolean isApex();

    boolean isApkInUpdatedApex();

    boolean isDebuggable();

    boolean isDefaultToDeviceProtectedStorage();

    boolean isExternalStorage();

    boolean isForceQueryableOverride();

    boolean isHiddenUntilInstalled();

    boolean isInstallPermissionsFixed();

    boolean isLeavingSharedUser();

    boolean isOdm();

    boolean isOem();

    boolean isPageSizeAppCompatEnabled();

    boolean isPendingRestore();

    boolean isPersistent();

    boolean isPrivileged();

    boolean isProduct();

    boolean isRequiredForSystemUser();

    boolean isScannedAsStoppedSystemApp();

    boolean isSystem();

    boolean isSystemExt();

    boolean isUpdateAvailable();

    boolean isUpdatedSystemApp();

    boolean isVendor();

    default PackageUserState getUserStateOrDefault(int userId) {
        PackageUserState userState = getUserStates().get(userId);
        if (userState != null) goto L6;
        return PackageUserState.DEFAULT;
    L6:
        return userState;
    }
}
