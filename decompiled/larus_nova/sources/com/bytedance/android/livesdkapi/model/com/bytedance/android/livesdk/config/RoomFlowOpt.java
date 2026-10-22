package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u001e\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/RoomFlowOpt;", "", "()V", "isReportLog", "", "()Z", "setReportLog", "(Z)V", "leakOpt", "getLeakOpt", "setLeakOpt", "mergeRoomOpt", "getMergeRoomOpt", "setMergeRoomOpt", "stopRoomOpt", "getStopRoomOpt", "setStopRoomOpt", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFlowOpt {

    @SerializedName("is_report_log")
    private boolean isReportLog;

    @SerializedName("leak_opt")
    private boolean leakOpt;

    @SerializedName("merge_start_for_finish")
    private boolean mergeRoomOpt;

    @SerializedName("stop_room_opt")
    private boolean stopRoomOpt;

    public RoomFlowOpt() {
    }

    public final boolean getLeakOpt() {
        return this.leakOpt;
    }

    public final boolean getMergeRoomOpt() {
        return this.mergeRoomOpt;
    }

    public final boolean getStopRoomOpt() {
        return this.stopRoomOpt;
    }

    public final boolean isReportLog() {
        return this.isReportLog;
    }

    public final void setLeakOpt(boolean r100) {
        this.leakOpt = r100;
    }

    public final void setMergeRoomOpt(boolean r100) {
        this.mergeRoomOpt = r100;
    }

    public final void setReportLog(boolean r100) {
        this.isReportLog = r100;
    }

    public final void setStopRoomOpt(boolean r100) {
        this.stopRoomOpt = r100;
    }
}
