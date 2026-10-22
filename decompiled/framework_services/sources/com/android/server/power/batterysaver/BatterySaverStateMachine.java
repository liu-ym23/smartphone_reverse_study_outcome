package com.android.server.power.batterysaver;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.BatterySaverPolicyConfig;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.BackgroundThread;
import com.android.server.EventLogTags;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.utils.Slogf;
import java.io.PrintWriter;
import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
public class BatterySaverStateMachine {
    private static final int ADAPTIVE_AUTO_DISABLE_BATTERY_LEVEL = 80;
    private static final long ADAPTIVE_CHANGE_TIMEOUT_MS = 86400000;
    private static final int AUTO_DISABLE_BATTERY_LEVEL_WHEN_CHARGING = 60;
    private static final String BATTERY_SAVER_NOTIF_CHANNEL_ID = "battery_saver_channel";
    private static final boolean DEBUG = true;
    private static final int DYNAMIC_MODE_NOTIFICATION_ID = 1992;
    private static final String DYNAMIC_MODE_NOTIF_CHANNEL_ID = "dynamic_mode_notification";
    private static final String EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key";
    private static final String EXTRA_SHOW_FRAGMENT_TITLE = ":settings:show_fragment_args";
    private static final String PREFERENCE_KEY_BATTERY_SAVER_SCHEDULER = "battery_saver_schedule";
    private static final int STATE_AUTOMATIC_ON = 3;
    private static final int STATE_MANUAL_ON = 2;
    private static final int STATE_OFF = 1;
    private static final int STATE_OFF_AUTOMATIC_SNOOZED = 4;
    private static final int STATE_PENDING_STICKY_ON = 5;
    private static final int STICKY_AUTO_DISABLED_NOTIFICATION_ID = 1993;
    private static final long STICKY_DISABLED_NOTIFY_TIMEOUT_MS = 0;
    private static final String TAG = "BatterySaverStateMachine";
    private int mBatteryLevel;
    private final BatterySaverController mBatterySaverController;
    private final boolean mBatterySaverStickyBehaviourDisabled;
    private final boolean mBatterySaverTurnedOffNotificationEnabled;
    private boolean mBatteryStatusSet;
    private boolean mBootCompleted;
    private final Context mContext;
    private final int mDynamicPowerSavingsDefaultDisableThreshold;
    private int mDynamicPowerSavingsDisableThreshold;
    private boolean mDynamicPowerSavingsEnableBatterySaver;
    private boolean mIsBatteryLevelLow;
    private boolean mIsPowered;
    private long mLastAdaptiveBatterySaverChangedExternallyElapsed;
    private int mLastChangedIntReason;
    private String mLastChangedStrReason;
    private final Object mLock;
    private int mSettingAutomaticBatterySaver;
    private boolean mSettingBatterySaverEnabled;
    private boolean mSettingBatterySaverEnabledSticky;
    private boolean mSettingBatterySaverStickyAutoDisableEnabled;
    private int mSettingBatterySaverStickyAutoDisableThreshold;
    private int mSettingBatterySaverTriggerThreshold;
    private boolean mSettingsLoaded;
    private final ContentObserver mSettingsObserver;
    private int mState;
    private final Runnable mThresholdChangeLogger;

    public static /* synthetic */ void $r8$lambda$G5XBnTUqhgNgX4CDatjiOTV7pEY(BatterySaverStateMachine r0) {
        r0.lambda$onBootCompleted$0();
    }

    public static /* synthetic */ void $r8$lambda$I8OcKyyA70W0hqyFzhIOg7ThIJY(BatterySaverStateMachine r0) {
        r0.lambda$triggerDynamicModeNotification$2();
    }

    public static /* synthetic */ void $r8$lambda$IDDbkPZLfeLEtebEzYCeBPC90hk(BatterySaverStateMachine r0) {
        r0.lambda$triggerDynamicModeNotificationV2$3();
    }

    public static /* synthetic */ void $r8$lambda$UuEtbBfzMq2RZoXeRbI8bOOFC1k(BatterySaverStateMachine r0, int r1) {
        r0.lambda$hideNotification$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$aJQwzie6uMxOY5RyJf9h4bHgK7E(BatterySaverStateMachine r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$mZohpS7xMpod2MMEFOSikigUzao(BatterySaverStateMachine r0) {
        r0.lambda$triggerStickyDisabledNotification$4();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7636$$Nest$fgetmLock(BatterySaverStateMachine r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mrefreshSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7637$$Nest$mrefreshSettingsLocked(BatterySaverStateMachine r0) {
        r0.refreshSettingsLocked();
    }

    static {
        STICKY_DISABLED_NOTIFY_TIMEOUT_MS = Duration.ofHours(12).toMillis();
    }

    public BatterySaverStateMachine(Object lock, Context context, BatterySaverController batterySaverController) {
        final Handler r1 = null;
        this.mSettingsObserver = new AnonymousClass1(this, r1);
        this.mThresholdChangeLogger = new BatterySaverStateMachine$$ExternalSyntheticLambda2(this);
        this.mLock = lock;
        this.mContext = context;
        this.mBatterySaverController = batterySaverController;
        this.mState = 1;
        this.mBatterySaverStickyBehaviourDisabled = this.mContext.getResources().getBoolean(R.bool.config_batterySaver_full_deferFullBackup);
        this.mBatterySaverTurnedOffNotificationEnabled = this.mContext.getResources().getBoolean(R.bool.config_batterySaver_full_disableAnimation);
        this.mDynamicPowerSavingsDefaultDisableThreshold = this.mContext.getResources().getInteger(R.integer.config_flipToScreenOffMaxLatencyMicros);
    }

    public void systemReady() {
        this.mBatterySaverController.systemReady();
        getBatterySaverPolicy().systemReady();
    }

    public BatterySaverController getBatterySaverController() {
        return this.mBatterySaverController;
    }

    public BatterySaverPolicy getBatterySaverPolicy() {
        return this.mBatterySaverController.getBatterySaverPolicy();
    }

    private boolean isAutomaticModeActiveLocked() {
        if (this.mSettingAutomaticBatterySaver == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mSettingBatterySaverTriggerThreshold <= 0) goto L7;
        return true;
    }

    private boolean isInAutomaticLowZoneLocked() {
        return this.mIsBatteryLevelLow;
    }

    private boolean isDynamicModeActiveLocked() {
        if (this.mSettingAutomaticBatterySaver == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.mDynamicPowerSavingsEnableBatterySaver == false) goto L7;
        return true;
    }

    private boolean isInDynamicLowZoneLocked() {
        if (this.mBatteryLevel > this.mDynamicPowerSavingsDisableThreshold) goto L5;
        return true;
    L5:
        return false;
    }

    public void onBootCompleted() {
        Slog.d(TAG, "onBootCompleted");
        putGlobalSetting("low_power", 0);
        runOnBgThread(new BatterySaverStateMachine$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ void lambda$onBootCompleted$0() {
        ContentResolver cr = this.mContext.getContentResolver();
        cr.registerContentObserver(Settings.Global.getUriFor("low_power"), false, this.mSettingsObserver, 0);
        cr.registerContentObserver(Settings.Global.getUriFor("low_power_trigger_level"), false, this.mSettingsObserver, 0);
        cr.registerContentObserver(Settings.Global.getUriFor("automatic_power_save_mode"), false, this.mSettingsObserver, 0);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mBootCompleted = true;     // Catch: Throwable -> L8
        refreshSettingsLocked();     // Catch: Throwable -> L8
        doAutoBatterySaverLocked();     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void runOnBgThread(Runnable r) {
        BackgroundThread.getHandler().post(r);
    }

    void runOnBgThreadLazy(Runnable r, int delayMillis) {
        Handler h = BackgroundThread.getHandler();
        h.removeCallbacks(r);
        h.postDelayed(r, delayMillis);
    }

    private void refreshSettingsLocked() {
        if (getGlobalSetting("low_power", 0) == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean lowPowerModeEnabled = r0;
        if (getGlobalSetting("low_power_sticky", 0) == 0) goto L9;
        boolean lowPowerModeEnabledSticky = true;
    L11:
        if (getGlobalSetting("dynamic_power_savings_enabled", 0) == 0) goto L13;
        boolean dynamicPowerSavingsBatterySaver = true;
    L14:
        int lowPowerModeTriggerLevel = getGlobalSetting("low_power_trigger_level", 0);
        int automaticBatterySaverMode = getGlobalSetting("automatic_power_save_mode", 0);
        int dynamicPowerSavingsDisableThreshold = getGlobalSetting("dynamic_power_savings_disable_threshold", this.mDynamicPowerSavingsDefaultDisableThreshold);
        if (getGlobalSetting("low_power_sticky_auto_disable_enabled", 1) == 0) goto L17;
        boolean isStickyAutoDisableEnabled = true;
    L18:
        int stickyAutoDisableThreshold = getGlobalSetting("low_power_sticky_auto_disable_level", 90);
        setSettingsLocked(lowPowerModeEnabled, lowPowerModeEnabledSticky, lowPowerModeTriggerLevel, isStickyAutoDisableEnabled, stickyAutoDisableThreshold, automaticBatterySaverMode, dynamicPowerSavingsBatterySaver, dynamicPowerSavingsDisableThreshold);
        return;
    L17:
        isStickyAutoDisableEnabled = false;
        goto L18
    L13:
        dynamicPowerSavingsBatterySaver = false;
        goto L14
    L9:
        lowPowerModeEnabledSticky = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    void setSettingsLocked(boolean batterySaverEnabled, boolean batterySaverEnabledSticky, int batterySaverTriggerThreshold, boolean isStickyAutoDisableEnabled, int stickyAutoDisableThreshold, int automaticBatterySaver, boolean dynamicPowerSavingsBatterySaver, int dynamicPowerSavingsDisableThreshold) {
        Slog.d(TAG, "setSettings: enabled=" + batterySaverEnabled + " sticky=" + batterySaverEnabledSticky + " threshold=" + batterySaverTriggerThreshold + " stickyAutoDisableEnabled=" + isStickyAutoDisableEnabled + " stickyAutoDisableThreshold=" + stickyAutoDisableThreshold + " automaticBatterySaver=" + automaticBatterySaver + " dynamicPowerSavingsBatterySaver=" + dynamicPowerSavingsBatterySaver + " dynamicPowerSavingsDisableThreshold=" + dynamicPowerSavingsDisableThreshold);
        this.mSettingsLoaded = true;
        int stickyAutoDisableThreshold2 = Math.max(stickyAutoDisableThreshold, batterySaverTriggerThreshold);
        if (this.mSettingBatterySaverEnabled == batterySaverEnabled) goto L5;
        boolean enabledChanged = true;
    L7:
        if (this.mSettingBatterySaverEnabledSticky == batterySaverEnabledSticky) goto L9;
        boolean stickyChanged = true;
    L11:
        if (this.mSettingBatterySaverTriggerThreshold == batterySaverTriggerThreshold) goto L13;
        boolean thresholdChanged = true;
    L15:
        if (this.mSettingBatterySaverStickyAutoDisableEnabled == isStickyAutoDisableEnabled) goto L17;
        boolean stickyAutoDisableEnabledChanged = true;
    L19:
        if (this.mSettingBatterySaverStickyAutoDisableThreshold == stickyAutoDisableThreshold2) goto L21;
        boolean stickyAutoDisableThresholdChanged = true;
    L23:
        if (this.mSettingAutomaticBatterySaver == automaticBatterySaver) goto L25;
        boolean automaticModeChanged = true;
    L27:
        if (this.mDynamicPowerSavingsDisableThreshold == dynamicPowerSavingsDisableThreshold) goto L29;
        boolean dynamicPowerSavingsThresholdChanged = true;
    L30:
        boolean dynamicPowerSavingsThresholdChanged2 = dynamicPowerSavingsThresholdChanged;
        boolean dynamicPowerSavingsThresholdChanged3 = this.mDynamicPowerSavingsEnableBatterySaver;
        if (dynamicPowerSavingsThresholdChanged3 == dynamicPowerSavingsBatterySaver) goto L33;
        boolean dynamicPowerSavingsBatterySaverChanged = true;
    L34:
        if (enabledChanged == true) goto L43;
        if (stickyChanged == true) goto L43;
        if (thresholdChanged == true) goto L43;
        if (automaticModeChanged == true) goto L43;
        if (stickyAutoDisableEnabledChanged == true) goto L43;
        if (stickyAutoDisableThresholdChanged == true) goto L43;
        if (dynamicPowerSavingsThresholdChanged2 == true) goto L43;
        if (dynamicPowerSavingsBatterySaverChanged == true) goto L43;
        return;
    L43:
        this.mSettingBatterySaverEnabled = batterySaverEnabled;
        this.mSettingBatterySaverEnabledSticky = batterySaverEnabledSticky;
        this.mSettingBatterySaverTriggerThreshold = batterySaverTriggerThreshold;
        this.mSettingBatterySaverStickyAutoDisableEnabled = isStickyAutoDisableEnabled;
        this.mSettingBatterySaverStickyAutoDisableThreshold = stickyAutoDisableThreshold2;
        this.mSettingAutomaticBatterySaver = automaticBatterySaver;
        this.mDynamicPowerSavingsDisableThreshold = dynamicPowerSavingsDisableThreshold;
        this.mDynamicPowerSavingsEnableBatterySaver = dynamicPowerSavingsBatterySaver;
        if (thresholdChanged == false) goto L47;
        runOnBgThreadLazy(this.mThresholdChangeLogger, 2000);
    L47:
        if (this.mSettingBatterySaverStickyAutoDisableEnabled == true) goto L49;
        hideStickyDisabledNotification();
    L49:
        if (enabledChanged == false) goto L54;
        if (batterySaverEnabled == false) goto L52;
        String reason = "Global.low_power changed to 1";
    L53:
        enableBatterySaverLocked(batterySaverEnabled, true, 8, reason);
        return;
    L52:
        reason = "Global.low_power changed to 0";
        goto L53
    L54:
        doAutoBatterySaverLocked();
        return;
    L33:
        dynamicPowerSavingsBatterySaverChanged = false;
        goto L34
    L29:
        dynamicPowerSavingsThresholdChanged = false;
        goto L30
    L25:
        automaticModeChanged = false;
        goto L27
    L21:
        stickyAutoDisableThresholdChanged = false;
        goto L23
    L17:
        stickyAutoDisableEnabledChanged = false;
        goto L19
    L13:
        thresholdChanged = false;
        goto L15
    L9:
        stickyChanged = false;
        goto L11
    L5:
        enabledChanged = false;
        goto L7
    }

    private /* synthetic */ void lambda$new$1() {
        EventLogTags.writeBatterySaverSetting(this.mSettingBatterySaverTriggerThreshold);
    }

    public void setBatteryStatus(boolean newPowered, int newLevel, boolean newBatteryLevelLow) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean lowChanged = true;
        this.mBatteryStatusSet = true;     // Catch: Throwable -> L22
        if (this.mIsPowered == newPowered) goto L8;
        boolean poweredChanged = true;
    L10:
        if (this.mBatteryLevel == newLevel) goto L12;
        boolean levelChanged = true;
    L14:
        if (this.mIsBatteryLevelLow != newBatteryLevelLow) goto L17;
        lowChanged = false;
    L17:
        if (poweredChanged == true) goto L24;
        if (levelChanged == true) goto L24;
        if (lowChanged == true) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L24:
        Slog.d(TAG, "setBatteryStatus: powered=" + newPowered + " level=" + newLevel + " low=" + newBatteryLevelLow);     // Catch: Throwable -> L22
        this.mIsPowered = newPowered;     // Catch: Throwable -> L22
        this.mBatteryLevel = newLevel;     // Catch: Throwable -> L22
        this.mIsBatteryLevelLow = newBatteryLevelLow;     // Catch: Throwable -> L22
        doAutoBatterySaverLocked();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L12:
        levelChanged = false;
        goto L14
    L8:
        poweredChanged = false;
    L22:
        th = move-exception;
        throw th;
    }

    public BatterySaverPolicyConfig getFullBatterySaverPolicy() {
        Slog.d(TAG, "getFullBatterySaverPolicy");
        Object r0 = this.mLock;
        monitor-enter(r0);
        BatterySaverPolicyConfig r1 = this.mBatterySaverController.getPolicyLocked(2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setFullBatterySaverPolicy(BatterySaverPolicyConfig config) {
        Slog.d(TAG, "setFullBatterySaverPolicy: config=" + config);
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mBatterySaverController.setFullPolicyLocked(config, 13);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setAdaptiveBatterySaverEnabled(boolean enabled) {
        Slog.d(TAG, "setAdaptiveBatterySaverEnabled: enabled=" + enabled);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastAdaptiveBatterySaverChangedExternallyElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        boolean r1 = this.mBatterySaverController.setAdaptivePolicyEnabledLocked(enabled, 11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setAdaptiveBatterySaverPolicy(BatterySaverPolicyConfig config) {
        Slog.d(TAG, "setAdaptiveBatterySaverPolicy: config=" + config);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastAdaptiveBatterySaverChangedExternallyElapsed = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        boolean r1 = this.mBatterySaverController.setAdaptivePolicyLocked(config, 11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void doAutoBatterySaverLocked() {
        Slog.d(TAG, "doAutoBatterySaverLocked: mBootCompleted=" + this.mBootCompleted + " mSettingsLoaded=" + this.mSettingsLoaded + " mBatteryStatusSet=" + this.mBatteryStatusSet + " mState=" + this.mState + " mIsBatteryLevelLow=" + this.mIsBatteryLevelLow + " mIsPowered=" + this.mIsPowered + " mSettingAutomaticBatterySaver=" + this.mSettingAutomaticBatterySaver + " mSettingBatterySaverEnabledSticky=" + this.mSettingBatterySaverEnabledSticky + " mSettingBatterySaverStickyAutoDisableEnabled=" + this.mSettingBatterySaverStickyAutoDisableEnabled);
        if (this.mBootCompleted == true) goto L5;
        return;
    L5:
        if (this.mSettingsLoaded == true) goto L7;
        return;
    L7:
        if (this.mBatteryStatusSet == false) goto L23;
        updateStateLocked(false, false);
        if ((SystemClock.elapsedRealtime() - this.mLastAdaptiveBatterySaverChangedExternallyElapsed) <= 86400000) goto L13;
        this.mBatterySaverController.setAdaptivePolicyEnabledLocked(false, 12);
        this.mBatterySaverController.resetAdaptivePolicyLocked(12);
        return;
    L13:
        if (this.mIsPowered == true) goto L15;
        return;
    L15:
        if (this.mBatteryLevel < 80) goto L21;
        this.mBatterySaverController.setAdaptivePolicyEnabledLocked(false, 7);
        return;
    L21:
        return;
    }

    private void updateStateLocked(boolean manual, boolean enable) {
        if (manual == false) goto L5;
    L11:
        int oldState = this.mState;
        switch(this.mState) {
            case 1: goto L41;
            case 2: goto L36;
            case 3: goto L26;
            case 4: goto L15;
            case 5: goto L14;
            default: goto L13;
        };
    L13:
        Slog.wtf(TAG, "Unknown state: " + this.mState);
    L53:
        Slogf.d(TAG, "updateStateLocked state[%d->%d], manu[%b,%b], powered[%b, %b, %d],settingAutoBS=%d,BSTriggerThreshold=%d,dynamicEnableBS=%b,dynamicDisableThreshold=%d,settingBSEnableSticky=%b,BSStickyBehaviourDisabled=%b,settingBSStickyAutoDisableEnable=%b,settingBSAutoDisableThreshold=%d", new Object[]{Integer.valueOf(oldState), Integer.valueOf(this.mState), Boolean.valueOf(manual), Boolean.valueOf(enable), Boolean.valueOf(this.mIsPowered), Boolean.valueOf(this.mIsBatteryLevelLow), Integer.valueOf(this.mBatteryLevel), Integer.valueOf(this.mSettingAutomaticBatterySaver), Integer.valueOf(this.mSettingBatterySaverTriggerThreshold), Boolean.valueOf(this.mDynamicPowerSavingsEnableBatterySaver), Integer.valueOf(this.mDynamicPowerSavingsDisableThreshold), Boolean.valueOf(this.mSettingBatterySaverEnabledSticky), Boolean.valueOf(this.mBatterySaverStickyBehaviourDisabled), Boolean.valueOf(this.mSettingBatterySaverStickyAutoDisableEnabled), Integer.valueOf(this.mSettingBatterySaverStickyAutoDisableThreshold)});
        return;
    L14:
        this.mState = 1;
        goto L53
    L15:
        if (manual == false) goto L19;
        if (enable == false) goto L19;
        enableBatterySaverLocked(true, true, 2);
        this.mState = 2;
    L19:
        if (isInAutomaticLowZoneLocked() == true) goto L21;
    L24:
        this.mState = 1;
        goto L53
    L21:
        if (isAutomaticModeActiveLocked() == false) goto L24;
        if (this.mBatteryLevel < 60) goto L53;
    L36:
        if (manual == false) goto L53;
        if (enable == false) goto L40;
        Slog.e(TAG, "Tried to enable BS when it's already MANUAL_ON");
        return;
    L40:
        enableBatterySaverLocked(false, true, 3);
        this.mState = 1;
        goto L53
    L41:
        if (manual == false) goto L47;
        if (enable == true) goto L45;
        Slog.e(TAG, "Tried to disable BS when it's already OFF");
        return;
    L45:
        enableBatterySaverLocked(true, true, 2);
        this.mState = 2;
        goto L53
    L47:
        if (isAutomaticModeActiveLocked() == false) goto L53;
        if (isInAutomaticLowZoneLocked() == false) goto L53;
        if (this.mIsPowered == true) goto L53;
        enableBatterySaverLocked(true, false, 0);
        this.mState = 3;
        goto L53
    L26:
        if (this.mBatteryLevel < 60) goto L28;
        enableBatterySaverLocked(false, false, 1);
        this.mState = 1;
        goto L53
    L28:
        if (manual == false) goto L34;
        if (enable == false) goto L32;
        Slog.e(TAG, "Tried to enable BS when it's already AUTO_ON");
        return;
    L32:
        enableBatterySaverLocked(false, true, 3);
        this.mState = 4;
        goto L53
    L34:
        if (isAutomaticModeActiveLocked() == true) goto L53;
        enableBatterySaverLocked(false, false, 8);
        this.mState = 1;
        goto L53
    L5:
        if (this.mBootCompleted == true) goto L7;
        return;
    L7:
        if (this.mSettingsLoaded == true) goto L9;
        return;
    L9:
        if (this.mBatteryStatusSet == true) goto L11;
    }

    int getState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setBatterySaverEnabledManually(boolean enabled) {
        Slog.d(TAG, "setBatterySaverEnabledManually: enabled=" + enabled);
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateStateLocked(true, enabled);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void enableBatterySaverLocked(boolean enable, boolean manual, int intReason) {
        enableBatterySaverLocked(enable, manual, intReason, BatterySaverController.reasonToString(intReason));
    }

    private void enableBatterySaverLocked(boolean r11, boolean r12, int r13, String r14) {
        Slog.d(TAG, "enableBatterySaver: enable=" + r11 + " manual=" + r12 + " reason=" + r14 + "(" + r13 + ")");
        if (this.mBatterySaverController.isFullEnabled() != r11) goto L10;
        StringBuilder r1 = new StringBuilder();
        r1.append("Already ");
        if (r11 == false) goto L7;
        String r2 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L8:
        r1.append(r2);
        Slog.d(TAG, r1.toString());
        return;
    L7:
        r2 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L8
    L10:
        if (r11 == true) goto L21;
        boolean r8 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "feature_phone_mode", 0) == 0) goto L14;
        r8 = true;
    L14:
        if (r8 == false) goto L17;
        Slog.d(TAG, "Being feature phone mode, not disable battery save mode!!!");
        return;
    L17:
        if (r12 == false) goto L21;
        if (this.mState != 2) goto L21;
        this.mState = 1;
    L21:
        this.mLastChangedIntReason = r13;
        this.mLastChangedStrReason = r14;
        this.mSettingBatterySaverEnabled = r11;
        putGlobalSetting("low_power", r11 ? 1 : 0);
        this.mBatterySaverController.enableBatterySaver(r11, r13);
        if (r13 == 9) goto L27;
        if (r13 == 0) goto L27;
        if (r11 == true) goto L28;
        hideDynamicModeNotification();
    L28:
        Slog.d(TAG, "Battery saver: Enabled=" + r11 + " manual=" + r12 + " reason=" + r14 + "(" + r13 + ")");
        StringBuilder r3 = new StringBuilder();
        r3.append("reason=");
        r3.append(r12);
        r3.append(",");
        r3.append(r14);
        r3.append("(");
        r3.append(r13);
        r3.append(")");
        SysMonitorSvcBridge.getFactory().getSmartPowerDataInstance().noteBatterySaverState(r11 ? 1 : 0, r3.toString());
        return;
    L27:
        triggerDynamicModeNotificationV2();
        goto L28
    }

    void triggerDynamicModeNotification() {
        runOnBgThread(new BatterySaverStateMachine$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$triggerDynamicModeNotification$2() {
        NotificationManager manager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        ensureNotificationChannelExists(manager, DYNAMIC_MODE_NOTIF_CHANNEL_ID, R.string.face_acquired_poor_gaze);
        manager.notifyAsUser(TAG, DYNAMIC_MODE_NOTIFICATION_ID, buildNotification(DYNAMIC_MODE_NOTIF_CHANNEL_ID, R.string.face_acquired_roll_too_extreme, R.string.face_acquired_recalibrate, "android.settings.BATTERY_SAVER_SETTINGS", 0, R.drawable.pointer_wait_6), UserHandle.ALL);
    }

    void triggerDynamicModeNotificationV2() {
        runOnBgThread(new BatterySaverStateMachine$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$triggerDynamicModeNotificationV2$3() {
        NotificationManager manager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        ensureNotificationChannelExists(manager, DYNAMIC_MODE_NOTIF_CHANNEL_ID, R.string.face_acquired_poor_gaze);
        Bundle highlightBundle = new Bundle(1);
        highlightBundle.putString(EXTRA_FRAGMENT_ARG_KEY, PREFERENCE_KEY_BATTERY_SAVER_SCHEDULER);
        manager.notifyAsUser(TAG, DYNAMIC_MODE_NOTIFICATION_ID, buildNotificationV2(DYNAMIC_MODE_NOTIF_CHANNEL_ID, R.string.face_acquired_sensor_dirty, R.string.face_acquired_recalibrate_alt, "android.settings.BATTERY_SAVER_SETTINGS", 0, highlightBundle, R.drawable.pointer_wait_42), UserHandle.ALL);
    }

    void triggerStickyDisabledNotification() {
        if (this.mBatterySaverTurnedOffNotificationEnabled == true) goto L5;
        return;
    L5:
        runOnBgThread(new BatterySaverStateMachine$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$triggerStickyDisabledNotification$4() {
        NotificationManager manager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        ensureNotificationChannelExists(manager, BATTERY_SAVER_NOTIF_CHANNEL_ID, R.string.call_notification_hang_up_action);
        manager.notifyAsUser(TAG, STICKY_AUTO_DISABLED_NOTIFICATION_ID, buildNotification(BATTERY_SAVER_NOTIF_CHANNEL_ID, R.string.call_notification_incoming_text, R.string.call_notification_answer_action, "android.settings.BATTERY_SAVER_SETTINGS", STICKY_DISABLED_NOTIFY_TIMEOUT_MS, R.drawable.pointer_wait_6), UserHandle.ALL);
    }

    private void ensureNotificationChannelExists(NotificationManager manager, String channelId, int nameId) {
        NotificationChannel channel = new NotificationChannel(channelId, this.mContext.getText(nameId), 3);
        channel.setSound(null, null);
        channel.setBlockable(true);
        manager.createNotificationChannel(channel);
    }

    private Notification buildNotification(String channelId, int titleId, int summaryId, String intentAction, long timeoutMs, int iconResId) {
        Resources res = this.mContext.getResources();
        Intent intent = new Intent(intentAction);
        intent.setFlags(268468224);
        PendingIntent batterySaverIntent = PendingIntent.getActivity(this.mContext, 0, intent, AudioFormat.DTS_HD);
        String title = res.getString(titleId);
        String summary = res.getString(summaryId);
        return new Notification.Builder(this.mContext, channelId).setSmallIcon(iconResId).setContentTitle(title).setContentText(summary).setContentIntent(batterySaverIntent).setStyle(new Notification.BigTextStyle().bigText(summary)).setOnlyAlertOnce(true).setAutoCancel(true).setTimeoutAfter(timeoutMs).build();
    }

    private Notification buildNotificationV2(String channelId, int titleId, int summaryId, String intentAction, long timeoutMs, Bundle highlightBundle, int iconResId) {
        Resources res = this.mContext.getResources();
        Intent intent = new Intent(intentAction).setFlags(268468224).putExtra(EXTRA_SHOW_FRAGMENT_TITLE, highlightBundle);
        PendingIntent batterySaverIntent = PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.DTS_HD, null, UserHandle.CURRENT);
        String title = res.getString(titleId);
        String summary = res.getString(summaryId);
        return new Notification.Builder(this.mContext, channelId).setSmallIcon(iconResId).setContentTitle(title).setContentText(summary).setContentIntent(batterySaverIntent).setStyle(new Notification.BigTextStyle().bigText(summary)).setOnlyAlertOnce(true).setAutoCancel(true).setTimeoutAfter(timeoutMs).build();
    }

    private void hideDynamicModeNotification() {
        hideNotification(DYNAMIC_MODE_NOTIFICATION_ID);
    }

    private void hideStickyDisabledNotification() {
        hideNotification(STICKY_AUTO_DISABLED_NOTIFICATION_ID);
    }

    private void hideNotification(final int notificationId) {
        runOnBgThread(new BatterySaverStateMachine$$ExternalSyntheticLambda5(this, notificationId));
    }

    private /* synthetic */ void lambda$hideNotification$5(int notificationId) {
        NotificationManager manager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        manager.cancelAsUser(TAG, notificationId, UserHandle.ALL);
    }

    private void setStickyActive(boolean r3) {
        this.mSettingBatterySaverEnabledSticky = r3;
        putGlobalSetting("low_power_sticky", this.mSettingBatterySaverEnabledSticky ? 1 : 0);
    }

    protected void putGlobalSetting(String key, int value) {
        Settings.Global.putInt(this.mContext.getContentResolver(), key, value);
    }

    protected int getGlobalSetting(String key, int defValue) {
        return Settings.Global.getInt(this.mContext.getContentResolver(), key, defValue);
    }

    public void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.println();
        ipw.println("Battery saver state machine:");
        ipw.increaseIndent();
        Object r1 = this.mLock;
        monitor-enter(r1);
        ipw.print("Enabled=");     // Catch: Throwable -> L7
        ipw.println(this.mBatterySaverController.isEnabled());     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        ipw.print("full=");     // Catch: Throwable -> L7
        ipw.println(this.mBatterySaverController.isFullEnabled());     // Catch: Throwable -> L7
        ipw.print("adaptive=");     // Catch: Throwable -> L7
        ipw.print(this.mBatterySaverController.isAdaptiveEnabled());     // Catch: Throwable -> L7
        if (this.mBatterySaverController.isAdaptiveEnabled() == false) goto L9;
        ipw.print(" (advertise=");     // Catch: Throwable -> L7
        ipw.print(getBatterySaverPolicy().shouldAdvertiseIsEnabled());     // Catch: Throwable -> L7
        ipw.print(")");     // Catch: Throwable -> L7
    L9:
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println();     // Catch: Throwable -> L7
        ipw.print("mState=");     // Catch: Throwable -> L7
        ipw.println(this.mState);     // Catch: Throwable -> L7
        ipw.print("mLastChangedIntReason=");     // Catch: Throwable -> L7
        ipw.println(this.mLastChangedIntReason);     // Catch: Throwable -> L7
        ipw.print("mLastChangedStrReason=");     // Catch: Throwable -> L7
        ipw.println(this.mLastChangedStrReason);     // Catch: Throwable -> L7
        ipw.print("mBootCompleted=");     // Catch: Throwable -> L7
        ipw.println(this.mBootCompleted);     // Catch: Throwable -> L7
        ipw.print("mSettingsLoaded=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingsLoaded);     // Catch: Throwable -> L7
        ipw.print("mBatteryStatusSet=");     // Catch: Throwable -> L7
        ipw.println(this.mBatteryStatusSet);     // Catch: Throwable -> L7
        ipw.print("mIsPowered=");     // Catch: Throwable -> L7
        ipw.println(this.mIsPowered);     // Catch: Throwable -> L7
        ipw.print("mBatteryLevel=");     // Catch: Throwable -> L7
        ipw.println(this.mBatteryLevel);     // Catch: Throwable -> L7
        ipw.print("mIsBatteryLevelLow=");     // Catch: Throwable -> L7
        ipw.println(this.mIsBatteryLevelLow);     // Catch: Throwable -> L7
        ipw.print("mSettingAutomaticBatterySaver=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingAutomaticBatterySaver);     // Catch: Throwable -> L7
        ipw.print("mSettingBatterySaverEnabled=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingBatterySaverEnabled);     // Catch: Throwable -> L7
        ipw.print("mSettingBatterySaverEnabledSticky=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingBatterySaverEnabledSticky);     // Catch: Throwable -> L7
        ipw.print("mSettingBatterySaverStickyAutoDisableEnabled=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingBatterySaverStickyAutoDisableEnabled);     // Catch: Throwable -> L7
        ipw.print("mSettingBatterySaverStickyAutoDisableThreshold=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingBatterySaverStickyAutoDisableThreshold);     // Catch: Throwable -> L7
        ipw.print("mSettingBatterySaverTriggerThreshold=");     // Catch: Throwable -> L7
        ipw.println(this.mSettingBatterySaverTriggerThreshold);     // Catch: Throwable -> L7
        ipw.print("mBatterySaverStickyBehaviourDisabled=");     // Catch: Throwable -> L7
        ipw.println(this.mBatterySaverStickyBehaviourDisabled);     // Catch: Throwable -> L7
        ipw.print("mBatterySaverTurnedOffNotificationEnabled=");     // Catch: Throwable -> L7
        ipw.println(this.mBatterySaverTurnedOffNotificationEnabled);     // Catch: Throwable -> L7
        ipw.print("mDynamicPowerSavingsDefaultDisableThreshold=");     // Catch: Throwable -> L7
        ipw.println(this.mDynamicPowerSavingsDefaultDisableThreshold);     // Catch: Throwable -> L7
        ipw.print("mDynamicPowerSavingsDisableThreshold=");     // Catch: Throwable -> L7
        ipw.println(this.mDynamicPowerSavingsDisableThreshold);     // Catch: Throwable -> L7
        ipw.print("mDynamicPowerSavingsEnableBatterySaver=");     // Catch: Throwable -> L7
        ipw.println(this.mDynamicPowerSavingsEnableBatterySaver);     // Catch: Throwable -> L7
        ipw.print("mLastAdaptiveBatterySaverChangedExternallyElapsed=");     // Catch: Throwable -> L7
        ipw.println(this.mLastAdaptiveBatterySaverChangedExternallyElapsed);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        ipw.decreaseIndent();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dumpProto(ProtoOutputStream proto, long tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long token = proto.start(tag);     // Catch: Throwable -> L7
        proto.write(1133871366145L, this.mBatterySaverController.isEnabled());     // Catch: Throwable -> L7
        proto.write(1159641169938L, this.mState);     // Catch: Throwable -> L7
        proto.write(1133871366158L, this.mBatterySaverController.isFullEnabled());     // Catch: Throwable -> L7
        proto.write(1133871366159L, this.mBatterySaverController.isAdaptiveEnabled());     // Catch: Throwable -> L7
        proto.write(1133871366160L, getBatterySaverPolicy().shouldAdvertiseIsEnabled());     // Catch: Throwable -> L7
        proto.write(1133871366146L, this.mBootCompleted);     // Catch: Throwable -> L7
        proto.write(1133871366147L, this.mSettingsLoaded);     // Catch: Throwable -> L7
        proto.write(1133871366148L, this.mBatteryStatusSet);     // Catch: Throwable -> L7
        proto.write(1133871366150L, this.mIsPowered);     // Catch: Throwable -> L7
        proto.write(1120986464263L, this.mBatteryLevel);     // Catch: Throwable -> L7
        proto.write(1133871366152L, this.mIsBatteryLevelLow);     // Catch: Throwable -> L7
        proto.write(1159641169939L, this.mSettingAutomaticBatterySaver);     // Catch: Throwable -> L7
        proto.write(1133871366153L, this.mSettingBatterySaverEnabled);     // Catch: Throwable -> L7
        proto.write(1133871366154L, this.mSettingBatterySaverEnabledSticky);     // Catch: Throwable -> L7
        proto.write(1120986464267L, this.mSettingBatterySaverTriggerThreshold);     // Catch: Throwable -> L7
        proto.write(1133871366156L, this.mSettingBatterySaverStickyAutoDisableEnabled);     // Catch: Throwable -> L7
        proto.write(1120986464269L, this.mSettingBatterySaverStickyAutoDisableThreshold);     // Catch: Throwable -> L7
        proto.write(1120986464276L, this.mDynamicPowerSavingsDefaultDisableThreshold);     // Catch: Throwable -> L7
        proto.write(1120986464277L, this.mDynamicPowerSavingsDisableThreshold);     // Catch: Throwable -> L7
        proto.write(1133871366166L, this.mDynamicPowerSavingsEnableBatterySaver);     // Catch: Throwable -> L7
        proto.write(1112396529681L, this.mLastAdaptiveBatterySaverChangedExternallyElapsed);     // Catch: Throwable -> L7
        proto.end(token);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
