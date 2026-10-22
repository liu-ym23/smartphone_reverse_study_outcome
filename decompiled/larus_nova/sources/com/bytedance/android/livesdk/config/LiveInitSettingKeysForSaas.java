package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public class LiveInitSettingKeysForSaas {
    public static boolean canReadPerformanceSettings;

    public LiveInitSettingKeysForSaas() {
    }

    private static boolean isSettingOpt() {
        return false;
    }

    public static boolean get_LIVE_ONLINE_EMOJI_ENABLE() {
        if (isSettingOpt() == false) goto L7;
        return LiveConfigSimplifySettingKeys.LIVE_ONLINE_EMOJI_ENABLE.getValue().booleanValue();
    L7:
        return LiveConfigSimplifySettingKeys.LIVE_ONLINE_EMOJI_ENABLE.getValue().booleanValue();
    }
}
