package com.android.server.timedetector;

import android.app.time.TimeConfiguration;
import com.android.server.timezonedetector.StateChangeListener;

/* JADX INFO: loaded from: classes3.dex */
public interface ServiceConfigAccessor {
    void addConfigurationInternalChangeListener(StateChangeListener r1);

    ConfigurationInternal getConfigurationInternal(int r1);

    ConfigurationInternal getCurrentUserConfigurationInternal();

    void removeConfigurationInternalChangeListener(StateChangeListener r1);

    boolean updateConfiguration(int r1, TimeConfiguration r2, boolean r3);
}
