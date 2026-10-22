package com.android.wm.shell;

/* JADX INFO: loaded from: classes3.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_BUBBLE_VIEW_INFO_EXECUTORS = "com.android.wm.shell.bubble_view_info_executors";
    public static final String FLAG_ENABLE_AUTO_TASK_STACK_CONTROLLER = "com.android.wm.shell.enable_auto_task_stack_controller";
    public static final String FLAG_ENABLE_BUBBLES_LONG_PRESS_NAV_HANDLE = "com.android.wm.shell.enable_bubbles_long_press_nav_handle";
    public static final String FLAG_ENABLE_BUBBLE_ANYTHING = "com.android.wm.shell.enable_bubble_anything";
    public static final String FLAG_ENABLE_BUBBLE_BAR = "com.android.wm.shell.enable_bubble_bar";
    public static final String FLAG_ENABLE_BUBBLE_BAR_ON_PHONES = "com.android.wm.shell.enable_bubble_bar_on_phones";
    public static final String FLAG_ENABLE_BUBBLE_STASHING = "com.android.wm.shell.enable_bubble_stashing";
    public static final String FLAG_ENABLE_BUBBLE_TASK_VIEW_LISTENER = "com.android.wm.shell.enable_bubble_task_view_listener";
    public static final String FLAG_ENABLE_BUBBLE_TO_FULLSCREEN = "com.android.wm.shell.enable_bubble_to_fullscreen";
    public static final String FLAG_ENABLE_CREATE_ANY_BUBBLE = "com.android.wm.shell.enable_create_any_bubble";
    public static final String FLAG_ENABLE_DYNAMIC_INSETS_FOR_APP_LAUNCH = "com.android.wm.shell.enable_dynamic_insets_for_app_launch";
    public static final String FLAG_ENABLE_FLEXIBLE_SPLIT = "com.android.wm.shell.enable_flexible_split";
    public static final String FLAG_ENABLE_FLEXIBLE_TWO_APP_SPLIT = "com.android.wm.shell.enable_flexible_two_app_split";
    public static final String FLAG_ENABLE_GSF = "com.android.wm.shell.enable_gsf";
    public static final String FLAG_ENABLE_MAGNETIC_SPLIT_DIVIDER = "com.android.wm.shell.enable_magnetic_split_divider";
    public static final String FLAG_ENABLE_NEW_BUBBLE_ANIMATIONS = "com.android.wm.shell.enable_new_bubble_animations";
    public static final String FLAG_ENABLE_OPTIONAL_BUBBLE_OVERFLOW = "com.android.wm.shell.enable_optional_bubble_overflow";
    public static final String FLAG_ENABLE_PIP2 = "com.android.wm.shell.enable_pip2";
    public static final String FLAG_ENABLE_PIP_UMO_EXPERIENCE = "com.android.wm.shell.enable_pip_umo_experience";
    public static final String FLAG_ENABLE_RECENTS_BOOKEND_TRANSITION = "com.android.wm.shell.enable_recents_bookend_transition";
    public static final String FLAG_ENABLE_RETRIEVABLE_BUBBLES = "com.android.wm.shell.enable_retrievable_bubbles";
    public static final String FLAG_ENABLE_SHELL_TOP_TASK_TRACKING = "com.android.wm.shell.enable_shell_top_task_tracking";
    public static final String FLAG_ENABLE_TASKBAR_NAVBAR_UNIFICATION = "com.android.wm.shell.enable_taskbar_navbar_unification";
    public static final String FLAG_ENABLE_TASKBAR_ON_PHONES = "com.android.wm.shell.enable_taskbar_on_phones";
    public static final String FLAG_ENABLE_TASK_VIEW_CONTROLLER_CLEANUP = "com.android.wm.shell.enable_task_view_controller_cleanup";
    public static final String FLAG_ENABLE_TINY_TASKBAR = "com.android.wm.shell.enable_tiny_taskbar";
    public static final String FLAG_FIX_MISSING_USER_CHANGE_CALLBACKS = "com.android.wm.shell.fix_missing_user_change_callbacks";
    public static final String FLAG_ONLY_REUSE_BUBBLED_TASK_WHEN_LAUNCHED_FROM_BUBBLE = "com.android.wm.shell.only_reuse_bubbled_task_when_launched_from_bubble";
    public static final String FLAG_TASK_VIEW_REPOSITORY = "com.android.wm.shell.task_view_repository";

    public Flags() {
    }

    public static boolean bubbleViewInfoExecutors() {
        return true;
    }

    public static boolean enableAutoTaskStackController() {
        return false;
    }

    public static boolean enableBubbleAnything() {
        return false;
    }

    public static boolean enableBubbleBar() {
        return false;
    }

    public static boolean enableBubbleBarOnPhones() {
        return false;
    }

    public static boolean enableBubbleStashing() {
        return false;
    }

    public static boolean enableBubbleTaskViewListener() {
        return false;
    }

    public static boolean enableBubbleToFullscreen() {
        return false;
    }

    public static boolean enableBubblesLongPressNavHandle() {
        return false;
    }

    public static boolean enableCreateAnyBubble() {
        return false;
    }

    public static boolean enableDynamicInsetsForAppLaunch() {
        return false;
    }

    public static boolean enableFlexibleSplit() {
        return false;
    }

    public static boolean enableFlexibleTwoAppSplit() {
        return false;
    }

    public static boolean enableGsf() {
        return false;
    }

    public static boolean enableMagneticSplitDivider() {
        return false;
    }

    public static boolean enableNewBubbleAnimations() {
        return false;
    }

    public static boolean enableOptionalBubbleOverflow() {
        return false;
    }

    public static boolean enablePip2() {
        return false;
    }

    public static boolean enablePipUmoExperience() {
        return false;
    }

    public static boolean enableRecentsBookendTransition() {
        return false;
    }

    public static boolean enableRetrievableBubbles() {
        return false;
    }

    public static boolean enableShellTopTaskTracking() {
        return false;
    }

    public static boolean enableTaskViewControllerCleanup() {
        return true;
    }

    public static boolean enableTaskbarNavbarUnification() {
        return true;
    }

    public static boolean enableTaskbarOnPhones() {
        return false;
    }

    public static boolean enableTinyTaskbar() {
        return false;
    }

    public static boolean fixMissingUserChangeCallbacks() {
        return false;
    }

    public static boolean onlyReuseBubbledTaskWhenLaunchedFromBubble() {
        return true;
    }

    public static boolean taskViewRepository() {
        return false;
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
