package com.android.server.wm;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Rect;
import java.io.PrintWriter;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatSafeRegionPolicy {
    private final ActivityRecord mActivityRecord;
    private final BooleanSupplier mAllowSafeRegionLetterboxing;
    private final Rect mLatestSafeRegionBounds;
    private boolean mNeedsSafeRegionBounds;
    final PackageManager mPackageManager;

    public static /* synthetic */ boolean $r8$lambda$9PpbIrRxIXQmlpsG9oaSF15leV0(AppCompatSafeRegionPolicy r0, PackageManager r1) {
        return r0.lambda$new$0(r1);
    }

    AppCompatSafeRegionPolicy(ActivityRecord activityRecord, final PackageManager packageManager) {
        this.mNeedsSafeRegionBounds = false;
        this.mLatestSafeRegionBounds = new Rect();
        this.mActivityRecord = activityRecord;
        this.mPackageManager = packageManager;
        this.mAllowSafeRegionLetterboxing = AppCompatUtils.asLazy(new AppCompatSafeRegionPolicy$$ExternalSyntheticLambda0(this, packageManager));
    }

    private /* synthetic */ boolean lambda$new$0(PackageManager packageManager) {
        if (allowSafeRegionLetterboxing(packageManager) == false) goto L9;
        return true;
    L9:
        return packageManager.getPropertyAsUser("android.window.PROPERTY_COMPAT_ALLOW_SAFE_REGION_LETTERBOXING", this.mActivityRecord.mActivityComponent.getPackageName(), this.mActivityRecord.mActivityComponent.getClassName(), this.mActivityRecord.mUserId).getBoolean();
    L8:
        return true;
    }

    private boolean allowSafeRegionLetterboxing(PackageManager pm) {
        return pm.getPropertyAsUser("android.window.PROPERTY_COMPAT_ALLOW_SAFE_REGION_LETTERBOXING", this.mActivityRecord.packageName, null, this.mActivityRecord.mUserId).getBoolean();
    L5:
        return true;
    }

    public Rect getLatestSafeRegionBounds() {
        if (allowSafeRegionLetterboxing() == true) goto L6;
        this.mLatestSafeRegionBounds.setEmpty();
        return null;
    L6:
        Rect latestSafeRegionBounds = this.mActivityRecord.getSafeRegionBounds();
        if (latestSafeRegionBounds == null) goto L9;
        this.mLatestSafeRegionBounds.set(latestSafeRegionBounds);
    L10:
        return latestSafeRegionBounds;
    L9:
        this.mLatestSafeRegionBounds.setEmpty();
        goto L10
    }

    public void resolveSafeRegionBoundsConfigurationIfNeeded(Configuration resolvedConfig, Configuration newParentConfig) {
        if (this.mLatestSafeRegionBounds.isEmpty() == false) goto L6;
        return;
    L6:
        if (isLetterboxedForSafeRegionOnlyAllowed() == true) goto L8;
        return;
    L8:
        if (this.mActivityRecord.getParent() == null) goto L13;
        resolvedConfig.windowConfiguration.setBounds(this.mLatestSafeRegionBounds);
        this.mActivityRecord.computeConfigByResolveHint(resolvedConfig, newParentConfig);
        return;
    }

    boolean isLetterboxedForSafeRegionOnlyAllowed() {
        if (this.mActivityRecord.areBoundsLetterboxed() == false) goto L5;
    L9:
        return false;
    L5:
        if (getNeedsSafeRegionBounds() == false) goto L9;
        if (getLatestSafeRegionBounds() == null) goto L9;
        return true;
    }

    public void setNeedsSafeRegionBounds(boolean needsSafeRegionBounds) {
        this.mNeedsSafeRegionBounds = needsSafeRegionBounds;
    }

    public boolean getNeedsSafeRegionBounds() {
        return this.mNeedsSafeRegionBounds;
    }

    boolean allowSafeRegionLetterboxing() {
        return this.mAllowSafeRegionLetterboxing.getAsBoolean();
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mNeedsSafeRegionBounds == false) goto L6;
        pw.println(prefix + " mNeedsSafeRegionBounds=true");
        pw.println(prefix + " latestSafeRegionBoundsOnActivity=" + getLatestSafeRegionBounds());
    L6:
        if (isLetterboxedForSafeRegionOnlyAllowed() == false) goto L9;
        pw.println(prefix + " isLetterboxForSafeRegionOnlyAllowed=true");
    L9:
        if (allowSafeRegionLetterboxing() == true) goto L12;
        pw.println(prefix + " allowSafeRegionLetterboxing=false");
        return;
    }
}
