package com.android.server.pm.pkg;

import android.content.pm.SigningDetails;
import android.util.SparseArray;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.server.pm.InstallSource;
import com.android.server.pm.PackageKeySetData;
import com.android.server.pm.permission.LegacyPermissionState;
import java.io.File;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageStateInternal extends PackageState {
    String getAppMetadataFilePath();

    int getAppMetadataSource();

    UUID getDomainSetId();

    int getFlags();

    InstallSource getInstallSource();

    PackageKeySetData getKeySetData();

    LegacyPermissionState getLegacyPermissionState();

    long getLoadingCompletedTime();

    float getLoadingProgress();

    Set<File> getOldPaths();

    String getPathString();

    AndroidPackageInternal getPkg();

    @Deprecated
    String getPrimaryCpuAbiLegacy();

    int getPrivateFlags();

    String getRealName();

    String getSecondaryCpuAbiLegacy();

    SigningDetails getSigningDetails();

    PackageStateUnserialized getTransientState();

    @Override // com.android.server.pm.pkg.PackageState
    SparseArray<? extends PackageUserStateInternal> getUserStates();

    boolean isLoading();

    @Override // com.android.server.pm.pkg.PackageState
    /* bridge */ /* synthetic */ default PackageUserState getUserStateOrDefault(int r1) {
        return getUserStateOrDefault(r1);
    }

    @Override // com.android.server.pm.pkg.PackageState
    default PackageUserStateInternal getUserStateOrDefault(int userId) {
        PackageUserStateInternal userState = getUserStates().get(userId);
        if (userState != null) goto L6;
        return PackageUserStateInternal.DEFAULT;
    L6:
        return userState;
    }
}
