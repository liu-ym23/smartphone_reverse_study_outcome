package com.android.server.vr;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.ArraySet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SettingsObserver {
    private final ContentObserver mContentObserver;
    private final String mSecureSettingName;
    private final BroadcastReceiver mSettingRestoreReceiver;
    private final Set<SettingChangeListener> mSettingsListeners;

    public interface SettingChangeListener {
        void onSettingChanged();

        void onSettingRestored(String r1, String r2, int r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendSettingChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9448$$Nest$msendSettingChanged(SettingsObserver r0) {
        r0.sendSettingChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$msendSettingRestored, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9449$$Nest$msendSettingRestored(SettingsObserver r0, String r1, String r2, int r3) {
        r0.sendSettingRestored(r1, r2, r3);
    }

    private SettingsObserver(Context context, final Handler handler, final Uri settingUri, final String secureSettingName) {
        this.mSettingsListeners = new ArraySet();
        this.mSecureSettingName = secureSettingName;
        this.mSettingRestoreReceiver = new AnonymousClass1(this, secureSettingName);
        this.mContentObserver = new AnonymousClass2(this, handler, settingUri);
        ContentResolver resolver = context.getContentResolver();
        resolver.registerContentObserver(settingUri, false, this.mContentObserver, -1);
    }

    public static SettingsObserver build(Context context, Handler handler, String settingName) {
        Uri settingUri = Settings.Secure.getUriFor(settingName);
        return new SettingsObserver(context, handler, settingUri, settingName);
    }

    public void addListener(SettingChangeListener listener) {
        this.mSettingsListeners.add(listener);
    }

    public void removeListener(SettingChangeListener listener) {
        this.mSettingsListeners.remove(listener);
    }

    private void sendSettingChanged() {
        Iterator<SettingChangeListener> r0 = this.mSettingsListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SettingChangeListener l = r0.next();
        l.onSettingChanged();
        goto L4
    }

    private void sendSettingRestored(String prevValue, String newValue, int userId) {
        Iterator<SettingChangeListener> r0 = this.mSettingsListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SettingChangeListener l = r0.next();
        l.onSettingRestored(prevValue, newValue, userId);
        goto L4
    }
}
