package com.android.server.timezonedetector;

import android.app.time.TimeZoneCapabilitiesAndConfig;
import android.app.time.TimeZoneConfiguration;
import android.app.timezonedetector.ManualTimeZoneSuggestion;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeZoneDetectorInternal {
    MetricsTimeZoneDetectorState generateMetricsState();

    TimeZoneCapabilitiesAndConfig getCapabilitiesAndConfigForDpm();

    void handleLocationAlgorithmEvent(LocationAlgorithmEvent r1);

    boolean setManualTimeZoneForDpm(ManualTimeZoneSuggestion r1);

    boolean updateConfigurationForDpm(TimeZoneConfiguration r1);
}
