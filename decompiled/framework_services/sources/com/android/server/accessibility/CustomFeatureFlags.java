package com.android.server.accessibility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADD_WINDOW_TOKEN_WITHOUT_LOCK, Flags.FLAG_ALLOW_SECURE_SCREENSHOTS, Flags.FLAG_ALWAYS_ALLOW_OBSERVING_TOUCH_EVENTS, Flags.FLAG_CLEANUP_A11Y_OVERLAYS, Flags.FLAG_CLEAR_DEFAULT_FROM_A11Y_SHORTCUT_TARGET_SERVICE_RESTORE, Flags.FLAG_CLEAR_SHORTCUTS_WHEN_ACTIVITY_UPDATES_TO_SERVICE, Flags.FLAG_DEPRECATE_PACKAGE_LIST_OBSERVER, Flags.FLAG_DISABLE_CONTINUOUS_SHORTCUT_ON_FORCE_STOP, Flags.FLAG_DO_NOT_RESET_KEY_EVENT_STATE, Flags.FLAG_ENABLE_A11Y_CHECKER_LOGGING, Flags.FLAG_ENABLE_AUTOCLICK_INDICATOR, Flags.FLAG_ENABLE_COLOR_CORRECTION_SATURATION, Flags.FLAG_ENABLE_HARDWARE_SHORTCUT_DISABLES_WARNING, Flags.FLAG_ENABLE_LOW_VISION_GENERIC_FEEDBACK, Flags.FLAG_ENABLE_LOW_VISION_HATS, Flags.FLAG_ENABLE_MAGNIFICATION_FOLLOWS_MOUSE_WITH_POINTER_MOTION_FILTER, Flags.FLAG_ENABLE_MAGNIFICATION_JOYSTICK, Flags.FLAG_ENABLE_MAGNIFICATION_KEYBOARD_CONTROL, Flags.FLAG_ENABLE_MAGNIFICATION_MULTIPLE_FINGER_MULTIPLE_TAP_GESTURE, Flags.FLAG_ENABLE_MAGNIFICATION_ONE_FINGER_PANNING_GESTURE, Flags.FLAG_EVENT_DISPATCHER_RAW_EVENT, Flags.FLAG_FIX_DRAG_POINTER_WHEN_ENDING_DRAG, Flags.FLAG_FOCUS_CLICK_POINT_WINDOW_BOUNDS_FROM_A11Y_WINDOW_INFO, Flags.FLAG_FULLSCREEN_FLING_GESTURE, Flags.FLAG_HANDLE_MULTI_DEVICE_INPUT, Flags.FLAG_HEARING_INPUT_CHANGE_WHEN_COMM_DEVICE, Flags.FLAG_MAGNIFICATION_ENLARGE_POINTER_BUGFIX, Flags.FLAG_MANAGER_AVOID_RECEIVER_TIMEOUT, Flags.FLAG_MANAGER_LIFECYCLE_USER_CHANGE, Flags.FLAG_MANAGER_PACKAGE_MONITOR_LOGIC_FIX, Flags.FLAG_MOTION_EVENT_INJECTOR_CANCEL_FIX, Flags.FLAG_PACKAGE_MONITOR_DEDICATED_THREAD, Flags.FLAG_PINCH_ZOOM_ZERO_MIN_SPAN, Flags.FLAG_POINTER_UP_MOTION_EVENT_IN_TOUCH_EXPLORATION, Flags.FLAG_PROXY_USE_APPS_ON_VIRTUAL_DEVICE_LISTENER, Flags.FLAG_REMOVE_ON_WINDOW_INFOS_CHANGED_HANDLER, Flags.FLAG_RESET_HOVER_EVENT_TIMER_ON_ACTION_UP, Flags.FLAG_RESET_INPUT_DISPATCHER_BEFORE_FIRST_TOUCH_EXPLORATION, Flags.FLAG_RESETTABLE_DYNAMIC_PROPERTIES, Flags.FLAG_SCAN_PACKAGES_WITHOUT_LOCK, Flags.FLAG_SEND_A11Y_EVENTS_BASED_ON_STATE, Flags.FLAG_SEND_HOVER_EVENTS_BASED_ON_EVENT_STREAM, Flags.FLAG_SKIP_PACKAGE_CHANGE_BEFORE_USER_SWITCH, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean addWindowTokenWithoutLock() {
        return getValue(Flags.FLAG_ADD_WINDOW_TOKEN_WITHOUT_LOCK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean allowSecureScreenshots() {
        return getValue(Flags.FLAG_ALLOW_SECURE_SCREENSHOTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean alwaysAllowObservingTouchEvents() {
        return getValue(Flags.FLAG_ALWAYS_ALLOW_OBSERVING_TOUCH_EVENTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean cleanupA11yOverlays() {
        return getValue(Flags.FLAG_CLEANUP_A11Y_OVERLAYS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean clearDefaultFromA11yShortcutTargetServiceRestore() {
        return getValue(Flags.FLAG_CLEAR_DEFAULT_FROM_A11Y_SHORTCUT_TARGET_SERVICE_RESTORE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean clearShortcutsWhenActivityUpdatesToService() {
        return getValue(Flags.FLAG_CLEAR_SHORTCUTS_WHEN_ACTIVITY_UPDATES_TO_SERVICE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean deprecatePackageListObserver() {
        return getValue(Flags.FLAG_DEPRECATE_PACKAGE_LIST_OBSERVER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean disableContinuousShortcutOnForceStop() {
        return getValue(Flags.FLAG_DISABLE_CONTINUOUS_SHORTCUT_ON_FORCE_STOP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean doNotResetKeyEventState() {
        return getValue(Flags.FLAG_DO_NOT_RESET_KEY_EVENT_STATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableA11yCheckerLogging() {
        return getValue(Flags.FLAG_ENABLE_A11Y_CHECKER_LOGGING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableAutoclickIndicator() {
        return getValue(Flags.FLAG_ENABLE_AUTOCLICK_INDICATOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableColorCorrectionSaturation() {
        return getValue(Flags.FLAG_ENABLE_COLOR_CORRECTION_SATURATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableHardwareShortcutDisablesWarning() {
        return getValue(Flags.FLAG_ENABLE_HARDWARE_SHORTCUT_DISABLES_WARNING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableLowVisionGenericFeedback() {
        return getValue(Flags.FLAG_ENABLE_LOW_VISION_GENERIC_FEEDBACK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableLowVisionHats() {
        return getValue(Flags.FLAG_ENABLE_LOW_VISION_HATS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableMagnificationFollowsMouseWithPointerMotionFilter() {
        return getValue(Flags.FLAG_ENABLE_MAGNIFICATION_FOLLOWS_MOUSE_WITH_POINTER_MOTION_FILTER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableMagnificationJoystick() {
        return getValue(Flags.FLAG_ENABLE_MAGNIFICATION_JOYSTICK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableMagnificationKeyboardControl() {
        return getValue(Flags.FLAG_ENABLE_MAGNIFICATION_KEYBOARD_CONTROL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableMagnificationMultipleFingerMultipleTapGesture() {
        return getValue(Flags.FLAG_ENABLE_MAGNIFICATION_MULTIPLE_FINGER_MULTIPLE_TAP_GESTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean enableMagnificationOneFingerPanningGesture() {
        return getValue(Flags.FLAG_ENABLE_MAGNIFICATION_ONE_FINGER_PANNING_GESTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean eventDispatcherRawEvent() {
        return getValue(Flags.FLAG_EVENT_DISPATCHER_RAW_EVENT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean fixDragPointerWhenEndingDrag() {
        return getValue(Flags.FLAG_FIX_DRAG_POINTER_WHEN_ENDING_DRAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean focusClickPointWindowBoundsFromA11yWindowInfo() {
        return getValue(Flags.FLAG_FOCUS_CLICK_POINT_WINDOW_BOUNDS_FROM_A11Y_WINDOW_INFO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean fullscreenFlingGesture() {
        return getValue(Flags.FLAG_FULLSCREEN_FLING_GESTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean handleMultiDeviceInput() {
        return getValue(Flags.FLAG_HANDLE_MULTI_DEVICE_INPUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean hearingInputChangeWhenCommDevice() {
        return getValue(Flags.FLAG_HEARING_INPUT_CHANGE_WHEN_COMM_DEVICE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean magnificationEnlargePointerBugfix() {
        return getValue(Flags.FLAG_MAGNIFICATION_ENLARGE_POINTER_BUGFIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean managerAvoidReceiverTimeout() {
        return getValue(Flags.FLAG_MANAGER_AVOID_RECEIVER_TIMEOUT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean managerLifecycleUserChange() {
        return getValue(Flags.FLAG_MANAGER_LIFECYCLE_USER_CHANGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean managerPackageMonitorLogicFix() {
        return getValue(Flags.FLAG_MANAGER_PACKAGE_MONITOR_LOGIC_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean motionEventInjectorCancelFix() {
        return getValue(Flags.FLAG_MOTION_EVENT_INJECTOR_CANCEL_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean packageMonitorDedicatedThread() {
        return getValue(Flags.FLAG_PACKAGE_MONITOR_DEDICATED_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean pinchZoomZeroMinSpan() {
        return getValue(Flags.FLAG_PINCH_ZOOM_ZERO_MIN_SPAN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean pointerUpMotionEventInTouchExploration() {
        return getValue(Flags.FLAG_POINTER_UP_MOTION_EVENT_IN_TOUCH_EXPLORATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean proxyUseAppsOnVirtualDeviceListener() {
        return getValue(Flags.FLAG_PROXY_USE_APPS_ON_VIRTUAL_DEVICE_LISTENER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean removeOnWindowInfosChangedHandler() {
        return getValue(Flags.FLAG_REMOVE_ON_WINDOW_INFOS_CHANGED_HANDLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean resetHoverEventTimerOnActionUp() {
        return getValue(Flags.FLAG_RESET_HOVER_EVENT_TIMER_ON_ACTION_UP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean resetInputDispatcherBeforeFirstTouchExploration() {
        return getValue(Flags.FLAG_RESET_INPUT_DISPATCHER_BEFORE_FIRST_TOUCH_EXPLORATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean resettableDynamicProperties() {
        return getValue(Flags.FLAG_RESETTABLE_DYNAMIC_PROPERTIES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean scanPackagesWithoutLock() {
        return getValue(Flags.FLAG_SCAN_PACKAGES_WITHOUT_LOCK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean sendA11yEventsBasedOnState() {
        return getValue(Flags.FLAG_SEND_A11Y_EVENTS_BASED_ON_STATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean sendHoverEventsBasedOnEventStream() {
        return getValue(Flags.FLAG_SEND_HOVER_EVENTS_BASED_ON_EVENT_STREAM, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.server.accessibility.FeatureFlags
    public boolean skipPackageChangeBeforeUserSwitch() {
        return getValue(Flags.FLAG_SKIP_PACKAGE_CHANGE_BEFORE_USER_SWITCH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_ADD_WINDOW_TOKEN_WITHOUT_LOCK, Flags.FLAG_ALLOW_SECURE_SCREENSHOTS, Flags.FLAG_ALWAYS_ALLOW_OBSERVING_TOUCH_EVENTS, Flags.FLAG_CLEANUP_A11Y_OVERLAYS, Flags.FLAG_CLEAR_DEFAULT_FROM_A11Y_SHORTCUT_TARGET_SERVICE_RESTORE, Flags.FLAG_CLEAR_SHORTCUTS_WHEN_ACTIVITY_UPDATES_TO_SERVICE, Flags.FLAG_DEPRECATE_PACKAGE_LIST_OBSERVER, Flags.FLAG_DISABLE_CONTINUOUS_SHORTCUT_ON_FORCE_STOP, Flags.FLAG_DO_NOT_RESET_KEY_EVENT_STATE, Flags.FLAG_ENABLE_A11Y_CHECKER_LOGGING, Flags.FLAG_ENABLE_AUTOCLICK_INDICATOR, Flags.FLAG_ENABLE_COLOR_CORRECTION_SATURATION, Flags.FLAG_ENABLE_HARDWARE_SHORTCUT_DISABLES_WARNING, Flags.FLAG_ENABLE_LOW_VISION_GENERIC_FEEDBACK, Flags.FLAG_ENABLE_LOW_VISION_HATS, Flags.FLAG_ENABLE_MAGNIFICATION_FOLLOWS_MOUSE_WITH_POINTER_MOTION_FILTER, Flags.FLAG_ENABLE_MAGNIFICATION_JOYSTICK, Flags.FLAG_ENABLE_MAGNIFICATION_KEYBOARD_CONTROL, Flags.FLAG_ENABLE_MAGNIFICATION_MULTIPLE_FINGER_MULTIPLE_TAP_GESTURE, Flags.FLAG_ENABLE_MAGNIFICATION_ONE_FINGER_PANNING_GESTURE, Flags.FLAG_EVENT_DISPATCHER_RAW_EVENT, Flags.FLAG_FIX_DRAG_POINTER_WHEN_ENDING_DRAG, Flags.FLAG_FOCUS_CLICK_POINT_WINDOW_BOUNDS_FROM_A11Y_WINDOW_INFO, Flags.FLAG_FULLSCREEN_FLING_GESTURE, Flags.FLAG_HANDLE_MULTI_DEVICE_INPUT, Flags.FLAG_HEARING_INPUT_CHANGE_WHEN_COMM_DEVICE, Flags.FLAG_MAGNIFICATION_ENLARGE_POINTER_BUGFIX, Flags.FLAG_MANAGER_AVOID_RECEIVER_TIMEOUT, Flags.FLAG_MANAGER_LIFECYCLE_USER_CHANGE, Flags.FLAG_MANAGER_PACKAGE_MONITOR_LOGIC_FIX, Flags.FLAG_MOTION_EVENT_INJECTOR_CANCEL_FIX, Flags.FLAG_PACKAGE_MONITOR_DEDICATED_THREAD, Flags.FLAG_PINCH_ZOOM_ZERO_MIN_SPAN, Flags.FLAG_POINTER_UP_MOTION_EVENT_IN_TOUCH_EXPLORATION, Flags.FLAG_PROXY_USE_APPS_ON_VIRTUAL_DEVICE_LISTENER, Flags.FLAG_REMOVE_ON_WINDOW_INFOS_CHANGED_HANDLER, Flags.FLAG_RESET_HOVER_EVENT_TIMER_ON_ACTION_UP, Flags.FLAG_RESET_INPUT_DISPATCHER_BEFORE_FIRST_TOUCH_EXPLORATION, Flags.FLAG_RESETTABLE_DYNAMIC_PROPERTIES, Flags.FLAG_SCAN_PACKAGES_WITHOUT_LOCK, Flags.FLAG_SEND_A11Y_EVENTS_BASED_ON_STATE, Flags.FLAG_SEND_HOVER_EVENTS_BASED_ON_EVENT_STREAM, Flags.FLAG_SKIP_PACKAGE_CHANGE_BEFORE_USER_SWITCH});
    }
}
