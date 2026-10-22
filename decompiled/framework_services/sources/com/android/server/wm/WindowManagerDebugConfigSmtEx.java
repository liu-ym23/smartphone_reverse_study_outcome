package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerDebugConfigSmtEx {
    static boolean DEBUG_ADD_REMOVE;
    static boolean DEBUG_APP_TRANSITIONS;
    static boolean DEBUG_BYTEDANCE_TRANSITION;
    static boolean DEBUG_FOCUS;
    static boolean DEBUG_KEYGUARD;
    static boolean DEBUG_RESIZE;
    static boolean DEBUG_STARTING_WINDOW;
    static boolean DEBUG_TOKEN_MOVEMENT;
    static boolean DEBUG_WINDOW_MOVEMENT;
    static boolean SHOW_TRANSACTIONS;

    public WindowManagerDebugConfigSmtEx() {
    }

    static {
        DEBUG_ADD_REMOVE = false;
        DEBUG_APP_TRANSITIONS = false;
        DEBUG_FOCUS = false;
        DEBUG_KEYGUARD = false;
        DEBUG_RESIZE = false;
        DEBUG_BYTEDANCE_TRANSITION = false;
        DEBUG_STARTING_WINDOW = false;
        DEBUG_TOKEN_MOVEMENT = false;
        DEBUG_WINDOW_MOVEMENT = false;
        SHOW_TRANSACTIONS = false;
    }
}
