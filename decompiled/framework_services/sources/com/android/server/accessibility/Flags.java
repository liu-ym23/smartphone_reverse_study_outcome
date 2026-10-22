package com.android.server.accessibility;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ADD_WINDOW_TOKEN_WITHOUT_LOCK = "com.android.server.accessibility.add_window_token_without_lock";
    public static final String FLAG_ALLOW_SECURE_SCREENSHOTS = "com.android.server.accessibility.allow_secure_screenshots";
    public static final String FLAG_ALWAYS_ALLOW_OBSERVING_TOUCH_EVENTS = "com.android.server.accessibility.always_allow_observing_touch_events";
    public static final String FLAG_CLEANUP_A11Y_OVERLAYS = "com.android.server.accessibility.cleanup_a11y_overlays";
    public static final String FLAG_CLEAR_DEFAULT_FROM_A11Y_SHORTCUT_TARGET_SERVICE_RESTORE = "com.android.server.accessibility.clear_default_from_a11y_shortcut_target_service_restore";
    public static final String FLAG_CLEAR_SHORTCUTS_WHEN_ACTIVITY_UPDATES_TO_SERVICE = "com.android.server.accessibility.clear_shortcuts_when_activity_updates_to_service";
    public static final String FLAG_DEPRECATE_PACKAGE_LIST_OBSERVER = "com.android.server.accessibility.deprecate_package_list_observer";
    public static final String FLAG_DISABLE_CONTINUOUS_SHORTCUT_ON_FORCE_STOP = "com.android.server.accessibility.disable_continuous_shortcut_on_force_stop";
    public static final String FLAG_DO_NOT_RESET_KEY_EVENT_STATE = "com.android.server.accessibility.do_not_reset_key_event_state";
    public static final String FLAG_ENABLE_A11Y_CHECKER_LOGGING = "com.android.server.accessibility.enable_a11y_checker_logging";
    public static final String FLAG_ENABLE_AUTOCLICK_INDICATOR = "com.android.server.accessibility.enable_autoclick_indicator";
    public static final String FLAG_ENABLE_COLOR_CORRECTION_SATURATION = "com.android.server.accessibility.enable_color_correction_saturation";
    public static final String FLAG_ENABLE_HARDWARE_SHORTCUT_DISABLES_WARNING = "com.android.server.accessibility.enable_hardware_shortcut_disables_warning";
    public static final String FLAG_ENABLE_LOW_VISION_GENERIC_FEEDBACK = "com.android.server.accessibility.enable_low_vision_generic_feedback";
    public static final String FLAG_ENABLE_LOW_VISION_HATS = "com.android.server.accessibility.enable_low_vision_hats";
    public static final String FLAG_ENABLE_MAGNIFICATION_FOLLOWS_MOUSE_WITH_POINTER_MOTION_FILTER = "com.android.server.accessibility.enable_magnification_follows_mouse_with_pointer_motion_filter";
    public static final String FLAG_ENABLE_MAGNIFICATION_JOYSTICK = "com.android.server.accessibility.enable_magnification_joystick";
    public static final String FLAG_ENABLE_MAGNIFICATION_KEYBOARD_CONTROL = "com.android.server.accessibility.enable_magnification_keyboard_control";
    public static final String FLAG_ENABLE_MAGNIFICATION_MULTIPLE_FINGER_MULTIPLE_TAP_GESTURE = "com.android.server.accessibility.enable_magnification_multiple_finger_multiple_tap_gesture";
    public static final String FLAG_ENABLE_MAGNIFICATION_ONE_FINGER_PANNING_GESTURE = "com.android.server.accessibility.enable_magnification_one_finger_panning_gesture";
    public static final String FLAG_EVENT_DISPATCHER_RAW_EVENT = "com.android.server.accessibility.event_dispatcher_raw_event";
    public static final String FLAG_FIX_DRAG_POINTER_WHEN_ENDING_DRAG = "com.android.server.accessibility.fix_drag_pointer_when_ending_drag";
    public static final String FLAG_FOCUS_CLICK_POINT_WINDOW_BOUNDS_FROM_A11Y_WINDOW_INFO = "com.android.server.accessibility.focus_click_point_window_bounds_from_a11y_window_info";
    public static final String FLAG_FULLSCREEN_FLING_GESTURE = "com.android.server.accessibility.fullscreen_fling_gesture";
    public static final String FLAG_HANDLE_MULTI_DEVICE_INPUT = "com.android.server.accessibility.handle_multi_device_input";
    public static final String FLAG_HEARING_INPUT_CHANGE_WHEN_COMM_DEVICE = "com.android.server.accessibility.hearing_input_change_when_comm_device";
    public static final String FLAG_MAGNIFICATION_ENLARGE_POINTER_BUGFIX = "com.android.server.accessibility.magnification_enlarge_pointer_bugfix";
    public static final String FLAG_MANAGER_AVOID_RECEIVER_TIMEOUT = "com.android.server.accessibility.manager_avoid_receiver_timeout";
    public static final String FLAG_MANAGER_LIFECYCLE_USER_CHANGE = "com.android.server.accessibility.manager_lifecycle_user_change";
    public static final String FLAG_MANAGER_PACKAGE_MONITOR_LOGIC_FIX = "com.android.server.accessibility.manager_package_monitor_logic_fix";
    public static final String FLAG_MOTION_EVENT_INJECTOR_CANCEL_FIX = "com.android.server.accessibility.motion_event_injector_cancel_fix";
    public static final String FLAG_PACKAGE_MONITOR_DEDICATED_THREAD = "com.android.server.accessibility.package_monitor_dedicated_thread";
    public static final String FLAG_PINCH_ZOOM_ZERO_MIN_SPAN = "com.android.server.accessibility.pinch_zoom_zero_min_span";
    public static final String FLAG_POINTER_UP_MOTION_EVENT_IN_TOUCH_EXPLORATION = "com.android.server.accessibility.pointer_up_motion_event_in_touch_exploration";
    public static final String FLAG_PROXY_USE_APPS_ON_VIRTUAL_DEVICE_LISTENER = "com.android.server.accessibility.proxy_use_apps_on_virtual_device_listener";
    public static final String FLAG_REMOVE_ON_WINDOW_INFOS_CHANGED_HANDLER = "com.android.server.accessibility.remove_on_window_infos_changed_handler";
    public static final String FLAG_RESETTABLE_DYNAMIC_PROPERTIES = "com.android.server.accessibility.resettable_dynamic_properties";
    public static final String FLAG_RESET_HOVER_EVENT_TIMER_ON_ACTION_UP = "com.android.server.accessibility.reset_hover_event_timer_on_action_up";
    public static final String FLAG_RESET_INPUT_DISPATCHER_BEFORE_FIRST_TOUCH_EXPLORATION = "com.android.server.accessibility.reset_input_dispatcher_before_first_touch_exploration";
    public static final String FLAG_SCAN_PACKAGES_WITHOUT_LOCK = "com.android.server.accessibility.scan_packages_without_lock";
    public static final String FLAG_SEND_A11Y_EVENTS_BASED_ON_STATE = "com.android.server.accessibility.send_a11y_events_based_on_state";
    public static final String FLAG_SEND_HOVER_EVENTS_BASED_ON_EVENT_STREAM = "com.android.server.accessibility.send_hover_events_based_on_event_stream";
    public static final String FLAG_SKIP_PACKAGE_CHANGE_BEFORE_USER_SWITCH = "com.android.server.accessibility.skip_package_change_before_user_switch";

    public Flags() {
    }

    public static boolean addWindowTokenWithoutLock() {
        return false;
    }

    public static boolean allowSecureScreenshots() {
        return true;
    }

    public static boolean alwaysAllowObservingTouchEvents() {
        return true;
    }

    public static boolean cleanupA11yOverlays() {
        return false;
    }

    public static boolean clearDefaultFromA11yShortcutTargetServiceRestore() {
        return true;
    }

    public static boolean clearShortcutsWhenActivityUpdatesToService() {
        return true;
    }

    public static boolean deprecatePackageListObserver() {
        return false;
    }

    public static boolean disableContinuousShortcutOnForceStop() {
        return false;
    }

    public static boolean doNotResetKeyEventState() {
        return true;
    }

    public static boolean enableA11yCheckerLogging() {
        return false;
    }

    public static boolean enableAutoclickIndicator() {
        return false;
    }

    public static boolean enableColorCorrectionSaturation() {
        return true;
    }

    public static boolean enableHardwareShortcutDisablesWarning() {
        return false;
    }

    public static boolean enableLowVisionGenericFeedback() {
        return false;
    }

    public static boolean enableLowVisionHats() {
        return false;
    }

    public static boolean enableMagnificationFollowsMouseWithPointerMotionFilter() {
        return false;
    }

    public static boolean enableMagnificationJoystick() {
        return false;
    }

    public static boolean enableMagnificationKeyboardControl() {
        return true;
    }

    public static boolean enableMagnificationMultipleFingerMultipleTapGesture() {
        return false;
    }

    public static boolean enableMagnificationOneFingerPanningGesture() {
        return false;
    }

    public static boolean eventDispatcherRawEvent() {
        return true;
    }

    public static boolean fixDragPointerWhenEndingDrag() {
        return false;
    }

    public static boolean focusClickPointWindowBoundsFromA11yWindowInfo() {
        return false;
    }

    public static boolean fullscreenFlingGesture() {
        return false;
    }

    public static boolean handleMultiDeviceInput() {
        return false;
    }

    public static boolean hearingInputChangeWhenCommDevice() {
        return false;
    }

    public static boolean magnificationEnlargePointerBugfix() {
        return true;
    }

    public static boolean managerAvoidReceiverTimeout() {
        return true;
    }

    public static boolean managerLifecycleUserChange() {
        return false;
    }

    public static boolean managerPackageMonitorLogicFix() {
        return true;
    }

    public static boolean motionEventInjectorCancelFix() {
        return true;
    }

    public static boolean packageMonitorDedicatedThread() {
        return true;
    }

    public static boolean pinchZoomZeroMinSpan() {
        return true;
    }

    public static boolean pointerUpMotionEventInTouchExploration() {
        return false;
    }

    public static boolean proxyUseAppsOnVirtualDeviceListener() {
        return true;
    }

    public static boolean removeOnWindowInfosChangedHandler() {
        return true;
    }

    public static boolean resetHoverEventTimerOnActionUp() {
        return false;
    }

    public static boolean resetInputDispatcherBeforeFirstTouchExploration() {
        return false;
    }

    public static boolean resettableDynamicProperties() {
        return false;
    }

    public static boolean scanPackagesWithoutLock() {
        return true;
    }

    public static boolean sendA11yEventsBasedOnState() {
        return false;
    }

    public static boolean sendHoverEventsBasedOnEventStream() {
        return true;
    }

    public static boolean skipPackageChangeBeforeUserSwitch() {
        return true;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
