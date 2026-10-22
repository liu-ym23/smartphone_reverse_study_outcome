package com.android.server.accessibility;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.view.accessibility.CaptioningManager;

/* JADX INFO: loaded from: classes.dex */
public class CaptioningManagerImpl implements CaptioningManager.SystemAudioCaptioningAccessing {
    private static final boolean SYSTEM_AUDIO_CAPTIONING_UI_DEFAULT_ENABLED = false;
    private final Context mContext;

    public CaptioningManagerImpl(Context context) {
        this.mContext = context;
    }

    public void setSystemAudioCaptioningEnabled(boolean isEnabled, int userId) {
        long identity = Binder.clearCallingIdentity();
        ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L10
        if (isEnabled == false) goto L6;
        int r4 = 1;
    L7:
        Settings.Secure.putIntForUser(r2, "odi_captions_enabled", r4, userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public boolean isSystemAudioCaptioningUiEnabled(int userId) {
        long identity = Binder.clearCallingIdentity();
        boolean r4 = false;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "odi_captions_volume_ui_enabled", 0, userId) != 1) goto L7;
        r4 = true;
    L7:
        Binder.restoreCallingIdentity(identity);
        return r4;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void setSystemAudioCaptioningUiEnabled(boolean isEnabled, int userId) {
        long identity = Binder.clearCallingIdentity();
        ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L10
        if (isEnabled == false) goto L6;
        int r4 = 1;
    L7:
        Settings.Secure.putIntForUser(r2, "odi_captions_volume_ui_enabled", r4, userId);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        r4 = 0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
