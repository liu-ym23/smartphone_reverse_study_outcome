package com.android.server.wm;

import android.content.pm.PackageManager;
import com.android.server.wm.utils.OptPropFactory;

/* JADX INFO: loaded from: classes3.dex */
public class AppCompatOverrides {
    private final AppCompatAspectRatioOverrides mAspectRatioOverrides;
    private final AppCompatCameraOverrides mCameraOverrides;
    private final AppCompatFocusOverrides mFocusOverrides;
    private final AppCompatLetterboxOverrides mLetterboxOverrides;
    private final AppCompatOrientationOverrides mOrientationOverrides;
    private final AppCompatReachabilityOverrides mReachabilityOverrides;
    private final AppCompatResizeOverrides mResizeOverrides;

    AppCompatOverrides(ActivityRecord activityRecord, PackageManager packageManager, AppCompatConfiguration appCompatConfiguration, OptPropFactory optPropBuilder, AppCompatDeviceStateQuery appCompatDeviceStateQuery) {
        this.mCameraOverrides = new AppCompatCameraOverrides(activityRecord, appCompatConfiguration, optPropBuilder);
        this.mOrientationOverrides = new AppCompatOrientationOverrides(activityRecord, appCompatConfiguration, optPropBuilder, this.mCameraOverrides);
        this.mReachabilityOverrides = new AppCompatReachabilityOverrides(activityRecord, appCompatConfiguration, appCompatDeviceStateQuery);
        this.mAspectRatioOverrides = new AppCompatAspectRatioOverrides(activityRecord, appCompatConfiguration, optPropBuilder, appCompatDeviceStateQuery, this.mReachabilityOverrides);
        this.mFocusOverrides = new AppCompatFocusOverrides(activityRecord, appCompatConfiguration, optPropBuilder);
        this.mResizeOverrides = new AppCompatResizeOverrides(activityRecord, packageManager, optPropBuilder);
        this.mLetterboxOverrides = new AppCompatLetterboxOverrides(activityRecord, appCompatConfiguration);
    }

    AppCompatOrientationOverrides getOrientationOverrides() {
        return this.mOrientationOverrides;
    }

    AppCompatCameraOverrides getCameraOverrides() {
        return this.mCameraOverrides;
    }

    AppCompatAspectRatioOverrides getAspectRatioOverrides() {
        return this.mAspectRatioOverrides;
    }

    AppCompatFocusOverrides getFocusOverrides() {
        return this.mFocusOverrides;
    }

    AppCompatResizeOverrides getResizeOverrides() {
        return this.mResizeOverrides;
    }

    AppCompatReachabilityOverrides getReachabilityOverrides() {
        return this.mReachabilityOverrides;
    }

    AppCompatLetterboxOverrides getLetterboxOverrides() {
        return this.mLetterboxOverrides;
    }
}
