package com.android.server.media.projection;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;

/* JADX INFO: loaded from: classes2.dex */
public class MediaProjectionTimestampStore {
    private static final String PREFERENCES_FILE_NAME = "media_projection_timestamp";
    private static final String TIMESTAMP_PREF_KEY = "media_projection_timestamp_key";
    private static MediaProjectionTimestampStore sInstance;
    private static final Object sInstanceLock = null;
    private final InstantSource mInstantSource;
    private final SharedPreferences mSharedPreferences;
    private final Object mTimestampLock;

    static {
        sInstanceLock = new Object();
    }

    public MediaProjectionTimestampStore(SharedPreferences sharedPreferences, InstantSource instantSource) {
        this.mTimestampLock = new Object();
        this.mSharedPreferences = sharedPreferences;
        this.mInstantSource = instantSource;
    }

    public static MediaProjectionTimestampStore getInstance(Context context) {
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
        sInstance = new MediaProjectionTimestampStore(preferences, InstantSource.system());     // Catch: Throwable -> L7
    L9:
        MediaProjectionTimestampStore r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public Duration timeSinceLastActiveSession() {
        Object r0 = this.mTimestampLock;
        monitor-enter(r0);
        Instant lastActiveSessionTimestamp = getLastActiveSessionTimestamp();     // Catch: Throwable -> L9
        if (lastActiveSessionTimestamp != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        Instant now = this.mInstantSource.instant();     // Catch: Throwable -> L9
        Duration r3 = Duration.between(lastActiveSessionTimestamp, now);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public void registerActiveSessionEnded() {
        Object r0 = this.mTimestampLock;
        monitor-enter(r0);
        Instant now = this.mInstantSource.instant();     // Catch: Throwable -> L7
        setLastActiveSessionTimestamp(now);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Instant getLastActiveSessionTimestamp() {
        long lastActiveSessionEpochMilli = this.mSharedPreferences.getLong(TIMESTAMP_PREF_KEY, -1);
        if (lastActiveSessionEpochMilli != (-1)) goto L7;
        return null;
    L7:
        return Instant.ofEpochMilli(lastActiveSessionEpochMilli);
    }

    private void setLastActiveSessionTimestamp(Instant timestamp) {
        this.mSharedPreferences.edit().putLong(TIMESTAMP_PREF_KEY, timestamp.toEpochMilli()).apply();
    }
}
