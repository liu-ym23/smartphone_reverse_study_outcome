package com.android.contacts.socialwidget;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;
import com.GlobalProxyLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SocialWidgetSettings {
    private static final String CONTACT_URI_PREFIX = "CONTACT_URI_";
    private static final String KEY_MIGRATED = "SocialWidgetSettings_settings_migrated";
    private static final String LEGACY_PREFS_NAME = "WidgetSettings";
    private static final String PREFERENCES_PREFIX = "SocialWidgetSettings_";
    private static final String TAG = "SocialWidgetSettings";
    private static final SocialWidgetSettings sInstance = null;

    public SocialWidgetSettings() {
    }

    static {
        sInstance = new SocialWidgetSettings();
    }

    public static SocialWidgetSettings getInstance() {
        return sInstance;
    }

    private final String getPreferenceKey(int r2) {
        return "SocialWidgetSettings_CONTACT_URI_" + Integer.toString(r2);
    }

    public void remove(Context r7, int[] r8) {
        SharedPreferences.Editor r9 = PreferenceManager.getDefaultSharedPreferences(r7).edit();
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r8[r1];
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "remove(" + r2 + ")");
    L7:
        r9.remove(getPreferenceKey(r2));
        r1 = r1 + 1;
        goto L3
    L8:
        r9.apply();
    }

    public Uri getContactUri(Context r3, int r4) {
        SharedPreferences r0 = PreferenceManager.getDefaultSharedPreferences(r3);
        ensureMigrated(r3, r0);
        Uri r5 = null;
        String r2 = r0.getString(getPreferenceKey(r4), null);
        if (r2 == null) goto L7;
        r5 = Uri.parse(r2);
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getContactUri(" + r4 + ") --> " + r5);
    L9:
        return r5;
    }

    public void setContactUri(Context r4, int r5, Uri r6) {
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setContactUri(" + r5 + ", " + r6 + ")");
    L5:
        SharedPreferences.Editor r7 = PreferenceManager.getDefaultSharedPreferences(r4).edit();
        if (r6 != null) goto L8;
        r7.remove(getPreferenceKey(r5));
    L9:
        r7.apply();
        return;
    L8:
        r7.putString(getPreferenceKey(r5), r6.toString());
        goto L9
    }

    private void ensureMigrated(Context r8, SharedPreferences r9) {
        if (r9.getBoolean(KEY_MIGRATED, false) == false) goto L5;
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Migrating widget settings...");
        SharedPreferences.Editor r1 = r9.edit();
        SharedPreferences r10 = r8.getSharedPreferences(LEGACY_PREFS_NAME, 0);
        Iterator<String> r0 = r10.getAll().keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r3 = r0.next();
        String r4 = r10.getString(r3, null);
        if (r4 == null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Found: " + r3 + ": " + r4);
        r1.putString(PREFERENCES_PREFIX + r3, r4);
        goto L7
    L12:
        r1.apply();
        r9.edit().putBoolean(KEY_MIGRATED, true).apply();
    }
}
