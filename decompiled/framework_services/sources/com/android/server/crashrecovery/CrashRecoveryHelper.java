package com.android.server.crashrecovery;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.VersionedPackage;
import android.net.ConnectivityModuleConnector;
import android.sysprop.CrashRecoveryProperties;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.PackageWatchdog;
import com.android.server.pm.ApexManager;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CrashRecoveryHelper {
    private static final String TAG = "CrashRecoveryHelper";
    private final ApexManager mApexManager;
    private final ConnectivityModuleConnector mConnectivityModuleConnector;
    private final Context mContext;

    public static /* synthetic */ void $r8$lambda$u7RLnZviLxfbHO9w6ST_8TjtWIg(CrashRecoveryHelper r0, String r1) {
        r0.lambda$registerConnectivityModuleHealthListener$0(r1);
    }

    public CrashRecoveryHelper(Context context) {
        this.mContext = context;
        this.mApexManager = ApexManager.getInstance();
        this.mConnectivityModuleConnector = ConnectivityModuleConnector.getInstance();
    }

    public boolean isModule(String packageName) {
        String apexPackageName = this.mApexManager.getActiveApexPackageNameContainingPackage(packageName);
        if (apexPackageName == null) goto L5;
        packageName = apexPackageName;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.getModuleInfo(packageName, 0) == null) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    public void registerConnectivityModuleHealthListener() {
        this.mConnectivityModuleConnector.registerHealthListener(new CrashRecoveryHelper$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$registerConnectivityModuleHealthListener$0(String packageName) {
        VersionedPackage pkg = getVersionedPackage(packageName);
        if (pkg != null) goto L6;
        Slog.wtf(TAG, "NetworkStack failed but could not find its package");
        return;
    L6:
        List<VersionedPackage> pkgList = Collections.singletonList(pkg);
        PackageWatchdog.getInstance(this.mContext).notifyPackageFailure(pkgList, 2);
    }

    private VersionedPackage getVersionedPackage(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null) goto L5;
    L11:
        return null;
    L5:
        if (TextUtils.isEmpty(packageName) == true) goto L11;
        long versionCode = getPackageInfo(packageName).getLongVersionCode();     // Catch: PackageManager.NameNotFoundException -> L9
        return new VersionedPackage(packageName, versionCode);
    L10:
        return null;
    }

    private PackageInfo getPackageInfo(String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = this.mContext.getPackageManager();
        return pm.getPackageInfo(packageName, 4194304);
    L7:
        return pm.getPackageInfo(packageName, 1073741824);
    }

    public static boolean isRecoveryTriggeredReboot() {
        if (isFactoryResetPropertySet() == false) goto L5;
    L8:
        return true;
    L5:
        if (isRebootPropertySet() == true) goto L8;
        return false;
    }

    static boolean isFactoryResetPropertySet() {
        return ((Boolean) CrashRecoveryProperties.attemptingFactoryReset().orElse(false)).booleanValue();
    }

    static boolean isRebootPropertySet() {
        return ((Boolean) CrashRecoveryProperties.attemptingReboot().orElse(false)).booleanValue();
    }
}
