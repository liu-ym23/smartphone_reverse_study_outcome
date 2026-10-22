package com.android.server.pm.parsing.library;

import android.util.ArrayMap;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.modules.utils.build.UnboundedSdkLevel;
import com.android.server.SystemConfig;

/* JADX INFO: loaded from: classes2.dex */
public class ApexSharedLibraryUpdater extends PackageSharedLibraryUpdater {
    private final ArrayMap<String, SystemConfig.SharedLibraryEntry> mSharedLibraries;

    public ApexSharedLibraryUpdater(ArrayMap<String, SystemConfig.SharedLibraryEntry> sharedLibraries) {
        this.mSharedLibraries = sharedLibraries;
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        int builtInLibCount = this.mSharedLibraries.size();
        int i = 0;
    L3:
        if (i >= builtInLibCount) goto L6;
        updateSharedLibraryForPackage(this.mSharedLibraries.valueAt(i), parsedPackage);
        i = i + 1;
        goto L3
    }

    private void updateSharedLibraryForPackage(SystemConfig.SharedLibraryEntry entry, ParsedPackage parsedPackage) {
        if (entry.onBootclasspathBefore == null) goto L10;
        if (isTargetSdkAtMost(parsedPackage.getTargetSdkVersion(), entry.onBootclasspathBefore) == false) goto L10;
        if (UnboundedSdkLevel.isAtLeast(entry.onBootclasspathBefore) == false) goto L10;
        prefixRequiredLibrary(parsedPackage, entry.name);
    L10:
        if (entry.canBeSafelyIgnored == false) goto L13;
        PackageSharedLibraryUpdater.removeLibrary(parsedPackage, entry.name);
        return;
    }

    private static boolean isTargetSdkAtMost(int targetSdk, String onBcpBefore) {
        if (isCodename(onBcpBefore) == false) goto L9;
        if (targetSdk < 10000) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (targetSdk < Integer.parseInt(onBcpBefore)) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean isCodename(String version) {
        if (version.length() == 0) goto L7;
        return Character.isUpperCase(version.charAt(0));
    L7:
        throw new IllegalArgumentException();
    }
}
