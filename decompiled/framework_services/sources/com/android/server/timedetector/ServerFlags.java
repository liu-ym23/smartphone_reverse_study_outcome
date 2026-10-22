package com.android.server.timedetector;

import android.content.Context;
import android.provider.DeviceConfig;
import android.util.ArrayMap;
import com.android.server.timezonedetector.StateChangeListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ServerFlags {
    public static final String KEY_ENHANCED_METRICS_COLLECTION_ENABLED = "enhanced_metrics_collection_enabled";
    public static final String KEY_LOCATION_TIME_ZONE_DETECTION_FEATURE_SUPPORTED = "location_time_zone_detection_feature_supported";
    public static final String KEY_LOCATION_TIME_ZONE_DETECTION_RUN_IN_BACKGROUND_ENABLED = "location_time_zone_detection_run_in_background_enabled";
    public static final String KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_DEFAULT = "location_time_zone_detection_setting_enabled_default";
    public static final String KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_OVERRIDE = "location_time_zone_detection_setting_enabled_override";
    public static final String KEY_LOCATION_TIME_ZONE_DETECTION_UNCERTAINTY_DELAY_MILLIS = "location_time_zone_detection_uncertainty_delay_millis";
    public static final String KEY_LTZP_EVENT_FILTERING_AGE_THRESHOLD_MILLIS = "ltzp_event_filtering_age_threshold_millis";
    public static final String KEY_LTZP_INITIALIZATION_TIMEOUT_FUZZ_MILLIS = "ltzp_init_timeout_fuzz_millis";
    public static final String KEY_LTZP_INITIALIZATION_TIMEOUT_MILLIS = "ltzp_init_timeout_millis";
    public static final String KEY_PRIMARY_LTZP_MODE_OVERRIDE = "primary_location_time_zone_provider_mode_override";
    public static final String KEY_SECONDARY_LTZP_MODE_OVERRIDE = "secondary_location_time_zone_provider_mode_override";
    public static final String KEY_TIME_DETECTOR_LOWER_BOUND_MILLIS_OVERRIDE = "time_detector_lower_bound_millis_override";
    public static final String KEY_TIME_DETECTOR_ORIGIN_PRIORITIES_OVERRIDE = "time_detector_origin_priorities_override";
    public static final String KEY_TIME_ZONE_DETECTOR_AUTO_DETECTION_ENABLED_DEFAULT = "time_zone_detector_auto_detection_enabled_default";
    public static final String KEY_TIME_ZONE_DETECTOR_TELEPHONY_FALLBACK_SUPPORTED = "time_zone_detector_telephony_fallback_supported";
    public static final String KEY_TIME_ZONE_MANUAL_CHANGE_TRACKING_SUPPORTED = "time_zone_manual_change_tracking_supported";
    public static final String KEY_TIME_ZONE_NOTIFICATIONS_ENABLED_DEFAULT = "time_zone_notifications_enabled_default";
    public static final String KEY_TIME_ZONE_NOTIFICATIONS_SUPPORTED = "time_zone_notifications_supported";
    public static final String KEY_TIME_ZONE_NOTIFICATIONS_TRACKING_SUPPORTED = "time_zone_notifications_tracking_supported";
    private static final Optional<Boolean> OPTIONAL_FALSE = null;
    private static final Optional<Boolean> OPTIONAL_TRUE = null;
    private static final Object SLOCK = null;
    private static ServerFlags sInstance;
    private final ArrayMap<StateChangeListener, HashSet<String>> mListeners;

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface DeviceConfigKey {
    }

    public static /* synthetic */ void $r8$lambda$51NkVFa7jyQxEfAmpAEeHsOYfYQ(ServerFlags r0, DeviceConfig.Properties r1) {
        r0.handlePropertiesChanged(r1);
    }

    static {
        OPTIONAL_TRUE = Optional.of(true);
        OPTIONAL_FALSE = Optional.of(false);
        SLOCK = new Object();
    }

    private ServerFlags(Context context) {
        this.mListeners = new ArrayMap();
        DeviceConfig.addOnPropertiesChangedListener("system_time", context.getMainExecutor(), new ServerFlags$$ExternalSyntheticLambda0(this));
    }

    public static ServerFlags getInstance(Context context) {
        Object r0 = SLOCK;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ServerFlags(context);     // Catch: Throwable -> L7
    L9:
        ServerFlags r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    private void handlePropertiesChanged(DeviceConfig.Properties properties) {
        ArrayMap<StateChangeListener, HashSet<String>> r0 = this.mListeners;
        monitor-enter(r0);
        List<StateChangeListener> listenersToNotify = new ArrayList(this.mListeners.size());     // Catch: Throwable -> L10
        Iterator<Map.Entry<StateChangeListener, HashSet<String>>> r2 = this.mListeners.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<StateChangeListener, HashSet<String>> listenerEntry = r2.next();     // Catch: Throwable -> L10
        HashSet<String> monitoredKeys = listenerEntry.getValue();     // Catch: Throwable -> L10
        Iterable<String> modifiedKeys = properties.getKeyset();     // Catch: Throwable -> L10
        if (containsAny(monitoredKeys, modifiedKeys) == false) goto L6;
        listenersToNotify.add(listenerEntry.getKey());     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        Iterator<StateChangeListener> r1 = listenersToNotify.iterator();
    L16:
        if (r1.hasNext() == false) goto L18;
        StateChangeListener listener = r1.next();
        listener.onChange();
        goto L16
    L18:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static boolean containsAny(Set<String> haystack, Iterable<String> needles) {
        Iterator<String> r0 = needles.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String needle = r0.next();
        if (haystack.contains(needle) == false) goto L4;
        return true;
    L10:
        return false;
    }

    public void addListener(StateChangeListener listener, Set<String> keys) {
        listener.getClass();
        keys.getClass();
        HashSet<String> keysCopy = new HashSet(keys);
        ArrayMap<StateChangeListener, HashSet<String>> r1 = this.mListeners;
        monitor-enter(r1);
        this.mListeners.put(listener, keysCopy);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Optional<String> getOptionalString(String key) {
        String value = DeviceConfig.getProperty("system_time", key);
        return Optional.ofNullable(value);
    }

    public Optional<String[]> getOptionalStringArray(String key) {
        Optional<String> optionalString = getOptionalString(key);
        if (optionalString.isPresent() == false) goto L5;
        String value = optionalString.get();
        if ("_[]_".equals(value) == false) goto L11;
        return Optional.of(new String[0]);
    L11:
        return Optional.of(value.split(","));
    L5:
        return Optional.empty();
    }

    public Optional<Instant> getOptionalInstant(String key) {
        String value = DeviceConfig.getProperty("system_time", key);
        if (value == null) goto L5;
        long millis = Long.parseLong(value);     // Catch: Throwable -> L8
        return Optional.of(Instant.ofEpochMilli(millis));
    L10:
        return Optional.empty();
    L5:
        return Optional.empty();
    }

    public Optional<Boolean> getOptionalBoolean(String key) {
        String value = DeviceConfig.getProperty("system_time", key);
        return parseOptionalBoolean(value);
    }

    private static Optional<Boolean> parseOptionalBoolean(String value) {
        if (value != null) goto L6;
        return Optional.empty();
    L6:
        if (Boolean.parseBoolean(value) == false) goto L9;
        return OPTIONAL_TRUE;
    L9:
        return OPTIONAL_FALSE;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return DeviceConfig.getBoolean("system_time", key, defaultValue);
    }

    public Duration getDurationFromMillis(String key, Duration defaultValue) {
        long deviceConfigValue = DeviceConfig.getLong("system_time", key, -1);
        if (deviceConfigValue >= 0) goto L6;
        return defaultValue;
    L6:
        return Duration.ofMillis(deviceConfigValue);
    }
}
