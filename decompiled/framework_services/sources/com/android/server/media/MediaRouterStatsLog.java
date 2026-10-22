package com.android.server.media;

import android.util.StatsEvent;
import android.util.StatsLog;

/* JADX INFO: loaded from: classes2.dex */
public class MediaRouterStatsLog {
    public static final byte ANNOTATION_ID_DEFAULT_STATE = 6;
    public static final byte ANNOTATION_ID_EXCLUSIVE_STATE = 4;
    public static final byte ANNOTATION_ID_IS_UID = 1;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD = 3;
    public static final byte ANNOTATION_ID_PRIMARY_FIELD_FIRST_UID = 5;
    public static final byte ANNOTATION_ID_STATE_NESTED = 8;
    public static final byte ANNOTATION_ID_TRIGGER_STATE_RESET = 7;
    public static final byte ANNOTATION_ID_TRUNCATE_TIMESTAMP = 2;
    public static final int MEDIA_ROUTER_EVENT_REPORTED = 1017;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_CREATE_SESSION = 1;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_CREATE_SYSTEM_ROUTING_SESSION = 2;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_DESELECT_ROUTE = 5;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_RELEASE_SESSION = 3;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_SCANNING_STARTED = 7;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_SCANNING_STOPPED = 8;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_SELECT_ROUTE = 4;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_TRANSFER_TO_ROUTE = 6;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__EVENT_TYPE__EVENT_TYPE_UNSPECIFIED = 0;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_DUPLICATE_SESSION_ID = 12;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_FAILED_TO_REROUTE_SYSTEM_MEDIA = 8;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_INVALID_COMMAND = 6;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_INVALID_ROUTE_ID = 10;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_INVALID_SESSION_ID = 11;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_MANAGER_RECORD_NOT_FOUND = 16;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_MEDIA_STREAM_CREATION_FAILED = 15;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_NETWORK_ERROR = 4;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_PERMISSION_DENIED = 9;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_PROVIDER_CALLBACK_ERROR = 13;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_REJECTED = 3;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_ROUTER_RECORD_NOT_FOUND = 17;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_ROUTE_NOT_AVAILABLE = 5;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_SUCCESS = 1;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_SYSTEM_SERVICE_ERROR = 14;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_UNIMPLEMENTED = 7;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_UNKNOWN_ERROR = 2;
    public static final int MEDIA_ROUTER_EVENT_REPORTED__RESULT__RESULT_UNSPECIFIED = 0;

    public MediaRouterStatsLog() {
    }

    public static void write(int code, int arg1, int arg2) {
        StatsEvent.Builder builder = StatsEvent.newBuilder();
        builder.setAtomId(code);
        builder.writeInt(arg1);
        builder.writeInt(arg2);
        builder.usePooledBuffer();
        StatsLog.write(builder.build());
    }
}
