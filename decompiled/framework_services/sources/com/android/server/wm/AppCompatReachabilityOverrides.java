package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatReachabilityOverrides {
    private final ActivityRecord mActivityRecord;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final AppCompatDeviceStateQuery mAppCompatDeviceStateQuery;
    private final ReachabilityState mReachabilityState;

    private static class ReachabilityState {
        private boolean mIsDoubleTapEvent;

        /* JADX INFO: renamed from: -$$Nest$fgetmIsDoubleTapEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9724$$Nest$fgetmIsDoubleTapEvent(ReachabilityState r0) {
            return r0.mIsDoubleTapEvent;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsDoubleTapEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9725$$Nest$fputmIsDoubleTapEvent(ReachabilityState r0, boolean r1) {
            r0.mIsDoubleTapEvent = r1;
        }

        /* synthetic */ ReachabilityState(AppCompatReachabilityOverridesIA r1) {
            this();
        }

        private ReachabilityState() {
        }

        boolean isFromDoubleTap() {
            boolean isFromDoubleTap = this.mIsDoubleTapEvent;
            this.mIsDoubleTapEvent = false;
            return isFromDoubleTap;
        }
    }

    AppCompatReachabilityOverrides(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration, AppCompatDeviceStateQuery appCompatDeviceStateQuery) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatConfiguration = appCompatConfiguration;
        this.mAppCompatDeviceStateQuery = appCompatDeviceStateQuery;
        this.mReachabilityState = new ReachabilityState(null);
    }

    boolean isFromDoubleTap() {
        return this.mReachabilityState.isFromDoubleTap();
    }

    boolean isDoubleTapEvent() {
        return ReachabilityState.m9724$$Nest$fgetmIsDoubleTapEvent(this.mReachabilityState);
    }

    void setDoubleTapEvent() {
        ReachabilityState.m9725$$Nest$fputmIsDoubleTapEvent(this.mReachabilityState, true);
    }

    float getHorizontalPositionMultiplier(Configuration parentConfiguration) {
        boolean bookModeEnabled = isFullScreenAndBookModeEnabled();
        if (isHorizontalReachabilityEnabled(parentConfiguration) == false) goto L6;
        return this.mAppCompatConfiguration.getHorizontalMultiplierForReachability(bookModeEnabled);
    L6:
        return this.mAppCompatConfiguration.getLetterboxHorizontalPositionMultiplier(bookModeEnabled);
    }

    float getVerticalPositionMultiplier(Configuration parentConfiguration) {
        boolean tabletopMode = this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(true);
        if (isVerticalReachabilityEnabled(parentConfiguration) == false) goto L6;
        return this.mAppCompatConfiguration.getVerticalMultiplierForReachability(tabletopMode);
    L6:
        return this.mAppCompatConfiguration.getLetterboxVerticalPositionMultiplier(tabletopMode);
    }

    boolean isHorizontalReachabilityEnabled() {
        return isHorizontalReachabilityEnabled(this.mActivityRecord.getParent().getConfiguration());
    }

    boolean isVerticalReachabilityEnabled() {
        return isVerticalReachabilityEnabled(this.mActivityRecord.getParent().getConfiguration());
    }

    boolean isLetterboxDoubleTapEducationEnabled() {
        if (isHorizontalReachabilityEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (isVerticalReachabilityEnabled() == true) goto L8;
        return false;
    }

    int getLetterboxPositionForVerticalReachability() {
        boolean isInFullScreenTabletopMode = this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndSeparatingHinge();
        return this.mAppCompatConfiguration.getLetterboxPositionForVerticalReachability(isInFullScreenTabletopMode);
    }

    int getLetterboxPositionForHorizontalReachability() {
        boolean isInFullScreenBookMode = isFullScreenAndBookModeEnabled();
        return this.mAppCompatConfiguration.getLetterboxPositionForHorizontalReachability(isInFullScreenBookMode);
    }

    int getLetterboxPositionForLogging() {
        if (isHorizontalReachabilityEnabled() == false) goto L7;
        int letterboxPositionForHorizontalReachability = this.mAppCompatConfiguration.getLetterboxPositionForHorizontalReachability(this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(false));
        int positionToLog = letterboxHorizontalReachabilityPositionToLetterboxPositionForLogging(letterboxPositionForHorizontalReachability);
        return positionToLog;
    L7:
        if (isVerticalReachabilityEnabled() == false) goto L11;
        int letterboxPositionForVerticalReachability = this.mAppCompatConfiguration.getLetterboxPositionForVerticalReachability(this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(true));
        int positionToLog2 = letterboxVerticalReachabilityPositionToLetterboxPositionForLogging(letterboxPositionForVerticalReachability);
        return positionToLog2;
    L11:
        return 0;
    }

    boolean allowVerticalReachabilityForThinLetterbox() {
        return !isVerticalThinLetterboxed();
    }

    boolean allowHorizontalReachabilityForThinLetterbox() {
        return !isHorizontalThinLetterboxed();
    }

    boolean isVerticalThinLetterboxed() {
        int thinHeight = this.mAppCompatConfiguration.getThinLetterboxHeightPx();
        if (thinHeight >= 0) goto L5;
        return false;
    L5:
        Task task = this.mActivityRecord.getTask();
        if (task != null) goto L8;
        return false;
    L8:
        int padding = Math.abs(task.getBounds().height() - this.mActivityRecord.getBounds().height()) / 2;
        if (padding > thinHeight) goto L12;
        return true;
    L12:
        return false;
    }

    boolean isHorizontalThinLetterboxed() {
        int thinWidth = this.mAppCompatConfiguration.getThinLetterboxWidthPx();
        if (thinWidth >= 0) goto L5;
        return false;
    L5:
        Task task = this.mActivityRecord.getTask();
        if (task != null) goto L8;
        return false;
    L8:
        int padding = Math.abs(task.getBounds().width() - this.mActivityRecord.getBounds().width()) / 2;
        if (padding > thinWidth) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isDisplayFullScreenAndSeparatingHinge() {
        Task task = this.mActivityRecord.getTask();
        if (this.mActivityRecord.mDisplayContent != null) goto L5;
    L10:
        return false;
    L5:
        if (this.mActivityRecord.mDisplayContent.getDisplayRotation().isDisplaySeparatingHinge() == false) goto L10;
        if (task == null) goto L10;
        if (task.getWindowingMode() != 1) goto L10;
        return true;
    }

    private int letterboxHorizontalReachabilityPositionToLetterboxPositionForLogging(int position) {
        switch(position) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 4;
    L7:
        return 2;
    L9:
        return 3;
    L4:
        throw new AssertionError("Unexpected letterbox horizontal reachability position type: " + position);
    }

    private int letterboxVerticalReachabilityPositionToLetterboxPositionForLogging(int position) {
        switch(position) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 6;
    L7:
        return 2;
    L9:
        return 5;
    L4:
        throw new AssertionError("Unexpected letterbox vertical reachability position type: " + position);
    }

    private boolean isFullScreenAndBookModeEnabled() {
        if (this.mAppCompatDeviceStateQuery.isDisplayFullScreenAndInPosture(false) == true) goto L5;
        return false;
    L5:
        if (this.mAppCompatConfiguration.getIsAutomaticReachabilityInBookModeEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isHorizontalReachabilityEnabled(Configuration parentConfiguration) {
        if (allowHorizontalReachabilityForThinLetterbox() == true) goto L5;
        return false;
    L5:
        Rect parentAppBoundsOverride = this.mActivityRecord.getParentAppBoundsOverride();
        if (parentAppBoundsOverride == null) goto L8;
        Rect parentAppBounds = parentAppBoundsOverride;
    L9:
        Rect opaqueActivityBounds = (Rect) this.mActivityRecord.mAppCompatController.getTransparentPolicy().getFirstOpaqueActivity().map(new AppCompatReachabilityOverrides$$ExternalSyntheticLambda0()).orElse(this.mActivityRecord.getScreenResolvedBounds());
        if (this.mAppCompatConfiguration.getIsHorizontalReachabilityEnabled() == true) goto L12;
        return false;
    L12:
        if (parentConfiguration.windowConfiguration.getWindowingMode() == 1) goto L14;
        return false;
    L14:
        if (parentAppBounds.height() <= opaqueActivityBounds.height()) goto L16;
        return false;
    L16:
        if (parentAppBounds.width() > opaqueActivityBounds.width()) goto L19;
        return false;
    L19:
        return true;
    L8:
        parentAppBounds = parentConfiguration.windowConfiguration.getAppBounds();
        goto L9
    }

    private boolean isVerticalReachabilityEnabled(Configuration parentConfiguration) {
        if (allowVerticalReachabilityForThinLetterbox() == true) goto L5;
        return false;
    L5:
        Rect parentAppBoundsOverride = this.mActivityRecord.getParentAppBoundsOverride();
        if (parentAppBoundsOverride == null) goto L8;
        Rect parentAppBounds = parentAppBoundsOverride;
    L9:
        Rect opaqueActivityBounds = (Rect) this.mActivityRecord.mAppCompatController.getTransparentPolicy().getFirstOpaqueActivity().map(new AppCompatReachabilityOverrides$$ExternalSyntheticLambda0()).orElse(this.mActivityRecord.getScreenResolvedBounds());
        if (this.mAppCompatConfiguration.getIsVerticalReachabilityEnabled() == true) goto L12;
        return false;
    L12:
        if (parentConfiguration.windowConfiguration.getWindowingMode() == 1) goto L14;
        return false;
    L14:
        if (parentAppBounds.width() <= opaqueActivityBounds.width()) goto L16;
        return false;
    L16:
        if (parentAppBounds.height() > opaqueActivityBounds.height()) goto L19;
        return false;
    L19:
        return true;
    L8:
        parentAppBounds = parentConfiguration.windowConfiguration.getAppBounds();
        goto L9
    }
}
