package com.android.server.media.projection;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class MediaProjectionSessionIdGenerator {
    private static final String PREFERENCES_FILE_NAME = "media_projection_session_id";
    private static final int SESSION_ID_DEFAULT_VALUE = 0;
    private static final String SESSION_ID_PREF_KEY = "media_projection_session_id_key";
    private static MediaProjectionSessionIdGenerator sInstance;
    private static final Object sInstanceLock = null;
    private final Object mSessionIdLock;
    private final SharedPreferences mSharedPreferences;

    static {
        sInstanceLock = new Object();
    }

    public static MediaProjectionSessionIdGenerator getInstance(Context context) {
        Object r0 = sInstanceLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        File preferencesFile = new File(Environment.getDataSystemDirectory(), PREFERENCES_FILE_NAME);     // Catch: Throwable -> L7
        Context directBootContext = context.createDeviceProtectedStorageContext();     // Catch: Throwable -> L7
        SharedPreferences preferences = directBootContext.getSharedPreferences(preferencesFile, 0);     // Catch: Throwable -> L7
        sInstance = new MediaProjectionSessionIdGenerator(preferences);     // Catch: Throwable -> L7
    L9:
        MediaProjectionSessionIdGenerator r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public MediaProjectionSessionIdGenerator(SharedPreferences sharedPreferences) {
        this.mSessionIdLock = new Object();
        this.mSharedPreferences = sharedPreferences;
    }

    public int getCurrentSessionId() {
        Object r0 = this.mSessionIdLock;
        monitor-enter(r0);
        int r1 = getCurrentSessionIdInternal();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int createAndGetNewSessionId() {
        Object r0 = this.mSessionIdLock;
        monitor-enter(r0);
        int newSessionId = getCurrentSessionId() + 1;     // Catch: Throwable -> L7
        setSessionIdInternal(newSessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return newSessionId;
    L7:
        th = move-exception;
        throw th;
    }

    private void setSessionIdInternal(int value) {
        this.mSharedPreferences.edit().putInt(SESSION_ID_PREF_KEY, value).apply();
    }

    private int getCurrentSessionIdInternal() {
        return this.mSharedPreferences.getInt(SESSION_ID_PREF_KEY, 0);
    }
}
