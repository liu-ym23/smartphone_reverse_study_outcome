package com.android.server.theming;

import android.content.ContentResolver;
import android.content.theming.ThemeSettings;
import android.content.theming.ThemeSettingsField;
import android.content.theming.ThemeSettingsUpdater;
import android.provider.Settings;
import android.telecom.Log;
import com.android.internal.util.Preconditions;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class ThemeSettingsManager {
    private static final String TAG = null;
    static final String TIMESTAMP_FIELD = "_applied_timestamp";
    private final ThemeSettings mDefaults;
    private final ThemeSettingsField<?, ?>[] mFields;

    static {
        TAG = ThemeSettingsManager.class.getSimpleName();
    }

    ThemeSettingsManager(ThemeSettings defaults) {
        this.mDefaults = defaults;
        this.mFields = ThemeSettingsField.getFields(defaults);
    }

    ThemeSettings loadSettings(int userId, ContentResolver contentResolver) {
        String jsonString = Settings.Secure.getStringForUser(contentResolver, "theme_customization_overlay_packages", userId);
        if (jsonString != null) goto L8;
        String r2 = "";
    L9:
        JSONObject userSettings = new JSONObject(r2);     // Catch: JSONException -> L6
    L12:
        ThemeSettingsUpdater updater = ThemeSettings.updater();
        ThemeSettingsField<?, ?>[] r3 = this.mFields;
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L16;
        ThemeSettingsField<?, ?> field = r3[r5];
        field.fromJSON(userSettings, updater);
        r5 = r5 + 1;
        goto L13
    L16:
        return updater.toThemeSettings(this.mDefaults);
    L8:
        r2 = jsonString;
    L11:
        userSettings = new JSONObject();
        goto L12
    }

    void replaceSettings(int userId, ContentResolver contentResolver, ThemeSettings newSettings) throws RuntimeException {
        if (newSettings == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Impossible to write empty settings");
        JSONObject jsonSettings = new JSONObject();
        ThemeSettingsField<?, ?>[] r2 = this.mFields;
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L15;
        ThemeSettingsField<?, ?> field = r2[r4];
        field.toJSON(newSettings, jsonSettings);
        r4 = r4 + 1;
        goto L7
    L15:
        jsonSettings.put(TIMESTAMP_FIELD, System.currentTimeMillis());     // Catch: JSONException -> L11
    L13:
        String jsonString = jsonSettings.toString();
        Settings.Secure.putStringForUser(contentResolver, "theme_customization_overlay_packages", jsonString, userId);
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "Error saving timestamp: " + e.getMessage(), new Object[0]);
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    void updateSettings(int userId, ContentResolver contentResolver, ThemeSettings newSettings) throws JSONException, RuntimeException {
        if (newSettings == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Impossible to write empty settings");
        String existingJsonString = Settings.Secure.getStringForUser(contentResolver, "theme_customization_overlay_packages", userId);
        if (existingJsonString != null) goto L12;
        String r4 = "{}";
    L13:
        JSONObject existingJson = new JSONObject(r4);     // Catch: JSONException -> L10
    L16:
        JSONObject newJson = new JSONObject();
        ThemeSettingsField<?, ?>[] r5 = this.mFields;
        int r6 = r5.length;
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L29;
        ThemeSettingsField<?, ?> field = r5[r7];
        field.toJSON(newSettings, newJson);
        r7 = r7 + 1;
        goto L17
    L29:
        newJson.put(TIMESTAMP_FIELD, System.currentTimeMillis());     // Catch: JSONException -> L21
    L23:
        Iterator<String> keys = newJson.keys();
    L25:
        if (keys.hasNext() == false) goto L27;
        String key = keys.next();
        existingJson.put(key, newJson.get(key));
        goto L25
    L27:
        String mergedJsonString = existingJson.toString();
        Settings.Secure.putStringForUser(contentResolver, "theme_customization_overlay_packages", mergedJsonString, userId);
        return;
    L21:
        e = move-exception;
        Log.w(TAG, "Error saving timestamp: " + e.getMessage(), new Object[0]);
        goto L23
    L12:
        r4 = existingJsonString;
    L15:
        existingJson = new JSONObject();
        goto L16
    L5:
        r1 = false;
        goto L6
    }
}
