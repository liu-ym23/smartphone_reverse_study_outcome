package com.stepos.pps.reflect;

import android.content.SharedPreferences;
import com.stepos.pps.PPSApplication;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class PPSSharePreference {
    public static final String ANIMATOR_DURATION_BEFORE_POWER_MODE_SUPPER = "animator_duration";
    public static final String IS_POWER_TIMER_BOOT_START = "is_power_timer_boot_start";
    public static final String KEY_DIAL_ACTIVITY_NAME = "dial_activity_name";
    public static final String KEY_DIAL_PACKAGE_NAME = "dial_package_name";
    public static final String KEY_EDIT_ACTIVITY_NAME = "edit_activity_name";
    public static final String KEY_EDIT_PACKAGE_NAME = "edit_package_name";
    public static final String KEY_ENTER_LOW_POWER_BATTERY_LEVEL = "enter_low_power_battery_level";
    public static final String KEY_EXCEPTION_NOTICE = "exception_notice";
    public static final String KEY_HAS_START_POWER_MODE_MTJ = "has_start_power_mode_mtj";
    public static final String KEY_INSERT_ACTIVITY_NAME = "insert_activity_name";
    public static final String KEY_INSERT_OR_EDIT_ACTIVITY_NAME = "insert_or_edit_activity_name";
    public static final String KEY_INSERT_OR_EDIT_PACKAGE_NAME = "insert_or_edit_package_name";
    public static final String KEY_INSERT_PACKAGE_NAME = "insert_package_name";
    public static final String KEY_IS_POWER_MODE_MTJ_BOOT = "is_power_mode_mtj_boot";
    public static final String KEY_MTJ_LAST_RECORD_TIME = "mtj_last_record_time";
    public static final String KEY_POWER_MODE_ENTRY_WAY = "power_mode_entry_way";
    public static final String KEY_VICE_SCREEN = "vice_screen";
    public static final String KEY_VIEW_ACTIVITY_NAME = "view_activity_name";
    public static final String KEY_VIEW_PACKAGE_NAME = "view_package_name";
    public static final String LOAD_DB = "database_load";
    public static final String POWER_MODE_DB_INITED = "power_mode_db_inited";
    public static final String POWER_MODE_REFERESH_INITED = "power_mode_refresh_inited";
    public static final String POWER_SETTING_DB_INITED = "power_setting_db_inited";
    public static final String SHARED_PREFERENCES_NAME = "pps_propertis";
    public static final String TRANSITION_SCALE_BEFORE_POWER_MODE_SUPPER = "transition_scale";
    public static final String WINDOW_SCALE_BEFORE_POWER_MODE_SUPPER = "window_scale";

    public static synchronized void setStringProperty(String str, String str2) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public static synchronized void setIntProperty(String str, int i) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static synchronized void setBooleanProperty(String str, boolean z) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.commit();
    }

    public static synchronized void setLongProperty(String str, long j) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putLong(str, j);
        editorEdit.commit();
    }

    public static synchronized void setFloatProperty(String str, float f) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putFloat(str, f);
        editorEdit.commit();
    }

    public static synchronized String getStringProperty(String str, String str2) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getString(str, str2);
    }

    public static synchronized int getIntProperty(String str, int i) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getInt(str, i);
    }

    public static synchronized boolean getBooleanProperty(String str, boolean z) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getBoolean(str, z);
    }

    public static synchronized long getLongProperty(String str, long j) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getLong(str, j);
    }

    public static synchronized float getFloatProperty(String str, float f) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getFloat(str, f);
    }

    public static synchronized void setStringSet(String str, Set<String> set) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.putStringSet(str, set);
        editorEdit.commit();
    }

    public static synchronized Set<String> getStringSet(String str) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).getStringSet(str, new HashSet());
    }

    public static synchronized void remove(String str) {
        SharedPreferences.Editor editorEdit = PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    public static synchronized boolean contains(String str) {
        return PPSApplication.getInstance().getSharedPreferences(SHARED_PREFERENCES_NAME, 4).contains(str);
    }
}
