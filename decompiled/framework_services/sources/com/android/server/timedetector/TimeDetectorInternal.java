package com.android.server.timedetector;

import android.app.time.TimeCapabilitiesAndConfig;
import android.app.time.TimeConfiguration;
import android.app.timedetector.ManualTimeSuggestion;
import com.android.server.timezonedetector.StateChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface TimeDetectorInternal {
    void addNetworkTimeUpdateListener(StateChangeListener r1);

    TimeCapabilitiesAndConfig getCapabilitiesAndConfigForDpm();

    NetworkTimeSuggestion getLatestNetworkSuggestion();

    boolean setManualTimeForDpm(ManualTimeSuggestion r1);

    void suggestGnssTime(GnssTimeSuggestion r1);

    void suggestNetworkTime(NetworkTimeSuggestion r1);

    boolean updateConfigurationForDpm(TimeConfiguration r1);
}
