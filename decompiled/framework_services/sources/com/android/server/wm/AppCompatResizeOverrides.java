package com.android.server.wm;

import android.content.pm.PackageManager;
import com.android.server.wm.utils.OptPropFactory;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatResizeOverrides {
    private final ActivityRecord mActivityRecord;
    private final OptPropFactory.OptProp mAllowForceResizeOverrideOptProp;
    private final BooleanSupplier mAllowRestrictedResizability;

    public static /* synthetic */ boolean $r8$lambda$KwgGiBwNtcm_k4DA4WB9j_d8dCA(AppCompatResizeOverrides r0, PackageManager r1) {
        return r0.lambda$new$0(r1);
    }

    AppCompatResizeOverrides(ActivityRecord activityRecord, final PackageManager packageManager, OptPropFactory optPropBuilder) {
        this.mActivityRecord = activityRecord;
        this.mAllowForceResizeOverrideOptProp = optPropBuilder.create("android.window.PROPERTY_COMPAT_ALLOW_RESIZEABLE_ACTIVITY_OVERRIDES");
        this.mAllowRestrictedResizability = AppCompatUtils.asLazy(new AppCompatResizeOverrides$$ExternalSyntheticLambda0(this, packageManager));
    }

    private /* synthetic */ boolean lambda$new$0(PackageManager packageManager) {
        if (allowRestrictedResizability(packageManager, this.mActivityRecord.packageName, this.mActivityRecord.mUserId) == false) goto L11;
        return true;
    L11:
        return packageManager.getPropertyAsUser("android.window.PROPERTY_COMPAT_ALLOW_RESTRICTED_RESIZABILITY", this.mActivityRecord.mActivityComponent.getPackageName(), this.mActivityRecord.mActivityComponent.getClassName(), this.mActivityRecord.mUserId).getBoolean();
    L9:
        return false;
    }

    static boolean allowRestrictedResizability(PackageManager pm, String packageName, int userId) {
        return pm.getPropertyAsUser("android.window.PROPERTY_COMPAT_ALLOW_RESTRICTED_RESIZABILITY", packageName, null, userId).getBoolean();
    L5:
        return false;
    }

    boolean shouldOverrideForceResizeApp() {
        return this.mAllowForceResizeOverrideOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 174042936));
    }

    boolean shouldOverrideForceNonResizeApp() {
        return this.mAllowForceResizeOverrideOptProp.shouldEnableWithOptInOverrideAndOptOutProperty(AppCompatUtils.isChangeEnabled(this.mActivityRecord, 181136395));
    }

    boolean allowRestrictedResizability() {
        return this.mAllowRestrictedResizability.getAsBoolean();
    }
}
