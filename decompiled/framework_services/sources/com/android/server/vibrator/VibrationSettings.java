package com.android.server.vibrator;

import android.R;
import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.SynchronousUserSwitchObserver;
import android.app.UidObserver;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.DisturbModeUtils;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.RemoteException;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.vibrator.VibrationConfig;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.proto.ProtoOutputStream;
import com.android.server.LocalServices;
import com.android.server.am.HostingRecord;
import com.android.server.audio.ZDtsSceneManager$$ExternalSyntheticLambda7;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.utils.PriorityDump;
import com.android.server.wm.WindowManagerInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes3.dex */
final class VibrationSettings {
    private static final Set<Integer> BACKGROUND_PROCESS_USAGE_ALLOWLIST = null;
    private static final Set<Integer> BATTERY_SAVER_USAGE_ALLOWLIST = null;
    private static final String CALENDAR_PACKAGE = "com.obric.calendar";
    private static final String MAIL_PACKAGE = "com.android.email";
    private static final String MMS_PACKAGE = "com.android.mms";
    private static final String PHONE_SETTINGS_ACTIVIT_CLASS_NAME = "com.android.phone.setting.SettingActivity";
    private static final Set<Integer> POWER_MANAGER_SLEEP_REASON_ALLOWLIST = null;
    private static final Set<Integer> SYSTEM_VIBRATION_SCREEN_OFF_USAGE_ALLOWLIST = null;
    private static final String TAG = "VibrationSettings";
    private static final String TELEPHONY_PACKAGE_NAME = "com.android.server.telecom";
    private static final int VIBRATE_ON_DISABLED_USAGE_ALLOWED = 66;
    private static final Set<String> WHITELISTED_APPS = null;
    private AudioManager mAudioManager;
    final BatteryBroadcastReceiver mBatteryBroadcastReceiver;
    private boolean mBatterySaverMode;
    private boolean mCalendarVibrationEnabled;
    private final Context mContext;
    private SparseIntArray mCurrentVibrationIntensities;
    private DisturbModeUtils mDisturbModeUtils;
    private final SparseArray<VibrationEffect> mFallbackEffects;
    private boolean mGlobalVibrationEnabled;
    private final List<OnVibratorSettingsChanged> mListeners;
    private final Object mLock;
    final VibrationLowPowerModeListener mLowPowerModeListener;
    private boolean mMailVibrationEnabled;
    private boolean mNotificationVibrationEnabled;
    private boolean mOnWirelessCharger;
    private PowerManagerInternal mPowerManagerInternal;
    private int mRingerMode;
    final RingerModeBroadcastReceiver mRingerModeBroadcastReceiver;
    private VibratorServiceSmtEx mServiceSmtEx;
    final SettingsContentObserver mSettingObserver;
    private boolean mSms1VibrationEnabled;
    private boolean mSms2VibrationEnabled;
    private String mSystemUiPackage;
    private boolean mTelephonyVibrationEnabled;
    final VibrationUidObserver mUidObserver;
    final VibrationUserSwitchObserver mUserSwitchObserver;
    private boolean mVibrateInputDevices;
    private boolean mVibrateOn;
    private final VibrationConfig mVibrationConfig;
    private VirtualDeviceManagerInternal mVirtualDeviceManagerInternal;
    private WindowManagerInternal mWindowManagerInternal;

    final class BatteryBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ VibrationSettings this$0;

        BatteryBroadcastReceiver(VibrationSettings this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.BATTERY_CHANGED".equals(action) == false) goto L6;
            VibrationSettings.m9291$$Nest$mupdateBatteryInfo(this.this$0, intent);
            return;
        }
    }

    interface OnVibratorSettingsChanged {
        void onChange();
    }

    final class RingerModeBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ VibrationSettings this$0;

        RingerModeBroadcastReceiver(VibrationSettings this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION".equals(action) == false) goto L6;
            VibrationSettings.m9292$$Nest$mupdateRingerMode(this.this$0);
            VibrationSettings.m9290$$Nest$mnotifyListeners(this.this$0);
            return;
        }
    }

    final class SettingsContentObserver extends ContentObserver {
        final /* synthetic */ VibrationSettings this$0;

        SettingsContentObserver(VibrationSettings this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            VibrationSettings.m9293$$Nest$mupdateSettings(this.this$0, -2);
            VibrationSettings.m9290$$Nest$mnotifyListeners(this.this$0);
        }
    }

    final class VibrationLowPowerModeListener implements PowerManagerInternal.LowPowerModeListener {
        final /* synthetic */ VibrationSettings this$0;

        VibrationLowPowerModeListener(VibrationSettings this$0) {
            this.this$0 = this$0;
        }

        public int getServiceType() {
            return 2;
        }

        public void onLowPowerModeChanged(PowerSaveState result) {
            Object r0 = VibrationSettings.m9288$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (result.batterySaverEnabled == VibrationSettings.m9287$$Nest$fgetmBatterySaverMode(this.this$0)) goto L7;
            boolean shouldNotifyListeners = true;
        L8:
            VibrationSettings.m9289$$Nest$fputmBatterySaverMode(this.this$0, result.batterySaverEnabled);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            if (shouldNotifyListeners == false) goto L18;
            VibrationSettings.m9290$$Nest$mnotifyListeners(this.this$0);
            return;
        L18:
            return;
        L7:
            shouldNotifyListeners = false;
            goto L8
        }
    }

    final class VibrationUidObserver extends UidObserver {
        private final SparseArray<Integer> mProcStatesCache;

        /* JADX INFO: renamed from: -$$Nest$fgetmProcStatesCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m9294$$Nest$fgetmProcStatesCache(VibrationUidObserver r0) {
            return r0.mProcStatesCache;
        }

        VibrationUidObserver(VibrationSettings this$0) {
            this.mProcStatesCache = new SparseArray();
        }

        public boolean isUidForeground(int uid) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.mProcStatesCache.get(uid, 6).intValue() > 6) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);     // Catch: Throwable -> L9
            return r0;
        L6:
            r0 = false;
            goto L7
        }

        public void onUidGone(int uid, boolean disabled) {
            monitor-enter(this);
            this.mProcStatesCache.delete(uid);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public void onUidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            monitor-enter(this);
            this.mProcStatesCache.put(uid, Integer.valueOf(procState));     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    final class VibrationUserSwitchObserver extends SynchronousUserSwitchObserver {
        final /* synthetic */ VibrationSettings this$0;

        VibrationUserSwitchObserver(VibrationSettings this$0) {
            this.this$0 = this$0;
        }

        public void onUserSwitching(int newUserId) {
            VibrationSettings.m9293$$Nest$mupdateSettings(this.this$0, newUserId);
            VibrationSettings.m9290$$Nest$mnotifyListeners(this.this$0);
        }

        public void onUserSwitchComplete(int newUserId) {
            this.this$0.update();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatterySaverMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9287$$Nest$fgetmBatterySaverMode(VibrationSettings r0) {
        return r0.mBatterySaverMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9288$$Nest$fgetmLock(VibrationSettings r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBatterySaverMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9289$$Nest$fputmBatterySaverMode(VibrationSettings r0, boolean r1) {
        r0.mBatterySaverMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9290$$Nest$mnotifyListeners(VibrationSettings r0) {
        r0.notifyListeners();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateBatteryInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9291$$Nest$mupdateBatteryInfo(VibrationSettings r0, Intent r1) {
        r0.updateBatteryInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRingerMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9292$$Nest$mupdateRingerMode(VibrationSettings r0) {
        r0.updateRingerMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9293$$Nest$mupdateSettings(VibrationSettings r0, int r1) {
        r0.updateSettings(r1);
    }

    static {
        BACKGROUND_PROCESS_USAGE_ALLOWLIST = new HashSet(Arrays.asList(new Integer[]{33, 17, 49, 65, 50, 34}));
        BATTERY_SAVER_USAGE_ALLOWLIST = new HashSet(Arrays.asList(new Integer[]{33, 17, 65, 34, 50}));
        SYSTEM_VIBRATION_SCREEN_OFF_USAGE_ALLOWLIST = new HashSet(Arrays.asList(new Integer[]{18, 66, 34, 50}));
        POWER_MANAGER_SLEEP_REASON_ALLOWLIST = new HashSet(Arrays.asList(new Integer[]{9, 2}));
        WHITELISTED_APPS = new HashSet(Set.of(CALENDAR_PACKAGE, MAIL_PACKAGE, MMS_PACKAGE));
    }

    VibrationSettings(Context context, Handler handler) {
        this(context, handler, new VibrationConfig(context.getResources()));
    }

    VibrationSettings(Context context, Handler handler, VibrationConfig config) {
        this.mLock = new Object();
        this.mListeners = new ArrayList();
        this.mCurrentVibrationIntensities = new SparseIntArray();
        this.mContext = context;
        this.mVibrationConfig = config;
        this.mSettingObserver = new SettingsContentObserver(this, handler);
        this.mRingerModeBroadcastReceiver = new RingerModeBroadcastReceiver(this);
        this.mBatteryBroadcastReceiver = new BatteryBroadcastReceiver(this);
        this.mUidObserver = new VibrationUidObserver(this);
        this.mUserSwitchObserver = new VibrationUserSwitchObserver(this);
        this.mLowPowerModeListener = new VibrationLowPowerModeListener(this);
        VibrationEffect clickEffect = createEffectFromResource(R.array.maps_starting_lat_lng);
        VibrationEffect doubleClickEffect = createEffectFromResource(R.array.config_force_cellular_transport_capabilities);
        VibrationEffect heavyClickEffect = createEffectFromResource(R.array.config_ntpServers);
        VibrationEffect tickEffect = createEffectFromResource(R.array.config_deviceSpecificSystemServices);
        this.mFallbackEffects = new SparseArray();
        this.mFallbackEffects.put(0, clickEffect);
        this.mFallbackEffects.put(1, doubleClickEffect);
        this.mFallbackEffects.put(2, tickEffect);
        this.mFallbackEffects.put(5, heavyClickEffect);
        this.mFallbackEffects.put(21, VibrationEffect.get(2, false));
        update();
        this.mDisturbModeUtils = DisturbModeUtils.getInstance(this.mContext);
    }

    public void onSystemReady() {
        onSystemReady((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class), ActivityManager.getService(), (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class), (AudioManager) this.mContext.getSystemService(AudioManager.class));
    }

    void onSystemReady(PackageManagerInternal packageManagerInternal, PowerManagerInternal powerManagerInternal, IActivityManager activityManagerInternal, VirtualDeviceManagerInternal virtualDeviceManagerInternal, AudioManager audioManager) {
        if (audioManager != null) goto L5;
        int ringerMode = 2;
    L6:
        String sysUiPackage = packageManagerInternal.getSystemUiServiceComponent().getPackageName();
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mPowerManagerInternal = powerManagerInternal;     // Catch: Throwable -> L23
        this.mVirtualDeviceManagerInternal = virtualDeviceManagerInternal;     // Catch: Throwable -> L23
        this.mAudioManager = audioManager;     // Catch: Throwable -> L23
        this.mRingerMode = ringerMode;     // Catch: Throwable -> L23
        this.mSystemUiPackage = sysUiPackage;     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        activityManagerInternal.registerUidObserver(this.mUidObserver, 3, -1, null);     // Catch: RemoteException -> L12
    L26:
        activityManagerInternal.registerUserSwitchObserver(this.mUserSwitchObserver, TAG);     // Catch: RemoteException -> L15
    L16:
        powerManagerInternal.registerLowPowerModeObserver(this.mLowPowerModeListener);
        this.mContext.registerReceiver(this.mRingerModeBroadcastReceiver, new IntentFilter("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION"), 2);
        registerSettingsObserver(Settings.System.getUriFor("vibrate_input_devices"));
        registerSettingsObserver(Settings.System.getUriFor("vibrate_on"));
        registerSettingsObserver(Settings.System.getUriFor("haptic_feedback_enabled"));
        registerSettingsObserver(Settings.System.getUriFor("alarm_vibration_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("haptic_feedback_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("hardware_haptic_feedback_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("media_vibration_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("notification_vibration_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("ring_vibration_intensity"));
        registerSettingsObserver(Settings.System.getUriFor("keyboard_vibration_enabled"));
        if (this.mVibrationConfig.ignoreVibrationsOnWirelessCharger() == false) goto L21;
        Intent batteryStatus = this.mContext.registerReceiver(this.mBatteryBroadcastReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"), 4);
        if (batteryStatus == null) goto L21;
        updateBatteryInfo(batteryStatus);
    L21:
        registerSettingsObserver(Settings.Global.getUriFor("telephony_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("global_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("calendar_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("sms_1_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("sms_2_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("mail_vibration_enabled"));
        registerSettingsObserver(Settings.Global.getUriFor("notification_vibration_enabled"));
        update();
        return;
    L23:
        th = move-exception;
        throw th;
    L5:
        ringerMode = audioManager.getRingerModeInternal();
        goto L6
    }

    public void addListener(OnVibratorSettingsChanged listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mListeners.contains(listener) == true) goto L9;
        this.mListeners.add(listener);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void removeListener(OnVibratorSettingsChanged listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int getRampStepDuration() {
        return this.mVibrationConfig.getRampStepDurationMs();
    }

    public int getRampDownDuration() {
        return this.mVibrationConfig.getRampDownDurationMs();
    }

    public int getDefaultIntensity(int usageHint) {
        return this.mVibrationConfig.getDefaultVibrationIntensity(usageHint);
    }

    public int getCurrentIntensity(int usageHint) {
        int defaultIntensity = getDefaultIntensity(usageHint);
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r2 = this.mCurrentVibrationIntensities.get(usageHint, defaultIntensity);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public int getRequestVibrationParamsTimeoutMs() {
        return this.mVibrationConfig.getRequestVibrationParamsTimeoutMs();
    }

    public int[] getRequestVibrationParamsForUsages() {
        return this.mVibrationConfig.getRequestVibrationParamsForUsages();
    }

    public VibrationEffect getFallbackEffect(int effectId) {
        return this.mFallbackEffects.get(effectId);
    }

    public boolean shouldVibrateInputDevices() {
        return this.mVibrateInputDevices;
    }

    public VibrationSession.Status shouldIgnoreVibration(VibrationSession.CallerInfo callerInfo) {
        int usage = callerInfo.attrs.getUsage();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUidObserver.isUidForeground(callerInfo.uid) == true) goto L14;
        if (BACKGROUND_PROCESS_USAGE_ALLOWLIST.contains(Integer.valueOf(usage)) == true) goto L14;
        VibrationSession.Status r2 = VibrationSession.Status.IGNORED_BACKGROUND;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r2;
    L14:
        if (callerInfo.deviceId == 0) goto L21;
        if (callerInfo.deviceId == (-1)) goto L21;
        VibrationSession.Status r3 = VibrationSession.Status.IGNORED_FROM_VIRTUAL_DEVICE;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r3;
    L21:
        if (callerInfo.deviceId != (-1)) goto L28;
        if (isAppRunningOnAnyVirtualDevice(callerInfo.uid) == false) goto L28;
        VibrationSession.Status r4 = VibrationSession.Status.IGNORED_FROM_VIRTUAL_DEVICE;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r4;
    L28:
        if (this.mBatterySaverMode == false) goto L35;
        if (BATTERY_SAVER_USAGE_ALLOWLIST.contains(Integer.valueOf(usage)) == true) goto L35;
        VibrationSession.Status r5 = VibrationSession.Status.IGNORED_FOR_POWER;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r5;
    L35:
        if (callerInfo.attrs.isFlagSet(2) == true) goto L42;
        if (shouldVibrateForUserSetting(callerInfo) == true) goto L42;
        VibrationSession.Status r6 = VibrationSession.Status.IGNORED_FOR_SETTINGS;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r6;
    L42:
        if (callerInfo.attrs.isFlagSet(1) == true) goto L49;
        if (shouldVibrateForRingerModeLocked(usage) == true) goto L49;
        VibrationSession.Status r7 = VibrationSession.Status.IGNORED_FOR_RINGER_MODE;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r7;
    L49:
        if (this.mVibrationConfig.ignoreVibrationsOnWirelessCharger() == false) goto L56;
        if (this.mOnWirelessCharger == false) goto L56;
        VibrationSession.Status r8 = VibrationSession.Status.IGNORED_ON_WIRELESS_CHARGER;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r8;
    L56:
        if (getWindowManagerInternal().getObricWindowManagerInternal().shouldBlockVibrationForAuto(callerInfo.opPkg) == false) goto L60;
        Slog.w(TAG, "shouldIgnoreVibration: ignore vibration for auto virtual display");     // Catch: Throwable -> L11
        VibrationSession.Status r9 = VibrationSession.Status.IGNORED_FOR_SETTINGS;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r9;
    L60:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return null;
    }

    public boolean shouldCancelVibrationOnScreenOff(VibrationSession.CallerInfo callerInfo, long vibrationStartUptimeMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PowerManagerInternal pm = this.mPowerManagerInternal;     // Catch: Throwable -> L28
        String sysUiPackageName = this.mSystemUiPackage;     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        if (pm == null) goto L17;
        PowerManager.SleepData sleepData = pm.getLastGoToSleep();
        if (sleepData == null) goto L17;
        if (sleepData.goToSleepUptimeMillis >= vibrationStartUptimeMillis) goto L13;
    L14:
        Slog.d(TAG, "Ignoring screen off event triggered at uptime " + sleepData.goToSleepUptimeMillis + " for reason " + PowerManager.sleepReasonToString(sleepData.goToSleepReason));
        return false;
    L13:
        if (POWER_MANAGER_SLEEP_REASON_ALLOWLIST.contains(Integer.valueOf(sleepData.goToSleepReason)) == true) goto L14;
    L17:
        if (SYSTEM_VIBRATION_SCREEN_OFF_USAGE_ALLOWLIST.contains(Integer.valueOf(callerInfo.attrs.getUsage())) == true) goto L20;
        return true;
    L20:
        if (callerInfo.uid != 1000) goto L22;
        return false;
    L22:
        if (callerInfo.uid != 0) goto L24;
        return false;
    L24:
        if (Objects.equals(sysUiPackageName, callerInfo.opPkg) == false) goto L27;
        return false;
    L27:
        return true;
    L28:
        th = move-exception;
        throw th;
    }

    private boolean shouldVibrateForRingerModeLocked(int usageHint) {
        if (usageHint == 33) goto L8;
        if (usageHint == 49) goto L8;
        return true;
    L8:
        if (this.mRingerMode != 0) goto L12;
        return false;
    L12:
        return true;
    }

    private boolean shouldVibrateForUserSetting(VibrationSession.CallerInfo callerInfo) {
        int usage = callerInfo.attrs.getUsage();
        if (this.mVibrateOn == true) goto L8;
        if (66 == usage) goto L8;
        return false;
    L8:
        if (getCurrentIntensity(usage) == 0) goto L11;
        return true;
    L11:
        return false;
    }

    void update() {
        updateSettings(-2);
        updateRingerMode();
        notifyListeners();
    }

    private void updateSettings(int userHandle) {
        Object r3 = this.mLock;
        monitor-enter(r3);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (loadSystemSetting("vibrate_input_devices", 0, userHandle) <= 0) goto L7;
        boolean r0 = true;
    L8:
        this.mVibrateInputDevices = r0;     // Catch: Throwable -> L19
        if (loadSystemSetting("vibrate_on", 1, userHandle) <= 0) goto L11;
        boolean r1 = true;
    L12:
        this.mVibrateOn = r1;     // Catch: Throwable -> L19
        if (loadSystemSetting("keyboard_vibration_enabled", 1, userHandle) <= 0) goto L15;
        boolean isKeyboardVibrationOn = true;
    L16:
        int keyboardIntensity = toIntensity(isKeyboardVibrationOn, getDefaultIntensity(82));     // Catch: Throwable -> L19
        int alarmIntensity = toIntensity(loadSystemSetting("alarm_vibration_intensity", -1, userHandle), getDefaultIntensity(17));     // Catch: Throwable -> L19
        int defaultHapticFeedbackIntensity = getDefaultIntensity(18);     // Catch: Throwable -> L19
        int hapticFeedbackIntensity = toIntensity(loadSystemSetting("haptic_feedback_intensity", -1, userHandle), defaultHapticFeedbackIntensity);     // Catch: Throwable -> L19
        int positiveHapticFeedbackIntensity = toPositiveIntensity(hapticFeedbackIntensity, defaultHapticFeedbackIntensity);     // Catch: Throwable -> L19
        int hardwareFeedbackIntensity = toIntensity(loadSystemSetting("hardware_haptic_feedback_intensity", -1, userHandle), positiveHapticFeedbackIntensity);     // Catch: Throwable -> L19
        int mediaIntensity = toIntensity(loadSystemSetting("media_vibration_intensity", -1, userHandle), getDefaultIntensity(19));     // Catch: Throwable -> L19
        int defaultNotificationIntensity = getDefaultIntensity(49);     // Catch: Throwable -> L19
        int notificationIntensity = toIntensity(loadSystemSetting("notification_vibration_intensity", -1, userHandle), defaultNotificationIntensity);     // Catch: Throwable -> L19
        int positiveNotificationIntensity = toPositiveIntensity(notificationIntensity, defaultNotificationIntensity);     // Catch: Throwable -> L19
        int ringIntensity = toIntensity(loadSystemSetting("ring_vibration_intensity", -1, userHandle), getDefaultIntensity(33));     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.clear();     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(17, alarmIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(49, notificationIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(19, mediaIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(0, mediaIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(33, ringIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(65, positiveNotificationIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(50, hardwareFeedbackIntensity);     // Catch: Throwable -> L19
        this.mCurrentVibrationIntensities.put(34, hardwareFeedbackIntensity);     // Catch: Throwable -> L19
        if (loadBooleanSetting("haptic_feedback_enabled", userHandle) == true) goto L21;
        this.mCurrentVibrationIntensities.put(18, 0);     // Catch: Throwable -> L19
    L23:
        if (this.mVibrationConfig.isKeyboardVibrationSettingsSupported() == false) goto L25;
        this.mCurrentVibrationIntensities.put(82, keyboardIntensity);     // Catch: Throwable -> L19
    L26:
        this.mCurrentVibrationIntensities.put(66, positiveHapticFeedbackIntensity);     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "telephony_vibration_enabled", 1) != 1) goto L29;
        boolean r2 = true;
    L30:
        this.mTelephonyVibrationEnabled = r2;     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "global_vibration_enabled", 1) != 1) goto L33;
        boolean r4 = true;
    L34:
        this.mGlobalVibrationEnabled = r4;     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "calendar_vibration_enabled", 1) != 1) goto L37;
        boolean r5 = true;
    L38:
        this.mCalendarVibrationEnabled = r5;     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "sms_1_vibration_enabled", 1) != 1) goto L41;
        boolean r6 = true;
    L42:
        this.mSms1VibrationEnabled = r6;     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "sms_2_vibration_enabled", 1) != 1) goto L45;
        boolean r7 = true;
    L46:
        this.mSms2VibrationEnabled = r7;     // Catch: Throwable -> L19
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "mail_vibration_enabled", 1) != 1) goto L49;
        boolean r11 = true;
    L50:
        this.mMailVibrationEnabled = r11;     // Catch: Throwable -> L19
        boolean r12 = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "notification_vibration_enabled", 1) == 1) goto L54;
        r12 = false;
    L54:
        this.mNotificationVibrationEnabled = r12;     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
        return;
    L49:
        r11 = false;
        goto L50
    L45:
        r7 = false;
        goto L46
    L41:
        r6 = false;
        goto L42
    L37:
        r5 = false;
        goto L38
    L33:
        r4 = false;
        goto L34
    L29:
        r2 = false;
        goto L30
    L25:
        this.mCurrentVibrationIntensities.put(82, hapticFeedbackIntensity);     // Catch: Throwable -> L19
        goto L26
    L21:
        this.mCurrentVibrationIntensities.put(18, hapticFeedbackIntensity);     // Catch: Throwable -> L19
        goto L23
    L15:
        isKeyboardVibrationOn = false;
        goto L16
    L11:
        r1 = false;
        goto L12
    L7:
        r0 = false;
        goto L8
    }

    private void updateRingerMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioManager != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mRingerMode = this.mAudioManager.getRingerModeInternal();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void updateBatteryInfo(Intent intent) {
        boolean r1 = false;
        int pluggedInfo = intent.getIntExtra("plugged", 0);
        Object r2 = this.mLock;
        monitor-enter(r2);
        if (pluggedInfo != 4) goto L13;
        r1 = true;
    L13:
        this.mOnWirelessCharger = r1;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        StringBuilder vibrationIntensitiesString = new StringBuilder("{");     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mCurrentVibrationIntensities.size()) goto L10;
        int usage = this.mCurrentVibrationIntensities.keyAt(i);     // Catch: Throwable -> L8
        int intensity = this.mCurrentVibrationIntensities.valueAt(i);     // Catch: Throwable -> L8
        vibrationIntensitiesString.append(VibrationAttributes.usageToString(usage));     // Catch: Throwable -> L8
        vibrationIntensitiesString.append("=(");     // Catch: Throwable -> L8
        vibrationIntensitiesString.append(intensityToString(intensity));     // Catch: Throwable -> L8
        vibrationIntensitiesString.append(",default:");     // Catch: Throwable -> L8
        vibrationIntensitiesString.append(intensityToString(getDefaultIntensity(usage)));     // Catch: Throwable -> L8
        vibrationIntensitiesString.append("), ");     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        vibrationIntensitiesString.append('}');     // Catch: Throwable -> L8
        String r2 = "VibrationSettings{mVibratorConfig=" + this.mVibrationConfig + ", mVibrateOn=" + this.mVibrateOn + ", mVibrateInputDevices=" + this.mVibrateInputDevices + ", mBatterySaverMode=" + this.mBatterySaverMode + ", mRingerMode=" + ringerModeToString(this.mRingerMode) + ", mOnWirelessCharger=" + this.mOnWirelessCharger + ", mVibrationIntensities=" + vibrationIntensitiesString + ", mProcStatesCache=" + VibrationUidObserver.m9294$$Nest$fgetmProcStatesCache(this.mUidObserver) + '}';     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("VibrationSettings:");     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        pw.println("vibrateOn = " + this.mVibrateOn);     // Catch: Throwable -> L8
        pw.println("vibrateInputDevices = " + this.mVibrateInputDevices);     // Catch: Throwable -> L8
        pw.println("batterySaverMode = " + this.mBatterySaverMode);     // Catch: Throwable -> L8
        pw.println("ringerMode = " + ringerModeToString(this.mRingerMode));     // Catch: Throwable -> L8
        pw.println("onWirelessCharger = " + this.mOnWirelessCharger);     // Catch: Throwable -> L8
        pw.println("processStateCache size = " + VibrationUidObserver.m9294$$Nest$fgetmProcStatesCache(this.mUidObserver).size());     // Catch: Throwable -> L8
        pw.println("VibrationIntensities:");     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mCurrentVibrationIntensities.size()) goto L10;
        int usage = this.mCurrentVibrationIntensities.keyAt(i);     // Catch: Throwable -> L8
        int intensity = this.mCurrentVibrationIntensities.valueAt(i);     // Catch: Throwable -> L8
        pw.println(VibrationAttributes.usageToString(usage) + " = " + intensityToString(intensity) + ", default: " + intensityToString(getDefaultIntensity(usage)));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.decreaseIndent();     // Catch: Throwable -> L8
        this.mVibrationConfig.dumpWithoutDefaultSettings(pw);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(ProtoOutputStream proto) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        proto.write(1133871366168L, this.mVibrateOn);     // Catch: Throwable -> L7
        proto.write(1133871366150L, this.mBatterySaverMode);     // Catch: Throwable -> L7
        proto.write(1120986464274L, getCurrentIntensity(17));     // Catch: Throwable -> L7
        proto.write(1120986464275L, getDefaultIntensity(17));     // Catch: Throwable -> L7
        proto.write(1120986464278L, getCurrentIntensity(50));     // Catch: Throwable -> L7
        proto.write(1120986464279L, getDefaultIntensity(50));     // Catch: Throwable -> L7
        proto.write(1120986464263L, getCurrentIntensity(18));     // Catch: Throwable -> L7
        proto.write(1120986464264L, getDefaultIntensity(18));     // Catch: Throwable -> L7
        proto.write(1120986464276L, getCurrentIntensity(19));     // Catch: Throwable -> L7
        proto.write(1120986464277L, getDefaultIntensity(19));     // Catch: Throwable -> L7
        proto.write(1120986464265L, getCurrentIntensity(49));     // Catch: Throwable -> L7
        proto.write(1120986464266L, getDefaultIntensity(49));     // Catch: Throwable -> L7
        proto.write(1120986464267L, getCurrentIntensity(33));     // Catch: Throwable -> L7
        proto.write(1120986464268L, getDefaultIntensity(33));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<OnVibratorSettingsChanged> currentListeners = new ArrayList(this.mListeners);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator<OnVibratorSettingsChanged> r1 = currentListeners.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        OnVibratorSettingsChanged listener = r1.next();
        listener.onChange();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static String intensityToString(int intensity) {
        switch(intensity) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L4;
            default: goto L9;
        };
    L4:
        return PriorityDump.PRIORITY_ARG_HIGH;
    L5:
        return "MEDIUM";
    L6:
        return "LOW";
    L7:
        return "OFF";
    L9:
        return "UNKNOWN INTENSITY " + intensity;
    }

    private static String ringerModeToString(int ringerMode) {
        switch(ringerMode) {
            case 0: goto L6;
            case 1: goto L5;
            case 2: goto L4;
            default: goto L8;
        };
    L4:
        return "normal";
    L5:
        return "vibrate";
    L6:
        return "silent";
    L8:
        return String.valueOf(ringerMode);
    }

    private int toPositiveIntensity(int value, int defaultValue) {
        if (value != 0) goto L5;
        return defaultValue;
    L5:
        return toIntensity(value, defaultValue);
    }

    private int toIntensity(int value, int defaultValue) {
        if (value >= 0) goto L4;
    L7:
        return defaultValue;
    L4:
        if (value > 3) goto L7;
        return value;
    }

    private int toIntensity(boolean enabled, int defaultValue) {
        if (enabled == true) goto L6;
        return 0;
    L6:
        return defaultValue;
    }

    private boolean loadBooleanSetting(String settingKey, int userHandle) {
        if (loadSystemSetting(settingKey, 0, userHandle) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private int loadSystemSetting(String settingName, int defaultValue, int userHandle) {
        return Settings.System.getIntForUser(this.mContext.getContentResolver(), settingName, defaultValue, userHandle);
    }

    private void registerSettingsObserver(Uri settingUri) {
        this.mContext.getContentResolver().registerContentObserver(settingUri, true, this.mSettingObserver, -1);
    }

    private VibrationEffect createEffectFromResource(int resId) {
        return createEffectFromResource(this.mContext.getResources(), resId);
    }

    static VibrationEffect createEffectFromResource(Resources res, int resId) {
        long[] timings = getLongIntArray(res, resId);
        return createEffectFromTimings(timings);
    }

    private static VibrationEffect createEffectFromTimings(long[] timings) {
        if (timings != null) goto L4;
        return null;
    L4:
        if (timings.length != 0) goto L7;
        return null;
    L7:
        if (timings.length != 1) goto L11;
        return VibrationEffect.createOneShot(timings[0], -1);
    L11:
        return VibrationEffect.createWaveform(timings, -1);
    }

    private static long[] getLongIntArray(Resources r, int resid) {
        int[] ar = r.getIntArray(resid);
        if (ar != null) goto L6;
        return null;
    L6:
        long[] out = new long[ar.length];
        int i = 0;
    L8:
        if (i >= ar.length) goto L11;
        out[i] = ar[i];
        i = i + 1;
        goto L8
    L11:
        return out;
    }

    private boolean isAppRunningOnAnyVirtualDevice(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VirtualDeviceManagerInternal vdm = this.mVirtualDeviceManagerInternal;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (vdm != null) goto L8;
    L10:
        return false;
    L8:
        if (vdm.isAppRunningOnAnyVirtualDevice(uid) == false) goto L10;
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    boolean getTelephonyVibrationEnabled() {
        return this.mTelephonyVibrationEnabled;
    }

    boolean getGlobalVibrationEnabled() {
        return this.mGlobalVibrationEnabled;
    }

    private boolean isPhoneSettingsActivity() {
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        if (am != null) goto L20;
        return false;
    L20:
        ComponentName topActivity = ActivityManager.getSmtEx().getTopActivity();     // Catch: Exception -> L13
        if (topActivity == null) goto L16;
        String classname = topActivity.getClassName();     // Catch: Exception -> L13
        if (classname == null) goto L19;
        if (classname.equals(PHONE_SETTINGS_ACTIVIT_CLASS_NAME) == false) goto L19;
        return true;
    L19:
        return false;
    L16:
        Slog.e(TAG, "ComponentName is null");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    protected VibrationSession.Status shouldIgnoreVibrationSmt(VibrationSession.Status statusFromSettings, int uid, VibrationAttributes attrs, String pkg, String reason) {
        if (statusFromSettings == null) goto L4;
        return statusFromSettings;
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mGlobalVibrationEnabled == true) goto L19;
        if (attrs.getUsage() != 49) goto L11;
    L15:
        VibrationSession.Status r1 = logAndReturnStatus("mGlobalVibrationEnabled", this.mGlobalVibrationEnabled);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L11:
        if (attrs.getUsage() == 33) goto L15;
    L19:
        if (attrs.getUsage() != 49) goto L31;
        Slog.d(TAG, "shouldIgnoreVibrationSmt reason = " + reason);     // Catch: Throwable -> L13
        if (isAppInWhitelist(reason) == false) goto L26;
        VibrationSession.Status r2 = checkAppVibrationSettings(reason, attrs);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L26:
        if (this.mNotificationVibrationEnabled == true) goto L31;
        VibrationSession.Status r3 = logAndReturnStatus("mNotificationVibrationEnabled", this.mNotificationVibrationEnabled);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L31:
        if (this.mDisturbModeUtils != null) goto L33;
    L42:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L33:
        if (this.mDisturbModeUtils.isInDisturbModeWithPolicy(pkg) == false) goto L42;
        if (attrs.getUsage() == 18) goto L42;
        if (reason != null) goto L38;
    L39:
        VibrationSession.Status r4 = logAndReturnStatus("mGlobalVibrationEnabled", this.mGlobalVibrationEnabled);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L38:
        if (reason.contains("DynamicEffect") == true) goto L42;
        goto L39
    }

    private boolean isAppInWhitelist(String reason) {
        if (reason == null) goto L6;
        Stream<String> r0 = WHITELISTED_APPS.stream();
        reason.getClass();
        if (r0.anyMatch(new ZDtsSceneManager$$ExternalSyntheticLambda7(reason)) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private VibrationSession.Status checkAppVibrationSettings(String reason, VibrationAttributes attrs) {
        if (reason.contains(CALENDAR_PACKAGE) == false) goto L9;
        if (this.mCalendarVibrationEnabled == true) goto L9;
        return logAndReturnStatus("mCalendarVibrationEnabled", this.mCalendarVibrationEnabled);
    L9:
        if (reason.contains(MAIL_PACKAGE) == false) goto L15;
        if (this.mMailVibrationEnabled == true) goto L15;
        return logAndReturnStatus("mMailVibrationEnabled", this.mMailVibrationEnabled);
    L15:
        if (reason.contains(MMS_PACKAGE) == false) goto L28;
        int mmsSlot = attrs.getPrivateFlags();
        if ((mmsSlot & 1024) == 0) goto L23;
        if (this.mSms1VibrationEnabled == true) goto L23;
        return logAndReturnStatus("mSms1VibrationEnabled", this.mSms1VibrationEnabled);
    L23:
        if ((mmsSlot & 2048) == 0) goto L28;
        if (this.mSms2VibrationEnabled == true) goto L28;
        return logAndReturnStatus("mSms2VibrationEnabled", this.mSms2VibrationEnabled);
    L28:
        Slog.i(TAG, "checkAppVibrationSettings pass");
        return null;
    }

    protected void setVibratorServiceSmtEx(VibratorServiceSmtEx serviceSmtEx) {
        this.mServiceSmtEx = serviceSmtEx;
    }

    public int getHapticFeedbackIntensity() {
        return getCurrentIntensity(18);
    }

    private VibrationSession.Status logAndReturnStatus(String settingName, boolean settingValue) {
        Slog.d(TAG, "shouldIgnoreVibrationSmt IGNORED_FOR_SETTINGS, " + settingName + " = " + settingValue);
        return VibrationSession.Status.IGNORED_FOR_SETTINGS;
    }

    private WindowManagerInternal getWindowManagerInternal() {
        if (this.mWindowManagerInternal != null) goto L6;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    L6:
        return this.mWindowManagerInternal;
    }
}
