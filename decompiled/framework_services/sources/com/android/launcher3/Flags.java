package com.android.launcher3;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ACCESSIBILITY_SCROLL_ON_ALLAPPS = "com.android.launcher3.accessibility_scroll_on_allapps";
    public static final String FLAG_ALL_APPS_BLUR = "com.android.launcher3.all_apps_blur";
    public static final String FLAG_ALL_APPS_SHEET_FOR_HANDHELD = "com.android.launcher3.all_apps_sheet_for_handheld";
    public static final String FLAG_COORDINATE_WORKSPACE_SCALE = "com.android.launcher3.coordinate_workspace_scale";
    public static final String FLAG_ENABLED_FOLDERS_IN_ALL_APPS = "com.android.launcher3.enabled_folders_in_all_apps";
    public static final String FLAG_ENABLE_ACTIVE_GESTURE_PROTO_LOG = "com.android.launcher3.enable_active_gesture_proto_log";
    public static final String FLAG_ENABLE_ADDITIONAL_HOME_ANIMATIONS = "com.android.launcher3.enable_additional_home_animations";
    public static final String FLAG_ENABLE_ADD_APP_WIDGET_VIA_CONFIG_ACTIVITY_V2 = "com.android.launcher3.enable_add_app_widget_via_config_activity_v2";
    public static final String FLAG_ENABLE_ALL_APPS_BUTTON_IN_HOTSEAT = "com.android.launcher3.enable_all_apps_button_in_hotseat";
    public static final String FLAG_ENABLE_ALT_TAB_KQS_FLATENNING = "com.android.launcher3.enable_alt_tab_kqs_flatenning";
    public static final String FLAG_ENABLE_ALT_TAB_KQS_ON_CONNECTED_DISPLAYS = "com.android.launcher3.enable_alt_tab_kqs_on_connected_displays";
    public static final String FLAG_ENABLE_CATEGORIZED_WIDGET_SUGGESTIONS = "com.android.launcher3.enable_categorized_widget_suggestions";
    public static final String FLAG_ENABLE_CONTAINER_RETURN_ANIMATIONS = "com.android.launcher3.enable_container_return_animations";
    public static final String FLAG_ENABLE_CONTRAST_TILES = "com.android.launcher3.enable_contrast_tiles";
    public static final String FLAG_ENABLE_CURSOR_HOVER_STATES = "com.android.launcher3.enable_cursor_hover_states";
    public static final String FLAG_ENABLE_DESKTOP_EXPLODED_VIEW = "com.android.launcher3.enable_desktop_exploded_view";
    public static final String FLAG_ENABLE_DESKTOP_TASK_ALPHA_ANIMATION = "com.android.launcher3.enable_desktop_task_alpha_animation";
    public static final String FLAG_ENABLE_DESKTOP_WINDOWING_CAROUSEL_DETACH = "com.android.launcher3.enable_desktop_windowing_carousel_detach";
    public static final String FLAG_ENABLE_DISMISS_PREDICTION_UNDO = "com.android.launcher3.enable_dismiss_prediction_undo";
    public static final String FLAG_ENABLE_EXPANDING_PAUSE_WORK_BUTTON = "com.android.launcher3.enable_expanding_pause_work_button";
    public static final String FLAG_ENABLE_EXPRESSIVE_DISMISS_TASK_MOTION = "com.android.launcher3.enable_expressive_dismiss_task_motion";
    public static final String FLAG_ENABLE_FALLBACK_OVERVIEW_IN_WINDOW = "com.android.launcher3.enable_fallback_overview_in_window";
    public static final String FLAG_ENABLE_FIRST_SCREEN_BROADCAST_ARCHIVING_EXTRAS = "com.android.launcher3.enable_first_screen_broadcast_archiving_extras";
    public static final String FLAG_ENABLE_FOCUS_OUTLINE = "com.android.launcher3.enable_focus_outline";
    public static final String FLAG_ENABLE_GENERATED_PREVIEWS = "com.android.launcher3.enable_generated_previews";
    public static final String FLAG_ENABLE_GESTURE_NAV_HORIZONTAL_TOUCH_SLOP = "com.android.launcher3.enable_gesture_nav_horizontal_touch_slop";
    public static final String FLAG_ENABLE_GESTURE_NAV_ON_CONNECTED_DISPLAYS = "com.android.launcher3.enable_gesture_nav_on_connected_displays";
    public static final String FLAG_ENABLE_GRID_MIGRATION_FIX = "com.android.launcher3.enable_grid_migration_fix";
    public static final String FLAG_ENABLE_GRID_ONLY_OVERVIEW = "com.android.launcher3.enable_grid_only_overview";
    public static final String FLAG_ENABLE_GROWTH_NUDGE = "com.android.launcher3.enable_growth_nudge";
    public static final String FLAG_ENABLE_HANDLE_DELAYED_GESTURE_CALLBACKS = "com.android.launcher3.enable_handle_delayed_gesture_callbacks";
    public static final String FLAG_ENABLE_HOME_TRANSITION_LISTENER = "com.android.launcher3.enable_home_transition_listener";
    public static final String FLAG_ENABLE_HOVER_OF_CHILD_ELEMENTS_IN_TASKVIEW = "com.android.launcher3.enable_hover_of_child_elements_in_taskview";
    public static final String FLAG_ENABLE_LARGE_DESKTOP_WINDOWING_TILE = "com.android.launcher3.enable_large_desktop_windowing_tile";
    public static final String FLAG_ENABLE_LAUNCHER_BR_METRICS_FIXED = "com.android.launcher3.enable_launcher_br_metrics_fixed";
    public static final String FLAG_ENABLE_LAUNCHER_ICON_SHAPES = "com.android.launcher3.enable_launcher_icon_shapes";
    public static final String FLAG_ENABLE_LAUNCHER_OVERVIEW_IN_WINDOW = "com.android.launcher3.enable_launcher_overview_in_window";
    public static final String FLAG_ENABLE_LAUNCHER_VISUAL_REFRESH = "com.android.launcher3.enable_launcher_visual_refresh";
    public static final String FLAG_ENABLE_MOUSE_INTERACTION_CHANGES = "com.android.launcher3.enable_mouse_interaction_changes";
    public static final String FLAG_ENABLE_MULTI_INSTANCE_MENU_TASKBAR = "com.android.launcher3.enable_multi_instance_menu_taskbar";
    public static final String FLAG_ENABLE_NARROW_GRID_RESTORE = "com.android.launcher3.enable_narrow_grid_restore";
    public static final String FLAG_ENABLE_OVERVIEW_BACKGROUND_WALLPAPER_BLUR = "com.android.launcher3.enable_overview_background_wallpaper_blur";
    public static final String FLAG_ENABLE_OVERVIEW_COMMAND_HELPER_TIMEOUT = "com.android.launcher3.enable_overview_command_helper_timeout";
    public static final String FLAG_ENABLE_OVERVIEW_DESKTOP_TILE_WALLPAPER_BACKGROUND = "com.android.launcher3.enable_overview_desktop_tile_wallpaper_background";
    public static final String FLAG_ENABLE_OVERVIEW_ICON_MENU = "com.android.launcher3.enable_overview_icon_menu";
    public static final String FLAG_ENABLE_OVERVIEW_ON_CONNECTED_DISPLAYS = "com.android.launcher3.enable_overview_on_connected_displays";
    public static final String FLAG_ENABLE_PINNING_APP_WITH_CONTEXT_MENU = "com.android.launcher3.enable_pinning_app_with_context_menu";
    public static final String FLAG_ENABLE_PREDICTIVE_BACK_GESTURE = "com.android.launcher3.enable_predictive_back_gesture";
    public static final String FLAG_ENABLE_PRIVATE_SPACE = "com.android.launcher3.enable_private_space";
    public static final String FLAG_ENABLE_PRIVATE_SPACE_INSTALL_SHORTCUT = "com.android.launcher3.enable_private_space_install_shortcut";
    public static final String FLAG_ENABLE_REBOOT_UNLOCK_ANIMATION = "com.android.launcher3.enable_reboot_unlock_animation";
    public static final String FLAG_ENABLE_RECENTS_IN_TASKBAR = "com.android.launcher3.enable_recents_in_taskbar";
    public static final String FLAG_ENABLE_RECENTS_WINDOW_PROTO_LOG = "com.android.launcher3.enable_recents_window_proto_log";
    public static final String FLAG_ENABLE_REFACTOR_TASK_THUMBNAIL = "com.android.launcher3.enable_refactor_task_thumbnail";
    public static final String FLAG_ENABLE_RESPONSIVE_WORKSPACE = "com.android.launcher3.enable_responsive_workspace";
    public static final String FLAG_ENABLE_SCALABILITY_FOR_DESKTOP_EXPERIENCE = "com.android.launcher3.enable_scalability_for_desktop_experience";
    public static final String FLAG_ENABLE_SCALING_REVEAL_HOME_ANIMATION = "com.android.launcher3.enable_scaling_reveal_home_animation";
    public static final String FLAG_ENABLE_SEPARATE_EXTERNAL_DISPLAY_TASKS = "com.android.launcher3.enable_separate_external_display_tasks";
    public static final String FLAG_ENABLE_SHORTCUT_DONT_SUGGEST_APP = "com.android.launcher3.enable_shortcut_dont_suggest_app";
    public static final String FLAG_ENABLE_SHOW_ENABLED_SHORTCUTS_IN_ACCESSIBILITY_MENU = "com.android.launcher3.enable_show_enabled_shortcuts_in_accessibility_menu";
    public static final String FLAG_ENABLE_SMARTSPACE_AS_A_WIDGET = "com.android.launcher3.enable_smartspace_as_a_widget";
    public static final String FLAG_ENABLE_SMARTSPACE_REMOVAL_TOGGLE = "com.android.launcher3.enable_smartspace_removal_toggle";
    public static final String FLAG_ENABLE_STATE_MANAGER_PROTO_LOG = "com.android.launcher3.enable_state_manager_proto_log";
    public static final String FLAG_ENABLE_STRICT_MODE = "com.android.launcher3.enable_strict_mode";
    public static final String FLAG_ENABLE_SUPPORT_FOR_ARCHIVING = "com.android.launcher3.enable_support_for_archiving";
    public static final String FLAG_ENABLE_TABLET_TWO_PANE_PICKER_V2 = "com.android.launcher3.enable_tablet_two_pane_picker_v2";
    public static final String FLAG_ENABLE_TASKBAR_BEHIND_SHADE = "com.android.launcher3.enable_taskbar_behind_shade";
    public static final String FLAG_ENABLE_TASKBAR_CUSTOMIZATION = "com.android.launcher3.enable_taskbar_customization";
    public static final String FLAG_ENABLE_TASKBAR_FOR_DIRECT_BOOT = "com.android.launcher3.enable_taskbar_for_direct_boot";
    public static final String FLAG_ENABLE_TASKBAR_NO_RECREATE = "com.android.launcher3.enable_taskbar_no_recreate";
    public static final String FLAG_ENABLE_TASKBAR_PINNING = "com.android.launcher3.enable_taskbar_pinning";
    public static final String FLAG_ENABLE_TIERED_WIDGETS_BY_DEFAULT_IN_PICKER = "com.android.launcher3.enable_tiered_widgets_by_default_in_picker";
    public static final String FLAG_ENABLE_TWOLINE_ALLAPPS = "com.android.launcher3.enable_twoline_allapps";
    public static final String FLAG_ENABLE_TWOLINE_TOGGLE = "com.android.launcher3.enable_twoline_toggle";
    public static final String FLAG_ENABLE_TWO_PANE_LAUNCHER_SETTINGS = "com.android.launcher3.enable_two_pane_launcher_settings";
    public static final String FLAG_ENABLE_UNFOLDED_TWO_PANE_PICKER = "com.android.launcher3.enable_unfolded_two_pane_picker";
    public static final String FLAG_ENABLE_UNFOLD_STATE_ANIMATION = "com.android.launcher3.enable_unfold_state_animation";
    public static final String FLAG_ENABLE_USE_TOP_VISIBLE_ACTIVITY_FOR_EXCLUDE_FROM_RECENT_TASK = "com.android.launcher3.enable_use_top_visible_activity_for_exclude_from_recent_task";
    public static final String FLAG_ENABLE_WIDGET_TAP_TO_ADD = "com.android.launcher3.enable_widget_tap_to_add";
    public static final String FLAG_ENABLE_WORKSPACE_INFLATION = "com.android.launcher3.enable_workspace_inflation";
    public static final String FLAG_EXPRESSIVE_THEME_IN_TASKBAR_AND_NAVIGATION = "com.android.launcher3.expressive_theme_in_taskbar_and_navigation";
    public static final String FLAG_EXTENDIBLE_THEME_MANAGER = "com.android.launcher3.extendible_theme_manager";
    public static final String FLAG_FLOATING_SEARCH_BAR = "com.android.launcher3.floating_search_bar";
    public static final String FLAG_FORCE_MONOCHROME_APP_ICONS = "com.android.launcher3.force_monochrome_app_icons";
    public static final String FLAG_GRID_MIGRATION_REFACTOR = "com.android.launcher3.grid_migration_refactor";
    public static final String FLAG_GSF_RES = "com.android.launcher3.gsf_res";
    public static final String FLAG_IGNORE_THREE_FINGER_TRACKPAD_FOR_NAV_HANDLE_LONG_PRESS = "com.android.launcher3.ignore_three_finger_trackpad_for_nav_handle_long_press";
    public static final String FLAG_LETTER_FAST_SCROLLER = "com.android.launcher3.letter_fast_scroller";
    public static final String FLAG_MSDL_FEEDBACK = "com.android.launcher3.msdl_feedback";
    public static final String FLAG_MULTILINE_SEARCH_BAR = "com.android.launcher3.multiline_search_bar";
    public static final String FLAG_NAVIGATE_TO_CHILD_PREFERENCE = "com.android.launcher3.navigate_to_child_preference";
    public static final String FLAG_ONE_GRID_MOUNTED_MODE = "com.android.launcher3.one_grid_mounted_mode";
    public static final String FLAG_ONE_GRID_ROTATION_HANDLING = "com.android.launcher3.one_grid_rotation_handling";
    public static final String FLAG_ONE_GRID_SPECS = "com.android.launcher3.one_grid_specs";
    public static final String FLAG_PREDICTIVE_BACK_TO_HOME_BLUR = "com.android.launcher3.predictive_back_to_home_blur";
    public static final String FLAG_PREDICTIVE_BACK_TO_HOME_POLISH = "com.android.launcher3.predictive_back_to_home_polish";
    public static final String FLAG_PRIVATE_SPACE_ADD_FLOATING_MASK_VIEW = "com.android.launcher3.private_space_add_floating_mask_view";
    public static final String FLAG_PRIVATE_SPACE_ANIMATION = "com.android.launcher3.private_space_animation";
    public static final String FLAG_PRIVATE_SPACE_APP_INSTALLER_BUTTON = "com.android.launcher3.private_space_app_installer_button";
    public static final String FLAG_PRIVATE_SPACE_RESTRICT_ACCESSIBILITY_DRAG = "com.android.launcher3.private_space_restrict_accessibility_drag";
    public static final String FLAG_PRIVATE_SPACE_RESTRICT_ITEM_DRAG = "com.android.launcher3.private_space_restrict_item_drag";
    public static final String FLAG_PRIVATE_SPACE_SYS_APPS_SEPARATION = "com.android.launcher3.private_space_sys_apps_separation";
    public static final String FLAG_REMOVE_APPS_REFRESH_ON_RIGHT_CLICK = "com.android.launcher3.remove_apps_refresh_on_right_click";
    public static final String FLAG_REMOVE_EXCLUDE_FROM_SCREEN_MAGNIFICATION_FLAG_USAGE = "com.android.launcher3.remove_exclude_from_screen_magnification_flag_usage";
    public static final String FLAG_RESTORE_ARCHIVED_APP_ICONS_FROM_DB = "com.android.launcher3.restore_archived_app_icons_from_db";
    public static final String FLAG_RESTORE_ARCHIVED_SHORTCUTS = "com.android.launcher3.restore_archived_shortcuts";
    public static final String FLAG_SHOW_TASKBAR_PINNING_POPUP_FROM_ANYWHERE = "com.android.launcher3.show_taskbar_pinning_popup_from_anywhere";
    public static final String FLAG_SYNC_APP_LAUNCH_WITH_TASKBAR_STASH = "com.android.launcher3.sync_app_launch_with_taskbar_stash";
    public static final String FLAG_TASKBAR_OVERFLOW = "com.android.launcher3.taskbar_overflow";
    public static final String FLAG_TASKBAR_QUIET_MODE_CHANGE_SUPPORT = "com.android.launcher3.taskbar_quiet_mode_change_support";
    public static final String FLAG_USE_ACTIVITY_OVERLAY = "com.android.launcher3.use_activity_overlay";
    public static final String FLAG_USE_NEW_ICON_FOR_ARCHIVED_APPS = "com.android.launcher3.use_new_icon_for_archived_apps";
    public static final String FLAG_USE_SYSTEM_RADIUS_FOR_APP_WIDGETS = "com.android.launcher3.use_system_radius_for_app_widgets";
    public static final String FLAG_WORK_SCHEDULER_IN_WORK_PROFILE = "com.android.launcher3.work_scheduler_in_work_profile";

    public Flags() {
    }

    public static boolean accessibilityScrollOnAllapps() {
        return true;
    }

    public static boolean allAppsBlur() {
        return false;
    }

    public static boolean allAppsSheetForHandheld() {
        return false;
    }

    public static boolean coordinateWorkspaceScale() {
        return true;
    }

    public static boolean enableActiveGestureProtoLog() {
        return true;
    }

    public static boolean enableAddAppWidgetViaConfigActivityV2() {
        return true;
    }

    public static boolean enableAdditionalHomeAnimations() {
        return true;
    }

    public static boolean enableAllAppsButtonInHotseat() {
        return false;
    }

    public static boolean enableAltTabKqsFlatenning() {
        return false;
    }

    public static boolean enableAltTabKqsOnConnectedDisplays() {
        return false;
    }

    public static boolean enableCategorizedWidgetSuggestions() {
        return true;
    }

    public static boolean enableContainerReturnAnimations() {
        return true;
    }

    public static boolean enableContrastTiles() {
        return false;
    }

    public static boolean enableCursorHoverStates() {
        return true;
    }

    public static boolean enableDesktopExplodedView() {
        return false;
    }

    public static boolean enableDesktopTaskAlphaAnimation() {
        return true;
    }

    public static boolean enableDesktopWindowingCarouselDetach() {
        return false;
    }

    public static boolean enableDismissPredictionUndo() {
        return true;
    }

    public static boolean enableExpandingPauseWorkButton() {
        return true;
    }

    public static boolean enableExpressiveDismissTaskMotion() {
        return false;
    }

    public static boolean enableFallbackOverviewInWindow() {
        return false;
    }

    public static boolean enableFirstScreenBroadcastArchivingExtras() {
        return true;
    }

    public static boolean enableFocusOutline() {
        return true;
    }

    public static boolean enableGeneratedPreviews() {
        return true;
    }

    public static boolean enableGestureNavHorizontalTouchSlop() {
        return false;
    }

    public static boolean enableGestureNavOnConnectedDisplays() {
        return false;
    }

    public static boolean enableGridMigrationFix() {
        return true;
    }

    public static boolean enableGridOnlyOverview() {
        return false;
    }

    public static boolean enableGrowthNudge() {
        return false;
    }

    public static boolean enableHandleDelayedGestureCallbacks() {
        return true;
    }

    public static boolean enableHomeTransitionListener() {
        return true;
    }

    public static boolean enableHoverOfChildElementsInTaskview() {
        return true;
    }

    public static boolean enableLargeDesktopWindowingTile() {
        return true;
    }

    public static boolean enableLauncherBrMetricsFixed() {
        return true;
    }

    public static boolean enableLauncherIconShapes() {
        return false;
    }

    public static boolean enableLauncherOverviewInWindow() {
        return false;
    }

    public static boolean enableLauncherVisualRefresh() {
        return false;
    }

    public static boolean enableMouseInteractionChanges() {
        return false;
    }

    public static boolean enableMultiInstanceMenuTaskbar() {
        return true;
    }

    public static boolean enableNarrowGridRestore() {
        return true;
    }

    public static boolean enableOverviewBackgroundWallpaperBlur() {
        return false;
    }

    public static boolean enableOverviewCommandHelperTimeout() {
        return true;
    }

    public static boolean enableOverviewDesktopTileWallpaperBackground() {
        return false;
    }

    public static boolean enableOverviewIconMenu() {
        return false;
    }

    public static boolean enableOverviewOnConnectedDisplays() {
        return false;
    }

    public static boolean enablePinningAppWithContextMenu() {
        return false;
    }

    public static boolean enablePredictiveBackGesture() {
        return true;
    }

    public static boolean enablePrivateSpace() {
        return true;
    }

    public static boolean enablePrivateSpaceInstallShortcut() {
        return true;
    }

    public static boolean enableRebootUnlockAnimation() {
        return false;
    }

    public static boolean enableRecentsInTaskbar() {
        return false;
    }

    public static boolean enableRecentsWindowProtoLog() {
        return false;
    }

    public static boolean enableRefactorTaskThumbnail() {
        return false;
    }

    public static boolean enableResponsiveWorkspace() {
        return true;
    }

    public static boolean enableScalabilityForDesktopExperience() {
        return false;
    }

    public static boolean enableScalingRevealHomeAnimation() {
        return true;
    }

    public static boolean enableSeparateExternalDisplayTasks() {
        return true;
    }

    public static boolean enableShortcutDontSuggestApp() {
        return true;
    }

    public static boolean enableShowEnabledShortcutsInAccessibilityMenu() {
        return true;
    }

    public static boolean enableSmartspaceAsAWidget() {
        return false;
    }

    public static boolean enableSmartspaceRemovalToggle() {
        return false;
    }

    public static boolean enableStateManagerProtoLog() {
        return false;
    }

    public static boolean enableStrictMode() {
        return false;
    }

    public static boolean enableSupportForArchiving() {
        return true;
    }

    public static boolean enableTabletTwoPanePickerV2() {
        return false;
    }

    public static boolean enableTaskbarBehindShade() {
        return false;
    }

    public static boolean enableTaskbarCustomization() {
        return false;
    }

    public static boolean enableTaskbarForDirectBoot() {
        return false;
    }

    public static boolean enableTaskbarNoRecreate() {
        return false;
    }

    public static boolean enableTaskbarPinning() {
        return true;
    }

    public static boolean enableTieredWidgetsByDefaultInPicker() {
        return false;
    }

    public static boolean enableTwoPaneLauncherSettings() {
        return false;
    }

    public static boolean enableTwolineAllapps() {
        return false;
    }

    public static boolean enableTwolineToggle() {
        return true;
    }

    public static boolean enableUnfoldStateAnimation() {
        return false;
    }

    public static boolean enableUnfoldedTwoPanePicker() {
        return true;
    }

    public static boolean enableUseTopVisibleActivityForExcludeFromRecentTask() {
        return true;
    }

    public static boolean enableWidgetTapToAdd() {
        return true;
    }

    public static boolean enableWorkspaceInflation() {
        return true;
    }

    public static boolean enabledFoldersInAllApps() {
        return false;
    }

    public static boolean expressiveThemeInTaskbarAndNavigation() {
        return false;
    }

    public static boolean extendibleThemeManager() {
        return false;
    }

    public static boolean floatingSearchBar() {
        return false;
    }

    public static boolean forceMonochromeAppIcons() {
        return false;
    }

    public static boolean gridMigrationRefactor() {
        return true;
    }

    public static boolean gsfRes() {
        return false;
    }

    public static boolean ignoreThreeFingerTrackpadForNavHandleLongPress() {
        return true;
    }

    public static boolean letterFastScroller() {
        return false;
    }

    public static boolean msdlFeedback() {
        return false;
    }

    public static boolean multilineSearchBar() {
        return true;
    }

    public static boolean navigateToChildPreference() {
        return true;
    }

    public static boolean oneGridMountedMode() {
        return false;
    }

    public static boolean oneGridRotationHandling() {
        return false;
    }

    public static boolean oneGridSpecs() {
        return false;
    }

    public static boolean predictiveBackToHomeBlur() {
        return false;
    }

    public static boolean predictiveBackToHomePolish() {
        return true;
    }

    public static boolean privateSpaceAddFloatingMaskView() {
        return true;
    }

    public static boolean privateSpaceAnimation() {
        return true;
    }

    public static boolean privateSpaceAppInstallerButton() {
        return true;
    }

    public static boolean privateSpaceRestrictAccessibilityDrag() {
        return true;
    }

    public static boolean privateSpaceRestrictItemDrag() {
        return true;
    }

    public static boolean privateSpaceSysAppsSeparation() {
        return true;
    }

    public static boolean removeAppsRefreshOnRightClick() {
        return true;
    }

    public static boolean removeExcludeFromScreenMagnificationFlagUsage() {
        return true;
    }

    public static boolean restoreArchivedAppIconsFromDb() {
        return false;
    }

    public static boolean restoreArchivedShortcuts() {
        return false;
    }

    public static boolean showTaskbarPinningPopupFromAnywhere() {
        return false;
    }

    public static boolean syncAppLaunchWithTaskbarStash() {
        return false;
    }

    public static boolean taskbarOverflow() {
        return true;
    }

    public static boolean taskbarQuietModeChangeSupport() {
        return false;
    }

    public static boolean useActivityOverlay() {
        return true;
    }

    public static boolean useNewIconForArchivedApps() {
        return true;
    }

    public static boolean useSystemRadiusForAppWidgets() {
        return true;
    }

    public static boolean workSchedulerInWorkProfile() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
