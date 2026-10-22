package com.android.server.timezonedetector;

import android.app.time.TimeZoneCapabilitiesAndConfig;
import android.app.time.TimeZoneConfiguration;
import android.app.time.TimeZoneState;
import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.app.timezonedetector.TelephonyTimeZoneSuggestion;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeZoneDetectorStrategy extends Dumpable {
    public static final int ORIGIN_LOCATION = 3;
    public static final int ORIGIN_MANUAL = 1;
    public static final int ORIGIN_TELEPHONY = 2;
    public static final int ORIGIN_UNKNOWN = 0;

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Origin {
    }

    void addChangeListener(StateChangeListener r1);

    boolean confirmTimeZone(String r1);

    void enableTelephonyTimeZoneFallback(String r1);

    MetricsTimeZoneDetectorState generateMetricsState();

    TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfig(int r1, boolean r2);

    TimeZoneState getTimeZoneState();

    void handleLocationAlgorithmEvent(LocationAlgorithmEvent r1);

    boolean isGeoTimeZoneDetectionSupported();

    boolean isTelephonyTimeZoneDetectionSupported();

    void setTimeZoneState(TimeZoneState r1);

    boolean suggestManualTimeZone(int r1, ManualTimeZoneSuggestion r2, boolean r3);

    void suggestTelephonyTimeZone(TelephonyTimeZoneSuggestion r1);

    boolean updateConfiguration(int r1, TimeZoneConfiguration r2, boolean r3);
}
