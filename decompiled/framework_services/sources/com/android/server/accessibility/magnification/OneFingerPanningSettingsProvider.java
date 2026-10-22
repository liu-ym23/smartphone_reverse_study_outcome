package com.android.server.accessibility.magnification;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class OneFingerPanningSettingsProvider {
    static final String KEY = "accessibility_single_finger_panning_enabled";
    private static final Uri URI = null;
    private AtomicBoolean mCached;
    ContentResolver mContentResolver;
    ContentObserver mObserver;

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int OFF = 0;
        public static final int ON = 1;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCached, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m864$$Nest$fgetmCached(OneFingerPanningSettingsProvider r0) {
        return r0.mCached;
    }

    /* JADX INFO: renamed from: -$$Nest$misOneFingerPanningEnabledInSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m865$$Nest$misOneFingerPanningEnabledInSetting(OneFingerPanningSettingsProvider r0, Context r1, boolean r2) {
        return r0.isOneFingerPanningEnabledInSetting(r1, r2);
    }

    static {
        URI = Settings.Secure.getUriFor(KEY);
    }

    public OneFingerPanningSettingsProvider(final Context context, boolean featureFlagEnabled) {
        this.mCached = new AtomicBoolean();
        final boolean defaultValue = isOneFingerPanningEnabledDefault(context);
        if (featureFlagEnabled == false) goto L5;
        this.mContentResolver = context.getContentResolver();
        final Handler r2 = context.getMainThreadHandler();
        this.mObserver = new AnonymousClass1(this, r2, context, defaultValue);
        this.mCached.set(isOneFingerPanningEnabledInSetting(context, defaultValue));
        this.mContentResolver.registerContentObserver(URI, false, this.mObserver);
        return;
    L5:
        this.mCached.set(defaultValue);
    }

    public boolean isOneFingerPanningEnabled() {
        return this.mCached.get();
    }

    public void unregister() {
        if (this.mContentResolver == null) goto L5;
        this.mContentResolver.unregisterContentObserver(this.mObserver);
    L5:
        this.mContentResolver = null;
    }

    private boolean isOneFingerPanningEnabledInSetting(Context r4, boolean r5) {
        ContentResolver r0 = this.mContentResolver;
        int r1 = r4.getUserId();
        if (1 == Settings.Secure.getIntForUser(r0, KEY, r5 ? 1 : 0, r1)) goto L7;
        return false;
    L7:
        return true;
    }

    static boolean isOneFingerPanningEnabledDefault(Context context) {
        boolean oneFingerPanningDefaultValue = context.getResources().getBoolean(R.bool.config_enabled_mt_sms_polling);     // Catch: Resources.NotFoundException -> L4
        return oneFingerPanningDefaultValue;
    L6:
        return false;
    }
}
