package com.android.server.wm;

import android.graphics.Rect;
import java.io.PrintWriter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatReachabilityPolicy {
    private final ActivityRecord mActivityRecord;
    private final AppCompatConfiguration mAppCompatConfiguration;
    Supplier<Rect> mLetterboxInnerBoundsSupplier;

    AppCompatReachabilityPolicy(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration) {
        this.mActivityRecord = activityRecord;
        this.mAppCompatConfiguration = appCompatConfiguration;
    }

    void setLetterboxInnerBoundsSupplier(Supplier<Rect> letterboxInnerBoundsSupplier) {
        this.mLetterboxInnerBoundsSupplier = letterboxInnerBoundsSupplier;
    }

    void handleDoubleTap(int x, int y) {
        handleHorizontalDoubleTap(x);
        handleVerticalDoubleTap(y);
    }

    void dump(PrintWriter pw, String prefix) {
        AppCompatReachabilityOverrides reachabilityOverrides = this.mActivityRecord.mAppCompatController.getReachabilityOverrides();
        pw.println(prefix + "  isVerticalThinLetterboxed=" + reachabilityOverrides.isVerticalThinLetterboxed());
        pw.println(prefix + "  isHorizontalThinLetterboxed=" + reachabilityOverrides.isHorizontalThinLetterboxed());
        pw.println(prefix + "  isHorizontalReachabilityEnabled=" + reachabilityOverrides.isHorizontalReachabilityEnabled());
        pw.println(prefix + "  isVerticalReachabilityEnabled=" + reachabilityOverrides.isVerticalReachabilityEnabled());
        pw.println(prefix + "  letterboxHorizontalPositionMultiplier=" + reachabilityOverrides.getHorizontalPositionMultiplier(this.mActivityRecord.getParent().getConfiguration()));
        pw.println(prefix + "  letterboxVerticalPositionMultiplier=" + reachabilityOverrides.getVerticalPositionMultiplier(this.mActivityRecord.getParent().getConfiguration()));
    }

    private void handleHorizontalDoubleTap(int x) {
        AppCompatReachabilityOverrides reachabilityOverrides = this.mActivityRecord.mAppCompatController.getReachabilityOverrides();
        boolean isInFullScreenBookMode = false;
        int letterboxPositionChangeForLog = 1;
        if (this.mActivityRecord.isInTransition() == false) goto L5;
        boolean isInTransition = true;
    L7:
        if (reachabilityOverrides.isHorizontalReachabilityEnabled() == false) goto L38;
        if (isInTransition == true) goto L39;
        Rect letterboxInnerFrame = getLetterboxInnerFrame();
        if (letterboxInnerFrame.left <= x) goto L13;
    L15:
        AppCompatDeviceStateQuery deviceStateQuery = this.mActivityRecord.mAppCompatController.getDeviceStateQuery();
        if (deviceStateQuery.isDisplayFullScreenAndSeparatingHinge() == true) goto L18;
    L21:
        int letterboxPositionForHorizontalReachability = this.mAppCompatConfiguration.getLetterboxPositionForHorizontalReachability(isInFullScreenBookMode);
        if (letterboxInnerFrame.left <= x) goto L30;
        this.mAppCompatConfiguration.movePositionForHorizontalReachabilityToNextLeftStop(isInFullScreenBookMode);
        if (letterboxPositionForHorizontalReachability == 1) goto L27;
        letterboxPositionChangeForLog = 4;
    L27:
        logLetterboxPositionChange(letterboxPositionChangeForLog);
        reachabilityOverrides.setDoubleTapEvent();
    L36:
        this.mActivityRecord.recomputeConfiguration();
        return;
    L30:
        if (letterboxInnerFrame.right >= x) goto L36;
        this.mAppCompatConfiguration.movePositionForHorizontalReachabilityToNextRightStop(isInFullScreenBookMode);
        if (letterboxPositionForHorizontalReachability != 1) goto L34;
        int letterboxPositionChangeForLog2 = 3;
    L35:
        logLetterboxPositionChange(letterboxPositionChangeForLog2);
        reachabilityOverrides.setDoubleTapEvent();
        goto L36
    L34:
        letterboxPositionChangeForLog2 = 2;
        goto L35
    L18:
        if (this.mAppCompatConfiguration.getIsAutomaticReachabilityInBookModeEnabled() == false) goto L21;
        isInFullScreenBookMode = true;
        goto L21
    L13:
        if (letterboxInnerFrame.right < x) goto L15;
        return;
    L39:
        return;
    L38:
        return;
    L5:
        isInTransition = false;
        goto L7
    }

    private void handleVerticalDoubleTap(int y) {
        AppCompatReachabilityOverrides reachabilityOverrides = this.mActivityRecord.mAppCompatController.getReachabilityOverrides();
        if (this.mActivityRecord.isInTransition() == false) goto L5;
        boolean isInTransition = true;
    L7:
        if (reachabilityOverrides.isVerticalReachabilityEnabled() == false) goto L32;
        if (isInTransition == true) goto L33;
        Rect letterboxInnerFrame = getLetterboxInnerFrame();
        if (letterboxInnerFrame.top <= y) goto L13;
    L15:
        AppCompatDeviceStateQuery deviceStateQuery = this.mActivityRecord.mAppCompatController.getDeviceStateQuery();
        boolean isInFullScreenTabletopMode = deviceStateQuery.isDisplayFullScreenAndSeparatingHinge();
        int letterboxPositionForVerticalReachability = this.mAppCompatConfiguration.getLetterboxPositionForVerticalReachability(isInFullScreenTabletopMode);
        if (letterboxInnerFrame.top <= y) goto L24;
        this.mAppCompatConfiguration.movePositionForVerticalReachabilityToNextTopStop(isInFullScreenTabletopMode);
        if (letterboxPositionForVerticalReachability != 1) goto L20;
        int letterboxPositionChangeForLog = 5;
    L21:
        logLetterboxPositionChange(letterboxPositionChangeForLog);
        reachabilityOverrides.setDoubleTapEvent();
    L30:
        this.mActivityRecord.recomputeConfiguration();
        return;
    L20:
        letterboxPositionChangeForLog = 8;
        goto L21
    L24:
        if (letterboxInnerFrame.bottom >= y) goto L30;
        this.mAppCompatConfiguration.movePositionForVerticalReachabilityToNextBottomStop(isInFullScreenTabletopMode);
        if (letterboxPositionForVerticalReachability != 1) goto L28;
        int letterboxPositionChangeForLog2 = 7;
    L29:
        logLetterboxPositionChange(letterboxPositionChangeForLog2);
        reachabilityOverrides.setDoubleTapEvent();
        goto L30
    L28:
        letterboxPositionChangeForLog2 = 6;
        goto L29
    L13:
        if (letterboxInnerFrame.bottom < y) goto L15;
        return;
    L33:
        return;
    L32:
        return;
    L5:
        isInTransition = false;
        goto L7
    }

    private void logLetterboxPositionChange(int letterboxPositionChangeForLog) {
        this.mActivityRecord.mTaskSupervisor.getActivityMetricsLogger().logLetterboxPositionChange(this.mActivityRecord, letterboxPositionChangeForLog);
    }

    private Rect getLetterboxInnerFrame() {
        if (this.mLetterboxInnerBoundsSupplier == null) goto L6;
        return this.mLetterboxInnerBoundsSupplier.get();
    L6:
        return new Rect();
    }
}
