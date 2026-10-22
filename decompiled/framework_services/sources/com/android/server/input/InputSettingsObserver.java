package com.android.server.input;

import android.R;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.input.InputSettings;
import android.net.Uri;
import android.os.Handler;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewConfiguration;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class InputSettingsObserver extends ContentObserver {
    private static final String DEEP_PRESS_ENABLED = "deep_press_enabled";
    static final String TAG = "InputManager";
    private final Context mContext;
    private final Handler mHandler;
    private final NativeInputManagerService mNative;
    private final Map<Uri, Consumer<String>> mObservers;
    private final InputManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$2uu-5VgzBAVH96KjrIYFV8FVeVQ, reason: not valid java name */
    public static /* synthetic */ void m4536$r8$lambda$2uu5VgzBAVH96KjrIYFV8FVeVQ(InputSettingsObserver r0, String r1) {
        r0.lambda$new$24(r1);
    }

    public static /* synthetic */ void $r8$lambda$6oq7bOpVftSU3OE_HHVEtJm_PHw(InputSettingsObserver r0, String r1) {
        r0.lambda$new$31(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$8-nmfADGlbXR2y7cYvJjCtqiCDU, reason: not valid java name */
    public static /* synthetic */ void m4537$r8$lambda$8nmfADGlbXR2y7cYvJjCtqiCDU(InputSettingsObserver r0, String r1) {
        r0.lambda$new$18(r1);
    }

    public static /* synthetic */ void $r8$lambda$B6UbsHTKEzcrp2SmYSj1UeL9fa0(InputSettingsObserver r0, String r1) {
        r0.lambda$new$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$BOzEmCS9Jya1bSR1eCAdAbZibBc(InputSettingsObserver r0, String r1) {
        r0.lambda$new$20(r1);
    }

    public static /* synthetic */ void $r8$lambda$DNZP2CcPqkve0D6JriX5TFF7Ftw(InputSettingsObserver r0, String r1) {
        r0.lambda$new$21(r1);
    }

    public static /* synthetic */ void $r8$lambda$E77TZbEY0Eiqo5odbeeaxq9YVVY(InputSettingsObserver r0, String r1) {
        r0.lambda$new$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$EZo0BN6vEeXLyFlM39mQLCNLQRU(InputSettingsObserver r0, String r1) {
        r0.lambda$new$12(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Gcygn9rRUf7IcgoJH-MXOFnUvCk, reason: not valid java name */
    public static /* synthetic */ void m4538$r8$lambda$Gcygn9rRUf7IcgoJHMXOFnUvCk(InputSettingsObserver r0, String r1) {
        r0.lambda$new$28(r1);
    }

    public static /* synthetic */ void $r8$lambda$H1paEVQ6iS1w225jbFS3KlGpUH0(InputSettingsObserver r0, String r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$IAIqOWxGj0NqFaNlwpNZXIwerhY(InputSettingsObserver r0, String r1) {
        r0.lambda$new$8(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$IQqGKcfcR0EZ-mDGhMY_gImu--o, reason: not valid java name */
    public static /* synthetic */ void m4539$r8$lambda$IQqGKcfcR0EZmDGhMY_gImuo(InputSettingsObserver r0, String r1) {
        r0.lambda$new$27(r1);
    }

    public static /* synthetic */ void $r8$lambda$MotvkOT12GYIlX8NWJLa1hYA0GA(InputSettingsObserver r0, String r1) {
        r0.lambda$new$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$QdnpwXhg1-UovvW3vm6K6ReunTA, reason: not valid java name */
    public static /* synthetic */ void m4540$r8$lambda$QdnpwXhg1UovvW3vm6K6ReunTA(InputSettingsObserver r0, String r1) {
        r0.lambda$new$17(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Rr0lgi-WpfNxFXW9-C-Qm7EPPAQ, reason: not valid java name */
    public static /* synthetic */ void m4541$r8$lambda$Rr0lgiWpfNxFXW9CQm7EPPAQ(InputSettingsObserver r0, String r1) {
        r0.lambda$new$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$RwhUKAUGanyEKdX5oDzP5wAXdec(InputSettingsObserver r0, String r1) {
        r0.lambda$new$22(r1);
    }

    public static /* synthetic */ void $r8$lambda$Wj_9VZoLtcn3kLPMwJr7RhQ_MSk(InputSettingsObserver r0, String r1) {
        r0.lambda$new$30(r1);
    }

    public static /* synthetic */ void $r8$lambda$X0GRs6ozJ2WUFZSxbSHhppfiguM(InputSettingsObserver r0, String r1) {
        r0.lambda$new$29(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZZJw7liozvnfpwJy3dHpbXK6TBs(InputSettingsObserver r0, String r1) {
        r0.lambda$new$13(r1);
    }

    public static /* synthetic */ void $r8$lambda$_Li3faBXkSiTTgluUvBmCdIKhxE(InputSettingsObserver r0, String r1) {
        r0.lambda$new$32(r1);
    }

    public static /* synthetic */ void $r8$lambda$_fP8LM44ztL2nXy491rpD7KkA8M(InputSettingsObserver r0, String r1) {
        r0.lambda$new$16(r1);
    }

    public static /* synthetic */ void $r8$lambda$bALfrLUB8JbIzE6kEvOL0PKgEtk(InputSettingsObserver r0, String r1) {
        r0.lambda$new$23(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$bQ6Pakt0-8gsVCTKD29WSS6maqM, reason: not valid java name */
    public static /* synthetic */ void m4542$r8$lambda$bQ6Pakt08gsVCTKD29WSS6maqM(InputSettingsObserver r0, String r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$fenPZ8hwNeHQiC5wNUY7p_Nan68(InputSettingsObserver r0, String r1) {
        r0.lambda$new$10(r1);
    }

    public static /* synthetic */ void $r8$lambda$fuEgvfKd7GY8eVSNTB3BzuuJKHQ(InputSettingsObserver r0, String r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$k6knUOK1nWWHQJdmB93hBPmnk4g(InputSettingsObserver r0, String r1) {
        r0.lambda$new$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$pqYW_K7ai5UbiF55BnWTwJfksFE(InputSettingsObserver r0, String r1) {
        r0.lambda$new$11(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qssZmvgvvHsM9r4tlwPcw-Njg-E, reason: not valid java name */
    public static /* synthetic */ void m4543$r8$lambda$qssZmvgvvHsM9r4tlwPcwNjgE(InputSettingsObserver r0, String r1) {
        r0.lambda$new$25(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$suNB2ZBWUoweyBdMN4-BMsvtA-Y, reason: not valid java name */
    public static /* synthetic */ void m4544$r8$lambda$suNB2ZBWUoweyBdMN4BMsvtAY(InputSettingsObserver r0, String r1) {
        r0.lambda$new$19(r1);
    }

    public static /* synthetic */ void $r8$lambda$tCrW_EpGwbX9GnJRAW5H1bM6Rsc(InputSettingsObserver r0, String r1) {
        r0.lambda$new$14(r1);
    }

    public static /* synthetic */ void $r8$lambda$uo0KjrciiUrgeyPJZXw8X_RZfIU(InputSettingsObserver r0, String r1) {
        r0.lambda$new$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uxAhDD-5nvRXXpXuIseeY9peJ1s, reason: not valid java name */
    public static /* synthetic */ void m4545$r8$lambda$uxAhDD5nvRXXpXuIseeY9peJ1s(InputSettingsObserver r0, String r1) {
        r0.lambda$new$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$xze_c500SSQNguXyBIwnZQOpiaY(InputSettingsObserver r0, String r1) {
        r0.lambda$new$26(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m4546$$Nest$fgetmObservers(InputSettingsObserver r0) {
        return r0.mObservers;
    }

    InputSettingsObserver(Context context, Handler handler, InputManagerService service, NativeInputManagerService nativeIms) {
        super(handler);
        this.mContext = context;
        this.mHandler = handler;
        this.mService = service;
        this.mNative = nativeIms;
        this.mObservers = Map.ofEntries(new Map.Entry[]{Map.entry(Settings.System.getUriFor("pointer_speed"), new InputSettingsObserver$$ExternalSyntheticLambda0(this)), Map.entry(Settings.System.getUriFor("mouse_reverse_vertical_scrolling"), new InputSettingsObserver$$ExternalSyntheticLambda11(this)), Map.entry(Settings.System.getUriFor("mouse_swap_primary_button"), new InputSettingsObserver$$ExternalSyntheticLambda22(this)), Map.entry(Settings.System.getUriFor("mouse_scrolling_acceleration"), new InputSettingsObserver$$ExternalSyntheticLambda26(this)), Map.entry(Settings.System.getUriFor("mouse_pointer_acceleration_enabled"), new InputSettingsObserver$$ExternalSyntheticLambda27(this)), Map.entry(Settings.System.getUriFor("mouse_scrolling_speed"), new InputSettingsObserver$$ExternalSyntheticLambda28(this)), Map.entry(Settings.System.getUriFor("touchpad_pointer_speed"), new InputSettingsObserver$$ExternalSyntheticLambda29(this)), Map.entry(Settings.System.getUriFor("touchpad_natural_scrolling"), new InputSettingsObserver$$ExternalSyntheticLambda30(this)), Map.entry(Settings.System.getUriFor("touchpad_tap_to_click"), new InputSettingsObserver$$ExternalSyntheticLambda31(this)), Map.entry(Settings.System.getUriFor("touchpad_tap_dragging"), new InputSettingsObserver$$ExternalSyntheticLambda32(this)), Map.entry(Settings.System.getUriFor("touchpad_visualizer"), new InputSettingsObserver$$ExternalSyntheticLambda1(this)), Map.entry(Settings.System.getUriFor("touchpad_right_click_zone"), new InputSettingsObserver$$ExternalSyntheticLambda2(this)), Map.entry(Settings.System.getUriFor("touchpad_system_gestures"), new InputSettingsObserver$$ExternalSyntheticLambda3(this)), Map.entry(Settings.System.getUriFor("touchpad_acceleration_enabled"), new InputSettingsObserver$$ExternalSyntheticLambda4(this)), Map.entry(Settings.System.getUriFor("show_touches"), new InputSettingsObserver$$ExternalSyntheticLambda5(this)), Map.entry(Settings.System.getUriFor("pointer_location"), new InputSettingsObserver$$ExternalSyntheticLambda6(this)), Map.entry(Settings.Secure.getUriFor("accessibility_large_pointer_icon"), new InputSettingsObserver$$ExternalSyntheticLambda7(this)), Map.entry(Settings.Secure.getUriFor("long_press_timeout"), new InputSettingsObserver$$ExternalSyntheticLambda8(this)), Map.entry(Settings.Global.getUriFor("maximum_obscuring_opacity_for_touch"), new InputSettingsObserver$$ExternalSyntheticLambda9(this)), Map.entry(Settings.System.getUriFor("show_key_presses"), new InputSettingsObserver$$ExternalSyntheticLambda10(this)), Map.entry(Settings.Secure.getUriFor("key_repeat_timeout"), new InputSettingsObserver$$ExternalSyntheticLambda12(this)), Map.entry(Settings.Secure.getUriFor("key_repeat_delay"), new InputSettingsObserver$$ExternalSyntheticLambda13(this)), Map.entry(Settings.Secure.getUriFor("key_repeat_enabled"), new InputSettingsObserver$$ExternalSyntheticLambda14(this)), Map.entry(Settings.System.getUriFor("show_rotary_input"), new InputSettingsObserver$$ExternalSyntheticLambda15(this)), Map.entry(Settings.Secure.getUriFor("accessibility_bounce_keys"), new InputSettingsObserver$$ExternalSyntheticLambda16(this)), Map.entry(Settings.Secure.getUriFor("accessibility_slow_keys"), new InputSettingsObserver$$ExternalSyntheticLambda17(this)), Map.entry(Settings.Secure.getUriFor("accessibility_sticky_keys"), new InputSettingsObserver$$ExternalSyntheticLambda18(this)), Map.entry(Settings.Secure.getUriFor("stylus_pointer_icon_enabled"), new InputSettingsObserver$$ExternalSyntheticLambda19(this)), Map.entry(Settings.System.getUriFor("pointer_fill_style"), new InputSettingsObserver$$ExternalSyntheticLambda20(this)), Map.entry(Settings.System.getUriFor("pointer_stroke_style"), new InputSettingsObserver$$ExternalSyntheticLambda21(this)), Map.entry(Settings.System.getUriFor("pointer_scale"), new InputSettingsObserver$$ExternalSyntheticLambda23(this)), Map.entry(Settings.System.getUriFor("touchpad_three_finger_tap_customization"), new InputSettingsObserver$$ExternalSyntheticLambda24(this)), Map.entry(Settings.System.getUriFor("toggle_power_ai_key"), new InputSettingsObserver$$ExternalSyntheticLambda25(this))});
    }

    private /* synthetic */ void lambda$new$0(String reason) {
        updateMousePointerSpeed();
    }

    private /* synthetic */ void lambda$new$1(String reason) {
        updateMouseReverseVerticalScrolling();
    }

    private /* synthetic */ void lambda$new$2(String reason) {
        updateMouseSwapPrimaryButton();
    }

    private /* synthetic */ void lambda$new$3(String reason) {
        updateMouseScrollingAcceleration();
    }

    private /* synthetic */ void lambda$new$4(String reason) {
        updateMouseAccelerationEnabled();
    }

    private /* synthetic */ void lambda$new$5(String reason) {
        updateMouseScrollingSpeed();
    }

    private /* synthetic */ void lambda$new$6(String reason) {
        updateTouchpadPointerSpeed();
    }

    private /* synthetic */ void lambda$new$7(String reason) {
        updateTouchpadNaturalScrollingEnabled();
    }

    private /* synthetic */ void lambda$new$8(String reason) {
        updateTouchpadTapToClickEnabled();
    }

    private /* synthetic */ void lambda$new$9(String reason) {
        updateTouchpadTapDraggingEnabled();
    }

    private /* synthetic */ void lambda$new$10(String reason) {
        updateTouchpadHardwareStateNotificationsEnabled();
    }

    private /* synthetic */ void lambda$new$11(String reason) {
        updateTouchpadRightClickZoneEnabled();
    }

    private /* synthetic */ void lambda$new$12(String reason) {
        updateTouchpadSystemGesturesEnabled();
    }

    private /* synthetic */ void lambda$new$13(String reason) {
        updateTouchpadAccelerationEnabled();
    }

    private /* synthetic */ void lambda$new$14(String reason) {
        updateShowTouches();
    }

    private /* synthetic */ void lambda$new$15(String reason) {
        updatePointerLocation();
    }

    private /* synthetic */ void lambda$new$16(String reason) {
        updateAccessibilityLargePointer();
    }

    private /* synthetic */ void lambda$new$17(String reason) {
        updateLongPressTimeout(reason);
    }

    private /* synthetic */ void lambda$new$18(String reason) {
        updateMaximumObscuringOpacityForTouch();
    }

    private /* synthetic */ void lambda$new$19(String reason) {
        updateShowKeyPresses();
    }

    private /* synthetic */ void lambda$new$20(String reason) {
        updateKeyRepeatInfo();
    }

    private /* synthetic */ void lambda$new$21(String reason) {
        updateKeyRepeatInfo();
    }

    private /* synthetic */ void lambda$new$22(String reason) {
        updateKeyRepeatInfo();
    }

    private /* synthetic */ void lambda$new$23(String reason) {
        updateShowRotaryInput();
    }

    private /* synthetic */ void lambda$new$24(String reason) {
        updateAccessibilityBounceKeys();
    }

    private /* synthetic */ void lambda$new$25(String reason) {
        updateAccessibilitySlowKeys();
    }

    private /* synthetic */ void lambda$new$26(String reason) {
        updateAccessibilityStickyKeys();
    }

    private /* synthetic */ void lambda$new$27(String reason) {
        updateStylusPointerIconEnabled();
    }

    private /* synthetic */ void lambda$new$28(String reason) {
        updatePointerFillStyleFromSettings();
    }

    private /* synthetic */ void lambda$new$29(String reason) {
        updatePointerStrokeStyleFromSettings();
    }

    private /* synthetic */ void lambda$new$30(String reason) {
        updatePointerScaleFromSettings();
    }

    private /* synthetic */ void lambda$new$31(String reason) {
        updateTouchpadThreeFingerTapShortcutEnabled();
    }

    private /* synthetic */ void lambda$new$32(String reason) {
        togglePowerAndAiKey();
    }

    public void registerAndUpdate() {
        Iterator<Uri> r0 = this.mObservers.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Uri uri = r0.next();
        this.mContext.getContentResolver().registerContentObserver(uri, true, this, -1);
        goto L4
    L6:
        this.mContext.registerReceiver(new AnonymousClass1(this), new IntentFilter("android.intent.action.USER_SWITCHED"), null, this.mHandler);
        Iterator<Consumer<String>> r1 = this.mObservers.values().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Consumer<String> observer = r1.next();
        observer.accept("just booted");
        goto L8
    L10:
        configureUserActivityPokeInterval();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        this.mObservers.get(uri).accept("setting changed");
    }

    private boolean getBoolean(String r3, boolean r4) {
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), r3, r4 ? 1 : 0, -2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int constrainPointerSpeedValue(int speed) {
        return Math.min(Math.max(speed, -7), 7);
    }

    private void updateMousePointerSpeed() {
        int speed = Settings.System.getIntForUser(this.mContext.getContentResolver(), "pointer_speed", 0, -2);
        this.mNative.setPointerSpeed(constrainPointerSpeedValue(speed));
    }

    private void updateMouseReverseVerticalScrolling() {
        this.mNative.setMouseReverseVerticalScrollingEnabled(InputSettings.isMouseReverseVerticalScrollingEnabled(this.mContext));
    }

    private void updateMouseSwapPrimaryButton() {
        this.mNative.setMouseSwapPrimaryButtonEnabled(InputSettings.isMouseSwapPrimaryButtonEnabled(this.mContext));
    }

    private void updateMouseScrollingAcceleration() {
        this.mNative.setMouseScrollingAccelerationEnabled(InputSettings.isMouseScrollingAccelerationEnabled(this.mContext));
    }

    private void updateMouseAccelerationEnabled() {
        this.mNative.setMouseAccelerationEnabled(InputSettings.isMousePointerAccelerationEnabled(this.mContext));
    }

    private void updateMouseScrollingSpeed() {
        this.mNative.setMouseScrollingSpeed(constrainPointerSpeedValue(InputSettings.getMouseScrollingSpeed(this.mContext)));
    }

    private void updateTouchpadPointerSpeed() {
        this.mNative.setTouchpadPointerSpeed(constrainPointerSpeedValue(InputSettings.getTouchpadPointerSpeed(this.mContext)));
    }

    private void updateTouchpadNaturalScrollingEnabled() {
        this.mNative.setTouchpadNaturalScrollingEnabled(InputSettings.useTouchpadNaturalScrolling(this.mContext));
    }

    private void updateTouchpadTapToClickEnabled() {
        this.mNative.setTouchpadTapToClickEnabled(InputSettings.useTouchpadTapToClick(this.mContext));
    }

    private void updateTouchpadTapDraggingEnabled() {
        this.mNative.setTouchpadTapDraggingEnabled(InputSettings.useTouchpadTapDragging(this.mContext));
    }

    private void updateTouchpadHardwareStateNotificationsEnabled() {
        this.mService.updateTouchpadVisualizerEnabled(InputSettings.useTouchpadVisualizer(this.mContext));
    }

    private void updateTouchpadRightClickZoneEnabled() {
        this.mNative.setTouchpadRightClickZoneEnabled(InputSettings.useTouchpadRightClickZone(this.mContext));
    }

    private void updateTouchpadThreeFingerTapShortcutEnabled() {
        this.mNative.setTouchpadThreeFingerTapShortcutEnabled(InputSettings.useTouchpadThreeFingerTapShortcut(this.mContext));
    }

    private void updateTouchpadSystemGesturesEnabled() {
        this.mNative.setTouchpadSystemGesturesEnabled(InputSettings.useTouchpadSystemGestures(this.mContext));
    }

    private void updateTouchpadAccelerationEnabled() {
        this.mNative.setTouchpadAccelerationEnabled(InputSettings.isTouchpadAccelerationEnabled(this.mContext));
    }

    private void updateShowTouches() {
        this.mNative.setShowTouches(getBoolean("show_touches", false));
    }

    private void togglePowerAndAiKey() {
    }

    private void updatePointerLocation() {
        this.mService.updatePointerLocationEnabled(getBoolean("pointer_location", false));
    }

    private void updateShowKeyPresses() {
        this.mService.updateShowKeyPresses(getBoolean("show_key_presses", false));
    }

    private void updateShowRotaryInput() {
        this.mService.updateShowRotaryInput(getBoolean("show_rotary_input", false));
    }

    private void updateAccessibilityLargePointer() {
        boolean r2 = false;
        int accessibilityConfig = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "accessibility_large_pointer_icon", 0, -2);
        InputManagerService r1 = this.mService;
        if (accessibilityConfig != 1) goto L5;
        r2 = true;
    L5:
        r1.setUseLargePointerIcons(r2);
    }

    private void updateLongPressTimeout(String reason) {
        int longPressTimeoutMs = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "long_press_timeout", 400, -2);
        boolean enabled = true;
        boolean featureEnabledFlag = DeviceConfig.getBoolean("input_native_boot", DEEP_PRESS_ENABLED, true);
        if (featureEnabledFlag == false) goto L6;
        if (longPressTimeoutMs > 400) goto L6;
    L7:
        StringBuilder r2 = new StringBuilder();
        if (enabled == false) goto L10;
        String r3 = "Enabling";
    L11:
        r2.append(r3);
        r2.append(" motion classifier because ");
        r2.append(reason);
        r2.append(": feature ");
        if (featureEnabledFlag == false) goto L14;
        String r4 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L15:
        r2.append(r4);
        r2.append(", long press timeout = ");
        r2.append(longPressTimeoutMs);
        r2.append(" ms");
        Log.i(TAG, r2.toString());
        this.mNative.setMotionClassifierEnabled(enabled);
        return;
    L14:
        r4 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L15
    L10:
        r3 = "Disabling";
    L6:
        enabled = false;
        goto L7
    }

    private void updateKeyRepeatInfo() {
        boolean keyRepeatEnabled = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "key_repeat_enabled", 1, -2) != 0) goto L6;
        keyRepeatEnabled = false;
    L6:
        int timeoutMs = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "key_repeat_timeout", ViewConfiguration.getKeyRepeatTimeout(), -2);
        int delayMs = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "key_repeat_delay", ViewConfiguration.getKeyRepeatDelay(), -2);
        this.mNative.setKeyRepeatConfiguration(timeoutMs, delayMs, keyRepeatEnabled);
    }

    private void updateMaximumObscuringOpacityForTouch() {
        float opacity = InputSettings.getMaximumObscuringOpacityForTouch(this.mContext);
        if (opacity >= 0.0f) goto L5;
    L9:
        Log.e(TAG, "Invalid maximum obscuring opacity " + opacity + ", it should be >= 0 and <= 1, rejecting update.");
        return;
    L5:
        if (opacity > 1.0f) goto L9;
        this.mNative.setMaximumObscuringOpacityForTouch(opacity);
    }

    private void updateAccessibilityBounceKeys() {
        this.mService.setAccessibilityBounceKeysThreshold(InputSettings.getAccessibilityBounceKeysThreshold(this.mContext));
    }

    private void updateAccessibilitySlowKeys() {
        this.mService.setAccessibilitySlowKeysThreshold(InputSettings.getAccessibilitySlowKeysThreshold(this.mContext));
    }

    private void updateAccessibilityStickyKeys() {
        this.mService.setAccessibilityStickyKeysEnabled(InputSettings.isAccessibilityStickyKeysEnabled(this.mContext));
    }

    private void configureUserActivityPokeInterval() {
        int intervalMillis = this.mContext.getResources().getInteger(R.integer.config_networkMeteredMultipathPreference);
        Log.i(TAG, "Setting user activity interval (ms) of " + intervalMillis);
        this.mNative.setMinTimeBetweenUserActivityPokes((long) intervalMillis);
    }

    private void updateStylusPointerIconEnabled() {
        this.mNative.setStylusPointerIconEnabled(InputSettings.isStylusPointerIconEnabled(this.mContext, true));
    }

    private void updatePointerFillStyleFromSettings() {
        int pointerFillStyle = Settings.System.getIntForUser(this.mContext.getContentResolver(), "pointer_fill_style", 0, -2);
        this.mService.setPointerFillStyle(pointerFillStyle);
    }

    private void updatePointerStrokeStyleFromSettings() {
        int pointerStrokeStyle = Settings.System.getIntForUser(this.mContext.getContentResolver(), "pointer_stroke_style", 0, -2);
        this.mService.setPointerStrokeStyle(pointerStrokeStyle);
    }

    private void updatePointerScaleFromSettings() {
        float pointerScale = Settings.System.getFloatForUser(this.mContext.getContentResolver(), "pointer_scale", 1.0f, -2);
        this.mService.setPointerScale(pointerScale);
    }
}
