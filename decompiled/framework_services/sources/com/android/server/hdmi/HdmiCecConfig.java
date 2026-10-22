package com.android.server.hdmi;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Environment;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.util.ConcurrentUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecConfig {
    private static final String CONFIG_FILE = "cec_config.xml";
    private static final String ETC_DIR = "etc";
    private static final String SHARED_PREFS_DIR = "shared_prefs";
    private static final String SHARED_PREFS_NAME = "cec_config.xml";
    private static final int STORAGE_GLOBAL_SETTINGS = 1;
    private static final int STORAGE_SHARED_PREFS = 2;
    private static final int STORAGE_SYSPROPS = 0;
    private static final String TAG = "HdmiCecConfig";
    private static final String VALUE_TYPE_INT = "int";
    private static final String VALUE_TYPE_STRING = "string";
    private final Context mContext;
    private final Object mLock;
    private final ArrayMap<Setting, ArrayMap<SettingChangeListener, Executor>> mSettingChangeListeners;
    private LinkedHashMap<String, Setting> mSettings;
    private final StorageAdapter mStorageAdapter;

    protected class Setting {
        private List<Value> mAllowedValues;
        private final Context mContext;
        private Value mDefaultValue;
        private final String mName;
        private final boolean mUserConfigurable;
        final /* synthetic */ HdmiCecConfig this$0;

        Setting(HdmiCecConfig this$0, Context context, String name, int userConfResId) {
            this.this$0 = this$0;
            this.mDefaultValue = null;
            this.mAllowedValues = new ArrayList();
            this.mContext = context;
            this.mName = name;
            this.mUserConfigurable = this.mContext.getResources().getBoolean(userConfResId);
        }

        public String getName() {
            return this.mName;
        }

        public String getValueType() {
            if (getDefaultValue().getStringValue() == null) goto L5;
            return HdmiCecConfig.VALUE_TYPE_STRING;
        L5:
            return HdmiCecConfig.VALUE_TYPE_INT;
        }

        public Value getDefaultValue() {
            if (this.mDefaultValue == null) goto L7;
            return this.mDefaultValue;
        L7:
            throw new VerificationException("Invalid CEC setup for '" + getName() + "' setting. Setting has no default value.");
        }

        public boolean getUserConfigurable() {
            return this.mUserConfigurable;
        }

        private void registerValue(Value value, int allowedResId, int defaultResId) {
            if (this.mContext.getResources().getBoolean(allowedResId) == false) goto L12;
            this.mAllowedValues.add(value);
            if (this.mContext.getResources().getBoolean(defaultResId) == true) goto L7;
            return;
        L7:
            if (this.mDefaultValue == null) goto L10;
            Slog.e(HdmiCecConfig.TAG, "Failed to set '" + value + "' as a default for '" + getName() + "': Setting already has a default ('" + this.mDefaultValue + "').");
            return;
        L10:
            this.mDefaultValue = value;
            return;
        }

        public void registerValue(String value, int allowedResId, int defaultResId) {
            registerValue(new Value(this.this$0, value), allowedResId, defaultResId);
        }

        public void registerValue(int value, int allowedResId, int defaultResId) {
            registerValue(new Value(this.this$0, Integer.valueOf(value)), allowedResId, defaultResId);
        }

        public List<Value> getAllowedValues() {
            return this.mAllowedValues;
        }
    }

    public interface SettingChangeListener {
        void onChange(String r1);
    }

    private @interface Storage {
    }

    public static class StorageAdapter {
        private final Context mContext;
        private final SharedPreferences mSharedPrefs;

        StorageAdapter(Context context) {
            this.mContext = context;
            Context deviceContext = this.mContext.createDeviceProtectedStorageContext();
            File prefsFile = new File(new File(Environment.getDataSystemDirectory(), HdmiCecConfig.SHARED_PREFS_DIR), "cec_config.xml");
            this.mSharedPrefs = deviceContext.getSharedPreferences(prefsFile, 0);
        }

        public String retrieveSystemProperty(String storageKey, String defaultValue) {
            return SystemProperties.get(storageKey, defaultValue);
        }

        public void storeSystemProperty(String storageKey, String value) {
            SystemProperties.set(storageKey, value);
        }

        public String retrieveGlobalSetting(String storageKey, String defaultValue) {
            String value = Settings.Global.getString(this.mContext.getContentResolver(), storageKey);
            if (value == null) goto L6;
            return value;
        L6:
            return defaultValue;
        }

        public void storeGlobalSetting(String storageKey, String value) {
            Settings.Global.putString(this.mContext.getContentResolver(), storageKey, value);
        }

        public String retrieveSharedPref(String storageKey, String defaultValue) {
            return this.mSharedPrefs.getString(storageKey, defaultValue);
        }

        public void storeSharedPref(String storageKey, String value) {
            this.mSharedPrefs.edit().putString(storageKey, value).apply();
        }
    }

    private class Value {
        private final Integer mIntValue;
        private final String mStringValue;

        Value(HdmiCecConfig r1, String value) {
            this.mStringValue = value;
            this.mIntValue = null;
        }

        Value(HdmiCecConfig r1, Integer value) {
            this.mStringValue = null;
            this.mIntValue = value;
        }

        String getStringValue() {
            return this.mStringValue;
        }

        Integer getIntValue() {
            return this.mIntValue;
        }
    }

    private @interface ValueType {
    }

    public static class VerificationException extends RuntimeException {
        public VerificationException(String message) {
            super(message);
        }
    }

    HdmiCecConfig(Context context, StorageAdapter storageAdapter) {
        this.mLock = new Object();
        this.mSettingChangeListeners = new ArrayMap();
        this.mSettings = new LinkedHashMap();
        this.mContext = context;
        this.mStorageAdapter = storageAdapter;
        Setting hdmiCecEnabled = registerSetting("hdmi_cec_enabled", R.bool.config_cecHdmiCecVersion20_allowed);
        hdmiCecEnabled.registerValue(1, R.bool.config_cecHdmiCecVersion14b_allowed, R.bool.config_cecHdmiCecVersion14b_default);
        hdmiCecEnabled.registerValue(0, R.bool.config_cecHdmiCecControlEnabled_default, R.bool.config_cecHdmiCecEnabled_userConfigurable);
        Setting hdmiCecVersion = registerSetting("hdmi_cec_version", R.bool.config_cecPowerControlModeNone_allowed);
        hdmiCecVersion.registerValue(5, R.bool.config_cecHdmiCecVersion20_default, R.bool.config_cecHdmiCecVersion_userConfigurable);
        hdmiCecVersion.registerValue(6, R.bool.config_cecPowerControlModeBroadcast_allowed, R.bool.config_cecPowerControlModeBroadcast_default);
        Setting routingControlControl = registerSetting("routing_control", R.bool.config_cecSetMenuLanguageEnabled_allowed);
        routingControlControl.registerValue(1, R.bool.config_cecSetMenuLanguageDisabled_allowed, R.bool.config_cecSetMenuLanguageDisabled_default);
        routingControlControl.registerValue(0, R.bool.config_cecRoutingControlEnabled_default, R.bool.config_cecRoutingControl_userConfigurable);
        Setting soundbarMode = registerSetting("soundbar_mode", R.bool.config_cecSystemAudioControlEnabled_allowed);
        soundbarMode.registerValue(1, R.bool.config_cecSystemAudioControlDisabled_allowed, R.bool.config_cecSystemAudioControlDisabled_default);
        soundbarMode.registerValue(0, R.bool.config_cecSoundbarModeEnabled_default, R.bool.config_cecSoundbarMode_userConfigurable);
        Setting powerControlMode = registerSetting("power_control_mode", R.bool.config_cecPowerStateChangeOnActiveSourceLostStandbyNow_allowed);
        powerControlMode.registerValue("to_tv", R.bool.config_cecPowerStateChangeOnActiveSourceLostNone_allowed, R.bool.config_cecPowerStateChangeOnActiveSourceLostNone_default);
        powerControlMode.registerValue("broadcast", R.bool.config_cecPowerControlModeNone_default, R.bool.config_cecPowerControlModeTvAndAudioSystem_allowed);
        powerControlMode.registerValue("none", R.bool.config_cecPowerControlModeTvAndAudioSystem_default, R.bool.config_cecPowerControlModeTv_allowed);
        powerControlMode.registerValue("to_tv_and_audio_system", R.bool.config_cecPowerControlModeTv_default, R.bool.config_cecPowerControlMode_userConfigurable);
        Setting powerStateChangeOnActiveSourceLost = registerSetting("power_state_change_on_active_source_lost", R.bool.config_cecQuerySadAacEnabled_allowed);
        powerStateChangeOnActiveSourceLost.registerValue("none", R.bool.config_cecPowerStateChangeOnActiveSourceLostStandbyNow_default, R.bool.config_cecPowerStateChangeOnActiveSourceLost_userConfigurable);
        powerStateChangeOnActiveSourceLost.registerValue("standby_now", R.bool.config_cecQuerySadAacDisabled_allowed, R.bool.config_cecQuerySadAacDisabled_default);
        Setting systemAudioControl = registerSetting("system_audio_control", R.bool.config_cecSystemAudioModeMutingEnabled_allowed);
        systemAudioControl.registerValue(1, R.bool.config_cecSystemAudioModeMutingDisabled_allowed, R.bool.config_cecSystemAudioModeMutingDisabled_default);
        systemAudioControl.registerValue(0, R.bool.config_cecSystemAudioControlEnabled_default, R.bool.config_cecSystemAudioControl_userConfigurable);
        Setting systemAudioModeMuting = registerSetting("system_audio_mode_muting", R.bool.config_cecTvSendStandbyOnSleepEnabled_allowed);
        systemAudioModeMuting.registerValue(1, R.bool.config_cecTvSendStandbyOnSleepDisabled_allowed, R.bool.config_cecTvSendStandbyOnSleepDisabled_default);
        systemAudioModeMuting.registerValue(0, R.bool.config_cecSystemAudioModeMutingEnabled_default, R.bool.config_cecSystemAudioModeMuting_userConfigurable);
        Setting volumeControlMode = registerSetting("volume_control_enabled", R.bool.config_closeDialogWhenTouchOutside);
        volumeControlMode.registerValue(1, R.bool.config_cellBroadcastAppLinks, R.bool.config_checkWallpaperAtBoot);
        volumeControlMode.registerValue(0, R.bool.config_cecVolumeControlModeEnabled_default, R.bool.config_cecVolumeControlMode_userConfigurable);
        Setting tvWakeOnOneTouchPlay = registerSetting("tv_wake_on_one_touch_play", R.bool.config_cecVolumeControlModeEnabled_allowed);
        tvWakeOnOneTouchPlay.registerValue(1, R.bool.config_cecVolumeControlModeDisabled_allowed, R.bool.config_cecVolumeControlModeDisabled_default);
        tvWakeOnOneTouchPlay.registerValue(0, R.bool.config_cecTvWakeOnOneTouchPlayEnabled_default, R.bool.config_cecTvWakeOnOneTouchPlay_userConfigurable);
        Setting tvSendStandbyOnSleep = registerSetting("tv_send_standby_on_sleep", R.bool.config_cecTvWakeOnOneTouchPlayEnabled_allowed);
        tvSendStandbyOnSleep.registerValue(1, R.bool.config_cecTvWakeOnOneTouchPlayDisabled_allowed, R.bool.config_cecTvWakeOnOneTouchPlayDisabled_default);
        tvSendStandbyOnSleep.registerValue(0, R.bool.config_cecTvSendStandbyOnSleepEnabled_default, R.bool.config_cecTvSendStandbyOnSleep_userConfigurable);
        Setting setMenuLanguage = registerSetting("set_menu_language", R.bool.config_cecSoundbarModeEnabled_allowed);
        setMenuLanguage.registerValue(1, R.bool.config_cecSoundbarModeDisabled_allowed, R.bool.config_cecSoundbarModeDisabled_default);
        setMenuLanguage.registerValue(0, R.bool.config_cecSetMenuLanguageEnabled_default, R.bool.config_cecSetMenuLanguage_userConfigurable);
        Setting rcProfileTv = registerSetting("rc_profile_tv", R.bool.config_cecRoutingControlEnabled_allowed);
        rcProfileTv.registerValue(0, R.bool.config_cecRcProfileTvOne_default, R.bool.config_cecRcProfileTvThree_allowed);
        rcProfileTv.registerValue(2, R.bool.config_cecRcProfileTvThree_default, R.bool.config_cecRcProfileTvTwo_allowed);
        rcProfileTv.registerValue(6, R.bool.config_cecRoutingControlDisabled_allowed, R.bool.config_cecRoutingControlDisabled_default);
        rcProfileTv.registerValue(10, R.bool.config_cecRcProfileTvTwo_default, R.bool.config_cecRcProfileTv_userConfigurable);
        rcProfileTv.registerValue(14, R.bool.config_cecRcProfileTvNone_default, R.bool.config_cecRcProfileTvOne_allowed);
        Setting rcProfileSourceRootMenu = registerSetting("rc_profile_source_handles_root_menu", R.bool.config_cecRcProfileSourceSetupMenuNotHandled_allowed);
        rcProfileSourceRootMenu.registerValue(1, R.bool.config_cecRcProfileSourceRootMenuNotHandled_default, R.bool.config_cecRcProfileSourceRootMenu_userConfigurable);
        rcProfileSourceRootMenu.registerValue(0, R.bool.config_cecRcProfileSourceSetupMenuHandled_allowed, R.bool.config_cecRcProfileSourceSetupMenuHandled_default);
        Setting rcProfileSourceSetupMenu = registerSetting("rc_profile_source_handles_setup_menu", R.bool.config_cecRcProfileSourceTopMenuNotHandled_allowed);
        rcProfileSourceSetupMenu.registerValue(1, R.bool.config_cecRcProfileSourceSetupMenuNotHandled_default, R.bool.config_cecRcProfileSourceSetupMenu_userConfigurable);
        rcProfileSourceSetupMenu.registerValue(0, R.bool.config_cecRcProfileSourceTopMenuHandled_allowed, R.bool.config_cecRcProfileSourceTopMenuHandled_default);
        Setting rcProfileSourceContentsMenu = registerSetting("rc_profile_source_handles_contents_menu", R.bool.config_cecRcProfileSourceMediaContextSensitiveMenuNotHandled_allowed);
        rcProfileSourceContentsMenu.registerValue(1, R.bool.config_cecRcProfileSourceContentsMenuNotHandled_default, R.bool.config_cecRcProfileSourceContentsMenu_userConfigurable);
        rcProfileSourceContentsMenu.registerValue(0, R.bool.config_cecRcProfileSourceMediaContextSensitiveMenuHandled_allowed, R.bool.config_cecRcProfileSourceMediaContextSensitiveMenuHandled_default);
        Setting rcProfileSourceTopMenu = registerSetting("rc_profile_source_handles_top_menu", R.bool.config_cecRcProfileTvNone_allowed);
        rcProfileSourceTopMenu.registerValue(1, R.bool.config_cecRcProfileSourceTopMenuNotHandled_default, R.bool.config_cecRcProfileSourceTopMenu_userConfigurable);
        rcProfileSourceTopMenu.registerValue(0, R.bool.config_cecRcProfileTvFour_allowed, R.bool.config_cecRcProfileTvFour_default);
        Setting rcProfileSourceMediaContextSensitiveMenu = registerSetting("rc_profile_source_handles_media_context_sensitive_menu", R.bool.config_cecRcProfileSourceRootMenuNotHandled_allowed);
        rcProfileSourceMediaContextSensitiveMenu.registerValue(1, R.bool.config_cecRcProfileSourceMediaContextSensitiveMenuNotHandled_default, R.bool.config_cecRcProfileSourceMediaContextSensitiveMenu_userConfigurable);
        rcProfileSourceMediaContextSensitiveMenu.registerValue(0, R.bool.config_cecRcProfileSourceRootMenuHandled_allowed, R.bool.config_cecRcProfileSourceRootMenuHandled_default);
        Setting querySadLpcm = registerSetting("query_sad_lpcm", R.bool.config_cecQuerySadMaxEnabled_allowed);
        querySadLpcm.registerValue(1, R.bool.config_cecQuerySadMaxDisabled_allowed, R.bool.config_cecQuerySadMaxDisabled_default);
        querySadLpcm.registerValue(0, R.bool.config_cecQuerySadLpcmEnabled_default, R.bool.config_cecQuerySadLpcm_userConfigurable);
        Setting querySadDd = registerSetting("query_sad_dd", R.bool.config_cecQuerySadDdpEnabled_allowed);
        querySadDd.registerValue(1, R.bool.config_cecQuerySadDdpDisabled_allowed, R.bool.config_cecQuerySadDdpDisabled_default);
        querySadDd.registerValue(0, R.bool.config_cecQuerySadDdEnabled_default, R.bool.config_cecQuerySadDd_userConfigurable);
        Setting querySadMpeg1 = registerSetting("query_sad_mpeg1", R.bool.config_cecQuerySadMpeg2Enabled_allowed);
        querySadMpeg1.registerValue(1, R.bool.config_cecQuerySadMpeg2Disabled_allowed, R.bool.config_cecQuerySadMpeg2Disabled_default);
        querySadMpeg1.registerValue(0, R.bool.config_cecQuerySadMpeg1Enabled_default, R.bool.config_cecQuerySadMpeg1_userConfigurable);
        Setting querySadMp3 = registerSetting("query_sad_mp3", R.bool.config_cecQuerySadMpeg1Enabled_allowed);
        querySadMp3.registerValue(1, R.bool.config_cecQuerySadMpeg1Disabled_allowed, R.bool.config_cecQuerySadMpeg1Disabled_default);
        querySadMp3.registerValue(0, R.bool.config_cecQuerySadMp3Enabled_default, R.bool.config_cecQuerySadMp3_userConfigurable);
        Setting querySadMpeg2 = registerSetting("query_sad_mpeg2", R.bool.config_cecQuerySadOnebitaudioEnabled_allowed);
        querySadMpeg2.registerValue(1, R.bool.config_cecQuerySadOnebitaudioDisabled_allowed, R.bool.config_cecQuerySadOnebitaudioDisabled_default);
        querySadMpeg2.registerValue(0, R.bool.config_cecQuerySadMpeg2Enabled_default, R.bool.config_cecQuerySadMpeg2_userConfigurable);
        Setting querySadAac = registerSetting("query_sad_aac", R.bool.config_cecQuerySadAtracEnabled_allowed);
        querySadAac.registerValue(1, R.bool.config_cecQuerySadAtracDisabled_allowed, R.bool.config_cecQuerySadAtracDisabled_default);
        querySadAac.registerValue(0, R.bool.config_cecQuerySadAacEnabled_default, R.bool.config_cecQuerySadAac_userConfigurable);
        Setting querySadDts = registerSetting("query_sad_dts", R.bool.config_cecQuerySadDtshdEnabled_allowed);
        querySadDts.registerValue(1, R.bool.config_cecQuerySadDtshdDisabled_allowed, R.bool.config_cecQuerySadDtshdDisabled_default);
        querySadDts.registerValue(0, R.bool.config_cecQuerySadDtsEnabled_default, R.bool.config_cecQuerySadDts_userConfigurable);
        Setting querySadAtrac = registerSetting("query_sad_atrac", R.bool.config_cecQuerySadDdEnabled_allowed);
        querySadAtrac.registerValue(1, R.bool.config_cecQuerySadDdDisabled_allowed, R.bool.config_cecQuerySadDdDisabled_default);
        querySadAtrac.registerValue(0, R.bool.config_cecQuerySadAtracEnabled_default, R.bool.config_cecQuerySadAtrac_userConfigurable);
        Setting querySadOnebitaudio = registerSetting("query_sad_onebitaudio", R.bool.config_cecQuerySadTruehdEnabled_allowed);
        querySadOnebitaudio.registerValue(1, R.bool.config_cecQuerySadTruehdDisabled_allowed, R.bool.config_cecQuerySadTruehdDisabled_default);
        querySadOnebitaudio.registerValue(0, R.bool.config_cecQuerySadOnebitaudioEnabled_default, R.bool.config_cecQuerySadOnebitaudio_userConfigurable);
        Setting querySadDdp = registerSetting("query_sad_ddp", R.bool.config_cecQuerySadDstEnabled_allowed);
        querySadDdp.registerValue(1, R.bool.config_cecQuerySadDstDisabled_allowed, R.bool.config_cecQuerySadDstDisabled_default);
        querySadDdp.registerValue(0, R.bool.config_cecQuerySadDdpEnabled_default, R.bool.config_cecQuerySadDdp_userConfigurable);
        Setting querySadDtshd = registerSetting("query_sad_dtshd", R.bool.config_cecQuerySadLpcmEnabled_allowed);
        querySadDtshd.registerValue(1, R.bool.config_cecQuerySadLpcmDisabled_allowed, R.bool.config_cecQuerySadLpcmDisabled_default);
        querySadDtshd.registerValue(0, R.bool.config_cecQuerySadDtshdEnabled_default, R.bool.config_cecQuerySadDtshd_userConfigurable);
        Setting querySadTruehd = registerSetting("query_sad_truehd", R.bool.config_cecQuerySadWmaproEnabled_allowed);
        querySadTruehd.registerValue(1, R.bool.config_cecQuerySadWmaproDisabled_allowed, R.bool.config_cecQuerySadWmaproDisabled_default);
        querySadTruehd.registerValue(0, R.bool.config_cecQuerySadTruehdEnabled_default, R.bool.config_cecQuerySadTruehd_userConfigurable);
        Setting querySadDst = registerSetting("query_sad_dst", R.bool.config_cecQuerySadDtsEnabled_allowed);
        querySadDst.registerValue(1, R.bool.config_cecQuerySadDtsDisabled_allowed, R.bool.config_cecQuerySadDtsDisabled_default);
        querySadDst.registerValue(0, R.bool.config_cecQuerySadDstEnabled_default, R.bool.config_cecQuerySadDst_userConfigurable);
        Setting querySadWmapro = registerSetting("query_sad_wmapro", R.bool.config_cecRcProfileSourceContentsMenuNotHandled_allowed);
        querySadWmapro.registerValue(1, R.bool.config_cecRcProfileSourceContentsMenuHandled_allowed, R.bool.config_cecRcProfileSourceContentsMenuHandled_default);
        querySadWmapro.registerValue(0, R.bool.config_cecQuerySadWmaproEnabled_default, R.bool.config_cecQuerySadWmapro_userConfigurable);
        Setting querySadMax = registerSetting("query_sad_max", R.bool.config_cecQuerySadMp3Enabled_allowed);
        querySadMax.registerValue(1, R.bool.config_cecQuerySadMp3Disabled_allowed, R.bool.config_cecQuerySadMp3Disabled_default);
        querySadMax.registerValue(0, R.bool.config_cecQuerySadMaxEnabled_default, R.bool.config_cecQuerySadMax_userConfigurable);
        Setting earcEnabled = registerSetting("earc_enabled", R.bool.config_earcFeatureEnabled_default);
        earcEnabled.registerValue(1, R.bool.config_enableAppCloningBuildingBlocks, R.bool.config_enableAppWidgetService);
        earcEnabled.registerValue(0, R.bool.config_emergencyGestureEnabled, R.bool.config_enableActivityRecognitionHardwareOverlay);
        verifySettings();
    }

    HdmiCecConfig(Context context) {
        this(context, new StorageAdapter(context));
    }

    private Setting registerSetting(String name, int userConfResId) {
        Setting setting = new Setting(this, this.mContext, name, userConfResId);
        this.mSettings.put(name, setting);
        return setting;
    }

    private void verifySettings() {
        Iterator<Setting> r0 = this.mSettings.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Setting setting = r0.next();
        setting.getDefaultValue();
        getStorage(setting);
        getStorageKey(setting);
        goto L4
    }

    private Setting getSetting(String name) {
        if (this.mSettings.containsKey(name) == true) goto L7;
        return null;
    L7:
        return this.mSettings.get(name);
    }

    private int getStorage(Setting setting) {
        String r0 = setting.getName();
        switch(r0.hashCode()) {
            case -2072577869: goto L105;
            case -1788790343: goto L102;
            case -1618836197: goto L99;
            case -1275604441: goto L96;
            case -1253675651: goto L93;
            case -1188289112: goto L90;
            case -1157203295: goto L87;
            case -1154431553: goto L84;
            case -1146252564: goto L81;
            case -1146252563: goto L78;
            case -1081575217: goto L75;
            case -971363478: goto L72;
            case -910325648: goto L69;
            case -890678558: goto L66;
            case -412334364: goto L63;
            case -314100402: goto L60;
            case -293445547: goto L57;
            case -219770232: goto L54;
            case -25374657: goto L51;
            case 18371678: goto L48;
            case 73184058: goto L45;
            case 261187356: goto L42;
            case 791759782: goto L39;
            case 799280879: goto L36;
            case 1577324768: goto L33;
            case 1629183631: goto L30;
            case 1652424675: goto L27;
            case 1652427664: goto L24;
            case 1652428133: goto L21;
            case 1652428163: goto L18;
            case 1652436228: goto L15;
            case 1652436624: goto L12;
            case 2055627683: goto L9;
            case 2118236132: goto L6;
            default: goto L107;
        };
    L107:
        byte r1 = -1;
    L108:
        switch(r1) {
            case 0: goto L144;
            case 1: goto L143;
            case 2: goto L142;
            case 3: goto L141;
            case 4: goto L140;
            case 5: goto L139;
            case 6: goto L138;
            case 7: goto L137;
            case 8: goto L136;
            case 9: goto L135;
            case 10: goto L134;
            case 11: goto L133;
            case 12: goto L132;
            case 13: goto L131;
            case 14: goto L130;
            case 15: goto L129;
            case 16: goto L128;
            case 17: goto L127;
            case 18: goto L126;
            case 19: goto L125;
            case 20: goto L124;
            case 21: goto L123;
            case 22: goto L122;
            case 23: goto L121;
            case 24: goto L120;
            case 25: goto L119;
            case 26: goto L118;
            case 27: goto L117;
            case 28: goto L116;
            case 29: goto L115;
            case 30: goto L114;
            case 31: goto L113;
            case 32: goto L112;
            case 33: goto L111;
            default: goto L110;
        };
    L111:
        return 2;
    L112:
        return 2;
    L113:
        return 2;
    L114:
        return 2;
    L115:
        return 2;
    L116:
        return 2;
    L117:
        return 2;
    L118:
        return 2;
    L119:
        return 2;
    L120:
        return 2;
    L121:
        return 2;
    L122:
        return 2;
    L123:
        return 2;
    L124:
        return 2;
    L125:
        return 2;
    L126:
        return 2;
    L127:
        return 2;
    L128:
        return 2;
    L129:
        return 2;
    L130:
        return 2;
    L131:
        return 2;
    L132:
        return 2;
    L133:
        return 2;
    L134:
        return 2;
    L135:
        return 2;
    L136:
        return 2;
    L137:
        return 2;
    L138:
        return 2;
    L139:
        return 2;
    L140:
        return 2;
    L141:
        return 2;
    L142:
        return 2;
    L143:
        return 2;
    L144:
        return 2;
    L110:
        throw new VerificationException("Invalid CEC setting '" + setting.getName() + "' storage.");
    L6:
        if (r0.equals("system_audio_control") == false) goto L107;
        r1 = 7;
        goto L108
    L9:
        if (r0.equals("tv_send_standby_on_sleep") == false) goto L107;
        r1 = 10;
        goto L108
    L12:
        if (r0.equals("query_sad_mp3") == false) goto L107;
        r1 = ParameterName.BLUE_STRETCH;
        goto L108
    L15:
        if (r0.equals("query_sad_max") == false) goto L107;
        r1 = ParameterName.CVRR;
        goto L108
    L18:
        if (r0.equals("query_sad_dts") == false) goto L107;
        r1 = ParameterName.GLOBE_DIMMING;
        goto L108
    L21:
        if (r0.equals("query_sad_dst") == false) goto L107;
        r1 = ParameterName.LOW_LATENCY;
        goto L108
    L24:
        if (r0.equals("query_sad_ddp") == false) goto L107;
        r1 = ParameterName.LEVEL_RANGE;
        goto L108
    L27:
        if (r0.equals("query_sad_aac") == false) goto L107;
        r1 = ParameterName.COLOR_TEMPERATURE;
        goto L108
    L30:
        if (r0.equals("tv_wake_on_one_touch_play") == false) goto L107;
        r1 = 9;
        goto L108
    L33:
        if (r0.equals("query_sad_dd") == false) goto L107;
        r1 = ParameterName.FILM_MODE;
        goto L108
    L36:
        if (r0.equals("query_sad_onebitaudio") == false) goto L107;
        r1 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L108
    L39:
        if (r0.equals("rc_profile_tv") == false) goto L107;
        r1 = 12;
        goto L108
    L42:
        if (r0.equals("hdmi_cec_enabled") == false) goto L107;
        r1 = 0;
        goto L108
    L45:
        if (r0.equals("volume_control_enabled") == false) goto L107;
        r1 = 5;
        goto L108
    L48:
        if (r0.equals("soundbar_mode") == false) goto L107;
        r1 = 3;
        goto L108
    L51:
        if (r0.equals("power_control_mode") == false) goto L107;
        r1 = 4;
        goto L108
    L54:
        if (r0.equals("power_state_change_on_active_source_lost") == false) goto L107;
        r1 = 6;
        goto L108
    L57:
        if (r0.equals("rc_profile_source_handles_setup_menu") == false) goto L107;
        r1 = 14;
        goto L108
    L60:
        if (r0.equals("query_sad_lpcm") == false) goto L107;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L108
    L63:
        if (r0.equals("routing_control") == false) goto L107;
        r1 = 2;
        goto L108
    L66:
        if (r0.equals("query_sad_wmapro") == false) goto L107;
        r1 = ParameterName.VRR;
        goto L108
    L69:
        if (r0.equals("rc_profile_source_handles_contents_menu") == false) goto L107;
        r1 = 15;
        goto L108
    L72:
        if (r0.equals("query_sad_truehd") == false) goto L107;
        r1 = ParameterName.PC_MODE;
        goto L108
    L75:
        if (r0.equals("earc_enabled") == false) goto L107;
        r1 = 33;
        goto L108
    L78:
        if (r0.equals("query_sad_mpeg2") == false) goto L107;
        r1 = ParameterName.COLOR_TUNE;
        goto L108
    L81:
        if (r0.equals("query_sad_mpeg1") == false) goto L107;
        r1 = ParameterName.BLACK_STRETCH;
        goto L108
    L84:
        if (r0.equals("query_sad_dtshd") == false) goto L107;
        r1 = ParameterName.GAMUT_MAPPING;
        goto L108
    L87:
        if (r0.equals("query_sad_atrac") == false) goto L107;
        r1 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L108
    L90:
        if (r0.equals("rc_profile_source_handles_root_menu") == false) goto L107;
        r1 = 13;
        goto L108
    L93:
        if (r0.equals("rc_profile_source_handles_top_menu") == false) goto L107;
        r1 = 16;
        goto L108
    L96:
        if (r0.equals("rc_profile_source_handles_media_context_sensitive_menu") == false) goto L107;
        r1 = ParameterName.DE_CONTOUR;
        goto L108
    L99:
        if (r0.equals("set_menu_language") == false) goto L107;
        r1 = 11;
        goto L108
    L102:
        if (r0.equals("system_audio_mode_muting") == false) goto L107;
        r1 = 8;
        goto L108
    L105:
        if (r0.equals("hdmi_cec_version") == false) goto L107;
        r1 = 1;
        goto L108
    }

    private String getStorageKey(Setting setting) {
        String r0 = setting.getName();
        switch(r0.hashCode()) {
            case -2072577869: goto L105;
            case -1788790343: goto L102;
            case -1618836197: goto L99;
            case -1275604441: goto L96;
            case -1253675651: goto L93;
            case -1188289112: goto L90;
            case -1157203295: goto L87;
            case -1154431553: goto L84;
            case -1146252564: goto L81;
            case -1146252563: goto L78;
            case -1081575217: goto L75;
            case -971363478: goto L72;
            case -910325648: goto L69;
            case -890678558: goto L66;
            case -412334364: goto L63;
            case -314100402: goto L60;
            case -293445547: goto L57;
            case -219770232: goto L54;
            case -25374657: goto L51;
            case 18371678: goto L48;
            case 73184058: goto L45;
            case 261187356: goto L42;
            case 791759782: goto L39;
            case 799280879: goto L36;
            case 1577324768: goto L33;
            case 1629183631: goto L30;
            case 1652424675: goto L27;
            case 1652427664: goto L24;
            case 1652428133: goto L21;
            case 1652428163: goto L18;
            case 1652436228: goto L15;
            case 1652436624: goto L12;
            case 2055627683: goto L9;
            case 2118236132: goto L6;
            default: goto L107;
        };
    L107:
        byte r1 = -1;
    L108:
        switch(r1) {
            case 0: goto L178;
            case 1: goto L176;
            case 2: goto L174;
            case 3: goto L172;
            case 4: goto L170;
            case 5: goto L168;
            case 6: goto L166;
            case 7: goto L164;
            case 8: goto L162;
            case 9: goto L160;
            case 10: goto L158;
            case 11: goto L156;
            case 12: goto L154;
            case 13: goto L152;
            case 14: goto L150;
            case 15: goto L148;
            case 16: goto L146;
            case 17: goto L144;
            case 18: goto L142;
            case 19: goto L140;
            case 20: goto L138;
            case 21: goto L136;
            case 22: goto L134;
            case 23: goto L132;
            case 24: goto L130;
            case 25: goto L128;
            case 26: goto L126;
            case 27: goto L124;
            case 28: goto L122;
            case 29: goto L120;
            case 30: goto L118;
            case 31: goto L116;
            case 32: goto L114;
            case 33: goto L112;
            default: goto L110;
        };
    L110:
        throw new VerificationException("Invalid CEC setting '" + setting.getName() + "' storage key.");
    L112:
        return setting.getName();
    L114:
        return setting.getName();
    L116:
        return setting.getName();
    L118:
        return setting.getName();
    L120:
        return setting.getName();
    L122:
        return setting.getName();
    L124:
        return setting.getName();
    L126:
        return setting.getName();
    L128:
        return setting.getName();
    L130:
        return setting.getName();
    L132:
        return setting.getName();
    L134:
        return setting.getName();
    L136:
        return setting.getName();
    L138:
        return setting.getName();
    L140:
        return setting.getName();
    L142:
        return setting.getName();
    L144:
        return setting.getName();
    L146:
        return setting.getName();
    L148:
        return setting.getName();
    L150:
        return setting.getName();
    L152:
        return setting.getName();
    L154:
        return setting.getName();
    L156:
        return setting.getName();
    L158:
        return setting.getName();
    L160:
        return setting.getName();
    L162:
        return setting.getName();
    L164:
        return setting.getName();
    L166:
        return setting.getName();
    L168:
        return setting.getName();
    L170:
        return setting.getName();
    L172:
        return setting.getName();
    L174:
        return setting.getName();
    L176:
        return setting.getName();
    L178:
        return setting.getName();
    L6:
        if (r0.equals("system_audio_control") == false) goto L107;
        r1 = 7;
        goto L108
    L9:
        if (r0.equals("tv_send_standby_on_sleep") == false) goto L107;
        r1 = 10;
        goto L108
    L12:
        if (r0.equals("query_sad_mp3") == false) goto L107;
        r1 = ParameterName.BLUE_STRETCH;
        goto L108
    L15:
        if (r0.equals("query_sad_max") == false) goto L107;
        r1 = ParameterName.CVRR;
        goto L108
    L18:
        if (r0.equals("query_sad_dts") == false) goto L107;
        r1 = ParameterName.GLOBE_DIMMING;
        goto L108
    L21:
        if (r0.equals("query_sad_dst") == false) goto L107;
        r1 = ParameterName.LOW_LATENCY;
        goto L108
    L24:
        if (r0.equals("query_sad_ddp") == false) goto L107;
        r1 = ParameterName.LEVEL_RANGE;
        goto L108
    L27:
        if (r0.equals("query_sad_aac") == false) goto L107;
        r1 = ParameterName.COLOR_TEMPERATURE;
        goto L108
    L30:
        if (r0.equals("tv_wake_on_one_touch_play") == false) goto L107;
        r1 = 9;
        goto L108
    L33:
        if (r0.equals("query_sad_dd") == false) goto L107;
        r1 = ParameterName.FILM_MODE;
        goto L108
    L36:
        if (r0.equals("query_sad_onebitaudio") == false) goto L107;
        r1 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L108
    L39:
        if (r0.equals("rc_profile_tv") == false) goto L107;
        r1 = 12;
        goto L108
    L42:
        if (r0.equals("hdmi_cec_enabled") == false) goto L107;
        r1 = 0;
        goto L108
    L45:
        if (r0.equals("volume_control_enabled") == false) goto L107;
        r1 = 5;
        goto L108
    L48:
        if (r0.equals("soundbar_mode") == false) goto L107;
        r1 = 3;
        goto L108
    L51:
        if (r0.equals("power_control_mode") == false) goto L107;
        r1 = 4;
        goto L108
    L54:
        if (r0.equals("power_state_change_on_active_source_lost") == false) goto L107;
        r1 = 6;
        goto L108
    L57:
        if (r0.equals("rc_profile_source_handles_setup_menu") == false) goto L107;
        r1 = 14;
        goto L108
    L60:
        if (r0.equals("query_sad_lpcm") == false) goto L107;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L108
    L63:
        if (r0.equals("routing_control") == false) goto L107;
        r1 = 2;
        goto L108
    L66:
        if (r0.equals("query_sad_wmapro") == false) goto L107;
        r1 = ParameterName.VRR;
        goto L108
    L69:
        if (r0.equals("rc_profile_source_handles_contents_menu") == false) goto L107;
        r1 = 15;
        goto L108
    L72:
        if (r0.equals("query_sad_truehd") == false) goto L107;
        r1 = ParameterName.PC_MODE;
        goto L108
    L75:
        if (r0.equals("earc_enabled") == false) goto L107;
        r1 = 33;
        goto L108
    L78:
        if (r0.equals("query_sad_mpeg2") == false) goto L107;
        r1 = ParameterName.COLOR_TUNE;
        goto L108
    L81:
        if (r0.equals("query_sad_mpeg1") == false) goto L107;
        r1 = ParameterName.BLACK_STRETCH;
        goto L108
    L84:
        if (r0.equals("query_sad_dtshd") == false) goto L107;
        r1 = ParameterName.GAMUT_MAPPING;
        goto L108
    L87:
        if (r0.equals("query_sad_atrac") == false) goto L107;
        r1 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L108
    L90:
        if (r0.equals("rc_profile_source_handles_root_menu") == false) goto L107;
        r1 = 13;
        goto L108
    L93:
        if (r0.equals("rc_profile_source_handles_top_menu") == false) goto L107;
        r1 = 16;
        goto L108
    L96:
        if (r0.equals("rc_profile_source_handles_media_context_sensitive_menu") == false) goto L107;
        r1 = ParameterName.DE_CONTOUR;
        goto L108
    L99:
        if (r0.equals("set_menu_language") == false) goto L107;
        r1 = 11;
        goto L108
    L102:
        if (r0.equals("system_audio_mode_muting") == false) goto L107;
        r1 = 8;
        goto L108
    L105:
        if (r0.equals("hdmi_cec_version") == false) goto L107;
        r1 = 1;
        goto L108
    }

    protected String retrieveValue(Setting setting, String defaultValue) {
        int storage = getStorage(setting);
        String storageKey = getStorageKey(setting);
        if (storage != 0) goto L7;
        HdmiLogger.debug("Reading '" + storageKey + "' sysprop.", new Object[0]);
        return this.mStorageAdapter.retrieveSystemProperty(storageKey, defaultValue);
    L7:
        if (storage != 1) goto L11;
        HdmiLogger.debug("Reading '" + storageKey + "' global setting.", new Object[0]);
        return this.mStorageAdapter.retrieveGlobalSetting(storageKey, defaultValue);
    L11:
        if (storage != 2) goto L14;
        HdmiLogger.debug("Reading '" + storageKey + "' shared preference.", new Object[0]);
        return this.mStorageAdapter.retrieveSharedPref(storageKey, defaultValue);
    L14:
        return null;
    }

    protected void storeValue(Setting setting, String value) {
        int storage = getStorage(setting);
        String storageKey = getStorageKey(setting);
        if (storage != 0) goto L6;
        HdmiLogger.debug("Setting '" + storageKey + "' sysprop.", new Object[0]);
        this.mStorageAdapter.storeSystemProperty(storageKey, value);
        return;
    L6:
        if (storage != 1) goto L9;
        HdmiLogger.debug("Setting '" + storageKey + "' global setting.", new Object[0]);
        this.mStorageAdapter.storeGlobalSetting(storageKey, value);
        return;
    L9:
        if (storage != 2) goto L14;
        HdmiLogger.debug("Setting '" + storageKey + "' shared pref.", new Object[0]);
        this.mStorageAdapter.storeSharedPref(storageKey, value);
        notifySettingChanged(setting);
        return;
    }

    protected void notifySettingChanged(final Setting setting) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<SettingChangeListener, Executor> listeners = this.mSettingChangeListeners.get(setting);     // Catch: Throwable -> L8
        if (listeners != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<Map.Entry<SettingChangeListener, Executor>> r2 = listeners.entrySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<SettingChangeListener, Executor> entry = r2.next();     // Catch: Throwable -> L8
        final SettingChangeListener listener = entry.getKey();     // Catch: Throwable -> L8
        Executor executor = entry.getValue();     // Catch: Throwable -> L8
        executor.execute(new AnonymousClass1(this, listener, setting));     // Catch: Throwable -> L8
        goto L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void registerChangeListener(String name, SettingChangeListener listener) {
        registerChangeListener(name, listener, ConcurrentUtils.DIRECT_EXECUTOR);
    }

    public void registerChangeListener(String name, SettingChangeListener listener, Executor executor) {
        Setting setting = getSetting(name);
        if (setting == null) goto L24;
        int storage = getStorage(setting);
        if (storage != 1) goto L7;
    L11:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (this.mSettingChangeListeners.containsKey(setting) == true) goto L18;
        this.mSettingChangeListeners.put(setting, new ArrayMap());     // Catch: Throwable -> L16
    L18:
        this.mSettingChangeListeners.get(setting).put(listener, executor);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L7:
        if (storage == 2) goto L11;
        throw new IllegalArgumentException("Change listeners for setting '" + name + "' not supported.");
    L24:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public void removeChangeListener(String name, SettingChangeListener listener) {
        Setting setting = getSetting(name);
        if (setting == null) goto L18;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mSettingChangeListeners.containsKey(setting) == false) goto L13;
        ArrayMap<SettingChangeListener, Executor> listeners = this.mSettingChangeListeners.get(setting);     // Catch: Throwable -> L11
        listeners.remove(listener);     // Catch: Throwable -> L11
        if (listeners.isEmpty() == false) goto L13;
        this.mSettingChangeListeners.remove(setting);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L18:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public List<String> getAllSettings() {
        return new ArrayList(this.mSettings.keySet());
    }

    public List<String> getUserSettings() {
        List<String> settings = new ArrayList();
        Iterator<Setting> r1 = this.mSettings.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Setting setting = r1.next();
        if (setting.getUserConfigurable() == false) goto L4;
        settings.add(setting.getName());
        goto L4
    L9:
        return settings;
    }

    public boolean isStringValueType(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L7;
        return getSetting(name).getValueType().equals(VALUE_TYPE_STRING);
    L7:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public boolean isIntValueType(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L7;
        return getSetting(name).getValueType().equals(VALUE_TYPE_INT);
    L7:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public List<String> getAllowedStringValues(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L14;
        if (setting.getValueType().equals(VALUE_TYPE_STRING) == false) goto L12;
        List<String> allowedValues = new ArrayList();
        Iterator<Value> r2 = setting.getAllowedValues().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Value allowedValue = r2.next();
        allowedValues.add(allowedValue.getStringValue());
        goto L8
    L10:
        return allowedValues;
    L12:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L14:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public List<Integer> getAllowedIntValues(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L14;
        if (setting.getValueType().equals(VALUE_TYPE_INT) == false) goto L12;
        List<Integer> allowedValues = new ArrayList();
        Iterator<Value> r2 = setting.getAllowedValues().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Value allowedValue = r2.next();
        allowedValues.add(allowedValue.getIntValue());
        goto L8
    L10:
        return allowedValues;
    L12:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L14:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public String getDefaultStringValue(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L11;
        if (setting.getValueType().equals(VALUE_TYPE_STRING) == false) goto L9;
        return getSetting(name).getDefaultValue().getStringValue();
    L9:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L11:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public int getDefaultIntValue(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L11;
        if (setting.getValueType().equals(VALUE_TYPE_INT) == false) goto L9;
        return getSetting(name).getDefaultValue().getIntValue().intValue();
    L9:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L11:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public String getStringValue(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L11;
        if (setting.getValueType().equals(VALUE_TYPE_STRING) == false) goto L9;
        HdmiLogger.debug("Getting CEC setting value '" + name + "'.", new Object[0]);
        return retrieveValue(setting, setting.getDefaultValue().getStringValue());
    L9:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L11:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public int getIntValue(String name) {
        Setting setting = getSetting(name);
        if (setting == null) goto L11;
        if (setting.getValueType().equals(VALUE_TYPE_INT) == false) goto L9;
        HdmiLogger.debug("Getting CEC setting value '" + name + "'.", new Object[0]);
        String defaultValue = Integer.toString(setting.getDefaultValue().getIntValue().intValue());
        String value = retrieveValue(setting, defaultValue);
        return Integer.parseInt(value);
    L9:
        throw new IllegalArgumentException("Setting '" + name + "' is not a int-type setting.");
    L11:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public void setStringValue(String name, String value) {
        Setting setting = getSetting(name);
        if (setting == null) goto L19;
        if (setting.getUserConfigurable() == false) goto L17;
        if (setting.getValueType().equals(VALUE_TYPE_STRING) == false) goto L15;
        if (getAllowedStringValues(name).contains(value) == false) goto L13;
        HdmiLogger.debug("Updating CEC setting '" + name + "' to '" + value + "'.", new Object[0]);
        storeValue(setting, value);
        return;
    L13:
        throw new IllegalArgumentException("Invalid CEC setting '" + name + "' value: '" + value + "'.");
    L15:
        throw new IllegalArgumentException("Setting '" + name + "' is not a string-type setting.");
    L17:
        throw new IllegalArgumentException("Updating CEC setting '" + name + "' prohibited.");
    L19:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }

    public void setIntValue(String name, int value) {
        Setting setting = getSetting(name);
        if (setting == null) goto L19;
        if (setting.getUserConfigurable() == false) goto L17;
        if (setting.getValueType().equals(VALUE_TYPE_INT) == false) goto L15;
        if (getAllowedIntValues(name).contains(Integer.valueOf(value)) == false) goto L13;
        HdmiLogger.debug("Updating CEC setting '" + name + "' to '" + value + "'.", new Object[0]);
        storeValue(setting, Integer.toString(value));
        return;
    L13:
        throw new IllegalArgumentException("Invalid CEC setting '" + name + "' value: '" + value + "'.");
    L15:
        throw new IllegalArgumentException("Setting '" + name + "' is not a int-type setting.");
    L17:
        throw new IllegalArgumentException("Updating CEC setting '" + name + "' prohibited.");
    L19:
        throw new IllegalArgumentException("Setting '" + name + "' does not exist.");
    }
}
