package com.android.server.pm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.ApkAssets;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerServiceUtilsSmtEX {
    public PackageManagerServiceUtilsSmtEX() {
    }

    public static CharSequence getPackageLabel(Context context, String path) {
        String absFilePath = new File(path).getAbsolutePath();
        PackageInfo packageInfoFromApk = context.getPackageManager().getPackageArchiveInfo(absFilePath, PackageManager.PackageInfoFlags.of(0));
        if (packageInfoFromApk == null) goto L5;
        ApplicationInfo appInfo = packageInfoFromApk.applicationInfo;
    L6:
        Resources pRes = context.getResources();
        if (appInfo == null) goto L9;
        AssetManager assetManager = new AssetManager();
        Configuration config = new Configuration(pRes.getConfiguration());
        ApkAssets apkAssets = ApkAssets.loadFromPath(absFilePath);     // Catch: IOException -> L14
        assetManager.setApkAssets(new ApkAssets[]{apkAssets}, false);
        Resources res = new Resources(assetManager, pRes.getDisplayMetrics(), config);
        return TextUtils.trimToSize(tryLoadingAppLabel(res, appInfo), 1000);
    L15:
        return null;
    L9:
        return pRes.getString(17042269);
    L5:
        appInfo = null;
        goto L6
    }

    private static CharSequence tryLoadingAppLabel(Resources res, ApplicationInfo info) {
        CharSequence label = null;
        if (info.labelRes != 0) goto L14;
    L7:
        if (label == null) goto L9;
        return label;
    L9:
        if (info.nonLocalizedLabel == null) goto L11;
        CharSequence label2 = info.nonLocalizedLabel;
    L13:
        return label2;
    L11:
        label2 = info.packageName;
        goto L13
    L14:
        label = res.getText(info.labelRes).toString().trim();     // Catch: Resources.NotFoundException -> L6
        goto L7
    }

    public static boolean verifyPackageByPath(String packagePath) {
        return BytedancePackageVerifier.verifyPackage(packagePath, null);
    }

    public static boolean verifyPackageBySignature(Signature[] signatures) {
        return BytedancePackageVerifier.verifyPackage(signatures, null);
    }
}
