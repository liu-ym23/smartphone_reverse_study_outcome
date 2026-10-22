package com.android.server.location.gnss;

import android.R;
import android.content.Context;
import android.os.PersistableBundle;
import android.os.SystemProperties;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.autofill.HintsHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GnssConfiguration {
    private static final String CONFIG_A_GLONASS_POS_PROTOCOL_SELECT = "A_GLONASS_POS_PROTOCOL_SELECT";
    private static final String CONFIG_C2K_HOST = "C2K_HOST";
    private static final String CONFIG_C2K_PORT = "C2K_PORT";
    private static final String CONFIG_ENABLE_ACTIVE_SIM_EMERGENCY_SUPL = "ENABLE_ACTIVE_SIM_EMERGENCY_SUPL";
    private static final String CONFIG_ENABLE_NI_SUPL_MESSAGE_INJECTION_BOOL = "ENABLE_NI_SUPL_MESSAGE_INJECTION_BOOL";
    private static final String CONFIG_ENABLE_PSDS_PERIODIC_DOWNLOAD = "ENABLE_PSDS_PERIODIC_DOWNLOAD";
    private static final String CONFIG_ES_EXTENSION_SEC = "ES_EXTENSION_SEC";
    private static final String CONFIG_GPS_LOCK = "GPS_LOCK";
    static final String CONFIG_LONGTERM_PSDS_SERVER_1 = "LONGTERM_PSDS_SERVER_1";
    static final String CONFIG_LONGTERM_PSDS_SERVER_2 = "LONGTERM_PSDS_SERVER_2";
    static final String CONFIG_LONGTERM_PSDS_SERVER_3 = "LONGTERM_PSDS_SERVER_3";
    private static final String CONFIG_LPP_PROFILE = "LPP_PROFILE";
    static final String CONFIG_NFW_PROXY_APPS = "NFW_PROXY_APPS";
    static final String CONFIG_NORMAL_PSDS_SERVER = "NORMAL_PSDS_SERVER";
    static final String CONFIG_REALTIME_PSDS_SERVER = "REALTIME_PSDS_SERVER";
    private static final String CONFIG_SUPL_ES = "SUPL_ES";
    private static final String CONFIG_SUPL_HOST = "SUPL_HOST";
    private static final String CONFIG_SUPL_MODE = "SUPL_MODE";
    private static final String CONFIG_SUPL_PORT = "SUPL_PORT";
    private static final String CONFIG_SUPL_VER = "SUPL_VER";
    private static final String CONFIG_USE_EMERGENCY_PDN_FOR_EMERGENCY_SUPL = "USE_EMERGENCY_PDN_FOR_EMERGENCY_SUPL";
    private static final boolean DEBUG = false;
    private static final String DEBUG_PROPERTIES_SYSTEM_FILE = "/etc/gps_debug.conf";
    private static final String DEBUG_PROPERTIES_VENDOR_FILE = "/vendor/etc/gps_debug.conf";
    static final String LPP_PROFILE = "persist.sys.gps.lpp";
    private static final int MAX_EMERGENCY_MODE_EXTENSION_SECONDS = 300;
    private static final String TAG = "GnssConfiguration";
    private final Context mContext;
    private int mEsExtensionSec;
    private final Properties mProperties;

    static class HalInterfaceVersion {
        static final int AIDL_INTERFACE = 3;
        final int mMajor;
        final int mMinor;

        HalInterfaceVersion(int major, int minor) {
            this.mMajor = major;
            this.mMinor = minor;
        }
    }

    interface SetCarrierProperty {
        boolean set(int r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$-vL-F9Cwyt2IAE587_5tF8_Vdkg, reason: not valid java name */
    public static /* synthetic */ boolean m5224$r8$lambda$vLF9Cwyt2IAE587_5tF8_Vdkg(int r0) {
        return native_set_supl_es(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$3fQhh0HIdjq4jMHxYVTiFqO2lhg(int r0) {
        return native_set_lpp_profile(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$DSZqFaGVxIJ_RoOI0GZb0pMXBhg(int r0) {
        return native_set_gps_lock(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$F9k7STpxBfONZ7Aqgxh165D_nWw(int r0) {
        return native_set_gnss_pos_protocol_select(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZLy4bFu8qE3ZjEkSXCo-Pu4l7O0, reason: not valid java name */
    public static /* synthetic */ boolean m5225$r8$lambda$ZLy4bFu8qE3ZjEkSXCoPu4l7O0(int r0) {
        return native_set_supl_mode(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$eXF9XL5ObtAcQauf3xSbZCBReug(int r0) {
        return native_set_supl_version(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$vT_XZFD-4uMu_ePbNOLadVMKlCY, reason: not valid java name */
    public static /* synthetic */ boolean m5226$r8$lambda$vT_XZFD4uMu_ePbNOLadVMKlCY(int r0) {
        return native_set_emergency_supl_pdn(r0);
    }

    private static native HalInterfaceVersion native_get_gnss_configuration_version();

    private static native boolean native_set_emergency_supl_pdn(int r0);

    private static native boolean native_set_es_extension_sec(int r0);

    private static native boolean native_set_gnss_pos_protocol_select(int r0);

    private static native boolean native_set_gps_lock(int r0);

    private static native boolean native_set_lpp_profile(int r0);

    private static native boolean native_set_satellite_blocklist(int[] r0, int[] r1);

    private static native boolean native_set_supl_es(int r0);

    private static native boolean native_set_supl_mode(int r0);

    private static native boolean native_set_supl_version(int r0);

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public GnssConfiguration(Context context) {
        this.mEsExtensionSec = 0;
        this.mContext = context;
        this.mProperties = new Properties();
    }

    Properties getProperties() {
        return this.mProperties;
    }

    public int getEsExtensionSec() {
        return this.mEsExtensionSec;
    }

    String getSuplHost() {
        return this.mProperties.getProperty(CONFIG_SUPL_HOST);
    }

    int getSuplPort(int defaultPort) {
        return getIntConfig(CONFIG_SUPL_PORT, defaultPort);
    }

    String getC2KHost() {
        return this.mProperties.getProperty(CONFIG_C2K_HOST);
    }

    int getC2KPort(int defaultPort) {
        return getIntConfig(CONFIG_C2K_PORT, defaultPort);
    }

    int getSuplMode(int defaultMode) {
        return getIntConfig(CONFIG_SUPL_MODE, defaultMode);
    }

    public int getSuplEs(int defaultSuplEs) {
        return getIntConfig(CONFIG_SUPL_ES, defaultSuplEs);
    }

    String getLppProfile() {
        return this.mProperties.getProperty(CONFIG_LPP_PROFILE);
    }

    List<String> getProxyApps() {
        String proxyAppsStr = this.mProperties.getProperty(CONFIG_NFW_PROXY_APPS);
        if (TextUtils.isEmpty(proxyAppsStr) == true) goto L5;
        String[] proxyAppsArray = proxyAppsStr.trim().split("\\s+");
        if (proxyAppsArray.length != 0) goto L11;
        return Collections.emptyList();
    L11:
        return Arrays.asList(proxyAppsArray);
    L5:
        return Collections.emptyList();
    }

    boolean isPsdsPeriodicDownloadEnabled() {
        return getBooleanConfig(CONFIG_ENABLE_PSDS_PERIODIC_DOWNLOAD, false);
    }

    boolean isActiveSimEmergencySuplEnabled() {
        return getBooleanConfig(CONFIG_ENABLE_ACTIVE_SIM_EMERGENCY_SUPL, false);
    }

    boolean isNiSuplMessageInjectionEnabled() {
        return getBooleanConfig(CONFIG_ENABLE_NI_SUPL_MESSAGE_INJECTION_BOOL, false);
    }

    boolean isLongTermPsdsServerConfigured() {
        if (this.mProperties.getProperty(CONFIG_LONGTERM_PSDS_SERVER_1) == null) goto L5;
    L10:
        return true;
    L5:
        if (this.mProperties.getProperty(CONFIG_LONGTERM_PSDS_SERVER_2) != null) goto L10;
        if (this.mProperties.getProperty(CONFIG_LONGTERM_PSDS_SERVER_3) != null) goto L10;
        return false;
    }

    void setSatelliteBlocklist(int[] constellations, int[] svids) {
        native_set_satellite_blocklist(constellations, svids);
    }

    HalInterfaceVersion getHalInterfaceVersion() {
        return native_get_gnss_configuration_version();
    }

    void reloadGpsProperties() {
        reloadGpsProperties(false, -1);
    }

    void reloadGpsProperties(boolean inEmergency, int activeSubId) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "Reset GPS properties, previous size = " + this.mProperties.size() + ", inEmergency:" + inEmergency + ", activeSubId=" + activeSubId);
    L5:
        loadPropertiesFromCarrierConfig(inEmergency, activeSubId);
        loadPropertiesFromResource(this.mContext, this.mProperties);
        if (isSimAbsent(this.mContext) == false) goto L10;
        String lpp_prof = SystemProperties.get(LPP_PROFILE);
        if (TextUtils.isEmpty(lpp_prof) == true) goto L10;
        this.mProperties.setProperty(CONFIG_LPP_PROFILE, lpp_prof);
    L10:
        loadPropertiesFromGpsDebugConfig(this.mProperties, DEBUG_PROPERTIES_VENDOR_FILE);
        loadPropertiesFromGpsDebugConfig(this.mProperties, DEBUG_PROPERTIES_SYSTEM_FILE);
        this.mEsExtensionSec = getRangeCheckedConfigEsExtensionSec();
        logConfigurations();
        HalInterfaceVersion gnssConfigurationIfaceVersion = getHalInterfaceVersion();
        if (gnssConfigurationIfaceVersion == null) goto L39;
        if (isConfigEsExtensionSecSupported(gnssConfigurationIfaceVersion) == true) goto L15;
    L17:
        Map<String, SetCarrierProperty> map = new HashMap();
        map.put(CONFIG_SUPL_VER, new GnssConfiguration$$ExternalSyntheticLambda0());
        map.put(CONFIG_SUPL_MODE, new GnssConfiguration$$ExternalSyntheticLambda1());
        if (isConfigSuplEsSupported(gnssConfigurationIfaceVersion) == false) goto L20;
        map.put(CONFIG_SUPL_ES, new GnssConfiguration$$ExternalSyntheticLambda2());
    L20:
        map.put(CONFIG_LPP_PROFILE, new GnssConfiguration$$ExternalSyntheticLambda3());
        map.put(CONFIG_A_GLONASS_POS_PROTOCOL_SELECT, new GnssConfiguration$$ExternalSyntheticLambda4());
        map.put(CONFIG_USE_EMERGENCY_PDN_FOR_EMERGENCY_SUPL, new GnssConfiguration$$ExternalSyntheticLambda5());
        if (isConfigGpsLockSupported(gnssConfigurationIfaceVersion) == false) goto L23;
        map.put(CONFIG_GPS_LOCK, new GnssConfiguration$$ExternalSyntheticLambda6());
    L23:
        Iterator<Map.Entry<String, SetCarrierProperty>> r2 = map.entrySet().iterator();
    L25:
        if (r2.hasNext() == false) goto L52;
        Map.Entry<String, SetCarrierProperty> entry = r2.next();
        String propertyName = entry.getKey();
        String propertyValueString = this.mProperties.getProperty(propertyName);
        if (propertyValueString == null) goto L25;
        int propertyValueInt = Integer.decode(propertyValueString).intValue();     // Catch: NumberFormatException -> L32
        boolean result = entry.getValue().set(propertyValueInt);     // Catch: NumberFormatException -> L32
        if (result == true) goto L25;
        Log.e(TAG, "Unable to set " + propertyName);     // Catch: NumberFormatException -> L32
    L35:
        Log.e(TAG, "Unable to parse propertyName: " + propertyValueString);
        goto L25
    L52:
        return;
    L15:
        if (native_set_es_extension_sec(this.mEsExtensionSec) == true) goto L17;
        Log.e(TAG, "Unable to set ES_EXTENSION_SEC: " + this.mEsExtensionSec);
        goto L17
    L39:
        if (DEBUG == false) goto L51;
        Log.d(TAG, "Skipped configuration update because GNSS configuration in GPS HAL is not supported");
        return;
    }

    private void logConfigurations() {
        String r1 = getSuplHost();
        int r2 = getSuplPort(0);
        String r3 = getC2KHost();
        int r4 = getC2KPort(0);
        int r5 = getIntConfig(CONFIG_SUPL_VER, 0);
        int r6 = getSuplMode(0);
        boolean r8 = true;
        if (getSuplEs(0) != 1) goto L5;
        boolean r7 = true;
    L6:
        int r9 = getIntConfig(CONFIG_LPP_PROFILE, 0);
        int r10 = getIntConfig(CONFIG_A_GLONASS_POS_PROTOCOL_SELECT, 0);
        if (getIntConfig(CONFIG_USE_EMERGENCY_PDN_FOR_EMERGENCY_SUPL, 0) == 1) goto L10;
        r8 = false;
    L10:
        FrameworkStatsLog.write(132, r1, r2, r3, r4, r5, r6, r7, r9, r10, r8, getIntConfig(CONFIG_GPS_LOCK, 0), getEsExtensionSec(), this.mProperties.getProperty(CONFIG_NFW_PROXY_APPS));
        return;
    L5:
        r7 = false;
        goto L6
    }

    void loadPropertiesFromCarrierConfig(boolean inEmergency, int activeSubId) {
        CarrierConfigManager configManager = (CarrierConfigManager) this.mContext.getSystemService("carrier_config");
        if (configManager != null) goto L5;
        return;
    L5:
        int subId = SubscriptionManager.getDefaultDataSubscriptionId();
        if (inEmergency == false) goto L10;
        if (activeSubId < 0) goto L10;
        subId = activeSubId;
    L10:
        if (SubscriptionManager.isValidSubscriptionId(subId) == false) goto L12;
        PersistableBundle configs = configManager.getConfigForSubId(subId);
    L14:
        if (configs == null) goto L16;
    L19:
        Iterator<String> r4 = configs.keySet().iterator();
    L21:
        if (r4.hasNext() == false) goto L35;
        String configKey = r4.next();
        if (configKey == null) goto L21;
        if (configKey.startsWith("gps.") == false) goto L21;
        String key = configKey.substring("gps.".length()).toUpperCase(Locale.ROOT);
        Object value = configs.get(configKey);
        if (DEBUG == false) goto L30;
        Log.d(TAG, "Gps config: " + key + " = " + value);
    L30:
        if ((value instanceof String) == true) goto L31;
        if (value == null) goto L21;
        this.mProperties.setProperty(key, value.toString());
        goto L21
    L31:
        this.mProperties.setProperty(key, (String) value);
        goto L21
    L35:
        return;
    L16:
        if (DEBUG == false) goto L18;
        Log.d(TAG, "SIM not ready, use default carrier config.");
    L18:
        configs = CarrierConfigManager.getDefaultConfig();
        goto L19
    L12:
        configs = configManager.getConfig();
        goto L14
    }

    private void loadPropertiesFromGpsDebugConfig(Properties properties, String filePath) {
        File file = new File(filePath);     // Catch: IOException -> L6
        FileInputStream stream = null;
        stream = new FileInputStream(file);     // Catch: Throwable -> L8
        properties.load(stream);     // Catch: Throwable -> L8
        IoUtils.closeQuietly(stream);     // Catch: IOException -> L6
        return;
    L8:
        th = move-exception;
        IoUtils.closeQuietly(stream);     // Catch: IOException -> L6
        throw th;     // Catch: IOException -> L6
    L12:
        if (DEBUG == false) goto L19;
        Log.d(TAG, "Could not open GPS configuration file " + filePath);
        return;
    }

    private void loadPropertiesFromResource(Context context, Properties properties) {
        String[] configValues = context.getResources().getStringArray(R.array.config_mainBuiltInDisplayCutoutSideOverride);
        int r1 = configValues.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        String item = configValues[r3];
        if (DEBUG == false) goto L7;
        Log.d(TAG, "GnssParamsResource: " + item);
    L7:
        int index = item.indexOf("=");
        if (index > 0) goto L10;
    L12:
        Log.w(TAG, "malformed contents: " + item);
    L13:
        r3 = r3 + 1;
        goto L3
    L10:
        if ((index + 1) >= item.length()) goto L12;
        String key = item.substring(0, index);
        String value = item.substring(index + 1);
        properties.setProperty(key.trim().toUpperCase(Locale.ROOT), value);
        goto L13
    }

    private int getRangeCheckedConfigEsExtensionSec() {
        int emergencyExtensionSeconds = getIntConfig(CONFIG_ES_EXTENSION_SEC, 0);
        if (emergencyExtensionSeconds <= 300) goto L5;
        Log.w(TAG, "ES_EXTENSION_SEC: " + emergencyExtensionSeconds + " too high, reset to 300");
        return 300;
    L5:
        if (emergencyExtensionSeconds >= 0) goto L9;
        Log.w(TAG, "ES_EXTENSION_SEC: " + emergencyExtensionSeconds + " is negative, reset to zero.");
        return 0;
    L9:
        return emergencyExtensionSeconds;
    }

    private int getIntConfig(String configParameter, int defaultValue) {
        String valueString = this.mProperties.getProperty(configParameter);
        if (TextUtils.isEmpty(valueString) == false) goto L10;
        return defaultValue;
    L10:
        return Integer.decode(valueString).intValue();
    L8:
        Log.e(TAG, "Unable to parse config parameter " + configParameter + " value: " + valueString + ". Using default value: " + defaultValue);
        return defaultValue;
    }

    private boolean getBooleanConfig(String configParameter, boolean defaultValue) {
        String valueString = this.mProperties.getProperty(configParameter);
        if (TextUtils.isEmpty(valueString) == false) goto L6;
        return defaultValue;
    L6:
        return Boolean.parseBoolean(valueString);
    }

    private static boolean isConfigEsExtensionSecSupported(HalInterfaceVersion gnssConfiguartionIfaceVersion) {
        if (gnssConfiguartionIfaceVersion.mMajor < 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isConfigSuplEsSupported(HalInterfaceVersion gnssConfiguartionIfaceVersion) {
        if (gnssConfiguartionIfaceVersion.mMajor >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isConfigGpsLockSupported(HalInterfaceVersion gnssConfiguartionIfaceVersion) {
        if (gnssConfiguartionIfaceVersion.mMajor >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isSimAbsent(Context context) {
        TelephonyManager phone = (TelephonyManager) context.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        if (phone.getSimState() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
