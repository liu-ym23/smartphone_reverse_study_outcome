package com.obric.capabilitykit.common;

/* JADX INFO: loaded from: classes3.dex */
public final class SettingsActionType {
    public static final SettingsActionType INSTANCE = null;
    public static final int SETTINGS_ACTION_TYPE_AIRPLANE_MODE = 8;
    public static final int SETTINGS_ACTION_TYPE_BATTERYPERCENTAGE = 2048;
    public static final int SETTINGS_ACTION_TYPE_BATTERY_SAVE = 256;
    public static final int SETTINGS_ACTION_TYPE_BLUETOOTH = 2;
    public static final int SETTINGS_ACTION_TYPE_BRIGHTNESS_ADATIVE = 8192;
    public static final int SETTINGS_ACTION_TYPE_DEFAULT = 512;
    public static final int SETTINGS_ACTION_TYPE_FLASHLIGHT = 16;
    public static final int SETTINGS_ACTION_TYPE_LOCATION = 4;
    public static final int SETTINGS_ACTION_TYPE_MOBILE_DATA = 16384;
    public static final int SETTINGS_ACTION_TYPE_NIGHT_DISPLAY = 64;
    public static final int SETTINGS_ACTION_TYPE_NIGHT_MODE = 128;
    public static final int SETTINGS_ACTION_TYPE_NOTIFICATION = 4096;
    public static final int SETTINGS_ACTION_TYPE_VIBRATION = 32;
    public static final int SETTINGS_ACTION_TYPE_WIFI = 1;
    public static final int SETTINGS_ACTION_TYPE_ZEN = 1024;

    static {
        INSTANCE = new SettingsActionType();
    }

    private SettingsActionType() {
    }
}
