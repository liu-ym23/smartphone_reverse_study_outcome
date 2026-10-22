package com.android.server.timezonedetector;

import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.app.timezonedetector.TelephonyTimeZoneSuggestion;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class MetricsTimeZoneDetectorState {
    public static final int DETECTION_MODE_GEO = 2;
    public static final int DETECTION_MODE_MANUAL = 1;
    public static final int DETECTION_MODE_TELEPHONY = 3;
    public static final int DETECTION_MODE_UNKNOWN = 0;
    private final ConfigurationInternal mConfigurationInternal;
    private final String mDeviceTimeZoneId;
    private final int mDeviceTimeZoneIdOrdinal;
    private final MetricsTimeZoneSuggestion mLatestGeolocationSuggestion;
    private final MetricsTimeZoneSuggestion mLatestManualSuggestion;
    private final MetricsTimeZoneSuggestion mLatestTelephonySuggestion;

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DetectionMode {
    }

    public static final class MetricsTimeZoneSuggestion {
        private final int[] mZoneIdOrdinals;
        private final String[] mZoneIds;

        private MetricsTimeZoneSuggestion(String[] zoneIds, int[] zoneIdOrdinals) {
            this.mZoneIds = zoneIds;
            this.mZoneIdOrdinals = zoneIdOrdinals;
        }

        static MetricsTimeZoneSuggestion createUncertain() {
            return new MetricsTimeZoneSuggestion(null, null);
        }

        static MetricsTimeZoneSuggestion createCertain(String[] zoneIds, int[] zoneIdOrdinals) {
            return new MetricsTimeZoneSuggestion(zoneIds, zoneIdOrdinals);
        }

        public boolean isCertain() {
            if (this.mZoneIdOrdinals == null) goto L5;
            return true;
        L5:
            return false;
        }

        public int[] getZoneIdOrdinals() {
            return this.mZoneIdOrdinals;
        }

        public String[] getZoneIds() {
            return this.mZoneIds;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L17:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L17;
            MetricsTimeZoneSuggestion that = (MetricsTimeZoneSuggestion) o;
            if (Arrays.equals(this.mZoneIdOrdinals, that.mZoneIdOrdinals) == false) goto L16;
            if (Arrays.equals(this.mZoneIds, that.mZoneIds) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int result = Arrays.hashCode(this.mZoneIds);
            return (result * 31) + Arrays.hashCode(this.mZoneIdOrdinals);
        }

        public String toString() {
            return "MetricsTimeZoneSuggestion{mZoneIdOrdinals=" + Arrays.toString(this.mZoneIdOrdinals) + ", mZoneIds=" + Arrays.toString(this.mZoneIds) + '}';
        }
    }

    private MetricsTimeZoneDetectorState(ConfigurationInternal configurationInternal, int deviceTimeZoneIdOrdinal, String deviceTimeZoneId, MetricsTimeZoneSuggestion latestManualSuggestion, MetricsTimeZoneSuggestion latestTelephonySuggestion, MetricsTimeZoneSuggestion latestGeolocationSuggestion) {
        configurationInternal.getClass();
        this.mConfigurationInternal = configurationInternal;
        this.mDeviceTimeZoneIdOrdinal = deviceTimeZoneIdOrdinal;
        this.mDeviceTimeZoneId = deviceTimeZoneId;
        this.mLatestManualSuggestion = latestManualSuggestion;
        this.mLatestTelephonySuggestion = latestTelephonySuggestion;
        this.mLatestGeolocationSuggestion = latestGeolocationSuggestion;
    }

    public static MetricsTimeZoneDetectorState create(OrdinalGenerator<String> tzIdOrdinalGenerator, ConfigurationInternal configurationInternal, String deviceTimeZoneId, ManualTimeZoneSuggestion latestManualSuggestion, TelephonyTimeZoneSuggestion latestTelephonySuggestion, LocationAlgorithmEvent latestLocationAlgorithmEvent) {
        boolean includeZoneIds = configurationInternal.isEnhancedMetricsCollectionEnabled();
        if (includeZoneIds == false) goto L5;
        String r1 = deviceTimeZoneId;
    L6:
        String metricDeviceTimeZoneId = r1;
        deviceTimeZoneId.getClass();
        int deviceTimeZoneIdOrdinal = tzIdOrdinalGenerator.ordinal(deviceTimeZoneId);
        MetricsTimeZoneSuggestion latestCanonicalManualSuggestion = createMetricsTimeZoneSuggestion(tzIdOrdinalGenerator, latestManualSuggestion, includeZoneIds);
        MetricsTimeZoneSuggestion latestCanonicalTelephonySuggestion = createMetricsTimeZoneSuggestion(tzIdOrdinalGenerator, latestTelephonySuggestion, includeZoneIds);
        if (latestLocationAlgorithmEvent == null) goto L9;
        GeolocationTimeZoneSuggestion suggestion = latestLocationAlgorithmEvent.getSuggestion();
        MetricsTimeZoneSuggestion latestCanonicalGeolocationSuggestion = createMetricsTimeZoneSuggestion(tzIdOrdinalGenerator, suggestion, includeZoneIds);
        MetricsTimeZoneSuggestion latestCanonicalGeolocationSuggestion2 = latestCanonicalGeolocationSuggestion;
    L11:
        return new MetricsTimeZoneDetectorState(configurationInternal, deviceTimeZoneIdOrdinal, metricDeviceTimeZoneId, latestCanonicalManualSuggestion, latestCanonicalTelephonySuggestion, latestCanonicalGeolocationSuggestion2);
    L9:
        latestCanonicalGeolocationSuggestion2 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public boolean isTelephonyDetectionSupported() {
        return this.mConfigurationInternal.isTelephonyDetectionSupported();
    }

    public boolean isGeoDetectionSupported() {
        return this.mConfigurationInternal.isGeoDetectionSupported();
    }

    public boolean isTelephonyTimeZoneFallbackSupported() {
        return this.mConfigurationInternal.isTelephonyFallbackSupported();
    }

    public boolean getGeoDetectionRunInBackgroundEnabled() {
        return this.mConfigurationInternal.getGeoDetectionRunInBackgroundEnabledSetting();
    }

    public boolean isEnhancedMetricsCollectionEnabled() {
        return this.mConfigurationInternal.isEnhancedMetricsCollectionEnabled();
    }

    public boolean getUserLocationEnabledSetting() {
        return this.mConfigurationInternal.getLocationEnabledSetting();
    }

    public boolean getGeoDetectionEnabledSetting() {
        return this.mConfigurationInternal.getGeoDetectionEnabledSetting();
    }

    public boolean getAutoDetectionEnabledSetting() {
        return this.mConfigurationInternal.getAutoDetectionEnabledSetting();
    }

    public int getDetectionMode() {
        switch(this.mConfigurationInternal.getDetectionMode()) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 3;
    L8:
        return 2;
    L10:
        return 1;
    }

    public int getDeviceTimeZoneIdOrdinal() {
        return this.mDeviceTimeZoneIdOrdinal;
    }

    public String getDeviceTimeZoneId() {
        return this.mDeviceTimeZoneId;
    }

    public MetricsTimeZoneSuggestion getLatestManualSuggestion() {
        return this.mLatestManualSuggestion;
    }

    public MetricsTimeZoneSuggestion getLatestTelephonySuggestion() {
        return this.mLatestTelephonySuggestion;
    }

    public MetricsTimeZoneSuggestion getLatestGeolocationSuggestion() {
        return this.mLatestGeolocationSuggestion;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L25;
        MetricsTimeZoneDetectorState that = (MetricsTimeZoneDetectorState) o;
        if (this.mDeviceTimeZoneIdOrdinal != that.mDeviceTimeZoneIdOrdinal) goto L24;
        if (Objects.equals(this.mDeviceTimeZoneId, that.mDeviceTimeZoneId) == false) goto L24;
        if (this.mConfigurationInternal.equals(that.mConfigurationInternal) == false) goto L24;
        if (Objects.equals(this.mLatestManualSuggestion, that.mLatestManualSuggestion) == false) goto L24;
        if (Objects.equals(this.mLatestTelephonySuggestion, that.mLatestTelephonySuggestion) == false) goto L24;
        if (Objects.equals(this.mLatestGeolocationSuggestion, that.mLatestGeolocationSuggestion) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mConfigurationInternal, Integer.valueOf(this.mDeviceTimeZoneIdOrdinal), this.mDeviceTimeZoneId, this.mLatestManualSuggestion, this.mLatestTelephonySuggestion, this.mLatestGeolocationSuggestion});
    }

    public String toString() {
        return "MetricsTimeZoneDetectorState{mConfigurationInternal=" + this.mConfigurationInternal + ", mDeviceTimeZoneIdOrdinal=" + this.mDeviceTimeZoneIdOrdinal + ", mDeviceTimeZoneId=" + this.mDeviceTimeZoneId + ", mLatestManualSuggestion=" + this.mLatestManualSuggestion + ", mLatestTelephonySuggestion=" + this.mLatestTelephonySuggestion + ", mLatestGeolocationSuggestion=" + this.mLatestGeolocationSuggestion + '}';
    }

    private static MetricsTimeZoneSuggestion createMetricsTimeZoneSuggestion(OrdinalGenerator<String> zoneIdOrdinalGenerator, ManualTimeZoneSuggestion manualSuggestion, boolean includeFullZoneIds) {
        String[] metricZoneIds = null;
        if (manualSuggestion != null) goto L5;
        return null;
    L5:
        String suggestionZoneId = manualSuggestion.getZoneId();
        if (includeFullZoneIds == false) goto L8;
        metricZoneIds = new String[]{suggestionZoneId};
    L8:
        int[] zoneIdOrdinals = {zoneIdOrdinalGenerator.ordinal(suggestionZoneId)};
        return MetricsTimeZoneSuggestion.createCertain(metricZoneIds, zoneIdOrdinals);
    }

    private static MetricsTimeZoneSuggestion createMetricsTimeZoneSuggestion(OrdinalGenerator<String> zoneIdOrdinalGenerator, TelephonyTimeZoneSuggestion telephonySuggestion, boolean includeFullZoneIds) {
        String[] metricZoneIds = null;
        if (telephonySuggestion != null) goto L5;
        return null;
    L5:
        String suggestionZoneId = telephonySuggestion.getZoneId();
        if (suggestionZoneId == null) goto L8;
        if (includeFullZoneIds == false) goto L11;
        metricZoneIds = new String[]{suggestionZoneId};
    L11:
        int[] zoneIdOrdinals = {zoneIdOrdinalGenerator.ordinal(suggestionZoneId)};
        return MetricsTimeZoneSuggestion.createCertain(metricZoneIds, zoneIdOrdinals);
    L8:
        return MetricsTimeZoneSuggestion.createUncertain();
    }

    private static MetricsTimeZoneSuggestion createMetricsTimeZoneSuggestion(OrdinalGenerator<String> zoneIdOrdinalGenerator, GeolocationTimeZoneSuggestion geolocationSuggestion, boolean includeFullZoneIds) {
        String[] metricZoneIds = null;
        if (geolocationSuggestion != null) goto L5;
        return null;
    L5:
        List<String> zoneIds = geolocationSuggestion.getZoneIds();
        if (zoneIds == null) goto L8;
        if (includeFullZoneIds == false) goto L11;
        metricZoneIds = (String[]) zoneIds.toArray(new String[0]);
    L11:
        int[] zoneIdOrdinals = zoneIdOrdinalGenerator.ordinals(zoneIds);
        return MetricsTimeZoneSuggestion.createCertain(metricZoneIds, zoneIdOrdinals);
    L8:
        return MetricsTimeZoneSuggestion.createUncertain();
    }
}
