package com.android.server.am;

import android.util.LogWriter;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerDebugConfig {
    static final boolean APPEND_CATEGORY_NAME = false;
    static final boolean DEBUG_ALL = false;
    static boolean DEBUG_ALLOWLISTS = false;
    static boolean DEBUG_ANR = false;
    static boolean DEBUG_BACKGROUND_CHECK = false;
    static boolean DEBUG_BACKUP = false;
    static boolean DEBUG_BROADCAST = false;
    static boolean DEBUG_BROADCAST_LIGHT = false;
    static boolean DEBUG_COMPACTION = false;
    static boolean DEBUG_FOREGROUND_SERVICE = false;
    static boolean DEBUG_FREEZER = false;
    static boolean DEBUG_LRU = false;
    static boolean DEBUG_MU = false;
    static boolean DEBUG_NETWORK = false;
    static boolean DEBUG_OOM_ADJ = false;
    static boolean DEBUG_OOM_ADJ_REASON = false;
    static boolean DEBUG_PERMISSIONS_REVIEW = false;
    static boolean DEBUG_POWER = false;
    static boolean DEBUG_POWER_QUICK = false;
    static boolean DEBUG_PREFETCH = false;
    static boolean DEBUG_PROCESSES = false;
    static boolean DEBUG_PROCESS_OBSERVERS = false;
    static boolean DEBUG_PROVIDER = false;
    static boolean DEBUG_PSS = false;
    static boolean DEBUG_RSS = false;
    static boolean DEBUG_SERVICE = false;
    static boolean DEBUG_SERVICE_EXECUTING = false;
    static boolean DEBUG_UID_OBSERVERS = false;
    static boolean DEBUG_USAGE_STATS = false;
    static final PrintWriter LOG_WRITER_INFO = null;
    static final String POSTFIX_BACKUP = "";
    static final String POSTFIX_BROADCAST = "";
    static final String POSTFIX_CLEANUP = "";
    static final String POSTFIX_LRU = "";
    static final String POSTFIX_MU = "_MU";
    static final String POSTFIX_NETWORK = "_Network";
    static final String POSTFIX_OOM_ADJ = "";
    static final String POSTFIX_POWER = "";
    static final String POSTFIX_PROCESSES = "";
    static final String POSTFIX_PROCESS_OBSERVERS = "";
    static final String POSTFIX_PSS = "";
    static final String POSTFIX_RSS = "";
    static final String POSTFIX_SERVICE = "";
    static final String POSTFIX_SERVICE_EXECUTING = "";
    static final String POSTFIX_UID_OBSERVERS = "";
    static final String TAG_AM = "ActivityManager";
    static final boolean TAG_WITH_CLASS_NAME = false;

    public ActivityManagerDebugConfig() {
    }

    static {
        LOG_WRITER_INFO = new PrintWriter(new LogWriter(4, TAG_AM));
        DEBUG_ANR = false;
        DEBUG_BACKGROUND_CHECK = false;
        DEBUG_BACKUP = false;
        DEBUG_BROADCAST = false;
        boolean r2 = true;
        if (DEBUG_BROADCAST == true) goto L5;
        boolean r1 = false;
    L6:
        DEBUG_BROADCAST_LIGHT = r1;
        DEBUG_COMPACTION = false;
        DEBUG_FREEZER = false;
        DEBUG_LRU = false;
        DEBUG_MU = false;
        DEBUG_NETWORK = false;
        DEBUG_OOM_ADJ = false;
        DEBUG_OOM_ADJ_REASON = false;
        DEBUG_POWER = false;
        if (DEBUG_POWER == true) goto L9;
        r2 = false;
    L9:
        DEBUG_POWER_QUICK = r2;
        DEBUG_PROCESS_OBSERVERS = false;
        DEBUG_PROCESSES = false;
        DEBUG_PROVIDER = false;
        DEBUG_PSS = false;
        DEBUG_RSS = false;
        DEBUG_SERVICE = false;
        DEBUG_FOREGROUND_SERVICE = false;
        DEBUG_SERVICE_EXECUTING = false;
        DEBUG_UID_OBSERVERS = false;
        DEBUG_USAGE_STATS = false;
        DEBUG_PERMISSIONS_REVIEW = false;
        DEBUG_ALLOWLISTS = false;
        DEBUG_PREFETCH = false;
        return;
    L5:
        r1 = true;
        goto L6
    }

    public static void reset() {
        DEBUG_ANR = false;
        DEBUG_BACKGROUND_CHECK = false;
        DEBUG_BACKUP = false;
        DEBUG_BROADCAST = false;
        boolean r2 = true;
        if (DEBUG_BROADCAST == true) goto L5;
        boolean r1 = false;
    L6:
        DEBUG_BROADCAST_LIGHT = r1;
        DEBUG_COMPACTION = false;
        DEBUG_FREEZER = false;
        DEBUG_LRU = false;
        DEBUG_MU = false;
        DEBUG_NETWORK = false;
        DEBUG_OOM_ADJ = false;
        DEBUG_OOM_ADJ_REASON = false;
        DEBUG_POWER = false;
        if (DEBUG_POWER == true) goto L9;
        r2 = false;
    L9:
        DEBUG_POWER_QUICK = r2;
        DEBUG_PROCESS_OBSERVERS = false;
        DEBUG_PROCESSES = false;
        DEBUG_PROVIDER = false;
        DEBUG_PSS = false;
        DEBUG_RSS = false;
        DEBUG_SERVICE = false;
        DEBUG_FOREGROUND_SERVICE = false;
        DEBUG_SERVICE_EXECUTING = false;
        DEBUG_UID_OBSERVERS = false;
        DEBUG_USAGE_STATS = false;
        DEBUG_PERMISSIONS_REVIEW = false;
        DEBUG_ALLOWLISTS = false;
        return;
    L5:
        r1 = true;
        goto L6
    }
}
