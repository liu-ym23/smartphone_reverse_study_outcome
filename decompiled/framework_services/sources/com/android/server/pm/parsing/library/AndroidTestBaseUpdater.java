package com.android.server.pm.parsing.library;

import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidTestBaseUpdater extends PackageSharedLibraryUpdater {
    private static final long REMOVE_ANDROID_TEST_BASE = 133396946;
    private static final String TAG = "AndroidTestBaseUpdater";

    public AndroidTestBaseUpdater() {
    }

    private static boolean isChangeEnabled(AndroidPackage pkg, boolean isSystemApp) {
        if (isSystemApp == true) goto L9;
        IPlatformCompat platformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        return platformCompat.isChangeEnabled(REMOVE_ANDROID_TEST_BASE, AndroidPackageUtils.generateAppInfoWithoutState(pkg));
    L6:
        e = move-exception;
        Log.e(TAG, "Failed to get a response from PLATFORM_COMPAT_SERVICE", e);
    L9:
        if (pkg.getTargetSdkVersion() <= 29) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage pkg, boolean isSystemApp, boolean isUpdatedSystemApp) {
        if (isChangeEnabled(pkg, isSystemApp) == true) goto L5;
        prefixRequiredLibrary(pkg, "android.test.base");
        return;
    L5:
        prefixImplicitDependency(pkg, "android.test.runner", "android.test.base");
    }
}
