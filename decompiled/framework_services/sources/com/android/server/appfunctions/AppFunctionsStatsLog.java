package com.android.server.appfunctions;

import android.util.StatsEvent;
import android.util.StatsLog;

/* JADX INFO: loaded from: classes.dex */
public class AppFunctionsStatsLog {
    public static final byte ANNOTATION_ID_DEFAULT_STATE = 6;
    public static final byte ANNOTATION_ID_EXCLUSIVE_STATE = 4;
    public static final byte ANNOTATION_ID_IS_UID = 1;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD = 3;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD_FIRST_UID = 5;
    public static final byte ANNOTATION_ID_STATE_NESTED = 8;
    public static final byte ANNOTATION_ID_TRIGGER_STATE_RESET = 7;
    public static final byte ANNOTATION_ID_TRUNCATE_TIMESTAMP = 2;
    public static final int APP_FUNCTIONS_REQUEST_REPORTED = 998;

    public AppFunctionsStatsLog() {
    }

    public static void write(int code, int arg1, int arg2, int arg3, int arg4, int arg5, long arg6, long arg7) {
        StatsEvent.Builder builder = StatsEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        if (998 != code) goto L5;
        builder.addBooleanAnnotation((byte) 1, true);
    L5:
        builder.writeInt(arg2);
        if (998 != code) goto L8;
        builder.addBooleanAnnotation((byte) 1, true);
    L8:
        builder.writeInt(arg3);
        builder.writeInt(arg4);
        builder.writeInt(arg5);
        builder.writeLong(arg6);
        builder.writeLong(arg7);
        builder.usePooledBuffer();
        StatsLog.write(builder.build());
    }
}
