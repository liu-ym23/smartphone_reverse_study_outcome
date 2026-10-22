package com.android.server.pm;

import android.util.ArraySet;
import android.util.Pair;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageAbiHelper {

    public static final class Abis {
        public final String primary;
        public final String secondary;

        Abis(String primary, String secondary) {
            this.primary = primary;
            this.secondary = secondary;
        }

        public void applyTo(ParsedPackage pkg) {
            pkg.setPrimaryCpuAbi(this.primary).setSecondaryCpuAbi(this.secondary);
        }

        public void applyTo(PackageSetting pkgSetting) {
            if (pkgSetting == null) goto L5;
            pkgSetting.setPrimaryCpuAbi(this.primary);
            pkgSetting.setSecondaryCpuAbi(this.secondary);
            return;
        }
    }

    public static final class NativeLibraryPaths {
        public final String nativeLibraryDir;
        public final String nativeLibraryRootDir;
        public final boolean nativeLibraryRootRequiresIsa;
        public final String secondaryNativeLibraryDir;

        NativeLibraryPaths(String nativeLibraryRootDir, boolean nativeLibraryRootRequiresIsa, String nativeLibraryDir, String secondaryNativeLibraryDir) {
            this.nativeLibraryRootDir = nativeLibraryRootDir;
            this.nativeLibraryRootRequiresIsa = nativeLibraryRootRequiresIsa;
            this.nativeLibraryDir = nativeLibraryDir;
            this.secondaryNativeLibraryDir = secondaryNativeLibraryDir;
        }

        public void applyTo(ParsedPackage pkg) {
            pkg.setNativeLibraryRootDir(this.nativeLibraryRootDir).setNativeLibraryRootRequiresIsa(this.nativeLibraryRootRequiresIsa).setNativeLibraryDir(this.nativeLibraryDir).setSecondaryNativeLibraryDir(this.secondaryNativeLibraryDir);
        }
    }

    int checkPackageAlignment(AndroidPackage r1, String r2, boolean r3, String r4);

    NativeLibraryPaths deriveNativeLibraryPaths(AndroidPackage r1, boolean r2, boolean r3, File r4);

    Pair<Abis, NativeLibraryPaths> derivePackageAbi(AndroidPackage r1, boolean r2, boolean r3, String r4, File r5) throws PackageManagerException;

    String getAdjustedAbiForSharedUser(ArraySet<? extends PackageStateInternal> r1, AndroidPackage r2);

    Abis getBundledAppAbis(AndroidPackage r1);
}
