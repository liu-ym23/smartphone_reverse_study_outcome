package com.android.systemui.shared;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_AMBIENT_AOD = "com.android.systemui.shared.ambient_aod";
    public static final String FLAG_BOUNCER_AREA_EXCLUSION = "com.android.systemui.shared.bouncer_area_exclusion";
    public static final String FLAG_CLOCK_REACTIVE_SMARTSPACE_LAYOUT = "com.android.systemui.shared.clock_reactive_smartspace_layout";
    public static final String FLAG_CLOCK_REACTIVE_VARIANTS = "com.android.systemui.shared.clock_reactive_variants";
    public static final String FLAG_CURSOR_HOT_CORNER = "com.android.systemui.shared.cursor_hot_corner";
    public static final String FLAG_ENABLE_HOME_DELAY = "com.android.systemui.shared.enable_home_delay";
    public static final String FLAG_ENABLE_LPP_SQUEEZE_EFFECT = "com.android.systemui.shared.enable_lpp_squeeze_effect";
    public static final String FLAG_EXAMPLE_SHARED_FLAG = "com.android.systemui.shared.example_shared_flag";
    public static final String FLAG_EXTENDED_WALLPAPER_EFFECTS = "com.android.systemui.shared.extended_wallpaper_effects";
    public static final String FLAG_LOCKSCREEN_CUSTOM_CLOCKS = "com.android.systemui.shared.lockscreen_custom_clocks";
    public static final String FLAG_NEW_CUSTOMIZATION_PICKER_UI = "com.android.systemui.shared.new_customization_picker_ui";
    public static final String FLAG_NEW_TOUCHPAD_GESTURES_TUTORIAL = "com.android.systemui.shared.new_touchpad_gestures_tutorial";
    public static final String FLAG_RETURN_ANIMATION_FRAMEWORK_LIBRARY = "com.android.systemui.shared.return_animation_framework_library";
    public static final String FLAG_RETURN_ANIMATION_FRAMEWORK_LONG_LIVED = "com.android.systemui.shared.return_animation_framework_long_lived";
    public static final String FLAG_SCREENSHOT_CONTEXT_URL = "com.android.systemui.shared.screenshot_context_url";
    public static final String FLAG_SHADE_ALLOW_BACK_GESTURE = "com.android.systemui.shared.shade_allow_back_gesture";
    public static final String FLAG_SIDEFPS_CONTROLLER_REFACTOR = "com.android.systemui.shared.sidefps_controller_refactor";
    public static final String FLAG_SMARTSPACE_REMOTEVIEWS_INTENT_HANDLER = "com.android.systemui.shared.smartspace_remoteviews_intent_handler";
    public static final String FLAG_SMARTSPACE_SPORTS_CARD_BACKGROUND = "com.android.systemui.shared.smartspace_sports_card_background";
    public static final String FLAG_SMARTSPACE_UI_UPDATE = "com.android.systemui.shared.smartspace_ui_update";
    public static final String FLAG_SMARTSPACE_UI_UPDATE_RESOURCES = "com.android.systemui.shared.smartspace_ui_update_resources";
    public static final String FLAG_STATUS_BAR_CONNECTED_DISPLAYS = "com.android.systemui.shared.status_bar_connected_displays";
    public static final String FLAG_THREE_BUTTON_CORNER_SWIPE = "com.android.systemui.shared.three_button_corner_swipe";
    public static final String FLAG_USE_PREFERRED_IMAGE_EDITOR = "com.android.systemui.shared.use_preferred_image_editor";

    public Flags() {
    }

    public static boolean ambientAod() {
        return true;
    }

    public static boolean bouncerAreaExclusion() {
        return true;
    }

    public static boolean clockReactiveSmartspaceLayout() {
        return false;
    }

    public static boolean clockReactiveVariants() {
        return false;
    }

    public static boolean cursorHotCorner() {
        return false;
    }

    public static boolean enableHomeDelay() {
        return false;
    }

    public static boolean enableLppSqueezeEffect() {
        return false;
    }

    public static boolean exampleSharedFlag() {
        return false;
    }

    public static boolean extendedWallpaperEffects() {
        return false;
    }

    public static boolean lockscreenCustomClocks() {
        return false;
    }

    public static boolean newCustomizationPickerUi() {
        return false;
    }

    public static boolean newTouchpadGesturesTutorial() {
        return true;
    }

    public static boolean returnAnimationFrameworkLibrary() {
        return true;
    }

    public static boolean returnAnimationFrameworkLongLived() {
        return true;
    }

    public static boolean screenshotContextUrl() {
        return false;
    }

    public static boolean shadeAllowBackGesture() {
        return false;
    }

    public static boolean sidefpsControllerRefactor() {
        return true;
    }

    public static boolean smartspaceRemoteviewsIntentHandler() {
        return true;
    }

    public static boolean smartspaceSportsCardBackground() {
        return false;
    }

    public static boolean smartspaceUiUpdate() {
        return false;
    }

    public static boolean smartspaceUiUpdateResources() {
        return false;
    }

    public static boolean statusBarConnectedDisplays() {
        return false;
    }

    public static boolean threeButtonCornerSwipe() {
        return false;
    }

    public static boolean usePreferredImageEditor() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
