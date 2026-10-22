package com.android.server.flags;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;

/* JADX INFO: loaded from: classes2.dex */
class GlobalSettingsProxy implements SettingsProxy {
    private final ContentResolver mContentResolver;

    GlobalSettingsProxy(ContentResolver contentResolver) {
        this.mContentResolver = contentResolver;
    }

    @Override // com.android.server.flags.SettingsProxy
    public ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    @Override // com.android.server.flags.SettingsProxy
    public Uri getUriFor(String name) {
        return Settings.Global.getUriFor(name);
    }

    @Override // com.android.server.flags.SettingsProxy
    public String getStringForUser(String name, int userHandle) {
        return Settings.Global.getStringForUser(this.mContentResolver, name, userHandle);
    }

    @Override // com.android.server.flags.SettingsProxy
    public boolean putString(String name, String value, boolean overrideableByRestore) {
        throw new UnsupportedOperationException("This method only exists publicly for Settings.System and Settings.Secure");
    }

    @Override // com.android.server.flags.SettingsProxy
    public boolean putStringForUser(String name, String value, int userHandle) {
        return Settings.Global.putStringForUser(this.mContentResolver, name, value, userHandle);
    }

    @Override // com.android.server.flags.SettingsProxy
    public boolean putStringForUser(String name, String value, String tag, boolean makeDefault, int userHandle, boolean overrideableByRestore) {
        return Settings.Global.putStringForUser(this.mContentResolver, name, value, tag, makeDefault, userHandle, overrideableByRestore);
    }

    @Override // com.android.server.flags.SettingsProxy
    public boolean putString(String name, String value, String tag, boolean makeDefault) {
        return Settings.Global.putString(this.mContentResolver, name, value, tag, makeDefault);
    }
}
