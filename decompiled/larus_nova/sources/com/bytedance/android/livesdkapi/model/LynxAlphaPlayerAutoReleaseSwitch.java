package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LynxAlphaPlayerAutoReleaseSwitch;", "", "()V", "aliveDuration", "", "getAliveDuration", "()J", "setAliveDuration", "(J)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LynxAlphaPlayerAutoReleaseSwitch {

    @SerializedName("alive_duration")
    private long aliveDuration;

    @SerializedName("enable")
    private boolean enable;

    public LynxAlphaPlayerAutoReleaseSwitch() {
        this.enable = true;
        this.aliveDuration = 15000;
    }

    public final long getAliveDuration() {
        return this.aliveDuration;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setAliveDuration(long r100) {
        this.aliveDuration = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }
}
