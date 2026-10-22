package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.util.ArrayUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WearSdkUpdater extends PackageSharedLibraryUpdater {
    private static final String LIBRARY_NAME = "wear-sdk";

    public WearSdkUpdater() {
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        List<String> usesLibraries = parsedPackage.getUsesLibraries();
        List<String> usesOptionalLibraries = parsedPackage.getUsesOptionalLibraries();
        if (ArrayUtils.contains(usesLibraries, LIBRARY_NAME) == false) goto L5;
    L6:
        PackageSharedLibraryUpdater.removeLibrary(parsedPackage, LIBRARY_NAME);
        return;
    L5:
        if (ArrayUtils.contains(usesOptionalLibraries, LIBRARY_NAME) == true) goto L6;
    }
}
