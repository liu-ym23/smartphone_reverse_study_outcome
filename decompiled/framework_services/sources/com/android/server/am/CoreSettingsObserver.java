package com.android.server.am;

import android.R;
import android.app.ActivityThread;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class CoreSettingsObserver extends ContentObserver {
    private static final String LOG_TAG = null;
    private static volatile boolean sDeviceConfigContextEntriesLoaded;
    static final List<DeviceConfigEntry> sDeviceConfigEntries = null;
    static final Map<String, Class<?>> sGlobalSettingToTypeMap = null;
    static final Map<String, Class<?>> sSecureSettingToTypeMap = null;
    static final Map<String, Class<?>> sSystemSettingToTypeMap = null;
    final ActivityManagerService mActivityManagerService;
    final Bundle mCoreSettings;
    private IExtCoreSettingsObserver mExt;

    private static class DeviceConfigEntry<T> {
        String coreSettingKey;
        T defaultValue;
        String flag;
        String namespace;
        Class<T> type;

        DeviceConfigEntry(String namespace, String flag, String coreSettingKey, Class<T> type, T defaultValue) {
            this.namespace = namespace;
            this.flag = flag;
            this.coreSettingKey = coreSettingKey;
            this.type = type;
            defaultValue.getClass();
            this.defaultValue = defaultValue;
        }
    }

    public static /* synthetic */ void $r8$lambda$qJWfpu58dALNvLI4dRF_UJZj2Ks(CoreSettingsObserver r0, DeviceConfig.Properties r1) {
        r0.lambda$beginObserveCoreSettings$0(r1);
    }

    static {
        LOG_TAG = CoreSettingsObserver.class.getSimpleName();
        sSecureSettingToTypeMap = new HashMap();
        sSystemSettingToTypeMap = new HashMap();
        sGlobalSettingToTypeMap = new HashMap();
        sDeviceConfigEntries = new ArrayList();
        sSecureSettingToTypeMap.put("long_press_timeout", Integer.TYPE);
        sSecureSettingToTypeMap.put("multi_press_timeout", Integer.TYPE);
        sSecureSettingToTypeMap.put("key_repeat_timeout", Integer.TYPE);
        sSecureSettingToTypeMap.put("key_repeat_delay", Integer.TYPE);
        sSecureSettingToTypeMap.put("key_repeat_enabled", Integer.TYPE);
        sSecureSettingToTypeMap.put("stylus_pointer_icon_enabled", Integer.TYPE);
        sSystemSettingToTypeMap.put("time_12_24", String.class);
        sGlobalSettingToTypeMap.put("debug_view_attributes", Integer.TYPE);
        sGlobalSettingToTypeMap.put("debug_view_attributes_application_package", String.class);
        sGlobalSettingToTypeMap.put("angle_debug_package", String.class);
        sGlobalSettingToTypeMap.put("angle_gl_driver_all_angle", Integer.TYPE);
        sGlobalSettingToTypeMap.put("angle_gl_driver_selection_pkgs", String.class);
        sGlobalSettingToTypeMap.put("angle_gl_driver_selection_values", String.class);
        sGlobalSettingToTypeMap.put("angle_egl_features", String.class);
        sGlobalSettingToTypeMap.put("show_angle_in_use_dialog_box", String.class);
        sGlobalSettingToTypeMap.put("enable_gpu_debug_layers", Integer.TYPE);
        sGlobalSettingToTypeMap.put("gpu_debug_app", String.class);
        sGlobalSettingToTypeMap.put("gpu_debug_layers", String.class);
        sGlobalSettingToTypeMap.put("gpu_debug_layers_gles", String.class);
        sGlobalSettingToTypeMap.put("gpu_debug_layer_app", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_all_apps", Integer.TYPE);
        sGlobalSettingToTypeMap.put("updatable_driver_production_opt_in_apps", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_prerelease_opt_in_apps", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_production_opt_out_apps", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_production_denylist", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_production_allowlist", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_production_denylists", String.class);
        sGlobalSettingToTypeMap.put("updatable_driver_sphal_libraries", String.class);
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__enable_cursor_drag_from_anywhere", "widget__enable_cursor_drag_from_anywhere", Boolean.TYPE, true));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__min_angle_from_vertical_to_start_cursor_drag", "widget__min_angle_from_vertical_to_start_cursor_drag", Integer.TYPE, 45));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__finger_to_cursor_distance", "widget__finger_to_cursor_distance", Integer.TYPE, -1));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__enable_insertion_handle_gestures", "widget__enable_insertion_handle_gestures", Boolean.TYPE, false));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__insertion_handle_delta_height", "widget__insertion_handle_delta_height", Integer.TYPE, 25));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__insertion_handle_opacity", "widget__insertion_handle_opacity", Integer.TYPE, 50));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__line_slop_ratio", "widget__line_slop_ratio", Float.TYPE, Float.valueOf(0.5f)));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__enable_new_magnifier", "widget__enable_new_magnifier", Boolean.TYPE, false));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__magnifier_zoom_factor", "widget__magnifier_zoom_factor", Float.TYPE, Float.valueOf(1.5f)));
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "CursorControlFeature__magnifier_aspect_ratio", "widget__magnifier_aspect_ratio", Float.TYPE, Float.valueOf(5.5f)));
        sDeviceConfigContextEntriesLoaded = false;
    }

    public CoreSettingsObserver(ActivityManagerService activityManagerService) {
        super(activityManagerService.mHandler);
        this.mCoreSettings = new Bundle();
        this.mExt = (IExtCoreSettingsObserver) ExtImplFactory.getImpl(IExtCoreSettingsObserver.class, new Object[]{this});
        if (sDeviceConfigContextEntriesLoaded == true) goto L15;
        List<DeviceConfigEntry> r0 = sDeviceConfigEntries;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sDeviceConfigContextEntriesLoaded == true) goto L11;
        loadDeviceConfigContextEntries(activityManagerService.mContext);     // Catch: Throwable -> L9
        sDeviceConfigContextEntriesLoaded = true;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    L15:
        this.mActivityManagerService = activityManagerService;
        beginObserveCoreSettings();
        sendCoreSettings();
    }

    private static void loadDeviceConfigContextEntries(Context context) {
        sDeviceConfigEntries.add(new DeviceConfigEntry("widget", "AnalogClockFeature__analog_clock_seconds_hand_fps", "widget__analog_clock_seconds_hand_fps", Integer.TYPE, Integer.valueOf(context.getResources().getInteger(R.integer.config_defaultNightDisplayCustomStartTime))));
    }

    public Bundle getCoreSettingsLocked() {
        return (Bundle) this.mCoreSettings.clone();
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        ActivityManagerService r0 = this.mActivityManagerService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        sendCoreSettings();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void sendCoreSettings() {
        populateSettings(this.mCoreSettings, sSecureSettingToTypeMap);
        populateSettings(this.mCoreSettings, sSystemSettingToTypeMap);
        populateSettings(this.mCoreSettings, sGlobalSettingToTypeMap);
        populateSettingsFromDeviceConfig();
        this.mActivityManagerService.onCoreSettingsChange(this.mCoreSettings);
    }

    private void beginObserveCoreSettings() {
        Iterator<String> r0 = sSecureSettingToTypeMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String setting = r0.next();
        Uri uri = Settings.Secure.getUriFor(setting);
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(uri, false, this);
        goto L4
    L6:
        Iterator<String> r1 = sSystemSettingToTypeMap.keySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        String setting2 = r1.next();
        Uri uri2 = Settings.System.getUriFor(setting2);
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(uri2, false, this);
        goto L8
    L10:
        Iterator<String> r2 = sGlobalSettingToTypeMap.keySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        String setting3 = r2.next();
        Uri uri3 = Settings.Global.getUriFor(setting3);
        this.mActivityManagerService.mContext.getContentResolver().registerContentObserver(uri3, false, this);
        goto L12
    L14:
        HashSet<String> deviceConfigNamespaces = new HashSet();
        Iterator<DeviceConfigEntry> r3 = sDeviceConfigEntries.iterator();
    L16:
        if (r3.hasNext() == false) goto L21;
        DeviceConfigEntry entry = r3.next();
        if (deviceConfigNamespaces.contains(entry.namespace) == true) goto L16;
        DeviceConfig.addOnPropertiesChangedListener(entry.namespace, ActivityThread.currentApplication().getMainExecutor(), new CoreSettingsObserver$$ExternalSyntheticLambda0(this));
        deviceConfigNamespaces.add(entry.namespace);
        goto L16
    }

    private /* synthetic */ void lambda$beginObserveCoreSettings$0(DeviceConfig.Properties prop) {
        onChange(false);
    }

    void populateSettings(Bundle snapshot, Map<String, Class<?>> map) {
        Context context = this.mActivityManagerService.mContext;
        ContentResolver cr = context.getContentResolver();
        Iterator<Map.Entry<String, Class<?>>> r2 = map.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L27;
        Map.Entry<String, Class<?>> entry = r2.next();
        String setting = entry.getKey();
        if (map != sSecureSettingToTypeMap) goto L9;
        String value = Settings.Secure.getStringForUser(cr, setting, cr.getUserId());
    L12:
        if (value == null) goto L13;
        Class<?> type = entry.getValue();
        if (type == String.class) goto L16;
        if (type == Integer.TYPE) goto L19;
        if (type == Float.TYPE) goto L22;
        if (type != Long.TYPE) goto L4;
        snapshot.putLong(setting, Long.parseLong(value));
        goto L4
    L22:
        snapshot.putFloat(setting, Float.parseFloat(value));
        goto L4
    L19:
        snapshot.putInt(setting, Integer.parseInt(value));
        goto L4
    L16:
        snapshot.putString(setting, value);
        goto L4
    L13:
        snapshot.remove(setting);
        goto L4
    L9:
        if (map != sSystemSettingToTypeMap) goto L11;
        value = Settings.System.getStringForUser(cr, setting, cr.getUserId());
        goto L12
    L11:
        value = Settings.Global.getString(cr, setting);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void populateSettingsFromDeviceConfig() {
        Iterator<DeviceConfigEntry> r0 = sDeviceConfigEntries.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        DeviceConfigEntry r1 = r0.next();
        if (r1.type == String.class) goto L7;
        if (r1.type == Integer.TYPE) goto L10;
        if (r1.type == Float.TYPE) goto L13;
        if (r1.type == Long.TYPE) goto L16;
        if (r1.type != Boolean.TYPE) goto L4;
        boolean r2 = ((Boolean) r1.defaultValue).booleanValue();
        this.mCoreSettings.putInt(r1.coreSettingKey, DeviceConfig.getBoolean(r1.namespace, r1.flag, r2) ? 1 : 0);
        goto L4
    L16:
        long r3 = ((Long) r1.defaultValue).longValue();
        this.mCoreSettings.putLong(r1.coreSettingKey, DeviceConfig.getLong(r1.namespace, r1.flag, r3));
        goto L4
    L13:
        float r4 = ((Float) r1.defaultValue).floatValue();
        this.mCoreSettings.putFloat(r1.coreSettingKey, DeviceConfig.getFloat(r1.namespace, r1.flag, r4));
        goto L4
    L10:
        int r5 = ((Integer) r1.defaultValue).intValue();
        this.mCoreSettings.putInt(r1.coreSettingKey, DeviceConfig.getInt(r1.namespace, r1.flag, r5));
        goto L4
    L7:
        String r6 = (String) r1.defaultValue;
        this.mCoreSettings.putString(r1.coreSettingKey, DeviceConfig.getString(r1.namespace, r1.flag, r6));
        goto L4
    }

    public IExtCoreSettingsObserver getExt() {
        return this.mExt;
    }
}
