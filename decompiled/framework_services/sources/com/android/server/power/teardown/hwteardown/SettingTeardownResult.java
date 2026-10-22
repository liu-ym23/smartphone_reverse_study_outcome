package com.android.server.power.teardown.hwteardown;

import com.android.server.power.teardown.ComponentResult;

/* JADX INFO: loaded from: classes3.dex */
public class SettingTeardownResult extends ComponentResult {
    public static final int MASK_ADAPTIVE_SLEEP = 16777216;
    public static final int MASK_AIRPLANE_MODE = 262144;
    public static final int MASK_AOD = 32;
    public static final int MASK_AUTO_BRIGHTNESS = 16;
    public static final int MASK_AUTO_MEMORY = 4194304;
    public static final int MASK_AUTO_RECOGNITION = 2;
    public static final int MASK_AUTO_RECORD = 8;
    public static final int MASK_AUTO_REFRESH_RATE = 32768;
    public static final int MASK_AUTO_RESOLUTION = 16384;
    public static final int MASK_AUTO_SUMMARY = 4;
    public static final int MASK_DC_DIMMING = 33554432;
    public static final int MASK_DOUBLE_CLICK = 64;
    public static final int MASK_DOZE_ENABLE = 256;
    public static final int MASK_HD_RESOLUTION = 8192;
    public static final int MASK_HIGH_REFRESH_RATE = 65536;
    public static final int MASK_LOW_POWER = 512;
    public static final int MASK_LOW_REFRESH_RATE = 131072;
    public static final int MASK_PICKUP = 128;
    public static final int MASK_POCKET_MODE = 2048;
    public static final int MASK_REVERSE_CHARGING = 524288;
    public static final int MASK_SCREEN_MEMORY = 8388608;
    public static final int MASK_SMT_5G = 1048576;
    public static final int MASK_SOUND_MEMORY = 2097152;
    public static final int MASK_TOGGLE_POWER_AI = 1024;
    public static final int MASK_ULTRA_RESOLUTION = 4096;
    public static final int MASK_VOICE_WAKEUP = 1;
    public String mAllowBgPowerHigh;
    public int mAodPolicy;
    public SettingFlags mSettingFlags;

    public static class SettingFlags {
        int flags;

        public SettingFlags() {
            this.flags = 0;
        }

        public void enableFeature(int mask) {
            this.flags |= mask;
        }

        public void disableFeature(int mask) {
            this.flags &= ~mask;
        }

        public boolean isFeatureEnabled(int mask) {
            if ((this.flags & mask) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int isSettingFlag(int mask) {
            if ((this.flags & mask) == 0) goto L5;
            return 1;
        L5:
            return 0;
        }
    }

    public SettingTeardownResult(int flags, int aodPolicy, String allowBgPowerHigh) {
        this.mSettingFlags = new SettingFlags();
        this.mSettingFlags.flags = flags;
        this.mAodPolicy = aodPolicy;
        this.mAllowBgPowerHigh = allowBgPowerHigh;
    }

    public String toString() {
        return "[Setting] Setting VoiceWakeup = " + this.mSettingFlags.isFeatureEnabled(1) + ", autoRecognition = " + this.mSettingFlags.isFeatureEnabled(2) + ", autoSummary = " + this.mSettingFlags.isFeatureEnabled(4) + ", autoRecord = " + this.mSettingFlags.isFeatureEnabled(8) + ", autoBrightness = " + this.mSettingFlags.isFeatureEnabled(16) + ", aod = " + this.mSettingFlags.isFeatureEnabled(32) + ", doubleClick = " + this.mSettingFlags.isFeatureEnabled(64) + ", pickup = " + this.mSettingFlags.isFeatureEnabled(128) + ", dozeEnable = " + this.mSettingFlags.isFeatureEnabled(256) + ", lowPower = " + this.mSettingFlags.isFeatureEnabled(512) + ", togglePowerAi = " + this.mSettingFlags.isFeatureEnabled(1024) + ", pocketMode = " + this.mSettingFlags.isFeatureEnabled(2048) + ", ultraResolution = " + this.mSettingFlags.isFeatureEnabled(4096) + ", hdResolution = " + this.mSettingFlags.isFeatureEnabled(8192) + ", autoResolution = " + this.mSettingFlags.isFeatureEnabled(16384) + ", airplaneMode = " + this.mSettingFlags.isFeatureEnabled(262144) + ", smt5G = " + this.mSettingFlags.isFeatureEnabled(1048576) + ", autoRefreshRate = " + this.mSettingFlags.isFeatureEnabled(32768) + ", highRefreshRate = " + this.mSettingFlags.isFeatureEnabled(65536) + ", lowRefreshRate = " + this.mSettingFlags.isFeatureEnabled(131072) + ", soundMemory = " + this.mSettingFlags.isFeatureEnabled(2097152) + ", autoMemory = " + this.mSettingFlags.isFeatureEnabled(4194304) + ", screenMemory = " + this.mSettingFlags.isFeatureEnabled(8388608) + ", adaptiveSleep = " + this.mSettingFlags.isFeatureEnabled(16777216) + ", dcDimming = " + this.mSettingFlags.isFeatureEnabled(33554432) + ", aodPolicy = " + this.mAodPolicy + ", allowBgPowerHigh = " + this.mAllowBgPowerHigh + "\n";
    }
}
