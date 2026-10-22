package com.bytedance.android.livesdkapi.depend.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/LiveStartRoomOptConfig;", "", "()V", "delayEnterRoom", "", "getDelayEnterRoom", "()J", "setDelayEnterRoom", "(J)V", "delayFastGift", "getDelayFastGift", "setDelayFastGift", "enablePreRoomEnter", "", "getEnablePreRoomEnter", "()Z", "setEnablePreRoomEnter", "(Z)V", "enableRoomWidgetOpt", "getEnableRoomWidgetOpt", "setEnableRoomWidgetOpt", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveStartRoomOptConfig {

    @SerializedName("delay_enter_room")
    private long delayEnterRoom;

    @SerializedName("delay_fast_gift")
    private long delayFastGift;

    @SerializedName("enable_pre_room_enter")
    private boolean enablePreRoomEnter;

    @SerializedName("enable_room_widget_opt")
    private boolean enableRoomWidgetOpt;

    public LiveStartRoomOptConfig() {
    }

    public final long getDelayEnterRoom() {
        return this.delayEnterRoom;
    }

    public final long getDelayFastGift() {
        return this.delayFastGift;
    }

    public final boolean getEnablePreRoomEnter() {
        return this.enablePreRoomEnter;
    }

    public final boolean getEnableRoomWidgetOpt() {
        return this.enableRoomWidgetOpt;
    }

    public final void setDelayEnterRoom(long r100) {
        this.delayEnterRoom = r100;
    }

    public final void setDelayFastGift(long r100) {
        this.delayFastGift = r100;
    }

    public final void setEnablePreRoomEnter(boolean r100) {
        this.enablePreRoomEnter = r100;
    }

    public final void setEnableRoomWidgetOpt(boolean r100) {
        this.enableRoomWidgetOpt = r100;
    }
}
