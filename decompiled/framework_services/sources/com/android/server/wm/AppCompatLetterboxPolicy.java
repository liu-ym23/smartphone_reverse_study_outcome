package com.android.server.wm;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.SurfaceControl;
import android.window.DesktopModeFlags;
import com.android.internal.statusbar.LetterboxDetails;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatLetterboxPolicy {
    private static final int DIFF_TOLERANCE_PX = 1;
    private final ActivityRecord mActivityRecord;
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final AppCompatRoundedCorners mAppCompatRoundedCorners;
    private boolean mIsEligibleForFixedOrientationLetterbox;
    private boolean mLastShouldShowLetterboxUi;
    private final AppCompatLetterboxPolicyState mLetterboxPolicyState;
    private final Rect mTmpRect;

    private class LegacyLetterboxPolicyState implements AppCompatLetterboxPolicyState {
        private Letterbox mLetterbox;
        final /* synthetic */ AppCompatLetterboxPolicy this$0;

        /* JADX INFO: renamed from: $r8$lambda$X6ucGf-BowyMCxP1Puj_n3OQ-tI, reason: not valid java name */
        public static /* synthetic */ SurfaceControl.Builder m9719$r8$lambda$X6ucGfBowyMCxP1Puj_n3OQtI(LegacyLetterboxPolicyState r0) {
            return r0.lambda$layoutLetterboxIfNeeded$0();
        }

        /* synthetic */ LegacyLetterboxPolicyState(AppCompatLetterboxPolicy r1, AppCompatLetterboxPolicyIA r2) {
            this(r1);
        }

        private LegacyLetterboxPolicyState(AppCompatLetterboxPolicy r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void layoutLetterboxIfNeeded(WindowState w) {
            if (isRunning() == true) goto L5;
            AppCompatLetterboxOverrides letterboxOverrides = AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getLetterboxOverrides();
            AppCompatReachabilityPolicy reachabilityPolicy = AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityPolicy();
            this.mLetterbox = new Letterbox(new AppCompatLetterboxPolicy$LegacyLetterboxPolicyState$$ExternalSyntheticLambda0(this), AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mWmService.mTransactionFactory, reachabilityPolicy, letterboxOverrides);
            AppCompatReachabilityPolicy r2 = AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityPolicy();
            final Letterbox r3 = this.mLetterbox;
            r3.getClass();
            r2.setLetterboxInnerBoundsSupplier(new AppCompatLetterboxPolicy$LegacyLetterboxPolicyState$$ExternalSyntheticLambda1(r3));
        L5:
            Point letterboxPosition = new Point();
            AppCompatLetterboxUtils.calculateLetterboxPosition(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), letterboxPosition);
            Rect spaceToFill = new Rect();
            AppCompatLetterboxUtils.calculateLetterboxOuterBounds(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), spaceToFill);
            Rect innerFrame = new Rect();
            AppCompatLetterboxUtils.calculateLetterboxInnerBounds(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), w, innerFrame);
            this.mLetterbox.layout(spaceToFill, innerFrame, letterboxPosition);
            if (AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityOverrides().isDoubleTapEvent() == false) goto L9;
            AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).getTask().dispatchTaskInfoChangedIfNeeded(true);
            return;
        }

        private /* synthetic */ SurfaceControl.Builder lambda$layoutLetterboxIfNeeded$0() {
            return AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).makeChildSurface(null);
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public boolean isRunning() {
            if (this.mLetterbox == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void onMovedToDisplay(int displayId) {
            if (isRunning() == false) goto L6;
            this.mLetterbox.onMovedToDisplay(displayId);
            return;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void stop() {
            if (isRunning() == false) goto L5;
            this.mLetterbox.destroy();
            this.mLetterbox = null;
        L5:
            AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityPolicy().setLetterboxInnerBoundsSupplier(null);
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void updateLetterboxSurfaceIfNeeded(WindowState winHint, SurfaceControl.Transaction t, SurfaceControl.Transaction inputT) {
            if (AppCompatLetterboxPolicy.m9718$$Nest$smshouldNotLayoutLetterbox(winHint) == false) goto L5;
            return;
        L5:
            this.this$0.start(winHint);
            if (isRunning() == true) goto L8;
            return;
        L8:
            if (this.mLetterbox.needsApplySurfaceChanges() == false) goto L12;
            this.mLetterbox.applySurfaceChanges(t, inputT, winHint);
            return;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void hide() {
            if (isRunning() == false) goto L6;
            this.mLetterbox.hide();
            return;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public Rect getLetterboxInsets() {
            if (isRunning() == false) goto L7;
            return this.mLetterbox.getInsets();
        L7:
            return new Rect();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void getLetterboxInnerBounds(Rect outBounds) {
            if (isRunning() == false) goto L8;
            outBounds.set(this.mLetterbox.getInnerFrame());
            WindowState w = AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).findMainWindow();
            if (w == null) goto L11;
            AppCompatUtils.adjustBoundsForTaskbar(w, outBounds);
            return;
        L11:
            return;
        L8:
            outBounds.setEmpty();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void getLetterboxOuterBounds(Rect outBounds) {
            if (isRunning() == false) goto L5;
            outBounds.set(this.mLetterbox.getOuterFrame());
            return;
        L5:
            outBounds.setEmpty();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public boolean isFullyTransparentBarAllowed(Rect rect) {
            if (isRunning() == true) goto L5;
        L8:
            return true;
        L5:
            if (this.mLetterbox.notIntersectsOrFullyContains(rect) == true) goto L8;
            return false;
        }
    }

    private class ShellLetterboxPolicyState implements AppCompatLetterboxPolicyState {
        private final Rect mInnerBounds;
        private final Point mLetterboxPosition;
        private final Rect mOuterBounds;
        private boolean mRunning;
        final /* synthetic */ AppCompatLetterboxPolicy this$0;

        public static /* synthetic */ Rect $r8$lambda$Uw8dZGU8azUuRlKFHPWvzHR1HHQ(ShellLetterboxPolicyState r0) {
            return r0.lambda$layoutLetterboxIfNeeded$0();
        }

        private ShellLetterboxPolicyState(AppCompatLetterboxPolicy r1) {
            this.this$0 = r1;
            this.mInnerBounds = new Rect();
            this.mOuterBounds = new Rect();
            this.mLetterboxPosition = new Point();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void layoutLetterboxIfNeeded(WindowState w) {
            this.mRunning = true;
            AppCompatLetterboxUtils.calculateLetterboxPosition(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), this.mLetterboxPosition);
            AppCompatLetterboxUtils.calculateLetterboxOuterBounds(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), this.mOuterBounds);
            AppCompatLetterboxUtils.calculateLetterboxInnerBounds(AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0), w, this.mInnerBounds);
            AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityPolicy().setLetterboxInnerBoundsSupplier(new AppCompatLetterboxPolicy$ShellLetterboxPolicyState$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ Rect lambda$layoutLetterboxIfNeeded$0() {
            return this.mInnerBounds;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public boolean isRunning() {
            return this.mRunning;
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void onMovedToDisplay(int displayId) {
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void stop() {
            if (isRunning() == true) goto L5;
            return;
        L5:
            this.mRunning = false;
            this.mLetterboxPosition.set(0, 0);
            this.mInnerBounds.setEmpty();
            this.mOuterBounds.setEmpty();
            AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).mAppCompatController.getReachabilityPolicy().setLetterboxInnerBoundsSupplier(null);
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void hide() {
            if (isRunning() == true) goto L5;
            return;
        L5:
            this.mLetterboxPosition.set(0, 0);
            this.mInnerBounds.setEmpty();
            this.mOuterBounds.setEmpty();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public Rect getLetterboxInsets() {
            if (isRunning() == false) goto L7;
            return new Rect(Math.max(0, this.mInnerBounds.left - this.mOuterBounds.left), Math.max(0, this.mOuterBounds.top - this.mInnerBounds.top), Math.max(0, this.mOuterBounds.right - this.mInnerBounds.right), Math.max(0, this.mInnerBounds.bottom - this.mOuterBounds.bottom));
        L7:
            return new Rect();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void getLetterboxInnerBounds(Rect outBounds) {
            if (isRunning() == false) goto L8;
            outBounds.set(this.mInnerBounds);
            WindowState w = AppCompatLetterboxPolicy.m9717$$Nest$fgetmActivityRecord(this.this$0).findMainWindow();
            if (w == null) goto L11;
            AppCompatUtils.adjustBoundsForTaskbar(w, outBounds);
            return;
        L11:
            return;
        L8:
            outBounds.setEmpty();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void getLetterboxOuterBounds(Rect outBounds) {
            if (isRunning() == false) goto L5;
            outBounds.set(this.mOuterBounds);
            return;
        L5:
            outBounds.setEmpty();
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public void updateLetterboxSurfaceIfNeeded(WindowState winHint, SurfaceControl.Transaction t, SurfaceControl.Transaction inputT) {
            if (AppCompatLetterboxPolicy.m9718$$Nest$smshouldNotLayoutLetterbox(winHint) == false) goto L5;
            return;
        L5:
            this.this$0.start(winHint);
        }

        @Override // com.android.server.wm.AppCompatLetterboxPolicyState
        public boolean isFullyTransparentBarAllowed(Rect rect) {
            return !isRunning();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$VIsnEAcb4wDCXFZKuW_zUlabbsk(AppCompatLetterboxPolicy r0, WindowState r1) {
        return r0.ieEligibleForRoundedCorners(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityRecord m9717$$Nest$fgetmActivityRecord(AppCompatLetterboxPolicy r0) {
        return r0.mActivityRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$smshouldNotLayoutLetterbox, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9718$$Nest$smshouldNotLayoutLetterbox(WindowState r0) {
        return shouldNotLayoutLetterbox(r0);
    }

    AppCompatLetterboxPolicy(ActivityRecord activityRecord, AppCompatConfiguration appCompatConfiguration) {
        this.mTmpRect = new Rect();
        this.mActivityRecord = activityRecord;
        this.mLetterboxPolicyState = new LegacyLetterboxPolicyState(this, null);
        this.mAppCompatRoundedCorners = new AppCompatRoundedCorners(this.mActivityRecord, new AppCompatLetterboxPolicy$$ExternalSyntheticLambda0(this));
        this.mAppCompatConfiguration = appCompatConfiguration;
    }

    void resetFixedOrientationLetterboxEligibility() {
        this.mIsEligibleForFixedOrientationLetterbox = false;
    }

    void stop() {
        this.mLetterboxPolicyState.stop();
    }

    boolean isRunning() {
        return this.mLetterboxPolicyState.isRunning();
    }

    void onMovedToDisplay(int displayId) {
        this.mLetterboxPolicyState.onMovedToDisplay(displayId);
    }

    Rect getLetterboxInsets() {
        return this.mLetterboxPolicyState.getLetterboxInsets();
    }

    void getLetterboxInnerBounds(Rect outBounds) {
        this.mLetterboxPolicyState.getLetterboxInnerBounds(outBounds);
    }

    boolean resolveFixedOrientationLetterboxEligibility(int forcedOrientation, int parentOrientation) {
        if (forcedOrientation == 0) goto L5;
        if (forcedOrientation == parentOrientation) goto L5;
        boolean r0 = true;
    L6:
        this.mIsEligibleForFixedOrientationLetterbox = r0;
        return this.mIsEligibleForFixedOrientationLetterbox;
    L5:
        r0 = false;
        goto L6
    }

    boolean isEligibleForLetterboxEducation() {
        if (this.mAppCompatConfiguration.getIsEducationEnabled() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mIsEligibleForFixedOrientationLetterbox == false) goto L13;
        if (this.mActivityRecord.getWindowingMode() != 1) goto L13;
        if (this.mActivityRecord.getRequestedConfigurationOrientation() != 1) goto L13;
        if (this.mActivityRecord.mStartingWindow != null) goto L13;
        return true;
    }

    LetterboxDetails getLetterboxDetails() {
        WindowState w = this.mActivityRecord.findMainWindow();
        if (isRunning() == false) goto L16;
        if (w == null) goto L16;
        if (w.isLetterboxedForDisplayCutout() == true) goto L16;
        Rect letterboxInnerBounds = new Rect();
        Rect letterboxOuterBounds = new Rect();
        this.mLetterboxPolicyState.getLetterboxInnerBounds(letterboxInnerBounds);
        this.mLetterboxPolicyState.getLetterboxOuterBounds(letterboxOuterBounds);
        if (letterboxInnerBounds.isEmpty() == false) goto L11;
    L15:
        return null;
    L11:
        if (letterboxOuterBounds.isEmpty() == true) goto L15;
        return new LetterboxDetails(letterboxInnerBounds, letterboxOuterBounds, w.mAttrs.insetsFlags.appearance);
    L16:
        return null;
    }

    boolean isFullyTransparentBarAllowed(Rect rect) {
        return this.mLetterboxPolicyState.isFullyTransparentBarAllowed(rect);
    }

    void updateLetterboxSurfaceIfNeeded(WindowState winHint, SurfaceControl.Transaction t, SurfaceControl.Transaction inputT) {
        this.mLetterboxPolicyState.updateLetterboxSurfaceIfNeeded(winHint, t, inputT);
    }

    void updateLetterboxSurfaceIfNeeded(WindowState winHint) {
        this.mLetterboxPolicyState.updateLetterboxSurfaceIfNeeded(winHint, this.mActivityRecord.getSyncTransaction(), this.mActivityRecord.getPendingTransaction());
    }

    void start(WindowState w) {
        if (shouldNotLayoutLetterbox(w) == false) goto L5;
        return;
    L5:
        this.mAppCompatRoundedCorners.updateRoundedCornersIfNeeded(w);
        updateWallpaperForLetterbox(w);
        if (shouldShowLetterboxUi(w) == false) goto L8;
        this.mLetterboxPolicyState.layoutLetterboxIfNeeded(w);
        return;
    L8:
        this.mLetterboxPolicyState.hide();
    }

    boolean shouldShowLetterboxUi(WindowState mainWindow) {
        boolean shouldShowLetterboxUi = false;
        if (this.mActivityRecord.getExt().shouldDisableLetterboxInSplitScreen() == false) goto L7;
        this.mLastShouldShowLetterboxUi = false;
        return false;
    L7:
        if (this.mActivityRecord.mAppCompatController.getOrientationOverrides().getIsRelaunchingAfterRequestedOrientationChanged() == false) goto L11;
        return this.mLastShouldShowLetterboxUi;
    L11:
        if (this.mActivityRecord.isVisible() == true) goto L15;
        if (this.mActivityRecord.isVisibleRequested() == true) goto L15;
    L20:
        this.mLastShouldShowLetterboxUi = shouldShowLetterboxUi;
        return shouldShowLetterboxUi;
    L15:
        if (mainWindow.areAppWindowBoundsLetterboxed() == false) goto L20;
        if ((mainWindow.mAttrs.flags & 1048576) != 0) goto L20;
        shouldShowLetterboxUi = true;
        goto L20
    }

    Rect getCropBoundsIfNeeded(WindowState mainWindow) {
        return this.mAppCompatRoundedCorners.getCropBoundsIfNeeded(mainWindow);
    }

    int getRoundedCornersRadius(WindowState mainWindow) {
        return this.mAppCompatRoundedCorners.getRoundedCornersRadius(mainWindow);
    }

    void dump(PrintWriter pw, String prefix) {
        WindowState mainWin = this.mActivityRecord.findMainWindow();
        if (mainWin != null) goto L5;
        return;
    L5:
        boolean areBoundsLetterboxed = mainWin.areAppWindowBoundsLetterboxed();
        pw.println(prefix + "areBoundsLetterboxed=" + areBoundsLetterboxed);
        pw.println(prefix + "isLetterboxRunning=" + isRunning());
        if (areBoundsLetterboxed == true) goto L8;
        return;
    L8:
        pw.println(prefix + "  letterboxReason=" + AppCompatUtils.getLetterboxReasonString(this.mActivityRecord, mainWin));
        this.mActivityRecord.mAppCompatController.getReachabilityPolicy().dump(pw, prefix);
        AppCompatLetterboxOverrides letterboxOverride = this.mActivityRecord.mAppCompatController.getLetterboxOverrides();
        pw.println(prefix + "  letterboxBackgroundColor=" + Integer.toHexString(letterboxOverride.getLetterboxBackgroundColor().toArgb()));
        pw.println(prefix + "  letterboxBackgroundType=" + AppCompatConfiguration.letterboxBackgroundTypeToString(letterboxOverride.getLetterboxBackgroundType()));
        pw.println(prefix + "  letterboxCornerRadius=" + getRoundedCornersRadius(mainWin));
        if (letterboxOverride.getLetterboxBackgroundType() != 3) goto L11;
        pw.println(prefix + "  isLetterboxWallpaperBlurSupported=" + letterboxOverride.isLetterboxWallpaperBlurSupported());
        pw.println(prefix + "  letterboxBackgroundWallpaperDarkScrimAlpha=" + letterboxOverride.getLetterboxWallpaperDarkScrimAlpha());
        pw.println(prefix + "  letterboxBackgroundWallpaperBlurRadius=" + letterboxOverride.getLetterboxWallpaperBlurRadiusPx());
    L11:
        this.mAppCompatConfiguration.dump(pw, prefix);
    }

    private void updateWallpaperForLetterbox(WindowState mainWindow) {
        AppCompatLetterboxOverrides letterboxOverrides = this.mActivityRecord.mAppCompatController.getLetterboxOverrides();
        int letterboxBackgroundType = letterboxOverrides.getLetterboxBackgroundType();
        if (letterboxBackgroundType == 3) goto L5;
    L15:
        boolean wallpaperShouldBeShown = false;
    L17:
        if (letterboxOverrides.checkWallpaperBackgroundForLetterbox(wallpaperShouldBeShown) == false) goto L20;
        this.mActivityRecord.requestUpdateWallpaperIfNeeded();
        return;
    L20:
        return;
    L5:
        if (isLetterboxedNotForDisplayCutout(mainWindow) == false) goto L15;
        if (letterboxOverrides.getLetterboxWallpaperBlurRadiusPx() > 0) goto L11;
        if (letterboxOverrides.getLetterboxWallpaperDarkScrimAlpha() <= 0.0f) goto L15;
    L11:
        if (letterboxOverrides.getLetterboxWallpaperBlurRadiusPx() > 0) goto L13;
    L14:
        wallpaperShouldBeShown = true;
        goto L17
    L13:
        if (letterboxOverrides.isLetterboxWallpaperBlurSupported() == false) goto L15;
        goto L14
    }

    private boolean ieEligibleForRoundedCorners(WindowState mainWindow) {
        if (isLetterboxedNotForDisplayCutout(mainWindow) == true) goto L5;
    L7:
        return false;
    L5:
        if (isFreeformActivityMatchParentAppBoundsHeight() == true) goto L7;
        return true;
    }

    private boolean isLetterboxedNotForDisplayCutout(WindowState mainWindow) {
        if (shouldShowLetterboxUi(mainWindow) == true) goto L5;
    L7:
        return false;
    L5:
        if (mainWindow.isLetterboxedForDisplayCutout() == true) goto L7;
        return true;
    }

    private boolean isFreeformActivityMatchParentAppBoundsHeight() {
        if (DesktopModeFlags.EXCLUDE_CAPTION_FROM_APP_BOUNDS.isTrue() == true) goto L5;
        return false;
    L5:
        Task task = this.mActivityRecord.getTask();
        if (task != null) goto L8;
        return false;
    L8:
        Rect parentAppBounds = task.getWindowConfiguration().getAppBounds();
        if (parentAppBounds != null) goto L11;
        return false;
    L11:
        this.mLetterboxPolicyState.getLetterboxInnerBounds(this.mTmpRect);
        int diff = parentAppBounds.height() - this.mTmpRect.height();
        if (task.getWindowingMode() == 5) goto L14;
        return false;
    L14:
        if (diff <= 1) goto L16;
        return false;
    L16:
        return true;
    }

    private static boolean shouldNotLayoutLetterbox(WindowState w) {
        if (w != null) goto L5;
        return true;
    L5:
        int type = w.mAttrs.type;
        if (type == 1) goto L10;
        if (type == 3) goto L10;
        return true;
    L10:
        if (w.mAnimatingExit == true) goto L15;
        return false;
    L15:
        return true;
    }
}
