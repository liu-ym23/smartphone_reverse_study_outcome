package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R&\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveEndRoomConfig;", "", "()V", "changeReportEnable", "", "getChangeReportEnable", "()Z", "setChangeReportEnable", "(Z)V", "delayTaskEnable", "getDelayTaskEnable", "setDelayTaskEnable", "delayTime", "", "getDelayTime", "()I", "setDelayTime", "(I)V", "endAnimationType", "getEndAnimationType", "setEndAnimationType", "enterAnimationType", "getEnterAnimationType", "setEnterAnimationType", "liveEntranceList", "", "", "getLiveEntranceList", "()Ljava/util/List;", "setLiveEntranceList", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveEndRoomConfig {

    @SerializedName("change_report_enable")
    private boolean changeReportEnable;

    @SerializedName("delay_task_enable")
    private boolean delayTaskEnable;

    @SerializedName("delay_time")
    private int delayTime;

    @SerializedName("end_animation_type")
    private int endAnimationType;

    @SerializedName("enter_animation_type")
    private int enterAnimationType;

    @SerializedName("live_entrance_list")
    private List<String> liveEntranceList;

    public LiveEndRoomConfig() {
        this.enterAnimationType = -1;
        this.endAnimationType = -1;
        this.liveEntranceList = CollectionsKt.emptyList();
    }

    public final boolean getChangeReportEnable() {
        return this.changeReportEnable;
    }

    public final boolean getDelayTaskEnable() {
        return this.delayTaskEnable;
    }

    public final int getDelayTime() {
        return this.delayTime;
    }

    public final int getEndAnimationType() {
        return this.endAnimationType;
    }

    public final int getEnterAnimationType() {
        return this.enterAnimationType;
    }

    public final List<String> getLiveEntranceList() {
        return this.liveEntranceList;
    }

    public final void setChangeReportEnable(boolean r100) {
        this.changeReportEnable = r100;
    }

    public final void setDelayTaskEnable(boolean r100) {
        this.delayTaskEnable = r100;
    }

    public final void setDelayTime(int r100) {
        this.delayTime = r100;
    }

    public final void setEndAnimationType(int r100) {
        this.endAnimationType = r100;
    }

    public final void setEnterAnimationType(int r100) {
        this.enterAnimationType = r100;
    }

    public final void setLiveEntranceList(List<String> r100) {
        this.liveEntranceList = r100;
    }
}
