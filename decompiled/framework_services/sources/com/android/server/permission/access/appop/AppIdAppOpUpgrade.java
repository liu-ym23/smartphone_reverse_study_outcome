package com.android.server.permission.access.appop;

import android.app.AppOpsManager;
import com.android.server.permission.access.MutateStateScope;
import com.android.server.permission.access.immutable.IndexedMap;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;

/* JADX INFO: compiled from: AppIdAppOpUpgrade.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIdAppOpUpgrade {
    private final AppIdAppOpPolicy policy;

    public AppIdAppOpUpgrade(AppIdAppOpPolicy policy) {
        this.policy = policy;
    }

    public final void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
        if (version > 2) goto L6;
        AppIdAppOpPolicy $this$upgradePackageState_u24lambda_u240 = this.policy;
        int appOpMode = $this$upgradePackageState_u24lambda_u240.getAppOpMode($this$upgradePackageState, packageState.getAppId(), userId, "android:run_in_background");
        $this$upgradePackageState_u24lambda_u240.setAppOpMode($this$upgradePackageState, packageState.getAppId(), userId, "android:run_any_in_background", appOpMode);
    L6:
        if (version > 13) goto L14;
        String permissionName = AppOpsManager.opToPermission(107);
        AndroidPackage r2 = packageState.getAndroidPackage();
        Intrinsics.checkNotNull(r2);
        if (r2.getRequestedPermissions().contains(permissionName) == false) goto L14;
        AppIdAppOpPolicy $this$upgradePackageState_u24lambda_u241 = this.policy;
        int appOpMode2 = $this$upgradePackageState_u24lambda_u241.getAppOpMode($this$upgradePackageState, packageState.getAppId(), userId, "android:schedule_exact_alarm");
        int defaultAppOpMode = AppOpsManager.opToDefaultMode(107);
        if (appOpMode2 != defaultAppOpMode) goto L14;
        $this$upgradePackageState_u24lambda_u241.setAppOpMode($this$upgradePackageState, packageState.getAppId(), userId, "android:schedule_exact_alarm", 0);
    L14:
        if (version > 15) goto L21;
        AppIdAppOpPolicy $this$upgradePackageState_u24lambda_u242 = this.policy;
        IndexedMap<String, Integer> r8 = $this$upgradePackageState_u24lambda_u242.getAppOpModes($this$upgradePackageState, packageState.getAppId(), userId);
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.contains("android:access_restricted_settings") == true) goto L24;
        $this$upgradePackageState_u24lambda_u242.setAppOpMode($this$upgradePackageState, packageState.getAppId(), userId, "android:access_restricted_settings", 0);
        return;
    L24:
        return;
    }
}
