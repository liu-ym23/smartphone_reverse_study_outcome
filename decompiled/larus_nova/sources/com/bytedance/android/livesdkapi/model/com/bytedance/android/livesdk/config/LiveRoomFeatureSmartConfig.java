package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveRoomFeatureSmartConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "recommendQueue", "getRecommendQueue", "setRecommendQueue", "sendNext", "getSendNext", "setSendNext", "isQueueFeature", "isSendNext", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomFeatureSmartConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("recommend_queue")
    private boolean recommendQueue;

    @SerializedName("send_next")
    private boolean sendNext;

    public LiveRoomFeatureSmartConfig() {
    }

    public final boolean isQueueFeature() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.recommendQueue == false) goto L7;
        return true;
    }

    public final boolean isSendNext() {
        if (isQueueFeature() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.sendNext == false) goto L7;
        return true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getRecommendQueue() {
        return this.recommendQueue;
    }

    public final boolean getSendNext() {
        return this.sendNext;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setRecommendQueue(boolean r100) {
        this.recommendQueue = r100;
    }

    public final void setSendNext(boolean r100) {
        this.sendNext = r100;
    }
}
