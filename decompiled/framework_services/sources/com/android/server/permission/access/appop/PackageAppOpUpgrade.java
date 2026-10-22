package com.android.server.permission.access.appop;

import com.android.server.permission.access.MutateStateScope;
import com.android.server.pm.pkg.PackageState;

/* JADX INFO: compiled from: PackageAppOpUpgrade.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageAppOpUpgrade {
    private final PackageAppOpPolicy policy;

    public PackageAppOpUpgrade(PackageAppOpPolicy policy) {
        this.policy = policy;
    }

    public final void upgradePackageState(MutateStateScope $this$upgradePackageState, PackageState packageState, int userId, int version) {
        if (version > 2) goto L6;
        PackageAppOpPolicy $this$upgradePackageState_u24lambda_u240 = this.policy;
        int appOpMode = $this$upgradePackageState_u24lambda_u240.getAppOpMode($this$upgradePackageState, packageState.getPackageName(), userId, "android:run_in_background");
        $this$upgradePackageState_u24lambda_u240.setAppOpMode($this$upgradePackageState, packageState.getPackageName(), userId, "android:run_any_in_background", appOpMode);
        return;
    }
}
