package com.android.server.pm.pkg.mutate;

import android.util.ArraySet;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageStateWrite {
    void onChanged();

    PackageStateWrite setCategoryOverride(int r1);

    PackageStateWrite setHiddenUntilInstalled(boolean r1);

    PackageStateWrite setInstaller(String r1, int r2);

    PackageStateWrite setLastPackageUsageTime(int r1, long r2);

    PackageStateWrite setLoadingCompletedTime(long r1);

    PackageStateWrite setLoadingProgress(float r1);

    PackageStateWrite setMimeGroup(String r1, ArraySet<String> r2);

    PackageStateWrite setOverrideSeInfo(String r1);

    PackageStateWrite setPageSizeAppCompatFlags(int r1);

    PackageStateWrite setRequiredForSystemUser(boolean r1);

    PackageStateWrite setUpdateAvailable(boolean r1);

    PackageStateWrite setUpdateOwner(String r1);

    PackageUserStateWrite userState(int r1);
}
