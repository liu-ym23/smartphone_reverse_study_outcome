package com.android.server.pm.parsing.library;

import android.util.Log;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.internal.pm.pkg.parsing.ParsingPackage;
import com.android.server.SystemConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageBackwardCompatibility extends PackageSharedLibraryUpdater {
    private static final PackageBackwardCompatibility INSTANCE = null;
    private static final String TAG = null;
    private final boolean mBootClassPathContainsATB;
    private final PackageSharedLibraryUpdater[] mPackageUpdaters;

    public static class AndroidTestRunnerSplitUpdater extends PackageSharedLibraryUpdater {
        public AndroidTestRunnerSplitUpdater() {
        }

        @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
        public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
            prefixImplicitDependency(parsedPackage, "android.test.runner", "android.test.mock");
        }
    }

    public static class RemoveUnnecessaryAndroidTestBaseLibrary extends PackageSharedLibraryUpdater {
        public RemoveUnnecessaryAndroidTestBaseLibrary() {
        }

        @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
        public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
            PackageSharedLibraryUpdater.removeLibrary(parsedPackage, "android.test.base");
        }
    }

    public static class RemoveUnnecessaryOrgApacheHttpLegacyLibrary extends PackageSharedLibraryUpdater {
        public RemoveUnnecessaryOrgApacheHttpLegacyLibrary() {
        }

        @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
        public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
            PackageSharedLibraryUpdater.removeLibrary(parsedPackage, SharedLibraryNames.ORG_APACHE_HTTP_LEGACY);
        }
    }

    static {
        TAG = PackageBackwardCompatibility.class.getSimpleName();
        List<PackageSharedLibraryUpdater> packageUpdaters = new ArrayList();
        packageUpdaters.add(new WearSdkUpdater());
        packageUpdaters.add(new AndroidNetIpSecIkeUpdater());
        packageUpdaters.add(new ComGoogleAndroidMapsUpdater());
        packageUpdaters.add(new OrgApacheHttpLegacyUpdater());
        packageUpdaters.add(new AndroidHidlUpdater());
        packageUpdaters.add(new AndroidTestRunnerSplitUpdater());
        boolean bootClassPathContainsATB = !addUpdaterForAndroidTestBase(packageUpdaters);
        packageUpdaters.add(new ApexSharedLibraryUpdater(SystemConfig.getInstance().getSharedLibraries()));
        PackageSharedLibraryUpdater[] updaterArray = (PackageSharedLibraryUpdater[]) packageUpdaters.toArray(new PackageSharedLibraryUpdater[0]);
        INSTANCE = new PackageBackwardCompatibility(bootClassPathContainsATB, updaterArray);
    }

    private static boolean addUpdaterForAndroidTestBase(List<PackageSharedLibraryUpdater> packageUpdaters) {
        boolean hasClass = false;
        if (ParsingPackage.class.getClassLoader().loadClass("android.content.pm.AndroidTestBaseUpdater") == null) goto L6;
        boolean r3 = true;
    L7:
        hasClass = r3;
        Log.i(TAG, "Loaded android.content.pm.AndroidTestBaseUpdater");     // Catch: ClassNotFoundException -> L9
    L11:
        if (hasClass == false) goto L13;
        packageUpdaters.add(new AndroidTestBaseUpdater());
    L14:
        return hasClass;
    L13:
        packageUpdaters.add(new RemoveUnnecessaryAndroidTestBaseLibrary());
        goto L14
    L6:
        r3 = false;
    L10:
        Log.i(TAG, "Could not find android.content.pm.AndroidTestBaseUpdater, ignoring");
        goto L11
    }

    public static PackageSharedLibraryUpdater getInstance() {
        return INSTANCE;
    }

    PackageSharedLibraryUpdater[] getPackageUpdaters() {
        return this.mPackageUpdaters;
    }

    private PackageBackwardCompatibility(boolean bootClassPathContainsATB, PackageSharedLibraryUpdater[] packageUpdaters) {
        this.mBootClassPathContainsATB = bootClassPathContainsATB;
        this.mPackageUpdaters = packageUpdaters;
    }

    public static void modifySharedLibraries(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        INSTANCE.updatePackage(parsedPackage, isSystemApp, isUpdatedSystemApp);
    }

    @Override // com.android.server.pm.parsing.library.PackageSharedLibraryUpdater
    public void updatePackage(ParsedPackage parsedPackage, boolean isSystemApp, boolean isUpdatedSystemApp) {
        PackageSharedLibraryUpdater[] r0 = this.mPackageUpdaters;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        PackageSharedLibraryUpdater packageUpdater = r0[r2];
        packageUpdater.updatePackage(parsedPackage, isSystemApp, isUpdatedSystemApp);
        r2 = r2 + 1;
        goto L3
    }

    public static boolean bootClassPathContainsATB() {
        return INSTANCE.mBootClassPathContainsATB;
    }
}
