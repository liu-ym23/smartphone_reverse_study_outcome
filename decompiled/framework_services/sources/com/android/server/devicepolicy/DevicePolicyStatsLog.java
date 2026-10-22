package com.android.server.devicepolicy;

import android.util.StatsEvent;

/* JADX INFO: loaded from: classes2.dex */
public class DevicePolicyStatsLog {
    public static final byte ANNOTATION_ID_DEFAULT_STATE = 6;
    public static final byte ANNOTATION_ID_EXCLUSIVE_STATE = 4;
    public static final byte ANNOTATION_ID_IS_UID = 1;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD = 3;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD_FIRST_UID = 5;
    public static final byte ANNOTATION_ID_STATE_NESTED = 8;
    public static final byte ANNOTATION_ID_TRIGGER_STATE_RESET = 7;
    public static final byte ANNOTATION_ID_TRUNCATE_TIMESTAMP = 2;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE = 10216;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE__MANAGEMENT_MODE__COPE = 3;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE__MANAGEMENT_MODE__DEVICE_OWNER = 1;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE__MANAGEMENT_MODE__DEVICE_OWNER_FINANCED = 4;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE__MANAGEMENT_MODE__MANAGEMENT_MODE_UNSPECIFIED = 0;
    public static final int DEVICE_POLICY_MANAGEMENT_MODE__MANAGEMENT_MODE__PROFILE_OWNER = 2;
    public static final int DEVICE_POLICY_STATE = 10217;
    public static final int DEVICE_POLICY_STATE__MANAGEMENT_MODE__COPE = 3;
    public static final int DEVICE_POLICY_STATE__MANAGEMENT_MODE__DEVICE_OWNER = 1;
    public static final int DEVICE_POLICY_STATE__MANAGEMENT_MODE__DEVICE_OWNER_FINANCED = 4;
    public static final int DEVICE_POLICY_STATE__MANAGEMENT_MODE__MANAGEMENT_MODE_UNSPECIFIED = 0;
    public static final int DEVICE_POLICY_STATE__MANAGEMENT_MODE__PROFILE_OWNER = 2;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_HIGH = 5;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_LEGACY = 2;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_LOW = 3;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_MEDIUM = 4;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_NONE = 1;
    public static final int DEVICE_POLICY_STATE__PASSWORD_COMPLEXITY__COMPLEXITY_UNSPECIFIED = 0;

    public DevicePolicyStatsLog() {
    }

    public static StatsEvent buildStatsEvent(int code, int arg1) {
        StatsEvent.Builder builder = StatsEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        return builder.build();
    }

    public static StatsEvent buildStatsEvent(int code, int arg1, int arg2) {
        StatsEvent.Builder builder = StatsEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        builder.writeInt(arg2);
        return builder.build();
    }
}
