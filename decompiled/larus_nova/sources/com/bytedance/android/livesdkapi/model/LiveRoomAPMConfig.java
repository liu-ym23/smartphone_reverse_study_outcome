package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class LiveRoomAPMConfig {
    public static final int EXIT_UPLOAD_ALL = 2;
    public static final int EXIT_UPLOAD_NONE = 0;
    public static final int EXIT_UPLOAD_ONLY_ABNORMAL = 1;
    public static final int LEVEL_ALL = 2;
    public static final int LEVEL_NONE = 0;
    public static final int LEVEL_ONLY_HAVE_ERROR = 1;

    @SerializedName("black_event_name")
    public List<String> blackEventName;

    @SerializedName("enable_live_room_apm")
    public boolean enableRoomAPM;

    @SerializedName("enable_live_write_alog_e")
    public boolean enableWriteALogE;

    @SerializedName("enable_live_write_alog_i")
    public boolean enableWriteALogI;

    @SerializedName("enter_room_timeout")
    public int enterRoomTimeout;

    @SerializedName("max_event_size")
    public int maxEventSize;

    @SerializedName("upload_enter_room_level")
    public int uploadEnterRoomLevel;

    @SerializedName("upload_exit_room_level")
    public int uploadExitRoomLevel;

    @SerializedName("upload_exit_trace")
    public int uploadExitTrace;

    @SerializedName("upload_ping_room_level")
    public int uploadPingRoomLevel;

    @SerializedName("upload_ping_time")
    public int uploadPingTime;

    public boolean exitUploadAll() {
        if (this.uploadExitTrace != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean exitUploadOnlyAbnormal() {
        if (this.uploadExitTrace == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public LiveRoomAPMConfig() {
        this.enableRoomAPM = true;
        this.uploadEnterRoomLevel = 2;
        this.enterRoomTimeout = 10000;
        this.uploadExitRoomLevel = 2;
        this.uploadPingRoomLevel = 0;
        this.uploadPingTime = 300000;
        this.enableWriteALogI = false;
        this.enableWriteALogE = false;
        this.blackEventName = new AnonymousClass1(this);
        this.maxEventSize = 50;
        this.uploadExitTrace = 1;
    }
}
