package com.android.server.am;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.android.server.slice.SliceClientPermissions;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class SettingsToPropertiesMapper {
    private static final String GLOBAL_SETTINGS_CATEGORY = "global_settings";
    public static final String NAMESPACE_LOCAL_OVERRIDES = "device_config_overrides";
    public static final String NAMESPACE_REBOOT_STAGING = "staged";
    public static final String NAMESPACE_REBOOT_STAGING_DELIMITER = "*";
    private static final String NAMESPACE_TETHERING_U_OR_LATER_NATIVE = "tethering_u_or_later_native";
    private static final String RESET_PERFORMED_PROPERTY = "device_config.reset_performed";
    private static final String RESET_RECORD_FILE_PATH = "/data/server_configurable_flags/reset_flags";
    private static final String SYSTEM_PROPERTY_INVALID_SUBSTRING = "..";
    private static final int SYSTEM_PROPERTY_MAX_LENGTH = 92;
    private static final String SYSTEM_PROPERTY_PREFIX = "persist.device_config.";
    private static final String SYSTEM_PROPERTY_VALID_CHARACTERS_REGEX = "^[\\w\\.\\-@:]*$";
    private static final String TAG = "SettingsToPropertiesMapper";
    static final String[] sDeviceConfigAconfigScopes = null;
    static final String[] sDeviceConfigScopes = null;
    static final String[] sGlobalSettings = null;
    private final ContentResolver mContentResolver;
    private final String[] mDeviceConfigScopes;
    private final String[] mGlobalSettings;

    public static /* synthetic */ void $r8$lambda$EgBV8Dz39zCT3L1Nko75WeB64pU(SettingsToPropertiesMapper r0, DeviceConfig.Properties r1) {
        r0.lambda$updatePropertiesFromSettings$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$U8GR0ipUE8X3hDRtGmnQloaxLkU(DeviceConfig.Properties r0) {
        lambda$updatePropertiesFromSettings$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$xaooDt4T3agG1Hk5_pT9j0XnxEM(DeviceConfig.Properties r0) {
        lambda$updatePropertiesFromSettings$1(r0);
    }

    static {
        sGlobalSettings = new String[]{"native_flags_health_check_enabled"};
        sDeviceConfigScopes = new String[]{"activity_manager_native_boot", "camera_native", "configuration", "connectivity", "edgetpu_native", "input_native_boot", "intelligence_content_suggestions", "lmkd_native", "media_native", "mglru_native", "mmd_native", "netd_native", "nnapi_native", "profcollect_native_boot", "remote_key_provisioning_native", "runtime_native", "runtime_native_boot", "statsd_native", "statsd_native_boot", "storage_native_boot", "surface_flinger_native_boot", "swcodec_native", "vendor_system_native", "vendor_system_native_boot", "virtualization_framework_native", "window_manager_native_boot", "memory_safety_native_boot", "memory_safety_native", "hdmi_control", NAMESPACE_TETHERING_U_OR_LATER_NATIVE};
        sDeviceConfigAconfigScopes = new String[]{"tv_os", "aaos_carframework_triage", "aaos_performance_triage", "aaos_input_triage", "aaos_user_triage", "aaos_window_triage", "aaos_audio_triage", "aaos_power_triage", "aaos_storage_triage", "aaos_sdv", "aaos_vac_triage", "accessibility", "android_core_networking", "android_health_services", "android_sdk", "android_kernel", "aoc", "app_widgets", "arc_next", "art_cloud", "art_mainline", "art_performance", "attack_tools", "automotive_cast", "avic", "desktop_firmware", "biometrics", "biometrics_framework", "biometrics_integration", "bluetooth", "brownout_mitigation_audio", "brownout_mitigation_modem", "build", "camera_hal", "camera_platform", "car_framework", "car_perception", "car_security", "car_telemetry", "codec_fwk", "companion", "com_android_adbd", "content_protection", "context_hub", "core_experiments_team_internal", "core_graphics", "core_libraries", "crumpet", "dck_framework", "desktop_apps", "desktop_audio", "desktop_better_together", "desktop_bsp", "desktop_camera", "desktop_connectivity", "desktop_dev_experience", "desktop_display", "desktop_commercial", "desktop_firmware", "desktop_graphics", "desktop_hwsec", "desktop_input", "desktop_kernel", "desktop_ml", "desktop_networking", "desktop_serviceability", "desktop_oobe", "desktop_peripherals", "desktop_personalization", "desktop_pnp", "desktop_privacy", "desktop_release", "desktop_security", "desktop_stats", "desktop_sysui", "desktop_users_and_accounts", "desktop_video", "desktop_wifi", "devoptions_settings", "game", "gpu", "haptics", "hardware_backed_security_mainline", "input", "incremental", "llvm_and_toolchains", "lse_desktop_experience", "machine_learning", "mainline_modularization", "mainline_sdk", "make_pixel_haptics", "media_audio", "media_drm", "media_projection", "media_reliability", "media_solutions", "media_tv", "microxr", "nearby", "nfc", "pdf_viewer", "perfetto", "pixel_audio_android", "pixel_biometrics_face", "pixel_bluetooth", "pixel_connectivity_gps", "pixel_continuity", "pixel_display", "pixel_fingerprint", "pixel_gsc", "pixel_perf", "pixel_sensai", "pixel_sensors", "pixel_state_server", "pixel_system_sw_video", "pixel_video_sw", "pixel_vpn", "pixel_watch", "pixel_watch_debug_trace", "pixel_watch_watchfaces", "pixel_wifi", "platform_compat", "platform_security", "pmw", "power", "preload_safety", "printing", "privacy_infra_policy", "psap_ai", "ravenwood", "resource_manager", "responsible_apis", "rust", "safety_center", "sensors", "spoon", "stability", "statsd", "system_performance", "system_sw_battery", "system_sw_touch", "system_sw_usb", "test_suites", "text", "threadnetwork", "treble", "tv_os_media", "tv_system_ui", "usb", "vibrator", "virtual_devices", "virtualization", "wallet_integration", "wear_calling_messaging", "wear_connectivity", "wear_esim_carriers", "wear_frameworks", "wear_media", "wear_offload", "wear_security", "wear_system_health", "wear_systems", "wear_sysui", "wear_system_managed_surfaces", "wear_watchfaces", "web_apps_on_chromeos_and_android", "window_surfaces", "windowing_frontend", "xr"};
    }

    protected SettingsToPropertiesMapper(ContentResolver contentResolver, String[] globalSettings, String[] deviceConfigScopes, String[] deviceConfigAconfigScopes) {
        this.mContentResolver = contentResolver;
        this.mGlobalSettings = globalSettings;
        this.mDeviceConfigScopes = deviceConfigScopes;
    }

    void updatePropertiesFromSettings() {
        String[] r0 = this.mGlobalSettings;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L14;
        final String globalSetting = r0[r3];
        Uri settingUri = Settings.Global.getUriFor(globalSetting);
        final String propName = makePropertyName(GLOBAL_SETTINGS_CATEGORY, globalSetting);
        if (settingUri != null) goto L7;
        logErr("setting uri is null for globalSetting " + globalSetting);
    L13:
        r3 = r3 + 1;
        goto L3
    L7:
        if (propName != null) goto L9;
        logErr("invalid prop name for globalSetting " + globalSetting);
        goto L13
    L9:
        final Handler r8 = null;
        ContentObserver co2 = new AnonymousClass1(this, r8, globalSetting, propName);
        if (isNativeFlagsResetPerformed() == true) goto L12;
        updatePropertyFromSetting(globalSetting, propName);
    L12:
        this.mContentResolver.registerContentObserver(settingUri, false, co2);
        goto L13
    L14:
        String[] r4 = this.mDeviceConfigScopes;
        int r5 = r4.length;
    L15:
        if (r2 >= r5) goto L17;
        String deviceConfigScope = r4[r2];
        DeviceConfig.addOnPropertiesChangedListener(deviceConfigScope, AsyncTask.THREAD_POOL_EXECUTOR, new SettingsToPropertiesMapper$$ExternalSyntheticLambda0(this));
        r2 = r2 + 1;
        goto L15
    L17:
        DeviceConfig.addOnPropertiesChangedListener(NAMESPACE_REBOOT_STAGING, Executors.newSingleThreadScheduledExecutor(), new SettingsToPropertiesMapper$$ExternalSyntheticLambda1());
        DeviceConfig.addOnPropertiesChangedListener(NAMESPACE_LOCAL_OVERRIDES, AsyncTask.THREAD_POOL_EXECUTOR, new SettingsToPropertiesMapper$$ExternalSyntheticLambda2());
    }

    private /* synthetic */ void lambda$updatePropertiesFromSettings$0(DeviceConfig.Properties properties) {
        String scope = properties.getNamespace();
        Iterator r1 = properties.getKeyset().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        String key = (String) r1.next();
        String propertyName = makePropertyName(scope, key);
        if (propertyName == null) goto L7;
        setProperty(propertyName, properties.getString(key, null));
        goto L4
    L7:
        logErr("unable to construct system property for " + scope + SliceClientPermissions.SliceAuthority.DELIMITER + key);
        return;
    }

    private static /* synthetic */ void lambda$updatePropertiesFromSettings$1(DeviceConfig.Properties properties) {
        stageFlagsInNewStorage(properties);
    }

    private static /* synthetic */ void lambda$updatePropertiesFromSettings$2(DeviceConfig.Properties properties) {
        setLocalOverridesInNewStorage(properties);
    }

    static void sendAconfigdRequests(ProtoOutputStream requests) {
        ProtoInputStream returns = sendAconfigdRequests("aconfigd_system", requests);
        parseAndLogAconfigdReturn(returns);     // Catch: IOException -> L5
    L7:
        ProtoInputStream returns2 = sendAconfigdRequests("aconfigd_mainline", requests);
        parseAndLogAconfigdReturn(returns2);     // Catch: IOException -> L10
        return;
    L10:
        ioe = move-exception;
        logErr("failed to parse aconfigd return", ioe);
        return;
    L5:
        ioe = move-exception;
        logErr("failed to parse aconfigd return", ioe);
        goto L7
    }

    static ProtoInputStream sendAconfigdRequests(String socketName, ProtoOutputStream requests) {
        LocalSocket client = new LocalSocket();
        client.connect(new LocalSocketAddress(socketName, LocalSocketAddress.Namespace.RESERVED));     // Catch: IOException -> L18
        Slog.d(TAG, "connected to " + socketName + " socket");     // Catch: IOException -> L18
        DataInputStream inputStream = new DataInputStream(client.getInputStream());     // Catch: IOException -> L15
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());     // Catch: IOException -> L15
        byte[] requests_bytes = requests.getBytes();     // Catch: IOException -> L12
        outputStream.writeInt(requests_bytes.length);     // Catch: IOException -> L12
        outputStream.write(requests_bytes, 0, requests_bytes.length);     // Catch: IOException -> L12
        Slog.d(TAG, "flag override requests sent to " + socketName);     // Catch: IOException -> L12
        int num_bytes = inputStream.readInt();     // Catch: IOException -> L9
        ProtoInputStream returns = new ProtoInputStream(inputStream);     // Catch: IOException -> L9
        Slog.d(TAG, "received " + num_bytes + " bytes back from " + socketName);     // Catch: IOException -> L9
        return returns;
    L9:
        ioe = move-exception;
        logErr("failed to read requests return from " + socketName, ioe);
        return null;
    L12:
        ioe = move-exception;
        logErr("failed to send requests to " + socketName, ioe);
        return null;
    L15:
        ioe = move-exception;
        logErr("failed to get local socket iostreams", ioe);
        return null;
    L18:
        ioe = move-exception;
        logErr("failed to connect to " + socketName + " socket", ioe);
        return null;
    }

    static void writeFlagOverrideRequest(ProtoOutputStream proto, String packageName, String flagName, String flagValue, boolean isLocal) {
        long msgsToken = proto.start(2246267895809L);
        long msgToken = proto.start(1146756268034L);
        proto.write(1138166333441L, packageName);
        proto.write(1138166333442L, flagName);
        proto.write(1138166333443L, flagValue);
        if (isLocal == false) goto L5;
        int r5 = 2;
    L6:
        proto.write(1159641169924L, r5);
        proto.end(msgToken);
        proto.end(msgsToken);
        return;
    L5:
        r5 = 3;
        goto L6
    }

    public static void writeFlagOverrideRemovalRequest(ProtoOutputStream proto, String packageName, String flagName, boolean immediate) {
        long msgsToken = proto.start(2246267895809L);
        long msgToken = proto.start(1146756268037L);
        proto.write(1138166333442L, packageName);
        proto.write(1138166333443L, flagName);
        proto.write(1133871366145L, false);
        if (immediate == false) goto L5;
        int r4 = 1;
    L6:
        proto.write(1159641169924L, r4);
        proto.end(msgToken);
        proto.end(msgsToken);
        return;
    L5:
        r4 = 2;
        goto L6
    }

    static void parseAndLogAconfigdReturn(ProtoInputStream proto) throws IOException {
    L3:
        switch(proto.nextField()) {
            case -1: goto L12;
            case 0: goto L4;
            case 1: goto L5;
            default: goto L4;
        };
    L5:
        long msgsToken = proto.start(2246267895809L);
        switch(proto.nextField()) {
            case -1: goto L11;
            case 2: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        logErr("invalid message type, expecting only flag override return or error message");
        goto L11
    L8:
        String errmsg = proto.readString(1138166333448L);
        Slog.d(TAG, "override request failed: " + errmsg);
        goto L11
    L9:
        Slog.d(TAG, "successfully handled override requests");
        long msgToken = proto.start(1146756268034L);
        proto.end(msgToken);
    L11:
        proto.end(msgsToken);
        goto L3
    L12:
        return;
    L4:
        logErr("invalid message type, expect storage return message");
        goto L3
    }

    public static void setLocalOverridesInNewStorage(DeviceConfig.Properties props) {
        int num_requests = 0;
        ProtoOutputStream requests = new ProtoOutputStream();
        Iterator r2 = props.getKeyset().iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        String flagName = (String) r2.next();
        String flagValue = props.getString(flagName, null);
        if (flagName == null) goto L4;
        int idx = flagName.indexOf(":");
        if (idx == (-1)) goto L22;
        if (idx == (flagName.length() - 1)) goto L22;
        if (idx == 0) goto L22;
        flagName.substring(0, idx);
        String fullFlagName = flagName.substring(idx + 1);
        int idx2 = fullFlagName.lastIndexOf(".");
        if (idx2 == (-1)) goto L16;
        String packageName = fullFlagName.substring(0, idx2);
        String realFlagName = fullFlagName.substring(idx2 + 1);
        if (flagValue != null) goto L20;
        writeFlagOverrideRemovalRequest(requests, packageName, realFlagName, true);
    L21:
        num_requests = num_requests + 1;
        goto L4
    L20:
        writeFlagOverrideRequest(requests, packageName, realFlagName, flagValue, true);
        goto L21
    L16:
        logErr("invalid flag name: " + fullFlagName);
    L22:
        logErr("invalid local flag override: " + flagName);
        goto L4
    L23:
        if (num_requests != 0) goto L25;
        return;
    L25:
        sendAconfigdRequests(requests);
    }

    public static SettingsToPropertiesMapper start(ContentResolver contentResolver) {
        SettingsToPropertiesMapper mapper = new SettingsToPropertiesMapper(contentResolver, sGlobalSettings, sDeviceConfigScopes, sDeviceConfigAconfigScopes);
        mapper.updatePropertiesFromSettings();
        return mapper;
    }

    public static boolean isNativeFlagsResetPerformed() {
        String value = SystemProperties.get(RESET_PERFORMED_PROPERTY);
        return "true".equals(value);
    }

    public static String[] getResetNativeCategories() {
        if (isNativeFlagsResetPerformed() == false) goto L5;
        String content = getResetFlagsFileContent();
        if (TextUtils.isEmpty(content) == true) goto L9;
        String[] property_names = content.split(";");
        HashSet<String> categories = new HashSet();
        int r4 = property_names.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L18;
        String property_name = property_names[r5];
        String[] segments = property_name.split("\\.");
        if (segments.length >= 3) goto L15;
        logErr("failed to extract category name from property " + property_name);
    L16:
        r5 = r5 + 1;
        goto L11
    L15:
        categories.add(segments[2]);
        goto L16
    L18:
        return (String[]) categories.toArray(new String[0]);
    L9:
        return new String[0];
    L5:
        return new String[0];
    }

    static String makePropertyName(String categoryName, String flagName) {
        String propertyName = SYSTEM_PROPERTY_PREFIX + categoryName + "." + flagName;
        if (propertyName.matches(SYSTEM_PROPERTY_VALID_CHARACTERS_REGEX) == true) goto L5;
        return null;
    L5:
        if (propertyName.contains(SYSTEM_PROPERTY_INVALID_SUBSTRING) == true) goto L10;
        return propertyName;
    L10:
        return null;
    }

    static void stageFlagsInNewStorage(DeviceConfig.Properties props) {
        int num_requests = 0;
        ProtoOutputStream requests = new ProtoOutputStream();
        Iterator r2 = props.getKeyset().iterator();
    L4:
        if (r2.hasNext() == false) goto L20;
        String flagName = (String) r2.next();
        String flagValue = props.getString(flagName, null);
        if (flagName == null) goto L4;
        if (flagValue == null) goto L4;
        int idx = flagName.indexOf(NAMESPACE_REBOOT_STAGING_DELIMITER);
        if (idx == (-1)) goto L19;
        if (idx == (flagName.length() - 1)) goto L19;
        if (idx == 0) goto L19;
        flagName.substring(0, idx);
        String fullFlagName = flagName.substring(idx + 1);
        int idx2 = fullFlagName.lastIndexOf(".");
        if (idx2 == (-1)) goto L17;
        String packageName = fullFlagName.substring(0, idx2);
        String realFlagName = fullFlagName.substring(idx2 + 1);
        writeFlagOverrideRequest(requests, packageName, realFlagName, flagValue, false);
        num_requests = num_requests + 1;
        goto L4
    L17:
        logErr("invalid flag name: " + fullFlagName);
    L19:
        logErr("invalid local flag override: " + flagName);
        goto L4
    L20:
        if (num_requests != 0) goto L22;
        return;
    L22:
        sendAconfigdRequests(requests);
    }

    private void setProperty(String key, String value) {
        if (value != null) goto L8;
        if (TextUtils.isEmpty(SystemProperties.get(key)) == false) goto L6;
        return;
    L6:
        value = "";
    L16:
        SystemProperties.set(key, value);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        logErr("Unable to set property " + key + " value '" + value + "'", e);
        return;
    L8:
        if (value.length() <= 92) goto L16;
        logErr("key=" + key + " value=" + value + " exceeds system property max length.");
    }

    private static void logErr(String msg, Exception e) {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        Slog.wtf(TAG, msg, e);
        return;
    L5:
        Slog.e(TAG, msg, e);
    }

    private static void logErr(String msg) {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        Slog.wtf(TAG, msg);
        return;
    L5:
        Slog.e(TAG, msg);
    }

    static String getResetFlagsFileContent() {
        String content = null;
        File reset_flag_file = new File(RESET_RECORD_FILE_PATH);     // Catch: IOException -> L5
        BufferedReader br = new BufferedReader(new FileReader(reset_flag_file));     // Catch: IOException -> L5
        content = br.readLine();     // Catch: IOException -> L5
        br.close();     // Catch: IOException -> L5
        return content;
    L5:
        ioe = move-exception;
        logErr("failed to read file /data/server_configurable_flags/reset_flags", ioe);
        return content;
    }

    void updatePropertyFromSetting(String settingName, String propName) {
        String settingValue = Settings.Global.getString(this.mContentResolver, settingName);
        setProperty(propName, settingValue);
    }
}
