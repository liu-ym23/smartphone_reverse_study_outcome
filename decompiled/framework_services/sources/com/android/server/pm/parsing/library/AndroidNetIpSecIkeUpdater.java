package com.android.server.pm.parsing.library;

import com.android.internal.pm.parsing.pkg.ParsedPackage;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidNetIpSecIkeUpdater extends PackageSharedLibraryUpdater {
    private static final String LIBRARY_NAME = "android.net.ipsec.ike";

    public AndroidNetIpSecIkeUpdater() {
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        PackageSharedLibraryUpdater.removeLibrary(parsedPackage, LIBRARY_NAME);
    }
}
