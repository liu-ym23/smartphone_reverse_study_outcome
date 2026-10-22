package com.android.server.pm.dex;

import com.android.server.pm.InstructionSets;
import com.android.server.pm.PackageDexOptimizer;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class ArtUtils {
    private ArtUtils() {
    }

    public static ArtPackageInfo createArtPackageInfo(AndroidPackage pkg, PackageState packageState) {
        return new ArtPackageInfo(pkg.getPackageName(), Arrays.asList(InstructionSets.getAppDexInstructionSets(packageState.getPrimaryCpuAbi(), packageState.getSecondaryCpuAbi())), AndroidPackageUtils.getAllCodePaths(pkg), getOatDir(pkg, packageState));
    }

    private static String getOatDir(AndroidPackage pkg, PackageState packageState) {
        if (AndroidPackageUtils.canHaveOatDir(packageState, pkg) == true) goto L5;
        return null;
    L5:
        File codePath = new File(pkg.getPath());
        if (codePath.isDirectory() == true) goto L8;
        return null;
    L8:
        return PackageDexOptimizer.getOatDir(codePath).getAbsolutePath();
    }
}
