package com.android.systemui.shared;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_AMBIENT_AOD, Flags.FLAG_BOUNCER_AREA_EXCLUSION, Flags.FLAG_CLOCK_REACTIVE_SMARTSPACE_LAYOUT, Flags.FLAG_CLOCK_REACTIVE_VARIANTS, Flags.FLAG_CURSOR_HOT_CORNER, Flags.FLAG_ENABLE_HOME_DELAY, Flags.FLAG_ENABLE_LPP_SQUEEZE_EFFECT, Flags.FLAG_EXAMPLE_SHARED_FLAG, Flags.FLAG_EXTENDED_WALLPAPER_EFFECTS, Flags.FLAG_LOCKSCREEN_CUSTOM_CLOCKS, Flags.FLAG_NEW_CUSTOMIZATION_PICKER_UI, Flags.FLAG_NEW_TOUCHPAD_GESTURES_TUTORIAL, Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LIBRARY, Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LONG_LIVED, Flags.FLAG_SCREENSHOT_CONTEXT_URL, Flags.FLAG_SHADE_ALLOW_BACK_GESTURE, Flags.FLAG_SIDEFPS_CONTROLLER_REFACTOR, Flags.FLAG_SMARTSPACE_REMOTEVIEWS_INTENT_HANDLER, Flags.FLAG_SMARTSPACE_SPORTS_CARD_BACKGROUND, Flags.FLAG_SMARTSPACE_UI_UPDATE, Flags.FLAG_SMARTSPACE_UI_UPDATE_RESOURCES, Flags.FLAG_STATUS_BAR_CONNECTED_DISPLAYS, Flags.FLAG_THREE_BUTTON_CORNER_SWIPE, Flags.FLAG_USE_PREFERRED_IMAGE_EDITOR, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean ambientAod() {
        return getValue(Flags.FLAG_AMBIENT_AOD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean bouncerAreaExclusion() {
        return getValue(Flags.FLAG_BOUNCER_AREA_EXCLUSION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean clockReactiveSmartspaceLayout() {
        return getValue(Flags.FLAG_CLOCK_REACTIVE_SMARTSPACE_LAYOUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean clockReactiveVariants() {
        return getValue(Flags.FLAG_CLOCK_REACTIVE_VARIANTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean cursorHotCorner() {
        return getValue(Flags.FLAG_CURSOR_HOT_CORNER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean enableHomeDelay() {
        return getValue(Flags.FLAG_ENABLE_HOME_DELAY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean enableLppSqueezeEffect() {
        return getValue(Flags.FLAG_ENABLE_LPP_SQUEEZE_EFFECT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean exampleSharedFlag() {
        return getValue(Flags.FLAG_EXAMPLE_SHARED_FLAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean extendedWallpaperEffects() {
        return getValue(Flags.FLAG_EXTENDED_WALLPAPER_EFFECTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean lockscreenCustomClocks() {
        return getValue(Flags.FLAG_LOCKSCREEN_CUSTOM_CLOCKS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean newCustomizationPickerUi() {
        return getValue(Flags.FLAG_NEW_CUSTOMIZATION_PICKER_UI, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean newTouchpadGesturesTutorial() {
        return getValue(Flags.FLAG_NEW_TOUCHPAD_GESTURES_TUTORIAL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean returnAnimationFrameworkLibrary() {
        return getValue(Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LIBRARY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean returnAnimationFrameworkLongLived() {
        return getValue(Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LONG_LIVED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean screenshotContextUrl() {
        return getValue(Flags.FLAG_SCREENSHOT_CONTEXT_URL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean shadeAllowBackGesture() {
        return getValue(Flags.FLAG_SHADE_ALLOW_BACK_GESTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean sidefpsControllerRefactor() {
        return getValue(Flags.FLAG_SIDEFPS_CONTROLLER_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean smartspaceRemoteviewsIntentHandler() {
        return getValue(Flags.FLAG_SMARTSPACE_REMOTEVIEWS_INTENT_HANDLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean smartspaceSportsCardBackground() {
        return getValue(Flags.FLAG_SMARTSPACE_SPORTS_CARD_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean smartspaceUiUpdate() {
        return getValue(Flags.FLAG_SMARTSPACE_UI_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean smartspaceUiUpdateResources() {
        return getValue(Flags.FLAG_SMARTSPACE_UI_UPDATE_RESOURCES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean statusBarConnectedDisplays() {
        return getValue(Flags.FLAG_STATUS_BAR_CONNECTED_DISPLAYS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean threeButtonCornerSwipe() {
        return getValue(Flags.FLAG_THREE_BUTTON_CORNER_SWIPE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.shared.FeatureFlags
    public boolean usePreferredImageEditor() {
        return getValue(Flags.FLAG_USE_PREFERRED_IMAGE_EDITOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_AMBIENT_AOD, Flags.FLAG_BOUNCER_AREA_EXCLUSION, Flags.FLAG_CLOCK_REACTIVE_SMARTSPACE_LAYOUT, Flags.FLAG_CLOCK_REACTIVE_VARIANTS, Flags.FLAG_CURSOR_HOT_CORNER, Flags.FLAG_ENABLE_HOME_DELAY, Flags.FLAG_ENABLE_LPP_SQUEEZE_EFFECT, Flags.FLAG_EXAMPLE_SHARED_FLAG, Flags.FLAG_EXTENDED_WALLPAPER_EFFECTS, Flags.FLAG_LOCKSCREEN_CUSTOM_CLOCKS, Flags.FLAG_NEW_CUSTOMIZATION_PICKER_UI, Flags.FLAG_NEW_TOUCHPAD_GESTURES_TUTORIAL, Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LIBRARY, Flags.FLAG_RETURN_ANIMATION_FRAMEWORK_LONG_LIVED, Flags.FLAG_SCREENSHOT_CONTEXT_URL, Flags.FLAG_SHADE_ALLOW_BACK_GESTURE, Flags.FLAG_SIDEFPS_CONTROLLER_REFACTOR, Flags.FLAG_SMARTSPACE_REMOTEVIEWS_INTENT_HANDLER, Flags.FLAG_SMARTSPACE_SPORTS_CARD_BACKGROUND, Flags.FLAG_SMARTSPACE_UI_UPDATE, Flags.FLAG_SMARTSPACE_UI_UPDATE_RESOURCES, Flags.FLAG_STATUS_BAR_CONNECTED_DISPLAYS, Flags.FLAG_THREE_BUTTON_CORNER_SWIPE, Flags.FLAG_USE_PREFERRED_IMAGE_EDITOR});
    }
}
