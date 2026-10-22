package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskManagerDebugConfig {
    private static final boolean APPEND_CATEGORY_NAME = false;
    static boolean DEBUG_ACTIVITY_STARTS = false;
    static boolean DEBUG_ALL = false;
    private static boolean DEBUG_ALL_ACTIVITIES = false;
    static boolean DEBUG_APP = false;
    public static boolean DEBUG_CLEANUP = false;
    static boolean DEBUG_IDLE = false;
    public static boolean DEBUG_METRICS = false;
    static boolean DEBUG_PERMISSIONS_REVIEW = false;
    public static boolean DEBUG_PREFETCH = false;
    static boolean DEBUG_RECENTS = false;
    static boolean DEBUG_RECENTS_TRIM_TASKS = false;
    static boolean DEBUG_RELEASE = false;
    static boolean DEBUG_RESULTS = false;
    static boolean DEBUG_ROOT_TASK = false;
    static boolean DEBUG_SERVICETRACKER = false;
    public static boolean DEBUG_SWITCH = false;
    static boolean DEBUG_TRANSITION = false;
    static boolean DEBUG_USER_LEAVING = false;
    static boolean DEBUG_VISIBILITY = false;
    static final String POSTFIX_ADD_REMOVE = "";
    static final String POSTFIX_APP = "";
    static final String POSTFIX_CLEANUP = "";
    public static final String POSTFIX_CONFIGURATION = "";
    static final String POSTFIX_CONTAINERS = "";
    static final String POSTFIX_FOCUS = "";
    static final String POSTFIX_IDLE = "";
    static final String POSTFIX_IMMERSIVE = "";
    public static final String POSTFIX_LOCKTASK = "";
    static final String POSTFIX_PAUSE = "";
    static final String POSTFIX_RECENTS = "";
    static final String POSTFIX_RELEASE = "";
    static final String POSTFIX_RESULTS = "";
    static final String POSTFIX_ROOT_TASK = "";
    static final String POSTFIX_SAVED_STATE = "";
    static final String POSTFIX_STATES = "";
    public static final String POSTFIX_SWITCH = "";
    static final String POSTFIX_TASKS = "";
    static final String POSTFIX_TRANSITION = "";
    static final String POSTFIX_USER_LEAVING = "";
    static final String POSTFIX_VISIBILITY = "";
    static final String TAG_ATM = "ActivityTaskManager";
    static final boolean TAG_WITH_CLASS_NAME = false;

    public ActivityTaskManagerDebugConfig() {
    }

    static {
        DEBUG_ALL = false;
        boolean r2 = true;
        if (DEBUG_ALL == true) goto L5;
        boolean r1 = false;
    L6:
        DEBUG_ALL_ACTIVITIES = r1;
        if (DEBUG_ALL == true) goto L9;
        boolean r3 = false;
    L10:
        DEBUG_RECENTS = r3;
        if (DEBUG_RECENTS == true) goto L13;
        boolean r4 = false;
    L14:
        DEBUG_RECENTS_TRIM_TASKS = r4;
        if (DEBUG_ALL == true) goto L17;
        boolean r5 = false;
    L18:
        DEBUG_ROOT_TASK = r5;
        if (DEBUG_ALL == true) goto L21;
        boolean r6 = false;
    L22:
        DEBUG_SWITCH = r6;
        if (DEBUG_ALL == true) goto L25;
        boolean r7 = false;
    L26:
        DEBUG_TRANSITION = r7;
        if (DEBUG_ALL == true) goto L29;
        boolean r8 = false;
    L30:
        DEBUG_VISIBILITY = r8;
        if (DEBUG_ALL_ACTIVITIES == true) goto L33;
        boolean r9 = false;
    L34:
        DEBUG_APP = r9;
        if (DEBUG_ALL_ACTIVITIES == true) goto L37;
        boolean r10 = false;
    L38:
        DEBUG_IDLE = r10;
        if (DEBUG_ALL_ACTIVITIES == true) goto L41;
        boolean r11 = false;
    L42:
        DEBUG_RELEASE = r11;
        if (DEBUG_ALL == true) goto L45;
        boolean r12 = false;
    L46:
        DEBUG_USER_LEAVING = r12;
        if (DEBUG_ALL == true) goto L49;
        boolean r13 = false;
    L50:
        DEBUG_PERMISSIONS_REVIEW = r13;
        if (DEBUG_ALL == true) goto L53;
        boolean r14 = false;
    L54:
        DEBUG_RESULTS = r14;
        if (DEBUG_ALL == true) goto L57;
        boolean r15 = false;
    L58:
        DEBUG_ACTIVITY_STARTS = r15;
        if (DEBUG_ALL == true) goto L61;
        boolean r16 = false;
    L62:
        DEBUG_CLEANUP = r16;
        if (DEBUG_ALL == true) goto L65;
        boolean r17 = false;
    L66:
        DEBUG_METRICS = r17;
        if (DEBUG_ALL == true) goto L69;
        r2 = false;
    L69:
        DEBUG_PREFETCH = r2;
        DEBUG_SERVICETRACKER = false;
        return;
    L65:
        r17 = true;
        goto L66
    L61:
        r16 = true;
        goto L62
    L57:
        r15 = true;
        goto L58
    L53:
        r14 = true;
        goto L54
    L49:
        r13 = true;
        goto L50
    L45:
        r12 = true;
        goto L46
    L41:
        r11 = true;
        goto L42
    L37:
        r10 = true;
        goto L38
    L33:
        r9 = true;
        goto L34
    L29:
        r8 = true;
        goto L30
    L25:
        r7 = true;
        goto L26
    L21:
        r6 = true;
        goto L22
    L17:
        r5 = true;
        goto L18
    L13:
        r4 = true;
        goto L14
    L9:
        r3 = true;
        goto L10
    L5:
        r1 = true;
        goto L6
    }

    protected static void reset() {
        DEBUG_ALL = false;
        boolean r2 = true;
        if (DEBUG_ALL == true) goto L5;
        boolean r1 = false;
    L6:
        DEBUG_ALL_ACTIVITIES = r1;
        if (DEBUG_ALL == true) goto L9;
        boolean r3 = false;
    L10:
        DEBUG_RECENTS = r3;
        if (DEBUG_RECENTS == true) goto L13;
        boolean r4 = false;
    L14:
        DEBUG_RECENTS_TRIM_TASKS = r4;
        if (DEBUG_ALL == true) goto L17;
        boolean r5 = false;
    L18:
        DEBUG_ROOT_TASK = r5;
        if (DEBUG_ALL == true) goto L21;
        boolean r6 = false;
    L22:
        DEBUG_SWITCH = r6;
        if (DEBUG_ALL == true) goto L25;
        boolean r7 = false;
    L26:
        DEBUG_TRANSITION = r7;
        if (DEBUG_ALL == true) goto L29;
        boolean r8 = false;
    L30:
        DEBUG_VISIBILITY = r8;
        if (DEBUG_ALL_ACTIVITIES == true) goto L33;
        boolean r9 = false;
    L34:
        DEBUG_APP = r9;
        if (DEBUG_ALL_ACTIVITIES == true) goto L37;
        boolean r10 = false;
    L38:
        DEBUG_IDLE = r10;
        if (DEBUG_ALL_ACTIVITIES == true) goto L41;
        boolean r11 = false;
    L42:
        DEBUG_RELEASE = r11;
        if (DEBUG_ALL == true) goto L45;
        boolean r12 = false;
    L46:
        DEBUG_USER_LEAVING = r12;
        if (DEBUG_ALL == true) goto L49;
        boolean r13 = false;
    L50:
        DEBUG_PERMISSIONS_REVIEW = r13;
        if (DEBUG_ALL == true) goto L53;
        boolean r14 = false;
    L54:
        DEBUG_RESULTS = r14;
        if (DEBUG_ALL == true) goto L57;
        boolean r15 = false;
    L58:
        DEBUG_ACTIVITY_STARTS = r15;
        if (DEBUG_ALL == true) goto L61;
        boolean r16 = false;
    L62:
        DEBUG_CLEANUP = r16;
        if (DEBUG_ALL == true) goto L65;
        boolean r17 = false;
    L66:
        DEBUG_METRICS = r17;
        if (DEBUG_ALL == true) goto L69;
        r2 = false;
    L69:
        DEBUG_PREFETCH = r2;
        DEBUG_SERVICETRACKER = false;
        return;
    L65:
        r17 = true;
        goto L66
    L61:
        r16 = true;
        goto L62
    L57:
        r15 = true;
        goto L58
    L53:
        r14 = true;
        goto L54
    L49:
        r13 = true;
        goto L50
    L45:
        r12 = true;
        goto L46
    L41:
        r11 = true;
        goto L42
    L37:
        r10 = true;
        goto L38
    L33:
        r9 = true;
        goto L34
    L29:
        r8 = true;
        goto L30
    L25:
        r7 = true;
        goto L26
    L21:
        r6 = true;
        goto L22
    L17:
        r5 = true;
        goto L18
    L13:
        r4 = true;
        goto L14
    L9:
        r3 = true;
        goto L10
    L5:
        r1 = true;
        goto L6
    }
}
