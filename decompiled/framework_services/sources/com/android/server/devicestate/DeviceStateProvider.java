package com.android.server.devicestate;

import android.hardware.devicestate.DeviceState;
import android.util.Dumpable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface DeviceStateProvider extends Dumpable {
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_DEFAULT = 0;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_EXTERNAL_DISPLAY_ADDED = 6;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_EXTERNAL_DISPLAY_REMOVED = 7;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_INITIALIZED = 1;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_POWER_SAVE_DISABLED = 5;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_POWER_SAVE_ENABLED = 4;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_THERMAL_CRITICAL = 3;
    public static final int SUPPORTED_DEVICE_STATES_CHANGED_THERMAL_NORMAL = 2;

    public interface Listener {
        void onStateChanged(int r1);

        void onSupportedDeviceStatesChanged(DeviceState[] r1, int r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedStatesUpdatedReason {
    }

    void setListener(Listener r1);

    default void onSystemReady() {
    }
}
