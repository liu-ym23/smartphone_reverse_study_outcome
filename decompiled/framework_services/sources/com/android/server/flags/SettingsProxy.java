package com.android.server.flags;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
public interface SettingsProxy {
    ContentResolver getContentResolver();

    String getStringForUser(String r1, int r2);

    Uri getUriFor(String r1);

    boolean putString(String r1, String r2, String r3, boolean r4);

    boolean putString(String r1, String r2, boolean r3);

    boolean putStringForUser(String r1, String r2, int r3);

    boolean putStringForUser(String r1, String r2, String r3, boolean r4, int r5, boolean r6);

    default int getUserId() {
        return getContentResolver().getUserId();
    }

    default String getString(String name) {
        return getStringForUser(name, getUserId());
    }

    default boolean putString(String name, String value) {
        return putStringForUser(name, value, getUserId());
    }

    default int getIntForUser(String name, int def, int userHandle) {
        String v = getStringForUser(name, userHandle);
        if (v == null) goto L9;
        return Integer.parseInt(v);
    L7:
        return def;
    L9:
        return def;
    }

    default int getInt(String name) throws Settings.SettingNotFoundException {
        return getIntForUser(name, getUserId());
    }

    default int getIntForUser(String name, int userHandle) throws Settings.SettingNotFoundException {
        String v = getStringForUser(name, userHandle);
        return Integer.parseInt(v);
    L7:
        throw new Settings.SettingNotFoundException(name);
    }

    default boolean putInt(String name, int value) {
        return putIntForUser(name, value, getUserId());
    }

    default boolean putIntForUser(String name, int value, int userHandle) {
        return putStringForUser(name, Integer.toString(value), userHandle);
    }

    default boolean getBool(String name, boolean def) {
        return getBoolForUser(name, def, getUserId());
    }

    default boolean getBoolForUser(String r2, boolean r3, int r4) {
        if (getIntForUser(r2, r3 ? 1 : 0, r4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    default boolean getBool(String name) throws Settings.SettingNotFoundException {
        return getBoolForUser(name, getUserId());
    }

    default boolean getBoolForUser(String name, int userHandle) throws Settings.SettingNotFoundException {
        if (getIntForUser(name, userHandle) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    default boolean putBool(String name, boolean value) {
        return putBoolForUser(name, value, getUserId());
    }

    default boolean putBoolForUser(String r2, boolean r3, int r4) {
        return putIntForUser(r2, r3 ? 1 : 0, r4);
    }

    default long getLong(String name, long def) {
        return getLongForUser(name, def, getUserId());
    }

    default long getLongForUser(String name, long def, int userHandle) {
        String valString = getStringForUser(name, userHandle);
        if (valString != null) goto L11;
        long r1 = def;
    L9:
        long value = r1;
        return value;
    L11:
        r1 = Long.parseLong(valString);     // Catch: NumberFormatException -> L6
    L13:
        return def;
    }

    default long getLong(String name) throws Settings.SettingNotFoundException {
        return getLongForUser(name, getUserId());
    }

    default long getLongForUser(String name, int userHandle) throws Settings.SettingNotFoundException {
        String valString = getStringForUser(name, userHandle);
        return Long.parseLong(valString);
    L7:
        throw new Settings.SettingNotFoundException(name);
    }

    default boolean putLong(String name, long value) {
        return putLongForUser(name, value, getUserId());
    }

    default boolean putLongForUser(String name, long value, int userHandle) {
        return putStringForUser(name, Long.toString(value), userHandle);
    }

    default float getFloat(String name, float def) {
        return getFloatForUser(name, def, getUserId());
    }

    default float getFloatForUser(String name, float def, int userHandle) {
        String v = getStringForUser(name, userHandle);
        if (v == null) goto L9;
        return Float.parseFloat(v);
    L7:
        return def;
    L9:
        return def;
    }

    default float getFloat(String name) throws Settings.SettingNotFoundException {
        return getFloatForUser(name, getUserId());
    }

    default float getFloatForUser(String name, int userHandle) throws Settings.SettingNotFoundException {
        String v = getStringForUser(name, userHandle);
        if (v == null) goto L10;
        return Float.parseFloat(v);
    L8:
        throw new Settings.SettingNotFoundException(name);
    L10:
        throw new Settings.SettingNotFoundException(name);
    }

    default boolean putFloat(String name, float value) {
        return putFloatForUser(name, value, getUserId());
    }

    default boolean putFloatForUser(String name, float value, int userHandle) {
        return putStringForUser(name, Float.toString(value), userHandle);
    }

    default void registerContentObserver(String name, ContentObserver settingsObserver) {
        registerContentObserver(getUriFor(name), settingsObserver);
    }

    default void registerContentObserver(Uri uri, ContentObserver settingsObserver) {
        registerContentObserverForUser(uri, settingsObserver, getUserId());
    }

    default void registerContentObserver(String name, boolean notifyForDescendants, ContentObserver settingsObserver) {
        registerContentObserver(getUriFor(name), notifyForDescendants, settingsObserver);
    }

    default void registerContentObserver(Uri uri, boolean notifyForDescendants, ContentObserver settingsObserver) {
        registerContentObserverForUser(uri, notifyForDescendants, settingsObserver, getUserId());
    }

    default void registerContentObserverForUser(String name, ContentObserver settingsObserver, int userHandle) {
        registerContentObserverForUser(getUriFor(name), settingsObserver, userHandle);
    }

    default void registerContentObserverForUser(Uri uri, ContentObserver settingsObserver, int userHandle) {
        registerContentObserverForUser(uri, false, settingsObserver, userHandle);
    }

    default void registerContentObserverForUser(String name, boolean notifyForDescendants, ContentObserver settingsObserver, int userHandle) {
        registerContentObserverForUser(getUriFor(name), notifyForDescendants, settingsObserver, userHandle);
    }

    default void registerContentObserverForUser(Uri uri, boolean notifyForDescendants, ContentObserver settingsObserver, int userHandle) {
        getContentResolver().registerContentObserver(uri, notifyForDescendants, settingsObserver, userHandle);
    }

    default void unregisterContentObserver(ContentObserver settingsObserver) {
        getContentResolver().unregisterContentObserver(settingsObserver);
    }
}
