package com.android.server.notification;

import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.display.ColorDisplayManager;
import android.os.Binder;
import android.os.PowerManager;
import android.service.notification.DeviceEffectsApplier;
import android.service.notification.ZenDeviceEffects;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultDeviceEffectsApplier implements DeviceEffectsApplier {
    private static final int SATURATION_LEVEL_FULL_COLOR = 100;
    private static final int SATURATION_LEVEL_GRAYSCALE = 0;
    private static final IntentFilter SCREEN_OFF_INTENT_FILTER = null;
    private static final String SUPPRESS_AMBIENT_DISPLAY_TOKEN = "DefaultDeviceEffectsApplier:SuppressAmbientDisplay";
    private static final String TAG = "DeviceEffectsApplier";
    private static final float WALLPAPER_DIM_AMOUNT_DIMMED = 0.6f;
    private static final float WALLPAPER_DIM_AMOUNT_NORMAL = 0.0f;
    private final ColorDisplayManager mColorDisplayManager;
    private final Context mContext;
    private boolean mIsScreenOffReceiverRegistered;
    private final KeyguardManager mKeyguardManager;
    protected ZenDeviceEffects mLastAppliedEffects;
    private final BroadcastReceiver mNightModeWhenScreenOff;
    private boolean mPendingNightMode;
    private final PowerManager mPowerManager;
    private final Object mRegisterReceiverLock;
    private final UiModeManager mUiModeManager;
    private final WallpaperManager mWallpaperManager;

    public static /* synthetic */ void $r8$lambda$4LDHIsj0iI2D9FidhGDL9DsNFGA(DefaultDeviceEffectsApplier r0, ZenDeviceEffects r1, int r2) {
        r0.lambda$apply$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$GU7KgDI7UqIvmoYhYm62_3u1GIw(DefaultDeviceEffectsApplier r0, boolean r1) {
        r0.lambda$updateNightModeImmediately$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6043$$Nest$fgetmPendingNightMode(DefaultDeviceEffectsApplier r0) {
        return r0.mPendingNightMode;
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterScreenOffReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6044$$Nest$munregisterScreenOffReceiver(DefaultDeviceEffectsApplier r0) {
        r0.unregisterScreenOffReceiver();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNightModeImmediately, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6045$$Nest$mupdateNightModeImmediately(DefaultDeviceEffectsApplier r0, boolean r1) {
        r0.updateNightModeImmediately(r1);
    }

    static {
        SCREEN_OFF_INTENT_FILTER = new IntentFilter("android.intent.action.SCREEN_OFF");
    }

    public DefaultDeviceEffectsApplier(Context context) {
        this.mRegisterReceiverLock = new Object();
        this.mLastAppliedEffects = new ZenDeviceEffects.Builder().build();
        this.mNightModeWhenScreenOff = new AnonymousClass1(this);
        this.mContext = context;
        this.mColorDisplayManager = (ColorDisplayManager) context.getSystemService(ColorDisplayManager.class);
        this.mKeyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
        this.mPowerManager = (PowerManager) context.getSystemService(PowerManager.class);
        this.mUiModeManager = (UiModeManager) context.getSystemService(UiModeManager.class);
        WallpaperManager wallpaperManager = (WallpaperManager) context.getSystemService(WallpaperManager.class);
        if (wallpaperManager != null) goto L5;
    L7:
        WallpaperManager r1 = null;
    L8:
        this.mWallpaperManager = r1;
        return;
    L5:
        if (wallpaperManager.isWallpaperSupported() == false) goto L7;
        r1 = wallpaperManager;
        goto L8
    }

    public void apply(final ZenDeviceEffects effects, final int origin) {
        Binder.withCleanCallingIdentity(new DefaultDeviceEffectsApplier$$ExternalSyntheticLambda1(this, effects, origin));
        this.mLastAppliedEffects = effects;
    }

    private /* synthetic */ void lambda$apply$0(ZenDeviceEffects effects, int origin) throws Exception {
        maybeSuppressAmbientDisplay(effects.shouldSuppressAmbientDisplay());
        maybeDisplayGrayscale(effects.shouldDisplayGrayscale());
        maybeDimWallpaper(effects.shouldDimWallpaper());
        maybeUseNightMode(effects.shouldUseNightMode(), origin);
    }

    protected void maybeSuppressAmbientDisplay(boolean shouldSuppressAmbientDisplay) {
        if (this.mLastAppliedEffects.shouldSuppressAmbientDisplay() == shouldSuppressAmbientDisplay) goto L11;
        ZenLog.traceApplyDeviceEffect("suppressAmbientDisplay", shouldSuppressAmbientDisplay);     // Catch: Exception -> L6
        this.mPowerManager.suppressAmbientDisplay(SUPPRESS_AMBIENT_DISPLAY_TOKEN, shouldSuppressAmbientDisplay);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Could not change AOD override", e);
        return;
    }

    protected void maybeDisplayGrayscale(boolean shouldDisplayGrayscale) {
        if (this.mLastAppliedEffects.shouldDisplayGrayscale() != shouldDisplayGrayscale) goto L5;
        return;
    L5:
        if (this.mColorDisplayManager == null) goto L18;
        ZenLog.traceApplyDeviceEffect("displayGrayscale", shouldDisplayGrayscale);     // Catch: Exception -> L12
        ColorDisplayManager r0 = this.mColorDisplayManager;     // Catch: Exception -> L12
        if (shouldDisplayGrayscale == false) goto L9;
        int r1 = 0;
    L10:
        r0.setSaturationLevel(r1);     // Catch: Exception -> L12
        return;
    L9:
        r1 = 100;
    L12:
        e = move-exception;
        Slog.e(TAG, "Could not change grayscale override", e);
        return;
    }

    protected void maybeDimWallpaper(boolean shouldDimWallpaper) {
        if (this.mLastAppliedEffects.shouldDimWallpaper() != shouldDimWallpaper) goto L5;
        return;
    L5:
        if (this.mWallpaperManager == null) goto L18;
        ZenLog.traceApplyDeviceEffect("dimWallpaper", shouldDimWallpaper);     // Catch: Exception -> L12
        WallpaperManager r0 = this.mWallpaperManager;     // Catch: Exception -> L12
        if (shouldDimWallpaper == false) goto L9;
        float r1 = WALLPAPER_DIM_AMOUNT_DIMMED;
    L10:
        r0.setWallpaperDimAmount(r1);     // Catch: Exception -> L12
        return;
    L9:
        r1 = 0.0f;
    L12:
        e = move-exception;
        Slog.e(TAG, "Could not change wallpaper override", e);
        return;
    }

    protected void maybeUseNightMode(boolean shouldUseNightMode, int origin) {
        if (this.mLastAppliedEffects.shouldUseNightMode() == shouldUseNightMode) goto L11;
        updateOrScheduleNightMode(shouldUseNightMode, origin);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Could not change dark theme override", e);
        return;
    }

    private void updateOrScheduleNightMode(boolean useNightMode, int origin) {
        this.mPendingNightMode = useNightMode;
        if (origin != 1) goto L5;
    L16:
        unregisterScreenOffReceiver();
        updateNightModeImmediately(useNightMode);
        return;
    L5:
        if (origin == 2) goto L16;
        if (origin == 3) goto L16;
        if (origin == 7) goto L16;
        if (this.mPowerManager.isInteractive() == false) goto L16;
        if (this.mKeyguardManager.isKeyguardLocked() == true) goto L16;
        ZenLog.traceScheduleApplyDeviceEffect("nightMode", useNightMode);
        registerScreenOffReceiver();
    }

    private void updateNightModeImmediately(final boolean useNightMode) {
        Binder.withCleanCallingIdentity(new DefaultDeviceEffectsApplier$$ExternalSyntheticLambda0(this, useNightMode));
    }

    private /* synthetic */ void lambda$updateNightModeImmediately$1(boolean useNightMode) throws Exception {
        ZenLog.traceApplyDeviceEffect("nightMode", useNightMode);     // Catch: Exception -> L8
        UiModeManager r0 = this.mUiModeManager;     // Catch: Exception -> L8
        if (useNightMode == false) goto L5;
        int r1 = 1001;
    L6:
        r0.setAttentionModeThemeOverlay(r1);     // Catch: Exception -> L8
        return;
    L5:
        r1 = 1000;
    L8:
        e = move-exception;
        Slog.e(TAG, "Could not change wallpaper override", e);
    }

    private void registerScreenOffReceiver() {
        Object r0 = this.mRegisterReceiverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsScreenOffReceiverRegistered == true) goto L9;
        this.mContext.registerReceiver(this.mNightModeWhenScreenOff, SCREEN_OFF_INTENT_FILTER, 4);     // Catch: Throwable -> L7
        this.mIsScreenOffReceiverRegistered = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void unregisterScreenOffReceiver() {
        Object r0 = this.mRegisterReceiverLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsScreenOffReceiverRegistered == false) goto L9;
        this.mIsScreenOffReceiverRegistered = false;     // Catch: Throwable -> L7
        this.mContext.unregisterReceiver(this.mNightModeWhenScreenOff);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
