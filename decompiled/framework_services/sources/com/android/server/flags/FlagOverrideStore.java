package com.android.server.flags;

import android.database.Cursor;
import android.provider.Settings;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FlagOverrideStore {
    private static final String KEYNAME_PREFIX = "flag|";
    private static final String NAMESPACE_NAME_SEPARATOR = ".";
    private FlagChangeCallback mCallback;
    private final SettingsProxy mSettingsProxy;

    interface FlagChangeCallback {
        void onFlagChanged(String r1, String r2, String r3);
    }

    FlagOverrideStore(SettingsProxy settingsProxy) {
        this.mSettingsProxy = settingsProxy;
    }

    void setChangeCallback(FlagChangeCallback callback) {
        this.mCallback = callback;
    }

    boolean contains(String namespace, String name) {
        if (get(namespace, name) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void set(String namespace, String name, String value) {
        this.mSettingsProxy.putString(getPropName(namespace, name), value);
        this.mCallback.onFlagChanged(namespace, name, value);
    }

    public String get(String namespace, String name) {
        return this.mSettingsProxy.getString(getPropName(namespace, name));
    }

    public void erase(String namespace, String name) {
        set(namespace, name, null);
    }

    Map<String, Map<String, String>> getFlags() {
        return getFlagsForNamespace(null);
    }

    Map<String, Map<String, String>> getFlagsForNamespace(String namespace) {
        Cursor c = this.mSettingsProxy.getContentResolver().query(Settings.Global.CONTENT_URI, new String[]{"name", "value"}, null, null, null);
        if (c == null) goto L5;
        int keynamePrefixLength = KEYNAME_PREFIX.length();
        Map<String, Map<String, String>> results = new HashMap();
    L8:
        if (c.moveToNext() == false) goto L25;
        String key = c.getString(0);
        if (key.startsWith(KEYNAME_PREFIX) == false) goto L8;
        if (key.indexOf(NAMESPACE_NAME_SEPARATOR, keynamePrefixLength) < 0) goto L8;
        String value = c.getString(1);
        if (value == null) goto L8;
        if (value.isEmpty() == true) goto L8;
        String ns = key.substring(keynamePrefixLength, key.indexOf(NAMESPACE_NAME_SEPARATOR));
        if (namespace == null) goto L24;
        if (namespace.equals(ns) == false) goto L8;
    L24:
        String name = key.substring(key.indexOf(NAMESPACE_NAME_SEPARATOR) + 1);
        results.putIfAbsent(ns, new HashMap());
        results.get(ns).put(name, value);
        goto L8
    L25:
        c.close();
        return results;
    L5:
        return Map.of();
    }

    static String getPropName(String namespace, String name) {
        return KEYNAME_PREFIX + namespace + NAMESPACE_NAME_SEPARATOR + name;
    }
}
