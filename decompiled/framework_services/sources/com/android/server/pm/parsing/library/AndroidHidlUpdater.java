package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidHidlUpdater extends PackageSharedLibraryUpdater {
    public AndroidHidlUpdater() {
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        if (parsedPackage.getTargetSdkVersion() > 28) goto L5;
        boolean isLegacy = true;
    L7:
        if (isLegacy == false) goto L11;
        if (isSystemApp == true) goto L10;
        if (isUpdatedSystemApp == false) goto L11;
    L10:
        prefixRequiredLibrary(parsedPackage, "android.hidl.base-V1.0-java");
        prefixRequiredLibrary(parsedPackage, "android.hidl.manager-V1.0-java");
        return;
    L11:
        PackageSharedLibraryUpdater.removeLibrary(parsedPackage, "android.hidl.base-V1.0-java");
        PackageSharedLibraryUpdater.removeLibrary(parsedPackage, "android.hidl.manager-V1.0-java");
        return;
    L5:
        isLegacy = false;
        goto L7
    }
}
