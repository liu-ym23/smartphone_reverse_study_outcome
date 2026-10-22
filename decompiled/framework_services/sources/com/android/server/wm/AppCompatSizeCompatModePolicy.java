package com.android.server.wm;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import java.io.PrintWriter;
import java.util.function.DoubleSupplier;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatSizeCompatModePolicy {
    private final ActivityRecord mActivityRecord;
    private AppCompatDisplayInsets mAppCompatDisplayInsets;
    private final AppCompatOverrides mAppCompatOverrides;
    private boolean mInSizeCompatModeForBounds;
    private Rect mSizeCompatBounds;
    private float mSizeCompatScale;

    public static /* synthetic */ Float $r8$lambda$DB1xiXDatdealGYmVyfNK1FWtH8(AppCompatSizeCompatModePolicy r0, Rect r1, Rect r2, Configuration r3) {
        return r0.lambda$updateSizeCompatScale$1(r1, r2, r3);
    }

    public static /* synthetic */ Float $r8$lambda$HeRz3r9TstDN3ctZMaGIi9JNjrY(ActivityRecord r0) {
        return lambda$updateSizeCompatScale$0(r0);
    }

    AppCompatSizeCompatModePolicy(ActivityRecord activityRecord, AppCompatOverrides appCompatOverrides) {
        this.mInSizeCompatModeForBounds = false;
        this.mSizeCompatScale = 1.0f;
        this.mActivityRecord = activityRecord;
        this.mAppCompatOverrides = appCompatOverrides;
    }

    boolean isInSizeCompatModeForBounds() {
        return this.mInSizeCompatModeForBounds;
    }

    void setInSizeCompatModeForBounds(boolean inSizeCompatModeForBounds) {
        this.mInSizeCompatModeForBounds = inSizeCompatModeForBounds;
    }

    boolean hasSizeCompatBounds() {
        if (this.mSizeCompatBounds == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasAppCompatDisplayInsetsWithoutInheritance() {
        if (this.mAppCompatDisplayInsets == null) goto L5;
        return true;
    L5:
        return false;
    }

    AppCompatDisplayInsets getAppCompatDisplayInsets() {
        TransparentPolicy transparentPolicy = this.mActivityRecord.mAppCompatController.getTransparentPolicy();
        if (transparentPolicy.isRunning() == false) goto L7;
        return transparentPolicy.getInheritedAppCompatDisplayInsets();
    L7:
        return this.mAppCompatDisplayInsets;
    }

    float getCompatScaleIfAvailable(DoubleSupplier scaleWhenNotAvailable) {
        if (hasSizeCompatBounds() == false) goto L6;
        return this.mSizeCompatScale;
    L6:
        return (float) scaleWhenNotAvailable.getAsDouble();
    }

    Rect getAppSizeCompatBoundsIfAvailable(Rect boundsWhenNotAvailable) {
        if (hasSizeCompatBounds() == false) goto L6;
        return this.mSizeCompatBounds;
    L6:
        return boundsWhenNotAvailable;
    }

    Rect replaceResolvedBoundsIfNeeded(Rect resolvedBounds) {
        if (hasSizeCompatBounds() == false) goto L6;
        return this.mSizeCompatBounds;
    L6:
        return resolvedBounds;
    }

    boolean applyOffsetIfNeeded(Rect resolvedBounds, Configuration resolvedConfig, int offsetX, int offsetY) {
        if (hasSizeCompatBounds() == false) goto L6;
        this.mSizeCompatBounds.offset(offsetX, offsetY);
        int dy = this.mSizeCompatBounds.top - resolvedBounds.top;
        int dx = this.mSizeCompatBounds.left - resolvedBounds.left;
        AppCompatUtils.offsetBounds(resolvedConfig, dx, dy);
        return true;
    L6:
        return false;
    }

    void alignToTopIfNeeded(Rect parentBounds) {
        if (hasSizeCompatBounds() == false) goto L6;
        Rect r0 = this.mSizeCompatBounds;
        r0.top = parentBounds.top;
        return;
    }

    void applySizeCompatScaleIfNeeded(Rect resolvedBounds, Configuration resolvedConfig) {
        if (this.mSizeCompatScale == 1.0f) goto L6;
        int screenPosX = resolvedBounds.left;
        int screenPosY = resolvedBounds.top;
        int dx = ((int) ((screenPosX / this.mSizeCompatScale) + 0.5f)) - screenPosX;
        int dy = ((int) ((screenPosY / this.mSizeCompatScale) + 0.5f)) - screenPosY;
        AppCompatUtils.offsetBounds(resolvedConfig, dx, dy);
        return;
    }

    void updateSizeCompatScale(final Rect resolvedAppBounds, final Rect containerAppBounds, final Configuration newParentConfig) {
        this.mSizeCompatScale = ((Float) this.mActivityRecord.mAppCompatController.getTransparentPolicy().findOpaqueNotFinishingActivityBelow().map(new AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda0()).orElseGet(new AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda1(this, resolvedAppBounds, containerAppBounds, newParentConfig))).floatValue();
    }

    private static /* synthetic */ Float lambda$updateSizeCompatScale$0(ActivityRecord ar) {
        return Float.valueOf(Math.min(1.0f, ar.getCompatScale()));
    }

    private /* synthetic */ Float lambda$updateSizeCompatScale$1(Rect resolvedAppBounds, Rect containerAppBounds, Configuration newParentConfig) {
        return Float.valueOf(calculateSizeCompatScale(resolvedAppBounds, containerAppBounds, newParentConfig));
    }

    void clearSizeCompatModeAttributes() {
        this.mInSizeCompatModeForBounds = false;
        float lastSizeCompatScale = this.mSizeCompatScale;
        this.mSizeCompatScale = 1.0f;
        if (this.mSizeCompatScale == lastSizeCompatScale) goto L5;
        this.mActivityRecord.forAllWindows(new AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda2(), false);
    L5:
        this.mSizeCompatBounds = null;
        this.mAppCompatDisplayInsets = null;
        this.mActivityRecord.mAppCompatController.getTransparentPolicy().clearInheritedAppCompatDisplayInsets();
    }

    private Configuration clearOverrideConfiguration() {
        int activityType = this.mActivityRecord.getActivityType();
        Configuration overrideConfig = this.mActivityRecord.getRequestedOverrideConfiguration();
        overrideConfig.unset();
        overrideConfig.windowConfiguration.setActivityType(activityType);
        return overrideConfig;
    }

    void clearSizeCompatMode() {
        clearSizeCompatModeAttributes();
        Configuration overrideConfig = clearOverrideConfiguration();
        this.mActivityRecord.onRequestedOverrideConfigurationChanged(overrideConfig);
    }

    void clearSizeCompatModeIfNeededOnResolveOverrideConfiguration() {
        if (this.mAppCompatDisplayInsets != null) goto L5;
        return;
    L5:
        if (this.mActivityRecord.isUniversalResizeable() == false) goto L10;
        clearSizeCompatModeAttributes();
        clearOverrideConfiguration();
        return;
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mSizeCompatScale == 1.0f) goto L5;
    L6:
        pw.println(prefix + "mSizeCompatScale=" + this.mSizeCompatScale + " mSizeCompatBounds=" + this.mSizeCompatBounds);
        return;
    L5:
        if (hasSizeCompatBounds() == true) goto L6;
    }

    void resolveSizeCompatModeConfiguration(Configuration newParentConfiguration, AppCompatDisplayInsets appCompatDisplayInsets, Rect tmpBounds) {
        Configuration resolvedConfig = this.mActivityRecord.getResolvedOverrideConfiguration();
        Rect resolvedBounds = resolvedConfig.windowConfiguration.getBounds();
        AppCompatAspectRatioPolicy aspectRatioPolicy = this.mActivityRecord.mAppCompatController.getAspectRatioPolicy();
        boolean useResolvedBounds = aspectRatioPolicy.isAspectRatioApplied();
        if (useResolvedBounds == false) goto L5;
        Rect r3 = new Rect(resolvedBounds);
    L6:
        Rect containerBounds = r3;
        if (useResolvedBounds == false) goto L9;
        Rect r4 = new Rect(resolvedConfig.windowConfiguration.getAppBounds());
    L10:
        Rect containerAppBounds = r4;
        int requestedOrientation = this.mActivityRecord.getRequestedConfigurationOrientation();
        boolean topNotAligned = true;
        if (requestedOrientation == 0) goto L13;
        boolean orientationRequested = true;
    L15:
        if (this.mActivityRecord.mResolveConfigHint.mUseOverrideInsetsForConfig == false) goto L17;
        int parentOrientation = this.mActivityRecord.mResolveConfigHint.mTmpOverrideConfigOrientation;
    L19:
        if (orientationRequested == false) goto L22;
        int orientation = requestedOrientation;
    L25:
        int rotation = newParentConfiguration.windowConfiguration.getRotation();
        if (this.mActivityRecord.mDisplayContent != null) goto L28;
    L31:
        boolean isFixedToUserRotation = true;
    L32:
        boolean tasksAreFloating = newParentConfiguration.windowConfiguration.tasksAreFloating();
        if (isFixedToUserRotation == true) goto L36;
        if (tasksAreFloating == true) goto L36;
        resolvedConfig.windowConfiguration.setRotation(rotation);
    L39:
        Rect containingAppBounds = new Rect();
        int parentOrientation2 = parentOrientation;
        appCompatDisplayInsets.getContainerBounds(containingAppBounds, tmpBounds, rotation, orientation, orientationRequested, isFixedToUserRotation);
        resolvedBounds.set(tmpBounds);
        if (appCompatDisplayInsets.mIsFloating == true) goto L42;
        aspectRatioPolicy.applyAspectRatioForLetterbox(resolvedBounds, containingAppBounds, tmpBounds);
    L42:
        this.mActivityRecord.mResolveConfigHint.mTmpCompatInsets = appCompatDisplayInsets;
        this.mActivityRecord.computeConfigByResolveHint(resolvedConfig, newParentConfiguration);
        resolvedConfig.screenLayout = WindowContainer.computeScreenLayout(this.mActivityRecord.getConfiguration().screenLayout, resolvedConfig.screenWidthDp, resolvedConfig.screenHeightDp);
        if (resolvedConfig.screenWidthDp != resolvedConfig.screenHeightDp) goto L45;
        resolvedConfig.orientation = parentOrientation2;
    L45:
        Rect resolvedAppBounds = resolvedConfig.windowConfiguration.getAppBounds();
        float lastSizeCompatScale = this.mSizeCompatScale;
        updateSizeCompatScale(resolvedAppBounds, containerAppBounds, newParentConfiguration);
        if (tasksAreFloating == false) goto L48;
        int containerTopInset = 0;
    L50:
        if (containerTopInset != (resolvedAppBounds.top - resolvedBounds.top)) goto L54;
        topNotAligned = false;
    L54:
        if (this.mSizeCompatScale != 1.0f) goto L59;
        if (topNotAligned == true) goto L59;
        this.mSizeCompatBounds = null;
    L63:
        if (this.mSizeCompatScale == lastSizeCompatScale) goto L66;
        this.mActivityRecord.forAllWindows(new AppCompatSizeCompatModePolicy$$ExternalSyntheticLambda2(), false);
    L66:
        boolean fillContainer = resolvedBounds.equals(tmpBounds);
        if (fillContainer == false) goto L69;
        int screenPosX = containerBounds.left;
    L70:
        if (fillContainer == false) goto L72;
        int screenPosY = containerBounds.top;
    L73:
        if (screenPosX != 0) goto L78;
        if (screenPosY != 0) goto L78;
    L82:
        this.mInSizeCompatModeForBounds = isInSizeCompatModeForBounds(resolvedAppBounds, containerAppBounds);
        return;
    L78:
        if (hasSizeCompatBounds() == false) goto L81;
        this.mSizeCompatBounds.offset(screenPosX, screenPosY);
    L81:
        int dx = screenPosX - resolvedBounds.left;
        int screenPosX2 = resolvedBounds.top;
        int dy = screenPosY - screenPosX2;
        AppCompatUtils.offsetBounds(resolvedConfig, dx, dy);
        goto L82
    L72:
        screenPosY = containerAppBounds.top;
        goto L73
    L69:
        screenPosX = containerAppBounds.left;
    L59:
        if (this.mSizeCompatBounds != null) goto L61;
        this.mSizeCompatBounds = new Rect();
    L61:
        this.mSizeCompatBounds.set(resolvedAppBounds);
        this.mSizeCompatBounds.offsetTo(0, 0);
        this.mSizeCompatBounds.scale(this.mSizeCompatScale);
        this.mSizeCompatBounds.bottom += containerTopInset;
        goto L63
    L48:
        containerTopInset = containerAppBounds.top - containerBounds.top;
    L36:
        int overrideRotation = resolvedConfig.windowConfiguration.getRotation();
        if (overrideRotation == (-1)) goto L39;
        rotation = overrideRotation;
        goto L39
    L28:
        if (this.mActivityRecord.mDisplayContent.getDisplayRotation().isFixedToUserRotation() == true) goto L31;
        isFixedToUserRotation = false;
        goto L32
    L22:
        if (appCompatDisplayInsets.mOriginalRequestedOrientation == 0) goto L24;
        orientation = appCompatDisplayInsets.mOriginalRequestedOrientation;
        goto L25
    L24:
        orientation = parentOrientation;
        goto L25
    L17:
        parentOrientation = newParentConfiguration.orientation;
        goto L19
    L13:
        orientationRequested = false;
        goto L15
    L9:
        r4 = this.mActivityRecord.mResolveConfigHint.mParentAppBoundsOverride;
        goto L10
    L5:
        r3 = newParentConfiguration.windowConfiguration.getBounds();
        goto L6
    }

    void updateAppCompatDisplayInsets() {
        if (getAppCompatDisplayInsets() == null) goto L5;
        return;
    L5:
        if (this.mActivityRecord.shouldCreateAppCompatDisplayInsets() == false) goto L13;
        Configuration overrideConfig = this.mActivityRecord.getRequestedOverrideConfiguration();
        Configuration fullConfig = this.mActivityRecord.getConfiguration();
        overrideConfig.colorMode = fullConfig.colorMode;
        overrideConfig.densityDpi = fullConfig.densityDpi;
        overrideConfig.smallestScreenWidthDp = fullConfig.smallestScreenWidthDp;
        if (ActivityInfo.isFixedOrientation(this.mActivityRecord.getOverrideOrientation()) == false) goto L10;
        overrideConfig.windowConfiguration.setRotation(fullConfig.windowConfiguration.getRotation());
    L10:
        Rect letterboxedContainerBounds = this.mActivityRecord.mAppCompatController.getAspectRatioPolicy().getLetterboxedContainerBounds();
        this.mAppCompatDisplayInsets = new AppCompatDisplayInsets(this.mActivityRecord.mDisplayContent, this.mActivityRecord, letterboxedContainerBounds, this.mActivityRecord.mResolveConfigHint.mUseOverrideInsetsForConfig);
        return;
    }

    boolean inSizeCompatMode() {
        if (isInSizeCompatModeForBounds() == false) goto L6;
        return true;
    L6:
        if (getAppCompatDisplayInsets() != null) goto L8;
    L23:
        return false;
    L8:
        if (shouldCreateAppCompatDisplayInsets() == false) goto L23;
        if (this.mActivityRecord.isFixedRotationTransforming() == true) goto L23;
        Rect appBounds = this.mActivityRecord.getConfiguration().windowConfiguration.getAppBounds();
        if (appBounds != null) goto L15;
        return false;
    L15:
        WindowContainer<?> parent = this.mActivityRecord.getParent();
        if (parent != null) goto L18;
        return false;
    L18:
        Configuration parentConfig = parent.getConfiguration();
        if (parentConfig.densityDpi == this.mActivityRecord.getConfiguration().densityDpi) goto L22;
        return true;
    L22:
        return false;
    }

    boolean shouldCreateAppCompatDisplayInsets() {
        if (this.mActivityRecord.mAppCompatController.getAspectRatioOverrides().hasFullscreenOverride() == false) goto L6;
        return false;
    L6:
        switch(supportsSizeChanges()) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L33;
            default: goto L7;
        };
    L7:
        TaskDisplayArea tda = this.mActivityRecord.getTaskDisplayArea();
        if (this.mActivityRecord.inMultiWindowMode() == true) goto L12;
        if (tda != null) goto L11;
    L22:
        AppCompatAspectRatioPolicy aspectRatioPolicy = this.mActivityRecord.mAppCompatController.getAspectRatioPolicy();
        if (this.mActivityRecord.isResizeable() == false) goto L25;
        return false;
    L25:
        if (this.mActivityRecord.info.isFixedOrientation() == true) goto L29;
        if (aspectRatioPolicy.hasFixedAspectRatio() == true) goto L29;
        return false;
    L29:
        if (this.mActivityRecord.isActivityTypeStandardOrUndefined() == true) goto L32;
        return false;
    L32:
        return true;
    L11:
        if (tda.inFreeformWindowingMode() == false) goto L22;
    L12:
        Task task = this.mActivityRecord.getTask();
        if (task == null) goto L15;
        ActivityRecord root = task.getRootActivity();
    L16:
        if (root == null) goto L22;
        if (root == this.mActivityRecord) goto L22;
        if (root.shouldCreateAppCompatDisplayInsets() == true) goto L22;
        return false;
    L15:
        root = null;
        goto L16
    L33:
        return false;
    L34:
        return true;
    }

    int supportsSizeChanges() {
        AppCompatResizeOverrides resizeOverrides = this.mAppCompatOverrides.getResizeOverrides();
        if (resizeOverrides.shouldOverrideForceNonResizeApp() == false) goto L7;
        return 1;
    L7:
        if (this.mActivityRecord.info.supportsSizeChanges == false) goto L11;
        return 2;
    L11:
        if (resizeOverrides.shouldOverrideForceResizeApp() == false) goto L14;
        return 3;
    L14:
        return 0;
    }

    private boolean isInSizeCompatModeForBounds(Rect appBounds, Rect containerBounds) {
        if (this.mActivityRecord.mAppCompatController.getTransparentPolicy().isRunning() == false) goto L5;
        return false;
    L5:
        int appWidth = appBounds.width();
        int appHeight = appBounds.height();
        int containerAppWidth = containerBounds.width();
        int containerAppHeight = containerBounds.height();
        if (containerAppWidth != appWidth) goto L10;
        if (containerAppHeight != appHeight) goto L10;
        return false;
    L10:
        if (containerAppWidth <= appWidth) goto L13;
        if (containerAppHeight <= appHeight) goto L13;
        return true;
    L13:
        if (containerAppWidth < appWidth) goto L27;
        if (containerAppHeight < appHeight) goto L27;
        float maxAspectRatio = this.mActivityRecord.getMaxAspectRatio();
        if (maxAspectRatio <= 0.0f) goto L21;
        float aspectRatio = (Math.max(appWidth, appHeight) + 0.5f) / Math.min(appWidth, appHeight);
        if (aspectRatio < maxAspectRatio) goto L21;
        return false;
    L21:
        float minAspectRatio = this.mActivityRecord.getMinAspectRatio();
        if (minAspectRatio <= 0.0f) goto L26;
        float containerAspectRatio = (Math.max(containerAppWidth, containerAppHeight) + 0.5f) / Math.min(containerAppWidth, containerAppHeight);
        if (containerAspectRatio > minAspectRatio) goto L26;
        return false;
    L26:
        return true;
    L27:
        return true;
    }

    private float calculateSizeCompatScale(Rect resolvedAppBounds, Rect containerAppBounds, Configuration newParentConfig) {
        int contentW = resolvedAppBounds.width();
        int contentH = resolvedAppBounds.height();
        int viewportW = containerAppBounds.width();
        int viewportH = containerAppBounds.height();
        if (contentW > viewportW) goto L9;
        if (contentH > viewportH) goto L9;
        if (AppCompatUtils.isInDesktopMode(this.mActivityRecord.mAtmService.mContext, newParentConfig.windowConfiguration.getWindowingMode()) == true) goto L9;
        boolean shouldAllowUpscaling = false;
    L11:
        if (shouldAllowUpscaling == true) goto L15;
        return 1.0f;
    L15:
        return Math.min(viewportW / contentW, viewportH / contentH);
    L9:
        shouldAllowUpscaling = true;
        goto L11
    }
}
