package com.android.server.wm;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.android.server.wm.utils.DimenPxIntSupplier;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
final class AppCompatConfiguration {
    static final float DEFAULT_LETTERBOX_ASPECT_RATIO_FOR_MULTI_WINDOW = 1.01f;
    private static final boolean DEFAULT_VALUE_ALLOW_IGNORE_ORIENTATION_REQUEST = true;
    private static final boolean DEFAULT_VALUE_ENABLE_CAMERA_COMPAT_TREATMENT = true;
    private static final boolean DEFAULT_VALUE_ENABLE_COMPAT_FAKE_FOCUS = true;
    private static final boolean DEFAULT_VALUE_ENABLE_DISPLAY_ROTATION_IMMERSIVE_APP_COMPAT_POLICY = true;
    private static final boolean DEFAULT_VALUE_ENABLE_LETTERBOX_BACKGROUND_WALLPAPER = false;
    private static final boolean DEFAULT_VALUE_ENABLE_LETTERBOX_TRANSLUCENT_ACTIVITY = true;
    private static final boolean DEFAULT_VALUE_ENABLE_USER_ASPECT_RATIO_FULLSCREEN = true;
    private static final boolean DEFAULT_VALUE_ENABLE_USER_ASPECT_RATIO_SETTINGS = true;
    private static final String KEY_ALLOW_IGNORE_ORIENTATION_REQUEST = "allow_ignore_orientation_request";
    private static final String KEY_ENABLE_CAMERA_COMPAT_TREATMENT = "enable_compat_camera_treatment";
    private static final String KEY_ENABLE_COMPAT_FAKE_FOCUS = "enable_compat_fake_focus";
    private static final String KEY_ENABLE_DISPLAY_ROTATION_IMMERSIVE_APP_COMPAT_POLICY = "enable_display_rotation_immersive_app_compat_policy";
    private static final String KEY_ENABLE_LETTERBOX_BACKGROUND_WALLPAPER = "enable_letterbox_background_wallpaper";
    private static final String KEY_ENABLE_LETTERBOX_TRANSLUCENT_ACTIVITY = "enable_letterbox_translucent_activity";
    private static final String KEY_ENABLE_USER_ASPECT_RATIO_FULLSCREEN = "enable_app_compat_user_aspect_ratio_fullscreen";
    private static final String KEY_ENABLE_USER_ASPECT_RATIO_SETTINGS = "enable_app_compat_aspect_ratio_user_settings";
    static final int LETTERBOX_BACKGROUND_APP_COLOR_BACKGROUND = 1;
    static final int LETTERBOX_BACKGROUND_APP_COLOR_BACKGROUND_FLOATING = 2;
    static final int LETTERBOX_BACKGROUND_OVERRIDE_UNSET = -1;
    static final int LETTERBOX_BACKGROUND_SOLID_COLOR = 0;
    static final int LETTERBOX_BACKGROUND_WALLPAPER = 3;
    static final int LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_CENTER = 1;
    static final int LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_LEFT = 0;
    static final int LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_RIGHT = 2;
    static final float LETTERBOX_POSITION_MULTIPLIER_CENTER = 0.5f;
    static final int LETTERBOX_VERTICAL_REACHABILITY_POSITION_BOTTOM = 2;
    static final int LETTERBOX_VERTICAL_REACHABILITY_POSITION_CENTER = 1;
    static final int LETTERBOX_VERTICAL_REACHABILITY_POSITION_TOP = 0;
    static final float MIN_FIXED_ORIENTATION_LETTERBOX_ASPECT_RATIO = 1.0f;
    private static final String TAG = "ActivityTaskManager";
    private final AppCompatConfigurationPersister mAppCompatConfigurationPersister;
    private float mCameraCompatAspectRatio;
    final Context mContext;
    private float mDefaultMinAspectRatioForUnresizableApps;
    private int mDefaultPositionForHorizontalReachability;
    private int mDefaultPositionForVerticalReachability;
    private final SynchedDeviceConfig mDeviceConfig;
    private float mFixedOrientationLetterboxAspectRatio;
    private boolean mIsAutomaticReachabilityInBookModeEnabled;
    private boolean mIsCameraCompatFreeformWindowingTreatmentEnabled;
    private boolean mIsCameraCompatRefreshCycleThroughStopEnabled;
    private final boolean mIsCameraCompatSplitScreenAspectRatioEnabled;
    private boolean mIsCameraCompatTreatmentRefreshEnabled;
    private boolean mIsDisplayAspectRatioEnabledForFixedOrientationLetterbox;
    private boolean mIsEducationEnabled;
    private boolean mIsHorizontalReachabilityEnabled;
    private final boolean mIsPolicyForIgnoringRequestedOrientationEnabled;
    private boolean mIsSplitScreenAspectRatioForUnresizableAppsEnabled;
    private boolean mIsVerticalReachabilityEnabled;
    private int mLetterboxActivityCornersRadius;
    private Color mLetterboxBackgroundColorOverride;
    private Integer mLetterboxBackgroundColorResourceIdOverride;
    private final int mLetterboxBackgroundType;
    private int mLetterboxBackgroundTypeOverride;
    private int mLetterboxBackgroundWallpaperBlurRadiusPx;
    private float mLetterboxBackgroundWallpaperDarkScrimAlpha;
    private float mLetterboxBookModePositionMultiplier;
    private float mLetterboxHorizontalPositionMultiplier;
    private float mLetterboxTabletopModePositionMultiplier;
    private float mLetterboxVerticalPositionMultiplier;
    private final DimenPxIntSupplier mThinLetterboxHeightPxSupplier;
    private final DimenPxIntSupplier mThinLetterboxWidthPxSupplier;
    private boolean mTranslucentLetterboxingOverrideEnabled;
    private boolean mUserAppAspectRatioFullscreenOverrideEnabled;
    private boolean mUserAppAspectRatioSettingsOverrideEnabled;

    @Retention(RetentionPolicy.SOURCE)
    @interface LetterboxBackgroundType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LetterboxHorizontalReachabilityPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LetterboxVerticalReachabilityPosition {
    }

    /* JADX INFO: renamed from: $r8$lambda$1T9-bd9hU1PBwmmR2Ukw6jXdOCc, reason: not valid java name */
    public static /* synthetic */ Integer m9712$r8$lambda$1T9bd9hU1PBwmmR2Ukw6jXdOCc(Context r0) {
        return lambda$new$2(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$BiemjI3Bs0jz1dJh3ts4y4kSTFo(Context r0) {
        return lambda$new$1(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$KQ2bkE3MuAlvpzaFzr-XNi9YiUM, reason: not valid java name */
    public static /* synthetic */ Integer m9713$r8$lambda$KQ2bkE3MuAlvpzaFzrXNi9YiUM(boolean r0, Integer r1) {
        return lambda$movePositionForHorizontalReachabilityToNextLeftStop$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Oh5I2_GJ2LhD0pXm_ZTUkNtr-Jw, reason: not valid java name */
    public static /* synthetic */ Integer m9714$r8$lambda$Oh5I2_GJ2LhD0pXm_ZTUkNtrJw(boolean r0, Integer r1) {
        return lambda$movePositionForHorizontalReachabilityToNextRightStop$4(r0, r1);
    }

    public static /* synthetic */ Integer $r8$lambda$PTOq1ckEo7_ZoQCBsa5eR2iH428(Context r0) {
        return lambda$new$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Vaw-d6xHC7DU4IzQJxPTXUI96zU, reason: not valid java name */
    public static /* synthetic */ Integer m9715$r8$lambda$Vawd6xHC7DU4IzQJxPTXUI96zU(boolean r0, Integer r1) {
        return lambda$movePositionForVerticalReachabilityToNextTopStop$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YGl2W9-CUHlXccr4c-FWxmqxcZA, reason: not valid java name */
    public static /* synthetic */ Integer m9716$r8$lambda$YGl2W9CUHlXccr4cFWxmqxcZA(Context r0) {
        return lambda$new$0(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$q8CyIDu5FF5I69ki5uRYf3180RY(boolean r0, Integer r1) {
        return lambda$movePositionForVerticalReachabilityToNextBottomStop$6(r0, r1);
    }

    AppCompatConfiguration(final Context systemUiContext) {
        this(systemUiContext, new AppCompatConfigurationPersister(new AppCompatConfiguration$$ExternalSyntheticLambda3(systemUiContext), new AppCompatConfiguration$$ExternalSyntheticLambda4(systemUiContext), new AppCompatConfiguration$$ExternalSyntheticLambda5(systemUiContext), new AppCompatConfiguration$$ExternalSyntheticLambda6(systemUiContext)));
    }

    private static /* synthetic */ Integer lambda$new$0(Context systemUiContext) {
        return Integer.valueOf(readLetterboxHorizontalReachabilityPositionFromConfig(systemUiContext, false));
    }

    private static /* synthetic */ Integer lambda$new$1(Context systemUiContext) {
        return Integer.valueOf(readLetterboxVerticalReachabilityPositionFromConfig(systemUiContext, false));
    }

    private static /* synthetic */ Integer lambda$new$2(Context systemUiContext) {
        return Integer.valueOf(readLetterboxHorizontalReachabilityPositionFromConfig(systemUiContext, true));
    }

    private static /* synthetic */ Integer lambda$new$3(Context systemUiContext) {
        return Integer.valueOf(readLetterboxVerticalReachabilityPositionFromConfig(systemUiContext, true));
    }

    AppCompatConfiguration(Context systemUiContext, AppCompatConfigurationPersister appCompatConfigurationPersister) {
        this.mLetterboxBackgroundTypeOverride = -1;
        this.mIsCameraCompatTreatmentRefreshEnabled = true;
        this.mIsCameraCompatRefreshCycleThroughStopEnabled = true;
        this.mIsCameraCompatFreeformWindowingTreatmentEnabled = false;
        this.mContext = systemUiContext;
        this.mFixedOrientationLetterboxAspectRatio = this.mContext.getResources().getFloat(R.dimen.default_magnifier_corner_radius);
        this.mLetterboxBackgroundType = readLetterboxBackgroundTypeFromConfig(this.mContext);
        this.mLetterboxActivityCornersRadius = this.mContext.getResources().getInteger(R.integer.config_longPressOnPowerBehavior);
        this.mLetterboxBackgroundWallpaperBlurRadiusPx = this.mContext.getResources().getDimensionPixelSize(R.dimen.dialog_btn_confirm_height);
        this.mLetterboxBackgroundWallpaperDarkScrimAlpha = this.mContext.getResources().getFloat(R.dimen.desktop_view_default_header_height);
        setLetterboxHorizontalPositionMultiplier(this.mContext.getResources().getFloat(R.dimen.dialog_btn_negative_width));
        setLetterboxVerticalPositionMultiplier(this.mContext.getResources().getFloat(R.dimen.dialog_fixed_width_major));
        setLetterboxBookModePositionMultiplier(this.mContext.getResources().getFloat(R.dimen.dialog_btn_confirm_width));
        setLetterboxTabletopModePositionMultiplier(this.mContext.getResources().getFloat(R.dimen.dialog_corner_radius));
        this.mIsHorizontalReachabilityEnabled = this.mContext.getResources().getBoolean(R.bool.config_lockDayNightMode);
        this.mIsVerticalReachabilityEnabled = this.mContext.getResources().getBoolean(R.bool.config_lowPowerStandbyEnabledByDefault);
        this.mIsAutomaticReachabilityInBookModeEnabled = this.mContext.getResources().getBoolean(R.bool.config_letterboxIsSplitScreenAspectRatioForUnresizableAppsEnabled);
        this.mDefaultPositionForHorizontalReachability = readLetterboxHorizontalReachabilityPositionFromConfig(this.mContext, false);
        this.mDefaultPositionForVerticalReachability = readLetterboxVerticalReachabilityPositionFromConfig(this.mContext, false);
        this.mIsEducationEnabled = this.mContext.getResources().getBoolean(R.bool.config_lidControlsSleep);
        setDefaultMinAspectRatioForUnresizableApps(this.mContext.getResources().getFloat(R.dimen.dialog_btn_negative_height));
        this.mIsSplitScreenAspectRatioForUnresizableAppsEnabled = this.mContext.getResources().getBoolean(R.bool.config_longPressOnPowerForAssistantSettingAvailable);
        this.mIsDisplayAspectRatioEnabledForFixedOrientationLetterbox = this.mContext.getResources().getBoolean(R.bool.config_letterboxIsVerticalReachabilityEnabled);
        this.mIsCameraCompatSplitScreenAspectRatioEnabled = this.mContext.getResources().getBoolean(R.bool.config_keyguardUserSwitcher);
        this.mCameraCompatAspectRatio = this.mContext.getResources().getFloat(R.dimen.floating_window_margin_left);
        this.mIsPolicyForIgnoringRequestedOrientationEnabled = this.mContext.getResources().getBoolean(R.bool.config_lockUiMode);
        this.mThinLetterboxWidthPxSupplier = new DimenPxIntSupplier(this.mContext, R.dimen.dialog_fixed_height_minor);
        this.mThinLetterboxHeightPxSupplier = new DimenPxIntSupplier(this.mContext, R.dimen.dialog_fixed_height_major);
        this.mAppCompatConfigurationPersister = appCompatConfigurationPersister;
        this.mAppCompatConfigurationPersister.start();
        this.mDeviceConfig = SynchedDeviceConfig.builder("window_manager", systemUiContext.getMainExecutor()).addDeviceConfigEntry(KEY_ENABLE_CAMERA_COMPAT_TREATMENT, true, this.mContext.getResources().getBoolean(R.bool.config_knownNetworksEnabledForService)).addDeviceConfigEntry(KEY_ENABLE_DISPLAY_ROTATION_IMMERSIVE_APP_COMPAT_POLICY, true, this.mContext.getResources().getBoolean(R.bool.config_lidControlsScreenLock)).addDeviceConfigEntry(KEY_ALLOW_IGNORE_ORIENTATION_REQUEST, true, true).addDeviceConfigEntry(KEY_ENABLE_COMPAT_FAKE_FOCUS, true, this.mContext.getResources().getBoolean(R.bool.config_isWindowManagerCameraCompatTreatmentEnabled)).addDeviceConfigEntry(KEY_ENABLE_LETTERBOX_TRANSLUCENT_ACTIVITY, true, this.mContext.getResources().getBoolean(R.bool.config_localDisplaysMirrorContent)).addDeviceConfigEntry(KEY_ENABLE_USER_ASPECT_RATIO_SETTINGS, true, this.mContext.getResources().getBoolean(R.bool.config_attachNavBarToAppDuringTransition)).addDeviceConfigEntry(KEY_ENABLE_LETTERBOX_BACKGROUND_WALLPAPER, false, true).addDeviceConfigEntry(KEY_ENABLE_USER_ASPECT_RATIO_FULLSCREEN, true, this.mContext.getResources().getBoolean(R.bool.config_assistTouchGestureEnabledDefault)).build();
    }

    boolean isIgnoreOrientationRequestAllowed() {
        return this.mDeviceConfig.getFlagValue(KEY_ALLOW_IGNORE_ORIENTATION_REQUEST);
    }

    void setFixedOrientationLetterboxAspectRatio(float aspectRatio) {
        this.mFixedOrientationLetterboxAspectRatio = aspectRatio;
    }

    void resetFixedOrientationLetterboxAspectRatio() {
        this.mFixedOrientationLetterboxAspectRatio = this.mContext.getResources().getFloat(R.dimen.default_magnifier_corner_radius);
    }

    float getFixedOrientationLetterboxAspectRatio() {
        return this.mFixedOrientationLetterboxAspectRatio;
    }

    void resetDefaultMinAspectRatioForUnresizableApps() {
        setDefaultMinAspectRatioForUnresizableApps(this.mContext.getResources().getFloat(R.dimen.dialog_btn_negative_height));
    }

    float getDefaultMinAspectRatioForUnresizableApps() {
        return this.mDefaultMinAspectRatioForUnresizableApps;
    }

    void setDefaultMinAspectRatioForUnresizableApps(float aspectRatio) {
        this.mDefaultMinAspectRatioForUnresizableApps = aspectRatio;
    }

    void setLetterboxActivityCornersRadius(int cornersRadius) {
        this.mLetterboxActivityCornersRadius = cornersRadius;
    }

    void resetLetterboxActivityCornersRadius() {
        this.mLetterboxActivityCornersRadius = this.mContext.getResources().getInteger(R.integer.config_longPressOnPowerBehavior);
    }

    boolean isLetterboxActivityCornersRounded() {
        if (getLetterboxActivityCornersRadius() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    int getLetterboxActivityCornersRadius() {
        return this.mLetterboxActivityCornersRadius;
    }

    Color getLetterboxBackgroundColor() {
        if (this.mLetterboxBackgroundColorOverride == null) goto L7;
        return this.mLetterboxBackgroundColorOverride;
    L7:
        if (this.mLetterboxBackgroundColorResourceIdOverride == null) goto L9;
        int colorId = this.mLetterboxBackgroundColorResourceIdOverride.intValue();
    L11:
        return Color.valueOf(this.mContext.getResources().getColor(colorId));
    L9:
        colorId = R.color.datepicker_default_selected_text_color_material_light;
        goto L11
    }

    void setLetterboxBackgroundColor(Color color) {
        this.mLetterboxBackgroundColorOverride = color;
    }

    void setLetterboxBackgroundColorResourceId(int colorId) {
        this.mLetterboxBackgroundColorResourceIdOverride = Integer.valueOf(colorId);
    }

    void resetLetterboxBackgroundColor() {
        this.mLetterboxBackgroundColorOverride = null;
        this.mLetterboxBackgroundColorResourceIdOverride = null;
    }

    int getLetterboxBackgroundType() {
        if (this.mLetterboxBackgroundTypeOverride == (-1)) goto L6;
        return this.mLetterboxBackgroundTypeOverride;
    L6:
        return getDefaultLetterboxBackgroundType();
    }

    void setLetterboxBackgroundTypeOverride(int backgroundType) {
        this.mLetterboxBackgroundTypeOverride = backgroundType;
    }

    void resetLetterboxBackgroundType() {
        this.mLetterboxBackgroundTypeOverride = -1;
    }

    private int getDefaultLetterboxBackgroundType() {
        if (this.mDeviceConfig.getFlagValue(KEY_ENABLE_LETTERBOX_BACKGROUND_WALLPAPER) == false) goto L6;
        return 3;
    L6:
        return this.mLetterboxBackgroundType;
    }

    static String letterboxBackgroundTypeToString(int backgroundType) {
        switch(backgroundType) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "LETTERBOX_BACKGROUND_WALLPAPER";
    L7:
        return "LETTERBOX_BACKGROUND_APP_COLOR_BACKGROUND_FLOATING";
    L9:
        return "LETTERBOX_BACKGROUND_APP_COLOR_BACKGROUND";
    L11:
        return "LETTERBOX_BACKGROUND_SOLID_COLOR";
    L4:
        return "unknown=" + backgroundType;
    }

    private static int readLetterboxBackgroundTypeFromConfig(Context context) {
        int backgroundType = context.getResources().getInteger(R.integer.config_longPressOnPowerDurationMs);
        if (backgroundType == 0) goto L13;
        if (backgroundType == 1) goto L13;
        if (backgroundType == 2) goto L13;
        if (backgroundType == 3) goto L13;
        return 0;
    L13:
        return backgroundType;
    }

    void setLetterboxBackgroundWallpaperDarkScrimAlpha(float alpha) {
        this.mLetterboxBackgroundWallpaperDarkScrimAlpha = alpha;
    }

    void resetLetterboxBackgroundWallpaperDarkScrimAlpha() {
        this.mLetterboxBackgroundWallpaperDarkScrimAlpha = this.mContext.getResources().getFloat(R.dimen.desktop_view_default_header_height);
    }

    float getLetterboxBackgroundWallpaperDarkScrimAlpha() {
        return this.mLetterboxBackgroundWallpaperDarkScrimAlpha;
    }

    void setLetterboxBackgroundWallpaperBlurRadiusPx(int radius) {
        this.mLetterboxBackgroundWallpaperBlurRadiusPx = radius;
    }

    void resetLetterboxBackgroundWallpaperBlurRadiusPx() {
        this.mLetterboxBackgroundWallpaperBlurRadiusPx = this.mContext.getResources().getDimensionPixelSize(R.dimen.dialog_btn_confirm_height);
    }

    int getLetterboxBackgroundWallpaperBlurRadiusPx() {
        return this.mLetterboxBackgroundWallpaperBlurRadiusPx;
    }

    float getLetterboxHorizontalPositionMultiplier(boolean isInBookMode) {
        if (isInBookMode == false) goto L5;
        return this.mLetterboxBookModePositionMultiplier;
    L5:
        return this.mLetterboxHorizontalPositionMultiplier;
    }

    float getLetterboxVerticalPositionMultiplier(boolean isInTabletopMode) {
        if (isInTabletopMode == false) goto L5;
        return this.mLetterboxTabletopModePositionMultiplier;
    L5:
        return this.mLetterboxVerticalPositionMultiplier;
    }

    void setLetterboxHorizontalPositionMultiplier(float multiplier) {
        this.mLetterboxHorizontalPositionMultiplier = assertValidMultiplier(multiplier, "mLetterboxHorizontalPositionMultiplier");
    }

    void setLetterboxVerticalPositionMultiplier(float multiplier) {
        this.mLetterboxVerticalPositionMultiplier = assertValidMultiplier(multiplier, "mLetterboxVerticalPositionMultiplier");
    }

    void resetLetterboxHorizontalPositionMultiplier() {
        this.mLetterboxHorizontalPositionMultiplier = this.mContext.getResources().getFloat(R.dimen.dialog_btn_negative_width);
    }

    void resetLetterboxVerticalPositionMultiplier() {
        this.mLetterboxVerticalPositionMultiplier = this.mContext.getResources().getFloat(R.dimen.dialog_fixed_width_major);
    }

    void setLetterboxTabletopModePositionMultiplier(float multiplier) {
        this.mLetterboxTabletopModePositionMultiplier = assertValidMultiplier(multiplier, "mLetterboxTabletopModePositionMultiplier");
    }

    void setLetterboxBookModePositionMultiplier(float multiplier) {
        this.mLetterboxBookModePositionMultiplier = assertValidMultiplier(multiplier, "mLetterboxBookModePositionMultiplier");
    }

    boolean getIsHorizontalReachabilityEnabled() {
        return this.mIsHorizontalReachabilityEnabled;
    }

    boolean getIsVerticalReachabilityEnabled() {
        return this.mIsVerticalReachabilityEnabled;
    }

    boolean getIsAutomaticReachabilityInBookModeEnabled() {
        return this.mIsAutomaticReachabilityInBookModeEnabled;
    }

    void setIsHorizontalReachabilityEnabled(boolean enabled) {
        this.mIsHorizontalReachabilityEnabled = enabled;
    }

    void setIsVerticalReachabilityEnabled(boolean enabled) {
        this.mIsVerticalReachabilityEnabled = enabled;
    }

    void setIsAutomaticReachabilityInBookModeEnabled(boolean enabled) {
        this.mIsAutomaticReachabilityInBookModeEnabled = enabled;
    }

    void resetIsHorizontalReachabilityEnabled() {
        this.mIsHorizontalReachabilityEnabled = this.mContext.getResources().getBoolean(R.bool.config_lockDayNightMode);
    }

    void resetIsVerticalReachabilityEnabled() {
        this.mIsVerticalReachabilityEnabled = this.mContext.getResources().getBoolean(R.bool.config_lowPowerStandbyEnabledByDefault);
    }

    void resetEnabledAutomaticReachabilityInBookMode() {
        this.mIsAutomaticReachabilityInBookModeEnabled = this.mContext.getResources().getBoolean(R.bool.config_letterboxIsSplitScreenAspectRatioForUnresizableAppsEnabled);
    }

    int getDefaultPositionForHorizontalReachability() {
        return this.mDefaultPositionForHorizontalReachability;
    }

    int getDefaultPositionForVerticalReachability() {
        return this.mDefaultPositionForVerticalReachability;
    }

    void setDefaultPositionForHorizontalReachability(int position) {
        this.mDefaultPositionForHorizontalReachability = position;
    }

    void setDefaultPositionForVerticalReachability(int position) {
        this.mDefaultPositionForVerticalReachability = position;
    }

    void resetDefaultPositionForHorizontalReachability() {
        this.mDefaultPositionForHorizontalReachability = readLetterboxHorizontalReachabilityPositionFromConfig(this.mContext, false);
    }

    void resetDefaultPositionForVerticalReachability() {
        this.mDefaultPositionForVerticalReachability = readLetterboxVerticalReachabilityPositionFromConfig(this.mContext, false);
    }

    void setPersistentLetterboxPositionForHorizontalReachability(boolean forBookMode, int position) {
        this.mAppCompatConfigurationPersister.setLetterboxPositionForHorizontalReachability(forBookMode, position);
    }

    void setPersistentLetterboxPositionForVerticalReachability(boolean forTabletopMode, int position) {
        this.mAppCompatConfigurationPersister.setLetterboxPositionForVerticalReachability(forTabletopMode, position);
    }

    void resetPersistentLetterboxPositionForHorizontalReachability() {
        this.mAppCompatConfigurationPersister.setLetterboxPositionForHorizontalReachability(false, readLetterboxHorizontalReachabilityPositionFromConfig(this.mContext, false));
        this.mAppCompatConfigurationPersister.setLetterboxPositionForHorizontalReachability(true, readLetterboxHorizontalReachabilityPositionFromConfig(this.mContext, true));
    }

    void resetPersistentLetterboxPositionForVerticalReachability() {
        this.mAppCompatConfigurationPersister.setLetterboxPositionForVerticalReachability(false, readLetterboxVerticalReachabilityPositionFromConfig(this.mContext, false));
        this.mAppCompatConfigurationPersister.setLetterboxPositionForVerticalReachability(true, readLetterboxVerticalReachabilityPositionFromConfig(this.mContext, true));
    }

    private static int readLetterboxHorizontalReachabilityPositionFromConfig(Context context, boolean forBookMode) {
        Resources r0 = context.getResources();
        if (forBookMode == false) goto L5;
        int r1 = R.integer.config_longPressOnStemPrimaryBehavior;
    L6:
        int position = r0.getInteger(r1);
        if (position == 0) goto L15;
        if (position == 1) goto L15;
        if (position == 2) goto L15;
        return 1;
    L15:
        return position;
    L5:
        r1 = R.integer.config_lowBatteryAutoTriggerDefaultLevel;
        goto L6
    }

    private static int readLetterboxVerticalReachabilityPositionFromConfig(Context context, boolean forTabletopMode) {
        Resources r0 = context.getResources();
        if (forTabletopMode == false) goto L5;
        int r1 = R.integer.config_lowBatteryCloseWarningBump;
    L6:
        int position = r0.getInteger(r1);
        if (position == 0) goto L15;
        if (position == 1) goto L15;
        if (position == 2) goto L15;
        return 1;
    L15:
        return position;
    L5:
        r1 = R.integer.config_lowBatteryWarningLevel;
        goto L6
    }

    float getHorizontalMultiplierForReachability(boolean isDeviceInBookMode) {
        int letterboxPositionForHorizontalReachability = this.mAppCompatConfigurationPersister.getLetterboxPositionForHorizontalReachability(isDeviceInBookMode);
        switch(letterboxPositionForHorizontalReachability) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        return 1.0f;
    L8:
        return LETTERBOX_POSITION_MULTIPLIER_CENTER;
    L10:
        return 0.0f;
    L5:
        throw new AssertionError("Unexpected letterbox position type: " + letterboxPositionForHorizontalReachability);
    }

    float getVerticalMultiplierForReachability(boolean isDeviceInTabletopMode) {
        int letterboxPositionForVerticalReachability = this.mAppCompatConfigurationPersister.getLetterboxPositionForVerticalReachability(isDeviceInTabletopMode);
        switch(letterboxPositionForVerticalReachability) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        return 1.0f;
    L8:
        return LETTERBOX_POSITION_MULTIPLIER_CENTER;
    L10:
        return 0.0f;
    L5:
        throw new AssertionError("Unexpected letterbox position type: " + letterboxPositionForVerticalReachability);
    }

    int getLetterboxPositionForHorizontalReachability(boolean isInFullScreenBookMode) {
        return this.mAppCompatConfigurationPersister.getLetterboxPositionForHorizontalReachability(isInFullScreenBookMode);
    }

    int getLetterboxPositionForVerticalReachability(boolean isInFullScreenTabletopMode) {
        return this.mAppCompatConfigurationPersister.getLetterboxPositionForVerticalReachability(isInFullScreenTabletopMode);
    }

    static String letterboxHorizontalReachabilityPositionToString(int position) {
        switch(position) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_RIGHT";
    L7:
        return "LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_CENTER";
    L9:
        return "LETTERBOX_HORIZONTAL_REACHABILITY_POSITION_LEFT";
    L4:
        throw new AssertionError("Unexpected letterbox position type: " + position);
    }

    static String letterboxVerticalReachabilityPositionToString(int position) {
        switch(position) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "LETTERBOX_VERTICAL_REACHABILITY_POSITION_BOTTOM";
    L7:
        return "LETTERBOX_VERTICAL_REACHABILITY_POSITION_CENTER";
    L9:
        return "LETTERBOX_VERTICAL_REACHABILITY_POSITION_TOP";
    L4:
        throw new AssertionError("Unexpected letterbox position type: " + position);
    }

    private static /* synthetic */ Integer lambda$movePositionForHorizontalReachabilityToNextRightStop$4(boolean isDeviceInBookMode, Integer prev) {
        int r0 = prev.intValue();
        if (isDeviceInBookMode == false) goto L5;
        int r2 = 2;
    L7:
        return Integer.valueOf(Math.min(r0 + r2, 2));
    L5:
        r2 = 1;
        goto L7
    }

    void movePositionForHorizontalReachabilityToNextRightStop(final boolean isDeviceInBookMode) {
        updatePositionForHorizontalReachability(isDeviceInBookMode, new AppCompatConfiguration$$ExternalSyntheticLambda2(isDeviceInBookMode));
    }

    private static /* synthetic */ Integer lambda$movePositionForHorizontalReachabilityToNextLeftStop$5(boolean isDeviceInBookMode, Integer prev) {
        int r0 = prev.intValue();
        if (isDeviceInBookMode == false) goto L5;
        int r1 = 2;
    L7:
        return Integer.valueOf(Math.max(r0 - r1, 0));
    L5:
        r1 = 1;
        goto L7
    }

    void movePositionForHorizontalReachabilityToNextLeftStop(final boolean isDeviceInBookMode) {
        updatePositionForHorizontalReachability(isDeviceInBookMode, new AppCompatConfiguration$$ExternalSyntheticLambda0(isDeviceInBookMode));
    }

    private static /* synthetic */ Integer lambda$movePositionForVerticalReachabilityToNextBottomStop$6(boolean isDeviceInTabletopMode, Integer prev) {
        int r0 = prev.intValue();
        if (isDeviceInTabletopMode == false) goto L5;
        int r2 = 2;
    L7:
        return Integer.valueOf(Math.min(r0 + r2, 2));
    L5:
        r2 = 1;
        goto L7
    }

    void movePositionForVerticalReachabilityToNextBottomStop(final boolean isDeviceInTabletopMode) {
        updatePositionForVerticalReachability(isDeviceInTabletopMode, new AppCompatConfiguration$$ExternalSyntheticLambda7(isDeviceInTabletopMode));
    }

    private static /* synthetic */ Integer lambda$movePositionForVerticalReachabilityToNextTopStop$7(boolean isDeviceInTabletopMode, Integer prev) {
        int r0 = prev.intValue();
        if (isDeviceInTabletopMode == false) goto L5;
        int r1 = 2;
    L7:
        return Integer.valueOf(Math.max(r0 - r1, 0));
    L5:
        r1 = 1;
        goto L7
    }

    void movePositionForVerticalReachabilityToNextTopStop(final boolean isDeviceInTabletopMode) {
        updatePositionForVerticalReachability(isDeviceInTabletopMode, new AppCompatConfiguration$$ExternalSyntheticLambda1(isDeviceInTabletopMode));
    }

    boolean getIsEducationEnabled() {
        return this.mIsEducationEnabled;
    }

    void setIsEducationEnabled(boolean enabled) {
        this.mIsEducationEnabled = enabled;
    }

    void resetIsEducationEnabled() {
        this.mIsEducationEnabled = this.mContext.getResources().getBoolean(R.bool.config_lidControlsSleep);
    }

    boolean getIsSplitScreenAspectRatioForUnresizableAppsEnabled() {
        return this.mIsSplitScreenAspectRatioForUnresizableAppsEnabled;
    }

    boolean getIsDisplayAspectRatioEnabledForFixedOrientationLetterbox() {
        return this.mIsDisplayAspectRatioEnabledForFixedOrientationLetterbox;
    }

    int getThinLetterboxWidthPx() {
        return this.mThinLetterboxWidthPxSupplier.getAsInt();
    }

    int getThinLetterboxHeightPx() {
        return this.mThinLetterboxHeightPxSupplier.getAsInt();
    }

    void setIsSplitScreenAspectRatioForUnresizableAppsEnabled(boolean enabled) {
        this.mIsSplitScreenAspectRatioForUnresizableAppsEnabled = enabled;
    }

    void setIsDisplayAspectRatioEnabledForFixedOrientationLetterbox(boolean enabled) {
        this.mIsDisplayAspectRatioEnabledForFixedOrientationLetterbox = enabled;
    }

    void resetIsSplitScreenAspectRatioForUnresizableAppsEnabled() {
        this.mIsSplitScreenAspectRatioForUnresizableAppsEnabled = this.mContext.getResources().getBoolean(R.bool.config_longPressOnPowerForAssistantSettingAvailable);
    }

    void resetIsDisplayAspectRatioEnabledForFixedOrientationLetterbox() {
        this.mIsDisplayAspectRatioEnabledForFixedOrientationLetterbox = this.mContext.getResources().getBoolean(R.bool.config_letterboxIsVerticalReachabilityEnabled);
    }

    boolean isTranslucentLetterboxingEnabled() {
        if (this.mTranslucentLetterboxingOverrideEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDeviceConfig.getFlagValue(KEY_ENABLE_LETTERBOX_TRANSLUCENT_ACTIVITY) == true) goto L8;
        return false;
    }

    void setTranslucentLetterboxingOverrideEnabled(boolean translucentLetterboxingOverrideEnabled) {
        this.mTranslucentLetterboxingOverrideEnabled = translucentLetterboxingOverrideEnabled;
    }

    void resetTranslucentLetterboxingEnabled() {
        setTranslucentLetterboxingOverrideEnabled(false);
    }

    private void updatePositionForHorizontalReachability(boolean isDeviceInBookMode, Function<Integer, Integer> newHorizonalPositionFun) {
        int letterboxPositionForHorizontalReachability = this.mAppCompatConfigurationPersister.getLetterboxPositionForHorizontalReachability(isDeviceInBookMode);
        int nextHorizontalPosition = newHorizonalPositionFun.apply(Integer.valueOf(letterboxPositionForHorizontalReachability)).intValue();
        this.mAppCompatConfigurationPersister.setLetterboxPositionForHorizontalReachability(isDeviceInBookMode, nextHorizontalPosition);
    }

    private void updatePositionForVerticalReachability(boolean isDeviceInTabletopMode, Function<Integer, Integer> newVerticalPositionFun) {
        int letterboxPositionForVerticalReachability = this.mAppCompatConfigurationPersister.getLetterboxPositionForVerticalReachability(isDeviceInTabletopMode);
        int nextVerticalPosition = newVerticalPositionFun.apply(Integer.valueOf(letterboxPositionForVerticalReachability)).intValue();
        this.mAppCompatConfigurationPersister.setLetterboxPositionForVerticalReachability(isDeviceInTabletopMode, nextVerticalPosition);
    }

    boolean isCompatFakeFocusEnabled() {
        return this.mDeviceConfig.getFlagValue(KEY_ENABLE_COMPAT_FAKE_FOCUS);
    }

    boolean isPolicyForIgnoringRequestedOrientationEnabled() {
        return this.mIsPolicyForIgnoringRequestedOrientationEnabled;
    }

    boolean isCameraCompatSplitScreenAspectRatioEnabled() {
        return this.mIsCameraCompatSplitScreenAspectRatioEnabled;
    }

    boolean isCameraCompatTreatmentEnabled() {
        return this.mDeviceConfig.getFlagValue(KEY_ENABLE_CAMERA_COMPAT_TREATMENT);
    }

    boolean isCameraCompatTreatmentEnabledAtBuildTime() {
        return this.mDeviceConfig.isBuildTimeFlagEnabled(KEY_ENABLE_CAMERA_COMPAT_TREATMENT);
    }

    boolean isCameraCompatRefreshEnabled() {
        return this.mIsCameraCompatTreatmentRefreshEnabled;
    }

    void setCameraCompatRefreshEnabled(boolean enabled) {
        this.mIsCameraCompatTreatmentRefreshEnabled = enabled;
    }

    void resetCameraCompatRefreshEnabled() {
        this.mIsCameraCompatTreatmentRefreshEnabled = true;
    }

    boolean isCameraCompatRefreshCycleThroughStopEnabled() {
        return this.mIsCameraCompatRefreshCycleThroughStopEnabled;
    }

    void setCameraCompatRefreshCycleThroughStopEnabled(boolean enabled) {
        this.mIsCameraCompatRefreshCycleThroughStopEnabled = enabled;
    }

    void resetCameraCompatRefreshCycleThroughStopEnabled() {
        this.mIsCameraCompatRefreshCycleThroughStopEnabled = true;
    }

    void setCameraCompatAspectRatio(float aspectRatio) {
        this.mCameraCompatAspectRatio = aspectRatio;
    }

    float getCameraCompatAspectRatio() {
        return this.mCameraCompatAspectRatio;
    }

    void resetCameraCompatAspectRatio() {
        this.mCameraCompatAspectRatio = this.mContext.getResources().getFloat(R.dimen.floating_window_margin_left);
    }

    void setIsCameraCompatFreeformWindowingTreatmentEnabled(boolean enabled) {
        this.mIsCameraCompatFreeformWindowingTreatmentEnabled = enabled;
    }

    boolean isCameraCompatFreeformWindowingTreatmentEnabled() {
        return this.mIsCameraCompatFreeformWindowingTreatmentEnabled;
    }

    void resetIsCameraCompatFreeformWindowingTreatmentEnabled() {
        this.mIsCameraCompatFreeformWindowingTreatmentEnabled = false;
    }

    boolean isDisplayRotationImmersiveAppCompatPolicyEnabledAtBuildTime() {
        return this.mDeviceConfig.isBuildTimeFlagEnabled(KEY_ENABLE_DISPLAY_ROTATION_IMMERSIVE_APP_COMPAT_POLICY);
    }

    boolean isDisplayRotationImmersiveAppCompatPolicyEnabled() {
        return this.mDeviceConfig.getFlagValue(KEY_ENABLE_DISPLAY_ROTATION_IMMERSIVE_APP_COMPAT_POLICY);
    }

    boolean isUserAppAspectRatioSettingsEnabled() {
        if (this.mUserAppAspectRatioSettingsOverrideEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDeviceConfig.getFlagValue(KEY_ENABLE_USER_ASPECT_RATIO_SETTINGS) == true) goto L8;
        return false;
    }

    void setUserAppAspectRatioSettingsOverrideEnabled(boolean enabled) {
        this.mUserAppAspectRatioSettingsOverrideEnabled = enabled;
    }

    void resetUserAppAspectRatioSettingsEnabled() {
        setUserAppAspectRatioSettingsOverrideEnabled(false);
    }

    boolean isUserAppAspectRatioFullscreenEnabled() {
        if (isUserAppAspectRatioSettingsEnabled() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mUserAppAspectRatioFullscreenOverrideEnabled == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mDeviceConfig.getFlagValue(KEY_ENABLE_USER_ASPECT_RATIO_FULLSCREEN) == false) goto L9;
        goto L8
    }

    void setUserAppAspectRatioFullscreenOverrideEnabled(boolean enabled) {
        this.mUserAppAspectRatioFullscreenOverrideEnabled = enabled;
    }

    void resetUserAppAspectRatioFullscreenEnabled() {
        setUserAppAspectRatioFullscreenOverrideEnabled(false);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "  letterboxPositionForHorizontalReachability=" + letterboxHorizontalReachabilityPositionToString(getLetterboxPositionForHorizontalReachability(false)));
        pw.println(prefix + "  letterboxPositionForVerticalReachability=" + letterboxVerticalReachabilityPositionToString(getLetterboxPositionForVerticalReachability(false)));
        pw.println(prefix + "  fixedOrientationLetterboxAspectRatio=" + getFixedOrientationLetterboxAspectRatio());
        pw.println(prefix + "  defaultMinAspectRatioForUnresizableApps=" + getDefaultMinAspectRatioForUnresizableApps());
        pw.println(prefix + "  isSplitScreenAspectRatioForUnresizableAppsEnabled=" + getIsSplitScreenAspectRatioForUnresizableAppsEnabled());
        pw.println(prefix + "  isDisplayAspectRatioEnabledForFixedOrientationLetterbox=" + getIsDisplayAspectRatioEnabledForFixedOrientationLetterbox());
    }

    private float assertValidMultiplier(float multiplier, String multiplierName) throws IllegalArgumentException {
        if (multiplier < 0.0f) goto L8;
        if (multiplier > 1.0f) goto L8;
        return multiplier;
    L8:
        throw new IllegalArgumentException("Trying to set " + multiplierName + " out of bounds: " + multiplier);
    }
}
