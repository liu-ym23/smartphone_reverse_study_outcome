package com.android.server.wm;

import android.content.pm.PackageManager;
import com.android.server.wm.utils.OptPropFactory;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatController {
    private final AppCompatOverrides mAppCompatOverrides;
    private final AppCompatAspectRatioPolicy mAspectRatioPolicy;
    private final DesktopAppCompatAspectRatioPolicy mDesktopAspectRatioPolicy;
    private final AppCompatDeviceStateQuery mDeviceStateQuery;
    private final AppCompatDisplayCompatModePolicy mDisplayCompatModePolicy;
    private final AppCompatLetterboxPolicy mLetterboxPolicy;
    private final AppCompatOrientationPolicy mOrientationPolicy;
    private final AppCompatReachabilityPolicy mReachabilityPolicy;
    private final AppCompatSafeRegionPolicy mSafeRegionPolicy;
    private final AppCompatSandboxingPolicy mSandboxingPolicy;
    private final AppCompatSizeCompatModePolicy mSizeCompatModePolicy;
    private final TransparentPolicy mTransparentPolicy;

    AppCompatController(WindowManagerService wmService, ActivityRecord activityRecord) {
        PackageManager packageManager = wmService.mContext.getPackageManager();
        OptPropFactory optPropBuilder = new OptPropFactory(packageManager, activityRecord.packageName, activityRecord.mUserId);
        this.mDeviceStateQuery = new AppCompatDeviceStateQuery(activityRecord);
        this.mTransparentPolicy = new TransparentPolicy(activityRecord, wmService.mAppCompatConfiguration);
        this.mAppCompatOverrides = new AppCompatOverrides(activityRecord, packageManager, wmService.mAppCompatConfiguration, optPropBuilder, this.mDeviceStateQuery);
        this.mOrientationPolicy = new AppCompatOrientationPolicy(activityRecord, this.mAppCompatOverrides);
        this.mAspectRatioPolicy = new AppCompatAspectRatioPolicy(activityRecord, this.mTransparentPolicy, this.mAppCompatOverrides);
        this.mSafeRegionPolicy = new AppCompatSafeRegionPolicy(activityRecord, packageManager);
        this.mReachabilityPolicy = new AppCompatReachabilityPolicy(activityRecord, wmService.mAppCompatConfiguration);
        this.mLetterboxPolicy = new AppCompatLetterboxPolicy(activityRecord, wmService.mAppCompatConfiguration);
        this.mDesktopAspectRatioPolicy = new DesktopAppCompatAspectRatioPolicy(activityRecord, this.mAppCompatOverrides, this.mTransparentPolicy, wmService.mAppCompatConfiguration);
        this.mSizeCompatModePolicy = new AppCompatSizeCompatModePolicy(activityRecord, this.mAppCompatOverrides);
        this.mSandboxingPolicy = new AppCompatSandboxingPolicy(activityRecord);
        this.mDisplayCompatModePolicy = new AppCompatDisplayCompatModePolicy();
    }

    TransparentPolicy getTransparentPolicy() {
        return this.mTransparentPolicy;
    }

    AppCompatOrientationPolicy getOrientationPolicy() {
        return this.mOrientationPolicy;
    }

    AppCompatAspectRatioPolicy getAspectRatioPolicy() {
        return this.mAspectRatioPolicy;
    }

    AppCompatSafeRegionPolicy getSafeRegionPolicy() {
        return this.mSafeRegionPolicy;
    }

    DesktopAppCompatAspectRatioPolicy getDesktopAspectRatioPolicy() {
        return this.mDesktopAspectRatioPolicy;
    }

    AppCompatOrientationOverrides getOrientationOverrides() {
        return this.mAppCompatOverrides.getOrientationOverrides();
    }

    AppCompatCameraOverrides getCameraOverrides() {
        return this.mAppCompatOverrides.getCameraOverrides();
    }

    AppCompatAspectRatioOverrides getAspectRatioOverrides() {
        return this.mAppCompatOverrides.getAspectRatioOverrides();
    }

    AppCompatResizeOverrides getResizeOverrides() {
        return this.mAppCompatOverrides.getResizeOverrides();
    }

    AppCompatReachabilityPolicy getReachabilityPolicy() {
        return this.mReachabilityPolicy;
    }

    AppCompatLetterboxPolicy getLetterboxPolicy() {
        return this.mLetterboxPolicy;
    }

    AppCompatFocusOverrides getFocusOverrides() {
        return this.mAppCompatOverrides.getFocusOverrides();
    }

    AppCompatReachabilityOverrides getReachabilityOverrides() {
        return this.mAppCompatOverrides.getReachabilityOverrides();
    }

    AppCompatDeviceStateQuery getDeviceStateQuery() {
        return this.mDeviceStateQuery;
    }

    AppCompatLetterboxOverrides getLetterboxOverrides() {
        return this.mAppCompatOverrides.getLetterboxOverrides();
    }

    AppCompatSizeCompatModePolicy getSizeCompatModePolicy() {
        return this.mSizeCompatModePolicy;
    }

    AppCompatSandboxingPolicy getSandboxingPolicy() {
        return this.mSandboxingPolicy;
    }

    AppCompatDisplayCompatModePolicy getDisplayCompatModePolicy() {
        return this.mDisplayCompatModePolicy;
    }

    void dump(PrintWriter pw, String prefix) {
        getTransparentPolicy().dump(pw, prefix);
        getLetterboxPolicy().dump(pw, prefix);
        getSizeCompatModePolicy().dump(pw, prefix);
        getSafeRegionPolicy().dump(pw, prefix);
    }
}
