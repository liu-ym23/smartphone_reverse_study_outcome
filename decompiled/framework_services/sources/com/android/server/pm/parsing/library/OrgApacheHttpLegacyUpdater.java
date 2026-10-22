package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.pm.pkg.AndroidPackage;

/* JADX INFO: loaded from: classes2.dex */
public class OrgApacheHttpLegacyUpdater extends PackageSharedLibraryUpdater {
    public OrgApacheHttpLegacyUpdater() {
    }

    private static boolean apkTargetsApiLevelLessThanOrEqualToOMR1(AndroidPackage pkg) {
        if (pkg.getTargetSdkVersion() >= 28) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        if (apkTargetsApiLevelLessThanOrEqualToOMR1(parsedPackage) == false) goto L6;
        prefixRequiredLibrary(parsedPackage, SharedLibraryNames.ORG_APACHE_HTTP_LEGACY);
        return;
    }
}
