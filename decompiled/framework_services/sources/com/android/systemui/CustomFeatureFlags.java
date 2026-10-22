package com.android.systemui;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ACTIVITY_TRANSITION_USE_LARGEST_WINDOW, Flags.FLAG_ADD_BLACK_BACKGROUND_FOR_WINDOW_MAGNIFIER, Flags.FLAG_ALWAYS_COMPOSE_QS_UI_FRAGMENT, Flags.FLAG_AMBIENT_TOUCH_MONITOR_LISTEN_TO_DISPLAY_CHANGES, Flags.FLAG_APP_CLIPS_BACKLINKS, Flags.FLAG_APP_SHORTCUT_REMOVAL_FIX, Flags.FLAG_AVALANCHE_REPLACE_HUN_WHEN_CRITICAL, Flags.FLAG_BIND_KEYGUARD_MEDIA_VISIBILITY, Flags.FLAG_BOUNCER_UI_REVAMP, Flags.FLAG_BOUNCER_UI_REVAMP_2, Flags.FLAG_BP_COLORS, Flags.FLAG_BRIGHTNESS_SLIDER_FOCUS_STATE, Flags.FLAG_CHECK_LOCKSCREEN_GONE_TRANSITION, Flags.FLAG_CLASSIC_FLAGS_MULTI_USER, Flags.FLAG_CLIPBOARD_IMAGE_TIMEOUT, Flags.FLAG_CLIPBOARD_NONINTERACTIVE_ON_LOCKSCREEN, Flags.FLAG_CLIPBOARD_OVERLAY_MULTIUSER, Flags.FLAG_CLIPBOARD_SHARED_TRANSITIONS, Flags.FLAG_CLIPBOARD_USE_DESCRIPTION_MIMETYPE, Flags.FLAG_CLOCK_FIDGET_ANIMATION, Flags.FLAG_COMMUNAL_BOUNCER_DO_NOT_MODIFY_PLUGIN_OPEN, Flags.FLAG_COMMUNAL_EDIT_WIDGETS_ACTIVITY_FINISH_FIX, Flags.FLAG_COMMUNAL_HUB, Flags.FLAG_COMMUNAL_HUB_USE_THREAD_POOL_FOR_WIDGETS, Flags.FLAG_COMMUNAL_RESPONSIVE_GRID, Flags.FLAG_COMMUNAL_SCENE_KTF_REFACTOR, Flags.FLAG_COMMUNAL_STANDALONE_SUPPORT, Flags.FLAG_COMMUNAL_TIMER_FLICKER_FIX, Flags.FLAG_COMMUNAL_WIDGET_RESIZING, Flags.FLAG_COMMUNAL_WIDGET_TRAMPOLINE_FIX, Flags.FLAG_COMPOSE_BOUNCER, Flags.FLAG_CONFINE_NOTIFICATION_TOUCH_TO_VIEW_WIDTH, Flags.FLAG_CONT_AUTH_PLUGIN, Flags.FLAG_CONTEXTUAL_TIPS_ASSISTANT_DISMISS_FIX, Flags.FLAG_COROUTINE_TRACING, Flags.FLAG_CREATE_WINDOWLESS_WINDOW_MAGNIFIER, Flags.FLAG_DEBUG_LIVE_UPDATES_PROMOTE_ALL, Flags.FLAG_DECOUPLE_VIEW_CONTROLLER_IN_ANIMLIB, Flags.FLAG_DELAY_SHOW_MAGNIFICATION_BUTTON, Flags.FLAG_DESKTOP_EFFECTS_QS_TILE, Flags.FLAG_DEVICE_ENTRY_UDFPS_REFACTOR, Flags.FLAG_DISABLE_BLURRED_SHADE_VISIBLE, Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_FREQUENCY_CHECK, Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_IOS_SWITCHER_CHECK, Flags.FLAG_DISABLE_SHADE_TRACKPAD_TWO_FINGER_SWIPE, Flags.FLAG_DOUBLE_TAP_TO_SLEEP, Flags.FLAG_DREAM_INPUT_SESSION_PILFER_ONCE, Flags.FLAG_DREAM_OVERLAY_BOUNCER_SWIPE_DIRECTION_FILTERING, Flags.FLAG_DREAM_OVERLAY_UPDATED_FONT, Flags.FLAG_EDGE_BACK_GESTURE_HANDLER_THREAD, Flags.FLAG_EDGEBACK_GESTURE_HANDLER_GET_RUNNING_TASKS_BACKGROUND, Flags.FLAG_ENABLE_BACKGROUND_KEYGUARD_ONDRAWN_CALLBACK, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_MUTE_VOLUME, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_POWER_OFF, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_TAKE_SCREENSHOT, Flags.FLAG_ENABLE_CONTEXTUAL_TIPS, Flags.FLAG_ENABLE_EFFICIENT_DISPLAY_REPOSITORY, Flags.FLAG_ENABLE_LAYOUT_TRACING, Flags.FLAG_ENABLE_UNDERLAY, Flags.FLAG_ENABLE_VIEW_CAPTURE_TRACING, Flags.FLAG_ENFORCE_BRIGHTNESS_BASE_USER_RESTRICTION, Flags.FLAG_EXAMPLE_FLAG, Flags.FLAG_EXPAND_COLLAPSE_PRIVACY_DIALOG, Flags.FLAG_EXPAND_HEADS_UP_ON_INLINE_REPLY, Flags.FLAG_EXPANDED_PRIVACY_INDICATORS_ON_LARGE_SCREEN, Flags.FLAG_EXTENDED_APPS_SHORTCUT_CATEGORY, Flags.FLAG_FACE_MESSAGE_DEFER_UPDATE, Flags.FLAG_FACE_SCANNING_ANIMATION_NPE_FIX, Flags.FLAG_FASTER_UNLOCK_TRANSITION, Flags.FLAG_FETCH_BOOKMARKS_XML_KEYBOARD_SHORTCUTS, Flags.FLAG_FIX_IMAGE_WALLPAPER_CRASH_SURFACE_ALREADY_RELEASED, Flags.FLAG_FIX_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, Flags.FLAG_FLOATING_MENU_ANIMATED_TUCK, Flags.FLAG_FLOATING_MENU_DISPLAY_CUTOUT_SUPPORT, Flags.FLAG_FLOATING_MENU_DRAG_TO_EDIT, Flags.FLAG_FLOATING_MENU_DRAG_TO_HIDE, Flags.FLAG_FLOATING_MENU_HEARING_DEVICE_STATUS_ICON, Flags.FLAG_FLOATING_MENU_IME_DISPLACEMENT_ANIMATION, Flags.FLAG_FLOATING_MENU_NARROW_TARGET_CONTENT_OBSERVER, Flags.FLAG_FLOATING_MENU_NOTIFY_TARGETS_CHANGED_ON_STRICT_DIFF, Flags.FLAG_FLOATING_MENU_OVERLAPS_NAV_BARS_FLAG, Flags.FLAG_FLOATING_MENU_RADII_ANIMATION, Flags.FLAG_GET_CONNECTED_DEVICE_NAME_UNSYNCHRONIZED, Flags.FLAG_GLANCEABLE_HUB_ALLOW_KEYGUARD_WHEN_DREAMING, Flags.FLAG_GLANCEABLE_HUB_BLURRED_BACKGROUND, Flags.FLAG_GLANCEABLE_HUB_DIRECT_EDIT_MODE, Flags.FLAG_GLANCEABLE_HUB_V2, Flags.FLAG_GLANCEABLE_HUB_V2_RESOURCES, Flags.FLAG_HAPTICS_FOR_COMPOSE_SLIDERS, Flags.FLAG_HARDWARE_COLOR_STYLES, Flags.FLAG_HEARING_AIDS_QS_TILE_DIALOG, Flags.FLAG_HEARING_DEVICES_DIALOG_RELATED_TOOLS, Flags.FLAG_HIDE_RINGER_BUTTON_IN_SINGLE_VOLUME_MODE, Flags.FLAG_HOME_CONTROLS_DREAM_HSUM, Flags.FLAG_HUB_EDIT_MODE_TOUCH_ADJUSTMENTS, Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE, Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE_FIX, Flags.FLAG_ICON_REFRESH_2025, Flags.FLAG_IGNORE_TOUCHES_NEXT_TO_NOTIFICATION_SHELF, Flags.FLAG_INDICATION_TEXT_A11Y_FIX, Flags.FLAG_KEYBOARD_DOCKING_INDICATOR, Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_REWRITE, Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_SHORTCUT_CUSTOMIZER, Flags.FLAG_KEYBOARD_TOUCHPAD_CONTEXTUAL_EDUCATION, Flags.FLAG_KEYGUARD_TRANSITION_FORCE_FINISH_ON_SCREEN_OFF, Flags.FLAG_KEYGUARD_WM_REORDER_ATMS_CALLS, Flags.FLAG_KEYGUARD_WM_STATE_REFACTOR, Flags.FLAG_LOCKSCREEN_FONT, Flags.FLAG_LOW_LIGHT_CLOCK_DREAM, Flags.FLAG_MAGNETIC_NOTIFICATION_SWIPES, Flags.FLAG_MEDIA_CONTROLS_A11Y_COLORS, Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3, Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3_PLACEMENT, Flags.FLAG_MEDIA_CONTROLS_DEVICE_MANAGER_BACKGROUND_EXECUTION, Flags.FLAG_MEDIA_CONTROLS_DRAWABLES_REUSE_BUGFIX, Flags.FLAG_MEDIA_CONTROLS_LOCKSCREEN_SHADE_BUG_FIX, Flags.FLAG_MEDIA_CONTROLS_UI_UPDATE, Flags.FLAG_MEDIA_CONTROLS_UMO_INFLATION_IN_BACKGROUND, Flags.FLAG_MEDIA_CONTROLS_USER_INITIATED_DELETEINTENT, Flags.FLAG_MEDIA_LOAD_METADATA_VIA_MEDIA_DATA_LOADER, Flags.FLAG_MEDIA_LOCKSCREEN_LAUNCH_ANIMATION, Flags.FLAG_MEDIA_PROJECTION_DIALOG_BEHIND_LOCKSCREEN, Flags.FLAG_MEDIA_PROJECTION_GREY_ERROR_TEXT, Flags.FLAG_MEDIA_PROJECTION_REQUEST_ATTRIBUTION_FIX, Flags.FLAG_MODES_UI_DIALOG_PAGING, Flags.FLAG_MOVE_TRANSITION_ANIMATION_LAYER, Flags.FLAG_MSDL_FEEDBACK, Flags.FLAG_MULTIUSER_WIFI_PICKER_TRACKER_SUPPORT, Flags.FLAG_NEW_AOD_TRANSITION, Flags.FLAG_NEW_VOLUME_PANEL, Flags.FLAG_NON_TOUCHSCREEN_DEVICES_BYPASS_FALSING, Flags.FLAG_NOTES_ROLE_QS_TILE, Flags.FLAG_NOTIFICATION_ADD_X_ON_HOVER_TO_DISMISS, Flags.FLAG_NOTIFICATION_AMBIENT_SUPPRESSION_AFTER_INFLATION, Flags.FLAG_NOTIFICATION_ANIMATED_ACTIONS_TREATMENT, Flags.FLAG_NOTIFICATION_APPEAR_NONLINEAR, Flags.FLAG_NOTIFICATION_ASYNC_GROUP_HEADER_INFLATION, Flags.FLAG_NOTIFICATION_ASYNC_HYBRID_VIEW_INFLATION, Flags.FLAG_NOTIFICATION_AVALANCHE_SUPPRESSION, Flags.FLAG_NOTIFICATION_AVALANCHE_THROTTLE_HUN, Flags.FLAG_NOTIFICATION_BACKGROUND_TINT_OPTIMIZATION, Flags.FLAG_NOTIFICATION_BUNDLE_UI, Flags.FLAG_NOTIFICATION_COLOR_UPDATE_LOGGER, Flags.FLAG_NOTIFICATION_CONTENT_ALPHA_OPTIMIZATION, Flags.FLAG_NOTIFICATION_FOOTER_BACKGROUND_TINT_OPTIMIZATION, Flags.FLAG_NOTIFICATION_OVER_EXPANSION_CLIPPING_FIX, Flags.FLAG_NOTIFICATION_REENTRANT_DISMISS, Flags.FLAG_NOTIFICATION_ROW_ACCESSIBILITY_EXPANDED, Flags.FLAG_NOTIFICATION_ROW_CONTENT_BINDER_REFACTOR, Flags.FLAG_NOTIFICATION_ROW_TRANSPARENCY, Flags.FLAG_NOTIFICATION_ROW_USER_CONTEXT, Flags.FLAG_NOTIFICATION_SHADE_BLUR, Flags.FLAG_NOTIFICATION_SHADE_UI_THREAD, Flags.FLAG_NOTIFICATION_SKIP_SILENT_UPDATES, Flags.FLAG_NOTIFICATION_TRANSPARENT_HEADER_FIX, Flags.FLAG_NOTIFICATION_VIEW_FLIPPER_PAUSING_V2, Flags.FLAG_NOTIFICATIONS_BACKGROUND_ICONS, Flags.FLAG_NOTIFICATIONS_FOOTER_VISIBILITY_FIX, Flags.FLAG_NOTIFICATIONS_HIDE_ON_DISPLAY_SWITCH, Flags.FLAG_NOTIFICATIONS_HUN_SHARED_ANIMATION_VALUES, Flags.FLAG_NOTIFICATIONS_ICON_CONTAINER_REFACTOR, Flags.FLAG_NOTIFICATIONS_LAUNCH_RADIUS, Flags.FLAG_NOTIFICATIONS_LIVE_DATA_STORE_REFACTOR, Flags.FLAG_NOTIFICATIONS_PINNED_HUN_IN_SHADE, Flags.FLAG_NOTIFICATIONS_REDESIGN_FOOTER_VIEW, Flags.FLAG_NOTIFICATIONS_REDESIGN_GUTS, Flags.FLAG_NOTIFY_PASSWORD_TEXT_VIEW_USER_ACTIVITY_IN_BACKGROUND, Flags.FLAG_NOTIFY_POWER_MANAGER_USER_ACTIVITY_BACKGROUND, Flags.FLAG_ONLY_SHOW_MEDIA_STREAM_SLIDER_IN_SINGLE_VOLUME_MODE, Flags.FLAG_OUTPUT_SWITCHER_REDESIGN, Flags.FLAG_OVERRIDE_SUPPRESS_OVERLAY_CONDITION, Flags.FLAG_PERMISSION_HELPER_INLINE_UI_RICH_ONGOING, Flags.FLAG_PERMISSION_HELPER_UI_RICH_ONGOING, Flags.FLAG_PHYSICAL_NOTIFICATION_MOVEMENT, Flags.FLAG_PIN_INPUT_FIELD_STYLED_FOCUS_STATE, Flags.FLAG_PREDICTIVE_BACK_ANIMATE_SHADE, Flags.FLAG_PREDICTIVE_BACK_DELAY_WM_TRANSITION, Flags.FLAG_PRIORITY_PEOPLE_SECTION, Flags.FLAG_PROMOTE_NOTIFICATIONS_AUTOMATICALLY, Flags.FLAG_PSS_APP_SELECTOR_RECENTS_SPLIT_SCREEN, Flags.FLAG_PSS_TASK_SWITCHER, Flags.FLAG_QS_CUSTOM_TILE_CLICK_GUARANTEED_BUG_FIX, Flags.FLAG_QS_NEW_TILES, Flags.FLAG_QS_NEW_TILES_FUTURE, Flags.FLAG_QS_QUICK_REBIND_ACTIVE_TILES, Flags.FLAG_QS_REGISTER_SETTING_OBSERVER_ON_BG_THREAD, Flags.FLAG_QS_TILE_DETAILED_VIEW, Flags.FLAG_QS_TILE_FOCUS_STATE, Flags.FLAG_QS_UI_REFACTOR, Flags.FLAG_QS_UI_REFACTOR_COMPOSE_FRAGMENT, Flags.FLAG_RECORD_ISSUE_QS_TILE, Flags.FLAG_REDESIGN_MAGNIFICATION_WINDOW_SIZE, Flags.FLAG_REFACTOR_GET_CURRENT_USER, Flags.FLAG_REGISTER_BATTERY_CONTROLLER_RECEIVERS_IN_CORESTARTABLE, Flags.FLAG_REGISTER_CONTENT_OBSERVERS_ASYNC, Flags.FLAG_REGISTER_NEW_WALLET_CARD_IN_BACKGROUND, Flags.FLAG_REGISTER_WALLPAPER_NOTIFIER_BACKGROUND, Flags.FLAG_RELOCK_WITH_POWER_BUTTON_IMMEDIATELY, Flags.FLAG_REMOVE_DREAM_OVERLAY_HIDE_ON_TOUCH, Flags.FLAG_REMOVE_UPDATE_LISTENER_IN_QS_ICON_VIEW_IMPL, Flags.FLAG_REST_TO_UNLOCK, Flags.FLAG_RESTART_DREAM_ON_UNOCCLUDE, Flags.FLAG_REVAMPED_BOUNCER_MESSAGES, Flags.FLAG_RUN_FINGERPRINT_DETECT_ON_DISMISSIBLE_KEYGUARD, Flags.FLAG_SAVE_AND_RESTORE_MAGNIFICATION_SETTINGS_BUTTONS, Flags.FLAG_SCENE_CONTAINER, Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING_BUG_FIX, Flags.FLAG_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, Flags.FLAG_SCREENSHOT_MULTIDISPLAY_FOCUS_CHANGE, Flags.FLAG_SCREENSHOT_POLICY_SPLIT_AND_DESKTOP_MODE, Flags.FLAG_SCREENSHOT_SCROLL_CROP_VIEW_CRASH_FIX, Flags.FLAG_SCREENSHOT_UI_CONTROLLER_REFACTOR, Flags.FLAG_SECONDARY_USER_WIDGET_HOST, Flags.FLAG_SETTINGS_EXT_REGISTER_CONTENT_OBSERVER_ON_BG_THREAD, Flags.FLAG_SHADE_EXPANDS_ON_STATUS_BAR_LONG_PRESS, Flags.FLAG_SHADE_HEADER_FONT_UPDATE, Flags.FLAG_SHADE_LAUNCH_ACCESSIBILITY, Flags.FLAG_SHADE_WINDOW_GOES_AROUND, Flags.FLAG_SHADERLIB_LOADING_EFFECT_REFACTOR, Flags.FLAG_SHORTCUT_HELPER_KEY_GLYPH, Flags.FLAG_SHOW_AUDIO_SHARING_SLIDER_IN_VOLUME_PANEL, Flags.FLAG_SHOW_CLIPBOARD_INDICATION, Flags.FLAG_SHOW_LOCKED_BY_YOUR_WATCH_KEYGUARD_INDICATOR, Flags.FLAG_SHOW_TOAST_WHEN_APP_CONTROL_BRIGHTNESS, Flags.FLAG_SIM_PIN_BOUNCER_RESET, Flags.FLAG_SIM_PIN_RACE_CONDITION_ON_RESTART, Flags.FLAG_SIM_PIN_USE_SLOT_ID, Flags.FLAG_SKIP_HIDE_SENSITIVE_NOTIF_ANIMATION, Flags.FLAG_SLICE_BROADCAST_RELAY_IN_BACKGROUND, Flags.FLAG_SLICE_MANAGER_BINDER_CALL_BACKGROUND, Flags.FLAG_SMARTSPACE_LOCKSCREEN_VIEWMODEL, Flags.FLAG_SMARTSPACE_RELOCATE_TO_BOTTOM, Flags.FLAG_SMARTSPACE_REMOTEVIEWS_RENDERING_FIX, Flags.FLAG_SMARTSPACE_SWIPE_EVENT_LOGGING_FIX, Flags.FLAG_SMARTSPACE_VIEWPAGER2, Flags.FLAG_SOUNDDOSE_CUSTOMIZATION, Flags.FLAG_SPATIAL_MODEL_APP_PUSHBACK, Flags.FLAG_STABILIZE_HEADS_UP_GROUP_V2, Flags.FLAG_STATUS_BAR_ALWAYS_CHECK_UNDERLYING_NETWORKS, Flags.FLAG_STATUS_BAR_AUTO_START_SCREEN_RECORD_CHIP, Flags.FLAG_STATUS_BAR_CHIPS_MODERNIZATION, Flags.FLAG_STATUS_BAR_CHIPS_RETURN_ANIMATIONS, Flags.FLAG_STATUS_BAR_FONT_UPDATES, Flags.FLAG_STATUS_BAR_MOBILE_ICON_KAIROS, Flags.FLAG_STATUS_BAR_MONOCHROME_ICONS_FIX, Flags.FLAG_STATUS_BAR_NO_HUN_BEHAVIOR, Flags.FLAG_STATUS_BAR_POPUP_CHIPS, Flags.FLAG_STATUS_BAR_ROOT_MODERNIZATION, Flags.FLAG_STATUS_BAR_SHOW_AUDIO_ONLY_PROJECTION_CHIP, Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR, Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR_ETHERNET, Flags.FLAG_STATUS_BAR_STATIC_INOUT_INDICATORS, Flags.FLAG_STATUS_BAR_STOP_UPDATING_WINDOW_HEIGHT, Flags.FLAG_STATUS_BAR_SWIPE_OVER_CHIP, Flags.FLAG_STATUS_BAR_SWITCH_TO_SPN_FROM_DATA_SPN, Flags.FLAG_STATUS_BAR_UI_THREAD, Flags.FLAG_STATUS_BAR_WINDOW_NO_CUSTOM_TOUCH, Flags.FLAG_STOPPABLE_FGS_SYSTEM_APP, Flags.FLAG_SWITCH_USER_ON_BG, Flags.FLAG_SYSUI_TEAMFOOD, Flags.FLAG_THEME_OVERLAY_CONTROLLER_WAKEFULNESS_DEPRECATION, Flags.FLAG_TRANSITION_RACE_CONDITION, Flags.FLAG_TRANSLUCENT_OCCLUDING_ACTIVITY_FIX, Flags.FLAG_TV_GLOBAL_ACTIONS_FOCUS, Flags.FLAG_UDFPS_VIEW_PERFORMANCE, Flags.FLAG_UNFOLD_ANIMATION_BACKGROUND_PROGRESS, Flags.FLAG_UNFOLD_LATENCY_TRACKING_FIX, Flags.FLAG_UPDATE_CORNER_RADIUS_ON_DISPLAY_CHANGED, Flags.FLAG_UPDATE_USER_SWITCHER_BACKGROUND, Flags.FLAG_UPDATE_WINDOW_MAGNIFIER_BOTTOM_BOUNDARY, Flags.FLAG_USE_AAD_PROX_SENSOR, Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_FOOTER, Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_ROW, Flags.FLAG_USE_TRANSITIONS_FOR_KEYGUARD_OCCLUDED, Flags.FLAG_USE_VOLUME_CONTROLLER, Flags.FLAG_USER_AWARE_SETTINGS_REPOSITORIES, Flags.FLAG_USER_ENCRYPTED_SOURCE, Flags.FLAG_USER_SWITCHER_ADD_SIGN_OUT_OPTION, Flags.FLAG_VISUAL_INTERRUPTIONS_REFACTOR, Flags.FLAG_VOLUME_REDESIGN, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean activityTransitionUseLargestWindow() {
        return getValue(Flags.FLAG_ACTIVITY_TRANSITION_USE_LARGEST_WINDOW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean addBlackBackgroundForWindowMagnifier() {
        return getValue(Flags.FLAG_ADD_BLACK_BACKGROUND_FOR_WINDOW_MAGNIFIER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean alwaysComposeQsUiFragment() {
        return getValue(Flags.FLAG_ALWAYS_COMPOSE_QS_UI_FRAGMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean ambientTouchMonitorListenToDisplayChanges() {
        return getValue(Flags.FLAG_AMBIENT_TOUCH_MONITOR_LISTEN_TO_DISPLAY_CHANGES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean appClipsBacklinks() {
        return getValue(Flags.FLAG_APP_CLIPS_BACKLINKS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean appShortcutRemovalFix() {
        return getValue(Flags.FLAG_APP_SHORTCUT_REMOVAL_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean avalancheReplaceHunWhenCritical() {
        return getValue(Flags.FLAG_AVALANCHE_REPLACE_HUN_WHEN_CRITICAL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bindKeyguardMediaVisibility() {
        return getValue(Flags.FLAG_BIND_KEYGUARD_MEDIA_VISIBILITY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bouncerUiRevamp() {
        return getValue(Flags.FLAG_BOUNCER_UI_REVAMP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bouncerUiRevamp2() {
        return getValue(Flags.FLAG_BOUNCER_UI_REVAMP_2, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean bpColors() {
        return getValue(Flags.FLAG_BP_COLORS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean brightnessSliderFocusState() {
        return getValue(Flags.FLAG_BRIGHTNESS_SLIDER_FOCUS_STATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean checkLockscreenGoneTransition() {
        return getValue(Flags.FLAG_CHECK_LOCKSCREEN_GONE_TRANSITION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean classicFlagsMultiUser() {
        return getValue(Flags.FLAG_CLASSIC_FLAGS_MULTI_USER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardImageTimeout() {
        return getValue(Flags.FLAG_CLIPBOARD_IMAGE_TIMEOUT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardNoninteractiveOnLockscreen() {
        return getValue(Flags.FLAG_CLIPBOARD_NONINTERACTIVE_ON_LOCKSCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardOverlayMultiuser() {
        return getValue(Flags.FLAG_CLIPBOARD_OVERLAY_MULTIUSER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardSharedTransitions() {
        return getValue(Flags.FLAG_CLIPBOARD_SHARED_TRANSITIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clipboardUseDescriptionMimetype() {
        return getValue(Flags.FLAG_CLIPBOARD_USE_DESCRIPTION_MIMETYPE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean clockFidgetAnimation() {
        return getValue(Flags.FLAG_CLOCK_FIDGET_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalBouncerDoNotModifyPluginOpen() {
        return getValue(Flags.FLAG_COMMUNAL_BOUNCER_DO_NOT_MODIFY_PLUGIN_OPEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalEditWidgetsActivityFinishFix() {
        return getValue(Flags.FLAG_COMMUNAL_EDIT_WIDGETS_ACTIVITY_FINISH_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalHub() {
        return getValue(Flags.FLAG_COMMUNAL_HUB, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalHubUseThreadPoolForWidgets() {
        return getValue(Flags.FLAG_COMMUNAL_HUB_USE_THREAD_POOL_FOR_WIDGETS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalResponsiveGrid() {
        return getValue(Flags.FLAG_COMMUNAL_RESPONSIVE_GRID, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalSceneKtfRefactor() {
        return getValue(Flags.FLAG_COMMUNAL_SCENE_KTF_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalStandaloneSupport() {
        return getValue(Flags.FLAG_COMMUNAL_STANDALONE_SUPPORT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalTimerFlickerFix() {
        return getValue(Flags.FLAG_COMMUNAL_TIMER_FLICKER_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalWidgetResizing() {
        return getValue(Flags.FLAG_COMMUNAL_WIDGET_RESIZING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean communalWidgetTrampolineFix() {
        return getValue(Flags.FLAG_COMMUNAL_WIDGET_TRAMPOLINE_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean composeBouncer() {
        return getValue(Flags.FLAG_COMPOSE_BOUNCER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean confineNotificationTouchToViewWidth() {
        return getValue(Flags.FLAG_CONFINE_NOTIFICATION_TOUCH_TO_VIEW_WIDTH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean contAuthPlugin() {
        return getValue(Flags.FLAG_CONT_AUTH_PLUGIN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean contextualTipsAssistantDismissFix() {
        return getValue(Flags.FLAG_CONTEXTUAL_TIPS_ASSISTANT_DISMISS_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean coroutineTracing() {
        return getValue(Flags.FLAG_COROUTINE_TRACING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean createWindowlessWindowMagnifier() {
        return getValue(Flags.FLAG_CREATE_WINDOWLESS_WINDOW_MAGNIFIER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean debugLiveUpdatesPromoteAll() {
        return getValue(Flags.FLAG_DEBUG_LIVE_UPDATES_PROMOTE_ALL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean decoupleViewControllerInAnimlib() {
        return getValue(Flags.FLAG_DECOUPLE_VIEW_CONTROLLER_IN_ANIMLIB, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean delayShowMagnificationButton() {
        return getValue(Flags.FLAG_DELAY_SHOW_MAGNIFICATION_BUTTON, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean desktopEffectsQsTile() {
        return getValue(Flags.FLAG_DESKTOP_EFFECTS_QS_TILE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean deviceEntryUdfpsRefactor() {
        return getValue(Flags.FLAG_DEVICE_ENTRY_UDFPS_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableBlurredShadeVisible() {
        return getValue(Flags.FLAG_DISABLE_BLURRED_SHADE_VISIBLE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableContextualTipsFrequencyCheck() {
        return getValue(Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_FREQUENCY_CHECK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableContextualTipsIosSwitcherCheck() {
        return getValue(Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_IOS_SWITCHER_CHECK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean disableShadeTrackpadTwoFingerSwipe() {
        return getValue(Flags.FLAG_DISABLE_SHADE_TRACKPAD_TWO_FINGER_SWIPE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean doubleTapToSleep() {
        return getValue(Flags.FLAG_DOUBLE_TAP_TO_SLEEP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamInputSessionPilferOnce() {
        return getValue(Flags.FLAG_DREAM_INPUT_SESSION_PILFER_ONCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamOverlayBouncerSwipeDirectionFiltering() {
        return getValue(Flags.FLAG_DREAM_OVERLAY_BOUNCER_SWIPE_DIRECTION_FILTERING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean dreamOverlayUpdatedFont() {
        return getValue(Flags.FLAG_DREAM_OVERLAY_UPDATED_FONT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean edgeBackGestureHandlerThread() {
        return getValue(Flags.FLAG_EDGE_BACK_GESTURE_HANDLER_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean edgebackGestureHandlerGetRunningTasksBackground() {
        return getValue(Flags.FLAG_EDGEBACK_GESTURE_HANDLER_GET_RUNNING_TASKS_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableBackgroundKeyguardOndrawnCallback() {
        return getValue(Flags.FLAG_ENABLE_BACKGROUND_KEYGUARD_ONDRAWN_CALLBACK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForMuteVolume() {
        return getValue(Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_MUTE_VOLUME, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForPowerOff() {
        return getValue(Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_POWER_OFF, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTipForTakeScreenshot() {
        return getValue(Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_TAKE_SCREENSHOT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableContextualTips() {
        return getValue(Flags.FLAG_ENABLE_CONTEXTUAL_TIPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableEfficientDisplayRepository() {
        return getValue(Flags.FLAG_ENABLE_EFFICIENT_DISPLAY_REPOSITORY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableLayoutTracing() {
        return getValue(Flags.FLAG_ENABLE_LAYOUT_TRACING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableUnderlay() {
        return getValue(Flags.FLAG_ENABLE_UNDERLAY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enableViewCaptureTracing() {
        return getValue(Flags.FLAG_ENABLE_VIEW_CAPTURE_TRACING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean enforceBrightnessBaseUserRestriction() {
        return getValue(Flags.FLAG_ENFORCE_BRIGHTNESS_BASE_USER_RESTRICTION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean exampleFlag() {
        return getValue(Flags.FLAG_EXAMPLE_FLAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandCollapsePrivacyDialog() {
        return getValue(Flags.FLAG_EXPAND_COLLAPSE_PRIVACY_DIALOG, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandHeadsUpOnInlineReply() {
        return getValue(Flags.FLAG_EXPAND_HEADS_UP_ON_INLINE_REPLY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean expandedPrivacyIndicatorsOnLargeScreen() {
        return getValue(Flags.FLAG_EXPANDED_PRIVACY_INDICATORS_ON_LARGE_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean extendedAppsShortcutCategory() {
        return getValue(Flags.FLAG_EXTENDED_APPS_SHORTCUT_CATEGORY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean faceMessageDeferUpdate() {
        return getValue(Flags.FLAG_FACE_MESSAGE_DEFER_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean faceScanningAnimationNpeFix() {
        return getValue(Flags.FLAG_FACE_SCANNING_ANIMATION_NPE_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fasterUnlockTransition() {
        return getValue(Flags.FLAG_FASTER_UNLOCK_TRANSITION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fetchBookmarksXmlKeyboardShortcuts() {
        return getValue(Flags.FLAG_FETCH_BOOKMARKS_XML_KEYBOARD_SHORTCUTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fixImageWallpaperCrashSurfaceAlreadyReleased() {
        return getValue(Flags.FLAG_FIX_IMAGE_WALLPAPER_CRASH_SURFACE_ALREADY_RELEASED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean fixScreenshotActionDismissSystemWindows() {
        return getValue(Flags.FLAG_FIX_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuAnimatedTuck() {
        return getValue(Flags.FLAG_FLOATING_MENU_ANIMATED_TUCK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDisplayCutoutSupport() {
        return getValue(Flags.FLAG_FLOATING_MENU_DISPLAY_CUTOUT_SUPPORT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDragToEdit() {
        return getValue(Flags.FLAG_FLOATING_MENU_DRAG_TO_EDIT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuDragToHide() {
        return getValue(Flags.FLAG_FLOATING_MENU_DRAG_TO_HIDE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuHearingDeviceStatusIcon() {
        return getValue(Flags.FLAG_FLOATING_MENU_HEARING_DEVICE_STATUS_ICON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuImeDisplacementAnimation() {
        return getValue(Flags.FLAG_FLOATING_MENU_IME_DISPLACEMENT_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuNarrowTargetContentObserver() {
        return getValue(Flags.FLAG_FLOATING_MENU_NARROW_TARGET_CONTENT_OBSERVER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuNotifyTargetsChangedOnStrictDiff() {
        return getValue(Flags.FLAG_FLOATING_MENU_NOTIFY_TARGETS_CHANGED_ON_STRICT_DIFF, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuOverlapsNavBarsFlag() {
        return getValue(Flags.FLAG_FLOATING_MENU_OVERLAPS_NAV_BARS_FLAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean floatingMenuRadiiAnimation() {
        return getValue(Flags.FLAG_FLOATING_MENU_RADII_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean getConnectedDeviceNameUnsynchronized() {
        return getValue(Flags.FLAG_GET_CONNECTED_DEVICE_NAME_UNSYNCHRONIZED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubAllowKeyguardWhenDreaming() {
        return getValue(Flags.FLAG_GLANCEABLE_HUB_ALLOW_KEYGUARD_WHEN_DREAMING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubBlurredBackground() {
        return getValue(Flags.FLAG_GLANCEABLE_HUB_BLURRED_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubDirectEditMode() {
        return getValue(Flags.FLAG_GLANCEABLE_HUB_DIRECT_EDIT_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubV2() {
        return getValue(Flags.FLAG_GLANCEABLE_HUB_V2, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean glanceableHubV2Resources() {
        return getValue(Flags.FLAG_GLANCEABLE_HUB_V2_RESOURCES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hapticsForComposeSliders() {
        return getValue(Flags.FLAG_HAPTICS_FOR_COMPOSE_SLIDERS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hardwareColorStyles() {
        return getValue(Flags.FLAG_HARDWARE_COLOR_STYLES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hearingAidsQsTileDialog() {
        return getValue(Flags.FLAG_HEARING_AIDS_QS_TILE_DIALOG, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hearingDevicesDialogRelatedTools() {
        return getValue(Flags.FLAG_HEARING_DEVICES_DIALOG_RELATED_TOOLS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hideRingerButtonInSingleVolumeMode() {
        return getValue(Flags.FLAG_HIDE_RINGER_BUTTON_IN_SINGLE_VOLUME_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean homeControlsDreamHsum() {
        return getValue(Flags.FLAG_HOME_CONTROLS_DREAM_HSUM, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubEditModeTouchAdjustments() {
        return getValue(Flags.FLAG_HUB_EDIT_MODE_TOUCH_ADJUSTMENTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubmodeFullscreenVerticalSwipe() {
        return getValue(Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean hubmodeFullscreenVerticalSwipeFix() {
        return getValue(Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean iconRefresh2025() {
        return getValue(Flags.FLAG_ICON_REFRESH_2025, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean ignoreTouchesNextToNotificationShelf() {
        return getValue(Flags.FLAG_IGNORE_TOUCHES_NEXT_TO_NOTIFICATION_SHELF, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean indicationTextA11yFix() {
        return getValue(Flags.FLAG_INDICATION_TEXT_A11Y_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardDockingIndicator() {
        return getValue(Flags.FLAG_KEYBOARD_DOCKING_INDICATOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardShortcutHelperRewrite() {
        return getValue(Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_REWRITE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardShortcutHelperShortcutCustomizer() {
        return getValue(Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_SHORTCUT_CUSTOMIZER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyboardTouchpadContextualEducation() {
        return getValue(Flags.FLAG_KEYBOARD_TOUCHPAD_CONTEXTUAL_EDUCATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardTransitionForceFinishOnScreenOff() {
        return getValue(Flags.FLAG_KEYGUARD_TRANSITION_FORCE_FINISH_ON_SCREEN_OFF, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardWmReorderAtmsCalls() {
        return getValue(Flags.FLAG_KEYGUARD_WM_REORDER_ATMS_CALLS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean keyguardWmStateRefactor() {
        return getValue(Flags.FLAG_KEYGUARD_WM_STATE_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean lockscreenFont() {
        return getValue(Flags.FLAG_LOCKSCREEN_FONT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean lowLightClockDream() {
        return getValue(Flags.FLAG_LOW_LIGHT_CLOCK_DREAM, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean magneticNotificationSwipes() {
        return getValue(Flags.FLAG_MAGNETIC_NOTIFICATION_SWIPES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsA11yColors() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_A11Y_COLORS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsButtonMedia3() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsButtonMedia3Placement() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3_PLACEMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsDeviceManagerBackgroundExecution() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_DEVICE_MANAGER_BACKGROUND_EXECUTION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsDrawablesReuseBugfix() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_DRAWABLES_REUSE_BUGFIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsLockscreenShadeBugFix() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_LOCKSCREEN_SHADE_BUG_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUiUpdate() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_UI_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUmoInflationInBackground() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_UMO_INFLATION_IN_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaControlsUserInitiatedDeleteintent() {
        return getValue(Flags.FLAG_MEDIA_CONTROLS_USER_INITIATED_DELETEINTENT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaLoadMetadataViaMediaDataLoader() {
        return getValue(Flags.FLAG_MEDIA_LOAD_METADATA_VIA_MEDIA_DATA_LOADER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaLockscreenLaunchAnimation() {
        return getValue(Flags.FLAG_MEDIA_LOCKSCREEN_LAUNCH_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionDialogBehindLockscreen() {
        return getValue(Flags.FLAG_MEDIA_PROJECTION_DIALOG_BEHIND_LOCKSCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionGreyErrorText() {
        return getValue(Flags.FLAG_MEDIA_PROJECTION_GREY_ERROR_TEXT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean mediaProjectionRequestAttributionFix() {
        return getValue(Flags.FLAG_MEDIA_PROJECTION_REQUEST_ATTRIBUTION_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean modesUiDialogPaging() {
        return getValue(Flags.FLAG_MODES_UI_DIALOG_PAGING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean moveTransitionAnimationLayer() {
        return getValue(Flags.FLAG_MOVE_TRANSITION_ANIMATION_LAYER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean msdlFeedback() {
        return getValue(Flags.FLAG_MSDL_FEEDBACK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean multiuserWifiPickerTrackerSupport() {
        return getValue(Flags.FLAG_MULTIUSER_WIFI_PICKER_TRACKER_SUPPORT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean newAodTransition() {
        return getValue(Flags.FLAG_NEW_AOD_TRANSITION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean newVolumePanel() {
        return getValue(Flags.FLAG_NEW_VOLUME_PANEL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean nonTouchscreenDevicesBypassFalsing() {
        return getValue(Flags.FLAG_NON_TOUCHSCREEN_DEVICES_BYPASS_FALSING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notesRoleQsTile() {
        return getValue(Flags.FLAG_NOTES_ROLE_QS_TILE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAddXOnHoverToDismiss() {
        return getValue(Flags.FLAG_NOTIFICATION_ADD_X_ON_HOVER_TO_DISMISS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAmbientSuppressionAfterInflation() {
        return getValue(Flags.FLAG_NOTIFICATION_AMBIENT_SUPPRESSION_AFTER_INFLATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAnimatedActionsTreatment() {
        return getValue(Flags.FLAG_NOTIFICATION_ANIMATED_ACTIONS_TREATMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAppearNonlinear() {
        return getValue(Flags.FLAG_NOTIFICATION_APPEAR_NONLINEAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAsyncGroupHeaderInflation() {
        return getValue(Flags.FLAG_NOTIFICATION_ASYNC_GROUP_HEADER_INFLATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAsyncHybridViewInflation() {
        return getValue(Flags.FLAG_NOTIFICATION_ASYNC_HYBRID_VIEW_INFLATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAvalancheSuppression() {
        return getValue(Flags.FLAG_NOTIFICATION_AVALANCHE_SUPPRESSION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationAvalancheThrottleHun() {
        return getValue(Flags.FLAG_NOTIFICATION_AVALANCHE_THROTTLE_HUN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationBackgroundTintOptimization() {
        return getValue(Flags.FLAG_NOTIFICATION_BACKGROUND_TINT_OPTIMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationBundleUi() {
        return getValue(Flags.FLAG_NOTIFICATION_BUNDLE_UI, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationColorUpdateLogger() {
        return getValue(Flags.FLAG_NOTIFICATION_COLOR_UPDATE_LOGGER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationContentAlphaOptimization() {
        return getValue(Flags.FLAG_NOTIFICATION_CONTENT_ALPHA_OPTIMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationFooterBackgroundTintOptimization() {
        return getValue(Flags.FLAG_NOTIFICATION_FOOTER_BACKGROUND_TINT_OPTIMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationOverExpansionClippingFix() {
        return getValue(Flags.FLAG_NOTIFICATION_OVER_EXPANSION_CLIPPING_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationReentrantDismiss() {
        return getValue(Flags.FLAG_NOTIFICATION_REENTRANT_DISMISS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowAccessibilityExpanded() {
        return getValue(Flags.FLAG_NOTIFICATION_ROW_ACCESSIBILITY_EXPANDED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowContentBinderRefactor() {
        return getValue(Flags.FLAG_NOTIFICATION_ROW_CONTENT_BINDER_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowTransparency() {
        return getValue(Flags.FLAG_NOTIFICATION_ROW_TRANSPARENCY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationRowUserContext() {
        return getValue(Flags.FLAG_NOTIFICATION_ROW_USER_CONTEXT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationShadeBlur() {
        return getValue(Flags.FLAG_NOTIFICATION_SHADE_BLUR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationShadeUiThread() {
        return getValue(Flags.FLAG_NOTIFICATION_SHADE_UI_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationSkipSilentUpdates() {
        return getValue(Flags.FLAG_NOTIFICATION_SKIP_SILENT_UPDATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationTransparentHeaderFix() {
        return getValue(Flags.FLAG_NOTIFICATION_TRANSPARENT_HEADER_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationViewFlipperPausingV2() {
        return getValue(Flags.FLAG_NOTIFICATION_VIEW_FLIPPER_PAUSING_V2, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsBackgroundIcons() {
        return getValue(Flags.FLAG_NOTIFICATIONS_BACKGROUND_ICONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsFooterVisibilityFix() {
        return getValue(Flags.FLAG_NOTIFICATIONS_FOOTER_VISIBILITY_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsHideOnDisplaySwitch() {
        return getValue(Flags.FLAG_NOTIFICATIONS_HIDE_ON_DISPLAY_SWITCH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsHunSharedAnimationValues() {
        return getValue(Flags.FLAG_NOTIFICATIONS_HUN_SHARED_ANIMATION_VALUES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsIconContainerRefactor() {
        return getValue(Flags.FLAG_NOTIFICATIONS_ICON_CONTAINER_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsLaunchRadius() {
        return getValue(Flags.FLAG_NOTIFICATIONS_LAUNCH_RADIUS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsLiveDataStoreRefactor() {
        return getValue(Flags.FLAG_NOTIFICATIONS_LIVE_DATA_STORE_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsPinnedHunInShade() {
        return getValue(Flags.FLAG_NOTIFICATIONS_PINNED_HUN_IN_SHADE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsRedesignFooterView() {
        return getValue(Flags.FLAG_NOTIFICATIONS_REDESIGN_FOOTER_VIEW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notificationsRedesignGuts() {
        return getValue(Flags.FLAG_NOTIFICATIONS_REDESIGN_GUTS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notifyPasswordTextViewUserActivityInBackground() {
        return getValue(Flags.FLAG_NOTIFY_PASSWORD_TEXT_VIEW_USER_ACTIVITY_IN_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean notifyPowerManagerUserActivityBackground() {
        return getValue(Flags.FLAG_NOTIFY_POWER_MANAGER_USER_ACTIVITY_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean onlyShowMediaStreamSliderInSingleVolumeMode() {
        return getValue(Flags.FLAG_ONLY_SHOW_MEDIA_STREAM_SLIDER_IN_SINGLE_VOLUME_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean outputSwitcherRedesign() {
        return getValue(Flags.FLAG_OUTPUT_SWITCHER_REDESIGN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean overrideSuppressOverlayCondition() {
        return getValue(Flags.FLAG_OVERRIDE_SUPPRESS_OVERLAY_CONDITION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean permissionHelperInlineUiRichOngoing() {
        return getValue(Flags.FLAG_PERMISSION_HELPER_INLINE_UI_RICH_ONGOING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean permissionHelperUiRichOngoing() {
        return getValue(Flags.FLAG_PERMISSION_HELPER_UI_RICH_ONGOING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean physicalNotificationMovement() {
        return getValue(Flags.FLAG_PHYSICAL_NOTIFICATION_MOVEMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pinInputFieldStyledFocusState() {
        return getValue(Flags.FLAG_PIN_INPUT_FIELD_STYLED_FOCUS_STATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean predictiveBackAnimateShade() {
        return getValue(Flags.FLAG_PREDICTIVE_BACK_ANIMATE_SHADE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean predictiveBackDelayWmTransition() {
        return getValue(Flags.FLAG_PREDICTIVE_BACK_DELAY_WM_TRANSITION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean priorityPeopleSection() {
        return getValue(Flags.FLAG_PRIORITY_PEOPLE_SECTION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean promoteNotificationsAutomatically() {
        return getValue(Flags.FLAG_PROMOTE_NOTIFICATIONS_AUTOMATICALLY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pssAppSelectorRecentsSplitScreen() {
        return getValue(Flags.FLAG_PSS_APP_SELECTOR_RECENTS_SPLIT_SCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean pssTaskSwitcher() {
        return getValue(Flags.FLAG_PSS_TASK_SWITCHER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsCustomTileClickGuaranteedBugFix() {
        return getValue(Flags.FLAG_QS_CUSTOM_TILE_CLICK_GUARANTEED_BUG_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsNewTiles() {
        return getValue(Flags.FLAG_QS_NEW_TILES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsNewTilesFuture() {
        return getValue(Flags.FLAG_QS_NEW_TILES_FUTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsQuickRebindActiveTiles() {
        return getValue(Flags.FLAG_QS_QUICK_REBIND_ACTIVE_TILES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsRegisterSettingObserverOnBgThread() {
        return getValue(Flags.FLAG_QS_REGISTER_SETTING_OBSERVER_ON_BG_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsTileDetailedView() {
        return getValue(Flags.FLAG_QS_TILE_DETAILED_VIEW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsTileFocusState() {
        return getValue(Flags.FLAG_QS_TILE_FOCUS_STATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsUiRefactor() {
        return getValue(Flags.FLAG_QS_UI_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean qsUiRefactorComposeFragment() {
        return getValue(Flags.FLAG_QS_UI_REFACTOR_COMPOSE_FRAGMENT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean recordIssueQsTile() {
        return getValue(Flags.FLAG_RECORD_ISSUE_QS_TILE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean redesignMagnificationWindowSize() {
        return getValue(Flags.FLAG_REDESIGN_MAGNIFICATION_WINDOW_SIZE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean refactorGetCurrentUser() {
        return getValue(Flags.FLAG_REFACTOR_GET_CURRENT_USER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerBatteryControllerReceiversInCorestartable() {
        return getValue(Flags.FLAG_REGISTER_BATTERY_CONTROLLER_RECEIVERS_IN_CORESTARTABLE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerContentObserversAsync() {
        return getValue(Flags.FLAG_REGISTER_CONTENT_OBSERVERS_ASYNC, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerNewWalletCardInBackground() {
        return getValue(Flags.FLAG_REGISTER_NEW_WALLET_CARD_IN_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean registerWallpaperNotifierBackground() {
        return getValue(Flags.FLAG_REGISTER_WALLPAPER_NOTIFIER_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean relockWithPowerButtonImmediately() {
        return getValue(Flags.FLAG_RELOCK_WITH_POWER_BUTTON_IMMEDIATELY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean removeDreamOverlayHideOnTouch() {
        return getValue(Flags.FLAG_REMOVE_DREAM_OVERLAY_HIDE_ON_TOUCH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean removeUpdateListenerInQsIconViewImpl() {
        return getValue(Flags.FLAG_REMOVE_UPDATE_LISTENER_IN_QS_ICON_VIEW_IMPL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean restToUnlock() {
        return getValue(Flags.FLAG_REST_TO_UNLOCK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean restartDreamOnUnocclude() {
        return getValue(Flags.FLAG_RESTART_DREAM_ON_UNOCCLUDE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean revampedBouncerMessages() {
        return getValue(Flags.FLAG_REVAMPED_BOUNCER_MESSAGES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean runFingerprintDetectOnDismissibleKeyguard() {
        return getValue(Flags.FLAG_RUN_FINGERPRINT_DETECT_ON_DISMISSIBLE_KEYGUARD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean saveAndRestoreMagnificationSettingsButtons() {
        return getValue(Flags.FLAG_SAVE_AND_RESTORE_MAGNIFICATION_SETTINGS_BUTTONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sceneContainer() {
        return getValue(Flags.FLAG_SCENE_CONTAINER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshareNotificationHidingBugFix() {
        return getValue(Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING_BUG_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotActionDismissSystemWindows() {
        return getValue(Flags.FLAG_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotMultidisplayFocusChange() {
        return getValue(Flags.FLAG_SCREENSHOT_MULTIDISPLAY_FOCUS_CHANGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotPolicySplitAndDesktopMode() {
        return getValue(Flags.FLAG_SCREENSHOT_POLICY_SPLIT_AND_DESKTOP_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotScrollCropViewCrashFix() {
        return getValue(Flags.FLAG_SCREENSHOT_SCROLL_CROP_VIEW_CRASH_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean screenshotUiControllerRefactor() {
        return getValue(Flags.FLAG_SCREENSHOT_UI_CONTROLLER_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean secondaryUserWidgetHost() {
        return getValue(Flags.FLAG_SECONDARY_USER_WIDGET_HOST, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean settingsExtRegisterContentObserverOnBgThread() {
        return getValue(Flags.FLAG_SETTINGS_EXT_REGISTER_CONTENT_OBSERVER_ON_BG_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeExpandsOnStatusBarLongPress() {
        return getValue(Flags.FLAG_SHADE_EXPANDS_ON_STATUS_BAR_LONG_PRESS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeHeaderFontUpdate() {
        return getValue(Flags.FLAG_SHADE_HEADER_FONT_UPDATE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeLaunchAccessibility() {
        return getValue(Flags.FLAG_SHADE_LAUNCH_ACCESSIBILITY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shadeWindowGoesAround() {
        return getValue(Flags.FLAG_SHADE_WINDOW_GOES_AROUND, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shaderlibLoadingEffectRefactor() {
        return getValue(Flags.FLAG_SHADERLIB_LOADING_EFFECT_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean shortcutHelperKeyGlyph() {
        return getValue(Flags.FLAG_SHORTCUT_HELPER_KEY_GLYPH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showAudioSharingSliderInVolumePanel() {
        return getValue(Flags.FLAG_SHOW_AUDIO_SHARING_SLIDER_IN_VOLUME_PANEL, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showClipboardIndication() {
        return getValue(Flags.FLAG_SHOW_CLIPBOARD_INDICATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showLockedByYourWatchKeyguardIndicator() {
        return getValue(Flags.FLAG_SHOW_LOCKED_BY_YOUR_WATCH_KEYGUARD_INDICATOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean showToastWhenAppControlBrightness() {
        return getValue(Flags.FLAG_SHOW_TOAST_WHEN_APP_CONTROL_BRIGHTNESS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinBouncerReset() {
        return getValue(Flags.FLAG_SIM_PIN_BOUNCER_RESET, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinRaceConditionOnRestart() {
        return getValue(Flags.FLAG_SIM_PIN_RACE_CONDITION_ON_RESTART, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean simPinUseSlotId() {
        return getValue(Flags.FLAG_SIM_PIN_USE_SLOT_ID, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean skipHideSensitiveNotifAnimation() {
        return getValue(Flags.FLAG_SKIP_HIDE_SENSITIVE_NOTIF_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sliceBroadcastRelayInBackground() {
        return getValue(Flags.FLAG_SLICE_BROADCAST_RELAY_IN_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sliceManagerBinderCallBackground() {
        return getValue(Flags.FLAG_SLICE_MANAGER_BINDER_CALL_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceLockscreenViewmodel() {
        return getValue(Flags.FLAG_SMARTSPACE_LOCKSCREEN_VIEWMODEL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceRelocateToBottom() {
        return getValue(Flags.FLAG_SMARTSPACE_RELOCATE_TO_BOTTOM, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceRemoteviewsRenderingFix() {
        return getValue(Flags.FLAG_SMARTSPACE_REMOTEVIEWS_RENDERING_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceSwipeEventLoggingFix() {
        return getValue(Flags.FLAG_SMARTSPACE_SWIPE_EVENT_LOGGING_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean smartspaceViewpager2() {
        return getValue(Flags.FLAG_SMARTSPACE_VIEWPAGER2, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sounddoseCustomization() {
        return getValue(Flags.FLAG_SOUNDDOSE_CUSTOMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean spatialModelAppPushback() {
        return getValue(Flags.FLAG_SPATIAL_MODEL_APP_PUSHBACK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean stabilizeHeadsUpGroupV2() {
        return getValue(Flags.FLAG_STABILIZE_HEADS_UP_GROUP_V2, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarAlwaysCheckUnderlyingNetworks() {
        return getValue(Flags.FLAG_STATUS_BAR_ALWAYS_CHECK_UNDERLYING_NETWORKS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarAutoStartScreenRecordChip() {
        return getValue(Flags.FLAG_STATUS_BAR_AUTO_START_SCREEN_RECORD_CHIP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarChipsModernization() {
        return getValue(Flags.FLAG_STATUS_BAR_CHIPS_MODERNIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarChipsReturnAnimations() {
        return getValue(Flags.FLAG_STATUS_BAR_CHIPS_RETURN_ANIMATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarFontUpdates() {
        return getValue(Flags.FLAG_STATUS_BAR_FONT_UPDATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarMobileIconKairos() {
        return getValue(Flags.FLAG_STATUS_BAR_MOBILE_ICON_KAIROS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarMonochromeIconsFix() {
        return getValue(Flags.FLAG_STATUS_BAR_MONOCHROME_ICONS_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarNoHunBehavior() {
        return getValue(Flags.FLAG_STATUS_BAR_NO_HUN_BEHAVIOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarPopupChips() {
        return getValue(Flags.FLAG_STATUS_BAR_POPUP_CHIPS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarRootModernization() {
        return getValue(Flags.FLAG_STATUS_BAR_ROOT_MODERNIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarShowAudioOnlyProjectionChip() {
        return getValue(Flags.FLAG_STATUS_BAR_SHOW_AUDIO_ONLY_PROJECTION_CHIP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSignalPolicyRefactor() {
        return getValue(Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSignalPolicyRefactorEthernet() {
        return getValue(Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR_ETHERNET, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarStaticInoutIndicators() {
        return getValue(Flags.FLAG_STATUS_BAR_STATIC_INOUT_INDICATORS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarStopUpdatingWindowHeight() {
        return getValue(Flags.FLAG_STATUS_BAR_STOP_UPDATING_WINDOW_HEIGHT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSwipeOverChip() {
        return getValue(Flags.FLAG_STATUS_BAR_SWIPE_OVER_CHIP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarSwitchToSpnFromDataSpn() {
        return getValue(Flags.FLAG_STATUS_BAR_SWITCH_TO_SPN_FROM_DATA_SPN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarUiThread() {
        return getValue(Flags.FLAG_STATUS_BAR_UI_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean statusBarWindowNoCustomTouch() {
        return getValue(Flags.FLAG_STATUS_BAR_WINDOW_NO_CUSTOM_TOUCH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean stoppableFgsSystemApp() {
        return getValue(Flags.FLAG_STOPPABLE_FGS_SYSTEM_APP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean switchUserOnBg() {
        return getValue(Flags.FLAG_SWITCH_USER_ON_BG, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean sysuiTeamfood() {
        return getValue(Flags.FLAG_SYSUI_TEAMFOOD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean themeOverlayControllerWakefulnessDeprecation() {
        return getValue(Flags.FLAG_THEME_OVERLAY_CONTROLLER_WAKEFULNESS_DEPRECATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean transitionRaceCondition() {
        return getValue(Flags.FLAG_TRANSITION_RACE_CONDITION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean translucentOccludingActivityFix() {
        return getValue(Flags.FLAG_TRANSLUCENT_OCCLUDING_ACTIVITY_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean tvGlobalActionsFocus() {
        return getValue(Flags.FLAG_TV_GLOBAL_ACTIONS_FOCUS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean udfpsViewPerformance() {
        return getValue(Flags.FLAG_UDFPS_VIEW_PERFORMANCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean unfoldAnimationBackgroundProgress() {
        return getValue(Flags.FLAG_UNFOLD_ANIMATION_BACKGROUND_PROGRESS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean unfoldLatencyTrackingFix() {
        return getValue(Flags.FLAG_UNFOLD_LATENCY_TRACKING_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateCornerRadiusOnDisplayChanged() {
        return getValue(Flags.FLAG_UPDATE_CORNER_RADIUS_ON_DISPLAY_CHANGED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateUserSwitcherBackground() {
        return getValue(Flags.FLAG_UPDATE_USER_SWITCHER_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean updateWindowMagnifierBottomBoundary() {
        return getValue(Flags.FLAG_UPDATE_WINDOW_MAGNIFIER_BOTTOM_BOUNDARY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useAadProxSensor() {
        return getValue(Flags.FLAG_USE_AAD_PROX_SENSOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useNotifInflationThreadForFooter() {
        return getValue(Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_FOOTER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useNotifInflationThreadForRow() {
        return getValue(Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_ROW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useTransitionsForKeyguardOccluded() {
        return getValue(Flags.FLAG_USE_TRANSITIONS_FOR_KEYGUARD_OCCLUDED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean useVolumeController() {
        return getValue(Flags.FLAG_USE_VOLUME_CONTROLLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userAwareSettingsRepositories() {
        return getValue(Flags.FLAG_USER_AWARE_SETTINGS_REPOSITORIES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userEncryptedSource() {
        return getValue(Flags.FLAG_USER_ENCRYPTED_SOURCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean userSwitcherAddSignOutOption() {
        return getValue(Flags.FLAG_USER_SWITCHER_ADD_SIGN_OUT_OPTION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean visualInterruptionsRefactor() {
        return getValue(Flags.FLAG_VISUAL_INTERRUPTIONS_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.systemui.FeatureFlags
    public boolean volumeRedesign() {
        return getValue(Flags.FLAG_VOLUME_REDESIGN, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ACTIVITY_TRANSITION_USE_LARGEST_WINDOW, Flags.FLAG_ADD_BLACK_BACKGROUND_FOR_WINDOW_MAGNIFIER, Flags.FLAG_ALWAYS_COMPOSE_QS_UI_FRAGMENT, Flags.FLAG_AMBIENT_TOUCH_MONITOR_LISTEN_TO_DISPLAY_CHANGES, Flags.FLAG_APP_CLIPS_BACKLINKS, Flags.FLAG_APP_SHORTCUT_REMOVAL_FIX, Flags.FLAG_AVALANCHE_REPLACE_HUN_WHEN_CRITICAL, Flags.FLAG_BIND_KEYGUARD_MEDIA_VISIBILITY, Flags.FLAG_BOUNCER_UI_REVAMP, Flags.FLAG_BOUNCER_UI_REVAMP_2, Flags.FLAG_BP_COLORS, Flags.FLAG_BRIGHTNESS_SLIDER_FOCUS_STATE, Flags.FLAG_CHECK_LOCKSCREEN_GONE_TRANSITION, Flags.FLAG_CLASSIC_FLAGS_MULTI_USER, Flags.FLAG_CLIPBOARD_IMAGE_TIMEOUT, Flags.FLAG_CLIPBOARD_NONINTERACTIVE_ON_LOCKSCREEN, Flags.FLAG_CLIPBOARD_OVERLAY_MULTIUSER, Flags.FLAG_CLIPBOARD_SHARED_TRANSITIONS, Flags.FLAG_CLIPBOARD_USE_DESCRIPTION_MIMETYPE, Flags.FLAG_CLOCK_FIDGET_ANIMATION, Flags.FLAG_COMMUNAL_BOUNCER_DO_NOT_MODIFY_PLUGIN_OPEN, Flags.FLAG_COMMUNAL_EDIT_WIDGETS_ACTIVITY_FINISH_FIX, Flags.FLAG_COMMUNAL_HUB, Flags.FLAG_COMMUNAL_HUB_USE_THREAD_POOL_FOR_WIDGETS, Flags.FLAG_COMMUNAL_RESPONSIVE_GRID, Flags.FLAG_COMMUNAL_SCENE_KTF_REFACTOR, Flags.FLAG_COMMUNAL_STANDALONE_SUPPORT, Flags.FLAG_COMMUNAL_TIMER_FLICKER_FIX, Flags.FLAG_COMMUNAL_WIDGET_RESIZING, Flags.FLAG_COMMUNAL_WIDGET_TRAMPOLINE_FIX, Flags.FLAG_COMPOSE_BOUNCER, Flags.FLAG_CONFINE_NOTIFICATION_TOUCH_TO_VIEW_WIDTH, Flags.FLAG_CONT_AUTH_PLUGIN, Flags.FLAG_CONTEXTUAL_TIPS_ASSISTANT_DISMISS_FIX, Flags.FLAG_COROUTINE_TRACING, Flags.FLAG_CREATE_WINDOWLESS_WINDOW_MAGNIFIER, Flags.FLAG_DEBUG_LIVE_UPDATES_PROMOTE_ALL, Flags.FLAG_DECOUPLE_VIEW_CONTROLLER_IN_ANIMLIB, Flags.FLAG_DELAY_SHOW_MAGNIFICATION_BUTTON, Flags.FLAG_DESKTOP_EFFECTS_QS_TILE, Flags.FLAG_DEVICE_ENTRY_UDFPS_REFACTOR, Flags.FLAG_DISABLE_BLURRED_SHADE_VISIBLE, Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_FREQUENCY_CHECK, Flags.FLAG_DISABLE_CONTEXTUAL_TIPS_IOS_SWITCHER_CHECK, Flags.FLAG_DISABLE_SHADE_TRACKPAD_TWO_FINGER_SWIPE, Flags.FLAG_DOUBLE_TAP_TO_SLEEP, Flags.FLAG_DREAM_INPUT_SESSION_PILFER_ONCE, Flags.FLAG_DREAM_OVERLAY_BOUNCER_SWIPE_DIRECTION_FILTERING, Flags.FLAG_DREAM_OVERLAY_UPDATED_FONT, Flags.FLAG_EDGE_BACK_GESTURE_HANDLER_THREAD, Flags.FLAG_EDGEBACK_GESTURE_HANDLER_GET_RUNNING_TASKS_BACKGROUND, Flags.FLAG_ENABLE_BACKGROUND_KEYGUARD_ONDRAWN_CALLBACK, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_MUTE_VOLUME, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_POWER_OFF, Flags.FLAG_ENABLE_CONTEXTUAL_TIP_FOR_TAKE_SCREENSHOT, Flags.FLAG_ENABLE_CONTEXTUAL_TIPS, Flags.FLAG_ENABLE_EFFICIENT_DISPLAY_REPOSITORY, Flags.FLAG_ENABLE_LAYOUT_TRACING, Flags.FLAG_ENABLE_UNDERLAY, Flags.FLAG_ENABLE_VIEW_CAPTURE_TRACING, Flags.FLAG_ENFORCE_BRIGHTNESS_BASE_USER_RESTRICTION, Flags.FLAG_EXAMPLE_FLAG, Flags.FLAG_EXPAND_COLLAPSE_PRIVACY_DIALOG, Flags.FLAG_EXPAND_HEADS_UP_ON_INLINE_REPLY, Flags.FLAG_EXPANDED_PRIVACY_INDICATORS_ON_LARGE_SCREEN, Flags.FLAG_EXTENDED_APPS_SHORTCUT_CATEGORY, Flags.FLAG_FACE_MESSAGE_DEFER_UPDATE, Flags.FLAG_FACE_SCANNING_ANIMATION_NPE_FIX, Flags.FLAG_FASTER_UNLOCK_TRANSITION, Flags.FLAG_FETCH_BOOKMARKS_XML_KEYBOARD_SHORTCUTS, Flags.FLAG_FIX_IMAGE_WALLPAPER_CRASH_SURFACE_ALREADY_RELEASED, Flags.FLAG_FIX_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, Flags.FLAG_FLOATING_MENU_ANIMATED_TUCK, Flags.FLAG_FLOATING_MENU_DISPLAY_CUTOUT_SUPPORT, Flags.FLAG_FLOATING_MENU_DRAG_TO_EDIT, Flags.FLAG_FLOATING_MENU_DRAG_TO_HIDE, Flags.FLAG_FLOATING_MENU_HEARING_DEVICE_STATUS_ICON, Flags.FLAG_FLOATING_MENU_IME_DISPLACEMENT_ANIMATION, Flags.FLAG_FLOATING_MENU_NARROW_TARGET_CONTENT_OBSERVER, Flags.FLAG_FLOATING_MENU_NOTIFY_TARGETS_CHANGED_ON_STRICT_DIFF, Flags.FLAG_FLOATING_MENU_OVERLAPS_NAV_BARS_FLAG, Flags.FLAG_FLOATING_MENU_RADII_ANIMATION, Flags.FLAG_GET_CONNECTED_DEVICE_NAME_UNSYNCHRONIZED, Flags.FLAG_GLANCEABLE_HUB_ALLOW_KEYGUARD_WHEN_DREAMING, Flags.FLAG_GLANCEABLE_HUB_BLURRED_BACKGROUND, Flags.FLAG_GLANCEABLE_HUB_DIRECT_EDIT_MODE, Flags.FLAG_GLANCEABLE_HUB_V2, Flags.FLAG_GLANCEABLE_HUB_V2_RESOURCES, Flags.FLAG_HAPTICS_FOR_COMPOSE_SLIDERS, Flags.FLAG_HARDWARE_COLOR_STYLES, Flags.FLAG_HEARING_AIDS_QS_TILE_DIALOG, Flags.FLAG_HEARING_DEVICES_DIALOG_RELATED_TOOLS, Flags.FLAG_HIDE_RINGER_BUTTON_IN_SINGLE_VOLUME_MODE, Flags.FLAG_HOME_CONTROLS_DREAM_HSUM, Flags.FLAG_HUB_EDIT_MODE_TOUCH_ADJUSTMENTS, Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE, Flags.FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE_FIX, Flags.FLAG_ICON_REFRESH_2025, Flags.FLAG_IGNORE_TOUCHES_NEXT_TO_NOTIFICATION_SHELF, Flags.FLAG_INDICATION_TEXT_A11Y_FIX, Flags.FLAG_KEYBOARD_DOCKING_INDICATOR, Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_REWRITE, Flags.FLAG_KEYBOARD_SHORTCUT_HELPER_SHORTCUT_CUSTOMIZER, Flags.FLAG_KEYBOARD_TOUCHPAD_CONTEXTUAL_EDUCATION, Flags.FLAG_KEYGUARD_TRANSITION_FORCE_FINISH_ON_SCREEN_OFF, Flags.FLAG_KEYGUARD_WM_REORDER_ATMS_CALLS, Flags.FLAG_KEYGUARD_WM_STATE_REFACTOR, Flags.FLAG_LOCKSCREEN_FONT, Flags.FLAG_LOW_LIGHT_CLOCK_DREAM, Flags.FLAG_MAGNETIC_NOTIFICATION_SWIPES, Flags.FLAG_MEDIA_CONTROLS_A11Y_COLORS, Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3, Flags.FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3_PLACEMENT, Flags.FLAG_MEDIA_CONTROLS_DEVICE_MANAGER_BACKGROUND_EXECUTION, Flags.FLAG_MEDIA_CONTROLS_DRAWABLES_REUSE_BUGFIX, Flags.FLAG_MEDIA_CONTROLS_LOCKSCREEN_SHADE_BUG_FIX, Flags.FLAG_MEDIA_CONTROLS_UI_UPDATE, Flags.FLAG_MEDIA_CONTROLS_UMO_INFLATION_IN_BACKGROUND, Flags.FLAG_MEDIA_CONTROLS_USER_INITIATED_DELETEINTENT, Flags.FLAG_MEDIA_LOAD_METADATA_VIA_MEDIA_DATA_LOADER, Flags.FLAG_MEDIA_LOCKSCREEN_LAUNCH_ANIMATION, Flags.FLAG_MEDIA_PROJECTION_DIALOG_BEHIND_LOCKSCREEN, Flags.FLAG_MEDIA_PROJECTION_GREY_ERROR_TEXT, Flags.FLAG_MEDIA_PROJECTION_REQUEST_ATTRIBUTION_FIX, Flags.FLAG_MODES_UI_DIALOG_PAGING, Flags.FLAG_MOVE_TRANSITION_ANIMATION_LAYER, Flags.FLAG_MSDL_FEEDBACK, Flags.FLAG_MULTIUSER_WIFI_PICKER_TRACKER_SUPPORT, Flags.FLAG_NEW_AOD_TRANSITION, Flags.FLAG_NEW_VOLUME_PANEL, Flags.FLAG_NON_TOUCHSCREEN_DEVICES_BYPASS_FALSING, Flags.FLAG_NOTES_ROLE_QS_TILE, Flags.FLAG_NOTIFICATION_ADD_X_ON_HOVER_TO_DISMISS, Flags.FLAG_NOTIFICATION_AMBIENT_SUPPRESSION_AFTER_INFLATION, Flags.FLAG_NOTIFICATION_ANIMATED_ACTIONS_TREATMENT, Flags.FLAG_NOTIFICATION_APPEAR_NONLINEAR, Flags.FLAG_NOTIFICATION_ASYNC_GROUP_HEADER_INFLATION, Flags.FLAG_NOTIFICATION_ASYNC_HYBRID_VIEW_INFLATION, Flags.FLAG_NOTIFICATION_AVALANCHE_SUPPRESSION, Flags.FLAG_NOTIFICATION_AVALANCHE_THROTTLE_HUN, Flags.FLAG_NOTIFICATION_BACKGROUND_TINT_OPTIMIZATION, Flags.FLAG_NOTIFICATION_BUNDLE_UI, Flags.FLAG_NOTIFICATION_COLOR_UPDATE_LOGGER, Flags.FLAG_NOTIFICATION_CONTENT_ALPHA_OPTIMIZATION, Flags.FLAG_NOTIFICATION_FOOTER_BACKGROUND_TINT_OPTIMIZATION, Flags.FLAG_NOTIFICATION_OVER_EXPANSION_CLIPPING_FIX, Flags.FLAG_NOTIFICATION_REENTRANT_DISMISS, Flags.FLAG_NOTIFICATION_ROW_ACCESSIBILITY_EXPANDED, Flags.FLAG_NOTIFICATION_ROW_CONTENT_BINDER_REFACTOR, Flags.FLAG_NOTIFICATION_ROW_TRANSPARENCY, Flags.FLAG_NOTIFICATION_ROW_USER_CONTEXT, Flags.FLAG_NOTIFICATION_SHADE_BLUR, Flags.FLAG_NOTIFICATION_SHADE_UI_THREAD, Flags.FLAG_NOTIFICATION_SKIP_SILENT_UPDATES, Flags.FLAG_NOTIFICATION_TRANSPARENT_HEADER_FIX, Flags.FLAG_NOTIFICATION_VIEW_FLIPPER_PAUSING_V2, Flags.FLAG_NOTIFICATIONS_BACKGROUND_ICONS, Flags.FLAG_NOTIFICATIONS_FOOTER_VISIBILITY_FIX, Flags.FLAG_NOTIFICATIONS_HIDE_ON_DISPLAY_SWITCH, Flags.FLAG_NOTIFICATIONS_HUN_SHARED_ANIMATION_VALUES, Flags.FLAG_NOTIFICATIONS_ICON_CONTAINER_REFACTOR, Flags.FLAG_NOTIFICATIONS_LAUNCH_RADIUS, Flags.FLAG_NOTIFICATIONS_LIVE_DATA_STORE_REFACTOR, Flags.FLAG_NOTIFICATIONS_PINNED_HUN_IN_SHADE, Flags.FLAG_NOTIFICATIONS_REDESIGN_FOOTER_VIEW, Flags.FLAG_NOTIFICATIONS_REDESIGN_GUTS, Flags.FLAG_NOTIFY_PASSWORD_TEXT_VIEW_USER_ACTIVITY_IN_BACKGROUND, Flags.FLAG_NOTIFY_POWER_MANAGER_USER_ACTIVITY_BACKGROUND, Flags.FLAG_ONLY_SHOW_MEDIA_STREAM_SLIDER_IN_SINGLE_VOLUME_MODE, Flags.FLAG_OUTPUT_SWITCHER_REDESIGN, Flags.FLAG_OVERRIDE_SUPPRESS_OVERLAY_CONDITION, Flags.FLAG_PERMISSION_HELPER_INLINE_UI_RICH_ONGOING, Flags.FLAG_PERMISSION_HELPER_UI_RICH_ONGOING, Flags.FLAG_PHYSICAL_NOTIFICATION_MOVEMENT, Flags.FLAG_PIN_INPUT_FIELD_STYLED_FOCUS_STATE, Flags.FLAG_PREDICTIVE_BACK_ANIMATE_SHADE, Flags.FLAG_PREDICTIVE_BACK_DELAY_WM_TRANSITION, Flags.FLAG_PRIORITY_PEOPLE_SECTION, Flags.FLAG_PROMOTE_NOTIFICATIONS_AUTOMATICALLY, Flags.FLAG_PSS_APP_SELECTOR_RECENTS_SPLIT_SCREEN, Flags.FLAG_PSS_TASK_SWITCHER, Flags.FLAG_QS_CUSTOM_TILE_CLICK_GUARANTEED_BUG_FIX, Flags.FLAG_QS_NEW_TILES, Flags.FLAG_QS_NEW_TILES_FUTURE, Flags.FLAG_QS_QUICK_REBIND_ACTIVE_TILES, Flags.FLAG_QS_REGISTER_SETTING_OBSERVER_ON_BG_THREAD, Flags.FLAG_QS_TILE_DETAILED_VIEW, Flags.FLAG_QS_TILE_FOCUS_STATE, Flags.FLAG_QS_UI_REFACTOR, Flags.FLAG_QS_UI_REFACTOR_COMPOSE_FRAGMENT, Flags.FLAG_RECORD_ISSUE_QS_TILE, Flags.FLAG_REDESIGN_MAGNIFICATION_WINDOW_SIZE, Flags.FLAG_REFACTOR_GET_CURRENT_USER, Flags.FLAG_REGISTER_BATTERY_CONTROLLER_RECEIVERS_IN_CORESTARTABLE, Flags.FLAG_REGISTER_CONTENT_OBSERVERS_ASYNC, Flags.FLAG_REGISTER_NEW_WALLET_CARD_IN_BACKGROUND, Flags.FLAG_REGISTER_WALLPAPER_NOTIFIER_BACKGROUND, Flags.FLAG_RELOCK_WITH_POWER_BUTTON_IMMEDIATELY, Flags.FLAG_REMOVE_DREAM_OVERLAY_HIDE_ON_TOUCH, Flags.FLAG_REMOVE_UPDATE_LISTENER_IN_QS_ICON_VIEW_IMPL, Flags.FLAG_REST_TO_UNLOCK, Flags.FLAG_RESTART_DREAM_ON_UNOCCLUDE, Flags.FLAG_REVAMPED_BOUNCER_MESSAGES, Flags.FLAG_RUN_FINGERPRINT_DETECT_ON_DISMISSIBLE_KEYGUARD, Flags.FLAG_SAVE_AND_RESTORE_MAGNIFICATION_SETTINGS_BUTTONS, Flags.FLAG_SCENE_CONTAINER, Flags.FLAG_SCREENSHARE_NOTIFICATION_HIDING_BUG_FIX, Flags.FLAG_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS, Flags.FLAG_SCREENSHOT_MULTIDISPLAY_FOCUS_CHANGE, Flags.FLAG_SCREENSHOT_POLICY_SPLIT_AND_DESKTOP_MODE, Flags.FLAG_SCREENSHOT_SCROLL_CROP_VIEW_CRASH_FIX, Flags.FLAG_SCREENSHOT_UI_CONTROLLER_REFACTOR, Flags.FLAG_SECONDARY_USER_WIDGET_HOST, Flags.FLAG_SETTINGS_EXT_REGISTER_CONTENT_OBSERVER_ON_BG_THREAD, Flags.FLAG_SHADE_EXPANDS_ON_STATUS_BAR_LONG_PRESS, Flags.FLAG_SHADE_HEADER_FONT_UPDATE, Flags.FLAG_SHADE_LAUNCH_ACCESSIBILITY, Flags.FLAG_SHADE_WINDOW_GOES_AROUND, Flags.FLAG_SHADERLIB_LOADING_EFFECT_REFACTOR, Flags.FLAG_SHORTCUT_HELPER_KEY_GLYPH, Flags.FLAG_SHOW_AUDIO_SHARING_SLIDER_IN_VOLUME_PANEL, Flags.FLAG_SHOW_CLIPBOARD_INDICATION, Flags.FLAG_SHOW_LOCKED_BY_YOUR_WATCH_KEYGUARD_INDICATOR, Flags.FLAG_SHOW_TOAST_WHEN_APP_CONTROL_BRIGHTNESS, Flags.FLAG_SIM_PIN_BOUNCER_RESET, Flags.FLAG_SIM_PIN_RACE_CONDITION_ON_RESTART, Flags.FLAG_SIM_PIN_USE_SLOT_ID, Flags.FLAG_SKIP_HIDE_SENSITIVE_NOTIF_ANIMATION, Flags.FLAG_SLICE_BROADCAST_RELAY_IN_BACKGROUND, Flags.FLAG_SLICE_MANAGER_BINDER_CALL_BACKGROUND, Flags.FLAG_SMARTSPACE_LOCKSCREEN_VIEWMODEL, Flags.FLAG_SMARTSPACE_RELOCATE_TO_BOTTOM, Flags.FLAG_SMARTSPACE_REMOTEVIEWS_RENDERING_FIX, Flags.FLAG_SMARTSPACE_SWIPE_EVENT_LOGGING_FIX, Flags.FLAG_SMARTSPACE_VIEWPAGER2, Flags.FLAG_SOUNDDOSE_CUSTOMIZATION, Flags.FLAG_SPATIAL_MODEL_APP_PUSHBACK, Flags.FLAG_STABILIZE_HEADS_UP_GROUP_V2, Flags.FLAG_STATUS_BAR_ALWAYS_CHECK_UNDERLYING_NETWORKS, Flags.FLAG_STATUS_BAR_AUTO_START_SCREEN_RECORD_CHIP, Flags.FLAG_STATUS_BAR_CHIPS_MODERNIZATION, Flags.FLAG_STATUS_BAR_CHIPS_RETURN_ANIMATIONS, Flags.FLAG_STATUS_BAR_FONT_UPDATES, Flags.FLAG_STATUS_BAR_MOBILE_ICON_KAIROS, Flags.FLAG_STATUS_BAR_MONOCHROME_ICONS_FIX, Flags.FLAG_STATUS_BAR_NO_HUN_BEHAVIOR, Flags.FLAG_STATUS_BAR_POPUP_CHIPS, Flags.FLAG_STATUS_BAR_ROOT_MODERNIZATION, Flags.FLAG_STATUS_BAR_SHOW_AUDIO_ONLY_PROJECTION_CHIP, Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR, Flags.FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR_ETHERNET, Flags.FLAG_STATUS_BAR_STATIC_INOUT_INDICATORS, Flags.FLAG_STATUS_BAR_STOP_UPDATING_WINDOW_HEIGHT, Flags.FLAG_STATUS_BAR_SWIPE_OVER_CHIP, Flags.FLAG_STATUS_BAR_SWITCH_TO_SPN_FROM_DATA_SPN, Flags.FLAG_STATUS_BAR_UI_THREAD, Flags.FLAG_STATUS_BAR_WINDOW_NO_CUSTOM_TOUCH, Flags.FLAG_STOPPABLE_FGS_SYSTEM_APP, Flags.FLAG_SWITCH_USER_ON_BG, Flags.FLAG_SYSUI_TEAMFOOD, Flags.FLAG_THEME_OVERLAY_CONTROLLER_WAKEFULNESS_DEPRECATION, Flags.FLAG_TRANSITION_RACE_CONDITION, Flags.FLAG_TRANSLUCENT_OCCLUDING_ACTIVITY_FIX, Flags.FLAG_TV_GLOBAL_ACTIONS_FOCUS, Flags.FLAG_UDFPS_VIEW_PERFORMANCE, Flags.FLAG_UNFOLD_ANIMATION_BACKGROUND_PROGRESS, Flags.FLAG_UNFOLD_LATENCY_TRACKING_FIX, Flags.FLAG_UPDATE_CORNER_RADIUS_ON_DISPLAY_CHANGED, Flags.FLAG_UPDATE_USER_SWITCHER_BACKGROUND, Flags.FLAG_UPDATE_WINDOW_MAGNIFIER_BOTTOM_BOUNDARY, Flags.FLAG_USE_AAD_PROX_SENSOR, Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_FOOTER, Flags.FLAG_USE_NOTIF_INFLATION_THREAD_FOR_ROW, Flags.FLAG_USE_TRANSITIONS_FOR_KEYGUARD_OCCLUDED, Flags.FLAG_USE_VOLUME_CONTROLLER, Flags.FLAG_USER_AWARE_SETTINGS_REPOSITORIES, Flags.FLAG_USER_ENCRYPTED_SOURCE, Flags.FLAG_USER_SWITCHER_ADD_SIGN_OUT_OPTION, Flags.FLAG_VISUAL_INTERRUPTIONS_REFACTOR, Flags.FLAG_VOLUME_REDESIGN});
    }
}
