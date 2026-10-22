package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveCountdownConfig;", "", "()V", "actionTypeLimit", "", "getActionTypeLimit", "()Z", "setActionTypeLimit", "(Z)V", "countdownDelayTime", "", "getCountdownDelayTime", "()J", "setCountdownDelayTime", "(J)V", "countdownTime", "getCountdownTime", "setCountdownTime", "countdownToNext", "getCountdownToNext", "setCountdownToNext", "liveEntranceList", "", "", "getLiveEntranceList", "()Ljava/util/List;", "setLiveEntranceList", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveCountdownConfig {

    @SerializedName("action_type_limit")
    private boolean actionTypeLimit;

    @SerializedName("countdown_delay_time")
    private long countdownDelayTime;

    @SerializedName("countdown_time")
    private long countdownTime;

    @SerializedName("countdown_to_next")
    private boolean countdownToNext;

    @SerializedName("live_entrance_list")
    private List<String> liveEntranceList;

    public LiveCountdownConfig() {
        this.actionTypeLimit = true;
        this.countdownDelayTime = -1;
        this.countdownTime = -1;
        this.liveEntranceList = CollectionsKt.emptyList();
    }

    public final boolean getActionTypeLimit() {
        return this.actionTypeLimit;
    }

    public final long getCountdownDelayTime() {
        return this.countdownDelayTime;
    }

    public final long getCountdownTime() {
        return this.countdownTime;
    }

    public final boolean getCountdownToNext() {
        return this.countdownToNext;
    }

    public final List<String> getLiveEntranceList() {
        return this.liveEntranceList;
    }

    public final void setActionTypeLimit(boolean r100) {
        this.actionTypeLimit = r100;
    }

    public final void setCountdownDelayTime(long r100) {
        this.countdownDelayTime = r100;
    }

    public final void setCountdownTime(long r100) {
        this.countdownTime = r100;
    }

    public final void setCountdownToNext(boolean r100) {
        this.countdownToNext = r100;
    }

    public final void setLiveEntranceList(List<String> r100) {
        this.liveEntranceList = r100;
    }
}
