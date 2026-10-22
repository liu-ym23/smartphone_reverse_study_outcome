package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveRoomFeatureConfig;", "", "()V", "delayTimeClick", "", "getDelayTimeClick", "()I", "setDelayTimeClick", "(I)V", "delayTimeDraw", "getDelayTimeDraw", "setDelayTimeDraw", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "innerPullStreamDelete", "getInnerPullStreamDelete", "setInnerPullStreamDelete", "pullStreamTime", "getPullStreamTime", "setPullStreamTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRoomFeatureConfig {

    @SerializedName("delay_time_click")
    private int delayTimeClick;

    @SerializedName("delay_time_draw")
    private int delayTimeDraw;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("inner_pull_stream_delete")
    private boolean innerPullStreamDelete;

    @SerializedName("pull_stream_time")
    private int pullStreamTime;

    public LiveRoomFeatureConfig() {
    }

    public final int getDelayTimeClick() {
        return this.delayTimeClick;
    }

    public final int getDelayTimeDraw() {
        return this.delayTimeDraw;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getInnerPullStreamDelete() {
        return this.innerPullStreamDelete;
    }

    public final int getPullStreamTime() {
        return this.pullStreamTime;
    }

    public final void setDelayTimeClick(int r100) {
        this.delayTimeClick = r100;
    }

    public final void setDelayTimeDraw(int r100) {
        this.delayTimeDraw = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setInnerPullStreamDelete(boolean r100) {
        this.innerPullStreamDelete = r100;
    }

    public final void setPullStreamTime(int r100) {
        this.pullStreamTime = r100;
    }
}
