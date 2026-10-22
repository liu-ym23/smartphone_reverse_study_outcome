package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerDebugConfig {
    static boolean DEBUG = false;
    static boolean DEBUG_CONFIGURATION = false;
    static boolean DEBUG_DISPLAY = false;
    static boolean DEBUG_DRAG = false;
    static boolean DEBUG_INPUT = false;
    static boolean DEBUG_INPUT_METHOD = false;
    static boolean DEBUG_LAYERS = false;
    static boolean DEBUG_LAYOUT = false;
    static boolean DEBUG_LAYOUT_REPEATS = false;
    static boolean DEBUG_POWER = false;
    static boolean DEBUG_ROOT_TASK = false;
    static boolean DEBUG_SCREENSHOT = false;
    static boolean DEBUG_STARTING_WINDOW_VERBOSE = false;
    static boolean DEBUG_TASK_MOVEMENT = false;
    static boolean DEBUG_UNKNOWN_APP_VISIBILITY = false;
    static boolean DEBUG_VISIBILITY = false;
    static boolean DEBUG_WALLPAPER = false;
    static boolean DEBUG_WINDOW_CROP = false;
    static boolean DEBUG_WINDOW_TRACE = false;
    static boolean SHOW_LIGHT_TRANSACTIONS = false;
    static boolean SHOW_STACK_CRAWLS = false;
    static boolean SHOW_VERBOSE_TRANSACTIONS = false;
    static final boolean TAG_WITH_CLASS_NAME = false;
    static final String TAG_WM = "WindowManager";

    public WindowManagerDebugConfig() {
    }

    static {
        DEBUG = false;
        DEBUG_LAYOUT = false;
        DEBUG_LAYERS = false;
        DEBUG_INPUT = false;
        DEBUG_INPUT_METHOD = false;
        DEBUG_VISIBILITY = false;
        DEBUG_CONFIGURATION = false;
        DEBUG_STARTING_WINDOW_VERBOSE = false;
        DEBUG_WALLPAPER = false;
        DEBUG_DRAG = true;
        DEBUG_SCREENSHOT = false;
        DEBUG_LAYOUT_REPEATS = false;
        DEBUG_WINDOW_TRACE = false;
        DEBUG_TASK_MOVEMENT = false;
        DEBUG_ROOT_TASK = false;
        DEBUG_DISPLAY = false;
        DEBUG_POWER = false;
        SHOW_VERBOSE_TRANSACTIONS = false;
        SHOW_LIGHT_TRANSACTIONS = false;
        SHOW_STACK_CRAWLS = false;
        DEBUG_WINDOW_CROP = false;
        DEBUG_UNKNOWN_APP_VISIBILITY = false;
    }

    protected static void reset() {
        DEBUG = false;
        DEBUG_LAYOUT = false;
        DEBUG_LAYERS = false;
        DEBUG_INPUT = false;
        DEBUG_INPUT_METHOD = false;
        DEBUG_VISIBILITY = false;
        DEBUG_CONFIGURATION = false;
        DEBUG_STARTING_WINDOW_VERBOSE = false;
        DEBUG_WALLPAPER = false;
        DEBUG_DRAG = true;
        DEBUG_SCREENSHOT = false;
        DEBUG_LAYOUT_REPEATS = false;
        DEBUG_WINDOW_TRACE = false;
        DEBUG_TASK_MOVEMENT = false;
        DEBUG_ROOT_TASK = false;
        DEBUG_DISPLAY = false;
        DEBUG_POWER = false;
        SHOW_VERBOSE_TRANSACTIONS = false;
        SHOW_LIGHT_TRANSACTIONS = false;
        SHOW_STACK_CRAWLS = false;
        DEBUG_WINDOW_CROP = false;
        DEBUG_UNKNOWN_APP_VISIBILITY = false;
    }
}
