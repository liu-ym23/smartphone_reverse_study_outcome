package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveHandleRoomOptimizeConfig;", "", "()V", "delayTime", "", "getDelayTime", "()J", "setDelayTime", "(J)V", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "enableHandleRoomExplicit", "getEnableHandleRoomExplicit", "setEnableHandleRoomExplicit", "repeatAnalyseOptimize", "getRepeatAnalyseOptimize", "setRepeatAnalyseOptimize", "sameRoomOptimize", "getSameRoomOptimize", "setSameRoomOptimize", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveHandleRoomOptimizeConfig {

    @SerializedName("delay_time")
    private long delayTime;

    @SerializedName("enable_cache")
    private boolean enableCache;

    @SerializedName("handle_room_explicit_info")
    private boolean enableHandleRoomExplicit;

    @SerializedName("repeat_analyse_optimize")
    private boolean repeatAnalyseOptimize;

    @SerializedName("same_room_optimize")
    private boolean sameRoomOptimize;

    public LiveHandleRoomOptimizeConfig() {
        this.delayTime = 500;
    }

    public final long getDelayTime() {
        return this.delayTime;
    }

    public final boolean getEnableCache() {
        return this.enableCache;
    }

    public final boolean getEnableHandleRoomExplicit() {
        return this.enableHandleRoomExplicit;
    }

    public final boolean getRepeatAnalyseOptimize() {
        return this.repeatAnalyseOptimize;
    }

    public final boolean getSameRoomOptimize() {
        return this.sameRoomOptimize;
    }

    public final void setDelayTime(long r100) {
        this.delayTime = r100;
    }

    public final void setEnableCache(boolean r100) {
        this.enableCache = r100;
    }

    public final void setEnableHandleRoomExplicit(boolean r100) {
        this.enableHandleRoomExplicit = r100;
    }

    public final void setRepeatAnalyseOptimize(boolean r100) {
        this.repeatAnalyseOptimize = r100;
    }

    public final void setSameRoomOptimize(boolean r100) {
        this.sameRoomOptimize = r100;
    }
}
