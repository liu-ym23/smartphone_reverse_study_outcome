package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveTabRecomModel;", "", "()V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", VideoThumbInfo.KEY_INTERVAL, "getInterval", "setInterval", "nearbyTime", "getNearbyTime", "setNearbyTime", UserInfo.UPDATE_TIME, "getUpdateTime", "setUpdateTime", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTabRecomModel {

    @SerializedName("single_room_accumulate_seconds")
    private int duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("show_ignore_minutes")
    private int interval;

    @SerializedName("nearby_ignore_minutes")
    private int nearbyTime;

    @SerializedName("install_ignore_minutes")
    private int updateTime;

    public LiveTabRecomModel() {
        this.interval = 4320;
        this.duration = 30;
        this.updateTime = 10080;
        this.nearbyTime = 10080;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final int getNearbyTime() {
        return this.nearbyTime;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    public final void setDuration(int r100) {
        this.duration = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setInterval(int r100) {
        this.interval = r100;
    }

    public final void setNearbyTime(int r100) {
        this.nearbyTime = r100;
    }

    public final void setUpdateTime(int r100) {
        this.updateTime = r100;
    }
}
