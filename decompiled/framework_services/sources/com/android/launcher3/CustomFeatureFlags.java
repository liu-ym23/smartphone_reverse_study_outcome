package com.android.launcher3;

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
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ACCESSIBILITY_SCROLL_ON_ALLAPPS, Flags.FLAG_ALL_APPS_BLUR, Flags.FLAG_ALL_APPS_SHEET_FOR_HANDHELD, Flags.FLAG_COORDINATE_WORKSPACE_SCALE, Flags.FLAG_ENABLE_ACTIVE_GESTURE_PROTO_LOG, Flags.FLAG_ENABLE_ADD_APP_WIDGET_VIA_CONFIG_ACTIVITY_V2, Flags.FLAG_ENABLE_ADDITIONAL_HOME_ANIMATIONS, Flags.FLAG_ENABLE_ALL_APPS_BUTTON_IN_HOTSEAT, Flags.FLAG_ENABLE_ALT_TAB_KQS_FLATENNING, Flags.FLAG_ENABLE_ALT_TAB_KQS_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_CATEGORIZED_WIDGET_SUGGESTIONS, Flags.FLAG_ENABLE_CONTAINER_RETURN_ANIMATIONS, Flags.FLAG_ENABLE_CONTRAST_TILES, Flags.FLAG_ENABLE_CURSOR_HOVER_STATES, Flags.FLAG_ENABLE_DESKTOP_EXPLODED_VIEW, Flags.FLAG_ENABLE_DESKTOP_TASK_ALPHA_ANIMATION, Flags.FLAG_ENABLE_DESKTOP_WINDOWING_CAROUSEL_DETACH, Flags.FLAG_ENABLE_DISMISS_PREDICTION_UNDO, Flags.FLAG_ENABLE_EXPANDING_PAUSE_WORK_BUTTON, Flags.FLAG_ENABLE_EXPRESSIVE_DISMISS_TASK_MOTION, Flags.FLAG_ENABLE_FALLBACK_OVERVIEW_IN_WINDOW, Flags.FLAG_ENABLE_FIRST_SCREEN_BROADCAST_ARCHIVING_EXTRAS, Flags.FLAG_ENABLE_FOCUS_OUTLINE, Flags.FLAG_ENABLE_GENERATED_PREVIEWS, Flags.FLAG_ENABLE_GESTURE_NAV_HORIZONTAL_TOUCH_SLOP, Flags.FLAG_ENABLE_GESTURE_NAV_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_GRID_MIGRATION_FIX, Flags.FLAG_ENABLE_GRID_ONLY_OVERVIEW, Flags.FLAG_ENABLE_GROWTH_NUDGE, Flags.FLAG_ENABLE_HANDLE_DELAYED_GESTURE_CALLBACKS, Flags.FLAG_ENABLE_HOME_TRANSITION_LISTENER, Flags.FLAG_ENABLE_HOVER_OF_CHILD_ELEMENTS_IN_TASKVIEW, Flags.FLAG_ENABLE_LARGE_DESKTOP_WINDOWING_TILE, Flags.FLAG_ENABLE_LAUNCHER_BR_METRICS_FIXED, Flags.FLAG_ENABLE_LAUNCHER_ICON_SHAPES, Flags.FLAG_ENABLE_LAUNCHER_OVERVIEW_IN_WINDOW, Flags.FLAG_ENABLE_LAUNCHER_VISUAL_REFRESH, Flags.FLAG_ENABLE_MOUSE_INTERACTION_CHANGES, Flags.FLAG_ENABLE_MULTI_INSTANCE_MENU_TASKBAR, Flags.FLAG_ENABLE_NARROW_GRID_RESTORE, Flags.FLAG_ENABLE_OVERVIEW_BACKGROUND_WALLPAPER_BLUR, Flags.FLAG_ENABLE_OVERVIEW_COMMAND_HELPER_TIMEOUT, Flags.FLAG_ENABLE_OVERVIEW_DESKTOP_TILE_WALLPAPER_BACKGROUND, Flags.FLAG_ENABLE_OVERVIEW_ICON_MENU, Flags.FLAG_ENABLE_OVERVIEW_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_PINNING_APP_WITH_CONTEXT_MENU, Flags.FLAG_ENABLE_PREDICTIVE_BACK_GESTURE, Flags.FLAG_ENABLE_PRIVATE_SPACE, Flags.FLAG_ENABLE_PRIVATE_SPACE_INSTALL_SHORTCUT, Flags.FLAG_ENABLE_REBOOT_UNLOCK_ANIMATION, Flags.FLAG_ENABLE_RECENTS_IN_TASKBAR, Flags.FLAG_ENABLE_RECENTS_WINDOW_PROTO_LOG, Flags.FLAG_ENABLE_REFACTOR_TASK_THUMBNAIL, Flags.FLAG_ENABLE_RESPONSIVE_WORKSPACE, Flags.FLAG_ENABLE_SCALABILITY_FOR_DESKTOP_EXPERIENCE, Flags.FLAG_ENABLE_SCALING_REVEAL_HOME_ANIMATION, Flags.FLAG_ENABLE_SEPARATE_EXTERNAL_DISPLAY_TASKS, Flags.FLAG_ENABLE_SHORTCUT_DONT_SUGGEST_APP, Flags.FLAG_ENABLE_SHOW_ENABLED_SHORTCUTS_IN_ACCESSIBILITY_MENU, Flags.FLAG_ENABLE_SMARTSPACE_AS_A_WIDGET, Flags.FLAG_ENABLE_SMARTSPACE_REMOVAL_TOGGLE, Flags.FLAG_ENABLE_STATE_MANAGER_PROTO_LOG, Flags.FLAG_ENABLE_STRICT_MODE, Flags.FLAG_ENABLE_SUPPORT_FOR_ARCHIVING, Flags.FLAG_ENABLE_TABLET_TWO_PANE_PICKER_V2, Flags.FLAG_ENABLE_TASKBAR_BEHIND_SHADE, Flags.FLAG_ENABLE_TASKBAR_CUSTOMIZATION, Flags.FLAG_ENABLE_TASKBAR_FOR_DIRECT_BOOT, Flags.FLAG_ENABLE_TASKBAR_NO_RECREATE, Flags.FLAG_ENABLE_TASKBAR_PINNING, Flags.FLAG_ENABLE_TIERED_WIDGETS_BY_DEFAULT_IN_PICKER, Flags.FLAG_ENABLE_TWO_PANE_LAUNCHER_SETTINGS, Flags.FLAG_ENABLE_TWOLINE_ALLAPPS, Flags.FLAG_ENABLE_TWOLINE_TOGGLE, Flags.FLAG_ENABLE_UNFOLD_STATE_ANIMATION, Flags.FLAG_ENABLE_UNFOLDED_TWO_PANE_PICKER, Flags.FLAG_ENABLE_USE_TOP_VISIBLE_ACTIVITY_FOR_EXCLUDE_FROM_RECENT_TASK, Flags.FLAG_ENABLE_WIDGET_TAP_TO_ADD, Flags.FLAG_ENABLE_WORKSPACE_INFLATION, Flags.FLAG_ENABLED_FOLDERS_IN_ALL_APPS, Flags.FLAG_EXPRESSIVE_THEME_IN_TASKBAR_AND_NAVIGATION, Flags.FLAG_EXTENDIBLE_THEME_MANAGER, Flags.FLAG_FLOATING_SEARCH_BAR, Flags.FLAG_FORCE_MONOCHROME_APP_ICONS, Flags.FLAG_GRID_MIGRATION_REFACTOR, Flags.FLAG_GSF_RES, Flags.FLAG_IGNORE_THREE_FINGER_TRACKPAD_FOR_NAV_HANDLE_LONG_PRESS, Flags.FLAG_LETTER_FAST_SCROLLER, Flags.FLAG_MSDL_FEEDBACK, Flags.FLAG_MULTILINE_SEARCH_BAR, Flags.FLAG_NAVIGATE_TO_CHILD_PREFERENCE, Flags.FLAG_ONE_GRID_MOUNTED_MODE, Flags.FLAG_ONE_GRID_ROTATION_HANDLING, Flags.FLAG_ONE_GRID_SPECS, Flags.FLAG_PREDICTIVE_BACK_TO_HOME_BLUR, Flags.FLAG_PREDICTIVE_BACK_TO_HOME_POLISH, Flags.FLAG_PRIVATE_SPACE_ADD_FLOATING_MASK_VIEW, Flags.FLAG_PRIVATE_SPACE_ANIMATION, Flags.FLAG_PRIVATE_SPACE_APP_INSTALLER_BUTTON, Flags.FLAG_PRIVATE_SPACE_RESTRICT_ACCESSIBILITY_DRAG, Flags.FLAG_PRIVATE_SPACE_RESTRICT_ITEM_DRAG, Flags.FLAG_PRIVATE_SPACE_SYS_APPS_SEPARATION, Flags.FLAG_REMOVE_APPS_REFRESH_ON_RIGHT_CLICK, Flags.FLAG_REMOVE_EXCLUDE_FROM_SCREEN_MAGNIFICATION_FLAG_USAGE, Flags.FLAG_RESTORE_ARCHIVED_APP_ICONS_FROM_DB, Flags.FLAG_RESTORE_ARCHIVED_SHORTCUTS, Flags.FLAG_SHOW_TASKBAR_PINNING_POPUP_FROM_ANYWHERE, Flags.FLAG_SYNC_APP_LAUNCH_WITH_TASKBAR_STASH, Flags.FLAG_TASKBAR_OVERFLOW, Flags.FLAG_TASKBAR_QUIET_MODE_CHANGE_SUPPORT, Flags.FLAG_USE_ACTIVITY_OVERLAY, Flags.FLAG_USE_NEW_ICON_FOR_ARCHIVED_APPS, Flags.FLAG_USE_SYSTEM_RADIUS_FOR_APP_WIDGETS, Flags.FLAG_WORK_SCHEDULER_IN_WORK_PROFILE, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean accessibilityScrollOnAllapps() {
        return getValue(Flags.FLAG_ACCESSIBILITY_SCROLL_ON_ALLAPPS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean allAppsBlur() {
        return getValue(Flags.FLAG_ALL_APPS_BLUR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean allAppsSheetForHandheld() {
        return getValue(Flags.FLAG_ALL_APPS_SHEET_FOR_HANDHELD, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean coordinateWorkspaceScale() {
        return getValue(Flags.FLAG_COORDINATE_WORKSPACE_SCALE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableActiveGestureProtoLog() {
        return getValue(Flags.FLAG_ENABLE_ACTIVE_GESTURE_PROTO_LOG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableAddAppWidgetViaConfigActivityV2() {
        return getValue(Flags.FLAG_ENABLE_ADD_APP_WIDGET_VIA_CONFIG_ACTIVITY_V2, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableAdditionalHomeAnimations() {
        return getValue(Flags.FLAG_ENABLE_ADDITIONAL_HOME_ANIMATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableAllAppsButtonInHotseat() {
        return getValue(Flags.FLAG_ENABLE_ALL_APPS_BUTTON_IN_HOTSEAT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableAltTabKqsFlatenning() {
        return getValue(Flags.FLAG_ENABLE_ALT_TAB_KQS_FLATENNING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableAltTabKqsOnConnectedDisplays() {
        return getValue(Flags.FLAG_ENABLE_ALT_TAB_KQS_ON_CONNECTED_DISPLAYS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableCategorizedWidgetSuggestions() {
        return getValue(Flags.FLAG_ENABLE_CATEGORIZED_WIDGET_SUGGESTIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableContainerReturnAnimations() {
        return getValue(Flags.FLAG_ENABLE_CONTAINER_RETURN_ANIMATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableContrastTiles() {
        return getValue(Flags.FLAG_ENABLE_CONTRAST_TILES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableCursorHoverStates() {
        return getValue(Flags.FLAG_ENABLE_CURSOR_HOVER_STATES, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableDesktopExplodedView() {
        return getValue(Flags.FLAG_ENABLE_DESKTOP_EXPLODED_VIEW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableDesktopTaskAlphaAnimation() {
        return getValue(Flags.FLAG_ENABLE_DESKTOP_TASK_ALPHA_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableDesktopWindowingCarouselDetach() {
        return getValue(Flags.FLAG_ENABLE_DESKTOP_WINDOWING_CAROUSEL_DETACH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableDismissPredictionUndo() {
        return getValue(Flags.FLAG_ENABLE_DISMISS_PREDICTION_UNDO, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableExpandingPauseWorkButton() {
        return getValue(Flags.FLAG_ENABLE_EXPANDING_PAUSE_WORK_BUTTON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableExpressiveDismissTaskMotion() {
        return getValue(Flags.FLAG_ENABLE_EXPRESSIVE_DISMISS_TASK_MOTION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableFallbackOverviewInWindow() {
        return getValue(Flags.FLAG_ENABLE_FALLBACK_OVERVIEW_IN_WINDOW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableFirstScreenBroadcastArchivingExtras() {
        return getValue(Flags.FLAG_ENABLE_FIRST_SCREEN_BROADCAST_ARCHIVING_EXTRAS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableFocusOutline() {
        return getValue(Flags.FLAG_ENABLE_FOCUS_OUTLINE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGeneratedPreviews() {
        return getValue(Flags.FLAG_ENABLE_GENERATED_PREVIEWS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGestureNavHorizontalTouchSlop() {
        return getValue(Flags.FLAG_ENABLE_GESTURE_NAV_HORIZONTAL_TOUCH_SLOP, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGestureNavOnConnectedDisplays() {
        return getValue(Flags.FLAG_ENABLE_GESTURE_NAV_ON_CONNECTED_DISPLAYS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGridMigrationFix() {
        return getValue(Flags.FLAG_ENABLE_GRID_MIGRATION_FIX, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGridOnlyOverview() {
        return getValue(Flags.FLAG_ENABLE_GRID_ONLY_OVERVIEW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableGrowthNudge() {
        return getValue(Flags.FLAG_ENABLE_GROWTH_NUDGE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableHandleDelayedGestureCallbacks() {
        return getValue(Flags.FLAG_ENABLE_HANDLE_DELAYED_GESTURE_CALLBACKS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableHomeTransitionListener() {
        return getValue(Flags.FLAG_ENABLE_HOME_TRANSITION_LISTENER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableHoverOfChildElementsInTaskview() {
        return getValue(Flags.FLAG_ENABLE_HOVER_OF_CHILD_ELEMENTS_IN_TASKVIEW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableLargeDesktopWindowingTile() {
        return getValue(Flags.FLAG_ENABLE_LARGE_DESKTOP_WINDOWING_TILE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableLauncherBrMetricsFixed() {
        return getValue(Flags.FLAG_ENABLE_LAUNCHER_BR_METRICS_FIXED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableLauncherIconShapes() {
        return getValue(Flags.FLAG_ENABLE_LAUNCHER_ICON_SHAPES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableLauncherOverviewInWindow() {
        return getValue(Flags.FLAG_ENABLE_LAUNCHER_OVERVIEW_IN_WINDOW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableLauncherVisualRefresh() {
        return getValue(Flags.FLAG_ENABLE_LAUNCHER_VISUAL_REFRESH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableMouseInteractionChanges() {
        return getValue(Flags.FLAG_ENABLE_MOUSE_INTERACTION_CHANGES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableMultiInstanceMenuTaskbar() {
        return getValue(Flags.FLAG_ENABLE_MULTI_INSTANCE_MENU_TASKBAR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableNarrowGridRestore() {
        return getValue(Flags.FLAG_ENABLE_NARROW_GRID_RESTORE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableOverviewBackgroundWallpaperBlur() {
        return getValue(Flags.FLAG_ENABLE_OVERVIEW_BACKGROUND_WALLPAPER_BLUR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableOverviewCommandHelperTimeout() {
        return getValue(Flags.FLAG_ENABLE_OVERVIEW_COMMAND_HELPER_TIMEOUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableOverviewDesktopTileWallpaperBackground() {
        return getValue(Flags.FLAG_ENABLE_OVERVIEW_DESKTOP_TILE_WALLPAPER_BACKGROUND, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableOverviewIconMenu() {
        return getValue(Flags.FLAG_ENABLE_OVERVIEW_ICON_MENU, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableOverviewOnConnectedDisplays() {
        return getValue(Flags.FLAG_ENABLE_OVERVIEW_ON_CONNECTED_DISPLAYS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enablePinningAppWithContextMenu() {
        return getValue(Flags.FLAG_ENABLE_PINNING_APP_WITH_CONTEXT_MENU, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enablePredictiveBackGesture() {
        return getValue(Flags.FLAG_ENABLE_PREDICTIVE_BACK_GESTURE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enablePrivateSpace() {
        return getValue(Flags.FLAG_ENABLE_PRIVATE_SPACE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enablePrivateSpaceInstallShortcut() {
        return getValue(Flags.FLAG_ENABLE_PRIVATE_SPACE_INSTALL_SHORTCUT, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableRebootUnlockAnimation() {
        return getValue(Flags.FLAG_ENABLE_REBOOT_UNLOCK_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableRecentsInTaskbar() {
        return getValue(Flags.FLAG_ENABLE_RECENTS_IN_TASKBAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableRecentsWindowProtoLog() {
        return getValue(Flags.FLAG_ENABLE_RECENTS_WINDOW_PROTO_LOG, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableRefactorTaskThumbnail() {
        return getValue(Flags.FLAG_ENABLE_REFACTOR_TASK_THUMBNAIL, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableResponsiveWorkspace() {
        return getValue(Flags.FLAG_ENABLE_RESPONSIVE_WORKSPACE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableScalabilityForDesktopExperience() {
        return getValue(Flags.FLAG_ENABLE_SCALABILITY_FOR_DESKTOP_EXPERIENCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableScalingRevealHomeAnimation() {
        return getValue(Flags.FLAG_ENABLE_SCALING_REVEAL_HOME_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableSeparateExternalDisplayTasks() {
        return getValue(Flags.FLAG_ENABLE_SEPARATE_EXTERNAL_DISPLAY_TASKS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableShortcutDontSuggestApp() {
        return getValue(Flags.FLAG_ENABLE_SHORTCUT_DONT_SUGGEST_APP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableShowEnabledShortcutsInAccessibilityMenu() {
        return getValue(Flags.FLAG_ENABLE_SHOW_ENABLED_SHORTCUTS_IN_ACCESSIBILITY_MENU, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableSmartspaceAsAWidget() {
        return getValue(Flags.FLAG_ENABLE_SMARTSPACE_AS_A_WIDGET, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableSmartspaceRemovalToggle() {
        return getValue(Flags.FLAG_ENABLE_SMARTSPACE_REMOVAL_TOGGLE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableStateManagerProtoLog() {
        return getValue(Flags.FLAG_ENABLE_STATE_MANAGER_PROTO_LOG, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableStrictMode() {
        return getValue(Flags.FLAG_ENABLE_STRICT_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableSupportForArchiving() {
        return getValue(Flags.FLAG_ENABLE_SUPPORT_FOR_ARCHIVING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTabletTwoPanePickerV2() {
        return getValue(Flags.FLAG_ENABLE_TABLET_TWO_PANE_PICKER_V2, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTaskbarBehindShade() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_BEHIND_SHADE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTaskbarCustomization() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_CUSTOMIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTaskbarForDirectBoot() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_FOR_DIRECT_BOOT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTaskbarNoRecreate() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_NO_RECREATE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTaskbarPinning() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_PINNING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTieredWidgetsByDefaultInPicker() {
        return getValue(Flags.FLAG_ENABLE_TIERED_WIDGETS_BY_DEFAULT_IN_PICKER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTwoPaneLauncherSettings() {
        return getValue(Flags.FLAG_ENABLE_TWO_PANE_LAUNCHER_SETTINGS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTwolineAllapps() {
        return getValue(Flags.FLAG_ENABLE_TWOLINE_ALLAPPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableTwolineToggle() {
        return getValue(Flags.FLAG_ENABLE_TWOLINE_TOGGLE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableUnfoldStateAnimation() {
        return getValue(Flags.FLAG_ENABLE_UNFOLD_STATE_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableUnfoldedTwoPanePicker() {
        return getValue(Flags.FLAG_ENABLE_UNFOLDED_TWO_PANE_PICKER, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableUseTopVisibleActivityForExcludeFromRecentTask() {
        return getValue(Flags.FLAG_ENABLE_USE_TOP_VISIBLE_ACTIVITY_FOR_EXCLUDE_FROM_RECENT_TASK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableWidgetTapToAdd() {
        return getValue(Flags.FLAG_ENABLE_WIDGET_TAP_TO_ADD, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enableWorkspaceInflation() {
        return getValue(Flags.FLAG_ENABLE_WORKSPACE_INFLATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean enabledFoldersInAllApps() {
        return getValue(Flags.FLAG_ENABLED_FOLDERS_IN_ALL_APPS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean expressiveThemeInTaskbarAndNavigation() {
        return getValue(Flags.FLAG_EXPRESSIVE_THEME_IN_TASKBAR_AND_NAVIGATION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean extendibleThemeManager() {
        return getValue(Flags.FLAG_EXTENDIBLE_THEME_MANAGER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean floatingSearchBar() {
        return getValue(Flags.FLAG_FLOATING_SEARCH_BAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean forceMonochromeAppIcons() {
        return getValue(Flags.FLAG_FORCE_MONOCHROME_APP_ICONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean gridMigrationRefactor() {
        return getValue(Flags.FLAG_GRID_MIGRATION_REFACTOR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean gsfRes() {
        return getValue(Flags.FLAG_GSF_RES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean ignoreThreeFingerTrackpadForNavHandleLongPress() {
        return getValue(Flags.FLAG_IGNORE_THREE_FINGER_TRACKPAD_FOR_NAV_HANDLE_LONG_PRESS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean letterFastScroller() {
        return getValue(Flags.FLAG_LETTER_FAST_SCROLLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean msdlFeedback() {
        return getValue(Flags.FLAG_MSDL_FEEDBACK, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean multilineSearchBar() {
        return getValue(Flags.FLAG_MULTILINE_SEARCH_BAR, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean navigateToChildPreference() {
        return getValue(Flags.FLAG_NAVIGATE_TO_CHILD_PREFERENCE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean oneGridMountedMode() {
        return getValue(Flags.FLAG_ONE_GRID_MOUNTED_MODE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean oneGridRotationHandling() {
        return getValue(Flags.FLAG_ONE_GRID_ROTATION_HANDLING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean oneGridSpecs() {
        return getValue(Flags.FLAG_ONE_GRID_SPECS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean predictiveBackToHomeBlur() {
        return getValue(Flags.FLAG_PREDICTIVE_BACK_TO_HOME_BLUR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean predictiveBackToHomePolish() {
        return getValue(Flags.FLAG_PREDICTIVE_BACK_TO_HOME_POLISH, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceAddFloatingMaskView() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_ADD_FLOATING_MASK_VIEW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceAnimation() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_ANIMATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceAppInstallerButton() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_APP_INSTALLER_BUTTON, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceRestrictAccessibilityDrag() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_RESTRICT_ACCESSIBILITY_DRAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceRestrictItemDrag() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_RESTRICT_ITEM_DRAG, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean privateSpaceSysAppsSeparation() {
        return getValue(Flags.FLAG_PRIVATE_SPACE_SYS_APPS_SEPARATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean removeAppsRefreshOnRightClick() {
        return getValue(Flags.FLAG_REMOVE_APPS_REFRESH_ON_RIGHT_CLICK, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean removeExcludeFromScreenMagnificationFlagUsage() {
        return getValue(Flags.FLAG_REMOVE_EXCLUDE_FROM_SCREEN_MAGNIFICATION_FLAG_USAGE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean restoreArchivedAppIconsFromDb() {
        return getValue(Flags.FLAG_RESTORE_ARCHIVED_APP_ICONS_FROM_DB, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean restoreArchivedShortcuts() {
        return getValue(Flags.FLAG_RESTORE_ARCHIVED_SHORTCUTS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean showTaskbarPinningPopupFromAnywhere() {
        return getValue(Flags.FLAG_SHOW_TASKBAR_PINNING_POPUP_FROM_ANYWHERE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean syncAppLaunchWithTaskbarStash() {
        return getValue(Flags.FLAG_SYNC_APP_LAUNCH_WITH_TASKBAR_STASH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean taskbarOverflow() {
        return getValue(Flags.FLAG_TASKBAR_OVERFLOW, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean taskbarQuietModeChangeSupport() {
        return getValue(Flags.FLAG_TASKBAR_QUIET_MODE_CHANGE_SUPPORT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean useActivityOverlay() {
        return getValue(Flags.FLAG_USE_ACTIVITY_OVERLAY, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean useNewIconForArchivedApps() {
        return getValue(Flags.FLAG_USE_NEW_ICON_FOR_ARCHIVED_APPS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean useSystemRadiusForAppWidgets() {
        return getValue(Flags.FLAG_USE_SYSTEM_RADIUS_FOR_APP_WIDGETS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.launcher3.FeatureFlags
    public boolean workSchedulerInWorkProfile() {
        return getValue(Flags.FLAG_WORK_SCHEDULER_IN_WORK_PROFILE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_ACCESSIBILITY_SCROLL_ON_ALLAPPS, Flags.FLAG_ALL_APPS_BLUR, Flags.FLAG_ALL_APPS_SHEET_FOR_HANDHELD, Flags.FLAG_COORDINATE_WORKSPACE_SCALE, Flags.FLAG_ENABLE_ACTIVE_GESTURE_PROTO_LOG, Flags.FLAG_ENABLE_ADD_APP_WIDGET_VIA_CONFIG_ACTIVITY_V2, Flags.FLAG_ENABLE_ADDITIONAL_HOME_ANIMATIONS, Flags.FLAG_ENABLE_ALL_APPS_BUTTON_IN_HOTSEAT, Flags.FLAG_ENABLE_ALT_TAB_KQS_FLATENNING, Flags.FLAG_ENABLE_ALT_TAB_KQS_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_CATEGORIZED_WIDGET_SUGGESTIONS, Flags.FLAG_ENABLE_CONTAINER_RETURN_ANIMATIONS, Flags.FLAG_ENABLE_CONTRAST_TILES, Flags.FLAG_ENABLE_CURSOR_HOVER_STATES, Flags.FLAG_ENABLE_DESKTOP_EXPLODED_VIEW, Flags.FLAG_ENABLE_DESKTOP_TASK_ALPHA_ANIMATION, Flags.FLAG_ENABLE_DESKTOP_WINDOWING_CAROUSEL_DETACH, Flags.FLAG_ENABLE_DISMISS_PREDICTION_UNDO, Flags.FLAG_ENABLE_EXPANDING_PAUSE_WORK_BUTTON, Flags.FLAG_ENABLE_EXPRESSIVE_DISMISS_TASK_MOTION, Flags.FLAG_ENABLE_FALLBACK_OVERVIEW_IN_WINDOW, Flags.FLAG_ENABLE_FIRST_SCREEN_BROADCAST_ARCHIVING_EXTRAS, Flags.FLAG_ENABLE_FOCUS_OUTLINE, Flags.FLAG_ENABLE_GENERATED_PREVIEWS, Flags.FLAG_ENABLE_GESTURE_NAV_HORIZONTAL_TOUCH_SLOP, Flags.FLAG_ENABLE_GESTURE_NAV_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_GRID_MIGRATION_FIX, Flags.FLAG_ENABLE_GRID_ONLY_OVERVIEW, Flags.FLAG_ENABLE_GROWTH_NUDGE, Flags.FLAG_ENABLE_HANDLE_DELAYED_GESTURE_CALLBACKS, Flags.FLAG_ENABLE_HOME_TRANSITION_LISTENER, Flags.FLAG_ENABLE_HOVER_OF_CHILD_ELEMENTS_IN_TASKVIEW, Flags.FLAG_ENABLE_LARGE_DESKTOP_WINDOWING_TILE, Flags.FLAG_ENABLE_LAUNCHER_BR_METRICS_FIXED, Flags.FLAG_ENABLE_LAUNCHER_ICON_SHAPES, Flags.FLAG_ENABLE_LAUNCHER_OVERVIEW_IN_WINDOW, Flags.FLAG_ENABLE_LAUNCHER_VISUAL_REFRESH, Flags.FLAG_ENABLE_MOUSE_INTERACTION_CHANGES, Flags.FLAG_ENABLE_MULTI_INSTANCE_MENU_TASKBAR, Flags.FLAG_ENABLE_NARROW_GRID_RESTORE, Flags.FLAG_ENABLE_OVERVIEW_BACKGROUND_WALLPAPER_BLUR, Flags.FLAG_ENABLE_OVERVIEW_COMMAND_HELPER_TIMEOUT, Flags.FLAG_ENABLE_OVERVIEW_DESKTOP_TILE_WALLPAPER_BACKGROUND, Flags.FLAG_ENABLE_OVERVIEW_ICON_MENU, Flags.FLAG_ENABLE_OVERVIEW_ON_CONNECTED_DISPLAYS, Flags.FLAG_ENABLE_PINNING_APP_WITH_CONTEXT_MENU, Flags.FLAG_ENABLE_PREDICTIVE_BACK_GESTURE, Flags.FLAG_ENABLE_PRIVATE_SPACE, Flags.FLAG_ENABLE_PRIVATE_SPACE_INSTALL_SHORTCUT, Flags.FLAG_ENABLE_REBOOT_UNLOCK_ANIMATION, Flags.FLAG_ENABLE_RECENTS_IN_TASKBAR, Flags.FLAG_ENABLE_RECENTS_WINDOW_PROTO_LOG, Flags.FLAG_ENABLE_REFACTOR_TASK_THUMBNAIL, Flags.FLAG_ENABLE_RESPONSIVE_WORKSPACE, Flags.FLAG_ENABLE_SCALABILITY_FOR_DESKTOP_EXPERIENCE, Flags.FLAG_ENABLE_SCALING_REVEAL_HOME_ANIMATION, Flags.FLAG_ENABLE_SEPARATE_EXTERNAL_DISPLAY_TASKS, Flags.FLAG_ENABLE_SHORTCUT_DONT_SUGGEST_APP, Flags.FLAG_ENABLE_SHOW_ENABLED_SHORTCUTS_IN_ACCESSIBILITY_MENU, Flags.FLAG_ENABLE_SMARTSPACE_AS_A_WIDGET, Flags.FLAG_ENABLE_SMARTSPACE_REMOVAL_TOGGLE, Flags.FLAG_ENABLE_STATE_MANAGER_PROTO_LOG, Flags.FLAG_ENABLE_STRICT_MODE, Flags.FLAG_ENABLE_SUPPORT_FOR_ARCHIVING, Flags.FLAG_ENABLE_TABLET_TWO_PANE_PICKER_V2, Flags.FLAG_ENABLE_TASKBAR_BEHIND_SHADE, Flags.FLAG_ENABLE_TASKBAR_CUSTOMIZATION, Flags.FLAG_ENABLE_TASKBAR_FOR_DIRECT_BOOT, Flags.FLAG_ENABLE_TASKBAR_NO_RECREATE, Flags.FLAG_ENABLE_TASKBAR_PINNING, Flags.FLAG_ENABLE_TIERED_WIDGETS_BY_DEFAULT_IN_PICKER, Flags.FLAG_ENABLE_TWO_PANE_LAUNCHER_SETTINGS, Flags.FLAG_ENABLE_TWOLINE_ALLAPPS, Flags.FLAG_ENABLE_TWOLINE_TOGGLE, Flags.FLAG_ENABLE_UNFOLD_STATE_ANIMATION, Flags.FLAG_ENABLE_UNFOLDED_TWO_PANE_PICKER, Flags.FLAG_ENABLE_USE_TOP_VISIBLE_ACTIVITY_FOR_EXCLUDE_FROM_RECENT_TASK, Flags.FLAG_ENABLE_WIDGET_TAP_TO_ADD, Flags.FLAG_ENABLE_WORKSPACE_INFLATION, Flags.FLAG_ENABLED_FOLDERS_IN_ALL_APPS, Flags.FLAG_EXPRESSIVE_THEME_IN_TASKBAR_AND_NAVIGATION, Flags.FLAG_EXTENDIBLE_THEME_MANAGER, Flags.FLAG_FLOATING_SEARCH_BAR, Flags.FLAG_FORCE_MONOCHROME_APP_ICONS, Flags.FLAG_GRID_MIGRATION_REFACTOR, Flags.FLAG_GSF_RES, Flags.FLAG_IGNORE_THREE_FINGER_TRACKPAD_FOR_NAV_HANDLE_LONG_PRESS, Flags.FLAG_LETTER_FAST_SCROLLER, Flags.FLAG_MSDL_FEEDBACK, Flags.FLAG_MULTILINE_SEARCH_BAR, Flags.FLAG_NAVIGATE_TO_CHILD_PREFERENCE, Flags.FLAG_ONE_GRID_MOUNTED_MODE, Flags.FLAG_ONE_GRID_ROTATION_HANDLING, Flags.FLAG_ONE_GRID_SPECS, Flags.FLAG_PREDICTIVE_BACK_TO_HOME_BLUR, Flags.FLAG_PREDICTIVE_BACK_TO_HOME_POLISH, Flags.FLAG_PRIVATE_SPACE_ADD_FLOATING_MASK_VIEW, Flags.FLAG_PRIVATE_SPACE_ANIMATION, Flags.FLAG_PRIVATE_SPACE_APP_INSTALLER_BUTTON, Flags.FLAG_PRIVATE_SPACE_RESTRICT_ACCESSIBILITY_DRAG, Flags.FLAG_PRIVATE_SPACE_RESTRICT_ITEM_DRAG, Flags.FLAG_PRIVATE_SPACE_SYS_APPS_SEPARATION, Flags.FLAG_REMOVE_APPS_REFRESH_ON_RIGHT_CLICK, Flags.FLAG_REMOVE_EXCLUDE_FROM_SCREEN_MAGNIFICATION_FLAG_USAGE, Flags.FLAG_RESTORE_ARCHIVED_APP_ICONS_FROM_DB, Flags.FLAG_RESTORE_ARCHIVED_SHORTCUTS, Flags.FLAG_SHOW_TASKBAR_PINNING_POPUP_FROM_ANYWHERE, Flags.FLAG_SYNC_APP_LAUNCH_WITH_TASKBAR_STASH, Flags.FLAG_TASKBAR_OVERFLOW, Flags.FLAG_TASKBAR_QUIET_MODE_CHANGE_SUPPORT, Flags.FLAG_USE_ACTIVITY_OVERLAY, Flags.FLAG_USE_NEW_ICON_FOR_ARCHIVED_APPS, Flags.FLAG_USE_SYSTEM_RADIUS_FOR_APP_WIDGETS, Flags.FLAG_WORK_SCHEDULER_IN_WORK_PROFILE});
    }
}
