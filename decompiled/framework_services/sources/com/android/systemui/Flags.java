package com.android.systemui;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ACTIVITY_TRANSITION_USE_LARGEST_WINDOW = "com.android.systemui.activity_transition_use_largest_window";
    public static final String FLAG_ADD_BLACK_BACKGROUND_FOR_WINDOW_MAGNIFIER = "com.android.systemui.add_black_background_for_window_magnifier";
    public static final String FLAG_ALWAYS_COMPOSE_QS_UI_FRAGMENT = "com.android.systemui.always_compose_qs_ui_fragment";
    public static final String FLAG_AMBIENT_TOUCH_MONITOR_LISTEN_TO_DISPLAY_CHANGES = "com.android.systemui.ambient_touch_monitor_listen_to_display_changes";
    public static final String FLAG_APP_CLIPS_BACKLINKS = "com.android.systemui.app_clips_backlinks";
    public static final String FLAG_APP_SHORTCUT_REMOVAL_FIX = "com.android.systemui.app_shortcut_removal_fix";
    public static final String FLAG_AVALANCHE_REPLACE_HUN_WHEN_CRITICAL = "com.android.systemui.avalanche_replace_hun_when_critical";
    public static final String FLAG_BIND_KEYGUARD_MEDIA_VISIBILITY = "com.android.systemui.bind_keyguard_media_visibility";
    public static final String FLAG_BOUNCER_UI_REVAMP = "com.android.systemui.bouncer_ui_revamp";
    public static final String FLAG_BOUNCER_UI_REVAMP_2 = "com.android.systemui.bouncer_ui_revamp_2";
    public static final String FLAG_BP_COLORS = "com.android.systemui.bp_colors";
    public static final String FLAG_BRIGHTNESS_SLIDER_FOCUS_STATE = "com.android.systemui.brightness_slider_focus_state";
    public static final String FLAG_CHECK_LOCKSCREEN_GONE_TRANSITION = "com.android.systemui.check_lockscreen_gone_transition";
    public static final String FLAG_CLASSIC_FLAGS_MULTI_USER = "com.android.systemui.classic_flags_multi_user";
    public static final String FLAG_CLIPBOARD_IMAGE_TIMEOUT = "com.android.systemui.clipboard_image_timeout";
    public static final String FLAG_CLIPBOARD_NONINTERACTIVE_ON_LOCKSCREEN = "com.android.systemui.clipboard_noninteractive_on_lockscreen";
    public static final String FLAG_CLIPBOARD_OVERLAY_MULTIUSER = "com.android.systemui.clipboard_overlay_multiuser";
    public static final String FLAG_CLIPBOARD_SHARED_TRANSITIONS = "com.android.systemui.clipboard_shared_transitions";
    public static final String FLAG_CLIPBOARD_USE_DESCRIPTION_MIMETYPE = "com.android.systemui.clipboard_use_description_mimetype";
    public static final String FLAG_CLOCK_FIDGET_ANIMATION = "com.android.systemui.clock_fidget_animation";
    public static final String FLAG_COMMUNAL_BOUNCER_DO_NOT_MODIFY_PLUGIN_OPEN = "com.android.systemui.communal_bouncer_do_not_modify_plugin_open";
    public static final String FLAG_COMMUNAL_EDIT_WIDGETS_ACTIVITY_FINISH_FIX = "com.android.systemui.communal_edit_widgets_activity_finish_fix";
    public static final String FLAG_COMMUNAL_HUB = "com.android.systemui.communal_hub";
    public static final String FLAG_COMMUNAL_HUB_USE_THREAD_POOL_FOR_WIDGETS = "com.android.systemui.communal_hub_use_thread_pool_for_widgets";
    public static final String FLAG_COMMUNAL_RESPONSIVE_GRID = "com.android.systemui.communal_responsive_grid";
    public static final String FLAG_COMMUNAL_SCENE_KTF_REFACTOR = "com.android.systemui.communal_scene_ktf_refactor";
    public static final String FLAG_COMMUNAL_STANDALONE_SUPPORT = "com.android.systemui.communal_standalone_support";
    public static final String FLAG_COMMUNAL_TIMER_FLICKER_FIX = "com.android.systemui.communal_timer_flicker_fix";
    public static final String FLAG_COMMUNAL_WIDGET_RESIZING = "com.android.systemui.communal_widget_resizing";
    public static final String FLAG_COMMUNAL_WIDGET_TRAMPOLINE_FIX = "com.android.systemui.communal_widget_trampoline_fix";
    public static final String FLAG_COMPOSE_BOUNCER = "com.android.systemui.compose_bouncer";
    public static final String FLAG_CONFINE_NOTIFICATION_TOUCH_TO_VIEW_WIDTH = "com.android.systemui.confine_notification_touch_to_view_width";
    public static final String FLAG_CONTEXTUAL_TIPS_ASSISTANT_DISMISS_FIX = "com.android.systemui.contextual_tips_assistant_dismiss_fix";
    public static final String FLAG_CONT_AUTH_PLUGIN = "com.android.systemui.cont_auth_plugin";
    public static final String FLAG_COROUTINE_TRACING = "com.android.systemui.coroutine_tracing";
    public static final String FLAG_CREATE_WINDOWLESS_WINDOW_MAGNIFIER = "com.android.systemui.create_windowless_window_magnifier";
    public static final String FLAG_DEBUG_LIVE_UPDATES_PROMOTE_ALL = "com.android.systemui.debug_live_updates_promote_all";
    public static final String FLAG_DECOUPLE_VIEW_CONTROLLER_IN_ANIMLIB = "com.android.systemui.decouple_view_controller_in_animlib";
    public static final String FLAG_DELAY_SHOW_MAGNIFICATION_BUTTON = "com.android.systemui.delay_show_magnification_button";
    public static final String FLAG_DESKTOP_EFFECTS_QS_TILE = "com.android.systemui.desktop_effects_qs_tile";
    public static final String FLAG_DEVICE_ENTRY_UDFPS_REFACTOR = "com.android.systemui.device_entry_udfps_refactor";
    public static final String FLAG_DISABLE_BLURRED_SHADE_VISIBLE = "com.android.systemui.disable_blurred_shade_visible";
    public static final String FLAG_DISABLE_CONTEXTUAL_TIPS_FREQUENCY_CHECK = "com.android.systemui.disable_contextual_tips_frequency_check";
    public static final String FLAG_DISABLE_CONTEXTUAL_TIPS_IOS_SWITCHER_CHECK = "com.android.systemui.disable_contextual_tips_ios_switcher_check";
    public static final String FLAG_DISABLE_SHADE_TRACKPAD_TWO_FINGER_SWIPE = "com.android.systemui.disable_shade_trackpad_two_finger_swipe";
    public static final String FLAG_DOUBLE_TAP_TO_SLEEP = "com.android.systemui.double_tap_to_sleep";
    public static final String FLAG_DREAM_INPUT_SESSION_PILFER_ONCE = "com.android.systemui.dream_input_session_pilfer_once";
    public static final String FLAG_DREAM_OVERLAY_BOUNCER_SWIPE_DIRECTION_FILTERING = "com.android.systemui.dream_overlay_bouncer_swipe_direction_filtering";
    public static final String FLAG_DREAM_OVERLAY_UPDATED_FONT = "com.android.systemui.dream_overlay_updated_font";
    public static final String FLAG_EDGEBACK_GESTURE_HANDLER_GET_RUNNING_TASKS_BACKGROUND = "com.android.systemui.edgeback_gesture_handler_get_running_tasks_background";
    public static final String FLAG_EDGE_BACK_GESTURE_HANDLER_THREAD = "com.android.systemui.edge_back_gesture_handler_thread";
    public static final String FLAG_ENABLE_BACKGROUND_KEYGUARD_ONDRAWN_CALLBACK = "com.android.systemui.enable_background_keyguard_ondrawn_callback";
    public static final String FLAG_ENABLE_CONTEXTUAL_TIPS = "com.android.systemui.enable_contextual_tips";
    public static final String FLAG_ENABLE_CONTEXTUAL_TIP_FOR_MUTE_VOLUME = "com.android.systemui.enable_contextual_tip_for_mute_volume";
    public static final String FLAG_ENABLE_CONTEXTUAL_TIP_FOR_POWER_OFF = "com.android.systemui.enable_contextual_tip_for_power_off";
    public static final String FLAG_ENABLE_CONTEXTUAL_TIP_FOR_TAKE_SCREENSHOT = "com.android.systemui.enable_contextual_tip_for_take_screenshot";
    public static final String FLAG_ENABLE_EFFICIENT_DISPLAY_REPOSITORY = "com.android.systemui.enable_efficient_display_repository";
    public static final String FLAG_ENABLE_LAYOUT_TRACING = "com.android.systemui.enable_layout_tracing";
    public static final String FLAG_ENABLE_UNDERLAY = "com.android.systemui.enable_underlay";
    public static final String FLAG_ENABLE_VIEW_CAPTURE_TRACING = "com.android.systemui.enable_view_capture_tracing";
    public static final String FLAG_ENFORCE_BRIGHTNESS_BASE_USER_RESTRICTION = "com.android.systemui.enforce_brightness_base_user_restriction";
    public static final String FLAG_EXAMPLE_FLAG = "com.android.systemui.example_flag";
    public static final String FLAG_EXPANDED_PRIVACY_INDICATORS_ON_LARGE_SCREEN = "com.android.systemui.expanded_privacy_indicators_on_large_screen";
    public static final String FLAG_EXPAND_COLLAPSE_PRIVACY_DIALOG = "com.android.systemui.expand_collapse_privacy_dialog";
    public static final String FLAG_EXPAND_HEADS_UP_ON_INLINE_REPLY = "com.android.systemui.expand_heads_up_on_inline_reply";
    public static final String FLAG_EXTENDED_APPS_SHORTCUT_CATEGORY = "com.android.systemui.extended_apps_shortcut_category";
    public static final String FLAG_FACE_MESSAGE_DEFER_UPDATE = "com.android.systemui.face_message_defer_update";
    public static final String FLAG_FACE_SCANNING_ANIMATION_NPE_FIX = "com.android.systemui.face_scanning_animation_npe_fix";
    public static final String FLAG_FASTER_UNLOCK_TRANSITION = "com.android.systemui.faster_unlock_transition";
    public static final String FLAG_FETCH_BOOKMARKS_XML_KEYBOARD_SHORTCUTS = "com.android.systemui.fetch_bookmarks_xml_keyboard_shortcuts";
    public static final String FLAG_FIX_IMAGE_WALLPAPER_CRASH_SURFACE_ALREADY_RELEASED = "com.android.systemui.fix_image_wallpaper_crash_surface_already_released";
    public static final String FLAG_FIX_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS = "com.android.systemui.fix_screenshot_action_dismiss_system_windows";
    public static final String FLAG_FLOATING_MENU_ANIMATED_TUCK = "com.android.systemui.floating_menu_animated_tuck";
    public static final String FLAG_FLOATING_MENU_DISPLAY_CUTOUT_SUPPORT = "com.android.systemui.floating_menu_display_cutout_support";
    public static final String FLAG_FLOATING_MENU_DRAG_TO_EDIT = "com.android.systemui.floating_menu_drag_to_edit";
    public static final String FLAG_FLOATING_MENU_DRAG_TO_HIDE = "com.android.systemui.floating_menu_drag_to_hide";
    public static final String FLAG_FLOATING_MENU_HEARING_DEVICE_STATUS_ICON = "com.android.systemui.floating_menu_hearing_device_status_icon";
    public static final String FLAG_FLOATING_MENU_IME_DISPLACEMENT_ANIMATION = "com.android.systemui.floating_menu_ime_displacement_animation";
    public static final String FLAG_FLOATING_MENU_NARROW_TARGET_CONTENT_OBSERVER = "com.android.systemui.floating_menu_narrow_target_content_observer";
    public static final String FLAG_FLOATING_MENU_NOTIFY_TARGETS_CHANGED_ON_STRICT_DIFF = "com.android.systemui.floating_menu_notify_targets_changed_on_strict_diff";
    public static final String FLAG_FLOATING_MENU_OVERLAPS_NAV_BARS_FLAG = "com.android.systemui.floating_menu_overlaps_nav_bars_flag";
    public static final String FLAG_FLOATING_MENU_RADII_ANIMATION = "com.android.systemui.floating_menu_radii_animation";
    public static final String FLAG_GET_CONNECTED_DEVICE_NAME_UNSYNCHRONIZED = "com.android.systemui.get_connected_device_name_unsynchronized";
    public static final String FLAG_GLANCEABLE_HUB_ALLOW_KEYGUARD_WHEN_DREAMING = "com.android.systemui.glanceable_hub_allow_keyguard_when_dreaming";
    public static final String FLAG_GLANCEABLE_HUB_BLURRED_BACKGROUND = "com.android.systemui.glanceable_hub_blurred_background";
    public static final String FLAG_GLANCEABLE_HUB_DIRECT_EDIT_MODE = "com.android.systemui.glanceable_hub_direct_edit_mode";
    public static final String FLAG_GLANCEABLE_HUB_V2 = "com.android.systemui.glanceable_hub_v2";
    public static final String FLAG_GLANCEABLE_HUB_V2_RESOURCES = "com.android.systemui.glanceable_hub_v2_resources";
    public static final String FLAG_HAPTICS_FOR_COMPOSE_SLIDERS = "com.android.systemui.haptics_for_compose_sliders";
    public static final String FLAG_HARDWARE_COLOR_STYLES = "com.android.systemui.hardware_color_styles";
    public static final String FLAG_HEARING_AIDS_QS_TILE_DIALOG = "com.android.systemui.hearing_aids_qs_tile_dialog";
    public static final String FLAG_HEARING_DEVICES_DIALOG_RELATED_TOOLS = "com.android.systemui.hearing_devices_dialog_related_tools";
    public static final String FLAG_HIDE_RINGER_BUTTON_IN_SINGLE_VOLUME_MODE = "com.android.systemui.hide_ringer_button_in_single_volume_mode";
    public static final String FLAG_HOME_CONTROLS_DREAM_HSUM = "com.android.systemui.home_controls_dream_hsum";
    public static final String FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE = "com.android.systemui.hubmode_fullscreen_vertical_swipe";
    public static final String FLAG_HUBMODE_FULLSCREEN_VERTICAL_SWIPE_FIX = "com.android.systemui.hubmode_fullscreen_vertical_swipe_fix";
    public static final String FLAG_HUB_EDIT_MODE_TOUCH_ADJUSTMENTS = "com.android.systemui.hub_edit_mode_touch_adjustments";
    public static final String FLAG_ICON_REFRESH_2025 = "com.android.systemui.icon_refresh_2025";
    public static final String FLAG_IGNORE_TOUCHES_NEXT_TO_NOTIFICATION_SHELF = "com.android.systemui.ignore_touches_next_to_notification_shelf";
    public static final String FLAG_INDICATION_TEXT_A11Y_FIX = "com.android.systemui.indication_text_a11y_fix";
    public static final String FLAG_KEYBOARD_DOCKING_INDICATOR = "com.android.systemui.keyboard_docking_indicator";
    public static final String FLAG_KEYBOARD_SHORTCUT_HELPER_REWRITE = "com.android.systemui.keyboard_shortcut_helper_rewrite";
    public static final String FLAG_KEYBOARD_SHORTCUT_HELPER_SHORTCUT_CUSTOMIZER = "com.android.systemui.keyboard_shortcut_helper_shortcut_customizer";
    public static final String FLAG_KEYBOARD_TOUCHPAD_CONTEXTUAL_EDUCATION = "com.android.systemui.keyboard_touchpad_contextual_education";
    public static final String FLAG_KEYGUARD_TRANSITION_FORCE_FINISH_ON_SCREEN_OFF = "com.android.systemui.keyguard_transition_force_finish_on_screen_off";
    public static final String FLAG_KEYGUARD_WM_REORDER_ATMS_CALLS = "com.android.systemui.keyguard_wm_reorder_atms_calls";
    public static final String FLAG_KEYGUARD_WM_STATE_REFACTOR = "com.android.systemui.keyguard_wm_state_refactor";
    public static final String FLAG_LOCKSCREEN_FONT = "com.android.systemui.lockscreen_font";
    public static final String FLAG_LOW_LIGHT_CLOCK_DREAM = "com.android.systemui.low_light_clock_dream";
    public static final String FLAG_MAGNETIC_NOTIFICATION_SWIPES = "com.android.systemui.magnetic_notification_swipes";
    public static final String FLAG_MEDIA_CONTROLS_A11Y_COLORS = "com.android.systemui.media_controls_a11y_colors";
    public static final String FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3 = "com.android.systemui.media_controls_button_media3";
    public static final String FLAG_MEDIA_CONTROLS_BUTTON_MEDIA3_PLACEMENT = "com.android.systemui.media_controls_button_media3_placement";
    public static final String FLAG_MEDIA_CONTROLS_DEVICE_MANAGER_BACKGROUND_EXECUTION = "com.android.systemui.media_controls_device_manager_background_execution";
    public static final String FLAG_MEDIA_CONTROLS_DRAWABLES_REUSE_BUGFIX = "com.android.systemui.media_controls_drawables_reuse_bugfix";
    public static final String FLAG_MEDIA_CONTROLS_LOCKSCREEN_SHADE_BUG_FIX = "com.android.systemui.media_controls_lockscreen_shade_bug_fix";
    public static final String FLAG_MEDIA_CONTROLS_UI_UPDATE = "com.android.systemui.media_controls_ui_update";
    public static final String FLAG_MEDIA_CONTROLS_UMO_INFLATION_IN_BACKGROUND = "com.android.systemui.media_controls_umo_inflation_in_background";
    public static final String FLAG_MEDIA_CONTROLS_USER_INITIATED_DELETEINTENT = "com.android.systemui.media_controls_user_initiated_deleteintent";
    public static final String FLAG_MEDIA_LOAD_METADATA_VIA_MEDIA_DATA_LOADER = "com.android.systemui.media_load_metadata_via_media_data_loader";
    public static final String FLAG_MEDIA_LOCKSCREEN_LAUNCH_ANIMATION = "com.android.systemui.media_lockscreen_launch_animation";
    public static final String FLAG_MEDIA_PROJECTION_DIALOG_BEHIND_LOCKSCREEN = "com.android.systemui.media_projection_dialog_behind_lockscreen";
    public static final String FLAG_MEDIA_PROJECTION_GREY_ERROR_TEXT = "com.android.systemui.media_projection_grey_error_text";
    public static final String FLAG_MEDIA_PROJECTION_REQUEST_ATTRIBUTION_FIX = "com.android.systemui.media_projection_request_attribution_fix";
    public static final String FLAG_MODES_UI_DIALOG_PAGING = "com.android.systemui.modes_ui_dialog_paging";
    public static final String FLAG_MOVE_TRANSITION_ANIMATION_LAYER = "com.android.systemui.move_transition_animation_layer";
    public static final String FLAG_MSDL_FEEDBACK = "com.android.systemui.msdl_feedback";
    public static final String FLAG_MULTIUSER_WIFI_PICKER_TRACKER_SUPPORT = "com.android.systemui.multiuser_wifi_picker_tracker_support";
    public static final String FLAG_NEW_AOD_TRANSITION = "com.android.systemui.new_aod_transition";
    public static final String FLAG_NEW_VOLUME_PANEL = "com.android.systemui.new_volume_panel";
    public static final String FLAG_NON_TOUCHSCREEN_DEVICES_BYPASS_FALSING = "com.android.systemui.non_touchscreen_devices_bypass_falsing";
    public static final String FLAG_NOTES_ROLE_QS_TILE = "com.android.systemui.notes_role_qs_tile";
    public static final String FLAG_NOTIFICATIONS_BACKGROUND_ICONS = "com.android.systemui.notifications_background_icons";
    public static final String FLAG_NOTIFICATIONS_FOOTER_VISIBILITY_FIX = "com.android.systemui.notifications_footer_visibility_fix";
    public static final String FLAG_NOTIFICATIONS_HIDE_ON_DISPLAY_SWITCH = "com.android.systemui.notifications_hide_on_display_switch";
    public static final String FLAG_NOTIFICATIONS_HUN_SHARED_ANIMATION_VALUES = "com.android.systemui.notifications_hun_shared_animation_values";
    public static final String FLAG_NOTIFICATIONS_ICON_CONTAINER_REFACTOR = "com.android.systemui.notifications_icon_container_refactor";
    public static final String FLAG_NOTIFICATIONS_LAUNCH_RADIUS = "com.android.systemui.notifications_launch_radius";
    public static final String FLAG_NOTIFICATIONS_LIVE_DATA_STORE_REFACTOR = "com.android.systemui.notifications_live_data_store_refactor";
    public static final String FLAG_NOTIFICATIONS_PINNED_HUN_IN_SHADE = "com.android.systemui.notifications_pinned_hun_in_shade";
    public static final String FLAG_NOTIFICATIONS_REDESIGN_FOOTER_VIEW = "com.android.systemui.notifications_redesign_footer_view";
    public static final String FLAG_NOTIFICATIONS_REDESIGN_GUTS = "com.android.systemui.notifications_redesign_guts";
    public static final String FLAG_NOTIFICATION_ADD_X_ON_HOVER_TO_DISMISS = "com.android.systemui.notification_add_x_on_hover_to_dismiss";
    public static final String FLAG_NOTIFICATION_AMBIENT_SUPPRESSION_AFTER_INFLATION = "com.android.systemui.notification_ambient_suppression_after_inflation";
    public static final String FLAG_NOTIFICATION_ANIMATED_ACTIONS_TREATMENT = "com.android.systemui.notification_animated_actions_treatment";
    public static final String FLAG_NOTIFICATION_APPEAR_NONLINEAR = "com.android.systemui.notification_appear_nonlinear";
    public static final String FLAG_NOTIFICATION_ASYNC_GROUP_HEADER_INFLATION = "com.android.systemui.notification_async_group_header_inflation";
    public static final String FLAG_NOTIFICATION_ASYNC_HYBRID_VIEW_INFLATION = "com.android.systemui.notification_async_hybrid_view_inflation";
    public static final String FLAG_NOTIFICATION_AVALANCHE_SUPPRESSION = "com.android.systemui.notification_avalanche_suppression";
    public static final String FLAG_NOTIFICATION_AVALANCHE_THROTTLE_HUN = "com.android.systemui.notification_avalanche_throttle_hun";
    public static final String FLAG_NOTIFICATION_BACKGROUND_TINT_OPTIMIZATION = "com.android.systemui.notification_background_tint_optimization";
    public static final String FLAG_NOTIFICATION_BUNDLE_UI = "com.android.systemui.notification_bundle_ui";
    public static final String FLAG_NOTIFICATION_COLOR_UPDATE_LOGGER = "com.android.systemui.notification_color_update_logger";
    public static final String FLAG_NOTIFICATION_CONTENT_ALPHA_OPTIMIZATION = "com.android.systemui.notification_content_alpha_optimization";
    public static final String FLAG_NOTIFICATION_FOOTER_BACKGROUND_TINT_OPTIMIZATION = "com.android.systemui.notification_footer_background_tint_optimization";
    public static final String FLAG_NOTIFICATION_OVER_EXPANSION_CLIPPING_FIX = "com.android.systemui.notification_over_expansion_clipping_fix";
    public static final String FLAG_NOTIFICATION_REENTRANT_DISMISS = "com.android.systemui.notification_reentrant_dismiss";
    public static final String FLAG_NOTIFICATION_ROW_ACCESSIBILITY_EXPANDED = "com.android.systemui.notification_row_accessibility_expanded";
    public static final String FLAG_NOTIFICATION_ROW_CONTENT_BINDER_REFACTOR = "com.android.systemui.notification_row_content_binder_refactor";
    public static final String FLAG_NOTIFICATION_ROW_TRANSPARENCY = "com.android.systemui.notification_row_transparency";
    public static final String FLAG_NOTIFICATION_ROW_USER_CONTEXT = "com.android.systemui.notification_row_user_context";
    public static final String FLAG_NOTIFICATION_SHADE_BLUR = "com.android.systemui.notification_shade_blur";
    public static final String FLAG_NOTIFICATION_SHADE_UI_THREAD = "com.android.systemui.notification_shade_ui_thread";
    public static final String FLAG_NOTIFICATION_SKIP_SILENT_UPDATES = "com.android.systemui.notification_skip_silent_updates";
    public static final String FLAG_NOTIFICATION_TRANSPARENT_HEADER_FIX = "com.android.systemui.notification_transparent_header_fix";
    public static final String FLAG_NOTIFICATION_VIEW_FLIPPER_PAUSING_V2 = "com.android.systemui.notification_view_flipper_pausing_v2";
    public static final String FLAG_NOTIFY_PASSWORD_TEXT_VIEW_USER_ACTIVITY_IN_BACKGROUND = "com.android.systemui.notify_password_text_view_user_activity_in_background";
    public static final String FLAG_NOTIFY_POWER_MANAGER_USER_ACTIVITY_BACKGROUND = "com.android.systemui.notify_power_manager_user_activity_background";
    public static final String FLAG_ONLY_SHOW_MEDIA_STREAM_SLIDER_IN_SINGLE_VOLUME_MODE = "com.android.systemui.only_show_media_stream_slider_in_single_volume_mode";
    public static final String FLAG_OUTPUT_SWITCHER_REDESIGN = "com.android.systemui.output_switcher_redesign";
    public static final String FLAG_OVERRIDE_SUPPRESS_OVERLAY_CONDITION = "com.android.systemui.override_suppress_overlay_condition";
    public static final String FLAG_PERMISSION_HELPER_INLINE_UI_RICH_ONGOING = "com.android.systemui.permission_helper_inline_ui_rich_ongoing";
    public static final String FLAG_PERMISSION_HELPER_UI_RICH_ONGOING = "com.android.systemui.permission_helper_ui_rich_ongoing";
    public static final String FLAG_PHYSICAL_NOTIFICATION_MOVEMENT = "com.android.systemui.physical_notification_movement";
    public static final String FLAG_PIN_INPUT_FIELD_STYLED_FOCUS_STATE = "com.android.systemui.pin_input_field_styled_focus_state";
    public static final String FLAG_PREDICTIVE_BACK_ANIMATE_SHADE = "com.android.systemui.predictive_back_animate_shade";
    public static final String FLAG_PREDICTIVE_BACK_DELAY_WM_TRANSITION = "com.android.systemui.predictive_back_delay_wm_transition";
    public static final String FLAG_PRIORITY_PEOPLE_SECTION = "com.android.systemui.priority_people_section";
    public static final String FLAG_PROMOTE_NOTIFICATIONS_AUTOMATICALLY = "com.android.systemui.promote_notifications_automatically";
    public static final String FLAG_PSS_APP_SELECTOR_RECENTS_SPLIT_SCREEN = "com.android.systemui.pss_app_selector_recents_split_screen";
    public static final String FLAG_PSS_TASK_SWITCHER = "com.android.systemui.pss_task_switcher";
    public static final String FLAG_QS_CUSTOM_TILE_CLICK_GUARANTEED_BUG_FIX = "com.android.systemui.qs_custom_tile_click_guaranteed_bug_fix";
    public static final String FLAG_QS_NEW_TILES = "com.android.systemui.qs_new_tiles";
    public static final String FLAG_QS_NEW_TILES_FUTURE = "com.android.systemui.qs_new_tiles_future";
    public static final String FLAG_QS_QUICK_REBIND_ACTIVE_TILES = "com.android.systemui.qs_quick_rebind_active_tiles";
    public static final String FLAG_QS_REGISTER_SETTING_OBSERVER_ON_BG_THREAD = "com.android.systemui.qs_register_setting_observer_on_bg_thread";
    public static final String FLAG_QS_TILE_DETAILED_VIEW = "com.android.systemui.qs_tile_detailed_view";
    public static final String FLAG_QS_TILE_FOCUS_STATE = "com.android.systemui.qs_tile_focus_state";
    public static final String FLAG_QS_UI_REFACTOR = "com.android.systemui.qs_ui_refactor";
    public static final String FLAG_QS_UI_REFACTOR_COMPOSE_FRAGMENT = "com.android.systemui.qs_ui_refactor_compose_fragment";
    public static final String FLAG_RECORD_ISSUE_QS_TILE = "com.android.systemui.record_issue_qs_tile";
    public static final String FLAG_REDESIGN_MAGNIFICATION_WINDOW_SIZE = "com.android.systemui.redesign_magnification_window_size";
    public static final String FLAG_REFACTOR_GET_CURRENT_USER = "com.android.systemui.refactor_get_current_user";
    public static final String FLAG_REGISTER_BATTERY_CONTROLLER_RECEIVERS_IN_CORESTARTABLE = "com.android.systemui.register_battery_controller_receivers_in_corestartable";
    public static final String FLAG_REGISTER_CONTENT_OBSERVERS_ASYNC = "com.android.systemui.register_content_observers_async";
    public static final String FLAG_REGISTER_NEW_WALLET_CARD_IN_BACKGROUND = "com.android.systemui.register_new_wallet_card_in_background";
    public static final String FLAG_REGISTER_WALLPAPER_NOTIFIER_BACKGROUND = "com.android.systemui.register_wallpaper_notifier_background";
    public static final String FLAG_RELOCK_WITH_POWER_BUTTON_IMMEDIATELY = "com.android.systemui.relock_with_power_button_immediately";
    public static final String FLAG_REMOVE_DREAM_OVERLAY_HIDE_ON_TOUCH = "com.android.systemui.remove_dream_overlay_hide_on_touch";
    public static final String FLAG_REMOVE_UPDATE_LISTENER_IN_QS_ICON_VIEW_IMPL = "com.android.systemui.remove_update_listener_in_qs_icon_view_impl";
    public static final String FLAG_RESTART_DREAM_ON_UNOCCLUDE = "com.android.systemui.restart_dream_on_unocclude";
    public static final String FLAG_REST_TO_UNLOCK = "com.android.systemui.rest_to_unlock";
    public static final String FLAG_REVAMPED_BOUNCER_MESSAGES = "com.android.systemui.revamped_bouncer_messages";
    public static final String FLAG_RUN_FINGERPRINT_DETECT_ON_DISMISSIBLE_KEYGUARD = "com.android.systemui.run_fingerprint_detect_on_dismissible_keyguard";
    public static final String FLAG_SAVE_AND_RESTORE_MAGNIFICATION_SETTINGS_BUTTONS = "com.android.systemui.save_and_restore_magnification_settings_buttons";
    public static final String FLAG_SCENE_CONTAINER = "com.android.systemui.scene_container";
    public static final String FLAG_SCREENSHARE_NOTIFICATION_HIDING_BUG_FIX = "com.android.systemui.screenshare_notification_hiding_bug_fix";
    public static final String FLAG_SCREENSHOT_ACTION_DISMISS_SYSTEM_WINDOWS = "com.android.systemui.screenshot_action_dismiss_system_windows";
    public static final String FLAG_SCREENSHOT_MULTIDISPLAY_FOCUS_CHANGE = "com.android.systemui.screenshot_multidisplay_focus_change";
    public static final String FLAG_SCREENSHOT_POLICY_SPLIT_AND_DESKTOP_MODE = "com.android.systemui.screenshot_policy_split_and_desktop_mode";
    public static final String FLAG_SCREENSHOT_SCROLL_CROP_VIEW_CRASH_FIX = "com.android.systemui.screenshot_scroll_crop_view_crash_fix";
    public static final String FLAG_SCREENSHOT_UI_CONTROLLER_REFACTOR = "com.android.systemui.screenshot_ui_controller_refactor";
    public static final String FLAG_SECONDARY_USER_WIDGET_HOST = "com.android.systemui.secondary_user_widget_host";
    public static final String FLAG_SETTINGS_EXT_REGISTER_CONTENT_OBSERVER_ON_BG_THREAD = "com.android.systemui.settings_ext_register_content_observer_on_bg_thread";
    public static final String FLAG_SHADERLIB_LOADING_EFFECT_REFACTOR = "com.android.systemui.shaderlib_loading_effect_refactor";
    public static final String FLAG_SHADE_EXPANDS_ON_STATUS_BAR_LONG_PRESS = "com.android.systemui.shade_expands_on_status_bar_long_press";
    public static final String FLAG_SHADE_HEADER_FONT_UPDATE = "com.android.systemui.shade_header_font_update";
    public static final String FLAG_SHADE_LAUNCH_ACCESSIBILITY = "com.android.systemui.shade_launch_accessibility";
    public static final String FLAG_SHADE_WINDOW_GOES_AROUND = "com.android.systemui.shade_window_goes_around";
    public static final String FLAG_SHORTCUT_HELPER_KEY_GLYPH = "com.android.systemui.shortcut_helper_key_glyph";
    public static final String FLAG_SHOW_AUDIO_SHARING_SLIDER_IN_VOLUME_PANEL = "com.android.systemui.show_audio_sharing_slider_in_volume_panel";
    public static final String FLAG_SHOW_CLIPBOARD_INDICATION = "com.android.systemui.show_clipboard_indication";
    public static final String FLAG_SHOW_LOCKED_BY_YOUR_WATCH_KEYGUARD_INDICATOR = "com.android.systemui.show_locked_by_your_watch_keyguard_indicator";
    public static final String FLAG_SHOW_TOAST_WHEN_APP_CONTROL_BRIGHTNESS = "com.android.systemui.show_toast_when_app_control_brightness";
    public static final String FLAG_SIM_PIN_BOUNCER_RESET = "com.android.systemui.sim_pin_bouncer_reset";
    public static final String FLAG_SIM_PIN_RACE_CONDITION_ON_RESTART = "com.android.systemui.sim_pin_race_condition_on_restart";
    public static final String FLAG_SIM_PIN_USE_SLOT_ID = "com.android.systemui.sim_pin_use_slot_id";
    public static final String FLAG_SKIP_HIDE_SENSITIVE_NOTIF_ANIMATION = "com.android.systemui.skip_hide_sensitive_notif_animation";
    public static final String FLAG_SLICE_BROADCAST_RELAY_IN_BACKGROUND = "com.android.systemui.slice_broadcast_relay_in_background";
    public static final String FLAG_SLICE_MANAGER_BINDER_CALL_BACKGROUND = "com.android.systemui.slice_manager_binder_call_background";
    public static final String FLAG_SMARTSPACE_LOCKSCREEN_VIEWMODEL = "com.android.systemui.smartspace_lockscreen_viewmodel";
    public static final String FLAG_SMARTSPACE_RELOCATE_TO_BOTTOM = "com.android.systemui.smartspace_relocate_to_bottom";
    public static final String FLAG_SMARTSPACE_REMOTEVIEWS_RENDERING_FIX = "com.android.systemui.smartspace_remoteviews_rendering_fix";
    public static final String FLAG_SMARTSPACE_SWIPE_EVENT_LOGGING_FIX = "com.android.systemui.smartspace_swipe_event_logging_fix";
    public static final String FLAG_SMARTSPACE_VIEWPAGER2 = "com.android.systemui.smartspace_viewpager2";
    public static final String FLAG_SOUNDDOSE_CUSTOMIZATION = "com.android.systemui.sounddose_customization";
    public static final String FLAG_SPATIAL_MODEL_APP_PUSHBACK = "com.android.systemui.spatial_model_app_pushback";
    public static final String FLAG_STABILIZE_HEADS_UP_GROUP_V2 = "com.android.systemui.stabilize_heads_up_group_v2";
    public static final String FLAG_STATUS_BAR_ALWAYS_CHECK_UNDERLYING_NETWORKS = "com.android.systemui.status_bar_always_check_underlying_networks";
    public static final String FLAG_STATUS_BAR_AUTO_START_SCREEN_RECORD_CHIP = "com.android.systemui.status_bar_auto_start_screen_record_chip";
    public static final String FLAG_STATUS_BAR_CHIPS_MODERNIZATION = "com.android.systemui.status_bar_chips_modernization";
    public static final String FLAG_STATUS_BAR_CHIPS_RETURN_ANIMATIONS = "com.android.systemui.status_bar_chips_return_animations";
    public static final String FLAG_STATUS_BAR_FONT_UPDATES = "com.android.systemui.status_bar_font_updates";
    public static final String FLAG_STATUS_BAR_MOBILE_ICON_KAIROS = "com.android.systemui.status_bar_mobile_icon_kairos";
    public static final String FLAG_STATUS_BAR_MONOCHROME_ICONS_FIX = "com.android.systemui.status_bar_monochrome_icons_fix";
    public static final String FLAG_STATUS_BAR_NO_HUN_BEHAVIOR = "com.android.systemui.status_bar_no_hun_behavior";
    public static final String FLAG_STATUS_BAR_POPUP_CHIPS = "com.android.systemui.status_bar_popup_chips";
    public static final String FLAG_STATUS_BAR_ROOT_MODERNIZATION = "com.android.systemui.status_bar_root_modernization";
    public static final String FLAG_STATUS_BAR_SHOW_AUDIO_ONLY_PROJECTION_CHIP = "com.android.systemui.status_bar_show_audio_only_projection_chip";
    public static final String FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR = "com.android.systemui.status_bar_signal_policy_refactor";
    public static final String FLAG_STATUS_BAR_SIGNAL_POLICY_REFACTOR_ETHERNET = "com.android.systemui.status_bar_signal_policy_refactor_ethernet";
    public static final String FLAG_STATUS_BAR_STATIC_INOUT_INDICATORS = "com.android.systemui.status_bar_static_inout_indicators";
    public static final String FLAG_STATUS_BAR_STOP_UPDATING_WINDOW_HEIGHT = "com.android.systemui.status_bar_stop_updating_window_height";
    public static final String FLAG_STATUS_BAR_SWIPE_OVER_CHIP = "com.android.systemui.status_bar_swipe_over_chip";
    public static final String FLAG_STATUS_BAR_SWITCH_TO_SPN_FROM_DATA_SPN = "com.android.systemui.status_bar_switch_to_spn_from_data_spn";
    public static final String FLAG_STATUS_BAR_UI_THREAD = "com.android.systemui.status_bar_ui_thread";
    public static final String FLAG_STATUS_BAR_WINDOW_NO_CUSTOM_TOUCH = "com.android.systemui.status_bar_window_no_custom_touch";
    public static final String FLAG_STOPPABLE_FGS_SYSTEM_APP = "com.android.systemui.stoppable_fgs_system_app";
    public static final String FLAG_SWITCH_USER_ON_BG = "com.android.systemui.switch_user_on_bg";
    public static final String FLAG_SYSUI_TEAMFOOD = "com.android.systemui.sysui_teamfood";
    public static final String FLAG_THEME_OVERLAY_CONTROLLER_WAKEFULNESS_DEPRECATION = "com.android.systemui.theme_overlay_controller_wakefulness_deprecation";
    public static final String FLAG_TRANSITION_RACE_CONDITION = "com.android.systemui.transition_race_condition";
    public static final String FLAG_TRANSLUCENT_OCCLUDING_ACTIVITY_FIX = "com.android.systemui.translucent_occluding_activity_fix";
    public static final String FLAG_TV_GLOBAL_ACTIONS_FOCUS = "com.android.systemui.tv_global_actions_focus";
    public static final String FLAG_UDFPS_VIEW_PERFORMANCE = "com.android.systemui.udfps_view_performance";
    public static final String FLAG_UNFOLD_ANIMATION_BACKGROUND_PROGRESS = "com.android.systemui.unfold_animation_background_progress";
    public static final String FLAG_UNFOLD_LATENCY_TRACKING_FIX = "com.android.systemui.unfold_latency_tracking_fix";
    public static final String FLAG_UPDATE_CORNER_RADIUS_ON_DISPLAY_CHANGED = "com.android.systemui.update_corner_radius_on_display_changed";
    public static final String FLAG_UPDATE_USER_SWITCHER_BACKGROUND = "com.android.systemui.update_user_switcher_background";
    public static final String FLAG_UPDATE_WINDOW_MAGNIFIER_BOTTOM_BOUNDARY = "com.android.systemui.update_window_magnifier_bottom_boundary";
    public static final String FLAG_USER_AWARE_SETTINGS_REPOSITORIES = "com.android.systemui.user_aware_settings_repositories";
    public static final String FLAG_USER_ENCRYPTED_SOURCE = "com.android.systemui.user_encrypted_source";
    public static final String FLAG_USER_SWITCHER_ADD_SIGN_OUT_OPTION = "com.android.systemui.user_switcher_add_sign_out_option";
    public static final String FLAG_USE_AAD_PROX_SENSOR = "com.android.systemui.use_aad_prox_sensor";
    public static final String FLAG_USE_NOTIF_INFLATION_THREAD_FOR_FOOTER = "com.android.systemui.use_notif_inflation_thread_for_footer";
    public static final String FLAG_USE_NOTIF_INFLATION_THREAD_FOR_ROW = "com.android.systemui.use_notif_inflation_thread_for_row";
    public static final String FLAG_USE_TRANSITIONS_FOR_KEYGUARD_OCCLUDED = "com.android.systemui.use_transitions_for_keyguard_occluded";
    public static final String FLAG_USE_VOLUME_CONTROLLER = "com.android.systemui.use_volume_controller";
    public static final String FLAG_VISUAL_INTERRUPTIONS_REFACTOR = "com.android.systemui.visual_interruptions_refactor";
    public static final String FLAG_VOLUME_REDESIGN = "com.android.systemui.volume_redesign";

    public Flags() {
    }

    public static boolean activityTransitionUseLargestWindow() {
        return true;
    }

    public static boolean addBlackBackgroundForWindowMagnifier() {
        return true;
    }

    public static boolean alwaysComposeQsUiFragment() {
        return false;
    }

    public static boolean ambientTouchMonitorListenToDisplayChanges() {
        return true;
    }

    public static boolean appClipsBacklinks() {
        return true;
    }

    public static boolean appShortcutRemovalFix() {
        return true;
    }

    public static boolean avalancheReplaceHunWhenCritical() {
        return false;
    }

    public static boolean bindKeyguardMediaVisibility() {
        return true;
    }

    public static boolean bouncerUiRevamp() {
        return false;
    }

    public static boolean bouncerUiRevamp2() {
        return false;
    }

    public static boolean bpColors() {
        return false;
    }

    public static boolean brightnessSliderFocusState() {
        return false;
    }

    public static boolean checkLockscreenGoneTransition() {
        return true;
    }

    public static boolean classicFlagsMultiUser() {
        return true;
    }

    public static boolean clipboardImageTimeout() {
        return true;
    }

    public static boolean clipboardNoninteractiveOnLockscreen() {
        return true;
    }

    public static boolean clipboardOverlayMultiuser() {
        return false;
    }

    public static boolean clipboardSharedTransitions() {
        return true;
    }

    public static boolean clipboardUseDescriptionMimetype() {
        return true;
    }

    public static boolean clockFidgetAnimation() {
        return false;
    }

    public static boolean communalBouncerDoNotModifyPluginOpen() {
        return true;
    }

    public static boolean communalEditWidgetsActivityFinishFix() {
        return true;
    }

    public static boolean communalHub() {
        return true;
    }

    public static boolean communalHubUseThreadPoolForWidgets() {
        return true;
    }

    public static boolean communalResponsiveGrid() {
        return false;
    }

    public static boolean communalSceneKtfRefactor() {
        return true;
    }

    public static boolean communalStandaloneSupport() {
        return false;
    }

    public static boolean communalTimerFlickerFix() {
        return true;
    }

    public static boolean communalWidgetResizing() {
        return true;
    }

    public static boolean communalWidgetTrampolineFix() {
        return true;
    }

    public static boolean composeBouncer() {
        return false;
    }

    public static boolean confineNotificationTouchToViewWidth() {
        return false;
    }

    public static boolean contAuthPlugin() {
        return false;
    }

    public static boolean contextualTipsAssistantDismissFix() {
        return true;
    }

    public static boolean coroutineTracing() {
        return false;
    }

    public static boolean createWindowlessWindowMagnifier() {
        return true;
    }

    public static boolean debugLiveUpdatesPromoteAll() {
        return false;
    }

    public static boolean decoupleViewControllerInAnimlib() {
        return false;
    }

    public static boolean delayShowMagnificationButton() {
        return true;
    }

    public static boolean desktopEffectsQsTile() {
        return false;
    }

    public static boolean deviceEntryUdfpsRefactor() {
        return true;
    }

    public static boolean disableBlurredShadeVisible() {
        return false;
    }

    public static boolean disableContextualTipsFrequencyCheck() {
        return false;
    }

    public static boolean disableContextualTipsIosSwitcherCheck() {
        return false;
    }

    public static boolean disableShadeTrackpadTwoFingerSwipe() {
        return false;
    }

    public static boolean doubleTapToSleep() {
        return true;
    }

    public static boolean dreamInputSessionPilferOnce() {
        return true;
    }

    public static boolean dreamOverlayBouncerSwipeDirectionFiltering() {
        return true;
    }

    public static boolean dreamOverlayUpdatedFont() {
        return false;
    }

    public static boolean edgeBackGestureHandlerThread() {
        return false;
    }

    public static boolean edgebackGestureHandlerGetRunningTasksBackground() {
        return true;
    }

    public static boolean enableBackgroundKeyguardOndrawnCallback() {
        return true;
    }

    public static boolean enableContextualTipForMuteVolume() {
        return true;
    }

    public static boolean enableContextualTipForPowerOff() {
        return true;
    }

    public static boolean enableContextualTipForTakeScreenshot() {
        return true;
    }

    public static boolean enableContextualTips() {
        return true;
    }

    public static boolean enableEfficientDisplayRepository() {
        return true;
    }

    public static boolean enableLayoutTracing() {
        return false;
    }

    public static boolean enableUnderlay() {
        return false;
    }

    public static boolean enableViewCaptureTracing() {
        return false;
    }

    public static boolean enforceBrightnessBaseUserRestriction() {
        return true;
    }

    public static boolean exampleFlag() {
        return false;
    }

    public static boolean expandCollapsePrivacyDialog() {
        return true;
    }

    public static boolean expandHeadsUpOnInlineReply() {
        return true;
    }

    public static boolean expandedPrivacyIndicatorsOnLargeScreen() {
        return false;
    }

    public static boolean extendedAppsShortcutCategory() {
        return false;
    }

    public static boolean faceMessageDeferUpdate() {
        return true;
    }

    public static boolean faceScanningAnimationNpeFix() {
        return true;
    }

    public static boolean fasterUnlockTransition() {
        return true;
    }

    public static boolean fetchBookmarksXmlKeyboardShortcuts() {
        return true;
    }

    public static boolean fixImageWallpaperCrashSurfaceAlreadyReleased() {
        return true;
    }

    public static boolean fixScreenshotActionDismissSystemWindows() {
        return true;
    }

    public static boolean floatingMenuAnimatedTuck() {
        return false;
    }

    public static boolean floatingMenuDisplayCutoutSupport() {
        return true;
    }

    public static boolean floatingMenuDragToEdit() {
        return true;
    }

    public static boolean floatingMenuDragToHide() {
        return false;
    }

    public static boolean floatingMenuHearingDeviceStatusIcon() {
        return false;
    }

    public static boolean floatingMenuImeDisplacementAnimation() {
        return false;
    }

    public static boolean floatingMenuNarrowTargetContentObserver() {
        return true;
    }

    public static boolean floatingMenuNotifyTargetsChangedOnStrictDiff() {
        return true;
    }

    public static boolean floatingMenuOverlapsNavBarsFlag() {
        return false;
    }

    public static boolean floatingMenuRadiiAnimation() {
        return false;
    }

    public static boolean getConnectedDeviceNameUnsynchronized() {
        return true;
    }

    public static boolean glanceableHubAllowKeyguardWhenDreaming() {
        return false;
    }

    public static boolean glanceableHubBlurredBackground() {
        return false;
    }

    public static boolean glanceableHubDirectEditMode() {
        return false;
    }

    public static boolean glanceableHubV2() {
        return false;
    }

    public static boolean glanceableHubV2Resources() {
        return false;
    }

    public static boolean hapticsForComposeSliders() {
        return true;
    }

    public static boolean hardwareColorStyles() {
        return false;
    }

    public static boolean hearingAidsQsTileDialog() {
        return true;
    }

    public static boolean hearingDevicesDialogRelatedTools() {
        return true;
    }

    public static boolean hideRingerButtonInSingleVolumeMode() {
        return false;
    }

    public static boolean homeControlsDreamHsum() {
        return true;
    }

    public static boolean hubEditModeTouchAdjustments() {
        return false;
    }

    public static boolean hubmodeFullscreenVerticalSwipe() {
        return false;
    }

    public static boolean hubmodeFullscreenVerticalSwipeFix() {
        return true;
    }

    public static boolean iconRefresh2025() {
        return false;
    }

    public static boolean ignoreTouchesNextToNotificationShelf() {
        return true;
    }

    public static boolean indicationTextA11yFix() {
        return true;
    }

    public static boolean keyboardDockingIndicator() {
        return false;
    }

    public static boolean keyboardShortcutHelperRewrite() {
        return true;
    }

    public static boolean keyboardShortcutHelperShortcutCustomizer() {
        return true;
    }

    public static boolean keyboardTouchpadContextualEducation() {
        return true;
    }

    public static boolean keyguardTransitionForceFinishOnScreenOff() {
        return false;
    }

    public static boolean keyguardWmReorderAtmsCalls() {
        return true;
    }

    public static boolean keyguardWmStateRefactor() {
        return false;
    }

    public static boolean lockscreenFont() {
        return false;
    }

    public static boolean lowLightClockDream() {
        return false;
    }

    public static boolean magneticNotificationSwipes() {
        return false;
    }

    public static boolean mediaControlsA11yColors() {
        return true;
    }

    public static boolean mediaControlsButtonMedia3() {
        return false;
    }

    public static boolean mediaControlsButtonMedia3Placement() {
        return false;
    }

    public static boolean mediaControlsDeviceManagerBackgroundExecution() {
        return false;
    }

    public static boolean mediaControlsDrawablesReuseBugfix() {
        return true;
    }

    public static boolean mediaControlsLockscreenShadeBugFix() {
        return true;
    }

    public static boolean mediaControlsUiUpdate() {
        return false;
    }

    public static boolean mediaControlsUmoInflationInBackground() {
        return true;
    }

    public static boolean mediaControlsUserInitiatedDeleteintent() {
        return true;
    }

    public static boolean mediaLoadMetadataViaMediaDataLoader() {
        return true;
    }

    public static boolean mediaLockscreenLaunchAnimation() {
        return true;
    }

    public static boolean mediaProjectionDialogBehindLockscreen() {
        return true;
    }

    public static boolean mediaProjectionGreyErrorText() {
        return true;
    }

    public static boolean mediaProjectionRequestAttributionFix() {
        return false;
    }

    public static boolean modesUiDialogPaging() {
        return false;
    }

    public static boolean moveTransitionAnimationLayer() {
        return false;
    }

    public static boolean msdlFeedback() {
        return false;
    }

    public static boolean multiuserWifiPickerTrackerSupport() {
        return false;
    }

    public static boolean newAodTransition() {
        return true;
    }

    public static boolean newVolumePanel() {
        return true;
    }

    public static boolean nonTouchscreenDevicesBypassFalsing() {
        return false;
    }

    public static boolean notesRoleQsTile() {
        return false;
    }

    public static boolean notificationAddXOnHoverToDismiss() {
        return false;
    }

    public static boolean notificationAmbientSuppressionAfterInflation() {
        return false;
    }

    public static boolean notificationAnimatedActionsTreatment() {
        return false;
    }

    public static boolean notificationAppearNonlinear() {
        return true;
    }

    public static boolean notificationAsyncGroupHeaderInflation() {
        return true;
    }

    public static boolean notificationAsyncHybridViewInflation() {
        return true;
    }

    public static boolean notificationAvalancheSuppression() {
        return true;
    }

    public static boolean notificationAvalancheThrottleHun() {
        return true;
    }

    public static boolean notificationBackgroundTintOptimization() {
        return true;
    }

    public static boolean notificationBundleUi() {
        return false;
    }

    public static boolean notificationColorUpdateLogger() {
        return false;
    }

    public static boolean notificationContentAlphaOptimization() {
        return false;
    }

    public static boolean notificationFooterBackgroundTintOptimization() {
        return false;
    }

    public static boolean notificationOverExpansionClippingFix() {
        return true;
    }

    public static boolean notificationReentrantDismiss() {
        return true;
    }

    public static boolean notificationRowAccessibilityExpanded() {
        return true;
    }

    public static boolean notificationRowContentBinderRefactor() {
        return true;
    }

    public static boolean notificationRowTransparency() {
        return false;
    }

    public static boolean notificationRowUserContext() {
        return true;
    }

    public static boolean notificationShadeBlur() {
        return false;
    }

    public static boolean notificationShadeUiThread() {
        return false;
    }

    public static boolean notificationSkipSilentUpdates() {
        return false;
    }

    public static boolean notificationTransparentHeaderFix() {
        return true;
    }

    public static boolean notificationViewFlipperPausingV2() {
        return true;
    }

    public static boolean notificationsBackgroundIcons() {
        return true;
    }

    public static boolean notificationsFooterVisibilityFix() {
        return true;
    }

    public static boolean notificationsHideOnDisplaySwitch() {
        return false;
    }

    public static boolean notificationsHunSharedAnimationValues() {
        return false;
    }

    public static boolean notificationsIconContainerRefactor() {
        return true;
    }

    public static boolean notificationsLaunchRadius() {
        return false;
    }

    public static boolean notificationsLiveDataStoreRefactor() {
        return true;
    }

    public static boolean notificationsPinnedHunInShade() {
        return true;
    }

    public static boolean notificationsRedesignFooterView() {
        return false;
    }

    public static boolean notificationsRedesignGuts() {
        return false;
    }

    public static boolean notifyPasswordTextViewUserActivityInBackground() {
        return true;
    }

    public static boolean notifyPowerManagerUserActivityBackground() {
        return true;
    }

    public static boolean onlyShowMediaStreamSliderInSingleVolumeMode() {
        return true;
    }

    public static boolean outputSwitcherRedesign() {
        return false;
    }

    public static boolean overrideSuppressOverlayCondition() {
        return false;
    }

    public static boolean permissionHelperInlineUiRichOngoing() {
        return false;
    }

    public static boolean permissionHelperUiRichOngoing() {
        return false;
    }

    public static boolean physicalNotificationMovement() {
        return false;
    }

    public static boolean pinInputFieldStyledFocusState() {
        return true;
    }

    public static boolean predictiveBackAnimateShade() {
        return false;
    }

    public static boolean predictiveBackDelayWmTransition() {
        return false;
    }

    public static boolean priorityPeopleSection() {
        return true;
    }

    public static boolean promoteNotificationsAutomatically() {
        return false;
    }

    public static boolean pssAppSelectorRecentsSplitScreen() {
        return true;
    }

    public static boolean pssTaskSwitcher() {
        return false;
    }

    public static boolean qsCustomTileClickGuaranteedBugFix() {
        return true;
    }

    public static boolean qsNewTiles() {
        return false;
    }

    public static boolean qsNewTilesFuture() {
        return false;
    }

    public static boolean qsQuickRebindActiveTiles() {
        return false;
    }

    public static boolean qsRegisterSettingObserverOnBgThread() {
        return true;
    }

    public static boolean qsTileDetailedView() {
        return false;
    }

    public static boolean qsTileFocusState() {
        return true;
    }

    public static boolean qsUiRefactor() {
        return false;
    }

    public static boolean qsUiRefactorComposeFragment() {
        return false;
    }

    public static boolean recordIssueQsTile() {
        return true;
    }

    public static boolean redesignMagnificationWindowSize() {
        return false;
    }

    public static boolean refactorGetCurrentUser() {
        return true;
    }

    public static boolean registerBatteryControllerReceiversInCorestartable() {
        return false;
    }

    public static boolean registerContentObserversAsync() {
        return true;
    }

    public static boolean registerNewWalletCardInBackground() {
        return true;
    }

    public static boolean registerWallpaperNotifierBackground() {
        return true;
    }

    public static boolean relockWithPowerButtonImmediately() {
        return true;
    }

    public static boolean removeDreamOverlayHideOnTouch() {
        return true;
    }

    public static boolean removeUpdateListenerInQsIconViewImpl() {
        return true;
    }

    public static boolean restToUnlock() {
        return false;
    }

    public static boolean restartDreamOnUnocclude() {
        return false;
    }

    public static boolean revampedBouncerMessages() {
        return true;
    }

    public static boolean runFingerprintDetectOnDismissibleKeyguard() {
        return false;
    }

    public static boolean saveAndRestoreMagnificationSettingsButtons() {
        return true;
    }

    public static boolean sceneContainer() {
        return false;
    }

    public static boolean screenshareNotificationHidingBugFix() {
        return true;
    }

    public static boolean screenshotActionDismissSystemWindows() {
        return false;
    }

    public static boolean screenshotMultidisplayFocusChange() {
        return false;
    }

    public static boolean screenshotPolicySplitAndDesktopMode() {
        return true;
    }

    public static boolean screenshotScrollCropViewCrashFix() {
        return true;
    }

    public static boolean screenshotUiControllerRefactor() {
        return true;
    }

    public static boolean secondaryUserWidgetHost() {
        return false;
    }

    public static boolean settingsExtRegisterContentObserverOnBgThread() {
        return true;
    }

    public static boolean shadeExpandsOnStatusBarLongPress() {
        return false;
    }

    public static boolean shadeHeaderFontUpdate() {
        return false;
    }

    public static boolean shadeLaunchAccessibility() {
        return true;
    }

    public static boolean shadeWindowGoesAround() {
        return false;
    }

    public static boolean shaderlibLoadingEffectRefactor() {
        return true;
    }

    public static boolean shortcutHelperKeyGlyph() {
        return true;
    }

    public static boolean showAudioSharingSliderInVolumePanel() {
        return false;
    }

    public static boolean showClipboardIndication() {
        return false;
    }

    public static boolean showLockedByYourWatchKeyguardIndicator() {
        return false;
    }

    public static boolean showToastWhenAppControlBrightness() {
        return true;
    }

    public static boolean simPinBouncerReset() {
        return true;
    }

    public static boolean simPinRaceConditionOnRestart() {
        return true;
    }

    public static boolean simPinUseSlotId() {
        return true;
    }

    public static boolean skipHideSensitiveNotifAnimation() {
        return true;
    }

    public static boolean sliceBroadcastRelayInBackground() {
        return true;
    }

    public static boolean sliceManagerBinderCallBackground() {
        return true;
    }

    public static boolean smartspaceLockscreenViewmodel() {
        return true;
    }

    public static boolean smartspaceRelocateToBottom() {
        return false;
    }

    public static boolean smartspaceRemoteviewsRenderingFix() {
        return true;
    }

    public static boolean smartspaceSwipeEventLoggingFix() {
        return true;
    }

    public static boolean smartspaceViewpager2() {
        return false;
    }

    public static boolean sounddoseCustomization() {
        return true;
    }

    public static boolean spatialModelAppPushback() {
        return false;
    }

    public static boolean stabilizeHeadsUpGroupV2() {
        return true;
    }

    public static boolean statusBarAlwaysCheckUnderlyingNetworks() {
        return true;
    }

    public static boolean statusBarAutoStartScreenRecordChip() {
        return true;
    }

    public static boolean statusBarChipsModernization() {
        return false;
    }

    public static boolean statusBarChipsReturnAnimations() {
        return false;
    }

    public static boolean statusBarFontUpdates() {
        return false;
    }

    public static boolean statusBarMobileIconKairos() {
        return false;
    }

    public static boolean statusBarMonochromeIconsFix() {
        return true;
    }

    public static boolean statusBarNoHunBehavior() {
        return false;
    }

    public static boolean statusBarPopupChips() {
        return false;
    }

    public static boolean statusBarRootModernization() {
        return false;
    }

    public static boolean statusBarShowAudioOnlyProjectionChip() {
        return true;
    }

    public static boolean statusBarSignalPolicyRefactor() {
        return true;
    }

    public static boolean statusBarSignalPolicyRefactorEthernet() {
        return true;
    }

    public static boolean statusBarStaticInoutIndicators() {
        return false;
    }

    public static boolean statusBarStopUpdatingWindowHeight() {
        return false;
    }

    public static boolean statusBarSwipeOverChip() {
        return false;
    }

    public static boolean statusBarSwitchToSpnFromDataSpn() {
        return true;
    }

    public static boolean statusBarUiThread() {
        return false;
    }

    public static boolean statusBarWindowNoCustomTouch() {
        return false;
    }

    public static boolean stoppableFgsSystemApp() {
        return true;
    }

    public static boolean switchUserOnBg() {
        return true;
    }

    public static boolean sysuiTeamfood() {
        return false;
    }

    public static boolean themeOverlayControllerWakefulnessDeprecation() {
        return false;
    }

    public static boolean transitionRaceCondition() {
        return true;
    }

    public static boolean translucentOccludingActivityFix() {
        return true;
    }

    public static boolean tvGlobalActionsFocus() {
        return false;
    }

    public static boolean udfpsViewPerformance() {
        return true;
    }

    public static boolean unfoldAnimationBackgroundProgress() {
        return true;
    }

    public static boolean unfoldLatencyTrackingFix() {
        return false;
    }

    public static boolean updateCornerRadiusOnDisplayChanged() {
        return true;
    }

    public static boolean updateUserSwitcherBackground() {
        return true;
    }

    public static boolean updateWindowMagnifierBottomBoundary() {
        return false;
    }

    public static boolean useAadProxSensor() {
        return false;
    }

    public static boolean useNotifInflationThreadForFooter() {
        return true;
    }

    public static boolean useNotifInflationThreadForRow() {
        return true;
    }

    public static boolean useTransitionsForKeyguardOccluded() {
        return true;
    }

    public static boolean useVolumeController() {
        return true;
    }

    public static boolean userAwareSettingsRepositories() {
        return true;
    }

    public static boolean userEncryptedSource() {
        return true;
    }

    public static boolean userSwitcherAddSignOutOption() {
        return false;
    }

    public static boolean visualInterruptionsRefactor() {
        return true;
    }

    public static boolean volumeRedesign() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
