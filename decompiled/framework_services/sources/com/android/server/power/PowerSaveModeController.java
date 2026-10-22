package com.android.server.power;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.LostModeUtil;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.notification.NotificationManagerServiceSmtEx;
import com.android.server.pm.PackageManagerService;
import com.android.server.scene.SceneUtils;
import com.android.server.wm.BarControllerSmtEx;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PowerSaveModeController extends BroadcastReceiver {
    private static final String[] sBlacklistForSystemApp = null;
    private static String[] sWhitelistForBroadcastQueue;
    private final String CONF_FILE_PATH;
    private final boolean DEBUG_PROCESS;
    private final boolean DEBUG_VALUE;
    private final int DEFAULT_MAX_SCREEN_BRIGHTNESS;
    private final int DEFAULT_POWERSAVE_SCREENOFF_DELAY_INIT;
    private final int DEFAULT_SAVEPOWER_SCREENOFF_DELAY;
    private final int DEFAULT_SCREENOFF_DELAY;
    private final int DEFAULT_SCREEN_BRIGHTNESS_MODE;
    private final String DISALBE_POWER_SAVE_MODE;
    private final String LAST_ADB_STATE;
    private final String LAST_BT_STATE;
    private final String LAST_DATA_STATE;
    private final String LAST_FEEDBACK_STATE;
    private final String LAST_LAUNCHER_NAME;
    private final String LAST_LAUNCHER_PKG;
    private final String LAST_LOCATION_STATE;
    private final String LAST_MTP_STATE;
    private final String LAST_NFC_STATE;
    private final String LAST_SCREEN_BRIGHTNESS;
    private final String LAST_SCREEN_BRIGHTNESS_MODEL;
    private final String LAST_SCREEN_OFF_DELAY;
    private final String LAST_VIRTUAL_KEYBOARD_SOUND;
    private final String LAST_WIFI_AP_STATE;
    private final String LAST_WIFI_STATE;
    private final String LOG_TAG;
    final String LOST_MODE;
    final int LOST_MODE_ENABLED;
    private final String OBRIC_LAUNCHER_PKG_CLASS_NAME;
    private final String OBRIC_LAUNCHER_PKG_NAME;
    private final String PKG_ASSISTANT;
    private final String POWER_SAVE_OBRIC_LAUNCHER_PKG_NAME;
    private final String SETTING_KEY_VIRTUAL_KEYBOARD_SOUND;
    private final String STATE_PREFIX;
    private boolean last_adbEnabeld;
    private boolean last_btOpenedState;
    private boolean last_dataEnabled;
    private boolean last_feedbackEnabled;
    private ComponentName last_launcher;
    private boolean last_locationState;
    private boolean last_mtpState;
    private boolean last_nfcEnabled;
    private int last_screenBrightness;
    private int last_screenBrightnessMode;
    private int last_screenOffDelay;
    private boolean last_virtualKeyboardSound;
    private boolean last_wifiApOpenedState;
    private boolean last_wifiOpenedState;
    private ActivityManager mAm;
    private final ComponentName mBytedanceHome;
    private CameraManager mCameraManager;
    Runnable mCloseUselessApkRunnable;
    private Context mContext;
    private boolean mDisablePowerSave;
    private Handler mHandler;
    private final boolean mIsUserDebug;
    private LocationManager mLocationManager;
    private PackageManager mPm;
    private final ComponentName mPowerSaveHome;
    private HashSet<String> mPowerSaveIgnorePackage;
    private File mSavePowerConfFile;
    private JSONObject mSavePowerConfList;
    private final String[] sWhiteList;

    /* JADX INFO: renamed from: $r8$lambda$h-fhgkHnhDsk1P-qYLrhdGzicyU, reason: not valid java name */
    public static /* synthetic */ void m7550$r8$lambda$hfhgkHnhDsk1PqYLrhdGzicyU(PowerSaveModeController r0, ComponentName r1) {
        r0.lambda$setDefaultHome$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcloseUselessApk, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7551$$Nest$mcloseUselessApk(PowerSaveModeController r0) {
        r0.closeUselessApk();
    }

    static {
        sBlacklistForSystemApp = new String[]{"com.obric.music", "com.obric.notes", "com.bytedanceos.voice", "com.bytedanceos.updater", "com.android.htmlviewer", "com.iflytek.speechsuite", "com.bytedanceos.theme", "com.obric.nodisturb", "com.android.providers.downloads", "com.bytedance.bbs", "com.obric.sconf", "com.android.browser", "com.bytedance.reader", "com.android.defcontainer", "com.bytedanceos.drivingmode", "com.bytedanceos.gamestore", "com.bytedanceos.calculator", "com.bytedance.factorytest", "com.android.backupconfirm", "com.android.launcher3", "com.android.statementservice", "com.obric.cleaner", "com.youdao.dict.bytedance", "com.android.phasebeam", "com.obric.filemanager", "com.bytedanceos.autoregistration", "com.obric.quicksearch", UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE, "com.bytedanceos.launcher.theme", "com.android.printspooler", "com.android.dreams.basic", "com.bytedanceos.weather", "com.android.musicfx", "com.android.calllogbackup", BarControllerSmtEx.GALLERY_PACKAGE_NAME, "com.bytedanceos.sidebar", "com.android.settings", "com.bytedanceos.cloudgallery", "com.android.email", "com.android.vpndialogs", "com.android.exchange", "com.bytedanceos.tracker", "com.android.gallery", "com.obric.appstore", "com.bytedanceos.updater", "com.bytedanceos.textboom", "com.bytedanceos.support"};
        sWhitelistForBroadcastQueue = new String[]{"com.android.settings"};
    }

    public PowerSaveModeController(Context context, Handler handler) {
        this.LOG_TAG = "SuperPowerSettingsEnabler";
        this.DEBUG_PROCESS = false;
        this.DEBUG_VALUE = false;
        this.mIsUserDebug = "userdebug".equals(SystemProperties.get("ro.build.type"));
        this.DEFAULT_SAVEPOWER_SCREENOFF_DELAY = ProcessList.PSS_MIN_TIME_FROM_STATE_CHANGE;
        this.DEFAULT_SCREENOFF_DELAY = 30000;
        this.DEFAULT_POWERSAVE_SCREENOFF_DELAY_INIT = 120000;
        this.DEFAULT_SCREEN_BRIGHTNESS_MODE = 0;
        this.DEFAULT_MAX_SCREEN_BRIGHTNESS = 255;
        this.LAST_SCREEN_OFF_DELAY = "last_screen_off_delay";
        this.LAST_SCREEN_BRIGHTNESS_MODEL = "last_screen_brightness_mode";
        this.LAST_SCREEN_BRIGHTNESS = "last_screen_brightness";
        this.LAST_WIFI_STATE = "last_wifi_state";
        this.LAST_BT_STATE = "last_bt_state";
        this.LAST_WIFI_AP_STATE = "last_wifi_ap_state";
        this.LAST_LOCATION_STATE = "last_location_state";
        this.LAST_NFC_STATE = "last_nfc_state";
        this.LAST_DATA_STATE = "last_data_state";
        this.LAST_ADB_STATE = "last_adb_state";
        this.LAST_LAUNCHER_PKG = "last_launcher_pkg";
        this.LAST_LAUNCHER_NAME = "last_launcher_name";
        this.LAST_FEEDBACK_STATE = "last_feedback_state";
        this.LAST_MTP_STATE = "last_mtp_state";
        this.LAST_VIRTUAL_KEYBOARD_SOUND = "last_virtual_keyboard_sound";
        this.OBRIC_LAUNCHER_PKG_NAME = "com.android.launcher3";
        this.OBRIC_LAUNCHER_PKG_CLASS_NAME = "com.android.launcher3.uioverrides.QuickstepLauncher";
        this.POWER_SAVE_OBRIC_LAUNCHER_PKG_NAME = "com.obric.powersaving.launcher";
        this.SETTING_KEY_VIRTUAL_KEYBOARD_SOUND = "virtual_keyboard_sound";
        this.CONF_FILE_PATH = "/data/system/save_power_model_conf.json";
        this.mSavePowerConfList = null;
        this.mSavePowerConfFile = new File("/data/system/save_power_model_conf.json");
        this.DISALBE_POWER_SAVE_MODE = "android.os.action.DISABLE_POWER_SAVE_MODE";
        this.mDisablePowerSave = false;
        this.LOST_MODE = "lost_mode";
        this.LOST_MODE_ENABLED = 1;
        this.PKG_ASSISTANT = NotificationManagerServiceSmtEx.ASSISTANT_PKG;
        this.STATE_PREFIX = "state_prefix";
        this.sWhiteList = new String[]{PackageManagerService.PLATFORM_PACKAGE_NAME, "com.obric.powersaving.launcher", "com.android.mms", "com.android.phone", "com.android.contacts", "com.obric.clock", BarControllerSmtEx.CAMEARA_PACKAGE_NAME, "com.android.calendar", "com.android.providers.calendar", "com.bytedanceos.torch", "com.obric.recorder", "com.android.incallui", "com.android.providers.applications", UserBackupManagerService.TELEPHONY_PROVIDER_PACKAGE, "com.android.providers.contacts", "com.android.providers.userdictionary", "com.amap.android.location", "com.android.server.telecom", "com.obric.numberassistant", "com.obric.smsparser", "com.bytedanceos.fakecall", SceneUtils.PKG_SYS_UI, "com.bytedanceos.cloudsync", "com.redteamobile.roaming", "com.redteamobile.virtual.softsim", "com.redteamobile.roaming:pushservice", "com.qualcomm.qcrilmsgtunnel"};
        this.mPowerSaveIgnorePackage = new HashSet(Arrays.asList(this.sWhiteList));
        this.mPowerSaveHome = new ComponentName("com.obric.powersaving.launcher", "com.obric.powersaving.launcher.Launcher");
        this.mBytedanceHome = new ComponentName("com.android.launcher3", "com.android.launcher3.uioverrides.QuickstepLauncher");
        this.mCloseUselessApkRunnable = new AnonymousClass1(this);
        this.mContext = context;
        this.mHandler = handler;
    }

    public void init() {
        this.mPm = this.mContext.getPackageManager();
        this.mAm = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mCameraManager = (CameraManager) this.mContext.getSystemService("camera");
        this.mLocationManager = (LocationManager) this.mContext.getSystemService(LocationLogsRecorder.KEY_FILE_LOCATION);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.os.action.DISABLE_POWER_SAVE_MODE");
        filter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this, filter, 2);
        boolean lastFeaturePhoneMode = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "feature_phone_mode", 0) == 0) goto L5;
        lastFeaturePhoneMode = true;
    L5:
        Log.d("SuperPowerSettingsEnabler", "init lastFeaturePhoneMode:" + lastFeaturePhoneMode);
        if (lastFeaturePhoneMode == false) goto L8;
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_off_timeout", 120000);
    L8:
        readPowerSaveData();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean lastFeaturePhoneMode = false;
        if (intent.getAction().equals("android.os.action.DISABLE_POWER_SAVE_MODE") == false) goto L9;
        setDisablePowerSave(intent.getBooleanExtra("disable_powersave", false));     // Catch: Exception -> L6
        return;
    L22:
        return;
    L9:
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF") == true) goto L11;
        return;
    L11:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "feature_phone_mode", 0) == 0) goto L13;
        lastFeaturePhoneMode = true;
    L13:
        Log.d("SuperPowerSettingsEnabler", "onReceive screen off:" + lastFeaturePhoneMode);
        if (lastFeaturePhoneMode == false) goto L20;
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_off_timeout", ProcessList.PSS_MIN_TIME_FROM_STATE_CHANGE);
        return;
    }

    public boolean isDisablePowerSave() {
        return this.mDisablePowerSave;
    }

    public void setDisablePowerSave(boolean disable) {
        this.mDisablePowerSave = disable;
    }

    public boolean changeToPowerSaveModel() {
        if (this.mIsUserDebug == false) goto L6;
        Log.d("SuperPowerSettingsEnabler", "changeToPowerSaveModel- enter");
    L6:
        if (this.mSavePowerConfList != null) goto L8;
        this.mSavePowerConfList = new JSONObject();
    L8:
        setSlideScreenOffDelay();
        setScreenLight();
        closeAllConnection();
        disableFeedBack();
        disableAssistant();
        if (this.mIsUserDebug == true) goto L11;
        disableAdb();
        diableMtp();
    L11:
        disableVirtualKeyboardSound();
        if (this.mSavePowerConfFile.exists() == true) goto L14;
        writeJsonDataToFile(this.mSavePowerConfList.toString());
    L14:
        this.mCloseUselessApkRunnable.run();
        removeRecentTasks();
        return true;
    }

    public boolean changeBackFromPowerSaveModel() {
        if (readPowerSaveData() == true) goto L6;
        return false;
    L6:
        resetSlideScreenOffDelay();
        resetScreenLight();
        resetAllConnection();
        resetFeedBack();
        resetVirtualKeyboardSound();
        resetAssistant();
        if (this.mIsUserDebug == true) goto L10;
        resetMtpState();
        resetAdbState();
    L10:
        if (this.mSavePowerConfFile.delete() == true) goto L14;
        Log.d("SuperPowerSettingsEnabler", "Failed to clear flag file");
        return true;
    L14:
        return true;
    }

    private void disableAssistant() {
        int assistantState = this.mPm.getApplicationEnabledSetting(NotificationManagerServiceSmtEx.ASSISTANT_PKG);     // Catch: RuntimeException -> L5
        saveConfig("state_prefixcom.obric.assistant", Integer.valueOf(assistantState));     // Catch: RuntimeException -> L5
        this.mPm.setApplicationEnabledSetting(NotificationManagerServiceSmtEx.ASSISTANT_PKG, 2, 0);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e("SuperPowerSettingsEnabler", " disableAssistant RuntimeException " + e);
    }

    private void resetAssistant() {
        int lastAssistantState = 0;
        if (this.mSavePowerConfList == null) goto L10;
        lastAssistantState = this.mSavePowerConfList.optInt("state_prefixcom.obric.assistant", 0);
    L10:
        this.mPm.setApplicationEnabledSetting(NotificationManagerServiceSmtEx.ASSISTANT_PKG, lastAssistantState, 0);     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e("SuperPowerSettingsEnabler", "resetAssistant RuntimeException " + e);
    }

    private void setSlideScreenOffDelay() {
        int currentTimeout = Settings.System.getInt(this.mContext.getContentResolver(), "screen_off_timeout", 0);
        saveConfig("last_screen_off_delay", Integer.valueOf(currentTimeout));
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_off_timeout", ProcessList.PSS_MIN_TIME_FROM_STATE_CHANGE);
    }

    private void resetSlideScreenOffDelay() {
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_off_timeout", this.last_screenOffDelay);
    }

    private int getMinScreenLight() {
        PowerManager pm = (PowerManager) this.mContext.getSystemService("power");
        return pm.getMinimumScreenBrightnessSetting();
    }

    private int getMaxScreenLightPowerSave() {
        PowerManager pm = (PowerManager) this.mContext.getSystemService("power");
        return pm.getSmtEx().getMaxScreenBrightnessPowerSave();
    }

    private void setScreenLight() {
        int screenMode = Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness_mode", 0);
        int screenBrightness = Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness", 255);
        saveConfig("last_screen_brightness_mode", Integer.valueOf(screenMode));
        saveConfig("last_screen_brightness", Integer.valueOf(screenBrightness));
        int brightness = ((getMaxScreenLightPowerSave() - getMinScreenLight()) * screenBrightness) / (255 - getMinScreenLight());
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_brightness_mode", 0);
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_brightness", brightness);
    }

    private void resetScreenLight() {
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_brightness_mode", this.last_screenBrightnessMode);
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_brightness", this.last_screenBrightness);
    }

    private void closeAllConnection() {
        if (this.mIsUserDebug == false) goto L5;
        Log.d("SuperPowerSettingsEnabler", "closeAllConnection");
    L5:
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        boolean iswifiopened = wifiManager.isWifiEnabled();
        boolean iswifiApOpened = wifiManager.isWifiApEnabled();
        saveConfig("last_wifi_state", Boolean.valueOf(iswifiopened));
        saveConfig("last_wifi_ap_state", Boolean.valueOf(iswifiApOpened));
        boolean lostModeEnabled = beingLostModeEnabled();
        if (this.mIsUserDebug == false) goto L9;
        Log.d("SuperPowerSettingsEnabler", "closeAllConnection - wlan before adjust is " + iswifiopened + " iswifiApOpened:" + iswifiApOpened + " lostModeEnabled:" + lostModeEnabled);
    L9:
        if (lostModeEnabled == true) goto L14;
        if (iswifiopened == false) goto L12;
        wifiManager.setWifiEnabled(false);
    L12:
        if (iswifiApOpened == false) goto L14;
        wifiManager.stopSoftAp();
    L14:
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) goto L22;
        boolean isbtopened = bluetoothAdapter.isEnabled();
        saveConfig("last_bt_state", Boolean.valueOf(isbtopened));
        if (this.mIsUserDebug == false) goto L19;
        Log.d("SuperPowerSettingsEnabler", "closeAllConnection - BT   before adjust is " + isbtopened);
    L19:
        if (isbtopened == false) goto L25;
        bluetoothAdapter.disable();
    L25:
        boolean locationEnabled = this.mLocationManager.isLocationEnabled();
        saveConfig("last_location_state", Boolean.valueOf(locationEnabled));
        if (this.mIsUserDebug == false) goto L28;
        Log.d("SuperPowerSettingsEnabler", "closeAllConnection- GPS  before adjust is " + locationEnabled);
    L28:
        if (locationEnabled == false) goto L31;
        if (lostModeEnabled == true) goto L31;
        this.mLocationManager.setLocationEnabledForUser(false, Process.myUserHandle());
    L31:
        TelephonyManager telephonyManager = TelephonyManager.from(this.mContext);
        boolean dataEnabled = telephonyManager.isDataEnabled();
        saveConfig("last_data_state", Boolean.valueOf(dataEnabled));
        if (dataEnabled == false) goto L35;
        telephonyManager.setDataEnabledForReason(0, false);
        return;
    L35:
        return;
    L22:
        saveConfig("last_bt_state", false);
        if (this.mIsUserDebug == false) goto L25;
        Log.d("SuperPowerSettingsEnabler", "closeAllConnection - BT   before adjust is closed , so do not need this.");
        goto L25
    }

    private void resetAllConnection() {
        WifiManager wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        boolean iswifiopened = wifiManager.isWifiEnabled();
        boolean iswifiApOpened = wifiManager.isWifiApEnabled();
        if (iswifiopened == this.last_wifiOpenedState) goto L6;
        wifiManager.setWifiEnabled(this.last_wifiOpenedState);
    L6:
        if (iswifiApOpened != this.last_wifiApOpenedState) goto L8;
    L18:
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) goto L26;
        boolean isbtopened = bluetoothAdapter.isEnabled();
        if (isbtopened == this.last_btOpenedState) goto L26;
        if (this.last_btOpenedState == false) goto L25;
        bluetoothAdapter.enable();
        goto L26
    L25:
        bluetoothAdapter.disable();
    L26:
        boolean locationEnabled = false;
        locationEnabled = this.mLocationManager.isLocationEnabled();     // Catch: IllegalArgumentException -> L29
    L32:
        if (locationEnabled == this.last_locationState) goto L34;
        this.mLocationManager.setLocationEnabledForUser(this.last_locationState, Process.myUserHandle());
    L34:
        TelephonyManager telephonyManager = TelephonyManager.from(this.mContext);
        boolean dataEnabled = telephonyManager.isDataEnabled();
        if (dataEnabled == this.last_dataEnabled) goto L42;
        telephonyManager.setDataEnabledForReason(0, this.last_dataEnabled);
        return;
    L42:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L8:
        if (this.last_wifiApOpenedState == true) goto L40;
        wifiManager.stopSoftAp();
        goto L18
    L40:
        WifiManager mWifiManager = (WifiManager) WifiManager.class.newInstance();     // Catch: Exception -> L13
        Method method = WifiManager.class.getDeclaredMethod("startSoftAp", new Class[]{WifiConfiguration.class});     // Catch: Exception -> L13
        if (method == null) goto L18;
        method.invoke(mWifiManager, new Object[0]);     // Catch: Exception -> L13
    L16:
        Log.d("SuperPowerSettingsEnabler", "startSoftAp failed.");
        goto L18
    }

    private void diableMtp() {
        UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
        boolean mtpState = usbManager.isFunctionEnabled("mtp");
        saveConfig("last_mtp_state", Boolean.valueOf(mtpState));
        usbManager.setCurrentFunction("none", false);
    }

    private void resetMtpState() {
        UsbManager usbManager = (UsbManager) this.mContext.getSystemService("usb");
        if (this.last_mtpState == false) goto L6;
        usbManager.setCurrentFunction("mtp", false);
        return;
    }

    private void disableAdb() {
        int adbState = Settings.Global.getInt(this.mContext.getContentResolver(), "adb_enabled", 0);
        boolean r3 = true;
        if (adbState == 1) goto L6;
        r3 = false;
    L6:
        saveConfig("last_adb_state", Boolean.valueOf(r3));
        Settings.Global.putInt(this.mContext.getContentResolver(), "adb_enabled", 0);
    }

    private void resetAdbState() {
        if (this.last_adbEnabeld == false) goto L5;
        Settings.Global.putInt(this.mContext.getContentResolver(), "adb_enabled", 1);
        return;
    L5:
        Settings.Global.putInt(this.mContext.getContentResolver(), "adb_enabled", 0);
    }

    private void disableVirtualKeyboardSound() {
        boolean r2 = true;
        int state = Settings.Global.getInt(this.mContext.getContentResolver(), "virtual_keyboard_sound", 1);
        if (state == 1) goto L6;
        r2 = false;
    L6:
        saveConfig("last_virtual_keyboard_sound", Boolean.valueOf(r2));
        Settings.Global.putInt(this.mContext.getContentResolver(), "virtual_keyboard_sound", 0);
    }

    private void resetVirtualKeyboardSound() {
        if (this.last_virtualKeyboardSound == false) goto L5;
        Settings.Global.putInt(this.mContext.getContentResolver(), "virtual_keyboard_sound", 1);
        return;
    L5:
        Settings.Global.putInt(this.mContext.getContentResolver(), "virtual_keyboard_sound", 0);
    }

    private void disableFeedBack() {
        boolean r2 = true;
        int feedbackState = Settings.System.getInt(this.mContext.getContentResolver(), "haptic_feedback_enabled", 1);
        if (feedbackState == 1) goto L6;
        r2 = false;
    L6:
        saveConfig("last_feedback_state", Boolean.valueOf(r2));
        Settings.System.putInt(this.mContext.getContentResolver(), "haptic_feedback_enabled", 0);
    }

    private void resetFeedBack() {
        if (this.last_feedbackEnabled == false) goto L5;
        Settings.System.putInt(this.mContext.getContentResolver(), "haptic_feedback_enabled", 1);
        return;
    L5:
        Settings.System.putInt(this.mContext.getContentResolver(), "haptic_feedback_enabled", 0);
    }

    private boolean readPowerSaveData() {
        this.mSavePowerConfList = getJSONObjectFromFile(this.mSavePowerConfFile);
        if (this.mSavePowerConfList != null) goto L5;
        this.mSavePowerConfList = new JSONObject();
        Log.d("SuperPowerSettingsEnabler", " Did not find the conf file, so restore default values");
    L5:
        int brightness = (255 - getMinScreenLight()) / 2;
        this.last_screenOffDelay = this.mSavePowerConfList.optInt("last_screen_off_delay", 30000);
        this.last_screenBrightnessMode = this.mSavePowerConfList.optInt("last_screen_brightness_mode", 0);
        this.last_screenBrightness = this.mSavePowerConfList.optInt("last_screen_brightness", brightness);
        this.last_wifiOpenedState = this.mSavePowerConfList.optBoolean("last_wifi_state", true);
        this.last_wifiApOpenedState = this.mSavePowerConfList.optBoolean("last_wifi_ap_state", false);
        this.last_btOpenedState = this.mSavePowerConfList.optBoolean("last_bt_state", false);
        this.last_locationState = this.mSavePowerConfList.optBoolean("last_location_state", true);
        this.last_nfcEnabled = this.mSavePowerConfList.optBoolean("last_nfc_state", false);
        this.last_dataEnabled = this.mSavePowerConfList.optBoolean("last_data_state", false);
        this.last_feedbackEnabled = this.mSavePowerConfList.optBoolean("last_feedback_state", false);
        this.last_adbEnabeld = this.mSavePowerConfList.optBoolean("last_adb_state", false);
        this.last_virtualKeyboardSound = this.mSavePowerConfList.optBoolean("last_virtual_keyboard_sound", false);
        this.last_mtpState = this.mSavePowerConfList.optBoolean("last_mtp_state", true);
        String pkg = this.mSavePowerConfList.optString("last_launcher_pkg", "com.android.launcher3");
        String name = this.mSavePowerConfList.optString("last_launcher_name", "com.android.launcher3.uioverrides.QuickstepLauncher");
        this.last_launcher = new ComponentName(pkg, name);
        return true;
    }

    private JSONObject getJSONObjectFromFile(File file) {
        String in = getStringFromFile(file);
        if (in == null) goto L11;
        JSONObject jo = new JSONObject(in);     // Catch: JSONException -> L6
        return jo;
    L7:
        return null;
    L11:
        return null;
    }

    private String getStringFromFile(File file) {
        if (file.exists() == true) goto L5;
        return null;
    L5:
        byte[] buffer = new byte[4096];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     // Catch: Exception -> L17
        FileInputStream fis = new FileInputStream(file);     // Catch: Throwable -> L19
    L35:
        int len = fis.read(buffer);     // Catch: Throwable -> L11
        if (len == (-1)) goto L13;
        baos.write(buffer, 0, len);     // Catch: Throwable -> L11
        goto L35
    L13:
        baos.close();     // Catch: Throwable -> L11
        fis.close();     // Catch: Throwable -> L11
        String result = baos.toString(StandardCharsets.UTF_8);     // Catch: Throwable -> L11
        fis.close();     // Catch: Throwable -> L19
        baos.close();     // Catch: Exception -> L17
        return result;
    L11:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L19
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        baos.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Exception -> L17
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        Slog.w("SuperPowerSettingsEnabler", "getStringFromFile: exception=" + e.getMessage());
        return null;
    }

    private void writeJsonDataToFile(String jsonData) {
        BufferedReader reader = new BufferedReader(new StringReader(jsonData));     // Catch: IOException -> L6
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.mSavePowerConfFile));     // Catch: IOException -> L6
        char[] buffer = new char[1024];     // Catch: IOException -> L6
    L3:
        int len = reader.read(buffer);     // Catch: IOException -> L6
        if (len == (-1)) goto L8;
        writer.write(buffer, 0, len);     // Catch: IOException -> L6
        goto L3
    L8:
        writer.flush();     // Catch: IOException -> L6
        writer.close();     // Catch: IOException -> L6
        reader.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isInBlackList(String name, boolean useWhitelistForBroadcastQueue) {
        if (useWhitelistForBroadcastQueue == false) goto L11;
        int i = 0;
    L6:
        if (i >= sWhitelistForBroadcastQueue.length) goto L11;
        String pn = sWhitelistForBroadcastQueue[i];
        if (pn.equals(name) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return false;
    L11:
        int i2 = 0;
    L13:
        if (i2 >= sBlacklistForSystemApp.length) goto L20;
        String pn2 = sBlacklistForSystemApp[i2];
        if (name.startsWith(pn2) == true) goto L16;
        i2 = i2 + 1;
        goto L13
    L16:
        return true;
    L20:
        return false;
    }

    private void closeUselessApk() {
        List<PackageInfo> packageInfoList = this.mPm.getInstalledPackages(0);
        String currentIme = getCurrentInputMethodName();
        long startTime = SystemClock.uptimeMillis();
        if (packageInfoList == null) goto L16;
        int i = 0;
    L6:
        if (i >= packageInfoList.size()) goto L16;
        String pn = packageInfoList.get(i).packageName;
        PackageInfo packageInfo = packageInfoList.get(i);
        Slog.d("PowerSaveModeController", "package " + i + " : " + pn);
        if (pn.equals(currentIme) == false) goto L11;
        Slog.d("PowerSaveModeController", "currentIme = " + currentIme);
    L15:
        i = i + 1;
        goto L6
    L11:
        if ((packageInfo.applicationInfo.flags & 1) != 0) goto L13;
    L14:
        Slog.d("PowerSaveModeController", "forceclose system package = " + pn);
        this.mAm.forceStopPackage(pn);
        goto L15
    L13:
        if (isInBlackList(pn, false) == false) goto L15;
    L16:
        long endTime = SystemClock.uptimeMillis();
        Slog.e("PowerSaveModeController", "forceclose time = " + (endTime - startTime));
    }

    private void removeRecentTasks() {
        List<ActivityManager.RecentTaskInfo> recentTasks = this.mAm.getRecentTasks(Integer.MAX_VALUE, 2);
        int numTasks = recentTasks.size();
        int i = 0;
    L3:
        if (i >= numTasks) goto L6;
        ActivityManager.RecentTaskInfo recentInfo = recentTasks.get(i);
        recentInfo.baseIntent.getComponent().getPackageName();
        i = i + 1;
        goto L3
    }

    public String getCurrentInputMethodName() {
        InputMethodManager imm = (InputMethodManager) this.mContext.getSystemService("input_method");
        List<InputMethodInfo> imms = imm.getInputMethodList();
        String selectedId = Settings.Secure.getString(this.mContext.getContentResolver(), "default_input_method");
        Iterator<InputMethodInfo> r3 = imms.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        InputMethodInfo imi = r3.next();
        if (imi.getId().equals(selectedId) == false) goto L4;
        Log.d("SuperPowerSettingsEnabler", "getCurrentInputMethodName : " + selectedId);
        return imi.getPackageName();
    L10:
        return null;
    }

    public void closeTorch() {
        String cameraId = getCameraId();     // Catch: CameraAccessException -> L6
        if (cameraId == null) goto L13;
        this.mCameraManager.setTorchMode(cameraId, false);     // Catch: CameraAccessException -> L6
        return;
    L13:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private String getCameraId() throws CameraAccessException {
        String[] ids = this.mCameraManager.getCameraIdList();
        int r1 = ids.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        String id = ids[r2];
        CameraCharacteristics cameraCharacter = this.mCameraManager.getCameraCharacteristics(id);
        Boolean flashAvailable = (Boolean) cameraCharacter.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Integer lensFacing = (Integer) cameraCharacter.get(CameraCharacteristics.LENS_FACING);
        if (flashAvailable == null) goto L12;
        if (flashAvailable.booleanValue() == false) goto L12;
        if (lensFacing == null) goto L12;
        if (lensFacing.intValue() != 1) goto L12;
        return id;
    L12:
        r2 = r2 + 1;
        goto L3
    L13:
        return null;
    }

    private void saveConfig(String name, Object value) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mSavePowerConfList != null) goto L7;
        this.mSavePowerConfList = new JSONObject();     // Catch: JSONException -> L5
    L7:
        this.mSavePowerConfList.put(name, value);     // Catch: JSONException -> L5
    }

    private ComponentName getCurrentLauncher() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo ri = this.mContext.getPackageManager().resolveActivity(intent, 65536);
        if (ri != null) goto L6;
        return null;
    L6:
        ActivityInfo ai = ri.activityInfo;
        if (ai.name.endsWith("ChooserAcitivy") == false) goto L11;
        return this.mBytedanceHome;
    L11:
        return new ComponentName(ai.packageName, ai.name);
    }

    private void setDefaultHome(final ComponentName home) {
        this.mPm.setApplicationEnabledSetting(home.getPackageName(), 1, 1);
        Intent homeIntent = new Intent("android.intent.action.MAIN");
        homeIntent.addCategory("android.intent.category.HOME");
        this.mPm.getSmtEx().clearPreferredActivities(homeIntent);
        List<ResolveInfo> homes = this.mPm.queryIntentActivities(homeIntent, 65536);
        int selected = -1;
        ComponentName[] set = new ComponentName[homes.size()];
        int i = 0;
    L4:
        if (i >= homes.size()) goto L10;
        ActivityInfo info = homes.get(i).activityInfo;
        set[i] = new ComponentName(info.packageName, info.name);
        if (home.getPackageName().equals(info.packageName) == false) goto L8;
        selected = i;
    L8:
        i = i + 1;
        goto L4
    L10:
        if (selected != (-1)) goto L13;
        Slog.d("PowerSaveModeController", "setDefaultHome failed and retry : " + home);
        this.mHandler.postDelayed(new PowerSaveModeController$$ExternalSyntheticLambda0(this, home), 500);
        return;
    L13:
        IntentFilter filter = new IntentFilter("android.intent.action.MAIN");
        filter.addCategory("android.intent.category.HOME");
        filter.addCategory("android.intent.category.DEFAULT");
        this.mPm.addPreferredActivity(filter, 1081344, set, set[selected]);
        this.mPm.flushPackageRestrictionsAsUser(UserHandle.getCallingUserId());
        this.mPm.getSmtEx().unlockAllPackages();
    }

    private /* synthetic */ void lambda$setDefaultHome$0(ComponentName home) {
        setDefaultHome(home);
    }

    private void startHome() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(268435456);
        this.mContext.startActivity(intent);
    }

    public void changeLauncher(boolean toNormal) {
        if (toNormal == true) goto L11;
        ComponentName from = getCurrentLauncher();
        if (from != null) goto L8;
        Slog.i("SuperPowerSettingsEnabler", "changeLauncher failed");
        return;
    L8:
        if (this.mPowerSaveHome.equals(from) == false) goto L10;
        from = this.last_launcher;
    L10:
        ComponentName to = this.mPowerSaveHome;
        saveConfig("last_launcher_pkg", from.getPackageName());
        saveConfig("last_launcher_name", from.getClassName());
        this.last_launcher = from;
    L12:
        setDefaultHome(to);
        this.mAm.forceStopPackage(from.getPackageName());
        startHome();
        return;
    L11:
        from = this.mPowerSaveHome;
        to = this.last_launcher;
        this.mPm.setApplicationEnabledSetting(this.mPowerSaveHome.getPackageName(), 2, 1);
        goto L12
    }

    private boolean beingLostModeEnabled() {
        return LostModeUtil.beingLostModeEnabled(this.mContext);
    }
}
