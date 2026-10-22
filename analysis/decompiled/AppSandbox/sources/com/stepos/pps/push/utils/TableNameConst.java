package com.stepos.pps.push.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TableNameConst {
    public static final int APPMANAGER_BIG_INDEX = 3;
    public static final String APPMANAGER_BIG_TABLE = "appmanager_big";
    public static final int APPMANAGER_CORE_INDEX = 4;
    public static final String APPMANAGER_CORE_TABLE = "appmanager_core";
    public static final int APPMANAGER_FREEZE_MUSIC_INDEX = 13;
    public static final String APPMANAGER_FREEZE_MUSIC_TABLE = "appmanager_freeze_music";
    public static final int APPMANAGER_FREEZE_WHITE_INDEX = 16;
    public static final String APPMANAGER_FREEZE_WHITE_TABLE = "appmanager_freeze_white";
    public static final int APPMANAGER_HOT_APP_INDEX = 17;
    public static final String APPMANAGER_HOT_APP_TABLE = "appmanager_hot_app";
    public static final int APPMANAGER_IGNORE_INDEX = 6;
    public static final String APPMANAGER_IGNORE_TABLE = "appmanager_ignore";
    public static final int APPMANAGER_NAVIGATION_INDEX = 7;
    public static final String APPMANAGER_NAVIGATION_TABLE = "appmanager_navigation";
    public static final int APPMANAGER_NON_RESIDENT_INDEX = 18;
    public static final String APPMANAGER_NON_RESIDENT_TABLE = "appmanager_non_resident";
    public static final int APPMANAGER_NORMAL_WHITE_INDEX = 1;
    public static final int APPMANAGER_NORMAL_WHITE_INTL_INDEX = 2;
    public static final String APPMANAGER_NORMAL_WHITE_INTL_TABLE = "appmanager_normal_white_intl";
    public static final String APPMANAGER_NORMAL_WHITE_TABLE = "appmanager_normal_white";
    public static final int APPMANAGER_PERSIST_APP_INDEX = 14;
    public static final String APPMANAGER_PERSIST_APP_TABLE = "appmanager_persistent_app";
    public static final int APPMANAGER_RUNNING_INDEX = 9;
    public static final String APPMANAGER_RUNNING_TABLE = "appmanager_running";
    public static final int APPMANAGER_STEP_INDEX = 8;
    public static final String APPMANAGER_STEP_TABLE = "appmanager_step";
    public static final int APPMANAGER_SUPER_BLACK_INDEX = 11;
    public static final String APPMANAGER_SUPER_BLACK_TABLE = "appmanager_super_black";
    public static final int APPMANAGER_SUPER_WHITE_INDEX = 0;
    public static final String APPMANAGER_SUPER_WHITE_TABLE = "appmanager_super_white";
    public static final int APPMANAGER_SYSTEM_BLACK_INDEX = 10;
    public static final String APPMANAGER_SYSTEM_BLACK_TABLE = "appmanager_system_black";
    public static final int APPMANAGER_SYSTEM_FREEZE_INDEX = 15;
    public static final String APPMANAGER_SYSTEM_FREEZE_TABLE = "appmanager_system_freeze";
    public static final int APPMANAGER_SYSTEM_INDEX = 5;
    public static final String APPMANAGER_SYSTEM_TABLE = "appmanager_system";
    public static final Map<Integer, String> APPMANAGER_TYPES;
    public static final int DOZE_WHITE_INDEX = 12;
    public static final String DOZE_WHITE_TABLE = "doze_white";
    public static final int FIRST_INDEX = 0;
    public static final int WINDOW_MODE_INPUT_INDEX = 19;
    public static final String WINDOW_MODE_INPUT_TABLE = "window_mode_input_method";

    static {
        HashMap map = new HashMap();
        APPMANAGER_TYPES = map;
        map.put(0, APPMANAGER_SUPER_WHITE_TABLE);
        map.put(1, APPMANAGER_NORMAL_WHITE_TABLE);
        map.put(2, APPMANAGER_NORMAL_WHITE_INTL_TABLE);
        map.put(3, APPMANAGER_BIG_TABLE);
        map.put(4, APPMANAGER_CORE_TABLE);
        map.put(5, APPMANAGER_SYSTEM_TABLE);
        map.put(6, APPMANAGER_IGNORE_TABLE);
        map.put(7, APPMANAGER_NAVIGATION_TABLE);
        map.put(8, APPMANAGER_STEP_TABLE);
        map.put(9, APPMANAGER_RUNNING_TABLE);
        map.put(10, APPMANAGER_SYSTEM_BLACK_TABLE);
        map.put(11, APPMANAGER_SUPER_BLACK_TABLE);
        map.put(12, DOZE_WHITE_TABLE);
        map.put(13, APPMANAGER_FREEZE_MUSIC_TABLE);
        map.put(14, APPMANAGER_PERSIST_APP_TABLE);
        map.put(15, APPMANAGER_SYSTEM_FREEZE_TABLE);
        map.put(16, APPMANAGER_FREEZE_WHITE_TABLE);
        map.put(17, APPMANAGER_HOT_APP_TABLE);
        map.put(18, APPMANAGER_NON_RESIDENT_TABLE);
        map.put(19, WINDOW_MODE_INPUT_TABLE);
    }
}
