package com.stepos.settings.impl;

import android.content.ContentValues;
import android.content.res.stepostheme.iconfilter.bean.FilterConfigInfo;
import android.database.sqlite.SQLiteDatabase;
import com.android.providers.settings.IStepOSSettingsDefaultsExt;
import com.stepos.settings.config.StepOSSettingsDefaults;
import com.stepos.settings.config.StepOSSettingsKeys;

/* loaded from: classes.dex */
public class StepOSSettingsDefaultsImpl implements IStepOSSettingsDefaultsExt {
    @Override // com.android.providers.settings.IStepOSSettingsDefaultsExt
    public void loadSystemDefaults(SQLiteDatabase db, int userId) {
        loadDefault(db, StepOSSettingsKeys.SYSTEM_LIGHT_FEEDBACK_ENABLED, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_EARPHONE_FEEDBACK_ENABLED, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_HEADSET_MIDDLE_KEY_WAKEUP, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_MODE_RING_UP, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SUPER_STEREO_SOUND, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SUPER_STEREO_SOUND_ITEM, "");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_MULTI_APP_VOLUME_CONTROL, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_MULTI_APP_VOLUME_LEVEL, "");
        loadDefault(db, "stepos_sound_classic", "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SOUND_CLASSIC_BASS, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SOUND_CLASSIC_TREBLE, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_HEARING_PROTECTION, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_RINGER_MODE_AFFECT_MUSIC, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SUPER_VOLUME_GLOBAL_ENABLE, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_SUPER_VOLUME_STREAM_TYPE_ENABLE, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_EACH_APP_VOLUME_NO_DISTURB, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_STEPOS_DISABLE_COLOR_FADE, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_DISPLAY_SOURCE_COLOR_ENABLE, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_KEY_CALL_PSENSOR_DELAY, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_STEPOS_COLOR_TEMPERATURE, "0");
        loadDefault(db, "stepos_lock_screen_brightness", "0");
        loadDefault(db, "stepos_outwork_mode_settings", "0");
        loadDefault(db, "stepos_outwork_mode_increase_brightness", "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_NAVIGATION_MODE, "2");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_QUICK_WAKEUP_SWITCH, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_QUICK_WAKEUP_DOUBLE_CLICK, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_ENABLED, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_ICON_SHOW_IN_AOD, "0");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_USE_UNLOCK, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_USE_APP_UNLOCK, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_USE_DOCUMENT_UNLOCK, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_USE_GALLERY_UNLOCK, "1");
        loadDefault(db, StepOSSettingsKeys.SYSTEM_FINGERPRINT_USE_NOTES_UNLOCK, "1");
    }

    @Override // com.android.providers.settings.IStepOSSettingsDefaultsExt
    public void loadSecureDefaults(SQLiteDatabase db, int userId) {
        loadDefault(db, "secure", "default_input_method", "com.sohu.inputmethod.sogou.oem/com.sohu.inputmethod.sogou.SogouIME");
        loadDefault(db, "secure", "enabled_input_methods", "com.sohu.inputmethod.sogou.oem/com.sohu.inputmethod.sogou.SogouIME");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_FACE_RECOGNITION_ENABLED, "1");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_THREE_FINGERS_SCREENSHOT_ENABLED, "1");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_GAME_MODE_DISABLE_THREE_FINGER_GESTURE, "1");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_AVOID_POWER_KEY_MISOPERATION, "0");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_SCREEN_SHARE_PROTECT_NOTIFICATION, "1");
        loadDefault(db, "secure", "stepos_lock_screen_brightness", "0");
        loadDefault(db, "secure", StepOSSettingsKeys.SECURE_STORAGE_ACCESS_DELETE_PROTECT, 1);
    }

    @Override // com.android.providers.settings.IStepOSSettingsDefaultsExt
    public void loadGlobalDefaults(SQLiteDatabase db, int userId) {
        if (userId != 0) {
            return;
        }
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_DEVICE_OWNER_TYPE, 0);
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_REFRESH_RATE, StepOSSettingsDefaults.GLOBAL_REFRESH_RATE_DEFAULT);
        loadDefault(db, "global", "stepos_outwork_mode_settings", "0");
        loadDefault(db, "global", "stepos_outwork_mode_increase_brightness", "0");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_WIFI_DISPLAY_PRIVACY_PROTECTION, "1");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_WIFI_DISPLAY_SCREEN_OFF_PROTECTION, "1");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_FINGERPRINT_ANIMATION, "3");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_FINGERPRINT_UNLOCK_MODE, "0");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_FINGERPRINT_ICON_SIZE, "1");
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_FINGERPRINT_QUICK_LAUNCH_LEFT, StepOSSettingsDefaults.GLOBAL_FINGERPRINT_QUICK_LAUNCH_LEFT_DEFAULT);
        loadDefault(db, "global", StepOSSettingsKeys.GLOBAL_FINGERPRINT_QUICK_LAUNCH_RIGHT, StepOSSettingsDefaults.GLOBAL_FINGERPRINT_QUICK_LAUNCH_RIGHT_DEFAULT);
    }

    private void loadDefault(SQLiteDatabase db, String key, String value) {
        loadDefault(db, "system", key, value);
    }

    private void loadDefault(SQLiteDatabase db, String table, String key, String value) {
        ContentValues cv = new ContentValues();
        cv.put("name", key);
        cv.put(FilterConfigInfo.Filter.PARAM_ATTR_VALUE, value);
        try {
            db.insertWithOnConflict(table, null, cv, 4);
        } catch (Exception e) {
        }
    }

    private void loadDefault(SQLiteDatabase db, String table, String key, int value) {
        loadDefault(db, table, key, String.valueOf(value));
    }
}
