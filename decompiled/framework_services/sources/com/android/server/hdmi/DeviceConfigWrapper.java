package com.android.server.hdmi;

import android.provider.DeviceConfig;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceConfigWrapper {
    private static final String TAG = "DeviceConfigWrapper";

    public DeviceConfigWrapper() {
    }

    boolean getBoolean(String name, boolean defaultValue) {
        return DeviceConfig.getBoolean("hdmi_control", name, defaultValue);
    }

    void addOnPropertiesChangedListener(Executor mainExecutor, DeviceConfig.OnPropertiesChangedListener onPropertiesChangedListener) {
        DeviceConfig.addOnPropertiesChangedListener("hdmi_control", mainExecutor, onPropertiesChangedListener);
    }
}
