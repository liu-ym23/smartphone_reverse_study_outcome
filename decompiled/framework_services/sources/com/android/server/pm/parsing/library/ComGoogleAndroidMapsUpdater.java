package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;

/* JADX INFO: loaded from: classes2.dex */
public class ComGoogleAndroidMapsUpdater extends PackageSharedLibraryUpdater {
    private static final String LIBRARY_NAME = "com.google.android.maps";

    public ComGoogleAndroidMapsUpdater() {
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        parsedPackage.removeUsesLibrary(LIBRARY_NAME);
        parsedPackage.removeUsesOptionalLibrary(LIBRARY_NAME);
    }
}
