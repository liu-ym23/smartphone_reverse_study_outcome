package com.android.internal.protolog;

import android.os.ServiceManager;
import android.util.Log;
import com.android.internal.protolog.common.IProtoLog;
import com.android.internal.protolog.common.IProtoLogGroup;
import com.android.internal.protolog.common.LogLevel;
import java.io.File;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class ProtoLogImpl_798997914 {
    private static final String LOG_TAG = "ProtoLogImpl";
    private static final ProtoLogCacheUpdater sCacheUpdater = null;
    private static final String sLegacyOutputFilePath = "/data/misc/wmtrace/wm_log.winscope";
    private static final String sLegacyViewerConfigPath = "/system/etc/protolog.conf.json.gz";
    private static final TreeMap<String, IProtoLogGroup> sLogGroups = null;
    private static IProtoLog sServiceInstance = null;
    private static final String sViewerConfigPath = "/etc/core.protolog.pb";

    public static class Cache {
        public static boolean[] TEST_GROUP_enabled;
        public static boolean[] WM_DEBUG_ADD_REMOVE_enabled;
        public static boolean[] WM_DEBUG_ANIM_enabled;
        public static boolean[] WM_DEBUG_APP_TRANSITIONS_ANIM_enabled;
        public static boolean[] WM_DEBUG_APP_TRANSITIONS_enabled;
        public static boolean[] WM_DEBUG_BACK_PREVIEW_enabled;
        public static boolean[] WM_DEBUG_BOOT_enabled;
        public static boolean[] WM_DEBUG_CONFIGURATION_enabled;
        public static boolean[] WM_DEBUG_CONTAINERS_enabled;
        public static boolean[] WM_DEBUG_CONTENT_RECORDING_enabled;
        public static boolean[] WM_DEBUG_DIMMER_enabled;
        public static boolean[] WM_DEBUG_DRAW_enabled;
        public static boolean[] WM_DEBUG_DREAM_enabled;
        public static boolean[] WM_DEBUG_EMBEDDED_WINDOWS_enabled;
        public static boolean[] WM_DEBUG_FOCUS_LIGHT_enabled;
        public static boolean[] WM_DEBUG_FOCUS_enabled;
        public static boolean[] WM_DEBUG_IME_enabled;
        public static boolean[] WM_DEBUG_IMMERSIVE_enabled;
        public static boolean[] WM_DEBUG_KEEP_SCREEN_ON_enabled;
        public static boolean[] WM_DEBUG_LOCKTASK_enabled;
        public static boolean[] WM_DEBUG_ORIENTATION_CHANGE_enabled;
        public static boolean[] WM_DEBUG_ORIENTATION_enabled;
        public static boolean[] WM_DEBUG_PRESENTATION_enabled;
        public static boolean[] WM_DEBUG_RECENTS_ANIMATIONS_enabled;
        public static boolean[] WM_DEBUG_REMOTE_ANIMATIONS_enabled;
        public static boolean[] WM_DEBUG_RESIZE_enabled;
        public static boolean[] WM_DEBUG_SCREEN_ON_enabled;
        public static boolean[] WM_DEBUG_SLEEP_TOKEN_enabled;
        public static boolean[] WM_DEBUG_STARTING_WINDOW_enabled;
        public static boolean[] WM_DEBUG_STATES_enabled;
        public static boolean[] WM_DEBUG_SWITCH_enabled;
        public static boolean[] WM_DEBUG_SYNC_ENGINE_enabled;
        public static boolean[] WM_DEBUG_TASKS_enabled;
        public static boolean[] WM_DEBUG_TPL_enabled;
        public static boolean[] WM_DEBUG_WALLPAPER_enabled;
        public static boolean[] WM_DEBUG_WINDOW_INSETS_enabled;
        public static boolean[] WM_DEBUG_WINDOW_MOVEMENT_enabled;
        public static boolean[] WM_DEBUG_WINDOW_ORGANIZER_enabled;
        public static boolean[] WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled;
        public static boolean[] WM_DEBUG_WINDOW_TRANSITIONS_enabled;
        public static boolean[] WM_ERROR_enabled;
        public static boolean[] WM_SHOW_SURFACE_ALLOC_enabled;
        public static boolean[] WM_SHOW_TRANSACTIONS_enabled;

        /* JADX INFO: renamed from: -$$Nest$smupdate, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m46$$Nest$smupdate(IProtoLog r0) {
            update(r0);
        }

        public Cache() {
        }

        static {
            WM_ERROR_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_ORIENTATION_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_ORIENTATION_CHANGE_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_FOCUS_LIGHT_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_BOOT_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_RESIZE_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_ADD_REMOVE_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_CONFIGURATION_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_SWITCH_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_CONTAINERS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_FOCUS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_IMMERSIVE_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_LOCKTASK_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_STATES_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_TASKS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_STARTING_WINDOW_enabled = new boolean[]{true, true, true, true, true, true};
            WM_SHOW_TRANSACTIONS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_SHOW_SURFACE_ALLOC_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_APP_TRANSITIONS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_ANIM_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_RECENTS_ANIMATIONS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_DRAW_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_REMOTE_ANIMATIONS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_SCREEN_ON_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_KEEP_SCREEN_ON_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_SLEEP_TOKEN_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WINDOW_MOVEMENT_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_IME_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WINDOW_ORGANIZER_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_SYNC_ENGINE_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WINDOW_TRANSITIONS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WINDOW_INSETS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_CONTENT_RECORDING_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_WALLPAPER_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_BACK_PREVIEW_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_DREAM_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_DIMMER_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_TPL_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_EMBEDDED_WINDOWS_enabled = new boolean[]{true, true, true, true, true, true};
            WM_DEBUG_PRESENTATION_enabled = new boolean[]{true, true, true, true, true, true};
            TEST_GROUP_enabled = new boolean[]{true, true, true, true, true, true};
        }

        private static void update(IProtoLog protoLogInstance) {
            WM_ERROR_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.DEBUG);
            WM_ERROR_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.VERBOSE);
            WM_ERROR_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.INFO);
            WM_ERROR_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.WARN);
            WM_ERROR_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.ERROR);
            WM_ERROR_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_ERROR, LogLevel.WTF);
            WM_DEBUG_ORIENTATION_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.DEBUG);
            WM_DEBUG_ORIENTATION_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.VERBOSE);
            WM_DEBUG_ORIENTATION_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.INFO);
            WM_DEBUG_ORIENTATION_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.WARN);
            WM_DEBUG_ORIENTATION_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.ERROR);
            WM_DEBUG_ORIENTATION_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION, LogLevel.WTF);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.DEBUG);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.VERBOSE);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.INFO);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.WARN);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.ERROR);
            WM_DEBUG_ORIENTATION_CHANGE_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE, LogLevel.WTF);
            WM_DEBUG_FOCUS_LIGHT_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.DEBUG);
            WM_DEBUG_FOCUS_LIGHT_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.VERBOSE);
            WM_DEBUG_FOCUS_LIGHT_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.INFO);
            WM_DEBUG_FOCUS_LIGHT_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.WARN);
            WM_DEBUG_FOCUS_LIGHT_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.ERROR);
            WM_DEBUG_FOCUS_LIGHT_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, LogLevel.WTF);
            WM_DEBUG_BOOT_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.DEBUG);
            WM_DEBUG_BOOT_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.VERBOSE);
            WM_DEBUG_BOOT_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.INFO);
            WM_DEBUG_BOOT_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.WARN);
            WM_DEBUG_BOOT_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.ERROR);
            WM_DEBUG_BOOT_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BOOT, LogLevel.WTF);
            WM_DEBUG_RESIZE_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.DEBUG);
            WM_DEBUG_RESIZE_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.VERBOSE);
            WM_DEBUG_RESIZE_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.INFO);
            WM_DEBUG_RESIZE_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.WARN);
            WM_DEBUG_RESIZE_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.ERROR);
            WM_DEBUG_RESIZE_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RESIZE, LogLevel.WTF);
            WM_DEBUG_ADD_REMOVE_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.DEBUG);
            WM_DEBUG_ADD_REMOVE_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.VERBOSE);
            WM_DEBUG_ADD_REMOVE_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.INFO);
            WM_DEBUG_ADD_REMOVE_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.WARN);
            WM_DEBUG_ADD_REMOVE_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.ERROR);
            WM_DEBUG_ADD_REMOVE_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, LogLevel.WTF);
            WM_DEBUG_CONFIGURATION_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.DEBUG);
            WM_DEBUG_CONFIGURATION_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.VERBOSE);
            WM_DEBUG_CONFIGURATION_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.INFO);
            WM_DEBUG_CONFIGURATION_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.WARN);
            WM_DEBUG_CONFIGURATION_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.ERROR);
            WM_DEBUG_CONFIGURATION_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONFIGURATION, LogLevel.WTF);
            WM_DEBUG_SWITCH_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.DEBUG);
            WM_DEBUG_SWITCH_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.VERBOSE);
            WM_DEBUG_SWITCH_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.INFO);
            WM_DEBUG_SWITCH_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.WARN);
            WM_DEBUG_SWITCH_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.ERROR);
            WM_DEBUG_SWITCH_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SWITCH, LogLevel.WTF);
            WM_DEBUG_CONTAINERS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.DEBUG);
            WM_DEBUG_CONTAINERS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.VERBOSE);
            WM_DEBUG_CONTAINERS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.INFO);
            WM_DEBUG_CONTAINERS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.WARN);
            WM_DEBUG_CONTAINERS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.ERROR);
            WM_DEBUG_CONTAINERS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTAINERS, LogLevel.WTF);
            WM_DEBUG_FOCUS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.DEBUG);
            WM_DEBUG_FOCUS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.VERBOSE);
            WM_DEBUG_FOCUS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.INFO);
            WM_DEBUG_FOCUS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.WARN);
            WM_DEBUG_FOCUS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.ERROR);
            WM_DEBUG_FOCUS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_FOCUS, LogLevel.WTF);
            WM_DEBUG_IMMERSIVE_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.DEBUG);
            WM_DEBUG_IMMERSIVE_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.VERBOSE);
            WM_DEBUG_IMMERSIVE_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.INFO);
            WM_DEBUG_IMMERSIVE_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.WARN);
            WM_DEBUG_IMMERSIVE_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.ERROR);
            WM_DEBUG_IMMERSIVE_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IMMERSIVE, LogLevel.WTF);
            WM_DEBUG_LOCKTASK_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.DEBUG);
            WM_DEBUG_LOCKTASK_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.VERBOSE);
            WM_DEBUG_LOCKTASK_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.INFO);
            WM_DEBUG_LOCKTASK_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.WARN);
            WM_DEBUG_LOCKTASK_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.ERROR);
            WM_DEBUG_LOCKTASK_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_LOCKTASK, LogLevel.WTF);
            WM_DEBUG_STATES_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.DEBUG);
            WM_DEBUG_STATES_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.VERBOSE);
            WM_DEBUG_STATES_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.INFO);
            WM_DEBUG_STATES_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.WARN);
            WM_DEBUG_STATES_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.ERROR);
            WM_DEBUG_STATES_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STATES, LogLevel.WTF);
            WM_DEBUG_TASKS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.DEBUG);
            WM_DEBUG_TASKS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.VERBOSE);
            WM_DEBUG_TASKS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.INFO);
            WM_DEBUG_TASKS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.WARN);
            WM_DEBUG_TASKS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.ERROR);
            WM_DEBUG_TASKS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TASKS, LogLevel.WTF);
            WM_DEBUG_STARTING_WINDOW_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.DEBUG);
            WM_DEBUG_STARTING_WINDOW_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.VERBOSE);
            WM_DEBUG_STARTING_WINDOW_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.INFO);
            WM_DEBUG_STARTING_WINDOW_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.WARN);
            WM_DEBUG_STARTING_WINDOW_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.ERROR);
            WM_DEBUG_STARTING_WINDOW_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, LogLevel.WTF);
            WM_SHOW_TRANSACTIONS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.DEBUG);
            WM_SHOW_TRANSACTIONS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.VERBOSE);
            WM_SHOW_TRANSACTIONS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.INFO);
            WM_SHOW_TRANSACTIONS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.WARN);
            WM_SHOW_TRANSACTIONS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.ERROR);
            WM_SHOW_TRANSACTIONS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_TRANSACTIONS, LogLevel.WTF);
            WM_SHOW_SURFACE_ALLOC_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.DEBUG);
            WM_SHOW_SURFACE_ALLOC_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.VERBOSE);
            WM_SHOW_SURFACE_ALLOC_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.INFO);
            WM_SHOW_SURFACE_ALLOC_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.WARN);
            WM_SHOW_SURFACE_ALLOC_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.ERROR);
            WM_SHOW_SURFACE_ALLOC_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, LogLevel.WTF);
            WM_DEBUG_APP_TRANSITIONS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.DEBUG);
            WM_DEBUG_APP_TRANSITIONS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.VERBOSE);
            WM_DEBUG_APP_TRANSITIONS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.INFO);
            WM_DEBUG_APP_TRANSITIONS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.WARN);
            WM_DEBUG_APP_TRANSITIONS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.ERROR);
            WM_DEBUG_APP_TRANSITIONS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, LogLevel.WTF);
            WM_DEBUG_ANIM_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.DEBUG);
            WM_DEBUG_ANIM_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.VERBOSE);
            WM_DEBUG_ANIM_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.INFO);
            WM_DEBUG_ANIM_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.WARN);
            WM_DEBUG_ANIM_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.ERROR);
            WM_DEBUG_ANIM_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.WTF);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.DEBUG);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.VERBOSE);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.INFO);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.WARN);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.ERROR);
            WM_DEBUG_APP_TRANSITIONS_ANIM_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM, LogLevel.WTF);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.DEBUG);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.VERBOSE);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.INFO);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.WARN);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.ERROR);
            WM_DEBUG_RECENTS_ANIMATIONS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS, LogLevel.WTF);
            WM_DEBUG_DRAW_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.DEBUG);
            WM_DEBUG_DRAW_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.VERBOSE);
            WM_DEBUG_DRAW_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.INFO);
            WM_DEBUG_DRAW_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.WARN);
            WM_DEBUG_DRAW_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.ERROR);
            WM_DEBUG_DRAW_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DRAW, LogLevel.WTF);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.DEBUG);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.VERBOSE);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.INFO);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.WARN);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.ERROR);
            WM_DEBUG_REMOTE_ANIMATIONS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS, LogLevel.WTF);
            WM_DEBUG_SCREEN_ON_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.DEBUG);
            WM_DEBUG_SCREEN_ON_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.VERBOSE);
            WM_DEBUG_SCREEN_ON_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.INFO);
            WM_DEBUG_SCREEN_ON_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.WARN);
            WM_DEBUG_SCREEN_ON_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.ERROR);
            WM_DEBUG_SCREEN_ON_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SCREEN_ON, LogLevel.WTF);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.DEBUG);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.VERBOSE);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.INFO);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.WARN);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.ERROR);
            WM_DEBUG_KEEP_SCREEN_ON_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON, LogLevel.WTF);
            WM_DEBUG_SLEEP_TOKEN_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.DEBUG);
            WM_DEBUG_SLEEP_TOKEN_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.VERBOSE);
            WM_DEBUG_SLEEP_TOKEN_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.INFO);
            WM_DEBUG_SLEEP_TOKEN_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.WARN);
            WM_DEBUG_SLEEP_TOKEN_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.ERROR);
            WM_DEBUG_SLEEP_TOKEN_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN, LogLevel.WTF);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.DEBUG);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.VERBOSE);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.INFO);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.WARN);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.ERROR);
            WM_DEBUG_WINDOW_MOVEMENT_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, LogLevel.WTF);
            WM_DEBUG_IME_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.DEBUG);
            WM_DEBUG_IME_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.VERBOSE);
            WM_DEBUG_IME_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.INFO);
            WM_DEBUG_IME_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.WARN);
            WM_DEBUG_IME_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.ERROR);
            WM_DEBUG_IME_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_IME, LogLevel.WTF);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.DEBUG);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.VERBOSE);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.INFO);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.WARN);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.ERROR);
            WM_DEBUG_WINDOW_ORGANIZER_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER, LogLevel.WTF);
            WM_DEBUG_SYNC_ENGINE_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.DEBUG);
            WM_DEBUG_SYNC_ENGINE_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.VERBOSE);
            WM_DEBUG_SYNC_ENGINE_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.INFO);
            WM_DEBUG_SYNC_ENGINE_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.WARN);
            WM_DEBUG_SYNC_ENGINE_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.ERROR);
            WM_DEBUG_SYNC_ENGINE_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, LogLevel.WTF);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.DEBUG);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.VERBOSE);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.INFO);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.WARN);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.ERROR);
            WM_DEBUG_WINDOW_TRANSITIONS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS, LogLevel.WTF);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.DEBUG);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.VERBOSE);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.INFO);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.WARN);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.ERROR);
            WM_DEBUG_WINDOW_TRANSITIONS_MIN_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN, LogLevel.WTF);
            WM_DEBUG_WINDOW_INSETS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.DEBUG);
            WM_DEBUG_WINDOW_INSETS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.VERBOSE);
            WM_DEBUG_WINDOW_INSETS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.INFO);
            WM_DEBUG_WINDOW_INSETS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.WARN);
            WM_DEBUG_WINDOW_INSETS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.ERROR);
            WM_DEBUG_WINDOW_INSETS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, LogLevel.WTF);
            WM_DEBUG_CONTENT_RECORDING_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.DEBUG);
            WM_DEBUG_CONTENT_RECORDING_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.VERBOSE);
            WM_DEBUG_CONTENT_RECORDING_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.INFO);
            WM_DEBUG_CONTENT_RECORDING_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.WARN);
            WM_DEBUG_CONTENT_RECORDING_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.ERROR);
            WM_DEBUG_CONTENT_RECORDING_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING, LogLevel.WTF);
            WM_DEBUG_WALLPAPER_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.DEBUG);
            WM_DEBUG_WALLPAPER_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.VERBOSE);
            WM_DEBUG_WALLPAPER_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.INFO);
            WM_DEBUG_WALLPAPER_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.WARN);
            WM_DEBUG_WALLPAPER_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.ERROR);
            WM_DEBUG_WALLPAPER_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_WALLPAPER, LogLevel.WTF);
            WM_DEBUG_BACK_PREVIEW_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.DEBUG);
            WM_DEBUG_BACK_PREVIEW_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.VERBOSE);
            WM_DEBUG_BACK_PREVIEW_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.INFO);
            WM_DEBUG_BACK_PREVIEW_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.WARN);
            WM_DEBUG_BACK_PREVIEW_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.ERROR);
            WM_DEBUG_BACK_PREVIEW_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, LogLevel.WTF);
            WM_DEBUG_DREAM_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.DEBUG);
            WM_DEBUG_DREAM_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.VERBOSE);
            WM_DEBUG_DREAM_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.INFO);
            WM_DEBUG_DREAM_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.WARN);
            WM_DEBUG_DREAM_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.ERROR);
            WM_DEBUG_DREAM_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DREAM, LogLevel.WTF);
            WM_DEBUG_DIMMER_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.DEBUG);
            WM_DEBUG_DIMMER_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.VERBOSE);
            WM_DEBUG_DIMMER_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.INFO);
            WM_DEBUG_DIMMER_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.WARN);
            WM_DEBUG_DIMMER_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.ERROR);
            WM_DEBUG_DIMMER_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_DIMMER, LogLevel.WTF);
            WM_DEBUG_TPL_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.DEBUG);
            WM_DEBUG_TPL_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.VERBOSE);
            WM_DEBUG_TPL_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.INFO);
            WM_DEBUG_TPL_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.WARN);
            WM_DEBUG_TPL_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.ERROR);
            WM_DEBUG_TPL_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_TPL, LogLevel.WTF);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.DEBUG);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.VERBOSE);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.INFO);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.WARN);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.ERROR);
            WM_DEBUG_EMBEDDED_WINDOWS_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS, LogLevel.WTF);
            WM_DEBUG_PRESENTATION_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.DEBUG);
            WM_DEBUG_PRESENTATION_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.VERBOSE);
            WM_DEBUG_PRESENTATION_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.INFO);
            WM_DEBUG_PRESENTATION_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.WARN);
            WM_DEBUG_PRESENTATION_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.ERROR);
            WM_DEBUG_PRESENTATION_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.WM_DEBUG_PRESENTATION, LogLevel.WTF);
            TEST_GROUP_enabled[0] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.DEBUG);
            TEST_GROUP_enabled[1] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.VERBOSE);
            TEST_GROUP_enabled[2] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.INFO);
            TEST_GROUP_enabled[3] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.WARN);
            TEST_GROUP_enabled[4] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.ERROR);
            TEST_GROUP_enabled[5] = ProtoLogImpl_798997914.m45$$Nest$smisEnabled(protoLogInstance, WmProtoLogGroups.TEST_GROUP, LogLevel.WTF);
        }
    }

    public static /* synthetic */ void $r8$lambda$YxpC1gtF2uoYmq6rmPOEQTn7Eno(IProtoLog r0) {
        Cache.m46$$Nest$smupdate(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smisEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m45$$Nest$smisEnabled(IProtoLog r0, IProtoLogGroup r1, LogLevel r2) {
        return isEnabled(r0, r1, r2);
    }

    public ProtoLogImpl_798997914() {
    }

    static {
        sServiceInstance = null;
        sLogGroups = createLogGroupsMap();
        sCacheUpdater = new ProtoLogImpl_798997914$$ExternalSyntheticLambda0();
    }

    public static void d(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.DEBUG, group, messageHash, paramsMask, args);
    }

    public static void v(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.VERBOSE, group, messageHash, paramsMask, args);
    }

    public static void i(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.INFO, group, messageHash, paramsMask, args);
    }

    public static void w(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.WARN, group, messageHash, paramsMask, args);
    }

    public static void e(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.ERROR, group, messageHash, paramsMask, args);
    }

    public static void wtf(IProtoLogGroup group, long messageHash, int paramsMask, Object... args) {
        getSingleInstance().log(LogLevel.WTF, group, messageHash, paramsMask, args);
    }

    public static boolean isEnabled(IProtoLogGroup group, LogLevel level) {
        return isEnabled(getSingleInstance(), group, level);
    }

    private static boolean isEnabled(IProtoLog protoLogInstance, IProtoLogGroup group, LogLevel level) {
        return protoLogInstance.isEnabled(group, level);
    }

    public static synchronized IProtoLog getSingleInstance() {
        monitor-enter(ProtoLogImpl_798997914.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sServiceInstance != null) goto L18;
        Log.i(LOG_TAG, "Setting up " + ProtoLogImpl.class.getSimpleName() + " with viewerConfigPath = " + sViewerConfigPath);     // Catch: Throwable -> L9
        IProtoLogGroup[] groups = (IProtoLogGroup[]) sLogGroups.values().toArray(new IProtoLogGroup[0]);     // Catch: Throwable -> L9
        File viewerConfigFile = new File(sViewerConfigPath);     // Catch: Throwable -> L9
        if (viewerConfigFile.exists() == true) goto L11;
        Log.e(LOG_TAG, "Failed to find viewer config file /etc/core.protolog.pb when setting up " + ProtoLogImpl.class.getSimpleName() + ". ProtoLog will not work here!");     // Catch: Throwable -> L9
        sServiceInstance = new NoViewerConfigProtoLogImpl();     // Catch: Throwable -> L9
    L14:
        sCacheUpdater.update(sServiceInstance);     // Catch: Throwable -> L9
        goto L18
    L11:
        ProtoLogDataSource datasource = ProtoLog.getSharedSingleInstanceDataSource();     // Catch: Throwable -> L9
        ProcessedPerfettoProtoLogImpl processedProtoLogImpl = new ProcessedPerfettoProtoLogImpl(datasource, sViewerConfigPath, sCacheUpdater, groups);     // Catch: Throwable -> L9 ServiceManager.ServiceNotFoundException -> L15
        sServiceInstance = processedProtoLogImpl;     // Catch: Throwable -> L9 ServiceManager.ServiceNotFoundException -> L15
        processedProtoLogImpl.enable();     // Catch: Throwable -> L9 ServiceManager.ServiceNotFoundException -> L15
    L15:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L18:
        IProtoLog r1 = sServiceInstance;     // Catch: Throwable -> L9
        monitor-exit(ProtoLogImpl_798997914.class);
        return r1;
    }

    private static LegacyProtoLogImpl createLegacyProtoLogImpl(IProtoLogGroup[] groups) {
        LegacyProtoLogImpl protologImpl = new LegacyProtoLogImpl(sLegacyOutputFilePath, sLegacyViewerConfigPath, sCacheUpdater);
        protologImpl.registerGroups(groups);
        return protologImpl;
    }

    public static synchronized void setSingleInstance(IProtoLog instance) {
        monitor-enter(ProtoLogImpl_798997914.class);
        sServiceInstance = instance;     // Catch: Throwable -> L7
        monitor-exit(ProtoLogImpl_798997914.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static final TreeMap<String, IProtoLogGroup> createLogGroupsMap() {
        TreeMap<String, IProtoLogGroup> result = new TreeMap();
        result.put("WM_ERROR", WmProtoLogGroups.WM_ERROR);
        result.put("WM_DEBUG_ORIENTATION", WmProtoLogGroups.WM_DEBUG_ORIENTATION);
        result.put("WM_DEBUG_ORIENTATION_CHANGE", WmProtoLogGroups.WM_DEBUG_ORIENTATION_CHANGE);
        result.put("WM_DEBUG_FOCUS_LIGHT", WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT);
        result.put("WM_DEBUG_BOOT", WmProtoLogGroups.WM_DEBUG_BOOT);
        result.put("WM_DEBUG_RESIZE", WmProtoLogGroups.WM_DEBUG_RESIZE);
        result.put("WM_DEBUG_ADD_REMOVE", WmProtoLogGroups.WM_DEBUG_ADD_REMOVE);
        result.put("WM_DEBUG_CONFIGURATION", WmProtoLogGroups.WM_DEBUG_CONFIGURATION);
        result.put("WM_DEBUG_SWITCH", WmProtoLogGroups.WM_DEBUG_SWITCH);
        result.put("WM_DEBUG_CONTAINERS", WmProtoLogGroups.WM_DEBUG_CONTAINERS);
        result.put("WM_DEBUG_FOCUS", WmProtoLogGroups.WM_DEBUG_FOCUS);
        result.put("WM_DEBUG_IMMERSIVE", WmProtoLogGroups.WM_DEBUG_IMMERSIVE);
        result.put("WM_DEBUG_LOCKTASK", WmProtoLogGroups.WM_DEBUG_LOCKTASK);
        result.put("WM_DEBUG_STATES", WmProtoLogGroups.WM_DEBUG_STATES);
        result.put("WM_DEBUG_TASKS", WmProtoLogGroups.WM_DEBUG_TASKS);
        result.put("WM_DEBUG_STARTING_WINDOW", WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW);
        result.put("WM_SHOW_TRANSACTIONS", WmProtoLogGroups.WM_SHOW_TRANSACTIONS);
        result.put("WM_SHOW_SURFACE_ALLOC", WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC);
        result.put("WM_DEBUG_APP_TRANSITIONS", WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS);
        result.put("WM_DEBUG_ANIM", WmProtoLogGroups.WM_DEBUG_ANIM);
        result.put("WM_DEBUG_APP_TRANSITIONS_ANIM", WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS_ANIM);
        result.put("WM_DEBUG_RECENTS_ANIMATIONS", WmProtoLogGroups.WM_DEBUG_RECENTS_ANIMATIONS);
        result.put("WM_DEBUG_DRAW", WmProtoLogGroups.WM_DEBUG_DRAW);
        result.put("WM_DEBUG_REMOTE_ANIMATIONS", WmProtoLogGroups.WM_DEBUG_REMOTE_ANIMATIONS);
        result.put("WM_DEBUG_SCREEN_ON", WmProtoLogGroups.WM_DEBUG_SCREEN_ON);
        result.put("WM_DEBUG_KEEP_SCREEN_ON", WmProtoLogGroups.WM_DEBUG_KEEP_SCREEN_ON);
        result.put("WM_DEBUG_SLEEP_TOKEN", WmProtoLogGroups.WM_DEBUG_SLEEP_TOKEN);
        result.put("WM_DEBUG_WINDOW_MOVEMENT", WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT);
        result.put("WM_DEBUG_IME", WmProtoLogGroups.WM_DEBUG_IME);
        result.put("WM_DEBUG_WINDOW_ORGANIZER", WmProtoLogGroups.WM_DEBUG_WINDOW_ORGANIZER);
        result.put("WM_DEBUG_SYNC_ENGINE", WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE);
        result.put("WM_DEBUG_WINDOW_TRANSITIONS", WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS);
        result.put("WM_DEBUG_WINDOW_TRANSITIONS_MIN", WmProtoLogGroups.WM_DEBUG_WINDOW_TRANSITIONS_MIN);
        result.put("WM_DEBUG_WINDOW_INSETS", WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS);
        result.put("WM_DEBUG_CONTENT_RECORDING", WmProtoLogGroups.WM_DEBUG_CONTENT_RECORDING);
        result.put("WM_DEBUG_WALLPAPER", WmProtoLogGroups.WM_DEBUG_WALLPAPER);
        result.put("WM_DEBUG_BACK_PREVIEW", WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW);
        result.put("WM_DEBUG_DREAM", WmProtoLogGroups.WM_DEBUG_DREAM);
        result.put("WM_DEBUG_DIMMER", WmProtoLogGroups.WM_DEBUG_DIMMER);
        result.put("WM_DEBUG_TPL", WmProtoLogGroups.WM_DEBUG_TPL);
        result.put("WM_DEBUG_EMBEDDED_WINDOWS", WmProtoLogGroups.WM_DEBUG_EMBEDDED_WINDOWS);
        result.put("WM_DEBUG_PRESENTATION", WmProtoLogGroups.WM_DEBUG_PRESENTATION);
        result.put("TEST_GROUP", WmProtoLogGroups.TEST_GROUP);
        return result;
    }
}
