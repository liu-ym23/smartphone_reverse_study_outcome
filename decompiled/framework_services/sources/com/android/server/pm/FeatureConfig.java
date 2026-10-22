package com.android.server.pm;

import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;

/* JADX INFO: loaded from: classes2.dex */
interface FeatureConfig {
    void enableLogging(int r1, boolean r2);

    boolean isGloballyEnabled();

    boolean isLoggingEnabled(int r1);

    void onSystemReady();

    boolean packageIsEnabled(AndroidPackage r1);

    FeatureConfig snapshot();

    void updatePackageState(PackageStateInternal r1, boolean r2);
}
