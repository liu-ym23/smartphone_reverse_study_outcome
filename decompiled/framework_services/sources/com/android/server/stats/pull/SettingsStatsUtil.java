package com.android.server.stats.pull;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Slog;
import android.util.StatsEvent;
import com.android.service.nano.StringListParamProto;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class SettingsStatsUtil {
    private static final FlagsData[] GLOBAL_SETTINGS = null;
    private static final FlagsData[] SECURE_SETTINGS = null;
    private static final FlagsData[] SYSTEM_SETTINGS = null;
    private static final String TAG = "SettingsStatsUtil";

    static final class FlagsData {
        int mDataType;
        String mFlagName;

        FlagsData(String flagName, int dataType) {
            this.mFlagName = flagName;
            this.mDataType = dataType;
        }
    }

    SettingsStatsUtil() {
    }

    static {
        GLOBAL_SETTINGS = new FlagsData[]{new FlagsData("GlobalFeature__boolean_whitelist", 1), new FlagsData("GlobalFeature__integer_whitelist", 2), new FlagsData("GlobalFeature__float_whitelist", 3), new FlagsData("GlobalFeature__string_whitelist", 4)};
        SECURE_SETTINGS = new FlagsData[]{new FlagsData("SecureFeature__boolean_whitelist", 1), new FlagsData("SecureFeature__integer_whitelist", 2), new FlagsData("SecureFeature__float_whitelist", 3), new FlagsData("SecureFeature__string_whitelist", 4)};
        SYSTEM_SETTINGS = new FlagsData[]{new FlagsData("SystemFeature__boolean_whitelist", 1), new FlagsData("SystemFeature__integer_whitelist", 2), new FlagsData("SystemFeature__float_whitelist", 3), new FlagsData("SystemFeature__string_whitelist", 4)};
    }

    static List<StatsEvent> logGlobalSettings(Context context, int atomTag, int userId) {
        List<StatsEvent> output = new ArrayList();
        ContentResolver resolver = context.getContentResolver();
        FlagsData[] r3 = GLOBAL_SETTINGS;
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L13;
        FlagsData flagsData = r3[r6];
        StringListParamProto proto = getList(flagsData.mFlagName);
        if (proto == null) goto L11;
        String[] r9 = proto.element;
        int r10 = r9.length;
        int r11 = 0;
    L8:
        if (r11 >= r10) goto L11;
        String key = r9[r11];
        String value = Settings.Global.getStringForUser(resolver, key, userId);
        output.add(createStatsEvent(atomTag, key, value, userId, flagsData.mDataType));
        r11 = r11 + 1;
    L11:
        r6 = r6 + 1;
        goto L3
    L13:
        return output;
    }

    static List<StatsEvent> logSystemSettings(Context context, int atomTag, int userId) {
        List<StatsEvent> output = new ArrayList();
        ContentResolver resolver = context.getContentResolver();
        FlagsData[] r3 = SYSTEM_SETTINGS;
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        FlagsData flagsData = r3[r6];
        StringListParamProto proto = getList(flagsData.mFlagName);
        if (proto == null) goto L11;
        String[] r9 = proto.element;
        int r10 = r9.length;
        int r11 = 0;
    L8:
        if (r11 >= r10) goto L11;
        String key = r9[r11];
        String value = Settings.System.getStringForUser(resolver, key, userId);
        String telemetryValue = RawSettingsTelemetryUtils.getTelemetrySettingFromRawVal(context, key, value);
        output.add(createStatsEvent(atomTag, key, telemetryValue, userId, flagsData.mDataType));
        r11 = r11 + 1;
        resolver = resolver;
    L11:
        r6 = r6 + 1;
        resolver = resolver;
        goto L3
    L12:
        return output;
    }

    static List<StatsEvent> logSecureSettings(Context context, int atomTag, int userId) {
        List<StatsEvent> output = new ArrayList();
        ContentResolver resolver = context.getContentResolver();
        FlagsData[] r3 = SECURE_SETTINGS;
        int r4 = r3.length;
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L13;
        FlagsData flagsData = r3[r6];
        StringListParamProto proto = getList(flagsData.mFlagName);
        if (proto == null) goto L11;
        String[] r9 = proto.element;
        int r10 = r9.length;
        int r11 = 0;
    L8:
        if (r11 >= r10) goto L11;
        String key = r9[r11];
        String value = Settings.Secure.getStringForUser(resolver, key, userId);
        output.add(createStatsEvent(atomTag, key, value, userId, flagsData.mDataType));
        r11 = r11 + 1;
    L11:
        r6 = r6 + 1;
        goto L3
    L13:
        return output;
    }

    static StringListParamProto getList(String flag) {
        String base64 = DeviceConfig.getProperty("settings_stats", flag);
        if (TextUtils.isEmpty(base64) == false) goto L6;
        return null;
    L6:
        byte[] decode = Base64.decode(base64, 3);
        StringListParamProto list = StringListParamProto.parseFrom(decode);     // Catch: Exception -> L9
        return list;
    L9:
        e = move-exception;
        Slog.e(TAG, "Error parsing string list proto", e);
        return null;
    }

    private static StatsEvent createStatsEvent(int atomTag, String key, String value, int userId, int type) {
        StatsEvent.Builder builder = StatsEvent.newBuilder().setAtomId(atomTag).writeString(key);
        boolean booleanValue = false;
        int intValue = 0;
        float floatValue = 0.0f;
        String stringValue = "";
        if (TextUtils.isEmpty(value) == false) goto L6;
        builder.writeInt(0).writeBoolean(false).writeInt(0).writeFloat(0.0f).writeString("").writeInt(userId);
    L20:
        return builder.build();
    L6:
        switch(type) {
            case 1: goto L17;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L8;
            default: goto L7;
        };
    L7:
        Slog.w(TAG, "Unexpected value type " + type);
    L18:
        builder.writeInt(type).writeBoolean(booleanValue).writeInt(intValue).writeFloat(floatValue).writeString(stringValue).writeInt(userId);
        goto L20
    L8:
        stringValue = value;
        goto L18
    L17:
        booleanValue = "1".equals(value);
        goto L18
    L21:
        floatValue = Float.parseFloat(value);     // Catch: NumberFormatException -> L11
    L12:
        Slog.w(TAG, "Can not parse value to float: " + value);
        goto L18
    L23:
        intValue = Integer.parseInt(value);     // Catch: NumberFormatException -> L15
    L16:
        Slog.w(TAG, "Can not parse value to float: " + value);
        goto L18
    }
}
