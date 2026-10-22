package com.android.server.stats.pull;

import android.content.Context;
import android.util.Log;
import com.android.internal.display.RefreshRateSettingsUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class RawSettingsTelemetryUtils {
    private static final String TAG = "SettingsTelemetryUtils";

    public RawSettingsTelemetryUtils() {
    }

    public static String getTelemetrySettingFromRawVal(Context context, String key, String value) {
        if (key != null) goto L6;
        return null;
    L6:
        if (key.equals("peak_refresh_rate") == true) goto L8;
        return value;
    L8:
        return getPeakRefreshRateSetting(context, value);
    }

    private static String getPeakRefreshRateSetting(Context context, String settingRawValue) {
        if (settingRawValue != null) goto L5;
        Log.e(TAG, "PEAK_REFRESH_RATE value is null");
        return null;
    L5:
        String floatInfinityStr = Float.toString(Float.POSITIVE_INFINITY);
        if (settingRawValue.equals(floatInfinityStr) == false) goto L9;
        float max_refresh_rate = RefreshRateSettingsUtils.findHighestRefreshRateAmongAllBuiltInDisplays(context);
        return Float.toString(max_refresh_rate);
    L9:
        return settingRawValue;
    }
}
